/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;@ElementInfo(name = "PlayerList")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000@\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\006\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\036\032\0020\037H\026R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\004X\004¢\006\002\n\000R\016\020\007\032\0020\004X\004¢\006\002\n\000R\016\020\b\032\0020\004X\004¢\006\002\n\000R\016\020\t\032\0020\004X\004¢\006\002\n\000R\016\020\n\032\0020\013X\004¢\006\002\n\000R\016\020\f\032\0020\004X\004¢\006\002\n\000R\016\020\r\032\0020\016X\004¢\006\002\n\000R\016\020\017\032\0020\004X\004¢\006\002\n\000R\016\020\020\032\0020\013X\004¢\006\002\n\000R\016\020\021\032\0020\022X\004¢\006\002\n\000R\016\020\023\032\0020\004X\004¢\006\002\n\000R\016\020\024\032\0020\004X\004¢\006\002\n\000R\016\020\025\032\0020\026X\004¢\006\002\n\000R\016\020\027\032\0020\030X\004¢\006\002\n\000R\016\020\031\032\0020\004X\004¢\006\002\n\000R\016\020\032\032\0020\026X\004¢\006\002\n\000R\016\020\033\032\0020\013X\004¢\006\002\n\000R\016\020\034\032\0020\026X\004¢\006\002\n\000R\016\020\035\032\0020\030X\004¢\006\002\n\000¨\006 "}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/PlayerList;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "()V", "alphaValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "bgalphaValue", "bgblueValue", "bggreenValue", "bgredValue", "blueValue", "brightnessValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "cRainbowSecValue", "decimalFormat3", "Ljava/text/DecimalFormat;", "distanceValue", "fontOffsetValue", "fontValue", "Lnet/ccbluex/liquidbounce/value/FontValue;", "gradientAmountValue", "greenValue", "lineValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "rainbowList", "Lnet/ccbluex/liquidbounce/value/ListValue;", "redValue", "reverseValue", "saturationValue", "shadowValue", "sortValue", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "XSJClient"})
/*     */ public final class PlayerList extends Element { private final DecimalFormat decimalFormat3; private final ListValue sortValue; private final FloatValue fontOffsetValue;
/*     */   private final BoolValue reverseValue;
/*     */   private final FontValue fontValue;
/*     */   private final BoolValue shadowValue;
/*     */   private final BoolValue lineValue;
/*     */   private final IntegerValue redValue;
/*     */   private final IntegerValue greenValue;
/*     */   private final IntegerValue blueValue;
/*     */   private final IntegerValue alphaValue;
/*     */   private final IntegerValue bgredValue;
/*     */   private final IntegerValue bggreenValue;
/*     */   private final IntegerValue bgblueValue;
/*     */   private final IntegerValue bgalphaValue;
/*     */   private final ListValue rainbowList;
/*     */   private final FloatValue saturationValue;
/*     */   private final FloatValue brightnessValue;
/*     */   private final IntegerValue cRainbowSecValue;
/*     */   private final IntegerValue distanceValue;
/*     */   private final IntegerValue gradientAmountValue;
/*     */   
/*     */   public PlayerList() {
/*  24 */     super(0.0D, 0.0D, 0.0F, null, 15, null);
/*     */     
/*  26 */     this.decimalFormat3 = new DecimalFormat("0.#", new DecimalFormatSymbols(Locale.ENGLISH));
/*  27 */     this.sortValue = new ListValue("Sort", new String[] { "Alphabet", "Distance", "Health" }, "Alphabet");
/*  28 */     this.fontOffsetValue = new FloatValue("Font-Offset", 0.0F, 3.0F, -3.0F);
/*  29 */     this.reverseValue = new BoolValue("Reverse", false);
/*  30 */     Intrinsics.checkExpressionValueIsNotNull(Fonts.font35, "Fonts.font35"); this.fontValue = new FontValue("Font", Fonts.font35);
/*  31 */     this.shadowValue = new BoolValue("Shadow", false);
/*  32 */     this.lineValue = new BoolValue("Line", true);
/*  33 */     this.redValue = new IntegerValue("Red", 255, 0, 255);
/*  34 */     this.greenValue = new IntegerValue("Green", 255, 0, 255);
/*  35 */     this.blueValue = new IntegerValue("Blue", 255, 0, 255);
/*  36 */     this.alphaValue = new IntegerValue("Alpha", 255, 0, 255);
/*  37 */     this.bgredValue = new IntegerValue("Background-Red", 0, 0, 255);
/*  38 */     this.bggreenValue = new IntegerValue("Background-Green", 0, 0, 255);
/*  39 */     this.bgblueValue = new IntegerValue("Background-Blue", 0, 0, 255);
/*  40 */     this.bgalphaValue = new IntegerValue("Background-Alpha", 120, 0, 255);
/*  41 */     this.rainbowList = new ListValue("Rainbow", new String[] { "Off", "CRainbow", "Sky", "LiquidSlowly", "Fade", "Mixer" }, "Off");
/*     */     
/*  43 */     this.saturationValue = new FloatValue("Saturation", 0.9F, 0.0F, 1.0F);
/*  44 */     this.brightnessValue = new FloatValue("Brightness", 1.0F, 0.0F, 1.0F);
/*  45 */     this.cRainbowSecValue = new IntegerValue("Seconds", 2, 1, 10);
/*  46 */     this.distanceValue = new IntegerValue("Line-Distance", 0, 0, 400);
/*  47 */     this.gradientAmountValue = new IntegerValue("Gradient-Amount", 25, 1, 50);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\020\n\000\n\002\020\b\n\000\n\002\030\002\n\002\b\003\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\0032\016\020\005\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\006"}, d2 = {"<anonymous>", "", "a", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;", "kotlin.jvm.PlatformType", "b", "compare"})
/*     */   static final class PlayerList$drawElement$2<T>
/*     */     implements Comparator<IEntityPlayer>
/*     */   {
/*     */     public static final PlayerList$drawElement$2 INSTANCE = new PlayerList$drawElement$2();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int compare(IEntityPlayer a, IEntityPlayer b) {
/*  69 */       Intrinsics.checkExpressionValueIsNotNull(a, "a"); MinecraftInstance.mc.getThePlayer(); if (((MinecraftInstance.mc.getThePlayer() != null) ? Double.valueOf(PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), (IEntity)a)) : null) == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(b, "b"); return Double.compare(((MinecraftInstance.mc.getThePlayer() != null) ? Double.valueOf(PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), (IEntity)a)) : null).doubleValue(), PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), (IEntity)b)); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\020\n\000\n\002\020\b\n\000\n\002\030\002\n\002\b\003\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\0032\016\020\005\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\006"}, d2 = {"<anonymous>", "", "a", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;", "kotlin.jvm.PlatformType", "b", "compare"})
/*  70 */   static final class PlayerList$drawElement$3<T> implements Comparator<IEntityPlayer> { public static final PlayerList$drawElement$3 INSTANCE = new PlayerList$drawElement$3(); public final int compare(IEntityPlayer a, IEntityPlayer b) { return Float.compare(a.getHealth(), b.getHealth()); }
/*     */      }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public Border drawElement() {
/*     */     boolean reverse = ((Boolean)this.reverseValue.get()).booleanValue();
/*     */     IFontRenderer font = (IFontRenderer)this.fontValue.get();
/*     */     float fontOffset = ((Number)this.fontOffsetValue.get()).floatValue();
/*     */     String rainbowType = (String)this.rainbowList.get();
/*     */     float nameLength = font.getStringWidth("Name (0)");
/*     */     float hpLength = font.getStringWidth("Health");
/*     */     float distLength = font.getStringWidth("Distance");
/*     */     float height = 4.0F + Fonts.font35.getFontHeight();
/*     */     int color = (new Color(((Number)this.redValue.get()).intValue(), ((Number)this.greenValue.get()).intValue(), ((Number)this.blueValue.get()).intValue(), ((Number)this.alphaValue.get()).intValue())).getRGB();
/*     */     Color bgColor = new Color(((Number)this.bgredValue.get()).intValue(), ((Number)this.bggreenValue.get()).intValue(), ((Number)this.bgblueValue.get()).intValue(), ((Number)this.bgalphaValue.get()).intValue());
/*     */     if (MinecraftInstance.mc.getTheWorld() == null) {
/*     */       Intrinsics.throwNpe();
/*     */     }
/*     */     Iterable $this$filter$iv = MinecraftInstance.mc.getTheWorld().getPlayerEntities();
/*     */     int $i$f$filter = 0;
/* 131 */     Iterable iterable1 = $this$filter$iv; Collection<Object> destination$iv$iv = new ArrayList(); int $i$f$filterTo = 0;
/* 132 */     for (Object element$iv$iv : iterable1) { IEntityPlayer it = (IEntityPlayer)element$iv$iv; int $i$a$-filter-PlayerList$drawElement$playerList$1 = 0; if ((!AntiBot.isBot((IEntityLivingBase)it) && (Intrinsics.areEqual(it, MinecraftInstance.mc.getThePlayer()) ^ true) != 0))
/* 133 */         destination$iv$iv.add(element$iv$iv);  }  List playerList = CollectionsKt.toMutableList(destination$iv$iv); nameLength = font.getStringWidth("Name (" + playerList.size() + ')'); String str1 = (String)this.sortValue.get(); switch (str1.hashCode()) { case 1985170067: if (str1.equals("Alphabet")) { List list = playerList; $i$f$filter = 0; PlayerList$drawElement$$inlined$compareBy$1 playerList$drawElement$$inlined$compareBy$1 = new PlayerList$drawElement$$inlined$compareBy$1(); CollectionsKt.sortWith(list, playerList$drawElement$$inlined$compareBy$1); break; } case 353103893: if (str1.equals("Distance")) { CollectionsKt.sortWith(playerList, PlayerList$drawElement$2.INSTANCE); break; } default: CollectionsKt.sortWith(playerList, PlayerList$drawElement$3.INSTANCE); break; }  if (reverse)
/* 134 */       playerList = CollectionsKt.toMutableList(CollectionsKt.reversed(playerList));  Iterable $this$forEach$iv = playerList; int $i$f$forEach = 0; Iterator iterator1 = $this$forEach$iv.iterator(); if (iterator1.hasNext()) { Object element$iv = iterator1.next(); IEntityPlayer it = (IEntityPlayer)element$iv; int $i$a$-forEach-PlayerList$drawElement$4 = 0; if (it.getName() == null) Intrinsics.throwNpe();  }  if (((Boolean)this.lineValue.get()).booleanValue()) { double barLength = (nameLength + hpLength + distLength + 50.0F); byte b = 0; int i = ((Number)this.gradientAmountValue.get()).intValue() - 1; if (b <= i) while (true) { double barStart = b / ((Number)this.gradientAmountValue.get()).intValue() * barLength; double barEnd = (b + 1) / ((Number)this.gradientAmountValue.get()).intValue() * barLength; String str = rainbowType; switch (str.hashCode()) { case 83201: if (str.equals("Sky"));case -884013110: if (str.equals("LiquidSlowly")) if (ColorUtils.LiquidSlowly(System.nanoTime(), b * ((Number)this.distanceValue.get()).intValue(), ((Number)this.saturationValue.get()).floatValue(), ((Number)this.brightnessValue.get()).floatValue()) == null) Intrinsics.throwNpe();  case 74357737: if (str.equals("Mixer")) Intrinsics.checkExpressionValueIsNotNull(ColorMixer.getMixedColor(b * ((Number)this.distanceValue.get()).intValue(), ((Number)this.cRainbowSecValue.get()).intValue()), "ColorMixer.getMixedColor…, cRainbowSecValue.get())"); case -852561933: if (str.equals("CRainbow"));case 2181788: if (str.equals("Fade"));default: break; }  str = rainbowType; switch (str.hashCode()) { case 83201: if (str.equals("Sky"));case -884013110: if (str.equals("LiquidSlowly")) if (ColorUtils.LiquidSlowly(System.nanoTime(), (b + 1) * ((Number)this.distanceValue.get()).intValue(), ((Number)this.saturationValue.get()).floatValue(), ((Number)this.brightnessValue.get()).floatValue()) == null)
/*     */                   Intrinsics.throwNpe();  case 74357737: if (str.equals("Mixer"))
/* 136 */                 Intrinsics.checkExpressionValueIsNotNull(ColorMixer.getMixedColor((b + 1) * ((Number)this.distanceValue.get()).intValue(), ((Number)this.cRainbowSecValue.get()).intValue()), "ColorMixer.getMixedColor…, cRainbowSecValue.get())"); case -852561933: if (str.equals("CRainbow"));case 2181788: if (str.equals("Fade"));default: break; }  RenderUtils.drawGradientSideways(barStart, -1.0D, barEnd, 0.0D, color, color); if (b != i) { b++; continue; }  break; }   }  RenderUtils.drawRect(0.0F, 0.0F, nameLength + hpLength + distLength + 50.0F, 4.0F + Fonts.font35.getFontHeight(), bgColor.getRGB()); font.drawString("Name (" + playerList.size() + ')', 5.0F, 3.0F, -1, ((Boolean)this.shadowValue.get()).booleanValue()); font.drawString("Distance", 5.0F + nameLength + 10.0F, 3.0F, -1, ((Boolean)this.shadowValue.get()).booleanValue()); font.drawString("Health", 5.0F + nameLength + distLength + 20.0F, 3.0F, -1, ((Boolean)this.shadowValue.get()).booleanValue()); Iterable $this$forEachIndexed$iv = playerList; int $i$f$forEachIndexed = 0; int index$iv = 0;
/* 137 */     Iterator iterator2 = $this$forEachIndexed$iv.iterator(); if (iterator2.hasNext()) { Object item$iv = iterator2.next(); int i = index$iv++; boolean bool = false; if (i < 0) CollectionsKt.throwIndexOverflow();  int j = i; IEntityPlayer iEntityPlayer = (IEntityPlayer)item$iv; int index = j, $i$a$-forEachIndexed-PlayerList$drawElement$5 = 0;
/*     */       RenderUtils.drawRect(0.0F, height, nameLength + hpLength + distLength + 50.0F, height + 2.0F + Fonts.font35.getFontHeight(), bgColor.getRGB()); }
/*     */     
/*     */     return new Border(0.0F, 0.0F, nameLength + hpLength + distLength + 50.0F, 4.0F + height + Fonts.font35.getFontHeight());
/*     */   } }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\PlayerList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */