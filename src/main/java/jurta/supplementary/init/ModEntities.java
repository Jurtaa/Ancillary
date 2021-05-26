package jurta.supplementary.init;

import jurta.supplementary.entity.item.ModBoatEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

public class ModEntities {
    public static final RegistryObject<EntityType<ModBoatEntity>> MOD_BOAT = Registration.ENTITIES.register("boat", () ->
            EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, EntityClassification.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build("boat"));

    static void register() {}
}
