/*    */ package net.ccbluex.liquidbounce.utils.render.particle;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Random;
/*    */ import net.ccbluex.liquidbounce.utils.render.particle.util.RenderUtils;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ParticleGenerator
/*    */ {
/* 21 */   private final List<Particle> particles = new ArrayList<>();
/*    */   
/*    */   private final int amount;
/*    */   private int prevWidth;
/*    */   private int prevHeight;
/*    */   
/*    */   public ParticleGenerator(int amount) {
/* 28 */     this.amount = amount;
/*    */   }
/*    */   
/*    */   public void draw(int mouseX, int mouseY) {
/* 32 */     if (this.particles.isEmpty() || this.prevWidth != (Minecraft.func_71410_x()).field_71443_c || this.prevHeight != (Minecraft.func_71410_x()).field_71440_d) {
/* 33 */       this.particles.clear();
/* 34 */       create();
/*    */     } 
/*    */     
/* 37 */     this.prevWidth = (Minecraft.func_71410_x()).field_71443_c;
/* 38 */     this.prevHeight = (Minecraft.func_71410_x()).field_71440_d;
/*    */     
/* 40 */     for (Particle particle : this.particles) {
/* 41 */       particle.fall();
/* 42 */       particle.interpolation();
/*    */       
/* 44 */       int range = 50;
/* 45 */       boolean mouseOver = (mouseX >= particle.x - range && mouseY >= particle.y - range && mouseX <= particle.x + range && mouseY <= particle.y + range);
/*    */       
/* 47 */       if (mouseOver) {
/* 48 */         this.particles.stream()
/* 49 */           .filter(part -> (part.getX() > particle.getX() && part.getX() - particle.getX() < range && particle.getX() - part.getX() < range && ((part.getY() > particle.getY() && part.getY() - particle.getY() < range) || (particle.getY() > part.getY() && particle.getY() - part.getY() < range))))
/*    */ 
/*    */ 
/*    */           
/* 53 */           .forEach(connectable -> particle.connect(connectable.getX(), connectable.getY()));
/*    */       }
/*    */       
/* 56 */       RenderUtils.drawCircle(particle.getX(), particle.getY(), particle.size, -1);
/*    */     } 
/*    */   }
/*    */   
/*    */   private void create() {
/* 61 */     Random random = new Random();
/*    */     
/* 63 */     for (int i = 0; i < this.amount; i++)
/* 64 */       this.particles.add(new Particle(random.nextInt((Minecraft.func_71410_x()).field_71443_c), random.nextInt((Minecraft.func_71410_x()).field_71440_d))); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\particle\ParticleGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */