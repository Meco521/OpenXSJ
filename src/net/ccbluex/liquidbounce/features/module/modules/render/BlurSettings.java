/*     */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*     */ 
/*     */ import com.google.gson.annotations.Expose;
/*     */ import com.google.gson.annotations.SerializedName;
/*     */ import java.awt.Color;
/*     */ import lynn.utils.blur.GaussianBlur;
/*     */ import lynn.utils.blur.InGameBlurUtil;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.event.Event;
/*     */ import net.ccbluex.liquidbounce.event.ShaderEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.render.StencilUtil;
/*     */ import net.ccbluex.liquidbounce.utils.BloomUtil;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.blur.KawaseBloom;
/*     */ import net.ccbluex.liquidbounce.utils.render.blur.KawaseBlur;
/*     */ import net.ccbluex.liquidbounce.utils.render.tenacity.ColorUtil;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.client.shader.Framebuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ModuleInfo(name = "BlurSettings", description = "Shader effect.", category = ModuleCategory.RENDER)
/*     */ public class BlurSettings
/*     */   extends Module
/*     */ {
/*  34 */   public static final ListValue modeValues = new ListValue("BlurMode", new String[] { "No", "Rise", "Tenacity", "TenacityGlow", "New" }, "TenacityGlow");
/*  35 */   public static final ListValue mode = new ListValue("ShadowMode", new String[] { "No", "Tenacity", "TenacityGlow", "New" }, "TenacityGlow");
/*  36 */   public static final BoolValue ArmorGlow = (BoolValue)(new BoolValue("Armor Glow", true)).displayable(() -> Boolean.valueOf((((String)mode.get()).equals("TenacityGlow") && ((String)modeValues.get()).equals("TenacityGlow"))));
/*  37 */   public static final BoolValue ArraylistGlow = (BoolValue)(new BoolValue("Arraylist Glow", true)).displayable(() -> Boolean.valueOf((((String)mode.get()).equals("TenacityGlow") && ((String)modeValues.get()).equals("TenacityGlow"))));
/*  38 */   public static final BoolValue SpeedGraphGlow = (BoolValue)(new BoolValue("SpeedGraph Glow", true)).displayable(() -> Boolean.valueOf((((String)mode.get()).equals("TenacityGlow") && ((String)modeValues.get()).equals("TenacityGlow"))));
/*  39 */   public static final BoolValue SessioninfoGlow = (BoolValue)(new BoolValue("Sessioninfo Glow", true)).displayable(() -> Boolean.valueOf((((String)mode.get()).equals("TenacityGlow") && ((String)modeValues.get()).equals("TenacityGlow"))));
/*  40 */   public static final BoolValue AutoPlayGGGlow = (BoolValue)(new BoolValue("AutoPlayGG Glow", true)).displayable(() -> Boolean.valueOf((((String)mode.get()).equals("TenacityGlow") && ((String)modeValues.get()).equals("TenacityGlow"))));
/*  41 */   public static final BoolValue logoGlow = (BoolValue)(new BoolValue("LogoFix  Glow", true)).displayable(() -> Boolean.valueOf((((String)mode.get()).equals("TenacityGlow") && ((String)modeValues.get()).equals("TenacityGlow"))));
/*  42 */   public static final BoolValue InventoryGlow = (BoolValue)(new BoolValue("Inventory Glow", true)).displayable(() -> Boolean.valueOf((((String)mode.get()).equals("TenacityGlow") && ((String)modeValues.get()).equals("TenacityGlow"))));
/*  43 */   public static final BoolValue KeyBindsGlow = (BoolValue)(new BoolValue("KeyBinds Glow", true)).displayable(() -> Boolean.valueOf((((String)mode.get()).equals("TenacityGlow") && ((String)modeValues.get()).equals("TenacityGlow"))));
/*  44 */   public static final BoolValue EffectsGlow = (BoolValue)(new BoolValue("Effects  Glow", true)).displayable(() -> Boolean.valueOf((((String)mode.get()).equals("TenacityGlow") && ((String)modeValues.get()).equals("TenacityGlow"))));
/*  45 */   public static final BoolValue NotificationsGlow = (BoolValue)(new BoolValue("Notifications Glow", true)).displayable(() -> Boolean.valueOf((((String)mode.get()).equals("TenacityGlow") && ((String)modeValues.get()).equals("TenacityGlow"))));
/*  46 */   public static final BoolValue ScoreboardGlow = (BoolValue)(new BoolValue("Scoreboard Glow", true)).displayable(() -> Boolean.valueOf((((String)mode.get()).equals("TenacityGlow") && ((String)modeValues.get()).equals("TenacityGlow"))));
/*  47 */   public static final BoolValue RadarGlow = (BoolValue)(new BoolValue("Radar Glow", true)).displayable(() -> Boolean.valueOf((((String)mode.get()).equals("TenacityGlow") && ((String)modeValues.get()).equals("TenacityGlow"))));
/*  48 */   public static final BoolValue Glow = (BoolValue)(new BoolValue("ESP2D Tags Glow", true)).displayable(() -> Boolean.valueOf((((String)mode.get()).equals("TenacityGlow") && ((String)modeValues.get()).equals("TenacityGlow"))));
/*  49 */   public static final BoolValue TargetHudGlow = (BoolValue)(new BoolValue("TargetHud  Glow", true)).displayable(() -> Boolean.valueOf((((String)mode.get()).equals("TenacityGlow") && ((String)modeValues.get()).equals("TenacityGlow"))));
/*  50 */   public static final IntegerValue hudradius = new IntegerValue("HUD BlurUtils Radius", 5, 1, 50);
/*  51 */   private final IntegerValue shadowRadius2 = (IntegerValue)(new IntegerValue("Tenacity Bloom Iterations", 2, 1, 8)).displayable(() -> Boolean.valueOf((((String)mode.get()).equals("Tenacity") || ((String)mode.get()).equals("TenacityGlow"))));
/*  52 */   private final IntegerValue tshadowOffset = (IntegerValue)(new IntegerValue("Tenacity Bloom Offset", 3, 1, 10)).displayable(() -> Boolean.valueOf((((String)mode.get()).equals("Tenacity") || ((String)mode.get()).equals("New") || ((String)mode.get()).equals("TenacityGlow"))));
/*  53 */   public static final IntegerValue iterations = (IntegerValue)(new IntegerValue("Tenacity Blur Iterations", 3, 1, 8)).displayable(() -> Boolean.valueOf((((String)modeValues.get()).equals("Tenacity") || ((String)mode.get()).equals("TenacityGlow"))));
/*  54 */   public static final IntegerValue offset = (IntegerValue)(new IntegerValue("Tenacity Blur Offset", 2, 1, 10)).displayable(() -> Boolean.valueOf((((String)modeValues.get()).equals("Tenacity") || ((String)mode.get()).equals("TenacityGlow"))));
/*     */   
/*  56 */   public static final IntegerValue radius = (IntegerValue)(new IntegerValue("Blur Radius", 5, 1, 50)).displayable(() -> Boolean.valueOf((((String)modeValues.get()).equals("Rise") || ((String)modeValues.get()).equals("New"))));
/*     */   
/*  58 */   private final IntegerValue shadowRadius = (IntegerValue)(new IntegerValue("ShadowRadius", 6, 1, 20)).displayable(() -> Boolean.valueOf(((String)mode.get()).equals("New")));
/*  59 */   private final IntegerValue shadowOffset = (IntegerValue)(new IntegerValue("ShadowOffset", 2, 1, 10)).displayable(() -> Boolean.valueOf(((String)mode.get()).equals("New")));
/*     */   
/*  61 */   private Framebuffer bloomFramebuffer = new Framebuffer(1, 1, true);
/*  62 */   private float saturation = 1.0F;
/*  63 */   private int speed = 15;
/*     */   
/*     */   public Color getColor(int index) {
/*  66 */     return ColorUtil.rainbow(this.speed, index, this.saturation, 1.0F, 1.0F);
/*     */   }
/*     */   @Expose
/*     */   @SerializedName("toggled")
/*     */   protected boolean toggled; private String currentMode;
/*     */   public void toggleSilent() {
/*  72 */     this.toggled = !this.toggled;
/*  73 */     if (this.toggled) {
/*  74 */       onEnable();
/*     */     } else {
/*  76 */       onDisable();
/*     */     } 
/*     */   }
/*     */   
/*     */   public BlurSettings() {
/*  81 */     if (!this.toggled) toggleSilent();
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onEnable() {
/*  89 */     super.onEnable();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void stuffToBlur(boolean bloom) {}
/*     */   
/*     */   public static void stuffToBlur2(boolean bloom) {}
/*     */   
/*     */   public void blurScreen() {
/*  98 */     if (!this.toggled)
/*  99 */       return;  switch ((String)modeValues.get()) {
/*     */       case "Rise":
/* 101 */         InGameBlurUtil.toBlurBuffer.func_147610_a(false);
/* 102 */         InGameBlurUtil.setupBuffers();
/*     */         
/* 104 */         InGameBlurUtil.renderGaussianBlur(((Integer)radius.getValue()).floatValue(), 2.0F, true, false);
/* 105 */         mc.getFramebuffer().bindFramebuffer(false);
/*     */         break;
/*     */       case "New":
/* 108 */         StencilUtil.initStencilToWrite();
/* 109 */         Retreat.eventManager.callEvent((Event)new ShaderEvent());
/*     */         
/* 111 */         stuffToBlur(false);
/* 112 */         stuffToBlur2(false);
/* 113 */         this.bloomFramebuffer.func_147609_e();
/* 114 */         StencilUtil.readStencilBuffer(1);
/* 115 */         GaussianBlur.renderBlur(((Integer)radius.getValue()).floatValue());
/* 116 */         StencilUtil.uninitStencilBuffer();
/*     */         break;
/*     */       case "Tenacity":
/* 119 */         this.bloomFramebuffer = RenderUtils.TcreateFrameBuffer(this.bloomFramebuffer);
/* 120 */         this.bloomFramebuffer.func_147614_f();
/* 121 */         this.bloomFramebuffer.func_147610_a(false);
/* 122 */         Retreat.eventManager.callEvent((Event)new ShaderEvent());
/* 123 */         stuffToBlur2(false);
/* 124 */         stuffToBlur(false);
/* 125 */         this.bloomFramebuffer.func_147609_e();
/* 126 */         KawaseBlur.renderBlur(this.bloomFramebuffer.field_147617_g, ((Integer)iterations.getValue()).intValue(), ((Integer)offset.getValue()).intValue());
/*     */         break;
/*     */       case "TenacityGlow":
/* 129 */         this.bloomFramebuffer = RenderUtils.TcreateFrameBuffer(this.bloomFramebuffer);
/* 130 */         this.bloomFramebuffer.func_147614_f();
/* 131 */         this.bloomFramebuffer.func_147610_a(false);
/* 132 */         Retreat.eventManager.callEvent((Event)new ShaderEvent());
/* 133 */         stuffToBlur2(false);
/* 134 */         stuffToBlur(false);
/* 135 */         this.bloomFramebuffer.func_147609_e();
/* 136 */         KawaseBlur.renderBlur2(this.bloomFramebuffer.field_147617_g, ((Integer)iterations.getValue()).intValue(), ((Integer)offset.getValue()).intValue());
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 142 */     switch ((String)mode.get()) {
/*     */       case "New":
/* 144 */         this.bloomFramebuffer = RenderUtils.createFrameBuffer(this.bloomFramebuffer);
/* 145 */         this.bloomFramebuffer.func_147614_f();
/* 146 */         this.bloomFramebuffer.func_147610_a(true);
/* 147 */         Retreat.eventManager.callEvent((Event)new ShaderEvent());
/* 148 */         this.bloomFramebuffer.func_147609_e();
/* 149 */         BloomUtil.renderBlur(this.bloomFramebuffer.field_147617_g, ((Integer)this.shadowRadius.get()).intValue(), ((Integer)this.shadowOffset.get()).intValue());
/*     */         break;
/*     */       case "Tenacity":
/* 152 */         this.bloomFramebuffer = RenderUtils.TcreateFrameBuffer(this.bloomFramebuffer);
/* 153 */         this.bloomFramebuffer.func_147614_f();
/* 154 */         this.bloomFramebuffer.func_147610_a(false);
/* 155 */         Retreat.eventManager.callEvent((Event)new ShaderEvent());
/* 156 */         stuffToBlur(true);
/* 157 */         this.bloomFramebuffer.func_147609_e();
/* 158 */         KawaseBloom.renderBlur(this.bloomFramebuffer.field_147617_g, ((Integer)this.shadowRadius2.getValue()).intValue(), ((Integer)this.tshadowOffset.getValue()).intValue());
/*     */         break;
/*     */       case "TenacityGlow":
/* 161 */         this.bloomFramebuffer = RenderUtils.TcreateFrameBuffer(this.bloomFramebuffer);
/* 162 */         this.bloomFramebuffer.func_147614_f();
/* 163 */         this.bloomFramebuffer.func_147610_a(false);
/* 164 */         Retreat.eventManager.callEvent((Event)new ShaderEvent());
/* 165 */         stuffToBlur(true);
/* 166 */         this.bloomFramebuffer.func_147609_e();
/* 167 */         KawaseBloom.renderBlur2(this.bloomFramebuffer.field_147617_g, ((Integer)this.shadowRadius2.getValue()).intValue(), ((Integer)this.tshadowOffset.getValue()).intValue());
/*     */         break;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\BlurSettings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */