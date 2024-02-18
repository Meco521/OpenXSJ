/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element;
/*     */ 
/*     */ import kotlin.Metadata;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000,\n\002\030\002\n\002\020\000\n\000\n\002\020\007\n\002\b\021\n\002\020\002\n\000\n\002\020\013\n\002\b\002\n\002\020\b\n\000\n\002\020\016\n\000\b\b\030\0002\0020\001B%\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003\022\006\020\005\032\0020\003\022\006\020\006\032\0020\003¢\006\002\020\007J\t\020\017\032\0020\003HÆ\003J\t\020\020\032\0020\003HÆ\003J\t\020\021\032\0020\003HÆ\003J\t\020\022\032\0020\003HÆ\003J1\020\023\032\0020\0002\b\b\002\020\002\032\0020\0032\b\b\002\020\004\032\0020\0032\b\b\002\020\005\032\0020\0032\b\b\002\020\006\032\0020\003HÆ\001J\006\020\024\032\0020\025J\023\020\026\032\0020\0272\b\020\030\032\004\030\0010\001HÖ\003J\t\020\031\032\0020\032HÖ\001J\t\020\033\032\0020\034HÖ\001R\021\020\b\032\0020\003¢\006\b\n\000\032\004\b\t\020\nR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\013\020\nR\021\020\005\032\0020\003¢\006\b\n\000\032\004\b\f\020\nR\021\020\004\032\0020\003¢\006\b\n\000\032\004\b\r\020\nR\021\020\006\032\0020\003¢\006\b\n\000\032\004\b\016\020\n¨\006\035"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "", "x", "", "y", "x2", "y2", "(FFFF)V", "size", "getSize", "()F", "getX", "getX2", "getY", "getY2", "component1", "component2", "component3", "component4", "copy", "draw", "", "equals", "", "other", "hashCode", "", "toString", "", "XSJClient"})
/*     */ public final class Border
/*     */ {
/*     */   private final float size;
/*     */   private final float x;
/*     */   private final float y;
/*     */   private final float x2;
/*     */   private final float y2;
/*     */   
/*     */   public final float getX() {
/* 215 */     return this.x; } public final float getY() { return this.y; } public final float getX2() { return this.x2; } public final float getY2() { return this.y2; } public Border(float x, float y, float x2, float y2) { this.x = x; this.y = y; this.x2 = x2; this.y2 = y2;
/* 216 */     float f1 = this.x2 - this.x; Border border = this; boolean bool = false; float f2 = Math.abs(f1); f1 = this.y2 - this.y; f2 = f2; border = border; bool = false; float f3 = Math.abs(f1); border.size = f2 * f3; } public final float getSize() { return this.size; } public final void draw() {
/* 217 */     RenderUtils.drawBorderedRect(this.x, this.y, this.x2, this.y2, 3.0F, -2147483648, 0);
/*     */   }
/*     */   
/*     */   public final float component1() {
/*     */     return this.x;
/*     */   }
/*     */   
/*     */   public final float component2() {
/*     */     return this.y;
/*     */   }
/*     */   
/*     */   public final float component3() {
/*     */     return this.x2;
/*     */   }
/*     */   
/*     */   public final float component4() {
/*     */     return this.y2;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final Border copy(float x, float y, float x2, float y2) {
/*     */     return new Border(x, y, x2, y2);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String toString() {
/*     */     return "Border(x=" + this.x + ", y=" + this.y + ", x2=" + this.x2 + ", y2=" + this.y2 + ")";
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*     */     return ((Float.hashCode(this.x) * 31 + Float.hashCode(this.y)) * 31 + Float.hashCode(this.x2)) * 31 + Float.hashCode(this.y2);
/*     */   }
/*     */   
/*     */   public boolean equals(@Nullable Object paramObject) {
/*     */     if (this != paramObject) {
/*     */       if (paramObject instanceof Border) {
/*     */         Border border = (Border)paramObject;
/*     */         if (Float.compare(this.x, border.x) == 0 && Float.compare(this.y, border.y) == 0 && Float.compare(this.x2, border.x2) == 0 && Float.compare(this.y2, border.y2) == 0)
/*     */           return true; 
/*     */       } 
/*     */     } else {
/*     */       return true;
/*     */     } 
/*     */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\Border.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */