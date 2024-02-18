/*    */ package net.ccbluex.liquidbounce.script.api.global;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\002\n\000\n\002\020\016\n\000\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\006H\007¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/script/api/global/Chat;", "", "()V", "print", "", "message", "", "XSJClient"})
/*    */ public final class Chat {
/*    */   static {
/*  8 */     Chat chat = new Chat();
/*    */   }
/*    */ 
/*    */   
/*    */   public static final Chat INSTANCE;
/*    */ 
/*    */   
/*    */   @JvmStatic
/*    */   public static final void print(@NotNull String message) {
/* 17 */     Intrinsics.checkParameterIsNotNull(message, "message"); ClientUtils.displayChatMessage(message);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\script\api\global\Chat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */