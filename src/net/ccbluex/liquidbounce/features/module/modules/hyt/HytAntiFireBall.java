/*    */ package net.ccbluex.liquidbounce.features.module.modules.hyt;
/*    */ import kotlin.TypeCastException;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketUseEntity;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "HytAntiFireBall", description = ":/", category = ModuleCategory.HYT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000$\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\007\032\0020\b2\006\020\t\032\0020\nH\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000¨\006\013"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/hyt/HytAntiFireBall;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "swingValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "timer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class HytAntiFireBall extends Module {
/* 18 */   private final ListValue swingValue = new ListValue("Swing", new String[] { "Normal", "Packet", "None" }, "Normal");
/* 19 */   private final MSTimer timer = new MSTimer();
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 23 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  for (IEntity entity : MinecraftInstance.mc.getTheWorld().getLoadedEntityList()) { if (MinecraftInstance.classProvider.isEntityFireball(entity)) {
/* 24 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getDistanceToEntity(entity) < 6.0D && this.timer.hasTimePassed(0L)) {
/*    */           
/* 26 */           if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.classProvider.createCPacketUseEntity(entity, ICPacketUseEntity.WAction.ATTACK) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.api.minecraft.network.IPacket");  MinecraftInstance.mc.getThePlayer().getSendQueue().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketUseEntity(entity, ICPacketUseEntity.WAction.ATTACK));
/* 27 */           if (((String)this.swingValue.get()).equals("Normal")) {
/* 28 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().swingItem();
/* 29 */           } else if (((String)this.swingValue.get()).equals("Packet")) {
/* 30 */             if (MinecraftInstance.classProvider.createCPacketAnimation() == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.api.minecraft.network.IPacket");  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketAnimation());
/*    */           } 
/* 32 */           this.timer.reset();
/*    */           break;
/*    */         } 
/*    */       }  }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\hyt\HytAntiFireBall.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */