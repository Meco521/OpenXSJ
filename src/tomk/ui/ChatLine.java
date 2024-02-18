/*    */ package tomk.ui;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.minecraft.util.text.ITextComponent;
/*    */ import tomk.utils.animation.SmoothAnimationTimer;
/*    */ 
/*    */ 
/*    */ public class ChatLine
/*    */   extends MinecraftInstance
/*    */ {
/*    */   private final int updateCounterCreated;
/*    */   private final ITextComponent lineString;
/* 13 */   public SmoothAnimationTimer posXTimer = new SmoothAnimationTimer(1.0F, 0.4F);
/* 14 */   public SmoothAnimationTimer posYTimer = new SmoothAnimationTimer(1.0F, 0.4F);
/* 15 */   public SmoothAnimationTimer alphaTimer = new SmoothAnimationTimer(1.0F, 0.15F);
/* 16 */   public float tempY = 0.0F;
/* 17 */   public float y = 0.0F;
/*    */   
/*    */   private final int chatLineID;
/*    */   public boolean a;
/*    */   
/*    */   public ChatLine(int p_i45000_1_, ITextComponent p_i45000_2_, int p_i45000_3_) {
/* 23 */     this.lineString = p_i45000_2_;
/* 24 */     this.updateCounterCreated = p_i45000_1_;
/* 25 */     this.chatLineID = p_i45000_3_;
/*    */   }
/*    */ 
/*    */   
/*    */   public ITextComponent getChatComponent() {
/* 30 */     return this.lineString;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getUpdatedCounter() {
/* 35 */     return this.updateCounterCreated;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getChatLineID() {
/* 40 */     return this.chatLineID;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\ui\ChatLine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */