package jurta.ancillary.init;

import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModParticleTypes {
    public static final RegistryObject<BasicParticleType> CHERRY_BLOSSOM = register("cherry_blossom", () ->
            new BasicParticleType(false));

    private static <F extends ParticleType<?>> RegistryObject<F> register(String name, Supplier<F> feature) {
        return Registration.PARTICLE_TYPES.register(name, feature);
    }

    static void register() {}
}
