package jurta.supplementary.init;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.template.AlwaysTrueRuleTest;
import net.minecraft.world.gen.feature.template.RandomBlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleEntry;
import net.minecraft.world.gen.feature.template.RuleStructureProcessor;

public class ModProcessors {
    public static final RuleStructureProcessor MODDED_CROP_PROCESSOR = new RuleStructureProcessor(ImmutableList.of(
            new RuleEntry(
            // We replace the vanilla Wheat block with Broccoli 30% of the time.
            // Note, Potatoes and Beetroot will also be available to be replaced too by our processor.
            new RandomBlockMatchRuleTest(Blocks.WHEAT, 0.3F),
            // Location predicate. Keep this as always true for most use-cases.
            AlwaysTrueRuleTest.INSTANCE,
            // The modded block to use.
            ModBlocks.BROCCOLI.get().defaultBlockState()
        )
    ));
}
