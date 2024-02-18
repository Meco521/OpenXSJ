/*    */ package net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.normal.TimerUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class Animation
/*    */ {
/* 15 */   public TimerUtil timerUtil = new TimerUtil();
/*    */   protected int duration;
/*    */   protected double endPoint;
/*    */   protected Direction direction;
/*    */   
/*    */   public Animation(int ms, double endPoint) {
/* 21 */     this.duration = ms;
/* 22 */     this.endPoint = endPoint;
/* 23 */     this.direction = Direction.FORWARDS;
/*    */   }
/*    */ 
/*    */   
/*    */   public Animation(int ms, double endPoint, Direction direction) {
/* 28 */     this.duration = ms;
/* 29 */     this.endPoint = endPoint;
/* 30 */     this.direction = direction;
/*    */   }
/*    */   
/*    */   public boolean finished(Direction direction) {
/* 34 */     return (isDone() && this.direction.equals(direction));
/*    */   }
/*    */   
/*    */   public double getLinearOutput() {
/* 38 */     return 1.0D - this.timerUtil.getTime() / this.duration * this.endPoint;
/*    */   }
/*    */   
/*    */   public double getEndPoint() {
/* 42 */     return this.endPoint;
/*    */   }
/*    */   
/*    */   public void setEndPoint(double endPoint) {
/* 46 */     this.endPoint = endPoint;
/*    */   }
/*    */   
/*    */   public void reset() {
/* 50 */     this.timerUtil.reset();
/*    */   }
/*    */   
/*    */   public boolean isDone() {
/* 54 */     return this.timerUtil.hasTimeElapsed(this.duration);
/*    */   }
/*    */   
/*    */   public void changeDirection() {
/* 58 */     setDirection(this.direction.opposite());
/*    */   }
/*    */   
/*    */   public Direction getDirection() {
/* 62 */     return this.direction;
/*    */   }
/*    */   
/*    */   public void setDirection(Direction direction) {
/* 66 */     if (this.direction != direction) {
/* 67 */       this.direction = direction;
/* 68 */       this.timerUtil.setTime(System.currentTimeMillis() - this.duration - Math.min(this.duration, this.timerUtil.getTime()));
/*    */     } 
/*    */   }
/*    */   
/*    */   public void setDuration(int duration) {
/* 73 */     this.duration = duration;
/*    */   }
/*    */   
/*    */   protected boolean correctOutput() {
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public double getOutput() {
/* 81 */     if (this.direction == Direction.FORWARDS) {
/* 82 */       if (isDone())
/* 83 */         return this.endPoint; 
/* 84 */       return getEquation(this.timerUtil.getTime()) * this.endPoint;
/*    */     } 
/* 86 */     if (isDone()) return 0.0D; 
/* 87 */     if (correctOutput()) {
/* 88 */       double revTime = Math.min(this.duration, Math.max(0L, this.duration - this.timerUtil.getTime()));
/* 89 */       return getEquation(revTime) * this.endPoint;
/* 90 */     }  return (1.0D - getEquation(this.timerUtil.getTime())) * this.endPoint;
/*    */   }
/*    */   
/*    */   protected abstract double getEquation(double paramDouble);
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\newdropdow\\utils\animations\Animation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */