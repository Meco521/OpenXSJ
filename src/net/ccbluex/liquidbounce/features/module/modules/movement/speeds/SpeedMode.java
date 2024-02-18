/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement.speeds;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.features.module.modules.movement.Speed;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000*\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\002\n\002\020\013\n\002\b\004\n\002\020\002\n\002\b\004\n\002\030\002\n\002\b\003\b&\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\b\020\n\032\0020\013H\026J\b\020\f\032\0020\013H\026J\b\020\r\032\0020\013H&J\020\020\016\032\0020\0132\006\020\017\032\0020\020H&J\b\020\021\032\0020\013H\026J\b\020\022\032\0020\013H&R\021\020\005\032\0020\0068F¢\006\006\032\004\b\005\020\007R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\b\020\t¨\006\023"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "modeName", "", "(Ljava/lang/String;)V", "isActive", "", "()Z", "getModeName", "()Ljava/lang/String;", "onDisable", "", "onEnable", "onMotion", "onMove", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onTick", "onUpdate", "XSJClient"})
/*    */ public abstract class SpeedMode extends MinecraftInstance {
/*    */   @NotNull
/*  8 */   public final String getModeName() { return this.modeName; } @NotNull private final String modeName; public SpeedMode(@NotNull String modeName) { this.modeName = modeName; }
/*    */   
/*    */   public final boolean isActive() {
/* 11 */     Speed speed = (Speed)Retreat.INSTANCE.getModuleManager().getModule(Speed.class);
/* 12 */     if (speed != null) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().isSneaking() && speed.getState() && Intrinsics.areEqual(speed.getModeValue().get(), this.modeName)); }  return false;
/*    */   }
/*    */   
/*    */   public void onTick() {}
/*    */   
/*    */   public void onEnable() {}
/*    */   
/*    */   public void onDisable() {}
/*    */   
/*    */   public abstract void onMotion();
/*    */   
/*    */   public abstract void onUpdate();
/*    */   
/*    */   public abstract void onMove(@NotNull MoveEvent paramMoveEvent);
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\speeds\SpeedMode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */