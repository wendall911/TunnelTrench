package tunneltrench.mixin;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerPlayerGameMode;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import tunneltrench.common.event.ServerEventHandler;

@Mixin(Player.class)
public class FabricPlayerMixin {

    @Inject(method = "getDestroySpeed", at = @At("HEAD"))
    private void tunneltrench$getDestroySpeed(BlockState state, CallbackInfoReturnable<Float> cir) {
        Player player = (Player)(Object)this;

        if (player instanceof ServerPlayer serverPlayer) {
            ServerPlayerGameMode gameMode = serverPlayer.gameMode;

            ServerEventHandler.breakSpeed(player, ((ServerPlayerGameModeAccessor) gameMode).tunneltrench$getDestroyPos());
        }
    }

}
