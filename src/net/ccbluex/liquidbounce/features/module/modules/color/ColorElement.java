/*    */ package net.ccbluex.liquidbounce.features.module.modules.color;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ColorElement
/*    */   extends IntegerValue
/*    */ {
/*    */   public ColorElement(int counter, Material m, IntegerValue basis) {
/* 15 */     super("Color" + counter + "-" + m.getColorName(), 255, 0, 255);
/*    */   }
/*    */   
/*    */   public ColorElement(int counter, Material m) {
/* 19 */     super("Color" + counter + "-" + m.getColorName(), 255, 0, 255);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void onChanged(Integer oldValue, Integer newValue) {
/* 24 */     ColorMixer.regenerateColors(true);
/*    */   }
/*    */   
/*    */   enum Material {
/* 28 */     RED("Red"),
/* 29 */     GREEN("Green"),
/* 30 */     BLUE("Blue");
/*    */     private final String colName;
/*    */     
/*    */     Material(String name) {
/* 34 */       this.colName = name;
/*    */     }
/*    */     
/*    */     public String getColorName() {
/* 38 */       return this.colName;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\color\ColorElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */