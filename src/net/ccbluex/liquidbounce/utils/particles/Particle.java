/*    */ package net.ccbluex.liquidbounce.utils.particles;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Particle
/*    */ {
/* 15 */   private final ParticleTimer removeTimer = new ParticleTimer();
/*    */   
/*    */   public final Vec3 position;
/*    */   private final Vec3 delta;
/*    */   
/*    */   public Particle(Vec3 position) {
/* 21 */     this.position = position;
/* 22 */     this.delta = new Vec3((Math.random() * 2.5D - 1.25D) * 0.01D, (Math.random() * 0.5D - 0.2D) * 0.01D, (Math.random() * 2.5D - 1.25D) * 0.01D);
/* 23 */     this.removeTimer.reset();
/*    */   }
/*    */   
/*    */   public Particle(Vec3 position, Vec3 velocity) {
/* 27 */     this.position = position;
/* 28 */     this.delta = new Vec3(velocity.xCoord * 0.01D, velocity.yCoord * 0.01D, velocity.zCoord * 0.01D);
/* 29 */     this.removeTimer.reset();
/*    */   }
/*    */   
/*    */   public void update() {
/* 33 */     Block block1 = PlayerParticles.getBlock(this.position.xCoord, this.position.yCoord, this.position.zCoord + this.delta.zCoord);
/* 34 */     if (!(block1 instanceof net.minecraft.block.BlockAir) && !(block1 instanceof net.minecraft.block.BlockBush) && !(block1 instanceof net.minecraft.block.BlockLiquid)) {
/* 35 */       this.delta.zCoord *= -0.8D;
/*    */     }
/* 37 */     Block block2 = PlayerParticles.getBlock(this.position.xCoord, this.position.yCoord + this.delta.yCoord, this.position.zCoord);
/* 38 */     if (!(block2 instanceof net.minecraft.block.BlockAir) && !(block2 instanceof net.minecraft.block.BlockBush) && !(block2 instanceof net.minecraft.block.BlockLiquid)) {
/* 39 */       this.delta.xCoord *= 0.9990000128746033D;
/* 40 */       this.delta.zCoord *= 0.9990000128746033D;
/*    */       
/* 42 */       this.delta.yCoord *= -0.6D;
/*    */     } 
/*    */     
/* 45 */     Block block3 = PlayerParticles.getBlock(this.position.xCoord + this.delta.xCoord, this.position.yCoord, this.position.zCoord);
/* 46 */     if (!(block3 instanceof net.minecraft.block.BlockAir) && !(block3 instanceof net.minecraft.block.BlockBush) && !(block3 instanceof net.minecraft.block.BlockLiquid)) {
/* 47 */       this.delta.xCoord *= -0.8D;
/*    */     }
/* 49 */     updateWithoutPhysics();
/*    */   }
/*    */   
/*    */   public void updateWithoutPhysics() {
/* 53 */     this.position.xCoord += this.delta.xCoord;
/* 54 */     this.position.yCoord += this.delta.yCoord;
/* 55 */     this.position.zCoord += this.delta.zCoord;
/* 56 */     this.delta.xCoord /= 0.9999970197677612D;
/* 57 */     this.delta.yCoord -= 1.7E-6D;
/* 58 */     this.delta.zCoord /= 0.9999970197677612D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\particles\Particle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */