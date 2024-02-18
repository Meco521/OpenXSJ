/*    */ package net.ccbluex.liquidbounce.features.special;@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\034\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\b\n\002\b\b\n\002\020\013\n\002\b\003\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002R\016\020\003\032\0020\004XT¢\006\002\n\000R\016\020\005\032\0020\004XT¢\006\002\n\000R$\020\007\032\0020\0042\006\020\006\032\0020\004@FX\016¢\006\016\n\000\032\004\b\b\020\t\"\004\b\n\020\013R\036\020\016\032\0020\r2\006\020\f\032\0020\r@BX\016¢\006\b\n\000\032\004\b\016\020\017¨\006\020"}, d2 = {"Lnet/ccbluex/liquidbounce/features/special/AutoReconnect;", "", "()V", "MAX", "", "MIN", "value", "delay", "getDelay", "()I", "setDelay", "(I)V", "<set-?>", "", "isEnabled", "()Z", "XSJClient"})
/*    */ public final class AutoReconnect { public static final int MAX = 60000;
/*    */   static {
/*  4 */     AutoReconnect autoReconnect = new AutoReconnect();
/*    */   }
/*    */   public static final int MIN = 1000; private static boolean isEnabled = true;
/*    */   public final boolean isEnabled() {
/*  8 */     return isEnabled;
/*    */   }
/* 10 */   private static int delay = 5000; public static final AutoReconnect INSTANCE; public final int getDelay() { return delay; }
/*    */    public final void setDelay(int value) {
/* 12 */     isEnabled = (value < 60000);
/*    */     
/* 14 */     delay = value;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\special\AutoReconnect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */