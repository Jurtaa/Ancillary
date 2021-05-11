package jurta.supplementary.init;

import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.util.ForgeSoundType;

public class ModSoundType {
    public static final ForgeSoundType LUSH_STONE = new ForgeSoundType(1.0F, 1.0F, () -> SoundEvents.STONE_BREAK, () -> SoundEvents.GRASS_STEP, () -> SoundEvents.STONE_PLACE, () -> SoundEvents.STONE_HIT, () -> SoundEvents.GRASS_FALL);
}
