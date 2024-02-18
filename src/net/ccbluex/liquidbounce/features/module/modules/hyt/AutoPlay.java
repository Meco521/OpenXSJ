/*     */ package net.ccbluex.liquidbounce.features.module.modules.hyt;
/*     */ import java.util.regex.Matcher;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.combat.GrimVelocity;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.player.InvManager;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.player.StealerPlus;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.retreat.HYTAutoArmor;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.retreat.SkidHYTVelocity;
/*     */ import net.ccbluex.liquidbounce.ui.client.hud.element.elements.Notification;
/*     */ import net.ccbluex.liquidbounce.ui.client.hud.element.elements.NotifyType;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.TextValue;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.SPacketChat;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "AutoPlay", category = ModuleCategory.HYT, description = "Auto GG")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000F\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\005\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\b\n\002\020\013\n\000\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\034\032\0020\035H\026J\020\020\036\032\0020\0372\006\020 \032\0020!H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\032\020\006\032\0020\007X\016¢\006\016\n\000\032\004\b\b\020\t\"\004\b\n\020\013R\016\020\f\032\0020\rX\004¢\006\002\n\000R\016\020\016\032\0020\004X\004¢\006\002\n\000R\024\020\017\032\0020\0208VX\004¢\006\006\032\004\b\021\020\022R\016\020\023\032\0020\024X\004¢\006\002\n\000R\016\020\025\032\0020\024X\004¢\006\002\n\000R\032\020\026\032\0020\007X\016¢\006\016\n\000\032\004\b\027\020\t\"\004\b\030\020\013R\032\020\031\032\0020\007X\016¢\006\016\n\000\032\004\b\032\020\t\"\004\b\033\020\013¨\006\""}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/hyt/AutoPlay;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "Text", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "autodis", "ban", "", "getBan", "()I", "setBan", "(I)V", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "prefix", "tag", "", "getTag", "()Ljava/lang/String;", "textValu", "Lnet/ccbluex/liquidbounce/value/TextValue;", "textValue", "totalPlayed", "getTotalPlayed", "setTotalPlayed", "win", "getWin", "setWin", "handleEvents", "", "onPacket", "", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "XSJClient"})
/*     */ public final class AutoPlay extends Module {
/*  27 */   private final ListValue modeValue = new ListValue("Server", new String[] { "HuaYuTingBW", "HuaYuTingSw", "HuaYuTing16" }, "HuaYuTingBW");
/*  28 */   private final BoolValue autodis = new BoolValue("Auto-Disable", true);
/*  29 */   private final BoolValue Text = new BoolValue("TextBoolValue", true);
/*  30 */   private final BoolValue prefix = new BoolValue("@", true);
/*  31 */   private final TextValue textValue = new TextValue("Text", "[XSJClient]GG");
/*  32 */   private final TextValue textValu = new TextValue("Text2", "@我正在使用XSJClient");
/*  33 */   private int totalPlayed; private int win; private int ban; public final int getTotalPlayed() { return this.totalPlayed; } public final void setTotalPlayed(int <set-?>) { this.totalPlayed = <set-?>; }
/*  34 */   public final int getWin() { return this.win; } public final void setWin(int <set-?>) { this.win = <set-?>; }
/*  35 */   public final int getBan() { return this.ban; } public final void setBan(int <set-?>) { this.ban = <set-?>; }
/*     */    @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/*  38 */     Intrinsics.checkParameterIsNotNull(event, "event"); IPacket $this$unwrap$iv = event.getPacket(); int $i$f$unwrap = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 132 */     if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.PacketImpl<*>");  Packet packet = ((PacketImpl)$this$unwrap$iv).getWrapped();
/*     */     if (Retreat.INSTANCE.getModuleManager().getModule(GrimVelocity.class) == null)
/*     */       throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.GrimVelocity"); 
/*     */     GrimVelocity GrimVelocity = (GrimVelocity)Retreat.INSTANCE.getModuleManager().getModule(GrimVelocity.class);
/*     */     if (Retreat.INSTANCE.getModuleManager().getModule(KillAura.class) == null)
/*     */       throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura"); 
/*     */     KillAura KillAura = (KillAura)Retreat.INSTANCE.getModuleManager().getModule(KillAura.class);
/*     */     if (Retreat.INSTANCE.getModuleManager().getModule(SkidHYTVelocity.class) == null)
/*     */       throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.retreat.SkidHYTVelocity"); 
/*     */     SkidHYTVelocity SkidHYTVelocity = (SkidHYTVelocity)Retreat.INSTANCE.getModuleManager().getModule(SkidHYTVelocity.class);
/*     */     if (Retreat.INSTANCE.getModuleManager().getModule(StealerPlus.class) == null)
/*     */       throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.player.StealerPlus"); 
/*     */     StealerPlus StealerPlus = (StealerPlus)Retreat.INSTANCE.getModuleManager().getModule(StealerPlus.class);
/*     */     if (Retreat.INSTANCE.getModuleManager().getModule(InvManager.class) == null)
/*     */       throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.player.InvManager"); 
/*     */     InvManager InvManager = (InvManager)Retreat.INSTANCE.getModuleManager().getModule(InvManager.class);
/*     */     if (Retreat.INSTANCE.getModuleManager().getModule(HYTAutoArmor.class) == null)
/*     */       throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.retreat.HYTAutoArmor"); 
/*     */     HYTAutoArmor HYTAutoArmor = (HYTAutoArmor)Retreat.INSTANCE.getModuleManager().getModule(HYTAutoArmor.class);
/*     */     if (packet instanceof SPacketChat) {
/*     */       Intrinsics.checkExpressionValueIsNotNull(((SPacketChat)packet).func_148915_c(), "packet.chatComponent");
/*     */       String ftchat = ((SPacketChat)packet).func_148915_c().func_150254_d();
/*     */       Intrinsics.checkExpressionValueIsNotNull(ftchat, "ftchat");
/*     */       if (StringsKt.contains$default(ftchat, "起床战争>> 游戏开始 ...", false, 2, null))
/*     */         this.modeValue.set("HuaYuTingBW"); 
/*     */       if (StringsKt.contains$default(ftchat, "开始倒计时", false, 2, null))
/*     */         this.modeValue.set("HuaYuTingSw"); 
/*     */       if (StringsKt.contains$default(ftchat, "§f[起床战争]", false, 2, null))
/*     */         this.modeValue.set("HuaYuTing16"); 
/*     */     } 
/*     */     if (packet instanceof SPacketChat) {
/*     */       Intrinsics.checkExpressionValueIsNotNull(((SPacketChat)packet).func_148915_c(), "packet.chatComponent");
/*     */       String text = ((SPacketChat)packet).func_148915_c().func_150260_c();
/*     */       if (packet instanceof SPacketChat) {
/*     */         Intrinsics.checkExpressionValueIsNotNull(((SPacketChat)packet).func_148915_c(), "packet.chatComponent");
/*     */         Matcher matcher = Pattern.compile("玩家(.*?)在本局游戏中行为异常").matcher(((SPacketChat)packet).func_148915_c().func_150260_c());
/*     */         if (matcher.find()) {
/*     */           int j;
/*     */           this.ban = (j = this.ban) + 1;
/*     */           String banname = matcher.group(1);
/*     */           Retreat.INSTANCE.getHud().addNotification(new Notification("BanChecker", banname + " was banned. (banned:" + this.ban + ')', NotifyType.INFO, 0, 1000, 8, null));
/*     */         } 
/*     */       } 
/*     */       String str1 = (String)this.modeValue.get();
/*     */       int i = 0;
/*     */       if (str1 == null)
/*     */         throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */       Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()");
/*     */       str1 = str1.toLowerCase();
/*     */       switch (str1.hashCode()) {
/*     */         case 1660684514:
/*     */           if (str1.equals("huayutingsw")) {
/*     */             Intrinsics.checkExpressionValueIsNotNull(text, "text");
/*     */             if (StringsKt.contains(text, "开始倒计时", true)) {
/*     */               this.totalPlayed = (i = this.totalPlayed) + 1;
/*     */               Retreat.INSTANCE.getModuleManager().get(StealerPlus.class).setState(true);
/*     */               Retreat.INSTANCE.getModuleManager().get(InvManager.class).setState(true);
/*     */               Retreat.INSTANCE.getHud().addNotification(new Notification("AutoPlay", "游戏开始！！", NotifyType.INFO, 0, 0, 24, null));
/*     */             } 
/*     */             Intrinsics.checkExpressionValueIsNotNull(((SPacketChat)packet).func_148915_c(), "packet.chatComponent");
/*     */             Matcher matcher = Pattern.compile("你在地图 (.*?)\\(").matcher(((SPacketChat)packet).func_148915_c().func_150260_c());
/*     */             if (StringsKt.contains(text, "你现在是观察者状态. 按E打开菜单.", true)) {
/*     */               Retreat.INSTANCE.getHud().addNotification(new Notification("AutoPlay", "Game Over", NotifyType.INFO, 0, 0, 24, null));
/*     */               if (((Boolean)this.Text.get()).booleanValue()) {
/*     */                 if (MinecraftInstance.mc.getThePlayer() == null)
/*     */                   Intrinsics.throwNpe(); 
/*     */                 MinecraftInstance.mc.getThePlayer().sendChatMessage((((Boolean)this.prefix.get()).booleanValue() ? "@" : "") + (String)this.textValue.get());
/*     */               } 
/*     */               if (((Boolean)this.autodis.get()).booleanValue()) {
/*     */                 KillAura.setState(false);
/*     */                 SkidHYTVelocity.setState(false);
/*     */                 GrimVelocity.setState(false);
/*     */                 StealerPlus.setState(false);
/*     */                 InvManager.setState(false);
/*     */                 HYTAutoArmor.setState(false);
/*     */               } 
/*     */               this.win++;
/*     */             } 
/*     */           } 
/*     */           break;
/*     */         case 1660683987:
/*     */           if (str1.equals("huayutingbw")) {
/*     */             Intrinsics.checkExpressionValueIsNotNull(text, "text");
/*     */             if (StringsKt.contains(text, "      喜欢      一般      不喜欢", true)) {
/*     */               if (((Boolean)this.Text.get()).booleanValue()) {
/*     */                 if (MinecraftInstance.mc.getThePlayer() == null)
/*     */                   Intrinsics.throwNpe(); 
/*     */                 MinecraftInstance.mc.getThePlayer().sendChatMessage((((Boolean)this.prefix.get()).booleanValue() ? "@" : "") + (String)this.textValue.get());
/*     */               } 
/*     */               this.win++;
/*     */               Retreat.INSTANCE.getHud().addNotification(new Notification("AutoPlay", "恭喜胜利！", NotifyType.INFO, 0, 0, 24, null));
/*     */               if (((Boolean)this.autodis.get()).booleanValue()) {
/*     */                 KillAura.setState(false);
/*     */                 SkidHYTVelocity.setState(false);
/*     */                 GrimVelocity.setState(false);
/*     */               } 
/*     */             } 
/*     */             if (StringsKt.contains(text, "起床战争>> 游戏开始 ...", true)) {
/*     */               this.totalPlayed = (i = this.totalPlayed) + 1;
/*     */               Retreat.INSTANCE.getHud().addNotification(new Notification("AutoPlay", "游戏开始！！", NotifyType.INFO, 0, 0, 24, null));
/*     */               if (((Boolean)this.Text.get()).booleanValue()) {
/*     */                 if (MinecraftInstance.mc.getThePlayer() == null)
/*     */                   Intrinsics.throwNpe(); 
/*     */                 MinecraftInstance.mc.getThePlayer().sendChatMessage((String)this.textValu.get());
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           break;
/*     */         case 1660682403:
/*     */           Intrinsics.checkExpressionValueIsNotNull(text, "text");
/*     */           if (str1.equals("huayuting16") && StringsKt.contains(text, "[起床战争] Game 结束！感谢您的参与！", true)) {
/*     */             Retreat.INSTANCE.getHud().addNotification(new Notification("AutoPlay", "Game Over", NotifyType.INFO, 0, 0, 24, null));
/*     */             if (((Boolean)this.Text.get()).booleanValue()) {
/*     */               if (MinecraftInstance.mc.getThePlayer() == null)
/*     */                 Intrinsics.throwNpe(); 
/*     */               MinecraftInstance.mc.getThePlayer().sendChatMessage((((Boolean)this.prefix.get()).booleanValue() ? "@" : "") + (String)this.textValue.get());
/*     */             } 
/*     */             this.win++;
/*     */             if (((Boolean)this.autodis.get()).booleanValue()) {
/*     */               KillAura.setState(false);
/*     */               GrimVelocity.setState(false);
/*     */               SkidHYTVelocity.setState(false);
/*     */             } 
/*     */           } 
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean handleEvents() {
/*     */     return true;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getTag() {
/*     */     return (String)this.modeValue.get();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\hyt\AutoPlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */