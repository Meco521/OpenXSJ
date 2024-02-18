/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.FunctionReference;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.potion.IPotion;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.potion.IPotionEffect;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.potion.Potion;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000h\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\036\n\002\030\002\n\002\b\003\n\002\020\007\n\002\b\006\n\002\030\002\n\002\b\006\n\002\020\b\n\002\b\003\n\002\020\013\n\002\b\027\n\002\030\002\n\002\b\007\n\002\020\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\006\b\026\030\000*\b\b\000\020\001*\0020\0022\b\022\004\022\002H\0010\0032\0020\004B\r\022\006\020\005\032\0028\000¢\006\002\020\006J\020\020>\032\0020?2\006\020@\032\0020\tH\026J\020\020A\032\0020\0372\006\020B\032\0020CH\026J\022\020D\032\004\030\0010\t2\006\020E\032\0020FH\026J\022\020G\032\004\030\0010H2\006\020I\032\0020\033H\026J\020\020J\032\0020\0372\006\020E\032\0020FH\026J\020\020K\032\0020?2\006\020L\032\0020\033H\026J\b\020M\032\0020?H\026R\032\020\007\032\b\022\004\022\0020\t0\b8VX\004¢\006\006\032\004\b\n\020\013R$\020\016\032\0020\r2\006\020\f\032\0020\r8V@VX\016¢\006\f\032\004\b\017\020\020\"\004\b\021\020\022R\024\020\023\032\0020\0248VX\004¢\006\006\032\004\b\025\020\026R$\020\027\032\0020\r2\006\020\f\032\0020\r8V@VX\016¢\006\f\032\004\b\030\020\020\"\004\b\031\020\022R\024\020\032\032\0020\0338VX\004¢\006\006\032\004\b\034\020\035R\024\020\036\032\0020\0378VX\004¢\006\006\032\004\b\036\020 R\024\020!\032\0020\0378VX\004¢\006\006\032\004\b!\020 R$\020\"\032\0020\r2\006\020\f\032\0020\r8V@VX\016¢\006\f\032\004\b#\020\020\"\004\b$\020\022R\024\020%\032\0020\r8VX\004¢\006\006\032\004\b&\020\020R\024\020'\032\0020\0338VX\004¢\006\006\032\004\b(\020\035R\024\020)\032\0020\r8VX\004¢\006\006\032\004\b*\020\020R\024\020+\032\0020\r8VX\004¢\006\006\032\004\b,\020\020R$\020-\032\0020\r2\006\020\f\032\0020\r8V@VX\016¢\006\f\032\004\b.\020\020\"\004\b/\020\022R$\0200\032\0020\r2\006\020\f\032\0020\r8V@VX\016¢\006\f\032\004\b1\020\020\"\004\b2\020\022R$\0203\032\0020\r2\006\020\f\032\0020\r8V@VX\016¢\006\f\032\004\b4\020\020\"\004\b5\020\022R\026\0206\032\004\030\001078VX\004¢\006\006\032\004\b8\0209R\024\020:\032\0020\0338VX\004¢\006\006\032\004\b;\020\035R\024\020<\032\0020\0338VX\004¢\006\006\032\004\b=\020\035¨\006N"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/EntityLivingBaseImpl;", "T", "Lnet/minecraft/entity/EntityLivingBase;", "Lnet/ccbluex/liquidbounce/injection/backend/EntityImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "wrapped", "(Lnet/minecraft/entity/EntityLivingBase;)V", "activePotionEffects", "", "Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect;", "getActivePotionEffects", "()Ljava/util/Collection;", "value", "", "cameraPitch", "getCameraPitch", "()F", "setCameraPitch", "(F)V", "creatureAttribute", "Lnet/ccbluex/liquidbounce/api/minecraft/entity/IEnumCreatureAttribute;", "getCreatureAttribute", "()Lnet/ccbluex/liquidbounce/api/minecraft/entity/IEnumCreatureAttribute;", "health", "getHealth", "setHealth", "hurtTime", "", "getHurtTime", "()I", "isOnLadder", "", "()Z", "isSwingInProgress", "jumpMovementFactor", "getJumpMovementFactor", "setJumpMovementFactor", "maxHealth", "getMaxHealth", "maxHurtTime", "getMaxHurtTime", "moveForward", "getMoveForward", "moveStrafing", "getMoveStrafing", "prevRotationYawHead", "getPrevRotationYawHead", "setPrevRotationYawHead", "renderYawOffset", "getRenderYawOffset", "setRenderYawOffset", "rotationYawHead", "getRotationYawHead", "setRotationYawHead", "team", "Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/ITeam;", "getTeam", "()Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/ITeam;", "totalArmorValue", "getTotalArmorValue", "totalArmorValue2", "getTotalArmorValue2", "addPotionEffect", "", "effect", "canEntityBeSeen", "it", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "getActivePotionEffect", "potion", "Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;", "getEquipmentInSlot", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "index", "isPotionActive", "removePotionEffectClient", "id", "swingItem", "XSJClient"})
/*    */ public class EntityLivingBaseImpl<T extends EntityLivingBase> extends EntityImpl<T> implements IEntityLivingBase {
/*    */   public EntityLivingBaseImpl(@NotNull EntityLivingBase wrapped) {
/* 18 */     super((T)wrapped);
/*    */   } public float getMaxHealth() {
/* 20 */     return ((EntityLivingBase)getWrapped()).func_110138_aP();
/*    */   } public int getTotalArmorValue2() {
/* 22 */     return ((EntityLivingBase)getWrapped()).func_70658_aO();
/*    */   } public float getPrevRotationYawHead() {
/* 24 */     return ((EntityLivingBase)getWrapped()).field_70758_at;
/*    */   } public void setPrevRotationYawHead(float value) {
/* 26 */     ((EntityLivingBase)getWrapped()).field_70758_at = value;
/*    */   }
/*    */   public float getRenderYawOffset() {
/* 29 */     return ((EntityLivingBase)getWrapped()).field_70761_aq;
/*    */   } public void setRenderYawOffset(float value) {
/* 31 */     ((EntityLivingBase)getWrapped()).field_70761_aq = value;
/*    */   }
/*    */   public int getMaxHurtTime() {
/* 34 */     return ((EntityLivingBase)getWrapped()).field_70738_aO;
/*    */   }
/* 36 */   public int getTotalArmorValue() { return ((EntityLivingBase)getWrapped()).func_70658_aO(); } @NotNull
/*    */   public Collection<IPotionEffect> getActivePotionEffects() {
/* 38 */     Intrinsics.checkExpressionValueIsNotNull(((EntityLivingBase)getWrapped()).func_70651_bq(), "wrapped.activePotionEffects"); return (Collection<IPotionEffect>)new WrappedCollection(((EntityLivingBase)getWrapped()).func_70651_bq(), EntityLivingBaseImpl$activePotionEffects$1.INSTANCE, EntityLivingBaseImpl$activePotionEffects$2.INSTANCE);
/*    */   } public boolean isSwingInProgress() {
/* 40 */     return ((EntityLivingBase)getWrapped()).field_82175_bq;
/*    */   } public float getCameraPitch() {
/* 42 */     return ((EntityLivingBase)getWrapped()).field_70726_aT;
/*    */   } public void setCameraPitch(float value) {
/* 44 */     ((EntityLivingBase)getWrapped()).field_70726_aT = value;
/*    */   }
/*    */   @Nullable
/* 47 */   public ITeam getTeam() { Team $this$wrap$iv = ((EntityLivingBase)getWrapped()).func_96124_cp(); int $i$f$wrap = 0; ((EntityLivingBase)getWrapped()).func_96124_cp(); return (((EntityLivingBase)getWrapped()).func_96124_cp() != null) ? 
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
/* 93 */       new TeamImpl($this$wrap$iv) : null; } @NotNull public IEnumCreatureAttribute getCreatureAttribute() { Intrinsics.checkExpressionValueIsNotNull(((EntityLivingBase)getWrapped()).func_70668_bt(), "wrapped.creatureAttribute"); EnumCreatureAttribute $this$wrap$iv = ((EntityLivingBase)getWrapped()).func_70668_bt(); int $i$f$wrap = 0;
/* 94 */     return new EnumCreatureAttributeImpl($this$wrap$iv); }
/* 95 */   public int getHurtTime() { return ((EntityLivingBase)getWrapped()).field_70737_aN; } public boolean isOnLadder() { return ((EntityLivingBase)getWrapped()).func_70617_f_(); } public float getJumpMovementFactor() { return ((EntityLivingBase)getWrapped()).field_70747_aH; } public void setJumpMovementFactor(float value) { ((EntityLivingBase)getWrapped()).field_70747_aH = value; } public float getMoveStrafing() { return ((EntityLivingBase)getWrapped()).field_70702_br; } public boolean canEntityBeSeen(@NotNull IEntity it) { Intrinsics.checkParameterIsNotNull(it, "it"); IEntity iEntity = it; EntityLivingBase entityLivingBase = (EntityLivingBase)getWrapped(); int $i$f$unwrap = 0; Entity entity = (Entity)((EntityImpl<Object>)iEntity).getWrapped(); return entityLivingBase.func_70685_l(entity); }
/* 96 */   public float getMoveForward() { return ((EntityLivingBase)getWrapped()).field_191988_bg; } public float getHealth() { return ((EntityLivingBase)getWrapped()).func_110143_aJ(); } public void setHealth(float value) { ((EntityLivingBase)getWrapped()).func_70606_j(value); } public float getRotationYawHead() { return ((EntityLivingBase)getWrapped()).field_70759_as; } public void setRotationYawHead(float value) { ((EntityLivingBase)getWrapped()).field_70759_as = value; } public boolean isPotionActive(@NotNull IPotion potion) { Intrinsics.checkParameterIsNotNull(potion, "potion"); IPotion iPotion = potion; EntityLivingBase entityLivingBase = (EntityLivingBase)getWrapped(); int $i$f$unwrap = 0; Potion potion1 = ((PotionImpl)iPotion).getWrapped(); return entityLivingBase.func_70644_a(potion1); } public void swingItem() { ((EntityLivingBase)getWrapped()).func_184609_a(EnumHand.MAIN_HAND); }
/* 97 */   @Nullable public IPotionEffect getActivePotionEffect(@NotNull IPotion potion) { Intrinsics.checkParameterIsNotNull(potion, "potion"); IPotion iPotion = potion; EntityLivingBase entityLivingBase = (EntityLivingBase)getWrapped(); int $i$f$unwrap = 0; Potion potion1 = ((PotionImpl)iPotion).getWrapped(); PotionEffect $this$wrap$iv = entityLivingBase.func_70660_b(potion1); int $i$f$wrap = 0; entityLivingBase.func_70660_b(potion1); return (entityLivingBase.func_70660_b(potion1) != null) ? 
/* 98 */       new PotionEffectImpl($this$wrap$iv) : null; } public void removePotionEffectClient(int id) { ((EntityLivingBase)getWrapped()).func_184596_c(Potion.func_188412_a(id)); }
/* 99 */   public void addPotionEffect(@NotNull IPotionEffect effect) { Intrinsics.checkParameterIsNotNull(effect, "effect"); IPotionEffect iPotionEffect = effect; EntityLivingBase entityLivingBase = (EntityLivingBase)getWrapped(); int $i$f$unwrap = 0; PotionEffect potionEffect = ((PotionEffectImpl)iPotionEffect).getWrapped(); entityLivingBase.func_70690_d(potionEffect); }
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   public IItemStack getEquipmentInSlot(int index) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: invokevirtual getWrapped : ()Lnet/minecraft/entity/Entity;
/*    */     //   4: checkcast net/minecraft/entity/EntityLivingBase
/*    */     //   7: iload_1
/*    */     //   8: istore_2
/*    */     //   9: astore #4
/*    */     //   11: iconst_0
/*    */     //   12: istore_3
/*    */     //   13: iload_2
/*    */     //   14: tableswitch default -> 88, 0 -> 52, 1 -> 58, 2 -> 64, 3 -> 70, 4 -> 76, 5 -> 82
/*    */     //   52: getstatic net/minecraft/inventory/EntityEquipmentSlot.FEET : Lnet/minecraft/inventory/EntityEquipmentSlot;
/*    */     //   55: goto -> 119
/*    */     //   58: getstatic net/minecraft/inventory/EntityEquipmentSlot.LEGS : Lnet/minecraft/inventory/EntityEquipmentSlot;
/*    */     //   61: goto -> 119
/*    */     //   64: getstatic net/minecraft/inventory/EntityEquipmentSlot.CHEST : Lnet/minecraft/inventory/EntityEquipmentSlot;
/*    */     //   67: goto -> 119
/*    */     //   70: getstatic net/minecraft/inventory/EntityEquipmentSlot.HEAD : Lnet/minecraft/inventory/EntityEquipmentSlot;
/*    */     //   73: goto -> 119
/*    */     //   76: getstatic net/minecraft/inventory/EntityEquipmentSlot.MAINHAND : Lnet/minecraft/inventory/EntityEquipmentSlot;
/*    */     //   79: goto -> 119
/*    */     //   82: getstatic net/minecraft/inventory/EntityEquipmentSlot.OFFHAND : Lnet/minecraft/inventory/EntityEquipmentSlot;
/*    */     //   85: goto -> 119
/*    */     //   88: new java/lang/IllegalArgumentException
/*    */     //   91: dup
/*    */     //   92: new java/lang/StringBuilder
/*    */     //   95: dup
/*    */     //   96: invokespecial <init> : ()V
/*    */     //   99: ldc_w 'Invalid armorType '
/*    */     //   102: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   105: iload_2
/*    */     //   106: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*    */     //   109: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   112: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   115: checkcast java/lang/Throwable
/*    */     //   118: athrow
/*    */     //   119: astore #5
/*    */     //   121: aload #4
/*    */     //   123: aload #5
/*    */     //   125: invokevirtual func_184582_a : (Lnet/minecraft/inventory/EntityEquipmentSlot;)Lnet/minecraft/item/ItemStack;
/*    */     //   128: dup
/*    */     //   129: ldc_w 'wrapped.getItemStackFrom….toEntityEquipmentSlot())'
/*    */     //   132: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   135: astore_2
/*    */     //   136: iconst_0
/*    */     //   137: istore_3
/*    */     //   138: new net/ccbluex/liquidbounce/injection/backend/ItemStackImpl
/*    */     //   141: dup
/*    */     //   142: aload_2
/*    */     //   143: invokespecial <init> : (Lnet/minecraft/item/ItemStack;)V
/*    */     //   146: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*    */     //   149: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #88	-> 0
/*    */     //   #100	-> 13
/*    */     //   #101	-> 52
/*    */     //   #102	-> 58
/*    */     //   #103	-> 64
/*    */     //   #104	-> 70
/*    */     //   #105	-> 76
/*    */     //   #106	-> 82
/*    */     //   #107	-> 88
/*    */     //   #88	-> 125
/*    */     //   #108	-> 138
/*    */     //   #88	-> 149
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   11	108	2	$this$toEntityEquipmentSlot$iv	I
/*    */     //   13	106	3	$i$f$toEntityEquipmentSlot	I
/*    */     //   136	13	2	$this$wrap$iv	Lnet/minecraft/item/ItemStack;
/*    */     //   138	11	3	$i$f$wrap	I
/*    */     //   0	150	0	this	Lnet/ccbluex/liquidbounce/injection/backend/EntityLivingBaseImpl;
/*    */     //   0	150	1	index	I
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\EntityLivingBaseImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */