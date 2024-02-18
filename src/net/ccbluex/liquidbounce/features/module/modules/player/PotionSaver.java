/*    */ package net.ccbluex.liquidbounce.features.module.modules.player;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ 
/*    */ @ModuleInfo(name = "PotionSaver", description = "Freezes all potion effects while you are standing still.", category = ModuleCategory.PLAYER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\006H\007¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/player/PotionSaver;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "onPacket", "", "e", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "XSJClient"})
/*    */ public final class PotionSaver extends Module {
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent e) {
/* 15 */     Intrinsics.checkParameterIsNotNull(e, "e"); IPacket packet = e.getPacket();
/*    */     
/* 17 */     if (MinecraftInstance.classProvider.isCPacketPlayer(packet) && !MinecraftInstance.classProvider.isCPacketPlayerPosition(packet) && !MinecraftInstance.classProvider.isCPacketPlayerPosLook(packet) && 
/* 18 */       !MinecraftInstance.classProvider.isCPacketPlayerPosLook(packet) && MinecraftInstance.mc.getThePlayer() != null) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().isUsingItem())
/* 19 */         e.cancelEvent();  }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\player\PotionSaver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */