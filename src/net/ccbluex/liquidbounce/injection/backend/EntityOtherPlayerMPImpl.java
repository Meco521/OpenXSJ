/*   */ package net.ccbluex.liquidbounce.injection.backend;
/*   */ import net.minecraft.client.entity.EntityOtherPlayerMP;
/*   */ 
/*   */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\026\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\030\000*\b\b\000\020\001*\0020\0022\b\022\004\022\002H\0010\0032\0020\004B\r\022\006\020\005\032\0028\000¢\006\002\020\006¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/EntityOtherPlayerMPImpl;", "T", "Lnet/minecraft/client/entity/EntityOtherPlayerMP;", "Lnet/ccbluex/liquidbounce/injection/backend/EntityPlayerImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP;", "wrapped", "(Lnet/minecraft/client/entity/EntityOtherPlayerMP;)V", "XSJClient"})
/*   */ public final class EntityOtherPlayerMPImpl<T extends EntityOtherPlayerMP> extends EntityPlayerImpl<T> implements IEntityOtherPlayerMP {
/*   */   public EntityOtherPlayerMPImpl(@NotNull EntityOtherPlayerMP wrapped) {
/* 7 */     super((T)wrapped);
/*   */   }
/*   */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\EntityOtherPlayerMPImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */