/*     */ package net.ccbluex.liquidbounce.injection.backend;
/*     */ 
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.stats.IStatBase;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\001\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\007\n\002\b\006\n\002\030\002\n\002\b\003\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\005\n\002\020\b\n\002\b\n\n\002\020\006\n\002\b\017\n\002\020\002\n\002\b\t\n\002\030\002\n\002\b\004\n\002\030\002\n\000\b\026\030\000*\b\b\000\020\001*\0020\0022\b\022\004\022\002H\0010\0032\0020\004B\r\022\006\020\005\032\0028\000¢\006\002\020\006J\020\020O\032\0020P2\006\020Q\032\0020\027H\026J\030\020R\032\0020P2\006\020S\032\0020\b2\006\020T\032\0020\bH\026J\020\020U\032\0020\b2\006\020V\032\0020\bH\026J\b\020W\032\0020PH\026J\020\020X\032\0020P2\006\020Q\032\0020\027H\026J\020\020Y\032\0020P2\006\020Q\032\0020ZH\026J\b\020[\032\0020PH\026J\b\020\\\032\0020PH\026J\020\020]\032\0020P2\006\020^\032\0020_H\026R$\020\t\032\0020\b2\006\020\007\032\0020\b8V@VX\016¢\006\f\032\004\b\n\020\013\"\004\b\f\020\rR\024\020\016\032\0020\0178VX\004¢\006\006\032\004\b\020\020\021R\024\020\022\032\0020\0238VX\004¢\006\006\032\004\b\024\020\025R\026\020\026\032\004\030\0010\0278VX\004¢\006\006\032\004\b\030\020\031R\024\020\032\032\0020\0338VX\004¢\006\006\032\004\b\034\020\035R\024\020\036\032\0020\0378VX\004¢\006\006\032\004\b \020!R\026\020\"\032\004\030\0010#8VX\004¢\006\006\032\004\b$\020%R\024\020&\032\0020'8VX\004¢\006\006\032\004\b(\020)R\024\020*\032\0020+8VX\004¢\006\006\032\004\b,\020-R\024\020.\032\0020/8VX\004¢\006\006\032\004\b.\0200R\024\0201\032\0020/8VX\004¢\006\006\032\004\b1\0200R\024\0202\032\0020/8VX\004¢\006\006\032\004\b2\0200R\026\0203\032\004\030\0010#8VX\004¢\006\006\032\004\b4\020%R$\0206\032\002052\006\020\007\032\002058V@VX\016¢\006\f\032\004\b7\0208\"\004\b9\020:R\024\020;\032\002058VX\004¢\006\006\032\004\b<\0208R\026\020=\032\004\030\0010+8VX\004¢\006\006\032\004\b>\020-R\024\020?\032\0020@8VX\004¢\006\006\032\004\bA\020BR$\020C\032\002052\006\020\007\032\002058V@VX\016¢\006\f\032\004\bD\0208\"\004\bE\020:R$\020F\032\0020/2\006\020\007\032\0020/8V@VX\016¢\006\f\032\004\bG\0200\"\004\bH\020IR\024\020J\032\0020/8VX\004¢\006\006\032\004\bK\0200R$\020L\032\0020\b2\006\020\007\032\0020\b8V@VX\016¢\006\f\032\004\bM\020\013\"\004\bN\020\r¨\006`"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/EntityPlayerImpl;", "T", "Lnet/minecraft/entity/player/EntityPlayer;", "Lnet/ccbluex/liquidbounce/injection/backend/EntityLivingBaseImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;", "wrapped", "(Lnet/minecraft/entity/player/EntityPlayer;)V", "value", "", "cameraYaw", "getCameraYaw", "()F", "setCameraYaw", "(F)V", "capabilities", "Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IPlayerCapabilities;", "getCapabilities", "()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IPlayerCapabilities;", "displayNameString", "", "getDisplayNameString", "()Ljava/lang/String;", "fishEntity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "getFishEntity", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "foodStats", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IFoodStats;", "getFoodStats", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IFoodStats;", "gameProfile", "Lcom/mojang/authlib/GameProfile;", "getGameProfile", "()Lcom/mojang/authlib/GameProfile;", "heldItem", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "getHeldItem", "()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "inventory", "Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;", "getInventory", "()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;", "inventoryContainer", "Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;", "getInventoryContainer", "()Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;", "isBlocking", "", "()Z", "isPlayerSleeping", "isUsingItem", "itemInUse", "getItemInUse", "", "itemInUseCount", "getItemInUseCount", "()I", "setItemInUseCount", "(I)V", "itemInUseDuration", "getItemInUseDuration", "openContainer", "getOpenContainer", "prevChasingPosY", "", "getPrevChasingPosY", "()D", "sleepTimer", "getSleepTimer", "setSleepTimer", "sleeping", "getSleeping", "setSleeping", "(Z)V", "spectator", "getSpectator", "speedInAir", "getSpeedInAir", "setSpeedInAir", "attackTargetEntityWithCurrentItem", "", "entity", "fall", "distance", "damageMultiplier", "getCooledAttackStrength", "adjustTicks", "jump", "onCriticalHit", "onEnchantmentCritical", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "resetCooldown", "stopUsingItem", "triggerAchievement", "stat", "Lnet/ccbluex/liquidbounce/api/minecraft/stats/IStatBase;", "XSJClient"})
/*     */ public class EntityPlayerImpl<T extends EntityPlayer> extends EntityLivingBaseImpl<T> implements IEntityPlayer {
/*  16 */   public EntityPlayerImpl(@NotNull EntityPlayer wrapped) { super((T)wrapped); }
/*     */   @NotNull
/*  18 */   public GameProfile getGameProfile() { Intrinsics.checkExpressionValueIsNotNull(((EntityPlayer)getWrapped()).func_146103_bH(), "wrapped.gameProfile"); return ((EntityPlayer)getWrapped()).func_146103_bH(); }
/*     */   @Nullable
/*  20 */   public IEntity getFishEntity() { Entity $this$wrap$iv = (Entity)((EntityPlayer)getWrapped()).field_71104_cf; int $i$f$wrap = 0; return (((EntityPlayer)getWrapped()).field_71104_cf != null) ? 
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
/*  96 */       new EntityImpl<>($this$wrap$iv) : null; } @NotNull public IFoodStats getFoodStats() { Intrinsics.checkExpressionValueIsNotNull(((EntityPlayer)getWrapped()).func_71024_bL(), "wrapped.foodStats"); FoodStats $this$wrap$iv = ((EntityPlayer)getWrapped()).func_71024_bL(); int $i$f$wrap = 0;
/*  97 */     return new FoodStatsImpl($this$wrap$iv); }
/*  98 */   public double getPrevChasingPosY() { return ((EntityPlayer)getWrapped()).field_71096_bN; } public int getSleepTimer() { return ((EntityPlayer)getWrapped()).field_71076_b; } public void setSleepTimer(int value) { ((EntityPlayer)getWrapped()).field_71076_b = value; } public boolean getSleeping() { return ((EntityPlayer)getWrapped()).field_71083_bS; } public void setSleeping(boolean value) { ((EntityPlayer)getWrapped()).field_71083_bS = value; } public boolean isPlayerSleeping() { return ((EntityPlayer)getWrapped()).func_70608_bn(); } @Nullable public IItemStack getItemInUse() { ItemStack $this$wrap$iv = ((EntityPlayer)getWrapped()).func_184607_cu(); int $i$f$wrap = 0; ((EntityPlayer)getWrapped()).func_184607_cu(); return (((EntityPlayer)getWrapped()).func_184607_cu() != null) ? new ItemStackImpl($this$wrap$iv) : null; }
/*  99 */   public float getSpeedInAir() { return ((EntityPlayer)getWrapped()).field_71102_ce; } public void setSpeedInAir(float value) { ((EntityPlayer)getWrapped()).field_71102_ce = value; } public float getCameraYaw() { return ((EntityPlayer)getWrapped()).field_71109_bG; } public void setCameraYaw(float value) { ((EntityPlayer)getWrapped()).field_71109_bG = value; } public boolean isBlocking() { return ((EntityPlayer)getWrapped()).func_184585_cz(); } public int getItemInUseCount() { return ((EntityPlayer)getWrapped()).func_184605_cv(); } public void setItemInUseCount(int value) { ((EntityPlayer)getWrapped()).field_184628_bn = value; } @NotNull public IPlayerCapabilities getCapabilities() { Intrinsics.checkExpressionValueIsNotNull(((EntityPlayer)getWrapped()).field_71075_bZ, "wrapped.capabilities"); PlayerCapabilities $this$wrap$iv = ((EntityPlayer)getWrapped()).field_71075_bZ; int $i$f$wrap = 0; return new PlayerCapabilitiesImpl($this$wrap$iv); } @Nullable public IItemStack getHeldItem() { ItemStack $this$wrap$iv = ((EntityPlayer)getWrapped()).func_184614_ca(); int $i$f$wrap = 0; ((EntityPlayer)getWrapped()).func_184614_ca();
/* 100 */     return (((EntityPlayer)getWrapped()).func_184614_ca() != null) ? new ItemStackImpl($this$wrap$iv) : null; } public boolean isUsingItem() { return ((EntityPlayer)getWrapped()).func_184587_cr(); }
/* 101 */   @NotNull public IContainer getInventoryContainer() { Intrinsics.checkExpressionValueIsNotNull(((EntityPlayer)getWrapped()).field_71069_bz, "wrapped.inventoryContainer"); Container $this$wrap$iv = ((EntityPlayer)getWrapped()).field_71069_bz; int $i$f$wrap = 0; return new ContainerImpl($this$wrap$iv); } @NotNull public IInventoryPlayer getInventory() { Intrinsics.checkExpressionValueIsNotNull(((EntityPlayer)getWrapped()).field_71071_by, "wrapped.inventory"); InventoryPlayer $this$wrap$iv = ((EntityPlayer)getWrapped()).field_71071_by; int $i$f$wrap = 0;
/* 102 */     return new InventoryPlayerImpl($this$wrap$iv); } @Nullable public IContainer getOpenContainer() { Container $this$wrap$iv = ((EntityPlayer)getWrapped()).field_71070_bA; int $i$f$wrap = 0;
/* 103 */     return (((EntityPlayer)getWrapped()).field_71070_bA != null) ? new ContainerImpl($this$wrap$iv) : null; } public int getItemInUseDuration() { return ((EntityPlayer)getWrapped()).func_184612_cw(); } @NotNull public String getDisplayNameString() { Intrinsics.checkExpressionValueIsNotNull(((EntityPlayer)getWrapped()).getDisplayNameString(), "wrapped.displayNameString"); return ((EntityPlayer)getWrapped()).getDisplayNameString(); } public boolean getSpectator() { return ((EntityPlayer)getWrapped()).func_175149_v(); } public void stopUsingItem() { ((EntityPlayer)getWrapped()).func_184597_cx(); }
/* 104 */   public void onCriticalHit(@NotNull IEntity entity) { Intrinsics.checkParameterIsNotNull(entity, "entity"); IEntity iEntity = entity; EntityPlayer entityPlayer = (EntityPlayer)getWrapped(); int $i$f$unwrap = 0; Entity entity1 = (Entity)((EntityImpl<Object>)iEntity).getWrapped(); entityPlayer.func_71009_b(entity1); } public void onEnchantmentCritical(@NotNull IEntityLivingBase entity) { Intrinsics.checkParameterIsNotNull(entity, "entity"); IEntityLivingBase iEntityLivingBase = entity; EntityPlayer entityPlayer = (EntityPlayer)getWrapped(); int $i$f$unwrap = 0;
/* 105 */     EntityLivingBase entityLivingBase = ((EntityLivingBaseImpl<EntityLivingBase>)iEntityLivingBase).getWrapped(); entityPlayer.func_71047_c((Entity)entityLivingBase); } public void attackTargetEntityWithCurrentItem(@NotNull IEntity entity) { Intrinsics.checkParameterIsNotNull(entity, "entity"); IEntity iEntity = entity; EntityPlayer entityPlayer = (EntityPlayer)getWrapped(); int $i$f$unwrap = 0;
/* 106 */     Entity entity1 = (Entity)((EntityImpl<Object>)iEntity).getWrapped(); entityPlayer.func_71059_n(entity1); } public void fall(float distance, float damageMultiplier) { ((EntityPlayer)getWrapped()).func_180430_e(distance, damageMultiplier); }
/* 107 */   public void triggerAchievement(@NotNull IStatBase stat) { Intrinsics.checkParameterIsNotNull(stat, "stat"); IStatBase iStatBase = stat; EntityPlayer entityPlayer = (EntityPlayer)getWrapped(); int $i$f$unwrap = 0; StatBase statBase = ((StatBaseImpl)iStatBase).getWrapped(); entityPlayer.func_71029_a(statBase); }
/*     */ 
/*     */   
/*     */   public void jump() {
/*     */     ((EntityPlayer)getWrapped()).func_70664_aZ();
/*     */   }
/*     */   
/*     */   public float getCooledAttackStrength(float adjustTicks) {
/*     */     return ((EntityPlayer)getWrapped()).func_184825_o(adjustTicks);
/*     */   }
/*     */   
/*     */   public void resetCooldown() {
/*     */     ((EntityPlayer)getWrapped()).func_184821_cY();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\EntityPlayerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */