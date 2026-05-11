package tunneltrench.data.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;

import tunneltrench.common.item.TunnelTrenchItems;

public class CommonRecipeProvider extends RecipeProvider {

    RecipeOutput recipeOutput;
    HolderLookup.Provider registries;

    public CommonRecipeProvider(HolderLookup.Provider registries, RecipeOutput recipeOutput) {
        super(registries, recipeOutput);

        this.recipeOutput = recipeOutput;
        this.registries = registries;
    }

    @Override
    public void buildRecipes() {
        HolderLookup.RegistryLookup<Item> itemRegistry = registries.lookupOrThrow(Registries.ITEM);

        RecipeProviderBase.woodenHammer(itemRegistry).save(recipeOutput);
        RecipeProviderBase.stoneHammer(itemRegistry).save(recipeOutput);
        RecipeProviderBase.copperHammer(itemRegistry).save(recipeOutput);
        RecipeProviderBase.ironHammer(itemRegistry).save(recipeOutput);
        RecipeProviderBase.goldHammer(itemRegistry).save(recipeOutput);
        RecipeProviderBase.diamondHammer(itemRegistry).save(recipeOutput);
        RecipeProviderBase.netheriteHammer(itemRegistry).save(recipeOutput, TunnelTrenchItems.netheriteHammerId + "_smithing");
        RecipeProviderBase.woodenExcavator(itemRegistry).save(recipeOutput);
        RecipeProviderBase.stoneExcavator(itemRegistry).save(recipeOutput);
        RecipeProviderBase.copperExcavator(itemRegistry).save(recipeOutput);
        RecipeProviderBase.ironExcavator(itemRegistry).save(recipeOutput);
        RecipeProviderBase.goldExcavator(itemRegistry).save(recipeOutput);
        RecipeProviderBase.diamondExcavator(itemRegistry).save(recipeOutput);
        RecipeProviderBase.netheriteExcavator(itemRegistry).save(recipeOutput, TunnelTrenchItems.netheriteExcavatorId + "_smithing");
    }

}
