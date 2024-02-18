/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.render;
/*    */ 
/*    */ import net.minecraft.client.renderer.tileentity.TileEntityMobSpawnerRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.tileentity.MobSpawnerBaseLogic;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({TileEntityMobSpawnerRenderer.class})
/*    */ public class MixinTileEntityMobSpawnerRenderer
/*    */ {
/*    */   @Inject(method = {"renderMob"}, cancellable = true, at = {@At("HEAD")})
/*    */   private static void injectPaintingSpawnerFix(MobSpawnerBaseLogic mobSpawnerLogic, double posX, double posY, double posZ, float partialTicks, CallbackInfo ci) {
/* 16 */     Entity entity = mobSpawnerLogic.func_184994_d();
/*    */     
/* 18 */     if (entity == null || entity instanceof net.minecraft.entity.item.EntityPainting)
/* 19 */       ci.cancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\render\MixinTileEntityMobSpawnerRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */