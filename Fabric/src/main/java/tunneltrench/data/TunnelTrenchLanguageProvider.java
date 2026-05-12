package tunneltrench.data;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import net.minecraft.core.HolderLookup;

import tunneltrench.TunnelTrench;
import tunneltrench.common.item.TunnelTrenchItems;

public class TunnelTrenchLanguageProvider extends FabricLanguageProvider {

    protected TunnelTrenchLanguageProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryFuture) {
        super(dataOutput, "en_us", registryFuture);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder builder) {
        builder.add("itemGroup." + TunnelTrench.MODID, TunnelTrench.MOD_NAME);
        addItem(builder, TunnelTrenchItems.woodenHammerId, "Wooden Mining Hammer");
        addItem(builder, TunnelTrenchItems.stoneHammerId, "Stone Mining Hammer");
        addItem(builder, TunnelTrenchItems.copperHammerId, "Copper Mining Hammer");
        addItem(builder, TunnelTrenchItems.ironHammerId, "Iron Mining Hammer");
        addItem(builder, TunnelTrenchItems.goldHammerId, "Gold Mining Hammer");
        addItem(builder, TunnelTrenchItems.diamondHammerId, "Diamond Mining Hammer");
        addItem(builder, TunnelTrenchItems.netheriteHammerId, "Netherite Mining Hammer");
        addItem(builder, TunnelTrenchItems.woodenExcavatorId, "Wooden Excavator");
        addItem(builder, TunnelTrenchItems.stoneExcavatorId, "Stone Excavator");
        addItem(builder, TunnelTrenchItems.copperExcavatorId, "Copper Excavator");
        addItem(builder, TunnelTrenchItems.ironExcavatorId, "Iron Excavator");
        addItem(builder, TunnelTrenchItems.goldExcavatorId, "Gold Excavator");
        addItem(builder, TunnelTrenchItems.diamondExcavatorId, "Diamond Excavator");
        addItem(builder, TunnelTrenchItems.netheriteExcavatorId, "Netherite Excavator");
    }

    private void addItem(TranslationBuilder builder, String id, String name) {
        builder.add("item." + TunnelTrench.MODID + "." + id, name);
    }

}
