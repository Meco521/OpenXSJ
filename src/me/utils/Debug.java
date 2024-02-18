/*     */ package me.utils;
/*     */ 
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.Animations;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.util.EnumHandSide;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Debug
/*     */   extends MinecraftInstance
/*     */ {
/*     */   private static void func_178103_d2() {
/*  15 */     GlStateManager.func_179109_b(((Float)Animations.xhValue.get()).floatValue(), ((Float)Animations.yhValue.get()).floatValue(), ((Float)Animations.zhValue.get()).floatValue());
/*  16 */     GlStateManager.func_179109_b(-0.5F, 0.2F, 0.0F);
/*  17 */     GlStateManager.func_179114_b(30.0F, 0.0F, 1.0F, 0.0F);
/*  18 */     GlStateManager.func_179114_b(-80.0F, 1.0F, 0.0F, 0.0F);
/*  19 */     GlStateManager.func_179114_b(60.0F, 0.0F, 1.0F, 0.0F);
/*  20 */     GlStateManager.func_179152_a(((Float)Animations.scalehValue.get()).floatValue(), ((Float)Animations.scalehValue.get()).floatValue(), ((Float)Animations.scalehValue.get()).floatValue());
/*     */   }
/*     */   private static void genCustom(float p_178096_1_, float p_178096_2_) {
/*  23 */     GlStateManager.func_179109_b(((Float)Animations.xhValue.get()).floatValue(), ((Float)Animations.yhValue.get()).floatValue(), ((Float)Animations.zhValue.get()).floatValue());
/*  24 */     GlStateManager.func_179109_b(0.56F, -0.52F, -0.71999997F);
/*  25 */     GlStateManager.func_179109_b(0.0F, p_178096_1_ * -0.6F, 0.0F);
/*  26 */     GlStateManager.func_179114_b(25.0F, 0.0F, 1.0F, 0.0F);
/*  27 */     float var3 = MathHelper.func_76126_a(p_178096_2_ * p_178096_2_ * 3.1415927F);
/*  28 */     float var4 = MathHelper.func_76126_a(MathHelper.func_76129_c(p_178096_2_) * 3.1415927F);
/*  29 */     GlStateManager.func_179114_b(var3 * -15.0F, 0.0F, 1.0F, 0.2F);
/*  30 */     GlStateManager.func_179114_b(var4 * -10.0F, 0.2F, 0.1F, 1.0F);
/*  31 */     GlStateManager.func_179114_b(var4 * -30.0F, 1.3F, 0.1F, 0.2F);
/*  32 */     GlStateManager.func_179152_a(0.4F, 0.4F, 0.4F);
/*  33 */     new Animations(); GlStateManager.func_179152_a(((Float)Animations.scalehValue.get()).floatValue(), ((Float)Animations.scalehValue.get()).floatValue(), ((Float)Animations.scalehValue.get()).floatValue());
/*     */   }
/*  35 */   public static Boolean thePlayerisBlocking = Boolean.valueOf(false);
/*     */   
/*     */   public static void transformSideFirstPersonBlock(EnumHandSide p_187459_1_, float equippedProg, float swingProgress) {
/*  38 */     int side = (p_187459_1_ == EnumHandSide.RIGHT) ? 1 : -1;
/*  39 */     GlStateManager.func_179137_b(side * 0.56D, -0.52D + equippedProg * -0.6D, -0.72D);
/*  40 */     GlStateManager.func_179137_b(side * -0.1414214D, 0.08D, 0.1414214D);
/*  41 */     GlStateManager.func_179114_b(-102.25F, 1.0F, 0.0F, 0.0F);
/*  42 */     GlStateManager.func_179114_b(side * 13.365F, 0.0F, 1.0F, 0.0F);
/*  43 */     GlStateManager.func_179114_b(side * 78.05F, 0.0F, 0.0F, 1.0F);
/*  44 */     double f = Math.sin((swingProgress * swingProgress) * Math.PI);
/*  45 */     double f1 = Math.sin(Math.sqrt(swingProgress) * Math.PI);
/*  46 */     GlStateManager.func_179114_b((float)(f * -20.0D), 0.0F, 1.0F, 0.0F);
/*  47 */     GlStateManager.func_179114_b((float)(f1 * -20.0D), 0.0F, 0.0F, 1.0F);
/*  48 */     GlStateManager.func_179114_b((float)(f1 * -80.0D), 1.0F, 0.0F, 0.0F);
/*     */   }
/*     */   public static void Remix(EnumHandSide p_187459_1_, float equippedProg, float swingProgress) {
/*  51 */     double f = 0.0D;
/*  52 */     genCustom((float)f, 0.83F);
/*  53 */     func_178103_d2();
/*  54 */     f = Math.sin((swingProgress * swingProgress) * Math.PI);
/*  55 */     double f1 = Math.sin(Math.sqrt(swingProgress) * Math.PI);
/*  56 */     float f4 = MathHelper.func_76126_a(MathHelper.func_76133_a(f1) * 3.83F);
/*  57 */     GlStateManager.func_179109_b(-0.5F, 0.2F, 0.2F);
/*  58 */     GlStateManager.func_179114_b(-f4 * 0.0F, 0.0F, 0.0F, 0.0F);
/*  59 */     GlStateManager.func_179114_b(-f4 * 43.0F, 58.0F, 23.0F, 45.0F);
/*     */   }
/*     */   public static void slide2(EnumHandSide p_187459_1_, float equippedProg, float swingProgress) {
/*  62 */     int side = (p_187459_1_ == EnumHandSide.RIGHT) ? 1 : -1;
/*  63 */     GlStateManager.func_179137_b(side * 0.25D, -0.55D + equippedProg * -0.6D, -0.72D);
/*  64 */     GlStateManager.func_179137_b(side * -0.1414214D, 0.2D, 0.1414214D);
/*  65 */     GlStateManager.func_179114_b(-100.0F, 0.0F, 1.0F, 0.0F);
/*  66 */     GlStateManager.func_179114_b(side * 13.365F, 0.0F, 0.0F, 0.0F);
/*  67 */     GlStateManager.func_179114_b(side * 78.05F, 0.0F, 0.0F, 1.0F);
/*  68 */     double f = Math.sin((swingProgress * swingProgress) * Math.PI);
/*  69 */     double f1 = Math.sin(Math.sqrt(swingProgress) * Math.PI);
/*  70 */     GlStateManager.func_179114_b((float)(f * -20.0D), 0.0F, 1.0F, 0.0F);
/*  71 */     GlStateManager.func_179114_b((float)(f1 * -20.0D), 0.0F, 0.0F, 1.0F);
/*  72 */     GlStateManager.func_179114_b((float)(f1 * -80.0D), 1.0F, 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public static void WindMill(EnumHandSide p_187459_1_, float equippedProg, float swingProgress) {
/*  76 */     int side = (p_187459_1_ == EnumHandSide.RIGHT) ? 1 : -1;
/*  77 */     GlStateManager.func_179137_b(side * 0.56D, -0.52D + equippedProg * -0.6D, -0.72D);
/*  78 */     GlStateManager.func_179137_b(side * -0.1414214D, 0.08D, 0.1414214D);
/*  79 */     GlStateManager.func_179114_b(-102.25F, 1.0F, 0.0F, 0.0F);
/*  80 */     GlStateManager.func_179114_b(side * 13.365F, 0.0F, 1.0F, 0.0F);
/*  81 */     GlStateManager.func_179114_b(side * 78.05F, 0.0F, 0.0F, 1.0F);
/*  82 */     double f = Math.sin((swingProgress * swingProgress) * Math.PI);
/*  83 */     double f1 = Math.sin(Math.sqrt(swingProgress) * Math.PI);
/*  84 */     GlStateManager.func_179114_b((float)(f * -20.0D), 0.0F, 1.0F, 0.0F);
/*  85 */     GlStateManager.func_179114_b((float)(f1 * -20.0D), 0.0F, 0.0F, 1.0F);
/*  86 */     GlStateManager.func_179114_b((float)(f1 * -80.0D), 1.0F, 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public static void Push(EnumHandSide p_187459_1_, float equippedProg, float swingProgress) {
/*  90 */     int side = (p_187459_1_ == EnumHandSide.RIGHT) ? 1 : -1;
/*  91 */     GlStateManager.func_179137_b(side * 0.56D, -0.52D + equippedProg * -0.6D, -0.72D);
/*  92 */     GlStateManager.func_179137_b(side * -0.1414214D, 0.08D, 0.1414214D);
/*  93 */     GlStateManager.func_179114_b(-102.25F, 1.0F, 0.0F, 0.0F);
/*  94 */     GlStateManager.func_179114_b(side * 13.365F, 0.0F, 1.0F, 0.0F);
/*  95 */     GlStateManager.func_179114_b(side * 78.05F, 0.0F, 0.0F, 1.0F);
/*  96 */     double f = Math.sin((swingProgress * swingProgress) * Math.PI);
/*  97 */     double f1 = Math.sin(Math.sqrt(swingProgress) * Math.PI);
/*  98 */     GlStateManager.func_179114_b((float)(f * -10.0D), 1.0F, 1.0F, 1.0F);
/*  99 */     GlStateManager.func_179114_b((float)(f1 * -10.0D), 1.0F, 1.0F, 1.0F);
/* 100 */     GlStateManager.func_179114_b((float)(f1 * -10.0D), 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public static void Pride(EnumHandSide p_187459_1_, float equippedProg, float swingProgress) {
/* 104 */     double f = 0.0D;
/* 105 */     genCustom((float)f, 0.9F);
/* 106 */     func_178103_d2();
/* 107 */     f = Math.sin((swingProgress * swingProgress) * Math.PI);
/* 108 */     double f1 = Math.sin(Math.sqrt(swingProgress) * Math.PI);
/* 109 */     float f4 = MathHelper.func_76126_a(MathHelper.func_76133_a(f1) * 3.83F);
/* 110 */     int side = (p_187459_1_ == EnumHandSide.RIGHT) ? 1 : -1;
/*     */     
/* 112 */     GlStateManager.func_179109_b(-0.0F, 0.4F, 0.0F);
/* 113 */     GlStateManager.func_179109_b(-0.5F, 0.2F, 0.0F);
/*     */     
/* 115 */     GlStateManager.func_179114_b(-102.25F, 1.0F, 0.0F, 0.0F);
/* 116 */     GlStateManager.func_179114_b(side * 13.365F, 0.0F, 1.0F, 0.0F);
/* 117 */     GlStateManager.func_179114_b(side * 78.05F, 0.0F, 0.0F, 1.0F);
/*     */     
/* 119 */     GlStateManager.func_179114_b((float)(f1 * 100.0D), 3.0F, 3.0F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void Vanilla(EnumHandSide p_187459_1_, float equippedProg, float swingProgress) {
/* 124 */     double f = 0.0D;
/* 125 */     genCustom((float)f, 0.83F);
/* 126 */     func_178103_d2();
/* 127 */     f = Math.sin((swingProgress * swingProgress) * Math.PI);
/* 128 */     double f1 = Math.sin(Math.sqrt(swingProgress) * Math.PI);
/* 129 */     float f4 = MathHelper.func_76126_a(MathHelper.func_76133_a(f1) * 3.83F);
/* 130 */     int side = (p_187459_1_ == EnumHandSide.RIGHT) ? 1 : -1;
/*     */     
/* 132 */     GlStateManager.func_179109_b(-0.0F, 0.4F, 0.0F);
/* 133 */     GlStateManager.func_179109_b(-0.5F, 0.2F, 0.0F);
/*     */     
/* 135 */     GlStateManager.func_179114_b(-102.25F, 1.0F, 0.0F, 0.0F);
/* 136 */     GlStateManager.func_179114_b(side * 13.365F, 0.0F, 1.0F, 0.0F);
/* 137 */     GlStateManager.func_179114_b(side * 78.05F, 0.0F, 0.0F, 1.0F);
/*     */     
/* 139 */     GlStateManager.func_179114_b((float)(f1 * 100.0D), 3.0F, 3.0F, 1.0F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\m\\utils\Debug.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */