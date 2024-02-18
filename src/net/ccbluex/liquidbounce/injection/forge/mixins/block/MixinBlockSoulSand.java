/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.block;
/*    */ 
/*    */ import java.util.Objects;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.movement.NoSlow;
/*    */ import net.minecraft.block.BlockSoulSand;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ @Mixin({BlockSoulSand.class})
/*    */ public class MixinBlockSoulSand
/*    */ {
/*    */   @Inject(method = {"onEntityCollidedWithBlock"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void onEntityCollidedWithBlock(CallbackInfo callbackInfo) {
/* 21 */     NoSlow noSlow = (NoSlow)Retreat.moduleManager.getModule(NoSlow.class);
/*    */     
/* 23 */     if (((NoSlow)Objects.<NoSlow>requireNonNull(noSlow)).getState() && ((Boolean)noSlow.getSoulsandValue().get()).booleanValue())
/* 24 */       callbackInfo.cancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\block\MixinBlockSoulSand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */