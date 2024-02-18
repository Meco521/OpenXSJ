/*    */ package tomk.utils;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\000\n\002\030\002\n\000\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\003\032\0020\0042\b\020\005\032\004\030\0010\006¨\006\007"}, d2 = {"Ltomk/utils/LiYingUtilK;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "()V", "getPing", "", "entityPlayer", "Lnet/minecraft/entity/player/EntityPlayer;", "XSJClient"})
/*    */ public final class LiYingUtilK extends MinecraftInstance {
/*    */   static {
/*  7 */     LiYingUtilK liYingUtilK = new LiYingUtilK();
/*    */   } public static final LiYingUtilK INSTANCE; public final int getPing(@Nullable EntityPlayer entityPlayer) {
/*  9 */     if (entityPlayer == null) return 0; 
/* 10 */     Intrinsics.checkExpressionValueIsNotNull(entityPlayer.func_110124_au(), "entityPlayer.uniqueID"); INetworkPlayerInfo networkPlayerInfo = MinecraftInstance.mc.getNetHandler().getPlayerInfo(entityPlayer.func_110124_au());
/* 11 */     return (networkPlayerInfo != null) ? networkPlayerInfo.getResponseTime() : 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\LiYingUtilK.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */