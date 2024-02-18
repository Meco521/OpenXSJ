/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.IEntityOtherPlayerMP;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ 
/*    */ @ModuleInfo(name = "FreeCam", description = "Allows you to move out of your body.", category = ModuleCategory.RENDER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000<\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\006\n\002\b\003\n\002\030\002\n\000\n\002\020\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\016\032\0020\017H\026J\b\020\020\032\0020\017H\026J\020\020\021\032\0020\0172\006\020\022\032\0020\023H\007J\022\020\024\032\0020\0172\b\020\022\032\004\030\0010\025H\007R\020\020\003\032\004\030\0010\004X\016¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\006X\004¢\006\002\n\000R\016\020\b\032\0020\tX\016¢\006\002\n\000R\016\020\n\032\0020\tX\016¢\006\002\n\000R\016\020\013\032\0020\tX\016¢\006\002\n\000R\016\020\f\032\0020\rX\004¢\006\002\n\000¨\006\026"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/FreeCam;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "fakePlayer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP;", "flyValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "noClipValue", "oldX", "", "oldY", "oldZ", "speedValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onDisable", "", "onEnable", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class FreeCam extends Module {
/* 16 */   private final FloatValue speedValue = new FloatValue("Speed", 0.8F, 0.1F, 2.0F);
/* 17 */   private final BoolValue flyValue = new BoolValue("Fly", true);
/* 18 */   private final BoolValue noClipValue = new BoolValue("NoClip", true);
/*    */   
/*    */   private IEntityOtherPlayerMP fakePlayer;
/*    */   
/*    */   private double oldX;
/*    */   private double oldY;
/*    */   private double oldZ;
/*    */   
/*    */   public void onEnable() {
/* 27 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 29 */       this.oldX = thePlayer.getPosX();
/* 30 */       this.oldY = thePlayer.getPosY();
/* 31 */       this.oldZ = thePlayer.getPosZ();
/*    */       
/* 33 */       if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  IEntityOtherPlayerMP playerMP = MinecraftInstance.classProvider.createEntityOtherPlayerMP(MinecraftInstance.mc.getTheWorld(), thePlayer.getGameProfile());
/*    */ 
/*    */       
/* 36 */       playerMP.setRotationYawHead(thePlayer.getRotationYawHead());
/* 37 */       playerMP.setRenderYawOffset(thePlayer.getRenderYawOffset());
/* 38 */       playerMP.setRotationYawHead(thePlayer.getRotationYawHead());
/* 39 */       playerMP.copyLocationAndAnglesFrom(thePlayer);
/*    */       
/* 41 */       if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getTheWorld().addEntityToWorld(-1000, (IEntity)playerMP);
/*    */       
/* 43 */       if (((Boolean)this.noClipValue.get()).booleanValue()) {
/* 44 */         thePlayer.setNoClip(true);
/*    */       }
/* 46 */       this.fakePlayer = playerMP;
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer(); } public void onDisable() {
/* 50 */     IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */     
/* 52 */     if (thePlayer == null || this.fakePlayer == null) {
/*    */       return;
/*    */     }
/* 55 */     thePlayer.setPositionAndRotation(this.oldX, this.oldY, this.oldZ, thePlayer.getRotationYaw(), thePlayer.getRotationPitch());
/*    */     
/* 57 */     if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  if (this.fakePlayer == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getTheWorld().removeEntityFromWorld(this.fakePlayer.getEntityId());
/* 58 */     this.fakePlayer = (IEntityOtherPlayerMP)null;
/*    */     
/* 60 */     thePlayer.setMotionX(0.0D);
/* 61 */     thePlayer.setMotionY(0.0D);
/* 62 */     thePlayer.setMotionZ(0.0D);
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@Nullable UpdateEvent event) {
/* 67 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */     
/* 69 */     if (((Boolean)this.noClipValue.get()).booleanValue()) {
/* 70 */       thePlayer.setNoClip(true);
/*    */     }
/* 72 */     thePlayer.setFallDistance(0.0F);
/*    */     
/* 74 */     if (((Boolean)this.flyValue.get()).booleanValue()) {
/* 75 */       float value = ((Number)this.speedValue.get()).floatValue();
/*    */       
/* 77 */       thePlayer.setMotionY(0.0D);
/* 78 */       thePlayer.setMotionX(0.0D);
/* 79 */       thePlayer.setMotionZ(0.0D);
/*    */       
/* 81 */       if (MinecraftInstance.mc.getGameSettings().getKeyBindJump().isKeyDown()) {
/* 82 */         thePlayer.setMotionY(thePlayer.getMotionY() + value);
/*    */       }
/* 84 */       if (MinecraftInstance.mc.getGameSettings().getKeyBindSneak().isKeyDown()) {
/* 85 */         thePlayer.setMotionY(thePlayer.getMotionY() - value);
/*    */       }
/* 87 */       MovementUtils.strafe(value);
/*    */     } 
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/* 93 */     Intrinsics.checkParameterIsNotNull(event, "event"); IPacket packet = event.getPacket();
/*    */     
/* 95 */     if (MinecraftInstance.classProvider.isCPacketPlayer(packet) || MinecraftInstance.classProvider.isCPacketEntityAction(packet))
/* 96 */       event.cancelEvent(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\FreeCam.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */