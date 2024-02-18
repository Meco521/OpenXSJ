/*    */ package net.ccbluex.liquidbounce.utils.particles;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.utils.render.particle.ParticleGenerator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ParticleUtils
/*    */ {
/* 13 */   private static final ParticleGenerator particleGenerator = new ParticleGenerator(100);
/*    */   
/*    */   public static void drawParticles(int mouseX, int mouseY) {
/* 16 */     particleGenerator.draw(mouseX, mouseY);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\particles\ParticleUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */