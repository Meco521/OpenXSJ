/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.client;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.event.Event;
/*    */ import net.ccbluex.liquidbounce.event.Render2DEvent;
/*    */ import net.ccbluex.liquidbounce.utils.ClassUtils;
/*    */ import net.minecraft.profiler.Profiler;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({Profiler.class})
/*    */ public class MixinProfiler {
/*    */   @Inject(method = {"startSection(Ljava/lang/String;)V"}, at = {@At("HEAD")})
/*    */   private void startSection(String name, CallbackInfo callbackInfo) {
/* 17 */     if (name.equals("bossHealth") && ClassUtils.hasClass("net.labymod.api.LabyModAPI"))
/* 18 */       Retreat.eventManager.callEvent((Event)new Render2DEvent(0.0F)); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\client\MixinProfiler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */