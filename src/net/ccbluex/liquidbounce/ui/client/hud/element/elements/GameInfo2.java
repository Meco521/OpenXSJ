/*    */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*    */ 
/*    */ import courage.utils.info.Recorder;
/*    */ import java.awt.Color;
/*    */ import java.text.SimpleDateFormat;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IFontRenderer;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.AColorPalette;
/*    */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*    */ import net.ccbluex.liquidbounce.value.FontValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ElementInfo(name = "GameInfo2")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0006\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\007\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\b\007\030\0002\0020\001B#\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006¢\006\002\020\007J\b\020\021\032\0020\022H\026R\021\020\b\032\0020\t¢\006\b\n\000\032\004\b\n\020\013R\016\020\f\032\0020\rX\004¢\006\002\n\000R\016\020\016\032\0020\017X\016¢\006\002\n\000R\016\020\020\032\0020\017X\016¢\006\002\n\000¨\006\023"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/GameInfo2;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "scale", "", "(DDF)V", "DATE_FORMAT", "Ljava/text/SimpleDateFormat;", "getDATE_FORMAT", "()Ljava/text/SimpleDateFormat;", "GameInfo", "Lnet/ccbluex/liquidbounce/value/ListValue;", "fontValue", "Lnet/ccbluex/liquidbounce/value/FontValue;", "fontValueBig", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "XSJClient"})
/*    */ public final class GameInfo2 extends Element {
/*    */   private final ListValue GameInfo;
/*    */   private FontValue fontValue;
/*    */   
/* 20 */   public GameInfo2(double x, double y, float scale) { super(x, y, scale, null, 8, null);
/* 21 */     this.GameInfo = new ListValue("Mode", new String[] { "Normal" }, "Normal");
/* 22 */     Intrinsics.checkExpressionValueIsNotNull(Fonts.productSans35, "Fonts.productSans35"); this.fontValue = new FontValue("Font", Fonts.productSans35);
/* 23 */     Intrinsics.checkExpressionValueIsNotNull(Fonts.font40, "Fonts.font40"); this.fontValueBig = new FontValue("TitleFont", Fonts.font40);
/* 24 */     this.DATE_FORMAT = new SimpleDateFormat("HH:mm:ss"); } private FontValue fontValueBig; @NotNull private final SimpleDateFormat DATE_FORMAT; @NotNull public final SimpleDateFormat getDATE_FORMAT() { return this.DATE_FORMAT; } @NotNull
/*    */   public Border drawElement() {
/* 26 */     Color gradientColor1 = new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue(), ((Number)AColorPalette.a.get()).intValue());
/* 27 */     Color gradientColor2 = new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue(), ((Number)AColorPalette.a.get()).intValue());
/* 28 */     Color gradientColor3 = new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), ((Number)AColorPalette.Companion.getA2().get()).intValue());
/* 29 */     Color gradientColor4 = new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), ((Number)AColorPalette.Companion.getA2().get()).intValue());
/* 30 */     IFontRenderer fontRenderer = (IFontRenderer)this.fontValue.get();
/* 31 */     int y2 = fontRenderer.getFontHeight() * 5 + (int)11.0D;
/* 32 */     int x2 = (int)140.0D;
/* 33 */     if (StringsKt.equals((String)this.GameInfo.get(), "normal", true)) {
/*    */       
/* 35 */       RoundedUtil.drawGradientRound(-2.0F, -2.0F, x2, y2, ((Number)AColorPalette.Companion.getRa().get()).floatValue(), ColorUtil.applyOpacity(gradientColor4, 0.85F), gradientColor1, gradientColor3, gradientColor2);
/*    */       
/* 37 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); ((IFontRenderer)this.fontValueBig.get()).drawCenteredString("Session Info", 31.5F, 3.0F, Color.WHITE.getRGB(), true);
/* 38 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawStringWithShadow("Play Time: " + this.DATE_FORMAT.format(new Date(System.currentTimeMillis() - Recorder.INSTANCE.getStartTime() - 28800000L)), 2, (int)(fontRenderer.getFontHeight() + 8.0F), Color.WHITE.getRGB());
/* 39 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawStringWithShadow("Players Killed: " + KillAura.Companion.getKillCounts(), 2, (int)((fontRenderer.getFontHeight() * 2) + 8.0F), Color.WHITE.getRGB());
/*    */       
/* 41 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawStringWithShadow("Win: " + Recorder.INSTANCE.getWin(), 2, (int)((fontRenderer.getFontHeight() * 3) + 8.0F), Color.WHITE.getRGB());
/*    */       
/* 43 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawStringWithShadow("Total: " + Recorder.INSTANCE.getTotalPlayed(), 2, (int)((fontRenderer.getFontHeight() * 4) + 8.0F), Color.WHITE.getRGB());
/*    */     } 
/* 45 */     return new Border(-2.0F, -2.0F, x2, y2);
/*    */   }
/*    */   
/*    */   public GameInfo2() {
/*    */     this(0.0D, 0.0D, 0.0F, 7, null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\GameInfo2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */