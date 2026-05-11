package tunneltrench.common;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import static tunneltrench.TunnelTrench.prefix;

public class TagManager {

    public static class Items {

        public static final TagKey<Item> HAMMER_TOOLS = create("hammer_tools");
        public static final TagKey<Item> EXCAVATOR_TOOLS = create("excavator_tools");

        private static TagKey<Item> create(String id) {
            return TagKey.create(Registries.ITEM, prefix(id));
        }
    }

}
