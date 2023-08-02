package igentuman.nc.recipes.handler;

import igentuman.nc.block.entity.IBlockEntityHandler;
import igentuman.nc.block.entity.NuclearCraftBE;
import igentuman.nc.recipes.INcRecipeTypeProvider;
import igentuman.nc.recipes.NcRecipe;
import igentuman.nc.recipes.ingredient.InputIngredient;
import igentuman.nc.recipes.type.ItemStackToItemStackRecipe;
import igentuman.nc.recipes.NcRecipeType;
import igentuman.nc.recipes.cache.InputRecipeCache.*;
import igentuman.nc.recipes.lookup.ISingleRecipeLookupHandler.ItemRecipeLookupHandler;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class ItemToItemRecipeHandler implements ItemRecipeLookupHandler<ItemStackToItemStackRecipe>, IBlockEntityHandler {

    private NuclearCraftBE blockEntity;

    public ItemToItemRecipeHandler(NuclearCraftBE blockEntity) {
        this.blockEntity = blockEntity;
    }

    @Override
    public @Nullable ItemStackToItemStackRecipe getRecipe() {
        return findFirstRecipe(blockEntity.getItemInventory());
    }

    @Override
    public @NotNull INcRecipeTypeProvider<ItemStackToItemStackRecipe, SingleItem<ItemStackToItemStackRecipe>> getRecipeType() {
        return NcRecipeType.ONE_ITEM_RECIPES.get(blockEntity.getName());
    }

    @Override
    public void onContentsChanged() {

    }

    @Override
    public BlockEntity getBlockEntity() {
        return blockEntity;
    }
}