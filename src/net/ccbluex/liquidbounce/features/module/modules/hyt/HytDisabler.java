/*    */ package net.ccbluex.liquidbounce.features.module.modules.hyt;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.TypeCastException;
/*    */ import kotlin.Unit;
/*    */ import kotlin.jvm.functions.Function1;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import net.minecraft.network.play.client.CPacketConfirmTransaction;
/*    */ import net.minecraft.network.play.client.CPacketKeepAlive;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import tomk.utils.packet.PacketUtils;
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
/*    */ @ModuleInfo(name = "HytDisabler", description = "修复版", category = ModuleCategory.HYT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000J\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\016\020\022\032\0020\0232\006\020\024\032\0020\025J\020\020\026\032\0020\0232\006\020\027\032\0020\030H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\036\020\006\032\022\022\004\022\0020\b0\007j\b\022\004\022\0020\b`\tX\004¢\006\002\n\000R\021\020\n\032\0020\013¢\006\b\n\000\032\004\b\f\020\rR\016\020\016\032\0020\017X\004¢\006\002\n\000R\036\020\020\032\022\022\004\022\0020\0210\007j\b\022\004\022\0020\021`\tX\004¢\006\002\n\000¨\006\031"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/hyt/HytDisabler;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "HytAAC", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "debugValue", "keepAlives", "Ljava/util/ArrayList;", "Lnet/minecraft/network/play/client/CPacketKeepAlive;", "Lkotlin/collections/ArrayList;", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "getModeValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "msTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "transactions", "Lnet/minecraft/network/play/client/CPacketConfirmTransaction;", "debug", "", "s", "", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "XSJClient"})
/*    */ public final class HytDisabler
/*    */   extends Module
/*    */ {
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\013¢\006\002\b\004"}, d2 = {"onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "invoke"})
/*    */   static final class HytDisabler$onPacket$1
/*    */     extends Lambda
/*    */     implements Function1<UpdateEvent, Unit>
/*    */   {
/*    */     @EventTarget
/*    */     public final void invoke(@NotNull UpdateEvent event) {
/* 78 */       Intrinsics.checkParameterIsNotNull(event, "event"); String str = (String)HytDisabler.this.getModeValue().get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case -330391888:
/* 79 */           if (str.equals("hytspartan") && 
/* 80 */             HytDisabler.this.msTimer.hasTimePassed(3000L) && HytDisabler.this.keepAlives.size() > 0 && HytDisabler.this.transactions.size() > 0) {
/* 81 */             PacketUtils.send(HytDisabler.this.keepAlives.get(HytDisabler.this.keepAlives.size() - 1));
/* 82 */             PacketUtils.send(HytDisabler.this.transactions.get(HytDisabler.this.transactions.size() - 1));
/*    */             
/* 84 */             HytDisabler.this.debug("c00 no." + (HytDisabler.this.keepAlives.size() - 1) + " sent.");
/* 85 */             HytDisabler.this.debug("c0f no." + (HytDisabler.this.transactions.size() - 1) + " sent.");
/* 86 */             HytDisabler.this.keepAlives.clear();
/* 87 */             HytDisabler.this.transactions.clear();
/* 88 */             HytDisabler.this.msTimer.reset();
/*    */           } 
/*    */           break; }
/*    */     
/*    */     }
/*    */     
/*    */     HytDisabler$onPacket$1() {
/*    */       super(1);
/*    */     }
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   private final ListValue modeValue = new ListValue("Mode", new String[] { "HytSpartan", "HytRange", "HytAAC" }, "HytSpartan");
/*    */   
/*    */   @NotNull
/*    */   public final ListValue getModeValue() {
/*    */     return this.modeValue;
/*    */   }
/*    */   
/*    */   private final BoolValue HytAAC = new BoolValue("HytAAC", false);
/*    */   private final BoolValue debugValue = new BoolValue("Debug", false);
/*    */   private final ArrayList<CPacketKeepAlive> keepAlives;
/*    */   private final ArrayList<CPacketConfirmTransaction> transactions;
/*    */   private final MSTimer msTimer;
/*    */   
/*    */   public HytDisabler() {
/*    */     HytDisabler hytDisabler = this;
/*    */     boolean bool = false;
/*    */     ArrayList<CPacketKeepAlive> arrayList = new ArrayList();
/*    */     hytDisabler = this;
/*    */     bool = false;
/*    */     hytDisabler.transactions = (ArrayList)(arrayList = new ArrayList<>());
/*    */     this.msTimer = new MSTimer();
/*    */   }
/*    */   
/*    */   public final void debug(@NotNull String s) {
/*    */     Intrinsics.checkParameterIsNotNull(s, "s");
/*    */     if (((Boolean)this.debugValue.get()).booleanValue())
/*    */       ClientUtils.displayChatMessage("§7[§3§lDisabler§7]§f " + s); 
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/*    */     Intrinsics.checkParameterIsNotNull(event, "event");
/*    */     IPacket packet = event.getPacket();
/*    */     String str = (String)this.modeValue.get();
/*    */     boolean bool = false;
/*    */     if (str == null)
/*    */       throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*    */     Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()");
/*    */     str = str.toLowerCase();
/*    */     switch (str.hashCode()) {
/*    */       case 46797210:
/*    */         if (str.equals("HytRange")) {
/*    */           if (MinecraftInstance.mc.getThePlayer() == null)
/*    */             Intrinsics.throwNpe(); 
/*    */           if (MinecraftInstance.mc.getThePlayer().getTicksExisted() % 4 == 0 && MinecraftInstance.classProvider.isCPacketPlayer(packet))
/*    */             event.cancelEvent(); 
/*    */         } 
/*    */         break;
/*    */       case -1202237472:
/*    */         if (str.equals("hytaac") && ((Boolean)this.HytAAC.get()).booleanValue()) {
/*    */           event.getPacket() instanceof net.minecraft.network.play.server.SPacketPlayerPosLook;
/*    */           IPacket s08 = event.getPacket();
/*    */           debug("[Disabler] 屏蔽S类型发包数据");
/*    */         } 
/*    */         break;
/*    */       case -330391888:
/*    */         if (str.equals("hytspartan")) {
/*    */           if (packet instanceof CPacketKeepAlive && (this.keepAlives.size() <= 0 || (Intrinsics.areEqual(packet, this.keepAlives.get(this.keepAlives.size() - 1)) ^ true) != 0)) {
/*    */             debug("c00 added");
/*    */             this.keepAlives.add(packet);
/*    */             event.cancelEvent();
/*    */           } 
/*    */           if (packet instanceof CPacketConfirmTransaction && (this.transactions.size() <= 0 || (Intrinsics.areEqual(packet, this.transactions.get(this.transactions.size() - 1)) ^ true) != 0)) {
/*    */             debug("c0f added");
/*    */             this.transactions.add(packet);
/*    */             event.cancelEvent();
/*    */           } 
/*    */         } 
/*    */         break;
/*    */     } 
/*    */     HytDisabler$onPacket$1 $fun$onUpdate$1 = new HytDisabler$onPacket$1();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\hyt\HytDisabler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */