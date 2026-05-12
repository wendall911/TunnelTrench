package tunneltrench.network;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;

import net.neoforged.neoforge.network.handling.IPayloadContext;

import tunneltrench.util.BlockEffectHelper;

public class TunnelTrenchNeoForgeNetwork {

    public static final TunnelTrenchNeoForgeNetwork INSTANCE = new TunnelTrenchNeoForgeNetwork();

    public static TunnelTrenchNeoForgeNetwork getInstance() {
        return INSTANCE;
    }

    public void handleBreakBlockPreviewPacket(BreakBlockPreview msg, IPayloadContext context) {
        context.enqueueWork(() -> {
            ClientLevel level = Minecraft.getInstance().level;

            if (level != null) {
                BlockEffectHelper.addBreakingBlockEffect(level, msg.blockPos(), msg.side());
            }
        });
    }

}
