/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.minecraft.nbt.INBTBase;
/*    */ import net.minecraft.nbt.NBTBase;
/*    */ import net.minecraft.nbt.NBTTagList;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0004\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\000\n\002\020\013\n\002\b\002\030\0002\b\022\004\022\0020\0020\0012\0020\003B\r\022\006\020\004\032\0020\002¢\006\002\020\005J\020\020\006\032\0020\0072\006\020\b\032\0020\tH\026J\020\020\n\032\0020\0132\006\020\f\032\0020\rH\026J\b\020\016\032\0020\017H\026J\b\020\020\032\0020\rH\026¨\006\021"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/NBTTagListImpl;", "Lnet/ccbluex/liquidbounce/injection/backend/NBTBaseImpl;", "Lnet/minecraft/nbt/NBTTagList;", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagList;", "wrapped", "(Lnet/minecraft/nbt/NBTTagList;)V", "appendTag", "", "createNBTTagString", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTBase;", "getCompoundTagAt", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagCompound;", "index", "", "hasNoTags", "", "tagCount", "XSJClient"})
/*    */ public final class NBTTagListImpl extends NBTBaseImpl<NBTTagList> implements INBTTagList {
/*  9 */   public NBTTagListImpl(@NotNull NBTTagList wrapped) { super(wrapped); }
/* 10 */   public boolean hasNoTags() { return getWrapped().func_82582_d(); }
/* 11 */   public int tagCount() { return getWrapped().func_74745_c(); } @NotNull
/* 12 */   public INBTTagCompound getCompoundTagAt(int index) { Intrinsics.checkExpressionValueIsNotNull(getWrapped().func_150305_b(index), "wrapped.getCompoundTagAt(index)"); NBTTagCompound $this$wrap$iv = getWrapped().func_150305_b(index); int $i$f$wrap = 0; return 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 18 */       new NBTTagCompoundImpl($this$wrap$iv); } public void appendTag(@NotNull INBTBase createNBTTagString) { Intrinsics.checkParameterIsNotNull(createNBTTagString, "createNBTTagString"); INBTBase iNBTBase = createNBTTagString; NBTTagList nBTTagList = getWrapped(); int $i$f$unwrap = 0;
/* 19 */     NBTBase nBTBase = (NBTBase)((NBTBaseImpl<Object>)iNBTBase).getWrapped(); nBTTagList.func_74742_a(nBTBase); }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\NBTTagListImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */