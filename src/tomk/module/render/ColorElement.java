/*    */ package tomk.module.render;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ 
/*    */ 
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
/* 17 */     super("Color" + counter + "-" + m.getColorName(), 255, 0, 255);
/*    */   }
/*    */   
/*    */   public ColorElement(int counter, Material m) {
/* 21 */     super("Color" + counter + "-" + m.getColorName(), 255, 0, 255);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void onChanged(Integer oldValue, Integer newValue) {
/* 26 */     ColorMixer.regenerateColors(true);
/*    */   }
/*    */   
/*    */   enum Material {
/* 30 */     RED("Red"),
/* 31 */     GREEN("Green"),
/* 32 */     BLUE("Blue");
/*    */     private final String colName;
/*    */     
/*    */     Material(String name) {
/* 36 */       this.colName = name;
/*    */     }
/*    */     
/*    */     public String getColorName() {
/* 40 */       return this.colName;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\module\render\ColorElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */