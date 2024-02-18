/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ import java.awt.Color;
/*     */ import java.text.SimpleDateFormat;
/*     */ import kotlin.Unit;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.player.AutoL;
/*     */ import net.ccbluex.liquidbounce.ui.client.hud.element.Side;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ElementInfo(name = "SessionInfo")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000B\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\007\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\030\002\n\000\b\007\030\0002\0020\001B-\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006\022\b\b\002\020\007\032\0020\b¢\006\002\020\tJ\b\020\027\032\0020\030H\026R\016\020\n\032\0020\013X\004¢\006\002\n\000R\016\020\f\032\0020\rX\004¢\006\002\n\000R\016\020\016\032\0020\017X\004¢\006\002\n\000R\016\020\020\032\0020\013X\004¢\006\002\n\000R\016\020\021\032\0020\022X\004¢\006\002\n\000R\016\020\023\032\0020\013X\004¢\006\002\n\000R\021\020\024\032\0020\r¢\006\b\n\000\032\004\b\025\020\026¨\006\031"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/SessionInfo;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "scale", "", "side", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;", "(DDFLnet/ccbluex/liquidbounce/ui/client/hud/element/Side;)V", "BlurStrength", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "bV", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "bgValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "radiusValue", "shadowColorMode", "Lnet/ccbluex/liquidbounce/value/ListValue;", "shadowValue", "shadowValueopen", "getShadowValueopen", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "XSJClient"})
/*     */ public final class SessionInfo extends Element {
/*     */   public SessionInfo(double x, double y, float scale, @NotNull Side side) {
/*  21 */     super(x, y, scale, side);
/*  22 */     this.bV = new BoolValue("Blur", true);
/*  23 */     this.BlurStrength = new FloatValue("BlurStrength", 5.0F, 0.0F, 20.0F);
/*  24 */     this.shadowValueopen = new BoolValue("shadow", true);
/*  25 */     this.shadowValue = new FloatValue("shadow-Value", 10.0F, 0.0F, 20.0F);
/*  26 */     this.shadowColorMode = new ListValue("Shadow-Color", new String[] { "Background", "Custom" }, "Background");
/*  27 */     this.bgValue = new IntegerValue("Background-Alpha", 120, 0, 255);
/*  28 */     this.radiusValue = new FloatValue("Radius", 4.25F, 0.0F, 10.0F);
/*     */   }
/*     */   
/*     */   private final BoolValue bV;
/*     */   private final FloatValue BlurStrength;
/*     */   @NotNull
/*     */   private final BoolValue shadowValueopen;
/*     */   private final FloatValue shadowValue;
/*     */   private final ListValue shadowColorMode;
/*     */   private final IntegerValue bgValue;
/*     */   private final FloatValue radiusValue;
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class SessionInfo$drawElement$1
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/*  46 */       GL11.glPushMatrix();
/*  47 */       GL11.glTranslated(SessionInfo.this.getRenderX(), SessionInfo.this.getRenderY(), 0.0D);
/*  48 */       GL11.glScalef(SessionInfo.this.getScale(), SessionInfo.this.getScale(), SessionInfo.this.getScale());
/*     */       
/*  50 */       RenderUtils.originalRoundedRect(
/*  51 */           -5.0F, 1.0F, 125.0F, 51.0F, ((Number)SessionInfo.this.radiusValue.get()).floatValue(), 
/*  52 */           StringsKt.equals((String)SessionInfo.this.shadowColorMode.get(), "background", true) ? (
/*  53 */           new Color(32, 30, 30)).getRGB() : (
/*     */           
/*  55 */           new Color(0, 0, 0)).getRGB());
/*     */       
/*  57 */       GL11.glPopMatrix();
/*     */     } SessionInfo$drawElement$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*  59 */   static final class SessionInfo$drawElement$2 extends Lambda implements Function0<Unit> { public final void invoke() { GL11.glPushMatrix();
/*  60 */       GL11.glTranslated(SessionInfo.this.getRenderX(), SessionInfo.this.getRenderY(), 0.0D);
/*  61 */       GL11.glScalef(SessionInfo.this.getScale(), SessionInfo.this.getScale(), SessionInfo.this.getScale());
/*  62 */       GlStateManager.func_179147_l();
/*  63 */       GlStateManager.func_179090_x();
/*  64 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/*  65 */       RenderUtils.fastRoundedRect(-5.0F, 1.0F, 125.0F, 51.0F, ((Number)SessionInfo.this.radiusValue.get()).floatValue());
/*  66 */       GlStateManager.func_179098_w();
/*  67 */       GlStateManager.func_179084_k();
/*  68 */       GL11.glPopMatrix(); } SessionInfo$drawElement$2() { super(0); } }
/*     */    @NotNull public Border drawElement() { RenderUtils.drawRoundedRect(-5.0F, 1.0F, 125.0F, 51.0F, ((Number)this.radiusValue.get()).floatValue(), (new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue())).getRGB()); GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix();
/*     */     if (((Boolean)this.shadowValueopen.get()).booleanValue())
/*     */       ShadowUtils.shadow(((Number)this.shadowValue.get()).floatValue(), new SessionInfo$drawElement$1(), new SessionInfo$drawElement$2()); 
/*  72 */     GL11.glPopMatrix();
/*  73 */     GL11.glScalef(getScale(), getScale(), getScale());
/*  74 */     GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */     
/*  76 */     if (((Boolean)this.bV.get()).booleanValue()) {
/*  77 */       GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D);
/*  78 */       GL11.glPushMatrix();
/*  79 */       BlurBuffer.CustomBlurRoundArea(
/*  80 */           (float)getRenderX() - 5, 
/*  81 */           (float)getRenderY() + true, 
/*  82 */           130.0F, 
/*  83 */           51.0F, (
/*  84 */           (Number)this.radiusValue.get()).floatValue(), ((Number)this.BlurStrength.get()).floatValue());
/*     */       
/*  86 */       GL11.glPopMatrix();
/*  87 */       GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */     } 
/*  89 */     float x2 = 120.0F;
/*  90 */     if (Retreat.INSTANCE.getModuleManager().getModule(AutoL.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.player.AutoL");  AutoL autoL = (AutoL)Retreat.INSTANCE.getModuleManager().getModule(AutoL.class);
/*     */     
/*  92 */     SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
/*  93 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.posterama40.drawCenteredString("Session", x2 / 2.0F, 5.0F, Color.WHITE.getRGB());
/*  94 */     Fonts.icon50.drawString("B", 0.0F, Fonts.posterama30.getFontHeight() * 1.5F + 8.0F, (new Color(255, 255, 255, 255)).getRGB());
/*  95 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.posterama30.drawString("Time:" + DATE_FORMAT.format(new Date(System.currentTimeMillis() - Recorder.INSTANCE.getStartTime() - 28800000L)), 20.0F, Fonts.posterama30.getFontHeight() * 1.5F + 8.0F, Color.WHITE.getRGB());
/*  96 */     Fonts.icon50.drawString("F", 0.0F, Fonts.posterama30.getFontHeight() * 3.0F + 8.0F, (new Color(255, 255, 255, 255)).getRGB());
/*  97 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.posterama30.drawString("Kill:" + String.valueOf(autoL.kills()), 20.0F, Fonts.posterama30.getFontHeight() * 3.0F + 8.0F, Color.WHITE.getRGB());
/*     */ 
/*     */     
/* 100 */     return new Border(-5.0F, 1.0F, 125.0F, 51.0F); }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public final BoolValue getShadowValueopen() {
/*     */     return this.shadowValueopen;
/*     */   }
/*     */   
/*     */   public SessionInfo() {
/*     */     this(0.0D, 0.0D, 0.0F, (Side)null, 15, (DefaultConstructorMarker)null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\SessionInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */