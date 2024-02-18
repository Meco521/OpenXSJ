/*    */ package net.ccbluex.liquidbounce.utils;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.enums.WEnumHand;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayerDigging;
/*    */ import net.ccbluex.liquidbounce.injection.backend.WrapperImpl;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\000\030\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\032\t\020\000\032\0020\001H\b\032\021\020\002\032\0020\0012\006\020\003\032\0020\004H\b\032\033\020\002\032\0020\0012\b\020\005\032\004\030\0010\0062\006\020\003\032\0020\004H\b\032\035\020\007\032\004\030\0010\0012\b\020\005\032\004\030\0010\0062\006\020\003\032\0020\004H\b\032\035\020\b\032\004\030\0010\0012\b\020\005\032\004\030\0010\0062\006\020\003\032\0020\004H\b¨\006\t"}, d2 = {"createOpenInventoryPacket", "Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;", "createUseItemPacket", "hand", "Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;", "itemStack", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "createblockc07", "createblockc08c07", "XSJClient"})
/*    */ public final class CrossVersionUtilsKt {
/*    */   @NotNull
/*    */   public static final IPacket createUseItemPacket(@NotNull WEnumHand hand) {
/* 16 */     int $i$f$createUseItemPacket = 0; Intrinsics.checkParameterIsNotNull(hand, "hand");
/* 17 */     return (IPacket)WrapperImpl.INSTANCE.getClassProvider().createCPacketTryUseItem(hand);
/*    */   }
/*    */   @NotNull
/*    */   public static final IPacket createUseItemPacket(@Nullable IItemStack itemStack, @NotNull WEnumHand hand) {
/* 21 */     int $i$f$createUseItemPacket = 0; Intrinsics.checkParameterIsNotNull(hand, "hand");
/* 22 */     return 
/*    */ 
/*    */       
/* 25 */       (IPacket)WrapperImpl.INSTANCE.getClassProvider().createCPacketTryUseItem(hand);
/*    */   }
/*    */   @Nullable
/*    */   public static final IPacket createblockc08c07(@Nullable IItemStack itemStack, @NotNull WEnumHand hand) {
/* 29 */     int $i$f$createblockc08c07 = 0; Intrinsics.checkParameterIsNotNull(hand, "hand");
/* 30 */     return 
/*    */ 
/*    */ 
/*    */       
/* 34 */       WrapperImpl.INSTANCE.getClassProvider().createCPacketPlayerDigging(ICPacketPlayerDigging.WAction.RELEASE_USE_ITEM, WBlockPos.Companion.getORIGIN(), MinecraftInstance.classProvider.getEnumFacing(EnumFacingType.DOWN));
/*    */   }
/*    */   @Nullable
/*    */   public static final IPacket createblockc07(@Nullable IItemStack itemStack, @NotNull WEnumHand hand) {
/* 38 */     int $i$f$createblockc07 = 0; Intrinsics.checkParameterIsNotNull(hand, "hand");
/* 39 */     return 
/*    */ 
/*    */       
/* 42 */       (IPacket)WrapperImpl.INSTANCE.getClassProvider().createCPacketTryUseItem(hand);
/*    */   }
/*    */   @NotNull
/*    */   public static final IPacket createOpenInventoryPacket() {
/* 46 */     int $i$f$createOpenInventoryPacket = 0;
/*    */ 
/*    */ 
/*    */     
/* 50 */     if (Retreat.INSTANCE.getWrapper().getMinecraft().getThePlayer() == null) Intrinsics.throwNpe();  return (IPacket)WrapperImpl.INSTANCE.getClassProvider().createCPacketEntityAction((IEntity)Retreat.INSTANCE.getWrapper().getMinecraft().getThePlayer(), ICPacketEntityAction.WAction.OPEN_INVENTORY);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\CrossVersionUtilsKt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */