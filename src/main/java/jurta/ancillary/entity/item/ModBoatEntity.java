package jurta.ancillary.entity.item;

import jurta.ancillary.init.ModBlocks;
import jurta.ancillary.init.ModEntities;
import jurta.ancillary.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class ModBoatEntity extends BoatEntity {
    private static final DataParameter<Integer> MOD_BOAT_TYPE = EntityDataManager.defineId(ModBoatEntity.class, DataSerializers.INT);

    public ModBoatEntity(EntityType<? extends BoatEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public ModBoatEntity(World world, double x, double y, double z) {
        super(ModEntities.MOD_BOAT.get(), world);
        setPos(x, y, z);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(MOD_BOAT_TYPE, ModBoatEntity.Type.SAKURA.ordinal());
    }

    public ModBoatEntity.Type getModBoatType() {
        return ModBoatEntity.Type.byId(this.entityData.get(MOD_BOAT_TYPE));
    }

    @Override
    public Item getDropItem() {
        switch (this.getModBoatType()) {
            case SAKURA:
            default:
                return ModItems.SAKURA_BOAT.get();

        }
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public void setType(ModBoatEntity.Type type) {
        this.entityData.set(MOD_BOAT_TYPE, type.ordinal());
    }

    public enum Type {
        SAKURA(ModBlocks.SAKURA_PLANKS.get(), "sakura");

        private final String name;
        private final Block planks;

        private Type(Block p_i48146_3_, String p_i48146_4_) {
            this.name = p_i48146_4_;
            this.planks = p_i48146_3_;
        }

        public String getName() {
            return this.name;
        }

        public Block getPlanks() {
            return this.planks;
        }

        public String toString() {
            return this.name;
        }

        public static ModBoatEntity.Type byId(int p_184979_0_) {
            ModBoatEntity.Type[] aboatentity$type = values();
            if (p_184979_0_ < 0 || p_184979_0_ >= aboatentity$type.length) {
                p_184979_0_ = 0;
            }

            return aboatentity$type[p_184979_0_];
        }

        public static ModBoatEntity.Type byName(String p_184981_0_) {
            ModBoatEntity.Type[] aboatentity$type = values();

            for(int i = 0; i < aboatentity$type.length; ++i) {
                if (aboatentity$type[i].getName().equals(p_184981_0_)) {
                    return aboatentity$type[i];
                }
            }

            return aboatentity$type[0];
        }
    }
}
