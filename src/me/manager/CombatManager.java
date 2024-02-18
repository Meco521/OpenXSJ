/*    */ package me.manager;
/*    */ 
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*    */ import net.ccbluex.liquidbounce.event.AttackEvent;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.utils.EntityUtils;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000@\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\002\b\006\n\002\020\007\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\030\0002\0020\0012\0020\002B\005¢\006\002\020\003J\020\020\022\032\004\030\0010\r2\006\020\023\032\0020\024J\b\020\025\032\0020\005H\026J\020\020\026\032\0020\0272\006\020\030\032\0020\031H\007J\020\020\032\032\0020\0272\006\020\030\032\0020\033H\007R\032\020\004\032\0020\005X\016¢\006\016\n\000\032\004\b\006\020\007\"\004\b\b\020\tR\016\020\n\032\0020\013X\004¢\006\002\n\000R\034\020\f\032\004\030\0010\rX\016¢\006\016\n\000\032\004\b\016\020\017\"\004\b\020\020\021¨\006\034"}, d2 = {"Lme/manager/CombatManager;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "()V", "inCombat", "", "getInCombat", "()Z", "setInCombat", "(Z)V", "lastAttackTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "target", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "getTarget", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "setTarget", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)V", "getNearByEntity", "radius", "", "handleEvents", "onAttack", "", "event", "Lnet/ccbluex/liquidbounce/event/AttackEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class CombatManager extends MinecraftInstance implements Listenable {
/* 16 */   public final boolean getInCombat() { return this.inCombat; } private boolean inCombat; public final void setInCombat(boolean <set-?>) { this.inCombat = <set-?>; }
/* 17 */    private final MSTimer lastAttackTimer = new MSTimer(); @Nullable private IEntityLivingBase target; @Nullable
/* 18 */   public final IEntityLivingBase getTarget() { return this.target; } public final void setTarget(@Nullable IEntityLivingBase <set-?>) { this.target = <set-?>; }
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 22 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() == null)
/* 23 */       return;  MovementUtils.INSTANCE.updateBlocksPerSecond();
/*    */     
/* 25 */     this.inCombat = false;
/*    */     
/* 27 */     if (!this.lastAttackTimer.hasTimePassed(1000L)) {
/* 28 */       this.inCombat = true;
/*    */       
/*    */       return;
/*    */     } 
/* 32 */     if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  for (IEntity entity : MinecraftInstance.mc.getTheWorld().getLoadedEntityList()) {
/* 33 */       if (entity instanceof IEntityLivingBase) {
/* 34 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (entity.getDistanceToEntity((IEntity)MinecraftInstance.mc.getThePlayer()) < 7 && EntityUtils.isSelected(entity, true)) {
/* 35 */           this.inCombat = true;
/*    */           break;
/*    */         } 
/*    */       } 
/*    */     } 
/* 40 */     if (this.target != null)
/* 41 */     { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (this.target == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getDistanceToEntity((IEntity)this.target) <= 7 && this.inCombat) { if (this.target == null) Intrinsics.throwNpe();  if (this.target.isDead())
/* 42 */         { this.target = (IEntityLivingBase)null; return; }  return; }  } else { return; }  this.target = (IEntityLivingBase)null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public final void onAttack(@NotNull AttackEvent event) {
/* 49 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (event.getTargetEntity() instanceof IEntityLivingBase && EntityUtils.isSelected(event.getTargetEntity(), true)) {
/* 50 */       this.target = (IEntityLivingBase)event.getTargetEntity();
/*    */     }
/* 52 */     this.lastAttackTimer.reset();
/*    */   } @Nullable
/*    */   public final IEntityLivingBase getNearByEntity(float radius) {
/*    */     IEntityLivingBase iEntityLivingBase;
/*    */     try {
/* 57 */       if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  Iterable $this$filter$iv = MinecraftInstance.mc.getTheWorld().getLoadedEntityList();
/* 58 */       int $i$f$filter = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 69 */       Iterable iterable1 = $this$filter$iv; Collection destination$iv$iv = new ArrayList(); int $i$f$filterTo = 0;
/* 70 */       for (Object element$iv$iv : iterable1) { IEntity it = (IEntity)element$iv$iv; int $i$a$-filter-CombatManager$getNearByEntity$1 = 0; if (MinecraftInstance.mc.getThePlayer() == null)
/* 71 */           Intrinsics.throwNpe();  }  Iterable $this$sortedBy$iv = destination$iv$iv; int $i$f$sortedBy = 0;
/* 72 */       Iterable $this$filterTo$iv$iv = $this$sortedBy$iv; boolean bool = false; CombatManager$getNearByEntity$$inlined$sortedBy$1 combatManager$getNearByEntity$$inlined$sortedBy$1 = new CombatManager$getNearByEntity$$inlined$sortedBy$1(); iEntityLivingBase = CollectionsKt.sortedWith($this$filterTo$iv$iv, combatManager$getNearByEntity$$inlined$sortedBy$1).get(0);
/*    */     } catch (Exception e) {
/*    */       iEntityLivingBase = null;
/*    */     } 
/*    */     return iEntityLivingBase;
/*    */   }
/*    */   
/*    */   public boolean handleEvents() {
/*    */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\me\manager\CombatManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */