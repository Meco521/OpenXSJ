/*    */ package net.ccbluex.liquidbounce.features.module;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.normal.Main;
/*    */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.objects.Drag;
/*    */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.render.Scroll;
/*    */ 
/*    */ public enum ModuleCategory
/*    */ {
/*  9 */   COMBAT("Combat"),
/* 10 */   PLAYER("Player"),
/* 11 */   MOVEMENT("Movement"),
/* 12 */   RENDER("Render"),
/* 13 */   WORLD("World"),
/* 14 */   COLOR("Color"),
/* 15 */   MISC("Misc"),
/* 16 */   EXPLOIT("Exploit"),
/* 17 */   RETREAT("XSJ"),
/* 18 */   HYT("XSJHyt");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 24 */   private final Scroll scroll = new Scroll();
/*    */   
/*    */   public Scroll getScroll() {
/* 27 */     return this.scroll;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Drag getDrag() {
/* 33 */     return this.drag;
/*    */   }
/*    */   
/* 36 */   public int posY = 20; public final String namee; public final int posX;
/*    */   
/*    */   public String getDisplayName() {
/* 39 */     return this.namee;
/*    */   }
/*    */   public final boolean expanded; private final Drag drag;
/*    */   ModuleCategory(String name) {
/* 43 */     this.namee = name;
/* 44 */     this.posX = 40 + Main.categoryCount * 120;
/* 45 */     this.drag = new Drag(this.posX, this.posY);
/* 46 */     this.expanded = true;
/* 47 */     Main.categoryCount++;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\ModuleCategory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */