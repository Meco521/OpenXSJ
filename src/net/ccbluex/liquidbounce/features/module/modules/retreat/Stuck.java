/*    */ package net.ccbluex.liquidbounce.features.module.modules.retreat;
/*    */ 
/*    */ import javax.vecmath.Vector2f;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.IMinecraft;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.injection.backend.MinecraftImpl;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.minecraft.network.Packet;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "Stuck", description = "c0w", category = ModuleCategory.RETREAT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0008\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\006\n\002\b\013\n\002\020\013\n\002\b\005\n\002\030\002\n\002\b\016\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020$\032\0020%H\027J\020\020&\032\0020%2\006\020'\032\0020(H\007J\020\020)\032\0020%2\006\020'\032\0020*H\007R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\032\020\t\032\0020\004X\016¢\006\016\n\000\032\004\b\n\020\006\"\004\b\013\020\bR\032\020\f\032\0020\004X\016¢\006\016\n\000\032\004\b\r\020\006\"\004\b\016\020\bR\032\020\017\032\0020\020X\016¢\006\016\n\000\032\004\b\021\020\022\"\004\b\023\020\024R\032\020\025\032\0020\026X\016¢\006\016\n\000\032\004\b\027\020\030\"\004\b\031\020\032R\032\020\033\032\0020\004X\016¢\006\016\n\000\032\004\b\034\020\006\"\004\b\035\020\bR\032\020\036\032\0020\004X\016¢\006\016\n\000\032\004\b\037\020\006\"\004\b \020\bR\032\020!\032\0020\004X\016¢\006\016\n\000\032\004\b\"\020\006\"\004\b#\020\b¨\006+"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/retreat/Stuck;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "motionX", "", "getMotionX", "()D", "setMotionX", "(D)V", "motionY", "getMotionY", "setMotionY", "motionZ", "getMotionZ", "setMotionZ", "onGround", "", "getOnGround", "()Z", "setOnGround", "(Z)V", "rotation", "Ljavax/vecmath/Vector2f;", "getRotation", "()Ljavax/vecmath/Vector2f;", "setRotation", "(Ljavax/vecmath/Vector2f;)V", "x", "getX", "setX", "y", "getY", "setY", "z", "getZ", "setZ", "onEnable", "", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class Stuck extends Module {
/*    */   private double x;
/*    */   private double y;
/*    */   private double z;
/*    */   
/* 19 */   public final double getX() { return this.x; } public final void setX(double <set-?>) { this.x = <set-?>; }
/* 20 */   public final double getY() { return this.y; } public final void setY(double <set-?>) { this.y = <set-?>; }
/* 21 */   public final double getZ() { return this.z; } public final void setZ(double <set-?>) { this.z = <set-?>; } @NotNull
/* 22 */   private Vector2f rotation = new Vector2f(); private double motionX; private double motionY; private double motionZ; private boolean onGround; @NotNull public final Vector2f getRotation() { return this.rotation; } public final void setRotation(@NotNull Vector2f <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.rotation = <set-?>; }
/* 23 */   public final double getMotionX() { return this.motionX; } public final void setMotionX(double <set-?>) { this.motionX = <set-?>; }
/* 24 */   public final double getMotionY() { return this.motionY; } public final void setMotionY(double <set-?>) { this.motionY = <set-?>; }
/* 25 */   public final double getMotionZ() { return this.motionZ; } public final void setMotionZ(double <set-?>) { this.motionZ = <set-?>; }
/* 26 */   public final boolean getOnGround() { return this.onGround; } public final void setOnGround(boolean <set-?>) { this.onGround = <set-?>; }
/*    */   
/*    */   @EventTarget
/*    */   public void onEnable() {
/* 30 */     if (MinecraftInstance.mc.getThePlayer() == null) {
/*    */       return;
/*    */     }
/* 33 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.x = MinecraftInstance.mc.getThePlayer().getPosX();
/* 34 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.y = MinecraftInstance.mc.getThePlayer().getPosY();
/* 35 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.z = MinecraftInstance.mc.getThePlayer().getPosZ();
/* 36 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.motionX = MinecraftInstance.mc.getThePlayer().getMotionX();
/* 37 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.motionY = MinecraftInstance.mc.getThePlayer().getMotionY();
/* 38 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.motionZ = MinecraftInstance.mc.getThePlayer().getMotionZ();
/* 39 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.rotation = new Vector2f(MinecraftInstance.mc.getThePlayer().getRotationYaw(), MinecraftInstance.mc.getThePlayer().getRotationPitch());
/* 40 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.onGround = MinecraftInstance.mc.getThePlayer().getOnGround();
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/* 45 */     Intrinsics.checkParameterIsNotNull(event, "event"); IPacket $this$unwrap$iv = event.getPacket(); int $i$f$unwrap = 0;
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
/* 77 */     if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.PacketImpl<*>");  Packet packet = ((PacketImpl)$this$unwrap$iv).getWrapped(); Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc"); IMinecraft iMinecraft = MinecraftInstance.mc; int i = 0;
/* 78 */     if (iMinecraft == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.MinecraftImpl");  if (((MinecraftImpl)iMinecraft).getWrapped().func_147114_u() != null) { Intrinsics.checkExpressionValueIsNotNull(((MinecraftImpl)iMinecraft).getWrapped().func_147114_u(), "mc.unwrap().connection ?: return"); NetHandlerPlayClient connection = ((MinecraftImpl)iMinecraft).getWrapped().func_147114_u(); if (packet instanceof CPacketPlayerTryUseItem) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  Vector2f current = new Vector2f(MinecraftInstance.mc.getThePlayer().getRotationYaw(), MinecraftInstance.mc.getThePlayer().getRotationPitch()); float f = MinecraftInstance.mc.getGameSettings().getMouseSensitivity() * 0.6F + 0.2F; float gcd = f * f * f * 1.2F; Vector2f vector2f = current; vector2f.x -= current.x % gcd; Vector2f vector2f2 = current; vector2f2.y -= current.y % gcd; if (this.rotation.equals((Tuple2f)current)) return;  this.rotation = current; event.cancelEvent(); connection.func_147297_a((Packet)new CPacketPlayerTryUseItem(EnumHand.OFF_HAND)); connection.func_147297_a((Packet)new CPacketPlayer.Rotation(current.x, current.y, this.onGround)); }  }  ((MinecraftImpl)iMinecraft).getWrapped().func_147114_u();
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/*    */     Intrinsics.checkParameterIsNotNull(event, "event");
/*    */     if (MinecraftInstance.mc.getThePlayer() == null)
/*    */       Intrinsics.throwNpe(); 
/*    */     MinecraftInstance.mc.getThePlayer().setMotionX(0.0D);
/*    */     if (MinecraftInstance.mc.getThePlayer() == null)
/*    */       Intrinsics.throwNpe(); 
/*    */     MinecraftInstance.mc.getThePlayer().setMotionY(0.0D);
/*    */     if (MinecraftInstance.mc.getThePlayer() == null)
/*    */       Intrinsics.throwNpe(); 
/*    */     MinecraftInstance.mc.getThePlayer().setMotionZ(0.0D);
/*    */     if (MinecraftInstance.mc.getThePlayer() == null)
/*    */       Intrinsics.throwNpe(); 
/*    */     MinecraftInstance.mc.getThePlayer().setPosition(this.x, this.y, this.z);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\retreat\Stuck.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */