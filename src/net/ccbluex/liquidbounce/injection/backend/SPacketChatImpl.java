/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.minecraft.network.play.server.SPacketChat;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\003\030\000*\b\b\000\020\001*\0020\0022\b\022\004\022\002H\0010\0032\0020\004B\r\022\006\020\005\032\0028\000¢\006\002\020\006R\024\020\007\032\0020\b8VX\004¢\006\006\032\004\b\t\020\nR\024\020\013\032\0020\b8VX\004¢\006\006\032\004\b\f\020\nR\024\020\r\032\0020\0168VX\004¢\006\006\032\004\b\017\020\020¨\006\021"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/SPacketChatImpl;", "T", "Lnet/minecraft/network/play/server/SPacketChat;", "Lnet/ccbluex/liquidbounce/injection/backend/PacketImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketChat;", "wrapped", "(Lnet/minecraft/network/play/server/SPacketChat;)V", "chatComponent", "Lnet/minecraft/util/text/ITextComponent;", "getChatComponent", "()Lnet/minecraft/util/text/ITextComponent;", "getChat", "getGetChat", "type", "Lnet/minecraft/util/text/ChatType;", "getType", "()Lnet/minecraft/util/text/ChatType;", "XSJClient"})
/*    */ public final class SPacketChatImpl<T extends SPacketChat> extends PacketImpl<T> implements ISPacketChat {
/*  8 */   public SPacketChatImpl(@NotNull SPacketChat wrapped) { super((T)wrapped); }
/*    */   @NotNull
/* 10 */   public ITextComponent getChatComponent() { Intrinsics.checkExpressionValueIsNotNull(((SPacketChat)getWrapped()).func_148915_c(), "wrapped.chatComponent"); return ((SPacketChat)getWrapped()).func_148915_c(); }
/*    */   @NotNull
/* 12 */   public ChatType getType() { Intrinsics.checkExpressionValueIsNotNull(((SPacketChat)getWrapped()).func_192590_c(), "wrapped.type"); return ((SPacketChat)getWrapped()).func_192590_c(); } @NotNull
/*    */   public ITextComponent getGetChat() {
/* 14 */     Intrinsics.checkExpressionValueIsNotNull(((SPacketChat)getWrapped()).func_148915_c(), "wrapped.getChatComponent()"); return ((SPacketChat)getWrapped()).func_148915_c();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\SPacketChatImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */