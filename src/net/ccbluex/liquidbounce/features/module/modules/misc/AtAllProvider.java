/*     */ package net.ccbluex.liquidbounce.features.module.modules.misc;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.Unit;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ 
/*     */ @ModuleInfo(name = "AtAllProvider", description = "Automatically mentions everyone on the server when using '@a' in your message.", category = ModuleCategory.MISC)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000J\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\t\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020!\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\021\032\0020\022H\026J\020\020\023\032\0020\0222\006\020\024\032\0020\025H\007J\022\020\026\032\0020\0222\b\020\024\032\004\030\0010\027H\007R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\006X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\024\020\n\032\b\022\004\022\0020\f0\013X\004¢\006\002\n\000R\016\020\r\032\0020\016X\004¢\006\002\n\000R\024\020\017\032\b\022\004\022\0020\f0\020X\004¢\006\002\n\000¨\006\030"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/misc/AtAllProvider;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "delay", "", "maxDelayValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "minDelayValue", "msTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "retryQueue", "", "", "retryValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "sendQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "onDisable", "", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class AtAllProvider extends Module {
/*  18 */   private final IntegerValue minDelayValue = new AtAllProvider$minDelayValue$1("MinDelay", 500, 0, 20000); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/misc/AtAllProvider$minDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class AtAllProvider$minDelayValue$1 extends IntegerValue { AtAllProvider$minDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(int oldValue, int newValue) {
/*  20 */       int i = ((Number)AtAllProvider.this.maxDelayValue.get()).intValue();
/*  21 */       if (i < newValue) set(Integer.valueOf(i)); 
/*     */     } }
/*     */   
/*  24 */   private final IntegerValue maxDelayValue = new AtAllProvider$maxDelayValue$1("MaxDelay", 1000, 0, 20000); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/misc/AtAllProvider$maxDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class AtAllProvider$maxDelayValue$1 extends IntegerValue { AtAllProvider$maxDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(int oldValue, int newValue) {
/*  26 */       int i = ((Number)AtAllProvider.this.minDelayValue.get()).intValue();
/*  27 */       if (i > newValue) set(Integer.valueOf(i)); 
/*     */     } }
/*     */ 
/*     */   
/*  31 */   private final BoolValue retryValue = new BoolValue("Retry", false);
/*  32 */   private final LinkedBlockingQueue<String> sendQueue = new LinkedBlockingQueue<>();
/*  33 */   private final List<String> retryQueue = new ArrayList<>();
/*  34 */   private final MSTimer msTimer = new MSTimer();
/*  35 */   private long delay = TimeUtils.randomDelay(((Number)this.minDelayValue.get()).intValue(), ((Number)this.maxDelayValue.get()).intValue());
/*     */   
/*     */   public void onDisable() {
/*  38 */     LinkedBlockingQueue<String> linkedBlockingQueue = this.sendQueue; boolean bool = false; synchronized (false) { int $i$a$-synchronized-AtAllProvider$onDisable$1 = 0;
/*  39 */       this.sendQueue.clear();
/*  40 */       Unit unit = Unit.INSTANCE; /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/concurrent/LinkedBlockingQueue<ObjectType{java/lang/String}>}, name=null} */ }
/*  41 */      List<String> list = this.retryQueue; bool = false; synchronized (false) { int $i$a$-synchronized-AtAllProvider$onDisable$2 = 0;
/*  42 */       this.retryQueue.clear();
/*  43 */       Unit unit = Unit.INSTANCE; /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/List<ObjectType{java/lang/String}>}, name=null} */ }
/*     */     
/*  45 */     super.onDisable();
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@Nullable UpdateEvent event) {
/*  50 */     if (!this.msTimer.hasTimePassed(this.delay)) {
/*     */       return;
/*     */     }
/*     */     try {
/*  54 */       LinkedBlockingQueue<String> linkedBlockingQueue = this.sendQueue; boolean bool = false; synchronized (false) { int $i$a$-synchronized-AtAllProvider$onUpdate$1 = 0;
/*  55 */         if (this.sendQueue.isEmpty()) {
/*  56 */           if (!((Boolean)this.retryValue.get()).booleanValue() || this.retryQueue.isEmpty()) {
/*     */             /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/concurrent/LinkedBlockingQueue<ObjectType{java/lang/String}>}, name=null} */ return;
/*     */           } 
/*  59 */           this.sendQueue.addAll(this.retryQueue);
/*     */         } 
/*     */         
/*  62 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(this.sendQueue.take(), "sendQueue.take()"); MinecraftInstance.mc.getThePlayer().sendChatMessage(this.sendQueue.take());
/*  63 */         this.msTimer.reset();
/*     */         
/*  65 */         this.delay = TimeUtils.randomDelay(((Number)this.minDelayValue.get()).intValue(), ((Number)this.maxDelayValue.get()).intValue());
/*  66 */         Unit unit = Unit.INSTANCE; /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/concurrent/LinkedBlockingQueue<ObjectType{java/lang/String}>}, name=null} */ } 
/*  67 */     } catch (InterruptedException e) {
/*  68 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/*  74 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.classProvider.isCPacketChatMessage(event.getPacket())) {
/*  75 */       ICPacketChatMessage packetChatMessage = event.getPacket().asCPacketChatMessage();
/*  76 */       String message = packetChatMessage.getMessage();
/*     */       
/*  78 */       if (StringsKt.contains$default(message, "@a", false, 2, null)) {
/*  79 */         LinkedBlockingQueue<String> linkedBlockingQueue = this.sendQueue; boolean bool = false; synchronized (false) { int $i$a$-synchronized-AtAllProvider$onPacket$1 = 0;
/*  80 */           for (INetworkPlayerInfo playerInfo : MinecraftInstance.mc.getNetHandler().getPlayerInfoMap()) {
/*  81 */             String playerName = playerInfo.getGameProfile().getName();
/*     */             
/*  83 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (Intrinsics.areEqual(playerName, MinecraftInstance.mc.getThePlayer().getName())) {
/*     */               continue;
/*     */             }
/*  86 */             Intrinsics.checkExpressionValueIsNotNull(playerName, "playerName"); this.sendQueue.add(StringsKt.replace$default(message, "@a", playerName, false, 4, null));
/*     */           } 
/*  88 */           if (((Boolean)this.retryValue.get()).booleanValue()) {
/*  89 */             List<String> list = this.retryQueue; boolean bool1 = false; synchronized (false) { int $i$a$-synchronized-AtAllProvider$onPacket$1$1 = 0;
/*  90 */               this.retryQueue.clear();
/*  91 */               LinkedBlockingQueue<String> linkedBlockingQueue1 = this.sendQueue; List<String> list1 = this.retryQueue; int $i$f$toTypedArray = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 100 */               Collection<String> thisCollection$iv = linkedBlockingQueue1;
/* 101 */               if (thisCollection$iv.toArray(new String[0]) == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");  String[] arrayOfString = thisCollection$iv.toArray(new String[0]); null = list1.addAll(CollectionsKt.listOf((Object[])Arrays.<String>copyOf(arrayOfString, arrayOfString.length)));
/*     */               /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/List<ObjectType{java/lang/String}>}, name=null} */ }
/*     */           
/*     */           } 
/*     */           Unit unit = Unit.INSTANCE;
/*     */           /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/concurrent/LinkedBlockingQueue<ObjectType{java/lang/String}>}, name=null} */ }
/*     */         
/*     */         event.cancelEvent();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\misc\AtAllProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */