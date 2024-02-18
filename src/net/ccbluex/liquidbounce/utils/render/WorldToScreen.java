/*    */ package net.ccbluex.liquidbounce.utils.render;
/*    */ 
/*    */ import java.nio.FloatBuffer;
/*    */ import org.lwjgl.BufferUtils;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ import org.lwjgl.util.vector.Matrix4f;
/*    */ import org.lwjgl.util.vector.Vector2f;
/*    */ import org.lwjgl.util.vector.Vector3f;
/*    */ import org.lwjgl.util.vector.Vector4f;
/*    */ 
/*    */ 
/*    */ public class WorldToScreen
/*    */ {
/*    */   public static Matrix4f getMatrix(int matrix) {
/* 15 */     FloatBuffer floatBuffer = BufferUtils.createFloatBuffer(16);
/*    */     
/* 17 */     GL11.glGetFloat(matrix, floatBuffer);
/*    */     
/* 19 */     return (Matrix4f)(new Matrix4f()).load(floatBuffer);
/*    */   }
/*    */   
/*    */   public static Vector2f worldToScreen(Vector3f pointInWorld, Matrix4f view, Matrix4f projection, int screenWidth, int screenHeight) {
/* 23 */     Vector4f clipSpacePos = multiply(multiply(new Vector4f(pointInWorld.x, pointInWorld.y, pointInWorld.z, 1.0F), view), projection);
/*    */     
/* 25 */     Vector3f ndcSpacePos = new Vector3f(clipSpacePos.x / clipSpacePos.w, clipSpacePos.y / clipSpacePos.w, clipSpacePos.z / clipSpacePos.w);
/*    */     
/* 27 */     float screenX = (ndcSpacePos.x + 1.0F) / 2.0F * screenWidth;
/* 28 */     float screenY = (1.0F - ndcSpacePos.y) / 2.0F * screenHeight;
/*    */     
/* 30 */     if (ndcSpacePos.z < -1.0D || ndcSpacePos.z > 1.0D) {
/* 31 */       return null;
/*    */     }
/*    */     
/* 34 */     return new Vector2f(screenX, screenY);
/*    */   }
/*    */   
/*    */   public static Vector4f multiply(Vector4f vec, Matrix4f mat) {
/* 38 */     return new Vector4f(vec.x * mat.m00 + vec.y * mat.m10 + vec.z * mat.m20 + vec.w * mat.m30, vec.x * mat.m01 + vec.y * mat.m11 + vec.z * mat.m21 + vec.w * mat.m31, vec.x * mat.m02 + vec.y * mat.m12 + vec.z * mat.m22 + vec.w * mat.m32, vec.x * mat.m03 + vec.y * mat.m13 + vec.z * mat.m23 + vec.w * mat.m33);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\WorldToScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */