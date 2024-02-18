/*     */ package net.ccbluex.liquidbounce.features.module.modules.misc;
/*     */ 
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.injection.backend.PacketImpl;
/*     */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.misc.RandomUtils;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.SPacketChat;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @ModuleInfo(name = "AntiFakePlayer", description = "❤", category = ModuleCategory.HYT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000Z\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\b\n\002\b\f\n\002\020\021\n\002\020\016\n\002\b\007\n\002\030\002\n\002\b\024\n\002\020\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\t\n\002\b\005\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\0205\032\00206H\002J\b\0207\032\00206H\027J\020\0208\032\002062\006\0209\032\0020:H\007J\020\020;\032\002062\006\0209\032\0020<H\007J\030\020=\032\002062\006\020>\032\0020\0312\006\020?\032\0020@H\002J\020\020A\032\002062\006\0209\032\0020:H\002J\030\020B\032\002062\006\020>\032\0020\0312\006\020C\032\0020\031H\002J\b\020D\032\0020\031H\002R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\004X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\n\032\0020\013X\016¢\006\002\n\000R\016\020\f\032\0020\004X\004¢\006\002\n\000R\016\020\r\032\0020\004X\004¢\006\002\n\000R\016\020\016\032\0020\004X\004¢\006\002\n\000R\016\020\017\032\0020\004X\004¢\006\002\n\000R\016\020\020\032\0020\004X\004¢\006\002\n\000R\016\020\021\032\0020\006X\004¢\006\002\n\000R\016\020\022\032\0020\004X\004¢\006\002\n\000R\016\020\023\032\0020\004X\004¢\006\002\n\000R\016\020\024\032\0020\004X\004¢\006\002\n\000R\016\020\025\032\0020\004X\004¢\006\002\n\000R\016\020\026\032\0020\004X\004¢\006\002\n\000R\026\020\027\032\b\022\004\022\0020\0310\030X\004¢\006\004\n\002\020\032R\026\020\033\032\b\022\004\022\0020\0310\030X\004¢\006\004\n\002\020\032R\016\020\034\032\0020\013X\016¢\006\002\n\000R\016\020\035\032\0020\tX\004¢\006\002\n\000R\026\020\036\032\b\022\004\022\0020\0310\030X\004¢\006\004\n\002\020\032R\016\020\037\032\0020\tX\004¢\006\002\n\000R\016\020 \032\0020!X\004¢\006\002\n\000R\026\020\"\032\b\022\004\022\0020\0310\030X\004¢\006\004\n\002\020\032R\016\020#\032\0020\004X\004¢\006\002\n\000R\016\020$\032\0020\031X\016¢\006\002\n\000R\016\020%\032\0020\004X\004¢\006\002\n\000R\016\020&\032\0020\004X\004¢\006\002\n\000R\016\020'\032\0020\004X\004¢\006\002\n\000R\016\020(\032\0020\004X\004¢\006\002\n\000R\016\020)\032\0020\004X\004¢\006\002\n\000R\016\020*\032\0020\tX\004¢\006\002\n\000R\016\020+\032\0020\004X\004¢\006\002\n\000R\016\020,\032\0020\tX\004¢\006\002\n\000R\016\020-\032\0020\004X\004¢\006\002\n\000R\016\020.\032\0020\004X\004¢\006\002\n\000R\016\020/\032\0020\004X\004¢\006\002\n\000R\016\0200\032\0020\004X\004¢\006\002\n\000R\016\0201\032\0020\004X\004¢\006\002\n\000R\026\0202\032\004\030\0010\0318VX\004¢\006\006\032\004\b3\0204¨\006E"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/misc/AntiFakePlayer;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "autoModeValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "autoSwitchDelay", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "autoSwitchLogger", "autoSwitchModeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "bots", "", "chatHiddenValue", "fakeNameProtectValue", "hideAntiGetNameValue", "hideKillChatValue", "hideMultiKillChatValue", "kitCustomDelayValue", "kitHideDeathStreakValue", "kitHideKillCoinValue", "kitHidePlayerUpgradeChatValue", "kitHideSkillChatValue", "kitHideSpecialDeathValue", "kitSpecialDeathChats", "", "", "[Ljava/lang/String;", "kitSpecialSkillChats", "logNumber", "logStyleValue", "logStyles", "modeValue", "ms", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "multiKillMessageList", "printLoggerValue", "protectedname", "sTHideAll", "sTHideAllAutoSwitcher", "sTHideAutoSwitcherDelay", "sTHideAutoSwitcherMode", "sTHideAutoSwitcherState", "sTHideAutoSwitcherStateSetting", "sTHideBotsCounter", "sTHideBotsCounterSetting", "sTHideLogStyle", "sTHideMode", "sTShowOptions", "showMyKillDeathChatValue", "showMyMultiKillChatValue", "tag", "getTag", "()Ljava/lang/String;", "clearAll", "", "onDisable", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "playerDeathAction", "name", "cd", "", "playerDeathMsgAction", "printLogger", "mode", "tagReturner", "XSJClient"})
/*     */ public final class AntiFakePlayer extends Module {
/*  31 */   private final String[] logStyles = new String[] { 
/*  32 */       "ArcticNew", 
/*  33 */       "FDPAntibot", 
/*  34 */       "FDPChat", 
/*  35 */       "Leave", 
/*  36 */       "Special", 
/*  37 */       "WaWa1", 
/*  38 */       "WaWa2", 
/*  39 */       "Retreat", 
/*  40 */       "Normal", 
/*  41 */       "WindX", 
/*  42 */       "Old", 
/*  43 */       "Verne" };
/*     */   
/*  45 */   private final String[] multiKillMessageList = new String[] {
/*  46 */       "正在大杀特杀！", 
/*  47 */       "主宰服务器！", 
/*  48 */       "杀人如麻！", 
/*  49 */       "无人能挡！", 
/*  50 */       "杀得变态了！", 
/*  51 */       "正在像妖怪般杀戮！", 
/*  52 */       "如同神一般！", 
/*  53 */       "已经超越神了！拜托谁去杀了他吧！"
/*     */     };
/*  55 */   private final String[] kitSpecialDeathChats = new String[] {
/*  56 */       "走着走着突然暴毙了!", 
/*  57 */       "Boom！！!"
/*     */     };
/*  59 */   private final String[] kitSpecialSkillChats = new String[] {
/*  60 */       "对你眨眼了!", 
/*  61 */       "诅咒了!", 
/*  62 */       "并没有使用作弊!"
/*     */     };
/*     */ 
/*     */   
/*  66 */   private final BoolValue autoModeValue = new BoolValue("AutoSwitch", false);
/*     */ 
/*     */ 
/*     */   
/*  70 */   private final ListValue modeValue = new ListValue(
/*  71 */       "Mode", 
/*  72 */       new String[] { "4v4/2v2/1v1", "BWXP32", "BWXP16", "KitBattle"
/*  73 */       }, "4V4/2v2/1V1");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  78 */   private final BoolValue printLoggerValue = new BoolValue("ShowChatMessage", false);
/*  79 */   private final ListValue logStyleValue = new ListValue("LogStyle", this.logStyles, "Normal");
/*     */ 
/*     */   
/*  82 */   private final BoolValue hideKillChatValue = new BoolValue("HideKillChat", false);
/*     */   
/*  84 */   private final BoolValue showMyKillDeathChatValue = new BoolValue("ShowMyKillDeathChat", false);
/*     */ 
/*     */ 
/*     */   
/*  88 */   private final IntegerValue kitCustomDelayValue = new IntegerValue("KitCustomDelay", 4700, 4000, 8000);
/*     */ 
/*     */ 
/*     */   
/*  92 */   private final BoolValue kitHideKillCoinValue = new BoolValue("HideKitBattleCoinChat", true);
/*     */ 
/*     */ 
/*     */   
/*  96 */   private final BoolValue kitHideDeathStreakValue = new BoolValue("HideKitDeathStreakChat", false);
/*     */ 
/*     */ 
/*     */   
/* 100 */   private final BoolValue kitHideSpecialDeathValue = new BoolValue("HideKitSpecialDeathChat", false);
/*     */ 
/*     */ 
/*     */   
/* 104 */   private final BoolValue kitHideSkillChatValue = new BoolValue("HideKitSkillChat", false);
/*     */   
/* 106 */   private final BoolValue kitHidePlayerUpgradeChatValue = new BoolValue("HideKitUpgradeChat", false);
/*     */ 
/*     */   
/* 109 */   private final BoolValue hideMultiKillChatValue = new BoolValue("HideMultiKillChat", true);
/*     */   
/* 111 */   private final BoolValue showMyMultiKillChatValue = new BoolValue("ShowMyMultiKillChat", true);
/*     */ 
/*     */   
/* 114 */   private final BoolValue fakeNameProtectValue = new BoolValue("ShittyNameProtect(OnlyEnglish", false);
/*     */ 
/*     */   
/* 117 */   private final BoolValue hideAntiGetNameValue = new BoolValue("IgnoreAntiGetname", false);
/* 118 */   private final BoolValue chatHiddenValue = new BoolValue("IgnoredChat", false);
/*     */ 
/*     */   
/* 121 */   private final BoolValue autoSwitchLogger = new BoolValue("AutoSwitchLogger", false);
/* 122 */   private final ListValue autoSwitchModeValue = new ListValue(
/* 123 */       "AutoSwitchMode", new String[] {
/* 124 */         "Random", 
/* 125 */         "List"
/* 126 */       }, "Random");
/*     */ 
/*     */   
/* 129 */   private final IntegerValue autoSwitchDelay = new IntegerValue("AutoSwitchDelay", 3000, 1500, 7000);
/*     */ 
/*     */   
/* 132 */   private final BoolValue sTShowOptions = new BoolValue("ShowShortTagOptions", false);
/*     */ 
/*     */   
/* 135 */   private final BoolValue sTHideAll = new BoolValue("HideAllTag", false);
/*     */ 
/*     */   
/* 138 */   private final BoolValue sTHideMode = new BoolValue("HideMode", false);
/*     */ 
/*     */ 
/*     */   
/* 142 */   private final BoolValue sTHideLogStyle = new BoolValue("HideLogStyle", false);
/*     */ 
/*     */ 
/*     */   
/* 146 */   private final BoolValue sTHideBotsCounter = new BoolValue("HideBotsCounter", false);
/*     */ 
/*     */   
/* 149 */   private final ListValue sTHideBotsCounterSetting = new ListValue(
/* 150 */       "HideBotsCounterMode", 
/* 151 */       new String[] { "FullHide", "OnlyNumber"
/* 152 */       }, "OnlyNumber");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 157 */   private final BoolValue sTHideAllAutoSwitcher = new BoolValue("HideAllAutoSwitcher", false);
/*     */ 
/*     */   
/* 160 */   private final BoolValue sTHideAutoSwitcherState = new BoolValue(
/* 161 */       "HideAutoSwitcherState", 
/* 162 */       false);
/*     */ 
/*     */ 
/*     */   
/* 166 */   private final ListValue sTHideAutoSwitcherStateSetting = new ListValue(
/* 167 */       "HideAutoSwitcherMode", 
/* 168 */       new String[] { "FullHide", "OnlyShowState"
/* 169 */       }, "FullHide");
/*     */ 
/*     */ 
/*     */   
/* 173 */   private final BoolValue sTHideAutoSwitcherMode = new BoolValue(
/* 174 */       "HideAutoSwitcherMode", 
/* 175 */       false);
/*     */ 
/*     */ 
/*     */   
/* 179 */   private final BoolValue sTHideAutoSwitcherDelay = new BoolValue(
/* 180 */       "HideAutoSwitcherDelay", 
/* 181 */       false);
/*     */   
/*     */   private int bots;
/*     */   
/*     */   private int logNumber;
/*     */   
/* 187 */   private final MSTimer ms = new MSTimer();
/* 188 */   private String protectedname = "";
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public void onDisable() {
/* 193 */     this.bots = 0;
/* 194 */     clearAll();
/* 195 */     super.onDisable();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: aload_1
/*     */     //   7: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   10: astore_3
/*     */     //   11: iconst_0
/*     */     //   12: istore #4
/*     */     //   14: aload_3
/*     */     //   15: dup
/*     */     //   16: ifnonnull -> 29
/*     */     //   19: new kotlin/TypeCastException
/*     */     //   22: dup
/*     */     //   23: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.PacketImpl<*>'
/*     */     //   25: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   28: athrow
/*     */     //   29: checkcast net/ccbluex/liquidbounce/injection/backend/PacketImpl
/*     */     //   32: invokevirtual getWrapped : ()Lnet/minecraft/network/Packet;
/*     */     //   35: astore_2
/*     */     //   36: aload_2
/*     */     //   37: instanceof net/minecraft/network/play/server/SPacketChat
/*     */     //   40: ifeq -> 1308
/*     */     //   43: aload_2
/*     */     //   44: checkcast net/minecraft/network/play/server/SPacketChat
/*     */     //   47: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   50: dup
/*     */     //   51: ldc 'packet.chatComponent'
/*     */     //   53: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   56: invokeinterface func_150260_c : ()Ljava/lang/String;
/*     */     //   61: dup
/*     */     //   62: ldc 'packet.chatComponent.unformattedText'
/*     */     //   64: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   67: checkcast java/lang/CharSequence
/*     */     //   70: ldc ':'
/*     */     //   72: checkcast java/lang/CharSequence
/*     */     //   75: iconst_0
/*     */     //   76: iconst_2
/*     */     //   77: aconst_null
/*     */     //   78: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   81: ifne -> 1308
/*     */     //   84: aload_2
/*     */     //   85: checkcast net/minecraft/network/play/server/SPacketChat
/*     */     //   88: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   91: dup
/*     */     //   92: ldc 'packet.chatComponent'
/*     */     //   94: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   97: invokeinterface func_150260_c : ()Ljava/lang/String;
/*     */     //   102: dup
/*     */     //   103: ldc 'packet.chatComponent.unformattedText'
/*     */     //   105: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   108: ldc '起床战争'
/*     */     //   110: iconst_0
/*     */     //   111: iconst_2
/*     */     //   112: aconst_null
/*     */     //   113: invokestatic startsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*     */     //   116: ifne -> 189
/*     */     //   119: aload_2
/*     */     //   120: checkcast net/minecraft/network/play/server/SPacketChat
/*     */     //   123: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   126: dup
/*     */     //   127: ldc 'packet.chatComponent'
/*     */     //   129: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   132: invokeinterface func_150260_c : ()Ljava/lang/String;
/*     */     //   137: dup
/*     */     //   138: ldc 'packet.chatComponent.unformattedText'
/*     */     //   140: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   143: ldc '[起床战争'
/*     */     //   145: iconst_0
/*     */     //   146: iconst_2
/*     */     //   147: aconst_null
/*     */     //   148: invokestatic startsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*     */     //   151: ifne -> 189
/*     */     //   154: aload_2
/*     */     //   155: checkcast net/minecraft/network/play/server/SPacketChat
/*     */     //   158: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   161: dup
/*     */     //   162: ldc 'packet.chatComponent'
/*     */     //   164: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   167: invokeinterface func_150260_c : ()Ljava/lang/String;
/*     */     //   172: dup
/*     */     //   173: ldc 'packet.chatComponent.unformattedText'
/*     */     //   175: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   178: ldc '花雨庭'
/*     */     //   180: iconst_0
/*     */     //   181: iconst_2
/*     */     //   182: aconst_null
/*     */     //   183: invokestatic startsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*     */     //   186: ifeq -> 1308
/*     */     //   189: aload_2
/*     */     //   190: checkcast net/minecraft/network/play/server/SPacketChat
/*     */     //   193: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   196: dup
/*     */     //   197: ldc 'packet.chatComponent'
/*     */     //   199: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   202: invokeinterface func_150260_c : ()Ljava/lang/String;
/*     */     //   207: astore_3
/*     */     //   208: aload_0
/*     */     //   209: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   212: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   215: checkcast java/lang/String
/*     */     //   218: astore #4
/*     */     //   220: iconst_0
/*     */     //   221: istore #5
/*     */     //   223: aload #4
/*     */     //   225: dup
/*     */     //   226: ifnonnull -> 239
/*     */     //   229: new kotlin/TypeCastException
/*     */     //   232: dup
/*     */     //   233: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   235: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   238: athrow
/*     */     //   239: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   242: dup
/*     */     //   243: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   245: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   248: astore #4
/*     */     //   250: aload #4
/*     */     //   252: invokevirtual hashCode : ()I
/*     */     //   255: lookupswitch default -> 1308, -1375727374 -> 296, -1375727316 -> 322, 699818926 -> 309, 957413134 -> 335
/*     */     //   296: aload #4
/*     */     //   298: ldc 'bwxp16'
/*     */     //   300: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   303: ifeq -> 1308
/*     */     //   306: goto -> 919
/*     */     //   309: aload #4
/*     */     //   311: ldc '4v4/2v2/1v1'
/*     */     //   313: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   316: ifeq -> 1308
/*     */     //   319: goto -> 348
/*     */     //   322: aload #4
/*     */     //   324: ldc 'bwxp32'
/*     */     //   326: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   329: ifeq -> 1308
/*     */     //   332: goto -> 673
/*     */     //   335: aload #4
/*     */     //   337: ldc 'kitbattle'
/*     */     //   339: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   342: ifeq -> 1308
/*     */     //   345: goto -> 1084
/*     */     //   348: ldc '杀死了 (.*?)\('
/*     */     //   350: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
/*     */     //   353: aload_3
/*     */     //   354: checkcast java/lang/CharSequence
/*     */     //   357: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   360: astore #5
/*     */     //   362: ldc '起床战争>> (.*?) (\(((.*?)死了!))'
/*     */     //   364: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
/*     */     //   367: aload_3
/*     */     //   368: checkcast java/lang/CharSequence
/*     */     //   371: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   374: astore #6
/*     */     //   376: ldc '杀死了 (.*?)\['
/*     */     //   378: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
/*     */     //   381: aload_3
/*     */     //   382: checkcast java/lang/CharSequence
/*     */     //   385: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   388: astore #7
/*     */     //   390: ldc '起床战争>> (.*?) \['
/*     */     //   392: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
/*     */     //   395: aload_3
/*     */     //   396: checkcast java/lang/CharSequence
/*     */     //   399: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   402: astore #8
/*     */     //   404: aload #5
/*     */     //   406: invokevirtual find : ()Z
/*     */     //   409: ifeq -> 470
/*     */     //   412: aload #5
/*     */     //   414: iconst_1
/*     */     //   415: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   418: dup
/*     */     //   419: ldc 'matcher.group(1)'
/*     */     //   421: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   424: astore #10
/*     */     //   426: iconst_0
/*     */     //   427: istore #11
/*     */     //   429: aload #10
/*     */     //   431: dup
/*     */     //   432: ifnonnull -> 445
/*     */     //   435: new kotlin/TypeCastException
/*     */     //   438: dup
/*     */     //   439: ldc 'null cannot be cast to non-null type kotlin.CharSequence'
/*     */     //   441: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   444: athrow
/*     */     //   445: checkcast java/lang/CharSequence
/*     */     //   448: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
/*     */     //   451: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   454: astore #9
/*     */     //   456: aload_0
/*     */     //   457: aload #9
/*     */     //   459: ldc2_w 4988
/*     */     //   462: invokespecial playerDeathAction : (Ljava/lang/String;J)V
/*     */     //   465: aload_0
/*     */     //   466: aload_1
/*     */     //   467: invokespecial playerDeathMsgAction : (Lnet/ccbluex/liquidbounce/event/PacketEvent;)V
/*     */     //   470: aload #6
/*     */     //   472: invokevirtual find : ()Z
/*     */     //   475: ifeq -> 536
/*     */     //   478: aload #6
/*     */     //   480: iconst_1
/*     */     //   481: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   484: dup
/*     */     //   485: ldc 'matcher2.group(1)'
/*     */     //   487: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   490: astore #10
/*     */     //   492: iconst_0
/*     */     //   493: istore #11
/*     */     //   495: aload #10
/*     */     //   497: dup
/*     */     //   498: ifnonnull -> 511
/*     */     //   501: new kotlin/TypeCastException
/*     */     //   504: dup
/*     */     //   505: ldc 'null cannot be cast to non-null type kotlin.CharSequence'
/*     */     //   507: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   510: athrow
/*     */     //   511: checkcast java/lang/CharSequence
/*     */     //   514: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
/*     */     //   517: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   520: astore #9
/*     */     //   522: aload_0
/*     */     //   523: aload #9
/*     */     //   525: ldc2_w 4988
/*     */     //   528: invokespecial playerDeathAction : (Ljava/lang/String;J)V
/*     */     //   531: aload_0
/*     */     //   532: aload_1
/*     */     //   533: invokespecial playerDeathMsgAction : (Lnet/ccbluex/liquidbounce/event/PacketEvent;)V
/*     */     //   536: aload #7
/*     */     //   538: invokevirtual find : ()Z
/*     */     //   541: ifeq -> 603
/*     */     //   544: aload #7
/*     */     //   546: iconst_1
/*     */     //   547: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   550: dup
/*     */     //   551: ldc_w 'matcher3.group(1)'
/*     */     //   554: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   557: astore #10
/*     */     //   559: iconst_0
/*     */     //   560: istore #11
/*     */     //   562: aload #10
/*     */     //   564: dup
/*     */     //   565: ifnonnull -> 578
/*     */     //   568: new kotlin/TypeCastException
/*     */     //   571: dup
/*     */     //   572: ldc 'null cannot be cast to non-null type kotlin.CharSequence'
/*     */     //   574: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   577: athrow
/*     */     //   578: checkcast java/lang/CharSequence
/*     */     //   581: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
/*     */     //   584: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   587: astore #9
/*     */     //   589: aload_0
/*     */     //   590: aload #9
/*     */     //   592: ldc2_w 4988
/*     */     //   595: invokespecial playerDeathAction : (Ljava/lang/String;J)V
/*     */     //   598: aload_0
/*     */     //   599: aload_1
/*     */     //   600: invokespecial playerDeathMsgAction : (Lnet/ccbluex/liquidbounce/event/PacketEvent;)V
/*     */     //   603: aload #8
/*     */     //   605: invokevirtual find : ()Z
/*     */     //   608: ifeq -> 1308
/*     */     //   611: aload #8
/*     */     //   613: iconst_1
/*     */     //   614: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   617: dup
/*     */     //   618: ldc_w 'matcher4.group(1)'
/*     */     //   621: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   624: astore #10
/*     */     //   626: iconst_0
/*     */     //   627: istore #11
/*     */     //   629: aload #10
/*     */     //   631: dup
/*     */     //   632: ifnonnull -> 645
/*     */     //   635: new kotlin/TypeCastException
/*     */     //   638: dup
/*     */     //   639: ldc 'null cannot be cast to non-null type kotlin.CharSequence'
/*     */     //   641: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   644: athrow
/*     */     //   645: checkcast java/lang/CharSequence
/*     */     //   648: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
/*     */     //   651: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   654: astore #9
/*     */     //   656: aload_0
/*     */     //   657: aload #9
/*     */     //   659: ldc2_w 4988
/*     */     //   662: invokespecial playerDeathAction : (Ljava/lang/String;J)V
/*     */     //   665: aload_0
/*     */     //   666: aload_1
/*     */     //   667: invokespecial playerDeathMsgAction : (Lnet/ccbluex/liquidbounce/event/PacketEvent;)V
/*     */     //   670: goto -> 1308
/*     */     //   673: ldc '杀死了 (.*?)\('
/*     */     //   675: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
/*     */     //   678: aload_3
/*     */     //   679: checkcast java/lang/CharSequence
/*     */     //   682: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   685: astore #5
/*     */     //   687: ldc_w '起床战争 >> (.*?) (\(((.*?)死了!))'
/*     */     //   690: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
/*     */     //   693: aload_3
/*     */     //   694: checkcast java/lang/CharSequence
/*     */     //   697: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   700: astore #6
/*     */     //   702: ldc_w '起床战争 >> (.*?)(\(((.*?)死了!))'
/*     */     //   705: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
/*     */     //   708: aload_3
/*     */     //   709: checkcast java/lang/CharSequence
/*     */     //   712: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   715: astore #7
/*     */     //   717: aload #5
/*     */     //   719: invokevirtual find : ()Z
/*     */     //   722: ifeq -> 783
/*     */     //   725: aload #5
/*     */     //   727: iconst_1
/*     */     //   728: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   731: dup
/*     */     //   732: ldc 'matcher.group(1)'
/*     */     //   734: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   737: astore #9
/*     */     //   739: iconst_0
/*     */     //   740: istore #10
/*     */     //   742: aload #9
/*     */     //   744: dup
/*     */     //   745: ifnonnull -> 758
/*     */     //   748: new kotlin/TypeCastException
/*     */     //   751: dup
/*     */     //   752: ldc 'null cannot be cast to non-null type kotlin.CharSequence'
/*     */     //   754: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   757: athrow
/*     */     //   758: checkcast java/lang/CharSequence
/*     */     //   761: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
/*     */     //   764: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   767: astore #8
/*     */     //   769: aload_0
/*     */     //   770: aload #8
/*     */     //   772: ldc2_w 7400
/*     */     //   775: invokespecial playerDeathAction : (Ljava/lang/String;J)V
/*     */     //   778: aload_0
/*     */     //   779: aload_1
/*     */     //   780: invokespecial playerDeathMsgAction : (Lnet/ccbluex/liquidbounce/event/PacketEvent;)V
/*     */     //   783: aload #6
/*     */     //   785: invokevirtual find : ()Z
/*     */     //   788: ifeq -> 849
/*     */     //   791: aload #6
/*     */     //   793: iconst_1
/*     */     //   794: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   797: dup
/*     */     //   798: ldc 'matcher2.group(1)'
/*     */     //   800: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   803: astore #9
/*     */     //   805: iconst_0
/*     */     //   806: istore #10
/*     */     //   808: aload #9
/*     */     //   810: dup
/*     */     //   811: ifnonnull -> 824
/*     */     //   814: new kotlin/TypeCastException
/*     */     //   817: dup
/*     */     //   818: ldc 'null cannot be cast to non-null type kotlin.CharSequence'
/*     */     //   820: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   823: athrow
/*     */     //   824: checkcast java/lang/CharSequence
/*     */     //   827: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
/*     */     //   830: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   833: astore #8
/*     */     //   835: aload_0
/*     */     //   836: aload #8
/*     */     //   838: ldc2_w 4988
/*     */     //   841: invokespecial playerDeathAction : (Ljava/lang/String;J)V
/*     */     //   844: aload_0
/*     */     //   845: aload_1
/*     */     //   846: invokespecial playerDeathMsgAction : (Lnet/ccbluex/liquidbounce/event/PacketEvent;)V
/*     */     //   849: aload #7
/*     */     //   851: invokevirtual find : ()Z
/*     */     //   854: ifeq -> 1308
/*     */     //   857: aload #7
/*     */     //   859: iconst_1
/*     */     //   860: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   863: dup
/*     */     //   864: ldc_w 'matcher3.group(1)'
/*     */     //   867: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   870: astore #9
/*     */     //   872: iconst_0
/*     */     //   873: istore #10
/*     */     //   875: aload #9
/*     */     //   877: dup
/*     */     //   878: ifnonnull -> 891
/*     */     //   881: new kotlin/TypeCastException
/*     */     //   884: dup
/*     */     //   885: ldc 'null cannot be cast to non-null type kotlin.CharSequence'
/*     */     //   887: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   890: athrow
/*     */     //   891: checkcast java/lang/CharSequence
/*     */     //   894: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
/*     */     //   897: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   900: astore #8
/*     */     //   902: aload_0
/*     */     //   903: aload #8
/*     */     //   905: ldc2_w 4988
/*     */     //   908: invokespecial playerDeathAction : (Ljava/lang/String;J)V
/*     */     //   911: aload_0
/*     */     //   912: aload_1
/*     */     //   913: invokespecial playerDeathMsgAction : (Lnet/ccbluex/liquidbounce/event/PacketEvent;)V
/*     */     //   916: goto -> 1308
/*     */     //   919: ldc_w '击败了 (.*?)!'
/*     */     //   922: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
/*     */     //   925: aload_3
/*     */     //   926: checkcast java/lang/CharSequence
/*     */     //   929: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   932: astore #5
/*     */     //   934: ldc_w '玩家 (.*?)死了！'
/*     */     //   937: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
/*     */     //   940: aload_3
/*     */     //   941: checkcast java/lang/CharSequence
/*     */     //   944: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   947: astore #6
/*     */     //   949: aload #5
/*     */     //   951: invokevirtual find : ()Z
/*     */     //   954: ifeq -> 1015
/*     */     //   957: aload #5
/*     */     //   959: iconst_1
/*     */     //   960: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   963: dup
/*     */     //   964: ldc 'matcher.group(1)'
/*     */     //   966: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   969: astore #8
/*     */     //   971: iconst_0
/*     */     //   972: istore #9
/*     */     //   974: aload #8
/*     */     //   976: dup
/*     */     //   977: ifnonnull -> 990
/*     */     //   980: new kotlin/TypeCastException
/*     */     //   983: dup
/*     */     //   984: ldc 'null cannot be cast to non-null type kotlin.CharSequence'
/*     */     //   986: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   989: athrow
/*     */     //   990: checkcast java/lang/CharSequence
/*     */     //   993: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
/*     */     //   996: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   999: astore #7
/*     */     //   1001: aload_0
/*     */     //   1002: aload #7
/*     */     //   1004: ldc2_w 9700
/*     */     //   1007: invokespecial playerDeathAction : (Ljava/lang/String;J)V
/*     */     //   1010: aload_0
/*     */     //   1011: aload_1
/*     */     //   1012: invokespecial playerDeathMsgAction : (Lnet/ccbluex/liquidbounce/event/PacketEvent;)V
/*     */     //   1015: aload #6
/*     */     //   1017: invokevirtual find : ()Z
/*     */     //   1020: ifeq -> 1308
/*     */     //   1023: aload #6
/*     */     //   1025: iconst_1
/*     */     //   1026: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   1029: dup
/*     */     //   1030: ldc 'matcher2.group(1)'
/*     */     //   1032: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1035: astore #8
/*     */     //   1037: iconst_0
/*     */     //   1038: istore #9
/*     */     //   1040: aload #8
/*     */     //   1042: dup
/*     */     //   1043: ifnonnull -> 1056
/*     */     //   1046: new kotlin/TypeCastException
/*     */     //   1049: dup
/*     */     //   1050: ldc 'null cannot be cast to non-null type kotlin.CharSequence'
/*     */     //   1052: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1055: athrow
/*     */     //   1056: checkcast java/lang/CharSequence
/*     */     //   1059: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
/*     */     //   1062: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1065: astore #7
/*     */     //   1067: aload_0
/*     */     //   1068: aload #7
/*     */     //   1070: ldc2_w 9700
/*     */     //   1073: invokespecial playerDeathAction : (Ljava/lang/String;J)V
/*     */     //   1076: aload_0
/*     */     //   1077: aload_1
/*     */     //   1078: invokespecial playerDeathMsgAction : (Lnet/ccbluex/liquidbounce/event/PacketEvent;)V
/*     */     //   1081: goto -> 1308
/*     */     //   1084: aload_3
/*     */     //   1085: dup
/*     */     //   1086: ldc_w 'chat'
/*     */     //   1089: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1092: ldc_w '花雨庭 >>'
/*     */     //   1095: iconst_0
/*     */     //   1096: iconst_2
/*     */     //   1097: aconst_null
/*     */     //   1098: invokestatic startsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*     */     //   1101: ifeq -> 1124
/*     */     //   1104: aload_3
/*     */     //   1105: checkcast java/lang/CharSequence
/*     */     //   1108: ldc_w '你的 coins 被修正为'
/*     */     //   1111: checkcast java/lang/CharSequence
/*     */     //   1114: iconst_0
/*     */     //   1115: iconst_2
/*     */     //   1116: aconst_null
/*     */     //   1117: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1120: ifeq -> 1124
/*     */     //   1123: return
/*     */     //   1124: ldc_w '击杀了(.*?) !'
/*     */     //   1127: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
/*     */     //   1130: aload_3
/*     */     //   1131: checkcast java/lang/CharSequence
/*     */     //   1134: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   1137: astore #5
/*     */     //   1139: ldc_w '花雨庭 >>(.*?) 被'
/*     */     //   1142: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
/*     */     //   1145: aload_3
/*     */     //   1146: checkcast java/lang/CharSequence
/*     */     //   1149: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   1152: astore #6
/*     */     //   1154: aload #5
/*     */     //   1156: invokevirtual find : ()Z
/*     */     //   1159: ifeq -> 1231
/*     */     //   1162: aload #5
/*     */     //   1164: iconst_1
/*     */     //   1165: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   1168: dup
/*     */     //   1169: ldc 'matcher.group(1)'
/*     */     //   1171: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1174: astore #8
/*     */     //   1176: iconst_0
/*     */     //   1177: istore #9
/*     */     //   1179: aload #8
/*     */     //   1181: dup
/*     */     //   1182: ifnonnull -> 1195
/*     */     //   1185: new kotlin/TypeCastException
/*     */     //   1188: dup
/*     */     //   1189: ldc 'null cannot be cast to non-null type kotlin.CharSequence'
/*     */     //   1191: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1194: athrow
/*     */     //   1195: checkcast java/lang/CharSequence
/*     */     //   1198: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
/*     */     //   1201: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1204: astore #7
/*     */     //   1206: aload_0
/*     */     //   1207: aload #7
/*     */     //   1209: aload_0
/*     */     //   1210: getfield kitCustomDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1213: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1216: checkcast java/lang/Number
/*     */     //   1219: invokevirtual intValue : ()I
/*     */     //   1222: i2l
/*     */     //   1223: invokespecial playerDeathAction : (Ljava/lang/String;J)V
/*     */     //   1226: aload_0
/*     */     //   1227: aload_1
/*     */     //   1228: invokespecial playerDeathMsgAction : (Lnet/ccbluex/liquidbounce/event/PacketEvent;)V
/*     */     //   1231: aload #6
/*     */     //   1233: invokevirtual find : ()Z
/*     */     //   1236: ifeq -> 1308
/*     */     //   1239: aload #6
/*     */     //   1241: iconst_1
/*     */     //   1242: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   1245: dup
/*     */     //   1246: ldc 'matcher2.group(1)'
/*     */     //   1248: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1251: astore #8
/*     */     //   1253: iconst_0
/*     */     //   1254: istore #9
/*     */     //   1256: aload #8
/*     */     //   1258: dup
/*     */     //   1259: ifnonnull -> 1272
/*     */     //   1262: new kotlin/TypeCastException
/*     */     //   1265: dup
/*     */     //   1266: ldc 'null cannot be cast to non-null type kotlin.CharSequence'
/*     */     //   1268: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1271: athrow
/*     */     //   1272: checkcast java/lang/CharSequence
/*     */     //   1275: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
/*     */     //   1278: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1281: astore #7
/*     */     //   1283: aload_0
/*     */     //   1284: aload #7
/*     */     //   1286: aload_0
/*     */     //   1287: getfield kitCustomDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1290: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1293: checkcast java/lang/Number
/*     */     //   1296: invokevirtual intValue : ()I
/*     */     //   1299: i2l
/*     */     //   1300: invokespecial playerDeathAction : (Ljava/lang/String;J)V
/*     */     //   1303: aload_0
/*     */     //   1304: aload_1
/*     */     //   1305: invokespecial playerDeathMsgAction : (Lnet/ccbluex/liquidbounce/event/PacketEvent;)V
/*     */     //   1308: aload_2
/*     */     //   1309: instanceof net/minecraft/network/play/server/SPacketChat
/*     */     //   1312: ifeq -> 1600
/*     */     //   1315: aload_2
/*     */     //   1316: checkcast net/minecraft/network/play/server/SPacketChat
/*     */     //   1319: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   1322: dup
/*     */     //   1323: ldc 'packet.chatComponent'
/*     */     //   1325: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1328: invokeinterface func_150260_c : ()Ljava/lang/String;
/*     */     //   1333: dup
/*     */     //   1334: ldc 'packet.chatComponent.unformattedText'
/*     */     //   1336: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1339: checkcast java/lang/CharSequence
/*     */     //   1342: ldc ':'
/*     */     //   1344: checkcast java/lang/CharSequence
/*     */     //   1347: iconst_0
/*     */     //   1348: iconst_2
/*     */     //   1349: aconst_null
/*     */     //   1350: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1353: ifeq -> 1600
/*     */     //   1356: aload_2
/*     */     //   1357: checkcast net/minecraft/network/play/server/SPacketChat
/*     */     //   1360: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   1363: dup
/*     */     //   1364: ldc 'packet.chatComponent'
/*     */     //   1366: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1369: invokeinterface func_150260_c : ()Ljava/lang/String;
/*     */     //   1374: dup
/*     */     //   1375: ldc 'packet.chatComponent.unformattedText'
/*     */     //   1377: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1380: checkcast java/lang/CharSequence
/*     */     //   1383: new java/lang/StringBuilder
/*     */     //   1386: dup
/*     */     //   1387: invokespecial <init> : ()V
/*     */     //   1390: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1393: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1398: dup
/*     */     //   1399: ifnonnull -> 1405
/*     */     //   1402: invokestatic throwNpe : ()V
/*     */     //   1405: invokeinterface getDisplayNameString : ()Ljava/lang/String;
/*     */     //   1410: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1413: ldc ':'
/*     */     //   1415: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1418: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1421: checkcast java/lang/CharSequence
/*     */     //   1424: iconst_0
/*     */     //   1425: iconst_2
/*     */     //   1426: aconst_null
/*     */     //   1427: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1430: ifne -> 1600
/*     */     //   1433: aload_2
/*     */     //   1434: checkcast net/minecraft/network/play/server/SPacketChat
/*     */     //   1437: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   1440: dup
/*     */     //   1441: ldc 'packet.chatComponent'
/*     */     //   1443: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1446: invokeinterface func_150260_c : ()Ljava/lang/String;
/*     */     //   1451: dup
/*     */     //   1452: ldc 'packet.chatComponent.unformattedText'
/*     */     //   1454: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1457: checkcast java/lang/CharSequence
/*     */     //   1460: ldc '起床战争'
/*     */     //   1462: checkcast java/lang/CharSequence
/*     */     //   1465: iconst_0
/*     */     //   1466: iconst_2
/*     */     //   1467: aconst_null
/*     */     //   1468: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1471: ifeq -> 1600
/*     */     //   1474: aload_2
/*     */     //   1475: checkcast net/minecraft/network/play/server/SPacketChat
/*     */     //   1478: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   1481: dup
/*     */     //   1482: ldc 'packet.chatComponent'
/*     */     //   1484: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1487: invokeinterface func_150260_c : ()Ljava/lang/String;
/*     */     //   1492: dup
/*     */     //   1493: ldc 'packet.chatComponent.unformattedText'
/*     */     //   1495: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1498: checkcast java/lang/CharSequence
/*     */     //   1501: ldc_w '01:00:00 是这个地图的记录!'
/*     */     //   1504: checkcast java/lang/CharSequence
/*     */     //   1507: iconst_0
/*     */     //   1508: iconst_2
/*     */     //   1509: aconst_null
/*     */     //   1510: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1513: ifne -> 1600
/*     */     //   1516: aload_2
/*     */     //   1517: checkcast net/minecraft/network/play/server/SPacketChat
/*     */     //   1520: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   1523: dup
/*     */     //   1524: ldc 'packet.chatComponent'
/*     */     //   1526: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1529: invokeinterface func_150260_c : ()Ljava/lang/String;
/*     */     //   1534: dup
/*     */     //   1535: ldc 'packet.chatComponent.unformattedText'
/*     */     //   1537: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1540: checkcast java/lang/CharSequence
/*     */     //   1543: ldc_w '之队队设置一个新的记录:'
/*     */     //   1546: checkcast java/lang/CharSequence
/*     */     //   1549: iconst_0
/*     */     //   1550: iconst_2
/*     */     //   1551: aconst_null
/*     */     //   1552: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1555: ifne -> 1600
/*     */     //   1558: aload_0
/*     */     //   1559: getfield hideAntiGetNameValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1562: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1565: checkcast java/lang/Boolean
/*     */     //   1568: invokevirtual booleanValue : ()Z
/*     */     //   1571: ifeq -> 1600
/*     */     //   1574: aload_1
/*     */     //   1575: invokevirtual cancelEvent : ()V
/*     */     //   1578: aload_0
/*     */     //   1579: getfield chatHiddenValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1582: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1585: checkcast java/lang/Boolean
/*     */     //   1588: invokevirtual booleanValue : ()Z
/*     */     //   1591: ifeq -> 1600
/*     */     //   1594: ldc_w '§bXSJ Client §7» §c隐藏了AntiGetname消息。'
/*     */     //   1597: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   1600: aload_2
/*     */     //   1601: instanceof net/minecraft/network/play/server/SPacketChat
/*     */     //   1604: ifeq -> 1766
/*     */     //   1607: aload_2
/*     */     //   1608: checkcast net/minecraft/network/play/server/SPacketChat
/*     */     //   1611: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   1614: dup
/*     */     //   1615: ldc 'packet.chatComponent'
/*     */     //   1617: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1620: invokeinterface func_150260_c : ()Ljava/lang/String;
/*     */     //   1625: astore_3
/*     */     //   1626: aload_0
/*     */     //   1627: getfield multiKillMessageList : [Ljava/lang/String;
/*     */     //   1630: astore #6
/*     */     //   1632: aload #6
/*     */     //   1634: arraylength
/*     */     //   1635: istore #7
/*     */     //   1637: iconst_0
/*     */     //   1638: istore #5
/*     */     //   1640: iload #5
/*     */     //   1642: iload #7
/*     */     //   1644: if_icmpge -> 1766
/*     */     //   1647: aload #6
/*     */     //   1649: iload #5
/*     */     //   1651: aaload
/*     */     //   1652: astore #4
/*     */     //   1654: aload_3
/*     */     //   1655: dup
/*     */     //   1656: ldc_w 'chat'
/*     */     //   1659: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1662: checkcast java/lang/CharSequence
/*     */     //   1665: aload #4
/*     */     //   1667: checkcast java/lang/CharSequence
/*     */     //   1670: iconst_0
/*     */     //   1671: iconst_2
/*     */     //   1672: aconst_null
/*     */     //   1673: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1676: ifne -> 1688
/*     */     //   1679: aload_3
/*     */     //   1680: aload #4
/*     */     //   1682: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1685: ifeq -> 1760
/*     */     //   1688: aload_0
/*     */     //   1689: getfield showMyMultiKillChatValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1692: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1695: checkcast java/lang/Boolean
/*     */     //   1698: invokevirtual booleanValue : ()Z
/*     */     //   1701: ifeq -> 1740
/*     */     //   1704: aload_3
/*     */     //   1705: checkcast java/lang/CharSequence
/*     */     //   1708: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1711: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1716: dup
/*     */     //   1717: ifnonnull -> 1723
/*     */     //   1720: invokestatic throwNpe : ()V
/*     */     //   1723: invokeinterface getDisplayNameString : ()Ljava/lang/String;
/*     */     //   1728: checkcast java/lang/CharSequence
/*     */     //   1731: iconst_0
/*     */     //   1732: iconst_2
/*     */     //   1733: aconst_null
/*     */     //   1734: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1737: ifne -> 1760
/*     */     //   1740: aload_0
/*     */     //   1741: getfield hideMultiKillChatValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1744: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1747: checkcast java/lang/Boolean
/*     */     //   1750: invokevirtual booleanValue : ()Z
/*     */     //   1753: ifeq -> 1760
/*     */     //   1756: aload_1
/*     */     //   1757: invokevirtual cancelEvent : ()V
/*     */     //   1760: iinc #5, 1
/*     */     //   1763: goto -> 1640
/*     */     //   1766: aload_2
/*     */     //   1767: instanceof net/minecraft/network/play/server/SPacketChat
/*     */     //   1770: ifeq -> 2419
/*     */     //   1773: aload_2
/*     */     //   1774: checkcast net/minecraft/network/play/server/SPacketChat
/*     */     //   1777: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   1780: dup
/*     */     //   1781: ldc 'packet.chatComponent'
/*     */     //   1783: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1786: invokeinterface func_150260_c : ()Ljava/lang/String;
/*     */     //   1791: astore_3
/*     */     //   1792: aload_0
/*     */     //   1793: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   1796: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1799: checkcast java/lang/String
/*     */     //   1802: astore #4
/*     */     //   1804: iconst_0
/*     */     //   1805: istore #5
/*     */     //   1807: aload #4
/*     */     //   1809: dup
/*     */     //   1810: ifnonnull -> 1823
/*     */     //   1813: new kotlin/TypeCastException
/*     */     //   1816: dup
/*     */     //   1817: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   1819: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1822: athrow
/*     */     //   1823: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   1826: dup
/*     */     //   1827: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   1829: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1832: ldc 'kitbattle'
/*     */     //   1834: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   1837: ifeq -> 2419
/*     */     //   1840: aload_3
/*     */     //   1841: dup
/*     */     //   1842: ldc_w 'chat'
/*     */     //   1845: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1848: ldc '花雨庭'
/*     */     //   1850: iconst_0
/*     */     //   1851: iconst_2
/*     */     //   1852: aconst_null
/*     */     //   1853: invokestatic startsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*     */     //   1856: ifeq -> 2419
/*     */     //   1859: aload_0
/*     */     //   1860: getfield kitHideKillCoinValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1863: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1866: checkcast java/lang/Boolean
/*     */     //   1869: invokevirtual booleanValue : ()Z
/*     */     //   1872: ifeq -> 1974
/*     */     //   1875: aload_3
/*     */     //   1876: checkcast java/lang/CharSequence
/*     */     //   1879: ldc_w '花雨庭 >>你消灭'
/*     */     //   1882: checkcast java/lang/CharSequence
/*     */     //   1885: iconst_0
/*     */     //   1886: iconst_2
/*     */     //   1887: aconst_null
/*     */     //   1888: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1891: ifeq -> 1932
/*     */     //   1894: aload_3
/*     */     //   1895: checkcast java/lang/CharSequence
/*     */     //   1898: ldc_w '% 的伤害并且获得了'
/*     */     //   1901: checkcast java/lang/CharSequence
/*     */     //   1904: iconst_0
/*     */     //   1905: iconst_2
/*     */     //   1906: aconst_null
/*     */     //   1907: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1910: ifeq -> 1932
/*     */     //   1913: aload_3
/*     */     //   1914: checkcast java/lang/CharSequence
/*     */     //   1917: ldc_w '硬币!'
/*     */     //   1920: checkcast java/lang/CharSequence
/*     */     //   1923: iconst_0
/*     */     //   1924: iconst_2
/*     */     //   1925: aconst_null
/*     */     //   1926: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1929: ifne -> 1970
/*     */     //   1932: aload_3
/*     */     //   1933: checkcast java/lang/CharSequence
/*     */     //   1936: ldc_w '你的 coins 被修正为'
/*     */     //   1939: checkcast java/lang/CharSequence
/*     */     //   1942: iconst_0
/*     */     //   1943: iconst_2
/*     */     //   1944: aconst_null
/*     */     //   1945: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1948: ifne -> 1970
/*     */     //   1951: aload_3
/*     */     //   1952: checkcast java/lang/CharSequence
/*     */     //   1955: ldc_w '搂c搂l您本日获得的 搂7搂l银币搂c搂l 已达上限,接下来的游戏将不再获得。'
/*     */     //   1958: checkcast java/lang/CharSequence
/*     */     //   1961: iconst_0
/*     */     //   1962: iconst_2
/*     */     //   1963: aconst_null
/*     */     //   1964: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1967: ifeq -> 1974
/*     */     //   1970: aload_1
/*     */     //   1971: invokevirtual cancelEvent : ()V
/*     */     //   1974: aload_3
/*     */     //   1975: checkcast java/lang/CharSequence
/*     */     //   1978: ldc_w '花雨庭 >>'
/*     */     //   1981: checkcast java/lang/CharSequence
/*     */     //   1984: iconst_0
/*     */     //   1985: iconst_2
/*     */     //   1986: aconst_null
/*     */     //   1987: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1990: ifeq -> 2103
/*     */     //   1993: aload_3
/*     */     //   1994: checkcast java/lang/CharSequence
/*     */     //   1997: ldc_w '完成了'
/*     */     //   2000: checkcast java/lang/CharSequence
/*     */     //   2003: iconst_0
/*     */     //   2004: iconst_2
/*     */     //   2005: aconst_null
/*     */     //   2006: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   2009: ifeq -> 2103
/*     */     //   2012: aload_3
/*     */     //   2013: checkcast java/lang/CharSequence
/*     */     //   2016: ldc_w '连杀!'
/*     */     //   2019: checkcast java/lang/CharSequence
/*     */     //   2022: iconst_0
/*     */     //   2023: iconst_2
/*     */     //   2024: aconst_null
/*     */     //   2025: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   2028: ifeq -> 2103
/*     */     //   2031: aload_0
/*     */     //   2032: getfield showMyMultiKillChatValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   2035: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2038: checkcast java/lang/Boolean
/*     */     //   2041: invokevirtual booleanValue : ()Z
/*     */     //   2044: ifeq -> 2083
/*     */     //   2047: aload_3
/*     */     //   2048: checkcast java/lang/CharSequence
/*     */     //   2051: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2054: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2059: dup
/*     */     //   2060: ifnonnull -> 2066
/*     */     //   2063: invokestatic throwNpe : ()V
/*     */     //   2066: invokeinterface getDisplayNameString : ()Ljava/lang/String;
/*     */     //   2071: checkcast java/lang/CharSequence
/*     */     //   2074: iconst_0
/*     */     //   2075: iconst_2
/*     */     //   2076: aconst_null
/*     */     //   2077: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   2080: ifne -> 2103
/*     */     //   2083: aload_0
/*     */     //   2084: getfield hideMultiKillChatValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   2087: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2090: checkcast java/lang/Boolean
/*     */     //   2093: invokevirtual booleanValue : ()Z
/*     */     //   2096: ifeq -> 2103
/*     */     //   2099: aload_1
/*     */     //   2100: invokevirtual cancelEvent : ()V
/*     */     //   2103: aload_3
/*     */     //   2104: checkcast java/lang/CharSequence
/*     */     //   2107: ldc_w '花雨庭 >>'
/*     */     //   2110: checkcast java/lang/CharSequence
/*     */     //   2113: iconst_0
/*     */     //   2114: iconst_2
/*     */     //   2115: aconst_null
/*     */     //   2116: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   2119: ifeq -> 2218
/*     */     //   2122: aload_3
/*     */     //   2123: checkcast java/lang/CharSequence
/*     */     //   2126: ldc_w 'has ended his deathstreak and lost his buff'
/*     */     //   2129: checkcast java/lang/CharSequence
/*     */     //   2132: iconst_0
/*     */     //   2133: iconst_2
/*     */     //   2134: aconst_null
/*     */     //   2135: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   2138: ifne -> 2198
/*     */     //   2141: aload_3
/*     */     //   2142: checkcast java/lang/CharSequence
/*     */     //   2145: ldc_w 'is now receiving a buff for his deathstreak'
/*     */     //   2148: checkcast java/lang/CharSequence
/*     */     //   2151: iconst_0
/*     */     //   2152: iconst_2
/*     */     //   2153: aconst_null
/*     */     //   2154: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   2157: ifne -> 2198
/*     */     //   2160: aload_3
/*     */     //   2161: checkcast java/lang/CharSequence
/*     */     //   2164: ldc_w '终结了他的连续死亡'
/*     */     //   2167: checkcast java/lang/CharSequence
/*     */     //   2170: iconst_0
/*     */     //   2171: iconst_2
/*     */     //   2172: aconst_null
/*     */     //   2173: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   2176: ifne -> 2198
/*     */     //   2179: aload_3
/*     */     //   2180: checkcast java/lang/CharSequence
/*     */     //   2183: ldc_w '获得了一个buff因为他刚刚完成了'
/*     */     //   2186: checkcast java/lang/CharSequence
/*     */     //   2189: iconst_0
/*     */     //   2190: iconst_2
/*     */     //   2191: aconst_null
/*     */     //   2192: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   2195: ifeq -> 2218
/*     */     //   2198: aload_0
/*     */     //   2199: getfield kitHideDeathStreakValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   2202: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2205: checkcast java/lang/Boolean
/*     */     //   2208: invokevirtual booleanValue : ()Z
/*     */     //   2211: ifeq -> 2218
/*     */     //   2214: aload_1
/*     */     //   2215: invokevirtual cancelEvent : ()V
/*     */     //   2218: aload_0
/*     */     //   2219: getfield kitSpecialDeathChats : [Ljava/lang/String;
/*     */     //   2222: astore #6
/*     */     //   2224: aload #6
/*     */     //   2226: arraylength
/*     */     //   2227: istore #7
/*     */     //   2229: iconst_0
/*     */     //   2230: istore #5
/*     */     //   2232: iload #5
/*     */     //   2234: iload #7
/*     */     //   2236: if_icmpge -> 2299
/*     */     //   2239: aload #6
/*     */     //   2241: iload #5
/*     */     //   2243: aaload
/*     */     //   2244: astore #4
/*     */     //   2246: aload_3
/*     */     //   2247: checkcast java/lang/CharSequence
/*     */     //   2250: aload #4
/*     */     //   2252: checkcast java/lang/CharSequence
/*     */     //   2255: iconst_0
/*     */     //   2256: iconst_2
/*     */     //   2257: aconst_null
/*     */     //   2258: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   2261: ifne -> 2273
/*     */     //   2264: aload_3
/*     */     //   2265: aload #4
/*     */     //   2267: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   2270: ifeq -> 2293
/*     */     //   2273: aload_0
/*     */     //   2274: getfield kitHideSpecialDeathValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   2277: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2280: checkcast java/lang/Boolean
/*     */     //   2283: invokevirtual booleanValue : ()Z
/*     */     //   2286: ifeq -> 2293
/*     */     //   2289: aload_1
/*     */     //   2290: invokevirtual cancelEvent : ()V
/*     */     //   2293: iinc #5, 1
/*     */     //   2296: goto -> 2232
/*     */     //   2299: aload_0
/*     */     //   2300: getfield kitSpecialSkillChats : [Ljava/lang/String;
/*     */     //   2303: astore #6
/*     */     //   2305: aload #6
/*     */     //   2307: arraylength
/*     */     //   2308: istore #7
/*     */     //   2310: iconst_0
/*     */     //   2311: istore #5
/*     */     //   2313: iload #5
/*     */     //   2315: iload #7
/*     */     //   2317: if_icmpge -> 2380
/*     */     //   2320: aload #6
/*     */     //   2322: iload #5
/*     */     //   2324: aaload
/*     */     //   2325: astore #4
/*     */     //   2327: aload_3
/*     */     //   2328: checkcast java/lang/CharSequence
/*     */     //   2331: aload #4
/*     */     //   2333: checkcast java/lang/CharSequence
/*     */     //   2336: iconst_0
/*     */     //   2337: iconst_2
/*     */     //   2338: aconst_null
/*     */     //   2339: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   2342: ifne -> 2354
/*     */     //   2345: aload_3
/*     */     //   2346: aload #4
/*     */     //   2348: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   2351: ifeq -> 2374
/*     */     //   2354: aload_0
/*     */     //   2355: getfield kitHideSkillChatValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   2358: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2361: checkcast java/lang/Boolean
/*     */     //   2364: invokevirtual booleanValue : ()Z
/*     */     //   2367: ifeq -> 2374
/*     */     //   2370: aload_1
/*     */     //   2371: invokevirtual cancelEvent : ()V
/*     */     //   2374: iinc #5, 1
/*     */     //   2377: goto -> 2313
/*     */     //   2380: aload_0
/*     */     //   2381: getfield kitHidePlayerUpgradeChatValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   2384: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2387: checkcast java/lang/Boolean
/*     */     //   2390: invokevirtual booleanValue : ()Z
/*     */     //   2393: ifeq -> 2419
/*     */     //   2396: aload_3
/*     */     //   2397: checkcast java/lang/CharSequence
/*     */     //   2400: ldc_w '通过击杀获得胜点的方式晋级为'
/*     */     //   2403: checkcast java/lang/CharSequence
/*     */     //   2406: iconst_0
/*     */     //   2407: iconst_2
/*     */     //   2408: aconst_null
/*     */     //   2409: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   2412: ifeq -> 2419
/*     */     //   2415: aload_1
/*     */     //   2416: invokevirtual cancelEvent : ()V
/*     */     //   2419: aload_2
/*     */     //   2420: instanceof net/minecraft/network/play/server/SPacketChat
/*     */     //   2423: ifeq -> 2783
/*     */     //   2426: aload_0
/*     */     //   2427: getfield autoModeValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   2430: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2433: checkcast java/lang/Boolean
/*     */     //   2436: invokevirtual booleanValue : ()Z
/*     */     //   2439: ifeq -> 2783
/*     */     //   2442: aload_2
/*     */     //   2443: checkcast net/minecraft/network/play/server/SPacketChat
/*     */     //   2446: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   2449: dup
/*     */     //   2450: ldc 'packet.chatComponent'
/*     */     //   2452: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   2455: invokeinterface func_150260_c : ()Ljava/lang/String;
/*     */     //   2460: astore_3
/*     */     //   2461: aload_3
/*     */     //   2462: dup
/*     */     //   2463: ldc_w 'chat'
/*     */     //   2466: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   2469: ldc_w '花雨庭 >>'
/*     */     //   2472: iconst_0
/*     */     //   2473: iconst_2
/*     */     //   2474: aconst_null
/*     */     //   2475: invokestatic startsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*     */     //   2478: ifeq -> 2547
/*     */     //   2481: aload_0
/*     */     //   2482: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   2485: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2488: checkcast java/lang/String
/*     */     //   2491: astore #4
/*     */     //   2493: iconst_0
/*     */     //   2494: istore #5
/*     */     //   2496: aload #4
/*     */     //   2498: dup
/*     */     //   2499: ifnonnull -> 2512
/*     */     //   2502: new kotlin/TypeCastException
/*     */     //   2505: dup
/*     */     //   2506: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   2508: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   2511: athrow
/*     */     //   2512: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   2515: dup
/*     */     //   2516: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   2518: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   2521: ldc 'kitbattle'
/*     */     //   2523: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   2526: iconst_1
/*     */     //   2527: ixor
/*     */     //   2528: ifeq -> 2547
/*     */     //   2531: aload_0
/*     */     //   2532: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   2535: ldc_w 'KitBattle'
/*     */     //   2538: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   2541: ldc_w '§7[§dAntiFP§7] §f自动切换模式为§c职业战争§7。'
/*     */     //   2544: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   2547: aload_3
/*     */     //   2548: ldc_w '起床战争>>'
/*     */     //   2551: iconst_0
/*     */     //   2552: iconst_2
/*     */     //   2553: aconst_null
/*     */     //   2554: invokestatic startsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*     */     //   2557: ifeq -> 2625
/*     */     //   2560: aload_0
/*     */     //   2561: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   2564: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2567: checkcast java/lang/String
/*     */     //   2570: astore #4
/*     */     //   2572: iconst_0
/*     */     //   2573: istore #5
/*     */     //   2575: aload #4
/*     */     //   2577: dup
/*     */     //   2578: ifnonnull -> 2591
/*     */     //   2581: new kotlin/TypeCastException
/*     */     //   2584: dup
/*     */     //   2585: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   2587: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   2590: athrow
/*     */     //   2591: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   2594: dup
/*     */     //   2595: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   2597: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   2600: ldc '4v4/2v2/1v1'
/*     */     //   2602: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   2605: iconst_1
/*     */     //   2606: ixor
/*     */     //   2607: ifeq -> 2625
/*     */     //   2610: aload_0
/*     */     //   2611: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   2614: ldc '4v4/2v2/1v1'
/*     */     //   2616: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   2619: ldc_w '§7[§dAntiFP§7] §f自动切换模式为§c4v4/2v2/1v1§7。'
/*     */     //   2622: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   2625: aload_3
/*     */     //   2626: ldc_w '起床战争 >>'
/*     */     //   2629: iconst_0
/*     */     //   2630: iconst_2
/*     */     //   2631: aconst_null
/*     */     //   2632: invokestatic startsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*     */     //   2635: ifeq -> 2704
/*     */     //   2638: aload_0
/*     */     //   2639: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   2642: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2645: checkcast java/lang/String
/*     */     //   2648: astore #4
/*     */     //   2650: iconst_0
/*     */     //   2651: istore #5
/*     */     //   2653: aload #4
/*     */     //   2655: dup
/*     */     //   2656: ifnonnull -> 2669
/*     */     //   2659: new kotlin/TypeCastException
/*     */     //   2662: dup
/*     */     //   2663: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   2665: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   2668: athrow
/*     */     //   2669: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   2672: dup
/*     */     //   2673: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   2675: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   2678: ldc 'bwxp32'
/*     */     //   2680: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   2683: iconst_1
/*     */     //   2684: ixor
/*     */     //   2685: ifeq -> 2704
/*     */     //   2688: aload_0
/*     */     //   2689: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   2692: ldc_w 'BWXP32'
/*     */     //   2695: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   2698: ldc_w '§7[§dAntiFP§7] §f自动切换模式为§c经验32§7。'
/*     */     //   2701: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   2704: aload_3
/*     */     //   2705: ldc_w '[起床战争]'
/*     */     //   2708: iconst_0
/*     */     //   2709: iconst_2
/*     */     //   2710: aconst_null
/*     */     //   2711: invokestatic startsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*     */     //   2714: ifeq -> 2783
/*     */     //   2717: aload_0
/*     */     //   2718: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   2721: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2724: checkcast java/lang/String
/*     */     //   2727: astore #4
/*     */     //   2729: iconst_0
/*     */     //   2730: istore #5
/*     */     //   2732: aload #4
/*     */     //   2734: dup
/*     */     //   2735: ifnonnull -> 2748
/*     */     //   2738: new kotlin/TypeCastException
/*     */     //   2741: dup
/*     */     //   2742: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   2744: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   2747: athrow
/*     */     //   2748: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   2751: dup
/*     */     //   2752: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   2754: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   2757: ldc 'bwxp16'
/*     */     //   2759: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   2762: iconst_1
/*     */     //   2763: ixor
/*     */     //   2764: ifeq -> 2783
/*     */     //   2767: aload_0
/*     */     //   2768: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   2771: ldc_w 'BWXP16'
/*     */     //   2774: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   2777: ldc_w '§7[§dAntiFP§7] §f自动切换模式为§c经验16§7。'
/*     */     //   2780: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   2783: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #205	-> 6
/*     */     //   #545	-> 14
/*     */     //   #205	-> 35
/*     */     //   #206	-> 36
/*     */     //   #208	-> 36
/*     */     //   #206	-> 36
/*     */     //   #207	-> 108
/*     */     //   #206	-> 113
/*     */     //   #208	-> 119
/*     */     //   #209	-> 178
/*     */     //   #208	-> 183
/*     */     //   #212	-> 189
/*     */     //   #213	-> 208
/*     */     //   #265	-> 296
/*     */     //   #215	-> 309
/*     */     //   #243	-> 322
/*     */     //   #281	-> 335
/*     */     //   #216	-> 348
/*     */     //   #217	-> 362
/*     */     //   #218	-> 376
/*     */     //   #219	-> 390
/*     */     //   #220	-> 404
/*     */     //   #221	-> 412
/*     */     //   #221	-> 454
/*     */     //   #222	-> 456
/*     */     //   #223	-> 465
/*     */     //   #225	-> 470
/*     */     //   #226	-> 478
/*     */     //   #226	-> 520
/*     */     //   #227	-> 522
/*     */     //   #228	-> 531
/*     */     //   #230	-> 536
/*     */     //   #231	-> 544
/*     */     //   #231	-> 587
/*     */     //   #232	-> 589
/*     */     //   #233	-> 598
/*     */     //   #235	-> 603
/*     */     //   #236	-> 611
/*     */     //   #236	-> 654
/*     */     //   #237	-> 656
/*     */     //   #238	-> 665
/*     */     //   #244	-> 673
/*     */     //   #245	-> 687
/*     */     //   #246	-> 702
/*     */     //   #247	-> 717
/*     */     //   #248	-> 725
/*     */     //   #248	-> 767
/*     */     //   #249	-> 769
/*     */     //   #250	-> 778
/*     */     //   #252	-> 783
/*     */     //   #253	-> 791
/*     */     //   #253	-> 833
/*     */     //   #254	-> 835
/*     */     //   #255	-> 844
/*     */     //   #257	-> 849
/*     */     //   #258	-> 857
/*     */     //   #258	-> 900
/*     */     //   #259	-> 902
/*     */     //   #260	-> 911
/*     */     //   #266	-> 919
/*     */     //   #267	-> 934
/*     */     //   #268	-> 949
/*     */     //   #269	-> 957
/*     */     //   #269	-> 999
/*     */     //   #270	-> 1001
/*     */     //   #271	-> 1010
/*     */     //   #273	-> 1015
/*     */     //   #274	-> 1023
/*     */     //   #274	-> 1065
/*     */     //   #275	-> 1067
/*     */     //   #276	-> 1076
/*     */     //   #282	-> 1084
/*     */     //   #283	-> 1124
/*     */     //   #284	-> 1139
/*     */     //   #285	-> 1154
/*     */     //   #286	-> 1162
/*     */     //   #286	-> 1204
/*     */     //   #287	-> 1206
/*     */     //   #288	-> 1226
/*     */     //   #290	-> 1231
/*     */     //   #291	-> 1239
/*     */     //   #291	-> 1281
/*     */     //   #292	-> 1283
/*     */     //   #293	-> 1303
/*     */     //   #296	-> 1308
/*     */     //   #300	-> 1308
/*     */     //   #302	-> 1308
/*     */     //   #305	-> 1308
/*     */     //   #307	-> 1308
/*     */     //   #309	-> 1308
/*     */     //   #300	-> 1308
/*     */     //   #301	-> 1342
/*     */     //   #300	-> 1350
/*     */     //   #302	-> 1356
/*     */     //   #303	-> 1383
/*     */     //   #304	-> 1383
/*     */     //   #302	-> 1427
/*     */     //   #305	-> 1433
/*     */     //   #306	-> 1460
/*     */     //   #305	-> 1468
/*     */     //   #307	-> 1474
/*     */     //   #308	-> 1501
/*     */     //   #307	-> 1510
/*     */     //   #309	-> 1516
/*     */     //   #310	-> 1543
/*     */     //   #309	-> 1552
/*     */     //   #314	-> 1558
/*     */     //   #315	-> 1574
/*     */     //   #316	-> 1578
/*     */     //   #321	-> 1600
/*     */     //   #322	-> 1607
/*     */     //   #323	-> 1626
/*     */     //   #324	-> 1654
/*     */     //   #325	-> 1740
/*     */     //   #323	-> 1760
/*     */     //   #331	-> 1766
/*     */     //   #332	-> 1773
/*     */     //   #333	-> 1792
/*     */     //   #333	-> 1840
/*     */     //   #335	-> 1859
/*     */     //   #337	-> 1859
/*     */     //   #335	-> 1859
/*     */     //   #336	-> 1917
/*     */     //   #335	-> 1926
/*     */     //   #337	-> 1932
/*     */     //   #339	-> 1970
/*     */     //   #343	-> 1974
/*     */     //   #344	-> 2051
/*     */     //   #343	-> 2077
/*     */     //   #347	-> 2083
/*     */     //   #351	-> 2103
/*     */     //   #352	-> 2103
/*     */     //   #353	-> 2103
/*     */     //   #354	-> 2103
/*     */     //   #355	-> 2103
/*     */     //   #351	-> 2103
/*     */     //   #352	-> 2122
/*     */     //   #353	-> 2141
/*     */     //   #354	-> 2160
/*     */     //   #355	-> 2179
/*     */     //   #358	-> 2198
/*     */     //   #362	-> 2218
/*     */     //   #363	-> 2246
/*     */     //   #364	-> 2273
/*     */     //   #362	-> 2293
/*     */     //   #369	-> 2299
/*     */     //   #370	-> 2327
/*     */     //   #371	-> 2354
/*     */     //   #369	-> 2374
/*     */     //   #376	-> 2380
/*     */     //   #377	-> 2415
/*     */     //   #382	-> 2419
/*     */     //   #383	-> 2442
/*     */     //   #384	-> 2461
/*     */     //   #385	-> 2531
/*     */     //   #386	-> 2541
/*     */     //   #388	-> 2547
/*     */     //   #389	-> 2610
/*     */     //   #390	-> 2619
/*     */     //   #392	-> 2625
/*     */     //   #393	-> 2688
/*     */     //   #394	-> 2698
/*     */     //   #396	-> 2704
/*     */     //   #397	-> 2767
/*     */     //   #398	-> 2777
/*     */     //   #401	-> 2783
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   11	24	3	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   14	21	4	$i$f$unwrap	I
/*     */     //   456	14	9	name	Ljava/lang/String;
/*     */     //   522	14	9	name	Ljava/lang/String;
/*     */     //   589	14	9	name	Ljava/lang/String;
/*     */     //   656	14	9	name	Ljava/lang/String;
/*     */     //   404	266	8	matcher4	Ljava/util/regex/Matcher;
/*     */     //   390	280	7	matcher3	Ljava/util/regex/Matcher;
/*     */     //   376	294	6	matcher2	Ljava/util/regex/Matcher;
/*     */     //   362	308	5	matcher	Ljava/util/regex/Matcher;
/*     */     //   769	14	8	name	Ljava/lang/String;
/*     */     //   835	14	8	name	Ljava/lang/String;
/*     */     //   902	14	8	name	Ljava/lang/String;
/*     */     //   717	199	7	matcher3	Ljava/util/regex/Matcher;
/*     */     //   702	214	6	matcher2	Ljava/util/regex/Matcher;
/*     */     //   687	229	5	matcher	Ljava/util/regex/Matcher;
/*     */     //   1001	14	7	name	Ljava/lang/String;
/*     */     //   1067	14	7	name	Ljava/lang/String;
/*     */     //   949	132	6	matcher2	Ljava/util/regex/Matcher;
/*     */     //   934	147	5	matcher	Ljava/util/regex/Matcher;
/*     */     //   1206	25	7	name	Ljava/lang/String;
/*     */     //   1283	25	7	name	Ljava/lang/String;
/*     */     //   1154	154	6	matcher2	Ljava/util/regex/Matcher;
/*     */     //   1139	169	5	matcher	Ljava/util/regex/Matcher;
/*     */     //   208	1100	3	chat	Ljava/lang/String;
/*     */     //   1654	109	4	it	Ljava/lang/String;
/*     */     //   1626	140	3	chat	Ljava/lang/String;
/*     */     //   2246	50	4	it	Ljava/lang/String;
/*     */     //   2327	50	4	it	Ljava/lang/String;
/*     */     //   1792	627	3	chat	Ljava/lang/String;
/*     */     //   2461	322	3	chat	Ljava/lang/String;
/*     */     //   36	2748	2	packet	Lnet/minecraft/network/Packet;
/*     */     //   0	2784	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/misc/AntiFakePlayer;
/*     */     //   0	2784	1	event	Lnet/ccbluex/liquidbounce/event/PacketEvent;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 406 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (this.bots < 0) this.bots = 0; 
/* 407 */     if (((Boolean)this.autoSwitchLogger.get()).booleanValue() && this.ms.hasTimePassed(((Number)this.autoSwitchDelay.get()).intValue())) {
/* 408 */       String str = (String)this.autoSwitchModeValue.get(); int i = 0; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case -938285885:
/* 409 */           if (str.equals("random")) this.logStyleValue.set(this.logStyles[RandomUtils.nextInt(0, this.logStyles.length - 1)]);  break;
/* 410 */         case 3322014: if (str.equals("list")) {
/* 411 */             if (this.logNumber != this.logStyles.length - 1) {
/* 412 */               this.logNumber = (i = this.logNumber) + 1;
/* 413 */               this.logStyleValue.set(this.logStyles[this.logNumber]); break;
/*     */             } 
/* 415 */             this.logNumber = 0;
/* 416 */             this.logStyleValue.set(this.logStyles[this.logNumber]);
/*     */           } 
/*     */           break; }
/*     */       
/* 420 */       this.ms.reset();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private final void playerDeathMsgAction(PacketEvent event) {
/* 426 */     IPacket $this$unwrap$iv = event.getPacket(); int $i$f$unwrap = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 546 */     if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.PacketImpl<*>");  Packet packet = ((PacketImpl)$this$unwrap$iv).getWrapped();
/*     */     if (packet instanceof SPacketChat && ((Boolean)this.hideKillChatValue.get()).booleanValue()) {
/*     */       if (((Boolean)this.showMyKillDeathChatValue.get()).booleanValue()) {
/*     */         Intrinsics.checkExpressionValueIsNotNull(((SPacketChat)packet).func_148915_c(), "packet.chatComponent");
/*     */         Intrinsics.checkExpressionValueIsNotNull(((SPacketChat)packet).func_148915_c().func_150260_c(), "packet.chatComponent.unformattedText");
/*     */         if (MinecraftInstance.mc.getThePlayer() == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         if (!StringsKt.contains$default(((SPacketChat)packet).func_148915_c().func_150260_c(), MinecraftInstance.mc.getThePlayer().getDisplayNameString(), false, 2, null)) {
/*     */           event.cancelEvent();
/*     */           return;
/*     */         } 
/*     */         return;
/*     */       } 
/*     */     } else {
/*     */       return;
/*     */     } 
/*     */     event.cancelEvent();
/*     */   }
/*     */   
/*     */   private final void playerDeathAction(String name, long cd) {
/*     */     if (name == null)
/*     */       return; 
/*     */     int i;
/*     */     this.bots = (i = this.bots) + 1;
/*     */     if (!(Retreat.INSTANCE.getFileManager()).friendsConfig.isFriend(name))
/*     */       (Retreat.INSTANCE.getFileManager()).friendsConfig.addFriend(name); 
/*     */     this.protectedname = ((Boolean)this.fakeNameProtectValue.get()).booleanValue() ? ("§7§k" + name) : ("§7" + name);
/*     */     if (((Boolean)this.printLoggerValue.get()).booleanValue())
/*     */       printLogger(this.protectedname, "add"); 
/*     */     (new Thread(new AntiFakePlayer$playerDeathAction$1(cd, name))).start();
/*     */   }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "run"})
/*     */   static final class AntiFakePlayer$playerDeathAction$1 implements Runnable {
/*     */     public final void run() {
/*     */       try {
/*     */         Thread.sleep(this.$cd);
/*     */         AntiFakePlayer.this.protectedname = ((Boolean)AntiFakePlayer.this.fakeNameProtectValue.get()).booleanValue() ? ("§7§k" + this.$name) : ("§7" + this.$name);
/*     */         if (this.$name == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         if ((Retreat.INSTANCE.getFileManager()).friendsConfig.isFriend(this.$name)) {
/*     */           if (this.$name == null)
/*     */             Intrinsics.throwNpe(); 
/*     */           (Retreat.INSTANCE.getFileManager()).friendsConfig.removeFriend(this.$name);
/*     */         } 
/*     */         int i;
/*     */         AntiFakePlayer.this.bots = (i = AntiFakePlayer.this.bots) + -1;
/*     */         if (((Boolean)AntiFakePlayer.this.printLoggerValue.get()).booleanValue())
/*     */           AntiFakePlayer.this.printLogger(AntiFakePlayer.this.protectedname, "remove"); 
/*     */       } catch (InterruptedException ex) {
/*     */         ex.printStackTrace();
/*     */         AntiFakePlayer.this.setState(false);
/*     */       } 
/*     */     }
/*     */     
/*     */     AntiFakePlayer$playerDeathAction$1(long param1Long, String param1String) {}
/*     */   }
/*     */   
/*     */   private final void printLogger(String name, String mode) {
/*     */     String str = mode;
/*     */     boolean bool = false;
/*     */     if (str == null)
/*     */       throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */     Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()");
/*     */     str = str.toLowerCase();
/*     */     switch (str.hashCode()) {
/*     */       case 96417:
/*     */         if (str.equals("add")) {
/*     */           String str1 = (String)this.logStyleValue.get();
/*     */           boolean bool1 = false;
/*     */           if (str1 == null)
/*     */             throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */           Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()");
/*     */           str1 = str1.toLowerCase();
/*     */           switch (str1.hashCode()) {
/*     */             case -1322978556:
/*     */               if (str1.equals("arcticNew"))
/*     */                 ClientUtils.displayChatMessage("§bXSJ Client §7» §aAdded§f HYT Bot §7-> §e" + name); 
/*     */               break;
/*     */             case -2008465223:
/*     */               if (str1.equals("special"))
/*     */                 ClientUtils.displayChatMessage("§8[§dXSJ Client§8] §a" + name + "§d被§b青柠§d吃掉啦! §bCiallo(∠・ω< )⌒☆"); 
/*     */               break;
/*     */             case -1039745817:
/*     */               if (str1.equals("normal"))
/*     */                 ClientUtils.displayChatMessage("§7[§6XSJ Client§7] §fAdded HYT Bot: §7" + name); 
/*     */               break;
/*     */             case -994503222:
/*     */               if (str1.equals("fdpchat"))
/*     */                 ClientUtils.displayChatMessage("§f[§c!§f] §bXSJ Client §7>> §aAdded §6HYT bot§f[" + name + "§f]§6."); 
/*     */               break;
/*     */             case -2146994317:
/*     */               if (str1.equals("fdpantibot"))
/*     */                 ClientUtils.displayChatMessage("§7[§cAntiBot§7] §fAdded §7" + name + "§f due to it being a bot."); 
/*     */               break;
/*     */             case 112906142:
/*     */               if (str1.equals("wawa2"))
/*     */                 ClientUtils.displayChatMessage("§6XSJ Client §7» §f玩家死亡: §7" + name); 
/*     */               break;
/*     */             case 112097434:
/*     */               if (str1.equals("verne"))
/*     */                 ClientUtils.displayChatMessage("§7[§fXSJ Client§7] §fAdd a Bot(§7" + name + "§f)"); 
/*     */               break;
/*     */             case 102846135:
/*     */               if (str1.equals("leave"))
/*     */                 ClientUtils.displayChatMessage("§bXSJ Client §8[§eWARNING§8] §6添加无敌人: " + name); 
/*     */               break;
/*     */             case 110119:
/*     */               if (str1.equals("old"))
/*     */                 ClientUtils.displayChatMessage("§8[§c§lXSJ Client§8] §d添加无敌人：§7" + name); 
/*     */               break;
/*     */             case 112906141:
/*     */               if (str1.equals("wawa1"))
/*     */                 ClientUtils.displayChatMessage("§6XSJ Client §7=> §fAdded Bot §7" + name + "§f."); 
/*     */               break;
/*     */             case 840649778:
/*     */               if (str1.equals("Retreatclient"))
/*     */                 ClientUtils.displayChatMessage("§7[§cAntiBots§7] §fAdded a bot(§7" + name + "§f)"); 
/*     */               break;
/*     */             case 113135984:
/*     */               if (str1.equals("windx"))
/*     */                 ClientUtils.displayChatMessage("§7[§c!§7] §bColorByte §aClient §7=> §aAdded §fa bot(§7" + name + "§f)"); 
/*     */               break;
/*     */           } 
/*     */         } 
/*     */         break;
/*     */       case -934610812:
/*     */         if (str.equals("remove")) {
/*     */           String str1 = (String)this.logStyleValue.get();
/*     */           boolean bool1 = false;
/*     */           if (str1 == null)
/*     */             throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */           Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()");
/*     */           str1 = str1.toLowerCase();
/*     */           switch (str1.hashCode()) {
/*     */             case -1322978556:
/*     */               if (str1.equals("arcticNew"))
/*     */                 ClientUtils.displayChatMessage("§bXSJ Client §7» §cRemoved§f HYT Bot §7-> §e" + name); 
/*     */               break;
/*     */             case -2008465223:
/*     */               if (str1.equals("special"))
/*     */                 ClientUtils.displayChatMessage("§8[§dXSJ Client§8] §a" + name + "§d被§b青柠§d吐出来咯~ §bCiallo(∠・ω< )⌒☆"); 
/*     */               break;
/*     */             case -1039745817:
/*     */               if (str1.equals("normal"))
/*     */                 ClientUtils.displayChatMessage("§7[§6XSJ Client§7] §fRemoved HYT Bot: §7" + name); 
/*     */               break;
/*     */             case -994503222:
/*     */               if (str1.equals("fdpchat"))
/*     */                 ClientUtils.displayChatMessage("§f[§c!§f] §bXSJ Client §7>> §cRemoved §6HYT bot§f[" + name + "§f]§6."); 
/*     */               break;
/*     */             case -2146994317:
/*     */               if (str1.equals("fdpantibot"))
/*     */                 ClientUtils.displayChatMessage("§7[§cAntiBot§7] §fRemoved §7" + name + "§f due to respawn."); 
/*     */               break;
/*     */             case 112906142:
/*     */               if (str1.equals("wawa2"))
/*     */                 ClientUtils.displayChatMessage("§6XSJ Client §7» §f玩家重生: §7" + name); 
/*     */               break;
/*     */             case 112097434:
/*     */               if (str1.equals("verne"))
/*     */                 ClientUtils.displayChatMessage("§7[§fXSJ Client§7] §fDel a Bot(§7" + name + "§f)"); 
/*     */               break;
/*     */             case 102846135:
/*     */               if (str1.equals("leave"))
/*     */                 ClientUtils.displayChatMessage("§bXSJ Client §8[§eWARNING§8] §6删除无敌人: " + name); 
/*     */               break;
/*     */             case 110119:
/*     */               if (str1.equals("old"))
/*     */                 ClientUtils.displayChatMessage("§8[§c§lXSJ Client§8] §d删除无敌人：§7" + name); 
/*     */               break;
/*     */             case 112906141:
/*     */               if (str1.equals("wawa1"))
/*     */                 ClientUtils.displayChatMessage("§6XSJ Client §7=> §fRemoved Bot §7" + name + "§f."); 
/*     */               break;
/*     */             case 840649778:
/*     */               if (str1.equals("Retreatclient"))
/*     */                 ClientUtils.displayChatMessage("§7[§cAntiBots§7] §fRemoved a bot(§7" + name + "§f)"); 
/*     */               break;
/*     */             case 113135984:
/*     */               if (str1.equals("windx"))
/*     */                 ClientUtils.displayChatMessage("§7[§c!§7] §bColorByte §aClient §7=> §cRemoved §fa bot(§7" + name + "§f)"); 
/*     */               break;
/*     */           } 
/*     */         } 
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   private final void clearAll() {
/*     */     (Retreat.INSTANCE.getFileManager()).friendsConfig.clearFriends();
/*     */     this.bots = 0;
/*     */   }
/*     */   
/*     */   private final String tagReturner() {
/*     */     String tag = "";
/*     */     if (((Boolean)this.sTHideAll.get()).booleanValue()) {
/*     */       tag = "";
/*     */     } else {
/*     */       if (!((Boolean)this.sTHideMode.get()).booleanValue())
/*     */         tag = (String)this.modeValue.get(); 
/*     */       if (!((Boolean)this.sTHideLogStyle.get()).booleanValue() && ((Boolean)this.printLoggerValue.get()).booleanValue())
/*     */         tag = ((Intrinsics.areEqual(tag, "") ^ true) != 0) ? (tag + ", " + (String)this.logStyleValue.get()) : (String)this.logStyleValue.get(); 
/*     */       if (!((Boolean)this.sTHideBotsCounter.get()).booleanValue()) {
/*     */         if ((Intrinsics.areEqual(tag, "") ^ true) != 0) {
/*     */           tag = tag + ", Bots: " + this.bots;
/*     */         } else {
/*     */           "Bots: " + this.bots;
/*     */         } 
/*     */       } else {
/*     */         String str = (String)this.sTHideBotsCounterSetting.get();
/*     */         boolean bool = false;
/*     */         if (str == null)
/*     */           throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */         Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()");
/*     */         if (Intrinsics.areEqual(str.toLowerCase(), "onlynumber"))
/*     */           if ((Intrinsics.areEqual(tag, "") ^ true) != 0) {
/*     */             tag = tag + ", " + this.bots;
/*     */           } else {
/*     */           
/*     */           }  
/*     */       } 
/*     */       if (((Boolean)this.autoSwitchLogger.get()).booleanValue() && !((Boolean)this.sTHideAllAutoSwitcher.get()).booleanValue()) {
/*     */         if ((Intrinsics.areEqual(tag, "") ^ true) != 0 && !((Boolean)this.sTHideAutoSwitcherState.get()).booleanValue())
/*     */           tag = tag + ", AutoSwitch:" + (((Boolean)this.autoSwitchLogger.get()).booleanValue() ? "On" : "Off"); 
/*     */         if (((Boolean)this.sTHideAutoSwitcherState.get()).booleanValue()) {
/*     */           String str = (String)this.sTHideAutoSwitcherStateSetting.get();
/*     */           boolean bool = false;
/*     */           if (str == null)
/*     */             throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */           Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()");
/*     */           if (Intrinsics.areEqual(str.toLowerCase(), "onlyshowstate"))
/*     */             tag = ((Intrinsics.areEqual(tag, "") ^ true) != 0) ? (tag + ", " + (((Boolean)this.autoSwitchLogger.get()).booleanValue() ? "On" : "Off")) : (((Boolean)this.autoSwitchLogger.get()).booleanValue() ? "On" : "Off"); 
/*     */         } 
/*     */         if (!((Boolean)this.sTHideAutoSwitcherMode.get()).booleanValue())
/*     */           tag = ((Intrinsics.areEqual(tag, "") ^ true) != 0) ? (tag + ", " + (String)this.autoSwitchModeValue.get()) : (String)this.autoSwitchModeValue.get(); 
/*     */         if (!((Boolean)this.sTHideAutoSwitcherDelay.get()).booleanValue())
/*     */           tag = ((Intrinsics.areEqual(tag, "") ^ true) != 0) ? (tag + ", " + ((Number)this.autoSwitchDelay.get()).intValue()) : String.valueOf(((Number)this.autoSwitchDelay.get()).intValue()); 
/*     */       } 
/*     */     } 
/*     */     return tag;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public String getTag() {
/*     */     return !((Boolean)this.sTHideAll.get()).booleanValue() ? tagReturner() : null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\misc\AntiFakePlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */