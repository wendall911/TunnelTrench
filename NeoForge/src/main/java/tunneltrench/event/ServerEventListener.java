package tunneltrench.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.level.block.BreakBlockEvent;

import tunneltrench.common.event.ServerEventHandler;

public class ServerEventListener {

    @SubscribeEvent
    public static void blockBreak(BreakBlockEvent event) {
        ServerEventHandler.blockBreak(event.getLevel(), event.getPlayer(), event.getState(), event.getPos());
    }

    @SubscribeEvent
    public static void breakSpeed(PlayerEvent.BreakSpeed event) {
        ServerEventHandler.breakSpeed(event.getEntity(), event.getPosition().orElse(null));
    }

}
