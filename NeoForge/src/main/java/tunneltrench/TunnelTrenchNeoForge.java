package tunneltrench;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.registries.RegisterEvent;

import tunneltrench.common.item.TunnelTrenchItems;
import tunneltrench.event.ServerEventListener;
import tunneltrench.network.TunnelTrenchNeoForgeNetwork;
import tunneltrench.network.BreakBlockPreview;

@Mod(TunnelTrench.MODID)
@EventBusSubscriber(modid = TunnelTrench.MODID)
public class TunnelTrenchNeoForge {

    public TunnelTrenchNeoForge(IEventBus eventBus) {
        registryInit(eventBus);
        eventBus.addListener(this::setup);
        eventBus.addListener(this::buildCreativeTabContents);
        eventBus.addListener(this::registerPayloadHandler);
    }

    private void buildCreativeTabContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            for (Map.Entry<Identifier, Item> entry : TunnelTrenchItems.getAll().entrySet()) {
                Item item = entry.getValue();

                if (item != null) {
                    event.accept(new ItemStack(item));
                }
            }
        }
    }

    private void setup(final FMLCommonSetupEvent event) {
        NeoForge.EVENT_BUS.register(ServerEventListener.class);
    }

    private static void registryInit(IEventBus eventBus) {
        bind(eventBus, Registries.ITEM, TunnelTrenchItems::registerItems);
    }

    private static <T> void bind(IEventBus eventBus, ResourceKey<Registry<T>> registry, Consumer<BiConsumer<T, Identifier>> source) {
        eventBus.addListener((RegisterEvent event) -> {
            if (registry.equals(event.getRegistryKey())) {
                source.accept((t, rl) -> event.register(registry, rl, () -> t));
            }
        });
    }

    private void registerPayloadHandler(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar(TunnelTrench.MODID).versioned("1.0");

        registrar.playToClient(
            BreakBlockPreview.TYPE,
            BreakBlockPreview.STREAM_CODEC,
            TunnelTrenchNeoForgeNetwork.getInstance()::handleBreakBlockPreviewPacket
        );
    }

}
