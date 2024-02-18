/*    */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.text.SimpleDateFormat;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IFontRenderer;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.player.AutoL;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.AColorPalette;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.HUD;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.Side;
/*    */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FontValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @ElementInfo(name = "SessionInfo4")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000J\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\007\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B-\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006\022\b\b\002\020\007\032\0020\b¢\006\002\020\tJ\b\020\033\032\0020\034H\026R\016\020\n\032\0020\013X\004¢\006\002\n\000R\016\020\f\032\0020\rX\004¢\006\002\n\000R\016\020\016\032\0020\rX\004¢\006\002\n\000R\016\020\017\032\0020\rX\004¢\006\002\n\000R\016\020\020\032\0020\rX\004¢\006\002\n\000R\016\020\021\032\0020\013X\004¢\006\002\n\000R\021\020\022\032\0020\023¢\006\b\n\000\032\004\b\024\020\025R\016\020\026\032\0020\027X\004¢\006\002\n\000R\016\020\030\032\0020\013X\004¢\006\002\n\000R\016\020\031\032\0020\032X\004¢\006\002\n\000¨\006\035"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/SessionInfo4;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "scale", "", "side", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;", "(DDFLnet/ccbluex/liquidbounce/ui/client/hud/element/Side;)V", "Shadow", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "bgalphaValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "bgblueValue", "bggreenValue", "bgredValue", "blur", "fontValue", "Lnet/ccbluex/liquidbounce/value/FontValue;", "getFontValue", "()Lnet/ccbluex/liquidbounce/value/FontValue;", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "outline", "radiusValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "XSJClient"})
/*    */ public final class SessionInfo4 extends Element {
/*    */   private final ListValue modeValue;
/*    */   private final BoolValue blur;
/*    */   private final BoolValue Shadow;
/*    */   private final FloatValue radiusValue;
/*    */   private final IntegerValue bgredValue;
/*    */   
/* 29 */   public SessionInfo4(double x, double y, float scale, @NotNull Side side) { super(x, y, scale, side);
/* 30 */     this.modeValue = new ListValue("Mode", new String[] { "Normal" }, "Normal");
/* 31 */     this.blur = new BoolValue("Blur", false);
/* 32 */     this.Shadow = new BoolValue("Normal-Shadow", true);
/* 33 */     this.radiusValue = new FloatValue("Normal-Radius", 0.0F, 0.0F, 10.0F);
/* 34 */     this.bgredValue = new IntegerValue("Normal-Bg-R", 0, 0, 255);
/* 35 */     this.bggreenValue = new IntegerValue("Normal-Bg-G", 0, 0, 255);
/* 36 */     this.bgblueValue = new IntegerValue("Normal-Bg-B", 0, 0, 255);
/* 37 */     this.bgalphaValue = new IntegerValue("Normal-Bg-Alpha", 0, 0, 255);
/* 38 */     this.outline = new BoolValue("Normal-Outline", false);
/* 39 */     Intrinsics.checkExpressionValueIsNotNull(Fonts.font40, "Fonts.font40"); this.fontValue = new FontValue("Font", Fonts.font40); } private final IntegerValue bggreenValue; private final IntegerValue bgblueValue; private final IntegerValue bgalphaValue; private final BoolValue outline; @NotNull private final FontValue fontValue; @NotNull public final FontValue getFontValue() { return this.fontValue; } @NotNull
/*    */   public Border drawElement() {
/* 41 */     String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case -1039745817:
/* 42 */         if (str.equals("normal")) {
/* 43 */           IFontRenderer fontRenderer = (IFontRenderer)this.fontValue.get();
/* 44 */           float y2 = (fontRenderer.getFontHeight() * 4) + 11.0F + 3.0F;
/* 45 */           float x2 = 120.0F;
/* 46 */           float floatX = (float)getRenderX();
/* 47 */           float floatY = (float)getRenderY();
/* 48 */           if (((Boolean)this.blur.get()).booleanValue()) {
/* 49 */             GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D);
/* 50 */             GL11.glPushMatrix();
/* 51 */             BlurBuffer.blurRoundArea(floatX, floatY, x2, y2, ((Number)this.radiusValue.get()).floatValue());
/* 52 */             GL11.glPopMatrix();
/* 53 */             GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*    */           } 
/* 55 */           if (((Boolean)this.Shadow.get()).booleanValue()) {
/* 56 */             RenderUtils.drawShadowWithCustomAlpha(0.0F, 0.0F, x2, y2, 255.0F);
/*    */           }
/* 58 */           if (Retreat.INSTANCE.getModuleManager().getModule(HUD.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.HUD");  HUD hud = (HUD)Retreat.INSTANCE.getModuleManager().getModule(HUD.class);
/* 59 */           RoundedUtil.drawRound(
/* 60 */               0.0F, 
/* 61 */               0.0F, 
/* 62 */               x2, 
/* 63 */               y2, (
/* 64 */               (Number)this.radiusValue.get()).floatValue(), 
/* 65 */               new Color(((Number)this.bgredValue.get()).intValue(), ((Number)this.bggreenValue.get()).intValue(), ((Number)this.bgblueValue.get()).intValue(), ((Number)this.bgalphaValue.get()).intValue()));
/*    */           
/* 67 */           RenderUtils.drawGradientSideways(
/* 68 */               2.22D, 
/* 69 */               fontRenderer.getFontHeight() + 2.5D + 0.0D - true, 
/* 70 */               x2 - 2.22D, 
/* 71 */               fontRenderer.getFontHeight() + 2.5D + 1.16F - true, (
/* 72 */               new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue())).getRGB(), (
/* 73 */               new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue())).getRGB());
/*    */ 
/*    */           
/* 76 */           Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.sfbold35.drawCenteredString("Session Info", x2 / 2.0F, 2.0F, Color.WHITE.getRGB(), true);
/* 77 */           if (((Boolean)this.outline.get()).booleanValue()) {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */             
/* 85 */             Intrinsics.checkExpressionValueIsNotNull(RenderUtils.getGradientOffset(
/* 86 */                   new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), 
/* 87 */                   new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue()), 
/* 88 */                   100.0D), "RenderUtils.getGradientO…                        )"); RenderUtils.rectangleBordered(0.0D, 0.0D, x2, y2, 0.55D, (new Color(0, 0, 0, 30)).getRGB(), RenderUtils.getGradientOffset(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue()), 100.0D).getRGB());
/*    */           } 
/*    */ 
/*    */           
/* 92 */           SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
/* 93 */           Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawString("Play Time: " + DATE_FORMAT.format(new Date(System.currentTimeMillis() - Recorder.INSTANCE.getStartTime() - 28800000L)), 2.0F, fontRenderer.getFontHeight() + 8.0F, Color.WHITE.getRGB(), true);
/* 94 */           if (Retreat.INSTANCE.getModuleManager().getModule(AutoL.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.player.AutoL");  AutoL autoL2 = (AutoL)Retreat.INSTANCE.getModuleManager().getModule(AutoL.class);
/* 95 */           Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawString("Play Kill: " + autoL2.kills(), 2.0F, fontRenderer.getFontHeight() * 2.0F + 8.0F, Color.WHITE.getRGB(), true);
/* 96 */           Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawString("World FPS:" + Minecraft.func_175610_ah(), 2.0F, fontRenderer.getFontHeight() * 3.0F + 8.0F, Color.WHITE.getRGB(), true);
/*    */         }  break; }
/*    */     
/* 99 */     return new Border(-2.0F, -2.0F, 120.0F, 50.0F);
/*    */   }
/*    */   
/*    */   public SessionInfo4() {
/*    */     this(0.0D, 0.0D, 0.0F, (Side)null, 15, (DefaultConstructorMarker)null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\SessionInfo4.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */