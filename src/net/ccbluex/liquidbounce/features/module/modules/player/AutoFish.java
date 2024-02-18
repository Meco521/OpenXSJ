/*    */ package net.ccbluex.liquidbounce.features.module.modules.player;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*    */ 
/*    */ @ModuleInfo(name = "AutoFish", description = "Automatically catches fish when using a rod.", category = ModuleCategory.PLAYER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\005\032\0020\0062\006\020\007\032\0020\bH\007R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/player/AutoFish;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "rodOutTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class AutoFish extends Module {
/* 14 */   private final MSTimer rodOutTimer = new MSTimer();
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 18 */     Intrinsics.checkParameterIsNotNull(event, "event"); IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */     
/* 20 */     if (((thePlayer != null) ? thePlayer.getHeldItem() : null) != null) { if (thePlayer.getHeldItem() == null) Intrinsics.throwNpe();  if (MinecraftInstance.classProvider.isItemFishingRod(thePlayer.getHeldItem().getItem())) {
/*    */ 
/*    */         
/* 23 */         IEntity fishEntity = thePlayer.getFishEntity();
/*    */         
/* 25 */         if ((this.rodOutTimer.hasTimePassed(500L) && fishEntity == null) || (fishEntity != null && fishEntity.getMotionX() == 0.0D && fishEntity.getMotionZ() == 0.0D && fishEntity.getMotionY() != 0.0D)) {
/* 26 */           MinecraftInstance.mc.rightClickMouse();
/* 27 */           this.rodOutTimer.reset();
/*    */         } 
/*    */         return;
/*    */       }  }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\player\AutoFish.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */