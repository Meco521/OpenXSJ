/*     */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*     */ 
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WMathHelper;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.StrafeEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.Rotation;
/*     */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "StrafeFix", description = "StrafeFix", category = ModuleCategory.MOVEMENT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0000\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\n\n\002\030\002\n\000\n\002\020\002\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\002\b\002\b\007\030\0002\0020\001B\005¢\006\002\020\002J\026\020\020\032\0020\0212\006\020\022\032\0020\0042\006\020\023\032\0020\004J\b\020\024\032\0020\021H\026J\020\020\025\032\0020\0212\006\020\026\032\0020\027H\007J\026\020\030\032\0020\0212\006\020\022\032\0020\0042\006\020\026\032\0020\031J\006\020\032\032\0020\021R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\032\020\t\032\0020\004X\016¢\006\016\n\000\032\004\b\t\020\006\"\004\b\n\020\bR\032\020\013\032\0020\004X\016¢\006\016\n\000\032\004\b\f\020\006\"\004\b\r\020\bR\016\020\016\032\0020\017X\004¢\006\002\n\000¨\006\033"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/StrafeFix;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "doFix", "", "getDoFix", "()Z", "setDoFix", "(Z)V", "isOverwrited", "setOverwrited", "silentFix", "getSilentFix", "setSilentFix", "silentFixVaule", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "applyForceStrafe", "", "isSilent", "runStrafeFix", "onDisable", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "runStrafeFixLoop", "Lnet/ccbluex/liquidbounce/event/StrafeEvent;", "updateOverwrite", "XSJClient"})
/*     */ public final class StrafeFix extends Module {
/*  22 */   private final BoolValue silentFixVaule = new BoolValue("Silent", true);
/*     */   
/*     */   private boolean silentFix;
/*     */   
/*     */   private boolean doFix;
/*     */   private boolean isOverwrited;
/*     */   
/*     */   public final boolean getSilentFix() {
/*  30 */     return this.silentFix; } public final void setSilentFix(boolean <set-?>) { this.silentFix = <set-?>; }
/*  31 */   public final boolean getDoFix() { return this.doFix; } public final void setDoFix(boolean <set-?>) { this.doFix = <set-?>; }
/*  32 */   public final boolean isOverwrited() { return this.isOverwrited; } public final void setOverwrited(boolean <set-?>) { this.isOverwrited = <set-?>; }
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/*  36 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (!this.isOverwrited) {
/*  37 */       this.silentFix = ((Boolean)this.silentFixVaule.get()).booleanValue();
/*  38 */       this.doFix = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void onDisable() {
/*  43 */     this.doFix = false;
/*     */   }
/*     */   
/*     */   public final void applyForceStrafe(boolean isSilent, boolean runStrafeFix) {
/*  47 */     this.silentFix = isSilent;
/*  48 */     this.doFix = runStrafeFix;
/*  49 */     this.isOverwrited = true;
/*     */   }
/*     */   
/*     */   public final void updateOverwrite() {
/*  53 */     this.isOverwrited = false;
/*  54 */     this.doFix = getState();
/*  55 */     this.silentFix = ((Boolean)this.silentFixVaule.get()).booleanValue();
/*     */   }
/*     */   
/*     */   public final void runStrafeFixLoop(boolean isSilent, @NotNull StrafeEvent event) {
/*  59 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (event.isCancelled()) {
/*     */       return;
/*     */     }
/*  62 */     if (RotationUtils.targetRotation != null) { Rotation rotation = RotationUtils.targetRotation; float yaw = rotation.component1();
/*  63 */       float strafe = event.getStrafe();
/*  64 */       float forward = event.getForward();
/*  65 */       float friction = event.getFriction();
/*  66 */       float factor = strafe * strafe + forward * forward;
/*     */ 
/*     */       
/*  69 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  int angleDiff = (int)((WMathHelper.wrapAngleTo180_float(MinecraftInstance.mc.getThePlayer().getRotationYaw() - yaw - 22.5F - 135.0F) + 180.0D) / 45.0D);
/*     */       
/*  71 */       float calcYaw = isSilent ? (
/*  72 */         yaw + 45.0F * angleDiff) : 
/*  73 */         yaw;
/*     */       
/*  75 */       float calcMoveDir = Math.max(Math.abs(strafe), Math.abs(forward));
/*  76 */       calcMoveDir *= calcMoveDir;
/*  77 */       float calcMultiplier = MathHelper.func_76129_c(calcMoveDir / Math.min(1.0F, calcMoveDir * 2.0F));
/*     */       
/*  79 */       if (isSilent) {
/*  80 */         switch (angleDiff) { case 1: case 3: case 5: case 7:
/*     */           case 9:
/*  82 */             if ((Math.abs(forward) > 0.005D || Math.abs(strafe) > 0.005D) && (Math.abs(forward) <= 0.005D || Math.abs(
/*  83 */                 strafe) <= 0.005D)) {
/*     */ 
/*     */               
/*  86 */               friction /= calcMultiplier; break;
/*  87 */             }  if (Math.abs(forward) > 0.005D && Math.abs(strafe) > 0.005D) {
/*  88 */               friction *= calcMultiplier;
/*     */             }
/*     */             break; }
/*     */       
/*     */       }
/*  93 */       if (factor >= 1.0E-4F) {
/*  94 */         factor = MathHelper.func_76129_c(factor);
/*     */         
/*  96 */         if (factor < 1.0F) {
/*  97 */           factor = 1.0F;
/*     */         }
/*     */         
/* 100 */         factor = friction / factor;
/* 101 */         strafe *= factor;
/* 102 */         forward *= factor;
/*     */         
/* 104 */         float yawSin = MathHelper.func_76126_a((float)(calcYaw * Math.PI / 180.0F));
/* 105 */         float yawCos = MathHelper.func_76134_b((float)(calcYaw * Math.PI / 180.0F));
/*     */         
/* 107 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionX(MinecraftInstance.mc.getThePlayer().getMotionX() + (strafe * yawCos - forward * yawSin));
/* 108 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionZ(MinecraftInstance.mc.getThePlayer().getMotionZ() + (forward * yawCos + strafe * yawSin));
/*     */       } 
/* 110 */       event.cancelEvent();
/*     */       return; }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\StrafeFix.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */