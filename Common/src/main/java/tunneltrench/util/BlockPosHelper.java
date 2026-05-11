package tunneltrench.util;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class BlockPosHelper {

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
        List<BlockPos> list = new ArrayList<>();
        BlockHitResult rayTraceResult = rayTrace(player.level(), player, Fluid.NONE);
        BlockPos center = rayTraceResult.getBlockPos();

        list.add(center);
        switch (rayTraceResult.getDirection()) {
            case DOWN:
            case UP:
                list.add(center.west());
                list.add(center.east());
                list.add(center.north());
                list.add(center.south());
                list.add(center.west().north());
                list.add(center.west().south());
                list.add(center.east().north());
                list.add(center.east().south());
                break;
            case NORTH:
            case SOUTH:
                list.add(center.above());
                list.add(center.below());
                list.add(center.west());
                list.add(center.east());
                list.add(center.west().above());
                list.add(center.west().below());
                list.add(center.east().above());
                list.add(center.east().below());
                break;
            case EAST:
            case WEST:
                list.add(center.above());
                list.add(center.below());
                list.add(center.north());
                list.add(center.south());
                list.add(center.north().above());
                list.add(center.north().below());
                list.add(center.south().above());
                list.add(center.south().below());
        }

        return list;
    }

}
