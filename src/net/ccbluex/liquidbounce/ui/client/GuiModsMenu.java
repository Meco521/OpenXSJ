/*    */ package net.ccbluex.liquidbounce.ui.client;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiButton;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiScreen;
/*    */ import net.ccbluex.liquidbounce.api.util.WrappedGuiScreen;
/*    */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0008\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\002\n\002\020\007\n\002\b\003\n\002\020\f\n\002\b\002\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\005\032\0020\0062\006\020\007\032\0020\bH\026J \020\t\032\0020\0062\006\020\n\032\0020\0132\006\020\f\032\0020\0132\006\020\r\032\0020\016H\026J\b\020\017\032\0020\006H\026J\030\020\020\032\0020\0062\006\020\021\032\0020\0222\006\020\023\032\0020\013H\026R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\024"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/GuiModsMenu;", "Lnet/ccbluex/liquidbounce/api/util/WrappedGuiScreen;", "prevGui", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;)V", "actionPerformed", "", "button", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiButton;", "drawScreen", "mouseX", "", "mouseY", "partialTicks", "", "initGui", "keyTyped", "typedChar", "", "keyCode", "XSJClient"})
/*    */ public final class GuiModsMenu extends WrappedGuiScreen {
/*    */   public GuiModsMenu(@NotNull IGuiScreen prevGui) {
/* 14 */     this.prevGui = prevGui;
/*    */   } private final IGuiScreen prevGui;
/*    */   public void initGui() {
/* 17 */     getRepresentedScreen().getButtonList().add(MinecraftInstance.classProvider.createGuiButton(0, getRepresentedScreen().getWidth() / 2 - 100, getRepresentedScreen().getHeight() / 4 + 48, "Forge Mods"));
/* 18 */     getRepresentedScreen().getButtonList().add(MinecraftInstance.classProvider.createGuiButton(1, getRepresentedScreen().getWidth() / 2 - 100, getRepresentedScreen().getHeight() / 4 + 48 + 25, "Scripts"));
/* 19 */     getRepresentedScreen().getButtonList().add(MinecraftInstance.classProvider.createGuiButton(2, getRepresentedScreen().getWidth() / 2 - 100, getRepresentedScreen().getHeight() / 4 + 48 + 50, "Back"));
/*    */   }
/*    */   
/*    */   public void actionPerformed(@NotNull IGuiButton button) {
/* 23 */     Intrinsics.checkParameterIsNotNull(button, "button"); switch (button.getId()) { case 0:
/* 24 */         MinecraftInstance.mc.displayGuiScreen(MinecraftInstance.classProvider.createGuiModList(getRepresentedScreen())); break;
/* 25 */       case 1: MinecraftInstance.mc.displayGuiScreen(MinecraftInstance.classProvider.wrapGuiScreen(new GuiScripts(getRepresentedScreen()))); break;
/* 26 */       case 2: MinecraftInstance.mc.displayGuiScreen(this.prevGui);
/*    */         break; }
/*    */   
/*    */   }
/*    */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 31 */     getRepresentedScreen().drawBackground(0);
/*    */     
/* 33 */     Fonts.robotoBold180.drawCenteredString("Mods", getRepresentedScreen().getWidth() / 2.0F, getRepresentedScreen().getHeight() / 8.0F + 5.0F, 4673984, true);
/*    */     
/* 35 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*    */   }
/*    */   
/*    */   public void keyTyped(char typedChar, int keyCode) {
/* 39 */     if (1 == keyCode) {
/* 40 */       MinecraftInstance.mc.displayGuiScreen(this.prevGui);
/*    */       
/*    */       return;
/*    */     } 
/* 44 */     super.keyTyped(typedChar, keyCode);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\GuiModsMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */