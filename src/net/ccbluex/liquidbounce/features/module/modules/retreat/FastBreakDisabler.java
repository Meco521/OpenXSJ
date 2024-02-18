/*    */ package net.ccbluex.liquidbounce.features.module.modules.retreat;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.IMinecraft;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.injection.backend.MinecraftImpl;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.minecraft.client.network.NetHandlerPlayClient;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.play.client.CPacketPlayerDigging;
/*    */ 
/*    */ @ModuleInfo(name = "FastBreakDisabler", description = "Fastbreak disabler For HYT GrimAC Skid By 凡哥", category = ModuleCategory.RETREAT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\006H\007¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/retreat/FastBreakDisabler;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "onPacket", "", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "XSJClient"})
/*    */ public final class FastBreakDisabler extends Module {
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/* 17 */     Intrinsics.checkParameterIsNotNull(event, "event"); IPacket $this$unwrap$iv = event.getPacket(); int $i$f$unwrap = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 24 */     if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.PacketImpl<*>");  Packet pw = ((PacketImpl)$this$unwrap$iv).getWrapped(); if (pw instanceof CPacketPlayerDigging && ((CPacketPlayerDigging)pw).func_180762_c() == CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK) {
/* 25 */       Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc"); IMinecraft iMinecraft = MinecraftInstance.mc; int i = 0; if (iMinecraft == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.MinecraftImpl");  if (((MinecraftImpl)iMinecraft).getWrapped().func_147114_u() != null) { Intrinsics.checkExpressionValueIsNotNull(((MinecraftImpl)iMinecraft).getWrapped().func_147114_u(), "mc.unwrap().connection ?: return"); NetHandlerPlayClient connection = ((MinecraftImpl)iMinecraft).getWrapped().func_147114_u(); connection.func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.ABORT_DESTROY_BLOCK, ((CPacketPlayerDigging)pw).func_179715_a().func_177982_a(0, 500, 0), ((CPacketPlayerDigging)pw).func_179714_b())); return; }  ((MinecraftImpl)iMinecraft).getWrapped().func_147114_u();
/*    */       return;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\retreat\FastBreakDisabler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */