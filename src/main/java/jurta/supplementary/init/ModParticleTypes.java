package jurta.supplementary.init;

import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.fml.RegistryObject;

public class ModParticleTypes {
    public static final RegistryObject<BasicParticleType> CHERRY_BLOSSOM = Registration.PARTICLE_TYPES.register("cherry_blossom", () ->
            new BasicParticleType(false));

    static void register() {}
}
