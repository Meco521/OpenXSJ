/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.Unit;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.jvm.functions.Function0;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IFontRenderer;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ElementInfo(name = "Arraylist", single = true)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000t\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\007\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\t\n\002\030\002\n\002\b\f\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\006\n\002\020 \n\002\030\002\n\002\b\"\n\002\020\b\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\002\b\004\n\002\020\002\n\000\b\007\030\0002\0020\001B-\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006\022\b\b\002\020\007\032\0020\b¢\006\002\020\tJ\n\020Z\032\004\030\0010[H\026J\016\020\\\032\0020]2\006\020^\032\00205J\020\020_\032\0020]2\006\020`\032\00205H\002J\b\020a\032\0020bH\026R\016\020\n\032\0020\013X\004¢\006\002\n\000R\016\020\f\032\0020\rX\004¢\006\002\n\000R\016\020\016\032\0020\017X\004¢\006\002\n\000R\016\020\020\032\0020\017X\004¢\006\002\n\000R\016\020\021\032\0020\017X\004¢\006\002\n\000R\016\020\022\032\0020\017X\004¢\006\002\n\000R\016\020\023\032\0020\013X\004¢\006\002\n\000R\016\020\024\032\0020\rX\004¢\006\002\n\000R\016\020\025\032\0020\rX\004¢\006\002\n\000R\016\020\026\032\0020\017X\004¢\006\002\n\000R\016\020\027\032\0020\017X\004¢\006\002\n\000R\016\020\030\032\0020\031X\004¢\006\002\n\000R\021\020\032\032\0020\017¢\006\b\n\000\032\004\b\033\020\034R\021\020\035\032\0020\017¢\006\b\n\000\032\004\b\036\020\034R\021\020\037\032\0020\017¢\006\b\n\000\032\004\b \020\034R\016\020!\032\0020\031X\004¢\006\002\n\000R\021\020\"\032\0020\017¢\006\b\n\000\032\004\b#\020\034R\016\020$\032\0020\017X\004¢\006\002\n\000R\"\020%\032\n '*\004\030\0010&0&X\016¢\006\016\n\000\032\004\b(\020)\"\004\b*\020+R\016\020,\032\0020-X\004¢\006\002\n\000R\016\020.\032\0020\017X\004¢\006\002\n\000R\016\020/\032\0020\031X\004¢\006\002\n\000R\016\0200\032\0020\rX\004¢\006\002\n\000R\016\0201\032\0020\rX\004¢\006\002\n\000R\016\0202\032\0020\017X\004¢\006\002\n\000R\024\0203\032\b\022\004\022\0020504X\016¢\006\002\n\000R\016\0206\032\0020\013X\004¢\006\002\n\000R\016\0207\032\0020\031X\004¢\006\002\n\000R\021\0208\032\0020\017¢\006\b\n\000\032\004\b9\020\034R\021\020:\032\0020\017¢\006\b\n\000\032\004\b;\020\034R\021\020<\032\0020\017¢\006\b\n\000\032\004\b=\020\034R\021\020>\032\0020\017¢\006\b\n\000\032\004\b?\020\034R\016\020@\032\0020\031X\004¢\006\002\n\000R\016\020A\032\0020\031X\004¢\006\002\n\000R\016\020B\032\0020\031X\004¢\006\002\n\000R\016\020C\032\0020\rX\004¢\006\002\n\000R\016\020D\032\0020\rX\004¢\006\002\n\000R\016\020E\032\0020\013X\004¢\006\002\n\000R\016\020F\032\0020\017X\004¢\006\002\n\000R\016\020G\032\0020\017X\004¢\006\002\n\000R\016\020H\032\0020\031X\004¢\006\002\n\000R\016\020I\032\0020\017X\004¢\006\002\n\000R\016\020J\032\0020\013X\004¢\006\002\n\000R\016\020K\032\0020\013X\004¢\006\002\n\000R\016\020L\032\0020\017X\004¢\006\002\n\000R\016\020M\032\0020\017X\004¢\006\002\n\000R\016\020N\032\0020\017X\004¢\006\002\n\000R\024\020O\032\b\022\004\022\0020504X\016¢\006\002\n\000R\016\020P\032\0020\rX\004¢\006\002\n\000R\016\020Q\032\0020\013X\004¢\006\002\n\000R\016\020R\032\0020\013X\004¢\006\002\n\000R\016\020S\032\0020\031X\004¢\006\002\n\000R\016\020T\032\0020\rX\004¢\006\002\n\000R\016\020U\032\0020\rX\004¢\006\002\n\000R\016\020V\032\0020\031X\004¢\006\002\n\000R\016\020W\032\0020XX\016¢\006\002\n\000R\016\020Y\032\0020\006X\016¢\006\002\n\000¨\006c"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Arraylist;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "scale", "", "side", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;", "(DDFLnet/ccbluex/liquidbounce/ui/client/hud/element/Side;)V", "abcOrder", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "animationSpeed", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "backgroundColorAlphaValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "backgroundColorBlueValue", "backgroundColorGreenValue", "backgroundColorRedValue", "blur", "blurStrength", "brightnessValue", "cRainbowDistValue", "cRainbowSecValue", "caseValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "colorAlphaValue", "getColorAlphaValue", "()Lnet/ccbluex/liquidbounce/value/IntegerValue;", "colorBlueValue", "getColorBlueValue", "colorGreenValue", "getColorGreenValue", "colorModeValue", "colorRedValue", "getColorRedValue", "fadeDistanceValue", "fontRenderer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;", "kotlin.jvm.PlatformType", "getFontRenderer", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;", "setFontRenderer", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;)V", "fontValue", "Lnet/ccbluex/liquidbounce/value/FontValue;", "gidentspeed", "hAnimation", "leftrad", "leftx2", "liquidSlowlyDistanceValue", "modules", "", "Lnet/ccbluex/liquidbounce/features/module/Module;", "nameBreak", "newbackground", "rcolorAlpha", "getRcolorAlpha", "rcolorBlueValue", "getRcolorBlueValue", "rcolorGreenValue", "getRcolorGreenValue", "rcolorRedValue", "getRcolorRedValue", "rectLeftValue", "rectRightValue", "rectcolor", "rightx2", "saturationValue", "shadow", "shadowColorBlueValue", "shadowColorGreenValue", "shadowColorMode", "shadowColorRedValue", "shadowNoCutValue", "shadowShaderValue", "shadowStrength", "shadowalpha", "skyDistanceValue", "sortedModules", "spaceValue", "tags", "tagsArrayColor", "tagsStyleValue", "textHeightValue", "textYValue", "vAnimation", "x2", "", "y2", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "getModName", "", "mod", "getModTag", "m", "updateElement", "", "XSJClient"})
/*     */ public final class Arraylist extends Element {
/*     */   private final ListValue colorModeValue;
/*     */   private final BoolValue blur;
/*     */   private final FloatValue blurStrength;
/*     */   private final BoolValue shadow;
/*     */   private final BoolValue shadowShaderValue;
/*     */   private final BoolValue shadowNoCutValue;
/*     */   private final IntegerValue shadowStrength;
/*     */   
/*     */   public Arraylist(double x, double y, float scale, @NotNull Side side) {
/*  32 */     super(x, y, scale, side);
/*  33 */     this.colorModeValue = new ListValue("Color", new String[] { "Custom", "Random", "Sky", "CRainbow", "LiquidSlowly", "Fade", "Gradinet" }, "Gradinet");
/*  34 */     this.blur = new BoolValue("Blur", true);
/*  35 */     this.blurStrength = new FloatValue("Blur-Strength", 0.0F, 0.0F, 50.0F);
/*  36 */     this.shadow = new BoolValue("ShadowText", true);
/*  37 */     this.shadowShaderValue = new BoolValue("Shadow", false);
/*  38 */     this.shadowNoCutValue = new BoolValue("Shadow-NoCut", false);
/*  39 */     this.shadowStrength = new IntegerValue("Shadow-Strength", 1, 1, 30);
/*  40 */     this.shadowColorMode = new ListValue("Shadow-Color", new String[] { "Background", "Text", "Custom" }, "Background");
/*  41 */     this.shadowColorRedValue = new IntegerValue("Shadow-Red", 0, 0, 255);
/*  42 */     this.shadowColorGreenValue = new IntegerValue("Shadow-Green", 111, 0, 255);
/*  43 */     this.shadowColorBlueValue = new IntegerValue("Shadow-Blue", 255, 0, 255);
/*  44 */     this.shadowalpha = new IntegerValue("Shadow-Alpha", 255, 0, 255);
/*     */     
/*  46 */     this.colorRedValue = new IntegerValue("Red", 0, 0, 255);
/*  47 */     this.colorGreenValue = new IntegerValue("Green", 111, 0, 255);
/*  48 */     this.colorBlueValue = new IntegerValue("Blue", 255, 0, 255);
/*     */     
/*  50 */     this.rcolorRedValue = new IntegerValue("Rect-Red", 0, 255, 255);
/*  51 */     this.rcolorGreenValue = new IntegerValue("Rect-Green", 255, 0, 255);
/*  52 */     this.rcolorBlueValue = new IntegerValue("Rect-Blue", 255, 0, 255);
/*  53 */     this.rcolorAlpha = new IntegerValue("Rect-Alpha", 255, 0, 255);
/*     */     
/*  55 */     this.gidentspeed = new IntegerValue("GidentSpeed", 100, 1, 1000);
/*  56 */     this.colorAlphaValue = new IntegerValue("Alpha", 255, 0, 255);
/*     */ 
/*     */     
/*  59 */     this.saturationValue = new FloatValue("Saturation", 0.9F, 0.0F, 1.0F);
/*  60 */     this.brightnessValue = new FloatValue("Brightness", 1.0F, 0.0F, 1.0F);
/*  61 */     this.skyDistanceValue = new IntegerValue("Sky-Distance", 2, 0, 4);
/*  62 */     this.cRainbowSecValue = new IntegerValue("CRainbow-Seconds", 2, 1, 10);
/*  63 */     this.cRainbowDistValue = new IntegerValue("CRainbow-Distance", 2, 1, 6);
/*  64 */     this.liquidSlowlyDistanceValue = new IntegerValue("LiquidSlowly-Distance", 90, 1, 90);
/*  65 */     this.fadeDistanceValue = new IntegerValue("Fade-Distance", 50, 1, 100);
/*  66 */     this.hAnimation = new ListValue("HorizontalAnimation", new String[] { "Default", "None", "Slide", "Astolfo" }, "None");
/*  67 */     this.vAnimation = new ListValue("VerticalAnimation", new String[] { "None", "LiquidSense", "Slide", "Rise", "Astolfo" }, "None");
/*  68 */     this.animationSpeed = new FloatValue("Animation-Speed", 0.25F, 0.01F, 1.0F);
/*  69 */     this.nameBreak = new BoolValue("NameBreak", false);
/*  70 */     this.abcOrder = new BoolValue("Alphabetical-Order", false);
/*  71 */     this.tags = new BoolValue("Tags", true);
/*  72 */     this.tagsStyleValue = new ListValue("TagsStyle", new String[] { "-", "|", "()", "[]", "<>", "Default" }, "()");
/*  73 */     this.newbackground = new ListValue("NewBackgroundMode", new String[] { "New", "Normal" }, "Normal");
/*  74 */     this.backgroundColorRedValue = new IntegerValue("Background-R", 0, 0, 255);
/*  75 */     this.backgroundColorGreenValue = new IntegerValue("Background-G", 0, 0, 255);
/*  76 */     this.backgroundColorBlueValue = new IntegerValue("Background-B", 0, 0, 255);
/*  77 */     this.backgroundColorAlphaValue = new IntegerValue("Background-Alpha", 0, 0, 255);
/*  78 */     this.rectcolor = new ListValue("RectColor", new String[] { "Custom", "Text" }, "Text");
/*  79 */     this.rectRightValue = new ListValue("Rect-Right", new String[] { "None", "Left", "NormalLeft", "Right", "Outline", "Special", "Top", "Rise" }, "None");
/*     */     
/*  81 */     this.leftrad = new FloatValue("Rect-LeftRadius", 2.0F, 0.0F, 5.0F);
/*  82 */     this.leftx2 = new FloatValue("Rect-LeftWidth", 2.0F, 0.0F, 5.0F);
/*  83 */     this.rightx2 = new FloatValue("Rect-RightWidth", 0.0F, 0.0F, 5.0F);
/*  84 */     this.rectLeftValue = new ListValue("Rect-Left", new String[] { "None", "Left", "Right" }, "None");
/*  85 */     this.caseValue = new ListValue("Case", new String[] { "None", "Lower", "Upper" }, "None");
/*  86 */     this.spaceValue = new FloatValue("Space", 0.0F, 0.0F, 5.0F);
/*  87 */     this.textHeightValue = new FloatValue("TextHeight", 11.0F, 1.0F, 20.0F);
/*  88 */     this.textYValue = new FloatValue("TextY", 2.62F, 0.0F, 20.0F);
/*  89 */     this.tagsArrayColor = new BoolValue("TagsArrayColor", false);
/*  90 */     Intrinsics.checkExpressionValueIsNotNull(Fonts.posterama30, "Fonts.posterama30"); this.fontValue = new FontValue("Font", Fonts.posterama30);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  96 */     this.modules = CollectionsKt.emptyList();
/*  97 */     this.sortedModules = CollectionsKt.emptyList();
/*     */     
/*  99 */     this.fontRenderer = Fonts.posterama30;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final ListValue shadowColorMode;
/*     */ 
/*     */   
/*     */   private final IntegerValue shadowColorRedValue;
/*     */ 
/*     */   
/*     */   private final IntegerValue shadowColorGreenValue;
/*     */ 
/*     */   
/*     */   private final IntegerValue shadowColorBlueValue;
/*     */ 
/*     */   
/*     */   private final IntegerValue shadowalpha;
/*     */   
/*     */   @NotNull
/*     */   private final IntegerValue colorRedValue;
/*     */   
/*     */   @NotNull
/*     */   private final IntegerValue colorGreenValue;
/*     */   
/*     */   @NotNull
/*     */   private final IntegerValue colorBlueValue;
/*     */   
/*     */   @NotNull
/*     */   private final IntegerValue rcolorRedValue;
/*     */   
/*     */   @NotNull
/*     */   private final IntegerValue rcolorGreenValue;
/*     */   
/*     */   @NotNull
/*     */   private final IntegerValue rcolorBlueValue;
/*     */   
/*     */   @NotNull
/*     */   private final IntegerValue rcolorAlpha;
/*     */   
/*     */   private final IntegerValue gidentspeed;
/*     */   
/*     */   @NotNull
/*     */   private final IntegerValue colorAlphaValue;
/*     */   
/*     */   private final FloatValue saturationValue;
/*     */   
/*     */   private final FloatValue brightnessValue;
/*     */   
/*     */   private final IntegerValue skyDistanceValue;
/*     */   
/*     */   private final IntegerValue cRainbowSecValue;
/*     */   
/*     */   private final IntegerValue cRainbowDistValue;
/*     */   
/*     */   private final IntegerValue liquidSlowlyDistanceValue;
/*     */   
/*     */   private final IntegerValue fadeDistanceValue;
/*     */   
/*     */   private final ListValue hAnimation;
/*     */   
/*     */   private final ListValue vAnimation;
/*     */   
/*     */   private final FloatValue animationSpeed;
/*     */   
/*     */   private final BoolValue nameBreak;
/*     */   
/*     */   private final BoolValue abcOrder;
/*     */   
/*     */   private final BoolValue tags;
/*     */   
/*     */   private final ListValue tagsStyleValue;
/*     */   
/*     */   private final ListValue newbackground;
/*     */   
/*     */   private final IntegerValue backgroundColorRedValue;
/*     */   
/*     */   private final IntegerValue backgroundColorGreenValue;
/*     */   
/*     */   private final IntegerValue backgroundColorBlueValue;
/*     */   
/*     */   private final IntegerValue backgroundColorAlphaValue;
/*     */   
/*     */   private final ListValue rectcolor;
/*     */   
/*     */   private final ListValue rectRightValue;
/*     */   
/*     */   private final FloatValue leftrad;
/*     */   
/*     */   private final FloatValue leftx2;
/*     */   
/*     */   private final FloatValue rightx2;
/*     */   
/*     */   private final ListValue rectLeftValue;
/*     */   
/*     */   private final ListValue caseValue;
/*     */   
/*     */   private final FloatValue spaceValue;
/*     */   
/*     */   private final FloatValue textHeightValue;
/*     */   
/*     */   private final FloatValue textYValue;
/*     */   
/*     */   private final BoolValue tagsArrayColor;
/*     */   
/*     */   private final FontValue fontValue;
/*     */   
/*     */   private int x2;
/*     */   
/*     */   private float y2;
/*     */   
/*     */   private List<? extends Module> modules;
/*     */   
/*     */   private List<? extends Module> sortedModules;
/*     */   
/*     */   private IFontRenderer fontRenderer;
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class Arraylist$drawElement$1
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     Arraylist$drawElement$1(float param1Float1, IFontRenderer param1IFontRenderer, float param1Float2, float param1Float3, int[] param1ArrayOfint, String param1String, int param1Int) {
/*     */       super(0);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void invoke()
/*     */     {
/* 229 */       GL11.glPushMatrix();
/* 230 */       GL11.glTranslated(Arraylist.this.getRenderX(), Arraylist.this.getRenderY(), 0.0D);
/* 231 */       Iterable $this$forEachIndexed$iv = Arraylist.this.modules; int $i$f$forEachIndexed = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 720 */       int index$iv = 0;
/* 721 */       Iterator iterator = $this$forEachIndexed$iv.iterator(); if (iterator.hasNext()) { Object item$iv = iterator.next(); int i = index$iv++; boolean bool = false; if (i < 0) CollectionsKt.throwIndexOverflow();  int j = i; Module module = (Module)item$iv; int index = j, $i$a$-forEachIndexed-Arraylist$drawElement$1$1 = 0; float xPos = -module.getSlide() - 2; }  GL11.glPopMatrix(); this.$counter[0] = 0; } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class Arraylist$drawElement$2 extends Lambda implements Function0<Unit> { public final void invoke() { int index$iv; Iterator iterator; if (!((Boolean)Arraylist.this.shadowNoCutValue.get()).booleanValue()) { GL11.glPushMatrix(); GL11.glTranslated(Arraylist.this.getRenderX(), Arraylist.this.getRenderY(), 0.0D); Iterable $this$forEachIndexed$iv = Arraylist.this.modules; int $i$f$forEachIndexed = 0; index$iv = 0; iterator = $this$forEachIndexed$iv.iterator(); } else { return; }  if (iterator.hasNext()) { Object item$iv = iterator.next(); int i = index$iv++; boolean bool = false; if (i < 0) CollectionsKt.throwIndexOverflow();  int j = i; Module module = (Module)item$iv; int index = j, $i$a$-forEachIndexed-Arraylist$drawElement$2$1 = 0; float xPos = -module.getSlide() - 2; }  GL11.glPopMatrix(); } Arraylist$drawElement$2(float param1Float) { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class Arraylist$drawElement$4 extends Lambda implements Function0<Unit> { public final void invoke() { Iterable $this$forEachIndexed$iv = Arraylist.this.modules; int $i$f$forEachIndexed = 0; int index$iv = 0; Iterator iterator = $this$forEachIndexed$iv.iterator(); if (iterator.hasNext()) { Object item$iv = iterator.next(); int i = index$iv++; boolean bool = false; if (i < 0) CollectionsKt.throwIndexOverflow();  int j = i; Module module = (Module)item$iv; int index = j, $i$a$-forEachIndexed-Arraylist$drawElement$4$1 = 0; float xPos = -module.getSlide() - 2; }  } Arraylist$drawElement$4(float param1Float1, float param1Float2, float param1Float3) { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class Arraylist$drawElement$6 extends Lambda implements Function0<Unit> { Arraylist$drawElement$6(IFontRenderer param1IFontRenderer, float param1Float1, float param1Float2, float param1Float3, int[] param1ArrayOfint, String param1String, int param1Int) { super(0); } public final void invoke() { GL11.glPushMatrix(); GL11.glTranslated(Arraylist.this.getRenderX(), Arraylist.this.getRenderY(), 0.0D); Iterable $this$forEachIndexed$iv = Arraylist.this.modules; int $i$f$forEachIndexed = 0; int index$iv = 0; Iterator iterator = $this$forEachIndexed$iv.iterator(); if (iterator.hasNext()) { Object item$iv = iterator.next(); int i = index$iv++; boolean bool = false; if (i < 0) CollectionsKt.throwIndexOverflow();  int j = i; Module module = (Module)item$iv; int index = j, $i$a$-forEachIndexed-Arraylist$drawElement$6$1 = 0; String displayString = Arraylist.this.getModName(module); int width = this.$fontRenderer.getStringWidth(displayString); }  GL11.glPopMatrix(); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class Arraylist$drawElement$7 extends Lambda implements Function0<Unit> { public final void invoke() { int index$iv; Iterator iterator; if (!((Boolean)Arraylist.this.shadowNoCutValue.get()).booleanValue()) { GL11.glPushMatrix(); GL11.glTranslated(Arraylist.this.getRenderX(), Arraylist.this.getRenderY(), 0.0D); Iterable $this$forEachIndexed$iv = Arraylist.this.modules; int $i$f$forEachIndexed = 0; index$iv = 0; iterator = $this$forEachIndexed$iv.iterator(); } else { return; }  if (iterator.hasNext()) { Object item$iv = iterator.next(); int i = index$iv++; boolean bool = false; if (i < 0) CollectionsKt.throwIndexOverflow();  int j = i; Module module = (Module)item$iv; int index = j, $i$a$-forEachIndexed-Arraylist$drawElement$7$1 = 0; String displayString = Arraylist.this.getModName(module); int width = this.$fontRenderer.getStringWidth(displayString); }  GL11.glPopMatrix(); } Arraylist$drawElement$7(IFontRenderer param1IFontRenderer, float param1Float) { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class Arraylist$drawElement$9 extends Lambda implements Function0<Unit> { public final void invoke() { Iterable $this$forEachIndexed$iv = Arraylist.this.modules; int $i$f$forEachIndexed = 0; int index$iv = 0; Iterator iterator = $this$forEachIndexed$iv.iterator(); if (iterator.hasNext()) { Object item$iv = iterator.next(); int i = index$iv++; boolean bool = false; if (i < 0) CollectionsKt.throwIndexOverflow();  int j = i; Module module = (Module)item$iv; int index = j, $i$a$-forEachIndexed-Arraylist$drawElement$9$1 = 0;
/*     */         String displayString = Arraylist.this.getModName(module);
/*     */         int width = this.$fontRenderer.getStringWidth(displayString); }
/*     */        } Arraylist$drawElement$9(IFontRenderer param1IFontRenderer, float param1Float1, float param1Float2, float param1Float3) { super(0); } }
/*     */   @NotNull public final IntegerValue getColorRedValue() { return this.colorRedValue; }
/*     */   @NotNull
/*     */   public final IntegerValue getColorGreenValue() { return this.colorGreenValue; }
/*     */   public void updateElement() { Module it;
/*     */     TreeSet treeSet1 = Retreat.INSTANCE.getModuleManager().getModules();
/*     */     Arraylist arraylist = this;
/*     */     int $i$f$filter = 0;
/* 732 */     TreeSet treeSet2 = treeSet1; Collection destination$iv$iv = new ArrayList(); int $i$f$filterTo = 0;
/* 733 */     for (Object element$iv$iv : treeSet2) { it = (Module)element$iv$iv; int $i$a$-filter-Arraylist$updateElement$1 = 0; }
/* 734 */      List<? extends Module> list = (List)destination$iv$iv; Iterable<? extends Module> $this$filter$iv = Retreat.INSTANCE.getModuleManager().getModules(); arraylist = this; $i$f$filter = 0;
/* 735 */     Iterable<? extends Module> $this$filterTo$iv$iv = $this$filter$iv; destination$iv$iv = new ArrayList(); $i$f$filterTo = 0;
/* 736 */     for (Object element$iv$iv : $this$filterTo$iv$iv) { it = (Module)element$iv$iv; int $i$a$-filter-Arraylist$updateElement$2 = 0; }
/* 737 */      $this$filter$iv = list = (List)destination$iv$iv; arraylist = arraylist; int $i$f$sortedBy = 0;
/* 738 */     $this$filterTo$iv$iv = $this$filter$iv; boolean bool = false; Arraylist$updateElement$$inlined$sortedBy$1 arraylist$updateElement$$inlined$sortedBy$1 = new Arraylist$updateElement$$inlined$sortedBy$1(this); list = CollectionsKt.sortedWith($this$filterTo$iv$iv, arraylist$updateElement$$inlined$sortedBy$1); arraylist.modules = ((Boolean)this.abcOrder.get()).booleanValue() ? list : list; Iterable<? extends Module> $this$sortedBy$iv = Retreat.INSTANCE.getModuleManager().getModules(); arraylist = this; $i$f$sortedBy = 0;
/* 739 */     $this$filterTo$iv$iv = $this$sortedBy$iv; bool = false; Arraylist$updateElement$$inlined$sortedBy$2 arraylist$updateElement$$inlined$sortedBy$2 = new Arraylist$updateElement$$inlined$sortedBy$2(this); list = CollectionsKt.sortedWith($this$filterTo$iv$iv, arraylist$updateElement$$inlined$sortedBy$2); arraylist.sortedModules = ((Boolean)this.abcOrder.get()).booleanValue() ? CollectionsKt.toList(Retreat.INSTANCE.getModuleManager().getModules()) : CollectionsKt.toList(list); }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public final IntegerValue getColorBlueValue() {
/*     */     return this.colorBlueValue;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final IntegerValue getRcolorRedValue() {
/*     */     return this.rcolorRedValue;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final IntegerValue getRcolorGreenValue() {
/*     */     return this.rcolorGreenValue;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final IntegerValue getRcolorBlueValue() {
/*     */     return this.rcolorBlueValue;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final IntegerValue getRcolorAlpha() {
/*     */     return this.rcolorAlpha;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final IntegerValue getColorAlphaValue() {
/*     */     return this.colorAlphaValue;
/*     */   }
/*     */   
/*     */   public final IFontRenderer getFontRenderer() {
/*     */     return this.fontRenderer;
/*     */   }
/*     */   
/*     */   public final void setFontRenderer(IFontRenderer <set-?>) {
/*     */     this.fontRenderer = <set-?>;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public Border drawElement() {
/*     */     // Byte code:
/*     */     //   0: iconst_0
/*     */     //   1: iconst_0
/*     */     //   2: iconst_0
/*     */     //   3: iconst_0
/*     */     //   4: iconst_0
/*     */     //   5: invokestatic func_73734_a : (IIIII)V
/*     */     //   8: aload_0
/*     */     //   9: getfield fontValue : Lnet/ccbluex/liquidbounce/value/FontValue;
/*     */     //   12: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   15: checkcast net/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer
/*     */     //   18: astore_1
/*     */     //   19: iconst_1
/*     */     //   20: newarray int
/*     */     //   22: dup
/*     */     //   23: iconst_0
/*     */     //   24: iconst_0
/*     */     //   25: iastore
/*     */     //   26: astore_2
/*     */     //   27: getstatic net/ccbluex/liquidbounce/ui/font/AWTFontRenderer.Companion : Lnet/ccbluex/liquidbounce/ui/font/AWTFontRenderer$Companion;
/*     */     //   30: iconst_1
/*     */     //   31: invokevirtual setAssumeNonVolatile : (Z)V
/*     */     //   34: getstatic net/ccbluex/liquidbounce/utils/render/RenderUtils.deltaTime : I
/*     */     //   37: istore_3
/*     */     //   38: aload_0
/*     */     //   39: getfield colorModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   42: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   45: checkcast java/lang/String
/*     */     //   48: astore #4
/*     */     //   50: aload_0
/*     */     //   51: getfield colorModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   54: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   57: checkcast java/lang/String
/*     */     //   60: astore #5
/*     */     //   62: new java/awt/Color
/*     */     //   65: dup
/*     */     //   66: aload_0
/*     */     //   67: getfield colorRedValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   70: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   73: checkcast java/lang/Number
/*     */     //   76: invokevirtual intValue : ()I
/*     */     //   79: aload_0
/*     */     //   80: getfield colorGreenValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   83: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   86: checkcast java/lang/Number
/*     */     //   89: invokevirtual intValue : ()I
/*     */     //   92: aload_0
/*     */     //   93: getfield colorBlueValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   96: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   99: checkcast java/lang/Number
/*     */     //   102: invokevirtual intValue : ()I
/*     */     //   105: aload_0
/*     */     //   106: getfield colorAlphaValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   109: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   112: checkcast java/lang/Number
/*     */     //   115: invokevirtual intValue : ()I
/*     */     //   118: invokespecial <init> : (IIII)V
/*     */     //   121: invokevirtual getRGB : ()I
/*     */     //   124: istore #6
/*     */     //   126: new java/awt/Color
/*     */     //   129: dup
/*     */     //   130: aload_0
/*     */     //   131: getfield colorRedValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   134: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   137: checkcast java/lang/Number
/*     */     //   140: invokevirtual intValue : ()I
/*     */     //   143: aload_0
/*     */     //   144: getfield colorGreenValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   147: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   150: checkcast java/lang/Number
/*     */     //   153: invokevirtual intValue : ()I
/*     */     //   156: aload_0
/*     */     //   157: getfield colorBlueValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   160: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   163: checkcast java/lang/Number
/*     */     //   166: invokevirtual intValue : ()I
/*     */     //   169: aload_0
/*     */     //   170: getfield colorAlphaValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   173: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   176: checkcast java/lang/Number
/*     */     //   179: invokevirtual intValue : ()I
/*     */     //   182: invokespecial <init> : (IIII)V
/*     */     //   185: invokevirtual getRGB : ()I
/*     */     //   188: istore #7
/*     */     //   190: aload_0
/*     */     //   191: getfield spaceValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   194: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   197: checkcast java/lang/Number
/*     */     //   200: invokevirtual floatValue : ()F
/*     */     //   203: fstore #8
/*     */     //   205: aload_0
/*     */     //   206: getfield textHeightValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   209: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   212: checkcast java/lang/Number
/*     */     //   215: invokevirtual floatValue : ()F
/*     */     //   218: fstore #9
/*     */     //   220: aload_0
/*     */     //   221: getfield textYValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   224: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   227: checkcast java/lang/Number
/*     */     //   230: invokevirtual floatValue : ()F
/*     */     //   233: fstore #10
/*     */     //   235: new java/awt/Color
/*     */     //   238: dup
/*     */     //   239: aload_0
/*     */     //   240: getfield backgroundColorRedValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   243: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   246: checkcast java/lang/Number
/*     */     //   249: invokevirtual intValue : ()I
/*     */     //   252: aload_0
/*     */     //   253: getfield backgroundColorGreenValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   256: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   259: checkcast java/lang/Number
/*     */     //   262: invokevirtual intValue : ()I
/*     */     //   265: aload_0
/*     */     //   266: getfield backgroundColorBlueValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   269: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   272: checkcast java/lang/Number
/*     */     //   275: invokevirtual intValue : ()I
/*     */     //   278: aload_0
/*     */     //   279: getfield backgroundColorAlphaValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   282: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   285: checkcast java/lang/Number
/*     */     //   288: invokevirtual intValue : ()I
/*     */     //   291: invokespecial <init> : (IIII)V
/*     */     //   294: invokevirtual getRGB : ()I
/*     */     //   297: istore #11
/*     */     //   299: aload_0
/*     */     //   300: getfield shadow : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   303: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   306: checkcast java/lang/Boolean
/*     */     //   309: invokevirtual booleanValue : ()Z
/*     */     //   312: istore #12
/*     */     //   314: fload #9
/*     */     //   316: fload #8
/*     */     //   318: fadd
/*     */     //   319: fstore #13
/*     */     //   321: aload_0
/*     */     //   322: getfield saturationValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   325: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   328: checkcast java/lang/Number
/*     */     //   331: invokevirtual floatValue : ()F
/*     */     //   334: fstore #14
/*     */     //   336: aload_0
/*     */     //   337: getfield brightnessValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   340: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   343: checkcast java/lang/Number
/*     */     //   346: invokevirtual floatValue : ()F
/*     */     //   349: fstore #15
/*     */     //   351: iconst_0
/*     */     //   352: istore #16
/*     */     //   354: aload_0
/*     */     //   355: getfield sortedModules : Ljava/util/List;
/*     */     //   358: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   363: astore #18
/*     */     //   365: aload #18
/*     */     //   367: invokeinterface hasNext : ()Z
/*     */     //   372: ifeq -> 1531
/*     */     //   375: aload #18
/*     */     //   377: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   382: checkcast net/ccbluex/liquidbounce/features/module/Module
/*     */     //   385: astore #17
/*     */     //   387: aload #17
/*     */     //   389: invokevirtual getArray : ()Z
/*     */     //   392: ifeq -> 969
/*     */     //   395: aload #17
/*     */     //   397: invokevirtual getState : ()Z
/*     */     //   400: ifne -> 413
/*     */     //   403: aload #17
/*     */     //   405: invokevirtual getSlide : ()F
/*     */     //   408: fconst_0
/*     */     //   409: fcmpg
/*     */     //   410: ifeq -> 969
/*     */     //   413: aload_0
/*     */     //   414: aload #17
/*     */     //   416: invokevirtual getModName : (Lnet/ccbluex/liquidbounce/features/module/Module;)Ljava/lang/String;
/*     */     //   419: astore #19
/*     */     //   421: aload_1
/*     */     //   422: aload #19
/*     */     //   424: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*     */     //   429: istore #20
/*     */     //   431: aload_0
/*     */     //   432: getfield hAnimation : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   435: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   438: checkcast java/lang/String
/*     */     //   441: astore #21
/*     */     //   443: aload #21
/*     */     //   445: invokevirtual hashCode : ()I
/*     */     //   448: lookupswitch default -> 890, -1085510111 -> 512, 79973777 -> 498, 961091784 -> 484
/*     */     //   484: aload #21
/*     */     //   486: ldc_w 'Astolfo'
/*     */     //   489: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   492: ifeq -> 890
/*     */     //   495: goto -> 526
/*     */     //   498: aload #21
/*     */     //   500: ldc_w 'Slide'
/*     */     //   503: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   506: ifeq -> 890
/*     */     //   509: goto -> 650
/*     */     //   512: aload #21
/*     */     //   514: ldc_w 'Default'
/*     */     //   517: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   520: ifeq -> 890
/*     */     //   523: goto -> 781
/*     */     //   526: aload #17
/*     */     //   528: invokevirtual getState : ()Z
/*     */     //   531: ifeq -> 584
/*     */     //   534: aload #17
/*     */     //   536: invokevirtual getSlide : ()F
/*     */     //   539: iload #20
/*     */     //   541: i2f
/*     */     //   542: fcmpg
/*     */     //   543: ifge -> 627
/*     */     //   546: aload #17
/*     */     //   548: dup
/*     */     //   549: invokevirtual getSlide : ()F
/*     */     //   552: aload_0
/*     */     //   553: getfield animationSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   556: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   559: checkcast java/lang/Number
/*     */     //   562: invokevirtual floatValue : ()F
/*     */     //   565: iload_3
/*     */     //   566: i2f
/*     */     //   567: fmul
/*     */     //   568: fadd
/*     */     //   569: invokevirtual setSlide : (F)V
/*     */     //   572: aload #17
/*     */     //   574: iload_3
/*     */     //   575: i2f
/*     */     //   576: fconst_1
/*     */     //   577: fdiv
/*     */     //   578: invokevirtual setSlideStep : (F)V
/*     */     //   581: goto -> 627
/*     */     //   584: aload #17
/*     */     //   586: invokevirtual getSlide : ()F
/*     */     //   589: iconst_0
/*     */     //   590: i2f
/*     */     //   591: fcmpl
/*     */     //   592: ifle -> 627
/*     */     //   595: aload #17
/*     */     //   597: dup
/*     */     //   598: invokevirtual getSlide : ()F
/*     */     //   601: aload_0
/*     */     //   602: getfield animationSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   605: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   608: checkcast java/lang/Number
/*     */     //   611: invokevirtual floatValue : ()F
/*     */     //   614: iload_3
/*     */     //   615: i2f
/*     */     //   616: fmul
/*     */     //   617: fsub
/*     */     //   618: invokevirtual setSlide : (F)V
/*     */     //   621: aload #17
/*     */     //   623: fconst_0
/*     */     //   624: invokevirtual setSlideStep : (F)V
/*     */     //   627: aload #17
/*     */     //   629: invokevirtual getSlide : ()F
/*     */     //   632: iload #20
/*     */     //   634: i2f
/*     */     //   635: fcmpl
/*     */     //   636: ifle -> 935
/*     */     //   639: aload #17
/*     */     //   641: iload #20
/*     */     //   643: i2f
/*     */     //   644: invokevirtual setSlide : (F)V
/*     */     //   647: goto -> 935
/*     */     //   650: aload #17
/*     */     //   652: invokevirtual getState : ()Z
/*     */     //   655: ifeq -> 721
/*     */     //   658: aload #17
/*     */     //   660: invokevirtual getSlide : ()F
/*     */     //   663: iload #20
/*     */     //   665: i2f
/*     */     //   666: fcmpg
/*     */     //   667: ifge -> 935
/*     */     //   670: aload #17
/*     */     //   672: iload #20
/*     */     //   674: i2d
/*     */     //   675: aload #17
/*     */     //   677: invokevirtual getSlide : ()F
/*     */     //   680: f2d
/*     */     //   681: aload_0
/*     */     //   682: getfield animationSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   685: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   688: checkcast java/lang/Number
/*     */     //   691: invokevirtual floatValue : ()F
/*     */     //   694: f2d
/*     */     //   695: ldc2_w 0.025
/*     */     //   698: dmul
/*     */     //   699: iload_3
/*     */     //   700: i2d
/*     */     //   701: dmul
/*     */     //   702: invokestatic animate : (DDD)D
/*     */     //   705: d2f
/*     */     //   706: invokevirtual setSlide : (F)V
/*     */     //   709: aload #17
/*     */     //   711: iload_3
/*     */     //   712: i2f
/*     */     //   713: fconst_1
/*     */     //   714: fdiv
/*     */     //   715: invokevirtual setSlideStep : (F)V
/*     */     //   718: goto -> 935
/*     */     //   721: aload #17
/*     */     //   723: invokevirtual getSlide : ()F
/*     */     //   726: iconst_0
/*     */     //   727: i2f
/*     */     //   728: fcmpl
/*     */     //   729: ifle -> 778
/*     */     //   732: aload #17
/*     */     //   734: iload #20
/*     */     //   736: i2d
/*     */     //   737: dneg
/*     */     //   738: aload #17
/*     */     //   740: invokevirtual getSlide : ()F
/*     */     //   743: f2d
/*     */     //   744: aload_0
/*     */     //   745: getfield animationSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   748: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   751: checkcast java/lang/Number
/*     */     //   754: invokevirtual floatValue : ()F
/*     */     //   757: f2d
/*     */     //   758: ldc2_w 0.025
/*     */     //   761: dmul
/*     */     //   762: iload_3
/*     */     //   763: i2d
/*     */     //   764: dmul
/*     */     //   765: invokestatic animate : (DDD)D
/*     */     //   768: d2f
/*     */     //   769: invokevirtual setSlide : (F)V
/*     */     //   772: aload #17
/*     */     //   774: fconst_0
/*     */     //   775: invokevirtual setSlideStep : (F)V
/*     */     //   778: goto -> 935
/*     */     //   781: aload #17
/*     */     //   783: invokevirtual getState : ()Z
/*     */     //   786: ifeq -> 840
/*     */     //   789: aload #17
/*     */     //   791: invokevirtual getSlide : ()F
/*     */     //   794: iload #20
/*     */     //   796: i2f
/*     */     //   797: fcmpg
/*     */     //   798: ifge -> 935
/*     */     //   801: aload #17
/*     */     //   803: aload #17
/*     */     //   805: invokevirtual getSlideStep : ()F
/*     */     //   808: iload #20
/*     */     //   810: i2f
/*     */     //   811: invokestatic easeOut : (FF)F
/*     */     //   814: iload #20
/*     */     //   816: i2f
/*     */     //   817: fmul
/*     */     //   818: invokevirtual setSlide : (F)V
/*     */     //   821: aload #17
/*     */     //   823: dup
/*     */     //   824: invokevirtual getSlideStep : ()F
/*     */     //   827: iload_3
/*     */     //   828: i2f
/*     */     //   829: ldc_w 4.0
/*     */     //   832: fdiv
/*     */     //   833: fadd
/*     */     //   834: invokevirtual setSlideStep : (F)V
/*     */     //   837: goto -> 935
/*     */     //   840: aload #17
/*     */     //   842: invokevirtual getSlide : ()F
/*     */     //   845: iconst_0
/*     */     //   846: i2f
/*     */     //   847: fcmpl
/*     */     //   848: ifle -> 887
/*     */     //   851: aload #17
/*     */     //   853: aload #17
/*     */     //   855: invokevirtual getSlideStep : ()F
/*     */     //   858: iload #20
/*     */     //   860: i2f
/*     */     //   861: invokestatic easeOut : (FF)F
/*     */     //   864: iload #20
/*     */     //   866: i2f
/*     */     //   867: fmul
/*     */     //   868: invokevirtual setSlide : (F)V
/*     */     //   871: aload #17
/*     */     //   873: dup
/*     */     //   874: invokevirtual getSlideStep : ()F
/*     */     //   877: iload_3
/*     */     //   878: i2f
/*     */     //   879: ldc_w 4.0
/*     */     //   882: fdiv
/*     */     //   883: fsub
/*     */     //   884: invokevirtual setSlideStep : (F)V
/*     */     //   887: goto -> 935
/*     */     //   890: aload #17
/*     */     //   892: aload #17
/*     */     //   894: invokevirtual getState : ()Z
/*     */     //   897: ifeq -> 906
/*     */     //   900: iload #20
/*     */     //   902: i2f
/*     */     //   903: goto -> 907
/*     */     //   906: fconst_0
/*     */     //   907: invokevirtual setSlide : (F)V
/*     */     //   910: aload #17
/*     */     //   912: dup
/*     */     //   913: invokevirtual getSlideStep : ()F
/*     */     //   916: aload #17
/*     */     //   918: invokevirtual getState : ()Z
/*     */     //   921: ifeq -> 928
/*     */     //   924: iload_3
/*     */     //   925: goto -> 930
/*     */     //   928: iload_3
/*     */     //   929: ineg
/*     */     //   930: i2f
/*     */     //   931: fadd
/*     */     //   932: invokevirtual setSlideStep : (F)V
/*     */     //   935: aload #17
/*     */     //   937: aload #17
/*     */     //   939: invokevirtual getSlide : ()F
/*     */     //   942: fconst_0
/*     */     //   943: iload #20
/*     */     //   945: i2f
/*     */     //   946: invokestatic coerceIn : (FFF)F
/*     */     //   949: invokevirtual setSlide : (F)V
/*     */     //   952: aload #17
/*     */     //   954: aload #17
/*     */     //   956: invokevirtual getSlideStep : ()F
/*     */     //   959: fconst_0
/*     */     //   960: iload #20
/*     */     //   962: i2f
/*     */     //   963: invokestatic coerceIn : (FFF)F
/*     */     //   966: invokevirtual setSlideStep : (F)V
/*     */     //   969: aload_0
/*     */     //   970: invokevirtual getSide : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;
/*     */     //   973: invokevirtual getVertical : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;
/*     */     //   976: getstatic net/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical.DOWN : Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;
/*     */     //   979: if_acmpne -> 988
/*     */     //   982: fload #13
/*     */     //   984: fneg
/*     */     //   985: goto -> 990
/*     */     //   988: fload #13
/*     */     //   990: aload_0
/*     */     //   991: invokevirtual getSide : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;
/*     */     //   994: invokevirtual getVertical : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;
/*     */     //   997: getstatic net/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical.DOWN : Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;
/*     */     //   1000: if_acmpne -> 1010
/*     */     //   1003: iload #16
/*     */     //   1005: iconst_1
/*     */     //   1006: iadd
/*     */     //   1007: goto -> 1012
/*     */     //   1010: iload #16
/*     */     //   1012: i2f
/*     */     //   1013: fmul
/*     */     //   1014: fstore #19
/*     */     //   1016: aload #17
/*     */     //   1018: invokevirtual getArray : ()Z
/*     */     //   1021: ifeq -> 1501
/*     */     //   1024: aload #17
/*     */     //   1026: invokevirtual getSlide : ()F
/*     */     //   1029: fconst_0
/*     */     //   1030: fcmpl
/*     */     //   1031: ifle -> 1501
/*     */     //   1034: aload_0
/*     */     //   1035: getfield vAnimation : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   1038: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1041: checkcast java/lang/String
/*     */     //   1044: ldc_w 'Rise'
/*     */     //   1047: iconst_1
/*     */     //   1048: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   1051: ifeq -> 1075
/*     */     //   1054: aload #17
/*     */     //   1056: invokevirtual getState : ()Z
/*     */     //   1059: ifne -> 1075
/*     */     //   1062: aload_1
/*     */     //   1063: invokeinterface getFontHeight : ()I
/*     */     //   1068: ineg
/*     */     //   1069: i2f
/*     */     //   1070: fload #10
/*     */     //   1072: fsub
/*     */     //   1073: fstore #19
/*     */     //   1075: aload_0
/*     */     //   1076: getfield modules : Ljava/util/List;
/*     */     //   1079: invokeinterface size : ()I
/*     */     //   1084: i2f
/*     */     //   1085: ldc_w 0.02
/*     */     //   1088: fmul
/*     */     //   1089: fstore #20
/*     */     //   1091: aload_0
/*     */     //   1092: getfield vAnimation : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   1095: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1098: checkcast java/lang/String
/*     */     //   1101: astore #21
/*     */     //   1103: aload #21
/*     */     //   1105: invokevirtual hashCode : ()I
/*     */     //   1108: lookupswitch default -> 1488, -1275652174 -> 1166, 2547433 -> 1194, 79973777 -> 1180, 961091784 -> 1152
/*     */     //   1152: aload #21
/*     */     //   1154: ldc_w 'Astolfo'
/*     */     //   1157: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1160: ifeq -> 1488
/*     */     //   1163: goto -> 1385
/*     */     //   1166: aload #21
/*     */     //   1168: ldc_w 'LiquidSense'
/*     */     //   1171: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1174: ifeq -> 1488
/*     */     //   1177: goto -> 1208
/*     */     //   1180: aload #21
/*     */     //   1182: ldc_w 'Slide'
/*     */     //   1185: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1188: ifeq -> 1488
/*     */     //   1191: goto -> 1343
/*     */     //   1194: aload #21
/*     */     //   1196: ldc_w 'Rise'
/*     */     //   1199: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1202: ifeq -> 1488
/*     */     //   1205: goto -> 1343
/*     */     //   1208: aload #17
/*     */     //   1210: invokevirtual getState : ()Z
/*     */     //   1213: ifeq -> 1495
/*     */     //   1216: aload #17
/*     */     //   1218: invokevirtual getHigt : ()F
/*     */     //   1221: fload #19
/*     */     //   1223: fcmpg
/*     */     //   1224: ifge -> 1285
/*     */     //   1227: aload #17
/*     */     //   1229: dup
/*     */     //   1230: invokevirtual getHigt : ()F
/*     */     //   1233: fload #20
/*     */     //   1235: aload #17
/*     */     //   1237: invokevirtual getHigt : ()F
/*     */     //   1240: ldc_w 0.002
/*     */     //   1243: fmul
/*     */     //   1244: fload #20
/*     */     //   1246: aload #17
/*     */     //   1248: invokevirtual getHigt : ()F
/*     */     //   1251: ldc_w 1.0E-4
/*     */     //   1254: fmul
/*     */     //   1255: fsub
/*     */     //   1256: invokestatic min : (FF)F
/*     */     //   1259: fsub
/*     */     //   1260: iload_3
/*     */     //   1261: i2f
/*     */     //   1262: fmul
/*     */     //   1263: fadd
/*     */     //   1264: invokevirtual setHigt : (F)V
/*     */     //   1267: aload #17
/*     */     //   1269: fload #19
/*     */     //   1271: aload #17
/*     */     //   1273: invokevirtual getHigt : ()F
/*     */     //   1276: invokestatic min : (FF)F
/*     */     //   1279: invokevirtual setHigt : (F)V
/*     */     //   1282: goto -> 1495
/*     */     //   1285: aload #17
/*     */     //   1287: dup
/*     */     //   1288: invokevirtual getHigt : ()F
/*     */     //   1291: fload #20
/*     */     //   1293: aload #17
/*     */     //   1295: invokevirtual getHigt : ()F
/*     */     //   1298: ldc_w 0.002
/*     */     //   1301: fmul
/*     */     //   1302: fload #20
/*     */     //   1304: aload #17
/*     */     //   1306: invokevirtual getHigt : ()F
/*     */     //   1309: ldc_w 1.0E-4
/*     */     //   1312: fmul
/*     */     //   1313: fsub
/*     */     //   1314: invokestatic min : (FF)F
/*     */     //   1317: fsub
/*     */     //   1318: iload_3
/*     */     //   1319: i2f
/*     */     //   1320: fmul
/*     */     //   1321: fsub
/*     */     //   1322: invokevirtual setHigt : (F)V
/*     */     //   1325: aload #17
/*     */     //   1327: aload #17
/*     */     //   1329: invokevirtual getHigt : ()F
/*     */     //   1332: fload #19
/*     */     //   1334: invokestatic max : (FF)F
/*     */     //   1337: invokevirtual setHigt : (F)V
/*     */     //   1340: goto -> 1495
/*     */     //   1343: aload #17
/*     */     //   1345: fload #19
/*     */     //   1347: f2d
/*     */     //   1348: aload #17
/*     */     //   1350: invokevirtual getHigt : ()F
/*     */     //   1353: f2d
/*     */     //   1354: aload_0
/*     */     //   1355: getfield animationSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1358: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1361: checkcast java/lang/Number
/*     */     //   1364: invokevirtual floatValue : ()F
/*     */     //   1367: f2d
/*     */     //   1368: ldc2_w 0.025
/*     */     //   1371: dmul
/*     */     //   1372: iload_3
/*     */     //   1373: i2d
/*     */     //   1374: dmul
/*     */     //   1375: invokestatic animate : (DDD)D
/*     */     //   1378: d2f
/*     */     //   1379: invokevirtual setHigt : (F)V
/*     */     //   1382: goto -> 1495
/*     */     //   1385: aload #17
/*     */     //   1387: invokevirtual getHigt : ()F
/*     */     //   1390: fload #19
/*     */     //   1392: fcmpg
/*     */     //   1393: ifge -> 1442
/*     */     //   1396: aload #17
/*     */     //   1398: dup
/*     */     //   1399: invokevirtual getHigt : ()F
/*     */     //   1402: aload_0
/*     */     //   1403: getfield animationSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1406: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1409: checkcast java/lang/Number
/*     */     //   1412: invokevirtual floatValue : ()F
/*     */     //   1415: fconst_2
/*     */     //   1416: fdiv
/*     */     //   1417: iload_3
/*     */     //   1418: i2f
/*     */     //   1419: fmul
/*     */     //   1420: fadd
/*     */     //   1421: invokevirtual setHigt : (F)V
/*     */     //   1424: aload #17
/*     */     //   1426: fload #19
/*     */     //   1428: aload #17
/*     */     //   1430: invokevirtual getHigt : ()F
/*     */     //   1433: invokestatic min : (FF)F
/*     */     //   1436: invokevirtual setHigt : (F)V
/*     */     //   1439: goto -> 1495
/*     */     //   1442: aload #17
/*     */     //   1444: dup
/*     */     //   1445: invokevirtual getHigt : ()F
/*     */     //   1448: aload_0
/*     */     //   1449: getfield animationSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1452: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1455: checkcast java/lang/Number
/*     */     //   1458: invokevirtual floatValue : ()F
/*     */     //   1461: fconst_2
/*     */     //   1462: fdiv
/*     */     //   1463: iload_3
/*     */     //   1464: i2f
/*     */     //   1465: fmul
/*     */     //   1466: fsub
/*     */     //   1467: invokevirtual setHigt : (F)V
/*     */     //   1470: aload #17
/*     */     //   1472: aload #17
/*     */     //   1474: invokevirtual getHigt : ()F
/*     */     //   1477: fload #19
/*     */     //   1479: invokestatic max : (FF)F
/*     */     //   1482: invokevirtual setHigt : (F)V
/*     */     //   1485: goto -> 1495
/*     */     //   1488: aload #17
/*     */     //   1490: fload #19
/*     */     //   1492: invokevirtual setHigt : (F)V
/*     */     //   1495: iinc #16, 1
/*     */     //   1498: goto -> 1528
/*     */     //   1501: aload_0
/*     */     //   1502: getfield vAnimation : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   1505: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1508: checkcast java/lang/String
/*     */     //   1511: ldc_w 'rise'
/*     */     //   1514: iconst_1
/*     */     //   1515: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   1518: ifne -> 1528
/*     */     //   1521: aload #17
/*     */     //   1523: fload #19
/*     */     //   1525: invokevirtual setHigt : (F)V
/*     */     //   1528: goto -> 365
/*     */     //   1531: aload_0
/*     */     //   1532: invokevirtual getSide : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;
/*     */     //   1535: invokevirtual getHorizontal : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Horizontal;
/*     */     //   1538: getstatic net/ccbluex/liquidbounce/ui/client/hud/element/elements/Arraylist$WhenMappings.$EnumSwitchMapping$0 : [I
/*     */     //   1541: swap
/*     */     //   1542: invokevirtual ordinal : ()I
/*     */     //   1545: iaload
/*     */     //   1546: tableswitch default -> 6483, 1 -> 1572, 2 -> 1572, 3 -> 4728
/*     */     //   1572: aload_0
/*     */     //   1573: getfield shadowShaderValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1576: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1579: checkcast java/lang/Boolean
/*     */     //   1582: invokevirtual booleanValue : ()Z
/*     */     //   1585: ifeq -> 1673
/*     */     //   1588: aload_0
/*     */     //   1589: invokevirtual getRenderX : ()D
/*     */     //   1592: dneg
/*     */     //   1593: aload_0
/*     */     //   1594: invokevirtual getRenderY : ()D
/*     */     //   1597: dneg
/*     */     //   1598: dconst_0
/*     */     //   1599: invokestatic glTranslated : (DDD)V
/*     */     //   1602: invokestatic glPushMatrix : ()V
/*     */     //   1605: aload_0
/*     */     //   1606: getfield shadowStrength : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1609: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1612: checkcast java/lang/Number
/*     */     //   1615: invokevirtual intValue : ()I
/*     */     //   1618: i2f
/*     */     //   1619: new net/ccbluex/liquidbounce/ui/client/hud/element/elements/Arraylist$drawElement$1
/*     */     //   1622: dup
/*     */     //   1623: aload_0
/*     */     //   1624: fload #9
/*     */     //   1626: aload_1
/*     */     //   1627: fload #14
/*     */     //   1629: fload #15
/*     */     //   1631: aload_2
/*     */     //   1632: aload #4
/*     */     //   1634: iload #6
/*     */     //   1636: invokespecial <init> : (Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Arraylist;FLnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;FF[ILjava/lang/String;I)V
/*     */     //   1639: checkcast kotlin/jvm/functions/Function0
/*     */     //   1642: new net/ccbluex/liquidbounce/ui/client/hud/element/elements/Arraylist$drawElement$2
/*     */     //   1645: dup
/*     */     //   1646: aload_0
/*     */     //   1647: fload #9
/*     */     //   1649: invokespecial <init> : (Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Arraylist;F)V
/*     */     //   1652: checkcast kotlin/jvm/functions/Function0
/*     */     //   1655: invokestatic shadow : (FLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V
/*     */     //   1658: invokestatic glPopMatrix : ()V
/*     */     //   1661: aload_0
/*     */     //   1662: invokevirtual getRenderX : ()D
/*     */     //   1665: aload_0
/*     */     //   1666: invokevirtual getRenderY : ()D
/*     */     //   1669: dconst_0
/*     */     //   1670: invokestatic glTranslated : (DDD)V
/*     */     //   1673: aload_0
/*     */     //   1674: getfield blur : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1677: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1680: checkcast java/lang/Boolean
/*     */     //   1683: invokevirtual booleanValue : ()Z
/*     */     //   1686: ifeq -> 1959
/*     */     //   1689: aload_0
/*     */     //   1690: invokevirtual getRenderX : ()D
/*     */     //   1693: dneg
/*     */     //   1694: aload_0
/*     */     //   1695: invokevirtual getRenderY : ()D
/*     */     //   1698: dneg
/*     */     //   1699: dconst_0
/*     */     //   1700: invokestatic glTranslated : (DDD)V
/*     */     //   1703: invokestatic glPushMatrix : ()V
/*     */     //   1706: aload_0
/*     */     //   1707: invokevirtual getRenderX : ()D
/*     */     //   1710: d2f
/*     */     //   1711: fstore #17
/*     */     //   1713: aload_0
/*     */     //   1714: invokevirtual getRenderY : ()D
/*     */     //   1717: d2f
/*     */     //   1718: fstore #18
/*     */     //   1720: fconst_0
/*     */     //   1721: fstore #19
/*     */     //   1723: fconst_0
/*     */     //   1724: fstore #20
/*     */     //   1726: aload_0
/*     */     //   1727: getfield modules : Ljava/util/List;
/*     */     //   1730: checkcast java/lang/Iterable
/*     */     //   1733: astore #21
/*     */     //   1735: iconst_0
/*     */     //   1736: istore #22
/*     */     //   1738: iconst_0
/*     */     //   1739: istore #23
/*     */     //   1741: aload #21
/*     */     //   1743: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   1748: astore #24
/*     */     //   1750: aload #24
/*     */     //   1752: invokeinterface hasNext : ()Z
/*     */     //   1757: ifeq -> 1895
/*     */     //   1760: aload #24
/*     */     //   1762: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   1767: astore #25
/*     */     //   1769: iload #23
/*     */     //   1771: iinc #23, 1
/*     */     //   1774: istore #26
/*     */     //   1776: iconst_0
/*     */     //   1777: istore #27
/*     */     //   1779: iload #26
/*     */     //   1781: ifge -> 1787
/*     */     //   1784: invokestatic throwIndexOverflow : ()V
/*     */     //   1787: iload #26
/*     */     //   1789: istore #28
/*     */     //   1791: iload #28
/*     */     //   1793: aload #25
/*     */     //   1795: checkcast net/ccbluex/liquidbounce/features/module/Module
/*     */     //   1798: astore #29
/*     */     //   1800: istore #30
/*     */     //   1802: iconst_0
/*     */     //   1803: istore #31
/*     */     //   1805: aload_0
/*     */     //   1806: aload #29
/*     */     //   1808: invokevirtual getModName : (Lnet/ccbluex/liquidbounce/features/module/Module;)Ljava/lang/String;
/*     */     //   1811: astore #32
/*     */     //   1813: aload_1
/*     */     //   1814: aload #32
/*     */     //   1816: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*     */     //   1821: i2f
/*     */     //   1822: fconst_2
/*     */     //   1823: fadd
/*     */     //   1824: fstore #33
/*     */     //   1826: aload_0
/*     */     //   1827: invokevirtual getSide : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;
/*     */     //   1830: invokevirtual getVertical : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;
/*     */     //   1833: getstatic net/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical.DOWN : Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;
/*     */     //   1836: if_acmpne -> 1845
/*     */     //   1839: fload #13
/*     */     //   1841: fneg
/*     */     //   1842: goto -> 1871
/*     */     //   1845: fload #13
/*     */     //   1847: aload_0
/*     */     //   1848: invokevirtual getSide : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;
/*     */     //   1851: invokevirtual getVertical : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;
/*     */     //   1854: getstatic net/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical.DOWN : Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;
/*     */     //   1857: if_acmpne -> 1867
/*     */     //   1860: iload #30
/*     */     //   1862: iconst_1
/*     */     //   1863: iadd
/*     */     //   1864: goto -> 1869
/*     */     //   1867: iload #30
/*     */     //   1869: i2f
/*     */     //   1870: fmul
/*     */     //   1871: fstore #34
/*     */     //   1873: fload #19
/*     */     //   1875: fload #34
/*     */     //   1877: fadd
/*     */     //   1878: fstore #19
/*     */     //   1880: fload #20
/*     */     //   1882: fload #33
/*     */     //   1884: fneg
/*     */     //   1885: invokestatic min : (FF)F
/*     */     //   1888: fstore #20
/*     */     //   1890: nop
/*     */     //   1891: nop
/*     */     //   1892: goto -> 1750
/*     */     //   1895: nop
/*     */     //   1896: fload #17
/*     */     //   1898: fload #18
/*     */     //   1900: fload #17
/*     */     //   1902: fload #20
/*     */     //   1904: fadd
/*     */     //   1905: fload #18
/*     */     //   1907: fload #19
/*     */     //   1909: fadd
/*     */     //   1910: aload_0
/*     */     //   1911: getfield blurStrength : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1914: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1917: checkcast java/lang/Number
/*     */     //   1920: invokevirtual floatValue : ()F
/*     */     //   1923: iconst_0
/*     */     //   1924: new net/ccbluex/liquidbounce/ui/client/hud/element/elements/Arraylist$drawElement$4
/*     */     //   1927: dup
/*     */     //   1928: aload_0
/*     */     //   1929: fload #17
/*     */     //   1931: fload #18
/*     */     //   1933: fload #9
/*     */     //   1935: invokespecial <init> : (Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Arraylist;FFF)V
/*     */     //   1938: checkcast kotlin/jvm/functions/Function0
/*     */     //   1941: invokestatic blur : (FFFFFZLkotlin/jvm/functions/Function0;)V
/*     */     //   1944: invokestatic glPopMatrix : ()V
/*     */     //   1947: aload_0
/*     */     //   1948: invokevirtual getRenderX : ()D
/*     */     //   1951: aload_0
/*     */     //   1952: invokevirtual getRenderY : ()D
/*     */     //   1955: dconst_0
/*     */     //   1956: invokestatic glTranslated : (DDD)V
/*     */     //   1959: aload_0
/*     */     //   1960: getfield modules : Ljava/util/List;
/*     */     //   1963: checkcast java/lang/Iterable
/*     */     //   1966: astore #17
/*     */     //   1968: iconst_0
/*     */     //   1969: istore #18
/*     */     //   1971: iconst_0
/*     */     //   1972: istore #19
/*     */     //   1974: aload #17
/*     */     //   1976: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   1981: astore #20
/*     */     //   1983: aload #20
/*     */     //   1985: invokeinterface hasNext : ()Z
/*     */     //   1990: ifeq -> 4725
/*     */     //   1993: aload #20
/*     */     //   1995: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   2000: astore #21
/*     */     //   2002: iload #19
/*     */     //   2004: iinc #19, 1
/*     */     //   2007: istore #22
/*     */     //   2009: iconst_0
/*     */     //   2010: istore #23
/*     */     //   2012: iload #22
/*     */     //   2014: ifge -> 2020
/*     */     //   2017: invokestatic throwIndexOverflow : ()V
/*     */     //   2020: iload #22
/*     */     //   2022: istore #24
/*     */     //   2024: iload #24
/*     */     //   2026: aload #21
/*     */     //   2028: checkcast net/ccbluex/liquidbounce/features/module/Module
/*     */     //   2031: astore #25
/*     */     //   2033: istore #26
/*     */     //   2035: iconst_0
/*     */     //   2036: istore #27
/*     */     //   2038: aload_0
/*     */     //   2039: aload #25
/*     */     //   2041: invokevirtual getModName : (Lnet/ccbluex/liquidbounce/features/module/Module;)Ljava/lang/String;
/*     */     //   2044: astore #28
/*     */     //   2046: aload #25
/*     */     //   2048: invokevirtual getSlide : ()F
/*     */     //   2051: fneg
/*     */     //   2052: iconst_2
/*     */     //   2053: i2f
/*     */     //   2054: fsub
/*     */     //   2055: fstore #29
/*     */     //   2057: aload #25
/*     */     //   2059: invokevirtual getHue : ()F
/*     */     //   2062: fload #14
/*     */     //   2064: fload #15
/*     */     //   2066: invokestatic getHSBColor : (FFF)Ljava/awt/Color;
/*     */     //   2069: dup
/*     */     //   2070: ldc_w 'Color.getHSBColor(module…, saturation, brightness)'
/*     */     //   2073: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   2076: invokevirtual getRGB : ()I
/*     */     //   2079: istore #30
/*     */     //   2081: iconst_0
/*     */     //   2082: istore #31
/*     */     //   2084: aload_2
/*     */     //   2085: iconst_0
/*     */     //   2086: iaload
/*     */     //   2087: aload_0
/*     */     //   2088: getfield skyDistanceValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   2091: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2094: checkcast java/lang/Number
/*     */     //   2097: invokevirtual intValue : ()I
/*     */     //   2100: bipush #50
/*     */     //   2102: imul
/*     */     //   2103: imul
/*     */     //   2104: aload_0
/*     */     //   2105: getfield saturationValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   2108: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2111: checkcast java/lang/Number
/*     */     //   2114: invokevirtual floatValue : ()F
/*     */     //   2117: aload_0
/*     */     //   2118: getfield brightnessValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   2121: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2124: checkcast java/lang/Number
/*     */     //   2127: invokevirtual floatValue : ()F
/*     */     //   2130: invokestatic SkyRainbow : (IFF)I
/*     */     //   2133: istore #31
/*     */     //   2135: iconst_0
/*     */     //   2136: istore #32
/*     */     //   2138: aload_0
/*     */     //   2139: getfield cRainbowSecValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   2142: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2145: checkcast java/lang/Number
/*     */     //   2148: invokevirtual intValue : ()I
/*     */     //   2151: aload_0
/*     */     //   2152: getfield saturationValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   2155: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2158: checkcast java/lang/Number
/*     */     //   2161: invokevirtual floatValue : ()F
/*     */     //   2164: aload_0
/*     */     //   2165: getfield brightnessValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   2168: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2171: checkcast java/lang/Number
/*     */     //   2174: invokevirtual floatValue : ()F
/*     */     //   2177: aload_2
/*     */     //   2178: iconst_0
/*     */     //   2179: iaload
/*     */     //   2180: bipush #50
/*     */     //   2182: aload_0
/*     */     //   2183: getfield cRainbowDistValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   2186: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2189: checkcast java/lang/Number
/*     */     //   2192: invokevirtual intValue : ()I
/*     */     //   2195: imul
/*     */     //   2196: imul
/*     */     //   2197: invokestatic getRainbowOpaque : (IFFI)I
/*     */     //   2200: istore #32
/*     */     //   2202: new java/awt/Color
/*     */     //   2205: dup
/*     */     //   2206: aload_0
/*     */     //   2207: getfield colorRedValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   2210: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2213: checkcast java/lang/Number
/*     */     //   2216: invokevirtual intValue : ()I
/*     */     //   2219: aload_0
/*     */     //   2220: getfield colorGreenValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   2223: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2226: checkcast java/lang/Number
/*     */     //   2229: invokevirtual intValue : ()I
/*     */     //   2232: aload_0
/*     */     //   2233: getfield colorBlueValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   2236: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2239: checkcast java/lang/Number
/*     */     //   2242: invokevirtual intValue : ()I
/*     */     //   2245: aload_0
/*     */     //   2246: getfield colorAlphaValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   2249: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2252: checkcast java/lang/Number
/*     */     //   2255: invokevirtual intValue : ()I
/*     */     //   2258: invokespecial <init> : (IIII)V
/*     */     //   2261: iload #26
/*     */     //   2263: aload_0
/*     */     //   2264: getfield fadeDistanceValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   2267: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2270: checkcast java/lang/Number
/*     */     //   2273: invokevirtual intValue : ()I
/*     */     //   2276: imul
/*     */     //   2277: bipush #100
/*     */     //   2279: invokestatic fade : (Ljava/awt/Color;II)Ljava/awt/Color;
/*     */     //   2282: invokevirtual getRGB : ()I
/*     */     //   2285: istore #33
/*     */     //   2287: aload_2
/*     */     //   2288: iconst_0
/*     */     //   2289: aload_2
/*     */     //   2290: iconst_0
/*     */     //   2291: iaload
/*     */     //   2292: iconst_1
/*     */     //   2293: isub
/*     */     //   2294: iastore
/*     */     //   2295: invokestatic nanoTime : ()J
/*     */     //   2298: iload #26
/*     */     //   2300: aload_0
/*     */     //   2301: getfield liquidSlowlyDistanceValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   2304: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2307: checkcast java/lang/Number
/*     */     //   2310: invokevirtual intValue : ()I
/*     */     //   2313: imul
/*     */     //   2314: aload_0
/*     */     //   2315: getfield saturationValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   2318: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2321: checkcast java/lang/Number
/*     */     //   2324: invokevirtual floatValue : ()F
/*     */     //   2327: aload_0
/*     */     //   2328: getfield brightnessValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   2331: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2334: checkcast java/lang/Number
/*     */     //   2337: invokevirtual floatValue : ()F
/*     */     //   2340: invokestatic LiquidSlowly : (JIFF)Ljava/awt/Color;
/*     */     //   2343: dup
/*     */     //   2344: ifnull -> 2356
/*     */     //   2347: invokevirtual getRGB : ()I
/*     */     //   2350: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   2353: goto -> 2358
/*     */     //   2356: pop
/*     */     //   2357: aconst_null
/*     */     //   2358: astore #34
/*     */     //   2360: aload #34
/*     */     //   2362: dup
/*     */     //   2363: ifnonnull -> 2369
/*     */     //   2366: invokestatic throwNpe : ()V
/*     */     //   2369: invokevirtual intValue : ()I
/*     */     //   2372: istore #35
/*     */     //   2374: fload #29
/*     */     //   2376: aload_0
/*     */     //   2377: getfield rectRightValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   2380: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2383: checkcast java/lang/String
/*     */     //   2386: ldc_w 'right'
/*     */     //   2389: iconst_1
/*     */     //   2390: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   2393: ifeq -> 2400
/*     */     //   2396: iconst_3
/*     */     //   2397: goto -> 2425
/*     */     //   2400: aload_0
/*     */     //   2401: getfield rectRightValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   2404: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2407: checkcast java/lang/String
/*     */     //   2410: ldc_w 'rise'
/*     */     //   2413: iconst_1
/*     */     //   2414: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   2417: ifeq -> 2424
/*     */     //   2420: iconst_3
/*     */     //   2421: goto -> 2425
/*     */     //   2424: iconst_2
/*     */     //   2425: i2f
/*     */     //   2426: fsub
/*     */     //   2427: aload #25
/*     */     //   2429: invokevirtual getHigt : ()F
/*     */     //   2432: aload_0
/*     */     //   2433: getfield rectRightValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   2436: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2439: checkcast java/lang/String
/*     */     //   2442: ldc_w 'right'
/*     */     //   2445: iconst_1
/*     */     //   2446: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   2449: ifeq -> 2458
/*     */     //   2452: ldc_w -1.0
/*     */     //   2455: goto -> 2485
/*     */     //   2458: aload_0
/*     */     //   2459: getfield rectRightValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   2462: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2465: checkcast java/lang/String
/*     */     //   2468: ldc_w 'rise'
/*     */     //   2471: iconst_1
/*     */     //   2472: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   2475: ifeq -> 2484
/*     */     //   2478: ldc_w -1.0
/*     */     //   2481: goto -> 2485
/*     */     //   2484: fconst_0
/*     */     //   2485: aload #25
/*     */     //   2487: invokevirtual getHigt : ()F
/*     */     //   2490: fload #9
/*     */     //   2492: fadd
/*     */     //   2493: aload_0
/*     */     //   2494: getfield newbackground : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   2497: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2500: checkcast java/lang/String
/*     */     //   2503: ldc_w 'New'
/*     */     //   2506: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   2509: ifeq -> 2646
/*     */     //   2512: new java/awt/Color
/*     */     //   2515: dup
/*     */     //   2516: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   2519: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2522: checkcast java/lang/Number
/*     */     //   2525: invokevirtual intValue : ()I
/*     */     //   2528: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   2531: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2534: checkcast java/lang/Number
/*     */     //   2537: invokevirtual intValue : ()I
/*     */     //   2540: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   2543: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2546: checkcast java/lang/Number
/*     */     //   2549: invokevirtual intValue : ()I
/*     */     //   2552: aload_0
/*     */     //   2553: getfield backgroundColorAlphaValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   2556: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2559: checkcast java/lang/Number
/*     */     //   2562: invokevirtual intValue : ()I
/*     */     //   2565: invokespecial <init> : (IIII)V
/*     */     //   2568: new java/awt/Color
/*     */     //   2571: dup
/*     */     //   2572: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.r2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   2575: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2578: checkcast java/lang/Number
/*     */     //   2581: invokevirtual intValue : ()I
/*     */     //   2584: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.g2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   2587: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2590: checkcast java/lang/Number
/*     */     //   2593: invokevirtual intValue : ()I
/*     */     //   2596: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.b2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   2599: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2602: checkcast java/lang/Number
/*     */     //   2605: invokevirtual intValue : ()I
/*     */     //   2608: aload_0
/*     */     //   2609: getfield backgroundColorAlphaValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   2612: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2615: checkcast java/lang/Number
/*     */     //   2618: invokevirtual intValue : ()I
/*     */     //   2621: invokespecial <init> : (IIII)V
/*     */     //   2624: iload #26
/*     */     //   2626: i2d
/*     */     //   2627: fconst_1
/*     */     //   2628: f2d
/*     */     //   2629: dmul
/*     */     //   2630: invokestatic getGradientOffset : (Ljava/awt/Color;Ljava/awt/Color;D)Ljava/awt/Color;
/*     */     //   2633: dup
/*     */     //   2634: ldc_w 'RenderUtils.getGradientO…)),index * 1f.toDouble())'
/*     */     //   2637: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   2640: invokevirtual getRGB : ()I
/*     */     //   2643: goto -> 2648
/*     */     //   2646: iload #11
/*     */     //   2648: invokestatic drawRect : (FFFFI)V
/*     */     //   2651: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   2654: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   2657: ldc_w net/ccbluex/liquidbounce/features/module/modules/render/HUD
/*     */     //   2660: invokevirtual getModule : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   2663: dup
/*     */     //   2664: ifnonnull -> 2678
/*     */     //   2667: new kotlin/TypeCastException
/*     */     //   2670: dup
/*     */     //   2671: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.HUD'
/*     */     //   2674: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   2677: athrow
/*     */     //   2678: checkcast net/ccbluex/liquidbounce/features/module/modules/render/HUD
/*     */     //   2681: astore #36
/*     */     //   2683: aload_1
/*     */     //   2684: aload #28
/*     */     //   2686: fload #29
/*     */     //   2688: aload_0
/*     */     //   2689: getfield rectRightValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   2692: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2695: checkcast java/lang/String
/*     */     //   2698: ldc_w 'right'
/*     */     //   2701: iconst_1
/*     */     //   2702: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   2705: ifeq -> 2712
/*     */     //   2708: iconst_1
/*     */     //   2709: goto -> 2737
/*     */     //   2712: aload_0
/*     */     //   2713: getfield rectRightValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   2716: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2719: checkcast java/lang/String
/*     */     //   2722: ldc_w 'rise'
/*     */     //   2725: iconst_1
/*     */     //   2726: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   2729: ifeq -> 2736
/*     */     //   2732: iconst_1
/*     */     //   2733: goto -> 2737
/*     */     //   2736: iconst_0
/*     */     //   2737: i2f
/*     */     //   2738: fsub
/*     */     //   2739: aload #25
/*     */     //   2741: invokevirtual getHigt : ()F
/*     */     //   2744: fload #10
/*     */     //   2746: fadd
/*     */     //   2747: aload #4
/*     */     //   2749: ldc_w 'Random'
/*     */     //   2752: iconst_1
/*     */     //   2753: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   2756: ifeq -> 2764
/*     */     //   2759: iload #30
/*     */     //   2761: goto -> 2990
/*     */     //   2764: aload #4
/*     */     //   2766: ldc_w 'Sky'
/*     */     //   2769: iconst_1
/*     */     //   2770: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   2773: ifeq -> 2781
/*     */     //   2776: iload #31
/*     */     //   2778: goto -> 2990
/*     */     //   2781: aload #4
/*     */     //   2783: ldc_w 'CRainbow'
/*     */     //   2786: iconst_1
/*     */     //   2787: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   2790: ifeq -> 2798
/*     */     //   2793: iload #32
/*     */     //   2795: goto -> 2990
/*     */     //   2798: aload #4
/*     */     //   2800: ldc_w 'LiquidSlowly'
/*     */     //   2803: iconst_1
/*     */     //   2804: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   2807: ifeq -> 2815
/*     */     //   2810: iload #35
/*     */     //   2812: goto -> 2990
/*     */     //   2815: aload #4
/*     */     //   2817: ldc_w 'Fade'
/*     */     //   2820: iconst_1
/*     */     //   2821: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   2824: ifeq -> 2832
/*     */     //   2827: iload #33
/*     */     //   2829: goto -> 2990
/*     */     //   2832: aload #4
/*     */     //   2834: ldc_w 'Gradinet'
/*     */     //   2837: iconst_1
/*     */     //   2838: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   2841: ifeq -> 2988
/*     */     //   2844: new java/awt/Color
/*     */     //   2847: dup
/*     */     //   2848: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   2851: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2854: checkcast java/lang/Number
/*     */     //   2857: invokevirtual intValue : ()I
/*     */     //   2860: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   2863: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2866: checkcast java/lang/Number
/*     */     //   2869: invokevirtual intValue : ()I
/*     */     //   2872: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   2875: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2878: checkcast java/lang/Number
/*     */     //   2881: invokevirtual intValue : ()I
/*     */     //   2884: invokespecial <init> : (III)V
/*     */     //   2887: new java/awt/Color
/*     */     //   2890: dup
/*     */     //   2891: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.r2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   2894: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2897: checkcast java/lang/Number
/*     */     //   2900: invokevirtual intValue : ()I
/*     */     //   2903: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.g2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   2906: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2909: checkcast java/lang/Number
/*     */     //   2912: invokevirtual intValue : ()I
/*     */     //   2915: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.b2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   2918: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2921: checkcast java/lang/Number
/*     */     //   2924: invokevirtual intValue : ()I
/*     */     //   2927: iconst_1
/*     */     //   2928: invokespecial <init> : (IIII)V
/*     */     //   2931: invokestatic currentTimeMillis : ()J
/*     */     //   2934: l2d
/*     */     //   2935: aload_0
/*     */     //   2936: getfield gidentspeed : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   2939: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2942: checkcast java/lang/Number
/*     */     //   2945: invokevirtual intValue : ()I
/*     */     //   2948: i2d
/*     */     //   2949: ddiv
/*     */     //   2950: aload #25
/*     */     //   2952: invokevirtual getHigt : ()F
/*     */     //   2955: aload_1
/*     */     //   2956: invokeinterface getFontHeight : ()I
/*     */     //   2961: i2f
/*     */     //   2962: fdiv
/*     */     //   2963: f2d
/*     */     //   2964: dadd
/*     */     //   2965: invokestatic abs : (D)D
/*     */     //   2968: bipush #10
/*     */     //   2970: i2d
/*     */     //   2971: ddiv
/*     */     //   2972: invokestatic getGradientOffset : (Ljava/awt/Color;Ljava/awt/Color;D)Ljava/awt/Color;
/*     */     //   2975: dup
/*     */     //   2976: ldc_w 'RenderUtils.getGradientO…                 ) / 10))'
/*     */     //   2979: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   2982: invokevirtual getRGB : ()I
/*     */     //   2985: goto -> 2990
/*     */     //   2988: iload #6
/*     */     //   2990: iload #12
/*     */     //   2992: invokeinterface drawString : (Ljava/lang/String;FFIZ)I
/*     */     //   2997: pop
/*     */     //   2998: aload_0
/*     */     //   2999: getfield rectRightValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   3002: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3005: checkcast java/lang/String
/*     */     //   3008: ldc_w 'none'
/*     */     //   3011: iconst_1
/*     */     //   3012: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   3015: ifne -> 4720
/*     */     //   3018: new java/awt/Color
/*     */     //   3021: dup
/*     */     //   3022: aload_0
/*     */     //   3023: getfield rcolorRedValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   3026: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3029: checkcast java/lang/Number
/*     */     //   3032: invokevirtual intValue : ()I
/*     */     //   3035: aload_0
/*     */     //   3036: getfield rcolorGreenValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   3039: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3042: checkcast java/lang/Number
/*     */     //   3045: invokevirtual intValue : ()I
/*     */     //   3048: aload_0
/*     */     //   3049: getfield rcolorBlueValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   3052: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3055: checkcast java/lang/Number
/*     */     //   3058: invokevirtual intValue : ()I
/*     */     //   3061: aload_0
/*     */     //   3062: getfield rcolorAlpha : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   3065: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3068: checkcast java/lang/Number
/*     */     //   3071: invokevirtual intValue : ()I
/*     */     //   3074: invokespecial <init> : (IIII)V
/*     */     //   3077: astore #37
/*     */     //   3079: nop
/*     */     //   3080: aload #5
/*     */     //   3082: ldc_w 'Custom'
/*     */     //   3085: iconst_1
/*     */     //   3086: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   3089: ifeq -> 3157
/*     */     //   3092: new java/awt/Color
/*     */     //   3095: dup
/*     */     //   3096: aload_0
/*     */     //   3097: getfield rcolorRedValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   3100: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3103: checkcast java/lang/Number
/*     */     //   3106: invokevirtual intValue : ()I
/*     */     //   3109: aload_0
/*     */     //   3110: getfield rcolorGreenValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   3113: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3116: checkcast java/lang/Number
/*     */     //   3119: invokevirtual intValue : ()I
/*     */     //   3122: aload_0
/*     */     //   3123: getfield rcolorBlueValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   3126: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3129: checkcast java/lang/Number
/*     */     //   3132: invokevirtual intValue : ()I
/*     */     //   3135: aload_0
/*     */     //   3136: getfield rcolorAlpha : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   3139: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3142: checkcast java/lang/Number
/*     */     //   3145: invokevirtual intValue : ()I
/*     */     //   3148: invokespecial <init> : (IIII)V
/*     */     //   3151: invokevirtual getRGB : ()I
/*     */     //   3154: goto -> 3400
/*     */     //   3157: aload #5
/*     */     //   3159: ldc_w 'Random'
/*     */     //   3162: iconst_1
/*     */     //   3163: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   3166: ifeq -> 3174
/*     */     //   3169: iload #30
/*     */     //   3171: goto -> 3400
/*     */     //   3174: aload #5
/*     */     //   3176: ldc_w 'Sky'
/*     */     //   3179: iconst_1
/*     */     //   3180: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   3183: ifeq -> 3191
/*     */     //   3186: iload #31
/*     */     //   3188: goto -> 3400
/*     */     //   3191: aload #5
/*     */     //   3193: ldc_w 'CRainbow'
/*     */     //   3196: iconst_1
/*     */     //   3197: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   3200: ifeq -> 3208
/*     */     //   3203: iload #32
/*     */     //   3205: goto -> 3400
/*     */     //   3208: aload #5
/*     */     //   3210: ldc_w 'LiquidSlowly'
/*     */     //   3213: iconst_1
/*     */     //   3214: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   3217: ifeq -> 3225
/*     */     //   3220: iload #35
/*     */     //   3222: goto -> 3400
/*     */     //   3225: aload #5
/*     */     //   3227: ldc_w 'Fade'
/*     */     //   3230: iconst_1
/*     */     //   3231: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   3234: ifeq -> 3242
/*     */     //   3237: iload #33
/*     */     //   3239: goto -> 3400
/*     */     //   3242: aload #5
/*     */     //   3244: ldc_w 'Gradinet'
/*     */     //   3247: iconst_1
/*     */     //   3248: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   3251: ifeq -> 3398
/*     */     //   3254: new java/awt/Color
/*     */     //   3257: dup
/*     */     //   3258: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   3261: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3264: checkcast java/lang/Number
/*     */     //   3267: invokevirtual intValue : ()I
/*     */     //   3270: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   3273: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3276: checkcast java/lang/Number
/*     */     //   3279: invokevirtual intValue : ()I
/*     */     //   3282: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   3285: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3288: checkcast java/lang/Number
/*     */     //   3291: invokevirtual intValue : ()I
/*     */     //   3294: invokespecial <init> : (III)V
/*     */     //   3297: new java/awt/Color
/*     */     //   3300: dup
/*     */     //   3301: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.r2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   3304: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3307: checkcast java/lang/Number
/*     */     //   3310: invokevirtual intValue : ()I
/*     */     //   3313: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.g2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   3316: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3319: checkcast java/lang/Number
/*     */     //   3322: invokevirtual intValue : ()I
/*     */     //   3325: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.b2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   3328: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3331: checkcast java/lang/Number
/*     */     //   3334: invokevirtual intValue : ()I
/*     */     //   3337: iconst_1
/*     */     //   3338: invokespecial <init> : (IIII)V
/*     */     //   3341: invokestatic currentTimeMillis : ()J
/*     */     //   3344: l2d
/*     */     //   3345: aload_0
/*     */     //   3346: getfield gidentspeed : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   3349: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3352: checkcast java/lang/Number
/*     */     //   3355: invokevirtual intValue : ()I
/*     */     //   3358: i2d
/*     */     //   3359: ddiv
/*     */     //   3360: aload #25
/*     */     //   3362: invokevirtual getHigt : ()F
/*     */     //   3365: aload_1
/*     */     //   3366: invokeinterface getFontHeight : ()I
/*     */     //   3371: i2f
/*     */     //   3372: fdiv
/*     */     //   3373: f2d
/*     */     //   3374: dadd
/*     */     //   3375: invokestatic abs : (D)D
/*     */     //   3378: bipush #10
/*     */     //   3380: i2d
/*     */     //   3381: ddiv
/*     */     //   3382: invokestatic getGradientOffset : (Ljava/awt/Color;Ljava/awt/Color;D)Ljava/awt/Color;
/*     */     //   3385: dup
/*     */     //   3386: ldc_w 'RenderUtils.getGradientO…                 ) / 10))'
/*     */     //   3389: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   3392: invokevirtual getRGB : ()I
/*     */     //   3395: goto -> 3400
/*     */     //   3398: iload #7
/*     */     //   3400: istore #38
/*     */     //   3402: aload_0
/*     */     //   3403: getfield rectcolor : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   3406: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3409: checkcast java/lang/String
/*     */     //   3412: ldc_w 'Text'
/*     */     //   3415: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   3418: ifeq -> 4028
/*     */     //   3421: nop
/*     */     //   3422: aload_0
/*     */     //   3423: getfield rectRightValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   3426: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3429: checkcast java/lang/String
/*     */     //   3432: ldc_w 'normalleft'
/*     */     //   3435: iconst_1
/*     */     //   3436: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   3439: ifeq -> 3473
/*     */     //   3442: fload #29
/*     */     //   3444: iconst_3
/*     */     //   3445: i2f
/*     */     //   3446: fsub
/*     */     //   3447: aload #25
/*     */     //   3449: invokevirtual getHigt : ()F
/*     */     //   3452: fload #29
/*     */     //   3454: iconst_2
/*     */     //   3455: i2f
/*     */     //   3456: fsub
/*     */     //   3457: aload #25
/*     */     //   3459: invokevirtual getHigt : ()F
/*     */     //   3462: fload #9
/*     */     //   3464: fadd
/*     */     //   3465: iload #38
/*     */     //   3467: invokestatic drawRect : (FFFFI)V
/*     */     //   3470: goto -> 4028
/*     */     //   3473: aload_0
/*     */     //   3474: getfield rectRightValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   3477: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3480: checkcast java/lang/String
/*     */     //   3483: ldc_w 'right'
/*     */     //   3486: iconst_1
/*     */     //   3487: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   3490: ifeq -> 3530
/*     */     //   3493: ldc_w -1.0
/*     */     //   3496: aload #25
/*     */     //   3498: invokevirtual getHigt : ()F
/*     */     //   3501: aload_0
/*     */     //   3502: getfield rightx2 : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   3505: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3508: checkcast java/lang/Number
/*     */     //   3511: invokevirtual floatValue : ()F
/*     */     //   3514: aload #25
/*     */     //   3516: invokevirtual getHigt : ()F
/*     */     //   3519: fload #9
/*     */     //   3521: fadd
/*     */     //   3522: iload #38
/*     */     //   3524: invokestatic drawRect : (FFFFI)V
/*     */     //   3527: goto -> 4028
/*     */     //   3530: aload_0
/*     */     //   3531: getfield rectRightValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   3534: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3537: checkcast java/lang/String
/*     */     //   3540: ldc_w 'outline'
/*     */     //   3543: iconst_1
/*     */     //   3544: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   3547: ifeq -> 3785
/*     */     //   3550: ldc_w -1.0
/*     */     //   3553: aload #25
/*     */     //   3555: invokevirtual getHigt : ()F
/*     */     //   3558: fconst_1
/*     */     //   3559: fsub
/*     */     //   3560: fconst_0
/*     */     //   3561: aload #25
/*     */     //   3563: invokevirtual getHigt : ()F
/*     */     //   3566: fload #9
/*     */     //   3568: fadd
/*     */     //   3569: iload #38
/*     */     //   3571: invokestatic drawRect : (FFFFI)V
/*     */     //   3574: fload #29
/*     */     //   3576: iconst_3
/*     */     //   3577: i2f
/*     */     //   3578: fsub
/*     */     //   3579: aload #25
/*     */     //   3581: invokevirtual getHigt : ()F
/*     */     //   3584: fload #29
/*     */     //   3586: iconst_2
/*     */     //   3587: i2f
/*     */     //   3588: fsub
/*     */     //   3589: aload #25
/*     */     //   3591: invokevirtual getHigt : ()F
/*     */     //   3594: fload #9
/*     */     //   3596: fadd
/*     */     //   3597: iload #38
/*     */     //   3599: invokestatic drawRect : (FFFFI)V
/*     */     //   3602: aload #25
/*     */     //   3604: aload_0
/*     */     //   3605: getfield modules : Ljava/util/List;
/*     */     //   3608: iconst_0
/*     */     //   3609: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   3614: checkcast net/ccbluex/liquidbounce/features/module/Module
/*     */     //   3617: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   3620: iconst_1
/*     */     //   3621: ixor
/*     */     //   3622: ifeq -> 3758
/*     */     //   3625: aload_0
/*     */     //   3626: aload_0
/*     */     //   3627: getfield modules : Ljava/util/List;
/*     */     //   3630: iload #26
/*     */     //   3632: iconst_1
/*     */     //   3633: isub
/*     */     //   3634: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   3639: checkcast net/ccbluex/liquidbounce/features/module/Module
/*     */     //   3642: invokevirtual getModName : (Lnet/ccbluex/liquidbounce/features/module/Module;)Ljava/lang/String;
/*     */     //   3645: astore #39
/*     */     //   3647: fload #29
/*     */     //   3649: iconst_3
/*     */     //   3650: i2f
/*     */     //   3651: fsub
/*     */     //   3652: aload_1
/*     */     //   3653: aload #39
/*     */     //   3655: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*     */     //   3660: aload_1
/*     */     //   3661: aload #28
/*     */     //   3663: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*     */     //   3668: isub
/*     */     //   3669: i2f
/*     */     //   3670: fsub
/*     */     //   3671: aload #25
/*     */     //   3673: invokevirtual getHigt : ()F
/*     */     //   3676: fload #29
/*     */     //   3678: iconst_2
/*     */     //   3679: i2f
/*     */     //   3680: fsub
/*     */     //   3681: aload #25
/*     */     //   3683: invokevirtual getHigt : ()F
/*     */     //   3686: iconst_1
/*     */     //   3687: i2f
/*     */     //   3688: fadd
/*     */     //   3689: iload #38
/*     */     //   3691: invokestatic drawRect : (FFFFI)V
/*     */     //   3694: aload #25
/*     */     //   3696: aload_0
/*     */     //   3697: getfield modules : Ljava/util/List;
/*     */     //   3700: aload_0
/*     */     //   3701: getfield modules : Ljava/util/List;
/*     */     //   3704: invokeinterface size : ()I
/*     */     //   3709: iconst_1
/*     */     //   3710: isub
/*     */     //   3711: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   3716: checkcast net/ccbluex/liquidbounce/features/module/Module
/*     */     //   3719: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   3722: ifeq -> 4028
/*     */     //   3725: fload #29
/*     */     //   3727: iconst_3
/*     */     //   3728: i2f
/*     */     //   3729: fsub
/*     */     //   3730: aload #25
/*     */     //   3732: invokevirtual getHigt : ()F
/*     */     //   3735: fload #9
/*     */     //   3737: fadd
/*     */     //   3738: fconst_0
/*     */     //   3739: aload #25
/*     */     //   3741: invokevirtual getHigt : ()F
/*     */     //   3744: fload #9
/*     */     //   3746: fadd
/*     */     //   3747: iconst_1
/*     */     //   3748: i2f
/*     */     //   3749: fadd
/*     */     //   3750: iload #38
/*     */     //   3752: invokestatic drawRect : (FFFFI)V
/*     */     //   3755: goto -> 4028
/*     */     //   3758: fload #29
/*     */     //   3760: iconst_3
/*     */     //   3761: i2f
/*     */     //   3762: fsub
/*     */     //   3763: aload #25
/*     */     //   3765: invokevirtual getHigt : ()F
/*     */     //   3768: fconst_0
/*     */     //   3769: aload #25
/*     */     //   3771: invokevirtual getHigt : ()F
/*     */     //   3774: iconst_1
/*     */     //   3775: i2f
/*     */     //   3776: fsub
/*     */     //   3777: iload #38
/*     */     //   3779: invokestatic drawRect : (FFFFI)V
/*     */     //   3782: goto -> 4028
/*     */     //   3785: aload_0
/*     */     //   3786: getfield rectRightValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   3789: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3792: checkcast java/lang/String
/*     */     //   3795: ldc_w 'special'
/*     */     //   3798: iconst_1
/*     */     //   3799: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   3802: ifeq -> 3914
/*     */     //   3805: aload #25
/*     */     //   3807: aload_0
/*     */     //   3808: getfield modules : Ljava/util/List;
/*     */     //   3811: iconst_0
/*     */     //   3812: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   3817: checkcast net/ccbluex/liquidbounce/features/module/Module
/*     */     //   3820: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   3823: ifeq -> 3850
/*     */     //   3826: fload #29
/*     */     //   3828: iconst_2
/*     */     //   3829: i2f
/*     */     //   3830: fsub
/*     */     //   3831: aload #25
/*     */     //   3833: invokevirtual getHigt : ()F
/*     */     //   3836: fconst_0
/*     */     //   3837: aload #25
/*     */     //   3839: invokevirtual getHigt : ()F
/*     */     //   3842: iconst_1
/*     */     //   3843: i2f
/*     */     //   3844: fsub
/*     */     //   3845: iload #38
/*     */     //   3847: invokestatic drawRect : (FFFFI)V
/*     */     //   3850: aload #25
/*     */     //   3852: aload_0
/*     */     //   3853: getfield modules : Ljava/util/List;
/*     */     //   3856: aload_0
/*     */     //   3857: getfield modules : Ljava/util/List;
/*     */     //   3860: invokeinterface size : ()I
/*     */     //   3865: iconst_1
/*     */     //   3866: isub
/*     */     //   3867: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   3872: checkcast net/ccbluex/liquidbounce/features/module/Module
/*     */     //   3875: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   3878: ifeq -> 4028
/*     */     //   3881: fload #29
/*     */     //   3883: iconst_2
/*     */     //   3884: i2f
/*     */     //   3885: fsub
/*     */     //   3886: aload #25
/*     */     //   3888: invokevirtual getHigt : ()F
/*     */     //   3891: fload #9
/*     */     //   3893: fadd
/*     */     //   3894: fconst_0
/*     */     //   3895: aload #25
/*     */     //   3897: invokevirtual getHigt : ()F
/*     */     //   3900: fload #9
/*     */     //   3902: fadd
/*     */     //   3903: iconst_1
/*     */     //   3904: i2f
/*     */     //   3905: fadd
/*     */     //   3906: iload #38
/*     */     //   3908: invokestatic drawRect : (FFFFI)V
/*     */     //   3911: goto -> 4028
/*     */     //   3914: aload_0
/*     */     //   3915: getfield rectRightValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   3918: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3921: checkcast java/lang/String
/*     */     //   3924: ldc_w 'top'
/*     */     //   3927: iconst_1
/*     */     //   3928: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   3931: ifeq -> 3982
/*     */     //   3934: aload #25
/*     */     //   3936: aload_0
/*     */     //   3937: getfield modules : Ljava/util/List;
/*     */     //   3940: iconst_0
/*     */     //   3941: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   3946: checkcast net/ccbluex/liquidbounce/features/module/Module
/*     */     //   3949: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   3952: ifeq -> 4028
/*     */     //   3955: fload #29
/*     */     //   3957: iconst_2
/*     */     //   3958: i2f
/*     */     //   3959: fsub
/*     */     //   3960: aload #25
/*     */     //   3962: invokevirtual getHigt : ()F
/*     */     //   3965: fconst_0
/*     */     //   3966: aload #25
/*     */     //   3968: invokevirtual getHigt : ()F
/*     */     //   3971: iconst_1
/*     */     //   3972: i2f
/*     */     //   3973: fsub
/*     */     //   3974: iload #38
/*     */     //   3976: invokestatic drawRect : (FFFFI)V
/*     */     //   3979: goto -> 4028
/*     */     //   3982: aload_0
/*     */     //   3983: getfield rectRightValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   3986: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3989: checkcast java/lang/String
/*     */     //   3992: ldc_w 'rise'
/*     */     //   3995: iconst_1
/*     */     //   3996: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   3999: ifeq -> 4028
/*     */     //   4002: ldc_w -1.2
/*     */     //   4005: aload #25
/*     */     //   4007: invokevirtual getHigt : ()F
/*     */     //   4010: fconst_1
/*     */     //   4011: fadd
/*     */     //   4012: fconst_0
/*     */     //   4013: aload #25
/*     */     //   4015: invokevirtual getHigt : ()F
/*     */     //   4018: fload #9
/*     */     //   4020: fadd
/*     */     //   4021: fconst_1
/*     */     //   4022: fsub
/*     */     //   4023: iload #38
/*     */     //   4025: invokestatic drawRect : (FFFFI)V
/*     */     //   4028: aload_0
/*     */     //   4029: getfield rectcolor : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   4032: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4035: checkcast java/lang/String
/*     */     //   4038: ldc_w 'Custom'
/*     */     //   4041: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   4044: ifeq -> 4720
/*     */     //   4047: nop
/*     */     //   4048: aload_0
/*     */     //   4049: getfield rectRightValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   4052: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4055: checkcast java/lang/String
/*     */     //   4058: ldc_w 'left'
/*     */     //   4061: iconst_1
/*     */     //   4062: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   4065: ifeq -> 4114
/*     */     //   4068: fload #29
/*     */     //   4070: iconst_3
/*     */     //   4071: i2f
/*     */     //   4072: fsub
/*     */     //   4073: aload #25
/*     */     //   4075: invokevirtual getHigt : ()F
/*     */     //   4078: aload_0
/*     */     //   4079: getfield leftx2 : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   4082: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4085: checkcast java/lang/Number
/*     */     //   4088: invokevirtual floatValue : ()F
/*     */     //   4091: fload #9
/*     */     //   4093: aload_0
/*     */     //   4094: getfield leftrad : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   4097: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4100: checkcast java/lang/Number
/*     */     //   4103: invokevirtual floatValue : ()F
/*     */     //   4106: aload #37
/*     */     //   4108: invokestatic drawRound : (FFFFFLjava/awt/Color;)V
/*     */     //   4111: goto -> 4720
/*     */     //   4114: aload_0
/*     */     //   4115: getfield rectRightValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   4118: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4121: checkcast java/lang/String
/*     */     //   4124: ldc_w 'normalleft'
/*     */     //   4127: iconst_1
/*     */     //   4128: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   4131: ifeq -> 4165
/*     */     //   4134: fload #29
/*     */     //   4136: iconst_3
/*     */     //   4137: i2f
/*     */     //   4138: fsub
/*     */     //   4139: aload #25
/*     */     //   4141: invokevirtual getHigt : ()F
/*     */     //   4144: fload #29
/*     */     //   4146: iconst_2
/*     */     //   4147: i2f
/*     */     //   4148: fsub
/*     */     //   4149: aload #25
/*     */     //   4151: invokevirtual getHigt : ()F
/*     */     //   4154: fload #9
/*     */     //   4156: fadd
/*     */     //   4157: aload #37
/*     */     //   4159: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   4162: goto -> 4720
/*     */     //   4165: aload_0
/*     */     //   4166: getfield rectRightValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   4169: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4172: checkcast java/lang/String
/*     */     //   4175: ldc_w 'right'
/*     */     //   4178: iconst_1
/*     */     //   4179: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   4182: ifeq -> 4222
/*     */     //   4185: ldc_w -1.0
/*     */     //   4188: aload #25
/*     */     //   4190: invokevirtual getHigt : ()F
/*     */     //   4193: aload_0
/*     */     //   4194: getfield rightx2 : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   4197: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4200: checkcast java/lang/Number
/*     */     //   4203: invokevirtual floatValue : ()F
/*     */     //   4206: aload #25
/*     */     //   4208: invokevirtual getHigt : ()F
/*     */     //   4211: fload #9
/*     */     //   4213: fadd
/*     */     //   4214: aload #37
/*     */     //   4216: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   4219: goto -> 4720
/*     */     //   4222: aload_0
/*     */     //   4223: getfield rectRightValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   4226: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4229: checkcast java/lang/String
/*     */     //   4232: ldc_w 'outline'
/*     */     //   4235: iconst_1
/*     */     //   4236: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   4239: ifeq -> 4477
/*     */     //   4242: ldc_w -1.0
/*     */     //   4245: aload #25
/*     */     //   4247: invokevirtual getHigt : ()F
/*     */     //   4250: fconst_1
/*     */     //   4251: fsub
/*     */     //   4252: fconst_0
/*     */     //   4253: aload #25
/*     */     //   4255: invokevirtual getHigt : ()F
/*     */     //   4258: fload #9
/*     */     //   4260: fadd
/*     */     //   4261: aload #37
/*     */     //   4263: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   4266: fload #29
/*     */     //   4268: iconst_3
/*     */     //   4269: i2f
/*     */     //   4270: fsub
/*     */     //   4271: aload #25
/*     */     //   4273: invokevirtual getHigt : ()F
/*     */     //   4276: fload #29
/*     */     //   4278: iconst_2
/*     */     //   4279: i2f
/*     */     //   4280: fsub
/*     */     //   4281: aload #25
/*     */     //   4283: invokevirtual getHigt : ()F
/*     */     //   4286: fload #9
/*     */     //   4288: fadd
/*     */     //   4289: aload #37
/*     */     //   4291: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   4294: aload #25
/*     */     //   4296: aload_0
/*     */     //   4297: getfield modules : Ljava/util/List;
/*     */     //   4300: iconst_0
/*     */     //   4301: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   4306: checkcast net/ccbluex/liquidbounce/features/module/Module
/*     */     //   4309: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   4312: iconst_1
/*     */     //   4313: ixor
/*     */     //   4314: ifeq -> 4450
/*     */     //   4317: aload_0
/*     */     //   4318: aload_0
/*     */     //   4319: getfield modules : Ljava/util/List;
/*     */     //   4322: iload #26
/*     */     //   4324: iconst_1
/*     */     //   4325: isub
/*     */     //   4326: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   4331: checkcast net/ccbluex/liquidbounce/features/module/Module
/*     */     //   4334: invokevirtual getModName : (Lnet/ccbluex/liquidbounce/features/module/Module;)Ljava/lang/String;
/*     */     //   4337: astore #39
/*     */     //   4339: fload #29
/*     */     //   4341: iconst_3
/*     */     //   4342: i2f
/*     */     //   4343: fsub
/*     */     //   4344: aload_1
/*     */     //   4345: aload #39
/*     */     //   4347: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*     */     //   4352: aload_1
/*     */     //   4353: aload #28
/*     */     //   4355: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*     */     //   4360: isub
/*     */     //   4361: i2f
/*     */     //   4362: fsub
/*     */     //   4363: aload #25
/*     */     //   4365: invokevirtual getHigt : ()F
/*     */     //   4368: fload #29
/*     */     //   4370: iconst_2
/*     */     //   4371: i2f
/*     */     //   4372: fsub
/*     */     //   4373: aload #25
/*     */     //   4375: invokevirtual getHigt : ()F
/*     */     //   4378: iconst_1
/*     */     //   4379: i2f
/*     */     //   4380: fadd
/*     */     //   4381: aload #37
/*     */     //   4383: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   4386: aload #25
/*     */     //   4388: aload_0
/*     */     //   4389: getfield modules : Ljava/util/List;
/*     */     //   4392: aload_0
/*     */     //   4393: getfield modules : Ljava/util/List;
/*     */     //   4396: invokeinterface size : ()I
/*     */     //   4401: iconst_1
/*     */     //   4402: isub
/*     */     //   4403: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   4408: checkcast net/ccbluex/liquidbounce/features/module/Module
/*     */     //   4411: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   4414: ifeq -> 4720
/*     */     //   4417: fload #29
/*     */     //   4419: iconst_3
/*     */     //   4420: i2f
/*     */     //   4421: fsub
/*     */     //   4422: aload #25
/*     */     //   4424: invokevirtual getHigt : ()F
/*     */     //   4427: fload #9
/*     */     //   4429: fadd
/*     */     //   4430: fconst_0
/*     */     //   4431: aload #25
/*     */     //   4433: invokevirtual getHigt : ()F
/*     */     //   4436: fload #9
/*     */     //   4438: fadd
/*     */     //   4439: iconst_1
/*     */     //   4440: i2f
/*     */     //   4441: fadd
/*     */     //   4442: aload #37
/*     */     //   4444: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   4447: goto -> 4720
/*     */     //   4450: fload #29
/*     */     //   4452: iconst_3
/*     */     //   4453: i2f
/*     */     //   4454: fsub
/*     */     //   4455: aload #25
/*     */     //   4457: invokevirtual getHigt : ()F
/*     */     //   4460: fconst_0
/*     */     //   4461: aload #25
/*     */     //   4463: invokevirtual getHigt : ()F
/*     */     //   4466: iconst_1
/*     */     //   4467: i2f
/*     */     //   4468: fsub
/*     */     //   4469: aload #37
/*     */     //   4471: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   4474: goto -> 4720
/*     */     //   4477: aload_0
/*     */     //   4478: getfield rectRightValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   4481: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4484: checkcast java/lang/String
/*     */     //   4487: ldc_w 'special'
/*     */     //   4490: iconst_1
/*     */     //   4491: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   4494: ifeq -> 4606
/*     */     //   4497: aload #25
/*     */     //   4499: aload_0
/*     */     //   4500: getfield modules : Ljava/util/List;
/*     */     //   4503: iconst_0
/*     */     //   4504: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   4509: checkcast net/ccbluex/liquidbounce/features/module/Module
/*     */     //   4512: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   4515: ifeq -> 4542
/*     */     //   4518: fload #29
/*     */     //   4520: iconst_2
/*     */     //   4521: i2f
/*     */     //   4522: fsub
/*     */     //   4523: aload #25
/*     */     //   4525: invokevirtual getHigt : ()F
/*     */     //   4528: fconst_0
/*     */     //   4529: aload #25
/*     */     //   4531: invokevirtual getHigt : ()F
/*     */     //   4534: iconst_1
/*     */     //   4535: i2f
/*     */     //   4536: fsub
/*     */     //   4537: aload #37
/*     */     //   4539: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   4542: aload #25
/*     */     //   4544: aload_0
/*     */     //   4545: getfield modules : Ljava/util/List;
/*     */     //   4548: aload_0
/*     */     //   4549: getfield modules : Ljava/util/List;
/*     */     //   4552: invokeinterface size : ()I
/*     */     //   4557: iconst_1
/*     */     //   4558: isub
/*     */     //   4559: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   4564: checkcast net/ccbluex/liquidbounce/features/module/Module
/*     */     //   4567: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   4570: ifeq -> 4720
/*     */     //   4573: fload #29
/*     */     //   4575: iconst_2
/*     */     //   4576: i2f
/*     */     //   4577: fsub
/*     */     //   4578: aload #25
/*     */     //   4580: invokevirtual getHigt : ()F
/*     */     //   4583: fload #9
/*     */     //   4585: fadd
/*     */     //   4586: fconst_0
/*     */     //   4587: aload #25
/*     */     //   4589: invokevirtual getHigt : ()F
/*     */     //   4592: fload #9
/*     */     //   4594: fadd
/*     */     //   4595: iconst_1
/*     */     //   4596: i2f
/*     */     //   4597: fadd
/*     */     //   4598: aload #37
/*     */     //   4600: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   4603: goto -> 4720
/*     */     //   4606: aload_0
/*     */     //   4607: getfield rectRightValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   4610: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4613: checkcast java/lang/String
/*     */     //   4616: ldc_w 'top'
/*     */     //   4619: iconst_1
/*     */     //   4620: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   4623: ifeq -> 4674
/*     */     //   4626: aload #25
/*     */     //   4628: aload_0
/*     */     //   4629: getfield modules : Ljava/util/List;
/*     */     //   4632: iconst_0
/*     */     //   4633: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   4638: checkcast net/ccbluex/liquidbounce/features/module/Module
/*     */     //   4641: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   4644: ifeq -> 4720
/*     */     //   4647: fload #29
/*     */     //   4649: iconst_2
/*     */     //   4650: i2f
/*     */     //   4651: fsub
/*     */     //   4652: aload #25
/*     */     //   4654: invokevirtual getHigt : ()F
/*     */     //   4657: fconst_0
/*     */     //   4658: aload #25
/*     */     //   4660: invokevirtual getHigt : ()F
/*     */     //   4663: iconst_1
/*     */     //   4664: i2f
/*     */     //   4665: fsub
/*     */     //   4666: aload #37
/*     */     //   4668: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   4671: goto -> 4720
/*     */     //   4674: aload_0
/*     */     //   4675: getfield rectRightValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   4678: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4681: checkcast java/lang/String
/*     */     //   4684: ldc_w 'rise'
/*     */     //   4687: iconst_1
/*     */     //   4688: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   4691: ifeq -> 4720
/*     */     //   4694: ldc_w -1.2
/*     */     //   4697: aload #25
/*     */     //   4699: invokevirtual getHigt : ()F
/*     */     //   4702: fconst_1
/*     */     //   4703: fadd
/*     */     //   4704: fconst_0
/*     */     //   4705: aload #25
/*     */     //   4707: invokevirtual getHigt : ()F
/*     */     //   4710: fload #9
/*     */     //   4712: fadd
/*     */     //   4713: fconst_1
/*     */     //   4714: fsub
/*     */     //   4715: aload #37
/*     */     //   4717: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   4720: nop
/*     */     //   4721: nop
/*     */     //   4722: goto -> 1983
/*     */     //   4725: goto -> 6483
/*     */     //   4728: aload_0
/*     */     //   4729: getfield shadowShaderValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   4732: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4735: checkcast java/lang/Boolean
/*     */     //   4738: invokevirtual booleanValue : ()Z
/*     */     //   4741: ifeq -> 4830
/*     */     //   4744: aload_0
/*     */     //   4745: invokevirtual getRenderX : ()D
/*     */     //   4748: dneg
/*     */     //   4749: aload_0
/*     */     //   4750: invokevirtual getRenderY : ()D
/*     */     //   4753: dneg
/*     */     //   4754: dconst_0
/*     */     //   4755: invokestatic glTranslated : (DDD)V
/*     */     //   4758: invokestatic glPushMatrix : ()V
/*     */     //   4761: aload_0
/*     */     //   4762: getfield shadowStrength : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   4765: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4768: checkcast java/lang/Number
/*     */     //   4771: invokevirtual intValue : ()I
/*     */     //   4774: i2f
/*     */     //   4775: new net/ccbluex/liquidbounce/ui/client/hud/element/elements/Arraylist$drawElement$6
/*     */     //   4778: dup
/*     */     //   4779: aload_0
/*     */     //   4780: aload_1
/*     */     //   4781: fload #9
/*     */     //   4783: fload #14
/*     */     //   4785: fload #15
/*     */     //   4787: aload_2
/*     */     //   4788: aload #4
/*     */     //   4790: iload #6
/*     */     //   4792: invokespecial <init> : (Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Arraylist;Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;FFF[ILjava/lang/String;I)V
/*     */     //   4795: checkcast kotlin/jvm/functions/Function0
/*     */     //   4798: new net/ccbluex/liquidbounce/ui/client/hud/element/elements/Arraylist$drawElement$7
/*     */     //   4801: dup
/*     */     //   4802: aload_0
/*     */     //   4803: aload_1
/*     */     //   4804: fload #9
/*     */     //   4806: invokespecial <init> : (Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Arraylist;Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;F)V
/*     */     //   4809: checkcast kotlin/jvm/functions/Function0
/*     */     //   4812: invokestatic shadow : (FLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V
/*     */     //   4815: invokestatic glPopMatrix : ()V
/*     */     //   4818: aload_0
/*     */     //   4819: invokevirtual getRenderX : ()D
/*     */     //   4822: aload_0
/*     */     //   4823: invokevirtual getRenderY : ()D
/*     */     //   4826: dconst_0
/*     */     //   4827: invokestatic glTranslated : (DDD)V
/*     */     //   4830: aload_0
/*     */     //   4831: getfield blur : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   4834: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4837: checkcast java/lang/Boolean
/*     */     //   4840: invokevirtual booleanValue : ()Z
/*     */     //   4843: ifeq -> 5116
/*     */     //   4846: aload_0
/*     */     //   4847: invokevirtual getRenderX : ()D
/*     */     //   4850: dneg
/*     */     //   4851: aload_0
/*     */     //   4852: invokevirtual getRenderY : ()D
/*     */     //   4855: dneg
/*     */     //   4856: dconst_0
/*     */     //   4857: invokestatic glTranslated : (DDD)V
/*     */     //   4860: invokestatic glPushMatrix : ()V
/*     */     //   4863: aload_0
/*     */     //   4864: invokevirtual getRenderX : ()D
/*     */     //   4867: d2f
/*     */     //   4868: fstore #17
/*     */     //   4870: aload_0
/*     */     //   4871: invokevirtual getRenderY : ()D
/*     */     //   4874: d2f
/*     */     //   4875: fstore #18
/*     */     //   4877: fconst_0
/*     */     //   4878: fstore #19
/*     */     //   4880: fconst_0
/*     */     //   4881: fstore #20
/*     */     //   4883: aload_0
/*     */     //   4884: getfield modules : Ljava/util/List;
/*     */     //   4887: checkcast java/lang/Iterable
/*     */     //   4890: astore #21
/*     */     //   4892: iconst_0
/*     */     //   4893: istore #22
/*     */     //   4895: iconst_0
/*     */     //   4896: istore #23
/*     */     //   4898: aload #21
/*     */     //   4900: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   4905: astore #24
/*     */     //   4907: aload #24
/*     */     //   4909: invokeinterface hasNext : ()Z
/*     */     //   4914: ifeq -> 5051
/*     */     //   4917: aload #24
/*     */     //   4919: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   4924: astore #25
/*     */     //   4926: iload #23
/*     */     //   4928: iinc #23, 1
/*     */     //   4931: istore #26
/*     */     //   4933: iconst_0
/*     */     //   4934: istore #27
/*     */     //   4936: iload #26
/*     */     //   4938: ifge -> 4944
/*     */     //   4941: invokestatic throwIndexOverflow : ()V
/*     */     //   4944: iload #26
/*     */     //   4946: istore #28
/*     */     //   4948: iload #28
/*     */     //   4950: aload #25
/*     */     //   4952: checkcast net/ccbluex/liquidbounce/features/module/Module
/*     */     //   4955: astore #29
/*     */     //   4957: istore #30
/*     */     //   4959: iconst_0
/*     */     //   4960: istore #31
/*     */     //   4962: aload_0
/*     */     //   4963: aload #29
/*     */     //   4965: invokevirtual getModName : (Lnet/ccbluex/liquidbounce/features/module/Module;)Ljava/lang/String;
/*     */     //   4968: astore #32
/*     */     //   4970: aload_1
/*     */     //   4971: aload #32
/*     */     //   4973: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*     */     //   4978: i2f
/*     */     //   4979: fconst_2
/*     */     //   4980: fadd
/*     */     //   4981: fstore #33
/*     */     //   4983: aload_0
/*     */     //   4984: invokevirtual getSide : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;
/*     */     //   4987: invokevirtual getVertical : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;
/*     */     //   4990: getstatic net/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical.DOWN : Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;
/*     */     //   4993: if_acmpne -> 5002
/*     */     //   4996: fload #13
/*     */     //   4998: fneg
/*     */     //   4999: goto -> 5028
/*     */     //   5002: fload #13
/*     */     //   5004: aload_0
/*     */     //   5005: invokevirtual getSide : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;
/*     */     //   5008: invokevirtual getVertical : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;
/*     */     //   5011: getstatic net/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical.DOWN : Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;
/*     */     //   5014: if_acmpne -> 5024
/*     */     //   5017: iload #30
/*     */     //   5019: iconst_1
/*     */     //   5020: iadd
/*     */     //   5021: goto -> 5026
/*     */     //   5024: iload #30
/*     */     //   5026: i2f
/*     */     //   5027: fmul
/*     */     //   5028: fstore #34
/*     */     //   5030: fload #19
/*     */     //   5032: fload #34
/*     */     //   5034: fadd
/*     */     //   5035: fstore #19
/*     */     //   5037: fload #20
/*     */     //   5039: fload #33
/*     */     //   5041: invokestatic max : (FF)F
/*     */     //   5044: fstore #20
/*     */     //   5046: nop
/*     */     //   5047: nop
/*     */     //   5048: goto -> 4907
/*     */     //   5051: nop
/*     */     //   5052: fload #17
/*     */     //   5054: fload #18
/*     */     //   5056: fload #17
/*     */     //   5058: fload #20
/*     */     //   5060: fadd
/*     */     //   5061: fload #18
/*     */     //   5063: fload #19
/*     */     //   5065: fadd
/*     */     //   5066: aload_0
/*     */     //   5067: getfield blurStrength : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   5070: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5073: checkcast java/lang/Number
/*     */     //   5076: invokevirtual floatValue : ()F
/*     */     //   5079: iconst_0
/*     */     //   5080: new net/ccbluex/liquidbounce/ui/client/hud/element/elements/Arraylist$drawElement$9
/*     */     //   5083: dup
/*     */     //   5084: aload_0
/*     */     //   5085: aload_1
/*     */     //   5086: fload #17
/*     */     //   5088: fload #18
/*     */     //   5090: fload #9
/*     */     //   5092: invokespecial <init> : (Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Arraylist;Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;FFF)V
/*     */     //   5095: checkcast kotlin/jvm/functions/Function0
/*     */     //   5098: invokestatic blur : (FFFFFZLkotlin/jvm/functions/Function0;)V
/*     */     //   5101: invokestatic glPopMatrix : ()V
/*     */     //   5104: aload_0
/*     */     //   5105: invokevirtual getRenderX : ()D
/*     */     //   5108: aload_0
/*     */     //   5109: invokevirtual getRenderY : ()D
/*     */     //   5112: dconst_0
/*     */     //   5113: invokestatic glTranslated : (DDD)V
/*     */     //   5116: aload_0
/*     */     //   5117: getfield modules : Ljava/util/List;
/*     */     //   5120: checkcast java/lang/Iterable
/*     */     //   5123: astore #17
/*     */     //   5125: iconst_0
/*     */     //   5126: istore #18
/*     */     //   5128: iconst_0
/*     */     //   5129: istore #19
/*     */     //   5131: aload #17
/*     */     //   5133: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   5138: astore #20
/*     */     //   5140: aload #20
/*     */     //   5142: invokeinterface hasNext : ()Z
/*     */     //   5147: ifeq -> 6482
/*     */     //   5150: aload #20
/*     */     //   5152: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   5157: astore #21
/*     */     //   5159: iload #19
/*     */     //   5161: iinc #19, 1
/*     */     //   5164: istore #22
/*     */     //   5166: iconst_0
/*     */     //   5167: istore #23
/*     */     //   5169: iload #22
/*     */     //   5171: ifge -> 5177
/*     */     //   5174: invokestatic throwIndexOverflow : ()V
/*     */     //   5177: iload #22
/*     */     //   5179: istore #24
/*     */     //   5181: iload #24
/*     */     //   5183: aload #21
/*     */     //   5185: checkcast net/ccbluex/liquidbounce/features/module/Module
/*     */     //   5188: astore #25
/*     */     //   5190: istore #26
/*     */     //   5192: iconst_0
/*     */     //   5193: istore #27
/*     */     //   5195: aload_0
/*     */     //   5196: aload #25
/*     */     //   5198: invokevirtual getModName : (Lnet/ccbluex/liquidbounce/features/module/Module;)Ljava/lang/String;
/*     */     //   5201: astore #28
/*     */     //   5203: aload_1
/*     */     //   5204: aload #28
/*     */     //   5206: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*     */     //   5211: istore #29
/*     */     //   5213: iload #29
/*     */     //   5215: i2f
/*     */     //   5216: aload #25
/*     */     //   5218: invokevirtual getSlide : ()F
/*     */     //   5221: fsub
/*     */     //   5222: fneg
/*     */     //   5223: aload_0
/*     */     //   5224: getfield rectLeftValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   5227: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5230: checkcast java/lang/String
/*     */     //   5233: ldc_w 'left'
/*     */     //   5236: iconst_1
/*     */     //   5237: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   5240: ifeq -> 5247
/*     */     //   5243: iconst_3
/*     */     //   5244: goto -> 5248
/*     */     //   5247: iconst_2
/*     */     //   5248: i2f
/*     */     //   5249: fadd
/*     */     //   5250: fstore #30
/*     */     //   5252: aload #25
/*     */     //   5254: invokevirtual getHue : ()F
/*     */     //   5257: fload #14
/*     */     //   5259: fload #15
/*     */     //   5261: invokestatic getHSBColor : (FFF)Ljava/awt/Color;
/*     */     //   5264: dup
/*     */     //   5265: ldc_w 'Color.getHSBColor(module…, saturation, brightness)'
/*     */     //   5268: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   5271: invokevirtual getRGB : ()I
/*     */     //   5274: istore #31
/*     */     //   5276: iconst_0
/*     */     //   5277: istore #32
/*     */     //   5279: aload_2
/*     */     //   5280: iconst_0
/*     */     //   5281: iaload
/*     */     //   5282: aload_0
/*     */     //   5283: getfield skyDistanceValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   5286: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5289: checkcast java/lang/Number
/*     */     //   5292: invokevirtual intValue : ()I
/*     */     //   5295: bipush #50
/*     */     //   5297: imul
/*     */     //   5298: imul
/*     */     //   5299: aload_0
/*     */     //   5300: getfield saturationValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   5303: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5306: checkcast java/lang/Number
/*     */     //   5309: invokevirtual floatValue : ()F
/*     */     //   5312: aload_0
/*     */     //   5313: getfield brightnessValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   5316: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5319: checkcast java/lang/Number
/*     */     //   5322: invokevirtual floatValue : ()F
/*     */     //   5325: invokestatic SkyRainbow : (IFF)I
/*     */     //   5328: istore #32
/*     */     //   5330: iconst_0
/*     */     //   5331: istore #33
/*     */     //   5333: aload_0
/*     */     //   5334: getfield cRainbowSecValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   5337: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5340: checkcast java/lang/Number
/*     */     //   5343: invokevirtual intValue : ()I
/*     */     //   5346: aload_0
/*     */     //   5347: getfield saturationValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   5350: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5353: checkcast java/lang/Number
/*     */     //   5356: invokevirtual floatValue : ()F
/*     */     //   5359: aload_0
/*     */     //   5360: getfield brightnessValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   5363: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5366: checkcast java/lang/Number
/*     */     //   5369: invokevirtual floatValue : ()F
/*     */     //   5372: aload_2
/*     */     //   5373: iconst_0
/*     */     //   5374: iaload
/*     */     //   5375: bipush #50
/*     */     //   5377: aload_0
/*     */     //   5378: getfield cRainbowDistValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   5381: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5384: checkcast java/lang/Number
/*     */     //   5387: invokevirtual intValue : ()I
/*     */     //   5390: imul
/*     */     //   5391: imul
/*     */     //   5392: invokestatic getRainbowOpaque : (IFFI)I
/*     */     //   5395: istore #33
/*     */     //   5397: new java/awt/Color
/*     */     //   5400: dup
/*     */     //   5401: aload_0
/*     */     //   5402: getfield colorRedValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   5405: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5408: checkcast java/lang/Number
/*     */     //   5411: invokevirtual intValue : ()I
/*     */     //   5414: aload_0
/*     */     //   5415: getfield colorGreenValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   5418: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5421: checkcast java/lang/Number
/*     */     //   5424: invokevirtual intValue : ()I
/*     */     //   5427: aload_0
/*     */     //   5428: getfield colorBlueValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   5431: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5434: checkcast java/lang/Number
/*     */     //   5437: invokevirtual intValue : ()I
/*     */     //   5440: aload_0
/*     */     //   5441: getfield colorAlphaValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   5444: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5447: checkcast java/lang/Number
/*     */     //   5450: invokevirtual intValue : ()I
/*     */     //   5453: invokespecial <init> : (IIII)V
/*     */     //   5456: iload #26
/*     */     //   5458: aload_0
/*     */     //   5459: getfield fadeDistanceValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   5462: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5465: checkcast java/lang/Number
/*     */     //   5468: invokevirtual intValue : ()I
/*     */     //   5471: imul
/*     */     //   5472: bipush #100
/*     */     //   5474: invokestatic fade : (Ljava/awt/Color;II)Ljava/awt/Color;
/*     */     //   5477: invokevirtual getRGB : ()I
/*     */     //   5480: istore #34
/*     */     //   5482: aload_2
/*     */     //   5483: iconst_0
/*     */     //   5484: aload_2
/*     */     //   5485: iconst_0
/*     */     //   5486: iaload
/*     */     //   5487: iconst_1
/*     */     //   5488: isub
/*     */     //   5489: iastore
/*     */     //   5490: invokestatic nanoTime : ()J
/*     */     //   5493: iload #26
/*     */     //   5495: aload_0
/*     */     //   5496: getfield liquidSlowlyDistanceValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   5499: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5502: checkcast java/lang/Number
/*     */     //   5505: invokevirtual intValue : ()I
/*     */     //   5508: imul
/*     */     //   5509: aload_0
/*     */     //   5510: getfield saturationValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   5513: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5516: checkcast java/lang/Number
/*     */     //   5519: invokevirtual floatValue : ()F
/*     */     //   5522: aload_0
/*     */     //   5523: getfield brightnessValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   5526: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5529: checkcast java/lang/Number
/*     */     //   5532: invokevirtual floatValue : ()F
/*     */     //   5535: invokestatic LiquidSlowly : (JIFF)Ljava/awt/Color;
/*     */     //   5538: dup
/*     */     //   5539: ifnull -> 5551
/*     */     //   5542: invokevirtual getRGB : ()I
/*     */     //   5545: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   5548: goto -> 5553
/*     */     //   5551: pop
/*     */     //   5552: aconst_null
/*     */     //   5553: astore #35
/*     */     //   5555: aload #35
/*     */     //   5557: dup
/*     */     //   5558: ifnonnull -> 5564
/*     */     //   5561: invokestatic throwNpe : ()V
/*     */     //   5564: invokevirtual intValue : ()I
/*     */     //   5567: istore #36
/*     */     //   5569: fconst_0
/*     */     //   5570: aload #25
/*     */     //   5572: invokevirtual getHigt : ()F
/*     */     //   5575: fload #30
/*     */     //   5577: iload #29
/*     */     //   5579: i2f
/*     */     //   5580: fadd
/*     */     //   5581: aload_0
/*     */     //   5582: getfield rectLeftValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   5585: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5588: checkcast java/lang/String
/*     */     //   5591: ldc_w 'right'
/*     */     //   5594: iconst_1
/*     */     //   5595: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   5598: ifeq -> 5605
/*     */     //   5601: iconst_3
/*     */     //   5602: goto -> 5606
/*     */     //   5605: iconst_2
/*     */     //   5606: i2f
/*     */     //   5607: fadd
/*     */     //   5608: aload #25
/*     */     //   5610: invokevirtual getHigt : ()F
/*     */     //   5613: fload #9
/*     */     //   5615: fadd
/*     */     //   5616: aload_0
/*     */     //   5617: getfield newbackground : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   5620: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5623: checkcast java/lang/String
/*     */     //   5626: ldc_w 'New'
/*     */     //   5629: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   5632: ifeq -> 5804
/*     */     //   5635: new java/awt/Color
/*     */     //   5638: dup
/*     */     //   5639: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   5642: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5645: checkcast java/lang/Number
/*     */     //   5648: invokevirtual intValue : ()I
/*     */     //   5651: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   5654: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5657: checkcast java/lang/Number
/*     */     //   5660: invokevirtual intValue : ()I
/*     */     //   5663: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   5666: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5669: checkcast java/lang/Number
/*     */     //   5672: invokevirtual intValue : ()I
/*     */     //   5675: aload_0
/*     */     //   5676: getfield backgroundColorAlphaValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   5679: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5682: checkcast java/lang/Number
/*     */     //   5685: invokevirtual intValue : ()I
/*     */     //   5688: invokespecial <init> : (IIII)V
/*     */     //   5691: new java/awt/Color
/*     */     //   5694: dup
/*     */     //   5695: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.r2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   5698: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5701: checkcast java/lang/Number
/*     */     //   5704: invokevirtual intValue : ()I
/*     */     //   5707: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.g2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   5710: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5713: checkcast java/lang/Number
/*     */     //   5716: invokevirtual intValue : ()I
/*     */     //   5719: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.b2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   5722: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5725: checkcast java/lang/Number
/*     */     //   5728: invokevirtual intValue : ()I
/*     */     //   5731: aload_0
/*     */     //   5732: getfield backgroundColorAlphaValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   5735: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5738: checkcast java/lang/Number
/*     */     //   5741: invokevirtual intValue : ()I
/*     */     //   5744: invokespecial <init> : (IIII)V
/*     */     //   5747: invokestatic currentTimeMillis : ()J
/*     */     //   5750: l2d
/*     */     //   5751: aload_0
/*     */     //   5752: getfield gidentspeed : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   5755: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5758: checkcast java/lang/Number
/*     */     //   5761: invokevirtual intValue : ()I
/*     */     //   5764: i2d
/*     */     //   5765: ddiv
/*     */     //   5766: aload #25
/*     */     //   5768: invokevirtual getHigt : ()F
/*     */     //   5771: aload_1
/*     */     //   5772: invokeinterface getFontHeight : ()I
/*     */     //   5777: i2f
/*     */     //   5778: fdiv
/*     */     //   5779: f2d
/*     */     //   5780: dadd
/*     */     //   5781: invokestatic abs : (D)D
/*     */     //   5784: bipush #10
/*     */     //   5786: i2d
/*     */     //   5787: ddiv
/*     */     //   5788: invokestatic getGradientOffset : (Ljava/awt/Color;Ljava/awt/Color;D)Ljava/awt/Color;
/*     */     //   5791: dup
/*     */     //   5792: ldc_w 'RenderUtils.getGradientO…                 ) / 10))'
/*     */     //   5795: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   5798: invokevirtual getRGB : ()I
/*     */     //   5801: goto -> 5806
/*     */     //   5804: iload #11
/*     */     //   5806: invokestatic drawRect : (FFFFI)V
/*     */     //   5809: aload_1
/*     */     //   5810: aload #28
/*     */     //   5812: fload #30
/*     */     //   5814: aload #25
/*     */     //   5816: invokevirtual getHigt : ()F
/*     */     //   5819: fload #10
/*     */     //   5821: fadd
/*     */     //   5822: aload #4
/*     */     //   5824: ldc_w 'Random'
/*     */     //   5827: iconst_1
/*     */     //   5828: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   5831: ifeq -> 5839
/*     */     //   5834: iload #31
/*     */     //   5836: goto -> 6065
/*     */     //   5839: aload #4
/*     */     //   5841: ldc_w 'Sky'
/*     */     //   5844: iconst_1
/*     */     //   5845: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   5848: ifeq -> 5856
/*     */     //   5851: iload #32
/*     */     //   5853: goto -> 6065
/*     */     //   5856: aload #4
/*     */     //   5858: ldc_w 'CRainbow'
/*     */     //   5861: iconst_1
/*     */     //   5862: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   5865: ifeq -> 5873
/*     */     //   5868: iload #33
/*     */     //   5870: goto -> 6065
/*     */     //   5873: aload #4
/*     */     //   5875: ldc_w 'LiquidSlowly'
/*     */     //   5878: iconst_1
/*     */     //   5879: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   5882: ifeq -> 5890
/*     */     //   5885: iload #36
/*     */     //   5887: goto -> 6065
/*     */     //   5890: aload #4
/*     */     //   5892: ldc_w 'Fade'
/*     */     //   5895: iconst_1
/*     */     //   5896: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   5899: ifeq -> 5907
/*     */     //   5902: iload #34
/*     */     //   5904: goto -> 6065
/*     */     //   5907: aload #4
/*     */     //   5909: ldc_w 'Gradinet'
/*     */     //   5912: iconst_1
/*     */     //   5913: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   5916: ifeq -> 6063
/*     */     //   5919: new java/awt/Color
/*     */     //   5922: dup
/*     */     //   5923: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   5926: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5929: checkcast java/lang/Number
/*     */     //   5932: invokevirtual intValue : ()I
/*     */     //   5935: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   5938: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5941: checkcast java/lang/Number
/*     */     //   5944: invokevirtual intValue : ()I
/*     */     //   5947: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   5950: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5953: checkcast java/lang/Number
/*     */     //   5956: invokevirtual intValue : ()I
/*     */     //   5959: invokespecial <init> : (III)V
/*     */     //   5962: new java/awt/Color
/*     */     //   5965: dup
/*     */     //   5966: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.r2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   5969: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5972: checkcast java/lang/Number
/*     */     //   5975: invokevirtual intValue : ()I
/*     */     //   5978: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.g2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   5981: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5984: checkcast java/lang/Number
/*     */     //   5987: invokevirtual intValue : ()I
/*     */     //   5990: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.b2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   5993: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5996: checkcast java/lang/Number
/*     */     //   5999: invokevirtual intValue : ()I
/*     */     //   6002: iconst_1
/*     */     //   6003: invokespecial <init> : (IIII)V
/*     */     //   6006: invokestatic currentTimeMillis : ()J
/*     */     //   6009: l2d
/*     */     //   6010: aload_0
/*     */     //   6011: getfield gidentspeed : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   6014: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   6017: checkcast java/lang/Number
/*     */     //   6020: invokevirtual intValue : ()I
/*     */     //   6023: i2d
/*     */     //   6024: ddiv
/*     */     //   6025: aload #25
/*     */     //   6027: invokevirtual getHigt : ()F
/*     */     //   6030: aload_1
/*     */     //   6031: invokeinterface getFontHeight : ()I
/*     */     //   6036: i2f
/*     */     //   6037: fdiv
/*     */     //   6038: f2d
/*     */     //   6039: dadd
/*     */     //   6040: invokestatic abs : (D)D
/*     */     //   6043: bipush #10
/*     */     //   6045: i2d
/*     */     //   6046: ddiv
/*     */     //   6047: invokestatic getGradientOffset : (Ljava/awt/Color;Ljava/awt/Color;D)Ljava/awt/Color;
/*     */     //   6050: dup
/*     */     //   6051: ldc_w 'RenderUtils.getGradientO…                 ) / 10))'
/*     */     //   6054: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6057: invokevirtual getRGB : ()I
/*     */     //   6060: goto -> 6065
/*     */     //   6063: iload #6
/*     */     //   6065: iload #12
/*     */     //   6067: invokeinterface drawString : (Ljava/lang/String;FFIZ)I
/*     */     //   6072: pop
/*     */     //   6073: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   6076: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   6079: ldc_w net/ccbluex/liquidbounce/features/module/modules/render/HUD
/*     */     //   6082: invokevirtual getModule : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   6085: dup
/*     */     //   6086: ifnonnull -> 6100
/*     */     //   6089: new kotlin/TypeCastException
/*     */     //   6092: dup
/*     */     //   6093: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.HUD'
/*     */     //   6096: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   6099: athrow
/*     */     //   6100: checkcast net/ccbluex/liquidbounce/features/module/modules/render/HUD
/*     */     //   6103: astore #37
/*     */     //   6105: aload_0
/*     */     //   6106: getfield rectLeftValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   6109: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   6112: checkcast java/lang/String
/*     */     //   6115: ldc_w 'none'
/*     */     //   6118: iconst_1
/*     */     //   6119: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   6122: ifne -> 6477
/*     */     //   6125: nop
/*     */     //   6126: aload #5
/*     */     //   6128: ldc_w 'Random'
/*     */     //   6131: iconst_1
/*     */     //   6132: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   6135: ifeq -> 6143
/*     */     //   6138: iload #31
/*     */     //   6140: goto -> 6369
/*     */     //   6143: aload #5
/*     */     //   6145: ldc_w 'Sky'
/*     */     //   6148: iconst_1
/*     */     //   6149: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   6152: ifeq -> 6160
/*     */     //   6155: iload #32
/*     */     //   6157: goto -> 6369
/*     */     //   6160: aload #5
/*     */     //   6162: ldc_w 'CRainbow'
/*     */     //   6165: iconst_1
/*     */     //   6166: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   6169: ifeq -> 6177
/*     */     //   6172: iload #33
/*     */     //   6174: goto -> 6369
/*     */     //   6177: aload #5
/*     */     //   6179: ldc_w 'LiquidSlowly'
/*     */     //   6182: iconst_1
/*     */     //   6183: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   6186: ifeq -> 6194
/*     */     //   6189: iload #36
/*     */     //   6191: goto -> 6369
/*     */     //   6194: aload #5
/*     */     //   6196: ldc_w 'Fade'
/*     */     //   6199: iconst_1
/*     */     //   6200: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   6203: ifeq -> 6211
/*     */     //   6206: iload #34
/*     */     //   6208: goto -> 6369
/*     */     //   6211: aload #5
/*     */     //   6213: ldc_w 'Gradinet'
/*     */     //   6216: iconst_1
/*     */     //   6217: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   6220: ifeq -> 6367
/*     */     //   6223: new java/awt/Color
/*     */     //   6226: dup
/*     */     //   6227: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   6230: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   6233: checkcast java/lang/Number
/*     */     //   6236: invokevirtual intValue : ()I
/*     */     //   6239: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   6242: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   6245: checkcast java/lang/Number
/*     */     //   6248: invokevirtual intValue : ()I
/*     */     //   6251: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   6254: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   6257: checkcast java/lang/Number
/*     */     //   6260: invokevirtual intValue : ()I
/*     */     //   6263: invokespecial <init> : (III)V
/*     */     //   6266: new java/awt/Color
/*     */     //   6269: dup
/*     */     //   6270: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.r2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   6273: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   6276: checkcast java/lang/Number
/*     */     //   6279: invokevirtual intValue : ()I
/*     */     //   6282: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.g2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   6285: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   6288: checkcast java/lang/Number
/*     */     //   6291: invokevirtual intValue : ()I
/*     */     //   6294: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.b2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   6297: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   6300: checkcast java/lang/Number
/*     */     //   6303: invokevirtual intValue : ()I
/*     */     //   6306: iconst_1
/*     */     //   6307: invokespecial <init> : (IIII)V
/*     */     //   6310: invokestatic currentTimeMillis : ()J
/*     */     //   6313: l2d
/*     */     //   6314: aload_0
/*     */     //   6315: getfield gidentspeed : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   6318: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   6321: checkcast java/lang/Number
/*     */     //   6324: invokevirtual intValue : ()I
/*     */     //   6327: i2d
/*     */     //   6328: ddiv
/*     */     //   6329: aload #25
/*     */     //   6331: invokevirtual getHigt : ()F
/*     */     //   6334: aload_1
/*     */     //   6335: invokeinterface getFontHeight : ()I
/*     */     //   6340: i2f
/*     */     //   6341: fdiv
/*     */     //   6342: f2d
/*     */     //   6343: dadd
/*     */     //   6344: invokestatic abs : (D)D
/*     */     //   6347: bipush #10
/*     */     //   6349: i2d
/*     */     //   6350: ddiv
/*     */     //   6351: invokestatic getGradientOffset : (Ljava/awt/Color;Ljava/awt/Color;D)Ljava/awt/Color;
/*     */     //   6354: dup
/*     */     //   6355: ldc_w 'RenderUtils.getGradientO…                 ) / 10))'
/*     */     //   6358: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6361: invokevirtual getRGB : ()I
/*     */     //   6364: goto -> 6369
/*     */     //   6367: iload #7
/*     */     //   6369: istore #38
/*     */     //   6371: nop
/*     */     //   6372: aload_0
/*     */     //   6373: getfield rectLeftValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   6376: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   6379: checkcast java/lang/String
/*     */     //   6382: ldc_w 'left'
/*     */     //   6385: iconst_1
/*     */     //   6386: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   6389: ifeq -> 6418
/*     */     //   6392: fconst_0
/*     */     //   6393: aload #25
/*     */     //   6395: invokevirtual getHigt : ()F
/*     */     //   6398: iconst_1
/*     */     //   6399: i2f
/*     */     //   6400: fsub
/*     */     //   6401: fconst_1
/*     */     //   6402: aload #25
/*     */     //   6404: invokevirtual getHigt : ()F
/*     */     //   6407: fload #9
/*     */     //   6409: fadd
/*     */     //   6410: iload #38
/*     */     //   6412: invokestatic drawRect : (FFFFI)V
/*     */     //   6415: goto -> 6477
/*     */     //   6418: aload_0
/*     */     //   6419: getfield rectLeftValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   6422: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   6425: checkcast java/lang/String
/*     */     //   6428: ldc_w 'right'
/*     */     //   6431: iconst_1
/*     */     //   6432: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   6435: ifeq -> 6477
/*     */     //   6438: fload #30
/*     */     //   6440: iload #29
/*     */     //   6442: i2f
/*     */     //   6443: fadd
/*     */     //   6444: iconst_2
/*     */     //   6445: i2f
/*     */     //   6446: fadd
/*     */     //   6447: aload #25
/*     */     //   6449: invokevirtual getHigt : ()F
/*     */     //   6452: fload #30
/*     */     //   6454: iload #29
/*     */     //   6456: i2f
/*     */     //   6457: fadd
/*     */     //   6458: iconst_2
/*     */     //   6459: i2f
/*     */     //   6460: fadd
/*     */     //   6461: iconst_1
/*     */     //   6462: i2f
/*     */     //   6463: fadd
/*     */     //   6464: aload #25
/*     */     //   6466: invokevirtual getHigt : ()F
/*     */     //   6469: fload #9
/*     */     //   6471: fadd
/*     */     //   6472: iload #38
/*     */     //   6474: invokestatic drawRect : (FFFFI)V
/*     */     //   6477: nop
/*     */     //   6478: nop
/*     */     //   6479: goto -> 5140
/*     */     //   6482: nop
/*     */     //   6483: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   6486: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   6489: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*     */     //   6494: invokeinterface isGuiHudDesigner : (Ljava/lang/Object;)Z
/*     */     //   6499: ifne -> 6521
/*     */     //   6502: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   6505: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   6508: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*     */     //   6513: invokeinterface isGuiChat : (Ljava/lang/Object;)Z
/*     */     //   6518: ifeq -> 6820
/*     */     //   6521: aload_0
/*     */     //   6522: ldc_w -2147483648
/*     */     //   6525: putfield x2 : I
/*     */     //   6528: aload_0
/*     */     //   6529: getfield modules : Ljava/util/List;
/*     */     //   6532: invokeinterface isEmpty : ()Z
/*     */     //   6537: ifeq -> 6591
/*     */     //   6540: aload_0
/*     */     //   6541: invokevirtual getSide : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;
/*     */     //   6544: invokevirtual getHorizontal : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Horizontal;
/*     */     //   6547: getstatic net/ccbluex/liquidbounce/ui/client/hud/element/Side$Horizontal.LEFT : Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Horizontal;
/*     */     //   6550: if_acmpne -> 6573
/*     */     //   6553: new net/ccbluex/liquidbounce/ui/client/hud/element/Border
/*     */     //   6556: dup
/*     */     //   6557: fconst_0
/*     */     //   6558: ldc_w -1.0
/*     */     //   6561: ldc_w 20.0
/*     */     //   6564: ldc_w 20.0
/*     */     //   6567: invokespecial <init> : (FFFF)V
/*     */     //   6570: goto -> 6590
/*     */     //   6573: new net/ccbluex/liquidbounce/ui/client/hud/element/Border
/*     */     //   6576: dup
/*     */     //   6577: fconst_0
/*     */     //   6578: ldc_w -1.0
/*     */     //   6581: ldc_w -20.0
/*     */     //   6584: ldc_w 20.0
/*     */     //   6587: invokespecial <init> : (FFFF)V
/*     */     //   6590: areturn
/*     */     //   6591: aload_0
/*     */     //   6592: getfield modules : Ljava/util/List;
/*     */     //   6595: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   6600: astore #18
/*     */     //   6602: aload #18
/*     */     //   6604: invokeinterface hasNext : ()Z
/*     */     //   6609: ifeq -> 6742
/*     */     //   6612: aload #18
/*     */     //   6614: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   6619: checkcast net/ccbluex/liquidbounce/features/module/Module
/*     */     //   6622: astore #17
/*     */     //   6624: aload_0
/*     */     //   6625: invokevirtual getSide : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;
/*     */     //   6628: invokevirtual getHorizontal : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Horizontal;
/*     */     //   6631: getstatic net/ccbluex/liquidbounce/ui/client/hud/element/elements/Arraylist$WhenMappings.$EnumSwitchMapping$1 : [I
/*     */     //   6634: swap
/*     */     //   6635: invokevirtual ordinal : ()I
/*     */     //   6638: iaload
/*     */     //   6639: tableswitch default -> 6739, 1 -> 6664, 2 -> 6664, 3 -> 6703
/*     */     //   6664: aload #17
/*     */     //   6666: invokevirtual getSlide : ()F
/*     */     //   6669: f2i
/*     */     //   6670: ineg
/*     */     //   6671: iconst_2
/*     */     //   6672: isub
/*     */     //   6673: istore #19
/*     */     //   6675: aload_0
/*     */     //   6676: getfield x2 : I
/*     */     //   6679: ldc_w -2147483648
/*     */     //   6682: if_icmpeq -> 6694
/*     */     //   6685: iload #19
/*     */     //   6687: aload_0
/*     */     //   6688: getfield x2 : I
/*     */     //   6691: if_icmpge -> 6739
/*     */     //   6694: aload_0
/*     */     //   6695: iload #19
/*     */     //   6697: putfield x2 : I
/*     */     //   6700: goto -> 6739
/*     */     //   6703: aload #17
/*     */     //   6705: invokevirtual getSlide : ()F
/*     */     //   6708: f2i
/*     */     //   6709: bipush #14
/*     */     //   6711: iadd
/*     */     //   6712: istore #19
/*     */     //   6714: aload_0
/*     */     //   6715: getfield x2 : I
/*     */     //   6718: ldc_w -2147483648
/*     */     //   6721: if_icmpeq -> 6733
/*     */     //   6724: iload #19
/*     */     //   6726: aload_0
/*     */     //   6727: getfield x2 : I
/*     */     //   6730: if_icmple -> 6739
/*     */     //   6733: aload_0
/*     */     //   6734: iload #19
/*     */     //   6736: putfield x2 : I
/*     */     //   6739: goto -> 6602
/*     */     //   6742: aload_0
/*     */     //   6743: aload_0
/*     */     //   6744: invokevirtual getSide : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;
/*     */     //   6747: invokevirtual getVertical : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;
/*     */     //   6750: getstatic net/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical.DOWN : Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;
/*     */     //   6753: if_acmpne -> 6762
/*     */     //   6756: fload #13
/*     */     //   6758: fneg
/*     */     //   6759: goto -> 6764
/*     */     //   6762: fload #13
/*     */     //   6764: aload_0
/*     */     //   6765: getfield modules : Ljava/util/List;
/*     */     //   6768: invokeinterface size : ()I
/*     */     //   6773: i2f
/*     */     //   6774: fmul
/*     */     //   6775: putfield y2 : F
/*     */     //   6778: new net/ccbluex/liquidbounce/ui/client/hud/element/Border
/*     */     //   6781: dup
/*     */     //   6782: fconst_0
/*     */     //   6783: fconst_0
/*     */     //   6784: aload_0
/*     */     //   6785: getfield x2 : I
/*     */     //   6788: i2f
/*     */     //   6789: ldc_w 7.0
/*     */     //   6792: fsub
/*     */     //   6793: aload_0
/*     */     //   6794: getfield y2 : F
/*     */     //   6797: aload_0
/*     */     //   6798: invokevirtual getSide : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;
/*     */     //   6801: invokevirtual getVertical : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;
/*     */     //   6804: getstatic net/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical.DOWN : Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;
/*     */     //   6807: if_acmpne -> 6814
/*     */     //   6810: fconst_1
/*     */     //   6811: goto -> 6815
/*     */     //   6814: fconst_0
/*     */     //   6815: fsub
/*     */     //   6816: invokespecial <init> : (FFFF)V
/*     */     //   6819: areturn
/*     */     //   6820: getstatic net/ccbluex/liquidbounce/ui/font/AWTFontRenderer.Companion : Lnet/ccbluex/liquidbounce/ui/font/AWTFontRenderer$Companion;
/*     */     //   6823: iconst_0
/*     */     //   6824: invokevirtual setAssumeNonVolatile : (Z)V
/*     */     //   6827: invokestatic func_179117_G : ()V
/*     */     //   6830: aconst_null
/*     */     //   6831: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #102	-> 0
/*     */     //   #103	-> 8
/*     */     //   #105	-> 19
/*     */     //   #107	-> 27
/*     */     //   #110	-> 34
/*     */     //   #113	-> 38
/*     */     //   #114	-> 50
/*     */     //   #115	-> 62
/*     */     //   #116	-> 126
/*     */     //   #117	-> 190
/*     */     //   #118	-> 205
/*     */     //   #119	-> 220
/*     */     //   #120	-> 235
/*     */     //   #121	-> 235
/*     */     //   #120	-> 235
/*     */     //   #121	-> 265
/*     */     //   #120	-> 291
/*     */     //   #122	-> 299
/*     */     //   #123	-> 314
/*     */     //   #124	-> 321
/*     */     //   #125	-> 336
/*     */     //   #126	-> 351
/*     */     //   #127	-> 354
/*     */     //   #129	-> 387
/*     */     //   #130	-> 413
/*     */     //   #132	-> 421
/*     */     //   #134	-> 431
/*     */     //   #135	-> 484
/*     */     //   #148	-> 498
/*     */     //   #159	-> 512
/*     */     //   #136	-> 526
/*     */     //   #137	-> 534
/*     */     //   #138	-> 546
/*     */     //   #139	-> 572
/*     */     //   #141	-> 584
/*     */     //   #142	-> 595
/*     */     //   #143	-> 621
/*     */     //   #144	-> 627
/*     */     //   #146	-> 627
/*     */     //   #149	-> 650
/*     */     //   #150	-> 658
/*     */     //   #151	-> 670
/*     */     //   #152	-> 709
/*     */     //   #154	-> 721
/*     */     //   #155	-> 732
/*     */     //   #156	-> 772
/*     */     //   #157	-> 778
/*     */     //   #160	-> 781
/*     */     //   #161	-> 789
/*     */     //   #162	-> 801
/*     */     //   #163	-> 821
/*     */     //   #165	-> 840
/*     */     //   #166	-> 851
/*     */     //   #167	-> 871
/*     */     //   #168	-> 887
/*     */     //   #171	-> 890
/*     */     //   #172	-> 910
/*     */     //   #174	-> 935
/*     */     //   #176	-> 935
/*     */     //   #177	-> 952
/*     */     //   #181	-> 969
/*     */     //   #182	-> 990
/*     */     //   #181	-> 1013
/*     */     //   #184	-> 1016
/*     */     //   #185	-> 1034
/*     */     //   #186	-> 1062
/*     */     //   #188	-> 1075
/*     */     //   #190	-> 1091
/*     */     //   #207	-> 1152
/*     */     //   #191	-> 1166
/*     */     //   #206	-> 1180
/*     */     //   #192	-> 1208
/*     */     //   #193	-> 1216
/*     */     //   #194	-> 1227
/*     */     //   #195	-> 1235
/*     */     //   #196	-> 1244
/*     */     //   #195	-> 1256
/*     */     //   #194	-> 1259
/*     */     //   #196	-> 1260
/*     */     //   #194	-> 1263
/*     */     //   #197	-> 1267
/*     */     //   #199	-> 1285
/*     */     //   #200	-> 1293
/*     */     //   #201	-> 1302
/*     */     //   #200	-> 1314
/*     */     //   #199	-> 1317
/*     */     //   #201	-> 1318
/*     */     //   #199	-> 1321
/*     */     //   #202	-> 1325
/*     */     //   #203	-> 1340
/*     */     //   #206	-> 1343
/*     */     //   #208	-> 1385
/*     */     //   #209	-> 1396
/*     */     //   #210	-> 1424
/*     */     //   #212	-> 1442
/*     */     //   #213	-> 1470
/*     */     //   #214	-> 1485
/*     */     //   #216	-> 1488
/*     */     //   #217	-> 1495
/*     */     //   #218	-> 1495
/*     */     //   #219	-> 1501
/*     */     //   #220	-> 1521
/*     */     //   #127	-> 1528
/*     */     //   #223	-> 1531
/*     */     //   #225	-> 1572
/*     */     //   #226	-> 1588
/*     */     //   #227	-> 1602
/*     */     //   #228	-> 1605
/*     */     //   #271	-> 1642
/*     */     //   #228	-> 1655
/*     */     //   #287	-> 1658
/*     */     //   #288	-> 1661
/*     */     //   #291	-> 1673
/*     */     //   #292	-> 1689
/*     */     //   #293	-> 1703
/*     */     //   #294	-> 1706
/*     */     //   #295	-> 1713
/*     */     //   #296	-> 1720
/*     */     //   #297	-> 1723
/*     */     //   #298	-> 1726
/*     */     //   #720	-> 1738
/*     */     //   #721	-> 1741
/*     */     //   #721	-> 1793
/*     */     //   #299	-> 1805
/*     */     //   #300	-> 1813
/*     */     //   #301	-> 1826
/*     */     //   #302	-> 1847
/*     */     //   #301	-> 1870
/*     */     //   #303	-> 1873
/*     */     //   #304	-> 1880
/*     */     //   #305	-> 1890
/*     */     //   #722	-> 1895
/*     */     //   #307	-> 1896
/*     */     //   #318	-> 1944
/*     */     //   #319	-> 1947
/*     */     //   #321	-> 1959
/*     */     //   #723	-> 1971
/*     */     //   #724	-> 1974
/*     */     //   #724	-> 2026
/*     */     //   #323	-> 2038
/*     */     //   #326	-> 2046
/*     */     //   #328	-> 2057
/*     */     //   #330	-> 2081
/*     */     //   #331	-> 2084
/*     */     //   #332	-> 2135
/*     */     //   #333	-> 2138
/*     */     //   #334	-> 2202
/*     */     //   #335	-> 2287
/*     */     //   #337	-> 2295
/*     */     //   #338	-> 2360
/*     */     //   #340	-> 2374
/*     */     //   #341	-> 2374
/*     */     //   #342	-> 2427
/*     */     //   #343	-> 2432
/*     */     //   #344	-> 2485
/*     */     //   #345	-> 2512
/*     */     //   #346	-> 2646
/*     */     //   #344	-> 2648
/*     */     //   #340	-> 2648
/*     */     //   #348	-> 2651
/*     */     //   #349	-> 2683
/*     */     //   #350	-> 2686
/*     */     //   #351	-> 2739
/*     */     //   #352	-> 2747
/*     */     //   #353	-> 2764
/*     */     //   #354	-> 2781
/*     */     //   #355	-> 2798
/*     */     //   #356	-> 2815
/*     */     //   #357	-> 2832
/*     */     //   #360	-> 2844
/*     */     //   #357	-> 2844
/*     */     //   #358	-> 2931
/*     */     //   #359	-> 2935
/*     */     //   #358	-> 2935
/*     */     //   #359	-> 2948
/*     */     //   #358	-> 2949
/*     */     //   #359	-> 2950
/*     */     //   #357	-> 2965
/*     */     //   #360	-> 2968
/*     */     //   #357	-> 2972
/*     */     //   #362	-> 2988
/*     */     //   #351	-> 2990
/*     */     //   #363	-> 2990
/*     */     //   #349	-> 2992
/*     */     //   #366	-> 2998
/*     */     //   #367	-> 3018
/*     */     //   #368	-> 3079
/*     */     //   #369	-> 3080
/*     */     //   #370	-> 3157
/*     */     //   #371	-> 3174
/*     */     //   #372	-> 3191
/*     */     //   #373	-> 3208
/*     */     //   #374	-> 3225
/*     */     //   #375	-> 3242
/*     */     //   #378	-> 3254
/*     */     //   #375	-> 3254
/*     */     //   #376	-> 3341
/*     */     //   #377	-> 3345
/*     */     //   #376	-> 3345
/*     */     //   #377	-> 3358
/*     */     //   #376	-> 3359
/*     */     //   #377	-> 3360
/*     */     //   #375	-> 3375
/*     */     //   #378	-> 3378
/*     */     //   #375	-> 3382
/*     */     //   #380	-> 3398
/*     */     //   #368	-> 3400
/*     */     //   #383	-> 3402
/*     */     //   #384	-> 3421
/*     */     //   #385	-> 3422
/*     */     //   #386	-> 3473
/*     */     //   #387	-> 3514
/*     */     //   #386	-> 3524
/*     */     //   #388	-> 3530
/*     */     //   #389	-> 3550
/*     */     //   #390	-> 3561
/*     */     //   #389	-> 3571
/*     */     //   #391	-> 3574
/*     */     //   #392	-> 3597
/*     */     //   #391	-> 3599
/*     */     //   #393	-> 3602
/*     */     //   #394	-> 3625
/*     */     //   #396	-> 3647
/*     */     //   #397	-> 3689
/*     */     //   #396	-> 3691
/*     */     //   #398	-> 3694
/*     */     //   #399	-> 3725
/*     */     //   #400	-> 3750
/*     */     //   #399	-> 3752
/*     */     //   #403	-> 3758
/*     */     //   #404	-> 3782
/*     */     //   #406	-> 3785
/*     */     //   #407	-> 3805
/*     */     //   #408	-> 3826
/*     */     //   #410	-> 3850
/*     */     //   #411	-> 3881
/*     */     //   #414	-> 3914
/*     */     //   #415	-> 3934
/*     */     //   #416	-> 3955
/*     */     //   #419	-> 3982
/*     */     //   #420	-> 4002
/*     */     //   #422	-> 4028
/*     */     //   #424	-> 4028
/*     */     //   #425	-> 4047
/*     */     //   #426	-> 4048
/*     */     //   #427	-> 4114
/*     */     //   #428	-> 4165
/*     */     //   #429	-> 4206
/*     */     //   #428	-> 4216
/*     */     //   #430	-> 4222
/*     */     //   #431	-> 4242
/*     */     //   #432	-> 4253
/*     */     //   #431	-> 4263
/*     */     //   #433	-> 4266
/*     */     //   #434	-> 4289
/*     */     //   #433	-> 4291
/*     */     //   #435	-> 4294
/*     */     //   #436	-> 4317
/*     */     //   #438	-> 4339
/*     */     //   #439	-> 4381
/*     */     //   #438	-> 4383
/*     */     //   #440	-> 4386
/*     */     //   #441	-> 4417
/*     */     //   #442	-> 4442
/*     */     //   #441	-> 4444
/*     */     //   #445	-> 4450
/*     */     //   #446	-> 4474
/*     */     //   #448	-> 4477
/*     */     //   #449	-> 4497
/*     */     //   #450	-> 4518
/*     */     //   #452	-> 4542
/*     */     //   #453	-> 4573
/*     */     //   #456	-> 4606
/*     */     //   #457	-> 4626
/*     */     //   #458	-> 4647
/*     */     //   #461	-> 4674
/*     */     //   #462	-> 4694
/*     */     //   #464	-> 4720
/*     */     //   #467	-> 4720
/*     */     //   #725	-> 4725
/*     */     //   #471	-> 4728
/*     */     //   #472	-> 4744
/*     */     //   #473	-> 4758
/*     */     //   #474	-> 4761
/*     */     //   #518	-> 4798
/*     */     //   #474	-> 4812
/*     */     //   #537	-> 4815
/*     */     //   #538	-> 4818
/*     */     //   #541	-> 4830
/*     */     //   #542	-> 4846
/*     */     //   #543	-> 4860
/*     */     //   #544	-> 4863
/*     */     //   #545	-> 4870
/*     */     //   #546	-> 4877
/*     */     //   #547	-> 4880
/*     */     //   #548	-> 4883
/*     */     //   #726	-> 4895
/*     */     //   #727	-> 4898
/*     */     //   #727	-> 4950
/*     */     //   #549	-> 4962
/*     */     //   #550	-> 4970
/*     */     //   #551	-> 4983
/*     */     //   #552	-> 5004
/*     */     //   #551	-> 5027
/*     */     //   #553	-> 5030
/*     */     //   #554	-> 5037
/*     */     //   #555	-> 5046
/*     */     //   #728	-> 5051
/*     */     //   #557	-> 5052
/*     */     //   #571	-> 5101
/*     */     //   #572	-> 5104
/*     */     //   #575	-> 5116
/*     */     //   #729	-> 5128
/*     */     //   #730	-> 5131
/*     */     //   #730	-> 5183
/*     */     //   #576	-> 5195
/*     */     //   #578	-> 5203
/*     */     //   #579	-> 5213
/*     */     //   #580	-> 5252
/*     */     //   #581	-> 5276
/*     */     //   #582	-> 5279
/*     */     //   #583	-> 5330
/*     */     //   #584	-> 5333
/*     */     //   #585	-> 5397
/*     */     //   #586	-> 5482
/*     */     //   #587	-> 5490
/*     */     //   #588	-> 5555
/*     */     //   #590	-> 5569
/*     */     //   #591	-> 5569
/*     */     //   #592	-> 5570
/*     */     //   #593	-> 5575
/*     */     //   #594	-> 5608
/*     */     //   #596	-> 5635
/*     */     //   #599	-> 5635
/*     */     //   #596	-> 5635
/*     */     //   #597	-> 5747
/*     */     //   #598	-> 5751
/*     */     //   #597	-> 5751
/*     */     //   #598	-> 5764
/*     */     //   #597	-> 5765
/*     */     //   #598	-> 5766
/*     */     //   #596	-> 5781
/*     */     //   #599	-> 5784
/*     */     //   #596	-> 5788
/*     */     //   #600	-> 5804
/*     */     //   #594	-> 5806
/*     */     //   #590	-> 5806
/*     */     //   #603	-> 5809
/*     */     //   #604	-> 5822
/*     */     //   #605	-> 5839
/*     */     //   #606	-> 5856
/*     */     //   #607	-> 5873
/*     */     //   #608	-> 5890
/*     */     //   #609	-> 5907
/*     */     //   #612	-> 5919
/*     */     //   #609	-> 5919
/*     */     //   #610	-> 6006
/*     */     //   #611	-> 6010
/*     */     //   #610	-> 6010
/*     */     //   #611	-> 6023
/*     */     //   #610	-> 6024
/*     */     //   #611	-> 6025
/*     */     //   #609	-> 6040
/*     */     //   #612	-> 6043
/*     */     //   #609	-> 6047
/*     */     //   #614	-> 6063
/*     */     //   #603	-> 6065
/*     */     //   #615	-> 6065
/*     */     //   #603	-> 6067
/*     */     //   #616	-> 6073
/*     */     //   #617	-> 6105
/*     */     //   #618	-> 6125
/*     */     //   #619	-> 6126
/*     */     //   #620	-> 6143
/*     */     //   #621	-> 6160
/*     */     //   #622	-> 6177
/*     */     //   #623	-> 6194
/*     */     //   #624	-> 6211
/*     */     //   #627	-> 6223
/*     */     //   #624	-> 6223
/*     */     //   #625	-> 6310
/*     */     //   #626	-> 6314
/*     */     //   #625	-> 6314
/*     */     //   #626	-> 6327
/*     */     //   #625	-> 6328
/*     */     //   #626	-> 6329
/*     */     //   #624	-> 6344
/*     */     //   #627	-> 6347
/*     */     //   #624	-> 6351
/*     */     //   #629	-> 6367
/*     */     //   #618	-> 6369
/*     */     //   #632	-> 6371
/*     */     //   #633	-> 6372
/*     */     //   #634	-> 6393
/*     */     //   #633	-> 6412
/*     */     //   #635	-> 6418
/*     */     //   #636	-> 6438
/*     */     //   #637	-> 6464
/*     */     //   #636	-> 6474
/*     */     //   #638	-> 6477
/*     */     //   #641	-> 6477
/*     */     //   #731	-> 6482
/*     */     //   #643	-> 6483
/*     */     //   #646	-> 6483
/*     */     //   #647	-> 6521
/*     */     //   #649	-> 6528
/*     */     //   #650	-> 6540
/*     */     //   #651	-> 6553
/*     */     //   #653	-> 6573
/*     */     //   #650	-> 6590
/*     */     //   #656	-> 6591
/*     */     //   #657	-> 6624
/*     */     //   #659	-> 6664
/*     */     //   #660	-> 6675
/*     */     //   #663	-> 6703
/*     */     //   #664	-> 6714
/*     */     //   #666	-> 6739
/*     */     //   #656	-> 6739
/*     */     //   #668	-> 6742
/*     */     //   #670	-> 6778
/*     */     //   #673	-> 6820
/*     */     //   #674	-> 6827
/*     */     //   #675	-> 6830
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   431	538	20	width	I
/*     */     //   421	548	19	displayString	Ljava/lang/String;
/*     */     //   1091	407	20	size	F
/*     */     //   1016	512	19	yPos	F
/*     */     //   387	1141	17	module	Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   1873	17	34	yPos	F
/*     */     //   1826	64	33	wid	F
/*     */     //   1813	77	32	dString	Ljava/lang/String;
/*     */     //   1802	89	30	index	I
/*     */     //   1802	89	29	module	Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   1805	86	31	$i$a$-forEachIndexed-Arraylist$drawElement$3	I
/*     */     //   1769	123	25	item$iv	Ljava/lang/Object;
/*     */     //   1741	155	23	index$iv	I
/*     */     //   1735	161	21	$this$forEachIndexed$iv	Ljava/lang/Iterable;
/*     */     //   1738	158	22	$i$f$forEachIndexed	I
/*     */     //   1726	233	20	xP	F
/*     */     //   1723	236	19	yP	F
/*     */     //   1720	239	18	floatY	F
/*     */     //   1713	246	17	floatX	F
/*     */     //   3647	108	39	displayStrings	Ljava/lang/String;
/*     */     //   4339	108	39	displayStrings	Ljava/lang/String;
/*     */     //   3402	1318	38	rectColor	I
/*     */     //   3079	1641	37	customrect	Ljava/awt/Color;
/*     */     //   2683	2037	36	hud	Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;
/*     */     //   2374	2346	35	LiquidSlowly	I
/*     */     //   2360	2360	34	test	Ljava/lang/Integer;
/*     */     //   2287	2433	33	FadeColor	I
/*     */     //   2138	2582	32	CRainbow	I
/*     */     //   2084	2636	31	Sky	I
/*     */     //   2081	2639	30	moduleColor	I
/*     */     //   2057	2663	29	xPos	F
/*     */     //   2046	2674	28	displayString	Ljava/lang/String;
/*     */     //   2035	2686	26	index	I
/*     */     //   2035	2686	25	module	Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   2038	2683	27	$i$a$-forEachIndexed-Arraylist$drawElement$5	I
/*     */     //   2002	2720	21	item$iv	Ljava/lang/Object;
/*     */     //   1974	2751	19	index$iv	I
/*     */     //   1968	2757	17	$this$forEachIndexed$iv	Ljava/lang/Iterable;
/*     */     //   1971	2754	18	$i$f$forEachIndexed	I
/*     */     //   5030	16	34	yPos	F
/*     */     //   4983	63	33	wid	F
/*     */     //   4970	76	32	dString	Ljava/lang/String;
/*     */     //   4959	88	30	index	I
/*     */     //   4959	88	29	module	Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   4962	85	31	$i$a$-forEachIndexed-Arraylist$drawElement$8	I
/*     */     //   4926	122	25	item$iv	Ljava/lang/Object;
/*     */     //   4898	154	23	index$iv	I
/*     */     //   4892	160	21	$this$forEachIndexed$iv	Ljava/lang/Iterable;
/*     */     //   4895	157	22	$i$f$forEachIndexed	I
/*     */     //   4883	233	20	xP	F
/*     */     //   4880	236	19	yP	F
/*     */     //   4877	239	18	floatY	F
/*     */     //   4870	246	17	floatX	F
/*     */     //   6371	106	38	rectColor	I
/*     */     //   6105	372	37	hud	Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;
/*     */     //   5569	908	36	LiquidSlowly	I
/*     */     //   5555	922	35	test	Ljava/lang/Integer;
/*     */     //   5482	995	34	FadeColor	I
/*     */     //   5333	1144	33	CRainbow	I
/*     */     //   5279	1198	32	Sky	I
/*     */     //   5276	1201	31	moduleColor	I
/*     */     //   5252	1225	30	xPos	F
/*     */     //   5213	1264	29	width	I
/*     */     //   5203	1274	28	displayString	Ljava/lang/String;
/*     */     //   5192	1286	26	index	I
/*     */     //   5192	1286	25	module	Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   5195	1283	27	$i$a$-forEachIndexed-Arraylist$drawElement$10	I
/*     */     //   5159	1320	21	item$iv	Ljava/lang/Object;
/*     */     //   5131	1352	19	index$iv	I
/*     */     //   5125	1358	17	$this$forEachIndexed$iv	Ljava/lang/Iterable;
/*     */     //   5128	1355	18	$i$f$forEachIndexed	I
/*     */     //   6675	25	19	xPos	I
/*     */     //   6714	25	19	xPos	I
/*     */     //   6624	115	17	module	Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   354	6478	16	inx	I
/*     */     //   351	6481	15	brightness	F
/*     */     //   336	6496	14	saturation	F
/*     */     //   321	6511	13	textSpacer	F
/*     */     //   314	6518	12	textShadow	Z
/*     */     //   299	6533	11	backgroundCustomColor	I
/*     */     //   235	6597	10	textY	F
/*     */     //   220	6612	9	textHeight	F
/*     */     //   205	6627	8	space	F
/*     */     //   190	6642	7	rectCustomColor	I
/*     */     //   126	6706	6	customColor	I
/*     */     //   62	6770	5	rectColorMode	Ljava/lang/String;
/*     */     //   50	6782	4	colorMode	Ljava/lang/String;
/*     */     //   38	6794	3	delta	I
/*     */     //   27	6805	2	counter	[I
/*     */     //   19	6813	1	fontRenderer	Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   0	6832	0	this	Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Arraylist;
/*     */   }
/*     */   
/*     */   private final String getModTag(Module m) {
/*     */     if (!((Boolean)this.tags.get()).booleanValue() || m.getTag() == null)
/*     */       return ""; 
/*     */     String returnTag = ' ' + (((Boolean)this.tagsArrayColor.get()).booleanValue() ? "" : "§7");
/*     */     if (!StringsKt.equals((String)this.tagsStyleValue.get(), "default", true))
/*     */       returnTag = returnTag + String.valueOf(((String)this.tagsStyleValue.get()).charAt(0)) + ((StringsKt.equals((String)this.tagsStyleValue.get(), "-", true) || StringsKt.equals((String)this.tagsStyleValue.get(), "|", true)) ? " " : ""); 
/*     */     returnTag = returnTag + m.getTag();
/*     */     if (!StringsKt.equals((String)this.tagsStyleValue.get(), "default", true) && !StringsKt.equals((String)this.tagsStyleValue.get(), "-", true) && !StringsKt.equals((String)this.tagsStyleValue.get(), "|", true))
/*     */       returnTag = returnTag + String.valueOf(((String)this.tagsStyleValue.get()).charAt(1)); 
/*     */     return returnTag;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final String getModName(@NotNull Module mod) {
/*     */     Intrinsics.checkParameterIsNotNull(mod, "mod");
/*     */     Intrinsics.checkExpressionValueIsNotNull(StringUtils.breakString(mod.getTagName()), "StringUtils.breakString(mod.tagName)");
/*     */     String displayName = ((Boolean)this.nameBreak.get()).booleanValue() ? StringUtils.breakString(mod.getTagName()) : (mod.getName() + getModTag(mod));
/*     */     String str1 = (String)this.caseValue.get();
/*     */     boolean bool = false;
/*     */     if (str1 == null)
/*     */       throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */     Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()");
/*     */     str1 = str1.toLowerCase();
/*     */     switch (str1.hashCode()) {
/*     */       case 103164673:
/*     */         if (str1.equals("lower")) {
/*     */           String str = displayName;
/*     */           boolean bool1 = false;
/*     */           if (str == null)
/*     */             throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */           Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()");
/*     */           displayName = str.toLowerCase();
/*     */         } 
/*     */         break;
/*     */       case 111499426:
/*     */         if (str1.equals("upper")) {
/*     */           String str = displayName;
/*     */           boolean bool1 = false;
/*     */           if (str == null)
/*     */             throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */           Intrinsics.checkExpressionValueIsNotNull(str.toUpperCase(), "(this as java.lang.String).toUpperCase()");
/*     */           displayName = str.toUpperCase();
/*     */         } 
/*     */         break;
/*     */     } 
/*     */     return displayName;
/*     */   }
/*     */   
/*     */   public Arraylist() {
/*     */     this(0.0D, 0.0D, 0.0F, (Side)null, 15, (DefaultConstructorMarker)null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\Arraylist.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */