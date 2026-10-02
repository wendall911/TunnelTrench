package tunneltrench.util;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

public class BlockEffectHelper {

    public static void addBreakingBlockEffect(ClientLevel level, BlockPos pos, int side) {
        level.addBreakingBlockEffects(pos, Direction.from3DDataValue(side), true);
    }

}
