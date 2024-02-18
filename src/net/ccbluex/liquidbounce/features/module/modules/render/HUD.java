/*     */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*     */ import java.awt.Color;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.Arrays;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.StringCompanionObject;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.KeyEvent;
/*     */ import net.ccbluex.liquidbounce.event.ScreenEvent;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.RoundedUtil;
/*     */ import net.ccbluex.liquidbounce.utils.render.tenacity.ColorUtil;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.ccbluex.liquidbounce.value.TextValue;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @ModuleInfo(name = "HUD", description = "Toggles visibility of the HUD.", category = ModuleCategory.RENDER, array = false)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\001\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\024\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\007\n\000\n\002\020\b\n\002\b-\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\002\n\002\020\021\n\002\b\007\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\b\007\030\000 }2\0020\001:\001}B\005¢\006\002\020\002J\006\020c\032\0020dJ\006\020e\032\0020dJ\023\020f\032\n\022\004\022\0020d\030\0010g¢\006\002\020hJ\016\020i\032\0020+2\006\020a\032\0020+J\006\020j\032\0020\bJ\030\020k\032\0020d2\006\020l\032\0020d2\006\020m\032\0020dH\002J\020\020n\032\0020o2\006\020p\032\0020qH\002J\020\020r\032\0020o2\006\020s\032\0020tH\007J\022\020u\032\0020o2\b\020s\032\004\030\0010vH\007J\020\020w\032\0020o2\006\020s\032\0020xH\007J\020\020y\032\0020o2\006\020s\032\0020zH\007J\022\020{\032\0020o2\b\020s\032\004\030\0010|H\007R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\021\020\007\032\0020\b¢\006\b\n\000\032\004\b\t\020\nR\021\020\013\032\0020\b¢\006\b\n\000\032\004\b\f\020\nR\021\020\r\032\0020\016¢\006\b\n\000\032\004\b\017\020\020R\021\020\021\032\0020\016¢\006\b\n\000\032\004\b\022\020\020R\021\020\023\032\0020\016¢\006\b\n\000\032\004\b\024\020\020R\021\020\025\032\0020\b¢\006\b\n\000\032\004\b\026\020\nR\021\020\027\032\0020\b¢\006\b\n\000\032\004\b\030\020\nR\021\020\031\032\0020\b¢\006\b\n\000\032\004\b\032\020\nR\021\020\033\032\0020\b¢\006\b\n\000\032\004\b\034\020\nR\021\020\035\032\0020\b¢\006\b\n\000\032\004\b\036\020\nR\016\020\037\032\0020\016X\004¢\006\002\n\000R\016\020 \032\0020\016X\004¢\006\002\n\000R\016\020!\032\0020\016X\004¢\006\002\n\000R\016\020\"\032\0020#X\004¢\006\002\n\000R\021\020$\032\0020%¢\006\b\n\000\032\004\b&\020'R\016\020(\032\0020)X\016¢\006\002\n\000R\016\020*\032\0020+X\016¢\006\002\n\000R\016\020,\032\0020)X\016¢\006\002\n\000R\016\020-\032\0020)X\016¢\006\002\n\000R\016\020.\032\0020)X\016¢\006\002\n\000R\021\020/\032\0020\b¢\006\b\n\000\032\004\b0\020\nR\021\0201\032\0020\016¢\006\b\n\000\032\004\b2\020\020R\021\0203\032\0020\016¢\006\b\n\000\032\004\b4\020\020R\020\0205\032\0020\b8\006X\004¢\006\002\n\000R\021\0206\032\0020\b¢\006\b\n\000\032\004\b7\020\nR\021\0208\032\0020\b¢\006\b\n\000\032\004\b9\020\nR\016\020:\032\0020\bX\004¢\006\002\n\000R\021\020;\032\0020\b¢\006\b\n\000\032\004\b<\020\nR\016\020=\032\0020\bX\004¢\006\002\n\000R\021\020>\032\0020+¢\006\b\n\000\032\004\b?\020@R\021\020A\032\0020\016¢\006\b\n\000\032\004\bB\020\020R\021\020C\032\0020\016¢\006\b\n\000\032\004\bD\020\020R\021\020E\032\0020\004¢\006\b\n\000\032\004\bF\020\006R\021\020G\032\0020\004¢\006\b\n\000\032\004\bH\020\006R\021\020I\032\0020\016¢\006\b\n\000\032\004\bJ\020\020R\021\020K\032\0020\004¢\006\b\n\000\032\004\bL\020\006R\021\020M\032\0020\004¢\006\b\n\000\032\004\bN\020\006R\016\020O\032\0020\bX\004¢\006\002\n\000R\021\020P\032\0020\016¢\006\b\n\000\032\004\bQ\020\020R\021\020R\032\0020\016¢\006\b\n\000\032\004\bS\020\020R\021\020T\032\0020\016¢\006\b\n\000\032\004\bU\020\020R\021\020V\032\0020\016¢\006\b\n\000\032\004\bW\020\020R\021\020X\032\0020Y¢\006\b\n\000\032\004\bZ\020[R\016\020\\\032\0020\bX\004¢\006\002\n\000R\016\020]\032\0020^X\004¢\006\002\n\000R\021\020_\032\0020+¢\006\b\n\000\032\004\b`\020@R\024\020a\032\0020+XD¢\006\b\n\000\032\004\bb\020@¨\006~"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "BlurStrength", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "getBlurStrength", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "ChineseScore", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "getChineseScore", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "ColorItem", "getColorItem", "Radius", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "getRadius", "()Lnet/ccbluex/liquidbounce/value/IntegerValue;", "b", "getB", "b2", "getB2", "blackHotbarValue", "getBlackHotbarValue", "blurValue", "getBlurValue", "blurmoduleValue", "getBlurmoduleValue", "chatAnimValue", "getChatAnimValue", "chatRect", "getChatRect", "colorBlueValue", "colorGreenValue", "colorRedValue", "decimalFormat", "Ljava/text/DecimalFormat;", "domainValue", "Lnet/ccbluex/liquidbounce/value/TextValue;", "getDomainValue", "()Lnet/ccbluex/liquidbounce/value/TextValue;", "easingHealth", "", "easingValue", "", "easingarmor", "easingfood", "easingxp", "fontChatValue", "getFontChatValue", "g", "getG", "g2", "getG2", "hotbar", "hotbarEaseValue", "getHotbarEaseValue", "hueInterpolation", "getHueInterpolation", "infoValue", "inventoryParticle", "getInventoryParticle", "inventoryrender", "left", "getLeft", "()I", "r", "getR", "r2", "getR2", "rainbowBrightnessValue", "getRainbowBrightnessValue", "rainbowSaturationValue", "getRainbowSaturationValue", "rainbowSpeedValue", "getRainbowSpeedValue", "rainbowStartValue", "getRainbowStartValue", "rainbowStopValue", "getRainbowStopValue", "sColors", "shadowalpha", "getShadowalpha", "shadowblue", "getShadowblue", "shadowgreen", "getShadowgreen", "shadowred", "getShadowred", "sr", "Lnet/minecraft/client/gui/ScaledResolution;", "getSr", "()Lnet/minecraft/client/gui/ScaledResolution;", "toggleMessageValue", "toggleSoundValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "top", "getTop", "x", "getX", "getAlternateClientColor", "Ljava/awt/Color;", "getClientColor", "getClientColors", "", "()[Ljava/awt/Color;", "getHotbarEasePos", "getInventoryrender", "mixColors", "color1", "color2", "onArmor", "", "target", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "onKey", "event", "Lnet/ccbluex/liquidbounce/event/KeyEvent;", "onRender2D", "Lnet/ccbluex/liquidbounce/event/Render2DEvent;", "onScreen", "Lnet/ccbluex/liquidbounce/event/ScreenEvent;", "onTick", "Lnet/ccbluex/liquidbounce/event/TickEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "Companion", "XSJClient"})
/*     */ public final class HUD extends Module {
/*     */   public HUD() {
/*  29 */     this.toggleMessageValue = new BoolValue("DisplayToggleMessage", true);
/*  30 */     this.sColors = new BoolValue("Colors", true);
/*  31 */     this.toggleSoundValue = new ListValue("ToggleSound", new String[] { "None", "Default", "Custom" }, "Custom");
/*  32 */     this.colorRedValue = new IntegerValue("R", 255, 0, 255);
/*  33 */     this.colorGreenValue = new IntegerValue("G", 255, 0, 255);
/*  34 */     this.colorBlueValue = new IntegerValue("B", 255, 0, 255);
/*  35 */     this.domainValue = new TextValue("Scoreboard-Domain", "XSJClient@凡哥");
/*  36 */     this.infoValue = new BoolValue("Info", false);
/*  37 */     this.fontChatValue = new BoolValue("FontChat", false);
/*  38 */     this.chatRect = new BoolValue("ChatRect", false);
/*  39 */     this.blurmoduleValue = new BoolValue("Moduleblur", false);
/*  40 */     this.shadowred = new IntegerValue("ShadowRed", 0, 0, 255);
/*  41 */     this.shadowgreen = new IntegerValue("ShadowGreen", 0, 0, 255);
/*  42 */     this.shadowblue = new IntegerValue("ShadowBlue", 0, 0, 255);
/*  43 */     this.shadowalpha = new IntegerValue("Shadowalpha", 0, 0, 255);
/*  44 */     this.r = new IntegerValue("NovolineRed", 0, 0, 255);
/*  45 */     this.g = new IntegerValue("NovolineGreen", 255, 0, 255);
/*  46 */     this.b = new IntegerValue("NovolineBlue", 255, 0, 255);
/*  47 */     this.r2 = new IntegerValue("NovolineRed2", 255, 0, 255);
/*  48 */     this.g2 = new IntegerValue("NovolineGreen2", 40, 0, 255);
/*  49 */     this.b2 = new IntegerValue("NovolineBlue2", 255, 0, 255);
/*  50 */     this.rainbowSaturationValue = new FloatValue("RainbowSaturation", 0.7F, 0.0F, 1.0F);
/*  51 */     this.rainbowBrightnessValue = new FloatValue("RainbowBrightness", 1.0F, 0.0F, 1.0F);
/*  52 */     this.rainbowSpeedValue = new IntegerValue("RainbowSpeed", 1500, 500, 7000);
/*  53 */     this.rainbowStartValue = new FloatValue("RainbowStart", 0.41F, 0.0F, 1.0F);
/*  54 */     this.rainbowStopValue = new FloatValue("RainbowStop", 0.58F, 0.0F, 1.0F);
/*  55 */     this.chatAnimValue = new BoolValue("ChatAnimation", true);
/*  56 */     this.blackHotbarValue = new BoolValue("BlackHotbar", false);
/*     */     
/*  58 */     this.hotbar = new BoolValue("Hotbar", false);
/*  59 */     this.ColorItem = new BoolValue("HotbarRect", false);
/*  60 */     this.hotbarEaseValue = new BoolValue("HotbarEase", false);
/*  61 */     this.hueInterpolation = new BoolValue("HueInterpolate", false);
/*  62 */     this.inventoryParticle = new BoolValue("InventoryParticle", false);
/*  63 */     this.inventoryrender = new BoolValue("Inventory-render", false);
/*  64 */     this.blurValue = new BoolValue("Blur", false);
/*  65 */     this.BlurStrength = new FloatValue("BlurStrength", 15.0F, 0.0F, 30.0F);
/*  66 */     this.Radius = new IntegerValue("BlurRadius", 10, 1, 50);
/*  67 */     this.ChineseScore = new BoolValue("ChineseScore", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  82 */     this.decimalFormat = new DecimalFormat();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  99 */     this.sr = new ScaledResolution(MinecraftInstance.mc2);
/* 100 */     this.left = this.sr.func_78326_a() / 2 + 91;
/* 101 */     this.top = this.sr.func_78328_b() - 100;
/* 102 */     this.x = 380;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 287 */     setState(true);
/*     */   }
/*     */   
/*     */   private final BoolValue toggleMessageValue;
/*     */   private final BoolValue sColors;
/*     */   private final ListValue toggleSoundValue;
/*     */   private final IntegerValue colorRedValue;
/*     */   private final IntegerValue colorGreenValue;
/*     */   private final IntegerValue colorBlueValue;
/*     */   @NotNull
/*     */   private final TextValue domainValue;
/*     */   private final BoolValue infoValue;
/*     */   @NotNull
/*     */   private final BoolValue fontChatValue;
/*     */   @NotNull
/*     */   private final BoolValue chatRect;
/*     */   @NotNull
/*     */   private final BoolValue blurmoduleValue;
/*     */   @NotNull
/*     */   private final IntegerValue shadowred;
/*     */   @NotNull
/*     */   private final IntegerValue shadowgreen;
/*     */   @NotNull
/*     */   private final IntegerValue shadowblue;
/*     */   @NotNull
/*     */   private final IntegerValue shadowalpha;
/*     */   @NotNull
/*     */   private final IntegerValue r;
/*     */   @NotNull
/*     */   private final IntegerValue g;
/*     */   @NotNull
/*     */   private final IntegerValue b;
/*     */   @NotNull
/*     */   private final IntegerValue r2;
/*     */   @NotNull
/*     */   private final IntegerValue g2;
/*     */   @NotNull
/*     */   private final IntegerValue b2;
/*     */   @NotNull
/*     */   private final FloatValue rainbowSaturationValue;
/*     */   @NotNull
/*     */   private final FloatValue rainbowBrightnessValue;
/*     */   @NotNull
/*     */   private final IntegerValue rainbowSpeedValue;
/*     */   @NotNull
/*     */   private final FloatValue rainbowStartValue;
/*     */   @NotNull
/*     */   private final FloatValue rainbowStopValue;
/*     */   @NotNull
/*     */   private final BoolValue chatAnimValue;
/*     */   @NotNull
/*     */   private final BoolValue blackHotbarValue;
/*     */   @JvmField
/*     */   @NotNull
/*     */   public final BoolValue hotbar;
/*     */   @NotNull
/*     */   private final BoolValue ColorItem;
/*     */   @NotNull
/*     */   private final BoolValue hotbarEaseValue;
/*     */   @NotNull
/*     */   private final BoolValue hueInterpolation;
/*     */   @NotNull
/*     */   private final BoolValue inventoryParticle;
/*     */   private final BoolValue inventoryrender;
/*     */   @NotNull
/*     */   private final BoolValue blurValue;
/*     */   @NotNull
/*     */   private final FloatValue BlurStrength;
/*     */   @NotNull
/*     */   private final IntegerValue Radius;
/*     */   @NotNull
/*     */   private final BoolValue ChineseScore;
/*     */   private float easingHealth;
/*     */   private final DecimalFormat decimalFormat;
/*     */   private float easingarmor;
/*     */   private float easingxp;
/*     */   private float easingfood;
/*     */   private int easingValue;
/*     */   @NotNull
/*     */   private final ScaledResolution sr;
/*     */   private final int left;
/*     */   private final int top;
/*     */   private final int x = 380;
/*     */   @NotNull
/*     */   private static final ListValue clolormode;
/*     */   
/*     */   @NotNull
/*     */   public final TextValue getDomainValue() {
/*     */     return this.domainValue;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final BoolValue getFontChatValue() {
/*     */     return this.fontChatValue;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final BoolValue getChatRect() {
/*     */     return this.chatRect;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final BoolValue getBlurmoduleValue() {
/*     */     return this.blurmoduleValue;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final IntegerValue getShadowred() {
/*     */     return this.shadowred;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final IntegerValue getShadowgreen() {
/*     */     return this.shadowgreen;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final IntegerValue getShadowblue() {
/*     */     return this.shadowblue;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final IntegerValue getShadowalpha() {
/*     */     return this.shadowalpha;
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
/*     */   public final IntegerValue getR2() {
/*     */     return this.r2;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final IntegerValue getG2() {
/*     */     return this.g2;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final IntegerValue getB2() {
/*     */     return this.b2;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final FloatValue getRainbowSaturationValue() {
/*     */     return this.rainbowSaturationValue;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final FloatValue getRainbowBrightnessValue() {
/*     */     return this.rainbowBrightnessValue;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final IntegerValue getRainbowSpeedValue() {
/*     */     return this.rainbowSpeedValue;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final FloatValue getRainbowStartValue() {
/*     */     return this.rainbowStartValue;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final FloatValue getRainbowStopValue() {
/*     */     return this.rainbowStopValue;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final BoolValue getChatAnimValue() {
/*     */     return this.chatAnimValue;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final BoolValue getBlackHotbarValue() {
/*     */     return this.blackHotbarValue;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final BoolValue getColorItem() {
/*     */     return this.ColorItem;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final BoolValue getHotbarEaseValue() {
/*     */     return this.hotbarEaseValue;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final BoolValue getHueInterpolation() {
/*     */     return this.hueInterpolation;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final BoolValue getInventoryParticle() {
/*     */     return this.inventoryParticle;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final BoolValue getBlurValue() {
/*     */     return this.blurValue;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final FloatValue getBlurStrength() {
/*     */     return this.BlurStrength;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final IntegerValue getRadius() {
/*     */     return this.Radius;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final BoolValue getChineseScore() {
/*     */     return this.ChineseScore;
/*     */   }
/*     */   
/*     */   public static final Companion Companion = new Companion(null);
/*     */   
/*     */   static {
/*     */     clolormode = new ListValue("ColorMode", new String[] { "Rainbow", "Light Rainbow", "Static", "Gident", "Double Color", "Default" }, "Light Rainbow");
/*     */   }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD$Companion;", "", "()V", "clolormode", "Lnet/ccbluex/liquidbounce/value/ListValue;", "getClolormode", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "XSJClient"})
/*     */   public static final class Companion {
/*     */     private Companion() {}
/*     */     
/*     */     @NotNull
/*     */     public final ListValue getClolormode() {
/*     */       return HUD.clolormode;
/*     */     }
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final BoolValue getInventoryrender() {
/*     */     return this.inventoryrender;
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onTick(@NotNull TickEvent event) {
/*     */     Intrinsics.checkParameterIsNotNull(event, "event");
/*     */     Retreat.INSTANCE.getModuleManager().setShouldNotify(((Boolean)this.toggleMessageValue.get()).booleanValue());
/*     */     Retreat.INSTANCE.getModuleManager().setToggleSoundMode(ArraysKt.indexOf((Object[])this.toggleSoundValue.getValues(), this.toggleSoundValue.get()));
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final ScaledResolution getSr() {
/*     */     return this.sr;
/*     */   }
/*     */   
/*     */   public final int getLeft() {
/*     */     return this.left;
/*     */   }
/*     */   
/*     */   public final int getTop() {
/*     */     return this.top;
/*     */   }
/*     */   
/*     */   public final int getX() {
/*     */     return this.x;
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onRender2D(@Nullable Render2DEvent event) {
/*     */     if (MinecraftInstance.classProvider.isGuiHudDesigner(MinecraftInstance.mc.getCurrentScreen()))
/*     */       return; 
/*     */     ScaledResolution sr = new ScaledResolution(MinecraftInstance.mc2);
/*     */     int left = sr.func_78326_a() / 2 + 91;
/*     */     int top = sr.func_78328_b() - 50;
/*     */     int x = left - 8 - 180;
/*     */     ScaledResolution scaledResolution = new ScaledResolution(MinecraftInstance.mc2);
/*     */     if (((Boolean)this.infoValue.get()).booleanValue()) {
/*     */       StringCompanionObject stringCompanionObject1 = StringCompanionObject.INSTANCE;
/*     */       String str1 = "VERSION:v2.3 New Year's Special Edition";
/*     */       Object[] arrayOfObject1 = new Object[0];
/*     */       boolean bool1 = false;
/*     */       Intrinsics.checkExpressionValueIsNotNull(String.format(str1, Arrays.copyOf(arrayOfObject1, arrayOfObject1.length)), "java.lang.String.format(format, *args)");
/*     */       String text = String.format(str1, Arrays.copyOf(arrayOfObject1, arrayOfObject1.length));
/*     */       if (MinecraftInstance.mc.getThePlayer() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       if (MinecraftInstance.mc.getThePlayer() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       if (MinecraftInstance.mc.getThePlayer() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       if (MinecraftInstance.mc.getThePlayer() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       double bps = Math.hypot(MinecraftInstance.mc.getThePlayer().getPosX() - MinecraftInstance.mc.getThePlayer().getPrevPosX(), MinecraftInstance.mc.getThePlayer().getPosZ() - MinecraftInstance.mc.getThePlayer().getPrevPosZ()) * MinecraftInstance.mc.getTimer().getTimerSpeed() * 20;
/*     */       StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
/*     */       String str2 = "XYZ: " + (int)MinecraftInstance.mc2.field_71439_g.field_70165_t + ", " + (int)MinecraftInstance.mc2.field_71439_g.field_70163_u + "," + (int)MinecraftInstance.mc2.field_71439_g.field_70161_v;
/*     */       Object[] arrayOfObject2 = new Object[0];
/*     */       boolean bool2 = false;
/*     */       Intrinsics.checkExpressionValueIsNotNull(String.format(str2, Arrays.copyOf(arrayOfObject2, arrayOfObject2.length)), "java.lang.String.format(format, *args)");
/*     */       String XYZ = String.format(str2, Arrays.copyOf(arrayOfObject2, arrayOfObject2.length));
/*     */       StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
/*     */       String str3 = "FPS: " + Minecraft.func_175610_ah();
/*     */       Object[] arrayOfObject3 = new Object[0];
/*     */       boolean bool3 = false;
/*     */       Intrinsics.checkExpressionValueIsNotNull(String.format(str3, Arrays.copyOf(arrayOfObject3, arrayOfObject3.length)), "java.lang.String.format(format, *args)");
/*     */       String FPS = String.format(str3, Arrays.copyOf(arrayOfObject3, arrayOfObject3.length));
/*     */       StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
/*     */       String str4 = "BPS: " + (Math.round(bps * 100.0D) / 100.0D);
/*     */       Object[] arrayOfObject4 = new Object[0];
/*     */       boolean bool4 = false;
/*     */       Intrinsics.checkExpressionValueIsNotNull(String.format(str4, Arrays.copyOf(arrayOfObject4, arrayOfObject4.length)), "java.lang.String.format(format, *args)");
/*     */       String BPS = String.format(str4, Arrays.copyOf(arrayOfObject4, arrayOfObject4.length));
/*     */       Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc");
/*     */       Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc");
/*     */       Fonts.rubik40.drawString(text, (MinecraftInstance.classProvider.createScaledResolution(MinecraftInstance.mc).getScaledWidth() - Fonts.rubik40.getStringWidth(text) - 2), (float)(MinecraftInstance.classProvider.createScaledResolution(MinecraftInstance.mc).getScaledHeight() - Fonts.rubik40.getFontHeight() - 1), (new Color(210, 210, 210)).getRGB(), true);
/*     */       Fonts.rubik40.drawString(XYZ, 2.0F, (scaledResolution.func_78328_b() - 10), (new Color(210, 210, 210)).getRGB(), true);
/*     */       Fonts.rubik40.drawString(BPS, 2.0F, (scaledResolution.func_78328_b() - 10 - Fonts.rubik40.getFontHeight()), (new Color(210, 210, 210)).getRGB(), true);
/*     */       Fonts.rubik40.drawString(FPS, 2.0F, (scaledResolution.func_78328_b() - 10 - Fonts.rubik40.getFontHeight() * 2), (new Color(210, 210, 210)).getRGB(), true);
/*     */     } 
/*     */     if (((Boolean)this.hotbar.get()).booleanValue() && MinecraftInstance.mc.getThePlayer() != null && MinecraftInstance.mc.getTheWorld() != null) {
/*     */       int color2 = (new Color(212, 48, 48)).getRGB();
/*     */       if (this.easingHealth <= 0.0F)
/*     */         this.easingHealth = 0.0F; 
/*     */       if (MinecraftInstance.mc.getThePlayer() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       if (this.easingHealth >= MinecraftInstance.mc.getThePlayer().getMaxHealth()) {
/*     */         if (MinecraftInstance.mc.getThePlayer() == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         this.easingHealth = MinecraftInstance.mc.getThePlayer().getMaxHealth();
/*     */       } 
/*     */       if (this.easingarmor <= false)
/*     */         this.easingarmor = 0.0F; 
/*     */       if (this.easingarmor >= 20.0F)
/*     */         this.easingarmor = 20.0F; 
/*     */       if (this.easingfood <= false)
/*     */         this.easingfood = 0.0F; 
/*     */       if (this.easingfood >= 20.0F)
/*     */         this.easingfood = 20.0F; 
/*     */       if (MinecraftInstance.mc.getThePlayer() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       if (MinecraftInstance.mc.getThePlayer().isPotionActive(MinecraftInstance.classProvider.getPotionEnum(PotionType.REGENERATION)))
/*     */         color2 = (new Color(200, 90, 90)).getRGB(); 
/*     */       RoundedUtil.drawRound(x, top - 8, 100.0F, 5.0F, 1.0F, new Color(126, 11, 11));
/*     */       if (MinecraftInstance.mc.getThePlayer() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       RoundedUtil.drawRound(x, top - 8, this.easingHealth / MinecraftInstance.mc.getThePlayer().getMaxHealth() * 100.0F, 5.0F, 1.0F, new Color(color2));
/*     */       RoundedUtil.drawRound(x, top + 10.0F, 210.0F, 5.0F, 1.0F, new Color(37, 94, 37));
/*     */       RoundedUtil.drawRound(x, top + 10.0F, this.easingxp / 20.0F * 40, 5.0F, 1.0F, new Color(65, 205, 125));
/*     */       RoundedUtil.drawRound(x, top - 18, 100.0F, 5.0F, 1.0F, new Color(35, 105, 136));
/*     */       RoundedUtil.drawRound(x, top - 18, this.easingarmor / 20.0F * 100.0F, 5.0F, 1.0F, new Color(73, 173, 203));
/*     */       RoundedUtil.drawRound(x + 110.0F, top - 8, 100.0F, 5.0F, 1.0F, new Color(100, 76, 37));
/*     */       RoundedUtil.drawRound(x + 110.0F, top - 8, this.easingfood / 20.0F * 100.0F, 5.0F, 1.0F, new Color(255, 140, 25));
/*     */       Fonts.posterama30.drawString("Armo/" + this.decimalFormat.format(Float.valueOf(this.easingarmor / 20.0F * 100.0F)) + "%", x + 2, (top + 3 - Fonts.posterama30.getFontHeight() / 2) - 3.0F - 15.0F, (new Color(255, 255, 255)).getRGB());
/*     */       if (MinecraftInstance.mc.getThePlayer() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       float reasingHealth = Math.round(this.easingHealth / MinecraftInstance.mc.getThePlayer().getMaxHealth() * 100.0F);
/*     */       Intrinsics.checkExpressionValueIsNotNull((new DecimalFormat()).format(Float.valueOf(reasingHealth)) + "%", "StringBuilder().append(D…)).append(\"%\").toString()");
/*     */       String s = (new DecimalFormat()).format(Float.valueOf(reasingHealth)) + "%";
/*     */       Fonts.posterama30.drawString("HP/" + s, x + 2, (top - 5 - Fonts.posterama30.getFontHeight() / 2), (new Color(255, 255, 255)).getRGB());
/*     */       Fonts.posterama30.drawString("Level/" + String.valueOf(MinecraftInstance.mc2.field_71439_g.field_71068_ca), x + 95, top + 6.0F - (Fonts.posterama30.getFontHeight() / 2), (new Color(255, 255, 255)).getRGB());
/*     */       Fonts.posterama30.drawString("Starvation/" + this.decimalFormat.format(Float.valueOf(this.easingfood / 20.0F * 100.0F)) + "%", x + 110.0F + 2, (top - 5 - Fonts.posterama30.getFontHeight() / 2), (new Color(255, 255, 255)).getRGB());
/*     */       Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player");
/*     */       Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g.func_71024_bL(), "mc2.player.foodStats");
/*     */       float f1 = 2.0F, f2 = 5.0F, f4 = MinecraftInstance.mc2.field_71439_g.func_71024_bL().func_75116_a() - this.easingfood, f3 = this.easingfood;
/*     */       HUD hUD = this;
/*     */       boolean bool = false;
/*     */       float f5 = (float)Math.pow(f1, f2);
/*     */       hUD.easingfood = f3 + f4 / f5 * RenderUtils.deltaTime;
/*     */       f1 = 2.0F;
/*     */       f2 = 5.0F;
/*     */       f4 = MinecraftInstance.mc2.field_71439_g.field_71106_cc * 100.0F - this.easingxp;
/*     */       f3 = this.easingxp;
/*     */       hUD = this;
/*     */       bool = false;
/*     */       f5 = (float)Math.pow(f1, f2);
/*     */       hUD.easingxp = f3 + f4 / f5 * RenderUtils.deltaTime;
/*     */       if (MinecraftInstance.mc.getThePlayer() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       f1 = 2.0F;
/*     */       f2 = 5.0F;
/*     */       f4 = MinecraftInstance.mc.getThePlayer().getHealth() - this.easingHealth;
/*     */       f3 = this.easingHealth;
/*     */       hUD = this;
/*     */       bool = false;
/*     */       f5 = (float)Math.pow(f1, f2);
/*     */       hUD.easingHealth = f3 + f4 / f5 * RenderUtils.deltaTime;
/*     */       Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player");
/*     */       f1 = 2.0F;
/*     */       f2 = 5.0F;
/*     */       f4 = MinecraftInstance.mc2.field_71439_g.func_70658_aO() - this.easingarmor;
/*     */       f3 = this.easingarmor;
/*     */       hUD = this;
/*     */       bool = false;
/*     */       f5 = (float)Math.pow(f1, f2);
/*     */       hUD.easingarmor = f3 + f4 / f5 * RenderUtils.deltaTime;
/*     */     } 
/*     */     Retreat.INSTANCE.getHud().render(false);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final Color getClientColor() {
/*     */     return new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue());
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final Color getAlternateClientColor() {
/*     */     return new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue());
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public final Color[] getClientColors() {
/*     */     Color firstColor = null;
/*     */     Color secondColor = null;
/*     */     String str = (String)clolormode.get();
/*     */     boolean bool = false;
/*     */     if (str == null)
/*     */       throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */     Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()");
/*     */     str = str.toLowerCase();
/*     */     switch (str.hashCode()) {
/*     */       case 1378677932:
/*     */         if (str.equals("light rainbow")) {
/*     */           Intrinsics.checkExpressionValueIsNotNull(ColorUtil.rainbow(15, 1, 0.6F, 1.0F, 1.0F), "ColorUtil.rainbow(15, 1, .6f, 1F, 1F)");
/*     */           firstColor = ColorUtil.rainbow(15, 1, 0.6F, 1.0F, 1.0F);
/*     */           Intrinsics.checkExpressionValueIsNotNull(ColorUtil.rainbow(15, 40, 0.6F, 1.0F, 1.0F), "ColorUtil.rainbow(15, 40, .6f, 1F, 1F)");
/*     */           secondColor = ColorUtil.rainbow(15, 40, 0.6F, 1.0F, 1.0F);
/*     */           return new Color[] { firstColor, secondColor };
/*     */         } 
/*     */         break;
/*     */       case -1246115351:
/*     */         if (str.equals("gident")) {
/*     */           firstColor = mixColors(getClientColor(), getAlternateClientColor());
/*     */           secondColor = mixColors(getAlternateClientColor(), getClientColor());
/*     */           return new Color[] { firstColor, secondColor };
/*     */         } 
/*     */         break;
/*     */       case 973576630:
/*     */         if (str.equals("rainbow")) {
/*     */           Intrinsics.checkExpressionValueIsNotNull(ColorUtil.rainbow(15, 1, 1.0F, 1.0F, 1.0F), "ColorUtil.rainbow(15, 1, 1F, 1F, 1F)");
/*     */           firstColor = ColorUtil.rainbow(15, 1, 1.0F, 1.0F, 1.0F);
/*     */           Intrinsics.checkExpressionValueIsNotNull(ColorUtil.rainbow(15, 40, 1.0F, 1.0F, 1.0F), "ColorUtil.rainbow(15, 40, 1F, 1F, 1F)");
/*     */           secondColor = ColorUtil.rainbow(15, 40, 1.0F, 1.0F, 1.0F);
/*     */           return new Color[] { firstColor, secondColor };
/*     */         } 
/*     */         break;
/*     */       case -429400492:
/*     */         if (str.equals("double color")) {
/*     */           Intrinsics.checkExpressionValueIsNotNull(ColorUtil.interpolateColorsBackAndForth(15, 0, Color.PINK, Color.BLUE, ((Boolean)this.hueInterpolation.get()).booleanValue()), "ColorUtil.interpolateCol…, hueInterpolation.get())");
/*     */           firstColor = ColorUtil.interpolateColorsBackAndForth(15, 0, Color.PINK, Color.BLUE, ((Boolean)this.hueInterpolation.get()).booleanValue());
/*     */           Intrinsics.checkExpressionValueIsNotNull(ColorUtil.interpolateColorsBackAndForth(15, 90, Color.PINK, Color.BLUE, ((Boolean)this.hueInterpolation.get()).booleanValue()), "ColorUtil.interpolateCol…, hueInterpolation.get())");
/*     */           secondColor = ColorUtil.interpolateColorsBackAndForth(15, 90, Color.PINK, Color.BLUE, ((Boolean)this.hueInterpolation.get()).booleanValue());
/*     */           return new Color[] { firstColor, secondColor };
/*     */         } 
/*     */         break;
/*     */       case -892481938:
/*     */         if (str.equals("static")) {
/*     */           firstColor = new Color(((Number)this.colorRedValue.get()).intValue(), ((Number)this.colorGreenValue.get()).intValue(), ((Number)this.colorBlueValue.get()).intValue());
/*     */           secondColor = firstColor;
/*     */           return new Color[] { firstColor, secondColor };
/*     */         } 
/*     */         break;
/*     */     } 
/*     */     firstColor = new Color(-1);
/*     */     secondColor = new Color(-1);
/*     */     return new Color[] { firstColor, secondColor };
/*     */   }
/*     */   
/*     */   private final Color mixColors(Color color1, Color color2) {
/*     */     if (((Boolean)this.sColors.get()).booleanValue()) {
/*     */       Intrinsics.checkExpressionValueIsNotNull(ColorUtil.interpolateColorsBackAndForth(15, 1, color1, color2, ((Boolean)this.hueInterpolation.get()).booleanValue()), "ColorUtil.interpolateCol…ation.get()\n            )");
/*     */     } else {
/*     */       Intrinsics.checkExpressionValueIsNotNull(ColorUtil.interpolateColorC(color1, color2, 0.0F), "ColorUtil.interpolateColorC(color1, color2, 0F)");
/*     */     } 
/*     */     return ColorUtil.interpolateColorC(color1, color2, 0.0F);
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@Nullable UpdateEvent event) {
/*     */     Retreat.INSTANCE.getHud().update();
/*     */   }
/*     */   
/*     */   public final int getHotbarEasePos(int x) {
/*     */     if (!getState() || !((Boolean)this.hotbarEaseValue.get()).booleanValue())
/*     */       return x; 
/*     */     this.easingValue = x;
/*     */     return this.easingValue;
/*     */   }
/*     */   
/*     */   private final void onArmor(IEntityLivingBase target) {}
/*     */   
/*     */   @EventTarget
/*     */   public final void onKey(@NotNull KeyEvent event) {
/*     */     Intrinsics.checkParameterIsNotNull(event, "event");
/*     */     Retreat.INSTANCE.getHud().handleKey('a', event.getKey());
/*     */   }
/*     */   
/*     */   @EventTarget(ignoreCondition = true)
/*     */   public final void onScreen(@NotNull ScreenEvent event) {
/*     */     Intrinsics.checkParameterIsNotNull(event, "event");
/*     */     if (MinecraftInstance.mc.getTheWorld() == null || MinecraftInstance.mc.getThePlayer() == null)
/*     */       return; 
/*     */     if (getState() && ((Boolean)this.blurValue.get()).booleanValue() && !MinecraftInstance.mc.getEntityRenderer().isShaderActive() && event.getGuiScreen() != null && !MinecraftInstance.classProvider.isGuiChat(event.getGuiScreen()) && !MinecraftInstance.classProvider.isGuiHudDesigner(event.getGuiScreen())) {
/*     */       MinecraftInstance.mc.getEntityRenderer().loadShader(MinecraftInstance.classProvider.createResourceLocation("liquidbounce/blur.json"));
/*     */     } else if (MinecraftInstance.mc.getEntityRenderer().getShaderGroup() != null) {
/*     */       if (MinecraftInstance.mc.getEntityRenderer().getShaderGroup() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       if (StringsKt.contains$default(MinecraftInstance.mc.getEntityRenderer().getShaderGroup().getShaderGroupName(), "liquidbounce/blur.json", false, 2, null))
/*     */         MinecraftInstance.mc.getEntityRenderer().stopUseShader(); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\HUD.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */