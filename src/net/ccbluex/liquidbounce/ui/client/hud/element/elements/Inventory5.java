/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.AColorPalette;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.HUD;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.tenacity.ColorUtil;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ElementInfo(name = "Inventory5")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000H\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\003\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\b\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\020\b\n\002\b\003\b\007\030\0002\0020\001B\031\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003¢\006\002\020\005J\b\020\037\032\0020 H\026J\006\020!\032\0020\rJ\006\020\"\032\0020\rJ(\020#\032\0020$2\006\020%\032\0020&2\006\020'\032\0020&2\006\020\002\032\0020&2\006\020\004\032\0020&H\002J\b\020(\032\0020$H\026R\021\020\006\032\0020\007¢\006\b\n\000\032\004\b\b\020\tR\021\020\n\032\0020\007¢\006\b\n\000\032\004\b\013\020\tR\026\020\f\032\n \016*\004\030\0010\r0\rX\016¢\006\002\n\000R\020\020\017\032\004\030\0010\rX\016¢\006\002\n\000R\021\020\020\032\0020\007¢\006\b\n\000\032\004\b\021\020\tR\021\020\022\032\0020\023¢\006\b\n\000\032\004\b\024\020\025R\016\020\026\032\0020\027X\004¢\006\002\n\000R\021\020\030\032\0020\007¢\006\b\n\000\032\004\b\031\020\tR\020\020\032\032\004\030\0010\rX\016¢\006\002\n\000R\024\020\033\032\0020\003XD¢\006\b\n\000\032\004\b\034\020\035R\020\020\036\032\004\030\0010\rX\016¢\006\002\n\000¨\006)"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Inventory5;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "(DD)V", "alpha2", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "getAlpha2", "()Lnet/ccbluex/liquidbounce/value/IntegerValue;", "b", "getB", "firstColor", "Ljava/awt/Color;", "kotlin.jvm.PlatformType", "fourthColor", "g", "getG", "hudMod", "Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;", "getHudMod", "()Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;", "modes", "Lnet/ccbluex/liquidbounce/value/ListValue;", "r", "getR", "secondColor", "startY", "getStartY", "()D", "thirdColor", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "getAlternateClientColor", "getClientColor", "renderInv", "", "slot", "", "endSlot", "shader", "XSJClient"})
/*     */ public final class Inventory5 extends Element {
/*     */   private final ListValue modes;
/*     */   @NotNull
/*     */   private final IntegerValue alpha2;
/*     */   @NotNull
/*     */   private final IntegerValue r;
/*     */   @NotNull
/*     */   private final IntegerValue g;
/*     */   @NotNull
/*     */   private final IntegerValue b;
/*     */   @NotNull
/*     */   private final HUD hudMod;
/*     */   private final double startY = -12.0D;
/*     */   private Color firstColor;
/*     */   private Color secondColor;
/*     */   private Color thirdColor;
/*     */   private Color fourthColor;
/*     */   
/*  33 */   public Inventory5(double x, double y) { super(x, y, 0.0F, null, 12, null);
/*  34 */     this.modes = new ListValue("Mode", new String[] { "New", "NewNovoline", "Outline" }, "New");
/*  35 */     this.alpha2 = new IntegerValue("BG-Alpha", 40, 0, 255);
/*  36 */     this.r = new IntegerValue("Red", 0, 0, 255);
/*  37 */     this.g = new IntegerValue("Green", 0, 0, 255);
/*  38 */     this.b = new IntegerValue("Blue", 0, 0, 255);
/*  39 */     if (Retreat.INSTANCE.getModuleManager().getModule(HUD.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.HUD");  this.hudMod = (HUD)Retreat.INSTANCE.getModuleManager().getModule(HUD.class);
/*     */ 
/*     */ 
/*     */     
/*  43 */     this.startY = -12.0D;
/*     */ 
/*     */ 
/*     */     
/*  47 */     this.firstColor = Color.BLACK;
/*  48 */     this.secondColor = Color.BLACK;
/*  49 */     this.thirdColor = Color.BLACK;
/*  50 */     this.fourthColor = Color.BLACK; }
/*     */   @NotNull public final IntegerValue getAlpha2() { return this.alpha2; }
/*  52 */   @NotNull public final IntegerValue getR() { return this.r; } @NotNull public final IntegerValue getG() { return this.g; } @NotNull public final Color getClientColor() { return new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue(), 255); }
/*     */   @NotNull public final IntegerValue getB() { return this.b; }
/*     */   @NotNull public final HUD getHudMod() { return this.hudMod; }
/*     */   public final double getStartY() { return this.startY; } @NotNull
/*  56 */   public final Color getAlternateClientColor() { return new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), 255); }
/*     */ 
/*     */   
/*     */   public void shader() {
/*  60 */     this.firstColor = ColorUtil.interpolateColorsBackAndForth(15, 0, getClientColor(), getAlternateClientColor(), ((Boolean)this.hudMod.getHueInterpolation().get()).booleanValue());
/*  61 */     this.secondColor = ColorUtil.interpolateColorsBackAndForth(15, 90, getClientColor(), getAlternateClientColor(), (
/*  62 */         (Boolean)this.hudMod.getHueInterpolation().get()).booleanValue());
/*  63 */     this.thirdColor = ColorUtil.interpolateColorsBackAndForth(15, 180, getClientColor(), getAlternateClientColor(), (
/*  64 */         (Boolean)this.hudMod.getHueInterpolation().get()).booleanValue());
/*  65 */     this.fourthColor = ColorUtil.interpolateColorsBackAndForth(15, 270, getClientColor(), getAlternateClientColor(), (
/*  66 */         (Boolean)this.hudMod.getHueInterpolation().get()).booleanValue());
/*  67 */     String str = (String)this.modes.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 108960:
/*  80 */         if (str.equals("new"))
/*  81 */         { RenderUtils.drawRoundedRectfix(2.0F, (float)this.startY + 14, 170.0F, 62.0F, 5.0F, (new Color(0, 0, 0)).getRGB());
/*  82 */           RenderUtils.drawRoundedRectfix(2.0F, (float)this.startY - 8, 170.0F, 16.0F, 5.0F, (new Color(0, 0, 0)).getRGB()); }  break;
/*     */       case -1106245566:
/*     */         if (str.equals("outline")) { if (((Boolean)BlurSettings.InventoryGlow.get()).booleanValue()) { RoundedUtil.drawGradientRound(3.0F, (float)this.startY + 15.2F, 169.5F, 60.3F, 5.0F, ColorUtil.applyOpacity(this.fourthColor, 1.0F), this.firstColor, this.secondColor, this.thirdColor); break; }
/*     */            RoundedUtil.drawRound(3.0F, (float)this.startY + 15.2F, 169.5F, 60.3F, 5.0F, new Color(0, 0, 0)); }
/*     */          break;
/*  87 */     }  } @NotNull public Border drawElement() { String str = (String)this.modes.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 108960:
/*  93 */         if (str.equals("new")) {
/*  94 */           RenderUtils.drawRoundedRectfix(2.0F, (float)this.startY + 14, 170.0F, 62.0F, 5.0F, (new Color(((Number)this.r.get()).intValue(), ((Number)this.g.get()).intValue(), ((Number)this.b.get()).intValue(), ((Number)this.alpha2.get()).intValue())).getRGB());
/*     */           
/*  96 */           RenderUtils.drawRoundedRectfix(2.0F, (float)this.startY - 8, 170.0F, 16.0F, 5.0F, (new Color(0, 20, 40, 225)).getRGB());
/*  97 */           UiFonts.Newuiicon919.drawString("D", 5.0F, (float)(this.startY + 8.0F) - 10.5F, (new Color(6, 180, 255)).getRGB());
/*  98 */           Fonts.Newuifont17.drawString("Inventory", 16.0F, (float)(this.startY + 8.0F) - 11, (new Color(255, 255, 255)).getRGB());
/*     */         }  break;
/*     */       case -1106245566:
/*     */         if (str.equals("outline")) { RoundedUtil.drawRound(3.0F, (float)this.startY + 15.2F, 169.5F, 60.3F, 5.0F, new Color(((Number)this.r.get()).intValue(), ((Number)this.g.get()).intValue(), ((Number)this.b.get()).intValue(), ((Number)this.alpha2.get()).intValue())); RenderUtils.drawRoundedRectfix(2.8F, (float)this.startY + 14.5F, 169.7F, 61.5F, 5.0F, (new Color(((Number)this.r.get()).intValue(), ((Number)this.g.get()).intValue(), ((Number)this.b.get()).intValue(), ((Number)this.alpha2.get()).intValue())).getRGB()); ScaleUtils.drawOutline(7.9F, (float)this.startY + 14.0F + 0.6F, 168.0F, 53.7F, 5.0F, 2.2F); }
/*     */          break;
/* 103 */     }  GlStateManager.func_179117_G();
/*     */     
/* 105 */     RenderHelper.func_74520_c();
/* 106 */     renderInv(9, 17, 6, 6);
/* 107 */     renderInv(18, 26, 6, 24);
/* 108 */     renderInv(27, 35, 6, 42);
/* 109 */     RenderHelper.func_74518_a();
/* 110 */     GlStateManager.func_179141_d();
/* 111 */     GlStateManager.func_179084_k();
/* 112 */     GlStateManager.func_179140_f();
/* 113 */     str = (String)this.modes.get(); bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case -1106245566:
/* 114 */         if (str.equals("outline")); break; }
/* 115 */      return new Border(0.0F, (float)this.startY - 4.5F, 174.0F, 71.0F); }
/*     */ 
/*     */   
/*     */   private final void renderInv(int slot, int endSlot, int x, int y) {
/* 119 */     int xOffset = x;
/* 120 */     int i = slot, j = endSlot; if (i <= j)
/* 121 */       while (true) { xOffset += 18;
/* 122 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getInventoryContainer().getSlot(i).getStack() != null) { IItemStack stack = MinecraftInstance.mc.getThePlayer().getInventoryContainer().getSlot(i).getStack();
/*     */           
/* 124 */           MinecraftInstance.mc.getRenderItem().renderItemAndEffectIntoGUI(stack, xOffset - 18, y);
/* 125 */           Intrinsics.checkExpressionValueIsNotNull(Fonts.posterama30, "Fonts.posterama30"); MinecraftInstance.mc.getRenderItem().renderItemOverlays(Fonts.posterama30, stack, xOffset - 18, y); }
/*     */         else
/*     */         { MinecraftInstance.mc.getThePlayer().getInventoryContainer().getSlot(i).getStack(); }
/*     */         
/*     */         if (i != j) {
/*     */           i++;
/*     */           continue;
/*     */         } 
/*     */         break; }
/*     */        
/*     */   }
/*     */   
/*     */   public Inventory5() {
/*     */     this(0.0D, 0.0D, 3, null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\Inventory5.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */