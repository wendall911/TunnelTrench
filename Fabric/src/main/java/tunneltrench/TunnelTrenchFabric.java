package tunneltrench;

import java.util.function.BiConsumer;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

import tunneltrench.common.item.TunnelTrenchItems;
import tunneltrench.network.BreakBlockPreview;

public class TunnelTrenchFabric implements ModInitializer {

	@Override
    public void onInitialize() {
        registryInit();

        PayloadTypeRegistry.clientboundPlay().register(BreakBlockPreview.TYPE, BreakBlockPreview.STREAM_CODEC);
    }

    private void registryInit() {
        TunnelTrenchItems.registerItems(bind(BuiltInRegistries.ITEM));
    }

    private static <T> BiConsumer<T, Identifier> bind(Registry<? super T> registry) {
        return (t, id) -> Registry.register(registry, id, t);
    }

}
