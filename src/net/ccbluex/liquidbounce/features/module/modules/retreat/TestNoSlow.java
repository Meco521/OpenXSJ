/*    */ package net.ccbluex.liquidbounce.features.module.modules.retreat;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.TypeCastException;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.item.IItem;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*    */ import net.ccbluex.liquidbounce.event.SlowDownEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.MovementUtils;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.play.client.CPacketConfirmTransaction;
/*    */ import net.minecraft.network.play.client.CPacketHeldItemChange;
/*    */ import net.minecraft.network.play.client.CPacketPlayerDigging;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ @ModuleInfo(name = "TestNoSlow", description = "Cancels slowness effects caused by soulsand and using items.", category = ModuleCategory.RETREAT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0000\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\007\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\032\020\003\032\0020\0042\b\020\005\032\004\030\0010\0062\006\020\007\032\0020\bH\002J\020\020\t\032\0020\n2\006\020\013\032\0020\fH\007J\020\020\r\032\0020\n2\006\020\013\032\0020\016H\007¨\006\017"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/retreat/TestNoSlow;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "getMultiplier", "", "item", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "isForward", "", "onMotion", "", "event", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onSlowDown", "Lnet/ccbluex/liquidbounce/event/SlowDownEvent;", "XSJClient"})
/*    */ public final class TestNoSlow
/*    */   extends Module
/*    */ {
/*    */   @EventTarget
/*    */   public final void onMotion(@NotNull MotionEvent event) {
/* 36 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHeldItem() != null) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHeldItem() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHeldItem().getItem() instanceof net.minecraft.item.ItemSword) {
/* 37 */         Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2"); if (MinecraftInstance.mc2.func_147114_u() == null) Intrinsics.throwNpe();  MinecraftInstance.mc2.func_147114_u().func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.field_177992_a, EnumFacing.DOWN));
/* 38 */         Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2"); if (MinecraftInstance.mc2.func_147114_u() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc2.func_147114_u().func_147297_a((Packet)new CPacketHeldItemChange((MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItem() + 1) % 9));
/* 39 */         Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2"); if (MinecraftInstance.mc2.func_147114_u() == null) Intrinsics.throwNpe();  MinecraftInstance.mc2.func_147114_u().func_147297_a((Packet)new CPacketConfirmTransaction(2147483647, (short)Short.MAX_VALUE, true));
/* 40 */         Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2"); if (MinecraftInstance.mc2.func_147114_u() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc2.func_147114_u().func_147297_a((Packet)new CPacketHeldItemChange(MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItem()));
/*    */       }  }
/* 42 */      if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 44 */       IItemStack heldItem = thePlayer.getHeldItem();
/* 45 */       if (heldItem == null || !MinecraftInstance.classProvider.isItemSword(heldItem.getItem()) || !MovementUtils.isMoving()) {
/*    */         return;
/*    */       }
/* 48 */       if (Retreat.INSTANCE.getModuleManager().get(KillAura.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura");  KillAura killAura = (KillAura)Retreat.INSTANCE.getModuleManager().get(KillAura.class);
/* 49 */       if (!thePlayer.isBlocking()) {
/*    */         return;
/*    */       }
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer();
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onSlowDown(@NotNull SlowDownEvent event) {
/* 59 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().getHeldItem(); IItem heldItem = (MinecraftInstance.mc.getThePlayer().getHeldItem() != null) ? MinecraftInstance.mc.getThePlayer().getHeldItem().getItem() : null;
/*    */     
/* 61 */     event.setForward(getMultiplier(heldItem, true));
/* 62 */     event.setStrafe(getMultiplier(heldItem, false));
/*    */   }
/*    */   
/*    */   private final float getMultiplier(IItem item, boolean isForward) {
/* 66 */     return (
/* 67 */       MinecraftInstance.classProvider.isItemFood(item) || MinecraftInstance.classProvider.isItemPotion(item) || MinecraftInstance.classProvider.isItemBucketMilk(item)) ? (
/* 68 */       isForward ? 0.2F : 0.2F) : (
/*    */       
/* 70 */       MinecraftInstance.classProvider.isItemSword(item) ? (
/* 71 */       isForward ? 1.0F : 1.0F) : (
/*    */       
/* 73 */       MinecraftInstance.classProvider.isItemBow(item) ? (
/* 74 */       isForward ? 0.2F : 0.2F) : 
/*    */       
/* 76 */       0.2F));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\retreat\TestNoSlow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */