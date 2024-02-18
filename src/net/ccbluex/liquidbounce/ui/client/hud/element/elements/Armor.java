/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ import java.awt.Color;
/*     */ import kotlin.Unit;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.ui.client.hud.element.Side;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ElementInfo(name = "Armor")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000H\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\007\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\007\n\002\030\002\n\000\n\002\020\002\n\000\b\007\030\0002\0020\001B-\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006\022\b\b\002\020\007\032\0020\b¢\006\002\020\tJ\b\020\031\032\0020\032H\026J\b\020\033\032\0020\034H\026R\016\020\n\032\0020\013X\004¢\006\002\n\000R\016\020\f\032\0020\rX\004¢\006\002\n\000R\016\020\016\032\0020\017X\004¢\006\002\n\000R\016\020\020\032\0020\rX\004¢\006\002\n\000R\016\020\021\032\0020\022X\004¢\006\002\n\000R\016\020\023\032\0020\013X\004¢\006\002\n\000R\016\020\024\032\0020\022X\004¢\006\002\n\000R\016\020\025\032\0020\013X\004¢\006\002\n\000R\021\020\026\032\0020\r¢\006\b\n\000\032\004\b\027\020\030¨\006\035"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Armor;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "scale", "", "side", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;", "(DDFLnet/ccbluex/liquidbounce/ui/client/hud/element/Side;)V", "BlurStrength", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "FShadow", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "alphaValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "bV", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "radiusValue", "shadowColorMode", "shadowValue", "shadowValueopen", "getShadowValueopen", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "shader", "", "XSJClient"})
/*     */ public final class Armor extends Element {
/*     */   private final BoolValue bV;
/*     */   private final FloatValue BlurStrength;
/*     */   @NotNull
/*     */   private final BoolValue shadowValueopen;
/*     */   private final FloatValue shadowValue;
/*     */   
/*     */   public Armor(double x, double y, float scale, @NotNull Side side) {
/*  25 */     super(x, y, scale, side);
/*     */     
/*  27 */     this.bV = new BoolValue("Blur", true);
/*  28 */     this.BlurStrength = new FloatValue("BlurStrength", 5.0F, 0.0F, 20.0F);
/*  29 */     this.shadowValueopen = new BoolValue("shadow", true);
/*  30 */     this.shadowValue = new FloatValue("shadow-Value", 10.0F, 0.0F, 20.0F);
/*  31 */     this.shadowColorMode = new ListValue("Shadow-Color", new String[] { "Background", "Custom" }, "Background");
/*  32 */     this.radiusValue = new FloatValue("Radius", 4.25F, 0.0F, 10.0F);
/*  33 */     this.FShadow = new BoolValue("Font-Shadow", true);
/*  34 */     this.alphaValue = new IntegerValue("Alpha", 120, 0, 255);
/*  35 */     this.modeValue = new ListValue("Ar-Mode", new String[] { "Mk" }, "Mk");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ListValue shadowColorMode;
/*     */ 
/*     */ 
/*     */   
/*     */   private final FloatValue radiusValue;
/*     */ 
/*     */ 
/*     */   
/*     */   private final BoolValue FShadow;
/*     */ 
/*     */ 
/*     */   
/*     */   private final IntegerValue alphaValue;
/*     */ 
/*     */ 
/*     */   
/*     */   private final ListValue modeValue;
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class Armor$drawElement$1
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/*  67 */       GL11.glPushMatrix();
/*  68 */       GL11.glTranslated(Armor.this.getRenderX(), Armor.this.getRenderY(), 0.0D);
/*  69 */       GL11.glScalef(Armor.this.getScale(), Armor.this.getScale(), Armor.this.getScale());
/*     */       
/*  71 */       RenderUtils.originalRoundedRect(
/*  72 */           0.0F, 0.0F, 50.0F, 76.0F, ((Number)Armor.this.radiusValue.get()).floatValue(), 
/*  73 */           StringsKt.equals((String)Armor.this.shadowColorMode.get(), "background", true) ? (
/*  74 */           new Color(32, 30, 30)).getRGB() : (
/*     */           
/*  76 */           new Color(0, 0, 0)).getRGB());
/*     */       
/*  78 */       GL11.glPopMatrix();
/*     */     } Armor$drawElement$1() { super(0); }
/*  80 */   } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class Armor$drawElement$2 extends Lambda implements Function0<Unit> { Armor$drawElement$2() { super(0); } public final void invoke() { GL11.glPushMatrix();
/*  81 */       GL11.glTranslated(Armor.this.getRenderX(), Armor.this.getRenderY(), 0.0D);
/*  82 */       GL11.glScalef(Armor.this.getScale(), Armor.this.getScale(), Armor.this.getScale());
/*  83 */       GlStateManager.func_179147_l();
/*  84 */       GlStateManager.func_179090_x();
/*  85 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/*  86 */       RenderUtils.fastRoundedRect(0.0F, 0.0F, 50.0F, 76.0F, ((Number)Armor.this.radiusValue.get()).floatValue());
/*  87 */       GlStateManager.func_179098_w();
/*  88 */       GlStateManager.func_179084_k();
/*  89 */       GL11.glPopMatrix(); } } @NotNull public Border drawElement() { GL11.glPushMatrix(); IRenderItem renderItem = MinecraftInstance.mc.getRenderItem(); if (MinecraftInstance.mc.getThePlayer() == null)
/*     */       Intrinsics.throwNpe();  boolean isInsideWater = MinecraftInstance.mc.getThePlayer().isInsideOfMaterial(MinecraftInstance.classProvider.getMaterialEnum(MaterialType.WATER)); int x = 1; int y = isInsideWater ? -10 : 0; String mode = (String)this.modeValue.get(); RenderUtils.drawRoundedRect(0.0F, 0.0F, 50.0F, 76.0F, ((Number)this.radiusValue.get()).floatValue(), (new Color(11, 11, 12, ((Number)this.alphaValue.get()).intValue())).getRGB()); RenderUtils.drawRoundedRect(x + 22.0F, y + 4.0F, x + 21.0F, y + 16.5F, 0.0F, (new Color(100, 100, 101, ((Number)this.alphaValue.get()).intValue() + 20)).getRGB()); RenderUtils.drawRoundedRect(x + 22.0F, y + 23.5F, x + 21.0F, y + 35.5F, 0.0F, (new Color(100, 100, 101, ((Number)this.alphaValue.get()).intValue() + 20)).getRGB()); RenderUtils.drawRoundedRect(x + 22.0F, y + 41.5F, x + 21.0F, y + 53.5F, 0.0F, (new Color(100, 100, 101, ((Number)this.alphaValue.get()).intValue() + 20)).getRGB()); RenderUtils.drawRoundedRect(x + 22.0F, y + 60.5F, x + 21.0F, y + 72.5F, 0.0F, (new Color(100, 100, 101, ((Number)this.alphaValue.get()).intValue() + 20)).getRGB()); GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F);
/*     */     GL11.glPushMatrix();
/*     */     if (((Boolean)this.shadowValueopen.get()).booleanValue())
/*     */       ShadowUtils.shadow(((Number)this.shadowValue.get()).floatValue(), new Armor$drawElement$1(), new Armor$drawElement$2()); 
/*  94 */     GL11.glPopMatrix();
/*  95 */     GL11.glScalef(getScale(), getScale(), getScale());
/*  96 */     GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*  97 */     if (((Boolean)this.bV.get()).booleanValue()) {
/*  98 */       GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D);
/*  99 */       GL11.glPushMatrix();
/* 100 */       BlurBuffer.CustomBlurRoundArea((float)getRenderX(), (float)getRenderY(), 50.0F, 76.0F, ((Number)this.radiusValue.get()).floatValue(), ((Number)this.BlurStrength.get()).floatValue());
/* 101 */       GL11.glPopMatrix();
/* 102 */       GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */     } 
/* 104 */     Gui.func_73734_a(0, 0, 0, 0, -1); byte b; boolean bool;
/* 105 */     for (b = 3, bool = false; b >= 0; b--) {
/* 106 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if ((IItemStack)MinecraftInstance.mc.getThePlayer().getInventory().getArmorInventory().get(b) != null) { IItemStack stack = (IItemStack)MinecraftInstance.mc.getThePlayer().getInventory().getArmorInventory().get(b);
/*     */         
/* 108 */         renderItem.renderItemAndEffectIntoGUI(stack, x + 3, y + 3);
/* 109 */         int itemDamage = stack.getMaxDamage() - stack.getItemDamage();
/* 110 */         GlStateManager.func_179094_E();
/* 111 */         GlStateManager.func_179152_a(0.5F, 0.5F, 0.5F);
/* 112 */         Gui.func_73734_a(0, 0, 0, 0, -1);
/* 113 */         GlStateManager.func_179121_F();
/* 114 */         float ms = Math.round(itemDamage * 1.0F / stack.getMaxDamage() * 100.0F);
/*     */         
/* 116 */         Intrinsics.checkExpressionValueIsNotNull((new DecimalFormat()).format(Float.valueOf(ms)) + "%", "StringBuilder().append(D…              .toString()"); String s = (new DecimalFormat()).format(Float.valueOf(ms)) + "%";
/* 117 */         Fonts.tenacitybold25.drawString(s, (x + 26), (float)(y + 6.7D), -1, ((Boolean)this.FShadow.get()).booleanValue());
/*     */         
/* 119 */         RoundedUtil.drawRound(x + 25.0F, y + 13.5F, itemDamage * 1.0F / stack.getMaxDamage() * 20.0F, 1.0F, 2.5F, new Color(255, 255, 255));
/* 120 */         RoundedUtil.drawRound(x + 25.0F, y + 13.8F, itemDamage * 1.0F / stack.getMaxDamage() * 20.0F, 1.1F, 2.5F, new Color(255, 255, 255, 210));
/* 121 */         RoundedUtil.drawRound(x + 25.3F, y + 13.5F, itemDamage * 1.0F / stack.getMaxDamage() * 20.0F, 1.1F, 2.5F, new Color(255, 255, 255, 210));
/* 122 */         if (StringsKt.equals(mode, "Mk", true))
/* 123 */           y += 18;  }
/*     */       else { (IItemStack)MinecraftInstance.mc.getThePlayer().getInventory().getArmorInventory().get(b); }
/*     */     
/* 126 */     }  MinecraftInstance.classProvider.getGlStateManager().enableAlpha();
/* 127 */     MinecraftInstance.classProvider.getGlStateManager().disableBlend();
/* 128 */     MinecraftInstance.classProvider.getGlStateManager().disableLighting();
/* 129 */     MinecraftInstance.classProvider.getGlStateManager().disableCull();
/* 130 */     GL11.glPopMatrix();
/*     */ 
/*     */     
/* 133 */     return StringsKt.equals((String)this.modeValue.get(), "Mk", true) ? 
/* 134 */       new Border(0.0F, 0.0F, 50.0F, 76.0F) : 
/*     */       
/* 136 */       new Border(0.0F, 0.0F, 50.0F, 76.0F); }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public final BoolValue getShadowValueopen() {
/*     */     return this.shadowValueopen;
/*     */   }
/*     */   
/*     */   public void shader() {
/*     */     if (StringsKt.equals((String)this.modeValue.get(), "mk", true))
/*     */       RenderUtils.drawRoundedRect(0.0F, 0.0F, 50.0F, 76.0F, 5.0F, -1); 
/*     */   }
/*     */   
/*     */   public Armor() {
/*     */     this(0.0D, 0.0D, 0.0F, (Side)null, 15, (DefaultConstructorMarker)null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\Armor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */