package tunneltrench.platform;

import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

import tunneltrench.network.BreakBlockPreview;
import tunneltrench.platform.services.IEffects;

public class FabricPlatform implements IEffects {

    @Override
    public void setBreakingBlockEffect(ServerLevel level, BlockPos pos, int side) {
        for (ServerPlayer sp : PlayerLookup.tracking(level, pos)) {
            ServerPlayNetworking.send(sp, new BreakBlockPreview(pos, side));
        }
    }

}
