/*     */ package net.ccbluex.liquidbounce.utils.render;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.Rotations;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.Wings;
/*     */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderWings
/*     */   extends ModelBase
/*     */ {
/*  21 */   Minecraft mc = Minecraft.func_71410_x();
/*     */   private ResourceLocation location;
/*     */   private final ModelRenderer wing;
/*     */   private final ModelRenderer wingTip;
/*     */   private final boolean playerUsesFullHeight;
/*  26 */   final Wings Wings = (Wings)Retreat.moduleManager.getModule(Wings.class);
/*  27 */   String WingMode = (String)this.Wings.getWingStyle().get();
/*  28 */   final Rotations rotations = (Rotations)Retreat.moduleManager.getModule(Rotations.class);
/*     */ 
/*     */   
/*     */   public RenderWings() {
/*  32 */     if (this.WingMode.equals("Dragon")) { this.location = new ResourceLocation("tomk/wings/DragonWings.png"); } else if (this.WingMode.equals("Simple")) { this.location = new ResourceLocation("tomk/wings/NeonWings.png"); }
/*  33 */      this.playerUsesFullHeight = true;
/*  34 */     func_78085_a("wing.bone", 0, 0);
/*  35 */     func_78085_a("wing.skin", -10, 8);
/*  36 */     func_78085_a("wingtip.bone", 0, 5);
/*  37 */     func_78085_a("wingtip.skin", -10, 18);
/*  38 */     this.wing = new ModelRenderer(this, "wing");
/*  39 */     this.wing.func_78787_b(30, 30);
/*  40 */     this.wing.func_78793_a(-2.0F, 0.0F, 0.0F);
/*  41 */     this.wing.func_78786_a("bone", -10.0F, -1.0F, -1.0F, 10, 2, 2);
/*  42 */     this.wing.func_78786_a("skin", -10.0F, 0.0F, 0.5F, 10, 0, 10);
/*  43 */     this.wingTip = new ModelRenderer(this, "wingtip");
/*  44 */     this.wingTip.func_78787_b(30, 30);
/*  45 */     this.wingTip.func_78793_a(-10.0F, 0.0F, 0.0F);
/*  46 */     this.wingTip.func_78786_a("bone", -10.0F, -0.5F, -0.5F, 10, 1, 1);
/*  47 */     this.wingTip.func_78786_a("skin", -10.0F, 0.0F, 0.5F, 10, 0, 10);
/*  48 */     this.wing.func_78792_a(this.wingTip);
/*     */   }
/*     */   
/*     */   public void renderWings(float partialTicks) {
/*     */     double d1;
/*  53 */     if (RotationUtils.targetRotation != null && ((Boolean)this.rotations.getBodyValue().get()).booleanValue()) {
/*  54 */       d1 = interpolate(this.mc.field_71439_g.field_70759_as, this.mc.field_71439_g.field_70761_aq, partialTicks);
/*     */     } else {
/*  56 */       d1 = interpolate(this.mc.field_71439_g.field_70760_ar, this.mc.field_71439_g.field_70761_aq, partialTicks);
/*     */     } 
/*  58 */     if (this.mc.field_71439_g.func_184218_aH()) d1 = interpolate(this.mc.field_71439_g.field_70760_ar, this.mc.field_71439_g.field_70761_aq, partialTicks); 
/*  59 */     double scale = 1.0D;
/*  60 */     GL11.glPushMatrix();
/*  61 */     GL11.glScaled(-scale, -scale, scale);
/*  62 */     GL11.glRotated(180.0D + d1, 0.0D, 1.0D, 0.0D);
/*  63 */     GL11.glTranslated(0.0D, -(this.playerUsesFullHeight ? 1.45D : 1.25D) / scale, 0.0D);
/*  64 */     GL11.glTranslated(0.0D, 0.0D, 0.2D / scale);
/*  65 */     if (this.mc.field_71439_g.func_70093_af()) {
/*  66 */       GL11.glTranslated(0.0D, 0.125D / scale, 0.0D);
/*     */     }
/*  68 */     if (((String)this.Wings.getColourType().get()).equals("Chroma")) {
/*  69 */       RenderUtils.glColor(ColorUtils.rainbow(), 255);
/*  70 */     } else if (((String)this.Wings.getColourType().get()).equals("Custom")) {
/*  71 */       RenderUtils.glColor(new Color(((Integer)this.Wings.getCR().get()).intValue(), ((Integer)this.Wings.getCG().get()).intValue(), ((Integer)this.Wings.getCB().get()).intValue()), 255);
/*     */     } else {
/*  73 */       GL11.glColor3f(1.0F, 1.0F, 1.0F);
/*     */     } 
/*  75 */     this.mc.func_110434_K().func_110577_a(this.location);
/*     */     
/*  77 */     for (int j = 0; j < 2; j++) {
/*  78 */       GL11.glEnable(2884);
/*  79 */       float f11 = (float)(System.currentTimeMillis() % 1000L) / 1000.0F * 3.1415927F * 2.0F;
/*  80 */       this.wing.field_78795_f = (float)Math.toRadians(-80.0D) - (float)Math.cos(f11) * 0.2F;
/*  81 */       this.wing.field_78796_g = (float)Math.toRadians(20.0D) + (float)Math.sin(f11) * 0.4F;
/*  82 */       this.wing.field_78808_h = (float)Math.toRadians(20.0D);
/*  83 */       this.wingTip.field_78808_h = -((float)(Math.sin((f11 + 2.0F)) + 0.5D)) * 0.75F;
/*  84 */       this.wing.func_78785_a(0.0625F);
/*  85 */       GL11.glScalef(-1.0F, 1.0F, 1.0F);
/*  86 */       if (j == 0) {
/*  87 */         GL11.glCullFace(1028);
/*     */       }
/*     */     } 
/*     */     
/*  91 */     GL11.glCullFace(1029);
/*  92 */     GL11.glDisable(2884);
/*  93 */     GL11.glColor3f(255.0F, 255.0F, 255.0F);
/*  94 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private double interpolate(float yaw1, float yaw2, float percent) {
/*  98 */     double f = (yaw1 + (yaw2 - yaw1) * percent) % 360.0D;
/*  99 */     if (f < 0.0D) {
/* 100 */       f += 360.0D;
/*     */     }
/*     */     
/* 103 */     return f;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\RenderWings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */