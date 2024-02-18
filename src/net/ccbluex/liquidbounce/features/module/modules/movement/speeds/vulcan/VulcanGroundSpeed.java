/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.vulcan;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.MovementUtils;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000@\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\020\b\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020\006\n\000\n\002\020\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\002\b\003\030\0002\0020\001B\005¢\006\002\020\002J\b\020\r\032\0020\016H\026J\b\020\017\032\0020\016H\026J\b\020\020\032\0020\016H\026J\020\020\021\032\0020\0162\006\020\022\032\0020\023H\026J\016\020\024\032\0020\0162\006\020\022\032\0020\025J\b\020\026\032\0020\016H\026J\b\020\027\032\0020\016H\026R\024\020\003\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\b\032\0020\005X\016¢\006\002\n\000R\016\020\t\032\0020\nX\016¢\006\002\n\000R\016\020\013\032\0020\fX\016¢\006\002\n\000¨\006\030"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/vulcan/VulcanGroundSpeed;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "()V", "boostDelayValue", "Lnet/ccbluex/liquidbounce/value/Value;", "", "boostSpeedValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "jumpCount", "jumped", "", "yMotion", "", "onDisable", "", "onEnable", "onMotion", "onMove", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onTick", "onUpdate", "XSJClient"})
/*    */ public final class VulcanGroundSpeed extends SpeedMode {
/*    */   private final BoolValue boostSpeedValue;
/*    */   private final Value<Integer> boostDelayValue;
/*    */   
/* 18 */   public VulcanGroundSpeed() { super("VulcanGround");
/* 19 */     this.boostSpeedValue = new BoolValue("GroundBoost", true);
/* 20 */     this.boostDelayValue = (new IntegerValue("BoostDelay", 8, 2, 15)).displayable(new VulcanGroundSpeed$boostDelayValue$1()); } private boolean jumped; private int jumpCount; private double yMotion; @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class VulcanGroundSpeed$boostDelayValue$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return ((Boolean)VulcanGroundSpeed.this.boostSpeedValue.get()).booleanValue(); }
/*    */     
/*    */     VulcanGroundSpeed$boostDelayValue$1() {
/*    */       super(0);
/*    */     } }
/*    */   public void onTick() {}
/*    */   public void onMotion() {}
/*    */   public void onUpdate() {
/* 28 */     if (this.jumped) {
/* 29 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionY(-0.1D);
/* 30 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setOnGround(false);
/* 31 */       this.jumped = false;
/* 32 */       this.yMotion = 0.0D;
/*    */     } 
/* 34 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setJumpMovementFactor(0.025F);
/* 35 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround() && MovementUtils.isMoving()) {
/* 36 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().isCollidedHorizontally() || MinecraftInstance.mc.getGameSettings().getKeyBindJump().getPressed()) {
/* 37 */         if (!MinecraftInstance.mc.getGameSettings().getKeyBindJump().getPressed()) {
/* 38 */           if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().jump();
/*    */         } 
/*    */         return;
/*    */       } 
/* 42 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().jump();
/* 43 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionY(0.0D);
/* 44 */       this.yMotion = 0.1D + Math.random() * 0.03D;
/* 45 */       MovementUtils.strafe(0.48F + this.jumpCount * 0.001F); int i;
/* 46 */       this.jumpCount = (i = this.jumpCount) + 1;
/* 47 */       this.jumped = true;
/* 48 */     } else if (MovementUtils.isMoving()) {
/* 49 */       MovementUtils.strafe(0.27F + this.jumpCount * 0.0018F);
/*    */     } else {
/* 51 */       MovementUtils.INSTANCE.resetMotion(false);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void onDisable() {
/* 56 */     MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/* 57 */     MovementUtils.INSTANCE.resetMotion(false);
/*    */   }
/*    */   
/*    */   public void onEnable() {
/* 61 */     MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/*    */   }
/*    */   
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/* 65 */     Intrinsics.checkParameterIsNotNull(event, "event"); IPacket packet = event.getPacket();
/* 66 */     if (packet instanceof CPacketPlayer) {
/* 67 */       ((CPacketPlayer)packet).field_149477_b += this.yMotion;
/*    */     }
/*    */   }
/*    */   
/*    */   public void onMove(@NotNull MoveEvent event) {
/* 72 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (this.jumpCount >= ((Number)this.boostDelayValue.get()).intValue() && ((Boolean)this.boostSpeedValue.get()).booleanValue()) {
/* 73 */       event.setX(event.getX() * 1.718114514191981D);
/* 74 */       event.setZ(event.getZ() * 1.718114514191981D);
/* 75 */       this.jumpCount = 0;
/* 76 */     } else if (!((Boolean)this.boostSpeedValue.get()).booleanValue()) {
/* 77 */       this.jumpCount = 4;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\speeds\vulcan\VulcanGroundSpeed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */