/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.render;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.Chams;
/*    */ import net.minecraft.client.renderer.entity.RenderEntityItem;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ @Mixin({RenderEntityItem.class})
/*    */ public class MixinRenderEntityItem
/*    */ {
/*    */   @Inject(method = {"doRender"}, at = {@At("HEAD")})
/*    */   private void injectChamsPre(CallbackInfo callbackInfo) {
/* 19 */     Chams chams = (Chams)Retreat.moduleManager.getModule(Chams.class);
/* 20 */     if (chams.getState() && ((Boolean)chams.getItemsValue().get()).booleanValue()) {
/* 21 */       GL11.glEnable(32823);
/* 22 */       GL11.glPolygonOffset(1.0F, -1000000.0F);
/*    */     } 
/*    */   }
/*    */   
/*    */   @Inject(method = {"doRender"}, at = {@At("RETURN")})
/*    */   private void injectChamsPost(CallbackInfo callbackInfo) {
/* 28 */     Chams chams = (Chams)Retreat.moduleManager.getModule(Chams.class);
/* 29 */     if (chams.getState() && ((Boolean)chams.getItemsValue().get()).booleanValue()) {
/* 30 */       GL11.glPolygonOffset(1.0F, 1000000.0F);
/* 31 */       GL11.glDisable(32823);
/*    */     } 
/*    */   }
/*    */   
/*    */   @Inject(method = {"doRender(Lnet/minecraft/entity/item/EntityItem;DDDFF)V"}, at = {@At("HEAD")}, cancellable = true)
/*    */   public void doRender(EntityItem f1, double f2, double f3, double f4, float f5, float j, CallbackInfo ci) {}
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\render\MixinRenderEntityItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */