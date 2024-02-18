/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element;@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000f\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\007\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\n\002\020\013\n\002\b\005\n\002\030\002\n\002\b\003\n\002\020\016\n\002\b\032\n\002\020 \n\002\b\007\n\002\020\002\n\002\b\t\n\002\020\f\n\000\n\002\020\b\n\002\b\007\b&\030\0002\0020\001B-\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006\022\b\b\002\020\007\032\0020\b¢\006\002\020\tJ(\020A\032\0020B2\006\020\002\032\0020\0062\006\020\004\032\0020\0062\006\020C\032\0020\0062\006\020D\032\0020\006H\004J\b\020E\032\0020\025H\026J\b\020F\032\0020BH\026J\022\020G\032\0020B2\b\b\002\020H\032\0020\006H\026J\n\020I\032\004\030\0010\017H&J\030\020J\032\0020B2\006\020K\032\0020L2\006\020M\032\0020NH\026J \020O\032\0020B2\006\020\002\032\0020\0032\006\020\004\032\0020\0032\006\020P\032\0020NH\026J\030\020Q\032\0020\0252\006\020\002\032\0020\0032\006\020\004\032\0020\003H\026J\b\020R\032\0020BH\026J\b\020S\032\0020BH\026J\b\020T\032\0020BH\026R\032\020\n\032\b\022\004\022\0020\0060\013X\004¢\006\b\n\000\032\004\b\f\020\rR\034\020\016\032\004\030\0010\017X\016¢\006\016\n\000\032\004\b\020\020\021\"\004\b\022\020\023R\032\020\024\032\0020\025X\016¢\006\016\n\000\032\004\b\026\020\027\"\004\b\030\020\031R\021\020\032\032\0020\033¢\006\b\n\000\032\004\b\034\020\035R\021\020\036\032\0020\0378F¢\006\006\032\004\b \020!R\032\020\"\032\0020\006X\016¢\006\016\n\000\032\004\b#\020$\"\004\b%\020&R\032\020'\032\0020\006X\016¢\006\016\n\000\032\004\b(\020$\"\004\b)\020&R$\020+\032\0020\0032\006\020*\032\0020\0038F@FX\016¢\006\f\032\004\b,\020-\"\004\b.\020/R$\0200\032\0020\0032\006\020*\032\0020\0038F@FX\016¢\006\f\032\004\b1\020-\"\004\b2\020/R&\020\005\032\0020\0062\006\020*\032\0020\0068F@FX\016¢\006\016\n\000\032\004\b3\020$\"\004\b4\020&R\032\020\007\032\0020\bX\016¢\006\016\n\000\032\004\b5\0206\"\004\b7\0208R\036\0209\032\f\022\b\022\006\022\002\b\0030\0130:8VX\004¢\006\006\032\004\b;\020<R\032\020\002\032\0020\003X\016¢\006\016\n\000\032\004\b=\020-\"\004\b>\020/R\032\020\004\032\0020\003X\016¢\006\016\n\000\032\004\b?\020-\"\004\b@\020/¨\006U"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "x", "", "y", "scale", "", "side", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;", "(DDFLnet/ccbluex/liquidbounce/ui/client/hud/element/Side;)V", "blurValue", "Lnet/ccbluex/liquidbounce/value/Value;", "getBlurValue", "()Lnet/ccbluex/liquidbounce/value/Value;", "border", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "getBorder", "()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "setBorder", "(Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;)V", "drag", "", "getDrag", "()Z", "setDrag", "(Z)V", "info", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementInfo;", "getInfo", "()Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementInfo;", "name", "", "getName", "()Ljava/lang/String;", "prevMouseX", "getPrevMouseX", "()F", "setPrevMouseX", "(F)V", "prevMouseY", "getPrevMouseY", "setPrevMouseY", "value", "renderX", "getRenderX", "()D", "setRenderX", "(D)V", "renderY", "getRenderY", "setRenderY", "getScale", "setScale", "getSide", "()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;", "setSide", "(Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;)V", "values", "", "getValues", "()Ljava/util/List;", "getX", "setX", "getY", "setY", "blur", "", "x2", "y2", "createElement", "destroyElement", "drawBoarderBlur", "blurRadius", "drawElement", "handleKey", "c", "", "keyCode", "", "handleMouseClick", "mouseButton", "isInBorder", "shader", "shadow", "updateElement", "XSJClient"})
/*     */ public abstract class Element extends MinecraftInstance { @NotNull
/*     */   private final ElementInfo info; private float scale; @Nullable
/*     */   private Border border; private boolean drag;
/*     */   private float prevMouseX;
/*     */   private float prevMouseY;
/*     */   @NotNull
/*     */   private final Value<Float> blurValue;
/*     */   private double x;
/*     */   private double y;
/*     */   @NotNull
/*     */   private Side side;
/*     */   
/*  14 */   public final double getX() { return this.x; } public final void setX(double <set-?>) { this.x = <set-?>; } public final double getY() { return this.y; } public final void setY(double <set-?>) { this.y = <set-?>; }
/*  15 */   public Element(double x, double y, float scale, @NotNull Side side) { this.x = x; this.y = y; this.side = side;
/*  16 */     if ((ElementInfo)getClass().<Annotation>getAnnotation(ElementInfo.class) != null) { this
/*  17 */         .info = getClass().<Annotation>getAnnotation(ElementInfo.class);
/*     */       
/*  19 */       this.scale = 1.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  33 */       setScale(scale);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  74 */       this.blurValue = (new FloatValue("Blur", 0.0F, 0.0F, 100.0F)).displayable(new Element$blurValue$1()); return; }  (ElementInfo)getClass().<Annotation>getAnnotation(ElementInfo.class); throw (Throwable)new IllegalArgumentException("Passed element with missing element info"); } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class Element$blurValue$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return Element.this.getInfo().blur(); } Element$blurValue$1() { super(0); } } @NotNull public final Side getSide() { return this.side; } public final void setSide(@NotNull Side <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.side = <set-?>; } @NotNull public final ElementInfo getInfo() { return this.info; } public final void setScale(float value) { if (this.info.disableScale()) return;  this.scale = value; } public final float getScale() { if (this.info.disableScale()) return 1.0F;  return this.scale; } @NotNull public final String getName() { return this.info.name(); } public final double getRenderX() { switch (Element$WhenMappings.$EnumSwitchMapping$0[this.side.getHorizontal().ordinal()]) { case 1: case 2: Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc");case 3: Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc"); }  throw new NoWhenBranchMatchedException(); } public final void setRenderX(double value) { switch (Element$WhenMappings.$EnumSwitchMapping$1[this.side.getHorizontal().ordinal()]) { case 1: this.x += value; return;case 2: case 3: this.x -= value; return; }  throw new NoWhenBranchMatchedException(); } public final double getRenderY() { switch (Element$WhenMappings.$EnumSwitchMapping$2[this.side.getVertical().ordinal()]) { case 1: case 2: Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc");case 3: Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc"); }  throw new NoWhenBranchMatchedException(); } @NotNull protected final Value<Float> getBlurValue() { return this.blurValue; }
/*     */   public final void setRenderY(double value) { switch (Element$WhenMappings.$EnumSwitchMapping$3[this.side.getVertical().ordinal()]) { case 1: this.y += value; return;case 2: case 3: this.y -= value; return; }  throw new NoWhenBranchMatchedException(); }
/*     */   @Nullable public final Border getBorder() { return this.border; }
/*     */   public final void setBorder(@Nullable Border <set-?>) { this.border = <set-?>; }
/*     */   public final boolean getDrag() { return this.drag; }
/*  79 */   public final void setDrag(boolean <set-?>) { this.drag = <set-?>; } public final float getPrevMouseX() { return this.prevMouseX; } public final void setPrevMouseX(float <set-?>) { this.prevMouseX = <set-?>; } public final float getPrevMouseY() { return this.prevMouseY; } public final void setPrevMouseY(float <set-?>) { this.prevMouseY = <set-?>; } @NotNull public List<Value<?>> getValues() { Intrinsics.checkExpressionValueIsNotNull(getClass().getDeclaredFields(), "javaClass.declaredFields"); Field[] arrayOfField1 = getClass().getDeclaredFields(); int $i$f$map = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 220 */     Field[] arrayOfField2 = arrayOfField1; Collection<Object> collection1 = new ArrayList(arrayOfField1.length); int $i$f$mapTo = 0;
/* 221 */     for (Field item$iv$iv : arrayOfField2) {
/* 222 */       Object object1 = item$iv$iv; Collection<Object> collection = collection1; int $i$a$-map-Element$values$1 = 0; Intrinsics.checkExpressionValueIsNotNull(object1, "valueField"); object1.setAccessible(true); Object object2 = object1.get(this); collection.add(object2);
/* 223 */     }  Iterable $this$filterIsInstance$iv = collection1; int $i$f$filterIsInstance = 0;
/* 224 */     Iterable iterable1 = $this$filterIsInstance$iv; Collection<Object> destination$iv$iv = new ArrayList(); int $i$f$filterIsInstanceTo = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 231 */     for (Object element$iv$iv : iterable1) { if (element$iv$iv instanceof Value) destination$iv$iv.add(element$iv$iv);  }
/* 232 */      return (List)destination$iv$iv; }
/*     */ 
/*     */   
/*     */   public boolean createElement() {
/*     */     return true;
/*     */   }
/*     */   
/*     */   public void shader() {}
/*     */   
/*     */   public void destroyElement() {}
/*     */   
/*     */   public void shadow() {}
/*     */   
/*     */   public void updateElement() {}
/*     */   
/*     */   public boolean isInBorder(double x, double y) {
/*     */     if (this.border != null) {
/*     */       Border border = this.border;
/*     */       float f1 = border.getX(), f2 = border.getX2();
/*     */       boolean bool1 = false;
/*     */       float minX = Math.min(f1, f2);
/*     */       f2 = border.getY();
/*     */       float f3 = border.getY2();
/*     */       boolean bool2 = false;
/*     */       float minY = Math.min(f2, f3);
/*     */       f3 = border.getX();
/*     */       float f4 = border.getX2();
/*     */       boolean bool3 = false;
/*     */       float maxX = Math.max(f3, f4);
/*     */       f4 = border.getY();
/*     */       float f5 = border.getY2();
/*     */       boolean bool4 = false;
/*     */       float maxY = Math.max(f4, f5);
/*     */       return (minX <= x && minY <= y && maxX >= x && maxY >= y);
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public void drawBoarderBlur(float blurRadius) {
/*     */     if (this.border != null && blurRadius != 0.0F) {
/*     */       if (this.border == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       if (this.border.getSize() != 0.0F) {
/*     */         if (this.border == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         if (this.border == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         float posX = (float)getRenderX() + RangesKt.coerceAtMost(this.border.getX(), this.border.getX2());
/*     */         if (this.border == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         if (this.border == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         float posY = (float)getRenderY() + RangesKt.coerceAtMost(this.border.getY(), this.border.getY2());
/*     */         if (this.border == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         if (this.border == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         float f1 = this.border.getX2() - this.border.getX();
/*     */         boolean bool1 = false;
/*     */         float width = Math.abs(f1);
/*     */         if (this.border == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         if (this.border == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         float f2 = this.border.getY2() - this.border.getY();
/*     */         boolean bool2 = false;
/*     */         float height = Math.abs(f2);
/*     */         BlurUtils.INSTANCE.draw(posX * getScale(), posY * getScale(), width * getScale(), height * getScale(), blurRadius);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected final void blur(float x, float y, float x2, float y2) {
/*     */     if (((Number)this.blurValue.get()).floatValue() == 0.0F)
/*     */       return; 
/*     */     float f1 = x2 - x, f3 = (float)(getRenderY() + RangesKt.coerceAtMost(y, y2)) * getScale(), f2 = (float)(getRenderX() + RangesKt.coerceAtMost(x, x2)) * getScale();
/*     */     BlurUtils blurUtils = BlurUtils.INSTANCE;
/*     */     boolean bool = false;
/*     */     float f4 = Math.abs(f1);
/*     */     f1 = y2 - y;
/*     */     f4 *= getScale();
/*     */     f3 = f3;
/*     */     f2 = f2;
/*     */     blurUtils = blurUtils;
/*     */     bool = false;
/*     */     float f5 = Math.abs(f1);
/*     */     blurUtils.draw(f2, f3, f4, f5 * getScale(), ((Number)this.blurValue.get()).floatValue());
/*     */   }
/*     */   
/*     */   public void handleMouseClick(double x, double y, int mouseButton) {}
/*     */   
/*     */   public void handleKey(char c, int keyCode) {}
/*     */   
/*     */   @Nullable
/*     */   public abstract Border drawElement();
/*     */   
/*     */   public Element() {
/*     */     this(0.0D, 0.0D, 0.0F, null, 15, null);
/*     */   } }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\Element.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */