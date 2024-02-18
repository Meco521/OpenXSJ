/*    */ package net.ccbluex.liquidbounce.utils.render;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.utils.render.particle.ParticleGenerator;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public final class ParticleUtils
/*    */ {
/* 10 */   private static final ParticleGenerator particleGenerator = new ParticleGenerator(100);
/*    */   
/*    */   public static void drawParticles(int mouseX, int mouseY) {
/* 13 */     particleGenerator.draw(mouseX, mouseY);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\ParticleUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */