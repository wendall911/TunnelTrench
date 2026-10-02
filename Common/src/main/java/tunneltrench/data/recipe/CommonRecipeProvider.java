package tunneltrench.data.recipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Recipe;

import tunneltrench.common.item.TunnelTrenchItems;

public class CommonRecipeProvider extends RecipeProvider {

    Provider registries;

    public CommonRecipeProvider(Provider registries, BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput) {
        super(recipeOutput, advancementOutput);

        this.registries = registries;
    }

    @Override
    public void buildRecipes() {
        HolderLookup.RegistryLookup<Item> itemRegistry = registries.lookupOrThrow(Registries.ITEM);

        RecipeProviderBase.woodenHammer(itemRegistry).save(this.output);
        RecipeProviderBase.stoneHammer(itemRegistry).save(this.output);
        RecipeProviderBase.copperHammer(itemRegistry).save(this.output);
        RecipeProviderBase.ironHammer(itemRegistry).save(this.output);
        RecipeProviderBase.goldHammer(itemRegistry).save(this.output);
        RecipeProviderBase.diamondHammer(itemRegistry).save(this.output);
        RecipeProviderBase.netheriteHammer(itemRegistry).save(this.output, TunnelTrenchItems.netheriteHammerId + "_smithing");
        RecipeProviderBase.woodenExcavator(itemRegistry).save(this.output);
        RecipeProviderBase.stoneExcavator(itemRegistry).save(this.output);
        RecipeProviderBase.copperExcavator(itemRegistry).save(this.output);
        RecipeProviderBase.ironExcavator(itemRegistry).save(this.output);
        RecipeProviderBase.goldExcavator(itemRegistry).save(this.output);
        RecipeProviderBase.diamondExcavator(itemRegistry).save(this.output);
        RecipeProviderBase.netheriteExcavator(itemRegistry).save(this.output, TunnelTrenchItems.netheriteExcavatorId + "_smithing");
    }

}
