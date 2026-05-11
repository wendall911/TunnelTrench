package tunneltrench;

import java.util.Map;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import tunneltrench.common.item.TunnelTrenchItems;
import tunneltrench.network.BreakBlockPreview;
import tunneltrench.util.BlockEffectHelper;

public class TunnelTrenchClientFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        for (Map.Entry<Identifier, Item> entry : TunnelTrenchItems.getAll().entrySet()) {
            CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register(entries -> entries.accept(entry.getValue()));
        }
        ClientPlayNetworking.registerGlobalReceiver(BreakBlockPreview.TYPE,
            ((payload, context) -> {
                Minecraft mc = Minecraft.getInstance();
                ClientLevel level = mc.level;

                if (level != null) {
                    mc.execute(() -> BlockEffectHelper.addBreakingBlockEffect(level, payload.blockPos(), payload.side()));
                }
            })
        );
    }

}
