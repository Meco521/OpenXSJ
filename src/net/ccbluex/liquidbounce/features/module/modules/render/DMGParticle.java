/*     */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.combat.Criticals;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.DMGPUtil.Location;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.DMGPUtil.Particles;
/*     */ import net.ccbluex.liquidbounce.injection.backend.EntityLivingBaseImplKt;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ModuleInfo(name = "DMGParticle", description = "Display heatlh volume change value", category = ModuleCategory.RENDER)
/*     */ public class DMGParticle
/*     */   extends Module
/*     */ {
/*  29 */   private HashMap<EntityLivingBase, Float> healthMap = new HashMap<>();
/*  30 */   private List<Particles> particles = new ArrayList<>();
/*     */   
/*     */   @EventTarget
/*     */   public void onUpdate(UpdateEvent event) {
/*  34 */     KillAura ka = (KillAura)Retreat.moduleManager.getModule(KillAura.class);
/*     */     
/*  36 */     int i1 = 0;
/*  37 */     while (i1 < this.particles.size()) {
/*  38 */       Particles update = this.particles.get(i1);
/*  39 */       int i = ++update.ticks;
/*  40 */       if (i < 10) {
/*  41 */         update.location.setY(update.location.getY() + update.ticks * 0.002D);
/*     */       }
/*  43 */       if (i > 20) {
/*  44 */         this.particles.remove(update);
/*     */       }
/*  46 */       i1++;
/*     */     } 
/*     */     
/*  49 */     EntityLivingBase entity = (ka.getTarget() == null) ? null : EntityLivingBaseImplKt.unwrap(ka.getTarget());
/*  50 */     if (entity == null || entity == mc.getThePlayer()) {
/*     */       return;
/*     */     }
/*     */     
/*  54 */     if (!this.healthMap.containsKey(entity)) {
/*  55 */       this.healthMap.put(entity, Float.valueOf(entity.func_110143_aJ()));
/*     */     }
/*     */     
/*  58 */     float floatValue = ((Float)this.healthMap.get(entity)).floatValue();
/*  59 */     float health = entity.func_110143_aJ();
/*  60 */     Criticals criticals = (Criticals)Retreat.moduleManager.get(Criticals.class);
/*     */     
/*  62 */     if (floatValue != health) {
/*     */       String text;
/*     */       
/*  65 */       if (floatValue - health < 0.0F) {
/*  66 */         text = "§a" + roundToPlace(((floatValue - health) * -1.0F), 1);
/*     */       } else {
/*  68 */         text = "§e" + roundToPlace((floatValue - health), 1);
/*     */       } 
/*     */       
/*  71 */       Location location = new Location(entity);
/*  72 */       location.setY((entity.func_174813_aQ()).field_72338_b + ((entity.func_174813_aQ()).field_72337_e - (entity.func_174813_aQ()).field_72338_b) / 2.0D);
/*  73 */       location.setX(location.getX() - 0.5D + (new Random(System.currentTimeMillis())).nextInt(5) * 0.15D);
/*  74 */       location.setZ(location.getZ() - 0.5D + (new Random(System.currentTimeMillis() + 1L)).nextInt(5) * 0.15D);
/*  75 */       this.particles.add(new Particles(location, text));
/*  76 */       this.healthMap.remove(entity);
/*  77 */       this.healthMap.put(entity, Float.valueOf(entity.func_110143_aJ()));
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public void onRender(Render3DEvent event) {
/*  83 */     for (Particles p : this.particles) {
/*  84 */       double x = p.location.getX();
/*  85 */       mc.getRenderManager();
/*  86 */       double n = x - mc.getRenderManager().getRenderPosX();
/*  87 */       double y = p.location.getY();
/*  88 */       mc.getRenderManager();
/*  89 */       double n2 = y - mc.getRenderManager().getRenderPosY();
/*  90 */       double z = p.location.getZ();
/*  91 */       mc.getRenderManager();
/*  92 */       double n3 = z - mc.getRenderManager().getRenderPosZ();
/*  93 */       GlStateManager.func_179094_E();
/*  94 */       GlStateManager.func_179088_q();
/*  95 */       GlStateManager.func_179136_a(1.0F, -1500000.0F);
/*  96 */       GlStateManager.func_179109_b((float)n, (float)n2, (float)n3);
/*  97 */       GlStateManager.func_179114_b(-mc.getRenderManager().getPlayerViewY(), 0.0F, 1.0F, 0.0F);
/*     */ 
/*     */       
/* 100 */       float textY = 1.0F;
/*     */       
/* 102 */       GlStateManager.func_179114_b(mc.getRenderManager().getPlayerViewX(), textY, 0.0F, 0.0F);
/* 103 */       double size = 0.025D;
/* 104 */       GlStateManager.func_179139_a(-0.025D, -0.025D, 0.025D);
/* 105 */       enableGL2D();
/* 106 */       disableGL2D();
/* 107 */       GL11.glDepthMask(false);
/* 108 */       mc.getFontRendererObj().drawString(p.text, -(mc.getFontRendererObj().getStringWidth(p.text) / 2), -(mc.getFontRendererObj().getFontHeight() - 1), 0, true);
/* 109 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 110 */       GL11.glDepthMask(true);
/* 111 */       GlStateManager.func_179136_a(1.0F, 1500000.0F);
/* 112 */       GlStateManager.func_179113_r();
/* 113 */       GlStateManager.func_179121_F();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void enableGL2D() {
/* 118 */     GL11.glDisable(2929);
/* 119 */     GL11.glEnable(3042);
/* 120 */     GL11.glDisable(3553);
/* 121 */     GL11.glBlendFunc(770, 771);
/* 122 */     GL11.glDepthMask(true);
/* 123 */     GL11.glEnable(2848);
/* 124 */     GL11.glHint(3154, 4354);
/* 125 */     GL11.glHint(3155, 4354);
/*     */   }
/*     */   
/*     */   public static void disableGL2D() {
/* 129 */     GL11.glEnable(3553);
/* 130 */     GL11.glDisable(3042);
/* 131 */     GL11.glEnable(2929);
/* 132 */     GL11.glDisable(2848);
/* 133 */     GL11.glHint(3154, 4352);
/* 134 */     GL11.glHint(3155, 4352);
/*     */   }
/*     */   
/*     */   public static double roundToPlace(double p_roundToPlace_0_, int p_roundToPlace_2_) {
/* 138 */     if (p_roundToPlace_2_ < 0) {
/* 139 */       throw new IllegalArgumentException();
/*     */     }
/* 141 */     return (new BigDecimal(p_roundToPlace_0_)).setScale(p_roundToPlace_2_, RoundingMode.HALF_UP).doubleValue();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\DMGParticle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */