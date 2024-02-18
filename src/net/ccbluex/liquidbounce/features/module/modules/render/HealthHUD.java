/*     */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IScaledResolution;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.Render2DEvent;
/*     */ import net.ccbluex.liquidbounce.event.ShaderEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ModuleInfo(name = "HealthHUD", description = "血量显示", category = ModuleCategory.RENDER)
/*     */ public class HealthHUD
/*     */   extends Module
/*     */ {
/*  32 */   private IntegerValue colorRedValue = new IntegerValue("R", 255, 0, 255);
/*  33 */   private IntegerValue colorGreenValue = new IntegerValue("G", 255, 0, 255);
/*  34 */   private IntegerValue colorBlueValue = new IntegerValue("B", 255, 0, 255);
/*  35 */   private BoolValue cColorValue = new BoolValue("CustomColor", false);
/*  36 */   private BoolValue cFontValue = new BoolValue("CustomFont", false);
/*  37 */   private BoolValue showTargetValue = new BoolValue("ShowTarget", true);
/*     */   
/*  39 */   private BoolValue showhealthValue = new BoolValue("ShowHealth", true);
/*     */   
/*  41 */   private BoolValue showvnhealthValue = new BoolValue("ShowVanillaHealth", true);
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public void onShader(ShaderEvent event) {}
/*     */   
/*     */   @EventTarget
/*     */   public void onRender2D(Render2DEvent event) {
/*  49 */     KillAura killAura = (KillAura)Retreat.moduleManager.getModule(KillAura.class);
/*  50 */     IEntityLivingBase currentTarget = killAura.getCurrentTarget();
/*     */     
/*  52 */     if (((Boolean)this.showvnhealthValue.get()).booleanValue()) {
/*  53 */       ScaledResolution sr2 = new ScaledResolution(mc2);
/*  54 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  55 */       mc.getTextureManager().bindTexture2(new ResourceLocation("textures/gui/icons.png"));
/*  56 */       int i2 = 0;
/*  57 */       int i3 = 0;
/*  58 */       while (i2 < mc.getThePlayer().getMaxHealth() / 2.0F) {
/*  59 */         mc2.field_71456_v.func_73729_b((int)((sr2.func_78326_a() / 2) - mc.getThePlayer().getMaxHealth() / 2.0F * 10.0F / 2.0F + (i2 * 10)), sr2.func_78328_b() / 2 - 20, 16, 0, 9, 9);
/*  60 */         i2++;
/*     */       } 
/*  62 */       i2 = 0;
/*  63 */       while (i2 < mc.getThePlayer().getHealth() / 2.0D) {
/*  64 */         mc2.field_71456_v.func_73729_b((int)((sr2.func_78326_a() / 2) - mc.getThePlayer().getMaxHealth() / 2.0F * 10.0F / 2.0F + (i2 * 10)), sr2.func_78328_b() / 2 - 20, 52, 0, 9, 9);
/*  65 */         i2++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  70 */     if (((Boolean)this.showTargetValue.get()).booleanValue()) {
/*  71 */       ScaledResolution sr2 = new ScaledResolution(mc2);
/*  72 */       if (currentTarget != null) {
/*  73 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  74 */         Fonts.font35.drawStringWithShadow(currentTarget.getName(), sr2.func_78326_a() / 2 - Fonts.font35.getStringWidth(currentTarget.getName()) / 2, sr2.func_78328_b() / 2 - 40, 16777215);
/*  75 */         mc.getTextureManager().bindTexture2(new ResourceLocation("textures/gui/icons.png"));
/*  76 */         int i2 = 0;
/*  77 */         int i3 = 0;
/*  78 */         while (i2 < currentTarget.getMaxHealth() / 2.0F) {
/*  79 */           mc2.field_71456_v.func_73729_b((int)((sr2.func_78326_a() / 2) - currentTarget.getMaxHealth() / 2.0F * 10.0F / 2.0F + (i2 * 10)), sr2.func_78328_b() / 2 - 20, 16, 0, 9, 9);
/*  80 */           i2++;
/*     */         } 
/*  82 */         i2 = 0;
/*  83 */         while (i2 < currentTarget.getHealth() / 2.0D) {
/*  84 */           mc2.field_71456_v.func_73729_b((int)((sr2.func_78326_a() / 2) - currentTarget.getMaxHealth() / 2.0F * 10.0F / 2.0F + (i2 * 10)), sr2.func_78328_b() / 2 - 20, 52, 0, 9, 9);
/*  85 */           i2++;
/*     */         } 
/*  87 */         while (i3 < 10.0F) {
/*  88 */           mc2.field_71456_v.func_73729_b((int)((sr2.func_78326_a() / 2) - currentTarget.getMaxHealth() / 2.0F * 10.0F / 2.0F + (i3 * 10)), sr2.func_78328_b() / 2 - 30, 16, 9, 9, 9);
/*  89 */           i3++;
/*     */         } 
/*  91 */         i3 = 0;
/*  92 */         while (i3 < currentTarget.getTotalArmorValue() / 2.0F) {
/*  93 */           mc2.field_71456_v.func_73729_b((int)((sr2.func_78326_a() / 2) - currentTarget.getMaxHealth() / 2.0F * 10.0F / 2.0F + (i3 * 10)), sr2.func_78328_b() / 2 - 30, 34, 9, 9, 9);
/*  94 */           i3++;
/*     */         } 
/*     */       } 
/*     */     } 
/*  98 */     if (((Boolean)this.showhealthValue.get()).booleanValue()) {
/*  99 */       IScaledResolution sr = classProvider.createScaledResolution(mc);
/* 100 */       float healthNum = (float)Math.round(mc.getThePlayer().getHealth() * 10.0D / 10.0D);
/* 101 */       float abNum = (float)Math.round((Minecraft.func_71410_x()).field_71439_g.func_110139_bj() * 10.0D / 10.0D);
/*     */ 
/*     */ 
/*     */       
/* 105 */       String abString = ((Boolean)this.cFontValue.get()).booleanValue() ? ("§e" + abNum + "§r") : ("§e" + abNum + "§e❤");
/*     */ 
/*     */ 
/*     */       
/* 109 */       if ((Minecraft.func_71410_x()).field_71439_g.func_110139_bj() <= 0.0F) {
/* 110 */         abString = "";
/*     */       }
/*     */       
/* 113 */       String text = ((Boolean)this.cFontValue.get()).booleanValue() ? (healthNum + "§r " + abString + "") : (healthNum + "§c❤ " + abString + "");
/*     */ 
/*     */ 
/*     */       
/* 117 */       int c = ((Boolean)this.cColorValue.get()).booleanValue() ? (new Color(((Integer)this.colorRedValue.get()).intValue(), ((Integer)this.colorGreenValue.get()).intValue(), ((Integer)this.colorBlueValue.get()).intValue())).getRGB() : ColorUtils.INSTANCE.getHealthColor(mc.getThePlayer().getHealth(), mc.getThePlayer().getMaxHealth());
/*     */       
/* 119 */       if (((Boolean)this.cFontValue.get()).booleanValue()) {
/* 120 */         Fonts.sfbold35.drawCenteredString(text, (sr.getScaledWidth() / 2), (sr.getScaledHeight() / 2 - 25), c, true);
/*     */       } else {
/*     */         
/* 123 */         mc.getFontRendererObj().drawCenteredString(text, (sr.getScaledWidth() / 2), (sr.getScaledHeight() / 2 - 25), c, true);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\HealthHUD.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */