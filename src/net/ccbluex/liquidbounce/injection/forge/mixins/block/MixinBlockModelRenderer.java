/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.block;
/*    */ 
/*    */ import java.util.Objects;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.XRay;
/*    */ import net.ccbluex.liquidbounce.injection.backend.BlockImplKt;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.client.renderer.BlockModelRenderer;
/*    */ import net.minecraft.client.renderer.BufferBuilder;
/*    */ import net.minecraft.client.renderer.block.model.IBakedModel;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ @Mixin({BlockModelRenderer.class})
/*    */ public class MixinBlockModelRenderer
/*    */ {
/*    */   @Inject(method = {"renderModelSmooth"}, at = {@At("HEAD")}, cancellable = true)
/*    */   public void renderModelSmooth(IBlockAccess worldIn, IBakedModel modelIn, IBlockState stateIn, BlockPos posIn, BufferBuilder buffer, boolean checkSides, long rand, CallbackInfoReturnable<Boolean> cir) {
/* 24 */     XRay xray = (XRay)Retreat.moduleManager.getModule(XRay.class);
/*    */     
/* 26 */     if (((XRay)Objects.<XRay>requireNonNull(xray)).getState() && !xray.getXrayBlocks().contains(BlockImplKt.wrap(stateIn.func_177230_c())))
/* 27 */       cir.setReturnValue(Boolean.valueOf(false)); 
/*    */   }
/*    */   
/*    */   @Inject(method = {"renderModelFlat"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void renderModelStandard(IBlockAccess worldIn, IBakedModel modelIn, IBlockState stateIn, BlockPos posIn, BufferBuilder buffer, boolean checkSides, long rand, CallbackInfoReturnable<Boolean> booleanCallbackInfoReturnable) {
/* 32 */     XRay xray = (XRay)Retreat.moduleManager.getModule(XRay.class);
/*    */     
/* 34 */     if (((XRay)Objects.<XRay>requireNonNull(xray)).getState() && !xray.getXrayBlocks().contains(BlockImplKt.wrap(stateIn.func_177230_c())))
/* 35 */       booleanCallbackInfoReturnable.setReturnValue(Boolean.valueOf(false)); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\block\MixinBlockModelRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */