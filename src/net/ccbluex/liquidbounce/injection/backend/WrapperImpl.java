/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.IExtractedFunctions;
/*    */ import net.ccbluex.liquidbounce.api.util.IWrappedUser;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000,\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002R\024\020\003\032\0020\004X\004¢\006\b\n\000\032\004\b\005\020\006R\024\020\007\032\0020\bX\004¢\006\b\n\000\032\004\b\t\020\nR\024\020\013\032\0020\f8VX\004¢\006\006\032\004\b\r\020\016R\024\020\017\032\0020\0208VX\004¢\006\006\032\004\b\021\020\022¨\006\023"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/WrapperImpl;", "Lnet/ccbluex/liquidbounce/api/Wrapper;", "()V", "classProvider", "Lnet/ccbluex/liquidbounce/api/IClassProvider;", "getClassProvider", "()Lnet/ccbluex/liquidbounce/api/IClassProvider;", "functions", "Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;", "getFunctions", "()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;", "microsoftUser", "Lnet/ccbluex/liquidbounce/api/util/IWrappedUser;", "getMicrosoftUser", "()Lnet/ccbluex/liquidbounce/api/util/IWrappedUser;", "minecraft", "Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;", "getMinecraft", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;", "XSJClient"})
/*    */ public final class WrapperImpl implements Wrapper {
/* 11 */   static { WrapperImpl wrapperImpl = new WrapperImpl(); } @NotNull
/* 12 */   private static final IClassProvider classProvider = ClassProviderImpl.INSTANCE; @NotNull public IClassProvider getClassProvider() { return classProvider; }
/*    */   @NotNull
/* 14 */   public IMinecraft getMinecraft() { Intrinsics.checkExpressionValueIsNotNull(Minecraft.func_71410_x(), "Minecraft.getMinecraft()"); return new MinecraftImpl(Minecraft.func_71410_x()); }
/*    */   @NotNull
/* 16 */   public IWrappedUser getMicrosoftUser() { Intrinsics.checkExpressionValueIsNotNull(IWrappedUser.INSTANCE, "IWrappedUser.INSTANCE"); return IWrappedUser.INSTANCE; } @NotNull
/* 17 */   private static final IExtractedFunctions functions = ExtractedFunctionsImpl.INSTANCE; public static final WrapperImpl INSTANCE; @NotNull public IExtractedFunctions getFunctions() { return functions; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\WrapperImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */