/*     */ package net.ccbluex.liquidbounce.features.command.commands;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.features.command.Command;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\021\n\002\020\016\n\002\b\002\n\002\020 \n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\033\020\003\032\0020\0042\f\020\005\032\b\022\004\022\0020\0070\006H\026¢\006\002\020\bJ!\020\t\032\b\022\004\022\0020\0070\n2\f\020\005\032\b\022\004\022\0020\0070\006H\026¢\006\002\020\013¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/features/command/commands/ScriptManagerCommand;", "Lnet/ccbluex/liquidbounce/features/command/Command;", "()V", "execute", "", "args", "", "", "([Ljava/lang/String;)V", "tabComplete", "", "([Ljava/lang/String;)Ljava/util/List;", "XSJClient"})
/*     */ public final class ScriptManagerCommand extends Command {
/*     */   public ScriptManagerCommand() {
/*  16 */     super("scriptmanager", new String[] { "scripts" });
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
/*     */   public void execute(@NotNull String[] args) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'args'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: aload_1
/*     */     //   7: arraylength
/*     */     //   8: iconst_1
/*     */     //   9: if_icmple -> 1047
/*     */     //   12: nop
/*     */     //   13: aload_1
/*     */     //   14: iconst_1
/*     */     //   15: aaload
/*     */     //   16: ldc 'import'
/*     */     //   18: iconst_1
/*     */     //   19: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   22: ifeq -> 477
/*     */     //   25: nop
/*     */     //   26: invokestatic openFileChooser : ()Ljava/io/File;
/*     */     //   29: dup
/*     */     //   30: ifnull -> 36
/*     */     //   33: goto -> 38
/*     */     //   36: pop
/*     */     //   37: return
/*     */     //   38: astore_2
/*     */     //   39: aload_2
/*     */     //   40: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   43: astore_3
/*     */     //   44: aload_3
/*     */     //   45: dup
/*     */     //   46: ldc 'fileName'
/*     */     //   48: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   51: ldc '.js'
/*     */     //   53: iconst_0
/*     */     //   54: iconst_2
/*     */     //   55: aconst_null
/*     */     //   56: invokestatic endsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*     */     //   59: ifeq -> 110
/*     */     //   62: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   65: invokevirtual getScriptManager : ()Lnet/ccbluex/liquidbounce/script/ScriptManager;
/*     */     //   68: aload_2
/*     */     //   69: invokevirtual importScript : (Ljava/io/File;)V
/*     */     //   72: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   75: new net/ccbluex/liquidbounce/ui/client/clickgui/ClickGui
/*     */     //   78: dup
/*     */     //   79: invokespecial <init> : ()V
/*     */     //   82: invokevirtual setClickGui : (Lnet/ccbluex/liquidbounce/ui/client/clickgui/ClickGui;)V
/*     */     //   85: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   88: invokevirtual getFileManager : ()Lnet/ccbluex/liquidbounce/file/FileManager;
/*     */     //   91: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   94: invokevirtual getFileManager : ()Lnet/ccbluex/liquidbounce/file/FileManager;
/*     */     //   97: getfield clickGuiConfig : Lnet/ccbluex/liquidbounce/file/FileConfig;
/*     */     //   100: invokevirtual loadConfig : (Lnet/ccbluex/liquidbounce/file/FileConfig;)V
/*     */     //   103: aload_0
/*     */     //   104: ldc 'Successfully imported script.'
/*     */     //   106: invokevirtual chat : (Ljava/lang/String;)V
/*     */     //   109: return
/*     */     //   110: aload_3
/*     */     //   111: ldc '.zip'
/*     */     //   113: iconst_0
/*     */     //   114: iconst_2
/*     */     //   115: aconst_null
/*     */     //   116: invokestatic endsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*     */     //   119: ifeq -> 417
/*     */     //   122: new java/util/zip/ZipFile
/*     */     //   125: dup
/*     */     //   126: aload_2
/*     */     //   127: invokespecial <init> : (Ljava/io/File;)V
/*     */     //   130: astore #4
/*     */     //   132: aload #4
/*     */     //   134: invokevirtual entries : ()Ljava/util/Enumeration;
/*     */     //   137: astore #5
/*     */     //   139: new java/util/ArrayList
/*     */     //   142: dup
/*     */     //   143: invokespecial <init> : ()V
/*     */     //   146: astore #6
/*     */     //   148: aload #5
/*     */     //   150: invokeinterface hasMoreElements : ()Z
/*     */     //   155: ifeq -> 297
/*     */     //   158: aload #5
/*     */     //   160: invokeinterface nextElement : ()Ljava/lang/Object;
/*     */     //   165: checkcast java/util/zip/ZipEntry
/*     */     //   168: astore #7
/*     */     //   170: aload #7
/*     */     //   172: dup
/*     */     //   173: ldc 'entry'
/*     */     //   175: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   178: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   181: astore #8
/*     */     //   183: new java/io/File
/*     */     //   186: dup
/*     */     //   187: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   190: invokevirtual getScriptManager : ()Lnet/ccbluex/liquidbounce/script/ScriptManager;
/*     */     //   193: invokevirtual getScriptsFolder : ()Ljava/io/File;
/*     */     //   196: aload #8
/*     */     //   198: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
/*     */     //   201: astore #9
/*     */     //   203: aload #7
/*     */     //   205: invokevirtual isDirectory : ()Z
/*     */     //   208: ifeq -> 220
/*     */     //   211: aload #9
/*     */     //   213: invokevirtual mkdir : ()Z
/*     */     //   216: pop
/*     */     //   217: goto -> 148
/*     */     //   220: aload #4
/*     */     //   222: aload #7
/*     */     //   224: invokevirtual getInputStream : (Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
/*     */     //   227: astore #10
/*     */     //   229: new java/io/FileOutputStream
/*     */     //   232: dup
/*     */     //   233: aload #9
/*     */     //   235: invokespecial <init> : (Ljava/io/File;)V
/*     */     //   238: astore #11
/*     */     //   240: aload #10
/*     */     //   242: aload #11
/*     */     //   244: checkcast java/io/OutputStream
/*     */     //   247: invokestatic copy : (Ljava/io/InputStream;Ljava/io/OutputStream;)I
/*     */     //   250: pop
/*     */     //   251: aload #11
/*     */     //   253: invokevirtual close : ()V
/*     */     //   256: aload #10
/*     */     //   258: invokevirtual close : ()V
/*     */     //   261: aload #8
/*     */     //   263: dup
/*     */     //   264: ldc 'entryName'
/*     */     //   266: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   269: checkcast java/lang/CharSequence
/*     */     //   272: ldc '/'
/*     */     //   274: checkcast java/lang/CharSequence
/*     */     //   277: iconst_0
/*     */     //   278: iconst_2
/*     */     //   279: aconst_null
/*     */     //   280: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   283: ifne -> 294
/*     */     //   286: aload #6
/*     */     //   288: aload #9
/*     */     //   290: invokevirtual add : (Ljava/lang/Object;)Z
/*     */     //   293: pop
/*     */     //   294: goto -> 148
/*     */     //   297: aload #6
/*     */     //   299: checkcast java/lang/Iterable
/*     */     //   302: astore #7
/*     */     //   304: iconst_0
/*     */     //   305: istore #8
/*     */     //   307: aload #7
/*     */     //   309: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   314: astore #9
/*     */     //   316: aload #9
/*     */     //   318: invokeinterface hasNext : ()Z
/*     */     //   323: ifeq -> 360
/*     */     //   326: aload #9
/*     */     //   328: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   333: astore #10
/*     */     //   335: aload #10
/*     */     //   337: checkcast java/io/File
/*     */     //   340: astore #11
/*     */     //   342: iconst_0
/*     */     //   343: istore #12
/*     */     //   345: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   348: invokevirtual getScriptManager : ()Lnet/ccbluex/liquidbounce/script/ScriptManager;
/*     */     //   351: aload #11
/*     */     //   353: invokevirtual loadScript : (Ljava/io/File;)V
/*     */     //   356: nop
/*     */     //   357: goto -> 316
/*     */     //   360: nop
/*     */     //   361: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   364: new net/ccbluex/liquidbounce/ui/client/clickgui/ClickGui
/*     */     //   367: dup
/*     */     //   368: invokespecial <init> : ()V
/*     */     //   371: invokevirtual setClickGui : (Lnet/ccbluex/liquidbounce/ui/client/clickgui/ClickGui;)V
/*     */     //   374: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   377: invokevirtual getFileManager : ()Lnet/ccbluex/liquidbounce/file/FileManager;
/*     */     //   380: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   383: invokevirtual getFileManager : ()Lnet/ccbluex/liquidbounce/file/FileManager;
/*     */     //   386: getfield clickGuiConfig : Lnet/ccbluex/liquidbounce/file/FileConfig;
/*     */     //   389: invokevirtual loadConfig : (Lnet/ccbluex/liquidbounce/file/FileConfig;)V
/*     */     //   392: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   395: invokevirtual getFileManager : ()Lnet/ccbluex/liquidbounce/file/FileManager;
/*     */     //   398: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   401: invokevirtual getFileManager : ()Lnet/ccbluex/liquidbounce/file/FileManager;
/*     */     //   404: getfield hudConfig : Lnet/ccbluex/liquidbounce/file/FileConfig;
/*     */     //   407: invokevirtual loadConfig : (Lnet/ccbluex/liquidbounce/file/FileConfig;)V
/*     */     //   410: aload_0
/*     */     //   411: ldc 'Successfully imported script.'
/*     */     //   413: invokevirtual chat : (Ljava/lang/String;)V
/*     */     //   416: return
/*     */     //   417: aload_0
/*     */     //   418: ldc 'The file extension has to be .js or .zip'
/*     */     //   420: invokevirtual chat : (Ljava/lang/String;)V
/*     */     //   423: goto -> 1046
/*     */     //   426: astore_2
/*     */     //   427: invokestatic getLogger : ()Lorg/apache/logging/log4j/Logger;
/*     */     //   430: ldc 'Something went wrong while importing a script.'
/*     */     //   432: aload_2
/*     */     //   433: invokeinterface error : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   438: aload_0
/*     */     //   439: new java/lang/StringBuilder
/*     */     //   442: dup
/*     */     //   443: invokespecial <init> : ()V
/*     */     //   446: aload_2
/*     */     //   447: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   450: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   453: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   456: ldc ': '
/*     */     //   458: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   461: aload_2
/*     */     //   462: invokevirtual getMessage : ()Ljava/lang/String;
/*     */     //   465: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   468: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   471: invokevirtual chat : (Ljava/lang/String;)V
/*     */     //   474: goto -> 1046
/*     */     //   477: aload_1
/*     */     //   478: iconst_1
/*     */     //   479: aaload
/*     */     //   480: ldc 'delete'
/*     */     //   482: iconst_1
/*     */     //   483: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   486: ifeq -> 709
/*     */     //   489: nop
/*     */     //   490: aload_1
/*     */     //   491: arraylength
/*     */     //   492: iconst_2
/*     */     //   493: if_icmpgt -> 504
/*     */     //   496: aload_0
/*     */     //   497: ldc_w 'scriptmanager delete <index>'
/*     */     //   500: invokevirtual chatSyntax : (Ljava/lang/String;)V
/*     */     //   503: return
/*     */     //   504: aload_1
/*     */     //   505: iconst_2
/*     */     //   506: aaload
/*     */     //   507: astore_3
/*     */     //   508: iconst_0
/*     */     //   509: istore #4
/*     */     //   511: aload_3
/*     */     //   512: invokestatic parseInt : (Ljava/lang/String;)I
/*     */     //   515: istore_2
/*     */     //   516: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   519: invokevirtual getScriptManager : ()Lnet/ccbluex/liquidbounce/script/ScriptManager;
/*     */     //   522: invokevirtual getScripts : ()Ljava/util/List;
/*     */     //   525: astore_3
/*     */     //   526: iload_2
/*     */     //   527: aload_3
/*     */     //   528: invokeinterface size : ()I
/*     */     //   533: if_icmplt -> 567
/*     */     //   536: aload_0
/*     */     //   537: new java/lang/StringBuilder
/*     */     //   540: dup
/*     */     //   541: invokespecial <init> : ()V
/*     */     //   544: ldc_w 'Index '
/*     */     //   547: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   550: iload_2
/*     */     //   551: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   554: ldc_w ' is too high.'
/*     */     //   557: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   560: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   563: invokevirtual chat : (Ljava/lang/String;)V
/*     */     //   566: return
/*     */     //   567: aload_3
/*     */     //   568: iload_2
/*     */     //   569: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   574: checkcast net/ccbluex/liquidbounce/script/Script
/*     */     //   577: astore #4
/*     */     //   579: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   582: invokevirtual getScriptManager : ()Lnet/ccbluex/liquidbounce/script/ScriptManager;
/*     */     //   585: aload #4
/*     */     //   587: invokevirtual deleteScript : (Lnet/ccbluex/liquidbounce/script/Script;)V
/*     */     //   590: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   593: new net/ccbluex/liquidbounce/ui/client/clickgui/ClickGui
/*     */     //   596: dup
/*     */     //   597: invokespecial <init> : ()V
/*     */     //   600: invokevirtual setClickGui : (Lnet/ccbluex/liquidbounce/ui/client/clickgui/ClickGui;)V
/*     */     //   603: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   606: invokevirtual getFileManager : ()Lnet/ccbluex/liquidbounce/file/FileManager;
/*     */     //   609: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   612: invokevirtual getFileManager : ()Lnet/ccbluex/liquidbounce/file/FileManager;
/*     */     //   615: getfield clickGuiConfig : Lnet/ccbluex/liquidbounce/file/FileConfig;
/*     */     //   618: invokevirtual loadConfig : (Lnet/ccbluex/liquidbounce/file/FileConfig;)V
/*     */     //   621: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   624: invokevirtual getFileManager : ()Lnet/ccbluex/liquidbounce/file/FileManager;
/*     */     //   627: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   630: invokevirtual getFileManager : ()Lnet/ccbluex/liquidbounce/file/FileManager;
/*     */     //   633: getfield hudConfig : Lnet/ccbluex/liquidbounce/file/FileConfig;
/*     */     //   636: invokevirtual loadConfig : (Lnet/ccbluex/liquidbounce/file/FileConfig;)V
/*     */     //   639: aload_0
/*     */     //   640: ldc_w 'Successfully deleted script.'
/*     */     //   643: invokevirtual chat : (Ljava/lang/String;)V
/*     */     //   646: goto -> 1046
/*     */     //   649: astore_2
/*     */     //   650: aload_0
/*     */     //   651: invokevirtual chatSyntaxError : ()V
/*     */     //   654: goto -> 1046
/*     */     //   657: astore_2
/*     */     //   658: invokestatic getLogger : ()Lorg/apache/logging/log4j/Logger;
/*     */     //   661: ldc_w 'Something went wrong while deleting a script.'
/*     */     //   664: aload_2
/*     */     //   665: invokeinterface error : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   670: aload_0
/*     */     //   671: new java/lang/StringBuilder
/*     */     //   674: dup
/*     */     //   675: invokespecial <init> : ()V
/*     */     //   678: aload_2
/*     */     //   679: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   682: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   685: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   688: ldc ': '
/*     */     //   690: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   693: aload_2
/*     */     //   694: invokevirtual getMessage : ()Ljava/lang/String;
/*     */     //   697: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   700: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   703: invokevirtual chat : (Ljava/lang/String;)V
/*     */     //   706: goto -> 1046
/*     */     //   709: aload_1
/*     */     //   710: iconst_1
/*     */     //   711: aaload
/*     */     //   712: ldc_w 'reload'
/*     */     //   715: iconst_1
/*     */     //   716: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   719: ifeq -> 958
/*     */     //   722: nop
/*     */     //   723: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   726: new net/ccbluex/liquidbounce/features/command/CommandManager
/*     */     //   729: dup
/*     */     //   730: invokespecial <init> : ()V
/*     */     //   733: invokevirtual setCommandManager : (Lnet/ccbluex/liquidbounce/features/command/CommandManager;)V
/*     */     //   736: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   739: invokevirtual getCommandManager : ()Lnet/ccbluex/liquidbounce/features/command/CommandManager;
/*     */     //   742: invokevirtual registerCommands : ()V
/*     */     //   745: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   748: iconst_1
/*     */     //   749: invokevirtual setStarting : (Z)V
/*     */     //   752: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   755: invokevirtual getScriptManager : ()Lnet/ccbluex/liquidbounce/script/ScriptManager;
/*     */     //   758: invokevirtual disableScripts : ()V
/*     */     //   761: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   764: invokevirtual getScriptManager : ()Lnet/ccbluex/liquidbounce/script/ScriptManager;
/*     */     //   767: invokevirtual unloadScripts : ()V
/*     */     //   770: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   773: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   776: invokevirtual getModules : ()Ljava/util/TreeSet;
/*     */     //   779: invokevirtual iterator : ()Ljava/util/Iterator;
/*     */     //   782: astore_3
/*     */     //   783: aload_3
/*     */     //   784: invokeinterface hasNext : ()Z
/*     */     //   789: ifeq -> 822
/*     */     //   792: aload_3
/*     */     //   793: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   798: checkcast net/ccbluex/liquidbounce/features/module/Module
/*     */     //   801: astore_2
/*     */     //   802: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   805: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   808: aload_2
/*     */     //   809: dup
/*     */     //   810: ldc_w 'module'
/*     */     //   813: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   816: invokevirtual generateCommand$XSJClient : (Lnet/ccbluex/liquidbounce/features/module/Module;)V
/*     */     //   819: goto -> 783
/*     */     //   822: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   825: invokevirtual getScriptManager : ()Lnet/ccbluex/liquidbounce/script/ScriptManager;
/*     */     //   828: invokevirtual loadScripts : ()V
/*     */     //   831: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   834: invokevirtual getScriptManager : ()Lnet/ccbluex/liquidbounce/script/ScriptManager;
/*     */     //   837: invokevirtual enableScripts : ()V
/*     */     //   840: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   843: iconst_0
/*     */     //   844: invokevirtual setStarting : (Z)V
/*     */     //   847: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   850: invokevirtual getFileManager : ()Lnet/ccbluex/liquidbounce/file/FileManager;
/*     */     //   853: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   856: invokevirtual getFileManager : ()Lnet/ccbluex/liquidbounce/file/FileManager;
/*     */     //   859: getfield valuesConfig : Lnet/ccbluex/liquidbounce/file/FileConfig;
/*     */     //   862: invokevirtual loadConfig : (Lnet/ccbluex/liquidbounce/file/FileConfig;)V
/*     */     //   865: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   868: new net/ccbluex/liquidbounce/ui/client/clickgui/ClickGui
/*     */     //   871: dup
/*     */     //   872: invokespecial <init> : ()V
/*     */     //   875: invokevirtual setClickGui : (Lnet/ccbluex/liquidbounce/ui/client/clickgui/ClickGui;)V
/*     */     //   878: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   881: invokevirtual getFileManager : ()Lnet/ccbluex/liquidbounce/file/FileManager;
/*     */     //   884: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   887: invokevirtual getFileManager : ()Lnet/ccbluex/liquidbounce/file/FileManager;
/*     */     //   890: getfield clickGuiConfig : Lnet/ccbluex/liquidbounce/file/FileConfig;
/*     */     //   893: invokevirtual loadConfig : (Lnet/ccbluex/liquidbounce/file/FileConfig;)V
/*     */     //   896: aload_0
/*     */     //   897: ldc_w 'Successfully reloaded all scripts.'
/*     */     //   900: invokevirtual chat : (Ljava/lang/String;)V
/*     */     //   903: goto -> 1046
/*     */     //   906: astore_2
/*     */     //   907: invokestatic getLogger : ()Lorg/apache/logging/log4j/Logger;
/*     */     //   910: ldc_w 'Something went wrong while reloading all scripts.'
/*     */     //   913: aload_2
/*     */     //   914: invokeinterface error : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   919: aload_0
/*     */     //   920: new java/lang/StringBuilder
/*     */     //   923: dup
/*     */     //   924: invokespecial <init> : ()V
/*     */     //   927: aload_2
/*     */     //   928: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   931: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   934: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   937: ldc ': '
/*     */     //   939: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   942: aload_2
/*     */     //   943: invokevirtual getMessage : ()Ljava/lang/String;
/*     */     //   946: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   949: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   952: invokevirtual chat : (Ljava/lang/String;)V
/*     */     //   955: goto -> 1046
/*     */     //   958: aload_1
/*     */     //   959: iconst_1
/*     */     //   960: aaload
/*     */     //   961: ldc_w 'folder'
/*     */     //   964: iconst_1
/*     */     //   965: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   968: ifeq -> 1046
/*     */     //   971: nop
/*     */     //   972: invokestatic getDesktop : ()Ljava/awt/Desktop;
/*     */     //   975: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   978: invokevirtual getScriptManager : ()Lnet/ccbluex/liquidbounce/script/ScriptManager;
/*     */     //   981: invokevirtual getScriptsFolder : ()Ljava/io/File;
/*     */     //   984: invokevirtual open : (Ljava/io/File;)V
/*     */     //   987: aload_0
/*     */     //   988: ldc_w 'Successfully opened scripts folder.'
/*     */     //   991: invokevirtual chat : (Ljava/lang/String;)V
/*     */     //   994: goto -> 1046
/*     */     //   997: astore_2
/*     */     //   998: invokestatic getLogger : ()Lorg/apache/logging/log4j/Logger;
/*     */     //   1001: ldc_w 'Something went wrong while trying to open your scripts folder.'
/*     */     //   1004: aload_2
/*     */     //   1005: invokeinterface error : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   1010: aload_0
/*     */     //   1011: new java/lang/StringBuilder
/*     */     //   1014: dup
/*     */     //   1015: invokespecial <init> : ()V
/*     */     //   1018: aload_2
/*     */     //   1019: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   1022: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   1025: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1028: ldc ': '
/*     */     //   1030: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1033: aload_2
/*     */     //   1034: invokevirtual getMessage : ()Ljava/lang/String;
/*     */     //   1037: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1040: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1043: invokevirtual chat : (Ljava/lang/String;)V
/*     */     //   1046: return
/*     */     //   1047: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   1050: invokevirtual getScriptManager : ()Lnet/ccbluex/liquidbounce/script/ScriptManager;
/*     */     //   1053: astore_2
/*     */     //   1054: aload_2
/*     */     //   1055: invokevirtual getScripts : ()Ljava/util/List;
/*     */     //   1058: checkcast java/util/Collection
/*     */     //   1061: astore_3
/*     */     //   1062: iconst_0
/*     */     //   1063: istore #4
/*     */     //   1065: aload_3
/*     */     //   1066: invokeinterface isEmpty : ()Z
/*     */     //   1071: ifne -> 1078
/*     */     //   1074: iconst_1
/*     */     //   1075: goto -> 1079
/*     */     //   1078: iconst_0
/*     */     //   1079: ifeq -> 1249
/*     */     //   1082: aload_0
/*     */     //   1083: ldc_w '§c§lScripts'
/*     */     //   1086: invokevirtual chat : (Ljava/lang/String;)V
/*     */     //   1089: aload_2
/*     */     //   1090: invokevirtual getScripts : ()Ljava/util/List;
/*     */     //   1093: checkcast java/lang/Iterable
/*     */     //   1096: astore_3
/*     */     //   1097: iconst_0
/*     */     //   1098: istore #4
/*     */     //   1100: iconst_0
/*     */     //   1101: istore #5
/*     */     //   1103: aload_3
/*     */     //   1104: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   1109: astore #6
/*     */     //   1111: aload #6
/*     */     //   1113: invokeinterface hasNext : ()Z
/*     */     //   1118: ifeq -> 1248
/*     */     //   1121: aload #6
/*     */     //   1123: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   1128: astore #7
/*     */     //   1130: iload #5
/*     */     //   1132: iinc #5, 1
/*     */     //   1135: istore #8
/*     */     //   1137: iconst_0
/*     */     //   1138: istore #9
/*     */     //   1140: iload #8
/*     */     //   1142: ifge -> 1148
/*     */     //   1145: invokestatic throwIndexOverflow : ()V
/*     */     //   1148: iload #8
/*     */     //   1150: istore #10
/*     */     //   1152: iload #10
/*     */     //   1154: aload #7
/*     */     //   1156: checkcast net/ccbluex/liquidbounce/script/Script
/*     */     //   1159: astore #11
/*     */     //   1161: istore #12
/*     */     //   1163: iconst_0
/*     */     //   1164: istore #13
/*     */     //   1166: aload_0
/*     */     //   1167: new java/lang/StringBuilder
/*     */     //   1170: dup
/*     */     //   1171: invokespecial <init> : ()V
/*     */     //   1174: iload #12
/*     */     //   1176: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   1179: ldc_w ': §a§l'
/*     */     //   1182: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1185: aload #11
/*     */     //   1187: invokevirtual getScriptName : ()Ljava/lang/String;
/*     */     //   1190: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1193: ldc_w ' §a§lv'
/*     */     //   1196: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1199: aload #11
/*     */     //   1201: invokevirtual getScriptVersion : ()Ljava/lang/String;
/*     */     //   1204: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1207: ldc_w ' §3by §a§l'
/*     */     //   1210: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1213: aload #11
/*     */     //   1215: invokevirtual getScriptAuthors : ()[Ljava/lang/String;
/*     */     //   1218: ldc_w ', '
/*     */     //   1221: checkcast java/lang/CharSequence
/*     */     //   1224: aconst_null
/*     */     //   1225: aconst_null
/*     */     //   1226: iconst_0
/*     */     //   1227: aconst_null
/*     */     //   1228: aconst_null
/*     */     //   1229: bipush #62
/*     */     //   1231: aconst_null
/*     */     //   1232: invokestatic joinToString$default : ([Ljava/lang/Object;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;ILjava/lang/Object;)Ljava/lang/String;
/*     */     //   1235: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1238: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1241: invokevirtual chat : (Ljava/lang/String;)V
/*     */     //   1244: nop
/*     */     //   1245: goto -> 1111
/*     */     //   1248: nop
/*     */     //   1249: aload_0
/*     */     //   1250: ldc_w 'scriptmanager <import/delete/reload/folder>'
/*     */     //   1253: invokevirtual chatSyntax : (Ljava/lang/String;)V
/*     */     //   1256: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #21	-> 6
/*     */     //   #22	-> 12
/*     */     //   #23	-> 13
/*     */     //   #24	-> 25
/*     */     //   #25	-> 26
/*     */     //   #25	-> 36
/*     */     //   #26	-> 39
/*     */     //   #28	-> 44
/*     */     //   #29	-> 62
/*     */     //   #31	-> 72
/*     */     //   #32	-> 85
/*     */     //   #34	-> 103
/*     */     //   #35	-> 109
/*     */     //   #36	-> 110
/*     */     //   #37	-> 122
/*     */     //   #38	-> 132
/*     */     //   #39	-> 139
/*     */     //   #41	-> 148
/*     */     //   #42	-> 158
/*     */     //   #43	-> 170
/*     */     //   #44	-> 183
/*     */     //   #46	-> 203
/*     */     //   #47	-> 211
/*     */     //   #48	-> 217
/*     */     //   #51	-> 220
/*     */     //   #52	-> 229
/*     */     //   #54	-> 240
/*     */     //   #55	-> 251
/*     */     //   #56	-> 256
/*     */     //   #58	-> 261
/*     */     //   #59	-> 286
/*     */     //   #41	-> 294
/*     */     //   #62	-> 297
/*     */     //   #167	-> 307
/*     */     //   #62	-> 345
/*     */     //   #168	-> 360
/*     */     //   #64	-> 361
/*     */     //   #65	-> 374
/*     */     //   #66	-> 392
/*     */     //   #68	-> 410
/*     */     //   #69	-> 416
/*     */     //   #70	-> 417
/*     */     //   #72	-> 417
/*     */     //   #73	-> 426
/*     */     //   #74	-> 427
/*     */     //   #75	-> 438
/*     */     //   #76	-> 474
/*     */     //   #79	-> 477
/*     */     //   #80	-> 489
/*     */     //   #81	-> 490
/*     */     //   #82	-> 496
/*     */     //   #83	-> 503
/*     */     //   #86	-> 504
/*     */     //   #86	-> 515
/*     */     //   #87	-> 516
/*     */     //   #89	-> 526
/*     */     //   #90	-> 536
/*     */     //   #91	-> 566
/*     */     //   #94	-> 567
/*     */     //   #96	-> 579
/*     */     //   #98	-> 590
/*     */     //   #99	-> 603
/*     */     //   #100	-> 621
/*     */     //   #101	-> 639
/*     */     //   #102	-> 649
/*     */     //   #103	-> 650
/*     */     //   #104	-> 657
/*     */     //   #105	-> 658
/*     */     //   #106	-> 670
/*     */     //   #107	-> 706
/*     */     //   #110	-> 709
/*     */     //   #111	-> 722
/*     */     //   #112	-> 723
/*     */     //   #113	-> 736
/*     */     //   #114	-> 745
/*     */     //   #115	-> 752
/*     */     //   #116	-> 761
/*     */     //   #117	-> 770
/*     */     //   #118	-> 802
/*     */     //   #117	-> 819
/*     */     //   #119	-> 822
/*     */     //   #120	-> 831
/*     */     //   #121	-> 840
/*     */     //   #122	-> 847
/*     */     //   #123	-> 865
/*     */     //   #124	-> 878
/*     */     //   #125	-> 896
/*     */     //   #126	-> 906
/*     */     //   #127	-> 907
/*     */     //   #128	-> 919
/*     */     //   #129	-> 955
/*     */     //   #132	-> 958
/*     */     //   #133	-> 971
/*     */     //   #134	-> 972
/*     */     //   #135	-> 987
/*     */     //   #136	-> 997
/*     */     //   #137	-> 998
/*     */     //   #138	-> 1010
/*     */     //   #139	-> 1046
/*     */     //   #141	-> 1046
/*     */     //   #143	-> 1046
/*     */     //   #146	-> 1047
/*     */     //   #148	-> 1054
/*     */     //   #149	-> 1082
/*     */     //   #150	-> 1089
/*     */     //   #169	-> 1100
/*     */     //   #170	-> 1103
/*     */     //   #170	-> 1154
/*     */     //   #150	-> 1166
/*     */     //   #171	-> 1248
/*     */     //   #153	-> 1249
/*     */     //   #154	-> 1256
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   240	54	11	fileOutputStream	Ljava/io/FileOutputStream;
/*     */     //   229	65	10	fileStream	Ljava/io/InputStream;
/*     */     //   203	91	9	entryFile	Ljava/io/File;
/*     */     //   183	111	8	entryName	Ljava/lang/String;
/*     */     //   170	124	7	entry	Ljava/util/zip/ZipEntry;
/*     */     //   342	14	11	scriptFile	Ljava/io/File;
/*     */     //   345	11	12	$i$a$-forEach-ScriptManagerCommand$execute$1	I
/*     */     //   335	22	10	element$iv	Ljava/lang/Object;
/*     */     //   304	57	7	$this$forEach$iv	Ljava/lang/Iterable;
/*     */     //   307	54	8	$i$f$forEach	I
/*     */     //   148	269	6	scriptFiles	Ljava/util/ArrayList;
/*     */     //   139	278	5	entries	Ljava/util/Enumeration;
/*     */     //   132	285	4	zipFile	Ljava/util/zip/ZipFile;
/*     */     //   44	379	3	fileName	Ljava/lang/String;
/*     */     //   39	384	2	file	Ljava/io/File;
/*     */     //   427	47	2	t	Ljava/lang/Throwable;
/*     */     //   579	67	4	script	Lnet/ccbluex/liquidbounce/script/Script;
/*     */     //   526	120	3	scripts	Ljava/util/List;
/*     */     //   516	130	2	scriptIndex	I
/*     */     //   650	4	2	numberFormat	Ljava/lang/NumberFormatException;
/*     */     //   658	48	2	t	Ljava/lang/Throwable;
/*     */     //   802	17	2	module	Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   907	48	2	t	Ljava/lang/Throwable;
/*     */     //   998	48	2	t	Ljava/lang/Throwable;
/*     */     //   1163	81	12	index	I
/*     */     //   1163	81	11	script	Lnet/ccbluex/liquidbounce/script/Script;
/*     */     //   1166	78	13	$i$a$-forEachIndexed-ScriptManagerCommand$execute$2	I
/*     */     //   1130	115	7	item$iv	Ljava/lang/Object;
/*     */     //   1103	146	5	index$iv	I
/*     */     //   1097	152	3	$this$forEachIndexed$iv	Ljava/lang/Iterable;
/*     */     //   1100	149	4	$i$f$forEachIndexed	I
/*     */     //   1054	203	2	scriptManager	Lnet/ccbluex/liquidbounce/script/ScriptManager;
/*     */     //   0	1257	0	this	Lnet/ccbluex/liquidbounce/features/command/commands/ScriptManagerCommand;
/*     */     //   0	1257	1	args	[Ljava/lang/String;
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   25	423	426	java/lang/Throwable
/*     */     //   489	646	649	java/lang/NumberFormatException
/*     */     //   489	646	657	java/lang/Throwable
/*     */     //   722	903	906	java/lang/Throwable
/*     */     //   971	994	997	java/lang/Throwable
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
/*     */   @NotNull
/*     */   public List<String> tabComplete(@NotNull String[] args) {
/*     */     Iterable $this$filter$iv;
/*     */     int $i$f$filter;
/*     */     Iterable iterable1;
/*     */     Collection<Object> destination$iv$iv;
/*     */     int $i$f$filterTo;
/* 157 */     Intrinsics.checkParameterIsNotNull(args, "args"); String[] arrayOfString = args; boolean bool = false; if ((arrayOfString.length == 0)) return CollectionsKt.emptyList();
/*     */     
/* 159 */     switch (args.length) { case 1:
/* 160 */         $this$filter$iv = CollectionsKt.listOf((Object[])new String[] { "delete", "import", "folder", "reload" });
/* 161 */         $i$f$filter = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 172 */         iterable1 = $this$filter$iv; destination$iv$iv = new ArrayList(); $i$f$filterTo = 0;
/* 173 */         for (Object element$iv$iv : iterable1) { String it = (String)element$iv$iv; int $i$a$-filter-ScriptManagerCommand$tabComplete$1 = 0;
/*     */           if (StringsKt.startsWith(it, args[0], true))
/*     */             destination$iv$iv.add(element$iv$iv);  }
/*     */        }
/*     */     
/*     */     return CollectionsKt.emptyList();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\command\commands\ScriptManagerCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */