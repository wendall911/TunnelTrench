package tunneltrench.data;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

import org.jspecify.annotations.NonNull;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;

import tunneltrench.common.item.TunnelTrenchItems;
import tunneltrench.common.TagManager;

public class CommonItemTagProvider extends IntrinsicHolderTagsProvider<Item> {

    public CommonItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, Registries.ITEM, lookupProvider, (item) -> item.builtInRegistryHolder().key());
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider provider) {
        tag(TagManager.Items.HAMMER_TOOLS)
            .add(TunnelTrenchItems.woodenHammerItem)
            .add(TunnelTrenchItems.stoneHammerItem)
            .add(TunnelTrenchItems.copperHammerItem)
            .add(TunnelTrenchItems.ironHammerItem)
            .add(TunnelTrenchItems.goldHammerItem)
            .add(TunnelTrenchItems.diamondHammerItem)
            .add(TunnelTrenchItems.netheriteHammerItem);
        tag(TagManager.Items.EXCAVATOR_TOOLS)
            .add(TunnelTrenchItems.woodenExcavatorItem)
            .add(TunnelTrenchItems.stoneExcavatorItem)
            .add(TunnelTrenchItems.copperExcavatorItem)
            .add(TunnelTrenchItems.ironExcavatorItem)
            .add(TunnelTrenchItems.goldExcavatorItem)
            .add(TunnelTrenchItems.diamondExcavatorItem)
            .add(TunnelTrenchItems.netheriteExcavatorItem);
        tag(ItemTags.CLUSTER_MAX_HARVESTABLES)
            .addTag(TagManager.Items.HAMMER_TOOLS);
        tag(ItemTags.PICKAXES)
            .addTag(TagManager.Items.HAMMER_TOOLS);
        tag(ItemTags.SHOVELS)
            .addTag(TagManager.Items.EXCAVATOR_TOOLS);
    }

}
