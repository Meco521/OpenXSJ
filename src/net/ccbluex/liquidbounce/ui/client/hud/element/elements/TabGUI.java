/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ import java.awt.Color;
/*     */ import java.io.Closeable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import kotlin.Unit;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.io.CloseableKt;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IFontRenderer;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.shader.shaders.RainbowShader;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ElementInfo(name = "TabGUI")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000n\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\013\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\030\002\n\002\b\002\n\002\020\007\n\002\b\005\n\002\020\b\n\002\b\004\n\002\020!\n\002\030\002\n\002\b\006\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\f\n\002\b\003\n\002\030\002\n\002\b\004\b\007\030\0002\0020\001:\002:;B\031\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003¢\006\002\020\005J\n\020/\032\004\030\00100H\026J\030\0201\032\002022\006\0203\032\002042\006\0205\032\0020#H\026J\020\0206\032\002022\006\0207\032\00208H\002J\b\0209\032\00202H\002R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\n\032\0020\007X\004¢\006\002\n\000R\016\020\013\032\0020\007X\004¢\006\002\n\000R\016\020\f\032\0020\007X\004¢\006\002\n\000R\016\020\r\032\0020\007X\004¢\006\002\n\000R\016\020\016\032\0020\007X\004¢\006\002\n\000R\016\020\017\032\0020\007X\004¢\006\002\n\000R\016\020\020\032\0020\007X\004¢\006\002\n\000R\016\020\021\032\0020\007X\004¢\006\002\n\000R\016\020\022\032\0020\tX\004¢\006\002\n\000R\016\020\023\032\0020\007X\004¢\006\002\n\000R\016\020\024\032\0020\025X\004¢\006\002\n\000R\016\020\026\032\0020\tX\004¢\006\002\n\000R\016\020\027\032\0020\030X\016¢\006\002\n\000R\016\020\031\032\0020\032X\004¢\006\002\n\000R\016\020\033\032\0020\007X\004¢\006\002\n\000R\016\020\034\032\0020\035X\016¢\006\002\n\000R\016\020\036\032\0020\025X\004¢\006\002\n\000R\016\020\037\032\0020\025X\004¢\006\002\n\000R\016\020 \032\0020\tX\004¢\006\002\n\000R\016\020!\032\0020\007X\004¢\006\002\n\000R\016\020\"\032\0020#X\016¢\006\002\n\000R\016\020$\032\0020#X\016¢\006\002\n\000R\016\020%\032\0020\025X\004¢\006\002\n\000R\016\020&\032\0020\035X\016¢\006\002\n\000R\030\020'\032\f\022\b\022\0060)R\0020\0000(X\004¢\006\002\n\000R\016\020*\032\0020\tX\004¢\006\002\n\000R\016\020+\032\0020\025X\004¢\006\002\n\000R\016\020,\032\0020\tX\004¢\006\002\n\000R\016\020-\032\0020\tX\004¢\006\002\n\000R\016\020.\032\0020\025X\004¢\006\002\n\000¨\006<"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/TabGUI;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "(DD)V", "alphaValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "arrowsValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "backgroundAlphaValue", "backgroundBlueValue", "backgroundGreenValue", "backgroundRedValue", "blueValue", "borderAlphaValue", "borderBlueValue", "borderGreenValue", "borderRainbow", "borderRedValue", "borderStrength", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "borderValue", "categoryMenu", "", "fontValue", "Lnet/ccbluex/liquidbounce/value/FontValue;", "greenValue", "itemY", "", "rainbowX", "rainbowY", "rectangleRainbow", "redValue", "selectedCategory", "", "selectedModule", "tabHeight", "tabY", "tabs", "", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/TabGUI$Tab;", "textFade", "textPositionY", "textShadow", "upperCaseValue", "width", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "handleKey", "", "c", "", "keyCode", "parseAction", "action", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/TabGUI$Action;", "updateAnimation", "Action", "Tab", "XSJClient"})
/*     */ public final class TabGUI extends Element {
/*     */   public TabGUI(double x, double y) {
/*  24 */     super(x, y, 0.0F, null, 12, null);
/*     */     
/*  26 */     this.rainbowX = new FloatValue("Rainbow-X", -1000.0F, -2000.0F, 2000.0F);
/*  27 */     this.rainbowY = new FloatValue("Rainbow-Y", -1000.0F, -2000.0F, 2000.0F);
/*  28 */     this.redValue = new IntegerValue("Rectangle Red", 0, 0, 255);
/*  29 */     this.greenValue = new IntegerValue("Rectangle Green", 148, 0, 255);
/*  30 */     this.blueValue = new IntegerValue("Rectangle Blue", 255, 0, 255);
/*  31 */     this.alphaValue = new IntegerValue("Rectangle Alpha", 140, 0, 255);
/*  32 */     this.rectangleRainbow = new BoolValue("Rectangle Rainbow", false);
/*  33 */     this.backgroundRedValue = new IntegerValue("Background Red", 0, 0, 255);
/*  34 */     this.backgroundGreenValue = new IntegerValue("Background Green", 0, 0, 255);
/*  35 */     this.backgroundBlueValue = new IntegerValue("Background Blue", 0, 0, 255);
/*  36 */     this.backgroundAlphaValue = new IntegerValue("Background Alpha", 150, 0, 255);
/*  37 */     this.borderValue = new BoolValue("Border", true);
/*  38 */     this.borderStrength = new FloatValue("Border Strength", 2.0F, 1.0F, 5.0F);
/*  39 */     this.borderRedValue = new IntegerValue("Border Red", 0, 0, 255);
/*  40 */     this.borderGreenValue = new IntegerValue("Border Green", 0, 0, 255);
/*  41 */     this.borderBlueValue = new IntegerValue("Border Blue", 0, 0, 255);
/*  42 */     this.borderAlphaValue = new IntegerValue("Border Alpha", 150, 0, 255);
/*  43 */     this.borderRainbow = new BoolValue("Border Rainbow", false);
/*  44 */     this.arrowsValue = new BoolValue("Arrows", true);
/*  45 */     Intrinsics.checkExpressionValueIsNotNull(Fonts.roboto35, "Fonts.roboto35"); this.fontValue = new FontValue("Font", Fonts.roboto35);
/*  46 */     this.textShadow = new BoolValue("TextShadow", false);
/*  47 */     this.textFade = new BoolValue("TextFade", true);
/*  48 */     this.textPositionY = new FloatValue("TextPosition-Y", 2.0F, 0.0F, 5.0F);
/*  49 */     this.width = new FloatValue("Width", 60.0F, 55.0F, 100.0F);
/*  50 */     this.tabHeight = new FloatValue("TabHeight", 12.0F, 10.0F, 15.0F);
/*  51 */     this.upperCaseValue = new BoolValue("UpperCase", false);
/*     */     
/*  53 */     TabGUI tabGUI = this; boolean bool = false; ArrayList<Tab> arrayList = new ArrayList();
/*     */     
/*  55 */     this.categoryMenu = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  63 */     ModuleCategory[] arrayOfModuleCategory = ModuleCategory.values(); int i = arrayOfModuleCategory.length; byte b = 0; while (true) { Tab tab; Iterator iterator; if (b < i) { ModuleCategory category = arrayOfModuleCategory[b];
/*  64 */         Intrinsics.checkExpressionValueIsNotNull(category.getDisplayName(), "category.displayName"); tab = new Tab(category.getDisplayName());
/*     */         
/*  66 */         Iterable $this$filter$iv = Retreat.INSTANCE.getModuleManager().getModules();
/*  67 */         int $i$f$filter = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 362 */         Iterable iterable1 = $this$filter$iv; Collection<Object> destination$iv$iv = new ArrayList(); int $i$f$filterTo = 0;
/* 363 */         for (Object element$iv$iv : iterable1) { Module module = (Module)element$iv$iv; int $i$a$-filter-TabGUI$1 = 0; if ((category == module.getCategory()))
/* 364 */             destination$iv$iv.add(element$iv$iv);  }  Iterable $this$forEach$iv = destination$iv$iv; int $i$f$forEach = 0;
/* 365 */         iterator = $this$forEach$iv.iterator(); } else { break; }  if (iterator.hasNext()) { Object element$iv = iterator.next(); Module e = (Module)element$iv; int $i$a$-forEach-TabGUI$2 = 0;
/*     */         tab.getModules().add(e); }
/*     */       
/*     */       this.tabs.add(tab);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   private final FloatValue rainbowX;
/*     */   private final FloatValue rainbowY;
/*     */   private final IntegerValue redValue;
/*     */   private final IntegerValue greenValue;
/*     */   private final IntegerValue blueValue;
/*     */   private final IntegerValue alphaValue;
/*     */   private final BoolValue rectangleRainbow;
/*     */   private final IntegerValue backgroundRedValue;
/*     */   private final IntegerValue backgroundGreenValue;
/*     */   private final IntegerValue backgroundBlueValue;
/*     */   private final IntegerValue backgroundAlphaValue;
/*     */   private final BoolValue borderValue;
/*     */   private final FloatValue borderStrength;
/*     */   private final IntegerValue borderRedValue;
/*     */   private final IntegerValue borderGreenValue;
/*     */   private final IntegerValue borderBlueValue;
/*     */   private final IntegerValue borderAlphaValue;
/*     */   private final BoolValue borderRainbow;
/*     */   private final BoolValue arrowsValue;
/*     */   private final FontValue fontValue;
/*     */   private final BoolValue textShadow;
/*     */   private final BoolValue textFade;
/*     */   private final FloatValue textPositionY;
/*     */   private final FloatValue width;
/*     */   private final FloatValue tabHeight;
/*     */   private final BoolValue upperCaseValue;
/*     */   private final List<Tab> tabs;
/*     */   private boolean categoryMenu;
/*     */   private int selectedCategory;
/*     */   private int selectedModule;
/*     */   private float tabY;
/*     */   private float itemY;
/*     */   
/*     */   @Nullable
/*     */   public Border drawElement() {
/*     */     updateAnimation();
/*     */     AWTFontRenderer.Companion.setAssumeNonVolatile(true);
/*     */     IFontRenderer fontRenderer = (IFontRenderer)this.fontValue.get();
/*     */     boolean rectangleRainbowEnabled = ((Boolean)this.rectangleRainbow.get()).booleanValue();
/*     */     Color backgroundColor = new Color(((Number)this.backgroundRedValue.get()).intValue(), ((Number)this.backgroundGreenValue.get()).intValue(), ((Number)this.backgroundBlueValue.get()).intValue(), ((Number)this.backgroundAlphaValue.get()).intValue());
/*     */     Color borderColor = !((Boolean)this.borderRainbow.get()).booleanValue() ? new Color(((Number)this.borderRedValue.get()).intValue(), ((Number)this.borderGreenValue.get()).intValue(), ((Number)this.borderBlueValue.get()).intValue(), ((Number)this.borderAlphaValue.get()).intValue()) : Color.black;
/*     */     float guiHeight = this.tabs.size() * ((Number)this.tabHeight.get()).floatValue();
/*     */     RenderUtils.drawRect(1.0F, 0.0F, ((Number)this.width.get()).floatValue(), guiHeight, backgroundColor.getRGB());
/*     */     if (((Boolean)this.borderValue.get()).booleanValue()) {
/*     */       RainbowShader.Companion companion1 = RainbowShader.Companion;
/*     */       boolean bool1 = ((Boolean)this.borderRainbow.get()).booleanValue();
/*     */       float f3 = (((Number)this.rainbowX.get()).floatValue() == 0.0F) ? 0.0F : (1.0F / ((Number)this.rainbowX.get()).floatValue()), f4 = (((Number)this.rainbowY.get()).floatValue() == 0.0F) ? 0.0F : (1.0F / ((Number)this.rainbowY.get()).floatValue()), f5 = (float)(System.currentTimeMillis() % 10000L) / 10000.0F;
/*     */       int i = 0;
/*     */       RainbowShader rainbowShader = RainbowShader.INSTANCE;
/*     */       if (bool1) {
/*     */         rainbowShader.setStrengthX(f3);
/*     */         rainbowShader.setStrengthY(f4);
/*     */         rainbowShader.setOffset(f5);
/*     */         rainbowShader.startShader();
/*     */       } 
/*     */       Closeable closeable1 = (Closeable)rainbowShader;
/*     */       boolean enable$iv = false;
/*     */       Throwable throwable1 = (Throwable)null;
/*     */       try {
/*     */         RainbowShader it = (RainbowShader)closeable1;
/*     */         int $i$a$-use-TabGUI$drawElement$1 = 0;
/*     */         Intrinsics.checkExpressionValueIsNotNull(borderColor, "borderColor");
/*     */         RenderUtils.drawBorder(1.0F, 0.0F, ((Number)this.width.get()).floatValue(), guiHeight, ((Number)this.borderStrength.get()).floatValue(), borderColor.getRGB());
/*     */         Unit unit = Unit.INSTANCE;
/*     */       } catch (Throwable throwable2) {
/*     */         throwable1 = throwable2 = null;
/*     */         throw throwable2;
/*     */       } finally {
/*     */         CloseableKt.closeFinally(closeable1, throwable1);
/*     */       } 
/*     */     } 
/*     */     Color rectColor = !rectangleRainbowEnabled ? new Color(((Number)this.redValue.get()).intValue(), ((Number)this.greenValue.get()).intValue(), ((Number)this.blueValue.get()).intValue(), ((Number)this.alphaValue.get()).intValue()) : Color.black;
/*     */     RainbowShader.Companion companion = RainbowShader.Companion;
/*     */     float f1 = (((Number)this.rainbowX.get()).floatValue() == 0.0F) ? 0.0F : (1.0F / ((Number)this.rainbowX.get()).floatValue()), f2 = (((Number)this.rainbowY.get()).floatValue() == 0.0F) ? 0.0F : (1.0F / ((Number)this.rainbowY.get()).floatValue()), offset$iv = (float)(System.currentTimeMillis() % 10000L) / 10000.0F;
/*     */     int $i$f$begin = 0;
/*     */     RainbowShader instance$iv = RainbowShader.INSTANCE;
/*     */     if (rectangleRainbowEnabled) {
/*     */       instance$iv.setStrengthX(f1);
/*     */       instance$iv.setStrengthY(f2);
/*     */       instance$iv.setOffset(offset$iv);
/*     */       instance$iv.startShader();
/*     */     } 
/*     */     Closeable closeable = (Closeable)instance$iv;
/*     */     boolean bool = false;
/*     */     Throwable throwable = (Throwable)null;
/*     */     try {
/*     */       RainbowShader it = (RainbowShader)closeable;
/*     */       int $i$a$-use-TabGUI$drawElement$2 = 0;
/*     */       RenderUtils.drawRect(1.0F, true + this.tabY - true, ((Number)this.width.get()).floatValue(), this.tabY + ((Number)this.tabHeight.get()).floatValue(), rectColor);
/*     */       Unit unit = Unit.INSTANCE;
/*     */     } catch (Throwable throwable1) {
/*     */       throwable = throwable1 = null;
/*     */       throw throwable1;
/*     */     } finally {
/*     */       CloseableKt.closeFinally(closeable, throwable);
/*     */     } 
/*     */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     float y = 1.0F;
/*     */     Iterable<Tab> $this$forEachIndexed$iv = this.tabs;
/*     */     int $i$f$forEachIndexed = 0;
/*     */     int index$iv = 0;
/*     */     Iterator<Tab> iterator = $this$forEachIndexed$iv.iterator();
/*     */     if (iterator.hasNext()) {
/*     */       Object item$iv = iterator.next();
/*     */       int i = index$iv++;
/*     */       boolean bool1 = false;
/*     */       if (i < 0)
/*     */         CollectionsKt.throwIndexOverflow(); 
/*     */       int j = i;
/*     */       Tab tab = (Tab)item$iv;
/*     */       int index = j, $i$a$-forEachIndexed-TabGUI$drawElement$3 = 0;
/*     */       if (((Boolean)this.upperCaseValue.get()).booleanValue()) {
/*     */         String str = tab.getTabName();
/*     */         boolean bool2 = false;
/*     */         if (str == null)
/*     */           throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */         Intrinsics.checkExpressionValueIsNotNull(str.toUpperCase(), "(this as java.lang.String).toUpperCase()");
/*     */       } else {
/*     */       
/*     */       } 
/*     */     } 
/*     */     AWTFontRenderer.Companion.setAssumeNonVolatile(false);
/*     */     return new Border(1.0F, 0.0F, ((Number)this.width.get()).floatValue(), guiHeight);
/*     */   }
/*     */   
/*     */   public void handleKey(char c, int keyCode) {
/*     */     switch (keyCode) {
/*     */       case 200:
/*     */         parseAction(Action.UP);
/*     */         break;
/*     */       case 208:
/*     */         parseAction(Action.DOWN);
/*     */         break;
/*     */       case 205:
/*     */         parseAction((getSide().getHorizontal() == Side.Horizontal.RIGHT) ? Action.LEFT : Action.RIGHT);
/*     */         break;
/*     */       case 203:
/*     */         parseAction((getSide().getHorizontal() == Side.Horizontal.RIGHT) ? Action.RIGHT : Action.LEFT);
/*     */         break;
/*     */       case 28:
/*     */         parseAction(Action.TOGGLE);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   private final void updateAnimation() {
/*     */     int index$iv;
/*     */     Iterator<Tab> iterator;
/*     */     int delta = RenderUtils.deltaTime;
/*     */     float xPos = ((Number)this.tabHeight.get()).floatValue() * this.selectedCategory;
/*     */     if ((int)this.tabY != (int)xPos) {
/*     */       if (xPos > this.tabY) {
/*     */         this.tabY += 0.1F * delta;
/*     */       } else {
/*     */         this.tabY -= 0.1F * delta;
/*     */       } 
/*     */     } else {
/*     */       this.tabY = xPos;
/*     */     } 
/*     */     float xPos2 = ((Number)this.tabHeight.get()).floatValue() * this.selectedModule;
/*     */     if ((int)this.itemY != (int)xPos2) {
/*     */       if (xPos2 > this.itemY) {
/*     */         this.itemY += 0.1F * delta;
/*     */       } else {
/*     */         this.itemY -= 0.1F * delta;
/*     */       } 
/*     */     } else {
/*     */       this.itemY = xPos2;
/*     */     } 
/*     */     if (this.categoryMenu)
/*     */       this.itemY = 0.0F; 
/*     */     if (((Boolean)this.textFade.get()).booleanValue()) {
/*     */       Iterable<Tab> $this$forEachIndexed$iv = this.tabs;
/*     */       int $i$f$forEachIndexed = 0;
/*     */       index$iv = 0;
/*     */       iterator = $this$forEachIndexed$iv.iterator();
/*     */     } else {
/*     */       for (Tab tab : this.tabs) {
/*     */         if (tab.getTextFade() > false)
/*     */           tab.setTextFade(tab.getTextFade() - 0.05F * delta); 
/*     */         if (tab.getTextFade() < false)
/*     */           tab.setTextFade(0.0F); 
/*     */       } 
/*     */       return;
/*     */     } 
/*     */     if (iterator.hasNext()) {
/*     */       Object item$iv = iterator.next();
/*     */       int i = index$iv++;
/*     */       boolean bool = false;
/*     */       if (i < 0)
/*     */         CollectionsKt.throwIndexOverflow(); 
/*     */       int j = i;
/*     */       Tab tab = (Tab)item$iv;
/*     */       int index = j, $i$a$-forEachIndexed-TabGUI$updateAnimation$1 = 0;
/*     */       if (index == this.selectedCategory) {
/*     */         if (tab.getTextFade() < 4)
/*     */           tab.setTextFade(tab.getTextFade() + 0.05F * delta); 
/*     */         if (tab.getTextFade() > 4)
/*     */           tab.setTextFade(4.0F); 
/*     */       } else {
/*     */         if (tab.getTextFade() > false)
/*     */           tab.setTextFade(tab.getTextFade() - 0.05F * delta); 
/*     */         if (tab.getTextFade() < false)
/*     */           tab.setTextFade(0.0F); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private final void parseAction(Action action) {
/*     */     boolean toggle = false;
/*     */     switch (TabGUI$WhenMappings.$EnumSwitchMapping$0[action.ordinal()]) {
/*     */       case 1:
/*     */         if (this.categoryMenu) {
/*     */           this.selectedCategory--;
/*     */           if (this.selectedCategory < 0) {
/*     */             this.selectedCategory = this.tabs.size() - 1;
/*     */             this.tabY = ((Number)this.tabHeight.get()).floatValue() * this.selectedCategory;
/*     */           } 
/*     */           break;
/*     */         } 
/*     */         this.selectedModule--;
/*     */         if (this.selectedModule < 0) {
/*     */           this.selectedModule = ((Tab)this.tabs.get(this.selectedCategory)).getModules().size() - 1;
/*     */           this.itemY = ((Number)this.tabHeight.get()).floatValue() * this.selectedModule;
/*     */         } 
/*     */         break;
/*     */       case 2:
/*     */         if (this.categoryMenu) {
/*     */           this.selectedCategory++;
/*     */           if (this.selectedCategory > this.tabs.size() - 1) {
/*     */             this.selectedCategory = 0;
/*     */             this.tabY = ((Number)this.tabHeight.get()).floatValue() * this.selectedCategory;
/*     */           } 
/*     */           break;
/*     */         } 
/*     */         this.selectedModule++;
/*     */         if (this.selectedModule > ((Tab)this.tabs.get(this.selectedCategory)).getModules().size() - 1) {
/*     */           this.selectedModule = 0;
/*     */           this.itemY = ((Number)this.tabHeight.get()).floatValue() * this.selectedModule;
/*     */         } 
/*     */         break;
/*     */       case 3:
/*     */         if (!this.categoryMenu)
/*     */           this.categoryMenu = true; 
/*     */         break;
/*     */       case 4:
/*     */         if (!this.categoryMenu) {
/*     */           toggle = true;
/*     */           break;
/*     */         } 
/*     */         this.categoryMenu = false;
/*     */         this.selectedModule = 0;
/*     */         break;
/*     */       case 5:
/*     */         if (!this.categoryMenu)
/*     */           toggle = true; 
/*     */         break;
/*     */     } 
/*     */     if (toggle) {
/*     */       int sel = this.selectedModule;
/*     */       ((Module)((Tab)this.tabs.get(this.selectedCategory)).getModules().get(sel)).toggle();
/*     */     } 
/*     */   }
/*     */   
/*     */   public TabGUI() {
/*     */     this(0.0D, 0.0D, 3, null);
/*     */   }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000D\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\002\b\002\n\002\020\b\n\002\b\005\n\002\020!\n\002\030\002\n\002\b\005\n\002\020\007\n\002\b\005\n\002\020\002\n\002\b\007\n\002\020\013\n\000\n\002\030\002\n\002\b\003\b\004\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004JV\020\030\032\0020\0312\006\020\032\032\0020\0232\006\020\033\032\0020\0232\006\020\034\032\0020\0062\006\020\035\032\0020\0062\006\020\036\032\0020\0062\006\020\037\032\0020\0232\006\020 \032\0020!2\006\020\"\032\0020#2\006\020$\032\0020!2\006\020%\032\0020!R\032\020\005\032\0020\006X\016¢\006\016\n\000\032\004\b\007\020\b\"\004\b\t\020\nR\027\020\013\032\b\022\004\022\0020\r0\f¢\006\b\n\000\032\004\b\016\020\017R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\020\020\021R\032\020\022\032\0020\023X\016¢\006\016\n\000\032\004\b\024\020\025\"\004\b\026\020\027¨\006&"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/TabGUI$Tab;", "", "tabName", "", "(Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/TabGUI;Ljava/lang/String;)V", "menuWidth", "", "getMenuWidth", "()I", "setMenuWidth", "(I)V", "modules", "", "Lnet/ccbluex/liquidbounce/features/module/Module;", "getModules", "()Ljava/util/List;", "getTabName", "()Ljava/lang/String;", "textFade", "", "getTextFade", "()F", "setTextFade", "(F)V", "drawTab", "", "x", "y", "color", "backgroundColor", "borderColor", "borderStrength", "upperCase", "", "fontRenderer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;", "borderRainbow", "rectRainbow", "XSJClient"})
/*     */   private final class Tab {
/*     */     @NotNull
/*     */     private final List<Module> modules;
/*     */     private int menuWidth;
/*     */     private float textFade;
/*     */     @NotNull
/*     */     private final String tabName;
/*     */     
/*     */     @NotNull
/*     */     public final String getTabName() {
/*     */       return this.tabName;
/*     */     }
/*     */     
/*     */     public Tab(String tabName) {
/*     */       this.tabName = tabName;
/*     */       Tab tab = this;
/*     */       boolean bool = false;
/*     */       ArrayList<Module> arrayList = new ArrayList();
/*     */     }
/*     */     
/*     */     @NotNull
/*     */     public final List<Module> getModules() {
/*     */       return this.modules;
/*     */     }
/*     */     
/*     */     public final int getMenuWidth() {
/*     */       return this.menuWidth;
/*     */     }
/*     */     
/*     */     public final void setMenuWidth(int <set-?>) {
/*     */       this.menuWidth = <set-?>;
/*     */     }
/*     */     
/*     */     public final float getTextFade() {
/*     */       return this.textFade;
/*     */     }
/*     */     
/*     */     public final void setTextFade(float <set-?>) {
/*     */       this.textFade = <set-?>;
/*     */     }
/*     */     
/*     */     public final void drawTab(float x, float y, int color, int backgroundColor, int borderColor, float borderStrength, boolean upperCase, @NotNull IFontRenderer fontRenderer, boolean borderRainbow, boolean rectRainbow) {
/*     */       Intrinsics.checkParameterIsNotNull(fontRenderer, "fontRenderer");
/*     */       int maxWidth = 0;
/*     */       for (Module module : this.modules) {
/*     */         String str1 = module.getName();
/*     */         IFontRenderer iFontRenderer = fontRenderer;
/*     */         boolean bool1 = false;
/*     */         if (str1 == null)
/*     */           throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */         Intrinsics.checkExpressionValueIsNotNull(str1.toUpperCase(), "(this as java.lang.String).toUpperCase()");
/*     */         String str2 = str1.toUpperCase();
/*     */         if (iFontRenderer.getStringWidth(upperCase ? str2 : module.getName()) + 4 > maxWidth) {
/*     */           str1 = module.getName();
/*     */           iFontRenderer = fontRenderer;
/*     */           bool1 = false;
/*     */           if (str1 == null)
/*     */             throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */           Intrinsics.checkExpressionValueIsNotNull(str1.toUpperCase(), "(this as java.lang.String).toUpperCase()");
/*     */           str2 = str1.toUpperCase();
/*     */           maxWidth = (int)(iFontRenderer.getStringWidth(upperCase ? str2 : module.getName()) + 7.0F);
/*     */         } 
/*     */       } 
/*     */       this.menuWidth = maxWidth;
/*     */       float menuHeight = this.modules.size() * ((Number)TabGUI.this.tabHeight.get()).floatValue();
/*     */       if (((Boolean)TabGUI.this.borderValue.get()).booleanValue()) {
/*     */         RainbowShader.Companion companion1 = RainbowShader.Companion;
/*     */         float f3 = (((Number)TabGUI.this.rainbowX.get()).floatValue() == 0.0F) ? 0.0F : (1.0F / ((Number)TabGUI.this.rainbowX.get()).floatValue()), f4 = (((Number)TabGUI.this.rainbowY.get()).floatValue() == 0.0F) ? 0.0F : (1.0F / ((Number)TabGUI.this.rainbowY.get()).floatValue()), f5 = (float)(System.currentTimeMillis() % 10000L) / 10000.0F;
/*     */         int i = 0;
/*     */         RainbowShader rainbowShader = RainbowShader.INSTANCE;
/*     */         if (borderRainbow) {
/*     */           rainbowShader.setStrengthX(f3);
/*     */           rainbowShader.setStrengthY(f4);
/*     */           rainbowShader.setOffset(f5);
/*     */           rainbowShader.startShader();
/*     */         } 
/*     */         Closeable closeable1 = (Closeable)rainbowShader;
/*     */         boolean bool1 = false;
/*     */         Throwable throwable1 = (Throwable)null;
/*     */         try {
/*     */           RainbowShader it = (RainbowShader)closeable1;
/*     */           int $i$a$-use-TabGUI$Tab$drawTab$1 = 0;
/*     */           RenderUtils.drawBorder(x - 1.0F, y - 1.0F, x + this.menuWidth - 2.0F, y + menuHeight - 1.0F, borderStrength, borderColor);
/*     */           Unit unit = Unit.INSTANCE;
/*     */         } catch (Throwable throwable2) {
/*     */           throwable1 = throwable2 = null;
/*     */           throw throwable2;
/*     */         } finally {
/*     */           CloseableKt.closeFinally(closeable1, throwable1);
/*     */         } 
/*     */       } 
/*     */       RenderUtils.drawRect(x - 1.0F, y - 1.0F, x + this.menuWidth - 2.0F, y + menuHeight - 1.0F, backgroundColor);
/*     */       RainbowShader.Companion companion = RainbowShader.Companion;
/*     */       float f1 = (((Number)TabGUI.this.rainbowX.get()).floatValue() == 0.0F) ? 0.0F : (1.0F / ((Number)TabGUI.this.rainbowX.get()).floatValue()), f2 = (((Number)TabGUI.this.rainbowY.get()).floatValue() == 0.0F) ? 0.0F : (1.0F / ((Number)TabGUI.this.rainbowY.get()).floatValue()), offset$iv = (float)(System.currentTimeMillis() % 10000L) / 10000.0F;
/*     */       int $i$f$begin = 0;
/*     */       RainbowShader instance$iv = RainbowShader.INSTANCE;
/*     */       if (rectRainbow) {
/*     */         instance$iv.setStrengthX(f1);
/*     */         instance$iv.setStrengthY(f2);
/*     */         instance$iv.setOffset(offset$iv);
/*     */         instance$iv.startShader();
/*     */       } 
/*     */       Closeable closeable = (Closeable)instance$iv;
/*     */       boolean bool = false;
/*     */       Throwable throwable = (Throwable)null;
/*     */       try {
/*     */         RainbowShader it = (RainbowShader)closeable;
/*     */         int $i$a$-use-TabGUI$Tab$drawTab$2 = 0;
/*     */         RenderUtils.drawRect(x - true, y + TabGUI.this.itemY - true, x + this.menuWidth - 2.0F, y + TabGUI.this.itemY + ((Number)TabGUI.this.tabHeight.get()).floatValue() - true, color);
/*     */         Unit unit = Unit.INSTANCE;
/*     */       } catch (Throwable throwable1) {
/*     */         throwable = throwable1 = null;
/*     */         throw throwable1;
/*     */       } finally {
/*     */         CloseableKt.closeFinally(closeable, throwable);
/*     */       } 
/*     */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */       Iterable<Module> $this$forEachIndexed$iv = this.modules;
/*     */       int $i$f$forEachIndexed = 0;
/*     */       int index$iv = 0;
/*     */       Iterator<Module> iterator = $this$forEachIndexed$iv.iterator();
/*     */       if (iterator.hasNext()) {
/*     */         Object item$iv = iterator.next();
/*     */         int i = index$iv++;
/*     */         boolean bool1 = false;
/*     */         if (i < 0)
/*     */           CollectionsKt.throwIndexOverflow(); 
/*     */         int j = i;
/*     */         Module module = (Module)item$iv;
/*     */         int index = j, $i$a$-forEachIndexed-TabGUI$Tab$drawTab$3 = 0;
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\f\n\002\030\002\n\002\020\020\n\002\b\007\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002j\002\b\003j\002\b\004j\002\b\005j\002\b\006j\002\b\007¨\006\b"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/TabGUI$Action;", "", "(Ljava/lang/String;I)V", "UP", "DOWN", "LEFT", "RIGHT", "TOGGLE", "XSJClient"})
/*     */   public enum Action {
/*     */     UP, DOWN, LEFT, RIGHT, TOGGLE;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\TabGUI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */