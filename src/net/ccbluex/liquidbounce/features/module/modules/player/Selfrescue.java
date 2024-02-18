/*    */ package net.ccbluex.liquidbounce.features.module.modules.player;
/*    */ 
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.world.ScaffoldLB;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "Selfrescue", category = ModuleCategory.PLAYER, description = "skid")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\005\n\002\020\016\n\002\b\003\n\002\020\013\n\000\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\r\032\0020\016H\027J\020\020\017\032\0020\0202\006\020\021\032\0020\022H\007R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\024\020\t\032\0020\n8VX\004¢\006\006\032\004\b\013\020\f¨\006\023"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/player/Selfrescue;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "a", "", "getA", "()I", "setA", "(I)V", "tag", "", "getTag", "()Ljava/lang/String;", "isInVoid", "", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class Selfrescue extends Module {
/* 16 */   public final int getA() { return this.a; } private int a; public final void setA(int <set-?>) { this.a = <set-?>; } @EventTarget
/*    */   public boolean isInVoid() { byte b;
/*    */     char c;
/* 19 */     for (b = 0, c = ''; b <= c; b++) {
/* 20 */       if (MovementUtils.INSTANCE.isOnGround(b)) {
/* 21 */         return false;
/*    */       }
/*    */     } 
/* 24 */     return true; }
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 28 */     Intrinsics.checkParameterIsNotNull(event, "event"); this.a++;
/* 29 */     if (Retreat.INSTANCE.getModuleManager().get(ScaffoldLB.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.world.ScaffoldLB");  ScaffoldLB scaffoldLB = (ScaffoldLB)Retreat.INSTANCE.getModuleManager().get(ScaffoldLB.class);
/*    */ 
/*    */     
/* 32 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHurtTime() > 0) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().isCollidedHorizontally()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().isOnLadder() && isInVoid() && !scaffoldLB.getState())
/* 33 */         { scaffoldLB.setState(true);
/* 34 */           this.a = 0; return; }  }  }
/* 35 */      if (scaffoldLB.getState() && this.a >= 30)
/* 36 */       scaffoldLB.setState(false); 
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public String getTag() {
/* 41 */     return "CatBounce";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\player\Selfrescue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */