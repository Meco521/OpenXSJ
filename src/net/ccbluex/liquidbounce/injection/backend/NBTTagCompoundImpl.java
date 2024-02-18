/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000<\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\n\n\000\n\002\020\016\n\000\n\002\020\013\n\000\n\002\020\002\n\002\b\002\n\002\020\b\n\002\b\003\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\0012\0020\003B\r\022\006\020\004\032\0020\002¢\006\002\020\005J\020\020\006\032\0020\0072\006\020\b\032\0020\tH\026J\020\020\n\032\0020\0132\006\020\b\032\0020\tH\026J\030\020\f\032\0020\r2\006\020\016\032\0020\t2\006\020\017\032\0020\020H\026J\030\020\021\032\0020\r2\006\020\016\032\0020\t2\006\020\017\032\0020\tH\026J\030\020\022\032\0020\r2\006\020\016\032\0020\t2\006\020\023\032\0020\024H\026¨\006\025"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/NBTTagCompoundImpl;", "Lnet/ccbluex/liquidbounce/injection/backend/NBTBaseImpl;", "Lnet/minecraft/nbt/NBTTagCompound;", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagCompound;", "wrapped", "(Lnet/minecraft/nbt/NBTTagCompound;)V", "getShort", "", "name", "", "hasKey", "", "setInteger", "", "key", "value", "", "setString", "setTag", "tag", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTBase;", "XSJClient"})
/*    */ public final class NBTTagCompoundImpl extends NBTBaseImpl<NBTTagCompound> implements INBTTagCompound {
/*  8 */   public NBTTagCompoundImpl(@NotNull NBTTagCompound wrapped) { super(wrapped); } public boolean hasKey(@NotNull String name) {
/*  9 */     Intrinsics.checkParameterIsNotNull(name, "name"); return getWrapped().func_74764_b(name);
/*    */   } public short getShort(@NotNull String name) {
/* 11 */     Intrinsics.checkParameterIsNotNull(name, "name"); return getWrapped().func_74765_d(name);
/*    */   } public void setString(@NotNull String key, @NotNull String value) {
/* 13 */     Intrinsics.checkParameterIsNotNull(key, "key"); Intrinsics.checkParameterIsNotNull(value, "value"); getWrapped().func_74778_a(key, value);
/*    */   } public void setTag(@NotNull String key, @NotNull INBTBase tag) {
/* 15 */     Intrinsics.checkParameterIsNotNull(key, "key"); Intrinsics.checkParameterIsNotNull(tag, "tag"); INBTBase iNBTBase = tag; String str = key; NBTTagCompound nBTTagCompound = getWrapped(); int $i$f$unwrap = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 22 */     NBTBase nBTBase = (NBTBase)((NBTBaseImpl<Object>)iNBTBase).getWrapped(); nBTTagCompound.func_74782_a(str, nBTBase);
/*    */   }
/*    */   
/*    */   public void setInteger(@NotNull String key, int value) {
/*    */     Intrinsics.checkParameterIsNotNull(key, "key");
/*    */     getWrapped().func_74768_a(key, value);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\NBTTagCompoundImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */