/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ import java.awt.Color;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.TreeSet;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.ui.client.hud.element.Border;
/*     */ import net.ccbluex.liquidbounce.ui.client.hud.element.Side;
/*     */ import net.ccbluex.liquidbounce.ui.font.AWTFontRenderer;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ 
/*     */ @ElementInfo(name = "VapeArraylist", single = true)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000^\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\007\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\020 \n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\002\n\002\030\002\n\000\n\002\020\002\n\000\b\007\030\0002\0020\001B-\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006\022\b\b\002\020\007\032\0020\b¢\006\002\020\tJ\n\020\036\032\004\030\0010\037H\026J\b\020 \032\0020!H\026R\016\020\n\032\0020\013X\004¢\006\002\n\000R\016\020\f\032\0020\rX\004¢\006\002\n\000R\016\020\016\032\0020\rX\004¢\006\002\n\000R\016\020\017\032\0020\rX\004¢\006\002\n\000R\016\020\020\032\0020\021X\004¢\006\002\n\000R\016\020\022\032\0020\013X\004¢\006\002\n\000R\024\020\023\032\b\022\004\022\0020\0250\024X\016¢\006\002\n\000R\016\020\026\032\0020\013X\004¢\006\002\n\000R\016\020\027\032\0020\030X\004¢\006\002\n\000R\016\020\031\032\0020\030X\004¢\006\002\n\000R\016\020\032\032\0020\030X\004¢\006\002\n\000R\016\020\033\032\0020\034X\016¢\006\002\n\000R\016\020\035\032\0020\006X\016¢\006\002\n\000¨\006\""}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/VapeArraylist;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "scale", "", "side", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;", "(DDFLnet/ccbluex/liquidbounce/ui/client/hud/element/Side;)V", "backgroundValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "colorBlueValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "colorGreenValue", "colorRedValue", "image", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;", "imageValue", "modules", "", "Lnet/ccbluex/liquidbounce/features/module/Module;", "shadow", "spaceValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "textHeightValue", "textYValue", "x2", "", "y2", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "updateElement", "", "XSJClient"})
/*     */ public final class VapeArraylist extends Element {
/*     */   private final IntegerValue colorRedValue;
/*     */   private final IntegerValue colorGreenValue;
/*     */   private final IntegerValue colorBlueValue;
/*     */   private final BoolValue imageValue;
/*     */   private final BoolValue backgroundValue;
/*     */   private final BoolValue shadow;
/*     */   private final FloatValue spaceValue;
/*     */   private final FloatValue textHeightValue;
/*     */   private final FloatValue textYValue;
/*     */   private int x2;
/*     */   private float y2;
/*     */   private List<? extends Module> modules;
/*     */   private final IResourceLocation image;
/*     */   
/*     */   public VapeArraylist(double x, double y, float scale, @NotNull Side side) {
/*  35 */     super(x, y, scale, side);
/*  36 */     this.colorRedValue = new IntegerValue("R", 0, 0, 255);
/*  37 */     this.colorGreenValue = new IntegerValue("G", 111, 0, 255);
/*  38 */     this.colorBlueValue = new IntegerValue("B", 255, 0, 255);
/*  39 */     this.imageValue = new BoolValue("Logo", true);
/*  40 */     this.backgroundValue = new BoolValue("Background", true);
/*  41 */     this.shadow = new BoolValue("ShadowText", true);
/*  42 */     this.spaceValue = new FloatValue("Space", 0.0F, 0.0F, 5.0F);
/*  43 */     this.textHeightValue = new FloatValue("TextHeight", 11.0F, 1.0F, 20.0F);
/*  44 */     this.textYValue = new FloatValue("TextY", 1.0F, 0.0F, 20.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  49 */     this.modules = CollectionsKt.emptyList();
/*  50 */     this.image = MinecraftInstance.classProvider.createResourceLocation("courage/vapelogo.png");
/*     */   }
/*     */   
/*     */   @Nullable
/*  54 */   public Border drawElement() { FontDrawer fontRenderer = FontLoaders.S18;
/*     */     
/*  56 */     AWTFontRenderer.Companion.setAssumeNonVolatile(true);
/*     */ 
/*     */     
/*  59 */     int delta = RenderUtils.deltaTime;
/*     */     
/*  61 */     for (Module module : Retreat.INSTANCE.getModuleManager().getModules()) {
/*  62 */       if (!module.getArray() || (!module.getState() && module.getSlide() == 0.0F))
/*     */         continue; 
/*  64 */       String displayString = module.getName();
/*     */       
/*  66 */       int width = fontRenderer.getStringWidth(displayString);
/*     */       
/*  68 */       if (module.getState()) {
/*  69 */         if (module.getSlide() < width) {
/*  70 */           module.setSlide(AnimationUtils.easeOut(module.getSlideStep(), width) * width);
/*  71 */           module.setSlideStep(module.getSlideStep() + delta / 4.0F);
/*     */         } 
/*  73 */       } else if (module.getSlide() > false) {
/*  74 */         module.setSlide(AnimationUtils.easeOut(module.getSlideStep(), width) * width);
/*  75 */         module.setSlideStep(module.getSlideStep() - delta / 4.0F);
/*     */       } 
/*     */       
/*  78 */       module.setSlide(RangesKt.coerceIn(module.getSlide(), 0.0F, width));
/*  79 */       module.setSlideStep(RangesKt.coerceIn(module.getSlideStep(), 0.0F, width));
/*     */     } 
/*     */ 
/*     */     
/*  83 */     float space = ((Number)this.spaceValue.get()).floatValue();
/*  84 */     float textHeight = ((Number)this.textHeightValue.get()).floatValue();
/*  85 */     float textY = ((Number)this.textYValue.get()).floatValue();
/*  86 */     int backgroundCustomColor = (new Color(0, 0, 0, 100)).getRGB();
/*  87 */     boolean textShadow = ((Boolean)this.shadow.get()).booleanValue();
/*  88 */     float textSpacer = textHeight + space;
/*  89 */     Color customColor = new Color(((Number)this.colorRedValue.get()).intValue(), ((Number)this.colorGreenValue.get()).intValue(), ((Number)this.colorBlueValue.get()).intValue(), 255);
/*     */     
/*  91 */     Iterable<? extends Module> $this$forEachIndexed$iv = this.modules; int $i$f$forEachIndexed = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 161 */     int index$iv = 0;
/* 162 */     Iterator<? extends Module> iterator = $this$forEachIndexed$iv.iterator(); if (iterator.hasNext()) { Object item$iv = iterator.next(); int i = index$iv++; boolean bool = false; if (i < 0) CollectionsKt.throwIndexOverflow();  int j = i; Module module = (Module)item$iv; int index = j, $i$a$-forEachIndexed-VapeArraylist$drawElement$1 = 0; String displayString = module.getName(); float xPos = -module.getSlide() - 2; }  if (((Boolean)this.imageValue.get()).booleanValue()) RenderUtils.drawImage(this.image, -57, -11, 57, 11);  if (MinecraftInstance.classProvider.isGuiHudDesigner(MinecraftInstance.mc.getCurrentScreen())) { this.x2 = Integer.MIN_VALUE; if (this.modules.isEmpty())
/*     */         return new Border(0.0F, -1.0F, -20.0F, 20.0F);  for (Module module : this.modules) { int xPos; switch (VapeArraylist$WhenMappings.$EnumSwitchMapping$0[getSide().getHorizontal().ordinal()]) { case 1: case 2: xPos = -((int)module.getSlide()) - 2; if (this.x2 == Integer.MIN_VALUE || xPos < this.x2)
/* 164 */               this.x2 = xPos;  }  }  this.y2 = textSpacer * this.modules.size(); return new Border(0.0F, 0.0F, this.x2 - 7.0F, this.y2 - ((getSide().getVertical() == Side.Vertical.DOWN) ? 1.0F : 0.0F)); }  AWTFontRenderer.Companion.setAssumeNonVolatile(false); GlStateManager.func_179117_G(); return null; } public void updateElement() { TreeSet treeSet1 = Retreat.INSTANCE.getModuleManager().getModules(); VapeArraylist vapeArraylist = this; int $i$f$filter = 0; TreeSet treeSet2 = treeSet1; Collection<Object> destination$iv$iv = new ArrayList(); int $i$f$filterTo = 0;
/* 165 */     for (Object element$iv$iv : treeSet2) { Module it = (Module)element$iv$iv; int $i$a$-filter-VapeArraylist$updateElement$1 = 0; if ((it.getArray() && it.getSlide() > false))
/* 166 */         destination$iv$iv.add(element$iv$iv);  }  List<? extends Module> list = (List)destination$iv$iv; Iterable<? extends Module> $this$filter$iv = list; vapeArraylist = vapeArraylist; int $i$f$sortedBy = 0;
/* 167 */     Iterable<? extends Module> $this$filterTo$iv$iv = $this$filter$iv; boolean bool = false; VapeArraylist$updateElement$$inlined$sortedBy$1 vapeArraylist$updateElement$$inlined$sortedBy$1 = new VapeArraylist$updateElement$$inlined$sortedBy$1(); vapeArraylist.modules = list = CollectionsKt.sortedWith($this$filterTo$iv$iv, vapeArraylist$updateElement$$inlined$sortedBy$1); }
/*     */ 
/*     */   
/*     */   public VapeArraylist() {
/*     */     this(0.0D, 0.0D, 0.0F, null, 15, null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\VapeArraylist.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */