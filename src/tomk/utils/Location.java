/*    */ package tomk.utils;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.utils.Rotation;
/*    */ import net.ccbluex.liquidbounce.utils.particles.Vec3;
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
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000,\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\t\n\002\020\013\n\002\b\002\n\002\020\b\n\000\n\002\020\016\n\000\b\b\030\0002\0020\001B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006J\t\020\013\032\0020\003HÆ\003J\t\020\f\032\0020\005HÆ\003J\035\020\r\032\0020\0002\b\b\002\020\002\032\0020\0032\b\b\002\020\004\032\0020\005HÆ\001J\023\020\016\032\0020\0172\b\020\020\032\004\030\0010\001HÖ\003J\t\020\021\032\0020\022HÖ\001J\t\020\023\032\0020\024HÖ\001R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\007\020\bR\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\t\020\n¨\006\025"}, d2 = {"Ltomk/utils/Location;", "", "position", "Lnet/ccbluex/liquidbounce/utils/particles/Vec3;", "rotation", "Lnet/ccbluex/liquidbounce/utils/Rotation;", "(Lnet/ccbluex/liquidbounce/utils/particles/Vec3;Lnet/ccbluex/liquidbounce/utils/Rotation;)V", "getPosition", "()Lnet/ccbluex/liquidbounce/utils/particles/Vec3;", "getRotation", "()Lnet/ccbluex/liquidbounce/utils/Rotation;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "XSJClient"})
/*    */ public final class Location
/*    */ {
/*    */   @NotNull
/*    */   private final Vec3 position;
/*    */   @NotNull
/*    */   private final Rotation rotation;
/*    */   
/*    */   @NotNull
/*    */   public final Vec3 getPosition() {
/* 50 */     return this.position; } @NotNull public final Rotation getRotation() { return this.rotation; } public Location(@NotNull Vec3 position, @NotNull Rotation rotation) { this.position = position; this.rotation = rotation; }
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public final Vec3 component1() {
/*    */     return this.position;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final Rotation component2() {
/*    */     return this.rotation;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final Location copy(@NotNull Vec3 position, @NotNull Rotation rotation) {
/*    */     Intrinsics.checkParameterIsNotNull(position, "position");
/*    */     Intrinsics.checkParameterIsNotNull(rotation, "rotation");
/*    */     return new Location(position, rotation);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public String toString() {
/*    */     return "Location(position=" + this.position + ", rotation=" + this.rotation + ")";
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return ((this.position != null) ? this.position.hashCode() : 0) * 31 + ((this.rotation != null) ? this.rotation.hashCode() : 0);
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object paramObject) {
/*    */     if (this != paramObject) {
/*    */       if (paramObject instanceof Location) {
/*    */         Location location = (Location)paramObject;
/*    */         if (Intrinsics.areEqual(this.position, location.position) && Intrinsics.areEqual(this.rotation, location.rotation))
/*    */           return true; 
/*    */       } 
/*    */     } else {
/*    */       return true;
/*    */     } 
/*    */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\Location.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */