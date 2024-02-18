/*     */ package net.ccbluex.liquidbounce.features.module.modules.movement;
/*     */ import java.util.List;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.enums.BlockType;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.block.state.IIBlockState;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.multiplayer.IWorldClient;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.MovementUtils;
/*     */ import net.ccbluex.liquidbounce.utils.block.BlockUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ 
/*     */ @ModuleInfo(name = "BufferSpeed", category = ModuleCategory.MOVEMENT, description = "巴菲特加速")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000N\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\004\n\002\030\002\n\002\b\n\n\002\030\002\n\002\b\006\n\002\020\006\n\002\b\b\n\002\020\002\n\002\020\007\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\002\b\002\b\007\030\0002\0020\001B\005¢\006\002\020\002J\021\020&\032\0020'2\006\020&\032\0020(H\bJ\b\020)\032\0020'H\026J\b\020*\032\0020'H\026J\020\020+\032\0020'2\006\020,\032\0020-H\007J\022\020.\032\0020'2\b\020,\032\004\030\0010/H\007J\b\0200\032\0020'H\002R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\007X\016¢\006\002\n\000R\016\020\b\032\0020\007X\016¢\006\002\n\000R\016\020\t\032\0020\007X\016¢\006\002\n\000R\016\020\n\032\0020\007X\016¢\006\002\n\000R\016\020\013\032\0020\fX\004¢\006\002\n\000R\016\020\r\032\0020\004X\004¢\006\002\n\000R\016\020\016\032\0020\fX\004¢\006\002\n\000R\016\020\017\032\0020\004X\004¢\006\002\n\000R\024\020\020\032\0020\0078BX\004¢\006\006\032\004\b\020\020\021R\016\020\022\032\0020\007X\016¢\006\002\n\000R\016\020\023\032\0020\fX\004¢\006\002\n\000R\016\020\024\032\0020\004X\004¢\006\002\n\000R\016\020\025\032\0020\fX\004¢\006\002\n\000R\016\020\026\032\0020\027X\004¢\006\002\n\000R\016\020\030\032\0020\004X\004¢\006\002\n\000R\016\020\031\032\0020\004X\004¢\006\002\n\000R\016\020\032\032\0020\fX\004¢\006\002\n\000R\016\020\033\032\0020\004X\004¢\006\002\n\000R\016\020\034\032\0020\004X\004¢\006\002\n\000R\016\020\035\032\0020\036X\016¢\006\002\n\000R\016\020\037\032\0020\004X\004¢\006\002\n\000R\016\020 \032\0020\fX\004¢\006\002\n\000R\016\020!\032\0020\027X\004¢\006\002\n\000R\016\020\"\032\0020\004X\004¢\006\002\n\000R\016\020#\032\0020\fX\004¢\006\002\n\000R\016\020$\032\0020\027X\004¢\006\002\n\000R\016\020%\032\0020\004X\004¢\006\002\n\000¨\0061"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/BufferSpeed;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "airStrafeValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "bufferValue", "down", "", "fastHop", "forceDown", "hadFastHop", "headBlockBoostValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "headBlockValue", "iceBoostValue", "iceValue", "isNearBlock", "()Z", "legitHop", "maxSpeedValue", "noHurtValue", "slabsBoostValue", "slabsModeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "slabsValue", "slimeValue", "snowBoostValue", "snowPortValue", "snowValue", "speed", "", "speedLimitValue", "stairsBoostValue", "stairsModeValue", "stairsValue", "wallBoostValue", "wallModeValue", "wallValue", "boost", "", "", "onDisable", "onEnable", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "reset", "XSJClient"})
/*     */ public final class BufferSpeed extends Module {
/*  25 */   private final BoolValue speedLimitValue = new BoolValue("SpeedLimit", true);
/*  26 */   private final FloatValue maxSpeedValue = new FloatValue("MaxSpeed", 2.0F, 1.0F, 5.0F);
/*  27 */   private final BoolValue bufferValue = new BoolValue("Buffer", true);
/*     */   
/*  29 */   private final BoolValue stairsValue = new BoolValue("Stairs", true);
/*  30 */   private final FloatValue stairsBoostValue = new FloatValue("StairsBoost", 1.87F, 1.0F, 2.0F);
/*  31 */   private final ListValue stairsModeValue = new ListValue("StairsMode", new String[] { "Old", "New" }, "New");
/*  32 */   private final BoolValue slabsValue = new BoolValue("Slabs", true);
/*  33 */   private final FloatValue slabsBoostValue = new FloatValue("SlabsBoost", 1.87F, 1.0F, 2.0F);
/*  34 */   private final ListValue slabsModeValue = new ListValue("SlabsMode", new String[] { "Old", "New" }, "New");
/*  35 */   private final BoolValue iceValue = new BoolValue("Ice", false);
/*  36 */   private final FloatValue iceBoostValue = new FloatValue("IceBoost", 1.342F, 1.0F, 2.0F);
/*  37 */   private final BoolValue snowValue = new BoolValue("Snow", true);
/*  38 */   private final FloatValue snowBoostValue = new FloatValue("SnowBoost", 1.87F, 1.0F, 2.0F);
/*  39 */   private final BoolValue snowPortValue = new BoolValue("SnowPort", true);
/*  40 */   private final BoolValue wallValue = new BoolValue("Wall", true);
/*  41 */   private final FloatValue wallBoostValue = new FloatValue("WallBoost", 1.87F, 1.0F, 2.0F);
/*  42 */   private final ListValue wallModeValue = new ListValue("WallMode", new String[] { "Old", "New" }, "New");
/*  43 */   private final BoolValue headBlockValue = new BoolValue("HeadBlock", true);
/*  44 */   private final FloatValue headBlockBoostValue = new FloatValue("HeadBlockBoost", 1.87F, 1.0F, 2.0F);
/*  45 */   private final BoolValue slimeValue = new BoolValue("Slime", true);
/*  46 */   private final BoolValue airStrafeValue = new BoolValue("AirStrafe", false);
/*  47 */   private final BoolValue noHurtValue = new BoolValue("NoHurt", true);
/*     */   
/*     */   private double speed;
/*     */   private boolean down;
/*     */   private boolean forceDown;
/*     */   private boolean fastHop;
/*     */   private boolean hadFastHop;
/*     */   private boolean legitHop;
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@Nullable UpdateEvent event) {
/*  58 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */       
/*  60 */       if (Retreat.INSTANCE.getModuleManager().getModule(Speed.class) == null) Intrinsics.throwNpe();  if (Retreat.INSTANCE.getModuleManager().getModule(Speed.class).getState() || (((Boolean)this.noHurtValue.get()).booleanValue() && thePlayer.getHurtTime() > 0)) {
/*  61 */         reset();
/*     */         
/*     */         return;
/*     */       } 
/*  65 */       WBlockPos blockPos = new WBlockPos(thePlayer.getPosX(), thePlayer.getEntityBoundingBox().getMinY(), thePlayer.getPosZ());
/*     */       
/*  67 */       if (this.forceDown || (this.down && thePlayer.getMotionY() == 0.0D)) {
/*  68 */         thePlayer.setMotionY(-1.0D);
/*  69 */         this.down = false;
/*  70 */         this.forceDown = false;
/*     */       } 
/*     */       
/*  73 */       if (this.fastHop) {
/*  74 */         thePlayer.setSpeedInAir(0.0211F);
/*  75 */         this.hadFastHop = true;
/*  76 */       } else if (this.hadFastHop) {
/*  77 */         thePlayer.setSpeedInAir(0.02F);
/*  78 */         this.hadFastHop = false;
/*     */       } 
/*     */       
/*  81 */       if (!MovementUtils.isMoving() || thePlayer.isSneaking() || thePlayer.isInWater() || MinecraftInstance.mc.getGameSettings().getKeyBindJump().isKeyDown()) {
/*  82 */         reset();
/*     */         
/*     */         return;
/*     */       } 
/*  86 */       if (thePlayer.getOnGround()) {
/*  87 */         this.fastHop = false;
/*     */         
/*  89 */         if (((Boolean)this.slimeValue.get()).booleanValue() && (MinecraftInstance.classProvider.isBlockSlime(BlockUtils.getBlock(blockPos.down())) || MinecraftInstance.classProvider.isBlockSlime(BlockUtils.getBlock(blockPos)))) {
/*  90 */           thePlayer.jump();
/*     */           
/*  92 */           thePlayer.setMotionX(thePlayer.getMotionY() * 1.132D);
/*  93 */           thePlayer.setMotionY(0.08D);
/*  94 */           thePlayer.setMotionZ(thePlayer.getMotionY() * 1.132D);
/*     */           
/*  96 */           this.down = true;
/*     */           return;
/*     */         } 
/*  99 */         if (((Boolean)this.slabsValue.get()).booleanValue() && MinecraftInstance.classProvider.isBlockSlab(BlockUtils.getBlock(blockPos)))
/* 100 */         { String str = (String)this.slabsModeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode())
/*     */           
/*     */           { 
/*     */             
/*     */             case 108960:
/* 105 */               if (str.equals("new")) {
/* 106 */                 this.fastHop = true;
/* 107 */                 if (this.legitHop) {
/* 108 */                   thePlayer.jump();
/* 109 */                   thePlayer.setOnGround(false);
/* 110 */                   this.legitHop = false;
/*     */                   return;
/*     */                 } 
/* 113 */                 thePlayer.setOnGround(false);
/*     */                 
/* 115 */                 MovementUtils.strafe(0.375F);
/*     */                 
/* 117 */                 thePlayer.jump();
/* 118 */                 thePlayer.setMotionY(0.41D);
/*     */                 return;
/*     */               } 
/*     */               break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             case 110119:
/*     */               if (str.equals("old"))
/*     */               { BufferSpeed bufferSpeed = this;
/*     */                 float boost$iv = ((Number)this.slabsBoostValue.get()).floatValue();
/*     */                 int $i$f$boost = 0;
/* 263 */                 if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer$iv = MinecraftInstance.mc.getThePlayer();
/*     */                 
/* 265 */                 thePlayer$iv.setMotionX(thePlayer$iv.getMotionX() * boost$iv);
/* 266 */                 thePlayer$iv.setMotionZ(thePlayer$iv.getMotionX() * boost$iv);
/*     */                 
/* 268 */                 access$setSpeed$p(bufferSpeed, MovementUtils.INSTANCE.getSpeed());
/*     */                 
/* 270 */                 if (((Boolean)access$getSpeedLimitValue$p(bufferSpeed).get()).booleanValue() && access$getSpeed$p(bufferSpeed) > ((Number)access$getMaxSpeedValue$p(bufferSpeed).get()).doubleValue())
/* 271 */                   access$setSpeed$p(bufferSpeed, ((Number)access$getMaxSpeedValue$p(bufferSpeed).get()).floatValue());  return; }  break; }  }  if (((Boolean)this.stairsValue.get()).booleanValue() && (MinecraftInstance.classProvider.isBlockStairs(BlockUtils.getBlock(blockPos.down())) || MinecraftInstance.classProvider.isBlockStairs(BlockUtils.getBlock(blockPos)))) { String str = (String)this.stairsModeValue.get(); boolean bool = false; if (str == null)
/*     */             throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case 108960: if (str.equals("new")) { this.fastHop = true; if (this.legitHop) { thePlayer.jump(); thePlayer.setOnGround(false); this.legitHop = false; return; }  thePlayer.setOnGround(false); MovementUtils.strafe(0.375F); thePlayer.jump(); thePlayer.setMotionY(0.41D); return; }  break;
/* 273 */             case 110119: if (str.equals("old")) { BufferSpeed bufferSpeed = this; float boost$iv = ((Number)this.stairsBoostValue.get()).floatValue(); int $i$f$boost = 0; if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer$iv = MinecraftInstance.mc.getThePlayer();
/*     */                 
/* 275 */                 thePlayer$iv.setMotionX(thePlayer$iv.getMotionX() * boost$iv);
/* 276 */                 thePlayer$iv.setMotionZ(thePlayer$iv.getMotionX() * boost$iv);
/*     */                 
/* 278 */                 access$setSpeed$p(bufferSpeed, MovementUtils.INSTANCE.getSpeed());
/*     */                 
/* 280 */                 if (((Boolean)access$getSpeedLimitValue$p(bufferSpeed).get()).booleanValue() && access$getSpeed$p(bufferSpeed) > ((Number)access$getMaxSpeedValue$p(bufferSpeed).get()).doubleValue())
/* 281 */                   access$setSpeed$p(bufferSpeed, ((Number)access$getMaxSpeedValue$p(bufferSpeed).get()).floatValue());  return; }  break; }
/*     */            }
/* 283 */          this.legitHop = true; if (((Boolean)this.headBlockValue.get()).booleanValue() && Intrinsics.areEqual(BlockUtils.getBlock(blockPos.up(2)), MinecraftInstance.classProvider.getBlockEnum(BlockType.AIR))) { BufferSpeed bufferSpeed = this; float boost$iv = ((Number)this.headBlockBoostValue.get()).floatValue(); int $i$f$boost = 0; if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer$iv = MinecraftInstance.mc.getThePlayer();
/*     */           
/* 285 */           thePlayer$iv.setMotionX(thePlayer$iv.getMotionX() * boost$iv);
/* 286 */           thePlayer$iv.setMotionZ(thePlayer$iv.getMotionX() * boost$iv);
/*     */           
/* 288 */           access$setSpeed$p(bufferSpeed, MovementUtils.INSTANCE.getSpeed());
/*     */           
/* 290 */           if (((Boolean)access$getSpeedLimitValue$p(bufferSpeed).get()).booleanValue() && access$getSpeed$p(bufferSpeed) > ((Number)access$getMaxSpeedValue$p(bufferSpeed).get()).doubleValue())
/* 291 */             access$setSpeed$p(bufferSpeed, ((Number)access$getMaxSpeedValue$p(bufferSpeed).get()).floatValue());  return; }
/*     */          if (((Boolean)this.iceValue.get()).booleanValue() && (Intrinsics.areEqual(BlockUtils.getBlock(blockPos.down()), MinecraftInstance.classProvider.getBlockEnum(BlockType.ICE)) || Intrinsics.areEqual(BlockUtils.getBlock(blockPos.down()), MinecraftInstance.classProvider.getBlockEnum(BlockType.ICE_PACKED)))) {
/* 293 */           BufferSpeed this_$iv = this; float boost$iv = ((Number)this.iceBoostValue.get()).floatValue(); int $i$f$boost = 0; if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer$iv = MinecraftInstance.mc.getThePlayer();
/*     */           
/* 295 */           thePlayer$iv.setMotionX(thePlayer$iv.getMotionX() * boost$iv);
/* 296 */           thePlayer$iv.setMotionZ(thePlayer$iv.getMotionX() * boost$iv);
/*     */           
/* 298 */           access$setSpeed$p(this_$iv, MovementUtils.INSTANCE.getSpeed());
/*     */           
/* 300 */           if (((Boolean)access$getSpeedLimitValue$p(this_$iv).get()).booleanValue() && access$getSpeed$p(this_$iv) > ((Number)access$getMaxSpeedValue$p(this_$iv).get()).doubleValue())
/* 301 */             access$setSpeed$p(this_$iv, ((Number)access$getMaxSpeedValue$p(this_$iv).get()).floatValue());  return;
/*     */         }  if (((Boolean)this.snowValue.get()).booleanValue() && Intrinsics.areEqual(BlockUtils.getBlock(blockPos), MinecraftInstance.classProvider.getBlockEnum(BlockType.SNOW_LAYER)) && (((Boolean)this.snowPortValue.get()).booleanValue() || thePlayer.getPosY() - (int)thePlayer.getPosY() >= 0.125D)) { if (thePlayer.getPosY() - (int)thePlayer.getPosY() >= 0.125D)
/* 303 */           { BufferSpeed this_$iv = this; float boost$iv = ((Number)this.snowBoostValue.get()).floatValue(); int $i$f$boost = 0; if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer$iv = MinecraftInstance.mc.getThePlayer();
/*     */             
/* 305 */             thePlayer$iv.setMotionX(thePlayer$iv.getMotionX() * boost$iv);
/* 306 */             thePlayer$iv.setMotionZ(thePlayer$iv.getMotionX() * boost$iv);
/*     */             
/* 308 */             access$setSpeed$p(this_$iv, MovementUtils.INSTANCE.getSpeed());
/*     */             
/* 310 */             if (((Boolean)access$getSpeedLimitValue$p(this_$iv).get()).booleanValue() && access$getSpeed$p(this_$iv) > ((Number)access$getMaxSpeedValue$p(this_$iv).get()).doubleValue())
/* 311 */               access$setSpeed$p(this_$iv, ((Number)access$getMaxSpeedValue$p(this_$iv).get()).floatValue());  } else { thePlayer.jump(); this.forceDown = true; }  return; }  if (((Boolean)this.wallValue.get()).booleanValue()) { String str = (String)this.wallModeValue.get(); boolean bool = false; if (str == null)
/*     */             throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case 108960: if (str.equals("new") && isNearBlock() && !thePlayer.getMovementInput().getJump()) { thePlayer.jump(); thePlayer.setMotionY(0.08D); thePlayer.setMotionX(thePlayer.getMotionX() * 0.99D); thePlayer.setMotionZ(thePlayer.getMotionX() * 0.99D); this.down = true; return; }  break;
/* 313 */             case 110119: if (str.equals("old") && ((thePlayer.isCollidedVertically() && isNearBlock()) || !MinecraftInstance.classProvider.isBlockAir(BlockUtils.getBlock(new WBlockPos(thePlayer.getPosX(), thePlayer.getPosY() + 2.0D, thePlayer.getPosZ()))))) { BufferSpeed bufferSpeed = this; float boost$iv = ((Number)this.wallBoostValue.get()).floatValue(); int $i$f$boost = 0; if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer$iv = MinecraftInstance.mc.getThePlayer();
/*     */                 
/* 315 */                 thePlayer$iv.setMotionX(thePlayer$iv.getMotionX() * boost$iv);
/* 316 */                 thePlayer$iv.setMotionZ(thePlayer$iv.getMotionX() * boost$iv);
/*     */                 
/* 318 */                 access$setSpeed$p(bufferSpeed, MovementUtils.INSTANCE.getSpeed());
/*     */                 
/* 320 */                 if (((Boolean)access$getSpeedLimitValue$p(bufferSpeed).get()).booleanValue() && access$getSpeed$p(bufferSpeed) > ((Number)access$getMaxSpeedValue$p(bufferSpeed).get()).doubleValue())
/* 321 */                   access$setSpeed$p(bufferSpeed, ((Number)access$getMaxSpeedValue$p(bufferSpeed).get()).floatValue()); 
/*     */                 return; }
/*     */               
/*     */               break; }
/*     */            }
/*     */         
/*     */         float currentSpeed = MovementUtils.INSTANCE.getSpeed();
/*     */         if (this.speed < currentSpeed)
/*     */           this.speed = currentSpeed; 
/*     */         if (((Boolean)this.bufferValue.get()).booleanValue() && this.speed > 0.2F) {
/*     */           this.speed /= 1.0199999809265137D;
/*     */           MovementUtils.strafe((float)this.speed);
/*     */         } 
/*     */       } else {
/*     */         this.speed = 0.0D;
/*     */         if (((Boolean)this.airStrafeValue.get()).booleanValue())
/*     */           MovementUtils.strafe$default(0.0F, 1, null); 
/*     */       } 
/*     */       return; }
/*     */     
/*     */     MinecraftInstance.mc.getThePlayer();
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/*     */     Intrinsics.checkParameterIsNotNull(event, "event");
/*     */     IPacket packet = event.getPacket();
/*     */     if (MinecraftInstance.classProvider.isSPacketPlayerPosLook(packet))
/*     */       this.speed = 0.0D; 
/*     */   }
/*     */   
/*     */   public void onEnable() {
/*     */     reset();
/*     */   }
/*     */   
/*     */   public void onDisable() {
/*     */     reset();
/*     */   }
/*     */   
/*     */   private final void reset() {
/*     */     if (MinecraftInstance.mc.getThePlayer() != null) {
/*     */       IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */       this.legitHop = true;
/*     */       this.speed = 0.0D;
/*     */       if (this.hadFastHop) {
/*     */         thePlayer.setSpeedInAir(0.02F);
/*     */         this.hadFastHop = false;
/*     */       } 
/*     */       return;
/*     */     } 
/*     */     MinecraftInstance.mc.getThePlayer();
/*     */   }
/*     */   
/*     */   private final void boost(float boost) {
/*     */     int $i$f$boost = 0;
/*     */     if (MinecraftInstance.mc.getThePlayer() == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */     thePlayer.setMotionX(thePlayer.getMotionX() * boost);
/*     */     thePlayer.setMotionZ(thePlayer.getMotionX() * boost);
/*     */     access$setSpeed$p(this, MovementUtils.INSTANCE.getSpeed());
/*     */     if (((Boolean)access$getSpeedLimitValue$p(this).get()).booleanValue() && access$getSpeed$p(this) > ((Number)access$getMaxSpeedValue$p(this).get()).doubleValue())
/*     */       access$setSpeed$p(this, ((Number)access$getMaxSpeedValue$p(this).get()).floatValue()); 
/*     */   }
/*     */   
/*     */   private final boolean isNearBlock() {
/*     */     IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */     IWorldClient theWorld = MinecraftInstance.mc.getTheWorld();
/*     */     List<WBlockPos> blocks = new ArrayList();
/*     */     if (thePlayer == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     blocks.add(new WBlockPos(thePlayer.getPosX(), thePlayer.getPosY() + true, thePlayer.getPosZ() - 0.7D));
/*     */     blocks.add(new WBlockPos(thePlayer.getPosX() + 0.7D, thePlayer.getPosY() + true, thePlayer.getPosZ()));
/*     */     blocks.add(new WBlockPos(thePlayer.getPosX(), thePlayer.getPosY() + true, thePlayer.getPosZ() + 0.7D));
/*     */     blocks.add(new WBlockPos(thePlayer.getPosX() - 0.7D, thePlayer.getPosY() + true, thePlayer.getPosZ()));
/*     */     for (WBlockPos blockPos : blocks) {
/*     */       if (theWorld == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       IIBlockState blockState = theWorld.getBlockState(blockPos);
/*     */       IAxisAlignedBB collisionBoundingBox = blockState.getBlock().getCollisionBoundingBox((IWorld)theWorld, blockPos, blockState);
/*     */       if (((collisionBoundingBox == null || collisionBoundingBox.getMaxX() == collisionBoundingBox.getMinY() + true) && !blockState.getBlock().isTranslucent(blockState) && Intrinsics.areEqual(blockState.getBlock(), MinecraftInstance.classProvider.getBlockEnum(BlockType.WATER)) && !MinecraftInstance.classProvider.isBlockSlab(blockState.getBlock())) || Intrinsics.areEqual(blockState.getBlock(), MinecraftInstance.classProvider.getBlockEnum(BlockType.BARRIER)))
/*     */         return true; 
/*     */     } 
/*     */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\BufferSpeed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */