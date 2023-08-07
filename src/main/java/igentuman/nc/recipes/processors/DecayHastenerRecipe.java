package igentuman.nc.recipes.processors;

import igentuman.nc.recipes.ingredient.FluidStackIngredient;
import igentuman.nc.recipes.type.NcRecipe;
import igentuman.nc.recipes.ingredient.ItemStackIngredient;
import igentuman.nc.content.processors.Processors;
import igentuman.nc.util.annotation.NothingNullByDefault;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;

import static igentuman.nc.compat.GlobalVars.*;

@NothingNullByDefault
public class DecayHastenerRecipe extends NcRecipe {

    public DecayHastenerRecipe(ResourceLocation id,
                               ItemStackIngredient[] input, ItemStack[] output,
                               FluidStackIngredient[] inputFluids, FluidStack[] outputFluids,
                               double timeModifier, double powerModifier, double heatModifier) {
        super(id, input, output, timeModifier, powerModifier, heatModifier);
        ID = Processors.DECAY_HASTENER;
        RECIPE_CLASSES.put(ID, this.getClass());
        CATALYSTS.put(ID, List.of(getToastSymbol()));
    }
}