/*    */ package net.ccbluex.liquidbounce.event;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\030\0002\0020\001B\017\022\b\020\002\032\004\030\0010\003¢\006\002\020\004R\023\020\002\032\004\030\0010\003¢\006\b\n\000\032\004\b\005\020\006¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/event/AttackEvent;", "Lnet/ccbluex/liquidbounce/event/Event;", "targetEntity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V", "getTargetEntity", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "XSJClient"})
/*    */ public final class AttackEvent
/*    */   extends Event
/*    */ {
/*    */   @Nullable
/*    */   private final IEntity targetEntity;
/*    */   
/*    */   @Nullable
/*    */   public final IEntity getTargetEntity() {
/* 20 */     return this.targetEntity; } public AttackEvent(@Nullable IEntity targetEntity) { this.targetEntity = targetEntity; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\event\AttackEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */