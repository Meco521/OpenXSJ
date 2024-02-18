/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ import courage.utils.info.Recorder;
/*     */ import java.awt.Color;
/*     */ import java.text.SimpleDateFormat;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.Unit;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IFontRenderer;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.AColorPalette;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.PictureColor;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.PictureColor2;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ElementInfo(name = "GameInfo4")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000B\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\007\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\t\n\002\030\002\n\000\b\007\030\0002\0020\001B-\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006\022\b\b\002\020\007\032\0020\b¢\006\002\020\tJ\b\020\032\032\0020\003H\002J\b\020\033\032\0020\034H\026R\016\020\n\032\0020\013X\004¢\006\002\n\000R\016\020\f\032\0020\rX\004¢\006\002\n\000R\016\020\016\032\0020\013X\004¢\006\002\n\000R\016\020\017\032\0020\020X\004¢\006\002\n\000R\021\020\021\032\0020\022¢\006\b\n\000\032\004\b\023\020\024R\016\020\025\032\0020\020X\004¢\006\002\n\000R\016\020\026\032\0020\020X\004¢\006\002\n\000R\016\020\027\032\0020\020X\004¢\006\002\n\000R\016\020\030\032\0020\013X\004¢\006\002\n\000R\016\020\031\032\0020\020X\004¢\006\002\n\000¨\006\035"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/GameInfo4;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "scale", "", "side", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;", "(DDFLnet/ccbluex/liquidbounce/ui/client/hud/element/Side;)V", "Outline", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "OutmodeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "bV", "bgValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "fontValue", "Lnet/ccbluex/liquidbounce/value/FontValue;", "getFontValue", "()Lnet/ccbluex/liquidbounce/value/FontValue;", "sa", "sb", "sg", "shadow", "sr", "calculateBPS", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "XSJClient"})
/*     */ public final class GameInfo4 extends Element {
/*     */   private final BoolValue bV;
/*     */   private final ListValue OutmodeValue;
/*     */   private final BoolValue Outline;
/*     */   private final IntegerValue bgValue;
/*     */   private final BoolValue shadow;
/*     */   private final IntegerValue sr;
/*     */   private final IntegerValue sg;
/*     */   private final IntegerValue sb;
/*     */   private final IntegerValue sa;
/*     */   @NotNull
/*     */   private final FontValue fontValue;
/*     */   
/*     */   public GameInfo4(double x, double y, float scale, @NotNull Side side) {
/*  35 */     super(x, y, scale, side);
/*  36 */     this.bV = new BoolValue("blur", false);
/*     */     
/*  38 */     this.OutmodeValue = new ListValue("Outmode", new String[] { "Outline1", "Outline2", "old", "more" }, "Outline1");
/*  39 */     this.Outline = new BoolValue("Outline", true);
/*  40 */     this.bgValue = new IntegerValue("Background-Alpha", 120, 0, 255);
/*  41 */     this.shadow = new BoolValue("Shadow", false);
/*  42 */     this.sr = new IntegerValue("Shadow-Red", 0, 0, 255);
/*  43 */     this.sg = new IntegerValue("Shadow-Green", 0, 0, 255);
/*  44 */     this.sb = new IntegerValue("Shadow-Blue", 0, 0, 255);
/*  45 */     this.sa = new IntegerValue("Shadow-Alpna", 0, 0, 255);
/*     */     
/*  47 */     Intrinsics.checkExpressionValueIsNotNull(Fonts.tenacitybold40, "Fonts.tenacitybold40"); this.fontValue = new FontValue("Font", Fonts.tenacitybold40);
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
/*     */   static final class GameInfo4$drawElement$1
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 119 */       GL11.glPushMatrix();
/* 120 */       GL11.glTranslated(GameInfo4.this.getRenderX(), GameInfo4.this.getRenderY(), 0.0D);
/* 121 */       GL11.glScalef(GameInfo4.this.getScale(), GameInfo4.this.getScale(), GameInfo4.this.getScale());
/* 122 */       RenderUtils.originalRoundedRect(
/* 123 */           -5.0F, 
/* 124 */           1.0F, 125.0F, 91.0F, 
/* 125 */           6.4F, (new Color(((Number)GameInfo4.this.sr.get()).intValue(), ((Number)GameInfo4.this.sg.get()).intValue(), ((Number)GameInfo4.this.sb.get()).intValue(), ((Number)GameInfo4.this.sa.get()).intValue())).getRGB());
/*     */ 
/*     */       
/* 128 */       GL11.glPopMatrix();
/*     */     } GameInfo4$drawElement$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class GameInfo4$drawElement$2 extends Lambda implements Function0<Unit> { public final void invoke() {
/* 131 */       GL11.glPushMatrix();
/* 132 */       GL11.glTranslated(GameInfo4.this.getRenderX(), GameInfo4.this.getRenderY(), 0.0D);
/* 133 */       GL11.glScalef(GameInfo4.this.getScale(), GameInfo4.this.getScale(), GameInfo4.this.getScale());
/* 134 */       GlStateManager.func_179147_l();
/* 135 */       GlStateManager.func_179090_x();
/* 136 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/*     */       
/* 138 */       RenderUtils.originalRoundedRect(
/* 139 */           -5.0F, 
/* 140 */           1.0F, 125.0F, 91.0F, 
/* 141 */           6.4F, (new Color(((Number)GameInfo4.this.sr.get()).intValue(), ((Number)GameInfo4.this.sg.get()).intValue(), ((Number)GameInfo4.this.sb.get()).intValue(), ((Number)GameInfo4.this.sa.get()).intValue())).getRGB());
/* 142 */       GlStateManager.func_179098_w();
/* 143 */       GlStateManager.func_179084_k();
/* 144 */       GL11.glPopMatrix();
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
/*     */     GameInfo4$drawElement$2() {
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
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class GameInfo4$drawElement$3
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 187 */       GL11.glPushMatrix();
/* 188 */       GL11.glTranslated(GameInfo4.this.getRenderX(), GameInfo4.this.getRenderY(), 0.0D);
/* 189 */       GL11.glScalef(GameInfo4.this.getScale(), GameInfo4.this.getScale(), GameInfo4.this.getScale());
/* 190 */       RenderUtils.originalRoundedRect(
/* 191 */           -5.0F, 
/* 192 */           1.0F, 125.0F, 91.0F, 
/* 193 */           6.4F, (new Color(((Number)GameInfo4.this.sr.get()).intValue(), ((Number)GameInfo4.this.sg.get()).intValue(), ((Number)GameInfo4.this.sb.get()).intValue(), ((Number)GameInfo4.this.sa.get()).intValue())).getRGB());
/*     */ 
/*     */       
/* 196 */       GL11.glPopMatrix();
/*     */     } GameInfo4$drawElement$3() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class GameInfo4$drawElement$4 extends Lambda implements Function0<Unit> { public final void invoke() {
/* 199 */       GL11.glPushMatrix();
/* 200 */       GL11.glTranslated(GameInfo4.this.getRenderX(), GameInfo4.this.getRenderY(), 0.0D);
/* 201 */       GL11.glScalef(GameInfo4.this.getScale(), GameInfo4.this.getScale(), GameInfo4.this.getScale());
/* 202 */       GlStateManager.func_179147_l();
/* 203 */       GlStateManager.func_179090_x();
/* 204 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/*     */       
/* 206 */       RenderUtils.originalRoundedRect(
/* 207 */           -5.0F, 
/* 208 */           1.0F, 125.0F, 91.0F, 
/* 209 */           6.4F, (new Color(((Number)GameInfo4.this.sr.get()).intValue(), ((Number)GameInfo4.this.sg.get()).intValue(), ((Number)GameInfo4.this.sb.get()).intValue(), ((Number)GameInfo4.this.sa.get()).intValue())).getRGB());
/* 210 */       GlStateManager.func_179098_w();
/* 211 */       GlStateManager.func_179084_k();
/* 212 */       GL11.glPopMatrix();
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
/*     */     GameInfo4$drawElement$4() {
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
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class GameInfo4$drawElement$5
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 263 */       GL11.glPushMatrix();
/* 264 */       GL11.glTranslated(GameInfo4.this.getRenderX(), GameInfo4.this.getRenderY(), 0.0D);
/* 265 */       GL11.glScalef(GameInfo4.this.getScale(), GameInfo4.this.getScale(), GameInfo4.this.getScale());
/* 266 */       RenderUtils.originalRoundedRect(
/* 267 */           -5.0F, 
/* 268 */           1.0F, 125.0F, 91.0F, 
/* 269 */           6.4F, (new Color(((Number)GameInfo4.this.sr.get()).intValue(), ((Number)GameInfo4.this.sg.get()).intValue(), ((Number)GameInfo4.this.sb.get()).intValue(), ((Number)GameInfo4.this.sa.get()).intValue())).getRGB());
/*     */ 
/*     */       
/* 272 */       GL11.glPopMatrix();
/*     */     } GameInfo4$drawElement$5() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class GameInfo4$drawElement$6 extends Lambda implements Function0<Unit> { public final void invoke() {
/* 275 */       GL11.glPushMatrix();
/* 276 */       GL11.glTranslated(GameInfo4.this.getRenderX(), GameInfo4.this.getRenderY(), 0.0D);
/* 277 */       GL11.glScalef(GameInfo4.this.getScale(), GameInfo4.this.getScale(), GameInfo4.this.getScale());
/* 278 */       GlStateManager.func_179147_l();
/* 279 */       GlStateManager.func_179090_x();
/* 280 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/*     */       
/* 282 */       RenderUtils.originalRoundedRect(
/* 283 */           -5.0F, 
/* 284 */           1.0F, 125.0F, 91.0F, 
/* 285 */           6.4F, (new Color(((Number)GameInfo4.this.sr.get()).intValue(), ((Number)GameInfo4.this.sg.get()).intValue(), ((Number)GameInfo4.this.sb.get()).intValue(), ((Number)GameInfo4.this.sa.get()).intValue())).getRGB());
/* 286 */       GlStateManager.func_179098_w();
/* 287 */       GlStateManager.func_179084_k();
/* 288 */       GL11.glPopMatrix();
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
/*     */     GameInfo4$drawElement$6() {
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
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class GameInfo4$drawElement$7
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 336 */       GL11.glPushMatrix();
/* 337 */       GL11.glTranslated(GameInfo4.this.getRenderX(), GameInfo4.this.getRenderY(), 0.0D);
/* 338 */       GL11.glScalef(GameInfo4.this.getScale(), GameInfo4.this.getScale(), GameInfo4.this.getScale());
/* 339 */       RenderUtils.originalRoundedRect(
/* 340 */           -5.0F, 
/* 341 */           1.0F, 125.0F, 91.0F, 
/* 342 */           6.4F, (new Color(((Number)GameInfo4.this.sr.get()).intValue(), ((Number)GameInfo4.this.sg.get()).intValue(), ((Number)GameInfo4.this.sb.get()).intValue(), ((Number)GameInfo4.this.sa.get()).intValue())).getRGB());
/*     */ 
/*     */       
/* 345 */       GL11.glPopMatrix();
/*     */     } GameInfo4$drawElement$7() { super(0); }
/*     */   } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/* 348 */   static final class GameInfo4$drawElement$8 extends Lambda implements Function0<Unit> { GameInfo4$drawElement$8() { super(0); } public final void invoke() { GL11.glPushMatrix();
/* 349 */       GL11.glTranslated(GameInfo4.this.getRenderX(), GameInfo4.this.getRenderY(), 0.0D);
/* 350 */       GL11.glScalef(GameInfo4.this.getScale(), GameInfo4.this.getScale(), GameInfo4.this.getScale());
/* 351 */       GlStateManager.func_179147_l();
/* 352 */       GlStateManager.func_179090_x();
/* 353 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/*     */       
/* 355 */       RenderUtils.originalRoundedRect(
/* 356 */           -5.0F, 
/* 357 */           1.0F, 125.0F, 91.0F, 
/* 358 */           6.4F, (new Color(((Number)GameInfo4.this.sr.get()).intValue(), ((Number)GameInfo4.this.sg.get()).intValue(), ((Number)GameInfo4.this.sb.get()).intValue(), ((Number)GameInfo4.this.sa.get()).intValue())).getRGB());
/* 359 */       GlStateManager.func_179098_w();
/* 360 */       GlStateManager.func_179084_k();
/* 361 */       GL11.glPopMatrix(); } } @NotNull public Border drawElement() { IFontRenderer fontRenderer = (IFontRenderer)this.fontValue.get(); SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss"); Fonts.icon50.drawString("B", 0.0F, fontRenderer.getFontHeight() * 1.5F + 8.0F, (new Color(255, 255, 255, 255)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawString("Time:" + DATE_FORMAT.format(new Date(System.currentTimeMillis() - Recorder.INSTANCE.getStartTime() - 28800000L)), 20.0F, fontRenderer.getFontHeight() * 1.5F + 8.0F, Color.WHITE.getRGB()); Fonts.icon50.drawString("F", 0.0F, fontRenderer.getFontHeight() * 3.0F + 8.0F, (new Color(255, 255, 255, 255)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawString("Banner:" + Recorder.INSTANCE.getBan(), 20.0F, fontRenderer.getFontHeight() * 3.0F + 8.0F, Color.WHITE.getRGB()); Fonts.icon50.drawString("D", 0.0F, fontRenderer.getFontHeight() * 4.5F + 8.0F, (new Color(255, 255, 255, 255)).getRGB()); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawString("Health:" + MinecraftInstance.mc.getThePlayer().getHealth(), 20.0F, fontRenderer.getFontHeight() * 4.5F + 8.0F, Color.WHITE.getRGB()); Fonts.icon50.drawString("C", 0.0F, fontRenderer.getFontHeight() * 6.0F + 8.0F, (new Color(255, 255, 255, 255)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawString("Speed:" + calculateBPS(), 20.0F, fontRenderer.getFontHeight() * 6.0F + 8.0F, Color.WHITE.getRGB()); Fonts.icon50.drawString("E", 0.0F, fontRenderer.getFontHeight() * 7.5F + 8.0F, (new Color(255, 255, 255, 255)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawString("FPS:" + Minecraft.func_175610_ah(), 20.0F, fontRenderer.getFontHeight() * 7.5F + 8.0F, Color.WHITE.getRGB()); if (((Boolean)this.bV.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glPushMatrix(); BlurBuffer.CustomBlurRoundArea((float)getRenderX() - 5, (float)getRenderY() + true, 130.0F, 91.0F, 6.4F, 10.0F); GL11.glPopMatrix(); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  if (((String)this.OutmodeValue.get()).equals("Outline1")) { RoundedUtil.drawRound(-5.0F, 1.0F, 130.0F, 91.0F, 6.4F, new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue())); if (((Boolean)this.Outline.get()).booleanValue()) ScaleUtils.drawOutline(0.0F, 0.0F, 120.0F, 80.0F, 6.4F, ((Number)AColorPalette.Companion.getLine().get()).floatValue(), 3.0F);  float floatX = (float)getRenderX(); float floatY = (float)getRenderY(); IFontRenderer iFontRenderer = (IFontRenderer)this.fontValue.get(); float y2 = (iFontRenderer.getFontHeight() * 5) + 35.0F + 3.0F; float x2 = 120.0F; SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss"); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold40.drawCenteredString("Session", x2 / 2.0F, 5.0F, Color.WHITE.getRGB()); Fonts.icon50.drawString("B", 0.0F, iFontRenderer.getFontHeight() * 1.5F + 8.0F, (new Color(255, 255, 255, 255)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); iFontRenderer.drawString("Time:" + simpleDateFormat.format(new Date(System.currentTimeMillis() - Recorder.INSTANCE.getStartTime() - 28800000L)), 20.0F, iFontRenderer.getFontHeight() * 1.5F + 8.0F, Color.WHITE.getRGB()); Fonts.icon50.drawString("F", 0.0F, iFontRenderer.getFontHeight() * 3.0F + 8.0F, (new Color(255, 255, 255, 255)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); iFontRenderer.drawString("Banner:" + Recorder.INSTANCE.getBan(), 20.0F, iFontRenderer.getFontHeight() * 3.0F + 8.0F, Color.WHITE.getRGB()); Fonts.icon50.drawString("D", 0.0F, iFontRenderer.getFontHeight() * 4.5F + 8.0F, (new Color(255, 255, 255, 255)).getRGB()); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); iFontRenderer.drawString("Health:" + MinecraftInstance.mc.getThePlayer().getHealth(), 20.0F, iFontRenderer.getFontHeight() * 4.5F + 8.0F, Color.WHITE.getRGB()); Fonts.icon50.drawString("C", 0.0F, iFontRenderer.getFontHeight() * 6.0F + 8.0F, (new Color(255, 255, 255, 255)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); iFontRenderer.drawString("Speed:" + calculateBPS(), 20.0F, iFontRenderer.getFontHeight() * 6.0F + 8.0F, Color.WHITE.getRGB()); Fonts.icon50.drawString("E", 0.0F, iFontRenderer.getFontHeight() * 7.5F + 8.0F, (new Color(255, 255, 255, 255)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); iFontRenderer.drawString("FPS:" + Minecraft.func_175610_ah(), 20.0F, iFontRenderer.getFontHeight() * 7.5F + 8.0F, Color.WHITE.getRGB()); }  if (((Boolean)this.shadow.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); ShadowUtils.shadow(8.0F, new GameInfo4$drawElement$1(), new GameInfo4$drawElement$2()); GL11.glPopMatrix(); GL11.glScalef(getScale(), getScale(), getScale()); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  if (((String)this.OutmodeValue.get()).equals("Outline2")) { RoundedUtil.drawRound(-5.0F, 1.0F, 130.0F, 91.0F, 6.4F, new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue())); if (((Boolean)this.Outline.get()).booleanValue()) ScaleUtils.drawGidentOutlinedRoundedRect3(-5.0D, 1.0D, 130.0D, 91.0D, 6.4D, ((Number)AColorPalette.Companion.getLine().get()).floatValue());  float floatX = (float)getRenderX(); float floatY = (float)getRenderY(); IFontRenderer iFontRenderer = (IFontRenderer)this.fontValue.get(); float y2 = (iFontRenderer.getFontHeight() * 5) + 35.0F + 3.0F; float x2 = 120.0F; SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss"); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold40.drawCenteredString("Session", x2 / 2.0F, 5.0F, Color.WHITE.getRGB()); Fonts.icon50.drawString("B", 0.0F, iFontRenderer.getFontHeight() * 1.5F + 8.0F, (new Color(255, 255, 255, 255)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); iFontRenderer.drawString("Time:" + simpleDateFormat.format(new Date(System.currentTimeMillis() - Recorder.INSTANCE.getStartTime() - 28800000L)), 20.0F, iFontRenderer.getFontHeight() * 1.5F + 8.0F, Color.WHITE.getRGB()); Fonts.icon50.drawString("F", 0.0F, iFontRenderer.getFontHeight() * 3.0F + 8.0F, (new Color(255, 255, 255, 255)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); iFontRenderer.drawString("Banner:" + Recorder.INSTANCE.getBan(), 20.0F, iFontRenderer.getFontHeight() * 3.0F + 8.0F, Color.WHITE.getRGB()); Fonts.icon50.drawString("D", 0.0F, iFontRenderer.getFontHeight() * 4.5F + 8.0F, (new Color(255, 255, 255, 255)).getRGB()); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); iFontRenderer.drawString("Health:" + MinecraftInstance.mc.getThePlayer().getHealth(), 20.0F, iFontRenderer.getFontHeight() * 4.5F + 8.0F, Color.WHITE.getRGB()); Fonts.icon50.drawString("C", 0.0F, iFontRenderer.getFontHeight() * 6.0F + 8.0F, (new Color(255, 255, 255, 255)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); iFontRenderer.drawString("Speed:" + calculateBPS(), 20.0F, iFontRenderer.getFontHeight() * 6.0F + 8.0F, Color.WHITE.getRGB()); Fonts.icon50.drawString("E", 0.0F, iFontRenderer.getFontHeight() * 7.5F + 8.0F, (new Color(255, 255, 255, 255)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); iFontRenderer.drawString("FPS:" + Minecraft.func_175610_ah(), 20.0F, iFontRenderer.getFontHeight() * 7.5F + 8.0F, Color.WHITE.getRGB()); }  if (((Boolean)this.shadow.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); ShadowUtils.shadow(8.0F, new GameInfo4$drawElement$3(), new GameInfo4$drawElement$4()); GL11.glPopMatrix(); GL11.glScalef(getScale(), getScale(), getScale()); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  if (((String)this.OutmodeValue.get()).equals("old")) { if (Retreat.INSTANCE.getModuleManager().getModule(PictureColor.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.PictureColor");  PictureColor color = (PictureColor)Retreat.INSTANCE.getModuleManager().getModule(PictureColor.class); if (Retreat.INSTANCE.getModuleManager().getModule(PictureColor2.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.PictureColor2");  PictureColor2 color2 = (PictureColor2)Retreat.INSTANCE.getModuleManager().getModule(PictureColor2.class); Color gradientColor1 = Color.WHITE; Color gradientColor2 = Color.WHITE; Color gradientColor3 = Color.WHITE; Color gradientColor4 = Color.WHITE; gradientColor1 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(10, 20, new Color(((Number)color.getColorRedValue().get()).intValue(), ((Number)color.getColorGreenValue().get()).intValue(), ((Number)color.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false); gradientColor2 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 90, new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false); gradientColor3 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 270, new Color(((Number)color.getColorRedValue().get()).intValue(), ((Number)color.getColorGreenValue().get()).intValue(), ((Number)color.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color.getColorRedValue().get()).intValue(), ((Number)color.getColorGreenValue().get()).intValue(), ((Number)color.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false); gradientColor4 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 270, new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false); RoundedUtil.drawGradientRound(-5.0F, 1.0F, 130.0F, 91.0F, ((Number)AColorPalette.Companion.getRa().get()).floatValue(), gradientColor1, gradientColor3, gradientColor2, gradientColor1); float floatX = (float)getRenderX(); float floatY = (float)getRenderY(); IFontRenderer iFontRenderer = (IFontRenderer)this.fontValue.get(); float y2 = (iFontRenderer.getFontHeight() * 5) + 35.0F + 3.0F; float x2 = 120.0F; SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss"); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold40.drawCenteredString("Session", x2 / 2.0F, 5.0F, Color.WHITE.getRGB()); Fonts.icon50.drawString("B", 0.0F, iFontRenderer.getFontHeight() * 1.5F + 8.0F, (new Color(255, 255, 255, 255)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); iFontRenderer.drawString("Time:" + simpleDateFormat.format(new Date(System.currentTimeMillis() - Recorder.INSTANCE.getStartTime() - 28800000L)), 20.0F, iFontRenderer.getFontHeight() * 1.5F + 8.0F, Color.WHITE.getRGB()); Fonts.icon50.drawString("F", 0.0F, iFontRenderer.getFontHeight() * 3.0F + 8.0F, (new Color(255, 255, 255, 255)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); iFontRenderer.drawString("Banner:" + Recorder.INSTANCE.getBan(), 20.0F, iFontRenderer.getFontHeight() * 3.0F + 8.0F, Color.WHITE.getRGB()); Fonts.icon50.drawString("D", 0.0F, iFontRenderer.getFontHeight() * 4.5F + 8.0F, (new Color(255, 255, 255, 255)).getRGB()); if (MinecraftInstance.mc.getThePlayer() == null)
/*     */         Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); iFontRenderer.drawString("Health:" + MinecraftInstance.mc.getThePlayer().getHealth(), 20.0F, iFontRenderer.getFontHeight() * 4.5F + 8.0F, Color.WHITE.getRGB()); Fonts.icon50.drawString("C", 0.0F, iFontRenderer.getFontHeight() * 6.0F + 8.0F, (new Color(255, 255, 255, 255)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); iFontRenderer.drawString("Speed:" + calculateBPS(), 20.0F, iFontRenderer.getFontHeight() * 6.0F + 8.0F, Color.WHITE.getRGB()); Fonts.icon50.drawString("E", 0.0F, iFontRenderer.getFontHeight() * 7.5F + 8.0F, (new Color(255, 255, 255, 255)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); iFontRenderer.drawString("FPS:" + Minecraft.func_175610_ah(), 20.0F, iFontRenderer.getFontHeight() * 7.5F + 8.0F, Color.WHITE.getRGB()); }  if (((Boolean)this.shadow.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); ShadowUtils.shadow(8.0F, new GameInfo4$drawElement$5(), new GameInfo4$drawElement$6()); GL11.glPopMatrix(); GL11.glScalef(getScale(), getScale(), getScale()); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  if (((String)this.OutmodeValue.get()).equals("more")) { Color gradientColor1 = new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue(), ((Number)AColorPalette.a.get()).intValue()); Color gradientColor2 = new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue(), ((Number)AColorPalette.a.get()).intValue()); Color gradientColor3 = new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), ((Number)AColorPalette.Companion.getA2().get()).intValue()); Color gradientColor4 = new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), ((Number)AColorPalette.Companion.getA2().get()).intValue()); RoundedUtil.drawGradientRound(-5.0F, 1.0F, 130.0F, 91.0F, ((Number)AColorPalette.Companion.getRa().get()).floatValue(), ColorUtil.applyOpacity(gradientColor4, 0.85F), gradientColor1, gradientColor3, gradientColor2); float floatX = (float)getRenderX(); float floatY = (float)getRenderY(); IFontRenderer iFontRenderer = (IFontRenderer)this.fontValue.get(); float y2 = (iFontRenderer.getFontHeight() * 5) + 35.0F + 3.0F; float x2 = 120.0F; SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss"); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold40.drawCenteredString("Session", x2 / 2.0F, 5.0F, Color.WHITE.getRGB()); Fonts.icon50.drawString("B", 0.0F, iFontRenderer.getFontHeight() * 1.5F + 8.0F, (new Color(255, 255, 255, 255)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); iFontRenderer.drawString("Time:" + simpleDateFormat.format(new Date(System.currentTimeMillis() - Recorder.INSTANCE.getStartTime() - 28800000L)), 20.0F, iFontRenderer.getFontHeight() * 1.5F + 8.0F, Color.WHITE.getRGB()); Fonts.icon50.drawString("F", 0.0F, iFontRenderer.getFontHeight() * 3.0F + 8.0F, (new Color(255, 255, 255, 255)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); iFontRenderer.drawString("Banner:" + Recorder.INSTANCE.getBan(), 20.0F, iFontRenderer.getFontHeight() * 3.0F + 8.0F, Color.WHITE.getRGB()); Fonts.icon50.drawString("D", 0.0F, iFontRenderer.getFontHeight() * 4.5F + 8.0F, (new Color(255, 255, 255, 255)).getRGB()); if (MinecraftInstance.mc.getThePlayer() == null)
/* 363 */         Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); iFontRenderer.drawString("Health:" + MinecraftInstance.mc.getThePlayer().getHealth(), 20.0F, iFontRenderer.getFontHeight() * 4.5F + 8.0F, Color.WHITE.getRGB()); Fonts.icon50.drawString("C", 0.0F, iFontRenderer.getFontHeight() * 6.0F + 8.0F, (new Color(255, 255, 255, 255)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); iFontRenderer.drawString("Speed:" + calculateBPS(), 20.0F, iFontRenderer.getFontHeight() * 6.0F + 8.0F, Color.WHITE.getRGB()); Fonts.icon50.drawString("E", 0.0F, iFontRenderer.getFontHeight() * 7.5F + 8.0F, (new Color(255, 255, 255, 255)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); iFontRenderer.drawString("FPS:" + Minecraft.func_175610_ah(), 20.0F, iFontRenderer.getFontHeight() * 7.5F + 8.0F, Color.WHITE.getRGB()); }  if (((Boolean)this.shadow.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); ShadowUtils.shadow(8.0F, new GameInfo4$drawElement$7(), new GameInfo4$drawElement$8()); GL11.glPopMatrix();
/* 364 */       GL11.glScalef(getScale(), getScale(), getScale());
/* 365 */       GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 370 */     return new Border(0.0F, 0.0F, 120.0F, 85.0F); }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public final FontValue getFontValue() {
/*     */     return this.fontValue;
/*     */   }
/*     */   
/*     */   private final double calculateBPS() {
/*     */     if (MinecraftInstance.mc.getThePlayer() == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     if (MinecraftInstance.mc.getThePlayer() == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     double d1 = MinecraftInstance.mc.getThePlayer().getPosX() - MinecraftInstance.mc.getThePlayer().getPrevPosX();
/*     */     if (MinecraftInstance.mc.getThePlayer() == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     if (MinecraftInstance.mc.getThePlayer() == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     double d2 = MinecraftInstance.mc.getThePlayer().getPosZ() - MinecraftInstance.mc.getThePlayer().getPrevPosZ();
/*     */     boolean bool = false;
/*     */     double bps = Math.hypot(d1, d2) * MinecraftInstance.mc.getTimer().getTimerSpeed() * 20;
/*     */     return MathKt.roundToLong(bps * 100.0D) / 100.0D;
/*     */   }
/*     */   
/*     */   public GameInfo4() {
/*     */     this(0.0D, 0.0D, 0.0F, (Side)null, 15, (DefaultConstructorMarker)null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\GameInfo4.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */