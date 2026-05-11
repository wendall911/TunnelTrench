package tunneltrench.data.recipe;

import java.util.concurrent.CompletableFuture;

import org.jspecify.annotations.NonNull;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

import tunneltrench.TunnelTrench;

public class TunnelTrenchRecipeProvider extends FabricRecipeProvider {

    public TunnelTrenchRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryFuture) {
        super(output, registryFuture);
    }

    @Override
    public @NonNull String getName() {
        return TunnelTrench.MOD_NAME + " - Recipes";
    }

    @Override
    protected @NonNull RecipeProvider createRecipeProvider(HolderLookup.@NonNull Provider registries, @NonNull RecipeOutput recipeOutput) {
        return new CommonRecipeProvider(registries, recipeOutput);
    }

}
