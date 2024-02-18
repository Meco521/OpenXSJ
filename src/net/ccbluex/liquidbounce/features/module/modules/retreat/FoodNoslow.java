/*     */ package net.ccbluex.liquidbounce.features.module.modules.retreat;
/*     */ import java.util.LinkedList;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItem;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayerBlockPlacement;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayerDigging;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.event.SlowDownEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.INetHandlerPlayServer;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "FoodNoslow", description = "走吃", category = ModuleCategory.RETREAT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\001\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\013\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\003\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\016\n\002\b\b\n\002\030\002\n\002\b\003\n\002\020\b\n\000\n\002\020\007\n\000\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\006\n\002\020\t\n\002\b\003\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\037\032\0020\0062\006\020 \032\0020!H\002J\020\020\"\032\0020\0062\006\020 \032\0020!H\002J\016\020#\032\0020\0062\006\020$\032\0020%J\032\020&\032\0020'2\b\020(\032\004\030\0010)2\006\020*\032\0020\006H\002J\006\020+\032\0020\006J\b\020,\032\0020-H\026J\020\020.\032\0020-2\006\020 \032\0020/H\007J\020\0200\032\0020-2\006\020 \032\00201H\007J\020\0202\032\0020-2\006\020 \032\00203H\007JB\0204\032\0020-2\006\0205\032\0020!2\006\0206\032\0020\0062\006\0207\032\0020\0062\006\0208\032\0020\0062\006\0209\032\0020:2\006\020;\032\0020\0062\b\b\002\020<\032\0020\006H\002R\016\020\003\032\0020\004X\004¢\006\002\n\000R\024\020\005\032\0020\0068BX\004¢\006\006\032\004\b\005\020\007R\021\020\b\032\0020\t¢\006\b\n\000\032\004\b\n\020\013R\016\020\f\032\0020\006X\016¢\006\002\n\000R\016\020\r\032\0020\016X\004¢\006\002\n\000R\016\020\017\032\0020\004X\004¢\006\002\n\000R\016\020\020\032\0020\006X\016¢\006\002\n\000R\032\020\021\032\016\022\n\022\b\022\004\022\0020\0240\0230\022X\016¢\006\002\n\000R\016\020\025\032\0020\006X\016¢\006\002\n\000R\016\020\026\032\0020\006X\016¢\006\002\n\000R\024\020\027\032\0020\0308VX\004¢\006\006\032\004\b\031\020\032R\021\020\033\032\0020\004¢\006\b\n\000\032\004\b\034\020\035R\016\020\036\032\0020\006X\016¢\006\002\n\000¨\006="}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/retreat/FoodNoslow;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "Timer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "isBlocking", "", "()Z", "killAura", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;", "getKillAura", "()Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;", "lastBlockingStat", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "msTimer", "nextTemp", "packetBuf", "Ljava/util/LinkedList;", "Lnet/minecraft/network/Packet;", "Lnet/minecraft/network/play/INetHandlerPlayServer;", "pendingFlagApplyPacket", "sendBuf", "tag", "", "getTag", "()Ljava/lang/String;", "timer", "getTimer", "()Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "waitC03", "OnPost", "event", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "OnPre", "fuckKotline", "value", "", "getMultiplier", "", "item", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "isForward", "isBlock", "onDisable", "", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onSlowDown", "Lnet/ccbluex/liquidbounce/event/SlowDownEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "sendPacket", "Event", "SendC07", "SendC08", "Delay", "DelayValue", "", "onGround", "Hypixel", "XSJClient"})
/*     */ public final class FoodNoslow extends Module {
/*  26 */   private final ListValue modeValue = new ListValue(
/*  27 */       "PacketMode", 
/*  28 */       new String[] { "GrimEat"
/*  29 */       }, "GrimEat");
/*     */   @NotNull
/*  31 */   private final MSTimer timer = new MSTimer(); @NotNull public final MSTimer getTimer() { return this.timer; }
/*  32 */    private final MSTimer Timer = new MSTimer();
/*     */   private boolean pendingFlagApplyPacket;
/*  34 */   private final MSTimer msTimer = new MSTimer();
/*     */   private boolean sendBuf;
/*  36 */   private LinkedList<Packet<INetHandlerPlayServer>> packetBuf = new LinkedList<>();
/*     */   private boolean nextTemp; private boolean waitC03; private boolean lastBlockingStat; @NotNull
/*     */   private final KillAura killAura;
/*     */   
/*     */   @NotNull
/*  41 */   public final KillAura getKillAura() { return this.killAura; } public FoodNoslow() { if (Retreat.INSTANCE.getModuleManager().get(KillAura.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura");  this.killAura = (KillAura)Retreat.INSTANCE.getModuleManager().get(KillAura.class); }
/*     */ 
/*     */   
/*     */   public final boolean isBlock() {
/*  45 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  return (MinecraftInstance.mc.getThePlayer().isBlocking() || this.killAura.getBlockingStatus());
/*     */   }
/*     */   
/*     */   public final boolean fuckKotline(int value) {
/*  49 */     return (value == 1);
/*     */   }
/*     */   
/*     */   private final boolean OnPre(MotionEvent event) {
/*  53 */     return (event.getEventState() == EventState.PRE);
/*     */   }
/*     */   
/*     */   private final boolean OnPost(MotionEvent event) {
/*  57 */     return (event.getEventState() == EventState.POST);
/*     */   }
/*     */   private final boolean isBlocking() {
/*     */     // Byte code:
/*     */     //   0: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   8: dup
/*     */     //   9: ifnonnull -> 15
/*     */     //   12: invokestatic throwNpe : ()V
/*     */     //   15: invokeinterface isUsingItem : ()Z
/*     */     //   20: ifne -> 57
/*     */     //   23: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   26: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   29: ldc net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*     */     //   31: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   34: dup
/*     */     //   35: ifnonnull -> 48
/*     */     //   38: new kotlin/TypeCastException
/*     */     //   41: dup
/*     */     //   42: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura'
/*     */     //   44: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   47: athrow
/*     */     //   48: checkcast net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*     */     //   51: invokevirtual getBlockingStatus : ()Z
/*     */     //   54: ifeq -> 122
/*     */     //   57: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   60: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   65: dup
/*     */     //   66: ifnonnull -> 72
/*     */     //   69: invokestatic throwNpe : ()V
/*     */     //   72: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   77: ifnull -> 122
/*     */     //   80: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   83: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   88: dup
/*     */     //   89: ifnonnull -> 95
/*     */     //   92: invokestatic throwNpe : ()V
/*     */     //   95: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   100: dup
/*     */     //   101: ifnonnull -> 107
/*     */     //   104: invokestatic throwNpe : ()V
/*     */     //   107: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   112: instanceof net/minecraft/item/ItemSword
/*     */     //   115: ifeq -> 122
/*     */     //   118: iconst_1
/*     */     //   119: goto -> 123
/*     */     //   122: iconst_0
/*     */     //   123: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #61	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	124	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/FoodNoslow;
/*     */   }
/*     */   
/*     */   public void onDisable() {
/*  64 */     this.Timer.reset();
/*  65 */     this.msTimer.reset();
/*  66 */     this.pendingFlagApplyPacket = false;
/*  67 */     this.sendBuf = false;
/*  68 */     this.packetBuf.clear();
/*  69 */     this.nextTemp = false;
/*  70 */     this.waitC03 = false;
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
/*     */   private final void sendPacket(MotionEvent Event, boolean SendC07, boolean SendC08, boolean Delay, long DelayValue, boolean onGround, boolean Hypixel) {
/*  82 */     if (Retreat.INSTANCE.getModuleManager().get(KillAura.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura");  KillAura aura = (KillAura)Retreat.INSTANCE.getModuleManager().get(KillAura.class);
/*     */ 
/*     */ 
/*     */     
/*  86 */     if (EnumFacing.DOWN == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.api.minecraft.util.IEnumFacing");  IPacket digging = MinecraftInstance.classProvider.createCPacketPlayerDigging(ICPacketPlayerDigging.WAction.RELEASE_USE_ITEM, new WBlockPos(-1, -1, -1), (IEnumFacing)EnumFacing.DOWN);
/*     */ 
/*     */     
/*  89 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  ICPacketPlayerBlockPlacement blockPlace = MinecraftInstance.classProvider.createCPacketPlayerBlockPlacement((IItemStack)Integer.valueOf(MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItem()));
/*     */ 
/*     */ 
/*     */     
/*  93 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  ICPacketPlayerBlockPlacement blockMent = MinecraftInstance.classProvider.createCPacketPlayerBlockPlacement(new WBlockPos(-1, -1, -1), 255, (IItemStack)Integer.valueOf(MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItem()), 
/*  94 */         0.0F, 
/*  95 */         0.0F, 
/*  96 */         0.0F);
/*     */     
/*  98 */     if (onGround) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().getOnGround()) {
/*     */         return;
/*     */       } }
/*     */     
/* 102 */     if (SendC07 && OnPre(Event)) {
/* 103 */       if (Delay && this.Timer.hasTimePassed(DelayValue)) {
/* 104 */         MinecraftInstance.mc.getNetHandler().addToSendQueue(digging);
/* 105 */       } else if (!Delay) {
/* 106 */         MinecraftInstance.mc.getNetHandler().addToSendQueue(digging);
/*     */       } 
/*     */     }
/* 109 */     if (SendC08 && OnPost(Event)) {
/* 110 */       if (Delay && this.Timer.hasTimePassed(DelayValue) && !Hypixel) {
/* 111 */         MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)blockPlace);
/* 112 */         this.Timer.reset();
/* 113 */       } else if (!Delay && !Hypixel) {
/* 114 */         MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)blockPlace);
/* 115 */       } else if (Hypixel) {
/* 116 */         MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)blockMent);
/*     */       } 
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
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/* 146 */     Intrinsics.checkParameterIsNotNull(event, "event"); IPacket packet = event.getPacket();
/* 147 */     if (this.modeValue.equals("GrimEat") && this.nextTemp) {
/* 148 */       if ((packet instanceof net.minecraft.network.play.client.CPacketPlayerDigging || packet instanceof ICPacketPlayerBlockPlacement) && isBlocking()) {
/* 149 */         event.cancelEvent();
/*     */       }
/* 151 */       event.cancelEvent();
/* 152 */     } else if (packet instanceof net.minecraft.network.play.client.CPacketPlayer || packet instanceof net.minecraft.network.play.client.CPacketAnimation || packet instanceof net.minecraft.network.play.client.CPacketEntityAction || packet instanceof net.minecraft.network.play.client.CPacketUseEntity || packet instanceof net.minecraft.network.play.client.CPacketPlayerDigging || packet instanceof ICPacketPlayerBlockPlacement) {
/* 153 */       if (this.modeValue.equals("GrimEat") && this.waitC03 && packet instanceof net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayer) {
/* 154 */         this.waitC03 = false;
/*     */         return;
/*     */       } 
/* 157 */       this.packetBuf.add((Packet<INetHandlerPlayServer>)packet);
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 163 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (this.modeValue.equals("GrimEat") && (this.lastBlockingStat || isBlocking())) {
/* 164 */       if (this.msTimer.hasTimePassed(230L) && this.nextTemp) {
/* 165 */         this.nextTemp = false;
/*     */ 
/*     */ 
/*     */         
/* 169 */         if (EnumFacing.DOWN == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.api.minecraft.util.IEnumFacing");  MinecraftInstance.classProvider.createCPacketPlayerDigging(ICPacketPlayerDigging.WAction.RELEASE_USE_ITEM, new WBlockPos(-1, -1, -1), (IEnumFacing)EnumFacing.DOWN);
/*     */         
/* 171 */         LinkedList<Packet<INetHandlerPlayServer>> linkedList = this.packetBuf; boolean bool = false; if (!linkedList.isEmpty()) {
/* 172 */           boolean canAttack = false;
/* 173 */           for (Packet<INetHandlerPlayServer> packet : this.packetBuf) {
/* 174 */             if (packet instanceof net.minecraft.network.play.client.CPacketPlayer) {
/* 175 */               canAttack = true;
/*     */             }
/* 177 */             if ((!(packet instanceof net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketUseEntity) && !(packet instanceof net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketAnimation)) || canAttack) {
/* 178 */               Intrinsics.checkExpressionValueIsNotNull(packet, "packet"); PacketUtils.sendPacketNoEvent(packet);
/*     */             } 
/*     */           } 
/* 181 */           this.packetBuf.clear();
/*     */         } 
/*     */       } 
/* 184 */       if (!this.nextTemp) {
/* 185 */         this.lastBlockingStat = isBlocking();
/* 186 */         this.nextTemp = true;
/* 187 */         this.waitC03 = this.modeValue.equals("GrimEat");
/* 188 */         this.msTimer.reset();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   @EventTarget
/*     */   public final void onSlowDown(@NotNull SlowDownEvent event) {
/* 194 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().getHeldItem(); IItem heldItem = (MinecraftInstance.mc.getThePlayer().getHeldItem() != null) ? MinecraftInstance.mc.getThePlayer().getHeldItem().getItem() : null;
/*     */     
/* 196 */     event.setForward(getMultiplier(heldItem, true));
/* 197 */     event.setStrafe(getMultiplier(heldItem, false));
/*     */   }
/*     */   private final float getMultiplier(IItem item, boolean isForward) {
/* 200 */     return (
/* 201 */       MinecraftInstance.classProvider.isItemFood(item) || MinecraftInstance.classProvider.isItemPotion(item) || MinecraftInstance.classProvider.isItemBucketMilk(item)) ? (
/* 202 */       isForward ? 0.8F : 0.8F) : 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 209 */       0.2F;
/*     */   }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public String getTag() {
/* 215 */     return (String)this.modeValue.get();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\retreat\FoodNoslow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */