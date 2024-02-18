/*     */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.NumberFormat;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.Render2DEvent;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.event.ShaderEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.ui.client.fonts.impl.Fonts;
/*     */ import net.ccbluex.liquidbounce.ui.font.GameFontRenderer;
/*     */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.ESPUtil;
/*     */ import net.ccbluex.liquidbounce.utils.render.RoundedUtil;
/*     */ import net.ccbluex.liquidbounce.utils.render.tenacity.ColorUtil;
/*     */ import net.ccbluex.liquidbounce.utils.render.tenacity.GradientUtil;
/*     */ import net.ccbluex.liquidbounce.utils.render.tenacity.MathUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.StringUtils;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.util.vector.Vector4f;
/*     */ 
/*     */ @ModuleInfo(name = "ESP2D", description = "Tenacity.", category = ModuleCategory.RENDER)
/*     */ public class ESP2D
/*     */   extends Module {
/*  38 */   public static final BoolValue Players = new BoolValue("Player", true);
/*  39 */   public static final BoolValue Animals = new BoolValue("Animals", false);
/*  40 */   public static final BoolValue Mobs = new BoolValue("Mobs", false);
/*  41 */   public static final BoolValue mcfont = new BoolValue("Minecraft Font", false);
/*  42 */   public final BoolValue itemHeld = new BoolValue("Item Held", true);
/*  43 */   public final BoolValue boxEsp = new BoolValue("Box", true);
/*  44 */   public static final ListValue boxColorMode = new ListValue("Box Mode", new String[] { "Sync", "Light Rainbow", "Static", "Fade", "Double Color", "Analogous", "Default" }, "Double Color");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   public static final ListValue degree = new ListValue("Degree", new String[] { "30", "-30" }, "30");
/*     */ 
/*     */ 
/*     */   
/*  57 */   public final BoolValue healthBar = new BoolValue("Health Bar", true);
/*  58 */   public static final ListValue healthBarMode = new ListValue("Health Bar Mode", new String[] { "Color", "Health" }, "Color");
/*     */ 
/*     */ 
/*     */   
/*  62 */   public final BoolValue healthBarText = new BoolValue("Health Bar Text", true);
/*  63 */   public final BoolValue nametags = new BoolValue("Tags", true);
/*     */   
/*  65 */   public static final FloatValue scale = new FloatValue("Tag Scale", 0.5F, 0.1F, 10.0F);
/*  66 */   public static final FloatValue scale2 = new FloatValue("Item Held Tag Scale", 0.5F, 0.1F, 10.0F);
/*  67 */   public static final BoolValue healthtext = new BoolValue("Health Text", true);
/*  68 */   public static final BoolValue Background = new BoolValue("Background", true);
/*     */   
/*  70 */   private static final Map<Entity, Vector4f> entityPosition = new HashMap<>();
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public void onRender3D(Render3DEvent event) {
/*  75 */     entityPosition.clear();
/*  76 */     for (Entity entity : mc2.field_71441_e.field_72996_f) {
/*  77 */       if (shouldRender(entity) && ESPUtil.isInView(entity)) {
/*  78 */         entityPosition.put(entity, ESPUtil.getEntityPositionsOn2D(entity));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  86 */   private static final NumberFormat df = new DecimalFormat("0.#");
/*  87 */   private static final Color backgroundColor = new Color(10, 10, 10, 80);
/*     */   public final Color getClientColor() {
/*  89 */     return new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue(), 255);
/*     */   }
/*     */   
/*     */   public final Color getAlternateClientColor() {
/*  93 */     return new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue(), 255);
/*     */   }
/*  95 */   private Color firstColor = Color.BLACK, secondColor = Color.BLACK, thirdColor = Color.BLACK, fourthColor = Color.BLACK;
/*     */   @EventTarget
/*     */   public void onShader(ShaderEvent event) {
/*  98 */     HUD hudMod = (HUD)Retreat.moduleManager.getModule(HUD.class);
/*  99 */     if (((Boolean)this.boxEsp.get()).booleanValue()) {
/* 100 */       Color[] colors; int val; Color analogous; switch (((String)boxColorMode.get()).toLowerCase()) {
/*     */         case "sync":
/* 102 */           colors = hudMod.getClientColors();
/* 103 */           this.firstColor = ColorUtil.interpolateColorsBackAndForth(15, 0, colors[0], colors[1], ((Boolean)hudMod.getHueInterpolation().get()).booleanValue());
/* 104 */           this.secondColor = ColorUtil.interpolateColorsBackAndForth(15, 90, colors[0], colors[1], ((Boolean)hudMod.getHueInterpolation().get()).booleanValue());
/* 105 */           this.thirdColor = ColorUtil.interpolateColorsBackAndForth(15, 180, colors[0], colors[1], ((Boolean)hudMod.getHueInterpolation().get()).booleanValue());
/* 106 */           this.fourthColor = ColorUtil.interpolateColorsBackAndForth(15, 270, colors[0], colors[1], ((Boolean)hudMod.getHueInterpolation().get()).booleanValue());
/*     */           break;
/*     */         case "light rainbow":
/* 109 */           this.firstColor = ColorUtil.rainbow(15, 0, 0.6F, 1.0F, 1.0F);
/* 110 */           this.secondColor = ColorUtil.rainbow(15, 90, 0.6F, 1.0F, 1.0F);
/* 111 */           this.thirdColor = ColorUtil.rainbow(15, 180, 0.6F, 1.0F, 1.0F);
/* 112 */           this.fourthColor = ColorUtil.rainbow(15, 270, 0.6F, 1.0F, 1.0F);
/*     */           break;
/*     */         case "rainbow":
/* 115 */           this.firstColor = ColorUtil.rainbow(15, 0, 1.0F, 1.0F, 1.0F);
/* 116 */           this.secondColor = ColorUtil.rainbow(15, 90, 1.0F, 1.0F, 1.0F);
/* 117 */           this.thirdColor = ColorUtil.rainbow(15, 180, 1.0F, 1.0F, 1.0F);
/* 118 */           this.fourthColor = ColorUtil.rainbow(15, 270, 1.0F, 1.0F, 1.0F);
/*     */           break;
/*     */         case "static":
/* 121 */           this.firstColor = Color.PINK;
/* 122 */           this.secondColor = this.firstColor;
/* 123 */           this.thirdColor = this.firstColor;
/* 124 */           this.fourthColor = this.firstColor;
/*     */           break;
/*     */         case "fade":
/* 127 */           this.firstColor = ColorUtil.fade(15, 0, Color.PINK, 1.0F);
/* 128 */           this.secondColor = ColorUtil.fade(15, 90, Color.PINK, 1.0F);
/* 129 */           this.thirdColor = ColorUtil.fade(15, 180, Color.PINK, 1.0F);
/* 130 */           this.fourthColor = ColorUtil.fade(15, 270, Color.PINK, 1.0F);
/*     */           break;
/*     */         case "double color":
/* 133 */           this.firstColor = ColorUtil.interpolateColorsBackAndForth(15, 0, getClientColor(), getAlternateClientColor(), ((Boolean)hudMod.getHueInterpolation().get()).booleanValue());
/* 134 */           this.secondColor = ColorUtil.interpolateColorsBackAndForth(15, 90, getClientColor(), getAlternateClientColor(), ((Boolean)hudMod.getHueInterpolation().get()).booleanValue());
/* 135 */           this.thirdColor = ColorUtil.interpolateColorsBackAndForth(15, 180, getClientColor(), getAlternateClientColor(), ((Boolean)hudMod.getHueInterpolation().get()).booleanValue());
/* 136 */           this.fourthColor = ColorUtil.interpolateColorsBackAndForth(15, 270, getClientColor(), getAlternateClientColor(), ((Boolean)hudMod.getHueInterpolation().get()).booleanValue());
/*     */           break;
/*     */         case "analogous":
/* 139 */           val = ((String)degree.get()).equals("30") ? 0 : 1;
/* 140 */           analogous = ColorUtil.getAnalogousColor(Color.BLUE)[val];
/* 141 */           this.firstColor = ColorUtil.interpolateColorsBackAndForth(15, 0, Color.BLUE, analogous, ((Boolean)hudMod.getHueInterpolation().get()).booleanValue());
/* 142 */           this.secondColor = ColorUtil.interpolateColorsBackAndForth(15, 90, Color.BLUE, analogous, ((Boolean)hudMod.getHueInterpolation().get()).booleanValue());
/* 143 */           this.thirdColor = ColorUtil.interpolateColorsBackAndForth(15, 180, Color.BLUE, analogous, ((Boolean)hudMod.getHueInterpolation().get()).booleanValue());
/* 144 */           this.fourthColor = ColorUtil.interpolateColorsBackAndForth(15, 270, Color.BLUE, analogous, ((Boolean)hudMod.getHueInterpolation().get()).booleanValue());
/*     */           break;
/*     */       } 
/*     */     
/*     */     } 
/* 149 */     GL11.glEnable(3042);
/* 150 */     GL11.glBlendFunc(770, 771);
/* 151 */     for (Entity entity : entityPosition.keySet()) {
/* 152 */       Vector4f pos = entityPosition.get(entity);
/* 153 */       float x = pos.getX();
/* 154 */       float y = pos.getY();
/* 155 */       float right = pos.getZ();
/* 156 */       float bottom = pos.getW();
/*     */       
/* 158 */       if (((Boolean)this.nametags.get()).booleanValue() && entity instanceof EntityLivingBase) {
/* 159 */         double fontHeight; EntityLivingBase renderingEntity = (EntityLivingBase)entity;
/* 160 */         float healthValue = renderingEntity.func_110143_aJ() / renderingEntity.func_110138_aP();
/* 161 */         EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
/* 162 */         Color color = getColor(entity);
/* 163 */         Color healthColor = (healthValue > 0.75D) ? new Color(66, 246, 123) : ((healthValue > 0.5D) ? new Color(228, 255, 105) : ((healthValue > 0.35D) ? new Color(236, 100, 64) : new Color(255, 65, 68)));
/* 164 */         StringBuilder text = new StringBuilder(StringUtils.func_76338_a(renderingEntity.func_145748_c_().func_150260_c()));
/* 165 */         if (((Boolean)healthtext.get()).booleanValue()) {
/* 166 */           text.append(String.format(" §7[§r%s HP§7]", new Object[] { df.format(renderingEntity.func_110143_aJ()) }));
/*     */         }
/* 168 */         double fontScale = ((Float)scale.getValue()).floatValue();
/* 169 */         float middle = x + (right - x) / 2.0F;
/* 170 */         float textWidth = 0.0F;
/*     */         
/* 172 */         if (((Boolean)mcfont.get()).booleanValue()) {
/* 173 */           textWidth = mc2.field_71466_p.func_78256_a(text.toString());
/* 174 */           middle = (float)(middle - textWidth * fontScale / 2.0D);
/* 175 */           fontHeight = mc2.field_71466_p.field_78288_b * fontScale;
/*     */         } else {
/* 177 */           textWidth = Fonts.SFBOLD.SFBOLD_20.SFBOLD_20.stringWidth(text.toString());
/* 178 */           middle = (float)(middle - textWidth * fontScale / 2.0D);
/* 179 */           fontHeight = Fonts.SFBOLD.SFBOLD_20.SFBOLD_20.getHeight() * fontScale;
/*     */         } 
/* 181 */         GL11.glPushMatrix();
/* 182 */         GL11.glTranslated(middle, y - fontHeight + 2.0D, 0.0D);
/* 183 */         GL11.glScaled(fontScale, fontScale, 1.0D);
/* 184 */         GL11.glTranslated(-middle, -(y - fontHeight + 2.0D), 0.0D);
/*     */         
/* 186 */         if (((Boolean)Background.get()).booleanValue())
/*     */         {
/*     */           
/* 189 */           if (((Boolean)BlurSettings.Glow.get()).booleanValue()) {
/* 190 */             RoundedUtil.drawGradientRound(middle - 3.0F, (float)(y - fontHeight + 7.0D), textWidth + 6.0F, (float)(fontHeight / fontScale + 4.0D), 4.0F, 
/*     */ 
/*     */                 
/* 193 */                 ColorUtil.applyOpacity(this.fourthColor, 1.0F), this.firstColor, this.secondColor, this.thirdColor);
/*     */           } else {
/* 195 */             RoundedUtil.drawRound(middle - 3.0F, (float)(y - fontHeight + 7.0D), textWidth + 6.0F, (float)(fontHeight / fontScale + 4.0D), 4.0F, new Color(0, 0, 0, 255));
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 203 */         GL11.glPopMatrix();
/*     */       } 
/*     */       
/* 206 */       if (((Boolean)this.healthBar.get()).booleanValue() && entity instanceof EntityLivingBase) {
/* 207 */         EntityLivingBase renderingEntity = (EntityLivingBase)entity;
/* 208 */         float healthValue = renderingEntity.func_110143_aJ() / renderingEntity.func_110138_aP();
/* 209 */         Color healthColor = (healthValue > 0.75D) ? new Color(66, 246, 123) : ((healthValue > 0.5D) ? new Color(228, 255, 105) : ((healthValue > 0.35D) ? new Color(236, 100, 64) : new Color(255, 65, 68)));
/* 210 */         float height = bottom - y + 1.0F;
/* 211 */         if (((String)healthBarMode.get()).equals("Color")) {
/* 212 */           GradientUtil.drawGradientTB(right + 3.0F, y + height - height * healthValue, 1.0F, height * healthValue, 1.0F, this.secondColor, this.thirdColor);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public void onRender2D(Render2DEvent event) {
/* 222 */     HUD hudMod = (HUD)Retreat.moduleManager.getModule(HUD.class);
/*     */     
/* 224 */     if (((Boolean)this.boxEsp.get()).booleanValue()) {
/* 225 */       Color[] colors; int val; Color analogous; switch (((String)boxColorMode.get()).toLowerCase()) {
/*     */         case "sync":
/* 227 */           colors = hudMod.getClientColors();
/* 228 */           this.firstColor = ColorUtil.interpolateColorsBackAndForth(15, 0, colors[0], colors[1], ((Boolean)hudMod.getHueInterpolation().get()).booleanValue());
/* 229 */           this.secondColor = ColorUtil.interpolateColorsBackAndForth(15, 90, colors[0], colors[1], ((Boolean)hudMod.getHueInterpolation().get()).booleanValue());
/* 230 */           this.thirdColor = ColorUtil.interpolateColorsBackAndForth(15, 180, colors[0], colors[1], ((Boolean)hudMod.getHueInterpolation().get()).booleanValue());
/* 231 */           this.fourthColor = ColorUtil.interpolateColorsBackAndForth(15, 270, colors[0], colors[1], ((Boolean)hudMod.getHueInterpolation().get()).booleanValue());
/*     */           break;
/*     */         case "light rainbow":
/* 234 */           this.firstColor = ColorUtil.rainbow(15, 0, 0.6F, 1.0F, 1.0F);
/* 235 */           this.secondColor = ColorUtil.rainbow(15, 90, 0.6F, 1.0F, 1.0F);
/* 236 */           this.thirdColor = ColorUtil.rainbow(15, 180, 0.6F, 1.0F, 1.0F);
/* 237 */           this.fourthColor = ColorUtil.rainbow(15, 270, 0.6F, 1.0F, 1.0F);
/*     */           break;
/*     */         case "rainbow":
/* 240 */           this.firstColor = ColorUtil.rainbow(15, 0, 1.0F, 1.0F, 1.0F);
/* 241 */           this.secondColor = ColorUtil.rainbow(15, 90, 1.0F, 1.0F, 1.0F);
/* 242 */           this.thirdColor = ColorUtil.rainbow(15, 180, 1.0F, 1.0F, 1.0F);
/* 243 */           this.fourthColor = ColorUtil.rainbow(15, 270, 1.0F, 1.0F, 1.0F);
/*     */           break;
/*     */         case "static":
/* 246 */           this.firstColor = Color.PINK;
/* 247 */           this.secondColor = this.firstColor;
/* 248 */           this.thirdColor = this.firstColor;
/* 249 */           this.fourthColor = this.firstColor;
/*     */           break;
/*     */         case "fade":
/* 252 */           this.firstColor = ColorUtil.fade(15, 0, Color.PINK, 1.0F);
/* 253 */           this.secondColor = ColorUtil.fade(15, 90, Color.PINK, 1.0F);
/* 254 */           this.thirdColor = ColorUtil.fade(15, 180, Color.PINK, 1.0F);
/* 255 */           this.fourthColor = ColorUtil.fade(15, 270, Color.PINK, 1.0F);
/*     */           break;
/*     */         case "double color":
/* 258 */           this.firstColor = ColorUtil.interpolateColorsBackAndForth(15, 0, getClientColor(), getAlternateClientColor(), ((Boolean)hudMod.getHueInterpolation().get()).booleanValue());
/* 259 */           this.secondColor = ColorUtil.interpolateColorsBackAndForth(15, 90, getClientColor(), getAlternateClientColor(), ((Boolean)hudMod.getHueInterpolation().get()).booleanValue());
/* 260 */           this.thirdColor = ColorUtil.interpolateColorsBackAndForth(15, 180, getClientColor(), getAlternateClientColor(), ((Boolean)hudMod.getHueInterpolation().get()).booleanValue());
/* 261 */           this.fourthColor = ColorUtil.interpolateColorsBackAndForth(15, 270, getClientColor(), getAlternateClientColor(), ((Boolean)hudMod.getHueInterpolation().get()).booleanValue());
/*     */           break;
/*     */         case "analogous":
/* 264 */           val = ((String)degree.get()).equals("30") ? 0 : 1;
/* 265 */           analogous = ColorUtil.getAnalogousColor(Color.BLUE)[val];
/* 266 */           this.firstColor = ColorUtil.interpolateColorsBackAndForth(15, 0, Color.BLUE, analogous, ((Boolean)hudMod.getHueInterpolation().get()).booleanValue());
/* 267 */           this.secondColor = ColorUtil.interpolateColorsBackAndForth(15, 90, Color.BLUE, analogous, ((Boolean)hudMod.getHueInterpolation().get()).booleanValue());
/* 268 */           this.thirdColor = ColorUtil.interpolateColorsBackAndForth(15, 180, Color.BLUE, analogous, ((Boolean)hudMod.getHueInterpolation().get()).booleanValue());
/* 269 */           this.fourthColor = ColorUtil.interpolateColorsBackAndForth(15, 270, Color.BLUE, analogous, ((Boolean)hudMod.getHueInterpolation().get()).booleanValue());
/*     */           break;
/*     */       } 
/*     */     } 
/* 273 */     GlStateManager.func_179117_G();
/* 274 */     GL11.glEnable(3042);
/* 275 */     GL11.glBlendFunc(770, 771);
/* 276 */     for (Entity entity : entityPosition.keySet()) {
/* 277 */       Vector4f pos = entityPosition.get(entity);
/* 278 */       float x = pos.getX();
/* 279 */       float y = pos.getY();
/* 280 */       float right = pos.getZ();
/* 281 */       float bottom = pos.getW();
/*     */       
/* 283 */       if (((Boolean)this.nametags.get()).booleanValue() && entity instanceof EntityLivingBase) {
/* 284 */         double fontHeight; EntityLivingBase renderingEntity = (EntityLivingBase)entity;
/* 285 */         float healthValue = renderingEntity.func_110143_aJ() / renderingEntity.func_110138_aP();
/* 286 */         EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
/* 287 */         Color color = getColor(entity);
/* 288 */         Color healthColor = (healthValue > 0.75D) ? new Color(66, 246, 123) : ((healthValue > 0.5D) ? new Color(228, 255, 105) : ((healthValue > 0.35D) ? new Color(236, 100, 64) : new Color(255, 65, 68)));
/* 289 */         StringBuilder text = new StringBuilder(StringUtils.func_76338_a(renderingEntity.func_145748_c_().func_150260_c()));
/* 290 */         if (((Boolean)healthtext.get()).booleanValue()) {
/* 291 */           if (healthValue > 0.75D) {
/* 292 */             text.append(String.format(" §7[§a%s HP§7]", new Object[] { df.format(renderingEntity.func_110143_aJ()) }));
/* 293 */           } else if (healthValue > 0.5D) {
/* 294 */             text.append(String.format(" §7[§e%s HP§7]", new Object[] { df.format(renderingEntity.func_110143_aJ()) }));
/*     */           }
/* 296 */           else if (healthValue > 0.35D) {
/* 297 */             text.append(String.format(" §7[§4%s HP§7]", new Object[] { df.format(renderingEntity.func_110143_aJ()) }));
/*     */           } else {
/* 299 */             text.append(String.format(" §7[§4%s HP§7]", new Object[] { df.format(renderingEntity.func_110143_aJ()) }));
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/* 304 */         double fontScale = ((Float)scale.getValue()).floatValue();
/* 305 */         float middle = x + (right - x) / 2.0F;
/* 306 */         float textWidth = 0.0F;
/*     */         
/* 308 */         if (((Boolean)mcfont.get()).booleanValue()) {
/* 309 */           textWidth = mc2.field_71466_p.func_78256_a(text.toString());
/* 310 */           middle = (float)(middle - textWidth * fontScale / 2.0D);
/* 311 */           fontHeight = mc2.field_71466_p.field_78288_b * fontScale;
/*     */         } else {
/* 313 */           textWidth = Fonts.SFBOLD.SFBOLD_20.SFBOLD_20.stringWidth(text.toString());
/* 314 */           middle = (float)(middle - textWidth * fontScale / 2.0D);
/* 315 */           fontHeight = Fonts.SFBOLD.SFBOLD_20.SFBOLD_20.getHeight() * fontScale;
/*     */         } 
/*     */         
/* 318 */         GL11.glPushMatrix();
/* 319 */         GL11.glTranslated(middle, y - fontHeight + 2.0D, 0.0D);
/* 320 */         GL11.glScaled(fontScale, fontScale, 1.0D);
/* 321 */         GL11.glTranslated(-middle, -(y - fontHeight + 2.0D), 0.0D);
/*     */         
/* 323 */         GlStateManager.func_179144_i(0);
/* 324 */         GlStateManager.func_179117_G();
/*     */         
/* 326 */         if (((Boolean)mcfont.get()).booleanValue()) {
/* 327 */           mc2.field_71466_p.func_175063_a(text.toString(), middle, (float)(y - fontHeight + 4.0D), color.getRGB());
/*     */         } else {
/* 329 */           Fonts.SFBOLD.SFBOLD_20.SFBOLD_20.drawString(text.toString(), middle, (float)(y - fontHeight + 5.0D), color.getRGB());
/*     */         } 
/* 331 */         if (((Boolean)Background.get()).booleanValue())
/*     */         {
/*     */           
/* 334 */           RoundedUtil.drawRound(middle - 3.0F, (float)(y - fontHeight + 7.0D), textWidth + 6.0F, (float)(fontHeight / fontScale + 4.0D), 4.0F, new Color(0, 0, 0, 50));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 339 */         GL11.glPopMatrix();
/*     */       } 
/*     */       
/* 342 */       GlStateManager.func_179117_G();
/* 343 */       if (((Boolean)this.itemHeld.get()).booleanValue() && entity instanceof EntityLivingBase) {
/* 344 */         EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
/* 345 */         EntityLivingBase entityLiving = (EntityLivingBase)entity;
/* 346 */         if (entityLiving instanceof EntityPlayer) {
/* 347 */           ((EntityPlayer)entityLiving).func_184614_ca();
/*     */           
/* 349 */           double fontScale = ((Float)scale2.getValue()).floatValue();
/* 350 */           float middle = x + (right - x) / 2.0F;
/* 351 */           float textWidth = 0.0F;
/*     */           
/* 353 */           String text = entityLiving.func_184614_ca().func_82833_r();
/* 354 */           if (((Boolean)mcfont.get()).booleanValue()) {
/* 355 */             textWidth = mc2.field_71466_p.func_78256_a(text);
/* 356 */             middle = (float)(middle - textWidth * fontScale / 2.0D);
/* 357 */             double fontHeight = mc2.field_71466_p.field_78288_b * fontScale;
/*     */           } else {
/* 359 */             textWidth = Fonts.SFBOLD.SFBOLD_20.SFBOLD_20.stringWidth(text);
/* 360 */             middle = (float)(middle - textWidth * fontScale / 2.0D);
/* 361 */             double fontHeight = Fonts.SFBOLD.SFBOLD_20.SFBOLD_20.getHeight() * fontScale;
/*     */           } 
/*     */           
/* 364 */           GL11.glPushMatrix();
/* 365 */           GL11.glTranslated(middle, (bottom + 4.0F), 0.0D);
/* 366 */           GL11.glScaled(fontScale, fontScale, 1.0D);
/* 367 */           GL11.glTranslated(-middle, -(bottom + 4.0F), 0.0D);
/* 368 */           GlStateManager.func_179144_i(0);
/* 369 */           GlStateManager.func_179117_G();
/*     */           
/* 371 */           if (((Boolean)mcfont.get()).booleanValue()) {
/* 372 */             mc2.field_71466_p.func_175063_a(text, middle, bottom + 4.0F, -1);
/*     */           } else {
/* 374 */             Fonts.SFBOLD.SFBOLD_20.SFBOLD_20.drawString(text.toString(), middle, bottom + 4.0F, -1, true);
/*     */           } 
/* 376 */           GL11.glPopMatrix();
/*     */         } 
/*     */       } 
/* 379 */       GlStateManager.func_179117_G();
/* 380 */       if (((Boolean)this.healthBar.get()).booleanValue() && entity instanceof EntityLivingBase) {
/* 381 */         EntityLivingBase renderingEntity = (EntityLivingBase)entity;
/* 382 */         float healthValue = renderingEntity.func_110143_aJ() / renderingEntity.func_110138_aP();
/* 383 */         Color healthColor = (healthValue > 0.75D) ? new Color(66, 246, 123) : ((healthValue > 0.5D) ? new Color(228, 255, 105) : ((healthValue > 0.35D) ? new Color(236, 100, 64) : new Color(255, 65, 68)));
/*     */         
/* 385 */         float height = bottom - y + 1.0F;
/* 386 */         if (((String)healthBarMode.get()).equals("Color")) {
/* 387 */           GradientUtil.drawGradientTB(right + 3.0F, y + height - height * healthValue, 1.0F, height * healthValue, 1.0F, this.secondColor, this.thirdColor);
/*     */         }
/*     */ 
/*     */         
/* 391 */         if (((Boolean)this.healthBarText.get()).booleanValue()) {
/* 392 */           healthValue *= 100.0F;
/* 393 */           String health = String.valueOf(MathUtils.round(healthValue, 1)).substring(0, (healthValue == 100.0F) ? 3 : 2);
/* 394 */           String text = health + "%";
/* 395 */           double fontScale = 0.5D;
/* 396 */           float textX = right + 8.0F;
/* 397 */           float fontHeight = ((Boolean)mcfont.get()).booleanValue() ? (float)(mc2.field_71466_p.field_78288_b * fontScale) : (float)(Fonts.SFBOLD.SFBOLD_20.SFBOLD_20.getHeight() * fontScale);
/* 398 */           float newHeight = height - fontHeight;
/* 399 */           float textY = y + newHeight - newHeight * healthValue / 100.0F;
/*     */           
/* 401 */           GL11.glPushMatrix();
/* 402 */           GL11.glTranslated((textX - 5.0F), textY, 1.0D);
/* 403 */           GL11.glScaled(fontScale, fontScale, 1.0D);
/* 404 */           GL11.glTranslated(-(textX - 5.0F), -textY, 1.0D);
/* 405 */           if (((Boolean)mcfont.get()).booleanValue()) {
/* 406 */             mc2.field_71466_p.func_175063_a(text, textX, textY, -1);
/*     */           } else {
/* 408 */             Fonts.SFBOLD.SFBOLD_20.SFBOLD_20.drawString(text, textX, textY, -1, true);
/*     */           } 
/* 410 */           GL11.glPopMatrix();
/*     */         } 
/* 412 */         GlStateManager.func_179117_G();
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 417 */       if (((Boolean)this.boxEsp.get()).booleanValue()) {
/* 418 */         float outlineThickness = 0.5F;
/* 419 */         GlStateManager.func_179117_G();
/*     */         
/* 421 */         GradientUtil.drawGradientLR(x, y, right - x, 1.0F, 1.0F, this.firstColor, this.secondColor);
/*     */         
/* 423 */         GradientUtil.drawGradientTB(x, y, 1.0F, bottom - y, 1.0F, this.firstColor, this.fourthColor);
/*     */         
/* 425 */         GradientUtil.drawGradientLR(x, bottom, right - x, 1.0F, 1.0F, this.fourthColor, this.thirdColor);
/*     */         
/* 427 */         GradientUtil.drawGradientTB(right, y, 1.0F, bottom - y + 1.0F, 1.0F, this.secondColor, this.thirdColor);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getColor(Entity entity) {
/* 437 */     if (entity != null) {
/* 438 */       EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
/* 439 */       char[] chars = (entityLivingBase.func_145748_c_() != null) ? entityLivingBase.func_145748_c_().func_150254_d().toCharArray() : new char[0];
/* 440 */       int color = Integer.MAX_VALUE;
/* 441 */       for (int i = 0; i < chars.length; i++) {
/* 442 */         if (chars[i] == '§' && i + 1 < chars.length) {
/* 443 */           int index = GameFontRenderer.getColorIndex(chars[i + 1]);
/* 444 */           if (index >= 0 && index <= 15) {
/* 445 */             color = ColorUtils.hexColors[index]; break;
/*     */           } 
/*     */         } 
/* 448 */       }  return new Color(color);
/*     */     } 
/* 450 */     return null;
/*     */   }
/*     */   public static boolean shouldRender(Entity entity) {
/* 453 */     if (entity.field_70128_L || entity.func_82150_aj()) {
/* 454 */       return false;
/*     */     }
/* 456 */     if (((Boolean)Players.get()).booleanValue() && entity instanceof EntityPlayer) {
/* 457 */       if (entity == mc2.field_71439_g) {
/* 458 */         return (mc2.field_71474_y.field_74320_O != 0);
/*     */       }
/* 460 */       return true;
/*     */     } 
/* 462 */     if (((Boolean)Animals.get()).booleanValue() && entity instanceof net.minecraft.entity.passive.EntityAnimal) {
/* 463 */       return true;
/*     */     }
/*     */     
/* 466 */     return (((Boolean)Mobs.get()).booleanValue() && entity instanceof net.minecraft.entity.monster.EntityMob);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\ESP2D.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */