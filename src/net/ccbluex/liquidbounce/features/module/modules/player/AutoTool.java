/*    */ package net.ccbluex.liquidbounce.features.module.modules.player;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.block.state.IIBlockState;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*    */ import net.ccbluex.liquidbounce.event.ClickBlockEvent;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "AutoTool", description = "Automatically selects the best tool in your inventory to mine a block.", category = ModuleCategory.PLAYER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000 \n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\006H\007J\016\020\007\032\0020\0042\006\020\b\032\0020\t¨\006\n"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/player/AutoTool;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "onClick", "", "event", "Lnet/ccbluex/liquidbounce/event/ClickBlockEvent;", "switchSlot", "blockPos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "XSJClient"})
/*    */ public final class AutoTool extends Module {
/*    */   @EventTarget
/*    */   public final void onClick(@NotNull ClickBlockEvent event) {
/* 15 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (event.getClickedBlock() != null) { switchSlot(event.getClickedBlock()); return; }  event.getClickedBlock();
/*    */   }
/*    */   
/*    */   public final void switchSlot(@NotNull WBlockPos blockPos) {
/* 19 */     Intrinsics.checkParameterIsNotNull(blockPos, "blockPos"); float bestSpeed = 1.0F;
/* 20 */     int bestSlot = -1;
/*    */     
/* 22 */     if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  IIBlockState blockState = MinecraftInstance.mc.getTheWorld().getBlockState(blockPos);
/*    */     
/* 24 */     for (byte b1 = 0, b2 = 8; b1 <= b2; b1++) {
/* 25 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getInventory().getStackInSlot(b1) != null) { IItemStack item = MinecraftInstance.mc.getThePlayer().getInventory().getStackInSlot(b1);
/* 26 */         float speed = item.getStrVsBlock(blockState);
/*    */         
/* 28 */         if (speed > bestSpeed) {
/* 29 */           bestSpeed = speed;
/* 30 */           bestSlot = b1;
/*    */         }  }
/*    */       else { MinecraftInstance.mc.getThePlayer().getInventory().getStackInSlot(b1); }
/*    */     
/* 34 */     }  if (bestSlot != -1) {
/* 35 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().getInventory().setCurrentItem(bestSlot);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\player\AutoTool.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */