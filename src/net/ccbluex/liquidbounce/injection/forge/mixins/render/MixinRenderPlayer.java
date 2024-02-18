/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.render;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.PlayerSize;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.AbstractClientPlayer;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({RenderPlayer.class})
/*    */ public abstract class MixinRenderPlayer {
/*    */   @Inject(method = {"renderLivingAt"}, at = {@At("HEAD")})
/*    */   protected void renderLivingAt(AbstractClientPlayer entityLivingBaseIn, double x, double y, double z, CallbackInfo callbackInfo) {
/* 18 */     PlayerSize playerSize = (PlayerSize)Retreat.moduleManager.getModule(PlayerSize.class);
/* 19 */     if (Retreat.moduleManager.getModule(PlayerSize.class).getState() && entityLivingBaseIn.equals((Minecraft.func_71410_x()).field_71439_g))
/* 20 */       GlStateManager.func_179152_a(((Float)playerSize.getPlayerSizeValue().get()).floatValue(), ((Float)playerSize.getPlayerSizeValue().get()).floatValue(), ((Float)playerSize.getPlayerSizeValue().get()).floatValue()); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\render\MixinRenderPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */