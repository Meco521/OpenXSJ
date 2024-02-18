/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ElementInfo(name = "Model")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000R\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\003\n\002\020\007\n\000\n\002\020\013\n\002\b\003\n\002\030\002\n\000\n\002\020\002\n\002\b\003\n\002\030\002\n\000\b\007\030\0002\0020\001B\031\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003¢\006\002\020\005J\b\020\037\032\0020 H\026J \020!\032\0020\"2\006\020#\032\0020\0322\006\020$\032\0020\0322\006\020%\032\0020&H\002R\016\020\006\032\0020\007X\004¢\006\002\n\000R\021\020\b\032\0020\t¢\006\b\n\000\032\004\b\n\020\013R\021\020\f\032\0020\t¢\006\b\n\000\032\004\b\r\020\013R\016\020\016\032\0020\017X\004¢\006\002\n\000R\016\020\020\032\0020\007X\004¢\006\002\n\000R\016\020\021\032\0020\007X\004¢\006\002\n\000R\021\020\022\032\0020\t¢\006\b\n\000\032\004\b\023\020\013R\016\020\024\032\0020\017X\004¢\006\002\n\000R\016\020\025\032\0020\026X\004¢\006\002\n\000R\021\020\027\032\0020\t¢\006\b\n\000\032\004\b\030\020\013R\016\020\031\032\0020\032X\016¢\006\002\n\000R\016\020\033\032\0020\034X\016¢\006\002\n\000R\016\020\035\032\0020\007X\004¢\006\002\n\000R\016\020\036\032\0020\026X\004¢\006\002\n\000¨\006'"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Model;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "(DD)V", "BlurStrength", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "alpha", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "getAlpha", "()Lnet/ccbluex/liquidbounce/value/IntegerValue;", "b", "getB", "blur", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "customPitch", "customYaw", "g", "getG", "novoshadow", "pitchMode", "Lnet/ccbluex/liquidbounce/value/ListValue;", "r", "getR", "rotate", "", "rotateDirection", "", "shadowValue", "yawMode", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "drawEntityOnScreen", "", "yaw", "pitch", "entityLivingBase", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "XSJClient"})
/*     */ public final class Model extends Element {
/*     */   @NotNull
/*     */   private final IntegerValue r;
/*     */   @NotNull
/*     */   private final IntegerValue g;
/*     */   @NotNull
/*     */   private final IntegerValue b;
/*     */   @NotNull
/*     */   private final IntegerValue alpha;
/*     */   private final ListValue yawMode;
/*     */   private final FloatValue customYaw;
/*     */   private final FloatValue customPitch;
/*     */   private final ListValue pitchMode;
/*     */   private final FloatValue shadowValue;
/*     */   private final BoolValue novoshadow;
/*     */   private final FloatValue BlurStrength;
/*     */   private final BoolValue blur;
/*     */   private float rotate;
/*     */   private boolean rotateDirection;
/*     */   
/*     */   public Model(double x, double y) {
/*  29 */     super(x, y, 0.0F, null, 12, null);
/*  30 */     this.r = new IntegerValue("Red", 0, 0, 255);
/*  31 */     this.g = new IntegerValue("Green", 0, 0, 255);
/*  32 */     this.b = new IntegerValue("Blue", 0, 0, 255);
/*  33 */     this.alpha = new IntegerValue("BG-Alpha", 100, 0, 255);
/*  34 */     this.yawMode = new ListValue("Yaw", new String[] { "Player", "Custom" }, "Custom");
/*  35 */     this.customYaw = new FloatValue("CustomYaw", 0.0F, -180.0F, 180.0F);
/*  36 */     this.customPitch = new FloatValue("CustomPitch", 0.0F, -90.0F, 90.0F);
/*  37 */     this.pitchMode = new ListValue("Pitch", new String[] { "Player", "Custom" }, "Player");
/*  38 */     this.shadowValue = new FloatValue("ShadowStrength", 10.0F, 0.0F, 20.0F);
/*  39 */     this.novoshadow = new BoolValue("Shadow", true);
/*  40 */     this.BlurStrength = new FloatValue("BlurStrength", 5.0F, 0.0F, 20.0F);
/*  41 */     this.blur = new BoolValue("Blur", true);
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
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class Model$drawElement$1
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/*  67 */       GL11.glPushMatrix();
/*  68 */       GL11.glTranslated(Model.this.getRenderX(), Model.this.getRenderY(), 0.0D);
/*  69 */       GL11.glScalef(Model.this.getScale(), Model.this.getScale(), Model.this.getScale());
/*  70 */       GL11.glTranslated(-Model.this.getRenderX(), -Model.this.getRenderY(), 0.0D);
/*  71 */       GL11.glPushMatrix();
/*  72 */       RenderUtils.drawRoundedRect2((float)Model.this.getRenderX() - 40.0F, (float)Model.this.getRenderY() - 125.0F, 145.0F, 135.0F, 2.0F, (new Color(0, 0, 0)).getRGB());
/*  73 */       GL11.glPopMatrix();
/*  74 */       GL11.glTranslated(Model.this.getRenderX(), Model.this.getRenderY(), 0.0D);
/*  75 */       GL11.glPopMatrix();
/*     */     } Model$drawElement$1() { super(0); } }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*  78 */   static final class Model$drawElement$2 extends Lambda implements Function0<Unit> { public final void invoke() { GL11.glPushMatrix();
/*  79 */       GL11.glTranslated(Model.this.getRenderX(), Model.this.getRenderY(), 0.0D);
/*  80 */       GL11.glScalef(Model.this.getScale(), Model.this.getScale(), Model.this.getScale());
/*  81 */       GlStateManager.func_179147_l();
/*  82 */       GlStateManager.func_179090_x();
/*  83 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/*  84 */       GL11.glTranslated(-Model.this.getRenderX(), -Model.this.getRenderY(), 0.0D);
/*  85 */       GL11.glPushMatrix();
/*  86 */       RenderUtils.drawRoundedRect2((float)Model.this.getRenderX() - 40.0F, (float)Model.this.getRenderY() - 125.0F, 145.0F, 135.0F, 2.0F, (new Color(0, 0, 0)).getRGB());
/*  87 */       GL11.glPopMatrix();
/*  88 */       GL11.glTranslated(Model.this.getRenderX(), Model.this.getRenderY(), 0.0D);
/*  89 */       GlStateManager.func_179098_w();
/*  90 */       GlStateManager.func_179084_k();
/*  91 */       GL11.glPopMatrix(); }
/*     */     Model$drawElement$2() { super(0); } }
/*  93 */    @NotNull public final IntegerValue getR() { return this.r; } @NotNull public Border drawElement() { String str1 = (String)this.yawMode.get(); boolean bool2 = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str1 = str1.toLowerCase(); switch (str1.hashCode()) { case -1349088399: if (str1.equals("custom"));case -985752863: if (str1.equals("player")) if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  default: break; }  float yaw = 0.0F; String str2 = (String)this.pitchMode.get(); boolean bool3 = false; if (str2 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str2.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str2 = str2.toLowerCase(); switch (str2.hashCode()) { case -1349088399: if (str2.equals("custom"));case -985752863: if (str2.equals("player")) if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  default: break; }  float pitch = 0.0F; boolean bool1 = false; pitch = (pitch > false) ? -pitch : Math.abs(pitch); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  drawEntityOnScreen(yaw, pitch, (IEntityLivingBase)MinecraftInstance.mc.getThePlayer()); if (((Boolean)this.novoshadow.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); ShadowUtils.shadow(((Number)this.shadowValue.get()).floatValue(), new Model$drawElement$1(), new Model$drawElement$2()); GL11.glPopMatrix();
/*  94 */       GL11.glScalef(getScale(), getScale(), getScale());
/*  95 */       GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }
/*     */ 
/*     */     
/*  98 */     GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D);
/*  99 */     GL11.glPushMatrix();
/* 100 */     RoundedUtil.drawRound((float)getRenderX() - 40.0F, (float)getRenderY() - 125.0F, 140.0F, 140.0F, 2.0F, new Color(((Number)this.r.get()).intValue(), ((Number)this.g.get()).intValue(), ((Number)this.b.get()).intValue(), ((Number)this.alpha.get()).intValue()));
/* 101 */     GL11.glPopMatrix();
/* 102 */     GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */     
/* 104 */     if (((Boolean)this.blur.get()).booleanValue()) {
/* 105 */       GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D);
/* 106 */       GL11.glPushMatrix();
/* 107 */       BlurUtils.CustomBlurRoundArea((float)getRenderX() - 40.0F, (float)getRenderY() - 125.0F, 145.0F, 135.0F, 2.0F, ((Number)this.BlurStrength.get()).floatValue());
/* 108 */       GL11.glPopMatrix();
/* 109 */       GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */     } 
/*     */     
/* 112 */     RoundedUtil.drawRound(5.0F, -115.0F, 65.0F, 5.0F, 2.0F, new Color(255, 102, 20, 185));
/*     */     
/* 114 */     GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D);
/* 115 */     GL11.glPushMatrix();
/* 116 */     RoundedUtil.drawRoundOutline((float)getRenderX() - 40.0F, (float)getRenderY() - 125.0F, 140.0F, 135.0F, 2.0F, 0.1F, 
/* 117 */         new Color(240, 240, 240, 0), new Color(235, 235, 235, 230));
/* 118 */     GL11.glPopMatrix();
/* 119 */     GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */     
/* 121 */     Fonts.SF.SF_18.SF_18.drawString("ModelPlus", 16.0F, -113.0F, (new Color(0, 0, 0)).getRGB());
/*     */     
/* 123 */     IFontRenderer fontRenderer = Fonts.productSans35;
/*     */     
/* 125 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe(); 
/* 126 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double bps = Math.hypot(MinecraftInstance.mc.getThePlayer().getPosX() - MinecraftInstance.mc.getThePlayer().getPrevPosX(), MinecraftInstance.mc.getThePlayer().getPosZ() - MinecraftInstance.mc.getThePlayer().getPrevPosZ()) * 
/* 127 */       MinecraftInstance.mc.getTimer().getTimerSpeed() * 20;
/* 128 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  fontRenderer.drawString("Health: " + Text.Companion.getDECIMAL_FORMAT().format(Float.valueOf(MinecraftInstance.mc.getThePlayer().getHealth())), 18, 
/* 129 */         (int)(fontRenderer.getFontHeight() + 6.0F) - 80, (new Color(250, 250, 250, 255)).getRGB());
/* 130 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  fontRenderer.drawString("Ping: " + String.valueOf(EntityUtils.getPing((IEntityPlayer)MinecraftInstance.mc.getThePlayer())), 18, (int)((fontRenderer.getFontHeight() * 2) + 8.0F) - 80, (new Color(250, 250, 250, 255)).getRGB());
/* 131 */     fontRenderer.drawString("BPS: " + (Math.round(bps * 100.0D) / 100.0D), 18, (int)((fontRenderer.getFontHeight() * 3) + 10.0F) - 80, (new Color(250, 250, 250, 255)).getRGB());
/* 132 */     fontRenderer.drawString("XYZ: " + (int)MinecraftInstance.mc2.field_71439_g.field_70165_t + ", " + (int)MinecraftInstance.mc2.field_71439_g.field_70163_u + "," + (int)MinecraftInstance.mc2.field_71439_g.field_70161_v, 18, 
/* 133 */         (int)((fontRenderer.getFontHeight() * 4) + 12.0F) - 80, (new Color(250, 250, 250, 255)).getRGB());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 141 */     return new Border(40.0F, 20.0F, -50.0F, -150.0F); }
/*     */   @NotNull
/*     */   public final IntegerValue getG() { return this.g; }
/*     */   @NotNull
/*     */   public final IntegerValue getB() { return this.b; }
/*     */   @NotNull
/*     */   public final IntegerValue getAlpha() { return this.alpha; } private final void drawEntityOnScreen(float yaw, float pitch, IEntityLivingBase entityLivingBase) {
/* 148 */     MinecraftInstance.classProvider.getGlStateManager().resetColor();
/* 149 */     MinecraftInstance.classProvider.getGlStateManager().enableColorMaterial();
/* 150 */     GL11.glPushMatrix();
/* 151 */     GL11.glTranslatef(0.0F, 0.0F, 50.0F);
/* 152 */     GL11.glScalef(-50.0F, 50.0F, 50.0F);
/* 153 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/*     */     
/* 155 */     float renderYawOffset = entityLivingBase.getRenderYawOffset();
/* 156 */     float rotationYaw = entityLivingBase.getRotationYaw();
/* 157 */     float rotationPitch = entityLivingBase.getRotationPitch();
/* 158 */     float prevRotationYawHead = entityLivingBase.getPrevRotationYawHead();
/* 159 */     float rotationYawHead = entityLivingBase.getRotationYawHead();
/*     */     
/* 161 */     GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
/* 162 */     MinecraftInstance.functions.enableStandardItemLighting();
/* 163 */     GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
/* 164 */     float f1 = pitch / 40.0F; boolean bool = false; GL11.glRotatef(-((float)Math.atan(f1)) * 20.0F, 1.0F, 0.0F, 0.0F);
/*     */     
/* 166 */     f1 = yaw / 40.0F; IEntityLivingBase iEntityLivingBase = entityLivingBase; bool = false; float f2 = (float)Math.atan(f1); iEntityLivingBase.setRenderYawOffset(f2 * 20.0F);
/* 167 */     f1 = yaw / 40.0F; iEntityLivingBase = entityLivingBase; bool = false; f2 = (float)Math.atan(f1); iEntityLivingBase.setRotationYaw(f2 * 40.0F);
/* 168 */     f1 = pitch / 40.0F; iEntityLivingBase = entityLivingBase; bool = false; f2 = (float)Math.atan(f1); iEntityLivingBase.setRotationPitch(-f2 * 20.0F);
/* 169 */     entityLivingBase.setRotationYawHead(entityLivingBase.getRotationYaw());
/* 170 */     entityLivingBase.setPrevRotationYawHead(entityLivingBase.getRotationYaw());
/*     */     
/* 172 */     GL11.glTranslatef(0.0F, 0.0F, 0.0F);
/*     */     
/* 174 */     IRenderManager renderManager = MinecraftInstance.mc.getRenderManager();
/* 175 */     renderManager.setPlayerViewY(180.0F);
/* 176 */     renderManager.setRenderShadow(false);
/* 177 */     renderManager.renderEntityWithPosYaw(entityLivingBase, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
/* 178 */     renderManager.setRenderShadow(true);
/*     */     
/* 180 */     entityLivingBase.setRenderYawOffset(renderYawOffset);
/* 181 */     entityLivingBase.setRotationYaw(rotationYaw);
/* 182 */     entityLivingBase.setRotationPitch(rotationPitch);
/* 183 */     entityLivingBase.setPrevRotationYawHead(prevRotationYawHead);
/* 184 */     entityLivingBase.setRotationYawHead(rotationYawHead);
/*     */     
/* 186 */     GL11.glPopMatrix();
/* 187 */     MinecraftInstance.functions.disableStandardItemLighting();
/* 188 */     MinecraftInstance.classProvider.getGlStateManager().disableRescaleNormal();
/* 189 */     MinecraftInstance.functions.setActiveTextureLightMapTexUnit();
/* 190 */     MinecraftInstance.classProvider.getGlStateManager().disableTexture2D();
/* 191 */     MinecraftInstance.functions.setActiveTextureDefaultTexUnit();
/* 192 */     MinecraftInstance.classProvider.getGlStateManager().resetColor();
/*     */   }
/*     */   
/*     */   public Model() {
/*     */     this(0.0D, 0.0D, 3, (DefaultConstructorMarker)null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\Model.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */