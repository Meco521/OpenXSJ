/*    */ package net.ccbluex.liquidbounce.injection.backend;@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000(\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\000\n\002\020\b\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\001\n\000\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\t\020\r\032\0020\016H\bR\016\020\003\032\0020\004XT¢\006\002\n\000R\016\020\005\032\0020\006XT¢\006\002\n\000R\016\020\007\032\0020\006XT¢\006\002\n\000R\016\020\b\032\0020\006XT¢\006\002\n\000R\021\020\t\032\0020\n¢\006\b\n\000\032\004\b\013\020\f¨\006\017"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/Backend;", "", "()V", "MINECRAFT_VERSION", "", "MINECRAFT_VERSION_MAJOR", "", "MINECRAFT_VERSION_MINOR", "MINECRAFT_VERSION_PATCH", "REPRESENTED_BACKEND_VERSION", "Lnet/ccbluex/liquidbounce/api/MinecraftVersion;", "getREPRESENTED_BACKEND_VERSION", "()Lnet/ccbluex/liquidbounce/api/MinecraftVersion;", "BACKEND_UNSUPPORTED", "", "XSJClient"})
/*    */ public final class Backend { @NotNull
/*    */   public static final String MINECRAFT_VERSION = "1.12.2";
/*    */   static {
/*  5 */     Backend backend = new Backend();
/*    */   }
/*    */   public static final int MINECRAFT_VERSION_MAJOR = 1; public static final int MINECRAFT_VERSION_MINOR = 12;
/*    */   public static final int MINECRAFT_VERSION_PATCH = 2;
/*    */   @NotNull
/* 10 */   private static final MinecraftVersion REPRESENTED_BACKEND_VERSION = MinecraftVersion.MC_1_12; public static final Backend INSTANCE; @NotNull public final MinecraftVersion getREPRESENTED_BACKEND_VERSION() { return REPRESENTED_BACKEND_VERSION; }
/*    */    @NotNull
/*    */   public final Void BACKEND_UNSUPPORTED() {
/* 13 */     int $i$f$BACKEND_UNSUPPORTED = 0; throw (Throwable)new NotImplementedError("1.12.2 doesn't support this feature'");
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\Backend.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */