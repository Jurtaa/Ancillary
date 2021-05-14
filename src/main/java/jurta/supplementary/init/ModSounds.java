package jurta.supplementary.init;

import jurta.supplementary.Supplementary;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;

public class ModSounds {
    // Lush Stone
    public static final RegistryObject<SoundEvent> BLOCK_LUSH_STONE_BREAK = Registration.SOUNDS.register("block_lush_stone_break", () ->
            new SoundEvent(modLoc("block.lush_stone.break")));
    public static final RegistryObject<SoundEvent> BLOCK_LUSH_STONE_FALL = Registration.SOUNDS.register("block_lush_stone_fall", () ->
            new SoundEvent(modLoc("block.lush_stone.fall")));
    public static final RegistryObject<SoundEvent> BLOCK_LUSH_STONE_HIT = Registration.SOUNDS.register("block_lush_stone_hit", () ->
            new SoundEvent(modLoc("block.lush_stone.hit")));
    public static final RegistryObject<SoundEvent> BLOCK_LUSH_STONE_PLACE = Registration.SOUNDS.register("block_lush_stone_place", () ->
            new SoundEvent(modLoc("block.lush_stone.place")));
    public static final RegistryObject<SoundEvent> BLOCK_LUSH_STONE_STEP = Registration.SOUNDS.register("block_lush_stone_step", () ->
            new SoundEvent(modLoc("block.lush_stone.step")));

    static void register() {}

    public static ResourceLocation modLoc(String location) {
            return new ResourceLocation(Supplementary.MOD_ID, location);
    }
}
