/*     */ package net.ccbluex.liquidbounce.event;
/*     */ 
/*     */ import kotlin.Metadata;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000 \n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\006\n\002\b\003\n\002\020\007\n\002\b\f\030\0002\0020\001B5\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\005\022\006\020\007\032\0020\005\022\006\020\b\032\0020\t\022\006\020\n\032\0020\t¢\006\002\020\013R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\f\020\rR\021\020\b\032\0020\t¢\006\b\n\000\032\004\b\016\020\017R\021\020\n\032\0020\t¢\006\b\n\000\032\004\b\020\020\017R\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\021\020\022R\021\020\006\032\0020\005¢\006\b\n\000\032\004\b\023\020\022R\021\020\007\032\0020\005¢\006\b\n\000\032\004\b\024\020\022¨\006\025"}, d2 = {"Lnet/ccbluex/liquidbounce/event/RenderEntityEvent;", "Lnet/ccbluex/liquidbounce/event/Event;", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "x", "", "y", "z", "entityYaw", "", "partialTicks", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;DDDFF)V", "getEntity", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "getEntityYaw", "()F", "getPartialTicks", "getX", "()D", "getY", "getZ", "XSJClient"})
/*     */ public final class RenderEntityEvent
/*     */   extends Event
/*     */ {
/*     */   @NotNull
/*     */   private final IEntity entity;
/*     */   private final double x;
/*     */   private final double y;
/*     */   private final double z;
/*     */   private final float entityYaw;
/*     */   private final float partialTicks;
/*     */   
/*     */   @NotNull
/*     */   public final IEntity getEntity() {
/* 138 */     return this.entity; } public final double getX() { return this.x; } public final double getY() { return this.y; } public final double getZ() { return this.z; } public final float getEntityYaw() { return this.entityYaw; }
/* 139 */   public RenderEntityEvent(@NotNull IEntity entity, double x, double y, double z, float entityYaw, float partialTicks) { this.entity = entity; this.x = x; this.y = y; this.z = z; this.entityYaw = entityYaw; this.partialTicks = partialTicks; } public final float getPartialTicks() { return this.partialTicks; }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\event\RenderEntityEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */