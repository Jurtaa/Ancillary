package jurta.supplementary.client.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;

public class CherryBlossomParticle extends SpriteTexturedParticle {
    private final float rotSpeed;

    protected CherryBlossomParticle(ClientWorld worldIn, double xPos, double yPos, double zPos, IAnimatedSprite spriteSet) {
        super(worldIn, xPos, yPos, zPos);
        int i = (int)(32.0D / (Math.random() * 0.8D + 0.2D));
        this.lifetime = (int)Math.max((float)i * 0.9F, 1.0F);
        this.hasPhysics = true;
        this.pickSprite(spriteSet);
        this.rotSpeed = ((float)Math.random() - 0.5F) * 0.1F;
        this.roll = (float)Math.random() * ((float)Math.PI * 2F);
    }

    @Override
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.oRoll = this.roll;
            this.roll += (float)Math.PI * this.rotSpeed * 2.0F;
            if (this.onGround) {
                this.oRoll = this.roll = 0.0F;
            }

            this.move(this.xd, this.yd, this.zd);
            this.yd -= 0.003F;
            this.yd = Math.max(this.yd, -0.14F);
        }
    }

    public static class Factory implements IParticleFactory<BasicParticleType> {
        private final IAnimatedSprite spriteSet;

        public Factory(IAnimatedSprite spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Override
        public Particle createParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new CherryBlossomParticle(worldIn, x, y, z, spriteSet);
        }
    }
}
