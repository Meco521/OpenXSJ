/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ import java.awt.Color;
/*     */ import java.math.BigDecimal;
/*     */ import kotlin.Unit;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.color.CustomColor;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.PictureColor;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.PictureColor2;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ElementInfo(name = "RenderFps")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\n\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\n\020\025\032\004\030\0010\026H\026R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\004X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\032\020\n\032\0020\013X\016¢\006\016\n\000\032\004\b\f\020\r\"\004\b\016\020\017R\016\020\020\032\0020\tX\004¢\006\002\n\000R\016\020\021\032\0020\tX\004¢\006\002\n\000R\016\020\022\032\0020\tX\004¢\006\002\n\000R\016\020\023\032\0020\004X\004¢\006\002\n\000R\016\020\024\032\0020\tX\004¢\006\002\n\000¨\006\027"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/RenderFps;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "()V", "Outline", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "OutmodeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "bV", "bgValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "blurmodule", "Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;", "getBlurmodule", "()Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;", "setBlurmodule", "(Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;)V", "sa", "sb", "sg", "shadow", "sr", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "XSJClient"})
/*     */ public final class RenderFps extends Element {
/*     */   private final BoolValue bV;
/*     */   private final BoolValue shadow;
/*     */   private final IntegerValue sr;
/*     */   private final IntegerValue sg;
/*     */   private final IntegerValue sb;
/*     */   private final IntegerValue sa;
/*     */   private final ListValue OutmodeValue;
/*     */   private final BoolValue Outline;
/*     */   private final IntegerValue bgValue;
/*     */   @NotNull
/*     */   private HUD blurmodule;
/*     */   
/*     */   public RenderFps() {
/*  29 */     super(0.0D, 0.0D, 0.0F, null, 15, null);
/*     */ 
/*     */ 
/*     */     
/*  33 */     this.bV = new BoolValue("blur", false);
/*  34 */     this.shadow = new BoolValue("Shadow", false);
/*  35 */     this.sr = new IntegerValue("Shadow-Red", 0, 0, 255);
/*  36 */     this.sg = new IntegerValue("Shadow-Green", 0, 0, 255);
/*  37 */     this.sb = new IntegerValue("Shadow-Blue", 0, 0, 255);
/*  38 */     this.sa = new IntegerValue("Shadow-Alpna", 0, 0, 255);
/*  39 */     this.OutmodeValue = new ListValue("Outmode", new String[] { "Outline1", "Outline2", "old", "more" }, "Outline1");
/*  40 */     this.Outline = new BoolValue("Outline", true);
/*  41 */     this.bgValue = new IntegerValue("Background-Alpha", 120, 0, 255);
/*     */     
/*  43 */     if (Retreat.INSTANCE.getModuleManager().getModule(HUD.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.HUD");  this.blurmodule = (HUD)Retreat.INSTANCE.getModuleManager().getModule(HUD.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class RenderFps$drawElement$1
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/*  67 */       GL11.glPushMatrix();
/*  68 */       GL11.glTranslated(RenderFps.this.getRenderX(), RenderFps.this.getRenderY(), 0.0D);
/*  69 */       GL11.glScalef(RenderFps.this.getScale(), RenderFps.this.getScale(), RenderFps.this.getScale());
/*  70 */       RenderUtils.originalRoundedRect(
/*  71 */           -1.0F, 
/*  72 */           0.0F, 61.0F, 16.0F, 
/*  73 */           2.0F, (new Color(((Number)RenderFps.this.sr.get()).intValue(), ((Number)RenderFps.this.sg.get()).intValue(), ((Number)RenderFps.this.sb.get()).intValue(), ((Number)RenderFps.this.sa.get()).intValue())).getRGB());
/*     */ 
/*     */       
/*  76 */       GL11.glPopMatrix();
/*     */     } RenderFps$drawElement$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class RenderFps$drawElement$2 extends Lambda implements Function0<Unit> { public final void invoke() {
/*  79 */       GL11.glPushMatrix();
/*  80 */       GL11.glTranslated(RenderFps.this.getRenderX(), RenderFps.this.getRenderY(), 0.0D);
/*  81 */       GL11.glScalef(RenderFps.this.getScale(), RenderFps.this.getScale(), RenderFps.this.getScale());
/*  82 */       GlStateManager.func_179147_l();
/*  83 */       GlStateManager.func_179090_x();
/*  84 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/*     */       
/*  86 */       RenderUtils.originalRoundedRect(
/*  87 */           -1.0F, 
/*  88 */           0.0F, 61.0F, 16.0F, 
/*  89 */           2.0F, (new Color(((Number)RenderFps.this.getBlurmodule().getShadowred().get()).intValue(), ((Number)RenderFps.this.getBlurmodule().getShadowgreen().get()).intValue(), ((Number)RenderFps.this.getBlurmodule().getShadowblue().get()).intValue(), ((Number)RenderFps.this.getBlurmodule().getShadowalpha().get()).intValue())).getRGB());
/*  90 */       GlStateManager.func_179098_w();
/*  91 */       GlStateManager.func_179084_k();
/*  92 */       GL11.glPopMatrix();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     RenderFps$drawElement$2() {
/*     */       super(0);
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class RenderFps$drawElement$3
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 120 */       GL11.glPushMatrix();
/* 121 */       GL11.glTranslated(RenderFps.this.getRenderX(), RenderFps.this.getRenderY(), 0.0D);
/* 122 */       GL11.glScalef(RenderFps.this.getScale(), RenderFps.this.getScale(), RenderFps.this.getScale());
/* 123 */       RenderUtils.originalRoundedRect(
/* 124 */           -1.0F, 
/* 125 */           0.0F, 61.0F, 16.0F, 
/* 126 */           2.2F, (new Color(((Number)RenderFps.this.sr.get()).intValue(), ((Number)RenderFps.this.sg.get()).intValue(), ((Number)RenderFps.this.sb.get()).intValue(), ((Number)RenderFps.this.sa.get()).intValue())).getRGB());
/*     */ 
/*     */       
/* 129 */       GL11.glPopMatrix();
/*     */     } RenderFps$drawElement$3() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class RenderFps$drawElement$4 extends Lambda implements Function0<Unit> { public final void invoke() {
/* 132 */       GL11.glPushMatrix();
/* 133 */       GL11.glTranslated(RenderFps.this.getRenderX(), RenderFps.this.getRenderY(), 0.0D);
/* 134 */       GL11.glScalef(RenderFps.this.getScale(), RenderFps.this.getScale(), RenderFps.this.getScale());
/* 135 */       GlStateManager.func_179147_l();
/* 136 */       GlStateManager.func_179090_x();
/* 137 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/*     */       
/* 139 */       RenderUtils.originalRoundedRect(
/* 140 */           -1.0F, 
/* 141 */           0.0F, 61.0F, 16.0F, 
/* 142 */           2.2F, (new Color(((Number)RenderFps.this.getBlurmodule().getShadowred().get()).intValue(), ((Number)RenderFps.this.getBlurmodule().getShadowgreen().get()).intValue(), ((Number)RenderFps.this.getBlurmodule().getShadowblue().get()).intValue(), ((Number)RenderFps.this.getBlurmodule().getShadowalpha().get()).intValue())).getRGB());
/* 143 */       GlStateManager.func_179098_w();
/* 144 */       GlStateManager.func_179084_k();
/* 145 */       GL11.glPopMatrix();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     RenderFps$drawElement$4() {
/*     */       super(0);
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class RenderFps$drawElement$5
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 255 */       GL11.glPushMatrix();
/* 256 */       GL11.glTranslated(RenderFps.this.getRenderX(), RenderFps.this.getRenderY(), 0.0D);
/* 257 */       GL11.glScalef(RenderFps.this.getScale(), RenderFps.this.getScale(), RenderFps.this.getScale());
/* 258 */       RenderUtils.originalRoundedRect(
/* 259 */           -1.0F, 
/* 260 */           0.0F, 61.0F, 16.0F, 
/* 261 */           2.0F, (new Color(((Number)RenderFps.this.sr.get()).intValue(), ((Number)RenderFps.this.sg.get()).intValue(), ((Number)RenderFps.this.sb.get()).intValue(), ((Number)RenderFps.this.sa.get()).intValue())).getRGB());
/*     */ 
/*     */ 
/*     */       
/* 265 */       GL11.glPopMatrix();
/*     */     } RenderFps$drawElement$5() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class RenderFps$drawElement$6 extends Lambda implements Function0<Unit> { public final void invoke() {
/* 268 */       GL11.glPushMatrix();
/* 269 */       GL11.glTranslated(RenderFps.this.getRenderX(), RenderFps.this.getRenderY(), 0.0D);
/* 270 */       GL11.glScalef(RenderFps.this.getScale(), RenderFps.this.getScale(), RenderFps.this.getScale());
/* 271 */       GlStateManager.func_179147_l();
/* 272 */       GlStateManager.func_179090_x();
/* 273 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/*     */       
/* 275 */       RenderUtils.originalRoundedRect(
/* 276 */           -1.0F, 
/* 277 */           0.0F, 
/* 278 */           61.0F, 
/* 279 */           16.0F, 
/* 280 */           2.0F, (
/* 281 */           new Color((
/* 282 */             (Number)RenderFps.this.getBlurmodule().getShadowred().get()).intValue(), (
/* 283 */             (Number)RenderFps.this.getBlurmodule().getShadowgreen().get()).intValue(), (
/* 284 */             (Number)RenderFps.this.getBlurmodule().getShadowblue().get()).intValue(), (
/* 285 */             (Number)RenderFps.this.getBlurmodule().getShadowalpha().get()).intValue())).getRGB());
/*     */ 
/*     */       
/* 288 */       GlStateManager.func_179098_w();
/* 289 */       GlStateManager.func_179084_k();
/* 290 */       GL11.glPopMatrix();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     RenderFps$drawElement$6() {
/*     */       super(0);
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class RenderFps$drawElement$7
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 320 */       GL11.glPushMatrix();
/* 321 */       GL11.glTranslated(RenderFps.this.getRenderX(), RenderFps.this.getRenderY(), 0.0D);
/* 322 */       GL11.glScalef(RenderFps.this.getScale(), RenderFps.this.getScale(), RenderFps.this.getScale());
/* 323 */       RenderUtils.originalRoundedRect(
/* 324 */           -1.0F, 
/* 325 */           0.0F, 61.0F, 16.0F, 
/* 326 */           2.0F, (new Color(((Number)RenderFps.this.sr.get()).intValue(), ((Number)RenderFps.this.sg.get()).intValue(), ((Number)RenderFps.this.sb.get()).intValue(), ((Number)RenderFps.this.sa.get()).intValue())).getRGB());
/*     */ 
/*     */       
/* 329 */       GL11.glPopMatrix();
/*     */     } RenderFps$drawElement$7() { super(0); } }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/* 332 */   static final class RenderFps$drawElement$8 extends Lambda implements Function0<Unit> { public final void invoke() { GL11.glPushMatrix();
/* 333 */       GL11.glTranslated(RenderFps.this.getRenderX(), RenderFps.this.getRenderY(), 0.0D);
/* 334 */       GL11.glScalef(RenderFps.this.getScale(), RenderFps.this.getScale(), RenderFps.this.getScale());
/* 335 */       GlStateManager.func_179147_l();
/* 336 */       GlStateManager.func_179090_x();
/* 337 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/*     */       
/* 339 */       RenderUtils.originalRoundedRect(
/* 340 */           -1.0F, 
/* 341 */           0.0F, 61.0F, 16.0F, 
/* 342 */           2.0F, (new Color(((Number)RenderFps.this.getBlurmodule().getShadowred().get()).intValue(), ((Number)RenderFps.this.getBlurmodule().getShadowgreen().get()).intValue(), ((Number)RenderFps.this.getBlurmodule().getShadowblue().get()).intValue(), ((Number)RenderFps.this.getBlurmodule().getShadowalpha().get()).intValue())).getRGB());
/* 343 */       GlStateManager.func_179098_w();
/* 344 */       GlStateManager.func_179084_k();
/* 345 */       GL11.glPopMatrix(); }
/*     */     RenderFps$drawElement$8() { super(0); } }
/* 347 */    @NotNull public final HUD getBlurmodule() { return this.blurmodule; } @Nullable public Border drawElement() { if (StringsKt.equals((String)this.OutmodeValue.get(), "Outline1", true)) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  BigDecimal bd = new BigDecimal(MinecraftInstance.mc.getThePlayer().getHealth()); Intrinsics.checkExpressionValueIsNotNull(bd.setScale(1, 3), "bd.setScale(1, BigDecimal.ROUND_FLOOR)"); bd = bd.setScale(1, 3); if (((Boolean)this.bV.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glPushMatrix(); BlurBuffer.blurRoundArea((float)getRenderX() - true, (float)getRenderY(), 62.0F, 16.0F, (int)2.0F); GL11.glPopMatrix(); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  RoundedUtil.drawRound(-1.0F, 0.0F, 62.0F, 16.0F, 2.0F, new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue())); if (((Boolean)this.Outline.get()).booleanValue()) ScaleUtils.drawOutline(0.0F, 0.0F, 60.0F, 12.0F, 2.0F, ((Number)CustomColor.line.get()).floatValue(), -5.6F);  Intrinsics.checkExpressionValueIsNotNull(Color.white, "Color.white"); CFontLoad.foricotwo24.drawStringWithShadow("I", 5.0D, 5.0D, Color.white.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.white, "Color.white"); CFontLoad.for18.drawStringWithShadow(String.valueOf(Minecraft.func_175610_ah()) + " Fps", 21.0D, 7, Color.white.getRGB()); if (((Boolean)this.shadow.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); ShadowUtils.shadow(8.0F, new RenderFps$drawElement$1(), new RenderFps$drawElement$2()); GL11.glPopMatrix(); GL11.glScalef(getScale(), getScale(), getScale()); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  }  if (StringsKt.equals((String)this.OutmodeValue.get(), "Outline2", true)) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  BigDecimal bd = new BigDecimal(MinecraftInstance.mc.getThePlayer().getHealth()); Intrinsics.checkExpressionValueIsNotNull(bd.setScale(1, 3), "bd.setScale(1, BigDecimal.ROUND_FLOOR)"); bd = bd.setScale(1, 3); if (((Boolean)this.bV.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glPushMatrix(); BlurBuffer.blurRoundArea((float)getRenderX() - true, (float)getRenderY(), 62.0F, 16.0F, (int)2.0F); GL11.glPopMatrix(); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  RoundedUtil.drawRound(-1.0F, 0.0F, 62.0F, 16.0F, 2.0F, new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue())); if (((Boolean)this.Outline.get()).booleanValue()) ScaleUtils.drawGidentOutlinedRoundedRect3(-1.0D, 0.0D, 62.0D, 16.0D, 2.0D, ((Number)CustomColor.line.get()).floatValue());  Intrinsics.checkExpressionValueIsNotNull(Color.white, "Color.white"); CFontLoad.foricotwo24.drawStringWithShadow("I", 5.0D, 5.0D, Color.white.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.white, "Color.white"); CFontLoad.for18.drawStringWithShadow(String.valueOf(Minecraft.func_175610_ah()) + " Fps", 21.0D, 7, Color.white.getRGB()); if (((Boolean)this.shadow.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); ShadowUtils.shadow(8.0F, new RenderFps$drawElement$3(), new RenderFps$drawElement$4()); GL11.glPopMatrix(); GL11.glScalef(getScale(), getScale(), getScale()); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  }  if (StringsKt.equals((String)this.OutmodeValue.get(), "old", true)) { if (Retreat.INSTANCE.getModuleManager().getModule(PictureColor.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.PictureColor");  PictureColor color = (PictureColor)Retreat.INSTANCE.getModuleManager().getModule(PictureColor.class); if (Retreat.INSTANCE.getModuleManager().getModule(PictureColor2.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.PictureColor2");  PictureColor2 color2 = (PictureColor2)Retreat.INSTANCE.getModuleManager().getModule(PictureColor2.class); Color gradientColor1 = Color.WHITE; Color gradientColor2 = Color.WHITE; Color gradientColor3 = Color.WHITE; Color gradientColor4 = Color.WHITE; gradientColor1 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(10, 20, new Color(((Number)color.getColorRedValue().get()).intValue(), ((Number)color.getColorGreenValue().get()).intValue(), ((Number)color.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false); gradientColor2 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 90, new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false); gradientColor3 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 270, new Color(((Number)color.getColorRedValue().get()).intValue(), ((Number)color.getColorGreenValue().get()).intValue(), ((Number)color.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color.getColorRedValue().get()).intValue(), ((Number)color.getColorGreenValue().get()).intValue(), ((Number)color.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false); gradientColor4 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 270, new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  BigDecimal bd = new BigDecimal(MinecraftInstance.mc.getThePlayer().getHealth()); Intrinsics.checkExpressionValueIsNotNull(bd.setScale(1, 3), "bd.setScale(1, BigDecimal.ROUND_FLOOR)"); bd = bd.setScale(1, 3); if (((Boolean)this.bV.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glPushMatrix(); BlurBuffer.blurRoundArea((float)getRenderX() - true, (float)getRenderY(), 62.0F, 16.0F, (int)2.0F); GL11.glPopMatrix(); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  RoundedUtil.drawGradientRound(-1.0F, 0.0F, 62.0F, 16.0F, 2.0F, gradientColor1, gradientColor3, gradientColor2, gradientColor1); Intrinsics.checkExpressionValueIsNotNull(Color.white, "Color.white"); CFontLoad.foricotwo24.drawString("I", 5.0F, 5.0F, Color.white.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.white, "Color.white"); CFontLoad.for18.drawString(String.valueOf(Minecraft.func_175610_ah()) + " Fps", 21.0F, 7.0F, Color.white.getRGB()); if (((Boolean)this.shadow.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); ShadowUtils.shadow(8.0F, new RenderFps$drawElement$5(), new RenderFps$drawElement$6()); GL11.glPopMatrix(); GL11.glScalef(getScale(), getScale(), getScale()); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  }  if (StringsKt.equals((String)this.OutmodeValue.get(), "more", true)) { Color gradientColor1 = new Color(((Number)CustomColor.r.get()).intValue(), ((Number)CustomColor.g.get()).intValue(), ((Number)CustomColor.b.get()).intValue(), ((Number)CustomColor.a.get()).intValue()); Color gradientColor2 = new Color(((Number)CustomColor.r.get()).intValue(), ((Number)CustomColor.g.get()).intValue(), ((Number)CustomColor.b.get()).intValue(), ((Number)CustomColor.a.get()).intValue()); Color gradientColor3 = new Color(((Number)CustomColor.r2.get()).intValue(), ((Number)CustomColor.g2.get()).intValue(), ((Number)CustomColor.b2.get()).intValue(), ((Number)CustomColor.a2.get()).intValue()); Color gradientColor4 = new Color(((Number)CustomColor.r2.get()).intValue(), ((Number)CustomColor.g2.get()).intValue(), ((Number)CustomColor.b2.get()).intValue(), ((Number)CustomColor.a2.get()).intValue()); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  BigDecimal bd = new BigDecimal(MinecraftInstance.mc.getThePlayer().getHealth()); Intrinsics.checkExpressionValueIsNotNull(bd.setScale(1, 3), "bd.setScale(1, BigDecimal.ROUND_FLOOR)"); bd = bd.setScale(1, 3); if (((Boolean)this.bV.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glPushMatrix(); BlurBuffer.blurRoundArea((float)getRenderX() - true, (float)getRenderY(), 62.0F, 16.0F, (int)2.0F); GL11.glPopMatrix(); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  RoundedUtil.drawGradientRound(-1.0F, 0.0F, 62.0F, 16.0F, 2.0F, ColorUtil.applyOpacity(gradientColor4, 0.85F), gradientColor1, gradientColor3, gradientColor2); Intrinsics.checkExpressionValueIsNotNull(Color.white, "Color.white"); CFontLoad.foricotwo24.drawString("I", 5.0F, 5.0F, Color.white.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.white, "Color.white"); CFontLoad.for18.drawString(String.valueOf(Minecraft.func_175610_ah()) + " Fps", 21.0F, 7.0F, Color.white.getRGB()); if (((Boolean)this.shadow.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); ShadowUtils.shadow(8.0F, new RenderFps$drawElement$7(), new RenderFps$drawElement$8()); GL11.glPopMatrix();
/* 348 */         GL11.glScalef(getScale(), getScale(), getScale());
/* 349 */         GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }
/*     */        }
/*     */     
/* 352 */     return new Border(0.0F, -16.0F, 70.0F, 30.0F); }
/*     */ 
/*     */   
/*     */   public final void setBlurmodule(@NotNull HUD <set-?>) {
/*     */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*     */     this.blurmodule = <set-?>;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\RenderFps.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */