/*     */ package net.ccbluex.liquidbounce.features.module.modules.player;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.functions.Function1;
/*     */ import kotlin.jvm.internal.FunctionReference;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Reflection;
/*     */ import kotlin.reflect.KDeclarationContainer;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.IClassProvider;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayer;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
/*     */ import net.ccbluex.liquidbounce.event.EventState;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.block.BlockUtils;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.utils.timer.TickTimer;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @ModuleInfo(name = "NoFall", description = "Prevents you from taking fall damage.", category = ModuleCategory.COMBAT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\001\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020!\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\006\n\002\020\006\n\002\b\003\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\030\020$\032\0020\0042\006\020%\032\0020&2\006\020'\032\0020&H\002J\b\020(\032\0020\004H\002J\b\020)\032\0020*H\026J\022\020+\032\0020*2\b\020,\032\004\030\0010-H\007J\020\020.\032\0020*2\006\020,\032\0020/H\007J\020\0200\032\0020*2\006\020,\032\0020/H\003J\020\0201\032\0020*2\006\020,\032\00202H\007J\022\0203\032\0020*2\b\020,\032\004\030\00104H\007R\016\020\003\032\0020\004X\016¢\006\002\n\000R\024\020\005\032\b\022\004\022\0020\0070\006X\004¢\006\002\n\000R\020\020\b\032\004\030\0010\tX\016¢\006\002\n\000R\016\020\n\032\0020\013X\016¢\006\002\n\000R\020\020\f\032\004\030\0010\rX\016¢\006\002\n\000R\016\020\016\032\0020\004X\016¢\006\002\n\000R\016\020\017\032\0020\020X\016¢\006\002\n\000R\016\020\021\032\0020\004X\016¢\006\002\n\000R\016\020\022\032\0020\020X\004¢\006\002\n\000R\016\020\023\032\0020\024X\004¢\006\002\n\000R\016\020\025\032\0020\026X\004¢\006\002\n\000R\016\020\027\032\0020\026X\004¢\006\002\n\000R\020\020\030\032\0020\0318\006X\004¢\006\002\n\000R\016\020\032\032\0020\004X\016¢\006\002\n\000R\024\020\033\032\b\022\004\022\0020\0350\034X\004¢\006\002\n\000R\024\020\036\032\0020\0378VX\004¢\006\006\032\004\b \020!R\016\020\"\032\0020\020X\016¢\006\002\n\000R\016\020#\032\0020\020X\016¢\006\002\n\000¨\0065"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/player/NoFall;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "aac4Fakelag", "", "aac4Packets", "", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;", "currentMlgBlock", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "currentMlgItemIndex", "", "currentMlgRotation", "Lnet/ccbluex/liquidbounce/utils/VecRotation;", "fall", "fallrange", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "jumped", "minFallDistance", "mlgTimer", "Lnet/ccbluex/liquidbounce/utils/timer/TickTimer;", "mlgTimer2", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "mlgTimer3", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "packetModify", "packets", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;", "tag", "", "getTag", "()Ljava/lang/String;", "test", "test2", "inAir", "height", "", "plus", "inVoid", "onEnable", "", "onJump", "event", "Lnet/ccbluex/liquidbounce/event/JumpEvent;", "onMotion", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onMotionUpdate", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class NoFall extends Module {
/*     */   @JvmField
/*     */   @NotNull
/*  36 */   public final ListValue modeValue = new ListValue("Mode", new String[] { "SpoofGround", "HuaYuTing", "AAC4", "MLG", "Test", "HuaYuTingfix2" }, "SpoofGround");
/*  37 */   private final FloatValue minFallDistance = new FloatValue("MinMLGHeight", 5.0F, 2.0F, 50.0F);
/*  38 */   private final TickTimer mlgTimer = new TickTimer();
/*  39 */   private final MSTimer mlgTimer2 = new MSTimer();
/*  40 */   private final MSTimer mlgTimer3 = new MSTimer();
/*     */   
/*     */   private boolean jumped;
/*     */   private VecRotation currentMlgRotation;
/*     */   private int currentMlgItemIndex;
/*     */   private WBlockPos currentMlgBlock;
/*  46 */   private FloatValue test = new FloatValue("TEST", 1000.0F, 0.0F, 20000.0F);
/*  47 */   private FloatValue test2 = new FloatValue("TEST2", 1000.0F, 0.0F, 20000.0F); private boolean aac4Fakelag; private boolean packetModify; private final List<ICPacketPlayer> aac4Packets; private final LinkedBlockingQueue<IPacket> packets; private FloatValue fallrange;
/*     */   private boolean fall;
/*     */   
/*     */   public NoFall() {
/*  51 */     NoFall noFall = this; boolean bool = false; ArrayList<ICPacketPlayer> arrayList = new ArrayList();
/*  52 */     this.packets = new LinkedBlockingQueue<>();
/*  53 */     this.fallrange = new FloatValue("Fall", 0.0F, 0.0F, 1.5F);
/*     */   }
/*     */ 
/*     */   
/*     */   @EventTarget(ignoreCondition = true)
/*     */   public final void onUpdate(@Nullable UpdateEvent event) {
/*  59 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround()) {
/*  60 */       this.jumped = false;
/*     */     }
/*  62 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getMotionY() > false) {
/*  63 */       this.jumped = true;
/*     */     }
/*  65 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!BlockUtils.collideBlock(MinecraftInstance.mc.getThePlayer().getEntityBoundingBox(), new NoFall$onUpdate$1(MinecraftInstance.classProvider))) {
/*  66 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!BlockUtils.collideBlock(MinecraftInstance.classProvider.createAxisAlignedBB(MinecraftInstance.mc.getThePlayer().getEntityBoundingBox().getMaxX(), MinecraftInstance.mc.getThePlayer().getEntityBoundingBox().getMaxY(), MinecraftInstance.mc.getThePlayer().getEntityBoundingBox().getMaxZ(), MinecraftInstance.mc.getThePlayer().getEntityBoundingBox().getMinX(), MinecraftInstance.mc.getThePlayer().getEntityBoundingBox().getMinY() - 0.01D, MinecraftInstance.mc.getThePlayer().getEntityBoundingBox().getMinZ()), new NoFall$onUpdate$2(MinecraftInstance.classProvider))) {
/*     */ 
/*     */         
/*  69 */         String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case -995865464:
/*  70 */             if (str.equals("packet")) {
/*  71 */               if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getFallDistance() > 2.0F)
/*  72 */                 MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayer(true)); 
/*     */             } 
/*     */             break; }
/*     */         
/*     */         return;
/*     */       } 
/*  78 */     }  } public void onEnable() { this.aac4Packets.clear();
/*  79 */     this.packetModify = false;
/*  80 */     this.aac4Fakelag = false;
/*  81 */     this.fall = false; }
/*     */ 
/*     */   
/*     */   @EventTarget
/*  85 */   public final void onPacket(@NotNull PacketEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); IPacket packet = event.getPacket();
/*  86 */     String mode = (String)this.modeValue.get();
/*  87 */     if (MinecraftInstance.classProvider.isCPacketPlayer(packet)) {
/*  88 */       ICPacketPlayer playerPacket = packet.asCPacketPlayer();
/*  89 */       if (StringsKt.equals(mode, "SpoofGround", true)) playerPacket.setOnGround(true);
/*     */     
/*     */     } 
/*  92 */     String str1 = (String)this.modeValue.get(); boolean bool = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str1 = str1.toLowerCase(); switch (str1.hashCode()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 3556498:
/* 103 */         if (str1.equals("test")) {
/* 104 */           if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getFallDistance() > 2.0D && this.mlgTimer2.hasTimePassed((long)((Number)this.test.get()).floatValue())) {
/* 105 */             if (MinecraftInstance.classProvider.isCPacketPlayer(packet))
/* 106 */               event.cancelEvent(); 
/* 107 */             if (MinecraftInstance.classProvider.isCPacketPlayerPosition(packet) || MinecraftInstance.classProvider.isCPacketPlayerPosLook(packet) || 
/* 108 */               MinecraftInstance.classProvider.isCPacketPlayerBlockPlacement(packet) || 
/* 109 */               MinecraftInstance.classProvider.isCPacketAnimation(packet) || 
/* 110 */               MinecraftInstance.classProvider.isCPacketEntityAction(packet) || MinecraftInstance.classProvider.isCPacketUseEntity(packet) || MinecraftInstance.classProvider.isCPacketConfirmTransaction(packet)) {
/* 111 */               event.cancelEvent();
/* 112 */               this.packets.add(packet);
/*     */             } 
/* 114 */             this.fall = true;
/* 115 */             this.mlgTimer2.reset();
/*     */           } 
/* 117 */           if (this.fall && this.mlgTimer3.hasTimePassed((long)((Number)this.test2.get()).floatValue()))
/* 118 */           { while (!this.packets.isEmpty()) {
/* 119 */               Intrinsics.checkExpressionValueIsNotNull(this.packets.take(), "packets.take()"); MinecraftInstance.mc.getNetHandler().getNetworkManager().sendPacket(this.packets.take());
/*     */             } 
/* 121 */             this.packets.clear();
/* 122 */             this.mlgTimer3.reset();
/* 123 */             this.fall = false; } 
/*     */         }  break;
/*     */       case -1810413125:
/* 126 */         if (str1.equals("huayutingfix2")) {
/* 127 */           if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getFallDistance() > 2.0D && this.mlgTimer2.hasTimePassed((long)((Number)this.test.get()).floatValue())) {
/* 128 */             Retreat.INSTANCE.getModuleManager().get(Blink.class).setState(true);
/* 129 */             this.fall = true;
/* 130 */             this.mlgTimer2.reset();
/*     */           } 
/*     */           
/* 133 */           if (this.fall && this.mlgTimer3.hasTimePassed((long)((Number)this.test2.get()).floatValue())) {
/* 134 */             Retreat.INSTANCE.getModuleManager().get(Blink.class).setState(false);
/* 135 */             this.mlgTimer3.reset();
/*     */           } 
/*     */         }  break;
/*     */       case 2001009:
/*     */         if (str1.equals("AAC4") && MinecraftInstance.classProvider.isCPacketPlayer(event.getPacket()) && this.aac4Fakelag) { event.cancelEvent(); if (this.packetModify) {
/*     */             event.getPacket().asCPacketPlayer().setOnGround(true); this.packetModify = false;
/*     */           }  this.aac4Packets.add(event.getPacket().asCPacketPlayer()); }
/*     */          break;
/* 143 */     }  } @EventTarget public final void onMotion(@NotNull MotionEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode())
/*     */     
/*     */     { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case -1777040898:
/* 181 */         if (str.equals("huayuting") && event.getEventState() == EventState.PRE)
/* 182 */         { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getFallDistance() > 2.0F && this.mlgTimer.hasTimePassed((int)((Number)this.test.get()).floatValue()))
/* 183 */           { MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayer(true));
/* 184 */             this.mlgTimer.reset(); }  }  break;case 2001009: if (str.equals("AAC4") && event.getEventState() == EventState.PRE) { if (!inVoid()) { if (this.aac4Fakelag) { this.aac4Fakelag = false; if (this.aac4Packets.size() > 0) { for (ICPacketPlayer packet : this.aac4Packets) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().getSendQueue().addToSendQueue((IPacket)packet); }  this.aac4Packets.clear(); }  }  return; }  if (MinecraftInstance.mc.getThePlayer() == null)
/*     */             Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround() && this.aac4Fakelag) { this.aac4Fakelag = false; if (this.aac4Packets.size() > 0) { for (ICPacketPlayer packet : this.aac4Packets) { if (MinecraftInstance.mc.getThePlayer() == null)
/*     */                   Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().getSendQueue().addToSendQueue((IPacket)packet); }  this.aac4Packets.clear(); }  return; }  if (MinecraftInstance.mc.getThePlayer() == null)
/*     */             Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getFallDistance() > 2.5D && this.aac4Fakelag) { this.packetModify = true; if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setFallDistance(0.0F); }  if (inAir(4.0D, 1.0D))
/*     */             return;  if (!this.aac4Fakelag)
/* 190 */             this.aac4Fakelag = true;  }  break; }  } private final boolean inVoid() { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getPosY() < false) {
/* 191 */       return false;
/*     */     }
/* 193 */     int off = 0; while (true) {
/* 194 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (off < MinecraftInstance.mc.getThePlayer().getPosY() + 2) {
/*     */         
/* 196 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe(); 
/* 197 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe(); 
/* 198 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe(); 
/* 199 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();
/*     */         
/* 201 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IAxisAlignedBB bb = MinecraftInstance.classProvider.createAxisAlignedBB(MinecraftInstance.mc.getThePlayer().getPosX(), MinecraftInstance.mc.getThePlayer().getPosY(), MinecraftInstance.mc.getThePlayer().getPosZ(), MinecraftInstance.mc.getThePlayer().getPosX(), off, MinecraftInstance.mc.getThePlayer().getPosZ());
/*     */         
/* 203 */         if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  Collection collection = MinecraftInstance.mc.getTheWorld().getCollidingBoundingBoxes((IEntity)MinecraftInstance.mc.getThePlayer(), bb); boolean bool = false; if (!collection.isEmpty()) {
/* 204 */           return true;
/*     */         }
/* 206 */         off += 2; continue;
/*     */       }  break;
/* 208 */     }  return false; }
/*     */   
/*     */   private final boolean inAir(double height, double plus) {
/* 211 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getPosY() < false) return false; 
/* 212 */     int off = 0;
/* 213 */     while (off < height) {
/*     */       
/* 215 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe(); 
/* 216 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe(); 
/* 217 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe(); 
/* 218 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe(); 
/* 219 */       if (MinecraftInstance.mc == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe(); 
/* 220 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IAxisAlignedBB bb = MinecraftInstance.classProvider.createAxisAlignedBB(MinecraftInstance.mc.getThePlayer().getPosX(), MinecraftInstance.mc.getThePlayer().getPosY(), MinecraftInstance.mc.getThePlayer().getPosZ(), MinecraftInstance.mc.getThePlayer().getPosX(), MinecraftInstance.mc.getThePlayer().getPosY() - off, MinecraftInstance.mc.getThePlayer().getPosZ());
/*     */       
/* 222 */       if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getTheWorld().getCollidingBoundingBoxes((IEntity)MinecraftInstance.mc.getThePlayer(), bb).isEmpty()) {
/* 223 */         return true;
/*     */       }
/* 225 */       off += (int)plus;
/*     */     } 
/* 227 */     return false;
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
/*     */   @EventTarget
/*     */   private final void onMotionUpdate(MotionEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   4: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   7: checkcast java/lang/String
/*     */     //   10: ldc_w 'MLG'
/*     */     //   13: iconst_1
/*     */     //   14: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   17: ifne -> 21
/*     */     //   20: return
/*     */     //   21: aload_1
/*     */     //   22: invokevirtual getEventState : ()Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   25: getstatic net/ccbluex/liquidbounce/event/EventState.PRE : Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   28: if_acmpne -> 983
/*     */     //   31: aload_0
/*     */     //   32: aconst_null
/*     */     //   33: checkcast net/ccbluex/liquidbounce/utils/VecRotation
/*     */     //   36: putfield currentMlgRotation : Lnet/ccbluex/liquidbounce/utils/VecRotation;
/*     */     //   39: aload_0
/*     */     //   40: getfield mlgTimer : Lnet/ccbluex/liquidbounce/utils/timer/TickTimer;
/*     */     //   43: invokevirtual update : ()V
/*     */     //   46: aload_0
/*     */     //   47: getfield mlgTimer : Lnet/ccbluex/liquidbounce/utils/timer/TickTimer;
/*     */     //   50: bipush #10
/*     */     //   52: invokevirtual hasTimePassed : (I)Z
/*     */     //   55: ifne -> 59
/*     */     //   58: return
/*     */     //   59: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   62: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   67: dup
/*     */     //   68: ifnonnull -> 74
/*     */     //   71: invokestatic throwNpe : ()V
/*     */     //   74: invokeinterface getFallDistance : ()F
/*     */     //   79: aload_0
/*     */     //   80: getfield minFallDistance : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   83: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   86: checkcast java/lang/Number
/*     */     //   89: invokevirtual floatValue : ()F
/*     */     //   92: fcmpl
/*     */     //   93: ifle -> 1271
/*     */     //   96: new net/ccbluex/liquidbounce/utils/misc/FallingPlayer
/*     */     //   99: dup
/*     */     //   100: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   103: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   108: dup
/*     */     //   109: ifnonnull -> 115
/*     */     //   112: invokestatic throwNpe : ()V
/*     */     //   115: invokeinterface getPosX : ()D
/*     */     //   120: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   123: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   128: dup
/*     */     //   129: ifnonnull -> 135
/*     */     //   132: invokestatic throwNpe : ()V
/*     */     //   135: invokeinterface getPosY : ()D
/*     */     //   140: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   143: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   148: dup
/*     */     //   149: ifnonnull -> 155
/*     */     //   152: invokestatic throwNpe : ()V
/*     */     //   155: invokeinterface getPosZ : ()D
/*     */     //   160: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   163: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   168: dup
/*     */     //   169: ifnonnull -> 175
/*     */     //   172: invokestatic throwNpe : ()V
/*     */     //   175: invokeinterface getMotionX : ()D
/*     */     //   180: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   183: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   188: dup
/*     */     //   189: ifnonnull -> 195
/*     */     //   192: invokestatic throwNpe : ()V
/*     */     //   195: invokeinterface getMotionY : ()D
/*     */     //   200: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   203: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   208: dup
/*     */     //   209: ifnonnull -> 215
/*     */     //   212: invokestatic throwNpe : ()V
/*     */     //   215: invokeinterface getMotionZ : ()D
/*     */     //   220: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   223: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   228: dup
/*     */     //   229: ifnonnull -> 235
/*     */     //   232: invokestatic throwNpe : ()V
/*     */     //   235: invokeinterface getRotationYaw : ()F
/*     */     //   240: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   243: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   248: dup
/*     */     //   249: ifnonnull -> 255
/*     */     //   252: invokestatic throwNpe : ()V
/*     */     //   255: invokeinterface getMoveStrafing : ()F
/*     */     //   260: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   263: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   268: dup
/*     */     //   269: ifnonnull -> 275
/*     */     //   272: invokestatic throwNpe : ()V
/*     */     //   275: invokeinterface getMoveForward : ()F
/*     */     //   280: invokespecial <init> : (DDDDDDFFF)V
/*     */     //   283: astore_2
/*     */     //   284: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   287: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*     */     //   292: invokeinterface getBlockReachDistance : ()F
/*     */     //   297: f2d
/*     */     //   298: ldc2_w 1.5
/*     */     //   301: dadd
/*     */     //   302: dstore_3
/*     */     //   303: aload_2
/*     */     //   304: dconst_1
/*     */     //   305: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   308: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   313: dup
/*     */     //   314: ifnonnull -> 320
/*     */     //   317: invokestatic throwNpe : ()V
/*     */     //   320: invokeinterface getMotionY : ()D
/*     */     //   325: ddiv
/*     */     //   326: dload_3
/*     */     //   327: dneg
/*     */     //   328: dmul
/*     */     //   329: dstore #6
/*     */     //   331: astore #15
/*     */     //   333: iconst_0
/*     */     //   334: istore #8
/*     */     //   336: dload #6
/*     */     //   338: invokestatic ceil : (D)D
/*     */     //   341: dstore #16
/*     */     //   343: aload #15
/*     */     //   345: dload #16
/*     */     //   347: d2i
/*     */     //   348: invokevirtual findCollision : (I)Lnet/ccbluex/liquidbounce/utils/misc/FallingPlayer$CollisionResult;
/*     */     //   351: dup
/*     */     //   352: ifnull -> 358
/*     */     //   355: goto -> 360
/*     */     //   358: pop
/*     */     //   359: return
/*     */     //   360: astore #5
/*     */     //   362: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*     */     //   365: dup
/*     */     //   366: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   369: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   374: dup
/*     */     //   375: ifnonnull -> 381
/*     */     //   378: invokestatic throwNpe : ()V
/*     */     //   381: invokeinterface getPosX : ()D
/*     */     //   386: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   389: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   394: dup
/*     */     //   395: ifnonnull -> 401
/*     */     //   398: invokestatic throwNpe : ()V
/*     */     //   401: invokeinterface getPosY : ()D
/*     */     //   406: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   409: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   414: dup
/*     */     //   415: ifnonnull -> 421
/*     */     //   418: invokestatic throwNpe : ()V
/*     */     //   421: invokeinterface getEyeHeight : ()F
/*     */     //   426: f2d
/*     */     //   427: dadd
/*     */     //   428: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   431: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   436: dup
/*     */     //   437: ifnonnull -> 443
/*     */     //   440: invokestatic throwNpe : ()V
/*     */     //   443: invokeinterface getPosZ : ()D
/*     */     //   448: invokespecial <init> : (DDD)V
/*     */     //   451: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*     */     //   454: dup
/*     */     //   455: aload #5
/*     */     //   457: invokevirtual getPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   460: dup
/*     */     //   461: ldc_w 'collision.pos'
/*     */     //   464: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   467: checkcast net/ccbluex/liquidbounce/api/minecraft/util/WVec3i
/*     */     //   470: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3i;)V
/*     */     //   473: astore #7
/*     */     //   475: ldc2_w 0.5
/*     */     //   478: dstore #8
/*     */     //   480: ldc2_w 0.5
/*     */     //   483: dstore #10
/*     */     //   485: ldc2_w 0.5
/*     */     //   488: dstore #12
/*     */     //   490: astore #15
/*     */     //   492: iconst_0
/*     */     //   493: istore #14
/*     */     //   495: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*     */     //   498: dup
/*     */     //   499: aload #7
/*     */     //   501: invokevirtual getXCoord : ()D
/*     */     //   504: dload #8
/*     */     //   506: dadd
/*     */     //   507: aload #7
/*     */     //   509: invokevirtual getYCoord : ()D
/*     */     //   512: dload #10
/*     */     //   514: dadd
/*     */     //   515: aload #7
/*     */     //   517: invokevirtual getZCoord : ()D
/*     */     //   520: dload #12
/*     */     //   522: dadd
/*     */     //   523: invokespecial <init> : (DDD)V
/*     */     //   526: astore #16
/*     */     //   528: aload #15
/*     */     //   530: aload #16
/*     */     //   532: invokevirtual distanceTo : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;)D
/*     */     //   535: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   538: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*     */     //   543: invokeinterface getBlockReachDistance : ()F
/*     */     //   548: f2d
/*     */     //   549: ldc2_w 0.75
/*     */     //   552: dstore #7
/*     */     //   554: dstore #17
/*     */     //   556: dstore #15
/*     */     //   558: iconst_0
/*     */     //   559: istore #9
/*     */     //   561: dload #7
/*     */     //   563: invokestatic sqrt : (D)D
/*     */     //   566: dstore #19
/*     */     //   568: dload #15
/*     */     //   570: dload #17
/*     */     //   572: dload #19
/*     */     //   574: dadd
/*     */     //   575: dcmpg
/*     */     //   576: ifge -> 583
/*     */     //   579: iconst_1
/*     */     //   580: goto -> 584
/*     */     //   583: iconst_0
/*     */     //   584: istore #6
/*     */     //   586: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   589: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   594: dup
/*     */     //   595: ifnonnull -> 601
/*     */     //   598: invokestatic throwNpe : ()V
/*     */     //   601: invokeinterface getMotionY : ()D
/*     */     //   606: aload #5
/*     */     //   608: invokevirtual getPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   611: invokevirtual getY : ()I
/*     */     //   614: iconst_1
/*     */     //   615: iadd
/*     */     //   616: i2d
/*     */     //   617: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   620: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   625: dup
/*     */     //   626: ifnonnull -> 632
/*     */     //   629: invokestatic throwNpe : ()V
/*     */     //   632: invokeinterface getPosY : ()D
/*     */     //   637: dsub
/*     */     //   638: dcmpg
/*     */     //   639: ifge -> 645
/*     */     //   642: iconst_1
/*     */     //   643: istore #6
/*     */     //   645: iload #6
/*     */     //   647: ifne -> 651
/*     */     //   650: return
/*     */     //   651: iconst_m1
/*     */     //   652: istore #7
/*     */     //   654: bipush #36
/*     */     //   656: istore #8
/*     */     //   658: bipush #44
/*     */     //   660: istore #9
/*     */     //   662: iload #8
/*     */     //   664: iload #9
/*     */     //   666: if_icmpgt -> 843
/*     */     //   669: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   672: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   677: dup
/*     */     //   678: ifnonnull -> 684
/*     */     //   681: invokestatic throwNpe : ()V
/*     */     //   684: invokeinterface getInventoryContainer : ()Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;
/*     */     //   689: iload #8
/*     */     //   691: invokeinterface getSlot : (I)Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;
/*     */     //   696: invokeinterface getStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   701: astore #10
/*     */     //   703: aload #10
/*     */     //   705: ifnull -> 837
/*     */     //   708: aload #10
/*     */     //   710: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   715: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   718: getstatic net/ccbluex/liquidbounce/api/enums/ItemType.WATER_BUCKET : Lnet/ccbluex/liquidbounce/api/enums/ItemType;
/*     */     //   721: invokeinterface getItemEnum : (Lnet/ccbluex/liquidbounce/api/enums/ItemType;)Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   726: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   729: ifne -> 797
/*     */     //   732: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   735: aload #10
/*     */     //   737: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   742: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*     */     //   747: ifeq -> 837
/*     */     //   750: aload #10
/*     */     //   752: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   757: dup
/*     */     //   758: ifnull -> 778
/*     */     //   761: invokeinterface asItemBlock : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemBlock;
/*     */     //   766: dup
/*     */     //   767: ifnull -> 778
/*     */     //   770: invokeinterface getBlock : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   775: goto -> 780
/*     */     //   778: pop
/*     */     //   779: aconst_null
/*     */     //   780: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   783: getstatic net/ccbluex/liquidbounce/api/enums/BlockType.WEB : Lnet/ccbluex/liquidbounce/api/enums/BlockType;
/*     */     //   786: invokeinterface getBlockEnum : (Lnet/ccbluex/liquidbounce/api/enums/BlockType;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   791: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   794: ifeq -> 837
/*     */     //   797: iload #8
/*     */     //   799: bipush #36
/*     */     //   801: isub
/*     */     //   802: istore #7
/*     */     //   804: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   807: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   812: dup
/*     */     //   813: ifnonnull -> 819
/*     */     //   816: invokestatic throwNpe : ()V
/*     */     //   819: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   824: invokeinterface getCurrentItem : ()I
/*     */     //   829: iload #7
/*     */     //   831: if_icmpne -> 837
/*     */     //   834: goto -> 843
/*     */     //   837: iinc #8, 1
/*     */     //   840: goto -> 662
/*     */     //   843: iload #7
/*     */     //   845: iconst_m1
/*     */     //   846: if_icmpne -> 850
/*     */     //   849: return
/*     */     //   850: aload_0
/*     */     //   851: iload #7
/*     */     //   853: putfield currentMlgItemIndex : I
/*     */     //   856: aload_0
/*     */     //   857: aload #5
/*     */     //   859: invokevirtual getPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   862: putfield currentMlgBlock : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   865: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   868: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   873: dup
/*     */     //   874: ifnonnull -> 880
/*     */     //   877: invokestatic throwNpe : ()V
/*     */     //   880: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   885: invokeinterface getCurrentItem : ()I
/*     */     //   890: iload #7
/*     */     //   892: if_icmpeq -> 933
/*     */     //   895: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   898: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   903: dup
/*     */     //   904: ifnonnull -> 910
/*     */     //   907: invokestatic throwNpe : ()V
/*     */     //   910: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   915: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   918: iload #7
/*     */     //   920: invokeinterface createCPacketHeldItemChange : (I)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;
/*     */     //   925: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   928: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   933: aload_0
/*     */     //   934: aload #5
/*     */     //   936: invokevirtual getPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   939: invokestatic faceBlock : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/utils/VecRotation;
/*     */     //   942: putfield currentMlgRotation : Lnet/ccbluex/liquidbounce/utils/VecRotation;
/*     */     //   945: aload_0
/*     */     //   946: getfield currentMlgRotation : Lnet/ccbluex/liquidbounce/utils/VecRotation;
/*     */     //   949: dup
/*     */     //   950: ifnonnull -> 956
/*     */     //   953: invokestatic throwNpe : ()V
/*     */     //   956: invokevirtual getRotation : ()Lnet/ccbluex/liquidbounce/utils/Rotation;
/*     */     //   959: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   962: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   967: dup
/*     */     //   968: ifnonnull -> 974
/*     */     //   971: invokestatic throwNpe : ()V
/*     */     //   974: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer
/*     */     //   977: invokevirtual toPlayer : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;)V
/*     */     //   980: goto -> 1271
/*     */     //   983: aload_0
/*     */     //   984: getfield currentMlgRotation : Lnet/ccbluex/liquidbounce/utils/VecRotation;
/*     */     //   987: ifnull -> 1271
/*     */     //   990: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   993: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   998: dup
/*     */     //   999: ifnonnull -> 1005
/*     */     //   1002: invokestatic throwNpe : ()V
/*     */     //   1005: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   1010: aload_0
/*     */     //   1011: getfield currentMlgItemIndex : I
/*     */     //   1014: bipush #36
/*     */     //   1016: iadd
/*     */     //   1017: invokeinterface getStackInSlot : (I)Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1022: astore_2
/*     */     //   1023: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1026: aload_2
/*     */     //   1027: dup
/*     */     //   1028: ifnonnull -> 1034
/*     */     //   1031: invokestatic throwNpe : ()V
/*     */     //   1034: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1039: invokeinterface isItemBucket : (Ljava/lang/Object;)Z
/*     */     //   1044: ifeq -> 1101
/*     */     //   1047: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1050: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*     */     //   1055: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1058: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1063: dup
/*     */     //   1064: ifnonnull -> 1070
/*     */     //   1067: invokestatic throwNpe : ()V
/*     */     //   1070: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer
/*     */     //   1073: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1076: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   1081: dup
/*     */     //   1082: ifnonnull -> 1088
/*     */     //   1085: invokestatic throwNpe : ()V
/*     */     //   1088: checkcast net/ccbluex/liquidbounce/api/minecraft/world/IWorld
/*     */     //   1091: aload_2
/*     */     //   1092: invokeinterface sendUseItem : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorld;Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Z
/*     */     //   1097: pop
/*     */     //   1098: goto -> 1178
/*     */     //   1101: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1104: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.UP : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   1107: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   1112: invokeinterface getDirectionVec : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3i;
/*     */     //   1117: astore_3
/*     */     //   1118: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1121: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*     */     //   1126: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1129: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1134: dup
/*     */     //   1135: ifnonnull -> 1141
/*     */     //   1138: invokestatic throwNpe : ()V
/*     */     //   1141: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer
/*     */     //   1144: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1147: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   1152: dup
/*     */     //   1153: ifnonnull -> 1159
/*     */     //   1156: invokestatic throwNpe : ()V
/*     */     //   1159: checkcast net/ccbluex/liquidbounce/api/minecraft/world/IWorld
/*     */     //   1162: aload_2
/*     */     //   1163: invokeinterface sendUseItem : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorld;Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Z
/*     */     //   1168: ifeq -> 1178
/*     */     //   1171: aload_0
/*     */     //   1172: getfield mlgTimer : Lnet/ccbluex/liquidbounce/utils/timer/TickTimer;
/*     */     //   1175: invokevirtual reset : ()V
/*     */     //   1178: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1181: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1186: dup
/*     */     //   1187: ifnonnull -> 1193
/*     */     //   1190: invokestatic throwNpe : ()V
/*     */     //   1193: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   1198: invokeinterface getCurrentItem : ()I
/*     */     //   1203: aload_0
/*     */     //   1204: getfield currentMlgItemIndex : I
/*     */     //   1207: if_icmpeq -> 1271
/*     */     //   1210: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1213: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1218: dup
/*     */     //   1219: ifnonnull -> 1225
/*     */     //   1222: invokestatic throwNpe : ()V
/*     */     //   1225: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1230: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1233: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1236: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1241: dup
/*     */     //   1242: ifnonnull -> 1248
/*     */     //   1245: invokestatic throwNpe : ()V
/*     */     //   1248: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   1253: invokeinterface getCurrentItem : ()I
/*     */     //   1258: invokeinterface createCPacketHeldItemChange : (I)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;
/*     */     //   1263: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   1266: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1271: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #232	-> 0
/*     */     //   #233	-> 20
/*     */     //   #235	-> 21
/*     */     //   #236	-> 31
/*     */     //   #238	-> 39
/*     */     //   #240	-> 46
/*     */     //   #241	-> 58
/*     */     //   #243	-> 59
/*     */     //   #244	-> 96
/*     */     //   #245	-> 100
/*     */     //   #246	-> 120
/*     */     //   #247	-> 140
/*     */     //   #248	-> 160
/*     */     //   #249	-> 180
/*     */     //   #250	-> 200
/*     */     //   #251	-> 220
/*     */     //   #252	-> 240
/*     */     //   #253	-> 260
/*     */     //   #244	-> 280
/*     */     //   #256	-> 284
/*     */     //   #258	-> 303
/*     */     //   #258	-> 347
/*     */     //   #259	-> 359
/*     */     //   #258	-> 360
/*     */     //   #261	-> 362
/*     */     //   #320	-> 495
/*     */     //   #261	-> 532
/*     */     //   #261	-> 574
/*     */     //   #263	-> 586
/*     */     //   #264	-> 642
/*     */     //   #267	-> 645
/*     */     //   #268	-> 650
/*     */     //   #270	-> 651
/*     */     //   #272	-> 654
/*     */     //   #273	-> 669
/*     */     //   #275	-> 703
/*     */     //   #276	-> 797
/*     */     //   #278	-> 804
/*     */     //   #279	-> 834
/*     */     //   #272	-> 837
/*     */     //   #282	-> 843
/*     */     //   #283	-> 849
/*     */     //   #285	-> 850
/*     */     //   #286	-> 856
/*     */     //   #288	-> 865
/*     */     //   #289	-> 895
/*     */     //   #292	-> 933
/*     */     //   #293	-> 945
/*     */     //   #295	-> 983
/*     */     //   #296	-> 990
/*     */     //   #298	-> 1023
/*     */     //   #299	-> 1047
/*     */     //   #301	-> 1101
/*     */     //   #303	-> 1118
/*     */     //   #304	-> 1171
/*     */     //   #306	-> 1178
/*     */     //   #307	-> 1178
/*     */     //   #308	-> 1210
/*     */     //   #309	-> 1271
/*     */     //   #310	-> 1271
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   492	34	7	this_$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   492	34	8	x$iv	D
/*     */     //   492	34	10	y$iv	D
/*     */     //   492	34	12	z$iv	D
/*     */     //   495	31	14	$i$f$addVector	I
/*     */     //   703	134	10	itemStack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   669	171	8	i	I
/*     */     //   654	326	7	index	I
/*     */     //   586	394	6	ok	Z
/*     */     //   362	618	5	collision	Lnet/ccbluex/liquidbounce/utils/misc/FallingPlayer$CollisionResult;
/*     */     //   303	677	3	maxDist	D
/*     */     //   284	696	2	fallingPlayer	Lnet/ccbluex/liquidbounce/utils/misc/FallingPlayer;
/*     */     //   1118	60	3	dirVec	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3i;
/*     */     //   1023	248	2	stack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   0	1272	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/player/NoFall;
/*     */     //   0	1272	1	event	Lnet/ccbluex/liquidbounce/event/MotionEvent;
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
/*     */   @EventTarget(ignoreCondition = true)
/*     */   public final void onJump(@Nullable JumpEvent event) {
/* 314 */     this.jumped = true;
/*     */   }
/*     */   @NotNull
/*     */   public String getTag() {
/* 318 */     return (String)this.modeValue.get();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\player\NoFall.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */