package jurta.supplementary.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.AbstractSphereReplaceConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;

import java.util.Random;

public class LushStonePatchFeature extends AbstractSphereReplaceConfig {
    public LushStonePatchFeature(Codec<SphereReplaceConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(ISeedReader reader, ChunkGenerator generator, Random random, BlockPos pos, SphereReplaceConfig config) {
        if (!reader.isEmptyBlock(pos.above())) {
            return false;
        }
        return !reader.isEmptyBlock(pos) ? false : super.place(reader, generator, random, pos, config);
    }
}
