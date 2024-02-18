/*    */ package net.ccbluex.liquidbounce.features.module.modules.retreat;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.extensions.PlayerExtensionKt;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "EntitySpeed", description = "from kid", category = ModuleCategory.RETREAT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000F\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\b\n\000\n\002\030\002\n\002\b\004\n\002\020\013\n\002\b\003\n\002\030\002\n\002\b\f\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\036\032\0020\037H\026J\020\020 \032\0020\0372\006\020!\032\0020\"H\007J\020\020#\032\0020\0372\006\020!\032\0020$H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\007X\016¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\n\032\0020\tX\004¢\006\002\n\000R\016\020\013\032\0020\tX\004¢\006\002\n\000R\016\020\f\032\0020\tX\004¢\006\002\n\000R\016\020\r\032\0020\016X\016¢\006\002\n\000R\016\020\017\032\0020\007X\016¢\006\002\n\000R\016\020\020\032\0020\tX\004¢\006\002\n\000R\016\020\021\032\0020\022X\004¢\006\002\n\000R\016\020\023\032\0020\016X\016¢\006\002\n\000R\016\020\024\032\0020\tX\004¢\006\002\n\000R\016\020\025\032\0020\022X\004¢\006\002\n\000R\032\020\026\032\0020\016X\016¢\006\016\n\000\032\004\b\027\020\030\"\004\b\031\020\032R\032\020\033\032\0020\016X\016¢\006\016\n\000\032\004\b\034\020\030\"\004\b\035\020\032¨\006%"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/retreat/EntitySpeed;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "distance", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "distance2", "f", "", "hurtcancle", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "keepSprint", "okstrafe", "onlyAir", "pre", "", "speed", "speedUp", "speedd", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "speeded", "speedplus", "speedplusvaule", "sprint", "getSprint", "()Z", "setSprint", "(Z)V", "strgo", "getStrgo", "setStrgo", "onEnable", "", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class EntitySpeed extends Module {
/* 17 */   private final BoolValue onlyAir = new BoolValue("OnlyAir", false);
/* 18 */   private final BoolValue okstrafe = new BoolValue("Strafe", false);
/* 19 */   private final BoolValue keepSprint = new BoolValue("KeepSprint", false);
/* 20 */   private final BoolValue speedUp = new BoolValue("SpeedUp", false);
/* 21 */   private final BoolValue hurtcancle = new BoolValue("Hurtcancle", false);
/*    */   
/* 23 */   private final BoolValue speedplus = new BoolValue("Speedplus", true);
/* 24 */   private final IntegerValue speedplusvaule = new IntegerValue("Speedplusvaule", 0, 0, 10);
/* 25 */   private final IntegerValue speedd = new IntegerValue("Speed", 0, 0, 10);
/*    */   private int speed;
/* 27 */   private final FloatValue distance = new FloatValue("speedRange", 0.0F, 0.0F, 3.0F);
/* 28 */   private final FloatValue distance2 = new FloatValue("starfeRange", 0.0F, 0.0F, 3.0F);
/*    */   private boolean speeded; private int f; private boolean strgo; private boolean pre; private boolean sprint;
/*    */   
/* 31 */   public final boolean getStrgo() { return this.strgo; } public final void setStrgo(boolean <set-?>) { this.strgo = <set-?>; }
/*    */   
/* 33 */   public final boolean getSprint() { return this.sprint; } public final void setSprint(boolean <set-?>) { this.sprint = <set-?>; }
/*    */   
/*    */   public void onEnable() {
/* 36 */     this.speeded = false;
/*    */   }
/*    */   
/*    */   @EventTarget
/* 40 */   public final void onPacket(@NotNull PacketEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); IPacket $this$unwrap$iv = event.getPacket(); int $i$f$unwrap = 0;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 88 */     if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.PacketImpl<*>");  Packet packet = ((PacketImpl)$this$unwrap$iv).getWrapped(); if (packet instanceof net.minecraft.network.play.server.SPacketPlayerPosLook) this.f = 10;  } @EventTarget public final void onUpdate(@NotNull UpdateEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); this.speed = ((Number)this.speedd.get()).intValue(); int i; this.f = (i = this.f) + -1; if (this.f >= 0) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionX(MinecraftInstance.mc.getThePlayer().getMotionX() * true); MinecraftInstance.mc.getGameSettings().getKeyBindForward().setPressed(false); MinecraftInstance.mc.getGameSettings().getKeyBindLeft().setPressed(false); MinecraftInstance.mc.getGameSettings().getKeyBindBack().setPressed(false); MinecraftInstance.mc.getGameSettings().getKeyBindRight().setPressed(false); MinecraftInstance.mc.getGameSettings().getKeyBindJump().setPressed(false); return; }  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHurtTime() > 0 && ((Boolean)this.hurtcancle.get()).booleanValue()) return;  if (MinecraftInstance.mc.getTheWorld() == null)
/* 89 */       Intrinsics.throwNpe();  for (IEntity entity : MinecraftInstance.mc.getTheWorld().getLoadedEntityList()) { IEntity $this$unwrap$iv = entity; int $i$f$unwrap = 0; if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.EntityImpl<*>");  if (((EntityImpl)$this$unwrap$iv).getWrapped() instanceof net.minecraft.entity.EntityLivingBase) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (entity.getEntityId() != MinecraftInstance.mc.getThePlayer().getEntityId()) {
/*    */           if (MinecraftInstance.mc.getThePlayer() == null)
/*    */             Intrinsics.throwNpe(); 
/*    */           if (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) <= ((Number)this.distance.get()).doubleValue()) {
/*    */             if (((Boolean)this.onlyAir.get()).booleanValue()) {
/*    */               if (MinecraftInstance.mc.getThePlayer() == null)
/*    */                 Intrinsics.throwNpe(); 
/*    */               if (!MinecraftInstance.mc.getThePlayer().getOnGround()) {
/*    */                 if (((Boolean)this.speedplus.get()).booleanValue()) {
/*    */                   if (MinecraftInstance.mc.getThePlayer() == null)
/*    */                     Intrinsics.throwNpe(); 
/*    */                   this.speed = (int)(((Number)this.speedd.get()).doubleValue() + ((Number)this.speedplusvaule.get()).doubleValue() * (true - PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) / ((Number)this.distance.get()).doubleValue()));
/*    */                 } 
/*    */                 if (((Boolean)this.speedUp.get()).booleanValue()) {
/*    */                   if (MinecraftInstance.mc.getThePlayer() == null)
/*    */                     Intrinsics.throwNpe(); 
/*    */                   MinecraftInstance.mc.getThePlayer().setMotionX(MinecraftInstance.mc.getThePlayer().getMotionX() * (true + this.speed * 0.01D));
/*    */                   if (MinecraftInstance.mc.getThePlayer() == null)
/*    */                     Intrinsics.throwNpe(); 
/*    */                   MinecraftInstance.mc.getThePlayer().setMotionZ(MinecraftInstance.mc.getThePlayer().getMotionZ() * (true + this.speed * 0.01D));
/*    */                 } 
/*    */                 if (((Boolean)this.keepSprint.get()).booleanValue())
/*    */                   this.sprint = true; 
/*    */                 if (((Boolean)this.okstrafe.get()).booleanValue()) {
/*    */                   if (MinecraftInstance.mc.getThePlayer() == null)
/*    */                     Intrinsics.throwNpe(); 
/*    */                   if (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) <= ((Number)this.distance2.get()).doubleValue())
/*    */                     this.strgo = true; 
/*    */                 } 
/*    */                 return;
/*    */               } 
/*    */               continue;
/*    */             } 
/*    */           } else {
/*    */             continue;
/*    */           } 
/*    */         }  }
/*    */       
/*    */       continue;
/*    */       this.sprint = false;
/*    */       this.strgo = false; }
/*    */      }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\retreat\EntitySpeed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */