/*    */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*    */ import java.awt.Color;
/*    */ import kotlin.jvm.internal.DefaultConstructorMarker;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.text.StringsKt;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.enums.MaterialType;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.render.entity.IRenderItem;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.AColorPalette;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.HUD;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.Border;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.Element;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.ElementInfo;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.Side;
/*    */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.VisualUtils;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @ElementInfo(name = "NovoArmor")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000B\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\007\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\000\n\002\020\002\n\000\b\007\030\0002\0020\001B-\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006\022\b\b\002\020\007\032\0020\b¢\006\002\020\tJ\b\020\025\032\0020\026H\026J\b\020\027\032\0020\030H\026R\016\020\n\032\0020\013X\004¢\006\002\n\000R\016\020\f\032\0020\013X\004¢\006\002\n\000R\016\020\r\032\0020\016X\004¢\006\002\n\000R\016\020\017\032\0020\020X\004¢\006\002\n\000R\016\020\021\032\0020\013X\004¢\006\002\n\000R\016\020\022\032\0020\013X\004¢\006\002\n\000R\016\020\023\032\0020\016X\004¢\006\002\n\000R\016\020\024\032\0020\013X\004¢\006\002\n\000¨\006\031"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/NovoArmor;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "scale", "", "side", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;", "(DDFLnet/ccbluex/liquidbounce/ui/client/hud/element/Side;)V", "alpha2", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "blueValue", "brightnessValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "colorModeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "greenValue", "redValue", "saturationValue", "speed", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "shader", "", "XSJClient"})
/*    */ public final class NovoArmor extends Element {
/*    */   private final ListValue colorModeValue;
/*    */   private final IntegerValue alpha2;
/*    */   
/*    */   public NovoArmor(double x, double y, float scale, @NotNull Side side) {
/* 34 */     super(x, y, scale, side);
/* 35 */     this.colorModeValue = new ListValue("Text-Color", new String[] { "Custom", "Astolfo", "gradient" }, "Custom");
/* 36 */     this.alpha2 = new IntegerValue("New-BG-Alpha", 40, 0, 255);
/* 37 */     this.brightnessValue = new FloatValue("Brightness", 1.0F, 0.0F, 1.0F);
/* 38 */     this.redValue = new IntegerValue("Text-R", 255, 0, 255);
/* 39 */     this.greenValue = new IntegerValue("Text-G", 255, 0, 255);
/* 40 */     this.blueValue = new IntegerValue("Text-B", 255, 0, 255);
/* 41 */     this.saturationValue = new FloatValue("Saturation", 0.9F, 0.0F, 1.0F);
/* 42 */     this.speed = new IntegerValue("AllSpeed", 0, 0, 400);
/*    */   }
/*    */   private final FloatValue brightnessValue; private final IntegerValue redValue; private final IntegerValue greenValue; private final IntegerValue blueValue; private final FloatValue saturationValue;
/*    */   private final IntegerValue speed;
/*    */   
/*    */   public void shader() {
/* 48 */     int x2 = 0;
/* 49 */     for (byte b1 = 0, b2 = 3; b1 <= b2; b1++) {
/* 50 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getInventory().getArmorInventory().get(b1) != null)
/* 51 */         x2 += 20; 
/*    */     } 
/* 53 */     RenderUtils.drawRoundedRect2(-2.0F, -4.0F, 4.0F + x2, 32.0F, 0.0F, -1);
/*    */   } @NotNull
/*    */   public Border drawElement() {
/* 56 */     int x2 = 0;
/* 57 */     GL11.glPushMatrix();
/*    */     
/* 59 */     IRenderItem renderItem = MinecraftInstance.mc.getRenderItem();
/* 60 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  boolean isInsideWater = MinecraftInstance.mc.getThePlayer().isInsideOfMaterial(MinecraftInstance.classProvider.getMaterialEnum(MaterialType.WATER));
/*    */     
/* 62 */     int x = 1;
/* 63 */     int i = 0;
/* 64 */     int y = 0;
/* 65 */     String colorMode = (String)this.colorModeValue.get();
/* 66 */     int color = (new Color(((Number)this.redValue.get()).intValue(), ((Number)this.greenValue.get()).intValue(), ((Number)this.blueValue.get()).intValue())).getRGB();
/* 67 */     boolean rainbow = StringsKt.equals(colorMode, "Rainbow", true); byte b2;
/* 68 */     for (byte b1 = 0; b1 <= b2; b1++) {
/* 69 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getInventory().getArmorInventory().get(b1) != null)
/* 70 */         x2 += 20; 
/*    */     } 
/* 72 */     RenderUtils.drawRoundedRect2(-2.0F, -4.0F, 4.0F + x2, 32.0F, 0.0F, (new Color(0, 0, 0, ((Number)this.alpha2.get()).intValue())).getRGB());
/*    */     
/* 74 */     if (Retreat.INSTANCE.getModuleManager().getModule(HUD.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.HUD");  HUD hud = (HUD)Retreat.INSTANCE.getModuleManager().getModule(HUD.class); boolean bool;
/* 75 */     for (b2 = 3, bool = false; b2 >= 0; b2--) {
/*    */ 
/*    */ 
/*    */       
/* 79 */       Intrinsics.checkExpressionValueIsNotNull(RenderUtils.getGradientOffset(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue()), 40000.0D), "RenderUtils.getGradientO…lette.b2.get())),40000.0)"); int colorall = rainbow ? 0 : (StringsKt.equals(colorMode, "Astolfo", true) ? RenderUtils.Astolfo(b2 * ((Number)this.speed.get()).intValue(), ((Number)this.saturationValue.get()).floatValue(), ((Number)this.brightnessValue.get()).floatValue()) : (StringsKt.equals(colorMode, "gradient", true) ? RenderUtils.getGradientOffset(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue()), 40000.0D).getRGB() : 
/* 80 */         color));
/*    */       
/* 82 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if ((IItemStack)MinecraftInstance.mc.getThePlayer().getInventory().getArmorInventory().get(b2) != null) { IItemStack stack = (IItemStack)MinecraftInstance.mc.getThePlayer().getInventory().getArmorInventory().get(b2);
/*    */         
/* 84 */         Intrinsics.checkExpressionValueIsNotNull(VisualUtils.getGradientOffset(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue()), 10.0D), "VisualUtils.getGradientO…rPalette.b2.get())),10.0)"); RenderUtils.drawGradientSidewaysV(x, 0.0D, x + 18, 17.0D, colorall, VisualUtils.getGradientOffset(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue()), 10.0D).getRGB());
/* 85 */         Fonts.Newuifont12.drawStringWithShadow(String.valueOf(stack.getMaxDamage() - stack.getItemDamage()), x + 4, 20, colorall);
/* 86 */         RenderUtils.drawRect(x, 25.0F, x + 18.0F, 26.0F, (new Color(140, 140, 140, 220)).getRGB());
/* 87 */         RenderUtils.drawRect(x, 25.0F, x + 18.0F * (stack.getMaxDamage() - stack.getItemDamage()) / stack.getMaxDamage(), 26.0F, colorall);
/* 88 */         renderItem.renderItemIntoGUI(stack, x + 1, y);
/* 89 */         x += 20;
/* 90 */         i++; } else { (IItemStack)MinecraftInstance.mc.getThePlayer().getInventory().getArmorInventory().get(b2); }
/*    */     
/* 92 */     }  GlStateManager.func_179141_d();
/* 93 */     GlStateManager.func_179084_k();
/* 94 */     GlStateManager.func_179140_f();
/* 95 */     GlStateManager.func_179129_p();
/* 96 */     GL11.glPopMatrix();
/*    */     
/* 98 */     return new Border(-2.0F, -4.0F, 82.0F, 29.0F);
/*    */   }
/*    */   
/*    */   public NovoArmor() {
/*    */     this(0.0D, 0.0D, 0.0F, null, 15, null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\NovoArmor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */