/*    */ package net.ccbluex.liquidbounce.ui.client;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiButton;
/*    */ import net.ccbluex.liquidbounce.api.util.WrappedGuiScreen;
/*    */ import net.ccbluex.liquidbounce.ui.client.altmanager.GuiAltManager;
/*    */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.ScaledResolution;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000*\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\002\n\002\020\007\n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\006H\026J \020\007\032\0020\0042\006\020\b\032\0020\t2\006\020\n\032\0020\t2\006\020\013\032\0020\fH\026J\b\020\r\032\0020\004H\026¨\006\016"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/GuiMainMenu;", "Lnet/ccbluex/liquidbounce/api/util/WrappedGuiScreen;", "()V", "actionPerformed", "", "button", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiButton;", "drawScreen", "mouseX", "", "mouseY", "partialTicks", "", "initGui", "XSJClient"})
/*    */ public final class GuiMainMenu
/*    */   extends WrappedGuiScreen {
/*    */   public void initGui() {
/* 20 */     int defaultHeight = (int)(getRepresentedScreen().getHeight() / 3.5D);
/* 21 */     Intrinsics.checkExpressionValueIsNotNull(I18n.func_135052_a("Singleplayer", new Object[0]), "I18n.format(\"Singleplayer\")"); getRepresentedScreen().getButtonList().add(MinecraftInstance.classProvider.createGuiButton(1, getRepresentedScreen().getWidth() / 2 - 50, defaultHeight, 100, 20, I18n.func_135052_a("Singleplayer", new Object[0])));
/* 22 */     Intrinsics.checkExpressionValueIsNotNull(I18n.func_135052_a("Multiplayer", new Object[0]), "I18n.format(\"Multiplayer\")"); getRepresentedScreen().getButtonList().add(MinecraftInstance.classProvider.createGuiButton(2, getRepresentedScreen().getWidth() / 2 - 50, defaultHeight + 24, 100, 20, I18n.func_135052_a("Multiplayer", new Object[0])));
/* 23 */     getRepresentedScreen().getButtonList().add(MinecraftInstance.classProvider.createGuiButton(100, getRepresentedScreen().getWidth() / 2 - 50, defaultHeight + 48, 100, 20, "AltManager"));
/* 24 */     Intrinsics.checkExpressionValueIsNotNull(I18n.func_135052_a("Options...", new Object[0]), "I18n.format(\"Options...\")"); getRepresentedScreen().getButtonList().add(MinecraftInstance.classProvider.createGuiButton(0, getRepresentedScreen().getWidth() / 2 - 50, defaultHeight + 72, 100, 20, I18n.func_135052_a("Options...", new Object[0])));
/* 25 */     Intrinsics.checkExpressionValueIsNotNull(I18n.func_135052_a("Quit Game", new Object[0]), "I18n.format(\"Quit Game\")"); getRepresentedScreen().getButtonList().add(MinecraftInstance.classProvider.createGuiButton(4, getRepresentedScreen().getWidth() / 2 - 50, defaultHeight + 96, 100, 20, I18n.func_135052_a("Quit Game", new Object[0])));
/* 26 */     super.initGui();
/*    */   }
/*    */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 29 */     ScaledResolution sr = new ScaledResolution(access$getMinecraft$p$s1046033730());
/* 30 */     int defaultHeight = (int)(getRepresentedScreen().getHeight() / 3.5D);
/*    */     
/* 32 */     RenderUtils.drawImage(MinecraftInstance.classProvider.createResourceLocation("tomk/bg.png"), 0, 0, sr.func_78326_a(), sr.func_78328_b());
/*    */     
/* 34 */     Fonts.productSans70.drawCenteredStringWithShadow("XSJ Client", sr.func_78326_a() / 2.0F, defaultHeight - 30.0F, -1);
/* 35 */     getRepresentedScreen().superDrawScreen(mouseX, mouseY, partialTicks);
/*    */   }
/*    */   
/*    */   public void actionPerformed(@NotNull IGuiButton button) {
/* 39 */     Intrinsics.checkParameterIsNotNull(button, "button"); switch (button.getId()) { case 0:
/* 40 */         MinecraftInstance.mc.displayGuiScreen(MinecraftInstance.classProvider.createGuiOptions(getRepresentedScreen(), MinecraftInstance.mc.getGameSettings())); break;
/* 41 */       case 1: MinecraftInstance.mc.displayGuiScreen(MinecraftInstance.classProvider.createGuiSelectWorld(getRepresentedScreen())); break;
/* 42 */       case 2: MinecraftInstance.mc.displayGuiScreen(MinecraftInstance.classProvider.createGuiMultiplayer(getRepresentedScreen())); break;
/* 43 */       case 4: MinecraftInstance.mc.shutdown(); break;
/* 44 */       case 100: MinecraftInstance.mc.displayGuiScreen(MinecraftInstance.classProvider.wrapGuiScreen((WrappedGuiScreen)new GuiAltManager()));
/*    */         break; }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\GuiMainMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */