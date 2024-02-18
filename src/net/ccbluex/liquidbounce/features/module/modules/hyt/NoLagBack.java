/*    */ package net.ccbluex.liquidbounce.features.module.modules.hyt;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.TypeCastException;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "NoLagBack", description = "Fix", category = ModuleCategory.MISC)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000*\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\002\b\004\n\002\020\002\n\002\b\002\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\r\032\0020\016H\026J\b\020\017\032\0020\016H\007R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\005\032\0020\004X\016¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\024\020\b\032\0020\t8VX\004¢\006\006\032\004\b\n\020\013R\016\020\f\032\0020\004X\016¢\006\002\n\000¨\006\020"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/hyt/NoLagBack;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "a", "", "b", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "tag", "", "getTag", "()Ljava/lang/String;", "ticks", "onEnable", "", "onUpdate", "XSJClient"})
/*    */ public final class NoLagBack extends Module {
/* 19 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "AntiCheat", "AAC5" }, "AAC5"); private int ticks;
/*    */   private int a;
/*    */   private int b;
/*    */   
/*    */   public void onEnable() {
/* 24 */     this.ticks = 0;
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate() {
/* 29 */     String str = (String)this.modeValue.get(); int i = 0; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case -2116882767:
/* 30 */         if (str.equals("anticheat")) {
/* 31 */           if (this.ticks > 1000) {
/* 32 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().isOnLadder() && MinecraftInstance.mc.getGameSettings().getKeyBindJump().getPressed()) {
/* 33 */               if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionY(0.11D);
/*    */             } 
/*    */           } 
/* 36 */           if (this.ticks > 2000) {
/* 37 */             this.ticks = 0; break;
/*    */           } 
/* 39 */           this.ticks = (i = this.ticks) + 1;
/*    */         } 
/*    */         break;
/*    */       case 2986066:
/* 43 */         if (str.equals("aac5")) {
/* 44 */           if (Retreat.INSTANCE.getModuleManager().getModule(KillAura.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura");  KillAura Killaura = (KillAura)Retreat.INSTANCE.getModuleManager().getModule(KillAura.class);
/* 45 */           if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround()) {
/* 46 */             if (this.b == 0) {
/* 47 */               Killaura.getKeepSprintValue().set(Boolean.valueOf(true)); int k;
/* 48 */               this.b = (k = this.b) + 1;
/*    */             } 
/*    */           } else {
/* 51 */             this.b = 0;
/* 52 */             if (this.a == 0) {
/* 53 */               Killaura.getKeepSprintValue().set(Boolean.valueOf(false)); int k;
/* 54 */               this.a = (k = this.a) + 1;
/*    */             } 
/*    */           } 
/* 57 */           if (this.ticks > 250) {
/* 58 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().isOnLadder() && MinecraftInstance.mc.getGameSettings().getKeyBindJump().getPressed()) {
/* 59 */               if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionY(0.11D);
/*    */             } 
/*    */           } 
/* 62 */           if (this.ticks > 500) {
/* 63 */             this.ticks = 0; break;
/*    */           }  int j;
/* 65 */           this.ticks = (j = this.ticks) + 1;
/*    */         } 
/*    */         break; }
/*    */   
/*    */   }
/*    */   @NotNull
/*    */   public String getTag() {
/* 72 */     return (String)this.modeValue.get();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\hyt\NoLagBack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */