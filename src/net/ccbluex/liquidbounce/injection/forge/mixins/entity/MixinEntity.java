/*     */ package net.ccbluex.liquidbounce.injection.forge.mixins.entity;
/*     */ 
/*     */ import java.util.Objects;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import javax.annotation.Nullable;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.event.Event;
/*     */ import net.ccbluex.liquidbounce.event.StrafeEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.combat.HitBox;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.combat.StrafeFix;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.exploit.NoPitchLimit;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.MoverType;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.util.math.AxisAlignedBB;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import org.spongepowered.asm.mixin.Final;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ @Mixin({Entity.class})
/*     */ public abstract class MixinEntity
/*     */ {
/*     */   @Shadow
/*     */   public double field_70165_t;
/*     */   @Shadow
/*     */   public double field_70163_u;
/*     */   @Shadow
/*     */   public double field_70161_v;
/*     */   @Shadow
/*     */   public float field_70125_A;
/*     */   @Shadow
/*     */   public float field_70177_z;
/*     */   @Shadow
/*     */   public Entity field_184239_as;
/*     */   @Shadow
/*     */   public double field_70159_w;
/*     */   @Shadow
/*     */   public double field_70181_x;
/*     */   @Shadow
/*     */   public double field_70179_y;
/*     */   @Shadow
/*     */   public boolean field_70122_E;
/*     */   @Shadow
/*     */   public boolean field_70160_al;
/*     */   @Shadow
/*     */   public boolean field_70145_X;
/*     */   @Shadow
/*     */   public World field_70170_p;
/*     */   @Shadow
/*     */   public boolean field_70134_J;
/*     */   @Shadow
/*     */   public float field_70138_W;
/*     */   @Shadow
/*     */   public boolean field_70123_F;
/*     */   @Shadow
/*     */   public boolean field_70124_G;
/*     */   @Shadow
/*     */   public boolean field_70132_H;
/*     */   @Shadow
/*     */   public float field_70140_Q;
/*     */   @Shadow
/*     */   public float field_82151_R;
/*     */   @Shadow
/*     */   public int field_71088_bW;
/*     */   @Shadow
/*     */   public float field_70130_N;
/*     */   @Shadow
/*     */   public int field_70150_b;
/*     */   @Shadow
/*     */   public int field_190534_ay;
/*     */   @Shadow
/*     */   public float field_70127_C;
/*     */   @Shadow
/*     */   public float field_70126_B;
/*     */   @Shadow
/*     */   public long field_191506_aJ;
/*     */   @Shadow
/*     */   @Final
/*     */   public double[] field_191505_aI;
/*     */   @Shadow
/*     */   public float field_191959_ay;
/*     */   @Shadow
/*     */   protected Random field_70146_Z;
/*     */   @Shadow
/*     */   protected boolean field_71087_bX;
/*     */   
/*     */   @Shadow
/*     */   public abstract boolean func_70051_ag();
/*     */   
/*     */   @Shadow
/*     */   public abstract AxisAlignedBB func_174813_aQ();
/*     */   
/*     */   @Shadow
/*     */   public abstract void func_174826_a(AxisAlignedBB paramAxisAlignedBB);
/*     */   
/*     */   @Shadow
/*     */   public void func_70091_d(MoverType p_move_1_, double p_move_2_, double p_move_4_, double p_move_4_2) {}
/*     */   
/*     */   @Shadow
/*     */   public abstract boolean func_70090_H();
/*     */   
/*     */   @Shadow
/*     */   protected abstract int func_190531_bD();
/*     */   
/*     */   @Shadow
/*     */   public abstract boolean func_184218_aH();
/*     */   
/*     */   @Shadow
/*     */   protected abstract void func_70081_e(int paramInt);
/*     */   
/*     */   @Shadow
/*     */   public abstract boolean func_70026_G();
/*     */   
/*     */   @Shadow
/*     */   public abstract void func_85029_a(CrashReportCategory paramCrashReportCategory);
/*     */   
/*     */   @Shadow
/*     */   protected abstract void func_145775_I();
/*     */   
/*     */   @Shadow
/*     */   protected abstract void func_180429_a(BlockPos paramBlockPos, Block paramBlock);
/*     */   
/*     */   @Shadow
/*     */   protected abstract Vec3d func_174806_f(float paramFloat1, float paramFloat2);
/*     */   
/*     */   @Shadow
/*     */   public abstract UUID func_110124_au();
/*     */   
/*     */   @Shadow
/*     */   public abstract boolean func_70093_af();
/*     */   
/*     */   @Shadow
/*     */   public abstract boolean func_70055_a(Material paramMaterial);
/*     */   
/*     */   @Shadow
/*     */   @Nullable
/*     */   public abstract Entity func_184187_bx();
/*     */   
/*     */   @Shadow
/*     */   public abstract void func_174829_m();
/*     */   
/*     */   @Shadow
/*     */   protected abstract void func_184231_a(double paramDouble, boolean paramBoolean, IBlockState paramIBlockState, BlockPos paramBlockPos);
/*     */   
/*     */   @Shadow
/*     */   protected abstract boolean func_70041_e_();
/*     */   
/*     */   @Shadow
/*     */   public abstract boolean func_184207_aI();
/*     */   
/*     */   @Shadow
/*     */   @Nullable
/*     */   public abstract Entity func_184179_bs();
/*     */   
/*     */   @Shadow
/*     */   public abstract void func_184185_a(SoundEvent paramSoundEvent, float paramFloat1, float paramFloat2);
/*     */   
/*     */   @Shadow
/*     */   protected abstract SoundEvent func_184184_Z();
/*     */   
/*     */   @Shadow
/*     */   protected abstract boolean func_191957_ae();
/*     */   
/*     */   @Shadow
/*     */   protected abstract float func_191954_d(float paramFloat);
/*     */   
/*     */   @Shadow
/*     */   public abstract boolean func_70027_ad();
/*     */   
/*     */   public int getNextStepDistance() {
/* 191 */     return this.field_70150_b;
/*     */   }
/*     */   
/*     */   public void setNextStepDistance(int nextStepDistance) {
/* 195 */     this.field_70150_b = nextStepDistance;
/*     */   }
/*     */   
/*     */   public int getFire() {
/* 199 */     return this.field_190534_ay;
/*     */   }
/*     */   
/*     */   @Shadow
/*     */   public abstract void func_70015_d(int paramInt);
/*     */   
/*     */   @Inject(method = {"getCollisionBorderSize"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void getCollisionBorderSize(CallbackInfoReturnable<Float> callbackInfoReturnable) {
/* 207 */     HitBox hitBox = (HitBox)Retreat.moduleManager.getModule(HitBox.class);
/*     */     
/* 209 */     if (((HitBox)Objects.<HitBox>requireNonNull(hitBox)).getState())
/* 210 */       callbackInfoReturnable.setReturnValue(Float.valueOf(0.1F + ((Float)hitBox.getSizeValue().get()).floatValue())); 
/*     */   }
/*     */   @Inject(method = {"moveFlying"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void handleRotations(float strafe, float forward, float friction, CallbackInfo callbackInfo) {
/* 214 */     if (this != (Minecraft.func_71410_x()).field_71439_g) {
/*     */       return;
/*     */     }
/* 217 */     StrafeEvent strafeEvent = new StrafeEvent(strafe, forward, friction);
/* 218 */     StrafeFix strafeFix = (StrafeFix)Retreat.moduleManager.getModule(StrafeFix.class);
/*     */     
/* 220 */     Retreat.eventManager.callEvent((Event)strafeEvent);
/* 221 */     if (strafeFix.getDoFix()) {
/* 222 */       strafeFix.runStrafeFixLoop(strafeFix.getSilentFix(), strafeEvent);
/*     */     }
/* 224 */     if (strafeEvent.isCancelled())
/* 225 */       callbackInfo.cancel(); 
/*     */   }
/*     */   
/*     */   @Inject(method = {"turn"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void setAngles(float yaw, float pitch, CallbackInfo callbackInfo) {
/* 230 */     if (((Module)Objects.<Module>requireNonNull(Retreat.moduleManager.getModule(NoPitchLimit.class))).getState()) {
/* 231 */       callbackInfo.cancel();
/*     */       
/* 233 */       float f = this.field_70125_A;
/* 234 */       float f1 = this.field_70177_z;
/* 235 */       this.field_70177_z = (float)(this.field_70177_z + yaw * 0.15D);
/* 236 */       this.field_70125_A = (float)(this.field_70125_A - pitch * 0.15D);
/* 237 */       this.field_70127_C += this.field_70125_A - f;
/* 238 */       this.field_70126_B += this.field_70177_z - f1;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\entity\MixinEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */