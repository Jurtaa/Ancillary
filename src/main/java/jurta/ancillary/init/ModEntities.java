package jurta.ancillary.init;

import jurta.ancillary.entity.item.ModBoatEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModEntities {
    public static final RegistryObject<EntityType<ModBoatEntity>> MOD_BOAT = register("boat", () ->
            EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, EntityClassification.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build("boat"));

    private static <F extends EntityType<?>> RegistryObject<F> register(String name, Supplier<F> feature) {
        return Registration.ENTITIES.register(name, feature);
    }

    static void register() {}
}
