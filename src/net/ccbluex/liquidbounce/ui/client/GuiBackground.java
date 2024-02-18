/*    */ package net.ccbluex.liquidbounce.ui.client;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.File;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiButton;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiScreen;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.IResourceLocation;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.misc.MiscUtils;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000:\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\n\002\020\002\n\002\b\003\n\002\020\b\n\002\b\002\n\002\020\007\n\002\b\003\n\002\020\f\n\002\b\003\030\000 \0302\0020\001:\001\030B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\n\032\0020\0132\006\020\f\032\0020\006H\026J \020\r\032\0020\0132\006\020\016\032\0020\0172\006\020\020\032\0020\0172\006\020\021\032\0020\022H\026J\b\020\023\032\0020\013H\026J\030\020\024\032\0020\0132\006\020\025\032\0020\0262\006\020\027\032\0020\017H\026R\016\020\005\032\0020\006X.¢\006\002\n\000R\016\020\007\032\0020\006X.¢\006\002\n\000R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\b\020\t¨\006\031"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/GuiBackground;", "Lnet/ccbluex/liquidbounce/api/util/WrappedGuiScreen;", "prevGui", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;)V", "enabledButton", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiButton;", "particlesButton", "getPrevGui", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;", "actionPerformed", "", "button", "drawScreen", "mouseX", "", "mouseY", "partialTicks", "", "initGui", "keyTyped", "typedChar", "", "keyCode", "Companion", "XSJClient"})
/*    */ public final class GuiBackground extends WrappedGuiScreen {
/*    */   private IGuiButton enabledButton;
/*    */   private IGuiButton particlesButton;
/*    */   
/*    */   @NotNull
/* 20 */   public final IGuiScreen getPrevGui() { return this.prevGui; } @NotNull private final IGuiScreen prevGui; private static boolean enabled; private static boolean particles; public GuiBackground(@NotNull IGuiScreen prevGui) { this.prevGui = prevGui; }
/*    */ 
/*    */   
/* 23 */   public static final Companion Companion = new Companion(null); static { enabled = true; } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\013\n\002\b\b\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\032\020\t\032\0020\004X\016¢\006\016\n\000\032\004\b\n\020\006\"\004\b\013\020\b¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/GuiBackground$Companion;", "", "()V", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "particles", "getParticles", "setParticles", "XSJClient"}) public static final class Companion { private Companion() {} public final boolean getEnabled() { return GuiBackground.enabled; } public final void setEnabled(boolean <set-?>) { GuiBackground.enabled = <set-?>; }
/* 24 */     public final boolean getParticles() { return GuiBackground.particles; } public final void setParticles(boolean <set-?>) { GuiBackground.particles = <set-?>; }
/*    */      }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void initGui() {
/* 31 */     this.enabledButton = MinecraftInstance.classProvider.createGuiButton(1, getRepresentedScreen().getWidth() / 2 - 100, getRepresentedScreen().getHeight() / 4 + 35, "Enabled (" + (enabled ? "On" : "Off") + ')');
/* 32 */     if (this.enabledButton == null) Intrinsics.throwUninitializedPropertyAccessException("enabledButton");  getRepresentedScreen().getButtonList().add(this.enabledButton);
/* 33 */     this.particlesButton = MinecraftInstance.classProvider.createGuiButton(2, getRepresentedScreen().getWidth() / 2 - 100, getRepresentedScreen().getHeight() / 4 + 50 + 25, "Particles (" + (particles ? "On" : "Off") + ')');
/* 34 */     if (this.particlesButton == null) Intrinsics.throwUninitializedPropertyAccessException("particlesButton");  getRepresentedScreen().getButtonList().add(this.particlesButton);
/* 35 */     getRepresentedScreen().getButtonList().add(MinecraftInstance.classProvider.createGuiButton(3, getRepresentedScreen().getWidth() / 2 - 100, getRepresentedScreen().getHeight() / 4 + 50 + 50, 98, 20, "Change wallpaper"));
/* 36 */     getRepresentedScreen().getButtonList().add(MinecraftInstance.classProvider.createGuiButton(4, getRepresentedScreen().getWidth() / 2 + 2, getRepresentedScreen().getHeight() / 4 + 50 + 50, 98, 20, "Reset wallpaper"));
/*    */     
/* 38 */     getRepresentedScreen().getButtonList().add(MinecraftInstance.classProvider.createGuiButton(0, getRepresentedScreen().getWidth() / 2 - 100, getRepresentedScreen().getHeight() / 4 + 55 + 100 + 5, "Back"));
/*    */   }
/*    */   
/*    */   public void actionPerformed(@NotNull IGuiButton button) {
/* 42 */     Intrinsics.checkParameterIsNotNull(button, "button"); switch (button.getId()) {
/*    */       case 1:
/* 44 */         enabled = !enabled;
/* 45 */         if (this.enabledButton == null) Intrinsics.throwUninitializedPropertyAccessException("enabledButton");  this.enabledButton.setDisplayString("Enabled (" + (enabled ? "On" : "Off") + ')');
/*    */         break;
/*    */       case 2:
/* 48 */         particles = !particles;
/* 49 */         if (this.particlesButton == null) Intrinsics.throwUninitializedPropertyAccessException("particlesButton");  this.particlesButton.setDisplayString("Particles (" + (particles ? "On" : "Off") + ')');
/*    */         break;
/*    */       case 3:
/* 52 */         if (MiscUtils.openFileChooser() != null) { File file = MiscUtils.openFileChooser();
/* 53 */           if (file.isDirectory())
/*    */             return; 
/*    */           try {
/* 56 */             Files.copy(file.toPath(), new FileOutputStream((Retreat.INSTANCE.getFileManager()).backgroundFile));
/*    */             
/* 58 */             BufferedImage image = ImageIO.read(new FileInputStream((Retreat.INSTANCE.getFileManager()).backgroundFile));
/* 59 */             String str1 = "XSJ Client"; StringBuilder stringBuilder = new StringBuilder(); IClassProvider iClassProvider = MinecraftInstance.classProvider; boolean bool = false; Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()"); String str2 = str1.toLowerCase(); IResourceLocation location = iClassProvider.createResourceLocation(stringBuilder.append(str2).append("/background.png").toString());
/*    */             
/* 61 */             Retreat.INSTANCE.setBackground(location);
/*    */             
/* 63 */             Intrinsics.checkExpressionValueIsNotNull(image, "image"); MinecraftInstance.mc.getTextureManager().loadTexture(location, (IAbstractTexture)MinecraftInstance.classProvider.createDynamicTexture(image));
/* 64 */           } catch (Exception e) {
/* 65 */             e.printStackTrace();
/* 66 */             MiscUtils.showErrorPopup("Error", "Exception class: " + e.getClass().getName() + "\nMessage: " + e.getMessage());
/* 67 */             (Retreat.INSTANCE.getFileManager()).backgroundFile.delete();
/*    */           }  break; }
/*    */          MiscUtils.openFileChooser(); return;
/*    */       case 4:
/* 71 */         Retreat.INSTANCE.setBackground((IResourceLocation)null);
/* 72 */         (Retreat.INSTANCE.getFileManager()).backgroundFile.delete(); break;
/*    */       case 0:
/* 74 */         MinecraftInstance.mc.displayGuiScreen(this.prevGui);
/*    */         break;
/*    */     } 
/*    */   }
/*    */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 79 */     getRepresentedScreen().drawBackground(0);
/* 80 */     Fonts.robotoBold180.drawCenteredString("Background", getRepresentedScreen().getWidth() / 2.0F, getRepresentedScreen().getHeight() / 8.0F + 5.0F, 
/* 81 */         4673984, true);
/*    */     
/* 83 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*    */   }
/*    */   
/*    */   public void keyTyped(char typedChar, int keyCode) {
/* 87 */     if (1 == keyCode) {
/* 88 */       MinecraftInstance.mc.displayGuiScreen(this.prevGui);
/*    */       
/*    */       return;
/*    */     } 
/* 92 */     super.keyTyped(typedChar, keyCode);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\GuiBackground.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */