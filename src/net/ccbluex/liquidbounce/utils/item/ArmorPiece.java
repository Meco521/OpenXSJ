/*    */ package net.ccbluex.liquidbounce.utils.item;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*    */ 
/*    */ public class ArmorPiece
/*    */ {
/*    */   private final IItemStack itemStack;
/*    */   private final int slot;
/*    */   
/*    */   public ArmorPiece(IItemStack itemStack, int slot) {
/* 11 */     this.itemStack = itemStack;
/* 12 */     this.slot = slot;
/*    */   }
/*    */   
/*    */   public int getArmorType() {
/* 16 */     return this.itemStack.getItem().asItemArmor().getArmorType();
/*    */   }
/*    */   
/*    */   public int getSlot() {
/* 20 */     return this.slot;
/*    */   }
/*    */   
/*    */   public IItemStack getItemStack() {
/* 24 */     return this.itemStack;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\item\ArmorPiece.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */