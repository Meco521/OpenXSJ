/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ElementInfo(name = "KeyBinds")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\007\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\006\n\002\030\002\n\000\n\002\020\b\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\n\020\020\032\004\030\0010\021H\026J\006\020\022\032\0020\023R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\016¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\t\032\0020\nX\004¢\006\002\n\000R\021\020\013\032\0020\b¢\006\b\n\000\032\004\b\f\020\rR\016\020\016\032\0020\004X\004¢\006\002\n\000R\016\020\017\032\0020\004X\004¢\006\002\n\000¨\006\024"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/KeyBinds;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "()V", "BlurStrength", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "anmitY", "", "bV", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "bgValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onlyState", "getOnlyState", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "radiusValue", "shadowValue", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "getmoduley", "", "XSJClient"})
/*     */ public final class KeyBinds extends Element {
/*     */   @NotNull
/*     */   private final BoolValue onlyState;
/*     */   private final BoolValue bV;
/*     */   private final FloatValue BlurStrength;
/*     */   private final IntegerValue bgValue;
/*     */   private final FloatValue radiusValue;
/*     */   private final FloatValue shadowValue;
/*     */   private float anmitY;
/*     */   
/*     */   public KeyBinds() {
/*  20 */     super(0.0D, 0.0D, 0.0F, null, 15, null);
/*  21 */     this.onlyState = new BoolValue("OnlyModuleState", false);
/*  22 */     this.bV = new BoolValue("Blur", true);
/*  23 */     this.BlurStrength = new FloatValue("BlurStrength", 5.0F, 0.0F, 20.0F);
/*  24 */     this.bgValue = new IntegerValue("Background-Alpha", 120, 0, 255);
/*  25 */     this.radiusValue = new FloatValue("Radius", 4.25F, 0.0F, 10.0F);
/*  26 */     this.shadowValue = new FloatValue("shadow-Value", 10.0F, 0.0F, 20.0F);
/*     */   }
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
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class KeyBinds$drawElement$1
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/*  45 */       GL11.glPushMatrix();
/*  46 */       GL11.glTranslated(KeyBinds.this.getRenderX(), KeyBinds.this.getRenderY(), 0.0D);
/*  47 */       GL11.glScalef(KeyBinds.this.getScale(), KeyBinds.this.getScale(), KeyBinds.this.getScale());
/*  48 */       RenderUtils.originalRoundedRect(
/*  49 */           0.0F, 
/*  50 */           0.0F, 
/*  51 */           114.0F, 
/*  52 */           KeyBinds.this.anmitY, (
/*  53 */           (Number)KeyBinds.this.radiusValue.get()).floatValue(), (
/*  54 */           new Color(0, 0, 0)).getRGB());
/*     */       
/*  56 */       GL11.glPopMatrix();
/*     */     } KeyBinds$drawElement$1() { super(0); } }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*  59 */   static final class KeyBinds$drawElement$2 extends Lambda implements Function0<Unit> { public final void invoke() { GL11.glPushMatrix();
/*  60 */       GL11.glTranslated(KeyBinds.this.getRenderX(), KeyBinds.this.getRenderY(), 0.0D);
/*  61 */       GL11.glScalef(KeyBinds.this.getScale(), KeyBinds.this.getScale(), KeyBinds.this.getScale());
/*  62 */       GlStateManager.func_179147_l();
/*  63 */       GlStateManager.func_179090_x();
/*  64 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/*  65 */       RenderUtils.fastRoundedRect(0.0F, 
/*  66 */           0.0F, 
/*  67 */           114.0F, 
/*  68 */           KeyBinds.this.anmitY, (
/*  69 */           (Number)KeyBinds.this.radiusValue.get()).floatValue());
/*     */       
/*  71 */       GlStateManager.func_179098_w();
/*  72 */       GlStateManager.func_179084_k();
/*  73 */       GL11.glPopMatrix(); } KeyBinds$drawElement$2() { super(0); } }
/*     */    @Nullable public Border drawElement() { int y2 = 0; this.anmitY = (float)RenderUtils.getAnimationState2(this.anmitY, (17 + getmoduley()), 200.0D); RenderUtils.drawRoundedRect(0.0F, 0.0F, 114.0F, this.anmitY, ((Number)this.radiusValue.get()).floatValue(), (new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue())).getRGB()); GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); ShadowUtils.shadow(((Number)this.shadowValue.get()).floatValue(), new KeyBinds$drawElement$1(), new KeyBinds$drawElement$2());
/*  75 */     GL11.glPopMatrix();
/*  76 */     GL11.glScalef(getScale(), getScale(), getScale());
/*  77 */     GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */     
/*  79 */     if (((Boolean)this.bV.get()).booleanValue()) {
/*  80 */       GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D);
/*  81 */       GL11.glPushMatrix();
/*  82 */       BlurBuffer.CustomBlurRoundArea(
/*  83 */           (float)getRenderX(), 
/*  84 */           (float)getRenderY(), 
/*  85 */           114.0F, 
/*  86 */           this.anmitY, (
/*  87 */           (Number)this.radiusValue.get()).floatValue(), ((Number)this.BlurStrength.get()).floatValue());
/*     */       
/*  89 */       GL11.glPopMatrix();
/*  90 */       GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */     } 
/*     */ 
/*     */     
/*  94 */     float fwidth = 57.0F - Fonts.tenacitybold35.getStringWidth("KeyBinds") / 2.0F;
/*  95 */     Fonts.posterama40.drawString("KeyBinds", fwidth, 4.5F, -1);
/*     */ 
/*     */     
/*  98 */     for (Module module : Retreat.INSTANCE.getModuleManager().getModules()) {
/*  99 */       if (module.getKeyBind() == 0 || ((
/* 100 */         (Boolean)this.onlyState.get()).booleanValue() && 
/* 101 */         !module.getState()))
/*     */         continue; 
/* 103 */       Fonts.posterama30.drawString(module.getName(), 3.0F, y2 + 19.0F, -1);
/* 104 */       Fonts.posterama30.drawString(
/* 105 */           module.getState() ? "[True]" : "[False]", (
/* 106 */           108 - Fonts.tenacitybold35.getStringWidth(module.getState() ? "[True]" : "[False]")), 
/* 107 */           y2 + 21.0F, 
/* 108 */           module.getState() ? (new Color(255, 255, 255)).getRGB() : (new Color(100, 100, 100)).getRGB());
/*     */       
/* 110 */       y2 += 12;
/*     */     } 
/* 112 */     return new Border(0.0F, 0.0F, 114.0F, (17 + getmoduley())); } @NotNull
/*     */   public final BoolValue getOnlyState() {
/*     */     return this.onlyState;
/*     */   } public final int getmoduley() {
/* 116 */     int y = 0;
/* 117 */     for (Module module : Retreat.INSTANCE.getModuleManager().getModules()) {
/* 118 */       if (module.getKeyBind() == 0 || ((
/* 119 */         (Boolean)this.onlyState.get()).booleanValue() && 
/* 120 */         !module.getState()))
/*     */         continue; 
/* 122 */       y += 12;
/*     */     } 
/* 124 */     return y;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\KeyBinds.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */