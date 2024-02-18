/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ import java.awt.Color;
/*     */ import kotlin.Unit;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IFontRenderer;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.AColorPalette;
/*     */ import net.ccbluex.liquidbounce.utils.CPSCounter;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.Palette;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.shader.shaders.RainbowFontShader;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ElementInfo(name = "Text")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\001\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\007\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\n\n\002\030\002\n\002\b\005\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\006\n\002\020\b\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\004\n\002\020\t\n\002\b\025\n\002\030\002\n\002\b\006\n\002\030\002\n\000\n\002\020\002\n\002\b\006\n\002\030\002\n\002\b\006\n\002\020\f\n\002\b\b\b\007\030\000 o2\0020\001:\001oB-\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006\022\b\b\002\020\007\032\0020\b¢\006\002\020\tJ\n\020W\032\004\030\0010XH\026J.\020Y\032\0020Z2\006\020\002\032\0020\0032\006\020\004\032\0020\0032\006\020[\032\0020\0032\006\020\\\032\0020\0032\006\020]\032\0020/J.\020Y\032\0020Z2\006\020\002\032\0020\0062\006\020\004\032\0020\0062\006\020[\032\0020\0062\006\020\\\032\0020\0062\006\020]\032\0020/J\022\020^\032\004\030\0010 2\006\020_\032\0020 H\002J\016\020`\032\0020Z2\006\020]\032\0020aJ\016\020`\032\0020Z2\006\020b\032\0020/J&\020`\032\0020Z2\006\020c\032\0020/2\006\020d\032\0020/2\006\020e\032\0020/2\006\020\016\032\0020/J\030\020f\032\0020Z2\006\020g\032\0020h2\006\020i\032\0020/H\026J \020j\032\0020Z2\006\020\002\032\0020\0032\006\020\004\032\0020\0032\006\020k\032\0020/H\026J\020\020l\032\0020 2\006\020_\032\0020 H\002J\016\020m\032\0020\0002\006\020g\032\0020aJ\b\020n\032\0020ZH\026R\016\020\n\032\0020\013X\004¢\006\002\n\000R\016\020\f\032\0020\rX\004¢\006\002\n\000R\021\020\016\032\0020\017¢\006\b\n\000\032\004\b\020\020\021R\016\020\022\032\0020\017X\004¢\006\002\n\000R\016\020\023\032\0020\017X\004¢\006\002\n\000R\016\020\024\032\0020\017X\004¢\006\002\n\000R\016\020\025\032\0020\017X\004¢\006\002\n\000R\021\020\026\032\0020\017¢\006\b\n\000\032\004\b\027\020\021R\016\020\030\032\0020\017X\004¢\006\002\n\000R\016\020\031\032\0020\032X\004¢\006\002\n\000R\016\020\033\032\0020\032X\004¢\006\002\n\000R\016\020\034\032\0020\013X\004¢\006\002\n\000R\016\020\035\032\0020\032X\004¢\006\002\n\000R\016\020\036\032\0020\rX\004¢\006\002\n\000R\024\020\037\032\0020 8BX\004¢\006\006\032\004\b!\020\"R\016\020#\032\0020$X\004¢\006\002\n\000R\016\020%\032\0020 X\016¢\006\002\n\000R\016\020&\032\0020\017X\004¢\006\002\n\000R\032\020'\032\0020(X\016¢\006\016\n\000\032\004\b)\020*\"\004\b+\020,R\016\020-\032\0020(X\016¢\006\002\n\000R\016\020.\032\0020/X\016¢\006\002\n\000R\016\0200\032\00201X\016¢\006\002\n\000R\021\0202\032\0020\017¢\006\b\n\000\032\004\b3\020\021R\016\0204\032\0020\017X\004¢\006\002\n\000R\021\0205\032\00206¢\006\b\n\000\032\004\b7\0208R\016\0209\032\0020\017X\004¢\006\002\n\000R\016\020:\032\0020;X\016¢\006\002\n\000R\021\020<\032\0020\017¢\006\b\n\000\032\004\b=\020\021R\016\020>\032\0020\013X\004¢\006\002\n\000R\016\020?\032\0020\013X\004¢\006\002\n\000R\016\020@\032\0020\013X\004¢\006\002\n\000R\016\020A\032\0020\013X\004¢\006\002\n\000R\016\020B\032\0020\032X\004¢\006\002\n\000R\021\020C\032\0020\013¢\006\b\n\000\032\004\bD\020ER\016\020F\032\0020\rX\004¢\006\002\n\000R\016\020G\032\0020\013X\004¢\006\002\n\000R\016\020H\032\0020\032X\004¢\006\002\n\000R\016\020I\032\0020\032X\004¢\006\002\n\000R\016\020J\032\0020\017X\004¢\006\002\n\000R\032\020K\032\0020/X\016¢\006\016\n\000\032\004\bL\020M\"\004\bN\020OR\032\020P\032\0020QX\016¢\006\016\n\000\032\004\bR\020S\"\004\bT\020UR\016\020V\032\0020 X\016¢\006\002\n\000¨\006p"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Text;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "scale", "", "side", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;", "(DDFLnet/ccbluex/liquidbounce/ui/client/hud/element/Side;)V", "BlurStrength", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "Mode", "Lnet/ccbluex/liquidbounce/value/ListValue;", "alpha", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "getAlpha", "()Lnet/ccbluex/liquidbounce/value/IntegerValue;", "amountValue", "astolfoRainbowIndex", "astolfoRainbowOffset", "astolfoclient", "b", "getB", "balpha", "blurValuee", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "bord", "brightnessValue", "char", "colorModeValue", "display", "", "getDisplay", "()Ljava/lang/String;", "displayString", "Lnet/ccbluex/liquidbounce/value/TextValue;", "displayText", "distanceValue", "doslide", "", "getDoslide", "()Z", "setDoslide", "(Z)V", "editMode", "editTicks", "", "fontValue", "Lnet/ccbluex/liquidbounce/value/FontValue;", "g", "getG", "gidentspeed", "hud", "Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;", "getHud", "()Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;", "newRainbowIndex", "prevClick", "", "r", "getR", "radiusValue", "rainbowX", "rainbowY", "saturationValue", "shadow", "shadowStrength", "getShadowStrength", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "shadowValue", "shadowValuee", "shadows", "slide", "slidedelay", "slidetext", "getSlidetext", "()I", "setSlidetext", "(I)V", "slidetimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "getSlidetimer", "()Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "setSlidetimer", "(Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;)V", "speedStr", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "drawRect", "", "x2", "y2", "color", "getReplacement", "str", "glColor", "Ljava/awt/Color;", "hex", "red", "green", "blue", "handleKey", "c", "", "keyCode", "handleMouseClick", "mouseButton", "multiReplace", "setColor", "updateElement", "Companion", "XSJClient"})
/*     */ public final class Text extends Element {
/*     */   private final BoolValue shadows;
/*     */   @NotNull
/*     */   private final FloatValue shadowStrength;
/*     */   private final ListValue colorModeValue;
/*     */   private final FloatValue brightnessValue;
/*     */   private final TextValue displayString;
/*     */   private final ListValue Mode;
/*     */   private final ListValue shadowValue;
/*     */   @NotNull
/*     */   private final IntegerValue r;
/*     */   @NotNull
/*     */   private final IntegerValue g;
/*     */   @NotNull
/*     */   private final IntegerValue b;
/*     */   @NotNull
/*     */   private final IntegerValue alpha;
/*     */   
/*     */   public Text(double x, double y, float scale, @NotNull Side side) {
/*  40 */     super(x, y, scale, side);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  63 */     this.shadows = new BoolValue("Text-shadow-bug+", false);
/*  64 */     this.shadowStrength = new FloatValue("Text-Shadow-Strength-bug+", 1.0F, 0.01F, 20.0F);
/*  65 */     this.colorModeValue = new ListValue("Text-Color", new String[] { "Custom", "Rainbow", "Fade", "Astolfo", "NewRainbow", "Gident" }, "Custom");
/*  66 */     this.brightnessValue = new FloatValue("Brightness", 1.0F, 0.0F, 1.0F);
/*  67 */     this.displayString = new TextValue("DisplayText", "");
/*  68 */     this.Mode = new ListValue("Border-Mode", new String[] { "Slide", "Skeet", "Top", "Onetap" }, "Onetap");
/*  69 */     this.shadowValue = new ListValue("Top-Shadow", new String[] { "None", "Basic", "Thick" }, "Thick");
/*  70 */     this.r = new IntegerValue("Top-bg-Red", 0, 0, 255);
/*  71 */     this.g = new IntegerValue("Top-bg-Green", 0, 0, 255);
/*  72 */     this.b = new IntegerValue("Top-bg-Blue", 0, 0, 255);
/*  73 */     this.alpha = new IntegerValue("Top-BG-Alpha", 100, 0, 255);
/*  74 */     this.blurValuee = new BoolValue("Top-Blur", true);
/*  75 */     this.BlurStrength = new FloatValue("BlurStrength", 5.0F, 0.0F, 20.0F);
/*  76 */     this.shadowValuee = new FloatValue("ShadowStrength", 10.0F, 0.0F, 20.0F);
/*  77 */     this.radiusValue = new FloatValue("Top-Radius", 3.0F, 0.0F, 10.0F);
/*  78 */     this.gidentspeed = new IntegerValue("GidentSpeed", 100, 1, 1000);
/*  79 */     this.newRainbowIndex = new IntegerValue("NewRainbowOffset", 1, 1, 50);
/*  80 */     this.astolfoRainbowOffset = new IntegerValue("AstolfoOffset", 5, 1, 20);
/*  81 */     this.astolfoclient = new IntegerValue("AstolfoRange", 109, 1, 765);
/*  82 */     this.astolfoRainbowIndex = new IntegerValue("AstolfoIndex", 109, 1, 300);
/*  83 */     this.saturationValue = new FloatValue("Saturation", 0.9F, 0.0F, 1.0F);
/*  84 */     this.rainbowX = new FloatValue("Rainbow-X", -1000.0F, -2000.0F, 2000.0F);
/*  85 */     this.rainbowY = new FloatValue("Rainbow-Y", -1000.0F, -2000.0F, 2000.0F);
/*  86 */     this.shadow = new BoolValue("Text-Shadow", true);
/*  87 */     this.bord = new BoolValue("Border", true);
/*  88 */     this.slide = new BoolValue("Slide", false);
/*  89 */     this.char = new BoolValue("NotChar", false);
/*  90 */     this.slidedelay = new IntegerValue("SlideDelay", 100, 0, 1000);
/*  91 */     this.balpha = new IntegerValue("BordAlpha", 255, 0, 255);
/*  92 */     this.distanceValue = new IntegerValue("Distance", 0, 0, 400);
/*  93 */     this.amountValue = new IntegerValue("Amount", 25, 1, 50);
/*  94 */     Intrinsics.checkExpressionValueIsNotNull(Fonts.productSans40, "Fonts.productSans40"); this.fontValue = new FontValue("Font", Fonts.productSans40);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 100 */     this.speedStr = "";
/* 101 */     this.displayText = "";
/* 102 */     if (Retreat.INSTANCE.getModuleManager().get(HUD.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.HUD");  this.hud = (HUD)Retreat.INSTANCE.getModuleManager().get(HUD.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 210 */     this.slidetimer = new MSTimer();
/* 211 */     this.doslide = true;
/*     */   }
/*     */   
/*     */   private final BoolValue blurValuee;
/*     */   private final FloatValue BlurStrength;
/*     */   private final FloatValue shadowValuee;
/*     */   private final FloatValue radiusValue;
/*     */   private final IntegerValue gidentspeed;
/*     */   private final IntegerValue newRainbowIndex;
/*     */   private final IntegerValue astolfoRainbowOffset;
/*     */   private final IntegerValue astolfoclient;
/*     */   private final IntegerValue astolfoRainbowIndex;
/*     */   private final FloatValue saturationValue;
/*     */   private final FloatValue rainbowX;
/*     */   private final FloatValue rainbowY;
/*     */   private final BoolValue shadow;
/*     */   private final BoolValue bord;
/*     */   private final BoolValue slide;
/*     */   private final BoolValue char;
/*     */   private final IntegerValue slidedelay;
/*     */   private final IntegerValue balpha;
/*     */   private final IntegerValue distanceValue;
/*     */   private final IntegerValue amountValue;
/*     */   private FontValue fontValue;
/*     */   private boolean editMode;
/*     */   private int editTicks;
/*     */   private long prevClick;
/*     */   private String speedStr;
/*     */   private String displayText;
/*     */   @NotNull
/*     */   private final HUD hud;
/*     */   private int slidetext;
/*     */   @NotNull
/*     */   private MSTimer slidetimer;
/*     */   private boolean doslide;
/*     */   @NotNull
/*     */   private static final SimpleDateFormat DATE_FORMAT;
/*     */   @NotNull
/*     */   private static final SimpleDateFormat HOUR_FORMAT;
/*     */   @NotNull
/*     */   private static final DecimalFormat DECIMAL_FORMAT;
/*     */   @NotNull
/*     */   private static final DecimalFormat DECIMAL_FORMAT_INT;
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class Text$drawElement$1
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 261 */       GL11.glPushMatrix();
/* 262 */       GL11.glTranslated(Text.this.getRenderX(), Text.this.getRenderY(), 0.0D);
/* 263 */       GL11.glScalef(Text.this.getScale(), Text.this.getScale(), Text.this.getScale());
/* 264 */       RenderUtils.drawRoundedRect2(-2.0F, -2.0F, (this.$fontRenderer.getStringWidth(Text.this.displayText) + 2), this.$fontRenderer.getFontHeight(), 0.0F, (new Color(0, 0, 0)).getRGB());
/* 265 */       GL11.glPopMatrix();
/*     */     } Text$drawElement$1(IFontRenderer param1IFontRenderer) { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class Text$drawElement$2 extends Lambda implements Function0<Unit> { public final void invoke() {
/* 268 */       GL11.glPushMatrix();
/* 269 */       GL11.glTranslated(Text.this.getRenderX(), Text.this.getRenderY(), 0.0D);
/* 270 */       GL11.glScalef(Text.this.getScale(), Text.this.getScale(), Text.this.getScale());
/* 271 */       GlStateManager.func_179147_l();
/* 272 */       GlStateManager.func_179090_x();
/* 273 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/* 274 */       RenderUtils.drawRoundedRect2(-2.0F, -2.0F, (this.$fontRenderer.getStringWidth(Text.this.displayText) + 2), this.$fontRenderer.getFontHeight(), 0.0F, (new Color(0, 0, 0)).getRGB());
/* 275 */       GlStateManager.func_179098_w();
/* 276 */       GlStateManager.func_179084_k();
/* 277 */       GL11.glPopMatrix();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Text$drawElement$2(IFontRenderer param1IFontRenderer) {
/*     */       super(0);
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class Text$drawElement$3
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 304 */       GL11.glPushMatrix();
/* 305 */       GL11.glTranslated(Text.this.getRenderX(), Text.this.getRenderY(), 0.0D);
/* 306 */       GL11.glScalef(Text.this.getScale(), Text.this.getScale(), Text.this.getScale());
/* 307 */       RenderUtils.drawRoundedRect2(-2.85F, -3.0F, this.$fontRenderer.getStringWidth(Text.this.displayText) + 0.91F, this.$fontRenderer.getFontHeight() + 4.12F, ((Number)Text.this.radiusValue.get()).floatValue() + 0.3F, (new Color(0, 0, 0)).getRGB());
/* 308 */       GL11.glPopMatrix();
/*     */     } Text$drawElement$3(IFontRenderer param1IFontRenderer) { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class Text$drawElement$4 extends Lambda implements Function0<Unit> { public final void invoke() {
/* 311 */       GL11.glPushMatrix();
/* 312 */       GL11.glTranslated(Text.this.getRenderX(), Text.this.getRenderY(), 0.0D);
/* 313 */       GL11.glScalef(Text.this.getScale(), Text.this.getScale(), Text.this.getScale());
/* 314 */       GlStateManager.func_179147_l();
/* 315 */       GlStateManager.func_179090_x();
/* 316 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/* 317 */       RenderUtils.drawRoundedRect2(-2.85F, -3.0F, this.$fontRenderer.getStringWidth(Text.this.displayText) + 0.91F, this.$fontRenderer.getFontHeight() + 4.12F, ((Number)Text.this.radiusValue.get()).floatValue() + 0.3F, (new Color(0, 0, 0)).getRGB());
/* 318 */       GlStateManager.func_179098_w();
/* 319 */       GlStateManager.func_179084_k();
/* 320 */       GL11.glPopMatrix();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Text$drawElement$4(IFontRenderer param1IFontRenderer) {
/*     */       super(0);
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class Text$drawElement$7
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     Text$drawElement$7(IFontRenderer param1IFontRenderer, int[] param1ArrayOfint, int param1Int) {
/*     */       super(0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void invoke() {
/* 446 */       GL11.glPushMatrix();
/* 447 */       GL11.glTranslated(Text.this.getRenderX(), Text.this.getRenderY(), 0.0D);
/*     */       
/* 449 */       String str1 = (String)Text.this.colorModeValue.get(); float f2 = 0.0F * Text.this.getScale(), f1 = 0.0F * Text.this.getScale(); String str2 = Text.this.displayText; IFontRenderer iFontRenderer = this.$fontRenderer; boolean bool = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()"); String str3 = str1.toLowerCase(); switch (str1.hashCode())
/*     */       
/*     */       { case 961091784:
/* 452 */           if (str1.equals("Astolfo"));case -1656737386: if (str1.equals("Rainbow"));
/* 453 */         case 2132719113: if (str1.equals("Gident")) Intrinsics.checkExpressionValueIsNotNull(RenderUtils.getGradientOffset(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), 1), Math.abs(System.currentTimeMillis() / ((Number)Text.this.gidentspeed.get()).intValue() + this.$counter[0]) / 10), "RenderUtils.getGradientO…le() + counter[0]) / 10))"); 
/* 454 */         case -733196266: if (str1.equals("NewRainbow"));case 2181788: if (str1.equals("Fade"))
/* 455 */             Intrinsics.checkExpressionValueIsNotNull(Palette.fade2(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), this.$counter[0] * 100, Text.this.displayText.length() * 200), "Palette.fade2(Color(ACol…displayText.length * 200)"); default: break; }  iFontRenderer.drawString(str2, f1, f2, this.$color, 
/* 456 */           false);
/* 457 */       GL11.glPopMatrix(); } } @Nullable public Border drawElement() { IFontRenderer fontRenderer = (IFontRenderer)this.fontValue.get(); float length2 = 4.5F; String str1 = this.displayText; byte b = 0; if (str1 == null)
/*     */       throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toCharArray(), "(this as java.lang.String).toCharArray()"); char[] charArray = str1.toCharArray(); if (((Boolean)this.char.get()).booleanValue()) {
/*     */       length2 = fontRenderer.getStringWidth(this.displayText);
/*     */     } else {
/*     */       for (char charIndex : charArray)
/*     */         length2 += fontRenderer.getStringWidth(String.valueOf(charIndex)); 
/*     */     }  if (((Boolean)this.slide.get()).booleanValue() && !MinecraftInstance.classProvider.isGuiHudDesigner(MinecraftInstance.mc.getCurrentScreen())) {
/*     */       if (this.slidetimer.hasTimePassed(((Number)this.slidedelay.get()).intValue()))
/*     */         if (this.slidetext <= getDisplay().length() && this.doslide) {
/*     */           this.slidetext++; this.slidetimer.reset();
/*     */         } else if (!this.doslide && this.slidetext >= 0) {
/*     */           this.slidetext--; this.slidetimer.reset();
/*     */         }   if (this.slidetext == getDisplay().length() && this.doslide) {
/*     */         this.doslide = false;
/*     */       } else if (this.slidetext == 0 && !this.doslide) {
/*     */         this.doslide = true;
/*     */       }  str1 = getDisplay(); b = 0; int i = this.slidetext; Text text = this; boolean bool = false; if (str1 == null)
/*     */         throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.substring(b, i), "(this as java.lang.Strin…ing(startIndex, endIndex)"); String str = str1.substring(b, i);
/*     */     } else {
/*     */       this.displayText = getDisplay();
/*     */     }  if (Retreat.INSTANCE.getModuleManager().get(HUD.class) == null)
/*     */       throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.HUD");  HUD hud = (HUD)Retreat.INSTANCE.getModuleManager().get(HUD.class); int mwc1 = (new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue())).getRGB(); int mwc2 = (new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue())).getRGB(); if (((String)this.Mode.get()).equals("Top")) {
/*     */       String str = (String)this.shadowValue.get(); switch (str.hashCode()) {
/*     */         case 63955982:
/*     */           if (str.equals("Basic"))
/*     */             RenderUtils.drawShadow(-2.5F, -2.5F, (fontRenderer.getStringWidth(this.displayText) + 2), fontRenderer.getFontHeight());  break;
/*     */         case -1819712192:
/*     */           if (str.equals("Shadow")) {
/*     */             GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); ShadowUtils.shadow(((Number)this.shadowValuee.get()).floatValue(), new Text$drawElement$1(fontRenderer), new Text$drawElement$2(fontRenderer)); GL11.glPopMatrix(); GL11.glScalef(getScale(), getScale(), getScale()); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */           }  break;
/*     */         case 80778109:
/*     */           if (str.equals("Thick")) {
/*     */             RenderUtils.drawShadow(-2.0F, -2.0F, (fontRenderer.getStringWidth(this.displayText) + 2), fontRenderer.getFontHeight());
/*     */             RenderUtils.drawShadow(-2.0F, -2.0F, (fontRenderer.getStringWidth(this.displayText) + 2), fontRenderer.getFontHeight());
/*     */           } 
/*     */           break;
/*     */       } 
/*     */       if (((Boolean)this.blurValuee.get()).booleanValue()) {
/*     */         GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D);
/*     */         GL11.glPushMatrix();
/*     */         BlurBuffer.blurRoundArea((float)getRenderX() - 0.5F, (float)getRenderY(), (fontRenderer.getStringWidth(this.displayText) + 2) + true, fontRenderer.getFontHeight(), 0);
/*     */         GL11.glPopMatrix();
/*     */         GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */       } 
/*     */       RoundedUtil.drawRound(-2.0F, -2.0F, (fontRenderer.getStringWidth(this.displayText) + 2), fontRenderer.getFontHeight(), 0.0F, new Color(0, 0, 0, 100));
/*     */       RenderUtils.drawGradientSideways(-3.0D, -3.0D, (fontRenderer.getStringWidth(this.displayText) + 2), -2.0D, mwc1, mwc2);
/*     */     } 
/*     */     if (((String)this.Mode.get()).equals("Onetap")) {
/*     */       RoundedUtil.drawRound(-2.8F, -3.0F, fontRenderer.getStringWidth(this.displayText) + 0.91F, fontRenderer.getFontHeight() + 4.12F, ((Number)this.radiusValue.get()).floatValue() + 0.5F, new Color(((Number)this.r.get()).intValue(), ((Number)this.g.get()).intValue(), ((Number)this.b.get()).intValue(), ((Number)this.alpha.get()).intValue()));
/*     */       GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D);
/*     */       GL11.glScalef(1.0F, 1.0F, 1.0F);
/*     */       GL11.glPushMatrix();
/*     */       ShadowUtils.shadow(((Number)this.shadowValuee.get()).floatValue(), new Text$drawElement$3(fontRenderer), new Text$drawElement$4(fontRenderer));
/*     */       GL11.glPopMatrix();
/*     */       GL11.glScalef(getScale(), getScale(), getScale());
/*     */       GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */       if (((Boolean)this.blurValuee.get()).booleanValue()) {
/*     */         GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D);
/*     */         GL11.glPushMatrix();
/*     */         BlurUtils.CustomBlurRoundArea((float)getRenderX() - 4.6F, (float)getRenderY() - 3.8F, fontRenderer.getStringWidth(this.displayText) + 3.85F, fontRenderer.getFontHeight() + 5.8F, ((Number)this.radiusValue.get()).floatValue(), ((Number)this.BlurStrength.get()).floatValue());
/*     */         GL11.glPopMatrix();
/*     */         GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */       } 
/*     */     } 
/*     */     String colorMode = (String)this.colorModeValue.get();
/*     */     int color = (new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue())).getRGB();
/*     */     boolean rainbow = StringsKt.equals(colorMode, "Rainbow", true);
/*     */     if (((Boolean)this.bord.get()).booleanValue()) {
/*     */       if (Intrinsics.areEqual(this.Mode.get(), "Skeet")) {
/*     */         RenderUtils.autoExhibition(-4.0D, -5.2D, length2, fontRenderer.getFontHeight() + 1.5D, 1.0D);
/*     */         double barLength = length2;
/*     */         byte b1 = 0;
/*     */         int i = ((Number)this.amountValue.get()).intValue() - 1;
/*     */         if (b1 <= i)
/*     */           while (true) {
/*     */             double barStart = b1 / ((Number)this.amountValue.get()).intValue() * barLength;
/*     */             double barEnd = (b1 + 1) / ((Number)this.amountValue.get()).intValue() * barLength;
/*     */             Intrinsics.checkExpressionValueIsNotNull(Palette.fade2(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), b1 * ((Number)this.distanceValue.get()).intValue(), this.displayText.length() * 200), "Palette.fade2(Color(ACol…displayText.length * 200)");
/*     */             Intrinsics.checkExpressionValueIsNotNull(RenderUtils.getGradientOffset(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), 1), Math.abs(System.currentTimeMillis() / ((Number)this.gidentspeed.get()).intValue() + (b1 * ((Number)this.distanceValue.get()).intValue())) / 10), "RenderUtils.getGradientO…stanceValue.get()) / 10))");
/*     */             Intrinsics.checkExpressionValueIsNotNull(Palette.fade2(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), b1 * ((Number)this.distanceValue.get()).intValue(), this.displayText.length() * 200), "Palette.fade2(Color(ACol…displayText.length * 200)");
/*     */             Intrinsics.checkExpressionValueIsNotNull(RenderUtils.getGradientOffset(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), 1), Math.abs(System.currentTimeMillis() / ((Number)this.gidentspeed.get()).intValue() + (b1 * ((Number)this.distanceValue.get()).intValue())) / 10), "RenderUtils.getGradientO…stanceValue.get()) / 10))");
/*     */             RenderUtils.drawGradientSideways(-1.4D + barStart, -2.7D, -1.4D + barEnd, -2.0D, rainbow ? 0 : (StringsKt.equals(colorMode, "Fade", true) ? Palette.fade2(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), b1 * ((Number)this.distanceValue.get()).intValue(), this.displayText.length() * 200).getRGB() : (StringsKt.equals(colorMode, "Astolfo", true) ? RenderUtils.Astolfo(b1 * ((Number)this.distanceValue.get()).intValue(), ((Number)this.saturationValue.get()).floatValue(), ((Number)this.brightnessValue.get()).floatValue(), ((Number)this.astolfoRainbowOffset.get()).intValue(), ((Number)this.astolfoRainbowIndex.get()).intValue(), ((Number)this.astolfoclient.get()).intValue()) : (StringsKt.equals(colorMode, "Gident", true) ? RenderUtils.getGradientOffset(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), 1), Math.abs(System.currentTimeMillis() / ((Number)this.gidentspeed.get()).intValue() + (b1 * ((Number)this.distanceValue.get()).intValue())) / 10).getRGB() : (StringsKt.equals(colorMode, "NewRainbow", true) ? RenderUtils.getRainbow(b1 * ((Number)this.distanceValue.get()).intValue(), ((Number)this.newRainbowIndex.get()).intValue(), ((Number)this.saturationValue.get()).floatValue(), ((Number)this.brightnessValue.get()).floatValue()) : color)))), rainbow ? 0 : (StringsKt.equals(colorMode, "Fade", true) ? Palette.fade2(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), b1 * ((Number)this.distanceValue.get()).intValue(), this.displayText.length() * 200).getRGB() : (StringsKt.equals(colorMode, "Astolfo", true) ? RenderUtils.Astolfo(b1 * ((Number)this.distanceValue.get()).intValue(), ((Number)this.saturationValue.get()).floatValue(), ((Number)this.brightnessValue.get()).floatValue(), ((Number)this.astolfoRainbowOffset.get()).intValue(), ((Number)this.astolfoRainbowIndex.get()).intValue(), ((Number)this.astolfoclient.get()).intValue()) : (StringsKt.equals(colorMode, "Gident", true) ? RenderUtils.getGradientOffset(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), 1), Math.abs(System.currentTimeMillis() / ((Number)this.gidentspeed.get()).intValue() + (b1 * ((Number)this.distanceValue.get()).intValue())) / 10).getRGB() : (StringsKt.equals(colorMode, "NewRainbow", true) ? RenderUtils.getRainbow(b1 * ((Number)this.distanceValue.get()).intValue(), ((Number)this.newRainbowIndex.get()).intValue(), ((Number)this.saturationValue.get()).floatValue(), ((Number)this.brightnessValue.get()).floatValue()) : color)))));
/*     */             if (b1 != i) {
/*     */               b1++;
/*     */               continue;
/*     */             } 
/*     */             break;
/*     */           }  
/*     */       } 
/*     */       if (Intrinsics.areEqual(this.Mode.get(), "Slide")) {
/*     */         RenderUtils.drawRect(-4.0F, -4.5F, length2, fontRenderer.getFontHeight(), (new Color(0, 0, 0, ((Number)this.balpha.get()).intValue())).getRGB());
/*     */         double barLength = (length2 + true);
/*     */         int i = 0, j = ((Number)this.amountValue.get()).intValue() - 1;
/*     */         if (i <= j)
/*     */           while (true) {
/*     */             double barStart = i / ((Number)this.amountValue.get()).intValue() * barLength;
/*     */             double barEnd = (i + 1) / ((Number)this.amountValue.get()).intValue() * barLength;
/*     */             Intrinsics.checkExpressionValueIsNotNull(Palette.fade2(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), i * ((Number)this.distanceValue.get()).intValue(), this.displayText.length() * 200), "Palette.fade2(Color(ACol…displayText.length * 200)");
/*     */             Intrinsics.checkExpressionValueIsNotNull(RenderUtils.getGradientOffset(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), 1), Math.abs(System.currentTimeMillis() / ((Number)this.gidentspeed.get()).intValue() + (i * ((Number)this.distanceValue.get()).intValue())) / 10), "RenderUtils.getGradientO…stanceValue.get()) / 10))");
/*     */             Intrinsics.checkExpressionValueIsNotNull(Palette.fade2(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), i * ((Number)this.distanceValue.get()).intValue(), this.displayText.length() * 200), "Palette.fade2(Color(ACol…displayText.length * 200)");
/*     */             Intrinsics.checkExpressionValueIsNotNull(RenderUtils.getGradientOffset(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), 1), Math.abs(System.currentTimeMillis() / ((Number)this.gidentspeed.get()).intValue() + (i * ((Number)this.distanceValue.get()).intValue())) / 10), "RenderUtils.getGradientO…stanceValue.get()) / 10))");
/*     */             RenderUtils.drawGradientSideways(-4.0D + barStart, -4.2D, -1.0D + barEnd, -3.0D, rainbow ? 0 : (StringsKt.equals(colorMode, "Fade", true) ? Palette.fade2(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), i * ((Number)this.distanceValue.get()).intValue(), this.displayText.length() * 200).getRGB() : (StringsKt.equals(colorMode, "Astolfo", true) ? RenderUtils.Astolfo(i * ((Number)this.distanceValue.get()).intValue(), ((Number)this.saturationValue.get()).floatValue(), ((Number)this.brightnessValue.get()).floatValue(), ((Number)this.astolfoRainbowOffset.get()).intValue(), ((Number)this.astolfoRainbowIndex.get()).intValue(), ((Number)this.astolfoclient.get()).intValue()) : (StringsKt.equals(colorMode, "Gident", true) ? RenderUtils.getGradientOffset(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), 1), Math.abs(System.currentTimeMillis() / ((Number)this.gidentspeed.get()).intValue() + (i * ((Number)this.distanceValue.get()).intValue())) / 10).getRGB() : (StringsKt.equals(colorMode, "NewRainbow", true) ? RenderUtils.getRainbow(i * ((Number)this.distanceValue.get()).intValue(), ((Number)this.newRainbowIndex.get()).intValue(), ((Number)this.saturationValue.get()).floatValue(), ((Number)this.brightnessValue.get()).floatValue()) : color)))), rainbow ? 0 : (StringsKt.equals(colorMode, "Fade", true) ? Palette.fade2(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), i * ((Number)this.distanceValue.get()).intValue(), this.displayText.length() * 200).getRGB() : (StringsKt.equals(colorMode, "Astolfo", true) ? RenderUtils.Astolfo(i * ((Number)this.distanceValue.get()).intValue(), ((Number)this.saturationValue.get()).floatValue(), ((Number)this.brightnessValue.get()).floatValue(), ((Number)this.astolfoRainbowOffset.get()).intValue(), ((Number)this.astolfoRainbowIndex.get()).intValue(), ((Number)this.astolfoclient.get()).intValue()) : (StringsKt.equals(colorMode, "Gident", true) ? RenderUtils.getGradientOffset(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), 1), Math.abs(System.currentTimeMillis() / ((Number)this.gidentspeed.get()).intValue() + (i * ((Number)this.distanceValue.get()).intValue())) / 10).getRGB() : (StringsKt.equals(colorMode, "NewRainbow", true) ? RenderUtils.getRainbow(i * ((Number)this.distanceValue.get()).intValue(), ((Number)this.newRainbowIndex.get()).intValue(), ((Number)this.saturationValue.get()).floatValue(), ((Number)this.brightnessValue.get()).floatValue()) : color)))));
/*     */             if (i != j) {
/*     */               i++;
/*     */               continue;
/*     */             } 
/*     */             break;
/*     */           }  
/*     */       } 
/*     */     } 
/*     */     int[] counter = { 0 };
/*     */     if (((Boolean)this.char.get()).booleanValue())
/*     */     { boolean bool = StringsKt.equals(colorMode, "Rainbow", true);
/*     */       float f1 = (((Number)this.rainbowX.get()).floatValue() == 0.0F) ? 0.0F : (1.0F / ((Number)this.rainbowX.get()).floatValue()), f2 = (((Number)this.rainbowY.get()).floatValue() == 0.0F) ? 0.0F : (1.0F / ((Number)this.rainbowY.get()).floatValue()), offset$iv = (float)(System.currentTimeMillis() % 10000L) / 10000.0F;
/*     */       int $i$f$begin = 0;
/* 572 */       if (bool) {
/* 573 */         RainbowFontShader.INSTANCE.setStrengthX(f1);
/* 574 */         RainbowFontShader.INSTANCE.setStrengthY(f2);
/* 575 */         RainbowFontShader.INSTANCE.setOffset(offset$iv);
/*     */         
/* 577 */         RainbowFontShader.INSTANCE.startShader();
/*     */       } 
/*     */       
/* 580 */       Closeable closeable = (Closeable)RainbowFontShader.INSTANCE; boolean bool1 = false; Throwable throwable = (Throwable)null; try { RainbowFontShader it = (RainbowFontShader)closeable; int $i$a$-use-Text$drawElement$5 = 0; Intrinsics.checkExpressionValueIsNotNull(Palette.fade2(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), counter[0] * 100, this.displayText.length() * 200), "Palette.fade2(Color(ACol…displayText.length * 200)"); Intrinsics.checkExpressionValueIsNotNull(RenderUtils.getGradientOffset(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), 1), Math.abs(System.currentTimeMillis() / ((Number)this.gidentspeed.get()).intValue() + counter[0]) / 10), "RenderUtils.getGradientO…le() + counter[0]) / 10))"); fontRenderer.drawString(this.displayText, 0.0F, 0.0F, bool ? 0 : (StringsKt.equals(colorMode, "Fade", true) ? Palette.fade2(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), counter[0] * 100, this.displayText.length() * 200).getRGB() : (StringsKt.equals(colorMode, "Astolfo", true) ? RenderUtils.Astolfo(counter[0] * 100, ((Number)this.saturationValue.get()).floatValue(), ((Number)this.brightnessValue.get()).floatValue(), ((Number)this.astolfoRainbowOffset.get()).intValue(), ((Number)this.astolfoRainbowIndex.get()).intValue(), ((Number)this.astolfoclient.get()).intValue()) : (StringsKt.equals(colorMode, "NewRainbow", true) ? RenderUtils.getRainbow(counter[0] * 100, ((Number)this.newRainbowIndex.get()).intValue(), ((Number)this.saturationValue.get()).floatValue(), ((Number)this.brightnessValue.get()).floatValue()) : (StringsKt.equals(colorMode, "Gident", true) ? RenderUtils.getGradientOffset(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), 1), Math.abs(System.currentTimeMillis() / ((Number)this.gidentspeed.get()).intValue() + counter[0]) / 10).getRGB() : color)))), ((Boolean)this.shadow.get()).booleanValue()); if (this.editMode && MinecraftInstance.classProvider.isGuiHudDesigner(MinecraftInstance.mc.getCurrentScreen()) && this.editTicks <= 40) { Intrinsics.checkExpressionValueIsNotNull(Palette.fade2(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), counter[0] * 100, this.displayText.length() * 200), "Palette.fade2(Color(ACol…displayText.length * 200)"); Intrinsics.checkExpressionValueIsNotNull(RenderUtils.getGradientOffset(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), 1), Math.abs(System.currentTimeMillis() / ((Number)this.gidentspeed.get()).intValue() + counter[0]) / 10), "RenderUtils.getGradientO…le() + counter[0]) / 10))"); fontRenderer.drawString("_", fontRenderer.getStringWidth(this.displayText), 0.0F, bool ? 0 : (StringsKt.equals(colorMode, "Fade", true) ? Palette.fade2(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), counter[0] * 100, this.displayText.length() * 200).getRGB() : (StringsKt.equals(colorMode, "Astolfo", true) ? RenderUtils.Astolfo(counter[0] * 100, ((Number)this.saturationValue.get()).floatValue(), ((Number)this.brightnessValue.get()).floatValue(), ((Number)this.astolfoRainbowOffset.get()).intValue(), ((Number)this.astolfoRainbowIndex.get()).intValue(), ((Number)this.astolfoclient.get()).intValue()) : (StringsKt.equals(colorMode, "Gident", true) ? RenderUtils.getGradientOffset(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), 1), Math.abs(System.currentTimeMillis() / ((Number)this.gidentspeed.get()).intValue() + counter[0]) / 10).getRGB() : (StringsKt.equals(colorMode, "NewRainbow", true) ? RenderUtils.getRainbow(counter[0] * 100, ((Number)this.newRainbowIndex.get()).intValue(), ((Number)this.saturationValue.get()).floatValue(), ((Number)this.brightnessValue.get()).floatValue()) : color)))), ((Boolean)this.shadow.get()).booleanValue()); }  counter[0] = counter[0] + 1; Unit unit = Unit.INSTANCE; } catch (Throwable throwable1) { throwable = throwable1 = null; throw throwable1; } finally { CloseableKt.closeFinally(closeable, throwable); }  }
/* 581 */     else { int length = 0; float f1 = (((Number)this.rainbowX.get()).floatValue() == 0.0F) ? 0.0F : (1.0F / ((Number)this.rainbowX.get()).floatValue()), f2 = (((Number)this.rainbowY.get()).floatValue() == 0.0F) ? 0.0F : (1.0F / ((Number)this.rainbowY.get()).floatValue()), offset$iv = (float)(System.currentTimeMillis() % 10000L) / 10000.0F; int $i$f$begin = 0; if (rainbow) {
/* 582 */         RainbowFontShader.INSTANCE.setStrengthX(f1);
/* 583 */         RainbowFontShader.INSTANCE.setStrengthY(f2);
/* 584 */         RainbowFontShader.INSTANCE.setOffset(offset$iv);
/*     */         
/* 586 */         RainbowFontShader.INSTANCE.startShader();
/*     */       } 
/*     */       
/* 589 */       Closeable closeable = (Closeable)RainbowFontShader.INSTANCE;
/*     */       boolean bool = false;
/*     */       Throwable throwable = (Throwable)null;
/*     */       try {
/*     */         RainbowFontShader it = (RainbowFontShader)closeable;
/*     */         int $i$a$-use-Text$drawElement$6 = 0;
/*     */         for (char charIndex : charArray) {
/*     */           boolean bool1 = StringsKt.equals(colorMode, "Rainbow", true);
/*     */           Intrinsics.checkExpressionValueIsNotNull(Palette.fade2(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), counter[0] * 100, this.displayText.length() * 200), "Palette.fade2(Color(ACol…displayText.length * 200)");
/*     */           Intrinsics.checkExpressionValueIsNotNull(RenderUtils.getGradientOffset(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), 1), Math.abs(System.currentTimeMillis() / ((Number)this.gidentspeed.get()).intValue() + counter[0]) / 10), "RenderUtils.getGradientO…le() + counter[0]) / 10))");
/*     */           fontRenderer.drawString(String.valueOf(charIndex), length, 0.0F, bool1 ? 0 : (StringsKt.equals(colorMode, "Fade", true) ? Palette.fade2(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), counter[0] * 100, this.displayText.length() * 200).getRGB() : (StringsKt.equals(colorMode, "Astolfo", true) ? RenderUtils.Astolfo(counter[0] * 100, ((Number)this.saturationValue.get()).floatValue(), ((Number)this.brightnessValue.get()).floatValue(), ((Number)this.astolfoRainbowOffset.get()).intValue(), ((Number)this.astolfoRainbowIndex.get()).intValue(), ((Number)this.astolfoclient.get()).intValue()) : (StringsKt.equals(colorMode, "NewRainbow", true) ? RenderUtils.getRainbow(counter[0] * 100, ((Number)this.newRainbowIndex.get()).intValue(), ((Number)this.saturationValue.get()).floatValue(), ((Number)this.brightnessValue.get()).floatValue()) : (StringsKt.equals(colorMode, "Gident", true) ? RenderUtils.getGradientOffset(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), 1), Math.abs(System.currentTimeMillis() / ((Number)this.gidentspeed.get()).intValue() + counter[0]) / 10).getRGB() : color)))), ((Boolean)this.shadow.get()).booleanValue());
/*     */           counter[0] = counter[0] + 1;
/*     */           counter[0] = RangesKt.coerceIn(counter[0], 0, this.displayText.length());
/*     */           length += fontRenderer.getStringWidth(String.valueOf(charIndex));
/*     */         } 
/*     */         if (this.editMode && MinecraftInstance.classProvider.isGuiHudDesigner(MinecraftInstance.mc.getCurrentScreen()) && this.editTicks <= 40) {
/*     */           Intrinsics.checkExpressionValueIsNotNull(Palette.fade2(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), counter[0] * 100, this.displayText.length() * 200), "Palette.fade2(Color(ACol…displayText.length * 200)");
/*     */           Intrinsics.checkExpressionValueIsNotNull(RenderUtils.getGradientOffset(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), 1), Math.abs(System.currentTimeMillis() / ((Number)this.gidentspeed.get()).intValue() + counter[0]) / 10), "RenderUtils.getGradientO…le() + counter[0]) / 10))");
/*     */           fontRenderer.drawString("_", length2, 0.0F, rainbow ? 0 : (StringsKt.equals(colorMode, "Fade", true) ? Palette.fade2(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), counter[0] * 100, this.displayText.length() * 200).getRGB() : (StringsKt.equals(colorMode, "Astolfo", true) ? RenderUtils.Astolfo(counter[0] * 100, ((Number)this.saturationValue.get()).floatValue(), ((Number)this.brightnessValue.get()).floatValue(), ((Number)this.astolfoRainbowOffset.get()).intValue(), ((Number)this.astolfoRainbowIndex.get()).intValue(), ((Number)this.astolfoclient.get()).intValue()) : (StringsKt.equals(colorMode, "Gident", true) ? RenderUtils.getGradientOffset(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), 1), Math.abs(System.currentTimeMillis() / ((Number)this.gidentspeed.get()).intValue() + counter[0]) / 10).getRGB() : (StringsKt.equals(colorMode, "NewRainbow", true) ? RenderUtils.getRainbow(counter[0] * 100, ((Number)this.newRainbowIndex.get()).intValue(), ((Number)this.saturationValue.get()).floatValue(), ((Number)this.brightnessValue.get()).floatValue()) : color)))), ((Boolean)this.shadow.get()).booleanValue());
/*     */         } 
/*     */         Unit unit = Unit.INSTANCE;
/*     */       } catch (Throwable throwable1) {
/*     */         throwable = throwable1 = null;
/*     */         throw throwable1;
/*     */       } finally {
/*     */         CloseableKt.closeFinally(closeable, throwable);
/*     */       }  }
/*     */     
/*     */     if (((Boolean)this.shadows.get()).booleanValue()) {
/*     */       GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D);
/*     */       GL11.glPushMatrix();
/*     */       ShadowUtils.shadow(((Number)this.shadowStrength.get()).floatValue(), new Text$drawElement$7(fontRenderer, counter, color), Text$drawElement$8.INSTANCE);
/*     */       GL11.glPopMatrix();
/*     */       GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */     } 
/*     */     if (this.editMode && !MinecraftInstance.classProvider.isGuiHudDesigner(MinecraftInstance.mc.getCurrentScreen())) {
/*     */       this.editMode = false;
/*     */       updateElement();
/*     */     } 
/*     */     return new Border(-2.0F, -2.0F, length2, fontRenderer.getFontHeight()); }
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class Text$drawElement$8 extends Lambda implements Function0<Unit> {
/*     */     public static final Text$drawElement$8 INSTANCE = new Text$drawElement$8();
/*     */     
/*     */     public final void invoke() {}
/*     */     
/*     */     Text$drawElement$8() {
/*     */       super(0);
/*     */     }
/*     */   }
/*     */   public static final Companion Companion = new Companion(null);
/*     */   
/*     */   static {
/*     */     DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
/*     */     HOUR_FORMAT = new SimpleDateFormat("HH:mm");
/*     */     DECIMAL_FORMAT = new DecimalFormat("0.00");
/*     */     DECIMAL_FORMAT_INT = new DecimalFormat("0");
/*     */   }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\007\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\006\020\017\032\0020\020R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\021\020\007\032\0020\b¢\006\b\n\000\032\004\b\t\020\nR\021\020\013\032\0020\b¢\006\b\n\000\032\004\b\f\020\nR\021\020\r\032\0020\004¢\006\b\n\000\032\004\b\016\020\006¨\006\021"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Text$Companion;", "", "()V", "DATE_FORMAT", "Ljava/text/SimpleDateFormat;", "getDATE_FORMAT", "()Ljava/text/SimpleDateFormat;", "DECIMAL_FORMAT", "Ljava/text/DecimalFormat;", "getDECIMAL_FORMAT", "()Ljava/text/DecimalFormat;", "DECIMAL_FORMAT_INT", "getDECIMAL_FORMAT_INT", "HOUR_FORMAT", "getHOUR_FORMAT", "defaultClient", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Text;", "XSJClient"})
/*     */   public static final class Companion {
/*     */     private Companion() {}
/*     */     
/*     */     @NotNull
/*     */     public final SimpleDateFormat getDATE_FORMAT() {
/*     */       return Text.DATE_FORMAT;
/*     */     }
/*     */     
/*     */     @NotNull
/*     */     public final SimpleDateFormat getHOUR_FORMAT() {
/*     */       return Text.HOUR_FORMAT;
/*     */     }
/*     */     
/*     */     @NotNull
/*     */     public final DecimalFormat getDECIMAL_FORMAT() {
/*     */       return Text.DECIMAL_FORMAT;
/*     */     }
/*     */     
/*     */     @NotNull
/*     */     public final DecimalFormat getDECIMAL_FORMAT_INT() {
/*     */       return Text.DECIMAL_FORMAT_INT;
/*     */     }
/*     */     
/*     */     @NotNull
/*     */     public final Text defaultClient() {
/*     */       Text text = new Text(2.0D, 2.0D, 2.0F, null, 8, null);
/*     */       text.displayString.set("XSJ Client |Fps:%fps% ");
/*     */       text.shadow.set(Boolean.valueOf(true));
/*     */       Intrinsics.checkExpressionValueIsNotNull(Fonts.roboto40, "Fonts.roboto40");
/*     */       text.fontValue.set(Fonts.roboto40);
/*     */       text.setColor(new Color(0, 111, 255));
/*     */       return text;
/*     */     }
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final FloatValue getShadowStrength() {
/*     */     return this.shadowStrength;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final IntegerValue getR() {
/*     */     return this.r;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final IntegerValue getG() {
/*     */     return this.g;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final IntegerValue getB() {
/*     */     return this.b;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final IntegerValue getAlpha() {
/*     */     return this.alpha;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final HUD getHud() {
/*     */     return this.hud;
/*     */   }
/*     */   
/*     */   private final String getDisplay() {
/*     */     CharSequence charSequence = (CharSequence)this.displayString.get();
/*     */     boolean bool = false;
/*     */     String textContent = (((charSequence.length() == 0)) && !this.editMode) ? "XSJ Client |Fps:%fps% " : (String)this.displayString.get();
/*     */     return multiReplace(textContent);
/*     */   }
/*     */   
/*     */   private final String getReplacement(String str) {
/*     */     if (MinecraftInstance.mc.getThePlayer() != null) {
/*     */       String str2 = str;
/*     */       switch (str2.hashCode()) {
/*     */         case 3648599:
/*     */           if (str2.equals("xInt")) {
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             return DECIMAL_FORMAT_INT.format(MinecraftInstance.mc.getThePlayer().getPosX());
/*     */           } 
/*     */           break;
/*     */         case 119493:
/*     */           if (str2.equals("ydp")) {
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             return String.valueOf(MinecraftInstance.mc.getThePlayer().getPosY());
/*     */           } 
/*     */           break;
/*     */         case 97765:
/*     */           if (str2.equals("bps"))
/*     */             return this.speedStr; 
/*     */           break;
/*     */         case 118532:
/*     */           if (str2.equals("xdp")) {
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             return String.valueOf(MinecraftInstance.mc.getThePlayer().getPosX());
/*     */           } 
/*     */           break;
/*     */         case 3441010:
/*     */           if (str2.equals("ping")) {
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             return String.valueOf(EntityUtils.getPing((IEntityPlayer)MinecraftInstance.mc.getThePlayer()));
/*     */           } 
/*     */           break;
/*     */         case 120454:
/*     */           if (str2.equals("zdp")) {
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             return String.valueOf(MinecraftInstance.mc.getThePlayer().getPosZ());
/*     */           } 
/*     */           break;
/*     */         case -1394017553:
/*     */           if (str2.equals("maxHealthInt")) {
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             return DECIMAL_FORMAT_INT.format(Float.valueOf(MinecraftInstance.mc.getThePlayer().getMaxHealth()));
/*     */           } 
/*     */           break;
/*     */         case -737639680:
/*     */           if (str2.equals("yawInt")) {
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             return DECIMAL_FORMAT_INT.format(Float.valueOf(MinecraftInstance.mc.getThePlayer().getRotationYaw()));
/*     */           } 
/*     */           break;
/*     */         case -259550065:
/*     */           if (str2.equals("pitchInt")) {
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             return DECIMAL_FORMAT_INT.format(Float.valueOf(MinecraftInstance.mc.getThePlayer().getRotationPitch()));
/*     */           } 
/*     */           break;
/*     */         case -1221262756:
/*     */           if (str2.equals("health")) {
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             return DECIMAL_FORMAT.format(Float.valueOf(MinecraftInstance.mc.getThePlayer().getHealth()));
/*     */           } 
/*     */           break;
/*     */         case 2134260957:
/*     */           if (str2.equals("velocity")) {
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             double d1 = MinecraftInstance.mc.getThePlayer().getMotionX() * MinecraftInstance.mc.getThePlayer().getMotionX() + MinecraftInstance.mc.getThePlayer().getMotionZ() * MinecraftInstance.mc.getThePlayer().getMotionZ();
/*     */             DecimalFormat decimalFormat = DECIMAL_FORMAT;
/*     */             boolean bool = false;
/*     */             double d2 = Math.sqrt(d1);
/*     */             return decimalFormat.format(d2);
/*     */           } 
/*     */           break;
/*     */         case 3708181:
/*     */           if (str2.equals("zInt")) {
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             return DECIMAL_FORMAT_INT.format(MinecraftInstance.mc.getThePlayer().getPosZ());
/*     */           } 
/*     */           break;
/*     */         case 29274099:
/*     */           if (str2.equals("healthInt")) {
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             return DECIMAL_FORMAT_INT.format(Float.valueOf(MinecraftInstance.mc.getThePlayer().getHealth()));
/*     */           } 
/*     */           break;
/*     */         case 3678390:
/*     */           if (str2.equals("yInt")) {
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             return DECIMAL_FORMAT_INT.format(MinecraftInstance.mc.getThePlayer().getPosY());
/*     */           } 
/*     */           break;
/*     */         case 119407:
/*     */           if (str2.equals("yaw")) {
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             return DECIMAL_FORMAT.format(Float.valueOf(MinecraftInstance.mc.getThePlayer().getRotationYaw()));
/*     */           } 
/*     */           break;
/*     */         case 1160949830:
/*     */           if (str2.equals("onGround")) {
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             return String.valueOf(MinecraftInstance.mc.getThePlayer().getOnGround());
/*     */           } 
/*     */           break;
/*     */         case 120:
/*     */           if (str2.equals("x")) {
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             return DECIMAL_FORMAT.format(MinecraftInstance.mc.getThePlayer().getPosX());
/*     */           } 
/*     */           break;
/*     */         case 121:
/*     */           if (str2.equals("y")) {
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             return DECIMAL_FORMAT.format(MinecraftInstance.mc.getThePlayer().getPosY());
/*     */           } 
/*     */           break;
/*     */         case 122:
/*     */           if (str2.equals("z")) {
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             return DECIMAL_FORMAT.format(MinecraftInstance.mc.getThePlayer().getPosZ());
/*     */           } 
/*     */           break;
/*     */         case -906299168:
/*     */           if (str2.equals("maxHealth")) {
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             return DECIMAL_FORMAT.format(Float.valueOf(MinecraftInstance.mc.getThePlayer().getMaxHealth()));
/*     */           } 
/*     */           break;
/*     */         case 700855164:
/*     */           if (str2.equals("hurtTime")) {
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             return String.valueOf(MinecraftInstance.mc.getThePlayer().getHurtTime());
/*     */           } 
/*     */           break;
/*     */         case 106677056:
/*     */           if (str2.equals("pitch")) {
/*     */             if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             return DECIMAL_FORMAT.format(Float.valueOf(MinecraftInstance.mc.getThePlayer().getRotationPitch()));
/*     */           } 
/*     */           break;
/*     */       } 
/*     */     } 
/*     */     String str1 = str;
/*     */     switch (str1.hashCode()) {
/*     */       case 3076014:
/*     */         if (str1.equals("date"));
/*     */         if (str1.equals("date"));
/*     */         break;
/*     */       case 3494900:
/*     */         if (str1.equals("rcps"))
/*     */           return String.valueOf(CPSCounter.getCPS(CPSCounter.MouseButton.RIGHT)); 
/*     */         if (str1.equals("rcps"))
/*     */           return String.valueOf(CPSCounter.getCPS(CPSCounter.MouseButton.RIGHT)); 
/*     */         break;
/*     */       case -215825919:
/*     */         if (str1.equals("clientcreator"));
/*     */         break;
/*     */       case -892772691:
/*     */         if (str1.equals("clientversion"));
/*     */         break;
/*     */       case 1102251254:
/*     */         if (str1.equals("clientName"));
/*     */         break;
/*     */       case 98726:
/*     */         if (!str1.equals("cps")) {
/*     */           if (str1.equals("cps"))
/*     */             return String.valueOf(CPSCounter.getCPS(CPSCounter.MouseButton.LEFT)); 
/*     */           break;
/*     */         } 
/*     */         return String.valueOf(CPSCounter.getCPS(CPSCounter.MouseButton.LEFT));
/*     */       case 101609:
/*     */         if (str1.equals("fps"));
/*     */         if (str1.equals("fps"));
/*     */         break;
/*     */       case 3316154:
/*     */         if (!str1.equals("lcps")) {
/*     */           if (str1.equals("lcps"))
/*     */             return String.valueOf(CPSCounter.getCPS(CPSCounter.MouseButton.LEFT)); 
/*     */           break;
/*     */         } 
/*     */         return String.valueOf(CPSCounter.getCPS(CPSCounter.MouseButton.LEFT));
/*     */       case 3345945:
/*     */         if (str1.equals("mcps"))
/*     */           return String.valueOf(CPSCounter.getCPS(CPSCounter.MouseButton.MIDDLE)); 
/*     */         if (str1.equals("mcps"))
/*     */           return String.valueOf(CPSCounter.getCPS(CPSCounter.MouseButton.MIDDLE)); 
/*     */         break;
/*     */       case -266666762:
/*     */         if (str1.equals("userName"));
/*     */         break;
/*     */       case 771880589:
/*     */         if (str1.equals("clientVersion"));
/*     */         break;
/*     */       case 1103204566:
/*     */         if (str1.equals("clientname"));
/*     */         break;
/*     */       case 1379104682:
/*     */         if (str1.equals("serverip"));
/*     */         break;
/*     */       case 1379103690:
/*     */         if (str1.equals("serverIp"));
/*     */         break;
/*     */       case 1448827361:
/*     */         if (str1.equals("clientCreator"));
/*     */         break;
/*     */       case 3560141:
/*     */         if (str1.equals("time"));
/*     */         if (str1.equals("time"));
/*     */         break;
/*     */       case -265713450:
/*     */         if (str1.equals("username"))
/*     */           Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.func_110432_I(), "mc2.getSession()"); 
/*     */         break;
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   private final String multiReplace(String str) {
/*     */     int lastPercent = -1;
/*     */     StringBuilder result = new StringBuilder();
/*     */     byte b;
/*     */     int i;
/*     */     for (b = 0, i = str.length(); b < i; b++) {
/*     */       if (str.charAt(b) == '%') {
/*     */         if (lastPercent != -1) {
/*     */           if (lastPercent + 1 != b) {
/*     */             String str1 = str;
/*     */             int j = lastPercent + 1;
/*     */             Text text = this;
/*     */             boolean bool = false;
/*     */             if (str1 == null)
/*     */               throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */             Intrinsics.checkExpressionValueIsNotNull(str1.substring(j, b), "(this as java.lang.Strin…ing(startIndex, endIndex)");
/*     */             String str2 = str1.substring(j, b), replacement = text.getReplacement(str2);
/*     */             if (replacement != null) {
/*     */               result.append(replacement);
/*     */               lastPercent = -1;
/*     */               continue;
/*     */             } 
/*     */           } 
/*     */           result.append(str, lastPercent, b);
/*     */         } 
/*     */         lastPercent = b;
/*     */         continue;
/*     */       } 
/*     */       if (lastPercent == -1)
/*     */         result.append(str.charAt(b)); 
/*     */       continue;
/*     */     } 
/*     */     if (lastPercent != -1)
/*     */       result.append(str, lastPercent, str.length()); 
/*     */     Intrinsics.checkExpressionValueIsNotNull(result.toString(), "result.toString()");
/*     */     return result.toString();
/*     */   }
/*     */   
/*     */   public final int getSlidetext() {
/*     */     return this.slidetext;
/*     */   }
/*     */   
/*     */   public final void setSlidetext(int <set-?>) {
/*     */     this.slidetext = <set-?>;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final MSTimer getSlidetimer() {
/*     */     return this.slidetimer;
/*     */   }
/*     */   
/*     */   public final void setSlidetimer(@NotNull MSTimer <set-?>) {
/*     */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*     */     this.slidetimer = <set-?>;
/*     */   }
/*     */   
/*     */   public final boolean getDoslide() {
/*     */     return this.doslide;
/*     */   }
/*     */   
/*     */   public final void setDoslide(boolean <set-?>) {
/*     */     this.doslide = <set-?>;
/*     */   }
/*     */   
/*     */   public void updateElement() {
/*     */     this.editTicks += 5;
/*     */     if (this.editTicks > 80)
/*     */       this.editTicks = 0; 
/*     */     this.displayText = this.editMode ? (String)this.displayString.get() : getDisplay();
/*     */   }
/*     */   
/*     */   public void handleMouseClick(double x, double y, int mouseButton) {
/*     */     if (isInBorder(x, y) && mouseButton == 0) {
/*     */       if (System.currentTimeMillis() - this.prevClick <= 250L)
/*     */         this.editMode = true; 
/*     */       this.prevClick = System.currentTimeMillis();
/*     */     } else {
/*     */       this.editMode = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void handleKey(char c, int keyCode) {
/*     */     if (this.editMode && MinecraftInstance.classProvider.isGuiHudDesigner(MinecraftInstance.mc.getCurrentScreen())) {
/*     */       if (keyCode == 14) {
/*     */         CharSequence charSequence = (CharSequence)this.displayString.get();
/*     */         boolean bool = false;
/*     */         if ((charSequence.length() > 0)) {
/*     */           charSequence = (String)this.displayString.get();
/*     */           bool = false;
/*     */           int i = ((String)this.displayString.get()).length() - 1;
/*     */           TextValue textValue = this.displayString;
/*     */           boolean bool1 = false;
/*     */           if (charSequence == null)
/*     */             throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */           Intrinsics.checkExpressionValueIsNotNull(charSequence.substring(bool, i), "(this as java.lang.Strin…ing(startIndex, endIndex)");
/*     */           String str = charSequence.substring(bool, i);
/*     */           textValue.set(str);
/*     */         } 
/*     */         updateElement();
/*     */         return;
/*     */       } 
/*     */       if (ChatAllowedCharacters.func_71566_a(c) || c == '§')
/*     */         this.displayString.set((String)this.displayString.get() + c); 
/*     */       updateElement();
/*     */     } 
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final Text setColor(@NotNull Color c) {
/*     */     Intrinsics.checkParameterIsNotNull(c, "c");
/*     */     AColorPalette.r.set(Integer.valueOf(c.getRed()));
/*     */     AColorPalette.g.set(Integer.valueOf(c.getGreen()));
/*     */     AColorPalette.b.set(Integer.valueOf(c.getBlue()));
/*     */     return this;
/*     */   }
/*     */   
/*     */   public final void drawRect(float x, float y, float x2, float y2, int color) {
/*     */     GL11.glEnable(3042);
/*     */     GL11.glDisable(3553);
/*     */     GL11.glBlendFunc(770, 771);
/*     */     GL11.glEnable(2848);
/*     */     glColor(color);
/*     */     GL11.glBegin(7);
/*     */     GL11.glVertex2d(x2, y);
/*     */     GL11.glVertex2d(x, y);
/*     */     GL11.glVertex2d(x, y2);
/*     */     GL11.glVertex2d(x2, y2);
/*     */     GL11.glEnd();
/*     */     GL11.glEnable(3553);
/*     */     GL11.glDisable(3042);
/*     */     GL11.glDisable(2848);
/*     */   }
/*     */   
/*     */   public final void drawRect(double x, double y, double x2, double y2, int color) {
/*     */     GL11.glEnable(3042);
/*     */     GL11.glDisable(3553);
/*     */     GL11.glBlendFunc(770, 771);
/*     */     GL11.glEnable(2848);
/*     */     glColor(color);
/*     */     GL11.glBegin(7);
/*     */     GL11.glVertex2d(x2, y);
/*     */     GL11.glVertex2d(x, y);
/*     */     GL11.glVertex2d(x, y2);
/*     */     GL11.glVertex2d(x2, y2);
/*     */     GL11.glEnd();
/*     */     GL11.glEnable(3553);
/*     */     GL11.glDisable(3042);
/*     */     GL11.glDisable(2848);
/*     */   }
/*     */   
/*     */   public final void glColor(int red, int green, int blue, int alpha) {
/*     */     GlStateManager.func_179131_c(red / 255.0F, green / 255.0F, blue / 255.0F, alpha / 255.0F);
/*     */   }
/*     */   
/*     */   public final void glColor(@NotNull Color color) {
/*     */     Intrinsics.checkParameterIsNotNull(color, "color");
/*     */     float red = color.getRed() / 255.0F;
/*     */     float green = color.getGreen() / 255.0F;
/*     */     float blue = color.getBlue() / 255.0F;
/*     */     float alpha = color.getAlpha() / 255.0F;
/*     */     GlStateManager.func_179131_c(red, green, blue, alpha);
/*     */   }
/*     */   
/*     */   public final void glColor(int hex) {
/*     */     float alpha = (hex >> 24 & 0xFF) / 255.0F;
/*     */     float red = (hex >> 16 & 0xFF) / 255.0F;
/*     */     float green = (hex >> 8 & 0xFF) / 255.0F;
/*     */     float blue = (hex & 0xFF) / 255.0F;
/*     */     GlStateManager.func_179131_c(red, green, blue, alpha);
/*     */   }
/*     */   
/*     */   public Text() {
/*     */     this(0.0D, 0.0D, 0.0F, (Side)null, 15, (DefaultConstructorMarker)null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\Text.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */