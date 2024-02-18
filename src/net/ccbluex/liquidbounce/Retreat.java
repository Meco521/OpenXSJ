package net.ccbluex.liquidbounce;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import courage.utils.WebUtils;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.api.Wrapper;
import net.ccbluex.liquidbounce.api.minecraft.util.IResourceLocation;
import net.ccbluex.liquidbounce.event.ClientShutdownEvent;
import net.ccbluex.liquidbounce.event.Event;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.event.Listenable;
import net.ccbluex.liquidbounce.features.command.CommandManager;
import net.ccbluex.liquidbounce.features.module.ModuleManager;
import net.ccbluex.liquidbounce.features.special.AntiForge;
import net.ccbluex.liquidbounce.features.special.BungeeCordSpoof;
import net.ccbluex.liquidbounce.features.special.DonatorCape;
import net.ccbluex.liquidbounce.file.FileConfig;
import net.ccbluex.liquidbounce.file.FileManager;
import net.ccbluex.liquidbounce.management.CombatManager;
import net.ccbluex.liquidbounce.management.MemoryManager;
import net.ccbluex.liquidbounce.script.ScriptManager;
import net.ccbluex.liquidbounce.script.remapper.Remapper;
import net.ccbluex.liquidbounce.ui.client.altmanager.GuiAltManager;
import net.ccbluex.liquidbounce.ui.client.clickgui.ClickGui;
import net.ccbluex.liquidbounce.ui.client.hud.HUD;
import net.ccbluex.liquidbounce.ui.font.FontLoaders;
import net.ccbluex.liquidbounce.ui.font.Fonts;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import net.ccbluex.liquidbounce.utils.InventoryUtils;
import net.ccbluex.liquidbounce.utils.RotationUtils;
import net.ccbluex.liquidbounce.utils.misc.sound.TipSoundManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.Display;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\001\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\002\b\f\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\005\n\002\020\007\n\002\b\005\n\002\030\002\n\002\b\005\n\002\020\013\n\002\b\004\n\002\020\b\n\002\b\b\n\002\030\002\n\002\b\005\n\002\020\t\n\002\b\b\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\b\n\002\030\002\n\002\b\005\n\002\020\002\n\002\b\003\b\002\030\0002\0020\001B\007\b\002\006\002\020\002J\006\020w\032\0020xJ\006\020y\032\0020xJ\020\020z\032\0020\0042\b\020z\032\004\030\0010\004R\016\020\003\032\0020\004X\006\002\n\000R\016\020\005\032\0020\004X\006\002\n\000R\032\020\006\032\0020\004X\016\006\016\n\000\032\004\b\007\020\b\"\004\b\t\020\nR\016\020\013\032\0020\004X\006\002\n\000R\016\020\f\032\0020\004X\006\002\n\000R\016\020\r\032\0020\004X\006\002\n\000R\016\020\016\032\0020\004X\006\002\n\000R\016\020\017\032\0020\004X\006\002\n\000R!\020\020\032\022\022\004\022\0020\0040\021j\b\022\004\022\0020\004`\022\006\b\n\000\032\004\b\023\020\024R\034\020\025\032\004\030\0010\026X\016\006\016\n\000\032\004\b\027\020\030\"\004\b\031\020\032R\032\020\033\032\0020\034X\006\016\n\000\032\004\b\035\020\036\"\004\b\037\020 R\032\020!\032\0020\"X\006\016\n\000\032\004\b#\020$\"\004\b%\020&R\032\020'\032\0020(X\006\016\n\000\032\004\b)\020*\"\004\b+\020,R\032\020-\032\0020.X\006\016\n\000\032\004\b/\0200\"\004\b1\0202R\032\0203\032\00204X\006\016\n\000\032\004\b5\0206\"\004\b7\0208R\032\0209\032\0020:X\016\006\016\n\000\032\004\b;\020<\"\004\b=\020>R\032\020?\032\0020@X\006\016\n\000\032\004\bA\020B\"\004\bC\020DR\032\020E\032\0020FX\016\006\016\n\000\032\004\bE\020G\"\004\bH\020IR\032\020J\032\0020KX\016\006\016\n\000\032\004\bL\020M\"\004\bN\020OR\032\020P\032\0020FX\016\006\016\n\000\032\004\bQ\020G\"\004\bR\020IR\032\020S\032\0020TX\006\016\n\000\032\004\bU\020V\"\004\bW\020XR\032\020Y\032\0020ZX\016\006\016\n\000\032\004\b[\020\\\"\004\b]\020^R\032\020_\032\0020\004X\006\016\n\000\032\004\b`\020\b\"\004\ba\020\nR\032\020b\032\0020cX\006\016\n\000\032\004\bd\020e\"\004\bf\020gR\032\020h\032\0020iX\006\016\n\000\032\004\bj\020k\"\004\bl\020mR\032\020n\032\0020\004X\006\016\n\000\032\004\bo\020\b\"\004\bp\020\nR\032\020q\032\0020rX\006\016\n\000\032\004\bs\020t\"\004\bu\020v\006{"}, d2 = {"Lnet/ccbluex/liquidbounce/Retreat;", "", "()V", "CLIENT_CLOUD", "", "CLIENT_CREATOR", "CLIENT_J", "getCLIENT_J", "()Ljava/lang/String;", "setCLIENT_J", "(Ljava/lang/String;)V", "CLIENT_NAME", "CLIENT_NAME2", "CLIENT_TIME", "CLIENT_VERSIO", "CLIENT_VERSION", "UPDATE_LIST", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getUPDATE_LIST", "()Ljava/util/ArrayList;", "background", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;", "getBackground", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;", "setBackground", "(Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;)V", "clickGui", "Lnet/ccbluex/liquidbounce/ui/client/clickgui/ClickGui;", "getClickGui", "()Lnet/ccbluex/liquidbounce/ui/client/clickgui/ClickGui;", "setClickGui", "(Lnet/ccbluex/liquidbounce/ui/client/clickgui/ClickGui;)V", "combatManager", "Lnet/ccbluex/liquidbounce/management/CombatManager;", "getCombatManager", "()Lnet/ccbluex/liquidbounce/management/CombatManager;", "setCombatManager", "(Lnet/ccbluex/liquidbounce/management/CombatManager;)V", "commandManager", "Lnet/ccbluex/liquidbounce/features/command/CommandManager;", "getCommandManager", "()Lnet/ccbluex/liquidbounce/features/command/CommandManager;", "setCommandManager", "(Lnet/ccbluex/liquidbounce/features/command/CommandManager;)V", "eventManager", "Lnet/ccbluex/liquidbounce/event/EventManager;", "getEventManager", "()Lnet/ccbluex/liquidbounce/event/EventManager;", "setEventManager", "(Lnet/ccbluex/liquidbounce/event/EventManager;)V", "fileManager", "Lnet/ccbluex/liquidbounce/file/FileManager;", "getFileManager", "()Lnet/ccbluex/liquidbounce/file/FileManager;", "setFileManager", "(Lnet/ccbluex/liquidbounce/file/FileManager;)V", "height", "", "getHeight", "()F", "setHeight", "(F)V", "hud", "Lnet/ccbluex/liquidbounce/ui/client/hud/HUD;", "getHud", "()Lnet/ccbluex/liquidbounce/ui/client/hud/HUD;", "setHud", "(Lnet/ccbluex/liquidbounce/ui/client/hud/HUD;)V", "isStarting", "", "()Z", "setStarting", "(Z)V", "latestVersion", "", "getLatestVersion", "()I", "setLatestVersion", "(I)V", "mainMenuPrep", "getMainMenuPrep", "setMainMenuPrep", "moduleManager", "Lnet/ccbluex/liquidbounce/features/module/ModuleManager;", "getModuleManager", "()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;", "setModuleManager", "(Lnet/ccbluex/liquidbounce/features/module/ModuleManager;)V", "playTimeStart", "", "getPlayTimeStart", "()J", "setPlayTimeStart", "(J)V", "qq", "getQq", "setQq", "scriptManager", "Lnet/ccbluex/liquidbounce/script/ScriptManager;", "getScriptManager", "()Lnet/ccbluex/liquidbounce/script/ScriptManager;", "setScriptManager", "(Lnet/ccbluex/liquidbounce/script/ScriptManager;)V", "tipSoundManager", "Lnet/ccbluex/liquidbounce/utils/misc/sound/TipSoundManager;", "getTipSoundManager", "()Lnet/ccbluex/liquidbounce/utils/misc/sound/TipSoundManager;", "setTipSoundManager", "(Lnet/ccbluex/liquidbounce/utils/misc/sound/TipSoundManager;)V", "user", "getUser", "setUser", "wrapper", "Lnet/ccbluex/liquidbounce/api/Wrapper;", "getWrapper", "()Lnet/ccbluex/liquidbounce/api/Wrapper;", "setWrapper", "(Lnet/ccbluex/liquidbounce/api/Wrapper;)V", "startClient", "", "stopClient", "wight", "XSJClient"})
public final class Retreat {
    @NotNull
    public static final String CLIENT_NAME = "XSJ Client";

    @NotNull
    public static final String CLIENT_NAME2 = "XSJ Client";

    @NotNull
    public static final String CLIENT_TIME = "v2.3 New Year!! 2024New Year's Special Edition by;

    @NotNull
    public static final String CLIENT_VERSION = "v2.3 New Year's Special Edition";

    @NotNull
    public static final String CLIENT_VERSIO = "v2.3 New Year's Special Edition";

    @NotNull
    public static final String CLIENT_CREATOR = ";

    @NotNull
    public static final String CLIENT_CLOUD = "https://cloud.liquidbounce.net/LiquidBounce";

    static {
        Retreat retreat = new Retreat();
    }

    @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\026\n\000\n\002\020\002\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\0032\006\020\004\032\0020\0032\b\020\005\032\004\030\0010\006H\n\006\002\b\007"}, d2 = {"displayTray", "", "Title", "", "Text", "type", "Ljava/awt/TrayIcon$MessageType;", "invoke"})
    static final class Retreat$startClient$1 extends Lambda implements Function3<String, String, TrayIcon.MessageType, Unit> {
        public static final Retreat$startClient$1 INSTANCE = new Retreat$startClient$1();

        public final void invoke(@NotNull String Title, @NotNull String Text, @Nullable TrayIcon.MessageType type) {
            Intrinsics.checkParameterIsNotNull(Title, "Title");
            Intrinsics.checkParameterIsNotNull(Text, "Text");
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
            TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("System tray icon demo");
            tray.add(trayIcon);
            trayIcon.displayMessage(Title, Text, type);
        }

        Retreat$startClient$1() {
            super(3);
        }
    }

    @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\n\n\000\n\002\020\016\n\002\b\004\020\000\032\004\030\0010\0012\006\020\002\032\0020\0012\b\020\003\032\004\030\0010\0012\b\020\004\032\004\030\0010\001H\n\006\002\b\005"}, d2 = {"getSubString", "", "text", "left", "right", "invoke"})
    static final class Retreat$startClient$2 extends Lambda implements Function3<String, String, String, String> {
        public static final Retreat$startClient$2 INSTANCE = new Retreat$startClient$2();

        @Nullable
        public final String invoke(@NotNull String text, @Nullable String left, @Nullable String right) {
            // Byte code:
            //   0: aload_1
            //   1: ldc 'text'
            //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
            //   6: ldc ''
            //   8: astore #4
            //   10: iconst_0
            //   11: istore #5
            //   13: aload_2
            //   14: ifnull -> 44
            //   17: aload_2
            //   18: checkcast java/lang/CharSequence
            //   21: astore #6
            //   23: iconst_0
            //   24: istore #7
            //   26: aload #6
            //   28: invokeinterface length : ()I
            //   33: ifne -> 40
            //   36: iconst_1
            //   37: goto -> 41
            //   40: iconst_0
            //   41: ifeq -> 50
            //   44: iconst_0
            //   45: istore #5
            //   47: goto -> 86
            //   50: aload_1
            //   51: checkcast java/lang/CharSequence
            //   54: aload_2
            //   55: iconst_0
            //   56: iconst_0
            //   57: bipush #6
            //   59: aconst_null
            //   60: invokestatic indexOf$default : (Ljava/lang/CharSequence;Ljava/lang/String;IZILjava/lang/Object;)I
            //   63: istore #5
            //   65: iload #5
            //   67: iconst_m1
            //   68: if_icmple -> 83
            //   71: iload #5
            //   73: aload_2
            //   74: invokevirtual length : ()I
            //   77: iadd
            //   78: istore #5
            //   80: goto -> 86
            //   83: iconst_0
            //   84: istore #5
            //   86: aload_1
            //   87: checkcast java/lang/CharSequence
            //   90: aload_3
            //   91: dup
            //   92: ifnonnull -> 98
            //   95: invokestatic throwNpe : ()V
            //   98: iload #5
            //   100: iconst_0
            //   101: iconst_4
            //   102: aconst_null
            //   103: invokestatic indexOf$default : (Ljava/lang/CharSequence;Ljava/lang/String;IZILjava/lang/Object;)I
            //   106: istore #6
            //   108: iload #6
            //   110: iflt -> 140
            //   113: aload_3
            //   114: checkcast java/lang/CharSequence
            //   117: astore #7
            //   119: iconst_0
            //   120: istore #8
            //   122: aload #7
            //   124: invokeinterface length : ()I
            //   129: ifne -> 136
            //   132: iconst_1
            //   133: goto -> 137
            //   136: iconst_0
            //   137: ifeq -> 146
            //   140: aload_1
            //   141: invokevirtual length : ()I
            //   144: istore #6
            //   146: aload_1
            //   147: astore #7
            //   149: iconst_0
            //   150: istore #8
            //   152: aload #7
            //   154: iload #5
            //   156: iload #6
            //   158: invokevirtual substring : (II)Ljava/lang/String;
            //   161: dup
            //   162: ldc '(this as java.lang.StrinendIndex)'
            //   164: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
            //   167: astore #4
            //   169: aload #4
            //   171: areturn
            // Line number table:
            //   Java source line number -> byte code offset
            //   #115	-> 6
            //   #116	-> 10
            //   #117	-> 13
            //   #118	-> 44
            //   #120	-> 50
            //   #121	-> 65
            //   #122	-> 71
            //   #124	-> 83
            //   #125	-> 86
            //   #126	-> 86
            //   #127	-> 86
            //   #128	-> 108
            //   #129	-> 140
            //   #131	-> 146
            //   #132	-> 169
            // Local variable table:
            //   start	length	slot	name	descriptor
            //   108	64	6	yLen	I
            //   13	159	5	zLen	I
            //   10	162	4	result	Ljava/lang/String;
            //   0	172	0	this	Lnet/ccbluex/liquidbounce/Retreat$startClient$2;
            //   0	172	1	text	Ljava/lang/String;
            //   0	172	2	left	Ljava/lang/String;
            //   0	172	3	right	Ljava/lang/String;
        }

        Retreat$startClient$2() {
            super(3);
        }
    }

    @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\016\n\000\n\002\020\013\n\000\n\002\020\016\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n\006\002\b\004"}, d2 = {"_filterQQInfo", "", "windowText", "", "invoke"})
    static final class Retreat$startClient$3 extends Lambda implements Function1<String, Boolean> {
        public static final Retreat$startClient$3 INSTANCE = new Retreat$startClient$3();

        public final boolean invoke(@NotNull String windowText) {
            Intrinsics.checkParameterIsNotNull(windowText, "windowText");
            return StringsKt.startsWith$default(windowText, "qqexchangewnd_shortcut_prefix_", false, 2, null);
        }

        Retreat$startClient$3() {
            super(1);
        }
    }

    @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\f\n\000\n\002\020$\n\002\020\016\n\000\020\000\032\020\022\004\022\0020\002\022\004\022\0020\002\030\0010\001H\n\006\002\b\003"}, d2 = {"getLoginQQList", "", "", "invoke"})
    static final class Retreat$startClient$4 extends Lambda implements Function0<Map<String, ? extends String>> {
        @Nullable
        public final Map<String, String> invoke() {
            String[] QQNumber1 = new String[1];
            Map<Object, Object> map = new HashMap<>(5);
            WebUtils.User32 user32 = WebUtils.User32.INSTANCE;
            user32.EnumWindows(new WebUtils.User32.WNDENUMPROC(user32, map, QQNumber1) {
                public final boolean callback(@NotNull Pointer hWnd, @Nullable Pointer userData) {
                    Intrinsics.checkParameterIsNotNull(hWnd, "hWnd");
                    byte[] windowText = new byte[512];
                    this.$user32.GetWindowTextA(hWnd, windowText, 512);
                    String wText = Native.toString(windowText);
                    Intrinsics.checkExpressionValueIsNotNull(wText, "wText");
                    if (Retreat$startClient$3.INSTANCE.invoke(wText)) {
                        Intrinsics.checkExpressionValueIsNotNull(hWnd.toString(), "hWnd.toString()");
                        String str1 = wText;
                        int i = StringsKt.indexOf$default(wText, "qqexchangewnd_shortcut_prefix_", 0, false, 6, null) + "qqexchangewnd_shortcut_prefix_".length();
                        String str2 = hWnd.toString();
                        Map<String, String> map = this.$map;
                        boolean bool = false;
                        Intrinsics.checkExpressionValueIsNotNull(str1.substring(i), "(this as java.lang.String).substring(startIndex)");
                        String str3 = str1.substring(i);
                        map.put(str2, str3);
                    }
                    this.$QQNumber1[0] = Retreat$startClient$2.INSTANCE.invoke(this.$map.toString(), "=", "}");
                    Retreat$startClient$4.this.$QQNumber.element = String.valueOf(this.$QQNumber1[0]);
                    return true;
                }
            }null);
            return (Map)map;
        }

        Retreat$startClient$4(Ref.ObjectRef param1ObjectRef) {
            super(0);
        }
    }

    @NotNull
    private static final ArrayList<String> UPDATE_LIST = CollectionsKt.arrayListOf((Object[])new String[] { "2.3 New Year!! 2024, "Ft.XSJ", "New Year's Special Edition", "by, "Invited Consultants:lovely , ", ", ", "});

    private static boolean isStarting;

    @NotNull
    public final ArrayList<String> getUPDATE_LIST() {
        return UPDATE_LIST;
    }

    public final boolean isStarting() {
        return isStarting;
    }

    public final void setStarting(boolean <set-?>) {
        isStarting = <set-?>;
    }

    private static float height = -14.0F;

    @NotNull
    public static ModuleManager moduleManager;

    @NotNull
    public static CommandManager commandManager;

    @NotNull
    public static EventManager eventManager;

    @NotNull
    public static FileManager fileManager;

    @NotNull
    public static ScriptManager scriptManager;

    @NotNull
    public static CombatManager combatManager;

    @NotNull
    public static TipSoundManager tipSoundManager;

    @NotNull
    public static String user;

    @NotNull
    public static String qq;

    @NotNull
    public static HUD hud;

    private static boolean mainMenuPrep;

    private static long playTimeStart;

    @NotNull
    public static ClickGui clickGui;

    @NotNull
    public static Wrapper wrapper;

    private static int latestVersion;

    @Nullable
    private static IResourceLocation background;

    public final float getHeight() {
        return height;
    }

    public final void setHeight(float <set-?>) {
        height = <set-?>;
    }

    @NotNull
    public final ModuleManager getModuleManager() {
        if (moduleManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("moduleManager");
        return moduleManager;
    }

    public final void setModuleManager(@NotNull ModuleManager <set-?>) {
        Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
        moduleManager = <set-?>;
    }

    @NotNull
    public final CommandManager getCommandManager() {
        if (commandManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("commandManager");
        return commandManager;
    }

    public final void setCommandManager(@NotNull CommandManager <set-?>) {
        Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
        commandManager = <set-?>;
    }

    @NotNull
    public final EventManager getEventManager() {
        if (eventManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("eventManager");
        return eventManager;
    }

    public final void setEventManager(@NotNull EventManager <set-?>) {
        Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
        eventManager = <set-?>;
    }

    @NotNull
    public final FileManager getFileManager() {
        if (fileManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("fileManager");
        return fileManager;
    }

    public final void setFileManager(@NotNull FileManager <set-?>) {
        Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
        fileManager = <set-?>;
    }

    @NotNull
    public final ScriptManager getScriptManager() {
        if (scriptManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("scriptManager");
        return scriptManager;
    }

    public final void setScriptManager(@NotNull ScriptManager <set-?>) {
        Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
        scriptManager = <set-?>;
    }

    @NotNull
    public final CombatManager getCombatManager() {
        if (combatManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("combatManager");
        return combatManager;
    }

    public final void setCombatManager(@NotNull CombatManager <set-?>) {
        Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
        combatManager = <set-?>;
    }

    @NotNull
    public final TipSoundManager getTipSoundManager() {
        if (tipSoundManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("tipSoundManager");
        return tipSoundManager;
    }

    public final void setTipSoundManager(@NotNull TipSoundManager <set-?>) {
        Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
        tipSoundManager = <set-?>;
    }

    @NotNull
    public final String getUser() {
        if (user == null)
            Intrinsics.throwUninitializedPropertyAccessException("user");
        return user;
    }

    public final void setUser(@NotNull String <set-?>) {
        Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
        user = <set-?>;
    }

    @NotNull
    public final String getQq() {
        if (qq == null)
            Intrinsics.throwUninitializedPropertyAccessException("qq");
        return qq;
    }

    public final void setQq(@NotNull String <set-?>) {
        Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
        qq = <set-?>;
    }

    @NotNull
    public final HUD getHud() {
        if (hud == null)
            Intrinsics.throwUninitializedPropertyAccessException("hud");
        return hud;
    }

    public final void setHud(@NotNull HUD <set-?>) {
        Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
        hud = <set-?>;
    }

    public final boolean getMainMenuPrep() {
        return mainMenuPrep;
    }

    public final void setMainMenuPrep(boolean <set-?>) {
        mainMenuPrep = <set-?>;
    }

    public final long getPlayTimeStart() {
        return playTimeStart;
    }

    public final void setPlayTimeStart(long <set-?>) {
        playTimeStart = <set-?>;
    }

    @NotNull
    public final ClickGui getClickGui() {
        if (clickGui == null)
            Intrinsics.throwUninitializedPropertyAccessException("clickGui");
        return clickGui;
    }

    public final void setClickGui(@NotNull ClickGui <set-?>) {
        Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
        clickGui = <set-?>;
    }

    @NotNull
    public final Wrapper getWrapper() {
        if (wrapper == null)
            Intrinsics.throwUninitializedPropertyAccessException("wrapper");
        return wrapper;
    }

    public final void setWrapper(@NotNull Wrapper <set-?>) {
        Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
        wrapper = <set-?>;
    }

    public final int getLatestVersion() {
        return latestVersion;
    }

    public final void setLatestVersion(int <set-?>) {
        latestVersion = <set-?>;
    }

    @Nullable
    public final IResourceLocation getBackground() {
        return background;
    }

    public final void setBackground(@Nullable IResourceLocation <set-?>) {
        background = <set-?>;
    }

    @NotNull
    private static String CLIENT_J = "XSJ";

    public static final Retreat INSTANCE;

    @NotNull
    public final String getCLIENT_J() {
        return CLIENT_J;
    }

    public final void setCLIENT_J(@NotNull String <set-?>) {
        Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
        CLIENT_J = <set-?>;
    }

    public final void startClient() {
        isStarting = true;
        ClientUtils.getLogger().info("Starting XSJ Client bv2.3 New Year's Special Edition, by );
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "dawdaw";
        Retreat$startClient$1 $fun$displayTray$1 = Retreat$startClient$1.INSTANCE;
        Retreat$startClient$2 $fun$getSubString$2 = Retreat$startClient$2.INSTANCE;
        Retreat$startClient$3 $fun$_filterQQInfo$3 = Retreat$startClient$3.INSTANCE;
        Retreat$startClient$4 $fun$getLoginQQList$4 = new Retreat$startClient$4(objectRef);
        $fun$getLoginQQList$4.invoke();
        Display.setTitle("XSJ Client");
        long start = System.currentTimeMillis();
        isStarting = true;
        ClientUtils.getLogger().info("Starting XSJ Client v2.3 New Year's Special Editionr, by );
                fileManager = new FileManager();
        tipSoundManager = new TipSoundManager();
        eventManager = new EventManager();
        combatManager = new CombatManager();
        if (eventManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("eventManager");
        eventManager.registerListener((Listenable)new RotationUtils());
        if (eventManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("eventManager");
        eventManager.registerListener((Listenable)new AntiForge());
        if (eventManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("eventManager");
        eventManager.registerListener((Listenable)new BungeeCordSpoof());
        if (eventManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("eventManager");
        eventManager.registerListener((Listenable)new InventoryUtils());
        if (eventManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("eventManager");
        if (combatManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("combatManager");
        eventManager.registerListener((Listenable)combatManager);
        if (eventManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("eventManager");
        eventManager.registerListener((Listenable)new DonatorCape());
        if (eventManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("eventManager");
        eventManager.registerListener((Listenable)new MemoryManager());
        commandManager = new CommandManager();
        Fonts.loadFonts();
        FontLoaders.initFonts();
        moduleManager = new ModuleManager();
        if (moduleManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("moduleManager");
        moduleManager.registerModules();
        try {
            Remapper.INSTANCE.loadSrg();
            scriptManager = new ScriptManager();
            if (scriptManager == null)
                Intrinsics.throwUninitializedPropertyAccessException("scriptManager");
            scriptManager.loadScripts();
            if (scriptManager == null)
                Intrinsics.throwUninitializedPropertyAccessException("scriptManager");
            scriptManager.enableScripts();
        } catch (Throwable throwable) {
            ClientUtils.getLogger().error("Failed to load scripts.", throwable);
        }
        if (commandManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("commandManager");
        commandManager.registerCommands();
        if (fileManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("fileManager");
        if (fileManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("fileManager");
        (new FileConfig[4])[0] = fileManager.valuesConfig;
        if (fileManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("fileManager");
        (new FileConfig[4])[1] = (FileConfig)fileManager.accountsConfig;
        if (fileManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("fileManager");
        (new FileConfig[4])[2] = (FileConfig)fileManager.friendsConfig;
        if (fileManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("fileManager");
        fileManager.loadConfigs(new FileConfig[] { null, null, null, fileManager.xrayConfig });
        clickGui = new ClickGui();
        if (fileManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("fileManager");
        if (fileManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("fileManager");
        fileManager.loadConfig(fileManager.clickGuiConfig);
        hud = HUD.Companion.createDefault();
        if (fileManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("fileManager");
        if (fileManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("fileManager");
        fileManager.loadConfig(fileManager.hudConfig);
        ClientUtils.disableFastRender();
        GuiAltManager.loadGenerators();
        try {
            if (StringsKt.contains$default(wight("https://gitcode.net/liufanzhubo/xsj-client-yes/-/raw/master/QQ"), (CharSequence)objectRef.element, false, 2, null)) {
                $fun$displayTray$1.invoke("1.12.2", "XSJ 1.12.2", TrayIcon.MessageType.WARNING);
            } else {
                $fun$displayTray$1.invoke("XSJ 1.12.2", "XSJ Client", TrayIcon.MessageType.ERROR);
                JOptionPane.showMessageDialog(null, ", "QQ", 0);
                boolean bool1 = false, bool2 = false;
                System.exit(bool1);
                throw (Throwable)new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, ", "XSJ 1.12.2", 0);
            boolean bool1 = false, bool2 = false;
            System.exit(bool1);
            throw (Throwable)new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
        isStarting = false;
    }

    public final void stopClient() {
        if (eventManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("eventManager");
        eventManager.callEvent((Event)new ClientShutdownEvent());
        if (fileManager == null)
            Intrinsics.throwUninitializedPropertyAccessException("fileManager");
        fileManager.saveAllConfigs();
    }

    @NotNull
    public final String wight(@Nullable String wight) {
        if ((new URL(wight)).openConnection() == null)
            throw new TypeCastException("null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection con = (HttpURLConnection)(new URL(wight)).openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        Ref.ObjectRef inputLine = new Ref.ObjectRef();
        StringBuilder response = new StringBuilder();
        while (true) {
            String str1 = in.readLine();
            boolean bool1 = false, bool2 = false;
            String it = str1;
            int $i$a$-also-Retreat$wight$1 = 0;
            inputLine.element = it;
            if (str1 != null) {
                response.append((String)inputLine.element);
                response.append("\n");
                continue;
            }
            break;
        }
        in.close();
        Intrinsics.checkExpressionValueIsNotNull(response.toString(), "response.toString()");
        return response.toString();
    }
}
