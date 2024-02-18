/*     */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.JvmField;
/*     */ import kotlin.jvm.internal.DefaultConstructorMarker;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.Render2DEvent;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*     */ import net.ccbluex.liquidbounce.utils.EntityUtils;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.shader.FramebufferShader;
/*     */ import net.ccbluex.liquidbounce.utils.render.shader.shaders.GlowShader;
/*     */ import net.ccbluex.liquidbounce.utils.render.shader.shaders.OutlineShader;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @ModuleInfo(name = "ESP3", description = "Allows you to see targets through walls.", category = ModuleCategory.RENDER)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000J\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\016\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\b\007\030\000 \0332\0020\001:\001\033B\005¢\006\002\020\002J\020\020\021\032\0020\0222\b\020\023\032\004\030\0010\024J\020\020\025\032\0020\0262\006\020\027\032\0020\030H\007J\022\020\031\032\0020\0262\b\020\027\032\004\030\0010\032H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\020\020\006\032\0020\0078\006X\004¢\006\002\n\000R\020\020\b\032\0020\t8\006X\004¢\006\002\n\000R\016\020\n\032\0020\tX\004¢\006\002\n\000R\016\020\013\032\0020\tX\004¢\006\002\n\000R\024\020\f\032\0020\r8VX\004¢\006\006\032\004\b\016\020\017R\020\020\020\032\0020\t8\006X\004¢\006\002\n\000¨\006\034"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/ESP3;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "colorRainbow", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "colorTeam", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "outlineWidth", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "shaderGlowRadius", "shaderOutlineRadius", "tag", "", "getTag", "()Ljava/lang/String;", "wireframeWidth", "getColor", "Ljava/awt/Color;", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "onRender2D", "", "event", "Lnet/ccbluex/liquidbounce/event/Render2DEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "Companion", "XSJClient"})
/*     */ public final class ESP3
/*     */   extends Module {
/*     */   @JvmField
/*     */   @NotNull
/*  35 */   public final ListValue modeValue = new ListValue("Mode", new String[] { "Box", "OtherBox", "WireFrame", "2D", "Real2D", "Outline", "ShaderOutline", "ShaderGlow", "Sanyueqi" }, "\"yBox");
/*     */   @JvmField
/*     */   @NotNull
/*  38 */   public final FloatValue outlineWidth = new FloatValue("Outline-Width", 3.0F, 0.5F, 5.0F);
/*     */   @JvmField
/*     */   @NotNull
/*  41 */   public final FloatValue wireframeWidth = new FloatValue("WireFrame-Width", 2.0F, 0.5F, 5.0F);
/*  42 */   private final FloatValue shaderOutlineRadius = new FloatValue("ShaderOutline-Radius", 1.35F, 1.0F, 2.0F);
/*  43 */   private final FloatValue shaderGlowRadius = new FloatValue("ShaderGlow-Radius", 2.3F, 2.0F, 3.0F);
/*  44 */   private final BoolValue colorRainbow = new BoolValue("Rainbow", false);
/*  45 */   private final BoolValue colorTeam = new BoolValue("Team", false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @JvmField
/*     */   public static boolean renderNameTags;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public final void onRender3D(@Nullable Render3DEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   4: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   7: checkcast java/lang/String
/*     */     //   10: astore_2
/*     */     //   11: sipush #2982
/*     */     //   14: invokestatic getMatrix : (I)Lorg/lwjgl/util/vector/Matrix4f;
/*     */     //   17: astore_3
/*     */     //   18: sipush #2983
/*     */     //   21: invokestatic getMatrix : (I)Lorg/lwjgl/util/vector/Matrix4f;
/*     */     //   24: astore #4
/*     */     //   26: aload_2
/*     */     //   27: ldc 'real2d'
/*     */     //   29: iconst_1
/*     */     //   30: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   33: istore #5
/*     */     //   35: iload #5
/*     */     //   37: ifeq -> 151
/*     */     //   40: sipush #8192
/*     */     //   43: invokestatic glPushAttrib : (I)V
/*     */     //   46: sipush #3042
/*     */     //   49: invokestatic glEnable : (I)V
/*     */     //   52: sipush #3553
/*     */     //   55: invokestatic glDisable : (I)V
/*     */     //   58: sipush #2929
/*     */     //   61: invokestatic glDisable : (I)V
/*     */     //   64: sipush #5889
/*     */     //   67: invokestatic glMatrixMode : (I)V
/*     */     //   70: invokestatic glPushMatrix : ()V
/*     */     //   73: invokestatic glLoadIdentity : ()V
/*     */     //   76: dconst_0
/*     */     //   77: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   80: invokeinterface getDisplayWidth : ()I
/*     */     //   85: i2d
/*     */     //   86: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   89: invokeinterface getDisplayHeight : ()I
/*     */     //   94: i2d
/*     */     //   95: dconst_0
/*     */     //   96: ldc2_w -1.0
/*     */     //   99: dconst_1
/*     */     //   100: invokestatic glOrtho : (DDDDDD)V
/*     */     //   103: sipush #5888
/*     */     //   106: invokestatic glMatrixMode : (I)V
/*     */     //   109: invokestatic glPushMatrix : ()V
/*     */     //   112: invokestatic glLoadIdentity : ()V
/*     */     //   115: sipush #2929
/*     */     //   118: invokestatic glDisable : (I)V
/*     */     //   121: sipush #770
/*     */     //   124: sipush #771
/*     */     //   127: invokestatic glBlendFunc : (II)V
/*     */     //   130: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   133: invokeinterface getGlStateManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/renderer/IGlStateManager;
/*     */     //   138: invokeinterface enableTexture2D : ()V
/*     */     //   143: iconst_1
/*     */     //   144: invokestatic glDepthMask : (Z)V
/*     */     //   147: fconst_1
/*     */     //   148: invokestatic glLineWidth : (F)V
/*     */     //   151: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   154: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   159: dup
/*     */     //   160: ifnonnull -> 166
/*     */     //   163: invokestatic throwNpe : ()V
/*     */     //   166: invokeinterface getLoadedEntityList : ()Ljava/util/Collection;
/*     */     //   171: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   176: astore #7
/*     */     //   178: aload #7
/*     */     //   180: invokeinterface hasNext : ()Z
/*     */     //   185: ifeq -> 1725
/*     */     //   188: aload #7
/*     */     //   190: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   195: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   198: astore #6
/*     */     //   200: aload #6
/*     */     //   202: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   205: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   210: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   213: iconst_1
/*     */     //   214: ixor
/*     */     //   215: ifeq -> 1722
/*     */     //   218: aload #6
/*     */     //   220: iconst_0
/*     */     //   221: invokestatic isSelected : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Z)Z
/*     */     //   224: ifeq -> 1722
/*     */     //   227: aload #6
/*     */     //   229: invokeinterface asEntityLivingBase : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   234: astore #8
/*     */     //   236: aload_0
/*     */     //   237: aload #8
/*     */     //   239: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   242: invokevirtual getColor : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)Ljava/awt/Color;
/*     */     //   245: astore #9
/*     */     //   247: aload_2
/*     */     //   248: astore #10
/*     */     //   250: iconst_0
/*     */     //   251: istore #11
/*     */     //   253: aload #10
/*     */     //   255: dup
/*     */     //   256: ifnonnull -> 269
/*     */     //   259: new kotlin/TypeCastException
/*     */     //   262: dup
/*     */     //   263: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   265: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   268: athrow
/*     */     //   269: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   272: dup
/*     */     //   273: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   275: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   278: astore #10
/*     */     //   280: aload #10
/*     */     //   282: invokevirtual hashCode : ()I
/*     */     //   285: lookupswitch default -> 1722, -1171135301 -> 388, -934973296 -> 362, 1650 -> 336, 97739 -> 375, 2077419745 -> 349
/*     */     //   336: aload #10
/*     */     //   338: ldc '2d'
/*     */     //   340: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   343: ifeq -> 1722
/*     */     //   346: goto -> 423
/*     */     //   349: aload #10
/*     */     //   351: ldc 'Sanyueqi'
/*     */     //   353: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   356: ifeq -> 1722
/*     */     //   359: goto -> 601
/*     */     //   362: aload #10
/*     */     //   364: ldc 'real2d'
/*     */     //   366: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   369: ifeq -> 1722
/*     */     //   372: goto -> 956
/*     */     //   375: aload #10
/*     */     //   377: ldc 'box'
/*     */     //   379: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   382: ifeq -> 1722
/*     */     //   385: goto -> 398
/*     */     //   388: aload #10
/*     */     //   390: ldc 'otherbox'
/*     */     //   392: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   395: ifeq -> 1722
/*     */     //   398: aload #6
/*     */     //   400: aload #9
/*     */     //   402: aload_2
/*     */     //   403: ldc 'otherbox'
/*     */     //   405: iconst_1
/*     */     //   406: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   409: ifne -> 416
/*     */     //   412: iconst_1
/*     */     //   413: goto -> 417
/*     */     //   416: iconst_0
/*     */     //   417: invokestatic drawEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Ljava/awt/Color;Z)V
/*     */     //   420: goto -> 1722
/*     */     //   423: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   426: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   431: astore #11
/*     */     //   433: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   436: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   441: astore #12
/*     */     //   443: aload #8
/*     */     //   445: invokeinterface getLastTickPosX : ()D
/*     */     //   450: aload #8
/*     */     //   452: invokeinterface getPosX : ()D
/*     */     //   457: aload #8
/*     */     //   459: invokeinterface getLastTickPosX : ()D
/*     */     //   464: dsub
/*     */     //   465: aload #12
/*     */     //   467: invokeinterface getRenderPartialTicks : ()F
/*     */     //   472: f2d
/*     */     //   473: dmul
/*     */     //   474: dadd
/*     */     //   475: aload #11
/*     */     //   477: invokeinterface getRenderPosX : ()D
/*     */     //   482: dsub
/*     */     //   483: dstore #13
/*     */     //   485: aload #8
/*     */     //   487: invokeinterface getLastTickPosY : ()D
/*     */     //   492: aload #8
/*     */     //   494: invokeinterface getPosY : ()D
/*     */     //   499: aload #8
/*     */     //   501: invokeinterface getLastTickPosY : ()D
/*     */     //   506: dsub
/*     */     //   507: aload #12
/*     */     //   509: invokeinterface getRenderPartialTicks : ()F
/*     */     //   514: f2d
/*     */     //   515: dmul
/*     */     //   516: dadd
/*     */     //   517: aload #11
/*     */     //   519: invokeinterface getRenderPosY : ()D
/*     */     //   524: dsub
/*     */     //   525: dstore #15
/*     */     //   527: aload #8
/*     */     //   529: invokeinterface getLastTickPosZ : ()D
/*     */     //   534: aload #8
/*     */     //   536: invokeinterface getPosZ : ()D
/*     */     //   541: aload #8
/*     */     //   543: invokeinterface getLastTickPosZ : ()D
/*     */     //   548: dsub
/*     */     //   549: aload #12
/*     */     //   551: invokeinterface getRenderPartialTicks : ()F
/*     */     //   556: f2d
/*     */     //   557: dmul
/*     */     //   558: dadd
/*     */     //   559: aload #11
/*     */     //   561: invokeinterface getRenderPosZ : ()D
/*     */     //   566: dsub
/*     */     //   567: dstore #17
/*     */     //   569: aload #8
/*     */     //   571: dload #13
/*     */     //   573: dload #15
/*     */     //   575: dload #17
/*     */     //   577: aload #9
/*     */     //   579: invokevirtual getRGB : ()I
/*     */     //   582: getstatic java/awt/Color.BLACK : Ljava/awt/Color;
/*     */     //   585: dup
/*     */     //   586: ldc_w 'Color.BLACK'
/*     */     //   589: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   592: invokevirtual getRGB : ()I
/*     */     //   595: invokestatic draw2D : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;DDDII)V
/*     */     //   598: goto -> 1722
/*     */     //   601: aload #6
/*     */     //   603: invokeinterface getLastTickPosX : ()D
/*     */     //   608: aload #6
/*     */     //   610: invokeinterface getPosX : ()D
/*     */     //   615: aload #6
/*     */     //   617: invokeinterface getLastTickPosX : ()D
/*     */     //   622: dsub
/*     */     //   623: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   626: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   631: invokeinterface getRenderPartialTicks : ()F
/*     */     //   636: f2d
/*     */     //   637: dmul
/*     */     //   638: dadd
/*     */     //   639: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   642: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   647: invokeinterface getRenderPosX : ()D
/*     */     //   652: dsub
/*     */     //   653: dstore #11
/*     */     //   655: aload #6
/*     */     //   657: invokeinterface getLastTickPosY : ()D
/*     */     //   662: aload #6
/*     */     //   664: invokeinterface getPosY : ()D
/*     */     //   669: aload #6
/*     */     //   671: invokeinterface getLastTickPosY : ()D
/*     */     //   676: dsub
/*     */     //   677: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   680: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   685: invokeinterface getRenderPartialTicks : ()F
/*     */     //   690: f2d
/*     */     //   691: dmul
/*     */     //   692: dadd
/*     */     //   693: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   696: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   701: invokeinterface getRenderPosY : ()D
/*     */     //   706: dsub
/*     */     //   707: dstore #13
/*     */     //   709: aload #6
/*     */     //   711: invokeinterface getLastTickPosZ : ()D
/*     */     //   716: aload #6
/*     */     //   718: invokeinterface getPosZ : ()D
/*     */     //   723: aload #6
/*     */     //   725: invokeinterface getLastTickPosZ : ()D
/*     */     //   730: dsub
/*     */     //   731: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   734: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   739: invokeinterface getRenderPartialTicks : ()F
/*     */     //   744: f2d
/*     */     //   745: dmul
/*     */     //   746: dadd
/*     */     //   747: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   750: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   755: invokeinterface getRenderPosZ : ()D
/*     */     //   760: dsub
/*     */     //   761: dstore #15
/*     */     //   763: invokestatic glPushMatrix : ()V
/*     */     //   766: dload #11
/*     */     //   768: d2f
/*     */     //   769: dload #13
/*     */     //   771: aload #6
/*     */     //   773: invokeinterface isSneaking : ()Z
/*     */     //   778: ifeq -> 787
/*     */     //   781: ldc_w 0.8
/*     */     //   784: goto -> 790
/*     */     //   787: ldc_w 1.3
/*     */     //   790: f2d
/*     */     //   791: dadd
/*     */     //   792: d2f
/*     */     //   793: dload #15
/*     */     //   795: d2f
/*     */     //   796: invokestatic glTranslatef : (FFF)V
/*     */     //   799: fconst_1
/*     */     //   800: fconst_1
/*     */     //   801: fconst_1
/*     */     //   802: invokestatic glNormal3f : (FFF)V
/*     */     //   805: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   808: dup
/*     */     //   809: ldc_w 'mc2'
/*     */     //   812: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   815: invokevirtual func_175598_ae : ()Lnet/minecraft/client/renderer/entity/RenderManager;
/*     */     //   818: pop
/*     */     //   819: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   822: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   827: invokeinterface getPlayerViewY : ()F
/*     */     //   832: fneg
/*     */     //   833: fconst_0
/*     */     //   834: fconst_1
/*     */     //   835: fconst_0
/*     */     //   836: invokestatic glRotatef : (FFFF)V
/*     */     //   839: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   842: dup
/*     */     //   843: ldc_w 'mc2'
/*     */     //   846: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   849: invokevirtual func_175598_ae : ()Lnet/minecraft/client/renderer/entity/RenderManager;
/*     */     //   852: pop
/*     */     //   853: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   856: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   861: invokeinterface getPlayerViewX : ()F
/*     */     //   866: fconst_1
/*     */     //   867: fconst_0
/*     */     //   868: fconst_0
/*     */     //   869: invokestatic glRotatef : (FFFF)V
/*     */     //   872: ldc_w 0.06
/*     */     //   875: fstore #17
/*     */     //   877: fload #17
/*     */     //   879: fneg
/*     */     //   880: fload #17
/*     */     //   882: fneg
/*     */     //   883: fload #17
/*     */     //   885: invokestatic glScalef : (FFF)V
/*     */     //   888: sipush #2896
/*     */     //   891: invokestatic glDisable : (I)V
/*     */     //   894: sipush #2929
/*     */     //   897: invokestatic glDisable : (I)V
/*     */     //   900: sipush #3042
/*     */     //   903: invokestatic glEnable : (I)V
/*     */     //   906: sipush #770
/*     */     //   909: sipush #771
/*     */     //   912: invokestatic glBlendFunc : (II)V
/*     */     //   915: invokestatic glPushMatrix : ()V
/*     */     //   918: fconst_1
/*     */     //   919: fconst_1
/*     */     //   920: fconst_1
/*     */     //   921: fconst_1
/*     */     //   922: invokestatic glColor4f : (FFFF)V
/*     */     //   925: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   928: ldc_w 'catbounce/Sanyueqi.png'
/*     */     //   931: invokeinterface createResourceLocation : (Ljava/lang/String;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;
/*     */     //   936: bipush #-8
/*     */     //   938: bipush #-14
/*     */     //   940: bipush #16
/*     */     //   942: bipush #16
/*     */     //   944: invokestatic drawImage : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;IIII)V
/*     */     //   947: invokestatic glPopMatrix : ()V
/*     */     //   950: invokestatic glPopMatrix : ()V
/*     */     //   953: goto -> 1722
/*     */     //   956: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   959: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   964: astore #11
/*     */     //   966: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   969: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   974: astore #12
/*     */     //   976: aload #8
/*     */     //   978: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   983: aload #8
/*     */     //   985: invokeinterface getPosX : ()D
/*     */     //   990: dneg
/*     */     //   991: aload #8
/*     */     //   993: invokeinterface getPosY : ()D
/*     */     //   998: dneg
/*     */     //   999: aload #8
/*     */     //   1001: invokeinterface getPosZ : ()D
/*     */     //   1006: dneg
/*     */     //   1007: invokeinterface offset : (DDD)Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   1012: aload #8
/*     */     //   1014: invokeinterface getLastTickPosX : ()D
/*     */     //   1019: aload #8
/*     */     //   1021: invokeinterface getPosX : ()D
/*     */     //   1026: aload #8
/*     */     //   1028: invokeinterface getLastTickPosX : ()D
/*     */     //   1033: dsub
/*     */     //   1034: aload #12
/*     */     //   1036: invokeinterface getRenderPartialTicks : ()F
/*     */     //   1041: f2d
/*     */     //   1042: dmul
/*     */     //   1043: dadd
/*     */     //   1044: aload #8
/*     */     //   1046: invokeinterface getLastTickPosY : ()D
/*     */     //   1051: aload #8
/*     */     //   1053: invokeinterface getPosY : ()D
/*     */     //   1058: aload #8
/*     */     //   1060: invokeinterface getLastTickPosY : ()D
/*     */     //   1065: dsub
/*     */     //   1066: aload #12
/*     */     //   1068: invokeinterface getRenderPartialTicks : ()F
/*     */     //   1073: f2d
/*     */     //   1074: dmul
/*     */     //   1075: dadd
/*     */     //   1076: aload #8
/*     */     //   1078: invokeinterface getLastTickPosZ : ()D
/*     */     //   1083: aload #8
/*     */     //   1085: invokeinterface getPosZ : ()D
/*     */     //   1090: aload #8
/*     */     //   1092: invokeinterface getLastTickPosZ : ()D
/*     */     //   1097: dsub
/*     */     //   1098: aload #12
/*     */     //   1100: invokeinterface getRenderPartialTicks : ()F
/*     */     //   1105: f2d
/*     */     //   1106: dmul
/*     */     //   1107: dadd
/*     */     //   1108: invokeinterface offset : (DDD)Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   1113: aload #11
/*     */     //   1115: invokeinterface getRenderPosX : ()D
/*     */     //   1120: dneg
/*     */     //   1121: aload #11
/*     */     //   1123: invokeinterface getRenderPosY : ()D
/*     */     //   1128: dneg
/*     */     //   1129: aload #11
/*     */     //   1131: invokeinterface getRenderPosZ : ()D
/*     */     //   1136: dneg
/*     */     //   1137: invokeinterface offset : (DDD)Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   1142: astore #13
/*     */     //   1144: bipush #8
/*     */     //   1146: anewarray [D
/*     */     //   1149: dup
/*     */     //   1150: iconst_0
/*     */     //   1151: iconst_3
/*     */     //   1152: newarray double
/*     */     //   1154: dup
/*     */     //   1155: iconst_0
/*     */     //   1156: aload #13
/*     */     //   1158: invokeinterface getMinX : ()D
/*     */     //   1163: dastore
/*     */     //   1164: dup
/*     */     //   1165: iconst_1
/*     */     //   1166: aload #13
/*     */     //   1168: invokeinterface getMinY : ()D
/*     */     //   1173: dastore
/*     */     //   1174: dup
/*     */     //   1175: iconst_2
/*     */     //   1176: aload #13
/*     */     //   1178: invokeinterface getMinZ : ()D
/*     */     //   1183: dastore
/*     */     //   1184: aastore
/*     */     //   1185: dup
/*     */     //   1186: iconst_1
/*     */     //   1187: iconst_3
/*     */     //   1188: newarray double
/*     */     //   1190: dup
/*     */     //   1191: iconst_0
/*     */     //   1192: aload #13
/*     */     //   1194: invokeinterface getMinX : ()D
/*     */     //   1199: dastore
/*     */     //   1200: dup
/*     */     //   1201: iconst_1
/*     */     //   1202: aload #13
/*     */     //   1204: invokeinterface getMaxY : ()D
/*     */     //   1209: dastore
/*     */     //   1210: dup
/*     */     //   1211: iconst_2
/*     */     //   1212: aload #13
/*     */     //   1214: invokeinterface getMinZ : ()D
/*     */     //   1219: dastore
/*     */     //   1220: aastore
/*     */     //   1221: dup
/*     */     //   1222: iconst_2
/*     */     //   1223: iconst_3
/*     */     //   1224: newarray double
/*     */     //   1226: dup
/*     */     //   1227: iconst_0
/*     */     //   1228: aload #13
/*     */     //   1230: invokeinterface getMaxX : ()D
/*     */     //   1235: dastore
/*     */     //   1236: dup
/*     */     //   1237: iconst_1
/*     */     //   1238: aload #13
/*     */     //   1240: invokeinterface getMaxY : ()D
/*     */     //   1245: dastore
/*     */     //   1246: dup
/*     */     //   1247: iconst_2
/*     */     //   1248: aload #13
/*     */     //   1250: invokeinterface getMinZ : ()D
/*     */     //   1255: dastore
/*     */     //   1256: aastore
/*     */     //   1257: dup
/*     */     //   1258: iconst_3
/*     */     //   1259: iconst_3
/*     */     //   1260: newarray double
/*     */     //   1262: dup
/*     */     //   1263: iconst_0
/*     */     //   1264: aload #13
/*     */     //   1266: invokeinterface getMaxX : ()D
/*     */     //   1271: dastore
/*     */     //   1272: dup
/*     */     //   1273: iconst_1
/*     */     //   1274: aload #13
/*     */     //   1276: invokeinterface getMinY : ()D
/*     */     //   1281: dastore
/*     */     //   1282: dup
/*     */     //   1283: iconst_2
/*     */     //   1284: aload #13
/*     */     //   1286: invokeinterface getMinZ : ()D
/*     */     //   1291: dastore
/*     */     //   1292: aastore
/*     */     //   1293: dup
/*     */     //   1294: iconst_4
/*     */     //   1295: iconst_3
/*     */     //   1296: newarray double
/*     */     //   1298: dup
/*     */     //   1299: iconst_0
/*     */     //   1300: aload #13
/*     */     //   1302: invokeinterface getMinX : ()D
/*     */     //   1307: dastore
/*     */     //   1308: dup
/*     */     //   1309: iconst_1
/*     */     //   1310: aload #13
/*     */     //   1312: invokeinterface getMinY : ()D
/*     */     //   1317: dastore
/*     */     //   1318: dup
/*     */     //   1319: iconst_2
/*     */     //   1320: aload #13
/*     */     //   1322: invokeinterface getMaxZ : ()D
/*     */     //   1327: dastore
/*     */     //   1328: aastore
/*     */     //   1329: dup
/*     */     //   1330: iconst_5
/*     */     //   1331: iconst_3
/*     */     //   1332: newarray double
/*     */     //   1334: dup
/*     */     //   1335: iconst_0
/*     */     //   1336: aload #13
/*     */     //   1338: invokeinterface getMinX : ()D
/*     */     //   1343: dastore
/*     */     //   1344: dup
/*     */     //   1345: iconst_1
/*     */     //   1346: aload #13
/*     */     //   1348: invokeinterface getMaxY : ()D
/*     */     //   1353: dastore
/*     */     //   1354: dup
/*     */     //   1355: iconst_2
/*     */     //   1356: aload #13
/*     */     //   1358: invokeinterface getMaxZ : ()D
/*     */     //   1363: dastore
/*     */     //   1364: aastore
/*     */     //   1365: dup
/*     */     //   1366: bipush #6
/*     */     //   1368: iconst_3
/*     */     //   1369: newarray double
/*     */     //   1371: dup
/*     */     //   1372: iconst_0
/*     */     //   1373: aload #13
/*     */     //   1375: invokeinterface getMaxX : ()D
/*     */     //   1380: dastore
/*     */     //   1381: dup
/*     */     //   1382: iconst_1
/*     */     //   1383: aload #13
/*     */     //   1385: invokeinterface getMaxY : ()D
/*     */     //   1390: dastore
/*     */     //   1391: dup
/*     */     //   1392: iconst_2
/*     */     //   1393: aload #13
/*     */     //   1395: invokeinterface getMaxZ : ()D
/*     */     //   1400: dastore
/*     */     //   1401: aastore
/*     */     //   1402: dup
/*     */     //   1403: bipush #7
/*     */     //   1405: iconst_3
/*     */     //   1406: newarray double
/*     */     //   1408: dup
/*     */     //   1409: iconst_0
/*     */     //   1410: aload #13
/*     */     //   1412: invokeinterface getMaxX : ()D
/*     */     //   1417: dastore
/*     */     //   1418: dup
/*     */     //   1419: iconst_1
/*     */     //   1420: aload #13
/*     */     //   1422: invokeinterface getMinY : ()D
/*     */     //   1427: dastore
/*     */     //   1428: dup
/*     */     //   1429: iconst_2
/*     */     //   1430: aload #13
/*     */     //   1432: invokeinterface getMaxZ : ()D
/*     */     //   1437: dastore
/*     */     //   1438: aastore
/*     */     //   1439: checkcast [[D
/*     */     //   1442: astore #14
/*     */     //   1444: getstatic kotlin/jvm/internal/FloatCompanionObject.INSTANCE : Lkotlin/jvm/internal/FloatCompanionObject;
/*     */     //   1447: invokevirtual getMAX_VALUE : ()F
/*     */     //   1450: fstore #15
/*     */     //   1452: getstatic kotlin/jvm/internal/FloatCompanionObject.INSTANCE : Lkotlin/jvm/internal/FloatCompanionObject;
/*     */     //   1455: invokevirtual getMAX_VALUE : ()F
/*     */     //   1458: fstore #16
/*     */     //   1460: ldc_w -1.0
/*     */     //   1463: fstore #17
/*     */     //   1465: ldc_w -1.0
/*     */     //   1468: fstore #18
/*     */     //   1470: aload #14
/*     */     //   1472: astore #21
/*     */     //   1474: aload #21
/*     */     //   1476: arraylength
/*     */     //   1477: istore #22
/*     */     //   1479: iconst_0
/*     */     //   1480: istore #20
/*     */     //   1482: iload #20
/*     */     //   1484: iload #22
/*     */     //   1486: if_icmpge -> 1607
/*     */     //   1489: aload #21
/*     */     //   1491: iload #20
/*     */     //   1493: aaload
/*     */     //   1494: astore #19
/*     */     //   1496: new org/lwjgl/util/vector/Vector3f
/*     */     //   1499: dup
/*     */     //   1500: aload #19
/*     */     //   1502: iconst_0
/*     */     //   1503: daload
/*     */     //   1504: d2f
/*     */     //   1505: aload #19
/*     */     //   1507: iconst_1
/*     */     //   1508: daload
/*     */     //   1509: d2f
/*     */     //   1510: aload #19
/*     */     //   1512: iconst_2
/*     */     //   1513: daload
/*     */     //   1514: d2f
/*     */     //   1515: invokespecial <init> : (FFF)V
/*     */     //   1518: aload_3
/*     */     //   1519: aload #4
/*     */     //   1521: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1524: invokeinterface getDisplayWidth : ()I
/*     */     //   1529: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1532: invokeinterface getDisplayHeight : ()I
/*     */     //   1537: invokestatic worldToScreen : (Lorg/lwjgl/util/vector/Vector3f;Lorg/lwjgl/util/vector/Matrix4f;Lorg/lwjgl/util/vector/Matrix4f;II)Lorg/lwjgl/util/vector/Vector2f;
/*     */     //   1540: dup
/*     */     //   1541: ifnull -> 1547
/*     */     //   1544: goto -> 1551
/*     */     //   1547: pop
/*     */     //   1548: goto -> 1601
/*     */     //   1551: astore #23
/*     */     //   1553: aload #23
/*     */     //   1555: getfield x : F
/*     */     //   1558: fload #15
/*     */     //   1560: invokestatic min : (FF)F
/*     */     //   1563: fstore #15
/*     */     //   1565: aload #23
/*     */     //   1567: getfield y : F
/*     */     //   1570: fload #16
/*     */     //   1572: invokestatic min : (FF)F
/*     */     //   1575: fstore #16
/*     */     //   1577: aload #23
/*     */     //   1579: getfield x : F
/*     */     //   1582: fload #17
/*     */     //   1584: invokestatic max : (FF)F
/*     */     //   1587: fstore #17
/*     */     //   1589: aload #23
/*     */     //   1591: getfield y : F
/*     */     //   1594: fload #18
/*     */     //   1596: invokestatic max : (FF)F
/*     */     //   1599: fstore #18
/*     */     //   1601: iinc #20, 1
/*     */     //   1604: goto -> 1482
/*     */     //   1607: fload #15
/*     */     //   1609: iconst_0
/*     */     //   1610: i2f
/*     */     //   1611: fcmpl
/*     */     //   1612: ifgt -> 1653
/*     */     //   1615: fload #16
/*     */     //   1617: iconst_0
/*     */     //   1618: i2f
/*     */     //   1619: fcmpl
/*     */     //   1620: ifgt -> 1653
/*     */     //   1623: fload #17
/*     */     //   1625: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1628: invokeinterface getDisplayWidth : ()I
/*     */     //   1633: i2f
/*     */     //   1634: fcmpg
/*     */     //   1635: ifle -> 1653
/*     */     //   1638: fload #18
/*     */     //   1640: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1643: invokeinterface getDisplayWidth : ()I
/*     */     //   1648: i2f
/*     */     //   1649: fcmpg
/*     */     //   1650: ifgt -> 1722
/*     */     //   1653: aload #9
/*     */     //   1655: invokevirtual getRed : ()I
/*     */     //   1658: i2f
/*     */     //   1659: ldc_w 255.0
/*     */     //   1662: fdiv
/*     */     //   1663: aload #9
/*     */     //   1665: invokevirtual getGreen : ()I
/*     */     //   1668: i2f
/*     */     //   1669: ldc_w 255.0
/*     */     //   1672: fdiv
/*     */     //   1673: aload #9
/*     */     //   1675: invokevirtual getBlue : ()I
/*     */     //   1678: i2f
/*     */     //   1679: ldc_w 255.0
/*     */     //   1682: fdiv
/*     */     //   1683: fconst_1
/*     */     //   1684: invokestatic glColor4f : (FFFF)V
/*     */     //   1687: iconst_2
/*     */     //   1688: invokestatic glBegin : (I)V
/*     */     //   1691: fload #15
/*     */     //   1693: fload #16
/*     */     //   1695: invokestatic glVertex2f : (FF)V
/*     */     //   1698: fload #15
/*     */     //   1700: fload #18
/*     */     //   1702: invokestatic glVertex2f : (FF)V
/*     */     //   1705: fload #17
/*     */     //   1707: fload #18
/*     */     //   1709: invokestatic glVertex2f : (FF)V
/*     */     //   1712: fload #17
/*     */     //   1714: fload #16
/*     */     //   1716: invokestatic glVertex2f : (FF)V
/*     */     //   1719: invokestatic glEnd : ()V
/*     */     //   1722: goto -> 178
/*     */     //   1725: iload #5
/*     */     //   1727: ifeq -> 1757
/*     */     //   1730: sipush #2929
/*     */     //   1733: invokestatic glEnable : (I)V
/*     */     //   1736: sipush #5889
/*     */     //   1739: invokestatic glMatrixMode : (I)V
/*     */     //   1742: invokestatic glPopMatrix : ()V
/*     */     //   1745: sipush #5888
/*     */     //   1748: invokestatic glMatrixMode : (I)V
/*     */     //   1751: invokestatic glPopMatrix : ()V
/*     */     //   1754: invokestatic glPopAttrib : ()V
/*     */     //   1757: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #49	-> 0
/*     */     //   #50	-> 11
/*     */     //   #51	-> 18
/*     */     //   #52	-> 26
/*     */     //   #55	-> 35
/*     */     //   #56	-> 40
/*     */     //   #57	-> 46
/*     */     //   #58	-> 52
/*     */     //   #59	-> 58
/*     */     //   #60	-> 64
/*     */     //   #61	-> 70
/*     */     //   #62	-> 73
/*     */     //   #63	-> 76
/*     */     //   #64	-> 103
/*     */     //   #65	-> 109
/*     */     //   #66	-> 112
/*     */     //   #67	-> 115
/*     */     //   #68	-> 121
/*     */     //   #69	-> 130
/*     */     //   #70	-> 143
/*     */     //   #71	-> 147
/*     */     //   #74	-> 151
/*     */     //   #75	-> 200
/*     */     //   #76	-> 227
/*     */     //   #77	-> 236
/*     */     //   #79	-> 247
/*     */     //   #81	-> 336
/*     */     //   #89	-> 349
/*     */     //   #119	-> 362
/*     */     //   #80	-> 375
/*     */     //   #82	-> 423
/*     */     //   #83	-> 433
/*     */     //   #84	-> 443
/*     */     //   #85	-> 485
/*     */     //   #86	-> 527
/*     */     //   #87	-> 569
/*     */     //   #90	-> 601
/*     */     //   #91	-> 639
/*     */     //   #90	-> 652
/*     */     //   #92	-> 655
/*     */     //   #93	-> 693
/*     */     //   #92	-> 706
/*     */     //   #94	-> 709
/*     */     //   #95	-> 747
/*     */     //   #94	-> 760
/*     */     //   #97	-> 763
/*     */     //   #98	-> 766
/*     */     //   #99	-> 793
/*     */     //   #98	-> 796
/*     */     //   #101	-> 799
/*     */     //   #102	-> 805
/*     */     //   #103	-> 839
/*     */     //   #104	-> 872
/*     */     //   #105	-> 877
/*     */     //   #107	-> 888
/*     */     //   #108	-> 894
/*     */     //   #109	-> 900
/*     */     //   #110	-> 906
/*     */     //   #112	-> 915
/*     */     //   #113	-> 918
/*     */     //   #115	-> 925
/*     */     //   #116	-> 947
/*     */     //   #117	-> 950
/*     */     //   #120	-> 956
/*     */     //   #121	-> 966
/*     */     //   #122	-> 976
/*     */     //   #127	-> 976
/*     */     //   #122	-> 976
/*     */     //   #124	-> 976
/*     */     //   #122	-> 976
/*     */     //   #123	-> 976
/*     */     //   #122	-> 976
/*     */     //   #123	-> 983
/*     */     //   #124	-> 1012
/*     */     //   #125	-> 1044
/*     */     //   #126	-> 1076
/*     */     //   #124	-> 1108
/*     */     //   #127	-> 1113
/*     */     //   #122	-> 1142
/*     */     //   #128	-> 1144
/*     */     //   #129	-> 1444
/*     */     //   #130	-> 1452
/*     */     //   #131	-> 1460
/*     */     //   #132	-> 1465
/*     */     //   #133	-> 1470
/*     */     //   #134	-> 1496
/*     */     //   #135	-> 1548
/*     */     //   #134	-> 1551
/*     */     //   #136	-> 1553
/*     */     //   #137	-> 1565
/*     */     //   #138	-> 1577
/*     */     //   #139	-> 1589
/*     */     //   #133	-> 1601
/*     */     //   #141	-> 1607
/*     */     //   #142	-> 1653
/*     */     //   #143	-> 1687
/*     */     //   #144	-> 1691
/*     */     //   #145	-> 1698
/*     */     //   #146	-> 1705
/*     */     //   #147	-> 1712
/*     */     //   #148	-> 1719
/*     */     //   #151	-> 1722
/*     */     //   #74	-> 1722
/*     */     //   #154	-> 1725
/*     */     //   #155	-> 1730
/*     */     //   #156	-> 1736
/*     */     //   #157	-> 1742
/*     */     //   #158	-> 1745
/*     */     //   #159	-> 1751
/*     */     //   #160	-> 1754
/*     */     //   #162	-> 1757
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   569	29	17	posZ	D
/*     */     //   527	71	15	posY	D
/*     */     //   485	113	13	posX	D
/*     */     //   443	155	12	timer	Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   433	165	11	renderManager	Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   877	76	17	scale	F
/*     */     //   763	190	15	pZ	D
/*     */     //   709	244	13	pY	D
/*     */     //   655	298	11	pX	D
/*     */     //   1553	48	23	screenPos	Lorg/lwjgl/util/vector/Vector2f;
/*     */     //   1496	108	19	boxVertex	[D
/*     */     //   1470	252	18	maxY	F
/*     */     //   1465	257	17	maxX	F
/*     */     //   1460	262	16	minY	F
/*     */     //   1452	270	15	minX	F
/*     */     //   1444	278	14	boxVertices	[[D
/*     */     //   1144	578	13	bb	Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   976	746	12	timer	Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   966	756	11	renderManager	Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   247	1475	9	color	Ljava/awt/Color;
/*     */     //   236	1486	8	entityLiving	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   200	1522	6	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   35	1723	5	real2d	Z
/*     */     //   26	1732	4	projectionMatrix	Lorg/lwjgl/util/vector/Matrix4f;
/*     */     //   18	1740	3	mvMatrix	Lorg/lwjgl/util/vector/Matrix4f;
/*     */     //   11	1747	2	mode	Ljava/lang/String;
/*     */     //   0	1758	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/render/ESP3;
/*     */     //   0	1758	1	event	Lnet/ccbluex/liquidbounce/event/Render3DEvent;
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
/* 166 */     Intrinsics.checkParameterIsNotNull(event, "event"); String str1 = (String)this.modeValue.get(); boolean bool = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()"); String mode = str1.toLowerCase();
/* 167 */     if ((StringsKt.equals(mode, "shaderoutline", true) ? OutlineShader.OUTLINE_SHADER : (StringsKt.equals(mode, "shaderglow", true) ? (FramebufferShader)GlowShader.GLOW_SHADER : null)) != null) { Object object = StringsKt.equals(mode, "shaderoutline", true) ? OutlineShader.OUTLINE_SHADER : (StringsKt.equals(mode, "shaderglow", true) ? (FramebufferShader)GlowShader.GLOW_SHADER : null);
/*     */       
/* 169 */       object.startDraw(event.getPartialTicks());
/* 170 */       renderNameTags = false;
/*     */       try {
/* 172 */         if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  for (IEntity entity : MinecraftInstance.mc.getTheWorld().getLoadedEntityList()) {
/* 173 */           if (!EntityUtils.isSelected(entity, false))
/* 174 */             continue;  MinecraftInstance.mc.getRenderManager().renderEntityStatic(entity, MinecraftInstance.mc.getTimer().getRenderPartialTicks(), true);
/*     */         } 
/* 176 */       } catch (Exception ex) {
/* 177 */         ClientUtils.getLogger().error("An error occurred while rendering all entities for shader esp", ex);
/*     */       } 
/* 179 */       renderNameTags = true;
/* 180 */       float radius = StringsKt.equals(mode, "shaderoutline", true) ? ((Number)this.shaderOutlineRadius.get()).floatValue() : (StringsKt.equals(mode, "shaderglow", true) ? ((Number)this.shaderGlowRadius.get()).floatValue() : 1.0F);
/* 181 */       object.stopDraw(getColor(null), radius, 1.0F);
/*     */       return; }
/*     */     
/*     */     StringsKt.equals(mode, "shaderoutline", true) ? OutlineShader.OUTLINE_SHADER : (StringsKt.equals(mode, "shaderglow", true) ? (FramebufferShader)GlowShader.GLOW_SHADER : null); } @NotNull
/* 185 */   public String getTag() { return (String)this.modeValue.get(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public final Color getColor(@Nullable IEntity entity) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: astore_2
/*     */     //   2: iconst_0
/*     */     //   3: istore_3
/*     */     //   4: iconst_0
/*     */     //   5: istore #4
/*     */     //   7: aload_2
/*     */     //   8: checkcast net/ccbluex/liquidbounce/features/module/modules/render/ESP3
/*     */     //   11: astore #5
/*     */     //   13: iconst_0
/*     */     //   14: istore #6
/*     */     //   16: aload_1
/*     */     //   17: ifnull -> 257
/*     */     //   20: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   23: aload_1
/*     */     //   24: invokeinterface isEntityLivingBase : (Ljava/lang/Object;)Z
/*     */     //   29: ifeq -> 257
/*     */     //   32: aload_1
/*     */     //   33: invokeinterface asEntityLivingBase : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   38: astore #7
/*     */     //   40: aload #7
/*     */     //   42: invokeinterface getHurtTime : ()I
/*     */     //   47: ifle -> 61
/*     */     //   50: getstatic java/awt/Color.RED : Ljava/awt/Color;
/*     */     //   53: dup
/*     */     //   54: ldc_w 'Color.RED'
/*     */     //   57: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   60: areturn
/*     */     //   61: aload #7
/*     */     //   63: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   66: invokestatic isFriend : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)Z
/*     */     //   69: ifeq -> 83
/*     */     //   72: getstatic java/awt/Color.BLUE : Ljava/awt/Color;
/*     */     //   75: dup
/*     */     //   76: ldc_w 'Color.BLUE'
/*     */     //   79: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   82: areturn
/*     */     //   83: aload #5
/*     */     //   85: getfield colorTeam : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   88: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   91: checkcast java/lang/Boolean
/*     */     //   94: invokevirtual booleanValue : ()Z
/*     */     //   97: ifeq -> 257
/*     */     //   100: aload #7
/*     */     //   102: invokeinterface getDisplayName : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;
/*     */     //   107: dup
/*     */     //   108: ifnull -> 114
/*     */     //   111: goto -> 118
/*     */     //   114: pop
/*     */     //   115: goto -> 258
/*     */     //   118: invokeinterface getFormattedText : ()Ljava/lang/String;
/*     */     //   123: astore #8
/*     */     //   125: iconst_0
/*     */     //   126: istore #9
/*     */     //   128: aload #8
/*     */     //   130: dup
/*     */     //   131: ifnonnull -> 144
/*     */     //   134: new kotlin/TypeCastException
/*     */     //   137: dup
/*     */     //   138: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   140: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   143: athrow
/*     */     //   144: invokevirtual toCharArray : ()[C
/*     */     //   147: dup
/*     */     //   148: ldc_w '(this as java.lang.String).toCharArray()'
/*     */     //   151: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   154: astore #10
/*     */     //   156: ldc_w 2147483647
/*     */     //   159: istore #8
/*     */     //   161: iconst_0
/*     */     //   162: istore #9
/*     */     //   164: aload #10
/*     */     //   166: arraylength
/*     */     //   167: istore #11
/*     */     //   169: iload #9
/*     */     //   171: iload #11
/*     */     //   173: if_icmpge -> 247
/*     */     //   176: aload #10
/*     */     //   178: iload #9
/*     */     //   180: caload
/*     */     //   181: sipush #167
/*     */     //   184: if_icmpne -> 241
/*     */     //   187: iload #9
/*     */     //   189: iconst_1
/*     */     //   190: iadd
/*     */     //   191: aload #10
/*     */     //   193: arraylength
/*     */     //   194: if_icmplt -> 200
/*     */     //   197: goto -> 241
/*     */     //   200: getstatic net/ccbluex/liquidbounce/ui/font/GameFontRenderer.Companion : Lnet/ccbluex/liquidbounce/ui/font/GameFontRenderer$Companion;
/*     */     //   203: aload #10
/*     */     //   205: iload #9
/*     */     //   207: iconst_1
/*     */     //   208: iadd
/*     */     //   209: caload
/*     */     //   210: invokevirtual getColorIndex : (C)I
/*     */     //   213: istore #12
/*     */     //   215: iload #12
/*     */     //   217: iflt -> 241
/*     */     //   220: iload #12
/*     */     //   222: bipush #15
/*     */     //   224: if_icmple -> 230
/*     */     //   227: goto -> 241
/*     */     //   230: getstatic net/ccbluex/liquidbounce/utils/render/ColorUtils.hexColors : [I
/*     */     //   233: iload #12
/*     */     //   235: iaload
/*     */     //   236: istore #8
/*     */     //   238: goto -> 247
/*     */     //   241: iinc #9, 1
/*     */     //   244: goto -> 169
/*     */     //   247: new java/awt/Color
/*     */     //   250: dup
/*     */     //   251: iload #8
/*     */     //   253: invokespecial <init> : (I)V
/*     */     //   256: areturn
/*     */     //   257: nop
/*     */     //   258: nop
/*     */     //   259: nop
/*     */     //   260: aload_0
/*     */     //   261: getfield colorRainbow : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   264: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   267: checkcast java/lang/Boolean
/*     */     //   270: invokevirtual booleanValue : ()Z
/*     */     //   273: ifeq -> 282
/*     */     //   276: invokestatic rainbow : ()Ljava/awt/Color;
/*     */     //   279: goto -> 325
/*     */     //   282: new java/awt/Color
/*     */     //   285: dup
/*     */     //   286: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   289: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   292: checkcast java/lang/Number
/*     */     //   295: invokevirtual intValue : ()I
/*     */     //   298: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   301: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   304: checkcast java/lang/Number
/*     */     //   307: invokevirtual intValue : ()I
/*     */     //   310: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   313: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   316: checkcast java/lang/Number
/*     */     //   319: invokevirtual intValue : ()I
/*     */     //   322: invokespecial <init> : (III)V
/*     */     //   325: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #188	-> 0
/*     */     //   #189	-> 16
/*     */     //   #190	-> 32
/*     */     //   #192	-> 40
/*     */     //   #193	-> 61
/*     */     //   #194	-> 83
/*     */     //   #195	-> 100
/*     */     //   #195	-> 114
/*     */     //   #195	-> 154
/*     */     //   #196	-> 156
/*     */     //   #197	-> 161
/*     */     //   #198	-> 176
/*     */     //   #199	-> 200
/*     */     //   #200	-> 215
/*     */     //   #201	-> 230
/*     */     //   #202	-> 238
/*     */     //   #197	-> 241
/*     */     //   #204	-> 247
/*     */     //   #207	-> 257
/*     */     //   #188	-> 259
/*     */     //   #208	-> 260
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   215	26	12	index	I
/*     */     //   176	68	9	i	I
/*     */     //   161	96	8	color	I
/*     */     //   156	101	10	chars	[C
/*     */     //   40	217	7	entityLivingBase	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   13	245	5	$this$run	Lnet/ccbluex/liquidbounce/features/module/modules/render/ESP3;
/*     */     //   16	242	6	$i$a$-run-ESP3$getColor$1	I
/*     */     //   0	326	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/render/ESP3;
/*     */     //   0	326	1	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\013\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\022\020\003\032\0020\0048\006@\006X\016¢\006\002\n\000¨\006\005"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/ESP3$Companion;", "", "()V", "renderNameTags", "", "XSJClient"})
/*     */   public static final class Companion
/*     */   {
/*     */     private Companion() {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 213 */   public static final Companion Companion = new Companion(null); static { renderNameTags = true; }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\ESP3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */