package tunneltrench.data.recipe;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

import net.minecraft.advancements.predicates.ItemPredicate;
import net.minecraft.advancements.triggers.CriteriaTriggers;
import net.minecraft.advancements.triggers.Criterion;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.advancements.triggers.InventoryChangeTrigger.TriggerInstance;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.data.recipes.SpecialRecipeBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

import tunneltrench.common.item.TunnelTrenchItems;

import static tunneltrench.TunnelTrench.prefix;

public class RecipeProviderBase {

    private static Criterion<InventoryChangeTrigger.TriggerInstance> has(HolderLookup.RegistryLookup<Item> itemRegistry, TagKey<Item> pTag) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(itemRegistry, pTag).build());
    }

    private static Criterion<TriggerInstance> has(HolderLookup.RegistryLookup<Item> itemRegistry, ItemLike pItemLike) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(itemRegistry, pItemLike).build());
    }

    private static Criterion<InventoryChangeTrigger.TriggerInstance> inventoryTrigger(ItemPredicate... predicates) {
        return CriteriaTriggers.INVENTORY_CHANGED.createCriterion(
            new InventoryChangeTrigger.TriggerInstance(
                Optional.empty(),
                InventoryChangeTrigger.TriggerInstance.Slots.ANY,
                List.of(predicates)
            )
        );
    }

    public static void specialRecipe(RecipeOutput exporter, RecipeSerializer<? extends CustomRecipe> serializer, Supplier<Recipe<?>> factory) {
        Identifier name = BuiltInRegistries.RECIPE_SERIALIZER.getKey(serializer);

        SpecialRecipeBuilder.special(factory).save(
            exporter, prefix("dynamic/" + Objects.requireNonNull(name).getPath()).toString());
    }

    public static Ingredient tagIngredient(HolderLookup.RegistryLookup<Item> itemRegistry, TagKey<Item> tag) {
        return Ingredient.of(itemRegistry.getOrThrow(tag));
    }

    protected static ShapedRecipeBuilder woodenHammer(HolderLookup.RegistryLookup<Item> itemRegistry) {
        return ShapedRecipeBuilder.shaped(itemRegistry, RecipeCategory.TOOLS, TunnelTrenchItems.woodenHammerItem)
            .define('I', ItemTags.LOGS)
            .pattern("III")
            .pattern(" I ")
            .pattern(" I ")
            .unlockedBy("has_item", has(itemRegistry, ItemTags.LOGS));
    }

    protected static ShapedRecipeBuilder stoneHammer(HolderLookup.RegistryLookup<Item> itemRegistry) {
        return ShapedRecipeBuilder.shaped(itemRegistry, RecipeCategory.TOOLS, TunnelTrenchItems.stoneHammerItem)
            .define('B', Items.STONE)
            .define('I', ItemTags.LOGS)
            .pattern("BBB")
            .pattern(" I ")
            .pattern(" I ")
            .unlockedBy("has_item", has(itemRegistry, Items.COBBLESTONE));
    }

    protected static ShapedRecipeBuilder copperHammer(HolderLookup.RegistryLookup<Item> itemRegistry) {
        return ShapedRecipeBuilder.shaped(itemRegistry, RecipeCategory.TOOLS, TunnelTrenchItems.copperHammerItem)
            .define('B', Items.COPPER_BLOCK.weathering().unaffected())
            .define('I', ItemTags.LOGS)
            .pattern("BBB")
            .pattern(" I ")
            .pattern(" I ")
            .unlockedBy("has_item", has(itemRegistry, Items.COPPER_INGOT));
    }

    protected static ShapedRecipeBuilder ironHammer(HolderLookup.RegistryLookup<Item> itemRegistry) {
        return ShapedRecipeBuilder.shaped(itemRegistry, RecipeCategory.TOOLS, TunnelTrenchItems.ironHammerItem)
            .define('B', Items.IRON_BLOCK)
            .define('I', ItemTags.LOGS)
            .pattern("BBB")
            .pattern(" I ")
            .pattern(" I ")
            .unlockedBy("has_item", has(itemRegistry, Items.IRON_INGOT));
    }

    protected static ShapedRecipeBuilder goldHammer(HolderLookup.RegistryLookup<Item> itemRegistry) {
        return ShapedRecipeBuilder.shaped(itemRegistry, RecipeCategory.TOOLS, TunnelTrenchItems.goldHammerItem)
            .define('B', Items.GOLD_BLOCK)
            .define('I', ItemTags.LOGS)
            .pattern("BBB")
            .pattern(" I ")
            .pattern(" I ")
            .unlockedBy("has_item", has(itemRegistry, Items.GOLD_INGOT));
    }

    protected static ShapedRecipeBuilder diamondHammer(HolderLookup.RegistryLookup<Item> itemRegistry) {
        return ShapedRecipeBuilder.shaped(itemRegistry, RecipeCategory.TOOLS, TunnelTrenchItems.diamondHammerItem)
            .define('B', Items.DIAMOND_BLOCK)
            .define('I', ItemTags.LOGS)
            .pattern("BBB")
            .pattern(" I ")
            .pattern(" I ")
            .unlockedBy("has_item", has(itemRegistry, Items.DIAMOND));
    }

    protected static SmithingTransformRecipeBuilder netheriteHammer(HolderLookup.RegistryLookup<Item> itemRegistry) {
        return SmithingTransformRecipeBuilder.smithing(
            Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
            Ingredient.of(TunnelTrenchItems.diamondHammerItem),
            tagIngredient(itemRegistry, ItemTags.NETHERITE_TOOL_MATERIALS),
            RecipeCategory.TOOLS,
            TunnelTrenchItems.netheriteHammerItem
        )
        .unlocks("has_netherite_ingot", has(itemRegistry, Items.NETHERITE_INGOT));
    }

    protected static ShapedRecipeBuilder woodenExcavator(HolderLookup.RegistryLookup<Item> itemRegistry) {
        return ShapedRecipeBuilder.shaped(itemRegistry, RecipeCategory.TOOLS, TunnelTrenchItems.woodenExcavatorItem)
            .define('I', ItemTags.LOGS)
            .pattern(" I ")
            .pattern(" I ")
            .pattern(" I ")
            .unlockedBy("has_item", has(itemRegistry, ItemTags.LOGS));
    }

    protected static ShapedRecipeBuilder stoneExcavator(HolderLookup.RegistryLookup<Item> itemRegistry) {
        return ShapedRecipeBuilder.shaped(itemRegistry, RecipeCategory.TOOLS, TunnelTrenchItems.stoneExcavatorItem)
            .define('B', Items.STONE)
            .define('I', ItemTags.LOGS)
            .pattern(" B ")
            .pattern(" I ")
            .pattern(" I ")
            .unlockedBy("has_item", has(itemRegistry, Items.COBBLESTONE));
    }

    protected static ShapedRecipeBuilder copperExcavator(HolderLookup.RegistryLookup<Item> itemRegistry) {
        return ShapedRecipeBuilder.shaped(itemRegistry, RecipeCategory.TOOLS, TunnelTrenchItems.copperExcavatorItem)
            .define('B', Items.COPPER_BLOCK.weathering().unaffected())
            .define('I', ItemTags.LOGS)
            .pattern(" B ")
            .pattern(" I ")
            .pattern(" I ")
            .unlockedBy("has_item", has(itemRegistry, Items.COPPER_INGOT));
    }

    protected static ShapedRecipeBuilder ironExcavator(HolderLookup.RegistryLookup<Item> itemRegistry) {
        return ShapedRecipeBuilder.shaped(itemRegistry, RecipeCategory.TOOLS, TunnelTrenchItems.ironExcavatorItem)
            .define('B', Items.IRON_BLOCK)
            .define('I', ItemTags.LOGS)
            .pattern(" B ")
            .pattern(" I ")
            .pattern(" I ")
            .unlockedBy("has_item", has(itemRegistry, Items.IRON_INGOT));
    }

    protected static ShapedRecipeBuilder goldExcavator(HolderLookup.RegistryLookup<Item> itemRegistry) {
        return ShapedRecipeBuilder.shaped(itemRegistry, RecipeCategory.TOOLS, TunnelTrenchItems.goldExcavatorItem)
            .define('B', Items.GOLD_BLOCK)
            .define('I', ItemTags.LOGS)
            .pattern(" B ")
            .pattern(" I ")
            .pattern(" I ")
            .unlockedBy("has_item", has(itemRegistry, Items.GOLD_INGOT));
    }

    protected static ShapedRecipeBuilder diamondExcavator(HolderLookup.RegistryLookup<Item> itemRegistry) {
        return ShapedRecipeBuilder.shaped(itemRegistry, RecipeCategory.TOOLS, TunnelTrenchItems.diamondExcavatorItem)
            .define('B', Items.DIAMOND_BLOCK)
            .define('I', ItemTags.LOGS)
            .pattern(" B ")
            .pattern(" I ")
            .pattern(" I ")
            .unlockedBy("has_item", has(itemRegistry, Items.DIAMOND));
    }

    protected static SmithingTransformRecipeBuilder netheriteExcavator(HolderLookup.RegistryLookup<Item> itemRegistry) {
        return SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.of(TunnelTrenchItems.diamondExcavatorItem),
                tagIngredient(itemRegistry, ItemTags.NETHERITE_TOOL_MATERIALS),
                RecipeCategory.TOOLS,
                TunnelTrenchItems.netheriteExcavatorItem
            )
            .unlocks("has_netherite_ingot", has(itemRegistry, Items.NETHERITE_INGOT));
    }

}
