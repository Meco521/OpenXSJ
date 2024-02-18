/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.minecraft.nbt.JsonToNBT;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\000\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\006H\026¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/JsonToNBTImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/IJsonToNBT;", "()V", "getTagFromJson", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagCompound;", "s", "", "XSJClient"})
/*    */ public final class JsonToNBTImpl implements IJsonToNBT {
/*  8 */   static { JsonToNBTImpl jsonToNBTImpl = new JsonToNBTImpl(); } public static final JsonToNBTImpl INSTANCE; @NotNull
/*  9 */   public INBTTagCompound getTagFromJson(@NotNull String s) { Intrinsics.checkParameterIsNotNull(s, "s"); Intrinsics.checkExpressionValueIsNotNull(JsonToNBT.func_180713_a(s), "JsonToNBT.getTagFromJson(s)"); NBTTagCompound $this$wrap$iv = JsonToNBT.func_180713_a(s); int $i$f$wrap = 0; return 
/*    */       
/* 11 */       new NBTTagCompoundImpl($this$wrap$iv); }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\JsonToNBTImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */