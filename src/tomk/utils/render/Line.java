/*    */ package tomk.utils.render;
/*    */ 
/*    */ import net.minecraft.util.text.ITextComponent;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import tomk.utils.animation.SmoothAnimationTimer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class Line
/*    */ {
/* 16 */   public SmoothAnimationTimer posXTimer = new SmoothAnimationTimer(1.0F, 0.4F);
/* 17 */   public SmoothAnimationTimer posYTimer = new SmoothAnimationTimer(1.0F, 0.4F);
/* 18 */   public SmoothAnimationTimer alphaTimer = new SmoothAnimationTimer(1.0F, 0.15F);
/* 19 */   public float tempY = 0.0F;
/* 20 */   public float y = 0.0F;
/*    */   
/*    */   private final int chatLineID;
/*    */   public boolean a;
/*    */   private final int updateCounterCreated;
/*    */   private final ITextComponent lineString;
/*    */   
/*    */   public Line(int p_i45000_1_, ITextComponent p_i45000_2_, int p_i45000_3_) {
/* 28 */     this.lineString = p_i45000_2_;
/* 29 */     this.updateCounterCreated = p_i45000_1_;
/* 30 */     this.chatLineID = p_i45000_3_;
/*    */   }
/*    */   
/*    */   public ITextComponent getChatComponent() {
/* 34 */     return this.lineString;
/*    */   }
/*    */   
/*    */   public int getUpdatedCounter() {
/* 38 */     return this.updateCounterCreated;
/*    */   }
/*    */   
/*    */   public int getChatLineID() {
/* 42 */     return this.chatLineID;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\render\Line.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */