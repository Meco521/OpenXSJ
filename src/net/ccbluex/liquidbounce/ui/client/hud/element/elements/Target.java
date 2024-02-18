/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ import java.awt.Color;
/*     */ import kotlin.Unit;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.network.INetworkPlayerInfo;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ElementInfo(name = "Target")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000L\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\t\n\000\n\002\020\007\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\002\b\b\n\002\020\002\n\002\b\003\n\002\030\002\n\002\b\004\b\007\030\0002\0020\001B\005¢\006\002\020\002J\030\020\034\032\0020\0352\006\020\036\032\0020\0242\006\020\037\032\0020\rH\002J\n\020 \032\004\030\0010!H\026J\022\020\"\032\0020\r2\b\020#\032\004\030\0010\024H\002J\n\020$\032\004\030\0010!H\002R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\t\032\0020\006X\004¢\006\002\n\000R\016\020\n\032\0020\013X\016¢\006\002\n\000R\016\020\f\032\0020\rX\016¢\006\002\n\000R\016\020\016\032\0020\rX\016¢\006\002\n\000R\016\020\017\032\0020\rX\016¢\006\002\n\000R\016\020\020\032\0020\013X\016¢\006\002\n\000R\016\020\021\032\0020\022X\004¢\006\002\n\000R\020\020\023\032\004\030\0010\024X\016¢\006\002\n\000R\016\020\025\032\0020\004X\004¢\006\002\n\000R\016\020\026\032\0020\022X\004¢\006\002\n\000R\016\020\027\032\0020\004X\004¢\006\002\n\000R\021\020\030\032\0020\b¢\006\b\n\000\032\004\b\031\020\032R\016\020\033\032\0020\006X\004¢\006\002\n\000¨\006%"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Target;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "()V", "BlurStrength", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "animSpeedValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "bV", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "bgValue", "changeTime", "", "displayPercent", "", "lastChangeHealth", "lastHealth", "lastUpdate", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "prevTarget", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "radiusValue", "shadowColorMode", "shadowValue", "shadowValueopen", "getShadowValueopen", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "switchAnimSpeedValue", "distance", "", "target", "easingHealth", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "getHealth", "entity", "getTBorder", "XSJClient"})
/*     */ public final class Target extends Element {
/*     */   public Target() {
/*  20 */     super(-46.0D, -40.0D, 1.0F, new Side(Side.Horizontal.MIDDLE, Side.Vertical.MIDDLE));
/*  21 */     this.bV = new BoolValue("Blur", true);
/*  22 */     this.BlurStrength = new FloatValue("BlurStrength", 5.0F, 0.0F, 20.0F);
/*  23 */     this.shadowValueopen = new BoolValue("shadow", true);
/*  24 */     this.shadowValue = new FloatValue("shadow-Value", 10.0F, 0.0F, 20.0F);
/*  25 */     this.shadowColorMode = new ListValue("Shadow-Color", new String[] { "Background", "Custom" }, "Background");
/*  26 */     this.bgValue = new IntegerValue("Background-Alpha", 120, 0, 255);
/*  27 */     this.radiusValue = new FloatValue("Radius", 4.25F, 0.0F, 10.0F);
/*  28 */     this.modeValue = new ListValue("Mode", new String[] { "distance" }, "novo");
/*  29 */     this.animSpeedValue = new IntegerValue("AnimSpeed", 10, 5, 20);
/*  30 */     this.switchAnimSpeedValue = new IntegerValue("SwitchAnimSpeed", 8, 5, 40);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  35 */     this.lastHealth = 20.0F;
/*  36 */     this.lastChangeHealth = 20.0F;
/*  37 */     this.changeTime = System.currentTimeMillis();
/*     */     
/*  39 */     this.lastUpdate = System.currentTimeMillis();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final BoolValue bV;
/*     */ 
/*     */ 
/*     */   
/*     */   private final FloatValue BlurStrength;
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   private final BoolValue shadowValueopen;
/*     */ 
/*     */   
/*     */   private final FloatValue shadowValue;
/*     */ 
/*     */   
/*     */   private final ListValue shadowColorMode;
/*     */ 
/*     */   
/*     */   private final IntegerValue bgValue;
/*     */ 
/*     */   
/*     */   private final FloatValue radiusValue;
/*     */ 
/*     */   
/*     */   private final ListValue modeValue;
/*     */ 
/*     */   
/*     */   private final IntegerValue animSpeedValue;
/*     */ 
/*     */   
/*     */   private final IntegerValue switchAnimSpeedValue;
/*     */ 
/*     */   
/*     */   private IEntityLivingBase prevTarget;
/*     */ 
/*     */   
/*     */   private float lastHealth;
/*     */ 
/*     */   
/*     */   private float lastChangeHealth;
/*     */ 
/*     */   
/*     */   private long changeTime;
/*     */ 
/*     */   
/*     */   private float displayPercent;
/*     */ 
/*     */   
/*     */   private long lastUpdate;
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class Target$distance$1
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 103 */       GL11.glPushMatrix();
/* 104 */       GL11.glTranslated(Target.this.getRenderX(), Target.this.getRenderY(), 0.0D);
/* 105 */       GL11.glScalef(Target.this.getScale(), Target.this.getScale(), Target.this.getScale());
/*     */       
/* 107 */       RenderUtils.originalRoundedRect(
/* 108 */           0.0F, 0.0F, 150.0F, 30.0F, ((Number)Target.this.radiusValue.get()).floatValue(), 
/* 109 */           StringsKt.equals((String)Target.this.shadowColorMode.get(), "background", true) ? (
/* 110 */           new Color(32, 30, 30)).getRGB() : (
/*     */           
/* 112 */           new Color(0, 0, 0)).getRGB());
/*     */       
/* 114 */       GL11.glPopMatrix();
/*     */     } Target$distance$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/* 116 */   static final class Target$distance$2 extends Lambda implements Function0<Unit> { public final void invoke() { GL11.glPushMatrix();
/* 117 */       GL11.glTranslated(Target.this.getRenderX(), Target.this.getRenderY(), 0.0D);
/* 118 */       GL11.glScalef(Target.this.getScale(), Target.this.getScale(), Target.this.getScale());
/* 119 */       GlStateManager.func_179147_l();
/* 120 */       GlStateManager.func_179090_x();
/* 121 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/* 122 */       RenderUtils.fastRoundedRect(0.0F, 0.0F, 150.0F, 30.0F, ((Number)Target.this.radiusValue.get()).floatValue());
/* 123 */       GlStateManager.func_179098_w();
/* 124 */       GlStateManager.func_179084_k();
/* 125 */       GL11.glPopMatrix(); } Target$distance$2() { super(0); } }
/*     */   @NotNull public final BoolValue getShadowValueopen() { return this.shadowValueopen; }
/*     */   private final void distance(IEntityLivingBase target, float easingHealth) { RenderUtils.drawRoundedRect(0.0F, 0.0F, 150.0F, 30.0F, ((Number)this.radiusValue.get()).floatValue(), (new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue())).getRGB()); GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); if (((Boolean)this.shadowValueopen.get()).booleanValue())
/*     */       ShadowUtils.shadow(((Number)this.shadowValue.get()).floatValue(), new Target$distance$1(), new Target$distance$2()); 
/* 129 */     GL11.glPopMatrix();
/* 130 */     GL11.glScalef(getScale(), getScale(), getScale());
/* 131 */     GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */     
/* 133 */     if (((Boolean)this.bV.get()).booleanValue()) {
/* 134 */       GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D);
/* 135 */       GL11.glPushMatrix();
/* 136 */       BlurBuffer.CustomBlurRoundArea(
/* 137 */           (float)getRenderX(), 
/* 138 */           (float)getRenderY(), 
/* 139 */           150.0F, 
/* 140 */           30.0F, (
/* 141 */           (Number)this.radiusValue.get()).floatValue(), ((Number)this.BlurStrength.get()).floatValue());
/*     */       
/* 143 */       GL11.glPopMatrix();
/* 144 */       GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */     } 
/* 146 */     if (target.getName() == null) Intrinsics.throwNpe();  Fonts.productSans35.drawString(target.getName(), 36, 6, -1);
/* 147 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  Fonts.productSans35.drawString("Distance:   " + ChatFormatting.WHITE + Math.round(target.getDistance(MinecraftInstance.mc.getThePlayer().getPosX(), MinecraftInstance.mc.getThePlayer().getPosY(), MinecraftInstance.mc.getThePlayer().getPosZ())) + "m", 36, 18, (new Color(41, 132, 163)).getRGB());
/* 148 */     RenderUtils.drawCircle(123.0F, 15.0F, 10.0F, -90, (int)(270.0F * easingHealth / 20.0F), new Color(41, 132, 163));
/* 149 */     Fonts.productSans35.drawCenteredString(String.valueOf(Math.round(easingHealth)), 123.1F, 12.0F, -1);
/*     */     
/* 151 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  INetworkPlayerInfo playerInfo = MinecraftInstance.mc.getNetHandler().getPlayerInfo(MinecraftInstance.mc.getThePlayer().getUniqueID());
/* 152 */     if (MinecraftInstance.classProvider.isEntityPlayer(target)) {
/* 153 */       playerInfo = MinecraftInstance.mc.getNetHandler().getPlayerInfo(target.getUniqueID());
/*     */     }
/* 155 */     if (playerInfo != null) {
/*     */       
/* 157 */       IResourceLocation locationSkin = playerInfo.getLocationSkin();
/* 158 */       float renderHurtTime = target.getHurtTime() - ((target.getHurtTime() != 0) ? 
/* 159 */         (Minecraft.func_71410_x()).field_71428_T.field_194147_b : 
/*     */         
/* 161 */         0.0F);
/*     */ 
/*     */       
/* 164 */       float hurtPercent = renderHurtTime / 10.0F;
/* 165 */       GL11.glColor4f(1.0F, true - hurtPercent, true - hurtPercent, 1.0F);
/* 166 */       int size = 24;
/*     */       
/* 168 */       GL11.glPushMatrix();
/*     */       
/* 170 */       MinecraftInstance.mc.getTextureManager().bindTexture(locationSkin);
/* 171 */       RenderUtils.drawScaledCustomSizeModalCircle(
/* 172 */           3, 3, 8.0F, 8.0F, 8, 8, size, size, 
/* 173 */           64.0F, 64.0F);
/*     */       
/* 175 */       GL11.glPopMatrix();
/*     */     }  }
/*     */    private final float getHealth(IEntityLivingBase entity) {
/*     */     return (entity == null || entity.isDead()) ? 0.0F : entity.getHealth();
/*     */   } private final Border getTBorder() {
/* 180 */     String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case 288459765:
/* 181 */         if (str.equals("distance")); break; }
/* 182 */      return null;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public Border drawElement() {
/*     */     if (Retreat.INSTANCE.getModuleManager().get(KillAura.class) == null)
/*     */       throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura"); 
/*     */     IEntityLivingBase target = ((KillAura)Retreat.INSTANCE.getModuleManager().get(KillAura.class)).getTarget();
/*     */     long time = System.currentTimeMillis();
/*     */     float pct = (float)(time - this.lastUpdate) / ((Number)this.switchAnimSpeedValue.get()).floatValue() * 50.0F;
/*     */     this.lastUpdate = System.currentTimeMillis();
/*     */     if (MinecraftInstance.classProvider.isGuiHudDesigner(MinecraftInstance.mc.getCurrentScreen()) || MinecraftInstance.classProvider.isGuiChat(MinecraftInstance.mc.getCurrentScreen()))
/*     */       target = (IEntityLivingBase)MinecraftInstance.mc.getThePlayer(); 
/*     */     if (target != null)
/*     */       this.prevTarget = target; 
/*     */     if (this.prevTarget != null) {
/*     */       if (target != null) {
/*     */         if (this.displayPercent < true)
/*     */           this.displayPercent += pct; 
/*     */         if (this.displayPercent > true)
/*     */           this.displayPercent = 1.0F; 
/*     */       } else {
/*     */         if (this.displayPercent > false)
/*     */           this.displayPercent -= pct; 
/*     */         if (this.displayPercent < false) {
/*     */           this.displayPercent = 0.0F;
/*     */           this.prevTarget = (IEntityLivingBase)null;
/*     */           return getTBorder();
/*     */         } 
/*     */       } 
/*     */       if (getHealth(this.prevTarget) != this.lastHealth) {
/*     */         this.lastChangeHealth = this.lastHealth;
/*     */         this.lastHealth = getHealth(this.prevTarget);
/*     */         this.changeTime = time;
/*     */       } 
/*     */       float nowAnimHP = (time - (((Number)this.animSpeedValue.get()).intValue() * 50) < this.changeTime) ? (getHealth(this.prevTarget) + (this.lastChangeHealth - getHealth(this.prevTarget)) * (true - (float)(time - this.changeTime) / ((Number)this.animSpeedValue.get()).floatValue() * 50.0F)) : getHealth(this.prevTarget);
/*     */       String str = (String)this.modeValue.get();
/*     */       boolean bool = false;
/*     */       if (str == null)
/*     */         throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */       Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()");
/*     */       str = str.toLowerCase();
/*     */       switch (str.hashCode()) {
/*     */         case 288459765:
/*     */           if (str.equals("distance")) {
/*     */             if (this.prevTarget == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             distance(this.prevTarget, nowAnimHP);
/*     */           } 
/*     */           break;
/*     */       } 
/*     */       return getTBorder();
/*     */     } 
/*     */     return getTBorder();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\Target.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */