/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.render;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.Chams;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntityChestRenderer;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({TileEntityChestRenderer.class})
/*    */ public class MixinTileEntityChestRenderer
/*    */ {
/*    */   @Inject(method = {"render"}, at = {@At("HEAD")})
/*    */   private void injectChamsPre(CallbackInfo callbackInfo) {
/* 17 */     Chams chams = (Chams)Retreat.moduleManager.getModule(Chams.class);
/*    */     
/* 19 */     if (chams.getState() && ((Boolean)chams.getChestsValue().get()).booleanValue()) {
/* 20 */       GL11.glEnable(32823);
/* 21 */       GL11.glPolygonOffset(1.0F, -1000000.0F);
/*    */     } 
/*    */   }
/*    */   
/*    */   @Inject(method = {"render"}, at = {@At("RETURN")})
/*    */   private void injectChamsPost(CallbackInfo callbackInfo) {
/* 27 */     Chams chams = (Chams)Retreat.moduleManager.getModule(Chams.class);
/*    */     
/* 29 */     if (chams.getState() && ((Boolean)chams.getChestsValue().get()).booleanValue()) {
/* 30 */       GL11.glPolygonOffset(1.0F, 1000000.0F);
/* 31 */       GL11.glDisable(32823);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\render\MixinTileEntityChestRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */