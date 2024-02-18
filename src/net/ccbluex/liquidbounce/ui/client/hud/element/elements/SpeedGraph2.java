/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.ranges.RangesKt;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.AColorPalette;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.HUD;
/*     */ import net.ccbluex.liquidbounce.ui.font.FontLoaders;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.RoundedUtil;
/*     */ import net.ccbluex.liquidbounce.utils.render.tenacity.ColorUtil;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ElementInfo(name = "SpeedGraph2")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\\\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\007\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\004\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\005\n\002\020\002\n\000\b\007\030\0002\0020\001B#\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006¢\006\002\020\007J\b\020$\032\0020%H\026J\006\020&\032\0020\fJ\006\020'\032\0020\fJ\006\020(\032\0020\fJ\006\020)\032\0020\fJ\b\020*\032\0020+H\026R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\n\032\0020\tX\004¢\006\002\n\000R\026\020\013\032\n \r*\004\030\0010\f0\fX\016¢\006\002\n\000R\026\020\016\032\n \r*\004\030\0010\f0\fX\016¢\006\002\n\000R\020\020\017\032\004\030\0010\fX\016¢\006\002\n\000R\020\020\020\032\004\030\0010\fX\016¢\006\002\n\000R\016\020\021\032\0020\tX\004¢\006\002\n\000R\021\020\022\032\0020\023¢\006\b\n\000\032\004\b\024\020\025R\016\020\026\032\0020\027X\016¢\006\002\n\000R\016\020\030\032\0020\tX\004¢\006\002\n\000R\020\020\031\032\004\030\0010\fX\016¢\006\002\n\000R\020\020\032\032\004\030\0010\fX\016¢\006\002\n\000R\024\020\033\032\b\022\004\022\0020\0030\034X\004¢\006\002\n\000R\016\020\035\032\0020\036X\016¢\006\002\n\000R\016\020\037\032\0020 X\004¢\006\002\n\000R\020\020!\032\004\030\0010\fX\016¢\006\002\n\000R\020\020\"\032\004\030\0010\fX\016¢\006\002\n\000R\016\020#\032\0020 X\004¢\006\002\n\000¨\006,"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/SpeedGraph2;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "scale", "", "(DDF)V", "alpha", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "alpha2", "firstColor", "Ljava/awt/Color;", "kotlin.jvm.PlatformType", "firstColor2", "fourthColor", "fourthColor2", "height", "hudMod", "Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;", "getHudMod", "()Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;", "lastTick", "", "radius", "secondColor", "secondColor2", "speedList", "Ljava/util/ArrayList;", "speedStr", "", "thickness", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "thirdColor", "thirdColor2", "yMultiplier", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "getAlternateClientColor", "getAlternateClientColor2", "getClientColor", "getClientColor2", "shader", "", "XSJClient"})
/*     */ public final class SpeedGraph2 extends Element {
/*     */   private final IntegerValue alpha2;
/*     */   private final IntegerValue alpha;
/*     */   private final IntegerValue radius;
/*     */   private final FloatValue yMultiplier;
/*     */   private final IntegerValue height;
/*     */   private final FloatValue thickness;
/*     */   private final ArrayList<Double> speedList;
/*     */   private int lastTick;
/*     */   private String speedStr;
/*     */   
/*  32 */   public SpeedGraph2(double x, double y, float scale) { super(x, y, scale, null, 8, null);
/*  33 */     this.alpha2 = new IntegerValue("BG Alpha", 40, 0, 255);
/*  34 */     this.alpha = new IntegerValue("Color Alpha", 40, 0, 255);
/*  35 */     this.radius = new IntegerValue("radius", 5, 0, 10);
/*  36 */     this.yMultiplier = new FloatValue("yMultiplier", 7.0F, 1.0F, 20.0F);
/*  37 */     this.height = new IntegerValue("Height", 50, 20, 63);
/*  38 */     this.thickness = new FloatValue("Thickness", 2.0F, 1.0F, 3.0F);
/*  39 */     this.speedList = new ArrayList<>();
/*  40 */     this.lastTick = -1;
/*  41 */     this.speedStr = "";
/*  42 */     if (Retreat.INSTANCE.getModuleManager().getModule(HUD.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.HUD");  this.hudMod = (HUD)Retreat.INSTANCE.getModuleManager().getModule(HUD.class);
/*  43 */     this.firstColor = Color.BLACK;
/*  44 */     this.secondColor = Color.BLACK;
/*  45 */     this.thirdColor = Color.BLACK;
/*  46 */     this.fourthColor = Color.BLACK;
/*     */     
/*  48 */     this.firstColor2 = Color.BLACK;
/*  49 */     this.secondColor2 = Color.BLACK;
/*  50 */     this.thirdColor2 = Color.BLACK;
/*  51 */     this.fourthColor2 = Color.BLACK; }
/*     */   @NotNull private final HUD hudMod; private Color firstColor; private Color secondColor; private Color thirdColor; private Color fourthColor; private Color firstColor2; private Color secondColor2; private Color thirdColor2; private Color fourthColor2; @NotNull public final HUD getHudMod() { return this.hudMod; } @NotNull
/*  53 */   public final Color getClientColor() { return new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue(), 255); }
/*     */   
/*     */   @NotNull
/*     */   public final Color getAlternateClientColor() {
/*  57 */     return new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), 255);
/*     */   } @NotNull
/*     */   public final Color getClientColor2() {
/*  60 */     return new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue(), ((Number)this.alpha.get()).intValue());
/*     */   }
/*     */   @NotNull
/*     */   public final Color getAlternateClientColor2() {
/*  64 */     return new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), ((Number)this.alpha.get()).intValue());
/*     */   }
/*     */   public void shader() {
/*  67 */     this.firstColor = ColorUtil.interpolateColorsBackAndForth(15, 0, getClientColor(), getAlternateClientColor(), ((Boolean)this.hudMod.getHueInterpolation().get()).booleanValue());
/*  68 */     this.secondColor = ColorUtil.interpolateColorsBackAndForth(15, 90, getClientColor(), getAlternateClientColor(), (
/*  69 */         (Boolean)this.hudMod.getHueInterpolation().get()).booleanValue());
/*  70 */     this.thirdColor = ColorUtil.interpolateColorsBackAndForth(15, 180, getClientColor(), getAlternateClientColor(), (
/*  71 */         (Boolean)this.hudMod.getHueInterpolation().get()).booleanValue());
/*  72 */     this.fourthColor = ColorUtil.interpolateColorsBackAndForth(15, 270, getClientColor(), getAlternateClientColor(), (
/*  73 */         (Boolean)this.hudMod.getHueInterpolation().get()).booleanValue());
/*     */     
/*  75 */     this.firstColor2 = ColorUtil.interpolateColorsBackAndForth(15, 0, getClientColor2(), getAlternateClientColor2(), (
/*  76 */         (Boolean)this.hudMod.getHueInterpolation().get()).booleanValue());
/*  77 */     this.secondColor2 = ColorUtil.interpolateColorsBackAndForth(15, 90, getClientColor2(), getAlternateClientColor2(), (
/*  78 */         (Boolean)this.hudMod.getHueInterpolation().get()).booleanValue());
/*  79 */     this.thirdColor2 = ColorUtil.interpolateColorsBackAndForth(15, 180, getClientColor2(), getAlternateClientColor2(), (
/*  80 */         (Boolean)this.hudMod.getHueInterpolation().get()).booleanValue());
/*  81 */     this.fourthColor2 = ColorUtil.interpolateColorsBackAndForth(15, 270, getClientColor2(), getAlternateClientColor2(), (
/*  82 */         (Boolean)this.hudMod.getHueInterpolation().get()).booleanValue());
/*  83 */     double x2 = 145.0D;
/*  84 */     if (((Boolean)BlurSettings.SpeedGraphGlow.get()).booleanValue()) {
/*  85 */       RoundedUtil.drawGradientRound(
/*  86 */           -3.0F, -15.0F, (float)x2 + 7, 85.0F, ((Number)this.radius.get()).intValue(), 
/*  87 */           ColorUtil.applyOpacity(this.fourthColor, 1.0F), this.firstColor, this.secondColor, this.thirdColor);
/*     */     } else {
/*  89 */       RoundedUtil.drawRound(-3.0F, -15.0F, (float)x2 + 7, 85.0F, ((Number)this.radius.get()).intValue(), 
/*  90 */           new Color(0, 0, 0));
/*     */     } 
/*     */   } @NotNull
/*     */   public Border drawElement() {
/*  94 */     this.firstColor = ColorUtil.interpolateColorsBackAndForth(15, 0, getClientColor(), getAlternateClientColor(), ((Boolean)this.hudMod.getHueInterpolation().get()).booleanValue());
/*  95 */     this.secondColor = ColorUtil.interpolateColorsBackAndForth(15, 90, getClientColor(), getAlternateClientColor(), (
/*  96 */         (Boolean)this.hudMod.getHueInterpolation().get()).booleanValue());
/*  97 */     this.thirdColor = ColorUtil.interpolateColorsBackAndForth(15, 180, getClientColor(), getAlternateClientColor(), (
/*  98 */         (Boolean)this.hudMod.getHueInterpolation().get()).booleanValue());
/*  99 */     this.fourthColor = ColorUtil.interpolateColorsBackAndForth(15, 270, getClientColor(), getAlternateClientColor(), (
/* 100 */         (Boolean)this.hudMod.getHueInterpolation().get()).booleanValue());
/*     */     
/* 102 */     this.firstColor2 = ColorUtil.interpolateColorsBackAndForth(15, 0, getClientColor2(), getAlternateClientColor2(), (
/* 103 */         (Boolean)this.hudMod.getHueInterpolation().get()).booleanValue());
/* 104 */     this.secondColor2 = ColorUtil.interpolateColorsBackAndForth(15, 90, getClientColor2(), getAlternateClientColor2(), (
/* 105 */         (Boolean)this.hudMod.getHueInterpolation().get()).booleanValue());
/* 106 */     this.thirdColor2 = ColorUtil.interpolateColorsBackAndForth(15, 180, getClientColor2(), getAlternateClientColor2(), (
/* 107 */         (Boolean)this.hudMod.getHueInterpolation().get()).booleanValue());
/* 108 */     this.fourthColor2 = ColorUtil.interpolateColorsBackAndForth(15, 270, getClientColor2(), getAlternateClientColor2(), (
/* 109 */         (Boolean)this.hudMod.getHueInterpolation().get()).booleanValue());
/* 110 */     double x2 = 145.0D;
/*     */     
/* 112 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe(); 
/* 113 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double bps = Math.hypot(MinecraftInstance.mc.getThePlayer().getPosX() - MinecraftInstance.mc.getThePlayer().getPrevPosX(), MinecraftInstance.mc.getThePlayer().getPosZ() - MinecraftInstance.mc.getThePlayer().getPrevPosZ()) * MinecraftInstance.mc.getTimer().getTimerSpeed() * 20;
/*     */     
/* 115 */     RoundedUtil.drawGradientRound(
/* 116 */         -3.0F, -15.0F, (float)x2 + 7, 85.0F, ((Number)this.radius.get()).intValue(), 
/* 117 */         ColorUtil.applyOpacity(this.fourthColor2, 1.0F), this.firstColor2, this.secondColor2, this.thirdColor2);
/*     */     
/* 119 */     RoundedUtil.drawRound(0.0F, 2.0F, (float)x2 + true, 65.0F, ((Number)this.radius.get()).intValue(), 
/* 120 */         new Color(0, 0, 0, ((Number)this.alpha2.get()).intValue()));
/* 121 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); FontLoaders.tenacitybold20.drawString("Speed", 3.0F, -11.0F, Color.WHITE.getRGB());
/* 122 */     FontLoaders.F18.drawString("Average: " + (Math.round(bps * 100.0D) / 100.0D) + " BPS", 61.5F, -11.0F, (new Color(255, 255, 255)).getRGB());
/* 123 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (this.lastTick != MinecraftInstance.mc.getThePlayer().getTicksExisted()) {
/* 124 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.lastTick = MinecraftInstance.mc.getThePlayer().getTicksExisted();
/* 125 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double z2 = MinecraftInstance.mc.getThePlayer().getPosZ();
/* 126 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double z1 = MinecraftInstance.mc.getThePlayer().getPrevPosZ();
/* 127 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double d1 = MinecraftInstance.mc.getThePlayer().getPosX();
/* 128 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double x1 = MinecraftInstance.mc.getThePlayer().getPrevPosX();
/* 129 */       double d2 = (z2 - z1) * (z2 - z1) + (d1 - x1) * (d1 - x1); boolean bool = false; double speed = Math.sqrt(d2);
/* 130 */       if (speed < false) {
/* 131 */         speed = -speed;
/*     */       }
/* 133 */       this.speedList.add(Double.valueOf(speed));
/* 134 */       while (this.speedList.size() > 146) {
/* 135 */         this.speedList.remove(0);
/*     */       }
/*     */     } 
/* 138 */     GL11.glBlendFunc(770, 771);
/* 139 */     GL11.glEnable(3042);
/* 140 */     GL11.glEnable(2848);
/* 141 */     GL11.glLineWidth(((Number)this.thickness.get()).floatValue());
/* 142 */     GL11.glDisable(3553);
/* 143 */     GL11.glDisable(2929);
/* 144 */     GL11.glDepthMask(false);
/*     */     
/* 146 */     GL11.glBegin(1);
/*     */     
/* 148 */     int size = this.speedList.size();
/*     */     
/* 150 */     int start = (size > 146) ? (size - 146) : 0;
/* 151 */     for (int i = start, j = size - 1; i < j; i++) {
/* 152 */       double y = ((Number)this.speedList.get(i)).doubleValue() * 10 * ((Number)this.yMultiplier.get()).doubleValue();
/* 153 */       double y1 = ((Number)this.speedList.get(i + 1)).doubleValue() * 10 * ((Number)this.yMultiplier.get()).doubleValue();
/*     */       
/* 155 */       RenderUtils.glColor(new Color(255, 255, 255, 255));
/* 156 */       GL11.glVertex2d(i - start, (((Number)this.height.get()).intValue() + 1) - RangesKt.coerceAtMost(y, ((Number)this.height.get()).intValue()));
/* 157 */       GL11.glVertex2d(i + 1.0D - start, (((Number)this.height.get()).intValue() + 1) - RangesKt.coerceAtMost(y1, ((Number)this.height.get()).intValue()));
/*     */     } 
/*     */     
/* 160 */     GL11.glEnd();
/*     */     
/* 162 */     GL11.glEnable(3553);
/* 163 */     GL11.glDisable(2848);
/* 164 */     GL11.glEnable(2929);
/* 165 */     GL11.glDepthMask(true);
/* 166 */     GL11.glDisable(3042);
/* 167 */     GlStateManager.func_179117_G();
/*     */     
/* 169 */     return new Border(-5.0F, -15.0F, 155.0F, 70.0F);
/*     */   }
/*     */   
/*     */   public SpeedGraph2() {
/*     */     this(0.0D, 0.0D, 0.0F, 7, null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\SpeedGraph2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */