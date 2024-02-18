/*    */ package net.ccbluex.liquidbounce.utils.render;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.utils.Translate;
/*    */ import net.minecraft.potion.Potion;
/*    */ 
/*    */ public class PotionData {
/*    */   public final Potion potion;
/*  8 */   public int maxTimer = 0;
/*  9 */   public float animationX = 0.0F;
/*    */   public final Translate translate;
/*    */   
/*    */   public PotionData(Potion potion, Translate translate, int level) {
/* 13 */     this.potion = potion;
/* 14 */     this.translate = translate;
/* 15 */     this.level = level;
/*    */   }
/*    */   public final int level;
/*    */   public float getAnimationX() {
/* 19 */     return this.animationX;
/*    */   }
/*    */   
/*    */   public Potion getPotion() {
/* 23 */     return this.potion;
/*    */   }
/*    */   
/*    */   public int getMaxTimer() {
/* 27 */     return this.maxTimer;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\PotionData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */