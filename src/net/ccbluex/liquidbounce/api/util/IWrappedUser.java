/*    */ package net.ccbluex.liquidbounce.api.util;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.win32.StdCallLibrary;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface IWrappedUser
/*    */   extends StdCallLibrary
/*    */ {
/* 13 */   public static final IWrappedUser INSTANCE = (IWrappedUser)Native.loadLibrary("user32", IWrappedUser.class);
/*    */   
/*    */   boolean EnumWindows(WNDENUMPROC paramWNDENUMPROC, Pointer paramPointer);
/*    */   
/*    */   int GetWindowTextA(Pointer paramPointer, byte[] paramArrayOfbyte, int paramInt);
/*    */   
/*    */   public static interface WNDENUMPROC extends StdCallLibrary.StdCallCallback {
/*    */     boolean callback(Pointer param1Pointer1, Pointer param1Pointer2);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\ap\\util\IWrappedUser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */