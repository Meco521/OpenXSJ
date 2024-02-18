/*    */ package tomk.utils;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.item.IItem;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0000\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\006\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\013\n\002\b\002\n\002\020\016\n\002\b\002\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\003\032\0020\0042\006\020\005\032\0020\006J \020\007\032\004\030\0010\b2\006\020\t\032\0020\0042\006\020\n\032\0020\0042\006\020\013\032\0020\004J\006\020\f\032\0020\rJ\006\020\016\032\0020\rJ\016\020\017\032\0020\0202\006\020\021\032\0020\020¨\006\022"}, d2 = {"Ltomk/utils/PlayerUtils;", "", "()V", "getAr", "", "player", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "getBlockRelativeToPlayer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "offsetX", "offsetY", "offsetZ", "isBlockUnder", "", "isUsingFood", "randomUnicode", "", "str", "XSJClient"})
/*    */ public final class PlayerUtils {
/* 13 */   static { PlayerUtils playerUtils = new PlayerUtils(); } public static final PlayerUtils INSTANCE; @NotNull
/*    */   public final String randomUnicode(@NotNull String str) {
/* 15 */     Intrinsics.checkParameterIsNotNull(str, "str"); StringBuilder stringBuilder = new StringBuilder();
/* 16 */     String str1 = str; int i = 0; Intrinsics.checkExpressionValueIsNotNull(str1.toCharArray(), "(this as java.lang.String).toCharArray()"); for (char c : str1.toCharArray()) {
/* 17 */       if (Math.random() > 0.5D) { i = Character.hashCode(c); if (33 > i) { 128; } else if (128 >= i)
/* 18 */         { stringBuilder.append(Character.toChars(Character.hashCode(c) + 65248)); continue; }
/*    */          }
/* 20 */        stringBuilder.append(c);
/*    */       continue;
/*    */     } 
/* 23 */     Intrinsics.checkExpressionValueIsNotNull(stringBuilder.toString(), "stringBuilder.toString()"); return stringBuilder.toString();
/*    */   }
/*    */   public final boolean isUsingFood() {
/* 26 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getItemInUse() == null) Intrinsics.throwNpe();  IItem usingItem = MinecraftInstance.mc.getThePlayer().getItemInUse().getItem();
/* 27 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe(); 
/* 28 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  return (MinecraftInstance.mc.getThePlayer().getItemInUse() != null) ? ((MinecraftInstance.mc.getThePlayer().isUsingItem() && (usingItem instanceof net.minecraft.item.ItemFood || usingItem instanceof net.minecraft.item.ItemBucketMilk || usingItem instanceof net.minecraft.item.ItemPotion))) : false;
/*    */   }
/*    */   
/*    */   public final boolean isBlockUnder() {
/* 32 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getPosY() < false) return false; 
/* 33 */     int off = 0; while (true) {
/* 34 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (off < (int)MinecraftInstance.mc.getThePlayer().getPosY() + 2) {
/* 35 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IAxisAlignedBB bb = MinecraftInstance.mc.getThePlayer().getEntityBoundingBox()
/* 36 */           .offset(0.0D, -(off), 0.0D);
/* 37 */         if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe(); 
/* 38 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  Collection collection = MinecraftInstance.mc.getTheWorld().getCollidingBoundingBoxes((IEntity)MinecraftInstance.mc.getThePlayer(), 
/* 39 */             bb);
/* 40 */         boolean bool = false; if (!collection.isEmpty())
/*    */         {
/* 42 */           return true;
/*    */         }
/* 44 */         off += 2; continue;
/*    */       }  break;
/* 46 */     }  return false;
/*    */   }
/*    */   public final double getAr(@NotNull IEntityLivingBase player) {
/* 49 */     Intrinsics.checkParameterIsNotNull(player, "player"); double arPercentage = (player.getTotalArmorValue() / player.getMaxHealth());
/* 50 */     arPercentage = MathHelper.func_151237_a(arPercentage, 0.0D, 1.0D);
/* 51 */     return 100 * arPercentage;
/*    */   } @Nullable
/*    */   public final IBlock getBlockRelativeToPlayer(double offsetX, double offsetY, double offsetZ) {
/* 54 */     if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();
/*    */     
/* 56 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe(); 
/* 57 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe(); 
/* 58 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  return MinecraftInstance.mc.getTheWorld().getBlockState(new WBlockPos(MinecraftInstance.mc.getThePlayer().getPosX() + offsetX, MinecraftInstance.mc.getThePlayer().getPosY() + offsetY, MinecraftInstance.mc.getThePlayer().getPosZ() + offsetZ)).getBlock();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\PlayerUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */