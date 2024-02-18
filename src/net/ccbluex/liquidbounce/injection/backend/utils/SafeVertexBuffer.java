/*    */ package net.ccbluex.liquidbounce.injection.backend.utils;
/*    */ 
/*    */ import net.minecraft.client.renderer.vertex.VertexBuffer;
/*    */ import net.minecraft.client.renderer.vertex.VertexFormat;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SafeVertexBuffer
/*    */   extends VertexBuffer
/*    */ {
/*    */   public SafeVertexBuffer(VertexFormat vertexFormatIn) {
/* 14 */     super(vertexFormatIn);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void finalize() throws Throwable {
/* 19 */     func_177362_c();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backen\\utils\SafeVertexBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */