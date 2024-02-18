/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.gui;
/*    */ 
/*    */ import net.minecraft.client.gui.GuiWorldSelection;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({GuiWorldSelection.class})
/*    */ public abstract class MixinGuiWorldSelection
/*    */   extends MixinGuiScreen {
/*    */   @Inject(method = {"drawScreen"}, at = {@At("HEAD")})
/*    */   private void injectDrawDefaultBackground(int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {
/* 14 */     func_146276_q_();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\gui\MixinGuiWorldSelection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */