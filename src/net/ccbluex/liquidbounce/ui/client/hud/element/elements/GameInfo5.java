/*    */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.util.Arrays;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IFontRenderer;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.AColorPalette;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.Side;
/*    */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ElementInfo(name = "GameInfo5", disableScale = true, priority = 1)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000N\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\007\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\b\n\002\b\006\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B-\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006\022\b\b\002\020\007\032\0020\b¢\006\002\020\tJ\b\020\030\032\0020\031H\026J\020\020\032\032\0020\0332\006\020\034\032\0020\035H\003R\016\020\n\032\0020\013X\004¢\006\002\n\000R\016\020\f\032\0020\rX\004¢\006\002\n\000R\016\020\016\032\0020\013X\004¢\006\002\n\000R\016\020\017\032\0020\020X\004¢\006\002\n\000R\032\020\021\032\0020\022X\016¢\006\016\n\000\032\004\b\023\020\024\"\004\b\025\020\026R\016\020\027\032\0020\013X\004¢\006\002\n\000¨\006\036"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/GameInfo5;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "scale", "", "side", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;", "(DDFLnet/ccbluex/liquidbounce/ui/client/hud/element/Side;)V", "blueValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "fontValue", "Lnet/ccbluex/liquidbounce/value/FontValue;", "greenValue", "lineValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "playerbans", "", "getPlayerbans", "()I", "setPlayerbans", "(I)V", "redValue", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "onPacket", "", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "XSJClient"})
/*    */ public final class GameInfo5 extends Element {
/*    */   private final BoolValue lineValue;
/*    */   private final IntegerValue redValue;
/*    */   private final IntegerValue greenValue;
/*    */   
/* 23 */   public GameInfo5(double x, double y, float scale, @NotNull Side side) { super(x, y, scale, side);
/*    */     
/* 25 */     this.lineValue = new BoolValue("Line", true);
/* 26 */     this.redValue = new IntegerValue("Line-Red-1", 255, 0, 255);
/* 27 */     this.greenValue = new IntegerValue("Line-Green-1", 255, 0, 255);
/* 28 */     this.blueValue = new IntegerValue("Line-Blue-1", 255, 0, 255);
/*    */     
/* 30 */     Intrinsics.checkExpressionValueIsNotNull(Fonts.tenacitybold35, "Fonts.tenacitybold35"); this.fontValue = new FontValue("Font", Fonts.tenacitybold35); } private final IntegerValue blueValue; private final FontValue fontValue; private int playerbans; public final int getPlayerbans() {
/* 31 */     return this.playerbans; } public final void setPlayerbans(int <set-?>) { this.playerbans = <set-?>; } @NotNull
/*    */   public Border drawElement() {
/* 33 */     IFontRenderer fontRenderer = (IFontRenderer)this.fontValue.get();
/*    */     
/* 35 */     double y2 = (fontRenderer.getFontHeight() * 3) + 11.0D;
/* 36 */     double x2 = 140.0D;
/* 37 */     int playerbans = 0;
/* 38 */     long durationInMillis = System.currentTimeMillis() - Recorder.INSTANCE.getStartTime();
/* 39 */     long second = durationInMillis / 1000L % 60L;
/* 40 */     long minute = durationInMillis / 60000L % 60L;
/* 41 */     long hour = durationInMillis / 3600000L % 24L;
/* 42 */     String time = null;
/* 43 */     StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE; String str1 = "%02dh %02dm %02ds"; Object[] arrayOfObject = { Long.valueOf(hour), Long.valueOf(minute), Long.valueOf(second) }; boolean bool = false; Intrinsics.checkExpressionValueIsNotNull(String.format(str1, Arrays.copyOf(arrayOfObject, arrayOfObject.length)), "java.lang.String.format(format, *args)"); time = String.format(str1, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
/*    */     
/* 45 */     if (((Boolean)this.lineValue.get()).booleanValue()) {
/* 46 */       RenderUtils.drawGradientSideways(
/* 47 */           2.44D, 
/* 48 */           fontRenderer.getFontHeight() + 2.5D + 0.0D, 
/* 49 */           135.56D, 
/* 50 */           fontRenderer.getFontHeight() + 2.5D + 1.16D, (
/* 51 */           new Color(((Number)this.redValue.get()).intValue(), ((Number)this.greenValue.get()).intValue(), ((Number)this.blueValue.get()).intValue())).getRGB(), (
/* 52 */           new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue())).getRGB());
/*    */     }
/*    */     
/* 55 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  String username = MinecraftInstance.mc.getThePlayer().getName();
/* 56 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawStringWithShadow("Session Information", (int)((float)x2 / 5.0F), 3, Color.WHITE.getRGB());
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 61 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawStringWithShadow("Play Time: " + time, 2, (int)(fontRenderer.getFontHeight() + 8.0F), Color.WHITE.getRGB());
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 67 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawStringWithShadow("Current ID: " + username, 2, (int)((fontRenderer.getFontHeight() * 2) + 8.0F), Color.WHITE.getRGB());
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 73 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawStringWithShadow("OtherplayerBanned: " + playerbans, 2, (int)((fontRenderer.getFontHeight() * 3) + 8.0F), Color.WHITE.getRGB());
/*    */     
/* 75 */     return new Border(-2.0F, -2.0F, (float)x2, (float)y2);
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   private final void onPacket(PacketEvent event) {
/* 80 */     if (event.getPacket() instanceof net.minecraft.network.handshake.client.C00Handshake) Recorder.INSTANCE.setStartTime(System.currentTimeMillis()); 
/*    */   }
/*    */   
/*    */   public GameInfo5() {
/*    */     this(0.0D, 0.0D, 0.0F, null, 15, null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\GameInfo5.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */