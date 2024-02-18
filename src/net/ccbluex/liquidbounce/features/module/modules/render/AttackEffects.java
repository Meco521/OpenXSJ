/*     */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*     */ 
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.DefaultConstructorMarker;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*     */ import net.ccbluex.liquidbounce.event.AttackEvent;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ 
/*     */ @ModuleInfo(name = "AttackEffects", category = ModuleCategory.RENDER, description = "skid")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000@\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\005\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\b\007\030\000 \0342\0020\001:\001\034B\005¢\006\002\020\002J\020\020\026\032\0020\0272\006\020\030\032\0020\031H\007J\020\020\032\032\0020\0272\006\020\030\032\0020\033H\007R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\t\032\0020\bX\004¢\006\002\n\000R\034\020\n\032\004\030\0010\013X\016¢\006\016\n\000\032\004\b\f\020\r\"\004\b\016\020\017R\034\020\020\032\004\030\0010\021X\016¢\006\016\n\000\032\004\b\022\020\023\"\004\b\024\020\025¨\006\035"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/AttackEffects;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "amount", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "getAmount", "()Lnet/ccbluex/liquidbounce/value/IntegerValue;", "lightingSoundValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "sound", "target", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "getTarget", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "setTarget", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)V", "target2", "Lnet/minecraft/entity/EntityLivingBase;", "getTarget2", "()Lnet/minecraft/entity/EntityLivingBase;", "setTarget2", "(Lnet/minecraft/entity/EntityLivingBase;)V", "onAttack", "", "event", "Lnet/ccbluex/liquidbounce/event/AttackEvent;", "onMotion", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "Companion", "XSJClient"})
/*     */ public final class AttackEffects
/*     */   extends Module
/*     */ {
/*     */   @NotNull
/*  28 */   private final IntegerValue amount = new IntegerValue("Amount", 5, 1, 20); @NotNull public final IntegerValue getAmount() { return this.amount; }
/*  29 */    private final BoolValue sound = new BoolValue("Sound", true); @Nullable private IEntityLivingBase target; @Nullable
/*  30 */   private EntityLivingBase target2; private final BoolValue lightingSoundValue = new BoolValue("LightingSound", true); @NotNull
/*     */   private static final ListValue mode; @Nullable
/*  32 */   public final IEntityLivingBase getTarget() { return this.target; } public final void setTarget(@Nullable IEntityLivingBase <set-?>) { this.target = <set-?>; } @Nullable
/*  33 */   public final EntityLivingBase getTarget2() { return this.target2; } public final void setTarget2(@Nullable EntityLivingBase <set-?>) { this.target2 = <set-?>; }
/*     */    @EventTarget
/*     */   public final void onAttack(@NotNull AttackEvent event) {
/*  36 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (event.getTargetEntity() instanceof IEntityLivingBase) this.target = (IEntityLivingBase)event.getTargetEntity(); 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onMotion(@NotNull MotionEvent event) {
/*  41 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (event.isPre())
/*     */     {
/*     */ 
/*     */ 
/*     */       
/*  46 */       if (this.target != null) { if (this.target == null) Intrinsics.throwNpe();  if (this.target.getHurtTime() >= 3) {
/*     */           if (MinecraftInstance.mc.getThePlayer() == null) {
/*     */             Intrinsics.throwNpe();
/*     */           }
/*     */           if (this.target == null) {
/*     */             Intrinsics.throwNpe();
/*     */           }
/*     */         }  }
/*     */     
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 111 */   public static final Companion Companion = new Companion(null); static { mode = new ListValue(
/* 112 */         "Mode", new String[] {
/* 113 */           "Blood", 
/* 114 */           "Lighting", 
/* 115 */           "Fire", 
/* 116 */           "Heart", 
/* 117 */           "Water"
/*     */         },
/* 119 */         "Blood"); }
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/AttackEffects$Companion;", "", "()V", "mode", "Lnet/ccbluex/liquidbounce/value/ListValue;", "getMode", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "XSJClient"})
/*     */   public static final class Companion {
/*     */     private Companion() {}
/*     */     
/*     */     @NotNull
/*     */     public final ListValue getMode() {
/*     */       return AttackEffects.mode;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\AttackEffects.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */