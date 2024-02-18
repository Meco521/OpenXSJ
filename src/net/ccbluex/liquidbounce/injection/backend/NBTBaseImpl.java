/*   */ package net.ccbluex.liquidbounce.injection.backend;
/*   */ 
/*   */ import net.minecraft.nbt.NBTBase;
/*   */ 
/*   */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\006\n\002\020\013\n\000\n\002\020\000\n\000\b\026\030\000*\b\b\000\020\001*\0020\0022\0020\003B\r\022\006\020\004\032\0028\000¢\006\002\020\005J\023\020\t\032\0020\n2\b\020\013\032\004\030\0010\fH\002R\023\020\004\032\0028\000¢\006\n\n\002\020\b\032\004\b\006\020\007¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/NBTBaseImpl;", "T", "Lnet/minecraft/nbt/NBTBase;", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTBase;", "wrapped", "(Lnet/minecraft/nbt/NBTBase;)V", "getWrapped", "()Lnet/minecraft/nbt/NBTBase;", "Lnet/minecraft/nbt/NBTBase;", "equals", "", "other", "", "XSJClient"})
/*   */ public class NBTBaseImpl<T extends NBTBase> implements INBTBase {
/* 7 */   public NBTBaseImpl(@NotNull NBTBase wrapped) { this.wrapped = (T)wrapped; } @NotNull private final T wrapped; @NotNull public final T getWrapped() { return this.wrapped; }
/*   */    public boolean equals(@Nullable Object other) {
/* 9 */     return (other instanceof NBTBaseImpl && Intrinsics.areEqual(((NBTBaseImpl)other).wrapped, this.wrapped));
/*   */   }
/*   */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\NBTBaseImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */