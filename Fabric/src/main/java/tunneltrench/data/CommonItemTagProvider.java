package tunneltrench.data;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

import org.jspecify.annotations.NonNull;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;

import tunneltrench.common.item.TunnelTrenchItems;
import tunneltrench.common.TagManager;

public class CommonItemTagProvider extends FabricTagsProvider<Item> {

    public CommonItemTagProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, Registries.ITEM, lookupProvider);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider provider) {
        tag(TagManager.Items.HAMMER_TOOLS)
            .add(BuiltInRegistries.ITEM.getResourceKey(TunnelTrenchItems.woodenHammerItem).orElseThrow())
            .add(BuiltInRegistries.ITEM.getResourceKey(TunnelTrenchItems.stoneHammerItem).orElseThrow())
            .add(BuiltInRegistries.ITEM.getResourceKey(TunnelTrenchItems.copperHammerItem).orElseThrow())
            .add(BuiltInRegistries.ITEM.getResourceKey(TunnelTrenchItems.ironHammerItem).orElseThrow())
            .add(BuiltInRegistries.ITEM.getResourceKey(TunnelTrenchItems.goldHammerItem).orElseThrow())
            .add(BuiltInRegistries.ITEM.getResourceKey(TunnelTrenchItems.diamondHammerItem).orElseThrow())
            .add(BuiltInRegistries.ITEM.getResourceKey(TunnelTrenchItems.netheriteHammerItem).orElseThrow());
        tag(TagManager.Items.EXCAVATOR_TOOLS)
            .add(BuiltInRegistries.ITEM.getResourceKey(TunnelTrenchItems.woodenExcavatorItem).orElseThrow())
            .add(BuiltInRegistries.ITEM.getResourceKey(TunnelTrenchItems.stoneExcavatorItem).orElseThrow())
            .add(BuiltInRegistries.ITEM.getResourceKey(TunnelTrenchItems.copperExcavatorItem).orElseThrow())
            .add(BuiltInRegistries.ITEM.getResourceKey(TunnelTrenchItems.ironExcavatorItem).orElseThrow())
            .add(BuiltInRegistries.ITEM.getResourceKey(TunnelTrenchItems.goldExcavatorItem).orElseThrow())
            .add(BuiltInRegistries.ITEM.getResourceKey(TunnelTrenchItems.diamondExcavatorItem).orElseThrow())
            .add(BuiltInRegistries.ITEM.getResourceKey(TunnelTrenchItems.netheriteExcavatorItem).orElseThrow());
        tag(ItemTags.CLUSTER_MAX_HARVESTABLES)
            .addTag(TagManager.Items.HAMMER_TOOLS);
        tag(ItemTags.PICKAXES)
            .addTag(TagManager.Items.HAMMER_TOOLS);
        tag(ItemTags.SHOVELS)
            .addTag(TagManager.Items.EXCAVATOR_TOOLS);
    }

}
