/*     */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.client.renderer.BufferBuilder;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import tomk.module.render.ColorMixer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ModuleInfo(name = "AsianHat", description = "Yep. China Hat.", category = ModuleCategory.RENDER)
/*     */ public class AsianHat
/*     */   extends Module
/*     */ {
/*  38 */   private final ListValue colorModeValue = new ListValue("Color", new String[] { "Custom", "Rainbow", "Sky", "LiquidSlowly", "Fade", "Mixer" }, "Custom");
/*  39 */   private final IntegerValue colorAlphaValue = new IntegerValue("Alpha", 0, 0, 255);
/*  40 */   private final IntegerValue colorEndAlphaValue = new IntegerValue("EndAlpha", 156, 0, 255);
/*  41 */   private final FloatValue saturationValue = new FloatValue("Saturation", 0.45F, 0.0F, 1.0F);
/*  42 */   private final FloatValue brightnessValue = new FloatValue("Brightness", 1.0F, 0.0F, 1.0F);
/*  43 */   private final IntegerValue mixerSecondsValue = new IntegerValue("Seconds", 2, 1, 10);
/*  44 */   private final IntegerValue spaceValue = new IntegerValue("Color-Space", 6, 0, 100);
/*  45 */   private final BoolValue noFirstPerson = new BoolValue("NoFirstPerson", true);
/*  46 */   private final BoolValue hatBorder = new BoolValue("HatBorder", true);
/*     */   
/*  48 */   private final IntegerValue borderAlphaValue = new IntegerValue("BorderAlpha", 255, 0, 255);
/*  49 */   private final FloatValue borderWidthValue = new FloatValue("BorderWidth", 1.0F, 0.1F, 4.0F);
/*     */   
/*  51 */   private final List<double[]> positions = (List)new ArrayList<>();
/*  52 */   private double lastRadius = 0.0D;
/*     */   
/*     */   private void checkPosition(double radius) {
/*  55 */     if (radius != this.lastRadius) {
/*     */       
/*  57 */       this.positions.clear();
/*  58 */       for (int i = 0; i <= 360; i++) {
/*  59 */         this.positions.add(new double[] { -Math.sin(i * Math.PI / 180.0D) * radius, Math.cos(i * Math.PI / 180.0D) * radius });
/*     */       } 
/*  61 */     }  this.lastRadius = radius;
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public void onRender3D(Render3DEvent event) {
/*  66 */     IEntityPlayerSP iEntityPlayerSP = mc.getThePlayer();
/*  67 */     if (iEntityPlayerSP == null || (((Boolean)this.noFirstPerson.get()).booleanValue() && mc.getGameSettings().getThirdPersonView() == 0))
/*     */       return; 
/*  69 */     IAxisAlignedBB bb = iEntityPlayerSP.getEntityBoundingBox();
/*  70 */     double radius = bb.getMaxX() - bb.getMinX();
/*  71 */     double height = bb.getMaxY() - bb.getMinY();
/*  72 */     double posX = iEntityPlayerSP.getLastTickPosX() + (iEntityPlayerSP.getPosX() - iEntityPlayerSP.getLastTickPosX()) * mc.getTimer().getRenderPartialTicks();
/*  73 */     double posY = iEntityPlayerSP.getLastTickPosY() + (iEntityPlayerSP.getPosY() - iEntityPlayerSP.getLastTickPosY()) * mc.getTimer().getRenderPartialTicks();
/*  74 */     double posZ = iEntityPlayerSP.getLastTickPosZ() + (iEntityPlayerSP.getPosZ() - iEntityPlayerSP.getLastTickPosZ()) * mc.getTimer().getRenderPartialTicks();
/*     */     
/*  76 */     Color colour = getColor((IEntity)iEntityPlayerSP, 0);
/*  77 */     float r = colour.getRed() / 255.0F;
/*  78 */     float g = colour.getGreen() / 255.0F;
/*  79 */     float b = colour.getBlue() / 255.0F;
/*  80 */     float al = ((Integer)this.colorAlphaValue.get()).intValue() / 255.0F;
/*  81 */     float Eal = ((Integer)this.colorEndAlphaValue.get()).intValue() / 255.0F;
/*     */     
/*  83 */     float partialTicks = event.getPartialTicks();
/*     */     
/*  85 */     double viewX = -mc.getRenderManager().getViewerPosX();
/*  86 */     double viewY = -mc.getRenderManager().getViewerPosY();
/*  87 */     double viewZ = -mc.getRenderManager().getViewerPosZ();
/*     */     
/*  89 */     Tessellator tessellator = Tessellator.func_178181_a();
/*  90 */     BufferBuilder worldrenderer = tessellator.func_178180_c();
/*     */     
/*  92 */     checkPosition(radius);
/*  93 */     pre3D();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 101 */     worldrenderer.func_181668_a(9, DefaultVertexFormats.field_181706_f);
/*     */ 
/*     */     
/* 104 */     worldrenderer.func_181662_b(viewX + posX, viewY + posY + height + 0.3D, viewZ + posZ).func_181666_a(r, g, b, al).func_181675_d();
/*     */     
/* 106 */     int i = 0;
/* 107 */     for (double[] smolPos : this.positions) {
/* 108 */       double posX2 = posX + smolPos[0];
/* 109 */       double posZ2 = posZ + smolPos[1];
/*     */       
/* 111 */       if (((Integer)this.spaceValue.get()).intValue() > 0 && !((String)this.colorModeValue.get()).equalsIgnoreCase("Custom")) {
/* 112 */         Color colour2 = getColor((IEntity)iEntityPlayerSP, i * ((Integer)this.spaceValue.get()).intValue());
/* 113 */         float r2 = colour2.getRed() / 255.0F;
/* 114 */         float g2 = colour2.getGreen() / 255.0F;
/* 115 */         float b2 = colour2.getBlue() / 255.0F;
/*     */         
/* 117 */         worldrenderer.func_181662_b(viewX + posX2, viewY + posY + height, viewZ + posZ2).func_181666_a(r2, g2, b2, Eal).func_181675_d();
/*     */       } else {
/* 119 */         worldrenderer.func_181662_b(viewX + posX2, viewY + posY + height, viewZ + posZ2).func_181666_a(r, g, b, Eal).func_181675_d();
/*     */       } 
/*     */       
/* 122 */       i++;
/*     */     } 
/*     */     
/* 125 */     worldrenderer.func_181662_b(viewX + posX, viewY + posY + height + 0.3D, viewZ + posZ).func_181666_a(r, g, b, al).func_181675_d();
/* 126 */     tessellator.func_78381_a();
/*     */ 
/*     */     
/* 129 */     if (((Boolean)this.hatBorder.get()).booleanValue()) {
/* 130 */       float lineAlp = ((Integer)this.borderAlphaValue.get()).intValue() / 255.0F;
/*     */       
/* 132 */       GL11.glLineWidth(((Float)this.borderWidthValue.get()).floatValue());
/*     */       
/* 134 */       worldrenderer.func_181668_a(2, DefaultVertexFormats.field_181706_f);
/*     */       
/* 136 */       i = 0;
/* 137 */       for (double[] smolPos : this.positions) {
/* 138 */         double posX2 = posX + smolPos[0];
/* 139 */         double posZ2 = posZ + smolPos[1];
/*     */         
/* 141 */         if (((Integer)this.spaceValue.get()).intValue() > 0 && !((String)this.colorModeValue.get()).equalsIgnoreCase("Custom")) {
/* 142 */           Color colour2 = getColor((IEntity)iEntityPlayerSP, i * ((Integer)this.spaceValue.get()).intValue());
/* 143 */           float r2 = colour2.getRed() / 255.0F;
/* 144 */           float g2 = colour2.getGreen() / 255.0F;
/* 145 */           float b2 = colour2.getBlue() / 255.0F;
/*     */           
/* 147 */           worldrenderer.func_181662_b(viewX + posX2, viewY + posY + height, viewZ + posZ2).func_181666_a(r2, g2, b2, lineAlp).func_181675_d();
/*     */         } else {
/* 149 */           worldrenderer.func_181662_b(viewX + posX2, viewY + posY + height, viewZ + posZ2).func_181666_a(r, g, b, lineAlp).func_181675_d();
/*     */         } 
/*     */         
/* 152 */         i++;
/*     */       } 
/*     */       
/* 155 */       tessellator.func_78381_a();
/*     */     } 
/*     */     
/* 158 */     post3D();
/*     */   }
/*     */   
/*     */   public final Color getColor(IEntity ent, int index) {
/* 162 */     switch ((String)this.colorModeValue.get()) {
/*     */       case "Custom":
/* 164 */         return new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue());
/*     */       case "Rainbow":
/* 166 */         return new Color(RenderUtils.getRainbowOpaque(((Integer)this.mixerSecondsValue.get()).intValue(), ((Float)this.saturationValue.get()).floatValue(), ((Float)this.brightnessValue.get()).floatValue(), index));
/*     */       case "Sky":
/* 168 */         return RenderUtils.skyRainbow(index, ((Float)this.saturationValue.get()).floatValue(), ((Float)this.brightnessValue.get()).floatValue());
/*     */       case "LiquidSlowly":
/* 170 */         return ColorUtils.LiquidSlowly(System.nanoTime(), index, ((Float)this.saturationValue.get()).floatValue(), ((Float)this.brightnessValue.get()).floatValue());
/*     */       case "Mixer":
/* 172 */         return ColorMixer.getMixedColor(index, ((Integer)this.mixerSecondsValue.get()).intValue());
/*     */     } 
/* 174 */     return ColorUtils.fade(new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue()), index, 100);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void pre3D() {
/* 179 */     GL11.glPushMatrix();
/* 180 */     GL11.glEnable(3042);
/* 181 */     GL11.glBlendFunc(770, 771);
/* 182 */     GL11.glShadeModel(7425);
/* 183 */     GL11.glDisable(3553);
/* 184 */     GL11.glEnable(2848);
/* 185 */     GL11.glDisable(2929);
/* 186 */     GL11.glDisable(2896);
/* 187 */     GL11.glDepthMask(false);
/* 188 */     GL11.glHint(3154, 4354);
/* 189 */     GL11.glDisable(2884);
/*     */   }
/*     */   
/*     */   public static void post3D() {
/* 193 */     GL11.glDepthMask(true);
/* 194 */     GL11.glEnable(2929);
/* 195 */     GL11.glDisable(2848);
/* 196 */     GL11.glEnable(3553);
/* 197 */     GL11.glDisable(3042);
/* 198 */     GL11.glPopMatrix();
/* 199 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\AsianHat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */