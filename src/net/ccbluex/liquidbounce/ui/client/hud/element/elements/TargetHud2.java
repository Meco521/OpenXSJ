/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;@ElementInfo(name = "TargetHud2")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000V\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\t\n\000\n\002\020\025\n\002\b\002\n\002\030\002\n\000\n\002\020\007\n\002\b\002\n\002\030\002\n\002\b\b\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\002\n\002\b\005\n\002\030\002\n\002\b\016\b\007\030\0002\0020\001B\005¢\006\002\020\002J\030\020#\032\0020$2\006\020%\032\0020\0372\006\020&\032\0020\021H\002J\030\020'\032\0020$2\006\020%\032\0020\0372\006\020(\032\0020\021H\002J\n\020)\032\004\030\0010*H\026J\030\020+\032\0020$2\006\020%\032\0020\0372\006\020&\032\0020\021H\002J\030\020,\032\0020$2\006\020%\032\0020\0372\006\020(\032\0020\021H\002J\030\020-\032\0020$2\006\020%\032\0020\0372\006\020(\032\0020\021H\002J\030\020.\032\0020$2\006\020%\032\0020\0372\006\020&\032\0020\021H\002J\030\020/\032\0020$2\006\020%\032\0020\0372\006\020(\032\0020\021H\002J\030\0200\032\0020$2\006\020%\032\0020\0372\006\020(\032\0020\021H\002J\030\0201\032\0020$2\006\020%\032\0020\0372\006\020(\032\0020\021H\002J\030\0202\032\0020$2\006\020%\032\0020\0372\006\020(\032\0020\021H\002J\030\0203\032\0020$2\006\020%\032\0020\0372\006\020(\032\0020\021H\002J\030\0204\032\0020$2\006\020%\032\0020\0372\006\020(\032\0020\021H\002J\022\0205\032\0020\0212\b\0206\032\004\030\0010\037H\002J\n\0207\032\004\030\0010*H\002R\016\020\003\032\0020\004X\004¢\006\002\n\000R\021\020\005\032\0020\004¢\006\b\n\000\032\004\b\006\020\007R\016\020\b\032\0020\004X\004¢\006\002\n\000R\016\020\t\032\0020\nX\016¢\006\002\n\000R\016\020\013\032\0020\fX\004¢\006\002\n\000R\016\020\r\032\0020\fX\004¢\006\002\n\000R\016\020\016\032\0020\017X\004¢\006\002\n\000R\016\020\020\032\0020\021X\016¢\006\002\n\000R\016\020\022\032\0020\021X\016¢\006\002\n\000R\016\020\023\032\0020\024X\004¢\006\002\n\000R\016\020\025\032\0020\004X\004¢\006\002\n\000R\016\020\026\032\0020\004X\004¢\006\002\n\000R\016\020\027\032\0020\004X\004¢\006\002\n\000R\016\020\030\032\0020\004X\004¢\006\002\n\000R\016\020\031\032\0020\021X\016¢\006\002\n\000R\016\020\032\032\0020\021X\016¢\006\002\n\000R\016\020\033\032\0020\nX\016¢\006\002\n\000R\016\020\034\032\0020\035X\004¢\006\002\n\000R\020\020\036\032\004\030\0010\037X\016¢\006\002\n\000R\016\020 \032\0020\004X\004¢\006\002\n\000R\016\020!\032\0020\004X\004¢\006\002\n\000R\016\020\"\032\0020\035X\004¢\006\002\n\000¨\0068"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/TargetHud2;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "()V", "animSpeedValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "backgroundalpha", "getBackgroundalpha", "()Lnet/ccbluex/liquidbounce/value/IntegerValue;", "blueValue", "changeTime", "", "counter1", "", "counter2", "decimalFormat", "Ljava/text/DecimalFormat;", "displayPercent", "", "easingHP", "fontValue", "Lnet/ccbluex/liquidbounce/value/FontValue;", "gblueValue", "ggreenValue", "gredValue", "greenValue", "lastChangeHealth", "lastHealth", "lastUpdate", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "prevTarget", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "redValue", "switchAnimSpeedValue", "switchModeValue", "drawAstolfo", "", "target", "nowAnimHP", "drawBest", "easingHealth", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "drawFlux", "drawLiquid", "drawMoon", "drawNovo", "drawRise", "drawTenacity", "drawZamorozka", "drawnewnovo", "drawnovoline2", "drawnovoline3", "getHealth", "entity", "getTBorder", "XSJClient"})
/*     */ public final class TargetHud2 extends Element {
/*     */   private final ListValue modeValue;
/*     */   private final ListValue switchModeValue;
/*     */   private final IntegerValue animSpeedValue;
/*     */   private final IntegerValue switchAnimSpeedValue;
/*     */   private final FontValue fontValue;
/*     */   @NotNull
/*     */   private final IntegerValue backgroundalpha;
/*     */   private final IntegerValue redValue;
/*     */   private final IntegerValue greenValue;
/*     */   private final IntegerValue blueValue;
/*     */   private final IntegerValue gredValue;
/*     */   private final IntegerValue ggreenValue;
/*     */   private final IntegerValue gblueValue;
/*     */   private float easingHP;
/*     */   private IEntityLivingBase prevTarget;
/*     */   private float lastHealth;
/*     */   private float lastChangeHealth;
/*     */   private long changeTime;
/*     */   private float displayPercent;
/*     */   private long lastUpdate;
/*     */   private final DecimalFormat decimalFormat;
/*     */   private final int[] counter1;
/*     */   private final int[] counter2;
/*     */   
/*     */   public TargetHud2() {
/*  29 */     super(-46.0D, -40.0D, 1.0F, new Side(Side.Horizontal.MIDDLE, Side.Vertical.MIDDLE));
/*  30 */     this.modeValue = new ListValue("Mode", new String[] { "Best", "Novoline", "Astolfo", "Liquid", "Flux", "Rise", "Zamorozka", "novoline2", "moon", "novoline3", "newnovoline", "tenacity" }, "Rise");
/*  31 */     this.switchModeValue = new ListValue("SwitchMode", new String[] { "Slide", "Zoom", "None" }, "Slide");
/*  32 */     this.animSpeedValue = new IntegerValue("AnimSpeed", 10, 5, 20);
/*  33 */     this.switchAnimSpeedValue = new IntegerValue("SwitchAnimSpeed", 20, 5, 40);
/*  34 */     Intrinsics.checkExpressionValueIsNotNull(Fonts.font40, "Fonts.font40"); this.fontValue = new FontValue("Font", Fonts.font40);
/*  35 */     this.backgroundalpha = new IntegerValue("Alpha", 120, 0, 255);
/*  36 */     this.redValue = new IntegerValue("Red", 255, 0, 255);
/*  37 */     this.greenValue = new IntegerValue("Green", 255, 0, 255);
/*  38 */     this.blueValue = new IntegerValue("Blue", 255, 0, 255);
/*  39 */     this.gredValue = new IntegerValue("GradientRed", 255, 0, 255);
/*  40 */     this.ggreenValue = new IntegerValue("GradientGreen", 255, 0, 255);
/*  41 */     this.gblueValue = new IntegerValue("GradientBlue", 255, 0, 255);
/*     */ 
/*     */     
/*  44 */     this.lastHealth = 20.0F;
/*  45 */     this.lastChangeHealth = 20.0F;
/*  46 */     this.changeTime = System.currentTimeMillis();
/*     */     
/*  48 */     this.lastUpdate = System.currentTimeMillis();
/*  49 */     this.decimalFormat = new DecimalFormat("0.0");
/*  50 */     this.counter1 = new int[] { 50 };
/*  51 */     this.counter2 = new int[] { 80 };
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
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002\020\000\032\0020\0012\006\020\002\032\0020\0032\006\020\004\032\0020\003H\n¢\006\002\b\005"}, d2 = {"renderSideway", "", "x", "", "x1", "invoke"})
/*     */   static final class TargetHud2$drawRise$1
/*     */     extends Lambda
/*     */     implements Function2<Integer, Integer, Unit>
/*     */   {
/*     */     public static final TargetHud2$drawRise$1 INSTANCE = new TargetHud2$drawRise$1();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TargetHud2$drawRise$1() {
/*     */       super(2);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void invoke(int x, int x1) {
/* 320 */       RenderUtils.quickDrawGradientSideways(x, 39.0D, x1, 45.0D, ColorUtils.hslRainbow$default(x, 0.0F, 0.0F, 10, 0, 22, null).getRGB(), ColorUtils.hslRainbow$default(x1, 0.0F, 0.0F, 10, 0, 22, null).getRGB());
/*     */     }
/* 322 */   } @NotNull public final IntegerValue getBackgroundalpha() { return this.backgroundalpha; } private final float getHealth(IEntityLivingBase entity) { return (entity == null || entity.isDead()) ? 0.0F : entity.getHealth(); } @Nullable public Border drawElement() { if (Retreat.INSTANCE.getModuleManager().get(KillAura.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura");  IEntityLivingBase target = ((KillAura)Retreat.INSTANCE.getModuleManager().get(KillAura.class)).getTarget(); long time = System.currentTimeMillis(); float pct = (float)(time - this.lastUpdate) / ((Number)this.switchAnimSpeedValue.get()).floatValue() * 50.0F; this.lastUpdate = System.currentTimeMillis(); if (MinecraftInstance.classProvider.isGuiHudDesigner(MinecraftInstance.mc.getCurrentScreen())) target = (IEntityLivingBase)MinecraftInstance.mc.getThePlayer();  if (target != null) this.prevTarget = target;  if (this.prevTarget != null) { if (target != null) { if (this.displayPercent < true) this.displayPercent += pct;  if (this.displayPercent > true) this.displayPercent = 1.0F;  } else { if (this.displayPercent > false) this.displayPercent -= pct;  if (this.displayPercent < false) { this.displayPercent = 0.0F; this.prevTarget = (IEntityLivingBase)null; return getTBorder(); }  }  if (getHealth(this.prevTarget) != this.lastHealth) { this.lastChangeHealth = this.lastHealth; this.lastHealth = getHealth(this.prevTarget); this.changeTime = time; }  float nowAnimHP = (time - (((Number)this.animSpeedValue.get()).intValue() * 50) < this.changeTime) ? (getHealth(this.prevTarget) + (this.lastChangeHealth - getHealth(this.prevTarget)) * (true - (float)(time - this.changeTime) / ((Number)this.animSpeedValue.get()).floatValue() * 50.0F)) : getHealth(this.prevTarget); String str = (String)this.switchModeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case 109526449: if (str.equals("slide")) { double percent = EaseUtils.INSTANCE.easeInQuint(1.0D - this.displayPercent); Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc"); double xAxis = MinecraftInstance.classProvider.createScaledResolution(MinecraftInstance.mc).getScaledWidth() - getRenderX(); GL11.glTranslated(xAxis * percent, 0.0D, 0.0D); }  break;case 3744723: if (str.equals("zoom")) { if (getTBorder() != null) { Border border = getTBorder(); GL11.glScalef(this.displayPercent, this.displayPercent, this.displayPercent); GL11.glTranslatef(border.getX2() * 0.5F * (true - this.displayPercent) / this.displayPercent, border.getY2() * 0.5F * (true - this.displayPercent) / this.displayPercent, 0.0F); break; }  getTBorder(); return null; }  break; }  str = (String)this.modeValue.get(); bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case 1322963594: if (str.equals("zamorozka")) { if (this.prevTarget == null) Intrinsics.throwNpe();  drawZamorozka(this.prevTarget, nowAnimHP); }  break;case 1648341806: if (str.equals("novoline")) { if (this.prevTarget == null) Intrinsics.throwNpe();  drawNovo(this.prevTarget, nowAnimHP); }  break;case -441011516: if (str.equals("novoline2")) { if (this.prevTarget == null) Intrinsics.throwNpe();  drawnovoline2(this.prevTarget, nowAnimHP); }  break;case 3357441: if (str.equals("moon")) { if (this.prevTarget == null) Intrinsics.throwNpe();  drawMoon(this.prevTarget, nowAnimHP); }  break;case -441011515: if (str.equals("novoline3")) { if (this.prevTarget == null) Intrinsics.throwNpe();  drawnovoline3(this.prevTarget, nowAnimHP); }  break;case -1454523186: if (str.equals("newnovoline")) { if (this.prevTarget == null) Intrinsics.throwNpe();  drawnewnovo(this.prevTarget, nowAnimHP); }  break;case -1102567108: if (str.equals("liquid")) { if (this.prevTarget == null) Intrinsics.throwNpe();  drawLiquid(this.prevTarget, nowAnimHP); }  break;case -1307030705: if (str.equals("tenacity")) { if (this.prevTarget == null) Intrinsics.throwNpe();  drawTenacity(this.prevTarget, nowAnimHP); }  break;case -703561496: if (str.equals("astolfo")) { if (this.prevTarget == null) Intrinsics.throwNpe();  drawAstolfo(this.prevTarget, nowAnimHP); }  break;case 3146217: if (str.equals("flux")) { if (this.prevTarget == null) Intrinsics.throwNpe();  drawFlux(this.prevTarget, nowAnimHP); }  break;case 3020260: if (str.equals("best")) { if (this.prevTarget == null) Intrinsics.throwNpe();  drawBest(this.prevTarget, nowAnimHP); }  break;case 3500745: if (str.equals("rise")) { if (this.prevTarget == null) Intrinsics.throwNpe();  drawRise(this.prevTarget, nowAnimHP); }  break; }  return getTBorder(); }  return getTBorder(); } private final void drawAstolfo(IEntityLivingBase target, float nowAnimHP) { IFontRenderer font = (IFontRenderer)this.fontValue.get(); Color color = RenderUtils.skyRainbow(1, 1.0F, 0.9F); float hpPct = nowAnimHP / target.getMaxHealth(); RenderUtils.drawRect(0.0F, 0.0F, 140.0F, 60.0F, (new Color(0, 0, 0, 110)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(color, "color"); RenderUtils.drawRect(3.0F, 55.0F, 137.0F, 58.0F, ColorUtils.INSTANCE.reAlpha(color, 100).getRGB()); RenderUtils.drawRect(3.0F, 55.0F, 3 + hpPct * 134.0F, 58.0F, color.getRGB()); GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); RenderUtils.drawEntityOnScreen(18, 46, 20, target); if (target.getName() == null) Intrinsics.throwNpe();  font.drawStringWithShadow(target.getName(), 37, 6, -1); GL11.glPushMatrix(); GL11.glScalef(2.0F, 2.0F, 2.0F); font.drawString(MathKt.roundToInt(getHealth(target)) + " ❤", 19, 9, color.getRGB()); GL11.glPopMatrix(); } private final void drawRise(IEntityLivingBase target, float easingHealth) { IFontRenderer font = (IFontRenderer)this.fontValue.get(); RenderUtils.drawCircleRect(0.0F, 0.0F, 150.0F, 50.0F, 5.0F, (new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue(), ((Number)AColorPalette.a.get()).intValue())).getRGB()); float hurtPercent = PlayerExtensionKt.getHurtPercent(target); float scale = (hurtPercent == 0.0F) ? 1.0F : ((hurtPercent < 0.5F) ? (true - 0.2F * hurtPercent * 2) : (0.8F + 0.2F * (hurtPercent - 0.5F) * 2)); int size = 30; GL11.glPushMatrix(); GL11.glTranslatef(5.0F, 5.0F, 0.0F); GL11.glScalef(scale, scale, scale); GL11.glTranslatef(size * 0.5F * (true - scale) / scale, size * 0.5F * (true - scale) / scale, 0.0F); GL11.glColor4f(1.0F, true - hurtPercent, true - hurtPercent, 1.0F); if (MinecraftInstance.mc.getNetHandler().getPlayerInfo(target.getUniqueID()) == null) Intrinsics.throwNpe();  RenderUtils.quickDrawHead(MinecraftInstance.mc.getNetHandler().getPlayerInfo(target.getUniqueID()).getLocationSkin(), 0, 0, size, size); GL11.glPopMatrix(); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); font.drawString("Name " + target.getName(), 40, 11, Color.WHITE.getRGB()); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); font.drawString("Distance " + this.decimalFormat.format(PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), (IEntity)target)) + " Hurt " + target.getHurtTime(), 40, 11 + font.getFontHeight(), Color.WHITE.getRGB()); GL11.glEnable(3042); GL11.glDisable(3553); GL11.glBlendFunc(770, 771); GL11.glEnable(2848); GL11.glShadeModel(7425); TargetHud2$drawRise$1 $fun$renderSideway$1 = TargetHud2$drawRise$1.INSTANCE; Intrinsics.checkExpressionValueIsNotNull(this.decimalFormat.format(Float.valueOf(target.getMaxHealth())), "decimalFormat.format(target.maxHealth)"); int stopPos = (int)(5 + (135 - font.getStringWidth(this.decimalFormat.format(Float.valueOf(target.getMaxHealth())))) * easingHealth / target.getMaxHealth());
/* 323 */     byte b = 5; int i = RangesKt.step((IntProgression)new IntRange(b, stopPos), 5).getFirst(), j = RangesKt.step((IntProgression)new IntRange(b, stopPos), 5).getLast(), k = RangesKt.step((IntProgression)new IntRange(b, stopPos), 5).getStep(); if ((k >= 0) ? (i <= j) : (i >= j))
/* 324 */       while (true) { $fun$renderSideway$1.invoke(i, RangesKt.coerceAtMost(i + 5, stopPos)); if (i != j) { int m = i + k; continue; }
/*     */          break; }
/* 326 */         GL11.glEnable(3553);
/* 327 */     GL11.glDisable(3042);
/* 328 */     GL11.glDisable(2848);
/* 329 */     GL11.glShadeModel(7424);
/* 330 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/* 332 */     Intrinsics.checkExpressionValueIsNotNull(this.decimalFormat.format(Float.valueOf(easingHealth)), "decimalFormat.format(easingHealth)"); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); font.drawString(this.decimalFormat.format(Float.valueOf(easingHealth)), stopPos + 5, 43 - font.getFontHeight() / 2, Color.WHITE.getRGB()); }
/*     */   private final void drawNovo(IEntityLivingBase target, float nowAnimHP) { IFontRenderer font = (IFontRenderer)this.fontValue.get(); Color color = ColorUtils.healthColor$default(ColorUtils.INSTANCE, getHealth(target), target.getMaxHealth(), 0, 4, null); Color darkColor = ColorUtils.INSTANCE.darker(color, 0.6F); float hpPos = 33.0F + (MathKt.roundToInt(getHealth(target) / target.getMaxHealth() * '✐') / 100); RenderUtils.drawRect(0.0F, 0.0F, 140.0F, 40.0F, (new Color(40, 40, 40)).getRGB()); if (target.getName() == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); font.drawString(target.getName(), 33, 5, Color.WHITE.getRGB()); RenderUtils.drawEntityOnScreen(20, 35, 15, target); RenderUtils.drawRect(hpPos, 18.0F, 33.0F + (MathKt.roundToInt(nowAnimHP / target.getMaxHealth() * '✐') / 100), 25.0F, darkColor); RenderUtils.drawRect(33.0F, 18.0F, hpPos, 25.0F, color); Intrinsics.checkExpressionValueIsNotNull(Color.RED, "Color.RED"); font.drawString("❤", 33, 30, Color.RED.getRGB()); Intrinsics.checkExpressionValueIsNotNull(this.decimalFormat.format(Float.valueOf(getHealth(target))), "decimalFormat.format(getHealth(target))"); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); font.drawString(this.decimalFormat.format(Float.valueOf(getHealth(target))), 43, 30, Color.WHITE.getRGB()); }
/*     */   private final void drawLiquid(IEntityLivingBase target, float easingHealth) { if (target.getName() == null) Intrinsics.throwNpe();  float width = RangesKt.coerceAtLeast(38 + Fonts.font40.getStringWidth(target.getName()), 118); Intrinsics.checkExpressionValueIsNotNull(Color.BLACK, "Color.BLACK"); Intrinsics.checkExpressionValueIsNotNull(Color.BLACK, "Color.BLACK"); RenderUtils.drawBorderedRect(0.0F, 0.0F, width, 36.0F, 3.0F, Color.BLACK.getRGB(), Color.BLACK.getRGB()); if (easingHealth > getHealth(target)) RenderUtils.drawRect(0.0F, 34.0F, easingHealth / target.getMaxHealth() * width, 36.0F, (new Color(252, 185, 65)).getRGB());  RenderUtils.drawRect(0.0F, 34.0F, getHealth(target) / target.getMaxHealth() * width, 36.0F, (new Color(252, 96, 66)).getRGB()); if (easingHealth < getHealth(target)) RenderUtils.drawRect(easingHealth / target.getMaxHealth() * width, 34.0F, getHealth(target) / target.getMaxHealth() * width, 36.0F, (new Color(44, 201, 144)).getRGB());  String str1 = target.getName(); boolean bool1 = false, bool2 = false; String it = str1; int $i$a$-let-TargetHud2$drawLiquid$1 = 0; if (it == null) Intrinsics.throwNpe();  Fonts.font40.drawString(it, 36, 3, 16777215); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  Fonts.font35.drawString("Distance: " + this.decimalFormat.format(PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), (IEntity)target)), 36, 15, 16777215); if (MinecraftInstance.mc.getNetHandler().getPlayerInfo(target.getUniqueID()) == null) Intrinsics.throwNpe();  RenderUtils.drawHead(MinecraftInstance.mc.getNetHandler().getPlayerInfo(target.getUniqueID()).getLocationSkin(), 2, 2, 30, 30); INetworkPlayerInfo playerInfo = MinecraftInstance.mc.getNetHandler().getPlayerInfo(target.getUniqueID()); if (playerInfo != null) Fonts.font35.drawString("Ping: " + RangesKt.coerceAtLeast(playerInfo.getResponseTime(), 0), 36, 24, 16777215);  }
/* 335 */   private final void drawZamorozka(IEntityLivingBase target, float easingHealth) { IFontRenderer font = (IFontRenderer)this.fontValue.get(); RenderUtils.drawCircleRect(0.0F, 0.0F, 150.0F, 55.0F, 5.0F, (new Color(0, 0, 0, 70)).getRGB()); RenderUtils.drawRect(7.0F, 7.0F, 35.0F, 40.0F, (new Color(0, 0, 0, 70)).getRGB()); GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); RenderUtils.drawEntityOnScreen(21, 38, 15, target); float barLength = 136.0F; RenderUtils.drawCircleRect(7.0F, 45.0F, 143.0F, 50.0F, 2.5F, (new Color(0, 0, 0, 70)).getRGB()); RenderUtils.drawCircleRect(7.0F, 45.0F, 7 + RangesKt.coerceAtLeast(easingHealth / target.getMaxHealth() * barLength, 5.0F), 50.0F, 2.5F, ColorUtils.INSTANCE.rainbowWithAlpha(90).getRGB()); RenderUtils.drawCircleRect(7.0F, 45.0F, 7 + RangesKt.coerceAtLeast(target.getHealth() / target.getMaxHealth() * barLength, 5.0F), 50.0F, 2.5F, ColorUtils.rainbow().getRGB()); RenderUtils.drawCircleRect(43.0F, 15.0F - font.getFontHeight(), 143.0F, 17.0F, (font.getFontHeight() + 1) * 0.45F, (new Color(0, 0, 0, 70)).getRGB()); font.drawCenteredString(target.getName() + ' ' + ((EntityUtils.getPing(target.asEntityPlayer()) != -1) ? ("§f" + EntityUtils.getPing(target.asEntityPlayer()) + "ms") : ""), 93.0F, 16.0F - font.getFontHeight(), ColorUtils.rainbow().getRGB(), false); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); font.drawString("Health: " + this.decimalFormat.format(Float.valueOf(easingHealth)) + " §7/ " + this.decimalFormat.format(Float.valueOf(target.getMaxHealth())), 43, 11 + font.getFontHeight(), Color.WHITE.getRGB()); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); font.drawString("Distance: " + this.decimalFormat.format(PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), (IEntity)target)), 43, 11 + font.getFontHeight() * 2, Color.WHITE.getRGB()); } private final void drawMoon(IEntityLivingBase target, float easingHealth) { IFontRenderer font = (IFontRenderer)this.fontValue.get(); String hp = this.decimalFormat.format(Float.valueOf(easingHealth)); int additionalWidth = RangesKt.coerceAtLeast(font.getStringWidth(target.getName() + "  " + hp + " hp"), 75); GL11.glEnable(3042); GL11.glDisable(3553); GL11.glBlendFunc(770, 771); GL11.glEnable(2848); GL11.glShadeModel(7425); float yPos = (5 + font.getFontHeight()) + 3.0F; Intrinsics.checkExpressionValueIsNotNull(this.decimalFormat.format(Float.valueOf(target.getMaxHealth())), "decimalFormat.format(target.maxHealth)"); int stopPos = (int)(5 + (135 - font.getStringWidth(this.decimalFormat.format(Float.valueOf(target.getMaxHealth())))) * easingHealth / target.getMaxHealth()); byte b = 5; int i = RangesKt.step((IntProgression)new IntRange(b, stopPos), 5).getFirst(), j = RangesKt.step((IntProgression)new IntRange(b, stopPos), 5).getLast(), k = RangesKt.step((IntProgression)new IntRange(b, stopPos), 5).getStep(); if ((k >= 0) ? (i <= j) : (i >= j)) while (true) { double x1 = RangesKt.coerceAtMost(i + 5, stopPos); RenderUtils.quickDrawGradientSideways(i - 5.0D, 0.0D, 45.0D + additionalWidth - true, 1.0D, ColorUtils.hslRainbow$default(i, 0.0F, 0.0F, 10, 0, 22, null).getRGB(), ColorUtils.hslRainbow$default((int)x1, 0.0F, 0.0F, 0, 0, 22, null).getRGB()); if (i != j) { int m = i + k; continue; }  break; }   GL11.glEnable(3553); GL11.glDisable(3042); GL11.glDisable(2848); GL11.glShadeModel(7424); GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); RenderUtils.drawRect(37.0F, yPos + 5, 37.0F + additionalWidth, yPos + 13, (new Color(0, 0, 0, 100)).getRGB()); if (target.getHealth() <= target.getMaxHealth()) RenderUtils.drawCircleRect(37.0F, yPos + 5, 37.0F + (MathKt.roundToInt(easingHealth / target.getMaxHealth() * 'ᾤ') / 100), yPos + 13, 3.0F, (new Color(0, 255, 0)).getRGB());  if (target.getHealth() < target.getMaxHealth() / 2) RenderUtils.drawCircleRect(37.0F, yPos + 5, 37.0F + (MathKt.roundToInt(easingHealth / target.getMaxHealth() * 'ᾤ') / 100), yPos + 13, 3.0F, (new Color(255, 255, 0)).getRGB());  if (target.getHealth() < target.getMaxHealth() / 4) RenderUtils.drawCircleRect(37.0F, yPos + 5, 37.0F + (MathKt.roundToInt(easingHealth / target.getMaxHealth() * 'ᾤ') / 100), yPos + 13, 3.0F, (new Color(255, 0, 0)).getRGB());  GL11.glEnable(3553); GL11.glDisable(3042); GL11.glDisable(2848); GL11.glShadeModel(7424); GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); if (target.getName() == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); font.drawString(target.getName(), 37, 5, Color.WHITE.getRGB()); if (MinecraftInstance.mc.getNetHandler().getPlayerInfo(target.getUniqueID()) == null) Intrinsics.throwNpe();  RenderUtils.drawHead(MinecraftInstance.mc.getNetHandler().getPlayerInfo(target.getUniqueID()).getLocationSkin(), 2, 2, 32, 32); GL11.glScaled(0.7D, 0.7D, 0.7D); String str1 = hp + " hp"; j = 0; k = 0; String it = str1; int $i$a$-also-TargetHud2$drawMoon$1 = 0; Intrinsics.checkExpressionValueIsNotNull(Color.LIGHT_GRAY, "Color.LIGHT_GRAY"); font.drawString(it, 53, 23, Color.LIGHT_GRAY.getRGB()); } private final void drawBest(IEntityLivingBase target, float easingHealth) { IFontRenderer font = (IFontRenderer)this.fontValue.get();
/* 336 */     if (target.getName() == null) Intrinsics.throwNpe();  float addedLen = 60 + font.getStringWidth(target.getName()) * 1.6F;
/*     */     
/* 338 */     RenderUtils.drawRect(0.0F, 0.0F, addedLen, 47.0F, (new Color(0, 0, 0, 120)).getRGB());
/* 339 */     RenderUtils.drawRoundedCornerRect(0.0F, 0.0F, easingHealth / target.getMaxHealth() * addedLen, 47.0F, 3.0F, (new Color(0, 0, 0, 90)).getRGB());
/*     */     
/* 341 */     RenderUtils.drawShadowWithCustomAlpha(0.0F, 0.0F, addedLen, 47.0F, 200.0F);
/*     */     
/* 343 */     float hurtPercent = PlayerExtensionKt.getHurtPercent(target);
/* 344 */     float scale = (hurtPercent == 0.0F) ? 1.0F : ((hurtPercent < 0.5F) ? (
/* 345 */       true - 0.1F * hurtPercent * 2) : (
/*     */       
/* 347 */       0.9F + 0.1F * (hurtPercent - 0.5F) * 2));
/*     */     
/* 349 */     int size = 35;
/*     */     
/* 351 */     GL11.glPushMatrix();
/* 352 */     GL11.glTranslatef(5.0F, 5.0F, 0.0F);
/*     */     
/* 354 */     GL11.glScalef(scale, scale, scale);
/* 355 */     GL11.glTranslatef(size * 0.5F * (true - scale) / scale, size * 0.5F * (true - scale) / scale, 0.0F);
/*     */     
/* 357 */     GL11.glColor4f(1.0F, true - hurtPercent, true - hurtPercent, 1.0F);
/*     */     
/* 359 */     if (MinecraftInstance.mc.getNetHandler().getPlayerInfo(target.getUniqueID()) == null) Intrinsics.throwNpe();  RenderUtils.drawHead(MinecraftInstance.mc.getNetHandler().getPlayerInfo(target.getUniqueID()).getLocationSkin(), 0, 0, size, size);
/* 360 */     GL11.glPopMatrix();
/*     */     
/* 362 */     GL11.glPushMatrix();
/* 363 */     GL11.glScalef(1.5F, 1.5F, 1.5F);
/* 364 */     if (target.getName() == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); font.drawString(target.getName(), 39, 8, Color.WHITE.getRGB());
/*     */     
/* 366 */     GL11.glPopMatrix();
/* 367 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); font.drawString("Health " + MathKt.roundToInt(target.getHealth()), 56, 20 + (int)(font.getFontHeight() * 1.5D), Color.WHITE.getRGB()); }
/*     */   
/*     */   private final void drawFlux(IEntityLivingBase target, float nowAnimHP) {
/* 370 */     if (target.getName() == null) Intrinsics.throwNpe();  float width = 
/* 371 */       RangesKt.coerceAtLeast(38 + Fonts.font40.getStringWidth(target.getName()), 70);
/*     */ 
/*     */ 
/*     */     
/* 375 */     RenderUtils.drawRect(0.0F, 0.0F, width, 34.0F, (new Color(40, 40, 40)).getRGB());
/* 376 */     Intrinsics.checkExpressionValueIsNotNull(Color.BLACK, "Color.BLACK"); RenderUtils.drawRect(2.0F, 22.0F, width - 2.0F, 24.0F, Color.BLACK.getRGB());
/* 377 */     Intrinsics.checkExpressionValueIsNotNull(Color.BLACK, "Color.BLACK"); RenderUtils.drawRect(2.0F, 28.0F, width - 2.0F, 30.0F, Color.BLACK.getRGB());
/*     */ 
/*     */     
/* 380 */     RenderUtils.drawRect(2.0F, 22.0F, 2 + nowAnimHP / target.getMaxHealth() * (width - 4), 24.0F, (new Color(231, 182, 0)).getRGB());
/* 381 */     RenderUtils.drawRect(2.0F, 22.0F, 2 + getHealth(target) / target.getMaxHealth() * (width - 4), 24.0F, (new Color(0, 224, 84)).getRGB());
/* 382 */     RenderUtils.drawRect(2.0F, 28.0F, 2 + target.getTotalArmorValue() / 20.0F * (width - 4), 30.0F, (new Color(77, 128, 255)).getRGB());
/*     */ 
/*     */     
/* 385 */     if (target.getName() == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.font40.drawString(target.getName(), 22, 3, Color.WHITE.getRGB());
/* 386 */     GL11.glPushMatrix();
/* 387 */     GL11.glScaled(0.7D, 0.7D, 0.7D);
/* 388 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.font35.drawString("Health: " + this.decimalFormat.format(Float.valueOf(getHealth(target))), 31.428572F, (4 + Fonts.font40.getFontHeight()) / 0.7F, Color.WHITE.getRGB());
/* 389 */     GL11.glPopMatrix();
/*     */ 
/*     */     
/* 392 */     if (MinecraftInstance.mc.getNetHandler().getPlayerInfo(target.getUniqueID()) == null) Intrinsics.throwNpe();  RenderUtils.drawHead(MinecraftInstance.mc.getNetHandler().getPlayerInfo(target.getUniqueID()).getLocationSkin(), 2, 2, 16, 16);
/*     */   }
/*     */   private final void drawnovoline2(IEntityLivingBase target, float easingHealth) {
/* 395 */     if (target.getName() == null) Intrinsics.throwNpe();  float width = RangesKt.coerceAtLeast(38 + Fonts.font40.getStringWidth(target.getName()), 118);
/* 396 */     RenderUtils.drawRect(0.0F, 0.0F, width + 14.0F, 44.0F, (new Color(0, 0, 0, ((Number)this.backgroundalpha.get()).intValue())).getRGB());
/* 397 */     if (MinecraftInstance.mc.getNetHandler().getPlayerInfo(target.getUniqueID()) == null) Intrinsics.throwNpe();  RenderUtils.drawHead(MinecraftInstance.mc.getNetHandler().getPlayerInfo(target.getUniqueID()).getLocationSkin(), 3, 3, 30, 30);
/* 398 */     if (target.getName() == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.font40.drawString(target.getName(), 34.5F, 4.0F, Color.WHITE.getRGB());
/* 399 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.font40.drawString("Health: " + this.decimalFormat.format(Float.valueOf(target.getHealth())), 34.5F, 14.0F, Color.WHITE.getRGB());
/*     */     
/* 401 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();
/*     */ 
/*     */     
/* 404 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.font40.drawString("Distance: " + this.decimalFormat.format(Float.valueOf(MinecraftInstance.mc.getThePlayer().getDistanceToEntity((IEntity)target))) + 'm', 34.5F, 24.0F, Color.WHITE.getRGB());
/*     */     
/* 406 */     RenderUtils.drawRect(2.5F, 35.5F, width + 11.5F, 37.5F, (new Color(0, 0, 0, 200)).getRGB());
/* 407 */     RenderUtils.drawRect(3.0F, 36.0F, 3.0F + easingHealth / target.getMaxHealth() * (width + 8.0F), 37.0F, (new Color(((Number)this.redValue.get()).intValue(), ((Number)this.greenValue.get()).intValue(), ((Number)this.blueValue.get()).intValue())).getRGB());
/* 408 */     RenderUtils.drawRect(2.5F, 39.5F, width + 11.5F, 41.5F, (new Color(0, 0, 0, 200)).getRGB());
/* 409 */     RenderUtils.drawRect(
/* 410 */         3.0F, 
/* 411 */         40.0F, 
/* 412 */         3.0F + target.getTotalArmorValue() / 20.0F * (width + 8.0F), 
/* 413 */         41.0F, (
/* 414 */         new Color(77, 128, 255)).getRGB());
/*     */   }
/*     */ 
/*     */   
/*     */   private final void drawnovoline3(IEntityLivingBase target, float easingHealth) {
/* 419 */     Color mainColor = new Color(((Number)this.redValue.get()).intValue(), ((Number)this.greenValue.get()).intValue(), ((Number)this.blueValue.get()).intValue());
/* 420 */     int percent = (int)target.getHealth();
/* 421 */     if (target.getName() == null) Intrinsics.throwNpe();  float nameLength = RangesKt.coerceAtLeast(Fonts.font40.getStringWidth(target.getName()), 
/* 422 */         Fonts.font40.getStringWidth(
/*     */           
/* 424 */           String.valueOf(this.decimalFormat.format(Integer.valueOf(percent))))) + 
/*     */ 
/*     */       
/* 427 */       20.0F;
/* 428 */     float barWidth = RangesKt.coerceIn(target.getHealth() / target.getMaxHealth(), 0.0F, target.getMaxHealth()) * (nameLength - 2.0F);
/* 429 */     RenderUtils.drawRect(-2.0F, -2.0F, 3.0F + nameLength + 36.0F, 38.0F, (new Color(50, 50, 50, 150)).getRGB());
/* 430 */     RenderUtils.drawRect(-1.0F, -1.0F, 2.0F + nameLength + 36.0F, 37.0F, (new Color(0, 0, 0, 100)).getRGB());
/* 431 */     if (MinecraftInstance.mc.getNetHandler().getPlayerInfo(target.getUniqueID()) == null) Intrinsics.throwNpe();  RenderUtils.drawHead(MinecraftInstance.mc.getNetHandler().getPlayerInfo(target.getUniqueID()).getLocationSkin(), 0, 0, 36, 36);
/* 432 */     if (target.getName() == null) Intrinsics.throwNpe();  Fonts.minecraftFont.drawStringWithShadow(target.getName(), 38, 2, -1);
/* 433 */     RenderUtils.drawRect(37.0F, 14.0F, 37.0F + nameLength, 24.0F, (new Color(0, 0, 0, 200)).getRGB());
/*     */     
/* 435 */     float animateThingy = 
/* 436 */       RangesKt.coerceIn(easingHealth, target.getHealth(), target.getMaxHealth()) / target.getMaxHealth() * (nameLength - 2.0F);
/* 437 */     if (easingHealth > target.getHealth()) {
/* 438 */       Intrinsics.checkExpressionValueIsNotNull(mainColor.darker(), "mainColor.darker()"); RenderUtils.drawRect(38.0F, 15.0F, 38.0F + animateThingy, 23.0F, mainColor.darker().getRGB());
/* 439 */     }  RenderUtils.drawRect(38.0F, 15.0F, 38.0F + barWidth, 23.0F, mainColor.getRGB());
/* 440 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.minecraftFont.drawStringWithShadow(String.valueOf(this.decimalFormat.format(Integer.valueOf(percent))), 38, 26, Color.WHITE.getRGB());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final void drawnewnovo(IEntityLivingBase target, float easingHealth) {
/* 449 */     if (target.getName() == null) Intrinsics.throwNpe();  float width = 
/* 450 */       RangesKt.coerceAtLeast(38 + Fonts.minecraftFont.getStringWidth(target.getName()), 118);
/*     */     
/* 452 */     this.counter1[0] = this.counter1[0] + 1;
/* 453 */     this.counter2[0] = this.counter2[0] + 1;
/* 454 */     this.counter1[0] = RangesKt.coerceIn(this.counter1[0], 0, 50);
/* 455 */     this.counter2[0] = RangesKt.coerceIn(this.counter2[0], 0, 80);
/* 456 */     RenderUtils.drawRect(0.0F, 0.0F, width, 34.5F, new Color(0, 0, 0, ((Number)this.backgroundalpha.get()).intValue()));
/*     */ 
/*     */     
/* 459 */     Color customColor = new Color(((Number)this.redValue.get()).intValue(), ((Number)this.greenValue.get()).intValue(), ((Number)this.blueValue.get()).intValue(), 255);
/* 460 */     Color customColor1 = new Color(((Number)this.gredValue.get()).intValue(), ((Number)this.ggreenValue.get()).intValue(), ((Number)this.gblueValue.get()).intValue(), 255);
/* 461 */     RenderUtils.drawGradientSideways(
/* 462 */         34.0D, 16.0D, width - 2, 
/* 463 */         24.0D, (new Color(40, 40, 40, 220)).getRGB(), (new Color(60, 60, 60, 255)).getRGB());
/*     */ 
/*     */ 
/*     */     
/* 467 */     Intrinsics.checkExpressionValueIsNotNull(Palette.fade2(customColor, this.counter1[0], Fonts.font35.getFontHeight()), "Palette.fade2(customColo…,Fonts.font35.fontHeight)");
/* 468 */     Intrinsics.checkExpressionValueIsNotNull(Palette.fade2(customColor1, this.counter2[0], Fonts.font35.getFontHeight()), "Palette.fade2(customColo… Fonts.font35.fontHeight)"); RenderUtils.drawGradientSideways(34.0D, 16.0D, (36.0F + easingHealth / target.getMaxHealth() * (width - 36.0F)) - 2, 24.0D, Palette.fade2(customColor, this.counter1[0], Fonts.font35.getFontHeight()).getRGB(), Palette.fade2(customColor1, this.counter2[0], Fonts.font35.getFontHeight()).getRGB());
/*     */ 
/*     */     
/* 471 */     if (target.getName() == null) Intrinsics.throwNpe();  Fonts.minecraftFont.drawString(target.getName(), 34, 4, (new Color(255, 255, 255, 255)).getRGB());
/* 472 */     if (MinecraftInstance.mc.getNetHandler().getPlayerInfo(target.getUniqueID()) == null) Intrinsics.throwNpe();  RenderUtils.drawHead(MinecraftInstance.mc.getNetHandler().getPlayerInfo(target.getUniqueID()).getLocationSkin(), 2, 2, 30, 30);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 477 */     Intrinsics.checkExpressionValueIsNotNull(Color.white, "Color.white"); Fonts.minecraftFont.drawStringWithShadow((new BigDecimal((target.getHealth() / target.getMaxHealth() * 100))).setScale(1, 4).toString() + "%", (int)(width / 2 + 5), 17, Color.white.getRGB());
/*     */   }
/*     */ 
/*     */   
/*     */   private final void drawTenacity(IEntityLivingBase target, float easingHealth) {
/* 482 */     IFontRenderer font = (IFontRenderer)this.fontValue.get();
/*     */     
/* 484 */     if (target.getName() == null) Intrinsics.throwNpe();  int additionalWidth = RangesKt.coerceAtLeast(font.getStringWidth(target.getName()), 75);
/* 485 */     RenderUtils.drawRoundedCornerRect(0.0F, 0.0F, 45.0F + additionalWidth, 40.0F, 7.0F, (new Color(0, 0, 0, 110)).getRGB());
/*     */ 
/*     */     
/* 488 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 489 */     RenderUtils.drawScaledCustomSizeModalCircle(5, 5, 8.0F, 8.0F, 8, 8, 30, 30, 64.0F, 64.0F);
/* 490 */     RenderUtils.drawScaledCustomSizeModalCircle(5, 5, 40.0F, 8.0F, 8, 8, 30, 30, 64.0F, 64.0F);
/*     */ 
/*     */     
/* 493 */     if (target.getName() == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); font.drawCenteredString(target.getName(), 40 + additionalWidth / 2.0F, 5.0F, Color.WHITE.getRGB(), false);
/* 494 */     String str1 = this.decimalFormat.format(Float.valueOf(this.easingHP / target.getMaxHealth() * 100)) + '%'; boolean bool1 = false, bool2 = false; String it = str1; int $i$a$-also-TargetHud2$drawTenacity$1 = 0;
/* 495 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); font.drawString(it, RangesKt.coerceAtLeast(40.0F + this.easingHP / target.getMaxHealth() * additionalWidth - font.getStringWidth(it), 40.0F), 28.0F - font.getFontHeight(), Color.WHITE.getRGB(), false);
/*     */ 
/*     */ 
/*     */     
/* 499 */     RenderUtils.drawRoundedCornerRect(40.0F, 28.0F, 40.0F + additionalWidth, 33.0F, 2.5F, (new Color(0, 0, 0, 70)).getRGB());
/* 500 */     RenderUtils.drawRoundedCornerRect(40.0F, 28.0F, 40.0F + this.easingHP / target.getMaxHealth() * additionalWidth, 33.0F, 2.5F, ColorUtils.rainbow().getRGB());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Border getTBorder() {
/* 507 */     String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode())
/*     */     
/*     */     { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 1949242831:
/* 517 */         if (str.equals("exhibition"));
/*     */         break;
/*     */       
/*     */       case -1454523186:
/* 521 */         if (str.equals("newnovoline")); break;case 3020260: if (str.equals("best")); break;case 1322963594: if (str.equals("zamorozka")); break;case 1648341806: if (str.equals("novoline")); break;case -441011516: if (str.equals("novoline2")); break;
/* 522 */       case 3357441: if (str.equals("moon")); break;case -441011515: if (str.equals("novoline3")); break;case -1102567108: if (str.equals("liquid")) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getName() == null)
/* 523 */             Intrinsics.throwNpe();  return new Border(0.0F, 0.0F, 38 + RangesKt.coerceAtLeast(Fonts.font40.getStringWidth(MinecraftInstance.mc.getThePlayer().getName()), 118), 36.0F); }  break;case -1307030705: if (str.equals("tenacity")); break;case -703561496: if (str.equals("astolfo")); break;case 3146217: if (str.equals("flux")) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getName() == null)
/* 524 */             Intrinsics.throwNpe();  return new Border(0.0F, 0.0F, RangesKt.coerceAtLeast(38 + Fonts.font40.getStringWidth(MinecraftInstance.mc.getThePlayer().getName()), 70), 34.0F); }  break;case 3500745: if (str.equals("rise")); break; }  return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\TargetHud2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */