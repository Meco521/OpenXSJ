/*     */ package net.ccbluex.liquidbounce.injection.forge.mixins.entity;
/*     */ 
/*     */ import java.util.Objects;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.event.Event;
/*     */ import net.ccbluex.liquidbounce.event.JumpEvent;
/*     */ import net.ccbluex.liquidbounce.event.StrafeEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.movement.LiquidWalk;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.movement.NoJumpDelay;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.Animations;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.AntiBlind;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.init.MobEffects;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import net.minecraftforge.common.ForgeHooks;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Overwrite;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Mixin({EntityLivingBase.class})
/*     */ public abstract class MixinEntityLivingBase
/*     */   extends MixinEntity
/*     */ {
/*     */   @Shadow
/*     */   public int field_184628_bn;
/*     */   @Shadow
/*     */   protected boolean field_70703_bu;
/*     */   @Shadow
/*     */   private int field_70773_bE;
/*     */   
/*     */   @Shadow
/*     */   public abstract boolean func_184587_cr();
/*     */   
/*     */   @Shadow
/*     */   public abstract ItemStack func_184607_cu();
/*     */   
/*     */   @Shadow
/*     */   protected abstract float func_175134_bD();
/*     */   
/*     */   @Shadow
/*     */   public abstract PotionEffect func_70660_b(Potion paramPotion);
/*     */   
/*     */   @Shadow
/*     */   public abstract boolean func_70644_a(Potion paramPotion);
/*     */   
/*     */   @Shadow
/*     */   public void func_70636_d() {}
/*     */   
/*     */   @Shadow
/*     */   protected abstract void func_184231_a(double paramDouble, boolean paramBoolean, IBlockState paramIBlockState, BlockPos paramBlockPos);
/*     */   
/*     */   @Shadow
/*     */   public abstract float func_110143_aJ();
/*     */   
/*     */   @Shadow
/*     */   public abstract ItemStack func_184586_b(EnumHand paramEnumHand);
/*     */   
/*     */   @Shadow
/*     */   protected abstract void func_70626_be();
/*     */   
/*     */   @Shadow
/*     */   protected abstract void func_70629_bd();
/*     */   
/*     */   @Shadow
/*     */   public abstract boolean func_184613_cA();
/*     */   
/*     */   @Shadow
/*     */   public abstract int func_184605_cv();
/*     */   
/*     */   @Overwrite
/*     */   protected void func_70664_aZ() {
/*  87 */     JumpEvent jumpEvent = new JumpEvent(func_175134_bD());
/*  88 */     Retreat.eventManager.callEvent((Event)jumpEvent);
/*  89 */     if (jumpEvent.isCancelled()) {
/*     */       return;
/*     */     }
/*  92 */     this.field_70181_x = jumpEvent.getMotion();
/*     */     
/*  94 */     if (func_70644_a(MobEffects.field_76430_j)) {
/*  95 */       this.field_70181_x += ((func_70660_b(MobEffects.field_76430_j).func_76458_c() + 1) * 0.1F);
/*     */     }
/*  97 */     if (func_70051_ag()) {
/*  98 */       float f = this.field_70177_z * 0.017453292F;
/*  99 */       this.field_70159_w -= (MathHelper.func_76126_a(f) * 0.2F);
/* 100 */       this.field_70179_y += (MathHelper.func_76134_b(f) * 0.2F);
/*     */     } 
/*     */     
/* 103 */     this.field_70160_al = true;
/* 104 */     ForgeHooks.onLivingJump((EntityLivingBase)this);
/*     */   }
/*     */   
/*     */   @Inject(method = {"onLivingUpdate"}, at = {@At("HEAD")})
/*     */   private void headLiving(CallbackInfo callbackInfo) {
/* 109 */     if (((Module)Objects.<Module>requireNonNull(Retreat.moduleManager.getModule(NoJumpDelay.class))).getState())
/* 110 */       this.field_70773_bE = 0; 
/*     */   }
/*     */   
/*     */   @Inject(method = {"onLivingUpdate"}, at = {@At(value = "FIELD", target = "Lnet/minecraft/entity/EntityLivingBase;isJumping:Z", ordinal = 1)})
/*     */   private void onJumpSection(CallbackInfo callbackInfo) {
/* 115 */     LiquidWalk liquidWalk = (LiquidWalk)Retreat.moduleManager.getModule(LiquidWalk.class);
/*     */     
/* 117 */     if (((LiquidWalk)Objects.<LiquidWalk>requireNonNull(liquidWalk)).getState() && !this.field_70703_bu && !func_70093_af() && func_70090_H() && ((String)liquidWalk
/* 118 */       .getModeValue().get()).equalsIgnoreCase("Swim")) {
/* 119 */       func_70629_bd();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @Inject(method = {"getLook"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void getLook(CallbackInfoReturnable<Vec3d> callbackInfoReturnable) {
/* 126 */     if ((EntityLivingBase)this instanceof net.minecraft.client.entity.EntityPlayerSP)
/* 127 */       callbackInfoReturnable.setReturnValue(func_174806_f(this.field_70125_A, this.field_70177_z)); 
/*     */   }
/*     */   
/*     */   @Inject(method = {"isPotionActive(Lnet/minecraft/potion/Potion;)Z"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void isPotionActive(Potion p_isPotionActive_1_, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
/* 132 */     AntiBlind antiBlind = (AntiBlind)Retreat.moduleManager.getModule(AntiBlind.class);
/*     */     
/* 134 */     if ((p_isPotionActive_1_ == MobEffects.field_76431_k || p_isPotionActive_1_ == MobEffects.field_76440_q) && ((AntiBlind)Objects.<AntiBlind>requireNonNull(antiBlind)).getState() && ((Boolean)antiBlind.getConfusionEffect().get()).booleanValue())
/* 135 */       callbackInfoReturnable.setReturnValue(Boolean.valueOf(false)); 
/*     */   }
/*     */   @Overwrite
/*     */   private int func_82166_i() {
/* 139 */     int speed = Retreat.moduleManager.getModule(Animations.class).getState() ? (2 + 20 - ((Integer)Animations.SpeedSwing.get()).intValue()) : 6;
/* 140 */     return func_70644_a(MobEffects.field_76424_c) ? (speed - 1 + func_70660_b(MobEffects.field_76424_c).func_76458_c()) : (func_70644_a(MobEffects.field_76421_d) ? (speed + (1 + func_70660_b(MobEffects.field_76421_d).func_76458_c()) * 2) : speed);
/*     */   }
/*     */   
/*     */   @Inject(method = {"moveRelative"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void handleRotations(float strafe, float up, float forward, float friction, CallbackInfo callbackInfo) {
/* 145 */     if (this != (Minecraft.func_71410_x()).field_71439_g) {
/*     */       return;
/*     */     }
/* 148 */     StrafeEvent strafeEvent = new StrafeEvent(strafe, forward, friction);
/* 149 */     Retreat.eventManager.callEvent((Event)strafeEvent);
/*     */     
/* 151 */     if (strafeEvent.isCancelled())
/* 152 */       callbackInfo.cancel(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\entity\MixinEntityLivingBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */