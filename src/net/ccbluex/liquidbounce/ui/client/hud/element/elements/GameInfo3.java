/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ import java.awt.Color;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.Unit;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.ranges.RangesKt;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.AColorPalette;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.PictureColor;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.PictureColor2;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ElementInfo(name = "GameInfo3")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0006\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\007\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\t\n\002\030\002\n\000\b\007\030\0002\0020\001B#\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006¢\006\002\020\007J\b\020\027\032\0020\030H\026R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\n\032\0020\013X\004¢\006\002\n\000R\016\020\f\032\0020\tX\004¢\006\002\n\000R\016\020\r\032\0020\016X\004¢\006\002\n\000R\016\020\017\032\0020\003X\016¢\006\002\n\000R\016\020\020\032\0020\003X\016¢\006\002\n\000R\016\020\021\032\0020\003X\016¢\006\002\n\000R\016\020\022\032\0020\016X\004¢\006\002\n\000R\016\020\023\032\0020\016X\004¢\006\002\n\000R\016\020\024\032\0020\tX\004¢\006\002\n\000R\016\020\025\032\0020\003X\016¢\006\002\n\000R\016\020\026\032\0020\016X\004¢\006\002\n\000¨\006\031"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/GameInfo3;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "scale", "", "(DDF)V", "Outline", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "OutmodeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "bV", "bgValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "fps", "health", "ms", "sb", "sg", "shadow", "speed", "sr", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "XSJClient"})
/*     */ public final class GameInfo3 extends Element {
/*     */   private final BoolValue bV;
/*     */   private final ListValue OutmodeValue;
/*     */   private final BoolValue Outline;
/*     */   private final IntegerValue bgValue;
/*     */   private final BoolValue shadow;
/*     */   private final IntegerValue sr;
/*     */   private final IntegerValue sg;
/*     */   private final IntegerValue sb;
/*     */   private double ms;
/*     */   private double health;
/*     */   private double speed;
/*     */   private double fps;
/*     */   
/*     */   public GameInfo3() {
/*     */     this(0.0D, 0.0D, 0.0F, 7, (DefaultConstructorMarker)null);
/*     */   }
/*     */   
/*     */   public GameInfo3(double x, double y, float scale) {
/*  38 */     super(x, y, scale, null, 8, null);
/*     */     
/*  40 */     this.bV = new BoolValue("blur", false);
/*     */     
/*  42 */     this.OutmodeValue = new ListValue("Outmode", new String[] { "Outline1", "Outline2", "old", "more" }, "Outline1");
/*  43 */     this.Outline = new BoolValue("Outline", true);
/*  44 */     this.bgValue = new IntegerValue("Background-Alpha", 120, 0, 255);
/*  45 */     this.shadow = new BoolValue("Shadow", false);
/*  46 */     this.sr = new IntegerValue("Shadow-Red", 0, 0, 255);
/*  47 */     this.sg = new IntegerValue("Shadow-Green", 0, 0, 255);
/*  48 */     this.sb = new IntegerValue("Shadow-Blue", 0, 0, 255);
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
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class GameInfo3$drawElement$1
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 242 */       GL11.glPushMatrix();
/* 243 */       GL11.glTranslated(GameInfo3.this.getRenderX(), GameInfo3.this.getRenderY(), 0.0D);
/* 244 */       GL11.glScalef(GameInfo3.this.getScale(), GameInfo3.this.getScale(), GameInfo3.this.getScale());
/* 245 */       RenderUtils.originalRoundedRect(
/* 246 */           0.0F, 
/* 247 */           0.0F, 114.0F, 100.0F, 
/* 248 */           6.4F, (new Color(((Number)GameInfo3.this.sr.get()).intValue(), ((Number)GameInfo3.this.sg.get()).intValue(), ((Number)GameInfo3.this.sb.get()).intValue(), 210)).getRGB());
/*     */ 
/*     */ 
/*     */       
/* 252 */       GL11.glPopMatrix();
/*     */     } GameInfo3$drawElement$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class GameInfo3$drawElement$2 extends Lambda implements Function0<Unit> { public final void invoke() {
/* 255 */       GL11.glPushMatrix();
/* 256 */       GL11.glTranslated(GameInfo3.this.getRenderX(), GameInfo3.this.getRenderY(), 0.0D);
/* 257 */       GL11.glScalef(GameInfo3.this.getScale(), GameInfo3.this.getScale(), GameInfo3.this.getScale());
/* 258 */       GlStateManager.func_179147_l();
/* 259 */       GlStateManager.func_179090_x();
/* 260 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/*     */       
/* 262 */       RenderUtils.originalRoundedRect(
/* 263 */           0.0F, 
/* 264 */           0.0F, 114.0F, 100.0F, 
/* 265 */           6.4F, (new Color(((Number)GameInfo3.this.sr.get()).intValue(), ((Number)GameInfo3.this.sg.get()).intValue(), ((Number)GameInfo3.this.sb.get()).intValue(), 210)).getRGB());
/*     */       
/* 267 */       GlStateManager.func_179098_w();
/* 268 */       GlStateManager.func_179084_k();
/* 269 */       GL11.glPopMatrix();
/*     */     }
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
/*     */     GameInfo3$drawElement$2() {
/*     */       super(0);
/*     */     } }
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
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class GameInfo3$drawElement$3
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 374 */       GL11.glPushMatrix();
/* 375 */       GL11.glTranslated(GameInfo3.this.getRenderX(), GameInfo3.this.getRenderY(), 0.0D);
/* 376 */       GL11.glScalef(GameInfo3.this.getScale(), GameInfo3.this.getScale(), GameInfo3.this.getScale());
/* 377 */       RenderUtils.originalRoundedRect(
/* 378 */           0.0F, 
/* 379 */           0.0F, 114.0F, 100.0F, 
/* 380 */           6.4F, (new Color(((Number)GameInfo3.this.sr.get()).intValue(), ((Number)GameInfo3.this.sg.get()).intValue(), ((Number)GameInfo3.this.sb.get()).intValue(), 210)).getRGB());
/*     */ 
/*     */ 
/*     */       
/* 384 */       GL11.glPopMatrix();
/*     */     } GameInfo3$drawElement$3() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class GameInfo3$drawElement$4 extends Lambda implements Function0<Unit> { public final void invoke() {
/* 387 */       GL11.glPushMatrix();
/* 388 */       GL11.glTranslated(GameInfo3.this.getRenderX(), GameInfo3.this.getRenderY(), 0.0D);
/* 389 */       GL11.glScalef(GameInfo3.this.getScale(), GameInfo3.this.getScale(), GameInfo3.this.getScale());
/* 390 */       GlStateManager.func_179147_l();
/* 391 */       GlStateManager.func_179090_x();
/* 392 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/*     */       
/* 394 */       RenderUtils.originalRoundedRect(
/* 395 */           0.0F, 
/* 396 */           0.0F, 114.0F, 100.0F, 
/* 397 */           6.4F, (new Color(((Number)GameInfo3.this.sr.get()).intValue(), ((Number)GameInfo3.this.sg.get()).intValue(), ((Number)GameInfo3.this.sb.get()).intValue(), 210)).getRGB());
/*     */       
/* 399 */       GlStateManager.func_179098_w();
/* 400 */       GlStateManager.func_179084_k();
/* 401 */       GL11.glPopMatrix();
/*     */     }
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
/*     */     GameInfo3$drawElement$4() {
/*     */       super(0);
/*     */     } }
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
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class GameInfo3$drawElement$5
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 588 */       GL11.glPushMatrix();
/* 589 */       GL11.glTranslated(GameInfo3.this.getRenderX(), GameInfo3.this.getRenderY(), 0.0D);
/* 590 */       GL11.glScalef(GameInfo3.this.getScale(), GameInfo3.this.getScale(), GameInfo3.this.getScale());
/* 591 */       RenderUtils.originalRoundedRect(
/* 592 */           0.0F, 
/* 593 */           0.0F, 114.0F, 100.0F, 
/* 594 */           6.4F, (new Color(((Number)GameInfo3.this.sr.get()).intValue(), ((Number)GameInfo3.this.sg.get()).intValue(), ((Number)GameInfo3.this.sb.get()).intValue(), 210)).getRGB());
/*     */ 
/*     */ 
/*     */       
/* 598 */       GL11.glPopMatrix();
/*     */     } GameInfo3$drawElement$5() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class GameInfo3$drawElement$6 extends Lambda implements Function0<Unit> { public final void invoke() {
/* 601 */       GL11.glPushMatrix();
/* 602 */       GL11.glTranslated(GameInfo3.this.getRenderX(), GameInfo3.this.getRenderY(), 0.0D);
/* 603 */       GL11.glScalef(GameInfo3.this.getScale(), GameInfo3.this.getScale(), GameInfo3.this.getScale());
/* 604 */       GlStateManager.func_179147_l();
/* 605 */       GlStateManager.func_179090_x();
/* 606 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/*     */       
/* 608 */       RenderUtils.originalRoundedRect(
/* 609 */           0.0F, 
/* 610 */           0.0F, 114.0F, 100.0F, 
/* 611 */           6.4F, (new Color(((Number)GameInfo3.this.sr.get()).intValue(), ((Number)GameInfo3.this.sg.get()).intValue(), ((Number)GameInfo3.this.sb.get()).intValue(), 210)).getRGB());
/*     */       
/* 613 */       GlStateManager.func_179098_w();
/* 614 */       GlStateManager.func_179084_k();
/* 615 */       GL11.glPopMatrix();
/*     */     }
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
/*     */     GameInfo3$drawElement$6() {
/*     */       super(0);
/*     */     } }
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
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class GameInfo3$drawElement$7
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 733 */       GL11.glPushMatrix();
/* 734 */       GL11.glTranslated(GameInfo3.this.getRenderX(), GameInfo3.this.getRenderY(), 0.0D);
/* 735 */       GL11.glScalef(GameInfo3.this.getScale(), GameInfo3.this.getScale(), GameInfo3.this.getScale());
/* 736 */       RenderUtils.originalRoundedRect(
/* 737 */           0.0F, 
/* 738 */           0.0F, 114.0F, 100.0F, 
/* 739 */           6.4F, (new Color(((Number)GameInfo3.this.sr.get()).intValue(), ((Number)GameInfo3.this.sg.get()).intValue(), ((Number)GameInfo3.this.sb.get()).intValue(), 210)).getRGB());
/*     */ 
/*     */ 
/*     */       
/* 743 */       GL11.glPopMatrix();
/*     */     } GameInfo3$drawElement$7() { super(0); }
/*     */   } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/* 746 */   static final class GameInfo3$drawElement$8 extends Lambda implements Function0<Unit> { GameInfo3$drawElement$8() { super(0); } public final void invoke() { GL11.glPushMatrix();
/* 747 */       GL11.glTranslated(GameInfo3.this.getRenderX(), GameInfo3.this.getRenderY(), 0.0D);
/* 748 */       GL11.glScalef(GameInfo3.this.getScale(), GameInfo3.this.getScale(), GameInfo3.this.getScale());
/* 749 */       GlStateManager.func_179147_l();
/* 750 */       GlStateManager.func_179090_x();
/* 751 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/*     */       
/* 753 */       RenderUtils.originalRoundedRect(
/* 754 */           0.0F, 
/* 755 */           0.0F, 114.0F, 100.0F, 
/* 756 */           6.4F, (new Color(((Number)GameInfo3.this.sr.get()).intValue(), ((Number)GameInfo3.this.sg.get()).intValue(), ((Number)GameInfo3.this.sb.get()).intValue(), 210)).getRGB());
/*     */       
/* 758 */       GlStateManager.func_179098_w();
/* 759 */       GlStateManager.func_179084_k();
/* 760 */       GL11.glPopMatrix(); } } @NotNull public Border drawElement() { Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold40.drawCenteredString("GameInfo", 57.0F, 5.0F, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); RenderUtils.drawRect(5.0F, 80.0F, 109.0F, 85.0F, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); RenderUtils.drawRect(5.0F, 17.0F, 109.0F, 19.0F, Color.WHITE.getRGB()); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.health = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(RenderUtils.getAnimationState2(this.health, this.health / MinecraftInstance.mc.getThePlayer().getMaxHealth() * 55.0F, 200.0D), 55.0D), 4.0D); this.fps = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(RenderUtils.getAnimationState2(this.fps, (MinecraftInstance.mc.getDebugFPS() / 300.0F * 55.0F), 200.0D), 55.0D), 4.0D); this.ms = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(RenderUtils.getAnimationState2(this.ms, (EntityUtils.getPing((IEntityPlayer)MinecraftInstance.mc.getThePlayer()) / 50.0F * 55.0F), 200.0D), 55.0D), 4.0D); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.speed = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(RenderUtils.getAnimationState2(this.speed, MovementUtils.INSTANCE.getBlockSpeed((IEntityLivingBase)MinecraftInstance.mc.getThePlayer()) / 20.0F * 55.0F, 200.0D), 55.0D), 4.0D); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold30.drawString("Health", 7, 90, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold30.drawString("Speed", 7 + Fonts.tenacitybold30.getStringWidth("Health") + 10, 90, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold30.drawString("FPS", 7 + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + 20, 90, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold30.drawString("MS", 7 + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + Fonts.tenacitybold30.getStringWidth("FPS") + 30, 90, Color.WHITE.getRGB()); RenderUtils.drawRoundedRect(10.0F, 77.0F, 15.0F, (float)(77.0F - this.health), 2.0F, (new Color(255, 255, 255)).getRGB()); RenderUtils.drawRoundedRect(10.0F + Fonts.tenacitybold30.getStringWidth("Health") + 10.0F, 77.0F, 10.0F + Fonts.tenacitybold30.getStringWidth("Health") + 10.0F + 5.0F, (float)(77.0F - this.speed), 2.0F, (new Color(255, 255, 255)).getRGB()); RenderUtils.drawRoundedRect(10.0F + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + 20.0F, 77.0F, 10.0F + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + 20.0F + 5.0F, (float)(77.0F - this.fps), 2.0F, (new Color(255, 255, 255)).getRGB()); RenderUtils.drawRoundedRect(10.0F + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + Fonts.tenacitybold30.getStringWidth("FPS") + 30.0F, 77.0F, 10.0F + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + Fonts.tenacitybold30.getStringWidth("FPS") + 30.0F + 5.0F, (float)(77.0F - this.ms), 2.0F, (new Color(255, 255, 255)).getRGB()); if (((Boolean)this.bV.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glPushMatrix(); BlurBuffer.CustomBlurRoundArea((float)getRenderX(), (float)getRenderY(), 114.0F, 100.0F, 6.4F, 10.0F); GL11.glPopMatrix(); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  if (StringsKt.equals((String)this.OutmodeValue.get(), "Outline1", true)) { int i = 114; int j = 100; long durationInMillis = System.currentTimeMillis() - Retreat.INSTANCE.getPlayTimeStart(); RenderUtils.drawRoundedRect(0.0F, 0.0F, 114.0F, 100.0F, 6.4F, (new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue())).getRGB()); if (((Boolean)this.Outline.get()).booleanValue()) ScaleUtils.drawOutline(6.0F, 0.0F, 107.0F, 87.0F, 6.4F, ((Number)AColorPalette.Companion.getLine().get()).floatValue(), 3.0F);  GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); GL11.glPopMatrix(); GL11.glScalef(getScale(), getScale(), getScale()); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold40.drawCenteredString("GameInfo", 57.0F, 5.0F, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); RenderUtils.drawRect(5.0F, 80.0F, 109.0F, 85.0F, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); RenderUtils.drawRect(5.0F, 17.0F, 109.0F, 19.0F, Color.WHITE.getRGB()); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.health = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(RenderUtils.getAnimationState2(this.health, this.health / MinecraftInstance.mc.getThePlayer().getMaxHealth() * 55.0F, 200.0D), 55.0D), 4.0D); this.fps = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(RenderUtils.getAnimationState2(this.fps, (MinecraftInstance.mc.getDebugFPS() / 300.0F * 55.0F), 200.0D), 55.0D), 4.0D); this.ms = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(RenderUtils.getAnimationState2(this.ms, (EntityUtils.getPing((IEntityPlayer)MinecraftInstance.mc.getThePlayer()) / 50.0F * 55.0F), 200.0D), 55.0D), 4.0D); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.speed = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(RenderUtils.getAnimationState2(this.speed, MovementUtils.INSTANCE.getBlockSpeed((IEntityLivingBase)MinecraftInstance.mc.getThePlayer()) / 20.0F * 55.0F, 200.0D), 55.0D), 4.0D); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold30.drawString("Health", 7, 90, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold30.drawString("Speed", 7 + Fonts.tenacitybold30.getStringWidth("Health") + 10, 90, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold30.drawString("FPS", 7 + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + 20, 90, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold30.drawString("MS", 7 + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + Fonts.tenacitybold30.getStringWidth("FPS") + 30, 90, Color.WHITE.getRGB()); RenderUtils.drawRoundedRect(10.0F, 77.0F, 15.0F, (float)(77.0F - this.health), 2.0F, (new Color(255, 255, 255)).getRGB()); RenderUtils.drawRoundedRect(10.0F + Fonts.tenacitybold30.getStringWidth("Health") + 10.0F, 77.0F, 10.0F + Fonts.tenacitybold30.getStringWidth("Health") + 10.0F + 5.0F, (float)(77.0F - this.speed), 2.0F, (new Color(255, 255, 255)).getRGB()); RenderUtils.drawRoundedRect(10.0F + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + 20.0F, 77.0F, 10.0F + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + 20.0F + 5.0F, (float)(77.0F - this.fps), 2.0F, (new Color(255, 255, 255)).getRGB()); RenderUtils.drawRoundedRect(10.0F + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + Fonts.tenacitybold30.getStringWidth("FPS") + 30.0F, 77.0F, 10.0F + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + Fonts.tenacitybold30.getStringWidth("FPS") + 30.0F + 5.0F, (float)(77.0F - this.ms), 2.0F, (new Color(255, 255, 255)).getRGB()); }  if (((Boolean)this.shadow.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); ShadowUtils.shadow(8.0F, new GameInfo3$drawElement$1(), new GameInfo3$drawElement$2()); GL11.glPopMatrix(); GL11.glScalef(getScale(), getScale(), getScale()); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  if (StringsKt.equals((String)this.OutmodeValue.get(), "Outline2", true)) { int i = 114; int j = 100; long durationInMillis = System.currentTimeMillis() - Retreat.INSTANCE.getPlayTimeStart(); RenderUtils.drawRoundedRect(0.0F, 0.0F, 114.0F, 100.0F, 6.4F, (new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue())).getRGB()); if (((Boolean)this.Outline.get()).booleanValue()) ScaleUtils.drawGidentOutlinedRoundedRect3(0.0D, 0.0D, 114.0D, 100.0D, 6.4D, ((Number)AColorPalette.Companion.getLine().get()).floatValue());  GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); GL11.glPopMatrix(); GL11.glScalef(getScale(), getScale(), getScale()); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold40.drawCenteredString("GameInfo", 57.0F, 5.0F, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); RenderUtils.drawRect(5.0F, 80.0F, 109.0F, 85.0F, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); RenderUtils.drawRect(5.0F, 17.0F, 109.0F, 19.0F, Color.WHITE.getRGB()); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.health = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(RenderUtils.getAnimationState2(this.health, this.health / MinecraftInstance.mc.getThePlayer().getMaxHealth() * 55.0F, 200.0D), 55.0D), 4.0D); this.fps = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(RenderUtils.getAnimationState2(this.fps, (MinecraftInstance.mc.getDebugFPS() / 300.0F * 55.0F), 200.0D), 55.0D), 4.0D); this.ms = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(RenderUtils.getAnimationState2(this.ms, (EntityUtils.getPing((IEntityPlayer)MinecraftInstance.mc.getThePlayer()) / 50.0F * 55.0F), 200.0D), 55.0D), 4.0D); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.speed = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(RenderUtils.getAnimationState2(this.speed, MovementUtils.INSTANCE.getBlockSpeed((IEntityLivingBase)MinecraftInstance.mc.getThePlayer()) / 20.0F * 55.0F, 200.0D), 55.0D), 4.0D); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold30.drawString("Health", 7, 90, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold30.drawString("Speed", 7 + Fonts.tenacitybold30.getStringWidth("Health") + 10, 90, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold30.drawString("FPS", 7 + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + 20, 90, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold30.drawString("MS", 7 + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + Fonts.tenacitybold30.getStringWidth("FPS") + 30, 90, Color.WHITE.getRGB()); RenderUtils.drawRoundedRect(10.0F, 77.0F, 15.0F, (float)(77.0F - this.health), 2.0F, (new Color(255, 255, 255)).getRGB()); RenderUtils.drawRoundedRect(10.0F + Fonts.tenacitybold30.getStringWidth("Health") + 10.0F, 77.0F, 10.0F + Fonts.tenacitybold30.getStringWidth("Health") + 10.0F + 5.0F, (float)(77.0F - this.speed), 2.0F, (new Color(255, 255, 255)).getRGB()); RenderUtils.drawRoundedRect(10.0F + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + 20.0F, 77.0F, 10.0F + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + 20.0F + 5.0F, (float)(77.0F - this.fps), 2.0F, (new Color(255, 255, 255)).getRGB()); RenderUtils.drawRoundedRect(10.0F + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + Fonts.tenacitybold30.getStringWidth("FPS") + 30.0F, 77.0F, 10.0F + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + Fonts.tenacitybold30.getStringWidth("FPS") + 30.0F + 5.0F, (float)(77.0F - this.ms), 2.0F, (new Color(255, 255, 255)).getRGB()); }  if (((Boolean)this.shadow.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); ShadowUtils.shadow(8.0F, new GameInfo3$drawElement$3(), new GameInfo3$drawElement$4()); GL11.glPopMatrix(); GL11.glScalef(getScale(), getScale(), getScale()); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  if (StringsKt.equals((String)this.OutmodeValue.get(), "old", true)) { int i = 114; int j = 100; long durationInMillis = System.currentTimeMillis() - Retreat.INSTANCE.getPlayTimeStart(); if (Retreat.INSTANCE.getModuleManager().getModule(PictureColor.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.PictureColor");  PictureColor color = (PictureColor)Retreat.INSTANCE.getModuleManager().getModule(PictureColor.class); if (Retreat.INSTANCE.getModuleManager().getModule(PictureColor2.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.PictureColor2");  PictureColor2 color2 = (PictureColor2)Retreat.INSTANCE.getModuleManager().getModule(PictureColor2.class); Color gradientColor1 = Color.WHITE; Color gradientColor2 = Color.WHITE; Color gradientColor3 = Color.WHITE; Color gradientColor4 = Color.WHITE; gradientColor1 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(10, 20, new Color(((Number)color.getColorRedValue().get()).intValue(), ((Number)color.getColorGreenValue().get()).intValue(), ((Number)color.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false); gradientColor2 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 90, new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false); gradientColor3 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 270, new Color(((Number)color.getColorRedValue().get()).intValue(), ((Number)color.getColorGreenValue().get()).intValue(), ((Number)color.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color.getColorRedValue().get()).intValue(), ((Number)color.getColorGreenValue().get()).intValue(), ((Number)color.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false); gradientColor4 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 270, new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false); RoundedUtil.drawGradientRound(0.0F, 0.0F, 114.0F, 100.0F, 6.4F, gradientColor1, gradientColor3, gradientColor2, gradientColor1); GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); GL11.glPopMatrix(); GL11.glScalef(getScale(), getScale(), getScale()); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold40.drawCenteredString("GameInfo", 57.0F, 5.0F, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); RenderUtils.drawRect(5.0F, 80.0F, 109.0F, 85.0F, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); RenderUtils.drawRect(5.0F, 17.0F, 109.0F, 19.0F, Color.WHITE.getRGB()); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.health = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(RenderUtils.getAnimationState2(this.health, this.health / MinecraftInstance.mc.getThePlayer().getMaxHealth() * 55.0F, 200.0D), 55.0D), 4.0D); this.fps = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(RenderUtils.getAnimationState2(this.fps, (MinecraftInstance.mc.getDebugFPS() / 300.0F * 55.0F), 200.0D), 55.0D), 4.0D); this.ms = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(RenderUtils.getAnimationState2(this.ms, (EntityUtils.getPing((IEntityPlayer)MinecraftInstance.mc.getThePlayer()) / 50.0F * 55.0F), 200.0D), 55.0D), 4.0D); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.speed = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(RenderUtils.getAnimationState2(this.speed, MovementUtils.INSTANCE.getBlockSpeed((IEntityLivingBase)MinecraftInstance.mc.getThePlayer()) / 20.0F * 55.0F, 200.0D), 55.0D), 4.0D); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold30.drawString("Health", 7, 90, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold30.drawString("Speed", 7 + Fonts.tenacitybold30.getStringWidth("Health") + 10, 90, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold30.drawString("FPS", 7 + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + 20, 90, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold30.drawString("MS", 7 + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + Fonts.tenacitybold30.getStringWidth("FPS") + 30, 90, Color.WHITE.getRGB()); RenderUtils.drawRoundedRect(10.0F, 77.0F, 15.0F, (float)(77.0F - this.health), 2.0F, (new Color(255, 255, 255)).getRGB()); RenderUtils.drawRoundedRect(10.0F + Fonts.tenacitybold30.getStringWidth("Health") + 10.0F, 77.0F, 10.0F + Fonts.tenacitybold30.getStringWidth("Health") + 10.0F + 5.0F, (float)(77.0F - this.speed), 2.0F, (new Color(255, 255, 255)).getRGB()); RenderUtils.drawRoundedRect(10.0F + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + 20.0F, 77.0F, 10.0F + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + 20.0F + 5.0F, (float)(77.0F - this.fps), 2.0F, (new Color(255, 255, 255)).getRGB()); RenderUtils.drawRoundedRect(10.0F + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + Fonts.tenacitybold30.getStringWidth("FPS") + 30.0F, 77.0F, 10.0F + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + Fonts.tenacitybold30.getStringWidth("FPS") + 30.0F + 5.0F, (float)(77.0F - this.ms), 2.0F, (new Color(255, 255, 255)).getRGB()); }  if (((Boolean)this.shadow.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); ShadowUtils.shadow(8.0F, new GameInfo3$drawElement$5(), new GameInfo3$drawElement$6()); GL11.glPopMatrix(); GL11.glScalef(getScale(), getScale(), getScale()); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  if (StringsKt.equals((String)this.OutmodeValue.get(), "more", true)) { Color gradientColor1 = new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue(), ((Number)AColorPalette.a.get()).intValue()); Color gradientColor2 = new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue(), ((Number)AColorPalette.a.get()).intValue()); Color gradientColor3 = new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), ((Number)AColorPalette.Companion.getA2().get()).intValue()); Color gradientColor4 = new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), ((Number)AColorPalette.Companion.getA2().get()).intValue()); RoundedUtil.drawGradientRound(0.0F, 0.0F, 114.0F, 100.0F, 6.4F, ColorUtil.applyOpacity(gradientColor4, 0.85F), gradientColor1, gradientColor3, gradientColor2); GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); GL11.glPopMatrix(); GL11.glScalef(getScale(), getScale(), getScale()); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold40.drawCenteredString("GameInfo", 57.0F, 5.0F, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); RenderUtils.drawRect(5.0F, 80.0F, 109.0F, 85.0F, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); RenderUtils.drawRect(5.0F, 17.0F, 109.0F, 19.0F, Color.WHITE.getRGB()); if (MinecraftInstance.mc.getThePlayer() == null)
/*     */         Intrinsics.throwNpe();  this.health = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(RenderUtils.getAnimationState2(this.health, this.health / MinecraftInstance.mc.getThePlayer().getMaxHealth() * 55.0F, 200.0D), 55.0D), 4.0D); this.fps = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(RenderUtils.getAnimationState2(this.fps, (MinecraftInstance.mc.getDebugFPS() / 300.0F * 55.0F), 200.0D), 55.0D), 4.0D); this.ms = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(RenderUtils.getAnimationState2(this.ms, (EntityUtils.getPing((IEntityPlayer)MinecraftInstance.mc.getThePlayer()) / 50.0F * 55.0F), 200.0D), 55.0D), 4.0D); if (MinecraftInstance.mc.getThePlayer() == null)
/* 762 */         Intrinsics.throwNpe();  this.speed = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(RenderUtils.getAnimationState2(this.speed, MovementUtils.INSTANCE.getBlockSpeed((IEntityLivingBase)MinecraftInstance.mc.getThePlayer()) / 20.0F * 55.0F, 200.0D), 55.0D), 4.0D); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold30.drawString("Health", 7, 90, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold30.drawString("Speed", 7 + Fonts.tenacitybold30.getStringWidth("Health") + 10, 90, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold30.drawString("FPS", 7 + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + 20, 90, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold30.drawString("MS", 7 + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + Fonts.tenacitybold30.getStringWidth("FPS") + 30, 90, Color.WHITE.getRGB()); RenderUtils.drawRoundedRect(10.0F, 77.0F, 15.0F, (float)(77.0F - this.health), 2.0F, (new Color(255, 255, 255)).getRGB()); RenderUtils.drawRoundedRect(10.0F + Fonts.tenacitybold30.getStringWidth("Health") + 10.0F, 77.0F, 10.0F + Fonts.tenacitybold30.getStringWidth("Health") + 10.0F + 5.0F, (float)(77.0F - this.speed), 2.0F, (new Color(255, 255, 255)).getRGB()); RenderUtils.drawRoundedRect(10.0F + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + 20.0F, 77.0F, 10.0F + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + 20.0F + 5.0F, (float)(77.0F - this.fps), 2.0F, (new Color(255, 255, 255)).getRGB()); RenderUtils.drawRoundedRect(10.0F + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + Fonts.tenacitybold30.getStringWidth("FPS") + 30.0F, 77.0F, 10.0F + Fonts.tenacitybold30.getStringWidth("Health") + Fonts.tenacitybold30.getStringWidth("Speed") + Fonts.tenacitybold30.getStringWidth("FPS") + 30.0F + 5.0F, (float)(77.0F - this.ms), 2.0F, (new Color(255, 255, 255)).getRGB()); }  if (((Boolean)this.shadow.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); ShadowUtils.shadow(8.0F, new GameInfo3$drawElement$7(), new GameInfo3$drawElement$8()); GL11.glPopMatrix();
/* 763 */       GL11.glScalef(getScale(), getScale(), getScale());
/* 764 */       GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }
/*     */ 
/*     */ 
/*     */     
/* 768 */     int x2 = 114;
/* 769 */     int y2 = 100;
/*     */     
/* 771 */     return new Border(0.0F, 0.0F, x2, y2); }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\GameInfo3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */