/*    */ package net.ccbluex.liquidbounce.event;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.IEnumFacing;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
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
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\006\030\0002\0020\001B\031\022\b\020\002\032\004\030\0010\003\022\b\020\004\032\004\030\0010\005¢\006\002\020\006R\023\020\004\032\004\030\0010\005¢\006\b\n\000\032\004\b\007\020\bR\023\020\002\032\004\030\0010\003¢\006\b\n\000\032\004\b\t\020\n¨\006\013"}, d2 = {"Lnet/ccbluex/liquidbounce/event/ClickBlockEvent;", "Lnet/ccbluex/liquidbounce/event/Event;", "clickedBlock", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "WEnumFacing", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;", "(Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;)V", "getWEnumFacing", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;", "getClickedBlock", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "XSJClient"})
/*    */ public final class ClickBlockEvent
/*    */   extends Event
/*    */ {
/*    */   @Nullable
/*    */   private final WBlockPos clickedBlock;
/*    */   @Nullable
/*    */   private final IEnumFacing WEnumFacing;
/*    */   
/*    */   @Nullable
/*    */   public final WBlockPos getClickedBlock() {
/* 41 */     return this.clickedBlock; } @Nullable public final IEnumFacing getWEnumFacing() { return this.WEnumFacing; } public ClickBlockEvent(@Nullable WBlockPos clickedBlock, @Nullable IEnumFacing WEnumFacing) { this.clickedBlock = clickedBlock; this.WEnumFacing = WEnumFacing; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\event\ClickBlockEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */