package igentuman.nc.block.entity.processor;

import igentuman.nc.setup.registration.NCProcessors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class SteamTurbineBE extends NCProcessor {
    public static String NAME = "steam_turbine";
    public SteamTurbineBE(BlockPos pPos, BlockState pBlockState) {
        super(pPos, pBlockState, NAME);
    }
    @Override
    public String getName() {
        return NAME;
    }
}