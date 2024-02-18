/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.render;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.event.Event;
/*    */ import net.ccbluex.liquidbounce.event.TextEvent;
/*    */ import net.ccbluex.liquidbounce.utils.render.shader.shaders.RainbowFontShader;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import org.lwjgl.opengl.GL20;
/*    */ import org.spongepowered.asm.mixin.Debug;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.ModifyVariable;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Debug(export = true, print = true)
/*    */ @SideOnly(Side.CLIENT)
/*    */ @Mixin({FontRenderer.class})
/*    */ public class MixinFontRenderer
/*    */ {
/*    */   private boolean rainbowEnabled0 = false;
/*    */   private boolean rainbowEnabled1 = false;
/*    */   
/*    */   @Debug(print = true)
/*    */   @Inject(method = {"drawString(Ljava/lang/String;FFIZ)I"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/gui/FontRenderer;renderString(Ljava/lang/String;FFIZ)I", ordinal = 0)}, require = 1, allow = 1)
/*    */   private void injectShadow1(String text, float x, float y, int color, boolean dropShadow, CallbackInfoReturnable<Integer> cir) {
/* 30 */     this.rainbowEnabled0 = RainbowFontShader.INSTANCE.isInUse();
/*    */     
/* 32 */     if (this.rainbowEnabled0) {
/* 33 */       GL20.glUseProgram(0);
/*    */     }
/*    */   }
/*    */   
/*    */   @Debug(print = true)
/*    */   @Inject(method = {"drawString(Ljava/lang/String;FFIZ)I"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/gui/FontRenderer;renderString(Ljava/lang/String;FFIZ)I", ordinal = 1)}, require = 1, allow = 1)
/*    */   private void injectShadow2(String text, float x, float y, int color, boolean dropShadow, CallbackInfoReturnable<Integer> cir) {
/* 40 */     if (this.rainbowEnabled0) {
/* 41 */       GL20.glUseProgram(RainbowFontShader.INSTANCE.getProgramId());
/*    */     }
/*    */   }
/*    */   
/*    */   @Debug(print = true)
/*    */   @Inject(method = {"renderStringAtPos"}, at = {@At("HEAD")}, require = 1, allow = 1)
/*    */   private void injectRainbow5(String text, boolean shadow, CallbackInfo ci) {
/* 48 */     this.rainbowEnabled1 = RainbowFontShader.INSTANCE.isInUse();
/*    */   }
/*    */   
/*    */   @Debug(print = true)
/*    */   @Inject(method = {"renderStringAtPos"}, at = {@At("RETURN")}, require = 1, allow = 1)
/*    */   private void injectRainbow6(String text, boolean shadow, CallbackInfo ci) {
/* 54 */     if (this.rainbowEnabled1) {
/* 55 */       GL20.glUseProgram(RainbowFontShader.INSTANCE.getProgramId());
/*    */     }
/*    */   }
/*    */   
/*    */   @Debug(print = true)
/*    */   @Inject(method = {"renderStringAtPos"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/gui/FontRenderer;setColor(FFFF)V", ordinal = 0)}, require = 1, allow = 1)
/*    */   private void injectRainbow3(String text, boolean shadow, CallbackInfo ci) {
/* 62 */     if (this.rainbowEnabled1) {
/* 63 */       GL20.glUseProgram(0);
/*    */     }
/*    */   }
/*    */   
/*    */   @Debug(print = true)
/*    */   @Inject(method = {"renderStringAtPos"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/gui/FontRenderer;setColor(FFFF)V", ordinal = 1)}, require = 1, allow = 1)
/*    */   private void injectRainbow4(String text, boolean shadow, CallbackInfo ci) {
/* 70 */     if (this.rainbowEnabled1) {
/* 71 */       GL20.glUseProgram(RainbowFontShader.INSTANCE.getProgramId());
/*    */     }
/*    */   }
/*    */   
/*    */   @ModifyVariable(method = {"renderString"}, at = @At("HEAD"), require = 1, ordinal = 0, argsOnly = true)
/*    */   private String renderString(String string) {
/* 77 */     if (string == null)
/* 78 */       return null; 
/* 79 */     if (Retreat.eventManager == null) {
/* 80 */       return string;
/*    */     }
/* 82 */     TextEvent textEvent = new TextEvent(string);
/* 83 */     Retreat.eventManager.callEvent((Event)textEvent);
/* 84 */     return textEvent.getText();
/*    */   }
/*    */   
/*    */   @ModifyVariable(method = {"getStringWidth"}, at = @At("HEAD"), require = 1, ordinal = 0, argsOnly = true)
/*    */   private String getStringWidth(String string) {
/* 89 */     if (string == null)
/* 90 */       return null; 
/* 91 */     if (Retreat.eventManager == null) {
/* 92 */       return string;
/*    */     }
/* 94 */     TextEvent textEvent = new TextEvent(string);
/* 95 */     Retreat.eventManager.callEvent((Event)textEvent);
/* 96 */     return textEvent.getText();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\render\MixinFontRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */