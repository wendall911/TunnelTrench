package tunneltrench.common.item;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

import static tunneltrench.TunnelTrench.prefix;

public final class TunnelTrenchItems {

    private static final Map<Identifier, Item> ALL = new LinkedHashMap<>();

    public static final String woodenHammerId = "wooden_hammer";
    public static final String stoneHammerId = "stone_hammer";
    public static final String copperHammerId = "copper_hammer";
    public static final String ironHammerId = "iron_hammer";
    public static final String goldHammerId = "golden_hammer";
    public static final String diamondHammerId = "diamond_hammer";
    public static final String netheriteHammerId = "netherite_hammer";
    public static final String woodenExcavatorId = "wooden_excavator";
    public static final String stoneExcavatorId = "stone_excavator";
    public static final String copperExcavatorId = "copper_excavator";
    public static final String ironExcavatorId = "iron_excavator";
    public static final String goldExcavatorId = "golden_excavator";
    public static final String diamondExcavatorId = "diamond_excavator";
    public static final String netheriteExcavatorId = "netherite_excavator";
    public static final Item woodenHammerItem = make(
        woodenHammerId,
        new HammerItemBase(getProps(woodenHammerId), ToolMaterial.WOOD)
    );
    public static final Item stoneHammerItem = make(
        stoneHammerId,
        new HammerItemBase(getProps(stoneHammerId), ToolMaterial.STONE)
    );
    public static final Item copperHammerItem = make(
        copperHammerId,
        new HammerItemBase(getProps(copperHammerId), ToolMaterial.COPPER)
    );
    public static final Item ironHammerItem = make(
        ironHammerId,
        new HammerItemBase(getProps(ironHammerId), ToolMaterial.IRON)
    );
    public static final Item goldHammerItem = make(
        goldHammerId,
        new HammerItemBase(getProps(goldHammerId), ToolMaterial.GOLD)
    );
    public static final Item diamondHammerItem = make(
        diamondHammerId,
        new HammerItemBase(getProps(diamondHammerId), ToolMaterial.DIAMOND)
    );
    public static final Item netheriteHammerItem = make(
        netheriteHammerId,
        new HammerItemBase(getProps(netheriteHammerId), ToolMaterial.NETHERITE)
    );
    public static final Item woodenExcavatorItem = make(
        woodenExcavatorId,
        new ExcavatorItemBase(getProps(woodenExcavatorId), ToolMaterial.WOOD)
    );
    public static final Item stoneExcavatorItem = make(
        stoneExcavatorId,
        new ExcavatorItemBase(getProps(stoneExcavatorId), ToolMaterial.STONE)
    );
    public static final Item  copperExcavatorItem = make(
        copperExcavatorId,
        new ExcavatorItemBase(getProps(copperExcavatorId), ToolMaterial.COPPER)
    );
    public static final Item ironExcavatorItem = make(
        ironExcavatorId,
        new ExcavatorItemBase(getProps(ironExcavatorId), ToolMaterial.IRON)
    );
    public static final Item goldExcavatorItem = make(
        goldExcavatorId,
        new ExcavatorItemBase(getProps(goldExcavatorId), ToolMaterial.GOLD)
    );
    public static final Item diamondExcavatorItem = make(
        diamondExcavatorId,
        new ExcavatorItemBase(getProps(diamondExcavatorId), ToolMaterial.DIAMOND)
    );
    public static final Item netheriteExcavatorItem = make(
        netheriteExcavatorId,
        new ExcavatorItemBase(getProps(netheriteExcavatorId), ToolMaterial.NETHERITE)
    );

    private static <T extends Item> T make(String id, T item) {
        Identifier loc = prefix(id);

        if (ALL.put(loc, item) != null) {
            throw new IllegalArgumentException("Duplicate Item: " + loc);
        }

        return item;
    }

    public static Item.Properties getProps(String id) {
        return new Item.Properties().setId(ResourceKey.create(Registries.ITEM, prefix(id)));
    }

    public static void registerItems(BiConsumer<Item, Identifier> consumer) {
        for (Map.Entry<Identifier, Item> entry : ALL.entrySet()) {
            consumer.accept(entry.getValue(), entry.getKey());
        }
    }

    public static Map<Identifier, Item> getAll() {
        return ALL;
    }

}
