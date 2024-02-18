/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.render;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.XRay;
/*    */ import net.minecraft.client.renderer.chunk.VisGraph;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({VisGraph.class})
/*    */ public class MixinVisGraph
/*    */ {
/*    */   @Inject(method = {"setOpaqueCube"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void func_178606_a(CallbackInfo callbackInfo) {
/* 16 */     if (Retreat.moduleManager.getModule(XRay.class).getState())
/* 17 */       callbackInfo.cancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\render\MixinVisGraph.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */