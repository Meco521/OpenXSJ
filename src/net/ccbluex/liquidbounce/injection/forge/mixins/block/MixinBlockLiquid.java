/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.block;
/*    */ 
/*    */ import java.util.Objects;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.world.Liquids;
/*    */ import net.minecraft.block.BlockLiquid;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ @Mixin({BlockLiquid.class})
/*    */ public class MixinBlockLiquid
/*    */ {
/*    */   @Inject(method = {"canCollideCheck"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void onCollideCheck(CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
/* 21 */     if (((Module)Objects.<Module>requireNonNull(Retreat.moduleManager.getModule(Liquids.class))).getState())
/* 22 */       callbackInfoReturnable.setReturnValue(Boolean.valueOf(true)); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\block\MixinBlockLiquid.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */