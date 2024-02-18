/*    */ package net.ccbluex.liquidbounce.ui.client;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IFontRenderer;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiButton;
/*    */ import net.ccbluex.liquidbounce.api.util.WrappedGuiScreen;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.ClickGUI;
/*    */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.lwjgl.input.Keyboard;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\002\n\002\020\007\n\002\b\003\n\002\020\f\n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\006H\026J \020\007\032\0020\0042\006\020\b\032\0020\t2\006\020\n\032\0020\t2\006\020\013\032\0020\fH\026J\b\020\r\032\0020\004H\026J\030\020\016\032\0020\0042\006\020\017\032\0020\0202\006\020\021\032\0020\tH\026¨\006\022"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/GuiWelcome;", "Lnet/ccbluex/liquidbounce/api/util/WrappedGuiScreen;", "()V", "actionPerformed", "", "button", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiButton;", "drawScreen", "mouseX", "", "mouseY", "partialTicks", "", "initGui", "keyTyped", "typedChar", "", "keyCode", "XSJClient"})
/*    */ public final class GuiWelcome extends WrappedGuiScreen {
/*    */   public void initGui() {
/* 20 */     getRepresentedScreen().getButtonList().add(MinecraftInstance.classProvider.createGuiButton(1, getRepresentedScreen().getWidth() / 2 - 100, getRepresentedScreen().getHeight() - 40, "Ok"));
/*    */   }
/*    */   
/*    */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 24 */     getRepresentedScreen().drawBackground(0);
/*    */     
/* 26 */     IFontRenderer font = Fonts.font35;
/*    */     
/* 28 */     font.drawCenteredString("Thank you for downloading and installing our client!", getRepresentedScreen().getWidth() / 2.0F, getRepresentedScreen().getHeight() / 8.0F + 70, 16777215, true);
/* 29 */     font.drawCenteredString("Here is some information you might find useful if you are using LiquidBounce for the first time.", getRepresentedScreen().getWidth() / 2.0F, getRepresentedScreen().getHeight() / 8.0F + 70 + font.getFontHeight(), 16777215, true);
/*    */     
/* 31 */     font.drawCenteredString("§lClickGUI:", getRepresentedScreen().getWidth() / 2.0F, getRepresentedScreen().getHeight() / 8.0F + 80 + (font.getFontHeight() * 3), 16777215, true);
/* 32 */     if (Retreat.INSTANCE.getModuleManager().get(ClickGUI.class) == null) Intrinsics.throwNpe();  font.drawCenteredString("Press " + Keyboard.getKeyName(Retreat.INSTANCE.getModuleManager().get(ClickGUI.class).getKeyBind()) + " to open up the ClickGUI", getRepresentedScreen().getWidth() / 2.0F, (getRepresentedScreen().getHeight() / 8) + 80.0F + (font.getFontHeight() * 4), 16777215, true);
/* 33 */     font.drawCenteredString("Right-click modules with a '+' next to them to edit their settings.", getRepresentedScreen().getWidth() / 2.0F, getRepresentedScreen().getHeight() / 8.0F + 80 + (font.getFontHeight() * 5), 16777215, true);
/* 34 */     font.drawCenteredString("Hover a module to see it's description.", getRepresentedScreen().getWidth() / 2.0F, getRepresentedScreen().getHeight() / 8.0F + 80 + (font.getFontHeight() * 6), 16777215, true);
/*    */     
/* 36 */     font.drawCenteredString("§lImportant Commands:", getRepresentedScreen().getWidth() / 2.0F, getRepresentedScreen().getHeight() / 8.0F + 80 + (font.getFontHeight() * 8), 16777215, true);
/* 37 */     font.drawCenteredString(".bind <module> <key> / .bind <module> none", getRepresentedScreen().getWidth() / 2.0F, getRepresentedScreen().getHeight() / 8.0F + 80 + (font.getFontHeight() * 9), 16777215, true);
/* 38 */     font.drawCenteredString(".autosettings load <name> / .autosettings list", getRepresentedScreen().getWidth() / 2.0F, getRepresentedScreen().getHeight() / 8.0F + 80 + (font.getFontHeight() * 10), 16777215, true);
/*    */     
/* 40 */     font.drawCenteredString("§lNeed help? Feel free to contact us!", getRepresentedScreen().getWidth() / 2.0F, getRepresentedScreen().getHeight() / 8.0F + 80 + (font.getFontHeight() * 12), 16777215, true);
/* 41 */     font.drawCenteredString("YouTube: https://youtube.com/ccbluex", getRepresentedScreen().getWidth() / 2.0F, getRepresentedScreen().getHeight() / 8.0F + 80 + (font.getFontHeight() * 13), 16777215, true);
/* 42 */     font.drawCenteredString("Twitter: https://twitter.com/ccbluex", getRepresentedScreen().getWidth() / 2.0F, getRepresentedScreen().getHeight() / 8.0F + 80 + (font.getFontHeight() * 14), 16777215, true);
/* 43 */     font.drawCenteredString("Forum: https://forum.ccbluex.net/", getRepresentedScreen().getWidth() / 2.0F, getRepresentedScreen().getHeight() / 8.0F + 80 + (font.getFontHeight() * 15), 16777215, true);
/*    */     
/* 45 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*    */ 
/*    */     
/* 48 */     GL11.glScalef(2.0F, 2.0F, 2.0F);
/* 49 */     Fonts.font40.drawCenteredString("Welcome!", (getRepresentedScreen().getWidth() / 2) / 2.0F, getRepresentedScreen().getHeight() / 8.0F / 2 + 20, (new Color(0, 140, 255)).getRGB(), true);
/*    */   }
/*    */   
/*    */   public void keyTyped(char typedChar, int keyCode) {
/* 53 */     if (1 == keyCode) {
/*    */       return;
/*    */     }
/* 56 */     super.keyTyped(typedChar, keyCode);
/*    */   }
/*    */   
/*    */   public void actionPerformed(@NotNull IGuiButton button) {
/* 60 */     Intrinsics.checkParameterIsNotNull(button, "button"); if (button.getId() == 1)
/* 61 */       MinecraftInstance.mc.displayGuiScreen(MinecraftInstance.classProvider.wrapGuiScreen(new GuiMainMenu())); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\GuiWelcome.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */