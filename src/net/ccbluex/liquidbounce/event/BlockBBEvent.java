/*    */ package net.ccbluex.liquidbounce.event;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\b\n\002\020\b\n\002\b\007\030\0002\0020\001B\037\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\b\020\006\032\004\030\0010\007¢\006\002\020\bR\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\t\020\nR\034\020\006\032\004\030\0010\007X\016¢\006\016\n\000\032\004\b\013\020\f\"\004\b\r\020\016R\021\020\017\032\0020\020¢\006\b\n\000\032\004\b\021\020\022R\021\020\023\032\0020\020¢\006\b\n\000\032\004\b\024\020\022R\021\020\025\032\0020\020¢\006\b\n\000\032\004\b\026\020\022¨\006\027"}, d2 = {"Lnet/ccbluex/liquidbounce/event/BlockBBEvent;", "Lnet/ccbluex/liquidbounce/event/Event;", "blockPos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "block", "Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "boundingBox", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;", "(Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;)V", "getBlock", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "getBoundingBox", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;", "setBoundingBox", "(Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;)V", "x", "", "getX", "()I", "y", "getY", "z", "getZ", "XSJClient"})
/*    */ public final class BlockBBEvent
/*    */   extends Event
/*    */ {
/*    */   private final int x;
/*    */   private final int y;
/*    */   private final int z;
/*    */   @NotNull
/*    */   private final IBlock block;
/*    */   @Nullable
/*    */   private IAxisAlignedBB boundingBox;
/*    */   
/*    */   @NotNull
/*    */   public final IBlock getBlock() {
/* 29 */     return this.block; } @Nullable public final IAxisAlignedBB getBoundingBox() { return this.boundingBox; } public final void setBoundingBox(@Nullable IAxisAlignedBB <set-?>) { this.boundingBox = <set-?>; } public BlockBBEvent(@NotNull WBlockPos blockPos, @NotNull IBlock block, @Nullable IAxisAlignedBB boundingBox) { this.block = block; this.boundingBox = boundingBox;
/* 30 */     this.x = blockPos.getX();
/* 31 */     this.y = blockPos.getY();
/* 32 */     this.z = blockPos.getZ(); } public final int getZ() { return this.z; }
/*    */ 
/*    */   
/*    */   public final int getX() {
/*    */     return this.x;
/*    */   }
/*    */   
/*    */   public final int getY() {
/*    */     return this.y;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\event\BlockBBEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */