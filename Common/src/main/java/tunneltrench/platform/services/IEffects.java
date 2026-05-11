package tunneltrench.platform.services;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;

public interface IEffects {

    void setBreakingBlockEffect(ServerLevel level, BlockPos pos, int side);

}
