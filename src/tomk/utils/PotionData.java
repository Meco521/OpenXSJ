/*    */ package tomk.utils;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.minecraft.potion.IPotion;
/*    */ 
/*    */ public class PotionData {
/*    */   public final IPotion potion;
/*  7 */   public int maxTimer = 0;
/*  8 */   public float animationX = 0.0F;
/*    */   public final Translate translate;
/*    */   
/*    */   public PotionData(IPotion potion, Translate translate, int level) {
/* 12 */     this.potion = potion;
/* 13 */     this.translate = translate;
/* 14 */     this.level = level;
/*    */   }
/*    */   public final int level;
/*    */   public float getAnimationX() {
/* 18 */     return this.animationX;
/*    */   }
/*    */   
/*    */   public IPotion getPotion() {
/* 22 */     return this.potion;
/*    */   }
/*    */   
/*    */   public int getMaxTimer() {
/* 26 */     return this.maxTimer;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\PotionData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */