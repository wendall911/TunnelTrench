package tunneltrench.common.item;

import org.jspecify.annotations.NonNull;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEvent.Context;

import tunneltrench.util.BlockPosHelper;

public class ExcavatorItemBase extends ShovelItem {

    public ExcavatorItemBase(Properties properties, ToolMaterial material) {
        super(material, 1.5F, -3.0F, properties);
    }

    @Override
    public @NonNull InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        Level level = context.getLevel();
        InteractionResult result = super.useOn(context);

        if (result == InteractionResult.SUCCESS
                && player != null
                && !player.isCrouching()
                && player.mayUseItemAt(context.getClickedPos(), context.getClickedFace(), context.getItemInHand())) {
            for (BlockPos pos : BlockPosHelper.getAffectedPos(context.getClickedPos(), context.getClickedFace())) {
                BlockState blockstate = FLATTENABLES.get(level.getBlockState(pos).getBlock());

                if (blockstate != null && level.getBlockState(pos.above()).isAir()) {
                    if (!level.isClientSide()) {
                        BlockState state = Blocks.DIRT_PATH.defaultBlockState();

                        level.setBlock(pos, state, 11);
                        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, Context.of(player, blockstate));
                    }
                }
            }

            if (!level.isClientSide()) {
                context.getItemInHand().hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
            }

            return InteractionResult.SUCCESS;
        }

        return result;
    }

}
