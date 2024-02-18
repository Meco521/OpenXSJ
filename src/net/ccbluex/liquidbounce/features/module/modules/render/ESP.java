/*     */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*     */ import java.awt.Color;
/*     */ import java.text.DecimalFormat;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.FloatCompanionObject;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.IEntityPlayer;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemArmor;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.renderer.entity.IRenderManager;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.ITimer;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.Render2DEvent;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.misc.Teams;
/*     */ import net.ccbluex.liquidbounce.utils.EntityUtils;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.WorldToScreen;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.util.vector.Matrix4f;
/*     */ import org.lwjgl.util.vector.Vector2f;
/*     */ import org.lwjgl.util.vector.Vector3f;
/*     */ 
/*     */ @ModuleInfo(name = "ESP", description = "FDPESP", category = ModuleCategory.RENDER)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000Z\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\002\b\n\n\002\020\016\n\002\b\006\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\006\020\037\032\0020 J\016\020!\032\0020\"2\006\020#\032\0020$J\016\020%\032\0020&2\006\020#\032\0020'J\020\020(\032\0020 2\006\020)\032\0020*H\007J\020\020+\032\0020 2\006\020)\032\0020,H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\006X\004¢\006\002\n\000R\016\020\b\032\0020\006X\004¢\006\002\n\000R\016\020\t\032\0020\006X\004¢\006\002\n\000R\016\020\n\032\0020\006X\004¢\006\002\n\000R\016\020\013\032\0020\fX\004¢\006\002\n\000R\016\020\r\032\0020\016X\004¢\006\002\n\000R\021\020\017\032\0020\006¢\006\b\n\000\032\004\b\020\020\021R\021\020\022\032\0020\004¢\006\b\n\000\032\004\b\023\020\024R\016\020\025\032\0020\fX\004¢\006\002\n\000R\016\020\026\032\0020\fX\004¢\006\002\n\000R\016\020\027\032\0020\fX\004¢\006\002\n\000R\024\020\030\032\0020\0318VX\004¢\006\006\032\004\b\032\020\033R\021\020\034\032\0020\f¢\006\b\n\000\032\004\b\035\020\036¨\006-"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/ESP;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "colorModeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "colorRainbowValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "csgoDirectLineValue", "csgoShowHealthValue", "csgoShowHeldItemValue", "csgoShowNameValue", "csgoWidthValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "decimalFormat", "Ljava/text/DecimalFormat;", "invisible", "getInvisible", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "modeValue", "getModeValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "outlineWidthValue", "shaderGlowRadiusValue", "shaderOutlineRadiusValue", "tag", "", "getTag", "()Ljava/lang/String;", "wireframeWidthValue", "getWireframeWidthValue", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "doWireFrame", "", "getColor", "Ljava/awt/Color;", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "isValid", "", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "onRender2D", "event", "Lnet/ccbluex/liquidbounce/event/Render2DEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "XSJClient"})
/*     */ public final class ESP extends Module {
/*     */   @NotNull
/*  40 */   private final ListValue modeValue = new ListValue(
/*  41 */       "Mode", 
/*  42 */       new String[] { "Box", "OtherBox", "WireFrame", "2D", "Real2D", "CSGO", "CSGO-Old", "Outline", "ShaderOutline", "ShaderGlow", "Jello", "Frame"
/*  43 */       }, "CSGO");
/*     */   @NotNull
/*  45 */   public final ListValue getModeValue() { return this.modeValue; } private final FloatValue outlineWidthValue = new FloatValue("Outline-Width", 3.0F, 0.5F, 5.0F); @NotNull
/*  46 */   private final FloatValue wireframeWidthValue = new FloatValue("WireFrame-Width", 2.0F, 0.5F, 5.0F); @NotNull public final FloatValue getWireframeWidthValue() { return this.wireframeWidthValue; }
/*  47 */    private final FloatValue shaderOutlineRadiusValue = new FloatValue("ShaderOutline-Radius", 1.35F, 1.0F, 2.0F);
/*  48 */   private final FloatValue shaderGlowRadiusValue = new FloatValue("ShaderGlow-Radius", 2.3F, 2.0F, 3.0F);
/*  49 */   private final BoolValue csgoDirectLineValue = new BoolValue("CSGO-DirectLine", false);
/*  50 */   private final BoolValue csgoShowHealthValue = new BoolValue("CSGO-ShowHealth", true);
/*  51 */   private final BoolValue csgoShowHeldItemValue = new BoolValue("CSGO-ShowHeldItem", true);
/*  52 */   private final BoolValue csgoShowNameValue = new BoolValue("CSGO-ShowName", true);
/*  53 */   private final FloatValue csgoWidthValue = new FloatValue("CSGOOld-Width", 2.0F, 0.5F, 5.0F);
/*  54 */   private final ListValue colorModeValue = new ListValue("ColorMode", new String[] { "Name", "Armor", "OFF" }, "Name");
/*  55 */   private final BoolValue colorRainbowValue = new BoolValue("Rainbow", false); @NotNull
/*  56 */   private final BoolValue invisible = new BoolValue("Invisible", false); @NotNull public final BoolValue getInvisible() { return this.invisible; }
/*     */   
/*  58 */   private final DecimalFormat decimalFormat = new DecimalFormat("0.0");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */     //   6: aload_0
/*     */     //   7: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   10: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   13: checkcast java/lang/String
/*     */     //   16: astore_3
/*     */     //   17: iconst_0
/*     */     //   18: istore #4
/*     */     //   20: aload_3
/*     */     //   21: dup
/*     */     //   22: ifnonnull -> 35
/*     */     //   25: new kotlin/TypeCastException
/*     */     //   28: dup
/*     */     //   29: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   31: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   34: athrow
/*     */     //   35: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   38: dup
/*     */     //   39: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   41: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   44: astore_2
/*     */     //   45: sipush #2982
/*     */     //   48: invokestatic getMatrix : (I)Lorg/lwjgl/util/vector/Matrix4f;
/*     */     //   51: astore_3
/*     */     //   52: sipush #2983
/*     */     //   55: invokestatic getMatrix : (I)Lorg/lwjgl/util/vector/Matrix4f;
/*     */     //   58: astore #4
/*     */     //   60: aload_2
/*     */     //   61: ldc 'csgo'
/*     */     //   63: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   66: ifne -> 87
/*     */     //   69: aload_2
/*     */     //   70: ldc 'real2d'
/*     */     //   72: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   75: ifne -> 87
/*     */     //   78: aload_2
/*     */     //   79: ldc 'csgo-old'
/*     */     //   81: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   84: ifeq -> 91
/*     */     //   87: iconst_1
/*     */     //   88: goto -> 92
/*     */     //   91: iconst_0
/*     */     //   92: istore #5
/*     */     //   94: iload #5
/*     */     //   96: ifeq -> 200
/*     */     //   99: sipush #8192
/*     */     //   102: invokestatic glPushAttrib : (I)V
/*     */     //   105: sipush #3042
/*     */     //   108: invokestatic glEnable : (I)V
/*     */     //   111: sipush #3553
/*     */     //   114: invokestatic glDisable : (I)V
/*     */     //   117: sipush #2929
/*     */     //   120: invokestatic glDisable : (I)V
/*     */     //   123: sipush #5889
/*     */     //   126: invokestatic glMatrixMode : (I)V
/*     */     //   129: invokestatic glPushMatrix : ()V
/*     */     //   132: invokestatic glLoadIdentity : ()V
/*     */     //   135: dconst_0
/*     */     //   136: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   139: invokeinterface getDisplayWidth : ()I
/*     */     //   144: i2d
/*     */     //   145: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   148: invokeinterface getDisplayHeight : ()I
/*     */     //   153: i2d
/*     */     //   154: dconst_0
/*     */     //   155: ldc2_w -1.0
/*     */     //   158: dconst_1
/*     */     //   159: invokestatic glOrtho : (DDDDDD)V
/*     */     //   162: sipush #5888
/*     */     //   165: invokestatic glMatrixMode : (I)V
/*     */     //   168: invokestatic glPushMatrix : ()V
/*     */     //   171: invokestatic glLoadIdentity : ()V
/*     */     //   174: sipush #2929
/*     */     //   177: invokestatic glDisable : (I)V
/*     */     //   180: sipush #770
/*     */     //   183: sipush #771
/*     */     //   186: invokestatic glBlendFunc : (II)V
/*     */     //   189: invokestatic func_179098_w : ()V
/*     */     //   192: iconst_1
/*     */     //   193: invokestatic func_179132_a : (Z)V
/*     */     //   196: fconst_1
/*     */     //   197: invokestatic glLineWidth : (F)V
/*     */     //   200: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   203: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   208: dup
/*     */     //   209: ifnonnull -> 215
/*     */     //   212: invokestatic throwNpe : ()V
/*     */     //   215: invokeinterface getLoadedEntityList : ()Ljava/util/Collection;
/*     */     //   220: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   225: astore #7
/*     */     //   227: aload #7
/*     */     //   229: invokeinterface hasNext : ()Z
/*     */     //   234: ifeq -> 2432
/*     */     //   237: aload #7
/*     */     //   239: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   244: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   247: astore #6
/*     */     //   249: aload #6
/*     */     //   251: iconst_0
/*     */     //   252: invokestatic isSelected : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Z)Z
/*     */     //   255: ifeq -> 2429
/*     */     //   258: aload #6
/*     */     //   260: invokeinterface asEntityLivingBase : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   265: astore #8
/*     */     //   267: aload_0
/*     */     //   268: aload #8
/*     */     //   270: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   273: invokevirtual getColor : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)Ljava/awt/Color;
/*     */     //   276: astore #9
/*     */     //   278: aload_2
/*     */     //   279: astore #10
/*     */     //   281: aload #10
/*     */     //   283: invokevirtual hashCode : ()I
/*     */     //   286: lookupswitch default -> 2429, -1518963662 -> 386, -1171135301 -> 438, -1106245566 -> 360, -934973296 -> 399, 1650 -> 373, 97739 -> 425, 3063128 -> 412, 97692013 -> 451
/*     */     //   360: aload #10
/*     */     //   362: ldc 'outline'
/*     */     //   364: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   367: ifeq -> 2429
/*     */     //   370: goto -> 503
/*     */     //   373: aload #10
/*     */     //   375: ldc '2d'
/*     */     //   377: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   380: ifeq -> 2429
/*     */     //   383: goto -> 528
/*     */     //   386: aload #10
/*     */     //   388: ldc 'csgo-old'
/*     */     //   390: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   393: ifeq -> 2429
/*     */     //   396: goto -> 706
/*     */     //   399: aload #10
/*     */     //   401: ldc 'real2d'
/*     */     //   403: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   406: ifeq -> 2429
/*     */     //   409: goto -> 706
/*     */     //   412: aload #10
/*     */     //   414: ldc 'csgo'
/*     */     //   416: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   419: ifeq -> 2429
/*     */     //   422: goto -> 706
/*     */     //   425: aload #10
/*     */     //   427: ldc 'box'
/*     */     //   429: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   432: ifeq -> 2429
/*     */     //   435: goto -> 464
/*     */     //   438: aload #10
/*     */     //   440: ldc 'otherbox'
/*     */     //   442: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   445: ifeq -> 2429
/*     */     //   448: goto -> 464
/*     */     //   451: aload #10
/*     */     //   453: ldc 'frame'
/*     */     //   455: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   458: ifeq -> 2429
/*     */     //   461: goto -> 496
/*     */     //   464: aload #6
/*     */     //   466: aload #9
/*     */     //   468: aload_2
/*     */     //   469: ldc 'otherbox'
/*     */     //   471: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   474: iconst_1
/*     */     //   475: ixor
/*     */     //   476: iconst_1
/*     */     //   477: aload_0
/*     */     //   478: getfield outlineWidthValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   481: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   484: checkcast java/lang/Number
/*     */     //   487: invokevirtual floatValue : ()F
/*     */     //   490: invokestatic drawEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Ljava/awt/Color;ZZF)V
/*     */     //   493: goto -> 2429
/*     */     //   496: aload_0
/*     */     //   497: invokevirtual doWireFrame : ()V
/*     */     //   500: goto -> 2429
/*     */     //   503: aload #6
/*     */     //   505: aload #9
/*     */     //   507: iconst_1
/*     */     //   508: iconst_0
/*     */     //   509: aload_0
/*     */     //   510: getfield outlineWidthValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   513: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   516: checkcast java/lang/Number
/*     */     //   519: invokevirtual floatValue : ()F
/*     */     //   522: invokestatic drawEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Ljava/awt/Color;ZZF)V
/*     */     //   525: goto -> 2429
/*     */     //   528: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   531: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   536: astore #11
/*     */     //   538: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   541: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   546: astore #12
/*     */     //   548: aload #8
/*     */     //   550: invokeinterface getLastTickPosX : ()D
/*     */     //   555: aload #8
/*     */     //   557: invokeinterface getPosX : ()D
/*     */     //   562: aload #8
/*     */     //   564: invokeinterface getLastTickPosX : ()D
/*     */     //   569: dsub
/*     */     //   570: aload #12
/*     */     //   572: invokeinterface getRenderPartialTicks : ()F
/*     */     //   577: f2d
/*     */     //   578: dmul
/*     */     //   579: dadd
/*     */     //   580: aload #11
/*     */     //   582: invokeinterface getRenderPosX : ()D
/*     */     //   587: dsub
/*     */     //   588: dstore #13
/*     */     //   590: aload #8
/*     */     //   592: invokeinterface getLastTickPosY : ()D
/*     */     //   597: aload #8
/*     */     //   599: invokeinterface getPosY : ()D
/*     */     //   604: aload #8
/*     */     //   606: invokeinterface getLastTickPosY : ()D
/*     */     //   611: dsub
/*     */     //   612: aload #12
/*     */     //   614: invokeinterface getRenderPartialTicks : ()F
/*     */     //   619: f2d
/*     */     //   620: dmul
/*     */     //   621: dadd
/*     */     //   622: aload #11
/*     */     //   624: invokeinterface getRenderPosY : ()D
/*     */     //   629: dsub
/*     */     //   630: dstore #15
/*     */     //   632: aload #8
/*     */     //   634: invokeinterface getLastTickPosZ : ()D
/*     */     //   639: aload #8
/*     */     //   641: invokeinterface getPosZ : ()D
/*     */     //   646: aload #8
/*     */     //   648: invokeinterface getLastTickPosZ : ()D
/*     */     //   653: dsub
/*     */     //   654: aload #12
/*     */     //   656: invokeinterface getRenderPartialTicks : ()F
/*     */     //   661: f2d
/*     */     //   662: dmul
/*     */     //   663: dadd
/*     */     //   664: aload #11
/*     */     //   666: invokeinterface getRenderPosZ : ()D
/*     */     //   671: dsub
/*     */     //   672: dstore #17
/*     */     //   674: aload #8
/*     */     //   676: dload #13
/*     */     //   678: dload #15
/*     */     //   680: dload #17
/*     */     //   682: aload #9
/*     */     //   684: invokevirtual getRGB : ()I
/*     */     //   687: getstatic java/awt/Color.BLACK : Ljava/awt/Color;
/*     */     //   690: dup
/*     */     //   691: ldc_w 'Color.BLACK'
/*     */     //   694: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   697: invokevirtual getRGB : ()I
/*     */     //   700: invokestatic draw2D : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;DDDII)V
/*     */     //   703: goto -> 2429
/*     */     //   706: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   709: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   714: astore #11
/*     */     //   716: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   719: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   724: astore #12
/*     */     //   726: aload #8
/*     */     //   728: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   733: aload #8
/*     */     //   735: invokeinterface getPosX : ()D
/*     */     //   740: dneg
/*     */     //   741: aload #8
/*     */     //   743: invokeinterface getPosY : ()D
/*     */     //   748: dneg
/*     */     //   749: aload #8
/*     */     //   751: invokeinterface getPosZ : ()D
/*     */     //   756: dneg
/*     */     //   757: invokeinterface offset : (DDD)Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   762: aload #8
/*     */     //   764: invokeinterface getLastTickPosX : ()D
/*     */     //   769: aload #8
/*     */     //   771: invokeinterface getPosX : ()D
/*     */     //   776: aload #8
/*     */     //   778: invokeinterface getLastTickPosX : ()D
/*     */     //   783: dsub
/*     */     //   784: aload #12
/*     */     //   786: invokeinterface getRenderPartialTicks : ()F
/*     */     //   791: f2d
/*     */     //   792: dmul
/*     */     //   793: dadd
/*     */     //   794: aload #8
/*     */     //   796: invokeinterface getLastTickPosY : ()D
/*     */     //   801: aload #8
/*     */     //   803: invokeinterface getPosY : ()D
/*     */     //   808: aload #8
/*     */     //   810: invokeinterface getLastTickPosY : ()D
/*     */     //   815: dsub
/*     */     //   816: aload #12
/*     */     //   818: invokeinterface getRenderPartialTicks : ()F
/*     */     //   823: f2d
/*     */     //   824: dmul
/*     */     //   825: dadd
/*     */     //   826: aload #8
/*     */     //   828: invokeinterface getLastTickPosZ : ()D
/*     */     //   833: aload #8
/*     */     //   835: invokeinterface getPosZ : ()D
/*     */     //   840: aload #8
/*     */     //   842: invokeinterface getLastTickPosZ : ()D
/*     */     //   847: dsub
/*     */     //   848: aload #12
/*     */     //   850: invokeinterface getRenderPartialTicks : ()F
/*     */     //   855: f2d
/*     */     //   856: dmul
/*     */     //   857: dadd
/*     */     //   858: invokeinterface offset : (DDD)Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   863: aload #11
/*     */     //   865: invokeinterface getRenderPosX : ()D
/*     */     //   870: dneg
/*     */     //   871: aload #11
/*     */     //   873: invokeinterface getRenderPosY : ()D
/*     */     //   878: dneg
/*     */     //   879: aload #11
/*     */     //   881: invokeinterface getRenderPosZ : ()D
/*     */     //   886: dneg
/*     */     //   887: invokeinterface offset : (DDD)Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   892: astore #13
/*     */     //   894: bipush #8
/*     */     //   896: anewarray [D
/*     */     //   899: dup
/*     */     //   900: iconst_0
/*     */     //   901: iconst_3
/*     */     //   902: newarray double
/*     */     //   904: dup
/*     */     //   905: iconst_0
/*     */     //   906: aload #13
/*     */     //   908: invokeinterface getMinX : ()D
/*     */     //   913: dastore
/*     */     //   914: dup
/*     */     //   915: iconst_1
/*     */     //   916: aload #13
/*     */     //   918: invokeinterface getMinY : ()D
/*     */     //   923: dastore
/*     */     //   924: dup
/*     */     //   925: iconst_2
/*     */     //   926: aload #13
/*     */     //   928: invokeinterface getMinZ : ()D
/*     */     //   933: dastore
/*     */     //   934: aastore
/*     */     //   935: dup
/*     */     //   936: iconst_1
/*     */     //   937: iconst_3
/*     */     //   938: newarray double
/*     */     //   940: dup
/*     */     //   941: iconst_0
/*     */     //   942: aload #13
/*     */     //   944: invokeinterface getMinX : ()D
/*     */     //   949: dastore
/*     */     //   950: dup
/*     */     //   951: iconst_1
/*     */     //   952: aload #13
/*     */     //   954: invokeinterface getMaxY : ()D
/*     */     //   959: dastore
/*     */     //   960: dup
/*     */     //   961: iconst_2
/*     */     //   962: aload #13
/*     */     //   964: invokeinterface getMinZ : ()D
/*     */     //   969: dastore
/*     */     //   970: aastore
/*     */     //   971: dup
/*     */     //   972: iconst_2
/*     */     //   973: iconst_3
/*     */     //   974: newarray double
/*     */     //   976: dup
/*     */     //   977: iconst_0
/*     */     //   978: aload #13
/*     */     //   980: invokeinterface getMaxX : ()D
/*     */     //   985: dastore
/*     */     //   986: dup
/*     */     //   987: iconst_1
/*     */     //   988: aload #13
/*     */     //   990: invokeinterface getMaxY : ()D
/*     */     //   995: dastore
/*     */     //   996: dup
/*     */     //   997: iconst_2
/*     */     //   998: aload #13
/*     */     //   1000: invokeinterface getMinZ : ()D
/*     */     //   1005: dastore
/*     */     //   1006: aastore
/*     */     //   1007: dup
/*     */     //   1008: iconst_3
/*     */     //   1009: iconst_3
/*     */     //   1010: newarray double
/*     */     //   1012: dup
/*     */     //   1013: iconst_0
/*     */     //   1014: aload #13
/*     */     //   1016: invokeinterface getMaxX : ()D
/*     */     //   1021: dastore
/*     */     //   1022: dup
/*     */     //   1023: iconst_1
/*     */     //   1024: aload #13
/*     */     //   1026: invokeinterface getMinY : ()D
/*     */     //   1031: dastore
/*     */     //   1032: dup
/*     */     //   1033: iconst_2
/*     */     //   1034: aload #13
/*     */     //   1036: invokeinterface getMinZ : ()D
/*     */     //   1041: dastore
/*     */     //   1042: aastore
/*     */     //   1043: dup
/*     */     //   1044: iconst_4
/*     */     //   1045: iconst_3
/*     */     //   1046: newarray double
/*     */     //   1048: dup
/*     */     //   1049: iconst_0
/*     */     //   1050: aload #13
/*     */     //   1052: invokeinterface getMinX : ()D
/*     */     //   1057: dastore
/*     */     //   1058: dup
/*     */     //   1059: iconst_1
/*     */     //   1060: aload #13
/*     */     //   1062: invokeinterface getMinY : ()D
/*     */     //   1067: dastore
/*     */     //   1068: dup
/*     */     //   1069: iconst_2
/*     */     //   1070: aload #13
/*     */     //   1072: invokeinterface getMaxZ : ()D
/*     */     //   1077: dastore
/*     */     //   1078: aastore
/*     */     //   1079: dup
/*     */     //   1080: iconst_5
/*     */     //   1081: iconst_3
/*     */     //   1082: newarray double
/*     */     //   1084: dup
/*     */     //   1085: iconst_0
/*     */     //   1086: aload #13
/*     */     //   1088: invokeinterface getMinX : ()D
/*     */     //   1093: dastore
/*     */     //   1094: dup
/*     */     //   1095: iconst_1
/*     */     //   1096: aload #13
/*     */     //   1098: invokeinterface getMaxY : ()D
/*     */     //   1103: dastore
/*     */     //   1104: dup
/*     */     //   1105: iconst_2
/*     */     //   1106: aload #13
/*     */     //   1108: invokeinterface getMaxZ : ()D
/*     */     //   1113: dastore
/*     */     //   1114: aastore
/*     */     //   1115: dup
/*     */     //   1116: bipush #6
/*     */     //   1118: iconst_3
/*     */     //   1119: newarray double
/*     */     //   1121: dup
/*     */     //   1122: iconst_0
/*     */     //   1123: aload #13
/*     */     //   1125: invokeinterface getMaxX : ()D
/*     */     //   1130: dastore
/*     */     //   1131: dup
/*     */     //   1132: iconst_1
/*     */     //   1133: aload #13
/*     */     //   1135: invokeinterface getMaxY : ()D
/*     */     //   1140: dastore
/*     */     //   1141: dup
/*     */     //   1142: iconst_2
/*     */     //   1143: aload #13
/*     */     //   1145: invokeinterface getMaxZ : ()D
/*     */     //   1150: dastore
/*     */     //   1151: aastore
/*     */     //   1152: dup
/*     */     //   1153: bipush #7
/*     */     //   1155: iconst_3
/*     */     //   1156: newarray double
/*     */     //   1158: dup
/*     */     //   1159: iconst_0
/*     */     //   1160: aload #13
/*     */     //   1162: invokeinterface getMaxX : ()D
/*     */     //   1167: dastore
/*     */     //   1168: dup
/*     */     //   1169: iconst_1
/*     */     //   1170: aload #13
/*     */     //   1172: invokeinterface getMinY : ()D
/*     */     //   1177: dastore
/*     */     //   1178: dup
/*     */     //   1179: iconst_2
/*     */     //   1180: aload #13
/*     */     //   1182: invokeinterface getMaxZ : ()D
/*     */     //   1187: dastore
/*     */     //   1188: aastore
/*     */     //   1189: checkcast [[D
/*     */     //   1192: astore #14
/*     */     //   1194: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1197: invokeinterface getDisplayWidth : ()I
/*     */     //   1202: i2f
/*     */     //   1203: fstore #15
/*     */     //   1205: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1208: invokeinterface getDisplayHeight : ()I
/*     */     //   1213: i2f
/*     */     //   1214: fstore #16
/*     */     //   1216: fconst_0
/*     */     //   1217: fstore #17
/*     */     //   1219: fconst_0
/*     */     //   1220: fstore #18
/*     */     //   1222: aload #14
/*     */     //   1224: astore #21
/*     */     //   1226: aload #21
/*     */     //   1228: arraylength
/*     */     //   1229: istore #22
/*     */     //   1231: iconst_0
/*     */     //   1232: istore #20
/*     */     //   1234: iload #20
/*     */     //   1236: iload #22
/*     */     //   1238: if_icmpge -> 1359
/*     */     //   1241: aload #21
/*     */     //   1243: iload #20
/*     */     //   1245: aaload
/*     */     //   1246: astore #19
/*     */     //   1248: new org/lwjgl/util/vector/Vector3f
/*     */     //   1251: dup
/*     */     //   1252: aload #19
/*     */     //   1254: iconst_0
/*     */     //   1255: daload
/*     */     //   1256: d2f
/*     */     //   1257: aload #19
/*     */     //   1259: iconst_1
/*     */     //   1260: daload
/*     */     //   1261: d2f
/*     */     //   1262: aload #19
/*     */     //   1264: iconst_2
/*     */     //   1265: daload
/*     */     //   1266: d2f
/*     */     //   1267: invokespecial <init> : (FFF)V
/*     */     //   1270: aload_3
/*     */     //   1271: aload #4
/*     */     //   1273: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1276: invokeinterface getDisplayWidth : ()I
/*     */     //   1281: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1284: invokeinterface getDisplayHeight : ()I
/*     */     //   1289: invokestatic worldToScreen : (Lorg/lwjgl/util/vector/Vector3f;Lorg/lwjgl/util/vector/Matrix4f;Lorg/lwjgl/util/vector/Matrix4f;II)Lorg/lwjgl/util/vector/Vector2f;
/*     */     //   1292: dup
/*     */     //   1293: ifnull -> 1299
/*     */     //   1296: goto -> 1303
/*     */     //   1299: pop
/*     */     //   1300: goto -> 1353
/*     */     //   1303: astore #23
/*     */     //   1305: aload #23
/*     */     //   1307: getfield x : F
/*     */     //   1310: fload #15
/*     */     //   1312: invokestatic coerceAtMost : (FF)F
/*     */     //   1315: fstore #15
/*     */     //   1317: aload #23
/*     */     //   1319: getfield y : F
/*     */     //   1322: fload #16
/*     */     //   1324: invokestatic coerceAtMost : (FF)F
/*     */     //   1327: fstore #16
/*     */     //   1329: aload #23
/*     */     //   1331: getfield x : F
/*     */     //   1334: fload #17
/*     */     //   1336: invokestatic coerceAtLeast : (FF)F
/*     */     //   1339: fstore #17
/*     */     //   1341: aload #23
/*     */     //   1343: getfield y : F
/*     */     //   1346: fload #18
/*     */     //   1348: invokestatic coerceAtLeast : (FF)F
/*     */     //   1351: fstore #18
/*     */     //   1353: iinc #20, 1
/*     */     //   1356: goto -> 1234
/*     */     //   1359: fload #15
/*     */     //   1361: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1364: invokeinterface getDisplayWidth : ()I
/*     */     //   1369: i2f
/*     */     //   1370: fcmpg
/*     */     //   1371: ifeq -> 2429
/*     */     //   1374: fload #16
/*     */     //   1376: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1379: invokeinterface getDisplayHeight : ()I
/*     */     //   1384: i2f
/*     */     //   1385: fcmpg
/*     */     //   1386: ifeq -> 2429
/*     */     //   1389: fload #17
/*     */     //   1391: fconst_0
/*     */     //   1392: fcmpg
/*     */     //   1393: ifeq -> 2429
/*     */     //   1396: fload #18
/*     */     //   1398: fconst_0
/*     */     //   1399: fcmpg
/*     */     //   1400: ifeq -> 2429
/*     */     //   1403: aload_2
/*     */     //   1404: ldc 'csgo'
/*     */     //   1406: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   1409: ifeq -> 2115
/*     */     //   1412: aload #9
/*     */     //   1414: invokestatic glColor : (Ljava/awt/Color;)V
/*     */     //   1417: aload_0
/*     */     //   1418: getfield csgoDirectLineValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1421: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1424: checkcast java/lang/Boolean
/*     */     //   1427: invokevirtual booleanValue : ()Z
/*     */     //   1430: ifne -> 1594
/*     */     //   1433: fload #17
/*     */     //   1435: fload #15
/*     */     //   1437: fsub
/*     */     //   1438: ldc_w 3.0
/*     */     //   1441: fdiv
/*     */     //   1442: fstore #19
/*     */     //   1444: fload #18
/*     */     //   1446: fload #16
/*     */     //   1448: fsub
/*     */     //   1449: ldc_w 3.0
/*     */     //   1452: fdiv
/*     */     //   1453: fstore #20
/*     */     //   1455: iconst_3
/*     */     //   1456: invokestatic glBegin : (I)V
/*     */     //   1459: fload #15
/*     */     //   1461: fload #16
/*     */     //   1463: fload #20
/*     */     //   1465: fadd
/*     */     //   1466: invokestatic glVertex2f : (FF)V
/*     */     //   1469: fload #15
/*     */     //   1471: fload #16
/*     */     //   1473: invokestatic glVertex2f : (FF)V
/*     */     //   1476: fload #15
/*     */     //   1478: fload #19
/*     */     //   1480: fadd
/*     */     //   1481: fload #16
/*     */     //   1483: invokestatic glVertex2f : (FF)V
/*     */     //   1486: invokestatic glEnd : ()V
/*     */     //   1489: iconst_3
/*     */     //   1490: invokestatic glBegin : (I)V
/*     */     //   1493: fload #15
/*     */     //   1495: fload #18
/*     */     //   1497: fload #20
/*     */     //   1499: fsub
/*     */     //   1500: invokestatic glVertex2f : (FF)V
/*     */     //   1503: fload #15
/*     */     //   1505: fload #18
/*     */     //   1507: invokestatic glVertex2f : (FF)V
/*     */     //   1510: fload #15
/*     */     //   1512: fload #19
/*     */     //   1514: fadd
/*     */     //   1515: fload #18
/*     */     //   1517: invokestatic glVertex2f : (FF)V
/*     */     //   1520: invokestatic glEnd : ()V
/*     */     //   1523: iconst_3
/*     */     //   1524: invokestatic glBegin : (I)V
/*     */     //   1527: fload #17
/*     */     //   1529: fload #19
/*     */     //   1531: fsub
/*     */     //   1532: fload #16
/*     */     //   1534: invokestatic glVertex2f : (FF)V
/*     */     //   1537: fload #17
/*     */     //   1539: fload #16
/*     */     //   1541: invokestatic glVertex2f : (FF)V
/*     */     //   1544: fload #17
/*     */     //   1546: fload #16
/*     */     //   1548: fload #20
/*     */     //   1550: fadd
/*     */     //   1551: invokestatic glVertex2f : (FF)V
/*     */     //   1554: invokestatic glEnd : ()V
/*     */     //   1557: iconst_3
/*     */     //   1558: invokestatic glBegin : (I)V
/*     */     //   1561: fload #17
/*     */     //   1563: fload #19
/*     */     //   1565: fsub
/*     */     //   1566: fload #18
/*     */     //   1568: invokestatic glVertex2f : (FF)V
/*     */     //   1571: fload #17
/*     */     //   1573: fload #18
/*     */     //   1575: invokestatic glVertex2f : (FF)V
/*     */     //   1578: fload #17
/*     */     //   1580: fload #18
/*     */     //   1582: fload #20
/*     */     //   1584: fsub
/*     */     //   1585: invokestatic glVertex2f : (FF)V
/*     */     //   1588: invokestatic glEnd : ()V
/*     */     //   1591: goto -> 1629
/*     */     //   1594: iconst_2
/*     */     //   1595: invokestatic glBegin : (I)V
/*     */     //   1598: fload #15
/*     */     //   1600: fload #16
/*     */     //   1602: invokestatic glVertex2f : (FF)V
/*     */     //   1605: fload #15
/*     */     //   1607: fload #18
/*     */     //   1609: invokestatic glVertex2f : (FF)V
/*     */     //   1612: fload #17
/*     */     //   1614: fload #18
/*     */     //   1616: invokestatic glVertex2f : (FF)V
/*     */     //   1619: fload #17
/*     */     //   1621: fload #16
/*     */     //   1623: invokestatic glVertex2f : (FF)V
/*     */     //   1626: invokestatic glEnd : ()V
/*     */     //   1629: aload_0
/*     */     //   1630: getfield csgoShowHealthValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1633: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1636: checkcast java/lang/Boolean
/*     */     //   1639: invokevirtual booleanValue : ()Z
/*     */     //   1642: ifeq -> 1861
/*     */     //   1645: fload #18
/*     */     //   1647: fload #16
/*     */     //   1649: fsub
/*     */     //   1650: fconst_1
/*     */     //   1651: aload #8
/*     */     //   1653: invokeinterface getHealth : ()F
/*     */     //   1658: aload #8
/*     */     //   1660: invokeinterface getMaxHealth : ()F
/*     */     //   1665: fdiv
/*     */     //   1666: fsub
/*     */     //   1667: fmul
/*     */     //   1668: fstore #19
/*     */     //   1670: ldc_w 0.1
/*     */     //   1673: fconst_1
/*     */     //   1674: ldc_w 0.1
/*     */     //   1677: fconst_1
/*     */     //   1678: invokestatic glColor4f : (FFFF)V
/*     */     //   1681: bipush #7
/*     */     //   1683: invokestatic glBegin : (I)V
/*     */     //   1686: fload #17
/*     */     //   1688: fconst_2
/*     */     //   1689: fadd
/*     */     //   1690: fload #16
/*     */     //   1692: fload #19
/*     */     //   1694: fadd
/*     */     //   1695: invokestatic glVertex2f : (FF)V
/*     */     //   1698: fload #17
/*     */     //   1700: fconst_2
/*     */     //   1701: fadd
/*     */     //   1702: fload #18
/*     */     //   1704: invokestatic glVertex2f : (FF)V
/*     */     //   1707: fload #17
/*     */     //   1709: ldc_w 3.0
/*     */     //   1712: fadd
/*     */     //   1713: fload #18
/*     */     //   1715: invokestatic glVertex2f : (FF)V
/*     */     //   1718: fload #17
/*     */     //   1720: ldc_w 3.0
/*     */     //   1723: fadd
/*     */     //   1724: fload #16
/*     */     //   1726: fload #19
/*     */     //   1728: fadd
/*     */     //   1729: invokestatic glVertex2f : (FF)V
/*     */     //   1732: invokestatic glEnd : ()V
/*     */     //   1735: fconst_1
/*     */     //   1736: fconst_1
/*     */     //   1737: fconst_1
/*     */     //   1738: fconst_1
/*     */     //   1739: invokestatic glColor4f : (FFFF)V
/*     */     //   1742: sipush #3553
/*     */     //   1745: invokestatic glEnable : (I)V
/*     */     //   1748: sipush #2929
/*     */     //   1751: invokestatic glEnable : (I)V
/*     */     //   1754: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1757: invokeinterface getFontRendererObj : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1762: new java/lang/StringBuilder
/*     */     //   1765: dup
/*     */     //   1766: invokespecial <init> : ()V
/*     */     //   1769: aload_0
/*     */     //   1770: getfield decimalFormat : Ljava/text/DecimalFormat;
/*     */     //   1773: aload #8
/*     */     //   1775: invokeinterface getHealth : ()F
/*     */     //   1780: invokestatic valueOf : (F)Ljava/lang/Float;
/*     */     //   1783: invokevirtual format : (Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   1786: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1789: ldc_w '§c❤'
/*     */     //   1792: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1795: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1798: fload #17
/*     */     //   1800: ldc_w 4.0
/*     */     //   1803: fadd
/*     */     //   1804: fload #16
/*     */     //   1806: fload #19
/*     */     //   1808: fadd
/*     */     //   1809: getstatic net/ccbluex/liquidbounce/utils/render/ColorUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/render/ColorUtils;
/*     */     //   1812: aload #8
/*     */     //   1814: invokeinterface getHealth : ()F
/*     */     //   1819: aload #8
/*     */     //   1821: invokeinterface getMaxHealth : ()F
/*     */     //   1826: iconst_0
/*     */     //   1827: iconst_4
/*     */     //   1828: aconst_null
/*     */     //   1829: invokestatic healthColor$default : (Lnet/ccbluex/liquidbounce/utils/render/ColorUtils;FFIILjava/lang/Object;)Ljava/awt/Color;
/*     */     //   1832: invokevirtual getRGB : ()I
/*     */     //   1835: iconst_0
/*     */     //   1836: invokeinterface drawString : (Ljava/lang/String;FFIZ)I
/*     */     //   1841: pop
/*     */     //   1842: sipush #3553
/*     */     //   1845: invokestatic glDisable : (I)V
/*     */     //   1848: sipush #2929
/*     */     //   1851: invokestatic glDisable : (I)V
/*     */     //   1854: fconst_1
/*     */     //   1855: fconst_1
/*     */     //   1856: fconst_1
/*     */     //   1857: fconst_1
/*     */     //   1858: invokestatic glColor4f : (FFFF)V
/*     */     //   1861: aload_0
/*     */     //   1862: getfield csgoShowHeldItemValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1865: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1868: checkcast java/lang/Boolean
/*     */     //   1871: invokevirtual booleanValue : ()Z
/*     */     //   1874: ifeq -> 2009
/*     */     //   1877: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1880: aload #8
/*     */     //   1882: invokeinterface isEntityPlayer : (Ljava/lang/Object;)Z
/*     */     //   1887: ifeq -> 2009
/*     */     //   1890: aload #8
/*     */     //   1892: invokeinterface asEntityPlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;
/*     */     //   1897: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1902: dup
/*     */     //   1903: ifnull -> 1914
/*     */     //   1906: invokeinterface getDisplayName : ()Ljava/lang/String;
/*     */     //   1911: goto -> 1916
/*     */     //   1914: pop
/*     */     //   1915: aconst_null
/*     */     //   1916: ifnull -> 2009
/*     */     //   1919: sipush #3553
/*     */     //   1922: invokestatic glEnable : (I)V
/*     */     //   1925: sipush #2929
/*     */     //   1928: invokestatic glEnable : (I)V
/*     */     //   1931: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1934: aload #8
/*     */     //   1936: invokeinterface isEntityPlayer : (Ljava/lang/Object;)Z
/*     */     //   1941: ifeq -> 1997
/*     */     //   1944: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1947: invokeinterface getFontRendererObj : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1952: aload #8
/*     */     //   1954: invokeinterface asEntityPlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;
/*     */     //   1959: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1964: dup
/*     */     //   1965: ifnonnull -> 1971
/*     */     //   1968: invokestatic throwNpe : ()V
/*     */     //   1971: invokeinterface getDisplayName : ()Ljava/lang/String;
/*     */     //   1976: fload #15
/*     */     //   1978: fload #17
/*     */     //   1980: fload #15
/*     */     //   1982: fsub
/*     */     //   1983: fconst_2
/*     */     //   1984: fdiv
/*     */     //   1985: fadd
/*     */     //   1986: fload #18
/*     */     //   1988: fconst_2
/*     */     //   1989: fadd
/*     */     //   1990: iconst_m1
/*     */     //   1991: invokeinterface drawCenteredString : (Ljava/lang/String;FFI)I
/*     */     //   1996: pop
/*     */     //   1997: sipush #3553
/*     */     //   2000: invokestatic glDisable : (I)V
/*     */     //   2003: sipush #2929
/*     */     //   2006: invokestatic glDisable : (I)V
/*     */     //   2009: aload_0
/*     */     //   2010: getfield csgoShowNameValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   2013: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2016: checkcast java/lang/Boolean
/*     */     //   2019: invokevirtual booleanValue : ()Z
/*     */     //   2022: ifeq -> 2429
/*     */     //   2025: sipush #3553
/*     */     //   2028: invokestatic glEnable : (I)V
/*     */     //   2031: sipush #2929
/*     */     //   2034: invokestatic glEnable : (I)V
/*     */     //   2037: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2040: aload #8
/*     */     //   2042: invokeinterface isEntityPlayer : (Ljava/lang/Object;)Z
/*     */     //   2047: ifeq -> 2100
/*     */     //   2050: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2053: invokeinterface getFontRendererObj : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   2058: aload #8
/*     */     //   2060: invokeinterface getDisplayName : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;
/*     */     //   2065: dup
/*     */     //   2066: ifnonnull -> 2072
/*     */     //   2069: invokestatic throwNpe : ()V
/*     */     //   2072: invokeinterface getFormattedText : ()Ljava/lang/String;
/*     */     //   2077: fload #15
/*     */     //   2079: fload #17
/*     */     //   2081: fload #15
/*     */     //   2083: fsub
/*     */     //   2084: fconst_2
/*     */     //   2085: fdiv
/*     */     //   2086: fadd
/*     */     //   2087: fload #16
/*     */     //   2089: ldc_w 12.0
/*     */     //   2092: fsub
/*     */     //   2093: iconst_m1
/*     */     //   2094: invokeinterface drawCenteredString : (Ljava/lang/String;FFI)I
/*     */     //   2099: pop
/*     */     //   2100: sipush #3553
/*     */     //   2103: invokestatic glDisable : (I)V
/*     */     //   2106: sipush #2929
/*     */     //   2109: invokestatic glDisable : (I)V
/*     */     //   2112: goto -> 2429
/*     */     //   2115: aload_2
/*     */     //   2116: ldc 'real2d'
/*     */     //   2118: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   2121: ifeq -> 2206
/*     */     //   2124: fload #15
/*     */     //   2126: iconst_1
/*     */     //   2127: i2f
/*     */     //   2128: fsub
/*     */     //   2129: fload #16
/*     */     //   2131: iconst_1
/*     */     //   2132: i2f
/*     */     //   2133: fsub
/*     */     //   2134: fload #15
/*     */     //   2136: fload #18
/*     */     //   2138: aload #9
/*     */     //   2140: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   2143: fload #17
/*     */     //   2145: fload #16
/*     */     //   2147: iconst_1
/*     */     //   2148: i2f
/*     */     //   2149: fsub
/*     */     //   2150: fload #17
/*     */     //   2152: iconst_1
/*     */     //   2153: i2f
/*     */     //   2154: fadd
/*     */     //   2155: fload #18
/*     */     //   2157: iconst_1
/*     */     //   2158: i2f
/*     */     //   2159: fadd
/*     */     //   2160: aload #9
/*     */     //   2162: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   2165: fload #15
/*     */     //   2167: iconst_1
/*     */     //   2168: i2f
/*     */     //   2169: fsub
/*     */     //   2170: fload #18
/*     */     //   2172: fload #17
/*     */     //   2174: fload #18
/*     */     //   2176: iconst_1
/*     */     //   2177: i2f
/*     */     //   2178: fadd
/*     */     //   2179: aload #9
/*     */     //   2181: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   2184: fload #15
/*     */     //   2186: iconst_1
/*     */     //   2187: i2f
/*     */     //   2188: fsub
/*     */     //   2189: fload #16
/*     */     //   2191: iconst_1
/*     */     //   2192: i2f
/*     */     //   2193: fsub
/*     */     //   2194: fload #17
/*     */     //   2196: fload #16
/*     */     //   2198: aload #9
/*     */     //   2200: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   2203: goto -> 2429
/*     */     //   2206: aload_2
/*     */     //   2207: ldc 'csgo-old'
/*     */     //   2209: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   2212: ifeq -> 2429
/*     */     //   2215: aload_0
/*     */     //   2216: getfield csgoWidthValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   2219: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2222: checkcast java/lang/Number
/*     */     //   2225: invokevirtual floatValue : ()F
/*     */     //   2228: fload #18
/*     */     //   2230: fload #16
/*     */     //   2232: fsub
/*     */     //   2233: bipush #50
/*     */     //   2235: i2f
/*     */     //   2236: fdiv
/*     */     //   2237: fmul
/*     */     //   2238: fstore #19
/*     */     //   2240: fload #15
/*     */     //   2242: fload #19
/*     */     //   2244: fsub
/*     */     //   2245: fload #16
/*     */     //   2247: fload #19
/*     */     //   2249: fsub
/*     */     //   2250: fload #15
/*     */     //   2252: fload #18
/*     */     //   2254: aload #9
/*     */     //   2256: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   2259: fload #17
/*     */     //   2261: fload #16
/*     */     //   2263: fload #19
/*     */     //   2265: fsub
/*     */     //   2266: fload #17
/*     */     //   2268: fload #19
/*     */     //   2270: fadd
/*     */     //   2271: fload #18
/*     */     //   2273: fload #19
/*     */     //   2275: fadd
/*     */     //   2276: aload #9
/*     */     //   2278: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   2281: fload #15
/*     */     //   2283: fload #19
/*     */     //   2285: fsub
/*     */     //   2286: fload #18
/*     */     //   2288: fload #17
/*     */     //   2290: fload #18
/*     */     //   2292: fload #19
/*     */     //   2294: fadd
/*     */     //   2295: aload #9
/*     */     //   2297: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   2300: fload #15
/*     */     //   2302: fload #19
/*     */     //   2304: fsub
/*     */     //   2305: fload #16
/*     */     //   2307: fload #19
/*     */     //   2309: fsub
/*     */     //   2310: fload #17
/*     */     //   2312: fload #16
/*     */     //   2314: aload #9
/*     */     //   2316: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   2319: fload #18
/*     */     //   2321: fload #19
/*     */     //   2323: fadd
/*     */     //   2324: fload #16
/*     */     //   2326: fsub
/*     */     //   2327: aload #8
/*     */     //   2329: invokeinterface getHealth : ()F
/*     */     //   2334: aload #8
/*     */     //   2336: invokeinterface getMaxHealth : ()F
/*     */     //   2341: fdiv
/*     */     //   2342: fmul
/*     */     //   2343: fstore #20
/*     */     //   2345: fload #15
/*     */     //   2347: fload #19
/*     */     //   2349: iconst_3
/*     */     //   2350: i2f
/*     */     //   2351: fmul
/*     */     //   2352: fsub
/*     */     //   2353: fload #16
/*     */     //   2355: fload #19
/*     */     //   2357: fsub
/*     */     //   2358: fload #15
/*     */     //   2360: fload #19
/*     */     //   2362: iconst_2
/*     */     //   2363: i2f
/*     */     //   2364: fmul
/*     */     //   2365: fsub
/*     */     //   2366: fload #18
/*     */     //   2368: fload #19
/*     */     //   2370: fadd
/*     */     //   2371: getstatic java/awt/Color.GRAY : Ljava/awt/Color;
/*     */     //   2374: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   2377: fload #15
/*     */     //   2379: fload #19
/*     */     //   2381: iconst_3
/*     */     //   2382: i2f
/*     */     //   2383: fmul
/*     */     //   2384: fsub
/*     */     //   2385: fload #18
/*     */     //   2387: fload #20
/*     */     //   2389: fsub
/*     */     //   2390: fload #15
/*     */     //   2392: fload #19
/*     */     //   2394: iconst_2
/*     */     //   2395: i2f
/*     */     //   2396: fmul
/*     */     //   2397: fsub
/*     */     //   2398: fload #18
/*     */     //   2400: fload #19
/*     */     //   2402: fadd
/*     */     //   2403: getstatic net/ccbluex/liquidbounce/utils/render/ColorUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/render/ColorUtils;
/*     */     //   2406: aload #8
/*     */     //   2408: invokeinterface getHealth : ()F
/*     */     //   2413: aload #8
/*     */     //   2415: invokeinterface getMaxHealth : ()F
/*     */     //   2420: iconst_0
/*     */     //   2421: iconst_4
/*     */     //   2422: aconst_null
/*     */     //   2423: invokestatic healthColor$default : (Lnet/ccbluex/liquidbounce/utils/render/ColorUtils;FFIILjava/lang/Object;)Ljava/awt/Color;
/*     */     //   2426: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   2429: goto -> 227
/*     */     //   2432: iload #5
/*     */     //   2434: ifeq -> 2464
/*     */     //   2437: sipush #2929
/*     */     //   2440: invokestatic glEnable : (I)V
/*     */     //   2443: sipush #5889
/*     */     //   2446: invokestatic glMatrixMode : (I)V
/*     */     //   2449: invokestatic glPopMatrix : ()V
/*     */     //   2452: sipush #5888
/*     */     //   2455: invokestatic glMatrixMode : (I)V
/*     */     //   2458: invokestatic glPopMatrix : ()V
/*     */     //   2461: invokestatic glPopAttrib : ()V
/*     */     //   2464: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #62	-> 6
/*     */     //   #62	-> 44
/*     */     //   #63	-> 45
/*     */     //   #64	-> 52
/*     */     //   #66	-> 60
/*     */     //   #67	-> 94
/*     */     //   #68	-> 99
/*     */     //   #69	-> 105
/*     */     //   #70	-> 111
/*     */     //   #71	-> 117
/*     */     //   #72	-> 123
/*     */     //   #73	-> 129
/*     */     //   #74	-> 132
/*     */     //   #75	-> 135
/*     */     //   #76	-> 162
/*     */     //   #77	-> 168
/*     */     //   #78	-> 171
/*     */     //   #79	-> 174
/*     */     //   #80	-> 180
/*     */     //   #81	-> 189
/*     */     //   #82	-> 192
/*     */     //   #83	-> 196
/*     */     //   #86	-> 200
/*     */     //   #87	-> 249
/*     */     //   #88	-> 258
/*     */     //   #89	-> 267
/*     */     //   #90	-> 278
/*     */     //   #102	-> 360
/*     */     //   #104	-> 373
/*     */     //   #116	-> 386
/*     */     //   #91	-> 425
/*     */     //   #98	-> 451
/*     */     //   #91	-> 464
/*     */     //   #92	-> 464
/*     */     //   #93	-> 466
/*     */     //   #94	-> 468
/*     */     //   #95	-> 476
/*     */     //   #96	-> 477
/*     */     //   #91	-> 490
/*     */     //   #99	-> 496
/*     */     //   #102	-> 503
/*     */     //   #105	-> 528
/*     */     //   #106	-> 538
/*     */     //   #107	-> 548
/*     */     //   #108	-> 548
/*     */     //   #107	-> 588
/*     */     //   #109	-> 590
/*     */     //   #110	-> 590
/*     */     //   #109	-> 630
/*     */     //   #111	-> 632
/*     */     //   #112	-> 632
/*     */     //   #111	-> 672
/*     */     //   #113	-> 674
/*     */     //   #117	-> 706
/*     */     //   #118	-> 716
/*     */     //   #119	-> 726
/*     */     //   #126	-> 726
/*     */     //   #119	-> 726
/*     */     //   #121	-> 726
/*     */     //   #119	-> 726
/*     */     //   #120	-> 726
/*     */     //   #119	-> 726
/*     */     //   #120	-> 733
/*     */     //   #122	-> 762
/*     */     //   #123	-> 794
/*     */     //   #124	-> 826
/*     */     //   #121	-> 858
/*     */     //   #126	-> 863
/*     */     //   #119	-> 892
/*     */     //   #127	-> 894
/*     */     //   #128	-> 900
/*     */     //   #129	-> 936
/*     */     //   #130	-> 972
/*     */     //   #131	-> 1008
/*     */     //   #132	-> 1044
/*     */     //   #133	-> 1080
/*     */     //   #134	-> 1116
/*     */     //   #135	-> 1153
/*     */     //   #127	-> 1189
/*     */     //   #137	-> 1194
/*     */     //   #138	-> 1205
/*     */     //   #139	-> 1216
/*     */     //   #140	-> 1219
/*     */     //   #141	-> 1222
/*     */     //   #142	-> 1248
/*     */     //   #143	-> 1248
/*     */     //   #144	-> 1252
/*     */     //   #143	-> 1267
/*     */     //   #145	-> 1270
/*     */     //   #142	-> 1289
/*     */     //   #146	-> 1300
/*     */     //   #142	-> 1303
/*     */     //   #147	-> 1305
/*     */     //   #148	-> 1317
/*     */     //   #149	-> 1329
/*     */     //   #150	-> 1341
/*     */     //   #141	-> 1353
/*     */     //   #154	-> 1359
/*     */     //   #155	-> 1403
/*     */     //   #156	-> 1412
/*     */     //   #157	-> 1417
/*     */     //   #158	-> 1433
/*     */     //   #159	-> 1444
/*     */     //   #160	-> 1455
/*     */     //   #161	-> 1459
/*     */     //   #162	-> 1469
/*     */     //   #163	-> 1476
/*     */     //   #164	-> 1486
/*     */     //   #165	-> 1489
/*     */     //   #166	-> 1493
/*     */     //   #167	-> 1503
/*     */     //   #168	-> 1510
/*     */     //   #169	-> 1520
/*     */     //   #170	-> 1523
/*     */     //   #171	-> 1527
/*     */     //   #172	-> 1537
/*     */     //   #173	-> 1544
/*     */     //   #174	-> 1554
/*     */     //   #175	-> 1557
/*     */     //   #176	-> 1561
/*     */     //   #177	-> 1571
/*     */     //   #178	-> 1578
/*     */     //   #179	-> 1588
/*     */     //   #181	-> 1594
/*     */     //   #182	-> 1598
/*     */     //   #183	-> 1605
/*     */     //   #184	-> 1612
/*     */     //   #185	-> 1619
/*     */     //   #186	-> 1626
/*     */     //   #187	-> 1629
/*     */     //   #188	-> 1629
/*     */     //   #189	-> 1645
/*     */     //   #190	-> 1645
/*     */     //   #189	-> 1668
/*     */     //   #191	-> 1670
/*     */     //   #192	-> 1681
/*     */     //   #193	-> 1686
/*     */     //   #194	-> 1698
/*     */     //   #195	-> 1707
/*     */     //   #196	-> 1718
/*     */     //   #197	-> 1732
/*     */     //   #198	-> 1735
/*     */     //   #199	-> 1742
/*     */     //   #200	-> 1748
/*     */     //   #201	-> 1754
/*     */     //   #202	-> 1762
/*     */     //   #203	-> 1798
/*     */     //   #204	-> 1804
/*     */     //   #205	-> 1809
/*     */     //   #206	-> 1835
/*     */     //   #201	-> 1836
/*     */     //   #208	-> 1842
/*     */     //   #209	-> 1848
/*     */     //   #210	-> 1854
/*     */     //   #212	-> 1861
/*     */     //   #213	-> 1890
/*     */     //   #214	-> 1919
/*     */     //   #215	-> 1925
/*     */     //   #216	-> 1931
/*     */     //   #217	-> 1944
/*     */     //   #218	-> 1952
/*     */     //   #219	-> 1976
/*     */     //   #220	-> 1986
/*     */     //   #221	-> 1990
/*     */     //   #217	-> 1991
/*     */     //   #224	-> 1997
/*     */     //   #225	-> 2003
/*     */     //   #228	-> 2009
/*     */     //   #229	-> 2025
/*     */     //   #230	-> 2031
/*     */     //   #231	-> 2037
/*     */     //   #232	-> 2050
/*     */     //   #233	-> 2058
/*     */     //   #234	-> 2077
/*     */     //   #235	-> 2087
/*     */     //   #236	-> 2093
/*     */     //   #232	-> 2094
/*     */     //   #239	-> 2100
/*     */     //   #240	-> 2106
/*     */     //   #242	-> 2115
/*     */     //   #243	-> 2124
/*     */     //   #244	-> 2143
/*     */     //   #245	-> 2165
/*     */     //   #246	-> 2184
/*     */     //   #247	-> 2206
/*     */     //   #248	-> 2215
/*     */     //   #249	-> 2240
/*     */     //   #250	-> 2259
/*     */     //   #251	-> 2281
/*     */     //   #252	-> 2300
/*     */     //   #254	-> 2319
/*     */     //   #255	-> 2345
/*     */     //   #256	-> 2345
/*     */     //   #257	-> 2353
/*     */     //   #258	-> 2358
/*     */     //   #259	-> 2366
/*     */     //   #260	-> 2371
/*     */     //   #255	-> 2374
/*     */     //   #262	-> 2377
/*     */     //   #263	-> 2377
/*     */     //   #264	-> 2385
/*     */     //   #265	-> 2390
/*     */     //   #266	-> 2398
/*     */     //   #267	-> 2403
/*     */     //   #262	-> 2426
/*     */     //   #269	-> 2429
/*     */     //   #272	-> 2429
/*     */     //   #86	-> 2429
/*     */     //   #276	-> 2432
/*     */     //   #277	-> 2437
/*     */     //   #278	-> 2443
/*     */     //   #279	-> 2449
/*     */     //   #280	-> 2452
/*     */     //   #281	-> 2458
/*     */     //   #282	-> 2461
/*     */     //   #284	-> 2464
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   674	29	17	posZ	D
/*     */     //   632	71	15	posY	D
/*     */     //   590	113	13	posX	D
/*     */     //   548	155	12	timer	Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   538	165	11	renderManager	Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   1305	48	23	screenPos	Lorg/lwjgl/util/vector/Vector2f;
/*     */     //   1248	108	19	boxVertex	[D
/*     */     //   1455	136	20	distY	F
/*     */     //   1444	147	19	distX	F
/*     */     //   1670	191	19	barHeight	F
/*     */     //   2345	84	20	hpSize	F
/*     */     //   2240	189	19	width	F
/*     */     //   1222	1207	18	maxY	F
/*     */     //   1219	1210	17	maxX	F
/*     */     //   1216	1213	16	minY	F
/*     */     //   1205	1224	15	minX	F
/*     */     //   1194	1235	14	boxVertices	[[D
/*     */     //   894	1535	13	bb	Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   726	1703	12	timer	Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   716	1713	11	renderManager	Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   278	2151	9	color	Ljava/awt/Color;
/*     */     //   267	2162	8	entityLiving	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   249	2180	6	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   94	2371	5	need2dTranslate	Z
/*     */     //   60	2405	4	projectionMatrix	Lorg/lwjgl/util/vector/Matrix4f;
/*     */     //   52	2413	3	mvMatrix	Lorg/lwjgl/util/vector/Matrix4f;
/*     */     //   45	2420	2	mode	Ljava/lang/String;
/*     */     //   0	2465	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/render/ESP;
/*     */     //   0	2465	1	event	Lnet/ccbluex/liquidbounce/event/Render3DEvent;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isValid(@NotNull IEntityLivingBase entity) {
/* 287 */     Intrinsics.checkParameterIsNotNull(entity, "entity"); return (entity != MinecraftInstance.mc.getThePlayer() && entity.getHealth() > 0.0F && entity instanceof net.minecraft.entity.player.EntityPlayer && !AntiBot.isBot(
/* 288 */         entity));
/*     */   }
/*     */   
/*     */   public final void doWireFrame() {
/* 292 */     Matrix4f mvMatrix = WorldToScreen.getMatrix(2982);
/* 293 */     Matrix4f projectionMatrix = WorldToScreen.getMatrix(2983);
/* 294 */     if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  for (IEntityPlayer entity : MinecraftInstance.mc.getTheWorld().getPlayerEntities()) {
/* 295 */       if (entity.asEntityLivingBase().isInvisible() && !((Boolean)this.invisible.getValue()).booleanValue()) {
/*     */         return;
/*     */       }
/* 298 */       if (isValid((IEntityLivingBase)entity)) {
/* 299 */         GL11.glPushAttrib(8192);
/* 300 */         GL11.glEnable(3042);
/* 301 */         GL11.glDisable(3553);
/* 302 */         GL11.glDisable(2929);
/* 303 */         GL11.glMatrixMode(5889);
/* 304 */         GL11.glPushMatrix();
/* 305 */         GL11.glLoadIdentity();
/* 306 */         GL11.glOrtho(0.0D, MinecraftInstance.mc.getDisplayWidth(), MinecraftInstance.mc.getDisplayHeight(), 0.0D, -1.0D, 1.0D);
/* 307 */         GL11.glMatrixMode(5888);
/* 308 */         GL11.glPushMatrix();
/* 309 */         GL11.glLoadIdentity();
/* 310 */         GL11.glDisable(2929);
/* 311 */         GL11.glBlendFunc(770, 771);
/* 312 */         GlStateManager.func_179098_w();
/* 313 */         GL11.glDepthMask(true);
/* 314 */         GL11.glLineWidth(2.0F);
/*     */         
/* 316 */         IRenderManager renderManager = MinecraftInstance.mc.getRenderManager();
/* 317 */         ITimer timer = MinecraftInstance.mc.getTimer();
/* 318 */         IAxisAlignedBB bb = entity.getEntityBoundingBox()
/* 319 */           .offset(-entity.getPosX(), -entity.getPosY(), -entity.getPosZ())
/* 320 */           .offset(
/* 321 */             entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * timer.getRenderPartialTicks(), 
/* 322 */             entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * timer.getRenderPartialTicks(), 
/* 323 */             entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * timer.getRenderPartialTicks())
/*     */           
/* 325 */           .offset(-MinecraftInstance.mc.getRenderManager().getRenderPosX(), -MinecraftInstance.mc.getRenderManager().getRenderPosY(), -MinecraftInstance.mc.getRenderManager().getRenderPosZ());
/* 326 */         double[][] boxVertices = {
/* 327 */             { bb.getMinX(), bb.getMinY(), bb.getMinZ()
/* 328 */             }, { bb.getMinX(), bb.getMaxY(), bb.getMinZ()
/* 329 */             }, { bb.getMaxX(), bb.getMaxY(), bb.getMinZ()
/* 330 */             }, { bb.getMaxX(), bb.getMinY(), bb.getMinZ()
/* 331 */             }, { bb.getMinX(), bb.getMinY(), bb.getMaxZ()
/* 332 */             }, { bb.getMinX(), bb.getMaxY(), bb.getMaxZ()
/* 333 */             }, { bb.getMaxX(), bb.getMaxY(), bb.getMaxZ()
/* 334 */             }, { bb.getMaxX(), bb.getMinY(), bb.getMaxZ() }
/*     */           };
/* 336 */         float minX = FloatCompanionObject.INSTANCE.getMAX_VALUE();
/* 337 */         float minY = FloatCompanionObject.INSTANCE.getMAX_VALUE();
/* 338 */         float maxX = -1.0F;
/* 339 */         float maxY = -1.0F;
/* 340 */         for (double[] boxVertex : boxVertices) {
/* 341 */           if (WorldToScreen.worldToScreen(
/* 342 */               new Vector3f(
/* 343 */                 (float)boxVertex[0], 
/* 344 */                 (float)boxVertex[1], 
/* 345 */                 (float)boxVertex[2]), 
/* 346 */               mvMatrix, projectionMatrix, MinecraftInstance.mc.getDisplayWidth(), MinecraftInstance.mc.getDisplayHeight()) != null) { Vector2f screenPos = WorldToScreen.worldToScreen(new Vector3f((float)boxVertex[0], (float)boxVertex[1], (float)boxVertex[2]), mvMatrix, projectionMatrix, MinecraftInstance.mc.getDisplayWidth(), MinecraftInstance.mc.getDisplayHeight());
/*     */ 
/*     */             
/* 349 */             minX = Math.min(screenPos.x, minX);
/* 350 */             minY = Math.min(screenPos.y, minY);
/* 351 */             maxX = Math.max(screenPos.x, maxX);
/* 352 */             maxY = Math.max(screenPos.y, maxY); } else { WorldToScreen.worldToScreen(new Vector3f((float)boxVertex[0], (float)boxVertex[1], (float)boxVertex[2]), mvMatrix, projectionMatrix, MinecraftInstance.mc.getDisplayWidth(), MinecraftInstance.mc.getDisplayHeight()); }
/*     */         
/* 354 */         }  if (Retreat.INSTANCE.getModuleManager().get(Teams.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.misc.Teams");  Teams teams = (Teams)Retreat.INSTANCE.getModuleManager().get(Teams.class);
/* 355 */         if (minX > false || minY > false || maxX <= MinecraftInstance.mc.getDisplayWidth() || maxY <= MinecraftInstance.mc.getDisplayWidth()) {
/* 356 */           if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  Color espColor = ((entity.getTotalArmorValue2() * 1) + entity.getHealth() * 2 > MinecraftInstance.mc.getThePlayer().getTotalArmorValue2() + MinecraftInstance.mc.getThePlayer().getHealth() * 2) ? new Color(255, 0, 0) : new Color(255, 255, 255);
/* 357 */           if (teams.isInYourTeam((IEntityLivingBase)entity))
/* 358 */             espColor = new Color(50, 255, 50); 
/* 359 */           RenderUtils.color((entity.getHurtTime() == 0) ? espColor.getRGB() : (new Color(255, 0, 0)).getRGB());
/* 360 */           GL11.glBegin(2);
/* 361 */           GL11.glVertex2f(minX, minY);
/* 362 */           GL11.glVertex2f(minX, maxY);
/* 363 */           GL11.glVertex2f(maxX, maxY);
/* 364 */           GL11.glVertex2f(maxX, minY);
/* 365 */           GL11.glEnd();
/*     */         } 
/* 367 */         GL11.glEnable(2929);
/* 368 */         GL11.glMatrixMode(5889);
/* 369 */         GL11.glPopMatrix();
/* 370 */         GL11.glMatrixMode(5888);
/* 371 */         GL11.glPopMatrix();
/* 372 */         GL11.glPopAttrib();
/*     */       } 
/*     */     } 
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
/*     */   @EventTarget
/*     */   public final void onRender2D(@NotNull Render2DEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: aload_0
/*     */     //   7: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   10: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   13: checkcast java/lang/String
/*     */     //   16: astore_3
/*     */     //   17: iconst_0
/*     */     //   18: istore #4
/*     */     //   20: aload_3
/*     */     //   21: dup
/*     */     //   22: ifnonnull -> 35
/*     */     //   25: new kotlin/TypeCastException
/*     */     //   28: dup
/*     */     //   29: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   31: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   34: athrow
/*     */     //   35: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   38: dup
/*     */     //   39: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   41: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   44: astore_2
/*     */     //   45: aload_1
/*     */     //   46: invokevirtual getPartialTicks : ()F
/*     */     //   49: fstore_3
/*     */     //   50: aload_2
/*     */     //   51: ldc_w 'jello'
/*     */     //   54: iconst_1
/*     */     //   55: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   58: ifeq -> 416
/*     */     //   61: new java/util/ArrayList
/*     */     //   64: dup
/*     */     //   65: invokespecial <init> : ()V
/*     */     //   68: astore #4
/*     */     //   70: getstatic net/ccbluex/liquidbounce/utils/render/shader/shaders/GlowShader.GLOW_SHADER : Lnet/ccbluex/liquidbounce/utils/render/shader/shaders/GlowShader;
/*     */     //   73: dup
/*     */     //   74: ldc_w 'GlowShader.GLOW_SHADER'
/*     */     //   77: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   80: checkcast net/ccbluex/liquidbounce/utils/render/shader/FramebufferShader
/*     */     //   83: astore #5
/*     */     //   85: ldc_w 3.0
/*     */     //   88: fstore #6
/*     */     //   90: new java/awt/Color
/*     */     //   93: dup
/*     */     //   94: bipush #120
/*     */     //   96: bipush #120
/*     */     //   98: bipush #120
/*     */     //   100: invokespecial <init> : (III)V
/*     */     //   103: astore #7
/*     */     //   105: new java/awt/Color
/*     */     //   108: dup
/*     */     //   109: bipush #120
/*     */     //   111: iconst_0
/*     */     //   112: iconst_0
/*     */     //   113: invokespecial <init> : (III)V
/*     */     //   116: astore #8
/*     */     //   118: iconst_1
/*     */     //   119: istore #9
/*     */     //   121: iconst_0
/*     */     //   122: istore #10
/*     */     //   124: iconst_1
/*     */     //   125: istore #11
/*     */     //   127: iload #10
/*     */     //   129: iload #11
/*     */     //   131: if_icmpgt -> 415
/*     */     //   134: aload #5
/*     */     //   136: fload_3
/*     */     //   137: invokevirtual startDraw : (F)V
/*     */     //   140: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   143: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   148: dup
/*     */     //   149: ifnonnull -> 155
/*     */     //   152: invokestatic throwNpe : ()V
/*     */     //   155: invokeinterface getLoadedEntityList : ()Ljava/util/Collection;
/*     */     //   160: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   165: astore #13
/*     */     //   167: aload #13
/*     */     //   169: invokeinterface hasNext : ()Z
/*     */     //   174: ifeq -> 254
/*     */     //   177: aload #13
/*     */     //   179: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   184: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   187: astore #12
/*     */     //   189: aload #12
/*     */     //   191: iconst_0
/*     */     //   192: invokestatic isSelected : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Z)Z
/*     */     //   195: ifeq -> 251
/*     */     //   198: aload #12
/*     */     //   200: invokeinterface asEntityLivingBase : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   205: astore #14
/*     */     //   207: iload #9
/*     */     //   209: ifeq -> 233
/*     */     //   212: aload #14
/*     */     //   214: invokeinterface getHurtTime : ()I
/*     */     //   219: ifle -> 233
/*     */     //   222: aload #4
/*     */     //   224: aload #14
/*     */     //   226: invokevirtual add : (Ljava/lang/Object;)Z
/*     */     //   229: pop
/*     */     //   230: goto -> 251
/*     */     //   233: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   236: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   241: aload #12
/*     */     //   243: fload_3
/*     */     //   244: iconst_1
/*     */     //   245: invokeinterface renderEntityStatic : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;FZ)Z
/*     */     //   250: pop
/*     */     //   251: goto -> 167
/*     */     //   254: aload #5
/*     */     //   256: aload #7
/*     */     //   258: fload #6
/*     */     //   260: fconst_1
/*     */     //   261: invokevirtual stopDraw : (Ljava/awt/Color;FF)V
/*     */     //   264: aload #4
/*     */     //   266: invokevirtual size : ()I
/*     */     //   269: ifle -> 348
/*     */     //   272: aload #5
/*     */     //   274: fload_3
/*     */     //   275: invokevirtual startDraw : (F)V
/*     */     //   278: aload #4
/*     */     //   280: invokevirtual iterator : ()Ljava/util/Iterator;
/*     */     //   283: astore #13
/*     */     //   285: aload #13
/*     */     //   287: invokeinterface hasNext : ()Z
/*     */     //   292: ifeq -> 338
/*     */     //   295: aload #13
/*     */     //   297: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   302: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*     */     //   305: astore #12
/*     */     //   307: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   310: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   315: aload #12
/*     */     //   317: dup
/*     */     //   318: ldc_w 'entity'
/*     */     //   321: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   324: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   327: fload_3
/*     */     //   328: iconst_1
/*     */     //   329: invokeinterface renderEntityStatic : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;FZ)Z
/*     */     //   334: pop
/*     */     //   335: goto -> 285
/*     */     //   338: aload #5
/*     */     //   340: aload #8
/*     */     //   342: fload #6
/*     */     //   344: fconst_1
/*     */     //   345: invokevirtual stopDraw : (Ljava/awt/Color;FF)V
/*     */     //   348: getstatic net/ccbluex/liquidbounce/utils/render/shader/shaders/OutlineShader.OUTLINE_SHADER : Lnet/ccbluex/liquidbounce/utils/render/shader/shaders/OutlineShader;
/*     */     //   351: dup
/*     */     //   352: ldc_w 'OutlineShader.OUTLINE_SHADER'
/*     */     //   355: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   358: checkcast net/ccbluex/liquidbounce/utils/render/shader/FramebufferShader
/*     */     //   361: astore #5
/*     */     //   363: ldc_w 1.2
/*     */     //   366: fstore #6
/*     */     //   368: new java/awt/Color
/*     */     //   371: dup
/*     */     //   372: sipush #255
/*     */     //   375: sipush #255
/*     */     //   378: sipush #255
/*     */     //   381: sipush #170
/*     */     //   384: invokespecial <init> : (IIII)V
/*     */     //   387: astore #7
/*     */     //   389: new java/awt/Color
/*     */     //   392: dup
/*     */     //   393: sipush #255
/*     */     //   396: iconst_0
/*     */     //   397: iconst_0
/*     */     //   398: sipush #170
/*     */     //   401: invokespecial <init> : (IIII)V
/*     */     //   404: astore #8
/*     */     //   406: iconst_0
/*     */     //   407: istore #9
/*     */     //   409: iinc #10, 1
/*     */     //   412: goto -> 127
/*     */     //   415: return
/*     */     //   416: aload_2
/*     */     //   417: astore #5
/*     */     //   419: aload #5
/*     */     //   421: invokevirtual hashCode : ()I
/*     */     //   424: lookupswitch default -> 498, -1682647875 -> 452, -1310952718 -> 466
/*     */     //   452: aload #5
/*     */     //   454: ldc_w 'shaderoutline'
/*     */     //   457: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   460: ifeq -> 498
/*     */     //   463: goto -> 480
/*     */     //   466: aload #5
/*     */     //   468: ldc_w 'shaderglow'
/*     */     //   471: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   474: ifeq -> 498
/*     */     //   477: goto -> 489
/*     */     //   480: getstatic net/ccbluex/liquidbounce/utils/render/shader/shaders/OutlineShader.OUTLINE_SHADER : Lnet/ccbluex/liquidbounce/utils/render/shader/shaders/OutlineShader;
/*     */     //   483: checkcast net/ccbluex/liquidbounce/utils/render/shader/FramebufferShader
/*     */     //   486: goto -> 499
/*     */     //   489: getstatic net/ccbluex/liquidbounce/utils/render/shader/shaders/GlowShader.GLOW_SHADER : Lnet/ccbluex/liquidbounce/utils/render/shader/shaders/GlowShader;
/*     */     //   492: checkcast net/ccbluex/liquidbounce/utils/render/shader/FramebufferShader
/*     */     //   495: goto -> 499
/*     */     //   498: return
/*     */     //   499: astore #4
/*     */     //   501: aload_2
/*     */     //   502: astore #6
/*     */     //   504: aload #6
/*     */     //   506: invokevirtual hashCode : ()I
/*     */     //   509: lookupswitch default -> 596, -1682647875 -> 536, -1310952718 -> 550
/*     */     //   536: aload #6
/*     */     //   538: ldc_w 'shaderoutline'
/*     */     //   541: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   544: ifeq -> 596
/*     */     //   547: goto -> 564
/*     */     //   550: aload #6
/*     */     //   552: ldc_w 'shaderglow'
/*     */     //   555: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   558: ifeq -> 596
/*     */     //   561: goto -> 580
/*     */     //   564: aload_0
/*     */     //   565: getfield shaderOutlineRadiusValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   568: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   571: checkcast java/lang/Number
/*     */     //   574: invokevirtual floatValue : ()F
/*     */     //   577: goto -> 597
/*     */     //   580: aload_0
/*     */     //   581: getfield shaderGlowRadiusValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   584: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   587: checkcast java/lang/Number
/*     */     //   590: invokevirtual floatValue : ()F
/*     */     //   593: goto -> 597
/*     */     //   596: fconst_1
/*     */     //   597: fstore #5
/*     */     //   599: new java/util/HashMap
/*     */     //   602: dup
/*     */     //   603: invokespecial <init> : ()V
/*     */     //   606: checkcast java/util/Map
/*     */     //   609: astore #6
/*     */     //   611: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   614: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   619: dup
/*     */     //   620: ifnonnull -> 626
/*     */     //   623: invokestatic throwNpe : ()V
/*     */     //   626: invokeinterface getLoadedEntityList : ()Ljava/util/Collection;
/*     */     //   631: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   636: astore #8
/*     */     //   638: aload #8
/*     */     //   640: invokeinterface hasNext : ()Z
/*     */     //   645: ifeq -> 746
/*     */     //   648: aload #8
/*     */     //   650: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   655: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   658: astore #7
/*     */     //   660: aload #7
/*     */     //   662: iconst_0
/*     */     //   663: invokestatic isSelected : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Z)Z
/*     */     //   666: ifeq -> 743
/*     */     //   669: aload #7
/*     */     //   671: invokeinterface asEntityLivingBase : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   676: astore #9
/*     */     //   678: aload_0
/*     */     //   679: aload #9
/*     */     //   681: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   684: invokevirtual getColor : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)Ljava/awt/Color;
/*     */     //   687: astore #10
/*     */     //   689: aload #6
/*     */     //   691: aload #10
/*     */     //   693: invokeinterface containsKey : (Ljava/lang/Object;)Z
/*     */     //   698: ifne -> 718
/*     */     //   701: aload #6
/*     */     //   703: aload #10
/*     */     //   705: new java/util/ArrayList
/*     */     //   708: dup
/*     */     //   709: invokespecial <init> : ()V
/*     */     //   712: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   717: pop
/*     */     //   718: aload #6
/*     */     //   720: aload #10
/*     */     //   722: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   727: dup
/*     */     //   728: ifnonnull -> 734
/*     */     //   731: invokestatic throwNpe : ()V
/*     */     //   734: checkcast java/util/ArrayList
/*     */     //   737: aload #9
/*     */     //   739: invokevirtual add : (Ljava/lang/Object;)Z
/*     */     //   742: pop
/*     */     //   743: goto -> 638
/*     */     //   746: aload #6
/*     */     //   748: astore #9
/*     */     //   750: iconst_0
/*     */     //   751: istore #10
/*     */     //   753: aload #9
/*     */     //   755: invokeinterface entrySet : ()Ljava/util/Set;
/*     */     //   760: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   765: astore #8
/*     */     //   767: aload #8
/*     */     //   769: invokeinterface hasNext : ()Z
/*     */     //   774: ifeq -> 906
/*     */     //   777: aload #8
/*     */     //   779: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   784: checkcast java/util/Map$Entry
/*     */     //   787: astore #7
/*     */     //   789: aload #7
/*     */     //   791: astore #11
/*     */     //   793: iconst_0
/*     */     //   794: istore #12
/*     */     //   796: aload #11
/*     */     //   798: invokeinterface getKey : ()Ljava/lang/Object;
/*     */     //   803: checkcast java/awt/Color
/*     */     //   806: astore #9
/*     */     //   808: aload #7
/*     */     //   810: astore #11
/*     */     //   812: iconst_0
/*     */     //   813: istore #12
/*     */     //   815: aload #11
/*     */     //   817: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   822: checkcast java/util/ArrayList
/*     */     //   825: astore #10
/*     */     //   827: aload #4
/*     */     //   829: fload_3
/*     */     //   830: invokevirtual startDraw : (F)V
/*     */     //   833: aload #10
/*     */     //   835: invokevirtual iterator : ()Ljava/util/Iterator;
/*     */     //   838: astore #12
/*     */     //   840: aload #12
/*     */     //   842: invokeinterface hasNext : ()Z
/*     */     //   847: ifeq -> 893
/*     */     //   850: aload #12
/*     */     //   852: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   857: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*     */     //   860: astore #11
/*     */     //   862: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   865: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   870: aload #11
/*     */     //   872: dup
/*     */     //   873: ldc_w 'entity'
/*     */     //   876: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   879: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   882: fload_3
/*     */     //   883: iconst_1
/*     */     //   884: invokeinterface renderEntityStatic : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;FZ)Z
/*     */     //   889: pop
/*     */     //   890: goto -> 840
/*     */     //   893: aload #4
/*     */     //   895: aload #9
/*     */     //   897: fload #5
/*     */     //   899: fconst_1
/*     */     //   900: invokevirtual stopDraw : (Ljava/awt/Color;FF)V
/*     */     //   903: goto -> 767
/*     */     //   906: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #378	-> 6
/*     */     //   #378	-> 44
/*     */     //   #379	-> 45
/*     */     //   #381	-> 50
/*     */     //   #382	-> 61
/*     */     //   #383	-> 70
/*     */     //   #384	-> 85
/*     */     //   #385	-> 90
/*     */     //   #386	-> 105
/*     */     //   #387	-> 118
/*     */     //   #389	-> 121
/*     */     //   #390	-> 134
/*     */     //   #391	-> 140
/*     */     //   #392	-> 189
/*     */     //   #393	-> 198
/*     */     //   #394	-> 207
/*     */     //   #395	-> 222
/*     */     //   #396	-> 230
/*     */     //   #398	-> 233
/*     */     //   #391	-> 251
/*     */     //   #401	-> 254
/*     */     //   #404	-> 264
/*     */     //   #405	-> 272
/*     */     //   #406	-> 278
/*     */     //   #407	-> 307
/*     */     //   #406	-> 335
/*     */     //   #409	-> 338
/*     */     //   #411	-> 348
/*     */     //   #412	-> 363
/*     */     //   #413	-> 368
/*     */     //   #414	-> 389
/*     */     //   #415	-> 406
/*     */     //   #389	-> 409
/*     */     //   #417	-> 415
/*     */     //   #421	-> 416
/*     */     //   #422	-> 452
/*     */     //   #423	-> 466
/*     */     //   #422	-> 480
/*     */     //   #423	-> 489
/*     */     //   #424	-> 498
/*     */     //   #421	-> 499
/*     */     //   #426	-> 501
/*     */     //   #427	-> 536
/*     */     //   #428	-> 550
/*     */     //   #427	-> 564
/*     */     //   #428	-> 580
/*     */     //   #429	-> 596
/*     */     //   #426	-> 597
/*     */     //   #433	-> 599
/*     */     //   #434	-> 611
/*     */     //   #435	-> 660
/*     */     //   #436	-> 669
/*     */     //   #437	-> 678
/*     */     //   #438	-> 689
/*     */     //   #439	-> 701
/*     */     //   #441	-> 718
/*     */     //   #434	-> 743
/*     */     //   #446	-> 746
/*     */     //   #446	-> 803
/*     */     //   #446	-> 822
/*     */     //   #447	-> 827
/*     */     //   #448	-> 833
/*     */     //   #449	-> 862
/*     */     //   #448	-> 890
/*     */     //   #451	-> 893
/*     */     //   #446	-> 903
/*     */     //   #453	-> 906
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   207	44	14	entityLivingBase	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   189	62	12	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   307	28	12	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   134	278	10	i	I
/*     */     //   121	295	9	firstRun	Z
/*     */     //   118	298	8	hurtColor	Ljava/awt/Color;
/*     */     //   105	311	7	color	Ljava/awt/Color;
/*     */     //   90	326	6	radius	F
/*     */     //   85	331	5	shader	Lnet/ccbluex/liquidbounce/utils/render/shader/FramebufferShader;
/*     */     //   70	346	4	hurtingEntities	Ljava/util/ArrayList;
/*     */     //   689	54	10	color	Ljava/awt/Color;
/*     */     //   678	65	9	entityLiving	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   660	83	7	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   862	28	11	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   827	76	10	value	Ljava/util/ArrayList;
/*     */     //   827	76	9	key	Ljava/awt/Color;
/*     */     //   611	296	6	entityMap	Ljava/util/Map;
/*     */     //   599	308	5	radius	F
/*     */     //   501	406	4	shader	Lnet/ccbluex/liquidbounce/utils/render/shader/FramebufferShader;
/*     */     //   50	857	3	partialTicks	F
/*     */     //   45	862	2	mode	Ljava/lang/String;
/*     */     //   0	907	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/render/ESP;
/*     */     //   0	907	1	event	Lnet/ccbluex/liquidbounce/event/Render2DEvent;
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
/*     */   @NotNull
/*     */   public String getTag() {
/* 456 */     return (String)this.modeValue.get();
/*     */   } @NotNull
/*     */   public final Color getColor(@NotNull IEntity entity) {
/* 459 */     Intrinsics.checkParameterIsNotNull(entity, "entity"); if (MinecraftInstance.classProvider.isEntityLivingBase(entity)) {
/* 460 */       if (entity.asEntityLivingBase().getHurtTime() > 0) { Intrinsics.checkExpressionValueIsNotNull(Color.RED, "Color.RED"); return Color.RED; }
/* 461 */        if (EntityUtils.isFriend(entity)) { Intrinsics.checkExpressionValueIsNotNull(Color.BLUE, "Color.BLUE"); return Color.BLUE; }
/* 462 */        if (Intrinsics.areEqual(this.colorModeValue.get(), "Name")) {
/* 463 */         if (entity.getDisplayName() == null) Intrinsics.throwNpe();  String str = entity.getDisplayName().getFormattedText(); int i = 0; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toCharArray(), "(this as java.lang.String).toCharArray()"); char[] chars = str.toCharArray();
/* 464 */         for (byte b = 0; b < i; b++) {
/* 465 */           if (chars[b] == '§' && b + 1 < chars.length)
/* 466 */           { int index = GameFontRenderer.Companion.getColorIndex(chars[b + 1]);
/* 467 */             if (index >= 0 && index <= 15)
/* 468 */               return new Color(ColorUtils.hexColors[index]);  } 
/*     */         } 
/* 470 */       } else if (Intrinsics.areEqual(this.colorModeValue.get(), "Armor") && 
/* 471 */         entity instanceof IEntityPlayer) {
/* 472 */         if ((IItemStack)((IEntityPlayer)entity).getInventory().getArmorInventory().get(3) != null) { IItemStack entityHead = (IItemStack)((IEntityPlayer)entity).getInventory().getArmorInventory().get(3);
/* 473 */           if (MinecraftInstance.classProvider.isEntityPlayer(entityHead)) {
/* 474 */             if (entityHead.getItem() == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.api.minecraft.item.IItemArmor");  IItemArmor entityItemArmor = (IItemArmor)entityHead.getItem();
/* 475 */             return new Color(entityItemArmor.getColor(entityHead));
/*     */           }  }
/*     */         else { (IItemStack)((IEntityPlayer)entity).getInventory().getArmorInventory().get(3); return new Color(2147483647); }
/*     */       
/*     */       } 
/* 480 */     }  return ((Boolean)this.colorRainbowValue.get()).booleanValue() ? ColorUtils.rainbow() : new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\ESP.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */