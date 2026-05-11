package tunneltrench.util;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class BlockPosHelper {

    private static final BlockPos[][] OFFSETS_BY_AXIS = new BlockPos[][]{
        // X axis (EAST/WEST): affect Y/Z plane.
        {
            new BlockPos(0, 0, 0),
            new BlockPos(0, 1, 0),
            new BlockPos(0, -1, 0),
            new BlockPos(0, 0, 1),
            new BlockPos(0, 0, -1),
            new BlockPos(0, 1, 1),
            new BlockPos(0, 1, -1),
            new BlockPos(0, -1, 1),
            new BlockPos(0, -1, -1)
        },
        // Y axis (UP/DOWN): affect X/Z plane.
        {
            new BlockPos(0, 0, 0),
            new BlockPos(1, 0, 0),
            new BlockPos(-1, 0, 0),
            new BlockPos(0, 0, 1),
            new BlockPos(0, 0, -1),
            new BlockPos(1, 0, 1),
            new BlockPos(1, 0, -1),
            new BlockPos(-1, 0, 1),
            new BlockPos(-1, 0, -1)
        },
        // Z axis (NORTH/SOUTH): affect X/Y plane.
        {
            new BlockPos(0, 0, 0),
            new BlockPos(1, 0, 0),
            new BlockPos(-1, 0, 0),
            new BlockPos(0, 1, 0),
            new BlockPos(0, -1, 0),
            new BlockPos(1, 1, 0),
            new BlockPos(1, -1, 0),
            new BlockPos(-1, 1, 0),
            new BlockPos(-1, -1, 0)
        }
    };

    public static BlockHitResult rayTrace(Level level, Player player, ClipContext.Fluid mode) {
        float pitch = player.getXRot();
        float yaw = player.getYRot();
        Vec3 vec3 = player.getEyePosition(1.0F);
        float cosYaw = Mth.cos(-yaw * ((float)Math.PI / 180F) - (float)Math.PI);
        float sinYaw = Mth.sin(-yaw * ((float)Math.PI / 180F) - (float)Math.PI);
        float cosPitch = -Mth.cos(-pitch * ((float)Math.PI / 180F));
        float sinPitch = Mth.sin(-pitch * ((float)Math.PI / 180F));
        float product = sinYaw * cosPitch;
        float product2 = cosYaw * cosPitch;
        double reachDistance = Math.max(player.blockInteractionRange(), player.entityInteractionRange());
        Vec3 vec32 = vec3.add((double)product * reachDistance, (double)sinPitch * reachDistance, (double)product2 * reachDistance);

        return level.clip(new ClipContext(vec3, vec32, Block.OUTLINE, mode, player));
    }

    public static List<BlockPos> getAffectedPos(@NotNull Player player) {
        BlockHitResult rayTraceResult = rayTrace(player.level(), player, Fluid.NONE);
        return getAffectedPos(rayTraceResult.getBlockPos(), rayTraceResult.getDirection());
    }

    public static List<BlockPos> getAffectedPos(@NotNull BlockPos center, @NotNull Direction direction) {
        BlockPos[] offsets = OFFSETS_BY_AXIS[direction.getAxis().ordinal()];
        List<BlockPos> list = new ArrayList<>(offsets.length);

        for (BlockPos offset : offsets) {
            list.add(center.offset(offset));
        }

        return list;
    }

}
