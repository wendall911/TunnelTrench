package tunneltrench.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import tunneltrench.data.client.TunnelTrenchModelProvider;
import tunneltrench.data.recipe.TunnelTrenchRecipeProvider;
import tunneltrench.TunnelTrench;

public class FabricDatagenInitializer implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator gen) {
        FabricDataGenerator.Pack pack = gen.createPack();

        if (System.getProperty(TunnelTrench.MODID + ".common_datagen") != null) {
            configureCommonDatagen(pack);
        }
        else {
            configureFabricDatagen(pack);
        }
    }

    /*
     * Datagen common across all modloaders.
     */
    public static void configureCommonDatagen(FabricDataGenerator.Pack pack) {
        pack.addProvider(CommonItemTagProvider::new);
        pack.addProvider(TunnelTrenchLanguageProvider::new);
        pack.addProvider(TunnelTrenchRecipeProvider::new);
        pack.addProvider(TunnelTrenchModelProvider::new);
    }

    /*
     * Fabric only datagen.
     */
    public static void configureFabricDatagen(FabricDataGenerator.Pack pack) {
    }

}
