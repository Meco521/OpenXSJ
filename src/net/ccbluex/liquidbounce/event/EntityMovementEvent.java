/*    */ package net.ccbluex.liquidbounce.event;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
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
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000*\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\006\n\002\020\013\n\000\n\002\020\000\n\000\n\002\020\b\n\000\n\002\020\016\n\000\b\b\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\t\020\007\032\0020\003HÆ\003J\023\020\b\032\0020\0002\b\b\002\020\002\032\0020\003HÆ\001J\023\020\t\032\0020\n2\b\020\013\032\004\030\0010\fHÖ\003J\t\020\r\032\0020\016HÖ\001J\t\020\017\032\0020\020HÖ\001R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006¨\006\021"}, d2 = {"Lnet/ccbluex/liquidbounce/event/EntityMovementEvent;", "Lnet/ccbluex/liquidbounce/event/Event;", "movedEntity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V", "getMovedEntity", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "XSJClient"})
/*    */ public final class EntityMovementEvent
/*    */   extends Event
/*    */ {
/*    */   @NotNull
/*    */   private final IEntity movedEntity;
/*    */   
/*    */   @NotNull
/*    */   public final IEntity getMovedEntity() {
/* 51 */     return this.movedEntity; } public EntityMovementEvent(@NotNull IEntity movedEntity) { this.movedEntity = movedEntity; }
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public final IEntity component1() {
/*    */     return this.movedEntity;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final EntityMovementEvent copy(@NotNull IEntity movedEntity) {
/*    */     Intrinsics.checkParameterIsNotNull(movedEntity, "movedEntity");
/*    */     return new EntityMovementEvent(movedEntity);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public String toString() {
/*    */     return "EntityMovementEvent(movedEntity=" + this.movedEntity + ")";
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return (this.movedEntity != null) ? this.movedEntity.hashCode() : 0;
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object paramObject) {
/*    */     if (this != paramObject) {
/*    */       if (paramObject instanceof EntityMovementEvent) {
/*    */         EntityMovementEvent entityMovementEvent = (EntityMovementEvent)paramObject;
/*    */         if (Intrinsics.areEqual(this.movedEntity, entityMovementEvent.movedEntity))
/*    */           return true; 
/*    */       } 
/*    */     } else {
/*    */       return true;
/*    */     } 
/*    */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\event\EntityMovementEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */