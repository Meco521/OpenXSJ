/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.render;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.event.Event;
/*    */ import net.ccbluex.liquidbounce.event.RenderEntityEvent;
/*    */ import net.ccbluex.liquidbounce.injection.backend.EntityImplKt;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.entity.Entity;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ @Mixin({Render.class})
/*    */ public abstract class MixinRender
/*    */ {
/*    */   @Inject(method = {"doRender"}, at = {@At("HEAD")})
/*    */   private void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks, CallbackInfo callbackInfo) {
/* 21 */     Retreat.eventManager.callEvent((Event)new RenderEntityEvent(EntityImplKt.wrap(entity), x, y, z, entityYaw, partialTicks));
/*    */   }
/*    */   
/*    */   @Shadow
/*    */   protected abstract <T extends Entity> boolean func_180548_c(T paramT);
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\render\MixinRender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */