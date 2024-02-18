/*     */ package net.ccbluex.liquidbounce.event;
/*     */ 
/*     */ import kotlin.Metadata;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\004\n\002\020\013\n\002\b\f\n\002\020\002\n\002\b\002\030\0002\0020\001B\035\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003\022\006\020\005\032\0020\003¢\006\002\020\006J\006\020\024\032\0020\025J\006\020\026\032\0020\025R\032\020\007\032\0020\bX\016¢\006\016\n\000\032\004\b\007\020\t\"\004\b\n\020\013R\032\020\002\032\0020\003X\016¢\006\016\n\000\032\004\b\f\020\r\"\004\b\016\020\017R\032\020\004\032\0020\003X\016¢\006\016\n\000\032\004\b\020\020\r\"\004\b\021\020\017R\032\020\005\032\0020\003X\016¢\006\016\n\000\032\004\b\022\020\r\"\004\b\023\020\017¨\006\027"}, d2 = {"Lnet/ccbluex/liquidbounce/event/MoveEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "x", "", "y", "z", "(DDD)V", "isSafeWalk", "", "()Z", "setSafeWalk", "(Z)V", "getX", "()D", "setX", "(D)V", "getY", "setY", "getZ", "setZ", "zero", "", "zeroXZ", "XSJClient"})
/*     */ public final class MoveEvent
/*     */   extends CancellableEvent
/*     */ {
/*     */   private boolean isSafeWalk;
/*     */   private double x;
/*     */   private double y;
/*     */   private double z;
/*     */   
/*     */   public final double getX() {
/* 100 */     return this.x; } public final void setX(double <set-?>) { this.x = <set-?>; } public final double getY() { return this.y; } public final void setY(double <set-?>) { this.y = <set-?>; } public final double getZ() { return this.z; } public final void setZ(double <set-?>) { this.z = <set-?>; } public MoveEvent(double x, double y, double z) { this.x = x; this.y = y; this.z = z; }
/* 101 */   public final boolean isSafeWalk() { return this.isSafeWalk; } public final void setSafeWalk(boolean <set-?>) { this.isSafeWalk = <set-?>; }
/*     */   
/*     */   public final void zero() {
/* 104 */     this.x = 0.0D;
/* 105 */     this.y = 0.0D;
/* 106 */     this.z = 0.0D;
/*     */   }
/*     */   
/*     */   public final void zeroXZ() {
/* 110 */     this.x = 0.0D;
/* 111 */     this.z = 0.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\event\MoveEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */