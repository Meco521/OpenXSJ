/*    */ package net.ccbluex.liquidbounce.utils.extensions;
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\000\f\n\000\n\002\020\016\n\002\030\002\n\000\032\n\020\000\032\0020\001*\0020\002¨\006\003"}, d2 = {"getFullName", "", "Lnet/ccbluex/liquidbounce/api/minecraft/client/network/INetworkPlayerInfo;", "XSJClient"})
/*    */ public final class NetworkPlayerInfoKt {
/*    */   @NotNull
/*    */   public static final String getFullName(@NotNull INetworkPlayerInfo $this$getFullName) {
/*  6 */     Intrinsics.checkParameterIsNotNull($this$getFullName, "$this$getFullName"); if ($this$getFullName.getDisplayName() != null) {
/*  7 */       if ($this$getFullName.getDisplayName() == null) Intrinsics.throwNpe();  return $this$getFullName.getDisplayName().getFormattedText();
/*    */     } 
/*  9 */     ITeam team = $this$getFullName.getPlayerTeam();
/* 10 */     String name = $this$getFullName.getGameProfile().getName();
/* 11 */     Intrinsics.checkExpressionValueIsNotNull(name, "name"); if (team == null || team.formatString(name) == null) { team.formatString(name); Intrinsics.checkExpressionValueIsNotNull(name, "name"); }  return name;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\extensions\NetworkPlayerInfoKt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */