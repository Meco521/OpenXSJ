/*    */ package net.ccbluex.liquidbounce.cape;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.DefaultConstructorMarker;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.IResourceLocation;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000$\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\020\013\n\002\b\f\n\002\020\b\n\000\n\002\020\016\n\000\b\b\030\0002\0020\001B\027\022\006\020\002\032\0020\003\022\b\b\002\020\004\032\0020\005¢\006\002\020\006J\t\020\f\032\0020\003HÆ\003J\t\020\r\032\0020\005HÆ\003J\035\020\016\032\0020\0002\b\b\002\020\002\032\0020\0032\b\b\002\020\004\032\0020\005HÆ\001J\023\020\017\032\0020\0052\b\020\020\032\004\030\0010\001HÖ\003J\t\020\021\032\0020\022HÖ\001J\t\020\023\032\0020\024HÖ\001R\032\020\004\032\0020\005X\016¢\006\016\n\000\032\004\b\004\020\007\"\004\b\b\020\tR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\n\020\013¨\006\025"}, d2 = {"Lnet/ccbluex/liquidbounce/cape/CapeInfo;", "", "resourceLocation", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;", "isCapeAvailable", "", "(Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;Z)V", "()Z", "setCapeAvailable", "(Z)V", "getResourceLocation", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "XSJClient"})
/*    */ public final class CapeInfo
/*    */ {
/*    */   @NotNull
/*    */   private final IResourceLocation resourceLocation;
/*    */   private boolean isCapeAvailable;
/*    */   
/*    */   @NotNull
/*    */   public final IResourceLocation getResourceLocation() {
/* 95 */     return this.resourceLocation; } public final boolean isCapeAvailable() { return this.isCapeAvailable; } public final void setCapeAvailable(boolean <set-?>) { this.isCapeAvailable = <set-?>; } public CapeInfo(@NotNull IResourceLocation resourceLocation, boolean isCapeAvailable) { this.resourceLocation = resourceLocation; this.isCapeAvailable = isCapeAvailable; }
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public final IResourceLocation component1() {
/*    */     return this.resourceLocation;
/*    */   }
/*    */   
/*    */   public final boolean component2() {
/*    */     return this.isCapeAvailable;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final CapeInfo copy(@NotNull IResourceLocation resourceLocation, boolean isCapeAvailable) {
/*    */     Intrinsics.checkParameterIsNotNull(resourceLocation, "resourceLocation");
/*    */     return new CapeInfo(resourceLocation, isCapeAvailable);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public String toString() {
/*    */     return "CapeInfo(resourceLocation=" + this.resourceLocation + ", isCapeAvailable=" + this.isCapeAvailable + ")";
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     if (this.isCapeAvailable);
/*    */     return ((this.resourceLocation != null) ? this.resourceLocation.hashCode() : 0) * 31 + 1;
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object paramObject) {
/*    */     if (this != paramObject) {
/*    */       if (paramObject instanceof CapeInfo) {
/*    */         CapeInfo capeInfo = (CapeInfo)paramObject;
/*    */         if (Intrinsics.areEqual(this.resourceLocation, capeInfo.resourceLocation) && this.isCapeAvailable == capeInfo.isCapeAvailable)
/*    */           return true; 
/*    */       } 
/*    */     } else {
/*    */       return true;
/*    */     } 
/*    */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\cape\CapeInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */