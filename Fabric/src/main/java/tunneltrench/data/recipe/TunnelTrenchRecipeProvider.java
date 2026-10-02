package tunneltrench.data.recipe;

import java.util.concurrent.CompletableFuture;

import org.jspecify.annotations.NonNull;

import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.recipes.RecipeProvider;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.crafting.Recipe;

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
    protected @NonNull RecipeProvider createRecipeProvider(@NonNull Provider registries,
            @NonNull BootstrapContext<Recipe<?>> recipes, @NonNull BootstrapContext<Advancement> advancements) {
        return new CommonRecipeProvider(registries, recipes, advancements);
    }

}
