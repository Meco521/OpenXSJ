/*    */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements.utils;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0008\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\020\007\n\002\b\003\n\002\030\002\n\002\b\023\n\002\020\006\n\002\b\n\n\002\020\002\n\002\b\003\n\002\020\013\n\002\b\004\030\0002\0020\001B/\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\005\022\006\020\007\032\0020\005\022\b\b\002\020\b\032\0020\t¢\006\002\020\nJ8\020'\032\0020(2\006\020)\032\0020\0052\006\020*\032\0020\0052\006\020+\032\0020,2\006\020-\032\0020\0052\006\020.\032\0020\0052\b\b\002\020/\032\0020,R\032\020\013\032\0020\005X\016¢\006\016\n\000\032\004\b\f\020\r\"\004\b\016\020\017R\032\020\002\032\0020\003X\016¢\006\016\n\000\032\004\b\020\020\021\"\004\b\022\020\023R\032\020\004\032\0020\005X\016¢\006\016\n\000\032\004\b\024\020\r\"\004\b\025\020\017R\032\020\006\032\0020\005X\016¢\006\016\n\000\032\004\b\026\020\r\"\004\b\027\020\017R\032\020\b\032\0020\tX\016¢\006\016\n\000\032\004\b\030\020\031\"\004\b\032\020\033R\032\020\034\032\0020\035X\016¢\006\016\n\000\032\004\b\036\020\037\"\004\b \020!R\032\020\007\032\0020\005X\016¢\006\016\n\000\032\004\b\"\020\r\"\004\b#\020\017R\032\020$\032\0020\005X\016¢\006\016\n\000\032\004\b%\020\r\"\004\b&\020\017¨\0060"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/utils/Particle;", "", "color", "Ljava/awt/Color;", "distX", "", "distY", "radius", "drawType", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/utils/ShapeType;", "(Ljava/awt/Color;FFFLnet/ccbluex/liquidbounce/ui/client/hud/element/elements/utils/ShapeType;)V", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "getColor", "()Ljava/awt/Color;", "setColor", "(Ljava/awt/Color;)V", "getDistX", "setDistX", "getDistY", "setDistY", "getDrawType", "()Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/utils/ShapeType;", "setDrawType", "(Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/utils/ShapeType;)V", "progress", "", "getProgress", "()D", "setProgress", "(D)V", "getRadius", "setRadius", "rotate", "getRotate", "setRotate", "render", "", "x", "y", "fade", "", "speed", "fadeSpeed", "canRotate", "XSJClient"})
/*    */ public final class Particle {
/*    */   private float alpha;
/*    */   private double progress;
/*    */   private float rotate;
/*    */   @NotNull
/*    */   private Color color;
/*    */   
/*    */   @NotNull
/* 13 */   public final Color getColor() { return this.color; } private float distX; private float distY; private float radius; @NotNull private ShapeType drawType; public final void setColor(@NotNull Color <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.color = <set-?>; } public final float getDistX() { return this.distX; } public final void setDistX(float <set-?>) { this.distX = <set-?>; } public final float getDistY() { return this.distY; } public final void setDistY(float <set-?>) { this.distY = <set-?>; } public final float getRadius() { return this.radius; } public final void setRadius(float <set-?>) { this.radius = <set-?>; } @NotNull public final ShapeType getDrawType() { return this.drawType; } public final void setDrawType(@NotNull ShapeType <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.drawType = <set-?>; } public Particle(@NotNull Color color, float distX, float distY, float radius, @NotNull ShapeType drawType) { this.color = color; this.distX = distX; this.distY = distY; this.radius = radius; this.drawType = drawType;
/* 14 */     this.alpha = 1.0F; } public final float getAlpha() { return this.alpha; } public final void setAlpha(float <set-?>) { this.alpha = <set-?>; }
/* 15 */   public final double getProgress() { return this.progress; } public final void setProgress(double <set-?>) { this.progress = <set-?>; }
/* 16 */   public final float getRotate() { return this.rotate; } public final void setRotate(float <set-?>) { this.rotate = <set-?>; }
/*    */    public final void render(float x, float y, boolean fade, float speed, float fadeSpeed, boolean canRotate) {
/* 18 */     if (this.progress >= 1.0D) {
/* 19 */       this.progress = 1.0D;
/* 20 */       if (fade) this.alpha -= fadeSpeed * 0.02F * RenderUtils.deltaTime; 
/* 21 */       if (this.alpha < 0.0F) this.alpha = 0.0F; 
/*    */     } else {
/* 23 */       this.progress += (speed * 0.025F * RenderUtils.deltaTime);
/*    */     } 
/* 25 */     if (this.alpha <= 0.0F)
/*    */       return; 
/* 27 */     Color reColored = new Color(this.color.getRed() / 255.0F, this.color.getGreen() / 255.0F, this.color.getBlue() / 255.0F, this.alpha);
/* 28 */     float easeOut = (float)EaseUtils.easeOutQuart(this.progress);
/*    */     
/* 30 */     if (canRotate && this.drawType != ShapeType.SOLID_CIRCLE && this.drawType != ShapeType.CIRCLE) {
/* 31 */       this.rotate += 10.0F * (1.0F - easeOut);
/* 32 */       GL11.glPushMatrix();
/* 33 */       GL11.glTranslatef(x + this.distX * easeOut, y + this.distY * easeOut, 0.0F);
/* 34 */       GL11.glPushMatrix();
/* 35 */       GL11.glRotatef(this.rotate, 0.0F, 0.0F, 1.0F);
/* 36 */       this.drawType.performRendering(0.0F, 0.0F, this.radius, reColored);
/* 37 */       GL11.glPopMatrix();
/* 38 */       GL11.glPopMatrix();
/*    */     } else {
/* 40 */       this.drawType.performRendering(x + this.distX * easeOut, y + this.distY * easeOut, this.radius, reColored);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\element\\utils\Particle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */