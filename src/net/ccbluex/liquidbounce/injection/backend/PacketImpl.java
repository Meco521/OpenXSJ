/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import kotlin.TypeCastException;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.play.server.SPacketAnimation;
/*    */ import net.minecraft.network.play.server.SPacketCloseWindow;
/*    */ import net.minecraft.network.play.server.SPacketWindowItems;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000~\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\006\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\020\000\n\000\b\026\030\000*\f\b\000\020\001*\006\022\002\b\0030\0022\0020\003B\r\022\006\020\004\032\0028\000¢\006\002\020\005J\b\020\t\032\0020\nH\026J\b\020\013\032\0020\fH\026J\b\020\r\032\0020\016H\026J\b\020\017\032\0020\020H\026J\b\020\021\032\0020\022H\026J\b\020\023\032\0020\024H\026J\b\020\025\032\0020\026H\026J\b\020\027\032\0020\030H\026J\b\020\031\032\0020\032H\026J\b\020\033\032\0020\034H\026J\b\020\035\032\0020\036H\026J\b\020\037\032\0020 H\026J\b\020!\032\0020\"H\026J\b\020#\032\0020$H\026J\b\020%\032\0020&H\026J\b\020'\032\0020(H\026J\023\020)\032\0020*2\b\020+\032\004\030\0010,H\002R\023\020\004\032\0028\000¢\006\n\n\002\020\b\032\004\b\006\020\007¨\006-"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/PacketImpl;", "T", "Lnet/minecraft/network/Packet;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;", "wrapped", "(Lnet/minecraft/network/Packet;)V", "getWrapped", "()Lnet/minecraft/network/Packet;", "Lnet/minecraft/network/Packet;", "asCPacketChatMessage", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketChatMessage;", "asCPacketCustomPayload", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketCustomPayload;", "asCPacketHandshake", "Lnet/ccbluex/liquidbounce/api/minecraft/network/handshake/client/ICPacketHandshake;", "asCPacketHeldItemChange", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;", "asCPacketPlayer", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;", "asCPacketPlayerDigging", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging;", "asCPacketUseEntity", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity;", "asSPacketAnimation", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketAnimation;", "asSPacketChat", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketChat;", "asSPacketCloseWindow", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ISPacketCloseWindow;", "asSPacketEntity", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketEntity;", "asSPacketEntityVelocity", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketEntityVelocity;", "asSPacketPosLook", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketPosLook;", "asSPacketResourcePackSend", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketResourcePackSend;", "asSPacketTabComplete", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketTabComplete;", "asSPacketWindowItems", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketWindowItems;", "equals", "", "other", "", "XSJClient"})
/*    */ public class PacketImpl<T extends Packet<?>> implements IPacket {
/*    */   @NotNull
/* 13 */   public final T getWrapped() { return this.wrapped; } @NotNull private final T wrapped; public PacketImpl(@NotNull Packet wrapped) { this.wrapped = (T)wrapped; } @NotNull
/* 14 */   public ISPacketChat asSPacketChat() { if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketChat");  return new SPacketChatImpl<>((SPacketChat)this.wrapped); }
/*    */   @NotNull
/* 16 */   public ISPacketAnimation asSPacketAnimation() { if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketAnimation");  return new SPacketAnimationImpl<>((SPacketAnimation)this.wrapped); }
/*    */   @NotNull
/* 18 */   public ISPacketEntity asSPacketEntity() { if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketEntity");  return new SPacketEntityImpl<>((SPacketEntity)this.wrapped); }
/*    */   @NotNull
/* 20 */   public ICPacketPlayer asCPacketPlayer() { if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketPlayer");  return new CPacketPlayerImpl<>((CPacketPlayer)this.wrapped); }
/*    */   @NotNull
/* 22 */   public ICPacketUseEntity asCPacketUseEntity() { if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketUseEntity");  return new CPacketUseEntityImpl<>((CPacketUseEntity)this.wrapped); }
/*    */   @NotNull
/* 24 */   public ISPacketEntityVelocity asSPacketEntityVelocity() { if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketEntityVelocity");  return new SPacketEntityVelocityImpl<>((SPacketEntityVelocity)this.wrapped); }
/*    */   @NotNull
/* 26 */   public ICPacketChatMessage asCPacketChatMessage() { if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketChatMessage");  return new CPacketChatMessageImpl<>((CPacketChatMessage)this.wrapped); }
/*    */   @NotNull
/* 28 */   public ISPacketCloseWindow asSPacketCloseWindow() { if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketCloseWindow");  return new SPacketCloseWindowImpl<>((SPacketCloseWindow)this.wrapped); }
/*    */   @NotNull
/* 30 */   public ISPacketTabComplete asSPacketTabComplete() { if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketTabComplete");  return new SPacketTabCompleteImpl<>((SPacketTabComplete)this.wrapped); }
/*    */   @NotNull
/* 32 */   public ISPacketPosLook asSPacketPosLook() { if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketPlayerPosLook");  return new SPacketPosLookImpl<>((SPacketPlayerPosLook)this.wrapped); }
/*    */   @NotNull
/* 34 */   public ISPacketResourcePackSend asSPacketResourcePackSend() { if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketResourcePackSend");  return new SPacketResourcePackSendImpl<>((SPacketResourcePackSend)this.wrapped); }
/*    */   @NotNull
/* 36 */   public ICPacketHeldItemChange asCPacketHeldItemChange() { if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketHeldItemChange");  return new CPacketHeldItemChangeImpl<>((CPacketHeldItemChange)this.wrapped); }
/*    */   @NotNull
/* 38 */   public ISPacketWindowItems asSPacketWindowItems() { if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketWindowItems");  return new SPacketWindowItemsImpl<>((SPacketWindowItems)this.wrapped); }
/*    */   @NotNull
/* 40 */   public ICPacketCustomPayload asCPacketCustomPayload() { if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketCustomPayload");  return new CPacketCustomPayloadImpl<>((CPacketCustomPayload)this.wrapped); }
/*    */   @NotNull
/* 42 */   public ICPacketHandshake asCPacketHandshake() { if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.handshake.client.C00Handshake");  return new CPacketHandshakeImpl<>((C00Handshake)this.wrapped); } @NotNull
/*    */   public ICPacketPlayerDigging asCPacketPlayerDigging() {
/* 44 */     if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketPlayerDigging");  return new CPacketPlayerDiggingImpl<>((CPacketPlayerDigging)this.wrapped);
/*    */   }
/*    */   public boolean equals(@Nullable Object other) {
/* 47 */     return (other instanceof PacketImpl && Intrinsics.areEqual(((PacketImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\PacketImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */