package tunneltrench.common.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class HammerItemBase extends Item {

    public HammerItemBase(Properties properties, ToolMaterial toolMaterial) {
        super(properties.pickaxe(toolMaterial, 1.0F, -2.8F));
    }

}
