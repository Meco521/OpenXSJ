/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.gui;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.utils.ServerUtils;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiIngameMenu;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({GuiIngameMenu.class})
/*    */ public abstract class MixinGuiIngameMenu
/*    */   extends MixinGuiScreen {
/*    */   @Inject(method = {"initGui"}, at = {@At("RETURN")})
/*    */   private void initGui(CallbackInfo callbackInfo) {
/* 16 */     if (!this.field_146297_k.func_71387_A())
/* 17 */       this.field_146292_n.add(new GuiButton(1337, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 128, "Reconnect")); 
/*    */   }
/*    */   
/*    */   @Inject(method = {"actionPerformed"}, at = {@At("HEAD")})
/*    */   private void actionPerformed(GuiButton button, CallbackInfo callbackInfo) {
/* 22 */     if (button.field_146127_k == 1337) {
/* 23 */       this.field_146297_k.field_71441_e.func_72882_A();
/* 24 */       ServerUtils.connectToLastServer();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\gui\MixinGuiIngameMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */