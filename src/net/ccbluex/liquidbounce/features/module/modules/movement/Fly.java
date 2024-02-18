/*     */ package net.ccbluex.liquidbounce.features.module.modules.movement;
/*     */ import java.awt.Color;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.potion.PotionType;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*     */ import net.ccbluex.liquidbounce.event.BlockBBEvent;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.JumpEvent;
/*     */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*     */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*     */ import net.ccbluex.liquidbounce.event.StepEvent;
/*     */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.MovementUtils;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.utils.timer.TickTimer;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "Fly", description = "Allows you to fly in survival mode.", category = ModuleCategory.MOVEMENT, keyBind = 33)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\001\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\002\n\002\030\002\n\000\n\002\020\006\n\000\n\002\030\002\n\002\b\005\n\002\020\013\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\007\n\002\b\005\n\002\030\002\n\002\b\b\n\002\020\t\n\000\n\002\030\002\n\002\b\n\n\002\020\016\n\002\b\t\n\002\020\002\n\002\b\005\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020=\032\0020\tH\002J\030\020>\032\0020?2\006\020@\032\0020\0312\006\020A\032\0020\031H\002J\b\020B\032\0020?H\002J\020\020C\032\0020?2\006\020D\032\0020EH\007J\b\020F\032\0020?H\026J\b\020G\032\0020?H\026J\020\020H\032\0020?2\006\020I\032\0020JH\007J\020\020K\032\0020?2\006\020D\032\0020LH\007J\020\020M\032\0020?2\006\020D\032\0020NH\007J\020\020O\032\0020?2\006\020D\032\0020PH\007J\022\020Q\032\0020?2\b\020D\032\004\030\0010RH\007J\020\020S\032\0020?2\006\020I\032\0020TH\007J\022\020U\032\0020?2\b\020D\032\004\030\0010VH\007R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\005\032\0020\004X\016¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\b\032\0020\tX\016¢\006\002\n\000R\016\020\n\032\0020\013X\004¢\006\002\n\000R\016\020\f\032\0020\013X\004¢\006\002\n\000R\016\020\r\032\0020\013X\004¢\006\002\n\000R\016\020\016\032\0020\004X\016¢\006\002\n\000R\016\020\017\032\0020\007X\004¢\006\002\n\000R\016\020\020\032\0020\021X\016¢\006\002\n\000R\016\020\022\032\0020\023X\004¢\006\002\n\000R\016\020\024\032\0020\023X\004¢\006\002\n\000R\016\020\025\032\0020\021X\016¢\006\002\n\000R\016\020\026\032\0020\027X\004¢\006\002\n\000R\016\020\030\032\0020\031X\016¢\006\002\n\000R\016\020\032\032\0020\023X\004¢\006\002\n\000R\016\020\033\032\0020\031X\016¢\006\002\n\000R\016\020\034\032\0020\027X\004¢\006\002\n\000R\016\020\035\032\0020\007X\004¢\006\002\n\000R\016\020\036\032\0020\037X\004¢\006\002\n\000R\016\020 \032\0020\013X\004¢\006\002\n\000R\016\020!\032\0020\023X\004¢\006\002\n\000R\016\020\"\032\0020\tX\016¢\006\002\n\000R\016\020#\032\0020\007X\004¢\006\002\n\000R\016\020$\032\0020\027X\004¢\006\002\n\000R\016\020%\032\0020\013X\004¢\006\002\n\000R\016\020&\032\0020\027X\004¢\006\002\n\000R\016\020'\032\0020(X\016¢\006\002\n\000R\021\020)\032\0020*¢\006\b\n\000\032\004\b+\020,R\016\020-\032\0020\tX\016¢\006\002\n\000R\016\020.\032\0020\013X\004¢\006\002\n\000R\016\020/\032\0020\037X\004¢\006\002\n\000R\016\0200\032\0020\021X\016¢\006\002\n\000R\016\0201\032\0020\021X\016¢\006\002\n\000R\016\0202\032\0020\023X\004¢\006\002\n\000R\016\0203\032\0020\tX\016¢\006\002\n\000R\024\0204\032\002058VX\004¢\006\006\032\004\b6\0207R\016\0208\032\0020\004X\016¢\006\002\n\000R\016\0209\032\0020\007X\004¢\006\002\n\000R\016\020:\032\0020\013X\004¢\006\002\n\000R\016\020;\032\0020\021X\016¢\006\002\n\000R\016\020<\032\0020\021X\016¢\006\002\n\000¨\006W"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/Fly;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "aac3delay", "", "aac3glideDelay", "aacFast", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "aacJump", "", "aacMotion", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "aacMotion2", "aacSpeedValue", "boostHypixelState", "canClipValue", "canGlide", "", "cubecraft2TickTimer", "Lnet/ccbluex/liquidbounce/utils/timer/TickTimer;", "cubecraftTeleportTickTimer", "failedStart", "flyTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "freeHypixelPitch", "", "freeHypixelTimer", "freeHypixelYaw", "groundTimer", "hypixelBoost", "hypixelBoostDelay", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "hypixelBoostTimer", "hypixelTimer", "lastDistance", "markValue", "mineSecureVClipTimer", "mineplexSpeedValue", "mineplexTimer", "minesuchtTP", "", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "getModeValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "moveSpeed", "ncpMotionValue", "neruxVaceTicks", "noFlag", "noPacketModify", "spartanTimer", "startY", "tag", "", "getTag", "()Ljava/lang/String;", "ticks", "vanillaKickBypassValue", "vanillaSpeedValue", "waitFlag", "wasDead", "calculateGround", "clip", "", "dist", "y", "handleVanillaKickBypass", "onBB", "event", "Lnet/ccbluex/liquidbounce/event/BlockBBEvent;", "onDisable", "onEnable", "onJump", "e", "Lnet/ccbluex/liquidbounce/event/JumpEvent;", "onMotion", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onMove", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onStep", "Lnet/ccbluex/liquidbounce/event/StepEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class Fly extends Module {
/*     */   @NotNull
/*  33 */   private final ListValue modeValue = new ListValue("Mode", new String[] { 
/*  34 */         "Vanilla", 
/*  35 */         "SmoothVanilla", 
/*  36 */         "VulcanClip", 
/*     */         
/*  38 */         "NCP", 
/*  39 */         "OldNCP", 
/*     */ 
/*     */         
/*  42 */         "AAC1.9.10", 
/*  43 */         "AAC3.0.5", 
/*  44 */         "AAC3.1.6-Gomme", 
/*  45 */         "AAC3.3.12", 
/*  46 */         "AAC3.3.12-Glide", 
/*  47 */         "AAC3.3.13", 
/*     */ 
/*     */         
/*  50 */         "CubeCraft", 
/*     */ 
/*     */         
/*  53 */         "Hypixel", 
/*  54 */         "BoostHypixel", 
/*  55 */         "FreeHypixel", 
/*     */ 
/*     */         
/*  58 */         "Rewinside", 
/*  59 */         "TeleportRewinside", 
/*     */ 
/*     */         
/*  62 */         "Mineplex", 
/*  63 */         "NeruxVace", 
/*  64 */         "Minesucht",
/*     */ 
/*     */         
/*  67 */         "Spartan", 
/*  68 */         "Spartan2", 
/*  69 */         "BugSpartan", 
/*     */ 
/*     */         
/*  72 */         "MineSecure", 
/*  73 */         "HawkEye", 
/*  74 */         "HAC", 
/*  75 */         "WatchCat", 
/*     */ 
/*     */         
/*  78 */         "Jetpack", 
/*  79 */         "KeepAlive", 
/*  80 */         "Flag"
/*  81 */       }, "Vanilla");
/*  82 */   @NotNull public final ListValue getModeValue() { return this.modeValue; } private final BoolValue canClipValue = new BoolValue("vulcanclipCanClip", true);
/*  83 */   private final FloatValue vanillaSpeedValue = new FloatValue("VanillaSpeed", 2.0F, 0.0F, 5.0F);
/*  84 */   private final BoolValue vanillaKickBypassValue = new BoolValue("VanillaKickBypass", false);
/*  85 */   private final FloatValue ncpMotionValue = new FloatValue("NCPMotion", 0.0F, 0.0F, 1.0F);
/*     */ 
/*     */   
/*  88 */   private final FloatValue aacSpeedValue = new FloatValue("AAC1.9.10-Speed", 0.3F, 0.0F, 1.0F);
/*  89 */   private final BoolValue aacFast = new BoolValue("AAC3.0.5-Fast", true);
/*  90 */   private final FloatValue aacMotion = new FloatValue("AAC3.3.12-Motion", 10.0F, 0.1F, 10.0F);
/*  91 */   private final FloatValue aacMotion2 = new FloatValue("AAC3.3.13-Motion", 10.0F, 0.1F, 10.0F);
/*     */ 
/*     */   
/*  94 */   private final BoolValue hypixelBoost = new BoolValue("Hypixel-Boost", true);
/*  95 */   private final IntegerValue hypixelBoostDelay = new IntegerValue("Hypixel-BoostDelay", 1200, 0, 2000);
/*  96 */   private final FloatValue hypixelBoostTimer = new FloatValue("Hypixel-BoostTimer", 1.0F, 0.0F, 5.0F);
/*  97 */   private final FloatValue mineplexSpeedValue = new FloatValue("MineplexSpeed", 1.0F, 0.5F, 10.0F);
/*  98 */   private final IntegerValue neruxVaceTicks = new IntegerValue("NeruxVace-Ticks", 6, 0, 20);
/*     */ 
/*     */   
/* 101 */   private final BoolValue markValue = new BoolValue("Mark", true);
/*     */   private double startY;
/* 103 */   private final MSTimer flyTimer = new MSTimer();
/* 104 */   private final MSTimer groundTimer = new MSTimer();
/*     */   private boolean noPacketModify;
/*     */   private double aacJump;
/*     */   private int aac3delay;
/*     */   private int aac3glideDelay;
/*     */   private boolean noFlag;
/* 110 */   private final MSTimer mineSecureVClipTimer = new MSTimer();
/* 111 */   private final TickTimer spartanTimer = new TickTimer();
/*     */   private long minesuchtTP;
/* 113 */   private final MSTimer mineplexTimer = new MSTimer();
/*     */   private boolean wasDead;
/* 115 */   private final TickTimer hypixelTimer = new TickTimer();
/* 116 */   private int boostHypixelState = 1;
/*     */   private double moveSpeed;
/*     */   private double lastDistance;
/*     */   private boolean failedStart;
/* 120 */   private final TickTimer cubecraft2TickTimer = new TickTimer();
/* 121 */   private final TickTimer cubecraftTeleportTickTimer = new TickTimer();
/* 122 */   private final TickTimer freeHypixelTimer = new TickTimer();
/*     */   private float freeHypixelYaw;
/*     */   private float freeHypixelPitch;
/*     */   private boolean waitFlag;
/*     */   private boolean canGlide;
/*     */   private int ticks;
/*     */   
/* 129 */   public void onEnable() { if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */       
/* 131 */       this.flyTimer.reset();
/* 132 */       this.noPacketModify = true;
/*     */       
/* 134 */       double x = thePlayer.getPosX();
/* 135 */       double y = thePlayer.getPosY();
/* 136 */       double z = thePlayer.getPosZ();
/*     */       
/* 138 */       String mode = (String)this.modeValue.get();
/*     */       
/* 140 */       Fly fly1 = this; boolean bool1 = false, bool2 = false; Fly $this$run = fly1; int $i$a$-run-Fly$onEnable$1 = 0;
/* 141 */       String str1 = mode; byte b = 0; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str1 = str1.toLowerCase(); switch (str1.hashCode())
/*     */       
/*     */       { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case -926713373:
/* 193 */           if (str1.equals("infinitycubecraft")) ClientUtils.displayChatMessage("§8[§c§lCubeCraft-§a§lFly§8] §aPlace a block before landing.");
/*     */         
/*     */ 
/*     */ 
/*     */         
/*     */         case 1814517522:
/* 199 */           if (str1.equals("boosthypixel"))
/* 200 */           { if (!thePlayer.getOnGround())
/*     */               break;  int i;
/*     */             byte b1;
/* 203 */             for (i = 0, b1 = 9; i <= b1; i++)
/*     */             {
/* 205 */               MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(thePlayer.getPosX(), thePlayer.getPosY(), thePlayer.getPosZ(), true));
/*     */             }
/*     */             
/* 208 */             double fallDistance = 3.0125D;
/*     */             
/* 210 */             while (fallDistance > false) {
/* 211 */               MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(thePlayer.getPosX(), thePlayer.getPosY() + 0.0624986421D, thePlayer.getPosZ(), false));
/* 212 */               MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(thePlayer.getPosX(), thePlayer.getPosY() + 0.0625D, thePlayer.getPosZ(), false));
/* 213 */               MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(thePlayer.getPosX(), thePlayer.getPosY() + 0.0624986421D, thePlayer.getPosZ(), false));
/* 214 */               MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(thePlayer.getPosX(), thePlayer.getPosY() + 1.3579E-6D, thePlayer.getPosZ(), false));
/* 215 */               fallDistance -= 0.0624986421D;
/*     */             } 
/*     */             
/* 218 */             MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(thePlayer.getPosX(), thePlayer.getPosY(), thePlayer.getPosZ(), true));
/*     */             
/* 220 */             thePlayer.jump();
/*     */             
/* 222 */             thePlayer.setPosY(thePlayer.getPosY() + 0.42F);
/* 223 */             $this$run.boostHypixelState = 1;
/* 224 */             $this$run.moveSpeed = 0.1D;
/* 225 */             $this$run.lastDistance = 0.0D;
/* 226 */             $this$run.failedStart = false; } case 1357613299: if (str1.equals("vulcanclip")) { if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround() && ((Boolean)$this$run.canClipValue.get()).booleanValue()) { $this$run.clip(0.0F, -0.1F); $this$run.waitFlag = true; $this$run.canGlide = false; $this$run.ticks = 0; MinecraftInstance.mc.getTimer().setTimerSpeed(0.1F); } else { $this$run.waitFlag = false; $this$run.canGlide = true; }  } case 108891: if (str1.equals("ncp")) { if (!thePlayer.getOnGround())
/*     */               break;  byte b1; for (b = 0, b1 = 64; b <= b1; b++) { MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(x, y + 0.049D, z, false)); MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(x, y, z, false)); }  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(x, y + 0.1D, z, true)); thePlayer.setMotionX(thePlayer.getMotionX() * 0.1D); thePlayer.setMotionZ(thePlayer.getMotionZ() * 0.1D); thePlayer.swingItem(); } case -1693125473: if (str1.equals("bugspartan")) { int i; byte b1; for (i = 0, b1 = 64; i <= b1; i++) { MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(x, y + 0.049D, z, false)); MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(x, y, z, false)); }  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(x, y + 0.1D, z, true)); thePlayer.setMotionX(thePlayer.getMotionX() * 0.1D); thePlayer.setMotionZ(thePlayer.getMotionZ() * 0.1D); thePlayer.swingItem(); } case 502330237: if (str1.equals("infinityvcubecraft")) { ClientUtils.displayChatMessage("§8[§c§lCubeCraft-§a§lFly§8] §aPlace a block before landing."); thePlayer.setPosition(thePlayer.getPosX(), thePlayer.getPosY() + 2, thePlayer.getPosZ()); } 
/*     */         case -1014303276: if (str1.equals("oldncp")) { if (!thePlayer.getOnGround())
/*     */               break;  int i; byte b1; for (i = 0, b1 = 3; i <= b1; i++) { MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(x, y + 1.01D, z, false)); MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(x, y, z, false)); }  thePlayer.jump(); thePlayer.swingItem(); } 
/* 231 */         default: break; }  this.startY = thePlayer.getPosY();
/* 232 */       this.aacJump = -3.8D;
/* 233 */       this.noPacketModify = false;
/*     */       
/* 235 */       if (StringsKt.equals(mode, "freehypixel", true)) {
/* 236 */         this.freeHypixelTimer.reset();
/* 237 */         thePlayer.setPositionAndUpdate(thePlayer.getPosX(), thePlayer.getPosY() + 0.42D, thePlayer.getPosZ());
/* 238 */         this.freeHypixelYaw = thePlayer.getRotationYaw();
/* 239 */         this.freeHypixelPitch = thePlayer.getRotationPitch();
/*     */       } 
/*     */       
/* 242 */       super.onEnable();
/*     */       return; }
/*     */     
/* 245 */     MinecraftInstance.mc.getThePlayer(); } private final void clip(float dist, float y) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double yaw = Math.toRadians(MinecraftInstance.mc.getThePlayer().getRotationYaw());
/* 246 */     boolean bool1 = false; double x = -Math.sin(yaw) * dist;
/* 247 */     boolean bool2 = false; double z = Math.cos(yaw) * dist;
/* 248 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setPosition(MinecraftInstance.mc.getThePlayer().getPosX() + x, MinecraftInstance.mc.getThePlayer().getPosY() + y, MinecraftInstance.mc.getThePlayer().getPosZ() + z);
/* 249 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(MinecraftInstance.mc.getThePlayer().getPosX(), MinecraftInstance.mc.getThePlayer().getPosY(), MinecraftInstance.mc.getThePlayer().getPosZ(), false)); }
/*     */ 
/*     */   
/* 252 */   public void onDisable() { this.wasDead = false;
/*     */     
/* 254 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */       
/* 256 */       this.noFlag = false;
/*     */       
/* 258 */       String mode = (String)this.modeValue.get();
/*     */       
/* 260 */       String str1 = mode; boolean bool = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toUpperCase(), "(this as java.lang.String).toUpperCase()"); if (!StringsKt.startsWith$default(str1.toUpperCase(), "AAC", false, 2, null) && !StringsKt.equals(mode, "Hypixel", true) && 
/* 261 */         !StringsKt.equals(mode, "CubeCraft", true)) {
/* 262 */         thePlayer.setMotionX(0.0D);
/* 263 */         thePlayer.setMotionY(0.0D);
/* 264 */         thePlayer.setMotionZ(0.0D);
/*     */       } 
/*     */       
/* 267 */       thePlayer.getCapabilities().setFlying(false);
/* 268 */       MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/* 269 */       thePlayer.setSpeedInAir(0.02F);
/*     */       return; }
/*     */     
/*     */     MinecraftInstance.mc.getThePlayer(); } @EventTarget
/*     */   public final void onUpdate(@Nullable UpdateEvent event) {
/* 274 */     float vanillaSpeed = ((Number)this.vanillaSpeedValue.get()).floatValue();
/* 275 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */     
/* 277 */     Fly fly1 = this; boolean bool1 = false, bool2 = false; Fly $this$run = fly1; int $i$a$-run-Fly$onUpdate$1 = 0;
/* 278 */     String str = (String)$this$run.modeValue.get(); int i = 0; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case -1848285483:
/* 388 */         if (str.equals("teleportrewinside")) {
/* 389 */           WVec3 vectorStart = new WVec3(thePlayer.getPosX(), thePlayer.getPosY(), thePlayer.getPosZ());
/* 390 */           float yaw = -thePlayer.getRotationYaw();
/* 391 */           float pitch = -thePlayer.getRotationPitch();
/* 392 */           double length = 9.9D;
/*     */           
/* 394 */           double d1 = Math.toRadians(yaw); boolean bool = false; double d2 = Math.sin(d1); d1 = Math.toRadians(pitch); d2 = d2; bool = false; double d3 = Math.cos(d1);
/* 395 */           d1 = Math.toRadians(pitch); d2 = d2 * d3 * length + vectorStart.getXCoord(); bool = false; d3 = Math.sin(d1);
/* 396 */           d1 = Math.toRadians(yaw); d3 = d3 * length + vectorStart.getYCoord(); d2 = d2; bool = false; double d4 = Math.cos(d1); d1 = Math.toRadians(pitch); d4 = d4; d3 = d3; d2 = d2; bool = false; double d5 = Math.cos(d1); double d6 = d4 * d5 * length + vectorStart.getZCoord(), d7 = d3, d8 = d2;
/*     */           WVec3 vectorEnd = new WVec3(d8, d7, d6);
/* 398 */           MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(vectorEnd.getXCoord(), thePlayer.getPosY() + 2, vectorEnd.getZCoord(), true));
/* 399 */           MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(vectorStart.getXCoord(), thePlayer.getPosY() + 2, vectorStart.getZCoord(), true));
/* 400 */           thePlayer.setMotionY(0.0D);
/*     */         } 
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 3145580:
/*     */         if (str.equals("flag")) {
/*     */           MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosLook(thePlayer.getPosX() + thePlayer.getMotionX() * 'ϧ', thePlayer.getPosY() + (MinecraftInstance.mc.getGameSettings().getKeyBindJump().isKeyDown() ? 1.5624D : 1.0E-8D) - (MinecraftInstance.mc.getGameSettings().getKeyBindSneak().isKeyDown() ? 0.0624D : 2.0E-8D), thePlayer.getPosZ() + thePlayer.getMotionZ() * 'ϧ', thePlayer.getRotationYaw(), thePlayer.getRotationPitch(), true));
/*     */           MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosLook(thePlayer.getPosX() + thePlayer.getMotionX() * 'ϧ', thePlayer.getPosY() - 'ᬹ', thePlayer.getPosZ() + thePlayer.getMotionZ() * 'ϧ', thePlayer.getRotationYaw(), thePlayer.getRotationPitch(), true));
/*     */           thePlayer.setPosition(thePlayer.getPosX() + thePlayer.getMotionX() * 11, thePlayer.getPosY(), thePlayer.getPosZ() + thePlayer.getMotionZ() * 11);
/*     */           thePlayer.setMotionY(0.0D);
/*     */         } 
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case -2011701869:
/* 497 */         if (str.equals("spartan")) {
/* 498 */           thePlayer.setMotionY(0.0D);
/*     */           
/* 500 */           $this$run.spartanTimer.update();
/* 501 */           if ($this$run.spartanTimer.hasTimePassed(12)) {
/* 502 */             MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(thePlayer.getPosX(), thePlayer.getPosY() + 8, thePlayer.getPosZ(), true));
/* 503 */             MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(thePlayer.getPosX(), thePlayer.getPosY() - 8, thePlayer.getPosZ(), true));
/* 504 */             $this$run.spartanTimer.reset();
/*     */           } 
/*     */         } 
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case -1362669950:
/*     */         if (str.equals("mineplex")) {
/*     */           if (thePlayer.getInventory().getCurrentItemInHand() == null) {
/*     */             if (MinecraftInstance.mc.getGameSettings().getKeyBindJump().isKeyDown() && $this$run.mineplexTimer.hasTimePassed(100L)) {
/*     */               thePlayer.setPosition(thePlayer.getPosX(), thePlayer.getPosY() + 0.6D, thePlayer.getPosZ());
/*     */               $this$run.mineplexTimer.reset();
/*     */             } 
/*     */             if (MinecraftInstance.mc.getThePlayer() == null) {
/*     */               Intrinsics.throwNpe();
/*     */             }
/*     */             if (MinecraftInstance.mc.getThePlayer().isSneaking() && $this$run.mineplexTimer.hasTimePassed(100L)) {
/*     */               thePlayer.setPosition(thePlayer.getPosX(), thePlayer.getPosY() - 0.6D, thePlayer.getPosZ());
/*     */               $this$run.mineplexTimer.reset();
/*     */             } 
/*     */             if (MinecraftInstance.mc.getThePlayer() == null) {
/*     */               Intrinsics.throwNpe();
/*     */             }
/*     */             WBlockPos blockPos = new WBlockPos(thePlayer.getPosX(), MinecraftInstance.mc.getThePlayer().getEntityBoundingBox().getMinY() - true, thePlayer.getPosZ());
/*     */             WVec3 wVec31 = new WVec3((WVec3i)blockPos);
/*     */             double d1 = 0.4D, d3 = 0.4D, z$iv = 0.4D;
/*     */             int $i$f$addVector = 0;
/* 767 */             WVec3 this_$iv = new WVec3(wVec31.getXCoord() + d1, wVec31.getYCoord() + d3, wVec31.getZCoord() + z$iv); WVec3 vec$iv = new WVec3(MinecraftInstance.classProvider.getEnumFacing(EnumFacingType.UP).getDirectionVec()); int $i$f$add = 0;
/* 768 */             WVec3 wVec32 = this_$iv; double d2 = vec$iv.getXCoord(), d4 = vec$iv.getYCoord(), z$iv$iv = vec$iv.getZCoord(); int j = 0;
/* 769 */             WVec3 vec = new WVec3(wVec32.getXCoord() + d2, wVec32.getYCoord() + d4, wVec32.getZCoord() + z$iv$iv);
/*     */             if (MinecraftInstance.mc.getTheWorld() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             if (thePlayer.getInventory().getCurrentItemInHand() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             MinecraftInstance.mc.getPlayerController().onPlayerRightClick(thePlayer, MinecraftInstance.mc.getTheWorld(), thePlayer.getInventory().getCurrentItemInHand(), blockPos, MinecraftInstance.classProvider.getEnumFacing(EnumFacingType.UP), new WVec3(vec.getXCoord() * 0.4F, vec.getYCoord() * 0.4F, vec.getZCoord() * 0.4F));
/*     */             MovementUtils.strafe(0.27F);
/*     */             MinecraftInstance.mc.getTimer().setTimerSpeed(true + ((Number)$this$run.mineplexSpeedValue.get()).floatValue());
/*     */             break;
/*     */           } 
/*     */           MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/*     */           $this$run.setState(false);
/*     */           ClientUtils.displayChatMessage("§8[§c§lMineplex-§a§lFly§8] §aSelect an empty slot to fly.");
/*     */         } 
/*     */         break;
/*     */       case 65876907:
/*     */         if (str.equals("aac3.1.6-gomme")) {
/*     */           thePlayer.getCapabilities().setFlying(true);
/*     */           if ($this$run.aac3delay == 2) {
/*     */             thePlayer.setMotionY(thePlayer.getMotionY() + 0.05D);
/*     */           } else if ($this$run.aac3delay > 2) {
/*     */             thePlayer.setMotionY(thePlayer.getMotionY() - 0.05D);
/*     */             $this$run.aac3delay = 0;
/*     */           } 
/*     */           $this$run.aac3delay = (i = $this$run.aac3delay) + 1;
/*     */           if (!$this$run.noFlag)
/*     */             MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(thePlayer.getPosX(), thePlayer.getPosY(), thePlayer.getPosZ(), thePlayer.getOnGround())); 
/*     */           if (thePlayer.getPosY() <= 0.0D)
/*     */             $this$run.noFlag = true; 
/*     */         } 
/*     */         break;
/*     */       case -1745954712:
/*     */         if (str.equals("keepalive")) {
/*     */           MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketKeepAlive());
/*     */           thePlayer.getCapabilities().setFlying(false);
/*     */           thePlayer.setMotionY(0.0D);
/*     */           thePlayer.setMotionX(0.0D);
/*     */           thePlayer.setMotionZ(0.0D);
/*     */           if (MinecraftInstance.mc.getGameSettings().getKeyBindJump().isKeyDown())
/*     */             thePlayer.setMotionY(thePlayer.getMotionY() + vanillaSpeed); 
/*     */           if (MinecraftInstance.mc.getGameSettings().getKeyBindSneak().isKeyDown())
/*     */             thePlayer.setMotionY(thePlayer.getMotionY() - vanillaSpeed); 
/*     */           MovementUtils.strafe(vanillaSpeed);
/*     */         } 
/*     */         break;
/*     */       case 701317508:
/*     */         if (str.equals("hawkeye"))
/*     */           thePlayer.setMotionY((thePlayer.getMotionY() <= -0.42D) ? 0.42D : -0.42D); 
/*     */         break;
/*     */       case -321358:
/*     */         if (str.equals("aac3.3.12-glide")) {
/*     */           if (!thePlayer.getOnGround())
/*     */             $this$run.aac3glideDelay = (i = $this$run.aac3glideDelay) + 1; 
/*     */           if ($this$run.aac3glideDelay == 2)
/*     */             MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F); 
/*     */           if ($this$run.aac3glideDelay == 12)
/*     */             MinecraftInstance.mc.getTimer().setTimerSpeed(0.1F); 
/*     */           if ($this$run.aac3glideDelay >= 12 && !thePlayer.getOnGround()) {
/*     */             $this$run.aac3glideDelay = 0;
/*     */             thePlayer.setMotionY(0.015D);
/*     */           } 
/*     */         } 
/*     */         break;
/*     */       case 709940890:
/*     */         if (str.equals("minesucht")) {
/*     */           double posX = thePlayer.getPosX();
/*     */           double posY = thePlayer.getPosY();
/*     */           double posZ = thePlayer.getPosZ();
/*     */           if (!MinecraftInstance.mc.getGameSettings().getKeyBindForward().isKeyDown())
/*     */             break; 
/*     */           if (System.currentTimeMillis() - $this$run.minesuchtTP > 99L) {
/*     */             WVec3 vec3 = thePlayer.getPositionEyes(0.0F);
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             WVec3 vec31 = MinecraftInstance.mc.getThePlayer().getLook(0.0F);
/*     */             WVec3 wVec31 = vec3;
/*     */             double d1 = vec31.getXCoord() * 7, d2 = vec31.getYCoord() * 7, z$iv = vec31.getZCoord() * 7;
/*     */             int $i$f$addVector = 0;
/*     */             WVec3 vec32 = new WVec3(wVec31.getXCoord() + d1, wVec31.getYCoord() + d2, wVec31.getZCoord() + z$iv);
/*     */             if (thePlayer.getFallDistance() > 0.8D) {
/*     */               thePlayer.getSendQueue().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(posX, posY + 50, posZ, false));
/*     */               if (MinecraftInstance.mc.getThePlayer() == null)
/*     */                 Intrinsics.throwNpe(); 
/*     */               MinecraftInstance.mc.getThePlayer().fall(100.0F, 100.0F);
/*     */               thePlayer.setFallDistance(0.0F);
/*     */               thePlayer.getSendQueue().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(posX, posY + 20, posZ, true));
/*     */             } 
/*     */             thePlayer.getSendQueue().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(vec32.getXCoord(), thePlayer.getPosY() + 50, vec32.getZCoord(), true));
/*     */             thePlayer.getSendQueue().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(posX, posY, posZ, false));
/*     */             thePlayer.getSendQueue().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(vec32.getXCoord(), posY, vec32.getZCoord(), true));
/*     */             thePlayer.getSendQueue().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(posX, posY, posZ, false));
/*     */             $this$run.minesuchtTP = System.currentTimeMillis();
/*     */             break;
/*     */           } 
/*     */           thePlayer.getSendQueue().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(thePlayer.getPosX(), thePlayer.getPosY(), thePlayer.getPosZ(), false));
/*     */           thePlayer.getSendQueue().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(posX, posY, posZ, true));
/*     */         } 
/*     */         break;
/*     */       case 103050:
/*     */         if (str.equals("hac")) {
/*     */           thePlayer.setMotionX(thePlayer.getMotionX() * 0.8D);
/*     */           thePlayer.setMotionZ(thePlayer.getMotionZ() * 0.8D);
/*     */           thePlayer.setMotionY((thePlayer.getMotionY() <= -0.42D) ? 0.42D : -0.42D);
/*     */         } 
/*     */         break;
/*     */       case 1381910549:
/*     */         if (str.equals("hypixel")) {
/*     */           int boostDelay = ((Number)$this$run.hypixelBoostDelay.get()).intValue();
/*     */           if (((Boolean)$this$run.hypixelBoost.get()).booleanValue() && !$this$run.flyTimer.hasTimePassed(boostDelay))
/*     */             MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F + ((Number)$this$run.hypixelBoostTimer.get()).floatValue() * (float)$this$run.flyTimer.hasTimeLeft(boostDelay) / boostDelay); 
/*     */           $this$run.hypixelTimer.update();
/*     */           if ($this$run.hypixelTimer.hasTimePassed(2)) {
/*     */             thePlayer.setPosition(thePlayer.getPosX(), thePlayer.getPosY() + 1.0E-5D, thePlayer.getPosZ());
/*     */             $this$run.hypixelTimer.reset();
/*     */           } 
/*     */         } 
/*     */         break;
/*     */       case -1693125473:
/*     */         if (str.equals("bugspartan")) {
/*     */           thePlayer.getCapabilities().setFlying(false);
/*     */           thePlayer.setMotionY(0.0D);
/*     */           thePlayer.setMotionX(0.0D);
/*     */           thePlayer.setMotionZ(0.0D);
/*     */           if (MinecraftInstance.mc.getGameSettings().getKeyBindJump().isKeyDown())
/*     */             thePlayer.setMotionY(thePlayer.getMotionY() + vanillaSpeed); 
/*     */           if (MinecraftInstance.mc.getGameSettings().getKeyBindSneak().isKeyDown())
/*     */             thePlayer.setMotionY(thePlayer.getMotionY() - vanillaSpeed); 
/*     */           MovementUtils.strafe(vanillaSpeed);
/*     */         } 
/*     */         break;
/*     */       case -1031473397:
/*     */         if (str.equals("cubecraft")) {
/*     */           MinecraftInstance.mc.getTimer().setTimerSpeed(0.6F);
/*     */           $this$run.cubecraftTeleportTickTimer.update();
/*     */         } 
/*     */         break;
/*     */       case 545150119:
/*     */         if (str.equals("watchcat")) {
/*     */           MovementUtils.strafe(0.15F);
/*     */           if (MinecraftInstance.mc.getThePlayer() == null)
/*     */             Intrinsics.throwNpe(); 
/*     */           MinecraftInstance.mc.getThePlayer().setSprinting(true);
/*     */           if (thePlayer.getPosY() < $this$run.startY + 2) {
/*     */             thePlayer.setMotionY(Math.random() * 0.48954512D);
/*     */             break;
/*     */           } 
/*     */           if ($this$run.startY > thePlayer.getPosY())
/*     */             MovementUtils.strafe(0.0F); 
/*     */         } 
/*     */         break;
/*     */       case 108891:
/*     */         if (str.equals("ncp")) {
/*     */           thePlayer.setMotionY(-((Number)$this$run.ncpMotionValue.get()).floatValue());
/*     */           if (MinecraftInstance.mc.getGameSettings().getKeyBindSneak().isKeyDown())
/*     */             thePlayer.setMotionY(-0.5D); 
/*     */           MovementUtils.strafe$default(0.0F, 1, null);
/*     */         } 
/*     */         break;
/*     */       case 2061751551:
/*     */         if (str.equals("spartan2")) {
/*     */           MovementUtils.strafe(0.264F);
/*     */           if (thePlayer.getTicksExisted() % 8 == 0)
/*     */             thePlayer.getSendQueue().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(thePlayer.getPosX(), thePlayer.getPosY() + 10, thePlayer.getPosZ(), true)); 
/*     */         } 
/*     */         break;
/*     */       case 1435059604:
/*     */         if (str.equals("aac1.9.10")) {
/*     */           if (MinecraftInstance.mc.getGameSettings().getKeyBindJump().isKeyDown())
/*     */             $this$run.aacJump += 0.2D; 
/*     */           if (MinecraftInstance.mc.getGameSettings().getKeyBindSneak().isKeyDown())
/*     */             $this$run.aacJump -= 0.2D; 
/*     */           if ($this$run.startY + $this$run.aacJump > thePlayer.getPosY()) {
/*     */             MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayer(true));
/*     */             thePlayer.setMotionY(0.8D);
/*     */             MovementUtils.strafe(((Number)$this$run.aacSpeedValue.get()).floatValue());
/*     */           } 
/*     */           MovementUtils.strafe$default(0.0F, 1, null);
/*     */         } 
/*     */         break;
/*     */       case -1014303276:
/*     */         if (str.equals("oldncp")) {
/*     */           if ($this$run.startY > thePlayer.getPosY())
/*     */             thePlayer.setMotionY(-1.0E-33D); 
/*     */           if (MinecraftInstance.mc.getGameSettings().getKeyBindSneak().isKeyDown())
/*     */             thePlayer.setMotionY(-0.2D); 
/*     */           if (MinecraftInstance.mc.getGameSettings().getKeyBindJump().isKeyDown() && thePlayer.getPosY() < $this$run.startY - 0.1D)
/*     */             thePlayer.setMotionY(0.2D); 
/*     */           MovementUtils.strafe$default(0.0F, 1, null);
/*     */         } 
/*     */         break;
/*     */       case 233102203:
/*     */         if (str.equals("vanilla")) {
/*     */           thePlayer.getCapabilities().setFlying(false);
/*     */           thePlayer.setMotionY(0.0D);
/*     */           thePlayer.setMotionX(0.0D);
/*     */           thePlayer.setMotionZ(0.0D);
/*     */           if (MinecraftInstance.mc.getGameSettings().getKeyBindJump().isKeyDown())
/*     */             thePlayer.setMotionY(thePlayer.getMotionY() + vanillaSpeed); 
/*     */           if (MinecraftInstance.mc.getGameSettings().getKeyBindSneak().isKeyDown())
/*     */             thePlayer.setMotionY(thePlayer.getMotionY() - vanillaSpeed); 
/*     */           MovementUtils.strafe(vanillaSpeed);
/*     */           $this$run.handleVanillaKickBypass();
/*     */         } 
/*     */         break;
/*     */       case -385327063:
/*     */         if (str.equals("freehypixel")) {
/*     */           if ($this$run.freeHypixelTimer.hasTimePassed(10)) {
/*     */             thePlayer.getCapabilities().setFlying(true);
/*     */             break;
/*     */           } 
/*     */           thePlayer.setRotationYaw($this$run.freeHypixelYaw);
/*     */           thePlayer.setRotationPitch($this$run.freeHypixelPitch);
/*     */           thePlayer.setMotionY(0.0D);
/*     */           thePlayer.setMotionZ(thePlayer.getMotionY());
/*     */           thePlayer.setMotionX(thePlayer.getMotionZ());
/*     */           if ($this$run.startY == (new BigDecimal(thePlayer.getPosY())).setScale(3, RoundingMode.HALF_DOWN).doubleValue())
/*     */             $this$run.freeHypixelTimer.update(); 
/*     */         } 
/*     */         break;
/*     */       case 518567306:
/*     */         if (str.equals("minesecure")) {
/*     */           thePlayer.getCapabilities().setFlying(false);
/*     */           if (!MinecraftInstance.mc.getGameSettings().getKeyBindSneak().isKeyDown())
/*     */             thePlayer.setMotionY(-0.01D); 
/*     */           thePlayer.setMotionX(0.0D);
/*     */           thePlayer.setMotionZ(0.0D);
/*     */           MovementUtils.strafe(vanillaSpeed);
/*     */           if ($this$run.mineSecureVClipTimer.hasTimePassed(150L) && MinecraftInstance.mc.getGameSettings().getKeyBindJump().isKeyDown()) {
/*     */             MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(thePlayer.getPosX(), thePlayer.getPosY() + 5, thePlayer.getPosZ(), false));
/*     */             MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(0.5D, -1000.0D, 0.5D, false));
/*     */             double yaw = Math.toRadians(thePlayer.getRotationYaw());
/*     */             boolean bool3 = false;
/*     */             double x = -Math.sin(yaw) * 0.4D;
/*     */             boolean bool4 = false;
/*     */             double z = Math.cos(yaw) * 0.4D;
/*     */             thePlayer.setPosition(thePlayer.getPosX() + x, thePlayer.getPosY(), thePlayer.getPosZ() + z);
/*     */             $this$run.mineSecureVClipTimer.reset();
/*     */           } 
/*     */         } 
/*     */         break;
/*     */       case 1492139162:
/*     */         if (str.equals("aac3.3.12")) {
/*     */           if (thePlayer.getPosY() < -70)
/*     */             thePlayer.setMotionY(((Number)$this$run.aacMotion.get()).floatValue()); 
/*     */           MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/*     */           if (Keyboard.isKeyDown(29)) {
/*     */             MinecraftInstance.mc.getTimer().setTimerSpeed(0.2F);
/*     */             MinecraftInstance.mc.setRightClickDelayTimer(0);
/*     */           } 
/*     */         } 
/*     */         break;
/*     */       case 1492139163:
/*     */         if (str.equals("aac3.3.13")) {
/*     */           if (thePlayer.isDead())
/*     */             $this$run.wasDead = true; 
/*     */           if ($this$run.wasDead || thePlayer.getOnGround()) {
/*     */             $this$run.wasDead = false;
/*     */             thePlayer.setMotionY(((Number)$this$run.aacMotion2.get()).floatValue());
/*     */             thePlayer.setOnGround(false);
/*     */           } 
/*     */           MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/*     */           if (Keyboard.isKeyDown(29)) {
/*     */             MinecraftInstance.mc.getTimer().setTimerSpeed(0.2F);
/*     */             MinecraftInstance.mc.setRightClickDelayTimer(0);
/*     */           } 
/*     */         } 
/*     */         break;
/*     */       case 1457669645:
/*     */         if (str.equals("smoothvanilla")) {
/*     */           thePlayer.getCapabilities().setFlying(true);
/*     */           $this$run.handleVanillaKickBypass();
/*     */         } 
/*     */         break;
/*     */       case 238938827:
/*     */         if (str.equals("neruxvace")) {
/*     */           if (!thePlayer.getOnGround())
/*     */             $this$run.aac3glideDelay = (i = $this$run.aac3glideDelay) + 1; 
/*     */           if ($this$run.aac3glideDelay >= ((Number)$this$run.neruxVaceTicks.get()).intValue() && !thePlayer.getOnGround()) {
/*     */             $this$run.aac3glideDelay = 0;
/*     */             thePlayer.setMotionY(0.015D);
/*     */           } 
/*     */         } 
/*     */         break;
/*     */       case -1706751950:
/*     */         if (str.equals("jetpack") && MinecraftInstance.mc.getGameSettings().getKeyBindJump().isKeyDown()) {
/*     */           thePlayer.setMotionY(thePlayer.getMotionY() + 0.15D);
/*     */           thePlayer.setMotionX(thePlayer.getMotionX() * 1.1D);
/*     */           thePlayer.setMotionZ(thePlayer.getMotionZ() * 1.1D);
/*     */         } 
/*     */         break;
/*     */       case 325225305:
/*     */         if (str.equals("aac3.0.5")) {
/*     */           if ($this$run.aac3delay == 2) {
/*     */             thePlayer.setMotionY(0.1D);
/*     */           } else if ($this$run.aac3delay > 2) {
/*     */             $this$run.aac3delay = 0;
/*     */           } 
/*     */           if (((Boolean)$this$run.aacFast.get()).booleanValue())
/*     */             if (thePlayer.getMovementInput().getMoveStrafe() == 0.0F) {
/*     */               thePlayer.setJumpMovementFactor(0.08F);
/*     */             } else {
/*     */               thePlayer.setJumpMovementFactor(0.0F);
/*     */             }  
/*     */           $this$run.aac3delay = (i = $this$run.aac3delay) + 1;
/*     */         } 
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onMotion(@NotNull MotionEvent event) {
/*     */     Intrinsics.checkParameterIsNotNull(event, "event");
/*     */     if (StringsKt.equals((String)this.modeValue.get(), "vulcanclip", true)) {
/*     */       if (event.getEventState() == EventState.PRE && this.canGlide) {
/*     */         MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/*     */         if (MinecraftInstance.mc.getThePlayer() == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         MinecraftInstance.mc.getThePlayer().setMotionY(-((this.ticks % 2 == 0) ? 0.17D : 0.1D));
/*     */         if (this.ticks == 0) {
/*     */           if (MinecraftInstance.mc.getThePlayer() == null)
/*     */             Intrinsics.throwNpe(); 
/*     */           MinecraftInstance.mc.getThePlayer().setMotionY(-0.07D);
/*     */         } 
/*     */         int i;
/*     */         this.ticks = (i = this.ticks) + 1;
/*     */       } 
/*     */     } else if (StringsKt.equals((String)this.modeValue.get(), "boosthypixel", true)) {
/*     */       double xDist;
/*     */       double zDist;
/*     */       double d1;
/*     */       boolean bool;
/*     */       Fly fly;
/*     */       double d2;
/*     */       switch (Fly$WhenMappings.$EnumSwitchMapping$0[event.getEventState().ordinal()]) {
/*     */         case 1:
/*     */           this.hypixelTimer.update();
/*     */           if (this.hypixelTimer.hasTimePassed(2)) {
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             MinecraftInstance.mc.getThePlayer().setPosition(MinecraftInstance.mc.getThePlayer().getPosX(), MinecraftInstance.mc.getThePlayer().getPosY() + 1.0E-5D, MinecraftInstance.mc.getThePlayer().getPosZ());
/*     */             this.hypixelTimer.reset();
/*     */           } 
/*     */           if (!this.failedStart) {
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             MinecraftInstance.mc.getThePlayer().setMotionY(0.0D);
/*     */           } 
/*     */           break;
/*     */         case 2:
/*     */           if (MinecraftInstance.mc.getThePlayer() == null)
/*     */             Intrinsics.throwNpe(); 
/*     */           if (MinecraftInstance.mc.getThePlayer() == null)
/*     */             Intrinsics.throwNpe(); 
/*     */           xDist = MinecraftInstance.mc.getThePlayer().getPosX() - MinecraftInstance.mc.getThePlayer().getPrevPosX();
/*     */           if (MinecraftInstance.mc.getThePlayer() == null)
/*     */             Intrinsics.throwNpe(); 
/*     */           if (MinecraftInstance.mc.getThePlayer() == null)
/*     */             Intrinsics.throwNpe(); 
/*     */           zDist = MinecraftInstance.mc.getThePlayer().getPosZ() - MinecraftInstance.mc.getThePlayer().getPrevPosZ();
/*     */           d1 = xDist * xDist + zDist * zDist;
/*     */           fly = this;
/*     */           bool = false;
/*     */           fly.lastDistance = d2 = Math.sqrt(d1);
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onRender3D(@Nullable Render3DEvent event) {
/*     */     String mode = (String)this.modeValue.get();
/*     */     if (!((Boolean)this.markValue.get()).booleanValue() || StringsKt.equals(mode, "Vanilla", true) || StringsKt.equals(mode, "SmoothVanilla", true))
/*     */       return; 
/*     */     double y = this.startY + 2.0D;
/*     */     if (MinecraftInstance.mc.getThePlayer() == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     RenderUtils.drawPlatform(y, (MinecraftInstance.mc.getThePlayer().getEntityBoundingBox().getMaxY() < y) ? new Color(0, 255, 0, 90) : new Color(255, 0, 0, 90), 1.0D);
/*     */     String str1 = mode;
/*     */     boolean bool = false;
/*     */     if (str1 == null)
/*     */       throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */     Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()");
/*     */     str1 = str1.toLowerCase();
/*     */     switch (str1.hashCode()) {
/*     */       case 1492139162:
/*     */         if (str1.equals("aac3.3.12"))
/*     */           RenderUtils.drawPlatform(-70.0D, new Color(0, 0, 255, 90), 1.0D); 
/*     */         break;
/*     */       case 1435059604:
/*     */         if (str1.equals("aac1.9.10"))
/*     */           RenderUtils.drawPlatform(this.startY + this.aacJump, new Color(0, 0, 255, 90), 1.0D); 
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc_w 'event'
/*     */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   7: aload_0
/*     */     //   8: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   11: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   14: checkcast java/lang/String
/*     */     //   17: ldc 'vulcanclip'
/*     */     //   19: iconst_1
/*     */     //   20: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   23: ifeq -> 288
/*     */     //   26: aload_1
/*     */     //   27: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   30: astore_2
/*     */     //   31: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   34: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   39: dup
/*     */     //   40: ifnonnull -> 46
/*     */     //   43: invokestatic throwNpe : ()V
/*     */     //   46: astore_3
/*     */     //   47: aload_1
/*     */     //   48: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   51: instanceof net/minecraft/network/play/server/SPacketPlayerPosLook
/*     */     //   54: ifeq -> 477
/*     */     //   57: aload_0
/*     */     //   58: getfield waitFlag : Z
/*     */     //   61: ifeq -> 477
/*     */     //   64: aload_0
/*     */     //   65: iconst_0
/*     */     //   66: putfield waitFlag : Z
/*     */     //   69: aload_3
/*     */     //   70: aload_3
/*     */     //   71: invokeinterface getPosX : ()D
/*     */     //   76: aload_3
/*     */     //   77: invokeinterface getPosY : ()D
/*     */     //   82: aload_3
/*     */     //   83: invokeinterface getPosZ : ()D
/*     */     //   88: invokeinterface setPosition : (DDD)V
/*     */     //   93: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   96: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   101: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   104: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   107: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   112: dup
/*     */     //   113: ifnonnull -> 119
/*     */     //   116: invokestatic throwNpe : ()V
/*     */     //   119: invokeinterface getPosX : ()D
/*     */     //   124: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   127: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   132: dup
/*     */     //   133: ifnonnull -> 139
/*     */     //   136: invokestatic throwNpe : ()V
/*     */     //   139: invokeinterface getPosY : ()D
/*     */     //   144: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   147: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   152: dup
/*     */     //   153: ifnonnull -> 159
/*     */     //   156: invokestatic throwNpe : ()V
/*     */     //   159: invokeinterface getPosZ : ()D
/*     */     //   164: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   167: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   172: dup
/*     */     //   173: ifnonnull -> 179
/*     */     //   176: invokestatic throwNpe : ()V
/*     */     //   179: invokeinterface getRotationYaw : ()F
/*     */     //   184: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   187: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   192: dup
/*     */     //   193: ifnonnull -> 199
/*     */     //   196: invokestatic throwNpe : ()V
/*     */     //   199: invokeinterface getRotationPitch : ()F
/*     */     //   204: iconst_0
/*     */     //   205: invokeinterface createCPacketPlayerPosLook : (DDDFFZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerPosLook;
/*     */     //   210: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   213: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   218: aload_1
/*     */     //   219: invokevirtual cancelEvent : ()V
/*     */     //   222: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   225: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   230: dup
/*     */     //   231: ifnonnull -> 237
/*     */     //   234: invokestatic throwNpe : ()V
/*     */     //   237: invokeinterface jump : ()V
/*     */     //   242: aload_0
/*     */     //   243: ldc_w 0.127318
/*     */     //   246: fconst_0
/*     */     //   247: invokespecial clip : (FF)V
/*     */     //   250: aload_0
/*     */     //   251: ldc_w 3.425559
/*     */     //   254: ldc_w 3.7
/*     */     //   257: invokespecial clip : (FF)V
/*     */     //   260: aload_0
/*     */     //   261: ldc_w 3.14285
/*     */     //   264: ldc_w 3.54
/*     */     //   267: invokespecial clip : (FF)V
/*     */     //   270: aload_0
/*     */     //   271: ldc_w 2.88522
/*     */     //   274: ldc_w 3.4
/*     */     //   277: invokespecial clip : (FF)V
/*     */     //   280: aload_0
/*     */     //   281: iconst_1
/*     */     //   282: putfield canGlide : Z
/*     */     //   285: goto -> 477
/*     */     //   288: aload_0
/*     */     //   289: getfield noPacketModify : Z
/*     */     //   292: ifeq -> 296
/*     */     //   295: return
/*     */     //   296: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   299: aload_1
/*     */     //   300: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   303: invokeinterface isCPacketPlayer : (Ljava/lang/Object;)Z
/*     */     //   308: ifeq -> 429
/*     */     //   311: aload_1
/*     */     //   312: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   315: invokeinterface asCPacketPlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   320: astore_2
/*     */     //   321: aload_0
/*     */     //   322: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   325: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   328: checkcast java/lang/String
/*     */     //   331: astore_3
/*     */     //   332: aload_3
/*     */     //   333: ldc_w 'NCP'
/*     */     //   336: iconst_1
/*     */     //   337: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   340: ifne -> 393
/*     */     //   343: aload_3
/*     */     //   344: ldc_w 'Rewinside'
/*     */     //   347: iconst_1
/*     */     //   348: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   351: ifne -> 393
/*     */     //   354: aload_3
/*     */     //   355: ldc_w 'Mineplex'
/*     */     //   358: iconst_1
/*     */     //   359: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   362: ifeq -> 400
/*     */     //   365: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   368: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   373: dup
/*     */     //   374: ifnonnull -> 380
/*     */     //   377: invokestatic throwNpe : ()V
/*     */     //   380: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   385: invokeinterface getCurrentItemInHand : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   390: ifnonnull -> 400
/*     */     //   393: aload_2
/*     */     //   394: iconst_1
/*     */     //   395: invokeinterface setOnGround : (Z)V
/*     */     //   400: aload_3
/*     */     //   401: ldc_w 'Hypixel'
/*     */     //   404: iconst_1
/*     */     //   405: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   408: ifne -> 422
/*     */     //   411: aload_3
/*     */     //   412: ldc_w 'BoostHypixel'
/*     */     //   415: iconst_1
/*     */     //   416: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   419: ifeq -> 429
/*     */     //   422: aload_2
/*     */     //   423: iconst_0
/*     */     //   424: invokeinterface setOnGround : (Z)V
/*     */     //   429: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   432: aload_1
/*     */     //   433: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   436: invokeinterface isSPacketPlayerPosLook : (Ljava/lang/Object;)Z
/*     */     //   441: ifeq -> 477
/*     */     //   444: aload_0
/*     */     //   445: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   448: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   451: checkcast java/lang/String
/*     */     //   454: astore_2
/*     */     //   455: aload_2
/*     */     //   456: ldc_w 'BoostHypixel'
/*     */     //   459: iconst_1
/*     */     //   460: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   463: ifeq -> 477
/*     */     //   466: aload_0
/*     */     //   467: iconst_1
/*     */     //   468: putfield failedStart : Z
/*     */     //   471: ldc_w '§8[§c§lBoostHypixel-§a§lFly§8] §cSetback detected.'
/*     */     //   474: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   477: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #607	-> 7
/*     */     //   #608	-> 26
/*     */     //   #609	-> 31
/*     */     //   #610	-> 47
/*     */     //   #611	-> 64
/*     */     //   #612	-> 69
/*     */     //   #613	-> 93
/*     */     //   #614	-> 218
/*     */     //   #615	-> 222
/*     */     //   #616	-> 242
/*     */     //   #617	-> 250
/*     */     //   #618	-> 260
/*     */     //   #619	-> 270
/*     */     //   #620	-> 280
/*     */     //   #623	-> 288
/*     */     //   #625	-> 296
/*     */     //   #626	-> 311
/*     */     //   #628	-> 321
/*     */     //   #630	-> 332
/*     */     //   #631	-> 332
/*     */     //   #630	-> 332
/*     */     //   #631	-> 354
/*     */     //   #632	-> 400
/*     */     //   #634	-> 429
/*     */     //   #635	-> 444
/*     */     //   #636	-> 455
/*     */     //   #637	-> 466
/*     */     //   #638	-> 471
/*     */     //   #641	-> 477
/*     */     //   #642	-> 477
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   47	238	3	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   31	254	2	packet	Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   332	97	3	mode	Ljava/lang/String;
/*     */     //   321	108	2	packetPlayer	Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   455	22	2	mode	Ljava/lang/String;
/*     */     //   0	478	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/movement/Fly;
/*     */     //   0	478	1	event	Lnet/ccbluex/liquidbounce/event/PacketEvent;
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onMove(@NotNull MoveEvent event) {
/*     */     Intrinsics.checkParameterIsNotNull(event, "event");
/*     */     String str = (String)this.modeValue.get();
/*     */     boolean bool = false;
/*     */     if (str == null)
/*     */       throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */     Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()");
/*     */     str = str.toLowerCase();
/*     */     switch (str.hashCode()) {
/*     */       case -385327063:
/*     */         if (str.equals("freehypixel") && !this.freeHypixelTimer.hasTimePassed(10))
/*     */           event.zero(); 
/*     */         break;
/*     */       case 1814517522:
/*     */         if (str.equals("boosthypixel")) {
/*     */           if (!MovementUtils.isMoving()) {
/*     */             event.setX(0.0D);
/*     */             event.setZ(0.0D);
/*     */             return;
/*     */           } 
/*     */           if (this.failedStart)
/*     */             return; 
/*     */           if (MinecraftInstance.mc.getThePlayer() == null)
/*     */             Intrinsics.throwNpe(); 
/*     */           if (MinecraftInstance.mc.getThePlayer() == null)
/*     */             Intrinsics.throwNpe(); 
/*     */           if (MinecraftInstance.mc.getThePlayer().getActivePotionEffect(MinecraftInstance.classProvider.getPotionEnum(PotionType.MOVE_SPEED)) == null)
/*     */             Intrinsics.throwNpe(); 
/*     */           double amplifier = true + (MinecraftInstance.mc.getThePlayer().isPotionActive(MinecraftInstance.classProvider.getPotionEnum(PotionType.MOVE_SPEED)) ? (0.2D * (MinecraftInstance.mc.getThePlayer().getActivePotionEffect(MinecraftInstance.classProvider.getPotionEnum(PotionType.MOVE_SPEED)).getAmplifier() + 1.0D)) : 0.0D);
/*     */           double baseSpeed = 0.29D * amplifier;
/*     */           switch (this.boostHypixelState) {
/*     */             case 1:
/*     */               if (MinecraftInstance.mc.getThePlayer() == null)
/*     */                 Intrinsics.throwNpe(); 
/*     */               this.moveSpeed = (MinecraftInstance.mc.getThePlayer().isPotionActive(MinecraftInstance.classProvider.getPotionEnum(PotionType.MOVE_SPEED)) ? 1.56D : 2.034D) * baseSpeed;
/*     */               this.boostHypixelState = 2;
/*     */               break;
/*     */             case 2:
/*     */               this.moveSpeed *= 2.16D;
/*     */               this.boostHypixelState = 3;
/*     */               break;
/*     */             case 3:
/*     */               if (MinecraftInstance.mc.getThePlayer() == null)
/*     */                 Intrinsics.throwNpe(); 
/*     */               this.moveSpeed = this.lastDistance - ((MinecraftInstance.mc.getThePlayer().getTicksExisted() % 2 == 0) ? 0.0103D : 0.0123D) * (this.lastDistance - baseSpeed);
/*     */               this.boostHypixelState = 4;
/*     */               break;
/*     */             default:
/*     */               this.moveSpeed = this.lastDistance - this.lastDistance / 159.8D;
/*     */               break;
/*     */           } 
/*     */           double d1 = this.moveSpeed, d2 = 0.3D;
/*     */           Fly fly = this;
/*     */           boolean bool2 = false;
/*     */           double d3 = Math.max(d1, d2);
/*     */           double yaw = MovementUtils.getDirection();
/*     */           MoveEvent moveEvent = event;
/*     */           boolean bool1 = false;
/*     */           d3 = Math.sin(yaw);
/*     */           moveEvent.setX(-d3 * this.moveSpeed);
/*     */           moveEvent = event;
/*     */           bool1 = false;
/*     */           d3 = Math.cos(yaw);
/*     */           moveEvent.setZ(d3 * this.moveSpeed);
/*     */           if (MinecraftInstance.mc.getThePlayer() == null)
/*     */             Intrinsics.throwNpe(); 
/*     */           MinecraftInstance.mc.getThePlayer().setMotionX(event.getX());
/*     */           if (MinecraftInstance.mc.getThePlayer() == null)
/*     */             Intrinsics.throwNpe(); 
/*     */           MinecraftInstance.mc.getThePlayer().setMotionZ(event.getZ());
/*     */         } 
/*     */         break;
/*     */       case -1031473397:
/*     */         if (str.equals("cubecraft")) {
/*     */           if (MinecraftInstance.mc.getThePlayer() == null)
/*     */             Intrinsics.throwNpe(); 
/*     */           double yaw = Math.toRadians(MinecraftInstance.mc.getThePlayer().getRotationYaw());
/*     */           if (this.cubecraftTeleportTickTimer.hasTimePassed(2)) {
/*     */             MoveEvent moveEvent1 = event;
/*     */             boolean bool2 = false;
/*     */             double d = Math.sin(yaw);
/*     */             moveEvent1.setX(-d * 2.4D);
/*     */             moveEvent1 = event;
/*     */             bool2 = false;
/*     */             d = Math.cos(yaw);
/*     */             moveEvent1.setZ(d * 2.4D);
/*     */             this.cubecraftTeleportTickTimer.reset();
/*     */             break;
/*     */           } 
/*     */           MoveEvent moveEvent = event;
/*     */           boolean bool1 = false;
/*     */           double d1 = Math.sin(yaw);
/*     */           moveEvent.setX(-d1 * 0.2D);
/*     */           moveEvent = event;
/*     */           bool1 = false;
/*     */           d1 = Math.cos(yaw);
/*     */           moveEvent.setZ(d1 * 0.2D);
/*     */         } 
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onBB(@NotNull BlockBBEvent event) {
/*     */     Intrinsics.checkParameterIsNotNull(event, "event");
/*     */     if (MinecraftInstance.mc.getThePlayer() == null)
/*     */       return; 
/*     */     String mode = (String)this.modeValue.get();
/*     */     if (MinecraftInstance.classProvider.isBlockAir(event.getBlock())) {
/*     */       if (!StringsKt.equals(mode, "Hypixel", true) && !StringsKt.equals(mode, "BoostHypixel", true) && !StringsKt.equals(mode, "Rewinside", true)) {
/*     */         if (StringsKt.equals(mode, "Mineplex", true)) {
/*     */           if (MinecraftInstance.mc.getThePlayer() == null)
/*     */             Intrinsics.throwNpe(); 
/*     */           if (MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItemInHand() == null) {
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             if (event.getY() < MinecraftInstance.mc.getThePlayer().getPosY()) {
/*     */               if (MinecraftInstance.mc.getThePlayer() == null)
/*     */                 Intrinsics.throwNpe(); 
/*     */               event.setBoundingBox(MinecraftInstance.classProvider.createAxisAlignedBB(event.getX(), event.getY(), event.getZ(), event.getX() + 1.0D, MinecraftInstance.mc.getThePlayer().getPosY(), event.getZ() + 1.0D));
/*     */             } 
/*     */             return;
/*     */           } 
/*     */         } 
/*     */         return;
/*     */       } 
/*     */     } else {
/*     */       return;
/*     */     } 
/*     */     if (MinecraftInstance.mc.getThePlayer() == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     if (event.getY() < MinecraftInstance.mc.getThePlayer().getPosY()) {
/*     */       if (MinecraftInstance.mc.getThePlayer() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       event.setBoundingBox(MinecraftInstance.classProvider.createAxisAlignedBB(event.getX(), event.getY(), event.getZ(), event.getX() + 1.0D, MinecraftInstance.mc.getThePlayer().getPosY(), event.getZ() + 1.0D));
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onJump(@NotNull JumpEvent e) {
/*     */     Intrinsics.checkParameterIsNotNull(e, "e");
/*     */     String mode = (String)this.modeValue.get();
/*     */     if (!StringsKt.equals(mode, "Hypixel", true) && !StringsKt.equals(mode, "BoostHypixel", true) && !StringsKt.equals(mode, "Rewinside", true)) {
/*     */       if (StringsKt.equals(mode, "Mineplex", true)) {
/*     */         if (MinecraftInstance.mc.getThePlayer() == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         if (MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItemInHand() == null) {
/*     */           e.cancelEvent();
/*     */           return;
/*     */         } 
/*     */       } 
/*     */       return;
/*     */     } 
/*     */     e.cancelEvent();
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onStep(@NotNull StepEvent e) {
/*     */     Intrinsics.checkParameterIsNotNull(e, "e");
/*     */     String mode = (String)this.modeValue.get();
/*     */     if (!StringsKt.equals(mode, "Hypixel", true) && !StringsKt.equals(mode, "BoostHypixel", true) && !StringsKt.equals(mode, "Rewinside", true)) {
/*     */       if (StringsKt.equals(mode, "Mineplex", true)) {
/*     */         if (MinecraftInstance.mc.getThePlayer() == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         if (MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItemInHand() == null) {
/*     */           e.setStepHeight(0.0F);
/*     */           return;
/*     */         } 
/*     */       } 
/*     */       return;
/*     */     } 
/*     */     e.setStepHeight(0.0F);
/*     */   }
/*     */   
/*     */   private final void handleVanillaKickBypass() {
/*     */     if (!((Boolean)this.vanillaKickBypassValue.get()).booleanValue() || !this.groundTimer.hasTimePassed(1000L))
/*     */       return; 
/*     */     double ground = calculateGround();
/*     */     Fly fly1 = this;
/*     */     boolean bool1 = false, bool2 = false;
/*     */     Fly $this$run = fly1;
/*     */     int $i$a$-run-Fly$handleVanillaKickBypass$1 = 0;
/*     */     if (MinecraftInstance.mc.getThePlayer() == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     double d1 = MinecraftInstance.mc.getThePlayer().getPosY();
/*     */     while (d1 > ground) {
/*     */       if (MinecraftInstance.mc.getThePlayer() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       if (MinecraftInstance.mc.getThePlayer() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(MinecraftInstance.mc.getThePlayer().getPosX(), d1, MinecraftInstance.mc.getThePlayer().getPosZ(), true));
/*     */       if (d1 - 8.0D < ground)
/*     */         break; 
/*     */       d1 -= 8.0D;
/*     */     } 
/*     */     if (MinecraftInstance.mc.getThePlayer() == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     if (MinecraftInstance.mc.getThePlayer() == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(MinecraftInstance.mc.getThePlayer().getPosX(), ground, MinecraftInstance.mc.getThePlayer().getPosZ(), true));
/*     */     double posY = ground;
/*     */     while (true) {
/*     */       if (MinecraftInstance.mc.getThePlayer() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       if (posY < MinecraftInstance.mc.getThePlayer().getPosY()) {
/*     */         if (MinecraftInstance.mc.getThePlayer() == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         if (MinecraftInstance.mc.getThePlayer() == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(MinecraftInstance.mc.getThePlayer().getPosX(), posY, MinecraftInstance.mc.getThePlayer().getPosZ(), true));
/*     */         if (MinecraftInstance.mc.getThePlayer() == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         if (posY + 8.0D > MinecraftInstance.mc.getThePlayer().getPosY())
/*     */           break; 
/*     */         posY += 8.0D;
/*     */         continue;
/*     */       } 
/*     */       break;
/*     */     } 
/*     */     if (MinecraftInstance.mc.getThePlayer() == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     if (MinecraftInstance.mc.getThePlayer() == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     if (MinecraftInstance.mc.getThePlayer() == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(MinecraftInstance.mc.getThePlayer().getPosX(), MinecraftInstance.mc.getThePlayer().getPosY(), MinecraftInstance.mc.getThePlayer().getPosZ(), true));
/*     */     this.groundTimer.reset();
/*     */   }
/*     */   
/*     */   private final double calculateGround() {
/*     */     if (MinecraftInstance.mc.getThePlayer() == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     IAxisAlignedBB playerBoundingBox = MinecraftInstance.mc.getThePlayer().getEntityBoundingBox();
/*     */     double blockHeight = 1.0D;
/*     */     if (MinecraftInstance.mc.getThePlayer() == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     double ground = MinecraftInstance.mc.getThePlayer().getPosY();
/*     */     while (ground > 0.0D) {
/*     */       IAxisAlignedBB customBox = MinecraftInstance.classProvider.createAxisAlignedBB(playerBoundingBox.getMaxX(), ground + blockHeight, playerBoundingBox.getMaxZ(), playerBoundingBox.getMinX(), ground, playerBoundingBox.getMinZ());
/*     */       if (MinecraftInstance.mc.getTheWorld() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       if (MinecraftInstance.mc.getTheWorld().checkBlockCollision(customBox)) {
/*     */         if (blockHeight <= 0.05D)
/*     */           return ground + blockHeight; 
/*     */         ground += blockHeight;
/*     */         blockHeight = 0.05D;
/*     */       } 
/*     */       ground -= blockHeight;
/*     */     } 
/*     */     return 0.0D;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getTag() {
/*     */     return (String)this.modeValue.get();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\Fly.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */