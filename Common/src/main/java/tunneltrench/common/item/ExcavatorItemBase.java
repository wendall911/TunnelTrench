package tunneltrench.common.item;

import org.jspecify.annotations.NonNull;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.component.BlockTransformer;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEvent.Context;
import net.minecraft.world.phys.BlockHitResult;

import tunneltrench.util.BlockPosHelper;

public class ExcavatorItemBase extends Item {

    public ExcavatorItemBase(Properties properties, ToolMaterial material) {
        super(properties.shovel(material, 1.5F, -3.0F));
    }

    @Override
    public @NonNull InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        Level level = context.getLevel();
        InteractionResult result = super.useOn(context);
        ItemStack stack = context.getItemInHand();
        Holder<BlockTransformer> blockTransformer = stack.get(DataComponents.BLOCK_TRANSFORMER);

        if (result == InteractionResult.SUCCESS
                && player != null
                && !player.isCrouching()
                && blockTransformer != null
                && player.mayUseItemAt(context.getClickedPos(), context.getClickedFace(), stack)) {
            for (BlockPos pos : BlockPosHelper.getAffectedPos(context.getClickedPos(), context.getClickedFace())) {
                UseOnContext newContext = new UseOnContext(
                    player,
                    context.getHand(),
                    new BlockHitResult(
                        context.getClickLocation(),
                        context.getClickedFace(),
                        pos,
                        context.isInside()
                    )
                );
                blockTransformer.value().transformBlock(newContext);
            }

            if (!level.isClientSide()) {
                context.getItemInHand().hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
            }

            return InteractionResult.SUCCESS;
        }

        return result;
    }

}
