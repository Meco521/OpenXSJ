/*    */ package net.ccbluex.liquidbounce.features.module.modules.hyt;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.play.server.ISPacketAnimation;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.play.server.ISPacketEntity;
/*    */ import net.ccbluex.liquidbounce.event.AttackEvent;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "HytAntiBot", description = "Prevents KillAura from attacking AntiCheat bots.", category = ModuleCategory.HYT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000<\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020!\n\002\020\b\n\002\b\003\n\002\020%\n\002\b\003\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\f\032\0020\rH\002J\020\020\016\032\0020\r2\006\020\017\032\0020\020H\007J\b\020\021\032\0020\rH\026J\020\020\022\032\0020\r2\006\020\023\032\0020\024H\007J\022\020\025\032\0020\r2\b\020\023\032\004\030\0010\026H\007R\024\020\003\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\024\020\006\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\024\020\007\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\032\020\b\032\016\022\004\022\0020\005\022\004\022\0020\0050\tX\004¢\006\002\n\000R\024\020\n\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\024\020\013\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000¨\006\027"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/hyt/HytAntiBot;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "air", "", "", "ground", "hitted", "invalidGround", "", "invisible", "swing", "clearAll", "", "onAttack", "e", "Lnet/ccbluex/liquidbounce/event/AttackEvent;", "onDisable", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onWorld", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "XSJClient"})
/*    */ public final class HytAntiBot extends Module {
/* 18 */   private final List<Integer> ground = new ArrayList<>();
/* 19 */   private final List<Integer> air = new ArrayList<>();
/* 20 */   private final Map<Integer, Integer> invalidGround = new HashMap<>();
/* 21 */   private final List<Integer> swing = new ArrayList<>();
/* 22 */   private final List<Integer> invisible = new ArrayList<>();
/* 23 */   private final List<Integer> hitted = new ArrayList<>();
/*    */   
/*    */   public void onDisable() {
/* 26 */     clearAll();
/* 27 */     super.onDisable();
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/* 32 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() == null || MinecraftInstance.mc.getTheWorld() == null) {
/*    */       return;
/*    */     }
/* 35 */     IPacket packet = event.getPacket();
/* 36 */     if (MinecraftInstance.classProvider.isSPacketEntity(packet)) {
/* 37 */       ISPacketEntity packetEntity = packet.asSPacketEntity();
/* 38 */       if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  IEntity entity = packetEntity.getEntity((IWorld)MinecraftInstance.mc.getTheWorld());
/*    */       
/* 40 */       if (MinecraftInstance.classProvider.isEntityPlayer(entity) && entity != null) {
/* 41 */         if (packetEntity.getOnGround() && !this.ground.contains(Integer.valueOf(entity.getEntityId())))
/* 42 */           this.ground.add(Integer.valueOf(entity.getEntityId())); 
/* 43 */         if (!packetEntity.getOnGround() && !this.air.contains(Integer.valueOf(entity.getEntityId())))
/* 44 */           this.air.add(Integer.valueOf(entity.getEntityId())); 
/* 45 */         if (packetEntity.getOnGround()) {
/* 46 */           if (entity.getPrevPosY() != entity.getPosY())
/* 47 */             this.invalidGround.put(Integer.valueOf(entity.getEntityId()), Integer.valueOf(((Number)this.invalidGround.getOrDefault(Integer.valueOf(entity.getEntityId()), Integer.valueOf(0))).intValue() + 1)); 
/*    */         } else {
/* 49 */           int currentVL = ((Number)this.invalidGround.getOrDefault(Integer.valueOf(entity.getEntityId()), Integer.valueOf(0))).intValue() / 2;
/* 50 */           if (currentVL <= 0) {
/* 51 */             this.invalidGround.remove(Integer.valueOf(entity.getEntityId()));
/*    */           } else {
/* 53 */             this.invalidGround.put(Integer.valueOf(entity.getEntityId()), Integer.valueOf(currentVL));
/*    */           } 
/* 55 */         }  if (entity.isInvisible() && !this.invisible.contains(Integer.valueOf(entity.getEntityId()))) this.invisible.add(Integer.valueOf(entity.getEntityId())); 
/*    */       } 
/*    */     } 
/* 58 */     if (MinecraftInstance.classProvider.isSPacketAnimation(packet)) {
/* 59 */       ISPacketAnimation packetAnimation = packet.asSPacketAnimation();
/* 60 */       if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  IEntity entity = MinecraftInstance.mc.getTheWorld().getEntityByID(packetAnimation.getEntityID());
/* 61 */       if (entity != null && MinecraftInstance.classProvider.isEntityLivingBase(entity) && packetAnimation.getAnimationType() == 0 && !this.swing.contains(Integer.valueOf(entity.getEntityId()))) this.swing.add(Integer.valueOf(entity.getEntityId())); 
/*    */     } 
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onAttack(@NotNull AttackEvent e) {
/* 67 */     Intrinsics.checkParameterIsNotNull(e, "e"); IEntity entity = e.getTargetEntity();
/* 68 */     if (entity != null && MinecraftInstance.classProvider.isEntityLivingBase(entity) && !this.hitted.contains(Integer.valueOf(entity.getEntityId()))) this.hitted.add(Integer.valueOf(entity.getEntityId())); 
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onWorld(@Nullable WorldEvent event) {
/* 73 */     clearAll();
/*    */   }
/*    */   
/*    */   private final void clearAll() {
/* 77 */     this.hitted.clear();
/* 78 */     this.swing.clear();
/* 79 */     this.ground.clear();
/* 80 */     this.invalidGround.clear();
/* 81 */     this.invisible.clear();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\hyt\HytAntiBot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */