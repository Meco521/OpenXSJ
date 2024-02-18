/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.minecraft.network.play.client.CPacketEntityAction;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "KeepSprint", description = "Keep you sprint. Hypixel auto ban.永不止步", category = ModuleCategory.MOVEMENT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\016\020\003\032\0020\0042\006\020\005\032\0020\006¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/KeepSprint;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "onPacket", "", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "XSJClient"})
/*    */ public final class KeepSprint extends Module {
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/* 17 */     Intrinsics.checkParameterIsNotNull(event, "event"); IPacket packet = event.getPacket();
/* 18 */     if (packet instanceof CPacketEntityAction && (
/* 19 */       (CPacketEntityAction)packet).func_180764_b() == CPacketEntityAction.Action.STOP_SPRINTING)
/* 20 */       event.cancelEvent(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\KeepSprint.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */