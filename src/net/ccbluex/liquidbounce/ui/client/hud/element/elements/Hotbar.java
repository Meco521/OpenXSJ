/*    */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import kotlin.collections.CollectionsKt;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.Border;
/*    */ import net.ccbluex.liquidbounce.utils.hotbarutil;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ 
/*    */ @ElementInfo(name = "Hotbar")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000(\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\003\n\002\030\002\n\000\n\002\020!\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\031\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003¢\006\002\020\005J\b\020\013\032\0020\fH\026R\016\020\006\032\0020\007X\004¢\006\002\n\000R\024\020\b\032\b\022\004\022\0020\n0\tX\004¢\006\002\n\000¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Hotbar;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "(DD)V", "itemrenderY", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "slotlist", "", "Lnet/ccbluex/liquidbounce/utils/hotbarutil;", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "XSJClient"})
/*    */ public final class Hotbar extends Element {
/*    */   private final FloatValue itemrenderY;
/*    */   
/*    */   public Hotbar(double x, double y) {
/* 16 */     super(x, y, 0.0F, null, 12, null);
/* 17 */     this.itemrenderY = new FloatValue("itemrenderY", -50.0F, -500.0F, 500.0F);
/* 18 */     Hotbar hotbar = this; byte b1 = 0; ArrayList<hotbarutil> arrayList = new ArrayList();
/*    */     
/*    */     byte b2;
/* 21 */     for (b1 = 0, b2 = 8; b1 <= b2; b1++) {
/* 22 */       hotbarutil slot = new hotbarutil();
/* 23 */       this.slotlist.add(slot);
/*    */     } 
/*    */   } private final List<hotbarutil> slotlist; public Hotbar() {
/*    */     this(0.0D, 0.0D, 3, null);
/*    */   } @NotNull
/*    */   public Border drawElement() {
/* 29 */     GlStateManager.func_179094_E();
/* 30 */     GlStateManager.func_179091_B();
/* 31 */     GlStateManager.func_179147_l();
/* 32 */     GlStateManager.func_179120_a(770, 771, 1, 0);
/*    */ 
/*    */     
/* 35 */     Iterable<hotbarutil> $this$forEachIndexed$iv = this.slotlist; int $i$f$forEachIndexed = 0;
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
/* 86 */     int index$iv = 0;
/* 87 */     Iterator<hotbarutil> iterator = $this$forEachIndexed$iv.iterator(); if (iterator.hasNext()) { Object item$iv = iterator.next(); int i = index$iv++; boolean bool = false; if (i < 0) CollectionsKt.throwIndexOverflow();  int j = i; hotbarutil hotbarutil = (hotbarutil)item$iv; int index = j, $i$a$-forEachIndexed-Hotbar$drawElement$1 = 0; }
/*    */     
/*    */     GlStateManager.func_179101_C();
/*    */     GlStateManager.func_179084_k();
/*    */     GlStateManager.func_179121_F();
/*    */     return new Border(0.0F, 0.0F, 180.0F, 17.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\Hotbar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */