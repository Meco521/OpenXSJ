/*     */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*     */ import java.awt.Color;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.api.IExtractedFunctions;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.renderer.entity.IRenderManager;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.tileentity.ITileEntity;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.Render2DEvent;
/*     */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.shader.FramebufferShader;
/*     */ import net.ccbluex.liquidbounce.utils.render.shader.shaders.GlowShader;
/*     */ import net.ccbluex.liquidbounce.utils.render.shader.shaders.OutlineShader;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "StorageESP", description = "Allows you to see chests, dispensers, etc. through walls.", category = ModuleCategory.RENDER)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\f\032\0020\r2\006\020\016\032\0020\017H\007J\020\020\020\032\0020\r2\006\020\016\032\0020\021H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\004X\004¢\006\002\n\000R\016\020\007\032\0020\004X\004¢\006\002\n\000R\016\020\b\032\0020\004X\004¢\006\002\n\000R\016\020\t\032\0020\nX\004¢\006\002\n\000R\016\020\013\032\0020\004X\004¢\006\002\n\000¨\006\022"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/StorageESP;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "chestValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "dispenserValue", "enderChestValue", "furnaceValue", "hopperValue", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "shulkerBoxValue", "onRender2D", "", "event", "Lnet/ccbluex/liquidbounce/event/Render2DEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "XSJClient"})
/*     */ public final class StorageESP extends Module {
/*  23 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "Box", "OtherBox", "Outline", "ShaderOutline", "ShaderGlow", "2D", "WireFrame" }, "Outline");
/*  24 */   private final BoolValue chestValue = new BoolValue("Chest", true);
/*  25 */   private final BoolValue enderChestValue = new BoolValue("EnderChest", true);
/*  26 */   private final BoolValue furnaceValue = new BoolValue("Furnace", true);
/*  27 */   private final BoolValue dispenserValue = new BoolValue("Dispenser", true);
/*  28 */   private final BoolValue hopperValue = new BoolValue("Hopper", true);
/*  29 */   private final BoolValue shulkerBoxValue = new BoolValue("ShulkerBox", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public final void onRender3D(@NotNull Render3DEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: nop
/*     */     //   7: aload_0
/*     */     //   8: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   11: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   14: checkcast java/lang/String
/*     */     //   17: astore_2
/*     */     //   18: aload_2
/*     */     //   19: ldc 'outline'
/*     */     //   21: iconst_1
/*     */     //   22: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   25: ifeq -> 34
/*     */     //   28: invokestatic disableFastRender : ()V
/*     */     //   31: invokestatic checkSetupFBO : ()V
/*     */     //   34: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   37: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   42: invokeinterface getGammaSetting : ()F
/*     */     //   47: fstore_3
/*     */     //   48: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   51: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   56: ldc 100000.0
/*     */     //   58: invokeinterface setGammaSetting : (F)V
/*     */     //   63: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   66: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   71: dup
/*     */     //   72: ifnonnull -> 78
/*     */     //   75: invokestatic throwNpe : ()V
/*     */     //   78: invokeinterface getLoadedTileEntityList : ()Ljava/util/Collection;
/*     */     //   83: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   88: astore #5
/*     */     //   90: aload #5
/*     */     //   92: invokeinterface hasNext : ()Z
/*     */     //   97: ifeq -> 907
/*     */     //   100: aload #5
/*     */     //   102: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   107: checkcast net/ccbluex/liquidbounce/api/minecraft/tileentity/ITileEntity
/*     */     //   110: astore #4
/*     */     //   112: nop
/*     */     //   113: aload_0
/*     */     //   114: getfield chestValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   117: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   120: checkcast java/lang/Boolean
/*     */     //   123: invokevirtual booleanValue : ()Z
/*     */     //   126: ifeq -> 209
/*     */     //   129: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   132: aload #4
/*     */     //   134: invokeinterface isTileEntityChest : (Ljava/lang/Object;)Z
/*     */     //   139: ifeq -> 209
/*     */     //   142: getstatic net/ccbluex/liquidbounce/features/module/modules/world/ChestAura.INSTANCE : Lnet/ccbluex/liquidbounce/features/module/modules/world/ChestAura;
/*     */     //   145: invokevirtual getClickedBlocks : ()Ljava/util/List;
/*     */     //   148: aload #4
/*     */     //   150: invokeinterface getPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   155: invokeinterface contains : (Ljava/lang/Object;)Z
/*     */     //   160: ifne -> 209
/*     */     //   163: new java/awt/Color
/*     */     //   166: dup
/*     */     //   167: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   170: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   173: checkcast java/lang/Number
/*     */     //   176: invokevirtual intValue : ()I
/*     */     //   179: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   182: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   185: checkcast java/lang/Number
/*     */     //   188: invokevirtual intValue : ()I
/*     */     //   191: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   194: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   197: checkcast java/lang/Number
/*     */     //   200: invokevirtual intValue : ()I
/*     */     //   203: invokespecial <init> : (III)V
/*     */     //   206: goto -> 419
/*     */     //   209: aload_0
/*     */     //   210: getfield enderChestValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   213: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   216: checkcast java/lang/Boolean
/*     */     //   219: invokevirtual booleanValue : ()Z
/*     */     //   222: ifeq -> 265
/*     */     //   225: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   228: aload #4
/*     */     //   230: invokeinterface isTileEntityEnderChest : (Ljava/lang/Object;)Z
/*     */     //   235: ifeq -> 265
/*     */     //   238: getstatic net/ccbluex/liquidbounce/features/module/modules/world/ChestAura.INSTANCE : Lnet/ccbluex/liquidbounce/features/module/modules/world/ChestAura;
/*     */     //   241: invokevirtual getClickedBlocks : ()Ljava/util/List;
/*     */     //   244: aload #4
/*     */     //   246: invokeinterface getPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   251: invokeinterface contains : (Ljava/lang/Object;)Z
/*     */     //   256: ifne -> 265
/*     */     //   259: getstatic java/awt/Color.MAGENTA : Ljava/awt/Color;
/*     */     //   262: goto -> 419
/*     */     //   265: aload_0
/*     */     //   266: getfield furnaceValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   269: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   272: checkcast java/lang/Boolean
/*     */     //   275: invokevirtual booleanValue : ()Z
/*     */     //   278: ifeq -> 300
/*     */     //   281: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   284: aload #4
/*     */     //   286: invokeinterface isTileEntityFurnace : (Ljava/lang/Object;)Z
/*     */     //   291: ifeq -> 300
/*     */     //   294: getstatic java/awt/Color.BLACK : Ljava/awt/Color;
/*     */     //   297: goto -> 419
/*     */     //   300: aload_0
/*     */     //   301: getfield dispenserValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   304: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   307: checkcast java/lang/Boolean
/*     */     //   310: invokevirtual booleanValue : ()Z
/*     */     //   313: ifeq -> 335
/*     */     //   316: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   319: aload #4
/*     */     //   321: invokeinterface isTileEntityDispenser : (Ljava/lang/Object;)Z
/*     */     //   326: ifeq -> 335
/*     */     //   329: getstatic java/awt/Color.BLACK : Ljava/awt/Color;
/*     */     //   332: goto -> 419
/*     */     //   335: aload_0
/*     */     //   336: getfield hopperValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   339: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   342: checkcast java/lang/Boolean
/*     */     //   345: invokevirtual booleanValue : ()Z
/*     */     //   348: ifeq -> 370
/*     */     //   351: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   354: aload #4
/*     */     //   356: invokeinterface isTileEntityHopper : (Ljava/lang/Object;)Z
/*     */     //   361: ifeq -> 370
/*     */     //   364: getstatic java/awt/Color.GRAY : Ljava/awt/Color;
/*     */     //   367: goto -> 419
/*     */     //   370: aload_0
/*     */     //   371: getfield shulkerBoxValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   374: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   377: checkcast java/lang/Boolean
/*     */     //   380: invokevirtual booleanValue : ()Z
/*     */     //   383: ifeq -> 418
/*     */     //   386: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   389: aload #4
/*     */     //   391: invokeinterface isTileEntityShulkerBox : (Ljava/lang/Object;)Z
/*     */     //   396: ifeq -> 418
/*     */     //   399: new java/awt/Color
/*     */     //   402: dup
/*     */     //   403: bipush #110
/*     */     //   405: bipush #77
/*     */     //   407: bipush #110
/*     */     //   409: invokespecial <init> : (III)V
/*     */     //   412: invokevirtual brighter : ()Ljava/awt/Color;
/*     */     //   415: goto -> 419
/*     */     //   418: aconst_null
/*     */     //   419: dup
/*     */     //   420: ifnull -> 426
/*     */     //   423: goto -> 430
/*     */     //   426: pop
/*     */     //   427: goto -> 904
/*     */     //   430: astore #6
/*     */     //   432: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   435: aload #4
/*     */     //   437: invokeinterface isTileEntityChest : (Ljava/lang/Object;)Z
/*     */     //   442: ifne -> 488
/*     */     //   445: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   448: aload #4
/*     */     //   450: invokeinterface isTileEntityChest : (Ljava/lang/Object;)Z
/*     */     //   455: ifne -> 488
/*     */     //   458: aload #4
/*     */     //   460: invokeinterface getPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   465: aload #6
/*     */     //   467: aload_2
/*     */     //   468: ldc 'otherbox'
/*     */     //   470: iconst_1
/*     */     //   471: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   474: ifne -> 481
/*     */     //   477: iconst_1
/*     */     //   478: goto -> 482
/*     */     //   481: iconst_0
/*     */     //   482: invokestatic drawBlockBox : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Ljava/awt/Color;Z)V
/*     */     //   485: goto -> 904
/*     */     //   488: aload_2
/*     */     //   489: astore #7
/*     */     //   491: iconst_0
/*     */     //   492: istore #8
/*     */     //   494: aload #7
/*     */     //   496: dup
/*     */     //   497: ifnonnull -> 511
/*     */     //   500: new kotlin/TypeCastException
/*     */     //   503: dup
/*     */     //   504: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*     */     //   507: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   510: athrow
/*     */     //   511: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   514: dup
/*     */     //   515: ldc_w '(this as java.lang.String).toLowerCase()'
/*     */     //   518: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   521: astore #7
/*     */     //   523: aload #7
/*     */     //   525: invokevirtual hashCode : ()I
/*     */     //   528: lookupswitch default -> 904, -1171135301 -> 621, -1106245566 -> 594, -941784056 -> 607, 1650 -> 580, 97739 -> 634
/*     */     //   580: aload #7
/*     */     //   582: ldc_w '2d'
/*     */     //   585: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   588: ifeq -> 904
/*     */     //   591: goto -> 675
/*     */     //   594: aload #7
/*     */     //   596: ldc 'outline'
/*     */     //   598: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   601: ifeq -> 904
/*     */     //   604: goto -> 706
/*     */     //   607: aload #7
/*     */     //   609: ldc_w 'wireframe'
/*     */     //   612: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   615: ifeq -> 904
/*     */     //   618: goto -> 800
/*     */     //   621: aload #7
/*     */     //   623: ldc 'otherbox'
/*     */     //   625: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   628: ifeq -> 904
/*     */     //   631: goto -> 645
/*     */     //   634: aload #7
/*     */     //   636: ldc_w 'box'
/*     */     //   639: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   642: ifeq -> 904
/*     */     //   645: aload #4
/*     */     //   647: invokeinterface getPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   652: aload #6
/*     */     //   654: aload_2
/*     */     //   655: ldc 'otherbox'
/*     */     //   657: iconst_1
/*     */     //   658: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   661: ifne -> 668
/*     */     //   664: iconst_1
/*     */     //   665: goto -> 669
/*     */     //   668: iconst_0
/*     */     //   669: invokestatic drawBlockBox : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Ljava/awt/Color;Z)V
/*     */     //   672: goto -> 904
/*     */     //   675: aload #4
/*     */     //   677: invokeinterface getPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   682: aload #6
/*     */     //   684: invokevirtual getRGB : ()I
/*     */     //   687: getstatic java/awt/Color.BLACK : Ljava/awt/Color;
/*     */     //   690: dup
/*     */     //   691: ldc_w 'Color.BLACK'
/*     */     //   694: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   697: invokevirtual getRGB : ()I
/*     */     //   700: invokestatic draw2D : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;II)V
/*     */     //   703: goto -> 904
/*     */     //   706: aload #6
/*     */     //   708: invokestatic glColor : (Ljava/awt/Color;)V
/*     */     //   711: ldc_w 3.0
/*     */     //   714: invokestatic renderOne : (F)V
/*     */     //   717: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*     */     //   720: aload #4
/*     */     //   722: aload_1
/*     */     //   723: invokevirtual getPartialTicks : ()F
/*     */     //   726: iconst_m1
/*     */     //   727: invokeinterface renderTileEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/tileentity/ITileEntity;FI)V
/*     */     //   732: invokestatic renderTwo : ()V
/*     */     //   735: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*     */     //   738: aload #4
/*     */     //   740: aload_1
/*     */     //   741: invokevirtual getPartialTicks : ()F
/*     */     //   744: iconst_m1
/*     */     //   745: invokeinterface renderTileEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/tileentity/ITileEntity;FI)V
/*     */     //   750: invokestatic renderThree : ()V
/*     */     //   753: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*     */     //   756: aload #4
/*     */     //   758: aload_1
/*     */     //   759: invokevirtual getPartialTicks : ()F
/*     */     //   762: iconst_m1
/*     */     //   763: invokeinterface renderTileEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/tileentity/ITileEntity;FI)V
/*     */     //   768: aload #6
/*     */     //   770: invokestatic renderFour : (Ljava/awt/Color;)V
/*     */     //   773: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*     */     //   776: aload #4
/*     */     //   778: aload_1
/*     */     //   779: invokevirtual getPartialTicks : ()F
/*     */     //   782: iconst_m1
/*     */     //   783: invokeinterface renderTileEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/tileentity/ITileEntity;FI)V
/*     */     //   788: invokestatic renderFive : ()V
/*     */     //   791: getstatic java/awt/Color.WHITE : Ljava/awt/Color;
/*     */     //   794: invokestatic setColor : (Ljava/awt/Color;)V
/*     */     //   797: goto -> 904
/*     */     //   800: invokestatic glPushMatrix : ()V
/*     */     //   803: ldc_w 1048575
/*     */     //   806: invokestatic glPushAttrib : (I)V
/*     */     //   809: sipush #1032
/*     */     //   812: sipush #6913
/*     */     //   815: invokestatic glPolygonMode : (II)V
/*     */     //   818: sipush #3553
/*     */     //   821: invokestatic glDisable : (I)V
/*     */     //   824: sipush #2896
/*     */     //   827: invokestatic glDisable : (I)V
/*     */     //   830: sipush #2929
/*     */     //   833: invokestatic glDisable : (I)V
/*     */     //   836: sipush #2848
/*     */     //   839: invokestatic glEnable : (I)V
/*     */     //   842: sipush #3042
/*     */     //   845: invokestatic glEnable : (I)V
/*     */     //   848: sipush #770
/*     */     //   851: sipush #771
/*     */     //   854: invokestatic glBlendFunc : (II)V
/*     */     //   857: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*     */     //   860: aload #4
/*     */     //   862: aload_1
/*     */     //   863: invokevirtual getPartialTicks : ()F
/*     */     //   866: iconst_m1
/*     */     //   867: invokeinterface renderTileEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/tileentity/ITileEntity;FI)V
/*     */     //   872: aload #6
/*     */     //   874: invokestatic glColor : (Ljava/awt/Color;)V
/*     */     //   877: ldc_w 1.5
/*     */     //   880: invokestatic glLineWidth : (F)V
/*     */     //   883: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*     */     //   886: aload #4
/*     */     //   888: aload_1
/*     */     //   889: invokevirtual getPartialTicks : ()F
/*     */     //   892: iconst_m1
/*     */     //   893: invokeinterface renderTileEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/tileentity/ITileEntity;FI)V
/*     */     //   898: invokestatic glPopAttrib : ()V
/*     */     //   901: invokestatic glPopMatrix : ()V
/*     */     //   904: goto -> 90
/*     */     //   907: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   910: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   915: dup
/*     */     //   916: ifnonnull -> 922
/*     */     //   919: invokestatic throwNpe : ()V
/*     */     //   922: invokeinterface getLoadedEntityList : ()Ljava/util/Collection;
/*     */     //   927: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   932: astore #5
/*     */     //   934: aload #5
/*     */     //   936: invokeinterface hasNext : ()Z
/*     */     //   941: ifeq -> 1751
/*     */     //   944: aload #5
/*     */     //   946: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   951: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   954: astore #4
/*     */     //   956: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   959: aload #4
/*     */     //   961: invokeinterface isEntityMinecartChest : (Ljava/lang/Object;)Z
/*     */     //   966: ifeq -> 1748
/*     */     //   969: aload_2
/*     */     //   970: astore #6
/*     */     //   972: iconst_0
/*     */     //   973: istore #7
/*     */     //   975: aload #6
/*     */     //   977: dup
/*     */     //   978: ifnonnull -> 992
/*     */     //   981: new kotlin/TypeCastException
/*     */     //   984: dup
/*     */     //   985: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*     */     //   988: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   991: athrow
/*     */     //   992: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   995: dup
/*     */     //   996: ldc_w '(this as java.lang.String).toLowerCase()'
/*     */     //   999: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1002: astore #6
/*     */     //   1004: aload #6
/*     */     //   1006: invokevirtual hashCode : ()I
/*     */     //   1009: lookupswitch default -> 1748, -1171135301 -> 1101, -1106245566 -> 1074, -941784056 -> 1087, 1650 -> 1060, 97739 -> 1114
/*     */     //   1060: aload #6
/*     */     //   1062: ldc_w '2d'
/*     */     //   1065: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1068: ifeq -> 1748
/*     */     //   1071: goto -> 1191
/*     */     //   1074: aload #6
/*     */     //   1076: ldc 'outline'
/*     */     //   1078: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1081: ifeq -> 1748
/*     */     //   1084: goto -> 1263
/*     */     //   1087: aload #6
/*     */     //   1089: ldc_w 'wireframe'
/*     */     //   1092: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1095: ifeq -> 1748
/*     */     //   1098: goto -> 1483
/*     */     //   1101: aload #6
/*     */     //   1103: ldc 'otherbox'
/*     */     //   1105: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1108: ifeq -> 1748
/*     */     //   1111: goto -> 1125
/*     */     //   1114: aload #6
/*     */     //   1116: ldc_w 'box'
/*     */     //   1119: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1122: ifeq -> 1748
/*     */     //   1125: aload #4
/*     */     //   1127: new java/awt/Color
/*     */     //   1130: dup
/*     */     //   1131: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1134: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1137: checkcast java/lang/Number
/*     */     //   1140: invokevirtual intValue : ()I
/*     */     //   1143: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1146: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1149: checkcast java/lang/Number
/*     */     //   1152: invokevirtual intValue : ()I
/*     */     //   1155: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1158: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1161: checkcast java/lang/Number
/*     */     //   1164: invokevirtual intValue : ()I
/*     */     //   1167: invokespecial <init> : (III)V
/*     */     //   1170: aload_2
/*     */     //   1171: ldc 'otherbox'
/*     */     //   1173: iconst_1
/*     */     //   1174: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   1177: ifne -> 1184
/*     */     //   1180: iconst_1
/*     */     //   1181: goto -> 1185
/*     */     //   1184: iconst_0
/*     */     //   1185: invokestatic drawEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Ljava/awt/Color;Z)V
/*     */     //   1188: goto -> 1748
/*     */     //   1191: aload #4
/*     */     //   1193: invokeinterface getPosition : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   1198: new java/awt/Color
/*     */     //   1201: dup
/*     */     //   1202: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1205: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1208: checkcast java/lang/Number
/*     */     //   1211: invokevirtual intValue : ()I
/*     */     //   1214: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1217: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1220: checkcast java/lang/Number
/*     */     //   1223: invokevirtual intValue : ()I
/*     */     //   1226: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1229: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1232: checkcast java/lang/Number
/*     */     //   1235: invokevirtual intValue : ()I
/*     */     //   1238: invokespecial <init> : (III)V
/*     */     //   1241: invokevirtual getRGB : ()I
/*     */     //   1244: getstatic java/awt/Color.BLACK : Ljava/awt/Color;
/*     */     //   1247: dup
/*     */     //   1248: ldc_w 'Color.BLACK'
/*     */     //   1251: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1254: invokevirtual getRGB : ()I
/*     */     //   1257: invokestatic draw2D : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;II)V
/*     */     //   1260: goto -> 1748
/*     */     //   1263: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1266: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1271: invokeinterface getEntityShadows : ()Z
/*     */     //   1276: istore #7
/*     */     //   1278: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1281: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1286: iconst_0
/*     */     //   1287: invokeinterface setEntityShadows : (Z)V
/*     */     //   1292: new java/awt/Color
/*     */     //   1295: dup
/*     */     //   1296: iconst_0
/*     */     //   1297: bipush #66
/*     */     //   1299: sipush #255
/*     */     //   1302: invokespecial <init> : (III)V
/*     */     //   1305: invokestatic glColor : (Ljava/awt/Color;)V
/*     */     //   1308: ldc_w 3.0
/*     */     //   1311: invokestatic renderOne : (F)V
/*     */     //   1314: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1317: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   1322: aload #4
/*     */     //   1324: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1327: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   1332: invokeinterface getRenderPartialTicks : ()F
/*     */     //   1337: iconst_1
/*     */     //   1338: invokeinterface renderEntityStatic : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;FZ)Z
/*     */     //   1343: pop
/*     */     //   1344: invokestatic renderTwo : ()V
/*     */     //   1347: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1350: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   1355: aload #4
/*     */     //   1357: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1360: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   1365: invokeinterface getRenderPartialTicks : ()F
/*     */     //   1370: iconst_1
/*     */     //   1371: invokeinterface renderEntityStatic : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;FZ)Z
/*     */     //   1376: pop
/*     */     //   1377: invokestatic renderThree : ()V
/*     */     //   1380: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1383: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   1388: aload #4
/*     */     //   1390: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1393: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   1398: invokeinterface getRenderPartialTicks : ()F
/*     */     //   1403: iconst_1
/*     */     //   1404: invokeinterface renderEntityStatic : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;FZ)Z
/*     */     //   1409: pop
/*     */     //   1410: new java/awt/Color
/*     */     //   1413: dup
/*     */     //   1414: iconst_0
/*     */     //   1415: bipush #66
/*     */     //   1417: sipush #255
/*     */     //   1420: invokespecial <init> : (III)V
/*     */     //   1423: invokestatic renderFour : (Ljava/awt/Color;)V
/*     */     //   1426: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1429: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   1434: aload #4
/*     */     //   1436: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1439: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   1444: invokeinterface getRenderPartialTicks : ()F
/*     */     //   1449: iconst_1
/*     */     //   1450: invokeinterface renderEntityStatic : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;FZ)Z
/*     */     //   1455: pop
/*     */     //   1456: invokestatic renderFive : ()V
/*     */     //   1459: getstatic java/awt/Color.WHITE : Ljava/awt/Color;
/*     */     //   1462: invokestatic setColor : (Ljava/awt/Color;)V
/*     */     //   1465: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1468: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1473: iload #7
/*     */     //   1475: invokeinterface setEntityShadows : (Z)V
/*     */     //   1480: goto -> 1748
/*     */     //   1483: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1486: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1491: invokeinterface getEntityShadows : ()Z
/*     */     //   1496: istore #7
/*     */     //   1498: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1501: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1506: iconst_0
/*     */     //   1507: invokeinterface setEntityShadows : (Z)V
/*     */     //   1512: invokestatic glPushMatrix : ()V
/*     */     //   1515: ldc_w 1048575
/*     */     //   1518: invokestatic glPushAttrib : (I)V
/*     */     //   1521: sipush #1032
/*     */     //   1524: sipush #6913
/*     */     //   1527: invokestatic glPolygonMode : (II)V
/*     */     //   1530: sipush #3553
/*     */     //   1533: invokestatic glDisable : (I)V
/*     */     //   1536: sipush #2896
/*     */     //   1539: invokestatic glDisable : (I)V
/*     */     //   1542: sipush #2929
/*     */     //   1545: invokestatic glDisable : (I)V
/*     */     //   1548: sipush #2848
/*     */     //   1551: invokestatic glEnable : (I)V
/*     */     //   1554: sipush #3042
/*     */     //   1557: invokestatic glEnable : (I)V
/*     */     //   1560: sipush #770
/*     */     //   1563: sipush #771
/*     */     //   1566: invokestatic glBlendFunc : (II)V
/*     */     //   1569: new java/awt/Color
/*     */     //   1572: dup
/*     */     //   1573: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1576: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1579: checkcast java/lang/Number
/*     */     //   1582: invokevirtual intValue : ()I
/*     */     //   1585: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1588: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1591: checkcast java/lang/Number
/*     */     //   1594: invokevirtual intValue : ()I
/*     */     //   1597: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1600: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1603: checkcast java/lang/Number
/*     */     //   1606: invokevirtual intValue : ()I
/*     */     //   1609: invokespecial <init> : (III)V
/*     */     //   1612: invokestatic glColor : (Ljava/awt/Color;)V
/*     */     //   1615: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1618: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   1623: aload #4
/*     */     //   1625: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1628: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   1633: invokeinterface getRenderPartialTicks : ()F
/*     */     //   1638: iconst_1
/*     */     //   1639: invokeinterface renderEntityStatic : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;FZ)Z
/*     */     //   1644: pop
/*     */     //   1645: new java/awt/Color
/*     */     //   1648: dup
/*     */     //   1649: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1652: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1655: checkcast java/lang/Number
/*     */     //   1658: invokevirtual intValue : ()I
/*     */     //   1661: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1664: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1667: checkcast java/lang/Number
/*     */     //   1670: invokevirtual intValue : ()I
/*     */     //   1673: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1676: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1679: checkcast java/lang/Number
/*     */     //   1682: invokevirtual intValue : ()I
/*     */     //   1685: invokespecial <init> : (III)V
/*     */     //   1688: invokestatic glColor : (Ljava/awt/Color;)V
/*     */     //   1691: ldc_w 1.5
/*     */     //   1694: invokestatic glLineWidth : (F)V
/*     */     //   1697: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1700: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   1705: aload #4
/*     */     //   1707: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1710: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   1715: invokeinterface getRenderPartialTicks : ()F
/*     */     //   1720: iconst_1
/*     */     //   1721: invokeinterface renderEntityStatic : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;FZ)Z
/*     */     //   1726: pop
/*     */     //   1727: invokestatic glPopAttrib : ()V
/*     */     //   1730: invokestatic glPopMatrix : ()V
/*     */     //   1733: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1736: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1741: iload #7
/*     */     //   1743: invokeinterface setEntityShadows : (Z)V
/*     */     //   1748: goto -> 934
/*     */     //   1751: new java/awt/Color
/*     */     //   1754: dup
/*     */     //   1755: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1758: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1761: checkcast java/lang/Number
/*     */     //   1764: invokevirtual intValue : ()I
/*     */     //   1767: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1770: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1773: checkcast java/lang/Number
/*     */     //   1776: invokevirtual intValue : ()I
/*     */     //   1779: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1782: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1785: checkcast java/lang/Number
/*     */     //   1788: invokevirtual intValue : ()I
/*     */     //   1791: sipush #255
/*     */     //   1794: invokespecial <init> : (IIII)V
/*     */     //   1797: invokestatic glColor : (Ljava/awt/Color;)V
/*     */     //   1800: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1803: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1808: fload_3
/*     */     //   1809: invokeinterface setGammaSetting : (F)V
/*     */     //   1814: goto -> 1818
/*     */     //   1817: astore_2
/*     */     //   1818: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #33	-> 6
/*     */     //   #34	-> 7
/*     */     //   #36	-> 18
/*     */     //   #37	-> 28
/*     */     //   #38	-> 31
/*     */     //   #41	-> 34
/*     */     //   #43	-> 48
/*     */     //   #45	-> 63
/*     */     //   #46	-> 112
/*     */     //   #47	-> 113
/*     */     //   #48	-> 209
/*     */     //   #49	-> 265
/*     */     //   #50	-> 300
/*     */     //   #51	-> 335
/*     */     //   #52	-> 370
/*     */     //   #53	-> 418
/*     */     //   #46	-> 419
/*     */     //   #54	-> 427
/*     */     //   #46	-> 430
/*     */     //   #56	-> 432
/*     */     //   #57	-> 458
/*     */     //   #58	-> 485
/*     */     //   #60	-> 488
/*     */     //   #62	-> 580
/*     */     //   #63	-> 594
/*     */     //   #76	-> 607
/*     */     //   #61	-> 621
/*     */     //   #62	-> 675
/*     */     //   #64	-> 706
/*     */     //   #65	-> 711
/*     */     //   #66	-> 717
/*     */     //   #67	-> 732
/*     */     //   #68	-> 735
/*     */     //   #69	-> 750
/*     */     //   #70	-> 753
/*     */     //   #71	-> 768
/*     */     //   #72	-> 773
/*     */     //   #73	-> 788
/*     */     //   #74	-> 791
/*     */     //   #77	-> 800
/*     */     //   #78	-> 803
/*     */     //   #79	-> 809
/*     */     //   #80	-> 818
/*     */     //   #81	-> 824
/*     */     //   #82	-> 830
/*     */     //   #83	-> 836
/*     */     //   #84	-> 842
/*     */     //   #85	-> 848
/*     */     //   #86	-> 857
/*     */     //   #87	-> 872
/*     */     //   #88	-> 877
/*     */     //   #89	-> 883
/*     */     //   #90	-> 898
/*     */     //   #91	-> 901
/*     */     //   #93	-> 904
/*     */     //   #45	-> 904
/*     */     //   #95	-> 907
/*     */     //   #96	-> 956
/*     */     //   #97	-> 969
/*     */     //   #99	-> 1060
/*     */     //   #100	-> 1074
/*     */     //   #116	-> 1087
/*     */     //   #98	-> 1101
/*     */     //   #99	-> 1191
/*     */     //   #101	-> 1263
/*     */     //   #102	-> 1278
/*     */     //   #103	-> 1292
/*     */     //   #104	-> 1308
/*     */     //   #105	-> 1314
/*     */     //   #106	-> 1344
/*     */     //   #107	-> 1347
/*     */     //   #108	-> 1377
/*     */     //   #109	-> 1380
/*     */     //   #110	-> 1410
/*     */     //   #111	-> 1426
/*     */     //   #112	-> 1456
/*     */     //   #113	-> 1459
/*     */     //   #114	-> 1465
/*     */     //   #117	-> 1483
/*     */     //   #118	-> 1498
/*     */     //   #119	-> 1512
/*     */     //   #120	-> 1515
/*     */     //   #121	-> 1521
/*     */     //   #122	-> 1530
/*     */     //   #123	-> 1536
/*     */     //   #124	-> 1542
/*     */     //   #125	-> 1548
/*     */     //   #126	-> 1554
/*     */     //   #127	-> 1560
/*     */     //   #128	-> 1569
/*     */     //   #129	-> 1615
/*     */     //   #130	-> 1645
/*     */     //   #131	-> 1691
/*     */     //   #132	-> 1697
/*     */     //   #133	-> 1727
/*     */     //   #134	-> 1730
/*     */     //   #135	-> 1733
/*     */     //   #137	-> 1748
/*     */     //   #95	-> 1748
/*     */     //   #140	-> 1751
/*     */     //   #141	-> 1800
/*     */     //   #142	-> 1817
/*     */     //   #143	-> 1818
/*     */     //   #144	-> 1818
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   432	472	6	color	Ljava/awt/Color;
/*     */     //   112	792	4	tileEntity	Lnet/ccbluex/liquidbounce/api/minecraft/tileentity/ITileEntity;
/*     */     //   1278	202	7	entityShadow	Z
/*     */     //   1498	250	7	entityShadow	Z
/*     */     //   956	792	4	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   48	1766	3	gamma	F
/*     */     //   18	1796	2	mode	Ljava/lang/String;
/*     */     //   0	1819	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/render/StorageESP;
/*     */     //   0	1819	1	event	Lnet/ccbluex/liquidbounce/event/Render3DEvent;
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   6	1814	1817	java/lang/Exception
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
/*     */   @EventTarget
/*     */   public final void onRender2D(@NotNull Render2DEvent event) {
/* 148 */     Intrinsics.checkParameterIsNotNull(event, "event"); String mode = (String)this.modeValue.get();
/* 149 */     if ((StringsKt.equals(mode, "shaderoutline", true) ? OutlineShader.OUTLINE_SHADER : (StringsKt.equals(mode, "shaderglow", true) ? (FramebufferShader)GlowShader.GLOW_SHADER : null)) != null) { Object object = StringsKt.equals(mode, "shaderoutline", true) ? OutlineShader.OUTLINE_SHADER : (StringsKt.equals(mode, "shaderglow", true) ? (FramebufferShader)GlowShader.GLOW_SHADER : null);
/*     */       
/* 151 */       object.startDraw(event.getPartialTicks());
/*     */       try {
/* 153 */         IRenderManager renderManager = MinecraftInstance.mc.getRenderManager();
/* 154 */         if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  for (ITileEntity entity : MinecraftInstance.mc.getTheWorld().getLoadedTileEntityList()) {
/* 155 */           if (!MinecraftInstance.classProvider.isTileEntityChest(entity))
/*     */             continue; 
/* 157 */           if (ChestAura.INSTANCE.getClickedBlocks().contains(entity.getPos())) {
/*     */             continue;
/*     */           }
/* 160 */           MinecraftInstance.mc.getRenderManager().renderEntityAt(
/* 161 */               entity, 
/* 162 */               entity.getPos().getX() - renderManager.getRenderPosX(), 
/* 163 */               entity.getPos().getY() - renderManager.getRenderPosY(), 
/* 164 */               entity.getPos().getZ() - renderManager.getRenderPosZ(), 
/* 165 */               event.getPartialTicks());
/*     */         } 
/*     */         
/* 168 */         if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  for (IEntity entity : MinecraftInstance.mc.getTheWorld().getLoadedEntityList()) {
/* 169 */           if (!MinecraftInstance.classProvider.isEntityMinecartChest(entity)) {
/*     */             continue;
/*     */           }
/* 172 */           renderManager.renderEntityStatic(entity, event.getPartialTicks(), true);
/*     */         } 
/* 174 */       } catch (Exception ex) {
/* 175 */         ClientUtils.getLogger().error("An error occurred while rendering all storages for shader esp", ex);
/*     */       } 
/*     */       
/* 178 */       object.stopDraw(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), StringsKt.equals(mode, "shaderglow", true) ? 2.5F : 1.5F, 1.0F);
/*     */       return; }
/*     */     
/*     */     StringsKt.equals(mode, "shaderoutline", true) ? OutlineShader.OUTLINE_SHADER : (StringsKt.equals(mode, "shaderglow", true) ? (FramebufferShader)GlowShader.GLOW_SHADER : null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\StorageESP.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */