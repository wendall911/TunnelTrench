package tunneltrench.data.client;

import org.jspecify.annotations.NonNull;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

import tunneltrench.common.item.TunnelTrenchItems;

public class TunnelTrenchModelProvider extends FabricModelProvider {

    public TunnelTrenchModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(@NonNull BlockModelGenerators blockModelGenerators) {}

    @Override
    public void generateItemModels(@NonNull ItemModelGenerators generator) {
        generator.generateFlatItem(TunnelTrenchItems.woodenHammerItem, ModelTemplates.FLAT_HANDHELD_ITEM);
        generator.generateFlatItem(TunnelTrenchItems.stoneHammerItem, ModelTemplates.FLAT_HANDHELD_ITEM);
        generator.generateFlatItem(TunnelTrenchItems.copperHammerItem, ModelTemplates.FLAT_HANDHELD_ITEM);
        generator.generateFlatItem(TunnelTrenchItems.ironHammerItem, ModelTemplates.FLAT_HANDHELD_ITEM);
        generator.generateFlatItem(TunnelTrenchItems.goldHammerItem, ModelTemplates.FLAT_HANDHELD_ITEM);
        generator.generateFlatItem(TunnelTrenchItems.diamondHammerItem, ModelTemplates.FLAT_HANDHELD_ITEM);
        generator.generateFlatItem(TunnelTrenchItems.netheriteHammerItem, ModelTemplates.FLAT_HANDHELD_ITEM);
        generator.generateFlatItem(TunnelTrenchItems.woodenExcavatorItem, ModelTemplates.FLAT_HANDHELD_ITEM);
        generator.generateFlatItem(TunnelTrenchItems.stoneExcavatorItem, ModelTemplates.FLAT_HANDHELD_ITEM);
        generator.generateFlatItem(TunnelTrenchItems.copperExcavatorItem, ModelTemplates.FLAT_HANDHELD_ITEM);
        generator.generateFlatItem(TunnelTrenchItems.ironExcavatorItem, ModelTemplates.FLAT_HANDHELD_ITEM);
        generator.generateFlatItem(TunnelTrenchItems.goldExcavatorItem, ModelTemplates.FLAT_HANDHELD_ITEM);
        generator.generateFlatItem(TunnelTrenchItems.diamondExcavatorItem, ModelTemplates.FLAT_HANDHELD_ITEM);
        generator.generateFlatItem(TunnelTrenchItems.netheriteExcavatorItem, ModelTemplates.FLAT_HANDHELD_ITEM);
    }

}
