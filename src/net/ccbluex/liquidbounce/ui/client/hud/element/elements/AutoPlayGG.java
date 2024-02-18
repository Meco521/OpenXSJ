/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.AColorPalette;
/*     */ import net.ccbluex.liquidbounce.management.CombatManager;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ElementInfo(name = "AutoPlayGG")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000N\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\007\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\t\n\002\b\005\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\003\n\002\020\002\n\000\b\007\030\0002\0020\001B-\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006\022\b\b\002\020\007\032\0020\b¢\006\002\020\tJ\b\020\036\032\0020\037H\026J\006\020 \032\0020\025J\006\020!\032\0020\025J\b\020\"\032\0020#H\026R\021\020\n\032\0020\013¢\006\b\n\000\032\004\b\f\020\rR\032\020\016\032\0020\017X\016¢\006\016\n\000\032\004\b\020\020\021\"\004\b\022\020\023R\026\020\024\032\n \026*\004\030\0010\0250\025X\016¢\006\002\n\000R\020\020\027\032\004\030\0010\025X\016¢\006\002\n\000R\021\020\030\032\0020\031¢\006\b\n\000\032\004\b\032\020\033R\020\020\034\032\004\030\0010\025X\016¢\006\002\n\000R\020\020\035\032\004\030\0010\025X\016¢\006\002\n\000¨\006$"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/AutoPlayGG;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "scale", "", "side", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;", "(DDFLnet/ccbluex/liquidbounce/ui/client/hud/element/Side;)V", "AutoPlay", "Lnet/ccbluex/liquidbounce/features/module/modules/hyt/AutoPlay;", "getAutoPlay", "()Lnet/ccbluex/liquidbounce/features/module/modules/hyt/AutoPlay;", "animeXTime", "", "getAnimeXTime", "()J", "setAnimeXTime", "(J)V", "firstColor", "Ljava/awt/Color;", "kotlin.jvm.PlatformType", "fourthColor", "hudMod", "Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;", "getHudMod", "()Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;", "secondColor", "thirdColor", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "getAlternateClientColor", "getClientColor", "shader", "", "XSJClient"})
/*     */ public final class AutoPlayGG extends Element {
/*     */   @NotNull
/*     */   private final AutoPlay AutoPlay;
/*     */   private long animeXTime;
/*     */   @NotNull
/*     */   private final HUD hudMod;
/*     */   private Color firstColor;
/*     */   private Color secondColor;
/*     */   private Color thirdColor;
/*     */   private Color fourthColor;
/*     */   
/*  22 */   public AutoPlayGG(double x, double y, float scale, @NotNull Side side) { super(x, y, scale, side);
/*  23 */     if (Retreat.INSTANCE.getModuleManager().getModule(AutoPlay.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.hyt.AutoPlay");  this.AutoPlay = (AutoPlay)Retreat.INSTANCE.getModuleManager().getModule(AutoPlay.class);
/*  24 */     this.animeXTime = System.currentTimeMillis();
/*  25 */     if (Retreat.INSTANCE.getModuleManager().getModule(HUD.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.HUD");  this.hudMod = (HUD)Retreat.INSTANCE.getModuleManager().getModule(HUD.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  33 */     this.firstColor = Color.BLACK;
/*  34 */     this.secondColor = Color.BLACK;
/*  35 */     this.thirdColor = Color.BLACK;
/*  36 */     this.fourthColor = Color.BLACK; }
/*     */   @NotNull public final AutoPlay getAutoPlay() { return this.AutoPlay; }
/*  38 */   public final long getAnimeXTime() { return this.animeXTime; } public final void setAnimeXTime(long <set-?>) { this.animeXTime = <set-?>; } public void shader() { this.firstColor = ColorUtil.interpolateColorsBackAndForth(
/*  39 */         15, 
/*  40 */         0, 
/*  41 */         getClientColor(), 
/*  42 */         getAlternateClientColor(), (
/*  43 */         (Boolean)this.hudMod.getHueInterpolation().get()).booleanValue());
/*     */     
/*  45 */     this.secondColor = ColorUtil.interpolateColorsBackAndForth(
/*  46 */         15, 
/*  47 */         90, 
/*  48 */         getClientColor(), 
/*  49 */         getAlternateClientColor(), (
/*  50 */         (Boolean)this.hudMod.getHueInterpolation().get()).booleanValue());
/*     */     
/*  52 */     this.thirdColor = ColorUtil.interpolateColorsBackAndForth(
/*  53 */         15, 
/*  54 */         180, 
/*  55 */         getClientColor(), 
/*  56 */         getAlternateClientColor(), (
/*  57 */         (Boolean)this.hudMod.getHueInterpolation().get()).booleanValue());
/*     */     
/*  59 */     this.fourthColor = ColorUtil.interpolateColorsBackAndForth(
/*  60 */         15, 
/*  61 */         270, 
/*  62 */         getClientColor(), 
/*  63 */         getAlternateClientColor(), (
/*  64 */         (Boolean)this.hudMod.getHueInterpolation().get()).booleanValue());
/*  65 */     long nowTime = System.currentTimeMillis();
/*  66 */     double pct = (nowTime - this.animeXTime) / 'Ǵ';
/*  67 */     switch (AutoPlayGG$WhenMappings.$EnumSwitchMapping$0[Retreat.INSTANCE.getCombatManager().getFadeState().ordinal()]) {
/*     */       case 1:
/*  69 */         if (pct > true) {
/*  70 */           Retreat.INSTANCE.getCombatManager().setFadeState(CombatManager.FadeState.IN);
/*  71 */           this.animeXTime = nowTime;
/*  72 */           pct = 1.0D;
/*     */         } 
/*     */         break;
/*     */       case 2:
/*  76 */         if (pct > true) {
/*  77 */           Retreat.INSTANCE.getCombatManager().setFadeState(CombatManager.FadeState.STAY);
/*  78 */           this.animeXTime = nowTime;
/*  79 */           pct = 1.0D;
/*     */         } 
/*  81 */         pct = EaseUtils.INSTANCE.easeOutBack(pct);
/*     */         break;
/*     */       
/*     */       case 3:
/*  85 */         if (nowTime - this.animeXTime > 10000L) {
/*  86 */           Retreat.INSTANCE.getCombatManager().setFadeState(CombatManager.FadeState.OUT);
/*  87 */           this.animeXTime = nowTime;
/*     */         } 
/*  89 */         pct = 1.0D;
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       case 4:
/*  95 */         if (pct > true) {
/*  96 */           Retreat.INSTANCE.getCombatManager().setFadeState(CombatManager.FadeState.END);
/*  97 */           this.animeXTime = nowTime;
/*  98 */           pct = 1.0D;
/*     */         } 
/* 100 */         pct = true - EaseUtils.INSTANCE.easeInBack(pct);
/*     */         break;
/*     */       
/*     */       case 5:
/* 104 */         pct = 0.0D;
/*     */         break;
/*     */       case 6:
/* 107 */         pct = 0.0D;
/*     */         break;
/*     */     } 
/*     */     
/* 111 */     if (!MinecraftInstance.classProvider.isGuiHudDesigner(MinecraftInstance.mc.getCurrentScreen())) {
/* 112 */       float width = Fonts.rise35.getStringWidth("Now Playing: Music") + 25.0F + 5.0F;
/* 113 */       GL11.glScaled(pct, pct, pct);
/* 114 */       GL11.glTranslatef(-width / 2, -15.0F, 0.0F);
/*     */       
/* 116 */       if (((Boolean)BlurSettings.AutoPlayGGGlow.get()).booleanValue()) {
/* 117 */         RoundedUtil.drawGradientRound(
/* 118 */             0.0F, 0.0F, width + 10, 25.0F, 5.05F, 
/* 119 */             ColorUtil.applyOpacity(this.fourthColor, 1.0F), this.firstColor, this.secondColor, this.thirdColor);
/*     */       } else {
/*     */         
/* 122 */         RoundedUtil.drawRound(0.0F, 0.0F, width + 10, 25.0F, 5.05F, 
/* 123 */             new Color(0, 0, 0));
/*     */       } 
/*     */     }  }
/*     */   @NotNull public final HUD getHudMod() { return this.hudMod; }
/*     */   @NotNull public final Color getClientColor() { return new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue(), 255); }
/*     */   @NotNull public final Color getAlternateClientColor() { return new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), 255); } @NotNull
/* 129 */   public Border drawElement() { long nowTime = System.currentTimeMillis();
/* 130 */     double pct = (nowTime - this.animeXTime) / 'Ǵ';
/* 131 */     switch (AutoPlayGG$WhenMappings.$EnumSwitchMapping$1[Retreat.INSTANCE.getCombatManager().getFadeState().ordinal()]) {
/*     */       case 1:
/* 133 */         if (pct > true) {
/* 134 */           Retreat.INSTANCE.getCombatManager().setFadeState(CombatManager.FadeState.IN);
/* 135 */           this.animeXTime = nowTime;
/* 136 */           pct = 1.0D;
/*     */         } 
/*     */         break;
/*     */       case 2:
/* 140 */         if (pct > true) {
/* 141 */           Retreat.INSTANCE.getCombatManager().setFadeState(CombatManager.FadeState.STAY);
/* 142 */           this.animeXTime = nowTime;
/* 143 */           pct = 1.0D;
/*     */         } 
/* 145 */         pct = EaseUtils.INSTANCE.easeOutBack(pct);
/*     */         break;
/*     */       
/*     */       case 3:
/* 149 */         if (nowTime - this.animeXTime > 10000L) {
/* 150 */           Retreat.INSTANCE.getCombatManager().setFadeState(CombatManager.FadeState.OUT);
/* 151 */           this.animeXTime = nowTime;
/*     */         } 
/* 153 */         pct = 1.0D;
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       case 4:
/* 159 */         if (pct > true) {
/* 160 */           Retreat.INSTANCE.getCombatManager().setFadeState(CombatManager.FadeState.END);
/* 161 */           this.animeXTime = nowTime;
/* 162 */           pct = 1.0D;
/*     */         } 
/* 164 */         pct = true - EaseUtils.INSTANCE.easeInBack(pct);
/*     */         break;
/*     */       
/*     */       case 5:
/* 168 */         pct = 0.0D;
/*     */         break;
/*     */       case 6:
/* 171 */         pct = 0.0D;
/*     */         break;
/*     */     } 
/*     */     
/* 175 */     if (!MinecraftInstance.classProvider.isGuiHudDesigner(MinecraftInstance.mc.getCurrentScreen())) {
/* 176 */       float width = Fonts.rise35.getStringWidth("Now Playing: Music") + 25.0F + 5.0F;
/* 177 */       GL11.glScaled(pct, pct, pct);
/* 178 */       GL11.glTranslatef(-width / 2, -15.0F, 0.0F);
/* 179 */       RoundedUtil.drawRound(0.0F, 0.0F, width + 10, 25.0F, 5.05F, new Color(0, 0, 0, 40));
/*     */       
/* 181 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.Newuifont15.drawString("Now Playing: Music", 25, 16, Color.WHITE.getRGB());
/*     */       
/* 183 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.Newuifont17.drawCenteredString("Game Win", width / 2, 5.0F, Color.WHITE.getRGB());
/*     */     } 
/*     */     
/* 186 */     return new Border(0.0F, -15.0F, 80.0F, 26.5F); }
/*     */ 
/*     */   
/*     */   public AutoPlayGG() {
/*     */     this(0.0D, 0.0D, 0.0F, null, 15, null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\AutoPlayGG.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */