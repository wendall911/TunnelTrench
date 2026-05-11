package tunneltrench.common.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import tunneltrench.common.item.ExcavatorItemBase;
import tunneltrench.common.item.HammerItemBase;
import tunneltrench.platform.Services;
import tunneltrench.util.BlockPosHelper;

public class ServerEventHandler {

    public static void blockBreak(LevelAccessor levelAccessor, Player player, BlockState blockState, BlockPos blockPos) {
        if (blockState.canOcclude() && !player.isCrouching()) {
            ItemStack itemStack = player.getMainHandItem();
            Item item = itemStack.getItem();

            if (item instanceof HammerItemBase || item instanceof ExcavatorItemBase) {
                double hardness = blockState.getDestroySpeed(levelAccessor, blockPos);

                for (BlockPos pos : BlockPosHelper.getAffectedPos(player)) {
                    BlockState otherBlockState = levelAccessor.getBlockState(pos);

                    if (hardness * 2 >= blockState.getDestroySpeed(levelAccessor, pos) && itemStack.isCorrectToolForDrops(otherBlockState)) {
                        Level level = player.level();

                        otherBlockState.getBlock().playerDestroy(level, player, pos, otherBlockState, levelAccessor.getBlockEntity(pos), itemStack);
                        level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());

                        levelAccessor.playSound(player, blockPos, otherBlockState.getSoundType().getBreakSound(), SoundSource.BLOCKS, 1.0F, 1.0F);
                    }
                }
            }
        }
    }

    public static void breakSpeed(Player player, BlockPos blockPos) {
        ItemStack itemStack = player.getMainHandItem();
        Item item = itemStack.getItem();
        Level level = player.level();

        if (!level.isClientSide()
                && !player.isCrouching()
                && blockPos != null
                && (item instanceof HammerItemBase || item instanceof ExcavatorItemBase)) {
            BlockHitResult rayTraceResult = BlockPosHelper.rayTrace(level, player, ClipContext.Fluid.NONE);
            Direction facing = rayTraceResult.getDirection();

            for (BlockPos pos : BlockPosHelper.getAffectedPos(blockPos, facing)) {
                BlockState otherBlockState = level.getBlockState(pos);

                if (itemStack.isCorrectToolForDrops(otherBlockState)) {
                    Services.EFFECTS.setBreakingBlockEffect((ServerLevel) level, pos, facing.get3DDataValue());
                }
            }
        }
    }

}
