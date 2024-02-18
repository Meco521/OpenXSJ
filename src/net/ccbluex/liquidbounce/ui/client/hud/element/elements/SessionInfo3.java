/*    */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.text.SimpleDateFormat;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IFontRenderer;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.AColorPalette;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.Side;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.FontValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ElementInfo(name = "SessionInfo3")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000D\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\007\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B-\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006\022\b\b\002\020\007\032\0020\b¢\006\002\020\tJ\n\020\031\032\004\030\0010\032H\026R\016\020\n\032\0020\013X\004¢\006\002\n\000R\016\020\f\032\0020\013X\004¢\006\002\n\000R\016\020\r\032\0020\013X\004¢\006\002\n\000R\016\020\016\032\0020\013X\004¢\006\002\n\000R\021\020\017\032\0020\020¢\006\b\n\000\032\004\b\021\020\022R\021\020\023\032\0020\024¢\006\b\n\000\032\004\b\025\020\026R\016\020\027\032\0020\030X\004¢\006\002\n\000¨\006\033"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/SessionInfo3;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "scale", "", "side", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;", "(DDFLnet/ccbluex/liquidbounce/ui/client/hud/element/Side;)V", "bgalphaValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "bgblueValue", "bggreenValue", "bgredValue", "fontValue", "Lnet/ccbluex/liquidbounce/value/FontValue;", "getFontValue", "()Lnet/ccbluex/liquidbounce/value/FontValue;", "lineValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "getLineValue", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "radiusValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "XSJClient"})
/*    */ public final class SessionInfo3 extends Element {
/*    */   private final FloatValue radiusValue;
/*    */   private final IntegerValue bgredValue;
/*    */   private final IntegerValue bggreenValue;
/*    */   
/* 24 */   public SessionInfo3(double x, double y, float scale, @NotNull Side side) { super(x, y, scale, side);
/* 25 */     this.radiusValue = new FloatValue("Radius", 4.25F, 0.0F, 10.0F);
/* 26 */     this.bgredValue = new IntegerValue("Bg-R", 255, 0, 255);
/* 27 */     this.bggreenValue = new IntegerValue("Bg-G", 255, 0, 255);
/* 28 */     this.bgblueValue = new IntegerValue("Bg-B", 255, 0, 255);
/* 29 */     this.bgalphaValue = new IntegerValue("Bg-Alpha", 150, 0, 255);
/*    */     
/* 31 */     this.lineValue = new BoolValue("Line", true);
/*    */ 
/*    */     
/* 34 */     Intrinsics.checkExpressionValueIsNotNull(Fonts.font35, "Fonts.font35"); this.fontValue = new FontValue("Font", Fonts.font35); } private final IntegerValue bgblueValue; private final IntegerValue bgalphaValue; @NotNull private final BoolValue lineValue; @NotNull private final FontValue fontValue; @NotNull public final BoolValue getLineValue() { return this.lineValue; } @NotNull public final FontValue getFontValue() { return this.fontValue; }
/*    */    @Nullable
/*    */   public Border drawElement() {
/* 37 */     IFontRenderer fontRenderer = (IFontRenderer)this.fontValue.get();
/*    */     
/* 39 */     double y2 = (fontRenderer.getFontHeight() * 5) + 11.0D;
/* 40 */     double x2 = 140.0D;
/*    */ 
/*    */ 
/*    */     
/* 44 */     SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
/*    */     
/* 46 */     RenderUtils.drawRoundedRect(-2.0F, -2.0F, (float)x2, (float)y2, ((Number)this.radiusValue.get()).floatValue(), (new Color(((Number)this.bgredValue.get()).intValue(), ((Number)this.bggreenValue.get()).intValue(), ((Number)this.bgblueValue.get()).intValue(), ((Number)this.bgalphaValue.get()).intValue())).getRGB());
/*    */ 
/*    */     
/* 49 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); RenderUtils.drawOutlinedRoundedRect(-2.0D, -2.0D, (float)x2, (float)y2, ((Number)this.radiusValue.get()).floatValue(), 1.0F, Color.WHITE.getRGB());
/* 50 */     if (((Boolean)this.lineValue.get()).booleanValue()) {
/*    */       
/* 52 */       if (Retreat.INSTANCE.getModuleManager().getModule(AColorPalette.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.AColorPalette");  AColorPalette hud = (AColorPalette)Retreat.INSTANCE.getModuleManager().getModule(AColorPalette.class);
/* 53 */       RenderUtils.drawGradientSideways(
/* 54 */           2.44D, 
/* 55 */           fontRenderer.getFontHeight() + 2.5D + 0.0D, 
/* 56 */           135.55999994277954D, 
/* 57 */           fontRenderer.getFontHeight() + 2.5D + 1.16F, (
/* 58 */           new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue())).getRGB());
/*    */     } 
/*    */     
/* 61 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  String username = MinecraftInstance.mc.getThePlayer().getName();
/* 62 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawCenteredString("SessionInfo", (float)x2 / 2.0F, 3.0F, Color.WHITE.getRGB(), true);
/* 63 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawStringWithShadow("Play Time: " + DATE_FORMAT.format(new Date(System.currentTimeMillis() - Recorder.INSTANCE.getStartTime() - 28800000L)), 2, (int)(fontRenderer.getFontHeight() + 8.0F), Color.WHITE.getRGB());
/*    */     
/* 65 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawStringWithShadow("World FPS:" + Minecraft.func_175610_ah(), 2, (int)((fontRenderer.getFontHeight() * 2) + 8.0F), Color.WHITE.getRGB());
/*    */     
/* 67 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawStringWithShadow("Current ID： " + username + ' ', 2, (int)((fontRenderer.getFontHeight() * 4) + 8.0F), Color.WHITE.getRGB());
/*    */     
/* 69 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawStringWithShadow("Play Kill:" + Recorder.INSTANCE.getKillCounts(), 2, (int)((fontRenderer.getFontHeight() * 3) + 8.0F), Color.WHITE.getRGB());
/* 70 */     return new Border(-2.0F, -2.0F, (float)x2, (float)y2);
/*    */   }
/*    */   
/*    */   public SessionInfo3() {
/*    */     this(0.0D, 0.0D, 0.0F, null, 15, null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\SessionInfo3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */