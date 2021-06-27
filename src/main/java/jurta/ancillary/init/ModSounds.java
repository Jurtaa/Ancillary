package jurta.ancillary.init;

import jurta.ancillary.Ancillary;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModSounds {
    // Lush Stone
    public static final RegistryObject<SoundEvent> BLOCK_LUSH_STONE_BREAK = register("block_lush_stone_break", () ->
            new SoundEvent(modLoc("block.lush_stone.break")));
    public static final RegistryObject<SoundEvent> BLOCK_LUSH_STONE_FALL = register("block_lush_stone_fall", () ->
            new SoundEvent(modLoc("block.lush_stone.fall")));
    public static final RegistryObject<SoundEvent> BLOCK_LUSH_STONE_HIT = register("block_lush_stone_hit", () ->
            new SoundEvent(modLoc("block.lush_stone.hit")));
    public static final RegistryObject<SoundEvent> BLOCK_LUSH_STONE_PLACE = register("block_lush_stone_place", () ->
            new SoundEvent(modLoc("block.lush_stone.place")));
    public static final RegistryObject<SoundEvent> BLOCK_LUSH_STONE_STEP = register("block_lush_stone_step", () ->
            new SoundEvent(modLoc("block.lush_stone.step")));

    private static <F extends SoundEvent> RegistryObject<F> register(String name, Supplier<F> feature) {
        return Registration.SOUNDS.register(name, feature);
    }

    static void register() {}

    public static ResourceLocation modLoc(String location) {
            return new ResourceLocation(Ancillary.MOD_ID, location);
    }
}
