/*     */ package net.ccbluex.liquidbounce.injection.backend;
/*     */ 
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.block.material.IMaterial;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000¤\001\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\003\n\002\020\007\n\002\b\003\n\002\030\002\n\002\b\f\n\002\030\002\n\002\b\006\n\002\020\b\n\002\b\n\n\002\030\002\n\002\b\023\n\002\020\006\n\002\b\007\n\002\030\002\n\002\b\r\n\002\020\016\n\002\b\020\n\002\030\002\n\002\b\036\n\002\030\002\n\002\b\b\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\020\000\n\002\b\016\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\b\b\026\030\000*\b\b\000\020\001*\0020\0022\0020\003B\r\022\006\020\004\032\0028\000¢\006\002\020\005J\n\020\001\032\0030\001H\026J\n\020\001\032\0030\001H\026J\n\020\001\032\0030\001H\026J\t\020\001\032\0020\007H\026J\t\020\001\032\0020\007H\026J\024\020\001\032\0030\0012\b\020\001\032\0030\001H\026J\026\020\001\032\0020\0072\n\020\001\032\005\030\0010\001H\002J$\020\001\032\0020B2\007\020 \001\032\0020B2\007\020¡\001\032\0020B2\007\020¢\001\032\0020BH\026J\022\020£\001\032\0020B2\007\020¤\001\032\0020iH\026J\022\020¥\001\032\0020B2\007\020¦\001\032\0020\003H\026J\022\020§\001\032\0020\0132\007\020¦\001\032\0020\003H\026J\022\020¨\001\032\0020J2\007\020©\001\032\0020\013H\026J\022\020ª\001\032\0020J2\007\020©\001\032\0020\013H\026J\023\020«\001\032\0020\0072\b\020¬\001\032\0030­\001H\026J%\020®\001\032\0030\0012\007\020 \001\032\0020B2\007\020¡\001\032\0020B2\007\020¢\001\032\0020BH\026J\036\020¯\001\032\005\030\0010°\0012\007\020±\001\032\0020B2\007\020©\001\032\0020\013H\026J%\020²\001\032\0030\0012\007\020 \001\032\0020B2\007\020¡\001\032\0020B2\007\020¢\001\032\0020BH\026J5\020³\001\032\0030\0012\007\020´\001\032\0020B2\007\020µ\001\032\0020B2\007\020¶\001\032\0020B2\006\020z\032\0020\0132\006\020w\032\0020\013H\026J\"\020·\001\032\0030\0012\006\020a\032\0020B2\006\020c\032\0020B2\006\020f\032\0020BH\026R\024\020\006\032\0020\0078VX\004¢\006\006\032\004\b\b\020\tR\024\020\n\032\0020\0138VX\004¢\006\006\032\004\b\f\020\rR\026\020\016\032\004\030\0010\0178VX\004¢\006\006\032\004\b\020\020\021R$\020\023\032\0020\0132\006\020\022\032\0020\0138V@VX\016¢\006\f\032\004\b\024\020\r\"\004\b\025\020\026R$\020\027\032\0020\0132\006\020\022\032\0020\0138V@VX\016¢\006\f\032\004\b\030\020\r\"\004\b\031\020\026R\024\020\032\032\0020\0078VX\004¢\006\006\032\004\b\033\020\tR$\020\035\032\0020\0342\006\020\022\032\0020\0348V@VX\016¢\006\f\032\004\b\036\020\037\"\004\b \020!R\024\020\"\032\0020#8VX\004¢\006\006\032\004\b$\020%R\024\020&\032\0020\0138VX\004¢\006\006\032\004\b'\020\rR$\020(\032\0020\0132\006\020\022\032\0020\0138V@VX\016¢\006\f\032\004\b)\020\r\"\004\b*\020\026R\024\020+\032\0020\0138VX\004¢\006\006\032\004\b,\020\rR\024\020-\032\0020.8VX\004¢\006\006\032\004\b/\0200R\024\0201\032\0020#8VX\004¢\006\006\032\004\b2\020%R\024\0203\032\0020\0078VX\004¢\006\006\032\004\b4\020\tR$\0205\032\0020\0072\006\020\022\032\0020\0078V@VX\016¢\006\f\032\004\b5\020\t\"\004\b6\0207R\024\0208\032\0020\0078VX\004¢\006\006\032\004\b8\020\tR\024\0209\032\0020\0078VX\004¢\006\006\032\004\b9\020\tR$\020:\032\0020\0072\006\020\022\032\0020\0078V@VX\016¢\006\f\032\004\b:\020\t\"\004\b;\0207R\024\020<\032\0020\0078VX\004¢\006\006\032\004\b<\020\tR\024\020=\032\0020\0078VX\004¢\006\006\032\004\b=\020\tR$\020>\032\0020\0072\006\020\022\032\0020\0078V@VX\016¢\006\f\032\004\b>\020\t\"\004\b?\0207R\024\020@\032\0020\0078VX\004¢\006\006\032\004\b@\020\tR\024\020A\032\0020B8VX\004¢\006\006\032\004\bC\020DR\024\020E\032\0020B8VX\004¢\006\006\032\004\bF\020DR\024\020G\032\0020B8VX\004¢\006\006\032\004\bH\020DR\026\020I\032\004\030\0010J8VX\004¢\006\006\032\004\bK\020LR$\020M\032\0020B2\006\020\022\032\0020B8V@VX\016¢\006\f\032\004\bN\020D\"\004\bO\020PR$\020Q\032\0020B2\006\020\022\032\0020B8V@VX\016¢\006\f\032\004\bR\020D\"\004\bS\020PR$\020T\032\0020B2\006\020\022\032\0020B8V@VX\016¢\006\f\032\004\bU\020D\"\004\bV\020PR\026\020W\032\004\030\0010X8VX\004¢\006\006\032\004\bY\020ZR$\020[\032\0020\0072\006\020\022\032\0020\0078V@VX\016¢\006\f\032\004\b\\\020\t\"\004\b]\0207R$\020^\032\0020\0072\006\020\022\032\0020\0078V@VX\016¢\006\f\032\004\b_\020\t\"\004\b`\0207R\024\020a\032\0020B8VX\004¢\006\006\032\004\bb\020DR$\020c\032\0020B2\006\020\022\032\0020B8V@VX\016¢\006\f\032\004\bd\020D\"\004\be\020PR\024\020f\032\0020B8VX\004¢\006\006\032\004\bg\020DR\024\020h\032\0020i8VX\004¢\006\006\032\004\bj\020kR\024\020l\032\0020J8VX\004¢\006\006\032\004\bm\020LR\024\020n\032\0020B8VX\004¢\006\006\032\004\bo\020DR\024\020p\032\0020B8VX\004¢\006\006\032\004\bq\020DR\024\020r\032\0020B8VX\004¢\006\006\032\004\bs\020DR\026\020t\032\004\030\0010\0038VX\004¢\006\006\032\004\bu\020vR$\020w\032\0020\0132\006\020\022\032\0020\0138V@VX\016¢\006\f\032\004\bx\020\r\"\004\by\020\026R$\020z\032\0020\0132\006\020\022\032\0020\0138V@VX\016¢\006\f\032\004\b{\020\r\"\004\b|\020\026R\024\020}\032\0020\0078VX\004¢\006\006\032\004\b~\020\tR&\020\032\0020\0072\006\020\022\032\0020\0078V@VX\016¢\006\016\032\005\b\001\020\t\"\005\b\001\0207R'\020\001\032\0020\0132\006\020\022\032\0020\0138V@VX\016¢\006\016\032\005\b\001\020\r\"\005\b\001\020\026R\026\020\001\032\0020#8VX\004¢\006\007\032\005\b\001\020%R\030\020\001\032\0030\0018VX\004¢\006\b\032\006\b\001\020\001R\026\020\001\032\0020\0138VX\004¢\006\007\032\005\b\001\020\rR\026\020\004\032\0028\000¢\006\r\n\003\020\001\032\006\b\001\020\001¨\006¸\001"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/EntityImpl;", "T", "Lnet/minecraft/entity/Entity;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "wrapped", "(Lnet/minecraft/entity/Entity;)V", "burning", "", "getBurning", "()Z", "collisionBorderSize", "", "getCollisionBorderSize", "()F", "displayName", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;", "getDisplayName", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;", "value", "distanceWalkedModified", "getDistanceWalkedModified", "setDistanceWalkedModified", "(F)V", "distanceWalkedOnStepModified", "getDistanceWalkedOnStepModified", "setDistanceWalkedOnStepModified", "entityAlive", "getEntityAlive", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;", "entityBoundingBox", "getEntityBoundingBox", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;", "setEntityBoundingBox", "(Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;)V", "entityId", "", "getEntityId", "()I", "eyeHeight", "getEyeHeight", "fallDistance", "getFallDistance", "setFallDistance", "height", "getHeight", "horizontalFacing", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;", "getHorizontalFacing", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;", "hurtResistantTime", "getHurtResistantTime", "invisible", "getInvisible", "isAirBorne", "setAirBorne", "(Z)V", "isCollidedHorizontally", "isCollidedVertically", "isDead", "setDead", "isInLava", "isInWater", "isInWeb", "setInWeb", "isRiding", "lastTickPosX", "", "getLastTickPosX", "()D", "lastTickPosY", "getLastTickPosY", "lastTickPosZ", "getLastTickPosZ", "lookVec", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;", "getLookVec", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;", "motionX", "getMotionX", "setMotionX", "(D)V", "motionY", "getMotionY", "setMotionY", "motionZ", "getMotionZ", "setMotionZ", "name", "", "getName", "()Ljava/lang/String;", "noClip", "getNoClip", "setNoClip", "onGround", "getOnGround", "setOnGround", "posX", "getPosX", "posY", "getPosY", "setPosY", "posZ", "getPosZ", "position", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "getPosition", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "positionVector", "getPositionVector", "prevPosX", "getPrevPosX", "prevPosY", "getPrevPosY", "prevPosZ", "getPrevPosZ", "ridingEntity", "getRidingEntity", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "rotationPitch", "getRotationPitch", "setRotationPitch", "rotationYaw", "getRotationYaw", "setRotationYaw", "sneaking", "getSneaking", "sprinting", "getSprinting", "setSprinting", "stepHeight", "getStepHeight", "setStepHeight", "ticksExisted", "getTicksExisted", "uniqueID", "Ljava/util/UUID;", "getUniqueID", "()Ljava/util/UUID;", "width", "getWidth", "getWrapped", "()Lnet/minecraft/entity/Entity;", "Lnet/minecraft/entity/Entity;", "asEntityLivingBase", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "asEntityPlayer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;", "asEntityTNTPrimed", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityTNTPrimed;", "canBeCollidedWith", "canRiderInteract", "copyLocationAndAnglesFrom", "", "player", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;", "equals", "other", "", "getDistance", "x", "y", "z", "getDistanceSq", "blockPos", "getDistanceSqToEntity", "it", "getDistanceToEntity", "getLook", "partialTicks", "getPositionEyes", "isInsideOfMaterial", "material", "Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;", "moveEntity", "rayTrace", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;", "range", "setPosition", "setPositionAndRotation", "oldX", "oldY", "oldZ", "setPositionAndUpdate", "XSJClient"})
/*     */ public class EntityImpl<T extends Entity> implements IEntity {
/*     */   @NotNull
/*     */   private final T wrapped;
/*     */   
/*     */   @NotNull
/*  21 */   public final T getWrapped() { return this.wrapped; } public EntityImpl(@NotNull Entity wrapped) { this.wrapped = (T)wrapped; }
/*     */   
/*     */   public float getDistanceWalkedOnStepModified() {
/*  24 */     return ((Entity)this.wrapped).field_82151_R;
/*     */   } public void setDistanceWalkedOnStepModified(float value) {
/*  26 */     ((Entity)this.wrapped).field_82151_R = value;
/*     */   }
/*     */   
/*     */   public float getDistanceWalkedModified() {
/*  30 */     return ((Entity)this.wrapped).field_70140_Q;
/*     */   } public void setDistanceWalkedModified(float value) {
/*  32 */     ((Entity)this.wrapped).field_70140_Q = value;
/*     */   }
/*     */   public boolean getSneaking() {
/*  35 */     return this.wrapped.func_70093_af();
/*     */   } public float getStepHeight() {
/*  37 */     return ((Entity)this.wrapped).field_70138_W;
/*     */   } public void setStepHeight(float value) {
/*  39 */     ((Entity)this.wrapped).field_70138_W = value;
/*     */   }
/*     */   @NotNull
/*  42 */   public IEnumFacing getHorizontalFacing() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_174811_aO(), "wrapped.horizontalFacing"); EnumFacing $this$wrap$iv = this.wrapped.func_174811_aO(); int $i$f$wrap = 0; return 
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
/* 218 */       new EnumFacingImpl($this$wrap$iv); } @Nullable public WVec3 getLookVec() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_70040_Z(), "wrapped.lookVec"); Vec3d $this$wrap$iv = this.wrapped.func_70040_Z(); int $i$f$wrap = 0;
/* 219 */     return new WVec3($this$wrap$iv.field_72450_a, $this$wrap$iv.field_72448_b, $this$wrap$iv.field_72449_c); } public boolean isDead() { return ((Entity)this.wrapped).field_70128_L; } public void setDead(boolean value) { ((Entity)this.wrapped).field_70128_L = value; } public boolean isCollidedVertically() { return ((Entity)this.wrapped).field_70124_G; } public boolean isCollidedHorizontally() { return ((Entity)this.wrapped).field_70123_F; } public boolean isAirBorne() { return ((Entity)this.wrapped).field_70160_al; } public void setAirBorne(boolean value) { ((Entity)this.wrapped).field_70160_al = value; } public int getHurtResistantTime() { return ((Entity)this.wrapped).field_70172_ad; } public boolean getNoClip() { return ((Entity)this.wrapped).field_70145_X; } public void setNoClip(boolean value) { ((Entity)this.wrapped).field_70145_X = value; } public boolean getSprinting() { return this.wrapped.func_70051_ag(); } public void setSprinting(boolean value) { this.wrapped.func_70031_b(value); }
/* 220 */   @NotNull public WVec3 getPositionVector() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_174791_d(), "wrapped.positionVector"); Vec3d $this$wrap$iv = this.wrapped.func_174791_d(); int $i$f$wrap = 0; return new WVec3($this$wrap$iv.field_72450_a, $this$wrap$iv.field_72448_b, $this$wrap$iv.field_72449_c); } public boolean isRiding() { return this.wrapped.func_184218_aH(); }
/* 221 */   @NotNull public WBlockPos getPosition() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_180425_c(), "wrapped.position"); BlockPos $this$wrap$iv = this.wrapped.func_180425_c(); int $i$f$wrap = 0; return new WBlockPos($this$wrap$iv.func_177958_n(), $this$wrap$iv.func_177956_o(), $this$wrap$iv.func_177952_p()); } public boolean getBurning() { return this.wrapped.func_70027_ad(); } public float getFallDistance() { return ((Entity)this.wrapped).field_70143_R; } public void setFallDistance(float value) { ((Entity)this.wrapped).field_70143_R = value; } public boolean isInWater() { return this.wrapped.func_70090_H(); } public boolean isInWeb() { return ((Entity)this.wrapped).field_70134_J; } public void setInWeb(boolean value) { ((Entity)this.wrapped).field_70134_J = value; } public boolean isInLava() { return this.wrapped.func_180799_ab(); } public float getWidth() { return ((Entity)this.wrapped).field_70130_N; } public float getHeight() { return ((Entity)this.wrapped).field_70131_O; } public boolean getOnGround() { return ((Entity)this.wrapped).field_70122_E; } public void setOnGround(boolean value) { ((Entity)this.wrapped).field_70122_E = value; }
/* 222 */   @Nullable public IEntity getRidingEntity() { Entity $this$wrap$iv = ((Entity)this.wrapped).field_184239_as; int $i$f$wrap = 0; return (((Entity)this.wrapped).field_184239_as != null) ? new EntityImpl((T)$this$wrap$iv) : null; } public float getCollisionBorderSize() { return this.wrapped.func_70111_Y(); } public double getMotionX() { return ((Entity)this.wrapped).field_70159_w; } public void setMotionX(double value) { ((Entity)this.wrapped).field_70159_w = value; } public double getMotionY() { return ((Entity)this.wrapped).field_70181_x; } public void setMotionY(double value) { ((Entity)this.wrapped).field_70181_x = value; } public double getMotionZ() { return ((Entity)this.wrapped).field_70179_y; } public void setMotionZ(double value) { ((Entity)this.wrapped).field_70179_y = value; } public float getEyeHeight() { return this.wrapped.func_70047_e(); }
/* 223 */   @NotNull public IAxisAlignedBB getEntityBoundingBox() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_174813_aQ(), "wrapped.entityBoundingBox"); AxisAlignedBB $this$wrap$iv = this.wrapped.func_174813_aQ(); int $i$f$wrap = 0; return new AxisAlignedBBImpl($this$wrap$iv); }
/* 224 */   public double getPosX() { return ((Entity)this.wrapped).field_70165_t; } public double getPosY() { return ((Entity)this.wrapped).field_70163_u; } public void setPosY(double value) { ((Entity)this.wrapped).field_70163_u = value; } public double getPosZ() { return ((Entity)this.wrapped).field_70161_v; } public double getLastTickPosX() { return ((Entity)this.wrapped).field_70142_S; } public double getLastTickPosY() { return ((Entity)this.wrapped).field_70137_T; } public double getLastTickPosZ() { return ((Entity)this.wrapped).field_70136_U; } public double getPrevPosX() { return ((Entity)this.wrapped).field_70169_q; } public void setEntityBoundingBox(@NotNull IAxisAlignedBB value) { Intrinsics.checkParameterIsNotNull(value, "value"); IAxisAlignedBB iAxisAlignedBB = value; T t = this.wrapped; int $i$f$unwrap = 0; AxisAlignedBB axisAlignedBB = ((AxisAlignedBBImpl)iAxisAlignedBB).getWrapped(); t.func_174826_a(axisAlignedBB); }
/* 225 */   public double getPrevPosY() { return ((Entity)this.wrapped).field_70167_r; } public double getPrevPosZ() { return ((Entity)this.wrapped).field_70166_s; } public float getRotationYaw() { return ((Entity)this.wrapped).field_70177_z; } public void setRotationYaw(float value) { ((Entity)this.wrapped).field_70177_z = value; } public float getRotationPitch() { return ((Entity)this.wrapped).field_70127_C; } public void setRotationPitch(float value) { ((Entity)this.wrapped).field_70125_A = value; } public int getEntityId() { return this.wrapped.func_145782_y(); } @Nullable public IIChatComponent getDisplayName() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_145748_c_(), "wrapped.displayName"); ITextComponent $this$wrap$iv = this.wrapped.func_145748_c_(); int $i$f$wrap = 0; return new IChatComponentImpl($this$wrap$iv); } @NotNull public UUID getUniqueID() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_110124_au(), "wrapped.uniqueID"); return this.wrapped.func_110124_au(); } @Nullable public String getName() { return this.wrapped.func_70005_c_(); } public int getTicksExisted() { return ((Entity)this.wrapped).field_70173_aa; } public boolean getEntityAlive() { return this.wrapped.func_70089_S(); } public boolean getInvisible() { return this.wrapped.func_82150_aj(); }
/* 226 */   @NotNull public WVec3 getPositionEyes(float partialTicks) { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_174824_e(partialTicks), "wrapped.getPositionEyes(partialTicks)"); Vec3d $this$wrap$iv = this.wrapped.func_174824_e(partialTicks); int $i$f$wrap = 0; return new WVec3($this$wrap$iv.field_72450_a, $this$wrap$iv.field_72448_b, $this$wrap$iv.field_72449_c); } public boolean canBeCollidedWith() { return this.wrapped.func_70067_L(); } public boolean canRiderInteract() { return this.wrapped.canRiderInteract(); } public void moveEntity(double x, double y, double z) { this.wrapped.func_70091_d(MoverType.PLAYER, x, y, z); }
/* 227 */   public float getDistanceToEntity(@NotNull IEntity it) { Intrinsics.checkParameterIsNotNull(it, "it"); IEntity iEntity = it; T t = this.wrapped; int $i$f$unwrap = 0; Entity entity = (Entity)((EntityImpl<Object>)iEntity).getWrapped(); return t.func_70032_d(entity); } public double getDistanceSqToEntity(@NotNull IEntity it) { Intrinsics.checkParameterIsNotNull(it, "it"); IEntity iEntity = it; T t = this.wrapped; int $i$f$unwrap = 0;
/* 228 */     Entity entity = (Entity)((EntityImpl<Object>)iEntity).getWrapped(); return t.func_70068_e(entity); } @NotNull public IEntityPlayer asEntityPlayer() { if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.entity.player.EntityPlayer");  return new EntityPlayerImpl<>((EntityPlayer)this.wrapped); } @NotNull public IEntityLivingBase asEntityLivingBase() { if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.entity.EntityLivingBase");  return new EntityLivingBaseImpl<>((EntityLivingBase)this.wrapped); } @NotNull public IEntityTNTPrimed asEntityTNTPrimed() { if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.entity.item.EntityTNTPrimed");  return new EntityTNTPrimedImpl((EntityTNTPrimed)this.wrapped); } public double getDistance(double x, double y, double z) { return this.wrapped.func_70011_f(x, y, z); } public void setPosition(double x, double y, double z) { this.wrapped.func_70107_b(x, y, z); }
/* 229 */   public double getDistanceSq(@NotNull WBlockPos blockPos) { Intrinsics.checkParameterIsNotNull(blockPos, "blockPos"); WBlockPos wBlockPos = blockPos; T t = this.wrapped; int $i$f$unwrap = 0; BlockPos blockPos1 = new BlockPos(wBlockPos.getX(), wBlockPos.getY(), wBlockPos.getZ()); return t.func_174818_b(blockPos1); } public void setPositionAndUpdate(double posX, double posY, double posZ) { this.wrapped.func_70634_a(posX, posY, posZ); }
/* 230 */   @Nullable public IMovingObjectPosition rayTrace(double range, float partialTicks) { RayTraceResult $this$wrap$iv = this.wrapped.func_174822_a(range, partialTicks); int $i$f$wrap = 0; this.wrapped.func_174822_a(range, partialTicks); return (this.wrapped.func_174822_a(range, partialTicks) != null) ? new MovingObjectPositionImpl($this$wrap$iv) : null; } @NotNull public WVec3 getLook(float partialTicks) { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_70676_i(partialTicks), "wrapped.getLook(partialTicks)"); Vec3d $this$wrap$iv = this.wrapped.func_70676_i(partialTicks); int $i$f$wrap = 0;
/* 231 */     return new WVec3($this$wrap$iv.field_72450_a, $this$wrap$iv.field_72448_b, $this$wrap$iv.field_72449_c); } public boolean isInsideOfMaterial(@NotNull IMaterial material) { Intrinsics.checkParameterIsNotNull(material, "material"); IMaterial iMaterial = material; T t = this.wrapped; int $i$f$unwrap = 0;
/* 232 */     Material material1 = ((MaterialImpl)iMaterial).getWrapped(); return t.func_70055_a(material1); } public void copyLocationAndAnglesFrom(@NotNull IEntityPlayerSP player) { Intrinsics.checkParameterIsNotNull(player, "player"); IEntityPlayerSP iEntityPlayerSP = player; T t = this.wrapped; int $i$f$unwrap = 0;
/* 233 */     EntityPlayerSP entityPlayerSP = ((EntityPlayerSPImpl<EntityPlayerSP>)iEntityPlayerSP).getWrapped(); t.func_82149_j((Entity)entityPlayerSP); }
/*     */ 
/*     */   
/*     */   public void setPositionAndRotation(double oldX, double oldY, double oldZ, float rotationYaw, float rotationPitch) {
/*     */     this.wrapped.func_70080_a(oldX, oldY, oldZ, rotationYaw, rotationPitch);
/*     */   }
/*     */   
/*     */   public boolean equals(@Nullable Object other) {
/*     */     return (other instanceof EntityImpl && Intrinsics.areEqual(((EntityImpl)other).wrapped, this.wrapped));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\EntityImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */