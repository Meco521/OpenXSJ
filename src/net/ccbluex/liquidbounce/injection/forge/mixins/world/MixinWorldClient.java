/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.world;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.TrueSight;
/*    */ import net.minecraft.client.multiplayer.WorldClient;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.ModifyVariable;
/*    */ 
/*    */ @Mixin({WorldClient.class})
/*    */ public class MixinWorldClient
/*    */ {
/*    */   @ModifyVariable(method = {"showBarrierParticles"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;randomDisplayTick(Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Ljava/util/Random;)V", shift = At.Shift.AFTER), ordinal = 0)
/*    */   private boolean handleBarriers(boolean flag) {
/* 15 */     TrueSight trueSight = (TrueSight)Retreat.moduleManager.getModule(TrueSight.class);
/*    */     
/* 17 */     return (flag || (trueSight.getState() && ((Boolean)trueSight.getBarriersValue().get()).booleanValue()));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\world\MixinWorldClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */