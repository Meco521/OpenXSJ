/*    */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000B\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\b\n\002\020\t\n\002\b\005\n\002\030\002\n\002\b\016\n\002\020\013\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\b\020!\032\0020\"H\026J\020\020#\032\0020$2\006\020%\032\0020&H\007J\020\020'\032\0020$2\006\020%\032\0020(H\007J\020\020)\032\0020$2\006\020%\032\0020*H\007R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\032\020\t\032\0020\004X\016¢\006\016\n\000\032\004\b\n\020\006\"\004\b\013\020\bR\032\020\f\032\0020\rX\016¢\006\016\n\000\032\004\b\016\020\017\"\004\b\020\020\021R\034\020\022\032\004\030\0010\023X\016¢\006\016\n\000\032\004\b\024\020\025\"\004\b\026\020\027R\032\020\030\032\0020\004X\016¢\006\016\n\000\032\004\b\031\020\006\"\004\b\032\020\bR\032\020\033\032\0020\004X\016¢\006\016\n\000\032\004\b\034\020\006\"\004\b\035\020\bR\032\020\036\032\0020\004X\016¢\006\016\n\000\032\004\b\037\020\006\"\004\b \020\b¨\006+"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Recorder;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "()V", "ban", "", "getBan", "()I", "setBan", "(I)V", "killCounts", "getKillCounts", "setKillCounts", "startTime", "", "getStartTime", "()J", "setStartTime", "(J)V", "syncEntity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "getSyncEntity", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "setSyncEntity", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)V", "totalPlayed", "getTotalPlayed", "setTotalPlayed", "totalPlayed2", "getTotalPlayed2", "setTotalPlayed2", "win", "getWin", "setWin", "handleEvents", "", "onAttack", "", "event", "Lnet/ccbluex/liquidbounce/event/AttackEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class Recorder implements Listenable {
/*    */   @Nullable
/*    */   private static IEntityLivingBase syncEntity;
/*    */   private static int killCounts;
/*    */   private static int win;
/*    */   
/*  9 */   static { Recorder recorder = new Recorder(); } private static int totalPlayed; private static int totalPlayed2; private static int ban; @Nullable
/* 10 */   public final IEntityLivingBase getSyncEntity() { return syncEntity; } public final void setSyncEntity(@Nullable IEntityLivingBase <set-?>) { syncEntity = <set-?>; }
/* 11 */   public final int getKillCounts() { return killCounts; } public final void setKillCounts(int <set-?>) { killCounts = <set-?>; }
/* 12 */   public final int getWin() { return win; } public final void setWin(int <set-?>) { win = <set-?>; }
/* 13 */   public final int getTotalPlayed() { return totalPlayed; } public final void setTotalPlayed(int <set-?>) { totalPlayed = <set-?>; }
/* 14 */   public final int getTotalPlayed2() { return totalPlayed2; } public final void setTotalPlayed2(int <set-?>) { totalPlayed2 = <set-?>; }
/* 15 */   public final int getBan() { return ban; } public final void setBan(int <set-?>) { ban = <set-?>; }
/* 16 */    private static long startTime = System.currentTimeMillis(); public static final Recorder INSTANCE; public final long getStartTime() { return startTime; } public final void setStartTime(long <set-?>) { startTime = <set-?>; }
/*    */    @EventTarget
/*    */   public final void onAttack(@NotNull AttackEvent event) {
/* 19 */     Intrinsics.checkParameterIsNotNull(event, "event"); syncEntity = (IEntityLivingBase)event.getTargetEntity();
/*    */   }
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 23 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (syncEntity == null) Intrinsics.throwNpe();  if (syncEntity.isDead()) {
/* 24 */       killCounts++;
/* 25 */       syncEntity = (IEntityLivingBase)null;
/*    */     } 
/*    */   }
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/* 30 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (event.getPacket() instanceof net.minecraft.network.handshake.client.C00Handshake) startTime = System.currentTimeMillis(); 
/* 31 */     if (event.getPacket() == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketChat");  Intrinsics.checkExpressionValueIsNotNull(((SPacketChat)event.getPacket()).func_148915_c(), "(event.packet as SPacketChat).chatComponent"); String message = ((SPacketChat)event.getPacket()).func_148915_c().func_150260_c();
/* 32 */     IPacket packet = event.getPacket();
/* 33 */     if (packet instanceof SPacketTitle)
/* 34 */       if (((SPacketTitle)packet).func_179805_b() != null) { String title = ((SPacketTitle)packet).func_179805_b().func_150254_d();
/* 35 */         Intrinsics.checkExpressionValueIsNotNull(title, "title"); if (StringsKt.startsWith$default(title, "游戏开始", false, 2, null)) {
/* 36 */           int i; totalPlayed = (i = totalPlayed) + 1;
/* 37 */         }  if (StringsKt.startsWith$default(title, "恭喜", false, 2, null))
/* 38 */         { int i; win = (i = win) + 1; }  }
/*    */       else { ((SPacketTitle)packet).func_179805_b(); return; }
/* 40 */         Intrinsics.checkExpressionValueIsNotNull(message, "message"); if (StringsKt.contains$default(message, "Reason", false, 2, null)) {
/* 41 */       int i; ban = (i = ban) + 1;
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean handleEvents() {
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\Recorder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */