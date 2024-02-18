/*    */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*    */ import courage.utils.info.Recorder;
/*    */ import java.awt.Color;
/*    */ import java.util.Arrays;
/*    */ import kotlin.jvm.internal.DefaultConstructorMarker;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.StringCompanionObject;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IFontRenderer;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @ElementInfo(name = "BanChecker")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000 \n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\007\n\002\b\003\n\002\030\002\n\000\b\007\030\0002\0020\001B#\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006¢\006\002\020\007J\b\020\b\032\0020\003H\002J\b\020\t\032\0020\nH\026¨\006\013"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/BanChecker;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "scale", "", "(DDF)V", "BPS", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "XSJClient"})
/*    */ public final class BanChecker extends Element {
/*    */   public BanChecker(double x, double y, float scale) {
/* 16 */     super(x, y, scale, null, 8, null);
/*    */   } @NotNull
/*    */   public Border drawElement() {
/* 19 */     IFontRenderer fontRenderer = Fonts.font30;
/* 20 */     int y2 = 70;
/* 21 */     int x2 = (int)120.0D;
/*    */     
/* 23 */     SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
/*    */     
/* 25 */     GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D);
/*    */     
/* 27 */     GL11.glScalef(1.0F, 1.0F, 1.0F);
/*    */     
/* 29 */     GL11.glPushMatrix();
/*    */     
/* 31 */     GL11.glPopMatrix();
/* 32 */     GL11.glScalef(getScale(), getScale(), getScale());
/* 33 */     GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*    */ 
/*    */     
/* 36 */     RenderUtils.drawRoundedRect(-2.0F, -2.0F, x2 - 2.0F, y2 - 1.0F, ((Number)CustomColor.radius.get()).floatValue(), (new Color(29, 41, 55, ((Number)CustomColor.a.get()).intValue())).getRGB());
/*    */     
/* 38 */     GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D);
/* 39 */     GL11.glPushMatrix();
/*    */     
/* 41 */     GL11.glPopMatrix();
/* 42 */     GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*    */     
/* 44 */     GL11.glTranslatef((float)-getRenderX(), (float)-getRenderY(), 0.0F);
/* 45 */     GL11.glPushMatrix();
/* 46 */     GL11.glPopMatrix();
/* 47 */     GL11.glTranslatef((float)getRenderX(), (float)getRenderY(), 0.0F);
/*    */ 
/*    */     
/* 50 */     int ty = 3;
/* 51 */     int ty1 = 20;
/* 52 */     int ty2 = fontRenderer.getFontHeight() + 25;
/* 53 */     int ty3 = fontRenderer.getFontHeight() * 2 + 30;
/* 54 */     int ty4 = fontRenderer.getFontHeight() * 3 + 35;
/* 55 */     float easingHealth = 0.0F;
/*    */ 
/*    */     
/* 58 */     Fonts.icon25.drawString("o", 3, ty, (new Color(19, 101, 150)).getRGB());
/*    */     
/* 60 */     fontRenderer.drawString("Ban Checker", 
/* 61 */         20, 
/* 62 */         2, (
/* 63 */         new Color(255, 255, 255)).getRGB());
/*    */ 
/*    */     
/* 66 */     StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE; String str1 = "Baned:" + Recorder.INSTANCE.getBan(); Object[] arrayOfObject = new Object[0]; IFontRenderer iFontRenderer1 = fontRenderer; boolean bool = false; Intrinsics.checkExpressionValueIsNotNull(String.format(str1, Arrays.copyOf(arrayOfObject, arrayOfObject.length)), "java.lang.String.format(format, *args)"); String str2 = String.format(str1, Arrays.copyOf(arrayOfObject, arrayOfObject.length)); iFontRenderer1.drawString(str2, 
/* 67 */         3, 
/* 68 */         ty1, (
/* 69 */         new Color(255, 255, 255)).getRGB());
/*    */ 
/*    */ 
/*    */     
/* 73 */     stringCompanionObject = StringCompanionObject.INSTANCE; str1 = "Wins:" + Recorder.INSTANCE.getWin(); arrayOfObject = new Object[0]; iFontRenderer1 = fontRenderer; bool = false; Intrinsics.checkExpressionValueIsNotNull(String.format(str1, Arrays.copyOf(arrayOfObject, arrayOfObject.length)), "java.lang.String.format(format, *args)"); str2 = String.format(str1, Arrays.copyOf(arrayOfObject, arrayOfObject.length)); iFontRenderer1.drawString(str2, 3, 
/* 74 */         ty2, (new Color(255, 255, 255)).getRGB());
/*    */ 
/*    */ 
/*    */     
/* 78 */     fontRenderer.drawString(
/* 79 */         "Kills:" + Recorder.INSTANCE.getKillCounts(), 3, 
/* 80 */         ty3, (new Color(255, 255, 255)).getRGB());
/*    */ 
/*    */     
/* 83 */     return new Border(-2.0F, -2.0F, x2, y2);
/*    */   }
/*    */ 
/*    */   
/*    */   private final double BPS() {
/* 88 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe(); 
/* 89 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double bps = Math.hypot(MinecraftInstance.mc.getThePlayer().getPosX() - MinecraftInstance.mc.getThePlayer().getPrevPosX(), MinecraftInstance.mc.getThePlayer().getPosZ() - MinecraftInstance.mc.getThePlayer().getPrevPosZ()) * 
/* 90 */       MinecraftInstance.mc.getTimer().getTimerSpeed() * 20;
/* 91 */     return Math.round(bps * 100.0D) / 100.0D;
/*    */   }
/*    */   
/*    */   public BanChecker() {
/*    */     this(0.0D, 0.0D, 0.0F, 7, (DefaultConstructorMarker)null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\BanChecker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */