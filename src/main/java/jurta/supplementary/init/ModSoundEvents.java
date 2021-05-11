package jurta.supplementary.init;

import jurta.supplementary.Supplementary;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;

public class ModSoundEvents {
    /* public static final RegistryObject<SoundEvent> TEST = Registration.SOUNDS.register("test", () ->
            new SoundEvent(modLoc("test"))); */

    static void register() {}

    public static ResourceLocation modLoc(String location) {
            return new ResourceLocation(Supplementary.MOD_ID, location);
    }
}
