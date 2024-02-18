/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayer;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.world.Fucker;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.world.Scaffold;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "Rotations", description = "Allows you to see server-sided head and body rotations.", category = ModuleCategory.RENDER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000<\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\007\n\002\b\002\n\002\020\013\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\b\007\030\0002\0020\001B\005¢\006\002\020\002J\024\020\n\032\0020\0132\n\020\f\032\006\022\002\b\0030\rH\002J\020\020\016\032\0020\0172\006\020\020\032\0020\021H\007J\020\020\022\032\0020\0172\006\020\020\032\0020\023H\007J\b\020\024\032\0020\013H\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\022\020\007\032\004\030\0010\bX\016¢\006\004\n\002\020\t¨\006\025"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/Rotations;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "bodyValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "getBodyValue", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "playerYaw", "", "Ljava/lang/Float;", "getState", "", "module", "Ljava/lang/Class;", "onPacket", "", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "shouldRotate", "XSJClient"})
/*    */ public final class Rotations extends Module {
/*    */   @NotNull
/* 23 */   private final BoolValue bodyValue = new BoolValue("Body", true); private Float playerYaw; @NotNull public final BoolValue getBodyValue() { return this.bodyValue; }
/*    */ 
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public final void onRender3D(@NotNull Render3DEvent event) {
/* 29 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (RotationUtils.serverRotation != null && !((Boolean)this.bodyValue.get()).booleanValue())
/* 30 */       if (MinecraftInstance.mc.getThePlayer() != null) { MinecraftInstance.mc.getThePlayer().setRotationYawHead(RotationUtils.serverRotation.getYaw()); } else { MinecraftInstance.mc.getThePlayer(); }
/*    */        
/*    */   }
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/* 35 */     Intrinsics.checkParameterIsNotNull(event, "event"); IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */     
/* 37 */     if (!((Boolean)this.bodyValue.get()).booleanValue() || !shouldRotate() || thePlayer == null) {
/*    */       return;
/*    */     }
/* 40 */     IPacket packet = event.getPacket();
/*    */     
/* 42 */     if (MinecraftInstance.classProvider.isCPacketPlayerPosLook(packet) || MinecraftInstance.classProvider.isCPacketPlayerLook(packet)) {
/* 43 */       ICPacketPlayer packetPlayer = packet.asCPacketPlayer();
/*    */       
/* 45 */       this.playerYaw = Float.valueOf(packetPlayer.getYaw());
/*    */       
/* 47 */       thePlayer.setRenderYawOffset(packetPlayer.getYaw());
/* 48 */       thePlayer.setRotationYawHead(packetPlayer.getYaw());
/*    */     } else {
/* 50 */       if (this.playerYaw != null) {
/* 51 */         if (this.playerYaw == null) Intrinsics.throwNpe();  thePlayer.setRenderYawOffset(this.playerYaw.floatValue());
/*    */       } 
/* 53 */       thePlayer.setRotationYawHead(thePlayer.getRenderYawOffset());
/*    */     } 
/*    */   }
/*    */   private final boolean getState(Class module) {
/* 57 */     return Retreat.INSTANCE.getModuleManager().get(module).getState();
/*    */   }
/*    */   private final boolean shouldRotate() {
/* 60 */     if (Retreat.INSTANCE.getModuleManager().getModule(KillAura.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura");  KillAura killAura = (KillAura)Retreat.INSTANCE.getModuleManager().getModule(KillAura.class);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 65 */     return (getState(Scaffold.class) || getState(Scaffold2.class) || getState(Tower.class) || (getState(KillAura.class) && killAura.getTarget() != null) || getState(BowAimbot.class) || getState(Fucker.class) || getState(CivBreak.class) || getState(Nuker.class) || getState(ChestAura.class));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\Rotations.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */