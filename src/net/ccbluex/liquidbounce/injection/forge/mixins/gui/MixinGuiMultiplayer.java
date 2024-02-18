/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.gui;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.util.WrappedGuiScreen;
/*    */ import net.ccbluex.liquidbounce.features.special.BungeeCordSpoof;
/*    */ import net.ccbluex.liquidbounce.injection.backend.GuiScreenImplKt;
/*    */ import net.ccbluex.liquidbounce.ui.client.GuiAntiForge;
/*    */ import net.ccbluex.liquidbounce.ui.client.tools.GuiTools;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiMultiplayer;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({GuiMultiplayer.class})
/*    */ public abstract class MixinGuiMultiplayer extends MixinGuiScreen {
/*    */   private GuiButton bungeeCordSpoofButton;
/*    */   
/*    */   @Inject(method = {"initGui"}, at = {@At("RETURN")})
/*    */   private void initGui(CallbackInfo callbackInfo) {
/* 23 */     this.field_146292_n.add(new GuiButton(997, 5, 8, 98, 20, "AntiForge"));
/* 24 */     this.field_146292_n.add(this.bungeeCordSpoofButton = new GuiButton(998, 108, 8, 98, 20, "BungeeCord Spoof: " + (BungeeCordSpoof.enabled ? "On" : "Off")));
/* 25 */     this.field_146292_n.add(new GuiButton(999, this.field_146294_l - 104, 8, 98, 20, "Tools"));
/*    */   }
/*    */   
/*    */   @Inject(method = {"actionPerformed"}, at = {@At("HEAD")})
/*    */   private void actionPerformed(GuiButton button, CallbackInfo callbackInfo) {
/* 30 */     switch (button.field_146127_k) {
/*    */       case 997:
/* 32 */         this.field_146297_k.func_147108_a(GuiScreenImplKt.unwrap(Retreat.wrapper.getClassProvider().wrapGuiScreen((WrappedGuiScreen)new GuiAntiForge(GuiScreenImplKt.wrap((GuiScreen)this)))));
/*    */         break;
/*    */       case 998:
/* 35 */         BungeeCordSpoof.enabled = !BungeeCordSpoof.enabled;
/* 36 */         this.bungeeCordSpoofButton.field_146126_j = "BungeeCord Spoof: " + (BungeeCordSpoof.enabled ? "On" : "Off");
/* 37 */         Retreat.fileManager.saveConfig(Retreat.fileManager.valuesConfig);
/*    */         break;
/*    */       case 999:
/* 40 */         this.field_146297_k.func_147108_a(GuiScreenImplKt.unwrap(Retreat.wrapper.getClassProvider().wrapGuiScreen((WrappedGuiScreen)new GuiTools(GuiScreenImplKt.wrap((GuiScreen)this)))));
/*    */         break;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\gui\MixinGuiMultiplayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */