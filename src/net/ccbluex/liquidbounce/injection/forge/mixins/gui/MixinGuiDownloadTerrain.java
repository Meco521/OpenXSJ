/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.gui;
/*    */ 
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiDownloadTerrain;
/*    */ import net.minecraft.client.gui.GuiMainMenu;
/*    */ import net.minecraft.client.gui.GuiMultiplayer;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.realms.RealmsBridge;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({GuiDownloadTerrain.class})
/*    */ public abstract class MixinGuiDownloadTerrain
/*    */   extends MixinGuiScreen {
/*    */   @Inject(method = {"initGui"}, at = {@At("RETURN")})
/*    */   private void injectDisconnectButton(CallbackInfo ci) {
/* 20 */     this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 120 + 12, I18n.func_135052_a("gui.cancel", new Object[0])));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void injectedActionPerformed(GuiButton button) {
/* 25 */     if (button.field_146127_k == 0) {
/* 26 */       boolean flag = this.field_146297_k.func_71387_A();
/* 27 */       boolean flag1 = this.field_146297_k.func_181540_al();
/* 28 */       button.field_146124_l = false;
/* 29 */       this.field_146297_k.field_71441_e.func_72882_A();
/* 30 */       this.field_146297_k.func_71403_a(null);
/*    */       
/* 32 */       if (flag) {
/* 33 */         this.field_146297_k.func_147108_a((GuiScreen)new GuiMainMenu());
/* 34 */       } else if (flag1) {
/* 35 */         RealmsBridge realmsbridge = new RealmsBridge();
/* 36 */         realmsbridge.switchToRealms((GuiScreen)new GuiMainMenu());
/*    */       } else {
/* 38 */         this.field_146297_k.func_147108_a((GuiScreen)new GuiMultiplayer((GuiScreen)new GuiMainMenu()));
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\gui\MixinGuiDownloadTerrain.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */