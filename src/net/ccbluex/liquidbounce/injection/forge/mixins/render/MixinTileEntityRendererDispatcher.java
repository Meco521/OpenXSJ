/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.render;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.XRay;
/*    */ import net.ccbluex.liquidbounce.injection.backend.BlockImplKt;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({TileEntityRendererDispatcher.class})
/*    */ public class MixinTileEntityRendererDispatcher
/*    */ {
/*    */   @Inject(method = {"render(Lnet/minecraft/tileentity/TileEntity;FI)V"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void renderTileEntity(TileEntity tileentityIn, float partialTicks, int destroyStage, CallbackInfo callbackInfo) {
/* 18 */     XRay xray = (XRay)Retreat.moduleManager.getModule(XRay.class);
/*    */     
/* 20 */     if (xray.getState() && !xray.getXrayBlocks().contains(BlockImplKt.wrap(tileentityIn.func_145838_q())))
/* 21 */       callbackInfo.cancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\render\MixinTileEntityRendererDispatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */