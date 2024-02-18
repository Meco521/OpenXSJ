/*     */ package net.ccbluex.liquidbounce.features.module.modules.misc;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.retreat.CatVelocity;
/*     */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.SPacketChat;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "PacketMonitor", category = ModuleCategory.MISC, description = "发包检测")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000<\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\004\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\020\032\0020\021H\026J\020\020\022\032\0020\0212\006\020\023\032\0020\024H\007J\020\020\025\032\0020\0212\006\020\023\032\0020\026H\007R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\t\032\0020\bX\004¢\006\002\n\000R\016\020\n\032\0020\bX\004¢\006\002\n\000R\016\020\013\032\0020\fX\016¢\006\002\n\000R\016\020\r\032\0020\004X\016¢\006\002\n\000R\016\020\016\032\0020\004X\016¢\006\002\n\000R\016\020\017\032\0020\004X\016¢\006\002\n\000¨\006\027"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/misc/PacketMonitor;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "Count", "", "Debug", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "Hubpacket", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "Maxpacket", "Overflow_count", "a", "", "b", "c", "ticks", "onEnable", "", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class PacketMonitor extends Module {
/*  22 */   private final BoolValue Debug = new BoolValue("Debug", true);
/*  23 */   private final IntegerValue Maxpacket = new IntegerValue("Maxpacket", 21, 1, 100);
/*  24 */   private final IntegerValue Hubpacket = new IntegerValue("Hubpacket", 50, 1, 100);
/*  25 */   private final IntegerValue Overflow_count = new IntegerValue("overflow_count", 5, 1, 20);
/*     */   private int Count;
/*     */   private int ticks;
/*     */   private boolean a;
/*     */   private int b;
/*     */   private int c;
/*     */   
/*     */   public void onEnable() {
/*  33 */     this.ticks = 0;
/*  34 */     this.a = false;
/*  35 */     this.Count = 0;
/*  36 */     this.b = 0;
/*  37 */     this.c = 0;
/*     */   }
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/*  41 */     Intrinsics.checkParameterIsNotNull(event, "event"); IPacket $this$unwrap$iv = event.getPacket(); int $i$f$unwrap = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 103 */     if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.PacketImpl<*>");  Packet e = ((PacketImpl)$this$unwrap$iv).getWrapped(); IPacket iPacket1 = event.getPacket(); int i = 0;
/* 104 */     if (iPacket1 == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.PacketImpl<*>");  Packet packet = ((PacketImpl)iPacket1).getWrapped();
/*     */     Intrinsics.checkExpressionValueIsNotNull(((SPacketChat)packet).func_148915_c(), "packet.chatComponent");
/*     */     Intrinsics.checkExpressionValueIsNotNull(((SPacketChat)packet).func_148915_c().func_150260_c(), "packet.chatComponent.unformattedText");
/*     */     if (packet instanceof SPacketChat && !StringsKt.contains$default(((SPacketChat)packet).func_148915_c().func_150260_c(), ":", false, 2, null)) {
/*     */       Intrinsics.checkExpressionValueIsNotNull(((SPacketChat)packet).func_148915_c(), "packet.chatComponent");
/*     */       String chat = ((SPacketChat)packet).func_148915_c().func_150260_c();
/*     */       Matcher matcher = Pattern.compile("游戏开始").matcher(chat);
/*     */       Matcher matcher2 = Pattern.compile("恭喜").matcher(chat);
/*     */       Matcher matcher3 = Pattern.compile("加入了游戏").matcher(chat);
/*     */       Matcher matcher5 = Pattern.compile("正在进行匹配").matcher(chat);
/*     */       Matcher matcher6 = Pattern.compile("已为你自动开启").matcher(chat);
/*     */       Matcher matcher7 = Pattern.compile("开始倒计时").matcher(chat);
/*     */       if (matcher.find() || matcher2.find() || matcher3.find() || matcher5.find() || matcher6.find() || matcher7.find()) {
/*     */         this.b = 0;
/*     */         if (((Boolean)this.Debug.get()).booleanValue())
/*     */           ClientUtils.displayChatMessage("§8[§c§lRetreat§8]§c§dPacket清除"); 
/*     */       } 
/*     */     } 
/*     */     if (e instanceof net.minecraft.network.play.client.CPacketUseEntity && this.b >= 20) {
/*     */       this.Count++;
/*     */       this.a = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/*     */     Intrinsics.checkParameterIsNotNull(event, "event");
/*     */     this.b++;
/*     */     if (this.a) {
/*     */       int i;
/*     */       this.ticks = (i = this.ticks) + 1;
/*     */     } 
/*     */     if (this.Count > ((Number)this.Maxpacket.get()).intValue()) {
/*     */       this.c++;
/*     */       if (((Boolean)this.Debug.get()).booleanValue())
/*     */         ClientUtils.displayChatMessage("§8[§c§lRetreat§8]§c§d发包过多:" + this.Count + "/s"); 
/*     */     } 
/*     */     if (this.Count >= ((Number)this.Hubpacket.get()).intValue()) {
/*     */       this.c = 0;
/*     */       if (MinecraftInstance.mc.getThePlayer() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       MinecraftInstance.mc.getThePlayer().sendChatMessage("/hub");
/*     */       if (((Boolean)this.Debug.get()).booleanValue())
/*     */         ClientUtils.displayChatMessage("§8[§c§lRetreat§8]§c§d发包超级多:" + this.Count + "/s"); 
/*     */     } 
/*     */     if (this.c >= ((Number)this.Overflow_count.get()).intValue()) {
/*     */       this.c = 0;
/*     */       if (MinecraftInstance.mc.getThePlayer() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       MinecraftInstance.mc.getThePlayer().sendChatMessage("/hub");
/*     */       if (((Boolean)this.Debug.get()).booleanValue())
/*     */         ClientUtils.displayChatMessage("§8[§c§lRetreat§8]§c§d发包过多次数过多"); 
/*     */     } 
/*     */     if (Retreat.INSTANCE.getModuleManager().get(CatVelocity.class) == null)
/*     */       throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.retreat.CatVelocity"); 
/*     */     CatVelocity noxzvelocity = (CatVelocity)Retreat.INSTANCE.getModuleManager().get(CatVelocity.class);
/*     */     if (noxzvelocity.getState()) {
/*     */       this.c = 0;
/*     */       this.b = 0;
/*     */       this.Count = 0;
/*     */     } 
/*     */     if (this.ticks == 20) {
/*     */       this.a = false;
/*     */       this.ticks = 0;
/*     */       this.Count = 0;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\misc\PacketMonitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */