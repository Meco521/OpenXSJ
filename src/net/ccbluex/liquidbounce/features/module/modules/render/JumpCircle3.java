/*     */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import net.ccbluex.liquidbounce.event.EventJump;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.AstolfoAnimation;
/*     */ import net.ccbluex.liquidbounce.utils.timer.TimeUtils;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ModuleInfo(name = "JumpCircle3", description = "JumpCircle3", category = ModuleCategory.RENDER)
/*     */ public class JumpCircle3
/*     */   extends Module
/*     */ {
/*  26 */   public static AstolfoAnimation astolfo = new AstolfoAnimation();
/*  27 */   static List<Circle> circles = new ArrayList<>();
/*  28 */   public FloatValue range2 = new FloatValue("Radius", 1.0F, 0.1F, 3.0F);
/*  29 */   public FloatValue range = new FloatValue("Radius2", 3.0F, 0.1F, 3.0F);
/*  30 */   public FloatValue lifetime = new FloatValue("live", 1000.0F, 1.0F, 10000.0F);
/*     */ 
/*     */   
/*  33 */   public TimeUtils timer = new TimeUtils();
/*     */   
/*     */   boolean check = false;
/*     */   
/*     */   @EventTarget
/*     */   public void onUpdate() {
/*  39 */     if (mc2.field_71439_g.field_70124_G && this.check) {
/*  40 */       circles.add(new Circle(new Vec3d(mc2.field_71439_g.field_70165_t, mc2.field_71439_g.field_70163_u + 0.0625D, mc2.field_71439_g.field_70161_v)));
/*  41 */       this.check = false;
/*     */     } 
/*  43 */     astolfo.update();
/*  44 */     for (Circle circle : circles) {
/*  45 */       circle.update();
/*     */     }
/*  47 */     circles.removeIf(Circle::update);
/*     */   }
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public void onJump(EventJump event) {
/*  53 */     circles.add(new Circle(new Vec3d(mc2.field_71439_g.field_70165_t, mc2.field_71439_g.field_70163_u + 0.0625D, mc2.field_71439_g.field_70161_v)));
/*     */     
/*  55 */     this.check = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public void onRender3D(Render3DEvent event) {
/*  62 */     GlStateManager.func_179094_E();
/*  63 */     GL11.glDisable(3553);
/*  64 */     GL11.glEnable(3042);
/*  65 */     GL11.glBlendFunc(770, 771);
/*  66 */     GL11.glDisable(2929);
/*  67 */     GL11.glDisable(3008);
/*  68 */     GL11.glEnable(2848);
/*  69 */     GlStateManager.func_179117_G();
/*  70 */     GL11.glShadeModel(7425);
/*  71 */     double ix = -(mc2.field_71439_g.field_70142_S + (mc2.field_71439_g.field_70165_t - mc2.field_71439_g.field_70142_S) * mc2.func_184121_ak());
/*  72 */     double iy = -(mc2.field_71439_g.field_70137_T + (mc2.field_71439_g.field_70163_u - mc2.field_71439_g.field_70137_T) * mc2.func_184121_ak());
/*  73 */     double iz = -(mc2.field_71439_g.field_70136_U + (mc2.field_71439_g.field_70161_v - mc2.field_71439_g.field_70136_U) * mc2.func_184121_ak());
/*  74 */     GL11.glTranslated(ix, iy, iz);
/*  75 */     Collections.reverse(circles);
/*     */     try {
/*  77 */       for (Circle c : circles) {
/*  78 */         double x = (c.position()).field_72450_a;
/*  79 */         double y = (c.position()).field_72448_b;
/*  80 */         double z = (c.position()).field_72449_c;
/*  81 */         float k = (float)c.timer.getPassedTimeMs() / ((Float)this.lifetime.getValue()).floatValue();
/*  82 */         float start = k * ((Float)this.range.getValue()).floatValue();
/*  83 */         float end = k * ((Float)this.range2.getValue()).floatValue();
/*     */         
/*  85 */         float middle = (start + end) / 2.0F;
/*  86 */         GL11.glBegin(8); int i;
/*  87 */         for (i = 0; i <= 360; i += 5) {
/*  88 */           int clr = getColor(i);
/*  89 */           int red = clr >> 16 & 0xFF;
/*  90 */           int green = clr >> 8 & 0xFF;
/*  91 */           int blue = clr & 0xFF;
/*     */           
/*  93 */           GL11.glColor4f(red / 255.0F, green / 255.0F, blue / 255.0F, 0.0F);
/*  94 */           GL11.glVertex3d(x + Math.cos(Math.toRadians(i)) * start, y, z + Math.sin(Math.toRadians(i)) * start);
/*  95 */           GL11.glColor4f(red / 255.0F, green / 255.0F, blue / 255.0F, 1.0F - (float)c.timer.getPassedTimeMs() / ((Float)this.lifetime.getValue()).floatValue());
/*  96 */           GL11.glVertex3d(x + Math.cos(Math.toRadians(i)) * middle, y, z + Math.sin(Math.toRadians(i)) * middle);
/*     */         } 
/*  98 */         GL11.glEnd();
/*     */         
/* 100 */         GL11.glBegin(8);
/* 101 */         for (i = 0; i <= 360; i += 5) {
/* 102 */           int clr = getColor(i);
/* 103 */           int red = clr >> 16 & 0xFF;
/* 104 */           int green = clr >> 8 & 0xFF;
/* 105 */           int blue = clr & 0xFF;
/*     */           
/* 107 */           GL11.glColor4f(red / 255.0F, green / 255.0F, blue / 255.0F, 0.0F);
/* 108 */           GL11.glVertex3d(x + Math.cos(Math.toRadians(i)) * (middle - 0.02D), y, z + Math.sin(Math.toRadians(i)) * (middle - 0.02D));
/* 109 */           GL11.glColor4f(red / 255.0F, green / 255.0F, blue / 255.0F, 1.0F - (float)c.timer.getPassedTimeMs() / ((Float)this.lifetime.getValue()).floatValue());
/* 110 */           GL11.glVertex3d(x + Math.cos(Math.toRadians(i)) * (middle + 0.02D), y, z + Math.sin(Math.toRadians(i)) * (middle + 0.02D));
/*     */         } 
/* 112 */         GL11.glEnd();
/*     */         
/* 114 */         GL11.glBegin(8);
/* 115 */         for (i = 0; i <= 360; i += 5) {
/* 116 */           int clr = getColor(i);
/* 117 */           int red = clr >> 16 & 0xFF;
/* 118 */           int green = clr >> 8 & 0xFF;
/* 119 */           int blue = clr & 0xFF;
/* 120 */           GL11.glColor4f(red / 255.0F, green / 255.0F, blue / 255.0F, 1.0F - (float)c.timer.getPassedTimeMs() / ((Float)this.lifetime.getValue()).floatValue());
/* 121 */           GL11.glVertex3d(x + Math.cos(Math.toRadians(i)) * middle, y, z + Math.sin(Math.toRadians(i)) * middle);
/* 122 */           GL11.glColor4f(red / 255.0F, green / 255.0F, blue / 255.0F, 0.0F);
/* 123 */           GL11.glVertex3d(x + Math.cos(Math.toRadians(i)) * end, y, z + Math.sin(Math.toRadians(i)) * end);
/*     */         } 
/* 125 */         GL11.glEnd();
/*     */       } 
/* 127 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 130 */     GL11.glEnable(3553);
/* 131 */     GL11.glEnable(2929);
/* 132 */     GL11.glDisable(2848);
/* 133 */     GL11.glEnable(3008);
/* 134 */     GlStateManager.func_179117_G();
/* 135 */     Collections.reverse(circles);
/* 136 */     GlStateManager.func_179121_F();
/* 137 */     GL11.glShadeModel(7424);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColor(int stage) {
/* 147 */     return astolfo.getColor((stage + 90) / 360.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum mode
/*     */   {
/* 155 */     Jump, Landing;
/*     */   }
/*     */   
/*     */   public enum cmode {
/* 159 */     Custom, Rainbow, TwoColor, Astolfo;
/*     */   }
/*     */   
/*     */   class Circle {
/*     */     private final Vec3d vec;
/* 164 */     TimeUtils timer = new TimeUtils();
/*     */     
/*     */     Circle(Vec3d vec) {
/* 167 */       this.vec = vec;
/* 168 */       this.timer.reset();
/*     */     }
/*     */     
/*     */     Vec3d position() {
/* 172 */       return this.vec;
/*     */     }
/*     */     
/*     */     public boolean update() {
/* 176 */       return this.timer.passedMs((Float)JumpCircle3.this.lifetime.get());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\JumpCircle3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */