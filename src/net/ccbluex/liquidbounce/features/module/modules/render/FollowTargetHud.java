/*     */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*     */ import java.awt.Color;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IFontRenderer;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ModuleInfo(name = "FollowTargetHud", description = "Follow Target HUD", category = ModuleCategory.RENDER)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000Z\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\003\n\002\020\007\n\002\b\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\025\032\0020\0042\006\020\026\032\0020\027H\002J\020\020\030\032\0020\0312\006\020\032\032\0020\033H\007J\030\020\034\032\0020\0312\006\020\026\032\0020\0352\006\020\036\032\0020\004H\002R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\t\032\0020\nX\004¢\006\002\n\000R\016\020\013\032\0020\fX\004¢\006\002\n\000R\016\020\r\032\0020\016X\004¢\006\002\n\000R\016\020\017\032\0020\020X\016¢\006\002\n\000R\016\020\021\032\0020\016X\004¢\006\002\n\000R\016\020\022\032\0020\016X\004¢\006\002\n\000R\016\020\023\032\0020\024X\016¢\006\002\n\000¨\006\037"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/FollowTargetHud;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "entityKeep", "", "fontValue", "Lnet/ccbluex/liquidbounce/value/FontValue;", "jelloAlphaValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "jelloColorValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "scaleValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "targetTicks", "", "translateX", "translateY", "xChange", "", "getPlayerName", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "onRender3D", "", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "renderNameTag", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "tag", "XSJClient"})
/*     */ public final class FollowTargetHud extends Module {
/*     */   private final ListValue modeValue;
/*     */   private final FontValue fontValue;
/*     */   private final BoolValue jelloColorValue;
/*     */   private final IntegerValue jelloAlphaValue;
/*     */   private final FloatValue scaleValue;
/*     */   private final FloatValue translateY;
/*     */   private final FloatValue translateX;
/*     */   private float xChange;
/*     */   private int targetTicks;
/*     */   private String entityKeep;
/*     */   
/*     */   public FollowTargetHud() {
/*  28 */     this.modeValue = new ListValue("Mode", new String[] { "Juul", "Jello", "Material", "Arris", "FDP" }, "Juul");
/*  29 */     Intrinsics.checkExpressionValueIsNotNull(Fonts.com30, "Fonts.com30"); this.fontValue = new FontValue("Font", Fonts.com30);
/*  30 */     this.jelloColorValue = new BoolValue("JelloHPColor", true);
/*  31 */     this.jelloAlphaValue = new IntegerValue("JelloAlpha", 170, 0, 255);
/*  32 */     this.scaleValue = new FloatValue("Scale", 1.0F, 1.0F, 4.0F);
/*  33 */     this.translateY = new FloatValue("TanslateY", 0.55F, -2.0F, 2.0F);
/*  34 */     this.translateX = new FloatValue("TranslateX", 0.0F, -2.0F, 2.0F);
/*  35 */     this.xChange = ((Number)this.translateX.get()).floatValue() * 20;
/*     */ 
/*     */     
/*  38 */     this.entityKeep = "yes";
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onRender3D(@NotNull Render3DEvent event) {
/*  43 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() == null)
/*     */       return; 
/*  45 */     if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  for (IEntity entity : MinecraftInstance.mc.getTheWorld().getLoadedEntityList()) {
/*  46 */       if (EntityUtils.isSelected(entity, false)) {
/*  47 */         if (entity.getDisplayName() != null) { renderNameTag(entity.asEntityLivingBase(), entity.getDisplayName().getUnformattedText()); continue; }  entity.getDisplayName(); entity.asEntityLivingBase(); this;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private final String getPlayerName(EntityLivingBase entity) {
/*  53 */     Intrinsics.checkExpressionValueIsNotNull(entity.func_145748_c_(), "entity.displayName"); String name = entity.func_145748_c_().func_150254_d();
/*  54 */     Intrinsics.checkExpressionValueIsNotNull(name, "name"); return name;
/*     */   }
/*     */   
/*     */   private final void renderNameTag(IEntityLivingBase entity, String tag) {
/*  58 */     this.xChange = ((Number)this.translateX.get()).floatValue() * 20;
/*     */     
/*  60 */     if (Retreat.INSTANCE.getModuleManager().getModule(KillAura.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura");  KillAura killAura = (KillAura)Retreat.INSTANCE.getModuleManager().getModule(KillAura.class);
/*  61 */     if ((Intrinsics.areEqual(entity, killAura.getTarget()) ^ true) != 0)
/*     */       return; 
/*  63 */     if (Intrinsics.areEqual(entity, killAura.getTarget())) {
/*  64 */       this.entityKeep = String.valueOf(entity.getName()); int i;
/*  65 */       this.targetTicks = (i = this.targetTicks) + 1;
/*  66 */       if (this.targetTicks >= 5) {
/*  67 */         this.targetTicks = 4;
/*     */       }
/*  69 */     } else if (killAura.getTarget() == null) {
/*  70 */       int i; this.targetTicks = (i = this.targetTicks) + -1;
/*  71 */       if (this.targetTicks <= -1) {
/*  72 */         this.targetTicks = 0;
/*  73 */         this.entityKeep = "dg636 top";
/*     */       } 
/*     */     } 
/*     */     
/*  77 */     if (this.targetTicks == 0) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  82 */     IFontRenderer fontRenderer = (IFontRenderer)this.fontValue.get();
/*  83 */     IFontRenderer font = Fonts.com30;
/*     */ 
/*     */     
/*  86 */     GL11.glPushMatrix();
/*     */ 
/*     */     
/*  89 */     IRenderManager renderManager = MinecraftInstance.mc.getRenderManager();
/*  90 */     ITimer timer = MinecraftInstance.mc.getTimer();
/*     */     
/*  92 */     GL11.glTranslated(
/*  93 */         entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * timer.getRenderPartialTicks() - renderManager.getRenderPosX(), 
/*  94 */         entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * timer.getRenderPartialTicks() - renderManager.getRenderPosY() + entity.getEyeHeight() + ((Number)this.translateY.get()).floatValue(), 
/*  95 */         entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * timer.getRenderPartialTicks() - renderManager.getRenderPosZ());
/*     */ 
/*     */ 
/*     */     
/*  99 */     GL11.glRotatef(-MinecraftInstance.mc.getRenderManager().getPlayerViewY(), 0.0F, 1.0F, 0.0F);
/* 100 */     GL11.glRotatef(MinecraftInstance.mc.getRenderManager().getPlayerViewX(), 1.0F, 0.0F, 0.0F);
/*     */ 
/*     */     
/* 103 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  float distance = MinecraftInstance.mc.getThePlayer().getDistanceToEntity((IEntity)entity) / 4.0F;
/*     */     
/* 105 */     if (distance < 1.0F) {
/* 106 */       distance = 1.0F;
/*     */     }
/*     */     
/* 109 */     float scale = distance / 150.0F * ((Number)this.scaleValue.get()).floatValue();
/*     */ 
/*     */     
/* 112 */     RenderUtils.disableGlCap(new int[] { 2896, 2929 });
/*     */ 
/*     */     
/* 115 */     RenderUtils.enableGlCap(3042);
/* 116 */     GL11.glBlendFunc(770, 771);
/*     */     
/* 118 */     if (entity.getDisplayName() == null) Intrinsics.throwNpe();  String name = entity.getDisplayName().getUnformattedText();
/* 119 */     float healthPercent = entity.getHealth() / entity.getMaxHealth();
/*     */     
/* 121 */     if (healthPercent > true) {
/* 122 */       healthPercent = 1.0F;
/*     */     }
/*     */ 
/*     */     
/* 126 */     String str1 = (String)this.modeValue.get(); boolean bool = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str1 = str1.toLowerCase(); switch (str1.hashCode())
/*     */     
/*     */     { 
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
/*     */       case 101009364:
/* 201 */         if (str1.equals("jello"))
/*     */         
/* 203 */         { Color color1 = new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue(), ((Number)this.jelloAlphaValue.get()).intValue());
/* 204 */           if (entity.getDisplayName() == null) Intrinsics.throwNpe();  String str = entity.getDisplayName().getUnformattedText();
/* 205 */           if (((Boolean)this.jelloColorValue.get()).booleanValue() && StringsKt.startsWith$default(str, "§", false, 2, null)) {
/* 206 */             String str2 = str; boolean bool1 = true; byte b = 2; ColorUtils colorUtils = ColorUtils.INSTANCE; boolean bool2 = false; if (str2 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str2.substring(bool1, b), "(this as java.lang.Strin…ing(startIndex, endIndex)"); String str3 = str2.substring(bool1, b); color1 = colorUtils.colorCode(str3, ((Number)this.jelloAlphaValue.get()).intValue());
/*     */           } 
/* 208 */           Color bgColor = new Color(50, 50, 50, ((Number)this.jelloAlphaValue.get()).intValue());
/* 209 */           int width = fontRenderer.getStringWidth(tag);
/* 210 */           float maxWidth = width + 4.0F - -width - 4.0F;
/* 211 */           float f1 = entity.getHealth() / entity.getMaxHealth();
/*     */ 
/*     */           
/* 214 */           GL11.glScalef(-scale * 2, -scale * 2, scale * 2);
/* 215 */           RenderUtils.drawRect(this.xChange, -fontRenderer.getFontHeight() * 3.0F, width + 8.0F + this.xChange, -3.0F, bgColor);
/*     */ 
/*     */           
/* 218 */           if (f1 > true) {
/* 219 */             f1 = 1.0F;
/*     */           }
/*     */           
/* 222 */           RenderUtils.drawRect(this.xChange, -3.0F, maxWidth * f1 + this.xChange, 1.0F, color1);
/* 223 */           RenderUtils.drawRect(maxWidth * f1 + this.xChange, -3.0F, width + 8.0F + this.xChange, 1.0F, bgColor);
/*     */ 
/*     */           
/* 226 */           Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawString(tag, 4 + (int)this.xChange, -fontRenderer.getFontHeight() * 2 - 4, Color.WHITE.getRGB());
/* 227 */           GL11.glScalef(0.5F, 0.5F, 0.5F);
/* 228 */           fontRenderer.drawString("Health: " + (int)entity.getHealth(), 4 + (int)this.xChange, -fontRenderer.getFontHeight() * 2, (new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue(), 255)).getRGB()); }  break;case 3274018: if (str1.equals("juul")) { GL11.glScalef(-scale * 2, -scale * 2, scale * 2); RenderUtils.drawRoundedCornerRect(-120.0F + this.xChange, -16.0F, -50.0F + this.xChange, 10.0F, 5.0F, (new Color(64, 64, 64, 255)).getRGB()); RenderUtils.drawRoundedCornerRect(-110.0F + this.xChange, 0.0F, -20.0F + this.xChange, 35.0F, 5.0F, (new Color(96, 96, 96, 255)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawString("Attacking", -105 + (int)this.xChange, -13, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawString(tag, -106 + (int)this.xChange, 10, Color.WHITE.getRGB()); String healthString = String.valueOf((int)(entity.getHealth() * 10.0F) * 0.1F) + " / 20"; Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawString(healthString, -25 - fontRenderer.getStringWidth(healthString) + (int)this.xChange, 22, Color.WHITE.getRGB()); if (MinecraftInstance.mc.getThePlayer() == null)
/*     */             Intrinsics.throwNpe();  String distanceString = "⤢" + String.valueOf((int)(MinecraftInstance.mc.getThePlayer().getDistanceToEntity((IEntity)entity) * 10.0F) * 0.1F); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawString(distanceString, -25 - fontRenderer.getStringWidth(distanceString) + (int)this.xChange, 10, Color.WHITE.getRGB()); RenderUtils.drawRoundedCornerRect(-104.0F + this.xChange, 22.0F, -50.0F + this.xChange, 30.0F, 1.0F, (new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue(), 255)).getRGB()); RenderUtils.drawRoundedCornerRect(-104.0F + this.xChange, 22.0F, -104.0F + healthPercent * 54 + this.xChange, 30.0F, 1.0F, (new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), 255)).getRGB()); }  break;
/*     */       case 69458: if (str1.equals("FDP")) { GL11.glScalef(-scale * 2, -scale * 2, scale * 2); RenderUtils.drawRoundedCornerRect(-70.0F, 0.0F, 70.0F, 40.0F, 5.0F, (new Color(0, 0, 0, 95)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawString(name, -30 + (int)this.xChange, 5, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); fontRenderer.drawString("Health " + (int)entity.getHealth(), -30 + (int)this.xChange, 5 + font.getFontHeight(), Color.WHITE.getRGB()); RenderUtils.drawRoundedCornerRect(-30.0F + this.xChange, (5 + font.getFontHeight() * 2), -30.0F + this.xChange + healthPercent * 95.0F, 37.0F, 3.0F, ColorUtils.rainbow().getRGB()); }  break;
/*     */       case 299066663: if (str1.equals("material")) { GL11.glScalef(-scale * 2, -scale * 2, scale * 2); RenderUtils.drawRoundedCornerRect(-40.0F + this.xChange, 0.0F, 40.0F + this.xChange, 30.0F, 5.0F, (new Color(72, 72, 72, 220)).getRGB()); RenderUtils.drawRoundedCornerRect(-35.0F + this.xChange, 7.0F, -35.0F + healthPercent * 70 + this.xChange, 12.0F, 2.0F, (new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue())).getRGB()); }  break;
/* 232 */       case 93090635: if (str1.equals("arris")) { GL11.glScalef(-scale * 2, -scale * 2, scale * 2); float f1 = healthPercent; int additionalWidth = RangesKt.coerceAtLeast(font.getStringWidth(entity.getName() + "  " + f1 + " hp"), 75); RenderUtils.drawRoundedCornerRect(this.xChange, 0.0F, 45.0F + additionalWidth + this.xChange, 40.0F, 7.0F, (new Color(0, 0, 0, 110)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); font.drawString(String.valueOf(entity.getName()), 40 + (int)this.xChange, 5, Color.WHITE.getRGB()); String str2 = f1 + " hp"; boolean bool1 = false, bool2 = false; String str3 = str2; int $i$a$-also-FollowTargetHud$renderNameTag$1 = 0; Intrinsics.checkExpressionValueIsNotNull(Color.LIGHT_GRAY, "Color.LIGHT_GRAY"); font.drawString(str3, 40 + additionalWidth - font.getStringWidth(str3) + (int)this.xChange, 5, Color.LIGHT_GRAY.getRGB()); float f2 = (5 + font.getFontHeight()) + 3.0F; RenderUtils.drawRect(40.0F + this.xChange, f2, 40 + this.xChange + healthPercent * additionalWidth, f2 + 4, (new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue())).getRGB()); }  break; }  RenderUtils.resetCaps();
/*     */ 
/*     */     
/* 235 */     GlStateManager.func_179117_G();
/* 236 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */ 
/*     */     
/* 239 */     GL11.glPopMatrix();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\FollowTargetHud.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */