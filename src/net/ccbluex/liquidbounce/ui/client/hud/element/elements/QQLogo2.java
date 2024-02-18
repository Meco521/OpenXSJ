/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ import java.awt.Color;
/*     */ import kotlin.Unit;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.color.CustomColor;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.PictureColor;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.PictureColor2;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ElementInfo(name = "QQLogo2")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000P\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\004\n\002\020\007\n\000\n\002\020\013\n\000\n\002\030\002\n\002\b\r\n\002\030\002\n\000\n\002\020\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\n\020'\032\004\030\0010(H\026J\006\020)\032\0020*R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\004X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\032\020\n\032\0020\013X\016¢\006\016\n\000\032\004\b\f\020\r\"\004\b\016\020\017R\031\020\020\032\n \022*\004\030\0010\0210\021¢\006\b\n\000\032\004\b\023\020\024R\016\020\025\032\0020\026X\016¢\006\002\n\000R\016\020\027\032\0020\030X\016¢\006\002\n\000R\032\020\031\032\0020\032X\016¢\006\016\n\000\032\004\b\033\020\034\"\004\b\035\020\036R\032\020\037\032\0020\032X\016¢\006\016\n\000\032\004\b \020\034\"\004\b!\020\036R\016\020\"\032\0020\tX\004¢\006\002\n\000R\016\020#\032\0020\tX\004¢\006\002\n\000R\016\020$\032\0020\tX\004¢\006\002\n\000R\016\020%\032\0020\004X\004¢\006\002\n\000R\016\020&\032\0020\tX\004¢\006\002\n\000¨\006+"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/QQLogo2;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "()V", "Outline", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "OutmodeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "bV", "bgValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "blurmodule", "Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;", "getBlurmodule", "()Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;", "setBlurmodule", "(Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;)V", "bufferedImage2", "Ljava/awt/image/BufferedImage;", "kotlin.jvm.PlatformType", "getBufferedImage2", "()Ljava/awt/image/BufferedImage;", "easingHealth", "", "got", "", "resourcelocation3", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;", "getResourcelocation3", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;", "setResourcelocation3", "(Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;)V", "resourcelocation4", "getResourcelocation4", "setResourcelocation4", "sa", "sb", "sg", "shadow", "sr", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "updateAnim", "", "XSJClient"})
/*     */ public final class QQLogo2 extends Element {
/*     */   private final BoolValue bV;
/*     */   private final ListValue OutmodeValue;
/*     */   private final BoolValue Outline;
/*     */   private final IntegerValue bgValue;
/*     */   private final BoolValue shadow;
/*     */   private final IntegerValue sr;
/*     */   private final IntegerValue sg;
/*     */   private final IntegerValue sb;
/*     */   private final IntegerValue sa;
/*     */   private boolean got;
/*     */   private float easingHealth;
/*     */   @NotNull
/*     */   private IResourceLocation resourcelocation4;
/*     */   @NotNull
/*     */   private IResourceLocation resourcelocation3;
/*     */   private final BufferedImage bufferedImage2;
/*     */   @NotNull
/*     */   private HUD blurmodule;
/*     */   
/*     */   public QQLogo2() {
/*  35 */     super(0.0D, 0.0D, 0.0F, null, 15, null);
/*     */ 
/*     */ 
/*     */     
/*  39 */     this.bV = new BoolValue("blur", false);
/*     */     
/*  41 */     this.OutmodeValue = new ListValue("Outmode", new String[] { "Outline1", "Outline2", "old", "more" }, "Outline1");
/*  42 */     this.Outline = new BoolValue("Outline", true);
/*  43 */     this.bgValue = new IntegerValue("Background-Alpha", 120, 0, 255);
/*  44 */     this.shadow = new BoolValue("Shadow", false);
/*  45 */     this.sr = new IntegerValue("Shadow-Red", 0, 0, 255);
/*  46 */     this.sg = new IntegerValue("Shadow-Green", 0, 0, 255);
/*  47 */     this.sb = new IntegerValue("Shadow-Blue", 0, 0, 255);
/*  48 */     this.sa = new IntegerValue("Shadow-Alpna", 0, 0, 255);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  53 */     this.resourcelocation4 = MinecraftInstance.classProvider.createResourceLocation("什么玩意妈妈暴毙是不是当年我把你婊子妈的臭逼用日本武士刀割下来炖烂放到离心机里把你妈的臭逼加上子宫用一百万转每秒的转速给你离心出来你这个废物东西一样我看你不三不四不痛不痒的一直虚空对线是不是想念牛鞭跟你妈的臭逼炖在一起的B味道了啊");
/*     */     
/*  55 */     this.resourcelocation3 = MinecraftInstance.classProvider.createResourceLocation("什么玩意妈妈暴毙是不是当年我把你婊子妈的臭逼用日本武士刀割下来炖烂放到离心机里把你妈的臭逼加上子宫用一百万转每秒的转速给你离心出来你这个废物东西一样我看你不三不四不痛不痒的一直虚空对线是不是想念牛鞭跟你妈的臭逼炖在一起的B味道了啊");
/*     */     
/*  57 */     this.bufferedImage2 = ImageIO.read(new URL("https://q.qlogo.cn/headimg_dl?dst_uin=" + QQUtils.getSubString(QQUtils.getLoginQQList().toString(), "=", "}") + "&spec=640&img_type=png"));
/*  58 */     if (Retreat.INSTANCE.getModuleManager().getModule(HUD.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.HUD");  this.blurmodule = (HUD)Retreat.INSTANCE.getModuleManager().getModule(HUD.class);
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
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class QQLogo2$drawElement$1
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 140 */       GL11.glPushMatrix();
/* 141 */       GL11.glTranslated(QQLogo2.this.getRenderX(), QQLogo2.this.getRenderY(), 0.0D);
/* 142 */       GL11.glScalef(QQLogo2.this.getScale(), QQLogo2.this.getScale(), QQLogo2.this.getScale());
/* 143 */       RenderUtils.originalRoundedRect(
/* 144 */           8.0F, 
/* 145 */           -17.0F, 110.0F, 20.0F, 
/* 146 */           6.4F, (new Color(((Number)QQLogo2.this.sr.get()).intValue(), ((Number)QQLogo2.this.sg.get()).intValue(), ((Number)QQLogo2.this.sb.get()).intValue(), ((Number)QQLogo2.this.sa.get()).intValue())).getRGB());
/*     */ 
/*     */       
/* 149 */       GL11.glPopMatrix();
/*     */     } QQLogo2$drawElement$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class QQLogo2$drawElement$2 extends Lambda implements Function0<Unit> { public final void invoke() {
/* 152 */       GL11.glPushMatrix();
/* 153 */       GL11.glTranslated(QQLogo2.this.getRenderX(), QQLogo2.this.getRenderY(), 0.0D);
/* 154 */       GL11.glScalef(QQLogo2.this.getScale(), QQLogo2.this.getScale(), QQLogo2.this.getScale());
/* 155 */       GlStateManager.func_179147_l();
/* 156 */       GlStateManager.func_179090_x();
/* 157 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/*     */       
/* 159 */       RenderUtils.originalRoundedRect(
/* 160 */           8.0F, 
/* 161 */           -17.0F, 10.0F, 20.0F, 
/* 162 */           6.4F, (new Color(((Number)QQLogo2.this.sr.get()).intValue(), ((Number)QQLogo2.this.sg.get()).intValue(), ((Number)QQLogo2.this.sb.get()).intValue(), ((Number)QQLogo2.this.sa.get()).intValue())).getRGB());
/* 163 */       GlStateManager.func_179098_w();
/* 164 */       GlStateManager.func_179084_k();
/* 165 */       GL11.glPopMatrix();
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
/*     */     QQLogo2$drawElement$2() {
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
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class QQLogo2$drawElement$3
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 243 */       GL11.glPushMatrix();
/* 244 */       GL11.glTranslated(QQLogo2.this.getRenderX(), QQLogo2.this.getRenderY(), 0.0D);
/* 245 */       GL11.glScalef(QQLogo2.this.getScale(), QQLogo2.this.getScale(), QQLogo2.this.getScale());
/* 246 */       RenderUtils.originalRoundedRect(
/* 247 */           8.0F, 
/* 248 */           -17.0F, 110.0F, 20.0F, 
/* 249 */           6.4F, (new Color(((Number)QQLogo2.this.sr.get()).intValue(), ((Number)QQLogo2.this.sg.get()).intValue(), ((Number)QQLogo2.this.sb.get()).intValue(), ((Number)QQLogo2.this.sa.get()).intValue())).getRGB());
/*     */ 
/*     */       
/* 252 */       GL11.glPopMatrix();
/*     */     } QQLogo2$drawElement$3() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class QQLogo2$drawElement$4 extends Lambda implements Function0<Unit> { public final void invoke() {
/* 255 */       GL11.glPushMatrix();
/* 256 */       GL11.glTranslated(QQLogo2.this.getRenderX(), QQLogo2.this.getRenderY(), 0.0D);
/* 257 */       GL11.glScalef(QQLogo2.this.getScale(), QQLogo2.this.getScale(), QQLogo2.this.getScale());
/* 258 */       GlStateManager.func_179147_l();
/* 259 */       GlStateManager.func_179090_x();
/* 260 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/*     */       
/* 262 */       RenderUtils.originalRoundedRect(
/* 263 */           8.0F, 
/* 264 */           -17.0F, 110.0F, 20.0F, 
/* 265 */           6.4F, (new Color(((Number)QQLogo2.this.sr.get()).intValue(), ((Number)QQLogo2.this.sg.get()).intValue(), ((Number)QQLogo2.this.sb.get()).intValue(), ((Number)QQLogo2.this.sa.get()).intValue())).getRGB());
/* 266 */       GlStateManager.func_179098_w();
/* 267 */       GlStateManager.func_179084_k();
/* 268 */       GL11.glPopMatrix();
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
/*     */     QQLogo2$drawElement$4() {
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
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class QQLogo2$drawElement$5
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 346 */       GL11.glPushMatrix();
/* 347 */       GL11.glTranslated(QQLogo2.this.getRenderX(), QQLogo2.this.getRenderY(), 0.0D);
/* 348 */       GL11.glScalef(QQLogo2.this.getScale(), QQLogo2.this.getScale(), QQLogo2.this.getScale());
/* 349 */       RenderUtils.originalRoundedRect(
/* 350 */           8.0F, 
/* 351 */           -17.0F, 110.0F, 20.0F, 
/* 352 */           6.4F, (new Color(((Number)QQLogo2.this.sr.get()).intValue(), ((Number)QQLogo2.this.sg.get()).intValue(), ((Number)QQLogo2.this.sb.get()).intValue(), ((Number)QQLogo2.this.sa.get()).intValue())).getRGB());
/*     */ 
/*     */       
/* 355 */       GL11.glPopMatrix();
/*     */     } QQLogo2$drawElement$5() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class QQLogo2$drawElement$6 extends Lambda implements Function0<Unit> { public final void invoke() {
/* 358 */       GL11.glPushMatrix();
/* 359 */       GL11.glTranslated(QQLogo2.this.getRenderX(), QQLogo2.this.getRenderY(), 0.0D);
/* 360 */       GL11.glScalef(QQLogo2.this.getScale(), QQLogo2.this.getScale(), QQLogo2.this.getScale());
/* 361 */       GlStateManager.func_179147_l();
/* 362 */       GlStateManager.func_179090_x();
/* 363 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/*     */       
/* 365 */       RenderUtils.originalRoundedRect(
/* 366 */           8.0F, 
/* 367 */           -17.0F, 10.0F, 20.0F, 
/* 368 */           6.4F, (new Color(((Number)QQLogo2.this.sr.get()).intValue(), ((Number)QQLogo2.this.sg.get()).intValue(), ((Number)QQLogo2.this.sb.get()).intValue(), ((Number)QQLogo2.this.sa.get()).intValue())).getRGB());
/* 369 */       GlStateManager.func_179098_w();
/* 370 */       GlStateManager.func_179084_k();
/* 371 */       GL11.glPopMatrix();
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
/*     */     QQLogo2$drawElement$6() {
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
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class QQLogo2$drawElement$7
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 443 */       GL11.glPushMatrix();
/* 444 */       GL11.glTranslated(QQLogo2.this.getRenderX(), QQLogo2.this.getRenderY(), 0.0D);
/* 445 */       GL11.glScalef(QQLogo2.this.getScale(), QQLogo2.this.getScale(), QQLogo2.this.getScale());
/* 446 */       RenderUtils.originalRoundedRect(
/* 447 */           8.0F, 
/* 448 */           -17.0F, 110.0F, 20.0F, 
/* 449 */           6.4F, (new Color(((Number)QQLogo2.this.sr.get()).intValue(), ((Number)QQLogo2.this.sg.get()).intValue(), ((Number)QQLogo2.this.sb.get()).intValue(), ((Number)QQLogo2.this.sa.get()).intValue())).getRGB());
/*     */ 
/*     */       
/* 452 */       GL11.glPopMatrix();
/*     */     } QQLogo2$drawElement$7() { super(0); } }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/* 455 */   static final class QQLogo2$drawElement$8 extends Lambda implements Function0<Unit> { public final void invoke() { GL11.glPushMatrix();
/* 456 */       GL11.glTranslated(QQLogo2.this.getRenderX(), QQLogo2.this.getRenderY(), 0.0D);
/* 457 */       GL11.glScalef(QQLogo2.this.getScale(), QQLogo2.this.getScale(), QQLogo2.this.getScale());
/* 458 */       GlStateManager.func_179147_l();
/* 459 */       GlStateManager.func_179090_x();
/* 460 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/*     */       
/* 462 */       RenderUtils.originalRoundedRect(
/* 463 */           8.0F, 
/* 464 */           -17.0F, 10.0F, 20.0F, 
/* 465 */           6.4F, (new Color(((Number)QQLogo2.this.sr.get()).intValue(), ((Number)QQLogo2.this.sg.get()).intValue(), ((Number)QQLogo2.this.sb.get()).intValue(), ((Number)QQLogo2.this.sa.get()).intValue())).getRGB());
/* 466 */       GlStateManager.func_179098_w();
/* 467 */       GlStateManager.func_179084_k();
/* 468 */       GL11.glPopMatrix(); }
/*     */     QQLogo2$drawElement$8() { super(0); } }
/* 470 */    @NotNull public final IResourceLocation getResourcelocation4() { return this.resourcelocation4; } public final void setResourcelocation4(@NotNull IResourceLocation <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.resourcelocation4 = <set-?>; } @NotNull public final IResourceLocation getResourcelocation3() { return this.resourcelocation3; } @Nullable public Border drawElement() { CFontLoad.clientfont20.drawString("XSJ Client", 50.0F, -0.0F, (new Color(255, 255, 255, 255)).getRGB()); if (((Boolean)this.bV.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glPushMatrix(); BlurBuffer.CustomBlurRoundArea((float)getRenderX() + 9, (float)getRenderY() - 16, 100.0F, 36.0F, 6.4F, 10.0F); GL11.glPopMatrix(); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  if (StringsKt.equals((String)this.OutmodeValue.get(), "Outline1", true)) { updateAnim(); Color gradientColor1 = Color.WHITE; Color gradientColor2 = Color.WHITE; Color gradientColor3 = Color.WHITE; Color gradientColor4 = Color.WHITE; gradientColor1 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(10, 20, new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue()), new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue()), false); gradientColor2 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 90, new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue()), new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue()), false); gradientColor3 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 270, new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue()), new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue()), false); gradientColor4 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 270, new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue()), new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue()), false); if (((Boolean)this.blurmodule.getBlurmoduleValue().get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  if (((Boolean)this.bV.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glPushMatrix(); BlurBuffer.blurRoundArea((float)getRenderX() + 9, (float)getRenderY() - 16, 100.0F, 36.0F, (int)6.4F); GL11.glPopMatrix(); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  RoundedUtil.drawGradientRound(9.0F, -16.0F, 100.0F, 36.0F, ((Number)CustomColor.ra.get()).floatValue(), gradientColor1, gradientColor3, gradientColor2, gradientColor1); if (((Boolean)this.Outline.get()).booleanValue()) ScaleUtils.drawOutline(14.0F, -17.0F, 104.0F, 8.0F, 6.4F, ((Number)CustomColor.line.get()).floatValue(), 3.0F);  CFontLoad.clientfont20.drawString("XSJ Client", 50.0F, -0.0F, (new Color(255, 255, 255, 255)).getRGB()); GL11.glDisable(2929); GL11.glEnable(3042); GL11.glDepthMask(false); OpenGlHelper.func_148821_a(770, 771, 1, 0); GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); if (!this.got) { Intrinsics.checkExpressionValueIsNotNull(this.bufferedImage2, "bufferedImage2"); MinecraftInstance.mc.getTextureManager().loadTexture(this.resourcelocation4, (IAbstractTexture)MinecraftInstance.classProvider.createDynamicTexture(this.bufferedImage2)); this.got = true; }  Stencil.write(false); GL11.glDisable(3553); GL11.glEnable(3042); GL11.glBlendFunc(770, 771); RoundedUtil.drawGradientRound(16, -11.0F, 27.0F, 27.0F, 4.0F, gradientColor1, gradientColor3, gradientColor2, gradientColor1); GL11.glDisable(3042); GL11.glEnable(3553); Stencil.erase(true); MinecraftInstance.mc.getTextureManager().bindTexture(this.resourcelocation3); GL11.glPushMatrix(); GL11.glScaled(0.7D, 0.7D, 0.7D); Gui.func_146110_a(20, -20, 0.0F, 0.0F, 45, 60, 45.0F, 45.0F); GL11.glPopMatrix(); Stencil.dispose(); GL11.glDepthMask(true); GL11.glDisable(3042); GL11.glEnable(2929); }  if (((Boolean)this.shadow.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); ShadowUtils.shadow(8.0F, new QQLogo2$drawElement$1(), new QQLogo2$drawElement$2()); GL11.glPopMatrix(); GL11.glScalef(getScale(), getScale(), getScale()); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  if (StringsKt.equals((String)this.OutmodeValue.get(), "Outline2", true)) { updateAnim(); Color gradientColor1 = Color.WHITE; Color gradientColor2 = Color.WHITE; Color gradientColor3 = Color.WHITE; Color gradientColor4 = Color.WHITE; gradientColor1 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(10, 20, new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue()), new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue()), false); gradientColor2 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 90, new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue()), new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue()), false); gradientColor3 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 270, new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue()), new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue()), false); gradientColor4 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 270, new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue()), new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue()), false); if (((Boolean)this.blurmodule.getBlurmoduleValue().get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  if (((Boolean)this.bV.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glPushMatrix(); BlurBuffer.blurRoundArea((float)getRenderX() + 9, (float)getRenderY() - 16, 100.0F, 36.0F, (int)6.4F); GL11.glPopMatrix(); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  RoundedUtil.drawGradientRound(9.0F, -16.0F, 100.0F, 36.0F, ((Number)CustomColor.ra.get()).floatValue(), gradientColor1, gradientColor3, gradientColor2, gradientColor1); if (((Boolean)this.Outline.get()).booleanValue()) ScaleUtils.drawGidentOutlinedRoundedRect3(9.0D, -16.0D, 100.0D, 36.0D, 6.4D, ((Number)CustomColor.line.get()).floatValue());  CFontLoad.clientfont20.drawString("XSJ Client", 50.0F, -0.0F, (new Color(255, 255, 255, 255)).getRGB()); GL11.glDisable(2929); GL11.glEnable(3042); GL11.glDepthMask(false); OpenGlHelper.func_148821_a(770, 771, 1, 0); GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); if (!this.got) { Intrinsics.checkExpressionValueIsNotNull(this.bufferedImage2, "bufferedImage2"); MinecraftInstance.mc.getTextureManager().loadTexture(this.resourcelocation4, (IAbstractTexture)MinecraftInstance.classProvider.createDynamicTexture(this.bufferedImage2)); this.got = true; }  Stencil.write(false); GL11.glDisable(3553); GL11.glEnable(3042); GL11.glBlendFunc(770, 771); RoundedUtil.drawGradientRound(16, -11.0F, 27.0F, 27.0F, 4.0F, gradientColor1, gradientColor3, gradientColor2, gradientColor1); GL11.glDisable(3042); GL11.glEnable(3553); Stencil.erase(true); MinecraftInstance.mc.getTextureManager().bindTexture(this.resourcelocation3); GL11.glPushMatrix(); GL11.glScaled(0.7D, 0.7D, 0.7D); Gui.func_146110_a(20, -20, 0.0F, 0.0F, 45, 60, 45.0F, 45.0F); GL11.glPopMatrix(); Stencil.dispose(); GL11.glDepthMask(true); GL11.glDisable(3042); GL11.glEnable(2929); }  if (((Boolean)this.shadow.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); ShadowUtils.shadow(8.0F, new QQLogo2$drawElement$3(), new QQLogo2$drawElement$4()); GL11.glPopMatrix(); GL11.glScalef(getScale(), getScale(), getScale()); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  if (StringsKt.equals((String)this.OutmodeValue.get(), "old", true)) { updateAnim(); if (Retreat.INSTANCE.getModuleManager().getModule(PictureColor.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.PictureColor");  PictureColor color = (PictureColor)Retreat.INSTANCE.getModuleManager().getModule(PictureColor.class); if (Retreat.INSTANCE.getModuleManager().getModule(PictureColor2.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.PictureColor2");  PictureColor2 color2 = (PictureColor2)Retreat.INSTANCE.getModuleManager().getModule(PictureColor2.class); Color gradientColor1 = Color.WHITE; Color gradientColor2 = Color.WHITE; Color gradientColor3 = Color.WHITE; Color gradientColor4 = Color.WHITE; gradientColor1 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(10, 20, new Color(((Number)color.getColorRedValue().get()).intValue(), ((Number)color.getColorGreenValue().get()).intValue(), ((Number)color.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false); gradientColor2 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 90, new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false); gradientColor3 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 270, new Color(((Number)color.getColorRedValue().get()).intValue(), ((Number)color.getColorGreenValue().get()).intValue(), ((Number)color.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color.getColorRedValue().get()).intValue(), ((Number)color.getColorGreenValue().get()).intValue(), ((Number)color.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false); gradientColor4 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 270, new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false); if (((Boolean)this.blurmodule.getBlurmoduleValue().get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  if (((Boolean)this.bV.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glPushMatrix(); BlurBuffer.blurRoundArea((float)getRenderX() + 9, (float)getRenderY() - 16, 100.0F, 36.0F, (int)6.4F); GL11.glPopMatrix(); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  RoundedUtil.drawGradientRound(9.0F, -16.0F, 100.0F, 36.0F, ((Number)CustomColor.ra.get()).floatValue(), gradientColor1, gradientColor3, gradientColor2, gradientColor1); CFontLoad.clientfont20.drawString("XSJ Client", 50.0F, -0.0F, (new Color(255, 255, 255, 255)).getRGB()); GL11.glDisable(2929); GL11.glEnable(3042); GL11.glDepthMask(false); OpenGlHelper.func_148821_a(770, 771, 1, 0); GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); if (!this.got) { Intrinsics.checkExpressionValueIsNotNull(this.bufferedImage2, "bufferedImage2"); MinecraftInstance.mc.getTextureManager().loadTexture(this.resourcelocation4, (IAbstractTexture)MinecraftInstance.classProvider.createDynamicTexture(this.bufferedImage2)); this.got = true; }  Stencil.write(false); GL11.glDisable(3553); GL11.glEnable(3042); GL11.glBlendFunc(770, 771); RoundedUtil.drawGradientRound(16, -11.0F, 27.0F, 27.0F, 4.0F, gradientColor1, gradientColor3, gradientColor2, gradientColor1); GL11.glDisable(3042); GL11.glEnable(3553); Stencil.erase(true); MinecraftInstance.mc.getTextureManager().bindTexture(this.resourcelocation3); GL11.glPushMatrix(); GL11.glScaled(0.7D, 0.7D, 0.7D); Gui.func_146110_a(20, -20, 0.0F, 0.0F, 45, 60, 45.0F, 45.0F); GL11.glPopMatrix(); Stencil.dispose(); GL11.glDepthMask(true); GL11.glDisable(3042); GL11.glEnable(2929); }  if (((Boolean)this.shadow.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); ShadowUtils.shadow(8.0F, new QQLogo2$drawElement$5(), new QQLogo2$drawElement$6()); GL11.glPopMatrix(); GL11.glScalef(getScale(), getScale(), getScale()); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  if (StringsKt.equals((String)this.OutmodeValue.get(), "more", true)) { updateAnim(); Color gradientColor1 = new Color(((Number)CustomColor.r.get()).intValue(), ((Number)CustomColor.g.get()).intValue(), ((Number)CustomColor.b.get()).intValue(), ((Number)CustomColor.a.get()).intValue()); Color gradientColor2 = new Color(((Number)CustomColor.r.get()).intValue(), ((Number)CustomColor.g.get()).intValue(), ((Number)CustomColor.b.get()).intValue(), ((Number)CustomColor.a.get()).intValue()); Color gradientColor3 = new Color(((Number)CustomColor.r2.get()).intValue(), ((Number)CustomColor.g2.get()).intValue(), ((Number)CustomColor.b2.get()).intValue(), ((Number)CustomColor.a2.get()).intValue()); Color gradientColor4 = new Color(((Number)CustomColor.r2.get()).intValue(), ((Number)CustomColor.g2.get()).intValue(), ((Number)CustomColor.b2.get()).intValue(), ((Number)CustomColor.a2.get()).intValue()); if (((Boolean)this.blurmodule.getBlurmoduleValue().get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  if (((Boolean)this.bV.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glPushMatrix(); BlurBuffer.blurRoundArea((float)getRenderX() + 9, (float)getRenderY() - 16, 100.0F, 36.0F, (int)6.4F); GL11.glPopMatrix(); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  RoundedUtil.drawGradientRound(9.0F, -16.0F, 100.0F, 36.0F, ((Number)CustomColor.ra.get()).floatValue(), ColorUtil.applyOpacity(gradientColor4, 0.85F), gradientColor1, gradientColor3, gradientColor2); CFontLoad.clientfont20.drawString("XSJ Client", 50.0F, -0.0F, (new Color(255, 255, 255, 255)).getRGB()); GL11.glDisable(2929); GL11.glEnable(3042); GL11.glDepthMask(false); OpenGlHelper.func_148821_a(770, 771, 1, 0); GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); if (!this.got) { Intrinsics.checkExpressionValueIsNotNull(this.bufferedImage2, "bufferedImage2"); MinecraftInstance.mc.getTextureManager().loadTexture(this.resourcelocation4, (IAbstractTexture)MinecraftInstance.classProvider.createDynamicTexture(this.bufferedImage2)); this.got = true; }  Stencil.write(false); GL11.glDisable(3553); GL11.glEnable(3042); GL11.glBlendFunc(770, 771); RoundedUtil.drawGradientRound(16, -11.0F, 27.0F, 27.0F, 4.0F, gradientColor1, gradientColor3, gradientColor2, gradientColor1); GL11.glDisable(3042); GL11.glEnable(3553); Stencil.erase(true); MinecraftInstance.mc.getTextureManager().bindTexture(this.resourcelocation3); GL11.glPushMatrix(); GL11.glScaled(0.7D, 0.7D, 0.7D); Gui.func_146110_a(20, -20, 0.0F, 0.0F, 45, 60, 45.0F, 45.0F); GL11.glPopMatrix(); Stencil.dispose(); GL11.glDepthMask(true); GL11.glDisable(3042); GL11.glEnable(2929); }  if (((Boolean)this.shadow.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); ShadowUtils.shadow(8.0F, new QQLogo2$drawElement$7(), new QQLogo2$drawElement$8()); GL11.glPopMatrix();
/* 471 */       GL11.glScalef(getScale(), getScale(), getScale());
/* 472 */       GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }
/*     */     
/* 474 */     return new Border(0.0F, -16.0F, 70.0F, 30.0F); }
/*     */   public final void setResourcelocation3(@NotNull IResourceLocation <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.resourcelocation3 = <set-?>; }
/*     */   public final BufferedImage getBufferedImage2() { return this.bufferedImage2; }
/*     */   @NotNull public final HUD getBlurmodule() { return this.blurmodule; }
/* 478 */   public final void setBlurmodule(@NotNull HUD <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.blurmodule = <set-?>; } public final void updateAnim() { if (Objects.requireNonNull(MinecraftInstance.mc.getThePlayer()) == null) Intrinsics.throwNpe();  float f1 = 2.0F, f2 = 8.5F, f4 = Objects.requireNonNull(MinecraftInstance.mc.getThePlayer()).getHealth() - this.easingHealth, f3 = this.easingHealth; QQLogo2 qQLogo2 = this; boolean bool = false; float f5 = (float)Math.pow(f1, f2); qQLogo2.easingHealth = f3 + f4 / f5 * RenderUtils.deltaTime; }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\QQLogo2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */