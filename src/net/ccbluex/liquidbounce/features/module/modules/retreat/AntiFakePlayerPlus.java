/*     */ package net.ccbluex.liquidbounce.features.module.modules.retreat;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ModuleInfo(name = "AntiFakePlayerPlus", description = "AntiBot in HuaYuTing. Skid By 凡哥", category = ModuleCategory.RETREAT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\\\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\013\n\002\020\021\n\002\020\016\n\002\b\006\n\002\030\002\n\002\b\025\n\002\020\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\t\n\002\b\004\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\0205\032\00206H\002J\b\0207\032\00206H\027J\020\0208\032\002062\006\0209\032\0020:H\007J\020\020;\032\002062\006\0209\032\0020<H\007J\030\020=\032\002062\006\020>\032\0020\0312\006\020?\032\0020@H\002J\020\020A\032\002062\006\0209\032\0020:H\002J\030\020\"\032\002062\006\020>\032\0020\0312\006\020B\032\0020\031H\002J\b\020C\032\0020\031H\002R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\004X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\n\032\0020\tX\004¢\006\002\n\000R\016\020\013\032\0020\fX\016¢\006\002\n\000R\016\020\r\032\0020\004X\004¢\006\002\n\000R\016\020\016\032\0020\004X\004¢\006\002\n\000R\016\020\017\032\0020\004X\004¢\006\002\n\000R\016\020\020\032\0020\004X\004¢\006\002\n\000R\016\020\021\032\0020\004X\004¢\006\002\n\000R\016\020\022\032\0020\004X\004¢\006\002\n\000R\016\020\023\032\0020\004X\004¢\006\002\n\000R\016\020\024\032\0020\004X\004¢\006\002\n\000R\016\020\025\032\0020\004X\004¢\006\002\n\000R\016\020\026\032\0020\006X\004¢\006\002\n\000R\026\020\027\032\b\022\004\022\0020\0310\030X\004¢\006\004\n\002\020\032R\026\020\033\032\b\022\004\022\0020\0310\030X\004¢\006\004\n\002\020\032R\016\020\034\032\0020\fX\016¢\006\002\n\000R\016\020\035\032\0020\tX\004¢\006\002\n\000R\026\020\036\032\b\022\004\022\0020\0310\030X\004¢\006\004\n\002\020\032R\016\020\037\032\0020 X\004¢\006\002\n\000R\026\020!\032\b\022\004\022\0020\0310\030X\004¢\006\004\n\002\020\032R\016\020\"\032\0020\004X\004¢\006\002\n\000R\016\020#\032\0020\004X\004¢\006\002\n\000R\016\020$\032\0020\031X\016¢\006\002\n\000R\016\020%\032\0020\004X\004¢\006\002\n\000R\016\020&\032\0020\004X\004¢\006\002\n\000R\016\020'\032\0020\004X\004¢\006\002\n\000R\016\020(\032\0020\004X\004¢\006\002\n\000R\016\020)\032\0020\004X\004¢\006\002\n\000R\016\020*\032\0020\tX\004¢\006\002\n\000R\016\020+\032\0020\004X\004¢\006\002\n\000R\016\020,\032\0020\tX\004¢\006\002\n\000R\016\020-\032\0020\004X\004¢\006\002\n\000R\016\020.\032\0020\004X\004¢\006\002\n\000R\016\020/\032\0020\004X\004¢\006\002\n\000R\016\0200\032\0020\004X\004¢\006\002\n\000R\016\0201\032\0020\004X\004¢\006\002\n\000R\026\0202\032\004\030\0010\0318VX\004¢\006\006\032\004\b3\0204¨\006D"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/retreat/AntiFakePlayerPlus;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "autoBotGetter", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "autoSwitchDelay", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "autoSwitchLogger", "autoSwitchMode", "Lnet/ccbluex/liquidbounce/value/ListValue;", "botGetterModeValue", "bots", "", "hideKillChatValue", "hideKitCoinGetChat", "hideKitDeathStreakChat", "hideKitSkillChat", "hideKitSpecialDeathChat", "hideKitUpgradeChat", "hideMultiKillChat", "hideValue", "isFriendDebuggerChat", "kitCustomDelay", "kitSpecialDeathChats", "", "", "[Ljava/lang/String;", "kitSpecialSkillChats", "logNumber", "logStyleValue", "logStyles", "ms", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "multiKillMessageList", "printLogger", "protectDeadPlayerName", "protectedname", "sTHideAll", "sTHideAllAutoSwitcher", "sTHideAutoSwitcherDelay", "sTHideAutoSwitcherMode", "sTHideAutoSwitcherState", "sTHideAutoSwitcherStateSetting", "sTHideBotsCounter", "sTHideBotsCounterSetting", "sTHideLogStyle", "sTHideMode", "showHideChat", "showMyKillDeathChatValue", "showMyMultiKillChat", "tag", "getTag", "()Ljava/lang/String;", "clearAll", "", "onDisable", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "playerDeathAction", "name", "cd", "", "playerDeathMsgAction", "mode", "tagReturner", "XSJClient"})
/*     */ public final class AntiFakePlayerPlus
/*     */   extends Module
/*     */ {
/*  69 */   private final String[] logStyles = new String[] { 
/*  70 */       "RyFNew", 
/*  71 */       "FDPAntibot", 
/*  72 */       "FDPChat", 
/*  73 */       "Leave", 
/*  74 */       "Special", 
/*  75 */       "Special2", 
/*  76 */       "Shitty", 
/*  77 */       "WaWa1", 
/*  78 */       "WaWa2", 
/*  79 */       "WaWa3", 
/*  80 */       "NullClient", 
/*  81 */       "Normal", 
/*  82 */       "WindX", 
/*  83 */       "Old", 
/*  84 */       "Old1", 
/*  85 */       "Arene" };
/*     */   
/*  87 */   private final String[] multiKillMessageList = new String[] {
/*  88 */       "正在大杀特杀！", 
/*  89 */       "主宰服务器！", 
/*  90 */       "杀人如麻！", 
/*  91 */       "无人能挡！", 
/*  92 */       "杀得变态了！", 
/*  93 */       "正在像妖怪般杀戮！", 
/*  94 */       "如同神一般！", 
/*  95 */       "已经超越神了！拜托谁去杀了他吧！"
/*     */     };
/*  97 */   private final String[] kitSpecialDeathChats = new String[] {
/*  98 */       "走着走着突然暴毙了!", 
/*  99 */       "Boom！！!", 
/* 100 */       "", 
/* 101 */       ""
/*     */     };
/* 103 */   private final String[] kitSpecialSkillChats = new String[] {
/* 104 */       "对你眨眼了!", 
/* 105 */       "诅咒了!", 
/* 106 */       "并没有使用作弊!", 
/* 107 */       "", 
/* 108 */       ""
/*     */     };
/*     */ 
/*     */   
/* 112 */   private final ListValue botGetterModeValue = new ListValue("Mode", new String[] { "4v4/2v2/1v1", "BWXP32", "BWXP16", "KitBattle" }, "4V4/2v2/1V1");
/*     */ 
/*     */   
/* 115 */   private final BoolValue autoBotGetter = new BoolValue("AutoSwitchMode(Test", false);
/*     */ 
/*     */   
/* 118 */   private final BoolValue isFriendDebuggerChat = new BoolValue("isFriendDebuggerChat", false);
/*     */ 
/*     */   
/* 121 */   private final BoolValue printLogger = new BoolValue("ShowChatMessage", false);
/* 122 */   private final ListValue logStyleValue = new ListValue("LogStyle", this.logStyles, "Normal");
/*     */ 
/*     */   
/* 125 */   private final BoolValue hideKillChatValue = new BoolValue("HideKillChat", false);
/* 126 */   private final BoolValue showMyKillDeathChatValue = new BoolValue("ShowMyKillDeathChat", false);
/*     */ 
/*     */   
/* 129 */   private final IntegerValue kitCustomDelay = new IntegerValue("KitCustomDelay", 4700, 4000, 8000);
/*     */   
/* 131 */   private final BoolValue hideKitCoinGetChat = new BoolValue("HideKitBattleCoinChat", true);
/*     */   
/* 133 */   private final BoolValue hideKitDeathStreakChat = new BoolValue("HideKitDeathStreakChat", false);
/*     */   
/* 135 */   private final BoolValue hideKitSpecialDeathChat = new BoolValue("HideKitSpecialDeathChat", false);
/*     */   
/* 137 */   private final BoolValue hideKitSkillChat = new BoolValue("HideKitSkillChat", false);
/* 138 */   private final BoolValue hideKitUpgradeChat = new BoolValue("HideKitUpgradeChat", false);
/*     */ 
/*     */   
/* 141 */   private final BoolValue hideMultiKillChat = new BoolValue("HideMultiKillChat", true);
/* 142 */   private final BoolValue showMyMultiKillChat = new BoolValue("ShowMyMultiKillChat", true);
/*     */ 
/*     */   
/* 145 */   private final BoolValue protectDeadPlayerName = new BoolValue("ShittyNameProtect(OnlyEnglish", false);
/*     */ 
/*     */   
/* 148 */   private final BoolValue hideValue = new BoolValue("IgnoreAntiGetname", false);
/* 149 */   private final BoolValue showHideChat = new BoolValue("IgnoredChat", false);
/*     */ 
/*     */   
/* 152 */   private final BoolValue autoSwitchLogger = new BoolValue("AutoSwitchLogger", false);
/* 153 */   private final ListValue autoSwitchMode = new ListValue("AutoSwitchMode", new String[] {
/* 154 */         "Random", 
/* 155 */         "List"
/* 156 */       }, "Random");
/* 157 */   private final IntegerValue autoSwitchDelay = new IntegerValue("AutoSwitchDelay", 3000, 1500, 7000);
/*     */ 
/*     */ 
/*     */   
/* 161 */   private final BoolValue sTHideAll = new BoolValue("HideAllTag", false);
/*     */ 
/*     */   
/* 164 */   private final BoolValue sTHideMode = new BoolValue("HideMode", false);
/*     */ 
/*     */   
/* 167 */   private final BoolValue sTHideLogStyle = new BoolValue("HideLogStyle", false);
/*     */ 
/*     */   
/* 170 */   private final BoolValue sTHideBotsCounter = new BoolValue("HideBotsCounter", false);
/*     */   
/* 172 */   private final ListValue sTHideBotsCounterSetting = new ListValue("HideBotsCounterMode", new String[] { "FullHide", "OnlyNumber" }, "OnlyNumber");
/*     */ 
/*     */   
/* 175 */   private final BoolValue sTHideAllAutoSwitcher = new BoolValue("HideAllAutoSwitcher", false);
/*     */ 
/*     */   
/* 178 */   private final BoolValue sTHideAutoSwitcherState = new BoolValue("HideAutoSwitcherState", false);
/*     */   
/* 180 */   private final ListValue sTHideAutoSwitcherStateSetting = new ListValue("HideAutoSwitcherMode", new String[] { "FullHide", "OnlyShowState" }, "FullHide");
/*     */ 
/*     */   
/* 183 */   private final BoolValue sTHideAutoSwitcherMode = new BoolValue("HideAutoSwitcherMode", false);
/*     */ 
/*     */   
/* 186 */   private final BoolValue sTHideAutoSwitcherDelay = new BoolValue("HideAutoSwitcherDelay", false);
/*     */   
/*     */   private int bots;
/*     */   
/*     */   private int logNumber;
/* 191 */   private final MSTimer ms = new MSTimer();
/* 192 */   private String protectedname = "";
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public void onDisable() {
/* 197 */     this.bots = 0;
/* 198 */     clearAll();
/* 199 */     super.onDisable();
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
/*     */     //   40: ifeq -> 1023
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
/*     */     //   81: ifne -> 1023
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
/*     */     //   186: ifeq -> 1023
/*     */     //   189: aload_2
/*     */     //   190: checkcast net/minecraft/network/play/server/SPacketChat
/*     */     //   193: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   196: dup
/*     */     //   197: ldc 'packet.chatComponent'
/*     */     //   199: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   202: invokeinterface func_150260_c : ()Ljava/lang/String;
/*     */     //   207: astore_3
/*     */     //   208: aload_0
/*     */     //   209: getfield botGetterModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
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
/*     */     //   255: lookupswitch default -> 1023, -1375727374 -> 296, -1375727316 -> 322, 699818926 -> 309, 957413134 -> 335
/*     */     //   296: aload #4
/*     */     //   298: ldc 'bwxp16'
/*     */     //   300: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   303: ifeq -> 1023
/*     */     //   306: goto -> 674
/*     */     //   309: aload #4
/*     */     //   311: ldc '4v4/2v2/1v1'
/*     */     //   313: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   316: ifeq -> 1023
/*     */     //   319: goto -> 348
/*     */     //   322: aload #4
/*     */     //   324: ldc 'bwxp32'
/*     */     //   326: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   329: ifeq -> 1023
/*     */     //   332: goto -> 511
/*     */     //   335: aload #4
/*     */     //   337: ldc 'kitbattle'
/*     */     //   339: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   342: ifeq -> 1023
/*     */     //   345: goto -> 839
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
/*     */     //   376: aload #5
/*     */     //   378: invokevirtual find : ()Z
/*     */     //   381: ifeq -> 442
/*     */     //   384: aload #5
/*     */     //   386: iconst_1
/*     */     //   387: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   390: dup
/*     */     //   391: ldc 'matcher.group(1)'
/*     */     //   393: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   396: astore #8
/*     */     //   398: iconst_0
/*     */     //   399: istore #9
/*     */     //   401: aload #8
/*     */     //   403: dup
/*     */     //   404: ifnonnull -> 417
/*     */     //   407: new kotlin/TypeCastException
/*     */     //   410: dup
/*     */     //   411: ldc 'null cannot be cast to non-null type kotlin.CharSequence'
/*     */     //   413: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   416: athrow
/*     */     //   417: checkcast java/lang/CharSequence
/*     */     //   420: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
/*     */     //   423: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   426: astore #7
/*     */     //   428: aload_0
/*     */     //   429: aload #7
/*     */     //   431: ldc2_w 4988
/*     */     //   434: invokespecial playerDeathAction : (Ljava/lang/String;J)V
/*     */     //   437: aload_0
/*     */     //   438: aload_1
/*     */     //   439: invokespecial playerDeathMsgAction : (Lnet/ccbluex/liquidbounce/event/PacketEvent;)V
/*     */     //   442: aload #6
/*     */     //   444: invokevirtual find : ()Z
/*     */     //   447: ifeq -> 1023
/*     */     //   450: aload #6
/*     */     //   452: iconst_1
/*     */     //   453: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   456: dup
/*     */     //   457: ldc 'matcher2.group(1)'
/*     */     //   459: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   462: astore #8
/*     */     //   464: iconst_0
/*     */     //   465: istore #9
/*     */     //   467: aload #8
/*     */     //   469: dup
/*     */     //   470: ifnonnull -> 483
/*     */     //   473: new kotlin/TypeCastException
/*     */     //   476: dup
/*     */     //   477: ldc 'null cannot be cast to non-null type kotlin.CharSequence'
/*     */     //   479: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   482: athrow
/*     */     //   483: checkcast java/lang/CharSequence
/*     */     //   486: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
/*     */     //   489: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   492: astore #7
/*     */     //   494: aload_0
/*     */     //   495: aload #7
/*     */     //   497: ldc2_w 4988
/*     */     //   500: invokespecial playerDeathAction : (Ljava/lang/String;J)V
/*     */     //   503: aload_0
/*     */     //   504: aload_1
/*     */     //   505: invokespecial playerDeathMsgAction : (Lnet/ccbluex/liquidbounce/event/PacketEvent;)V
/*     */     //   508: goto -> 1023
/*     */     //   511: ldc '杀死了 (.*?)\('
/*     */     //   513: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
/*     */     //   516: aload_3
/*     */     //   517: checkcast java/lang/CharSequence
/*     */     //   520: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   523: astore #5
/*     */     //   525: ldc '起床战争 >> (.*?) (\(((.*?)死了!))'
/*     */     //   527: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
/*     */     //   530: aload_3
/*     */     //   531: checkcast java/lang/CharSequence
/*     */     //   534: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   537: astore #6
/*     */     //   539: aload #5
/*     */     //   541: invokevirtual find : ()Z
/*     */     //   544: ifeq -> 605
/*     */     //   547: aload #5
/*     */     //   549: iconst_1
/*     */     //   550: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   553: dup
/*     */     //   554: ldc 'matcher.group(1)'
/*     */     //   556: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   559: astore #8
/*     */     //   561: iconst_0
/*     */     //   562: istore #9
/*     */     //   564: aload #8
/*     */     //   566: dup
/*     */     //   567: ifnonnull -> 580
/*     */     //   570: new kotlin/TypeCastException
/*     */     //   573: dup
/*     */     //   574: ldc 'null cannot be cast to non-null type kotlin.CharSequence'
/*     */     //   576: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   579: athrow
/*     */     //   580: checkcast java/lang/CharSequence
/*     */     //   583: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
/*     */     //   586: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   589: astore #7
/*     */     //   591: aload_0
/*     */     //   592: aload #7
/*     */     //   594: ldc2_w 7400
/*     */     //   597: invokespecial playerDeathAction : (Ljava/lang/String;J)V
/*     */     //   600: aload_0
/*     */     //   601: aload_1
/*     */     //   602: invokespecial playerDeathMsgAction : (Lnet/ccbluex/liquidbounce/event/PacketEvent;)V
/*     */     //   605: aload #6
/*     */     //   607: invokevirtual find : ()Z
/*     */     //   610: ifeq -> 1023
/*     */     //   613: aload #6
/*     */     //   615: iconst_1
/*     */     //   616: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   619: dup
/*     */     //   620: ldc 'matcher2.group(1)'
/*     */     //   622: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   625: astore #8
/*     */     //   627: iconst_0
/*     */     //   628: istore #9
/*     */     //   630: aload #8
/*     */     //   632: dup
/*     */     //   633: ifnonnull -> 646
/*     */     //   636: new kotlin/TypeCastException
/*     */     //   639: dup
/*     */     //   640: ldc 'null cannot be cast to non-null type kotlin.CharSequence'
/*     */     //   642: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   645: athrow
/*     */     //   646: checkcast java/lang/CharSequence
/*     */     //   649: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
/*     */     //   652: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   655: astore #7
/*     */     //   657: aload_0
/*     */     //   658: aload #7
/*     */     //   660: ldc2_w 4988
/*     */     //   663: invokespecial playerDeathAction : (Ljava/lang/String;J)V
/*     */     //   666: aload_0
/*     */     //   667: aload_1
/*     */     //   668: invokespecial playerDeathMsgAction : (Lnet/ccbluex/liquidbounce/event/PacketEvent;)V
/*     */     //   671: goto -> 1023
/*     */     //   674: ldc_w '击败了 (.*?)!'
/*     */     //   677: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
/*     */     //   680: aload_3
/*     */     //   681: checkcast java/lang/CharSequence
/*     */     //   684: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   687: astore #5
/*     */     //   689: ldc_w '玩家 (.*?)死了！'
/*     */     //   692: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
/*     */     //   695: aload_3
/*     */     //   696: checkcast java/lang/CharSequence
/*     */     //   699: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   702: astore #6
/*     */     //   704: aload #5
/*     */     //   706: invokevirtual find : ()Z
/*     */     //   709: ifeq -> 770
/*     */     //   712: aload #5
/*     */     //   714: iconst_1
/*     */     //   715: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   718: dup
/*     */     //   719: ldc 'matcher.group(1)'
/*     */     //   721: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   724: astore #8
/*     */     //   726: iconst_0
/*     */     //   727: istore #9
/*     */     //   729: aload #8
/*     */     //   731: dup
/*     */     //   732: ifnonnull -> 745
/*     */     //   735: new kotlin/TypeCastException
/*     */     //   738: dup
/*     */     //   739: ldc 'null cannot be cast to non-null type kotlin.CharSequence'
/*     */     //   741: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   744: athrow
/*     */     //   745: checkcast java/lang/CharSequence
/*     */     //   748: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
/*     */     //   751: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   754: astore #7
/*     */     //   756: aload_0
/*     */     //   757: aload #7
/*     */     //   759: ldc2_w 9700
/*     */     //   762: invokespecial playerDeathAction : (Ljava/lang/String;J)V
/*     */     //   765: aload_0
/*     */     //   766: aload_1
/*     */     //   767: invokespecial playerDeathMsgAction : (Lnet/ccbluex/liquidbounce/event/PacketEvent;)V
/*     */     //   770: aload #6
/*     */     //   772: invokevirtual find : ()Z
/*     */     //   775: ifeq -> 1023
/*     */     //   778: aload #6
/*     */     //   780: iconst_1
/*     */     //   781: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   784: dup
/*     */     //   785: ldc 'matcher2.group(1)'
/*     */     //   787: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   790: astore #8
/*     */     //   792: iconst_0
/*     */     //   793: istore #9
/*     */     //   795: aload #8
/*     */     //   797: dup
/*     */     //   798: ifnonnull -> 811
/*     */     //   801: new kotlin/TypeCastException
/*     */     //   804: dup
/*     */     //   805: ldc 'null cannot be cast to non-null type kotlin.CharSequence'
/*     */     //   807: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   810: athrow
/*     */     //   811: checkcast java/lang/CharSequence
/*     */     //   814: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
/*     */     //   817: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   820: astore #7
/*     */     //   822: aload_0
/*     */     //   823: aload #7
/*     */     //   825: ldc2_w 9700
/*     */     //   828: invokespecial playerDeathAction : (Ljava/lang/String;J)V
/*     */     //   831: aload_0
/*     */     //   832: aload_1
/*     */     //   833: invokespecial playerDeathMsgAction : (Lnet/ccbluex/liquidbounce/event/PacketEvent;)V
/*     */     //   836: goto -> 1023
/*     */     //   839: ldc_w '击杀了(.*?) !'
/*     */     //   842: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
/*     */     //   845: aload_3
/*     */     //   846: checkcast java/lang/CharSequence
/*     */     //   849: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   852: astore #5
/*     */     //   854: ldc_w '花雨庭 >>(.*?) 被'
/*     */     //   857: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
/*     */     //   860: aload_3
/*     */     //   861: checkcast java/lang/CharSequence
/*     */     //   864: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   867: astore #6
/*     */     //   869: aload #5
/*     */     //   871: invokevirtual find : ()Z
/*     */     //   874: ifeq -> 946
/*     */     //   877: aload #5
/*     */     //   879: iconst_1
/*     */     //   880: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   883: dup
/*     */     //   884: ldc 'matcher.group(1)'
/*     */     //   886: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   889: astore #8
/*     */     //   891: iconst_0
/*     */     //   892: istore #9
/*     */     //   894: aload #8
/*     */     //   896: dup
/*     */     //   897: ifnonnull -> 910
/*     */     //   900: new kotlin/TypeCastException
/*     */     //   903: dup
/*     */     //   904: ldc 'null cannot be cast to non-null type kotlin.CharSequence'
/*     */     //   906: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   909: athrow
/*     */     //   910: checkcast java/lang/CharSequence
/*     */     //   913: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
/*     */     //   916: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   919: astore #7
/*     */     //   921: aload_0
/*     */     //   922: aload #7
/*     */     //   924: aload_0
/*     */     //   925: getfield kitCustomDelay : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   928: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   931: checkcast java/lang/Number
/*     */     //   934: invokevirtual intValue : ()I
/*     */     //   937: i2l
/*     */     //   938: invokespecial playerDeathAction : (Ljava/lang/String;J)V
/*     */     //   941: aload_0
/*     */     //   942: aload_1
/*     */     //   943: invokespecial playerDeathMsgAction : (Lnet/ccbluex/liquidbounce/event/PacketEvent;)V
/*     */     //   946: aload #6
/*     */     //   948: invokevirtual find : ()Z
/*     */     //   951: ifeq -> 1023
/*     */     //   954: aload #6
/*     */     //   956: iconst_1
/*     */     //   957: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   960: dup
/*     */     //   961: ldc 'matcher2.group(1)'
/*     */     //   963: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   966: astore #8
/*     */     //   968: iconst_0
/*     */     //   969: istore #9
/*     */     //   971: aload #8
/*     */     //   973: dup
/*     */     //   974: ifnonnull -> 987
/*     */     //   977: new kotlin/TypeCastException
/*     */     //   980: dup
/*     */     //   981: ldc 'null cannot be cast to non-null type kotlin.CharSequence'
/*     */     //   983: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   986: athrow
/*     */     //   987: checkcast java/lang/CharSequence
/*     */     //   990: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
/*     */     //   993: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   996: astore #7
/*     */     //   998: aload_0
/*     */     //   999: aload #7
/*     */     //   1001: aload_0
/*     */     //   1002: getfield kitCustomDelay : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1005: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1008: checkcast java/lang/Number
/*     */     //   1011: invokevirtual intValue : ()I
/*     */     //   1014: i2l
/*     */     //   1015: invokespecial playerDeathAction : (Ljava/lang/String;J)V
/*     */     //   1018: aload_0
/*     */     //   1019: aload_1
/*     */     //   1020: invokespecial playerDeathMsgAction : (Lnet/ccbluex/liquidbounce/event/PacketEvent;)V
/*     */     //   1023: aload_2
/*     */     //   1024: instanceof net/minecraft/network/play/server/SPacketChat
/*     */     //   1027: ifeq -> 1315
/*     */     //   1030: aload_2
/*     */     //   1031: checkcast net/minecraft/network/play/server/SPacketChat
/*     */     //   1034: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   1037: dup
/*     */     //   1038: ldc 'packet.chatComponent'
/*     */     //   1040: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1043: invokeinterface func_150260_c : ()Ljava/lang/String;
/*     */     //   1048: dup
/*     */     //   1049: ldc 'packet.chatComponent.unformattedText'
/*     */     //   1051: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1054: checkcast java/lang/CharSequence
/*     */     //   1057: ldc ':'
/*     */     //   1059: checkcast java/lang/CharSequence
/*     */     //   1062: iconst_0
/*     */     //   1063: iconst_2
/*     */     //   1064: aconst_null
/*     */     //   1065: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1068: ifeq -> 1315
/*     */     //   1071: aload_2
/*     */     //   1072: checkcast net/minecraft/network/play/server/SPacketChat
/*     */     //   1075: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   1078: dup
/*     */     //   1079: ldc 'packet.chatComponent'
/*     */     //   1081: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1084: invokeinterface func_150260_c : ()Ljava/lang/String;
/*     */     //   1089: dup
/*     */     //   1090: ldc 'packet.chatComponent.unformattedText'
/*     */     //   1092: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1095: checkcast java/lang/CharSequence
/*     */     //   1098: new java/lang/StringBuilder
/*     */     //   1101: dup
/*     */     //   1102: invokespecial <init> : ()V
/*     */     //   1105: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1108: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1113: dup
/*     */     //   1114: ifnonnull -> 1120
/*     */     //   1117: invokestatic throwNpe : ()V
/*     */     //   1120: invokeinterface getDisplayNameString : ()Ljava/lang/String;
/*     */     //   1125: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1128: ldc ':'
/*     */     //   1130: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1133: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1136: checkcast java/lang/CharSequence
/*     */     //   1139: iconst_0
/*     */     //   1140: iconst_2
/*     */     //   1141: aconst_null
/*     */     //   1142: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1145: ifne -> 1315
/*     */     //   1148: aload_2
/*     */     //   1149: checkcast net/minecraft/network/play/server/SPacketChat
/*     */     //   1152: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   1155: dup
/*     */     //   1156: ldc 'packet.chatComponent'
/*     */     //   1158: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1161: invokeinterface func_150260_c : ()Ljava/lang/String;
/*     */     //   1166: dup
/*     */     //   1167: ldc 'packet.chatComponent.unformattedText'
/*     */     //   1169: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1172: checkcast java/lang/CharSequence
/*     */     //   1175: ldc '起床战争'
/*     */     //   1177: checkcast java/lang/CharSequence
/*     */     //   1180: iconst_0
/*     */     //   1181: iconst_2
/*     */     //   1182: aconst_null
/*     */     //   1183: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1186: ifeq -> 1315
/*     */     //   1189: aload_2
/*     */     //   1190: checkcast net/minecraft/network/play/server/SPacketChat
/*     */     //   1193: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   1196: dup
/*     */     //   1197: ldc 'packet.chatComponent'
/*     */     //   1199: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1202: invokeinterface func_150260_c : ()Ljava/lang/String;
/*     */     //   1207: dup
/*     */     //   1208: ldc 'packet.chatComponent.unformattedText'
/*     */     //   1210: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1213: checkcast java/lang/CharSequence
/*     */     //   1216: ldc_w '01:00:00 是这个地图的记录!'
/*     */     //   1219: checkcast java/lang/CharSequence
/*     */     //   1222: iconst_0
/*     */     //   1223: iconst_2
/*     */     //   1224: aconst_null
/*     */     //   1225: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1228: ifne -> 1315
/*     */     //   1231: aload_2
/*     */     //   1232: checkcast net/minecraft/network/play/server/SPacketChat
/*     */     //   1235: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   1238: dup
/*     */     //   1239: ldc 'packet.chatComponent'
/*     */     //   1241: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1244: invokeinterface func_150260_c : ()Ljava/lang/String;
/*     */     //   1249: dup
/*     */     //   1250: ldc 'packet.chatComponent.unformattedText'
/*     */     //   1252: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1255: checkcast java/lang/CharSequence
/*     */     //   1258: ldc_w '之队队设置一个新的记录:'
/*     */     //   1261: checkcast java/lang/CharSequence
/*     */     //   1264: iconst_0
/*     */     //   1265: iconst_2
/*     */     //   1266: aconst_null
/*     */     //   1267: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1270: ifne -> 1315
/*     */     //   1273: aload_0
/*     */     //   1274: getfield hideValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1277: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1280: checkcast java/lang/Boolean
/*     */     //   1283: invokevirtual booleanValue : ()Z
/*     */     //   1286: ifeq -> 1315
/*     */     //   1289: aload_1
/*     */     //   1290: invokevirtual cancelEvent : ()V
/*     */     //   1293: aload_0
/*     */     //   1294: getfield showHideChat : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1297: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1300: checkcast java/lang/Boolean
/*     */     //   1303: invokevirtual booleanValue : ()Z
/*     */     //   1306: ifeq -> 1315
/*     */     //   1309: ldc_w '§bXSJ Client §7» §c隐藏了AntiGetname消息。'
/*     */     //   1312: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   1315: aload_2
/*     */     //   1316: instanceof net/minecraft/network/play/server/SPacketChat
/*     */     //   1319: ifeq -> 1481
/*     */     //   1322: aload_2
/*     */     //   1323: checkcast net/minecraft/network/play/server/SPacketChat
/*     */     //   1326: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   1329: dup
/*     */     //   1330: ldc 'packet.chatComponent'
/*     */     //   1332: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1335: invokeinterface func_150260_c : ()Ljava/lang/String;
/*     */     //   1340: astore_3
/*     */     //   1341: aload_0
/*     */     //   1342: getfield multiKillMessageList : [Ljava/lang/String;
/*     */     //   1345: astore #6
/*     */     //   1347: aload #6
/*     */     //   1349: arraylength
/*     */     //   1350: istore #7
/*     */     //   1352: iconst_0
/*     */     //   1353: istore #5
/*     */     //   1355: iload #5
/*     */     //   1357: iload #7
/*     */     //   1359: if_icmpge -> 1481
/*     */     //   1362: aload #6
/*     */     //   1364: iload #5
/*     */     //   1366: aaload
/*     */     //   1367: astore #4
/*     */     //   1369: aload_3
/*     */     //   1370: dup
/*     */     //   1371: ldc_w 'chat'
/*     */     //   1374: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1377: checkcast java/lang/CharSequence
/*     */     //   1380: aload #4
/*     */     //   1382: checkcast java/lang/CharSequence
/*     */     //   1385: iconst_0
/*     */     //   1386: iconst_2
/*     */     //   1387: aconst_null
/*     */     //   1388: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1391: ifne -> 1403
/*     */     //   1394: aload_3
/*     */     //   1395: aload #4
/*     */     //   1397: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1400: ifeq -> 1475
/*     */     //   1403: aload_0
/*     */     //   1404: getfield showMyMultiKillChat : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1407: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1410: checkcast java/lang/Boolean
/*     */     //   1413: invokevirtual booleanValue : ()Z
/*     */     //   1416: ifeq -> 1455
/*     */     //   1419: aload_3
/*     */     //   1420: checkcast java/lang/CharSequence
/*     */     //   1423: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1426: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1431: dup
/*     */     //   1432: ifnonnull -> 1438
/*     */     //   1435: invokestatic throwNpe : ()V
/*     */     //   1438: invokeinterface getDisplayNameString : ()Ljava/lang/String;
/*     */     //   1443: checkcast java/lang/CharSequence
/*     */     //   1446: iconst_0
/*     */     //   1447: iconst_2
/*     */     //   1448: aconst_null
/*     */     //   1449: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1452: ifne -> 1475
/*     */     //   1455: aload_0
/*     */     //   1456: getfield hideMultiKillChat : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1459: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1462: checkcast java/lang/Boolean
/*     */     //   1465: invokevirtual booleanValue : ()Z
/*     */     //   1468: ifeq -> 1475
/*     */     //   1471: aload_1
/*     */     //   1472: invokevirtual cancelEvent : ()V
/*     */     //   1475: iinc #5, 1
/*     */     //   1478: goto -> 1355
/*     */     //   1481: aload_2
/*     */     //   1482: instanceof net/minecraft/network/play/server/SPacketChat
/*     */     //   1485: ifeq -> 2115
/*     */     //   1488: aload_2
/*     */     //   1489: checkcast net/minecraft/network/play/server/SPacketChat
/*     */     //   1492: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   1495: dup
/*     */     //   1496: ldc 'packet.chatComponent'
/*     */     //   1498: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1501: invokeinterface func_150260_c : ()Ljava/lang/String;
/*     */     //   1506: astore_3
/*     */     //   1507: aload_0
/*     */     //   1508: getfield botGetterModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   1511: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1514: checkcast java/lang/String
/*     */     //   1517: astore #4
/*     */     //   1519: iconst_0
/*     */     //   1520: istore #5
/*     */     //   1522: aload #4
/*     */     //   1524: dup
/*     */     //   1525: ifnonnull -> 1538
/*     */     //   1528: new kotlin/TypeCastException
/*     */     //   1531: dup
/*     */     //   1532: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   1534: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1537: athrow
/*     */     //   1538: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   1541: dup
/*     */     //   1542: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   1544: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1547: ldc 'kitbattle'
/*     */     //   1549: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   1552: ifeq -> 2115
/*     */     //   1555: aload_3
/*     */     //   1556: dup
/*     */     //   1557: ldc_w 'chat'
/*     */     //   1560: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1563: ldc '花雨庭'
/*     */     //   1565: iconst_0
/*     */     //   1566: iconst_2
/*     */     //   1567: aconst_null
/*     */     //   1568: invokestatic startsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*     */     //   1571: ifeq -> 2115
/*     */     //   1574: aload_0
/*     */     //   1575: getfield hideKitCoinGetChat : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1578: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1581: checkcast java/lang/Boolean
/*     */     //   1584: invokevirtual booleanValue : ()Z
/*     */     //   1587: ifeq -> 1670
/*     */     //   1590: aload_3
/*     */     //   1591: checkcast java/lang/CharSequence
/*     */     //   1594: ldc_w '花雨庭 >>你消灭'
/*     */     //   1597: checkcast java/lang/CharSequence
/*     */     //   1600: iconst_0
/*     */     //   1601: iconst_2
/*     */     //   1602: aconst_null
/*     */     //   1603: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1606: ifeq -> 1647
/*     */     //   1609: aload_3
/*     */     //   1610: checkcast java/lang/CharSequence
/*     */     //   1613: ldc_w '% 的伤害并且获得了'
/*     */     //   1616: checkcast java/lang/CharSequence
/*     */     //   1619: iconst_0
/*     */     //   1620: iconst_2
/*     */     //   1621: aconst_null
/*     */     //   1622: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1625: ifeq -> 1647
/*     */     //   1628: aload_3
/*     */     //   1629: checkcast java/lang/CharSequence
/*     */     //   1632: ldc_w '硬币!'
/*     */     //   1635: checkcast java/lang/CharSequence
/*     */     //   1638: iconst_0
/*     */     //   1639: iconst_2
/*     */     //   1640: aconst_null
/*     */     //   1641: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1644: ifne -> 1666
/*     */     //   1647: aload_3
/*     */     //   1648: checkcast java/lang/CharSequence
/*     */     //   1651: ldc_w '你的 coins 被修正为'
/*     */     //   1654: checkcast java/lang/CharSequence
/*     */     //   1657: iconst_0
/*     */     //   1658: iconst_2
/*     */     //   1659: aconst_null
/*     */     //   1660: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1663: ifeq -> 1670
/*     */     //   1666: aload_1
/*     */     //   1667: invokevirtual cancelEvent : ()V
/*     */     //   1670: aload_3
/*     */     //   1671: checkcast java/lang/CharSequence
/*     */     //   1674: ldc_w '花雨庭 >>'
/*     */     //   1677: checkcast java/lang/CharSequence
/*     */     //   1680: iconst_0
/*     */     //   1681: iconst_2
/*     */     //   1682: aconst_null
/*     */     //   1683: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1686: ifeq -> 1799
/*     */     //   1689: aload_3
/*     */     //   1690: checkcast java/lang/CharSequence
/*     */     //   1693: ldc_w '完成了'
/*     */     //   1696: checkcast java/lang/CharSequence
/*     */     //   1699: iconst_0
/*     */     //   1700: iconst_2
/*     */     //   1701: aconst_null
/*     */     //   1702: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1705: ifeq -> 1799
/*     */     //   1708: aload_3
/*     */     //   1709: checkcast java/lang/CharSequence
/*     */     //   1712: ldc_w '连杀!'
/*     */     //   1715: checkcast java/lang/CharSequence
/*     */     //   1718: iconst_0
/*     */     //   1719: iconst_2
/*     */     //   1720: aconst_null
/*     */     //   1721: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1724: ifeq -> 1799
/*     */     //   1727: aload_0
/*     */     //   1728: getfield showMyMultiKillChat : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1731: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1734: checkcast java/lang/Boolean
/*     */     //   1737: invokevirtual booleanValue : ()Z
/*     */     //   1740: ifeq -> 1779
/*     */     //   1743: aload_3
/*     */     //   1744: checkcast java/lang/CharSequence
/*     */     //   1747: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1750: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1755: dup
/*     */     //   1756: ifnonnull -> 1762
/*     */     //   1759: invokestatic throwNpe : ()V
/*     */     //   1762: invokeinterface getDisplayNameString : ()Ljava/lang/String;
/*     */     //   1767: checkcast java/lang/CharSequence
/*     */     //   1770: iconst_0
/*     */     //   1771: iconst_2
/*     */     //   1772: aconst_null
/*     */     //   1773: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1776: ifne -> 1799
/*     */     //   1779: aload_0
/*     */     //   1780: getfield hideMultiKillChat : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1783: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1786: checkcast java/lang/Boolean
/*     */     //   1789: invokevirtual booleanValue : ()Z
/*     */     //   1792: ifeq -> 1799
/*     */     //   1795: aload_1
/*     */     //   1796: invokevirtual cancelEvent : ()V
/*     */     //   1799: aload_3
/*     */     //   1800: checkcast java/lang/CharSequence
/*     */     //   1803: ldc_w '花雨庭 >>'
/*     */     //   1806: checkcast java/lang/CharSequence
/*     */     //   1809: iconst_0
/*     */     //   1810: iconst_2
/*     */     //   1811: aconst_null
/*     */     //   1812: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1815: ifeq -> 1914
/*     */     //   1818: aload_3
/*     */     //   1819: checkcast java/lang/CharSequence
/*     */     //   1822: ldc_w 'has ended his deathstreak and lost his buff'
/*     */     //   1825: checkcast java/lang/CharSequence
/*     */     //   1828: iconst_0
/*     */     //   1829: iconst_2
/*     */     //   1830: aconst_null
/*     */     //   1831: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1834: ifne -> 1894
/*     */     //   1837: aload_3
/*     */     //   1838: checkcast java/lang/CharSequence
/*     */     //   1841: ldc_w 'is now receiving a buff for his deathstreak'
/*     */     //   1844: checkcast java/lang/CharSequence
/*     */     //   1847: iconst_0
/*     */     //   1848: iconst_2
/*     */     //   1849: aconst_null
/*     */     //   1850: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1853: ifne -> 1894
/*     */     //   1856: aload_3
/*     */     //   1857: checkcast java/lang/CharSequence
/*     */     //   1860: ldc_w '终结了他的连续死亡'
/*     */     //   1863: checkcast java/lang/CharSequence
/*     */     //   1866: iconst_0
/*     */     //   1867: iconst_2
/*     */     //   1868: aconst_null
/*     */     //   1869: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1872: ifne -> 1894
/*     */     //   1875: aload_3
/*     */     //   1876: checkcast java/lang/CharSequence
/*     */     //   1879: ldc_w '获得了一个buff因为他刚刚完成了'
/*     */     //   1882: checkcast java/lang/CharSequence
/*     */     //   1885: iconst_0
/*     */     //   1886: iconst_2
/*     */     //   1887: aconst_null
/*     */     //   1888: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1891: ifeq -> 1914
/*     */     //   1894: aload_0
/*     */     //   1895: getfield hideKitDeathStreakChat : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1898: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1901: checkcast java/lang/Boolean
/*     */     //   1904: invokevirtual booleanValue : ()Z
/*     */     //   1907: ifeq -> 1914
/*     */     //   1910: aload_1
/*     */     //   1911: invokevirtual cancelEvent : ()V
/*     */     //   1914: aload_0
/*     */     //   1915: getfield kitSpecialDeathChats : [Ljava/lang/String;
/*     */     //   1918: astore #6
/*     */     //   1920: aload #6
/*     */     //   1922: arraylength
/*     */     //   1923: istore #7
/*     */     //   1925: iconst_0
/*     */     //   1926: istore #5
/*     */     //   1928: iload #5
/*     */     //   1930: iload #7
/*     */     //   1932: if_icmpge -> 1995
/*     */     //   1935: aload #6
/*     */     //   1937: iload #5
/*     */     //   1939: aaload
/*     */     //   1940: astore #4
/*     */     //   1942: aload_3
/*     */     //   1943: checkcast java/lang/CharSequence
/*     */     //   1946: aload #4
/*     */     //   1948: checkcast java/lang/CharSequence
/*     */     //   1951: iconst_0
/*     */     //   1952: iconst_2
/*     */     //   1953: aconst_null
/*     */     //   1954: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1957: ifne -> 1969
/*     */     //   1960: aload_3
/*     */     //   1961: aload #4
/*     */     //   1963: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1966: ifeq -> 1989
/*     */     //   1969: aload_0
/*     */     //   1970: getfield hideKitSpecialDeathChat : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1973: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1976: checkcast java/lang/Boolean
/*     */     //   1979: invokevirtual booleanValue : ()Z
/*     */     //   1982: ifeq -> 1989
/*     */     //   1985: aload_1
/*     */     //   1986: invokevirtual cancelEvent : ()V
/*     */     //   1989: iinc #5, 1
/*     */     //   1992: goto -> 1928
/*     */     //   1995: aload_0
/*     */     //   1996: getfield kitSpecialSkillChats : [Ljava/lang/String;
/*     */     //   1999: astore #6
/*     */     //   2001: aload #6
/*     */     //   2003: arraylength
/*     */     //   2004: istore #7
/*     */     //   2006: iconst_0
/*     */     //   2007: istore #5
/*     */     //   2009: iload #5
/*     */     //   2011: iload #7
/*     */     //   2013: if_icmpge -> 2076
/*     */     //   2016: aload #6
/*     */     //   2018: iload #5
/*     */     //   2020: aaload
/*     */     //   2021: astore #4
/*     */     //   2023: aload_3
/*     */     //   2024: checkcast java/lang/CharSequence
/*     */     //   2027: aload #4
/*     */     //   2029: checkcast java/lang/CharSequence
/*     */     //   2032: iconst_0
/*     */     //   2033: iconst_2
/*     */     //   2034: aconst_null
/*     */     //   2035: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   2038: ifne -> 2050
/*     */     //   2041: aload_3
/*     */     //   2042: aload #4
/*     */     //   2044: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   2047: ifeq -> 2070
/*     */     //   2050: aload_0
/*     */     //   2051: getfield hideKitSkillChat : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   2054: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2057: checkcast java/lang/Boolean
/*     */     //   2060: invokevirtual booleanValue : ()Z
/*     */     //   2063: ifeq -> 2070
/*     */     //   2066: aload_1
/*     */     //   2067: invokevirtual cancelEvent : ()V
/*     */     //   2070: iinc #5, 1
/*     */     //   2073: goto -> 2009
/*     */     //   2076: aload_0
/*     */     //   2077: getfield hideKitUpgradeChat : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   2080: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2083: checkcast java/lang/Boolean
/*     */     //   2086: invokevirtual booleanValue : ()Z
/*     */     //   2089: ifeq -> 2115
/*     */     //   2092: aload_3
/*     */     //   2093: checkcast java/lang/CharSequence
/*     */     //   2096: ldc_w '通过击杀获得胜点的方式晋级为'
/*     */     //   2099: checkcast java/lang/CharSequence
/*     */     //   2102: iconst_0
/*     */     //   2103: iconst_2
/*     */     //   2104: aconst_null
/*     */     //   2105: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   2108: ifeq -> 2115
/*     */     //   2111: aload_1
/*     */     //   2112: invokevirtual cancelEvent : ()V
/*     */     //   2115: aload_2
/*     */     //   2116: instanceof net/minecraft/network/play/server/SPacketChat
/*     */     //   2119: ifeq -> 2279
/*     */     //   2122: aload_0
/*     */     //   2123: getfield autoBotGetter : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   2126: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2129: checkcast java/lang/Boolean
/*     */     //   2132: invokevirtual booleanValue : ()Z
/*     */     //   2135: ifeq -> 2279
/*     */     //   2138: aload_2
/*     */     //   2139: checkcast net/minecraft/network/play/server/SPacketChat
/*     */     //   2142: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   2145: dup
/*     */     //   2146: ldc 'packet.chatComponent'
/*     */     //   2148: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   2151: invokeinterface func_150254_d : ()Ljava/lang/String;
/*     */     //   2156: astore_3
/*     */     //   2157: aload_3
/*     */     //   2158: dup
/*     */     //   2159: ldc_w 'ftchat'
/*     */     //   2162: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   2165: checkcast java/lang/CharSequence
/*     */     //   2168: ldc_w '§b花雨庭 §7>>'
/*     */     //   2171: checkcast java/lang/CharSequence
/*     */     //   2174: iconst_0
/*     */     //   2175: iconst_2
/*     */     //   2176: aconst_null
/*     */     //   2177: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   2180: ifeq -> 2193
/*     */     //   2183: aload_0
/*     */     //   2184: getfield botGetterModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   2187: ldc_w 'KitBattle'
/*     */     //   2190: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   2193: aload_3
/*     */     //   2194: checkcast java/lang/CharSequence
/*     */     //   2197: ldc_w '§b起床战争§7>>'
/*     */     //   2200: checkcast java/lang/CharSequence
/*     */     //   2203: iconst_0
/*     */     //   2204: iconst_2
/*     */     //   2205: aconst_null
/*     */     //   2206: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   2209: ifeq -> 2221
/*     */     //   2212: aload_0
/*     */     //   2213: getfield botGetterModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   2216: ldc '4v4/2v2/1v1'
/*     */     //   2218: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   2221: aload_3
/*     */     //   2222: checkcast java/lang/CharSequence
/*     */     //   2225: ldc_w '§b起床战争 §f>>'
/*     */     //   2228: checkcast java/lang/CharSequence
/*     */     //   2231: iconst_0
/*     */     //   2232: iconst_2
/*     */     //   2233: aconst_null
/*     */     //   2234: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   2237: ifeq -> 2250
/*     */     //   2240: aload_0
/*     */     //   2241: getfield botGetterModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   2244: ldc_w 'BWXP32'
/*     */     //   2247: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   2250: aload_3
/*     */     //   2251: checkcast java/lang/CharSequence
/*     */     //   2254: ldc_w '§f[起床战争]'
/*     */     //   2257: checkcast java/lang/CharSequence
/*     */     //   2260: iconst_0
/*     */     //   2261: iconst_2
/*     */     //   2262: aconst_null
/*     */     //   2263: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   2266: ifeq -> 2279
/*     */     //   2269: aload_0
/*     */     //   2270: getfield botGetterModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   2273: ldc_w 'BWXP16'
/*     */     //   2276: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   2279: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #209	-> 6
/*     */     //   #512	-> 14
/*     */     //   #209	-> 35
/*     */     //   #210	-> 36
/*     */     //   #212	-> 36
/*     */     //   #210	-> 36
/*     */     //   #211	-> 108
/*     */     //   #210	-> 113
/*     */     //   #212	-> 119
/*     */     //   #214	-> 189
/*     */     //   #215	-> 208
/*     */     //   #249	-> 296
/*     */     //   #217	-> 309
/*     */     //   #233	-> 322
/*     */     //   #265	-> 335
/*     */     //   #218	-> 348
/*     */     //   #219	-> 362
/*     */     //   #220	-> 376
/*     */     //   #221	-> 384
/*     */     //   #221	-> 426
/*     */     //   #222	-> 428
/*     */     //   #223	-> 437
/*     */     //   #225	-> 442
/*     */     //   #226	-> 450
/*     */     //   #226	-> 492
/*     */     //   #227	-> 494
/*     */     //   #228	-> 503
/*     */     //   #234	-> 511
/*     */     //   #235	-> 525
/*     */     //   #236	-> 539
/*     */     //   #237	-> 547
/*     */     //   #237	-> 589
/*     */     //   #238	-> 591
/*     */     //   #239	-> 600
/*     */     //   #241	-> 605
/*     */     //   #242	-> 613
/*     */     //   #242	-> 655
/*     */     //   #243	-> 657
/*     */     //   #244	-> 666
/*     */     //   #250	-> 674
/*     */     //   #251	-> 689
/*     */     //   #252	-> 704
/*     */     //   #253	-> 712
/*     */     //   #253	-> 754
/*     */     //   #254	-> 756
/*     */     //   #255	-> 765
/*     */     //   #257	-> 770
/*     */     //   #258	-> 778
/*     */     //   #258	-> 820
/*     */     //   #259	-> 822
/*     */     //   #260	-> 831
/*     */     //   #266	-> 839
/*     */     //   #267	-> 854
/*     */     //   #268	-> 869
/*     */     //   #269	-> 877
/*     */     //   #269	-> 919
/*     */     //   #270	-> 921
/*     */     //   #271	-> 941
/*     */     //   #273	-> 946
/*     */     //   #274	-> 954
/*     */     //   #274	-> 996
/*     */     //   #275	-> 998
/*     */     //   #276	-> 1018
/*     */     //   #279	-> 1023
/*     */     //   #283	-> 1023
/*     */     //   #284	-> 1023
/*     */     //   #285	-> 1023
/*     */     //   #286	-> 1023
/*     */     //   #287	-> 1023
/*     */     //   #283	-> 1023
/*     */     //   #284	-> 1057
/*     */     //   #283	-> 1065
/*     */     //   #284	-> 1071
/*     */     //   #285	-> 1098
/*     */     //   #284	-> 1142
/*     */     //   #285	-> 1148
/*     */     //   #286	-> 1175
/*     */     //   #285	-> 1183
/*     */     //   #286	-> 1189
/*     */     //   #287	-> 1216
/*     */     //   #286	-> 1225
/*     */     //   #287	-> 1231
/*     */     //   #288	-> 1258
/*     */     //   #287	-> 1267
/*     */     //   #290	-> 1273
/*     */     //   #291	-> 1289
/*     */     //   #292	-> 1293
/*     */     //   #297	-> 1315
/*     */     //   #298	-> 1322
/*     */     //   #299	-> 1341
/*     */     //   #300	-> 1369
/*     */     //   #301	-> 1455
/*     */     //   #299	-> 1475
/*     */     //   #307	-> 1481
/*     */     //   #308	-> 1488
/*     */     //   #309	-> 1507
/*     */     //   #309	-> 1555
/*     */     //   #311	-> 1574
/*     */     //   #313	-> 1574
/*     */     //   #311	-> 1574
/*     */     //   #312	-> 1632
/*     */     //   #311	-> 1641
/*     */     //   #313	-> 1647
/*     */     //   #315	-> 1666
/*     */     //   #319	-> 1670
/*     */     //   #320	-> 1747
/*     */     //   #319	-> 1773
/*     */     //   #323	-> 1779
/*     */     //   #327	-> 1799
/*     */     //   #328	-> 1799
/*     */     //   #329	-> 1799
/*     */     //   #330	-> 1799
/*     */     //   #331	-> 1799
/*     */     //   #327	-> 1799
/*     */     //   #328	-> 1818
/*     */     //   #329	-> 1837
/*     */     //   #330	-> 1856
/*     */     //   #331	-> 1875
/*     */     //   #334	-> 1894
/*     */     //   #338	-> 1914
/*     */     //   #339	-> 1942
/*     */     //   #340	-> 1969
/*     */     //   #338	-> 1989
/*     */     //   #345	-> 1995
/*     */     //   #346	-> 2023
/*     */     //   #347	-> 2050
/*     */     //   #345	-> 2070
/*     */     //   #352	-> 2076
/*     */     //   #353	-> 2111
/*     */     //   #358	-> 2115
/*     */     //   #359	-> 2138
/*     */     //   #360	-> 2157
/*     */     //   #361	-> 2193
/*     */     //   #362	-> 2221
/*     */     //   #363	-> 2250
/*     */     //   #365	-> 2279
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   11	24	3	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   14	21	4	$i$f$unwrap	I
/*     */     //   428	14	7	name	Ljava/lang/String;
/*     */     //   494	14	7	name	Ljava/lang/String;
/*     */     //   376	132	6	matcher2	Ljava/util/regex/Matcher;
/*     */     //   362	146	5	matcher	Ljava/util/regex/Matcher;
/*     */     //   591	14	7	name	Ljava/lang/String;
/*     */     //   657	14	7	name	Ljava/lang/String;
/*     */     //   539	132	6	matcher2	Ljava/util/regex/Matcher;
/*     */     //   525	146	5	matcher	Ljava/util/regex/Matcher;
/*     */     //   756	14	7	name	Ljava/lang/String;
/*     */     //   822	14	7	name	Ljava/lang/String;
/*     */     //   704	132	6	matcher2	Ljava/util/regex/Matcher;
/*     */     //   689	147	5	matcher	Ljava/util/regex/Matcher;
/*     */     //   921	25	7	name	Ljava/lang/String;
/*     */     //   998	25	7	name	Ljava/lang/String;
/*     */     //   869	154	6	matcher2	Ljava/util/regex/Matcher;
/*     */     //   854	169	5	matcher	Ljava/util/regex/Matcher;
/*     */     //   208	815	3	chat	Ljava/lang/String;
/*     */     //   1369	109	4	it	Ljava/lang/String;
/*     */     //   1341	140	3	chat	Ljava/lang/String;
/*     */     //   1942	50	4	it	Ljava/lang/String;
/*     */     //   2023	50	4	it	Ljava/lang/String;
/*     */     //   1507	608	3	chat	Ljava/lang/String;
/*     */     //   2157	122	3	ftchat	Ljava/lang/String;
/*     */     //   36	2244	2	packet	Lnet/minecraft/network/Packet;
/*     */     //   0	2280	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/AntiFakePlayerPlus;
/*     */     //   0	2280	1	event	Lnet/ccbluex/liquidbounce/event/PacketEvent;
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
/*     */   @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 370 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (((Boolean)this.autoSwitchLogger.get()).booleanValue() && this.ms.hasTimePassed(((Number)this.autoSwitchDelay.get()).intValue())) {
/* 371 */       String str = (String)this.autoSwitchMode.get(); int i = 0; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case -938285885:
/* 372 */           if (str.equals("random")) this.logStyleValue.set(this.logStyles[RandomUtils.nextInt(0, this.logStyles.length - 1)]);  break;
/* 373 */         case 3322014: if (str.equals("list")) {
/* 374 */             if (this.logNumber != this.logStyles.length - 1) {
/* 375 */               this.logNumber = (i = this.logNumber) + 1;
/* 376 */               this.logStyleValue.set(this.logStyles[this.logNumber]); break;
/*     */             } 
/* 378 */             this.logNumber = 0;
/* 379 */             this.logStyleValue.set(this.logStyles[this.logNumber]);
/*     */           } 
/*     */           break; }
/*     */       
/* 383 */       this.ms.reset();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private final void playerDeathMsgAction(PacketEvent event) {
/* 389 */     IPacket $this$unwrap$iv = event.getPacket(); int $i$f$unwrap = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 513 */     if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.PacketImpl<*>");  Packet packet = ((PacketImpl)$this$unwrap$iv).getWrapped();
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
/*     */     int i;
/*     */     this.bots = (i = this.bots) + 1;
/*     */     if (!(Retreat.INSTANCE.getFileManager()).friendsConfig.isFriend(name)) {
/*     */       if (((Boolean)this.isFriendDebuggerChat.get()).booleanValue())
/*     */         ClientUtils.displayChatMessage("§f[§c!§f] §7[§bXSJ Client§7] §f判定 §7" + name + " §f是否在好友列表。"); 
/*     */       (Retreat.INSTANCE.getFileManager()).friendsConfig.addFriend(name);
/*     */     } 
/*     */     this.protectedname = ((Boolean)this.protectDeadPlayerName.get()).booleanValue() ? ("§7§k" + name) : ("§7" + name);
/*     */     if (((Boolean)this.printLogger.get()).booleanValue())
/*     */       printLogger(this.protectedname, "add"); 
/*     */     (new Thread(new AntiFakePlayerPlus$playerDeathAction$1(cd, name))).start();
/*     */   }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "run"})
/*     */   static final class AntiFakePlayerPlus$playerDeathAction$1 implements Runnable {
/*     */     public final void run() {
/*     */       try {
/*     */         Thread.sleep(this.$cd);
/*     */         AntiFakePlayerPlus.this.protectedname = ((Boolean)AntiFakePlayerPlus.this.protectDeadPlayerName.get()).booleanValue() ? ("§7§k" + this.$name) : ("§7" + this.$name);
/*     */         if ((Retreat.INSTANCE.getFileManager()).friendsConfig.isFriend(this.$name)) {
/*     */           if (((Boolean)AntiFakePlayerPlus.this.isFriendDebuggerChat.get()).booleanValue())
/*     */             ClientUtils.displayChatMessage("§f[§c!§f] §7[§bXSJ Client§7] §f判定 §7" + this.$name + " §f是否在好友列表。"); 
/*     */           (Retreat.INSTANCE.getFileManager()).friendsConfig.removeFriend(this.$name);
/*     */         } 
/*     */         int i;
/*     */         AntiFakePlayerPlus.this.bots = (i = AntiFakePlayerPlus.this.bots) + -1;
/*     */         if (((Boolean)AntiFakePlayerPlus.this.printLogger.get()).booleanValue())
/*     */           AntiFakePlayerPlus.this.printLogger(AntiFakePlayerPlus.this.protectedname, "remove"); 
/*     */       } catch (InterruptedException ex) {
/*     */         ex.printStackTrace();
/*     */       } 
/*     */     }
/*     */     
/*     */     AntiFakePlayerPlus$playerDeathAction$1(long param1Long, String param1String) {}
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
/*     */             case -916350399:
/*     */               if (str1.equals("ryfnew"))
/*     */                 ClientUtils.displayChatMessage("§bXSJ Client §7» §aAdded§f HYT Bot §7-> §e" + name); 
/*     */               break;
/*     */             case -1039745817:
/*     */               if (str1.equals("normal"))
/*     */                 ClientUtils.displayChatMessage("§7[§6XSJ Client§7] §fAdded HYT Bot: §7" + name); 
/*     */               break;
/*     */             case 112906142:
/*     */               if (str1.equals("wawa2"))
/*     */                 ClientUtils.displayChatMessage("§6XSJ Client §7» §f玩家死亡: §7" + name); 
/*     */               break;
/*     */             case 112906143:
/*     */               if (str1.equals("wawa3"))
/*     */                 ClientUtils.displayChatMessage("§6XSJ Client §7=» §f玩家 §7" + name + " §f狂暴死去"); 
/*     */               break;
/*     */             case 110119:
/*     */               if (str1.equals("old"))
/*     */                 ClientUtils.displayChatMessage("§8[§c§lXSJ Client提醒您§8] §d添加无敌人：§7" + name); 
/*     */               break;
/*     */             case -2132879719:
/*     */               if (str1.equals("special2"))
/*     */                 ClientUtils.displayChatMessage("§8[§bXSJ Client§8] §a" + name + "§b被RyF吃掉啦! Ciallo(∠・ω< )⌒☆"); 
/*     */               break;
/*     */             case 112906141:
/*     */               if (str1.equals("wawa1"))
/*     */                 ClientUtils.displayChatMessage("§6XSJ Client §7=> §fAdded Bot §7" + name + "§f."); 
/*     */               break;
/*     */             case 93078283:
/*     */               if (str1.equals("arene"))
/*     */                 ClientUtils.displayChatMessage("§7[§fXSJ Client§7] §fAdd a Bot(§7" + name + "§f)"); 
/*     */               break;
/*     */             case -903325499:
/*     */               if (str1.equals("shitty"))
/*     */                 ClientUtils.displayChatMessage("§7[§aXSJ Client§7] §7" + name + "§f被§bRyF§f吃掉啦! §aawa~"); 
/*     */               break;
/*     */             case 113135984:
/*     */               if (str1.equals("windx"))
/*     */                 ClientUtils.displayChatMessage("§7[§c!§7] §bColorByte §aClient §7=> §aAdded §fa bot(§7" + name + "§f)"); 
/*     */               break;
/*     */             case -2008465223:
/*     */               if (str1.equals("special"))
/*     */                 ClientUtils.displayChatMessage("§8[§dXSJ Client§8] §a" + name + "§d被§bRyF§d吃掉啦! §bCiallo(∠・ω< )⌒☆"); 
/*     */               break;
/*     */             case -994503222:
/*     */               if (str1.equals("fdpchat"))
/*     */                 ClientUtils.displayChatMessage("§f[§c!§f] §7[§b§lXSJ Client§7] §aAdded §6HYT bot§f[" + name + "§f]§6."); 
/*     */               break;
/*     */             case -2146994317:
/*     */               if (str1.equals("fdpantibot"))
/*     */                 ClientUtils.displayChatMessage("§7[§cAntiBot§7] §fAdded §7" + name + "§f due to it being a bot."); 
/*     */               break;
/*     */             case 102846135:
/*     */               if (str1.equals("leave"))
/*     */                 ClientUtils.displayChatMessage("§bXSJ Client §8[§eWARNING§8] §6添加无敌人: " + name); 
/*     */               break;
/*     */             case -1912063982:
/*     */               if (str1.equals("nullclient"))
/*     */                 ClientUtils.displayChatMessage("§7[§cAntiBots§7] §fAdded a bot(§7" + name + "§f)"); 
/*     */               break;
/*     */             case 3413738:
/*     */               if (str1.equals("old1"))
/*     */                 ClientUtils.displayChatMessage("§8[§c§lXSJ Client§8] §d添加无敌人：§7" + name); 
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
/*     */             case -916350399:
/*     */               if (str1.equals("ryfnew"))
/*     */                 ClientUtils.displayChatMessage("§bXSJ Client §7» §cRemoved§f HYT Bot §7-> §e" + name); 
/*     */               break;
/*     */             case -1039745817:
/*     */               if (str1.equals("normal"))
/*     */                 ClientUtils.displayChatMessage("§7[§6XSJ Client§7] §fRemoved HYT Bot: §7" + name); 
/*     */               break;
/*     */             case 112906142:
/*     */               if (str1.equals("wawa2"))
/*     */                 ClientUtils.displayChatMessage("§6XSJ Client §7» §f玩家重生: §7" + name); 
/*     */               break;
/*     */             case 112906143:
/*     */               if (str1.equals("wawa3"))
/*     */                 ClientUtils.displayChatMessage("§6XSJ Client §7=» §f玩家 §7" + name + " §f炸裂归来"); 
/*     */               break;
/*     */             case 110119:
/*     */               if (str1.equals("old"))
/*     */                 ClientUtils.displayChatMessage("§8[§c§lXSJ Client提醒您§8] §d删除无敌人：§7" + name); 
/*     */               break;
/*     */             case -2132879719:
/*     */               if (str1.equals("special2"))
/*     */                 ClientUtils.displayChatMessage("§8[§bXSJ Client§8] §a" + name + "§b被RyF吐出来咯~ Ciallo(∠・ω< )⌒☆"); 
/*     */               break;
/*     */             case 112906141:
/*     */               if (str1.equals("wawa1"))
/*     */                 ClientUtils.displayChatMessage("§6XSJ Client §7=> §fRemoved Bot §7" + name + "§f."); 
/*     */               break;
/*     */             case 93078283:
/*     */               if (str1.equals("arene"))
/*     */                 ClientUtils.displayChatMessage("§7[§fXSJ Client§7] §fDel a Bot(§7" + name + "§f)"); 
/*     */               break;
/*     */             case -903325499:
/*     */               if (str1.equals("shitty"))
/*     */                 ClientUtils.displayChatMessage("§7[§bXSJ Client§7] §7" + name + "§f被§bRyF§f吐出来咯~ §dqwq"); 
/*     */               break;
/*     */             case 113135984:
/*     */               if (str1.equals("windx"))
/*     */                 ClientUtils.displayChatMessage("§7[§c!§7] §bColorByte §aClient §7=> §cRemoved §fa bot(§7" + name + "§f)"); 
/*     */               break;
/*     */             case -2008465223:
/*     */               if (str1.equals("special"))
/*     */                 ClientUtils.displayChatMessage("§8[§dXSJ Client§8] §a" + name + "§d被§bRyF§d吐出来咯~ §bCiallo(∠・ω< )⌒☆"); 
/*     */               break;
/*     */             case -994503222:
/*     */               if (str1.equals("fdpchat"))
/*     */                 ClientUtils.displayChatMessage("§f[§c!§f] §7[§b§lXSJ Client§7] §cRemoved §6HYT bot§f[" + name + "§f]§6."); 
/*     */               break;
/*     */             case -2146994317:
/*     */               if (str1.equals("fdpantibot"))
/*     */                 ClientUtils.displayChatMessage("§7[§cAntiBot§7] §fRemoved §7" + name + "§f due to respawn."); 
/*     */               break;
/*     */             case 102846135:
/*     */               if (str1.equals("leave"))
/*     */                 ClientUtils.displayChatMessage("§bXSJ Client §8[§eWARNING§8] §6删除无敌人: " + name); 
/*     */               break;
/*     */             case -1912063982:
/*     */               if (str1.equals("nullclient"))
/*     */                 ClientUtils.displayChatMessage("§7[§cAntiBots§7] §fRemoved a bot(§7" + name + "§f)"); 
/*     */               break;
/*     */             case 3413738:
/*     */               if (str1.equals("old1"))
/*     */                 ClientUtils.displayChatMessage("§8[§c§lXSJ Client§8] §d删除无敌人：§7" + name); 
/*     */               break;
/*     */           } 
/*     */         } 
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   private final void clearAll() {
/*     */     (Retreat.INSTANCE.getFileManager()).friendsConfig.clearFriends();
/*     */   }
/*     */   
/*     */   private final String tagReturner() {
/*     */     String tag = "";
/*     */     if (((Boolean)this.sTHideAll.get()).booleanValue()) {
/*     */       tag = "";
/*     */     } else {
/*     */       if (!((Boolean)this.sTHideMode.get()).booleanValue())
/*     */         tag = (String)this.botGetterModeValue.get(); 
/*     */       if (!((Boolean)this.sTHideLogStyle.get()).booleanValue() && ((Boolean)this.printLogger.get()).booleanValue())
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
/*     */           tag = ((Intrinsics.areEqual(tag, "") ^ true) != 0) ? (tag + ", " + (String)this.autoSwitchMode.get()) : (String)this.autoSwitchMode.get(); 
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


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\retreat\AntiFakePlayerPlus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */