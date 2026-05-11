package tunneltrench.platform;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;

import net.neoforged.neoforge.network.PacketDistributor;

import tunneltrench.network.BreakBlockPreview;
import tunneltrench.platform.services.IEffects;

public class NeoForgePlatform implements IEffects {

    @Override
    public void setBreakingBlockEffect(ServerLevel level, BlockPos pos, int side) {
        PacketDistributor.sendToPlayersNear(level, null, pos.getX(), pos.getY(), pos.getZ(), 12, new BreakBlockPreview(pos, side));
    }

}
