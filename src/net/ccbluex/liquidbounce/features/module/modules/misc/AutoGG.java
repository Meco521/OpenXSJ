/*    */ package net.ccbluex.liquidbounce.features.module.modules.misc;
/*    */ 
/*    */ import java.awt.Image;
/*    */ import java.awt.SystemTray;
/*    */ import java.awt.Toolkit;
/*    */ import java.awt.TrayIcon;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import net.ccbluex.liquidbounce.value.TextValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @ModuleInfo(name = "AutoGG", category = ModuleCategory.MISC, description = "Skid form CatBounce")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000L\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\016\n\002\b\003\n\002\030\002\n\000\n\002\020\b\n\002\b\n\n\002\020\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J \020\034\032\0020\0352\006\020\036\032\0020\f2\006\020\037\032\0020\f2\b\020 \032\004\030\0010!J\020\020\"\032\0020\0352\006\020#\032\0020$H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\021\020\007\032\0020\b¢\006\b\n\000\032\004\b\t\020\nR\024\020\013\032\0020\f8VX\004¢\006\006\032\004\b\r\020\016R\016\020\017\032\0020\020X\004¢\006\002\n\000R\032\020\021\032\0020\022X\016¢\006\016\n\000\032\004\b\023\020\024\"\004\b\025\020\026R\032\020\027\032\0020\022X\016¢\006\016\n\000\032\004\b\030\020\024\"\004\b\031\020\026R\021\020\032\032\0020\b¢\006\b\n\000\032\004\b\033\020\n¨\006%"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/misc/AutoGG;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "Debug", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "Volume", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "startmodeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "getStartmodeValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "tag", "", "getTag", "()Ljava/lang/String;", "textValue", "Lnet/ccbluex/liquidbounce/value/TextValue;", "totalPlayed", "", "getTotalPlayed", "()I", "setTotalPlayed", "(I)V", "win", "getWin", "setWin", "winmodeValue", "getWinmodeValue", "displayTray", "", "Title", "Text", "type", "Ljava/awt/TrayIcon$MessageType;", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "XSJClient"})
/*    */ public final class AutoGG
/*    */   extends Module
/*    */ {
/*    */   private int totalPlayed;
/* 27 */   private final TextValue textValue = new TextValue("Text", "GG"); private int win; public final int getTotalPlayed() {
/* 28 */     return this.totalPlayed; } public final void setTotalPlayed(int <set-?>) { this.totalPlayed = <set-?>; }
/* 29 */   public final int getWin() { return this.win; } public final void setWin(int <set-?>) { this.win = <set-?>; } @NotNull
/* 30 */   private final ListValue winmodeValue = new ListValue("WinSoundMode", new String[] { "克拉拉", "有为青年", "停云", "光头强", "可莉", "派蒙", "景元", "虎克", "黑塔", "瓦尔特", "枫原万叶", "艾斯妲", "刃", "王者荣耀", "MiddleofNight", "None" }, "克拉拉"); @NotNull public final ListValue getWinmodeValue() { return this.winmodeValue; } @NotNull
/* 31 */   private final ListValue startmodeValue = new ListValue("StartSoundMode", new String[] { "佩拉", "None" }, "佩拉"); @NotNull public final ListValue getStartmodeValue() { return this.startmodeValue; }
/* 32 */    private final FloatValue Volume = new FloatValue("Volume", 50.0F, 0.0F, 100.0F);
/* 33 */   private final BoolValue Debug = new BoolValue("advance", true);
/*    */   
/*    */   public final void displayTray(@NotNull String Title, @NotNull String Text, @Nullable TrayIcon.MessageType type) {
/* 36 */     Intrinsics.checkParameterIsNotNull(Title, "Title"); Intrinsics.checkParameterIsNotNull(Text, "Text"); if (SystemTray.isSupported()) {
/* 37 */       Image image = Toolkit.getDefaultToolkit().createImage("Cat.png");
/* 38 */       TrayIcon trayIcon = new TrayIcon(image);
/* 39 */       trayIcon.setImageAutoSize(true);
/* 40 */       trayIcon.setToolTip("System tray icon demo");
/* 41 */       trayIcon.displayMessage(Title, Text, type);
/*    */     } 
/*    */   }
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
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: ldc 'event'
/*    */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   6: aload_1
/*    */     //   7: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*    */     //   10: astore_3
/*    */     //   11: iconst_0
/*    */     //   12: istore #4
/*    */     //   14: aload_3
/*    */     //   15: dup
/*    */     //   16: ifnonnull -> 29
/*    */     //   19: new kotlin/TypeCastException
/*    */     //   22: dup
/*    */     //   23: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.PacketImpl<*>'
/*    */     //   25: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   28: athrow
/*    */     //   29: checkcast net/ccbluex/liquidbounce/injection/backend/PacketImpl
/*    */     //   32: invokevirtual getWrapped : ()Lnet/minecraft/network/Packet;
/*    */     //   35: astore_2
/*    */     //   36: aload_2
/*    */     //   37: instanceof net/minecraft/network/play/server/SPacketChat
/*    */     //   40: ifeq -> 1438
/*    */     //   43: aload_2
/*    */     //   44: checkcast net/minecraft/network/play/server/SPacketChat
/*    */     //   47: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*    */     //   50: dup
/*    */     //   51: ldc 'packet.chatComponent'
/*    */     //   53: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   56: invokeinterface func_150260_c : ()Ljava/lang/String;
/*    */     //   61: astore_3
/*    */     //   62: aload_2
/*    */     //   63: checkcast net/minecraft/network/play/server/SPacketChat
/*    */     //   66: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*    */     //   69: dup
/*    */     //   70: ldc 'packet.chatComponent'
/*    */     //   72: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   75: invokeinterface func_150260_c : ()Ljava/lang/String;
/*    */     //   80: dup
/*    */     //   81: ldc 'packet.chatComponent.unformattedText'
/*    */     //   83: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   86: checkcast java/lang/CharSequence
/*    */     //   89: ldc ':'
/*    */     //   91: checkcast java/lang/CharSequence
/*    */     //   94: iconst_0
/*    */     //   95: iconst_2
/*    */     //   96: aconst_null
/*    */     //   97: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*    */     //   100: ifne -> 1228
/*    */     //   103: aload_3
/*    */     //   104: dup
/*    */     //   105: ldc 'text'
/*    */     //   107: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   110: checkcast java/lang/CharSequence
/*    */     //   113: ldc '恭喜'
/*    */     //   115: checkcast java/lang/CharSequence
/*    */     //   118: iconst_1
/*    */     //   119: invokestatic contains : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Z
/*    */     //   122: ifne -> 193
/*    */     //   125: aload_3
/*    */     //   126: checkcast java/lang/CharSequence
/*    */     //   129: new java/lang/StringBuilder
/*    */     //   132: dup
/*    */     //   133: invokespecial <init> : ()V
/*    */     //   136: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   139: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   144: dup
/*    */     //   145: ifnonnull -> 151
/*    */     //   148: invokestatic throwNpe : ()V
/*    */     //   151: invokeinterface getName : ()Ljava/lang/String;
/*    */     //   156: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   159: ldc ' 在地图'
/*    */     //   161: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   164: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   167: checkcast java/lang/CharSequence
/*    */     //   170: iconst_1
/*    */     //   171: invokestatic contains : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Z
/*    */     //   174: ifeq -> 1228
/*    */     //   177: aload_3
/*    */     //   178: checkcast java/lang/CharSequence
/*    */     //   181: ldc '取得了一场游戏的胜利'
/*    */     //   183: checkcast java/lang/CharSequence
/*    */     //   186: iconst_1
/*    */     //   187: invokestatic contains : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Z
/*    */     //   190: ifeq -> 1228
/*    */     //   193: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*    */     //   196: invokevirtual getHud : ()Lnet/ccbluex/liquidbounce/ui/client/hud/HUD;
/*    */     //   199: new net/ccbluex/liquidbounce/ui/client/hud/element/elements/Notification
/*    */     //   202: dup
/*    */     //   203: ldc 'AutoGG'
/*    */     //   205: ldc '凡哥恭喜您成功殴打HYT'
/*    */     //   207: getstatic net/ccbluex/liquidbounce/ui/client/hud/element/elements/NotifyType.SUCCESS : Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/NotifyType;
/*    */     //   210: iconst_0
/*    */     //   211: iconst_0
/*    */     //   212: bipush #24
/*    */     //   214: aconst_null
/*    */     //   215: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/NotifyType;IIILkotlin/jvm/internal/DefaultConstructorMarker;)V
/*    */     //   218: invokevirtual addNotification : (Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Notification;)Z
/*    */     //   221: pop
/*    */     //   222: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   225: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   230: dup
/*    */     //   231: ifnonnull -> 237
/*    */     //   234: invokestatic throwNpe : ()V
/*    */     //   237: aload_0
/*    */     //   238: getfield textValue : Lnet/ccbluex/liquidbounce/value/TextValue;
/*    */     //   241: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   244: checkcast java/lang/String
/*    */     //   247: invokeinterface sendChatMessage : (Ljava/lang/String;)V
/*    */     //   252: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*    */     //   255: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*    */     //   258: ldc_w net/ccbluex/liquidbounce/features/module/modules/player/StealerPlus
/*    */     //   261: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*    */     //   264: dup
/*    */     //   265: ifnonnull -> 279
/*    */     //   268: new kotlin/TypeCastException
/*    */     //   271: dup
/*    */     //   272: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.player.StealerPlus'
/*    */     //   275: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   278: athrow
/*    */     //   279: checkcast net/ccbluex/liquidbounce/features/module/modules/player/StealerPlus
/*    */     //   282: astore #4
/*    */     //   284: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*    */     //   287: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*    */     //   290: ldc_w net/ccbluex/liquidbounce/features/module/modules/player/InvManager
/*    */     //   293: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*    */     //   296: dup
/*    */     //   297: ifnonnull -> 311
/*    */     //   300: new kotlin/TypeCastException
/*    */     //   303: dup
/*    */     //   304: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.player.InvManager'
/*    */     //   307: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   310: athrow
/*    */     //   311: checkcast net/ccbluex/liquidbounce/features/module/modules/player/InvManager
/*    */     //   314: astore #5
/*    */     //   316: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*    */     //   319: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*    */     //   322: ldc_w net/ccbluex/liquidbounce/features/module/modules/world/ChestAura
/*    */     //   325: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*    */     //   328: dup
/*    */     //   329: ifnonnull -> 343
/*    */     //   332: new kotlin/TypeCastException
/*    */     //   335: dup
/*    */     //   336: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.world.ChestAura'
/*    */     //   339: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   342: athrow
/*    */     //   343: checkcast net/ccbluex/liquidbounce/features/module/modules/world/ChestAura
/*    */     //   346: astore #6
/*    */     //   348: aload #4
/*    */     //   350: iconst_0
/*    */     //   351: invokevirtual setState : (Z)V
/*    */     //   354: aload #6
/*    */     //   356: iconst_0
/*    */     //   357: invokevirtual setState : (Z)V
/*    */     //   360: aload #5
/*    */     //   362: iconst_0
/*    */     //   363: invokevirtual setState : (Z)V
/*    */     //   366: aload_0
/*    */     //   367: getfield winmodeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*    */     //   370: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   373: checkcast java/lang/String
/*    */     //   376: astore #7
/*    */     //   378: iconst_0
/*    */     //   379: istore #8
/*    */     //   381: aload #7
/*    */     //   383: dup
/*    */     //   384: ifnonnull -> 398
/*    */     //   387: new kotlin/TypeCastException
/*    */     //   390: dup
/*    */     //   391: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*    */     //   394: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   397: athrow
/*    */     //   398: invokevirtual toLowerCase : ()Ljava/lang/String;
/*    */     //   401: dup
/*    */     //   402: ldc_w '(this as java.lang.String).toLowerCase()'
/*    */     //   405: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   408: astore #7
/*    */     //   410: aload #7
/*    */     //   412: invokevirtual hashCode : ()I
/*    */     //   415: lookupswitch default -> 1186, -1503672020 -> 642, 20995 -> 572, 657845 -> 740, 699770 -> 600, 833716 -> 698, 900891 -> 670, 1086653 -> 586, 1282979 -> 614, 20729743 -> 628, 20808619 -> 656, 32933089 -> 684, 806267251 -> 712, 811836195 -> 544, 913758295 -> 558, 915086645 -> 726
/*    */     //   544: aload #7
/*    */     //   546: ldc_w '枫原万叶'
/*    */     //   549: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   552: ifeq -> 1186
/*    */     //   555: goto -> 1102
/*    */     //   558: aload #7
/*    */     //   560: ldc_w '王者荣耀'
/*    */     //   563: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   566: ifeq -> 1186
/*    */     //   569: goto -> 754
/*    */     //   572: aload #7
/*    */     //   574: ldc_w '刃'
/*    */     //   577: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   580: ifeq -> 1186
/*    */     //   583: goto -> 1160
/*    */     //   586: aload #7
/*    */     //   588: ldc_w '虎克'
/*    */     //   591: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   594: ifeq -> 1186
/*    */     //   597: goto -> 1015
/*    */     //   600: aload #7
/*    */     //   602: ldc_w '可莉'
/*    */     //   605: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   608: ifeq -> 1186
/*    */     //   611: goto -> 928
/*    */     //   614: aload #7
/*    */     //   616: ldc_w '黑塔'
/*    */     //   619: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   622: ifeq -> 1186
/*    */     //   625: goto -> 1044
/*    */     //   628: aload #7
/*    */     //   630: ldc_w '光头强'
/*    */     //   633: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   636: ifeq -> 1186
/*    */     //   639: goto -> 812
/*    */     //   642: aload #7
/*    */     //   644: ldc_w 'MiddleofNight'
/*    */     //   647: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   650: ifeq -> 1186
/*    */     //   653: goto -> 841
/*    */     //   656: aload #7
/*    */     //   658: ldc_w '克拉拉'
/*    */     //   661: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   664: ifeq -> 1186
/*    */     //   667: goto -> 870
/*    */     //   670: aload #7
/*    */     //   672: ldc_w '派蒙'
/*    */     //   675: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   678: ifeq -> 1186
/*    */     //   681: goto -> 957
/*    */     //   684: aload #7
/*    */     //   686: ldc_w '艾斯妲'
/*    */     //   689: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   692: ifeq -> 1186
/*    */     //   695: goto -> 1131
/*    */     //   698: aload #7
/*    */     //   700: ldc_w '景元'
/*    */     //   703: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   706: ifeq -> 1186
/*    */     //   709: goto -> 986
/*    */     //   712: aload #7
/*    */     //   714: ldc_w '有为青年'
/*    */     //   717: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   720: ifeq -> 1186
/*    */     //   723: goto -> 783
/*    */     //   726: aload #7
/*    */     //   728: ldc_w '瓦尔特 '
/*    */     //   731: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   734: ifeq -> 1186
/*    */     //   737: goto -> 1073
/*    */     //   740: aload #7
/*    */     //   742: ldc_w '停云'
/*    */     //   745: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   748: ifeq -> 1186
/*    */     //   751: goto -> 899
/*    */     //   754: new me/sound/SoundPlayer
/*    */     //   757: dup
/*    */     //   758: invokespecial <init> : ()V
/*    */     //   761: getstatic me/sound/SoundPlayer$SoundType.VICTORY : Lme/sound/SoundPlayer$SoundType;
/*    */     //   764: aload_0
/*    */     //   765: getfield Volume : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   768: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   771: checkcast java/lang/Number
/*    */     //   774: invokevirtual floatValue : ()F
/*    */     //   777: invokevirtual playSound : (Lme/sound/SoundPlayer$SoundType;F)V
/*    */     //   780: goto -> 1186
/*    */     //   783: new me/sound/SoundPlayer
/*    */     //   786: dup
/*    */     //   787: invokespecial <init> : ()V
/*    */     //   790: getstatic me/sound/SoundPlayer$SoundType.ONMYOWN : Lme/sound/SoundPlayer$SoundType;
/*    */     //   793: aload_0
/*    */     //   794: getfield Volume : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   797: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   800: checkcast java/lang/Number
/*    */     //   803: invokevirtual floatValue : ()F
/*    */     //   806: invokevirtual playSound : (Lme/sound/SoundPlayer$SoundType;F)V
/*    */     //   809: goto -> 1186
/*    */     //   812: new me/sound/SoundPlayer
/*    */     //   815: dup
/*    */     //   816: invokespecial <init> : ()V
/*    */     //   819: getstatic me/sound/SoundPlayer$SoundType.GUANGTOUQIANG : Lme/sound/SoundPlayer$SoundType;
/*    */     //   822: aload_0
/*    */     //   823: getfield Volume : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   826: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   829: checkcast java/lang/Number
/*    */     //   832: invokevirtual floatValue : ()F
/*    */     //   835: invokevirtual playSound : (Lme/sound/SoundPlayer$SoundType;F)V
/*    */     //   838: goto -> 1186
/*    */     //   841: new me/sound/SoundPlayer
/*    */     //   844: dup
/*    */     //   845: invokespecial <init> : ()V
/*    */     //   848: getstatic me/sound/SoundPlayer$SoundType.MIDDLEOFNIGHT : Lme/sound/SoundPlayer$SoundType;
/*    */     //   851: aload_0
/*    */     //   852: getfield Volume : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   855: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   858: checkcast java/lang/Number
/*    */     //   861: invokevirtual floatValue : ()F
/*    */     //   864: invokevirtual playSound : (Lme/sound/SoundPlayer$SoundType;F)V
/*    */     //   867: goto -> 1186
/*    */     //   870: new me/sound/SoundPlayer
/*    */     //   873: dup
/*    */     //   874: invokespecial <init> : ()V
/*    */     //   877: getstatic me/sound/SoundPlayer$SoundType.KELALAWIN : Lme/sound/SoundPlayer$SoundType;
/*    */     //   880: aload_0
/*    */     //   881: getfield Volume : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   884: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   887: checkcast java/lang/Number
/*    */     //   890: invokevirtual floatValue : ()F
/*    */     //   893: invokevirtual playSound : (Lme/sound/SoundPlayer$SoundType;F)V
/*    */     //   896: goto -> 1186
/*    */     //   899: new me/sound/SoundPlayer
/*    */     //   902: dup
/*    */     //   903: invokespecial <init> : ()V
/*    */     //   906: getstatic me/sound/SoundPlayer$SoundType.TINYUNWIN : Lme/sound/SoundPlayer$SoundType;
/*    */     //   909: aload_0
/*    */     //   910: getfield Volume : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   913: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   916: checkcast java/lang/Number
/*    */     //   919: invokevirtual floatValue : ()F
/*    */     //   922: invokevirtual playSound : (Lme/sound/SoundPlayer$SoundType;F)V
/*    */     //   925: goto -> 1186
/*    */     //   928: new me/sound/SoundPlayer
/*    */     //   931: dup
/*    */     //   932: invokespecial <init> : ()V
/*    */     //   935: getstatic me/sound/SoundPlayer$SoundType.KELIWIN : Lme/sound/SoundPlayer$SoundType;
/*    */     //   938: aload_0
/*    */     //   939: getfield Volume : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   942: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   945: checkcast java/lang/Number
/*    */     //   948: invokevirtual floatValue : ()F
/*    */     //   951: invokevirtual playSound : (Lme/sound/SoundPlayer$SoundType;F)V
/*    */     //   954: goto -> 1186
/*    */     //   957: new me/sound/SoundPlayer
/*    */     //   960: dup
/*    */     //   961: invokespecial <init> : ()V
/*    */     //   964: getstatic me/sound/SoundPlayer$SoundType.PAIMENWIN : Lme/sound/SoundPlayer$SoundType;
/*    */     //   967: aload_0
/*    */     //   968: getfield Volume : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   971: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   974: checkcast java/lang/Number
/*    */     //   977: invokevirtual floatValue : ()F
/*    */     //   980: invokevirtual playSound : (Lme/sound/SoundPlayer$SoundType;F)V
/*    */     //   983: goto -> 1186
/*    */     //   986: new me/sound/SoundPlayer
/*    */     //   989: dup
/*    */     //   990: invokespecial <init> : ()V
/*    */     //   993: getstatic me/sound/SoundPlayer$SoundType.JINYUANWIN : Lme/sound/SoundPlayer$SoundType;
/*    */     //   996: aload_0
/*    */     //   997: getfield Volume : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   1000: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   1003: checkcast java/lang/Number
/*    */     //   1006: invokevirtual floatValue : ()F
/*    */     //   1009: invokevirtual playSound : (Lme/sound/SoundPlayer$SoundType;F)V
/*    */     //   1012: goto -> 1186
/*    */     //   1015: new me/sound/SoundPlayer
/*    */     //   1018: dup
/*    */     //   1019: invokespecial <init> : ()V
/*    */     //   1022: getstatic me/sound/SoundPlayer$SoundType.HUKEWIN : Lme/sound/SoundPlayer$SoundType;
/*    */     //   1025: aload_0
/*    */     //   1026: getfield Volume : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   1029: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   1032: checkcast java/lang/Number
/*    */     //   1035: invokevirtual floatValue : ()F
/*    */     //   1038: invokevirtual playSound : (Lme/sound/SoundPlayer$SoundType;F)V
/*    */     //   1041: goto -> 1186
/*    */     //   1044: new me/sound/SoundPlayer
/*    */     //   1047: dup
/*    */     //   1048: invokespecial <init> : ()V
/*    */     //   1051: getstatic me/sound/SoundPlayer$SoundType.HEITAWIN : Lme/sound/SoundPlayer$SoundType;
/*    */     //   1054: aload_0
/*    */     //   1055: getfield Volume : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   1058: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   1061: checkcast java/lang/Number
/*    */     //   1064: invokevirtual floatValue : ()F
/*    */     //   1067: invokevirtual playSound : (Lme/sound/SoundPlayer$SoundType;F)V
/*    */     //   1070: goto -> 1186
/*    */     //   1073: new me/sound/SoundPlayer
/*    */     //   1076: dup
/*    */     //   1077: invokespecial <init> : ()V
/*    */     //   1080: getstatic me/sound/SoundPlayer$SoundType.WATWIN : Lme/sound/SoundPlayer$SoundType;
/*    */     //   1083: aload_0
/*    */     //   1084: getfield Volume : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   1087: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   1090: checkcast java/lang/Number
/*    */     //   1093: invokevirtual floatValue : ()F
/*    */     //   1096: invokevirtual playSound : (Lme/sound/SoundPlayer$SoundType;F)V
/*    */     //   1099: goto -> 1186
/*    */     //   1102: new me/sound/SoundPlayer
/*    */     //   1105: dup
/*    */     //   1106: invokespecial <init> : ()V
/*    */     //   1109: getstatic me/sound/SoundPlayer$SoundType.FENGYUANWIN : Lme/sound/SoundPlayer$SoundType;
/*    */     //   1112: aload_0
/*    */     //   1113: getfield Volume : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   1116: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   1119: checkcast java/lang/Number
/*    */     //   1122: invokevirtual floatValue : ()F
/*    */     //   1125: invokevirtual playSound : (Lme/sound/SoundPlayer$SoundType;F)V
/*    */     //   1128: goto -> 1186
/*    */     //   1131: new me/sound/SoundPlayer
/*    */     //   1134: dup
/*    */     //   1135: invokespecial <init> : ()V
/*    */     //   1138: getstatic me/sound/SoundPlayer$SoundType.AISHIDAWIN : Lme/sound/SoundPlayer$SoundType;
/*    */     //   1141: aload_0
/*    */     //   1142: getfield Volume : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   1145: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   1148: checkcast java/lang/Number
/*    */     //   1151: invokevirtual floatValue : ()F
/*    */     //   1154: invokevirtual playSound : (Lme/sound/SoundPlayer$SoundType;F)V
/*    */     //   1157: goto -> 1186
/*    */     //   1160: new me/sound/SoundPlayer
/*    */     //   1163: dup
/*    */     //   1164: invokespecial <init> : ()V
/*    */     //   1167: getstatic me/sound/SoundPlayer$SoundType.LENGWIN : Lme/sound/SoundPlayer$SoundType;
/*    */     //   1170: aload_0
/*    */     //   1171: getfield Volume : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   1174: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   1177: checkcast java/lang/Number
/*    */     //   1180: invokevirtual floatValue : ()F
/*    */     //   1183: invokevirtual playSound : (Lme/sound/SoundPlayer$SoundType;F)V
/*    */     //   1186: aload_0
/*    */     //   1187: getfield Debug : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   1190: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   1193: checkcast java/lang/Boolean
/*    */     //   1196: invokevirtual booleanValue : ()Z
/*    */     //   1199: ifeq -> 1215
/*    */     //   1202: aload_0
/*    */     //   1203: ldc_w '恭喜胜利'
/*    */     //   1206: ldc_w 'XSJ 1.12.2'
/*    */     //   1209: getstatic java/awt/TrayIcon$MessageType.WARNING : Ljava/awt/TrayIcon$MessageType;
/*    */     //   1212: invokevirtual displayTray : (Ljava/lang/String;Ljava/lang/String;Ljava/awt/TrayIcon$MessageType;)V
/*    */     //   1215: aload_0
/*    */     //   1216: dup
/*    */     //   1217: getfield win : I
/*    */     //   1220: dup
/*    */     //   1221: istore #7
/*    */     //   1223: iconst_1
/*    */     //   1224: iadd
/*    */     //   1225: putfield win : I
/*    */     //   1228: aload_2
/*    */     //   1229: checkcast net/minecraft/network/play/server/SPacketChat
/*    */     //   1232: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*    */     //   1235: dup
/*    */     //   1236: ldc 'packet.chatComponent'
/*    */     //   1238: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   1241: invokeinterface func_150260_c : ()Ljava/lang/String;
/*    */     //   1246: dup
/*    */     //   1247: ldc 'packet.chatComponent.unformattedText'
/*    */     //   1249: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   1252: checkcast java/lang/CharSequence
/*    */     //   1255: ldc ':'
/*    */     //   1257: checkcast java/lang/CharSequence
/*    */     //   1260: iconst_0
/*    */     //   1261: iconst_2
/*    */     //   1262: aconst_null
/*    */     //   1263: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*    */     //   1266: ifne -> 1438
/*    */     //   1269: aload_3
/*    */     //   1270: dup
/*    */     //   1271: ldc 'text'
/*    */     //   1273: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   1276: checkcast java/lang/CharSequence
/*    */     //   1279: ldc_w '游戏开始'
/*    */     //   1282: checkcast java/lang/CharSequence
/*    */     //   1285: iconst_1
/*    */     //   1286: invokestatic contains : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Z
/*    */     //   1289: ifeq -> 1438
/*    */     //   1292: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*    */     //   1295: invokevirtual getHud : ()Lnet/ccbluex/liquidbounce/ui/client/hud/HUD;
/*    */     //   1298: new net/ccbluex/liquidbounce/ui/client/hud/element/elements/Notification
/*    */     //   1301: dup
/*    */     //   1302: ldc 'AutoGG'
/*    */     //   1304: ldc_w '游戏开始！！'
/*    */     //   1307: getstatic net/ccbluex/liquidbounce/ui/client/hud/element/elements/NotifyType.SUCCESS : Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/NotifyType;
/*    */     //   1310: iconst_0
/*    */     //   1311: iconst_0
/*    */     //   1312: bipush #24
/*    */     //   1314: aconst_null
/*    */     //   1315: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/NotifyType;IIILkotlin/jvm/internal/DefaultConstructorMarker;)V
/*    */     //   1318: invokevirtual addNotification : (Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Notification;)Z
/*    */     //   1321: pop
/*    */     //   1322: aload_0
/*    */     //   1323: getfield startmodeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*    */     //   1326: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   1329: checkcast java/lang/String
/*    */     //   1332: astore #4
/*    */     //   1334: iconst_0
/*    */     //   1335: istore #5
/*    */     //   1337: aload #4
/*    */     //   1339: dup
/*    */     //   1340: ifnonnull -> 1354
/*    */     //   1343: new kotlin/TypeCastException
/*    */     //   1346: dup
/*    */     //   1347: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*    */     //   1350: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   1353: athrow
/*    */     //   1354: invokevirtual toLowerCase : ()Ljava/lang/String;
/*    */     //   1357: dup
/*    */     //   1358: ldc_w '(this as java.lang.String).toLowerCase()'
/*    */     //   1361: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   1364: astore #4
/*    */     //   1366: aload #4
/*    */     //   1368: invokevirtual hashCode : ()I
/*    */     //   1371: tableswitch default -> 1425, 655488 -> 1388
/*    */     //   1388: aload #4
/*    */     //   1390: ldc_w '佩拉'
/*    */     //   1393: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   1396: ifeq -> 1425
/*    */     //   1399: new me/sound/SoundPlayer
/*    */     //   1402: dup
/*    */     //   1403: invokespecial <init> : ()V
/*    */     //   1406: getstatic me/sound/SoundPlayer$SoundType.PEILABEGIN : Lme/sound/SoundPlayer$SoundType;
/*    */     //   1409: aload_0
/*    */     //   1410: getfield Volume : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   1413: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   1416: checkcast java/lang/Number
/*    */     //   1419: invokevirtual floatValue : ()F
/*    */     //   1422: invokevirtual playSound : (Lme/sound/SoundPlayer$SoundType;F)V
/*    */     //   1425: aload_0
/*    */     //   1426: dup
/*    */     //   1427: getfield totalPlayed : I
/*    */     //   1430: dup
/*    */     //   1431: istore #4
/*    */     //   1433: iconst_1
/*    */     //   1434: iadd
/*    */     //   1435: putfield totalPlayed : I
/*    */     //   1438: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #46	-> 6
/*    */     //   #95	-> 14
/*    */     //   #46	-> 35
/*    */     //   #47	-> 36
/*    */     //   #48	-> 43
/*    */     //   #50	-> 62
/*    */     //   #51	-> 62
/*    */     //   #50	-> 62
/*    */     //   #51	-> 125
/*    */     //   #52	-> 193
/*    */     //   #53	-> 222
/*    */     //   #54	-> 252
/*    */     //   #55	-> 284
/*    */     //   #56	-> 316
/*    */     //   #57	-> 348
/*    */     //   #58	-> 354
/*    */     //   #59	-> 360
/*    */     //   #61	-> 366
/*    */     //   #74	-> 544
/*    */     //   #62	-> 558
/*    */     //   #76	-> 572
/*    */     //   #71	-> 586
/*    */     //   #68	-> 600
/*    */     //   #72	-> 614
/*    */     //   #64	-> 628
/*    */     //   #65	-> 642
/*    */     //   #66	-> 656
/*    */     //   #69	-> 670
/*    */     //   #75	-> 684
/*    */     //   #70	-> 698
/*    */     //   #63	-> 712
/*    */     //   #73	-> 726
/*    */     //   #67	-> 740
/*    */     //   #62	-> 754
/*    */     //   #63	-> 783
/*    */     //   #64	-> 812
/*    */     //   #65	-> 841
/*    */     //   #66	-> 870
/*    */     //   #67	-> 899
/*    */     //   #68	-> 928
/*    */     //   #69	-> 957
/*    */     //   #70	-> 986
/*    */     //   #71	-> 1015
/*    */     //   #72	-> 1044
/*    */     //   #73	-> 1073
/*    */     //   #74	-> 1102
/*    */     //   #75	-> 1131
/*    */     //   #76	-> 1160
/*    */     //   #77	-> 1186
/*    */     //   #78	-> 1186
/*    */     //   #79	-> 1202
/*    */     //   #81	-> 1215
/*    */     //   #83	-> 1228
/*    */     //   #84	-> 1292
/*    */     //   #85	-> 1322
/*    */     //   #86	-> 1388
/*    */     //   #87	-> 1425
/*    */     //   #88	-> 1425
/*    */     //   #91	-> 1438
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   11	24	3	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*    */     //   14	21	4	$i$f$unwrap	I
/*    */     //   348	880	6	chestaura	Lnet/ccbluex/liquidbounce/features/module/modules/world/ChestAura;
/*    */     //   316	912	5	invManager	Lnet/ccbluex/liquidbounce/features/module/modules/player/InvManager;
/*    */     //   284	944	4	stealerPlus	Lnet/ccbluex/liquidbounce/features/module/modules/player/StealerPlus;
/*    */     //   62	1376	3	text	Ljava/lang/String;
/*    */     //   36	1403	2	packet	Lnet/minecraft/network/Packet;
/*    */     //   0	1439	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/misc/AutoGG;
/*    */     //   0	1439	1	event	Lnet/ccbluex/liquidbounce/event/PacketEvent;
/*    */   }
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
/*    */   @NotNull
/*    */   public String getTag() {
/* 93 */     return "HuaYuTing";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\misc\AutoGG.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */