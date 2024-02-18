/*    */ package net.ccbluex.liquidbounce.features.module.modules.hyt;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.injection.backend.PacketImpl;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.network.NetHandlerPlayClient;
/*    */ import net.minecraft.entity.player.PlayerCapabilities;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.play.client.CPacketPlayer;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "HytPUBGMoveDis", description = "HYT吃鸡移动屏蔽器", category = ModuleCategory.HYT)
/*    */ public class HytPUBGMoveDis extends Module {
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/* 22 */     Intrinsics.checkParameterIsNotNull(event, "event");
/* 23 */     IPacket $this$unwrap$iv = event.getPacket();
/* 24 */     int $i$f$unwrap = 0;
/* 25 */     Packet packet = ((PacketImpl)$this$unwrap$iv).getWrapped();
/* 26 */     IPacket packet2 = event.getPacket();
/* 27 */     if (MinecraftInstance.classProvider.isSPacketEntityVelocity(packet2)) {
/* 28 */       event.cancelEvent();
/*    */     }
/* 30 */     if (packet instanceof CPacketPlayer) {
/* 31 */       ((CPacketPlayer)packet).field_149474_g = false;
/* 32 */       PlayerCapabilities capabilities = new PlayerCapabilities();
/* 33 */       capabilities.field_75102_a = false;
/* 34 */       capabilities.field_75100_b = true;
/* 35 */       capabilities.field_75101_c = false;
/* 36 */       capabilities.field_75098_d = false;
/* 37 */       Minecraft mc2 = MinecraftInstance.mc2;
/* 38 */       Intrinsics.checkExpressionValueIsNotNull(mc2, "mc2");
/* 39 */       Minecraft mc3 = MinecraftInstance.mc2;
/* 40 */       Intrinsics.checkExpressionValueIsNotNull(mc3, "mc2");
/* 41 */       NetHandlerPlayClient netHandler = mc3.field_71439_g.field_71174_a;
/* 42 */       if (netHandler == null)
/* 43 */         Intrinsics.throwNpe(); 
/*    */     } 
/*    */   }
/*    */   
/*    */   public String getTag() {
/* 48 */     return "PUBGDisabler";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\hyt\HytPUBGMoveDis.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */