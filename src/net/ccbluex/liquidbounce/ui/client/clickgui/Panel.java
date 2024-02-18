/*     */ package net.ccbluex.liquidbounce.ui.client.clickgui;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.ClickGUI;
/*     */ import net.ccbluex.liquidbounce.ui.client.clickgui.elements.Element;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.minecraft.util.StringUtils;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public abstract class Panel
/*     */   extends MinecraftInstance
/*     */ {
/*     */   private final String name;
/*     */   public int x;
/*     */   public int y;
/*     */   public int x2;
/*     */   public int y2;
/*     */   private final int width;
/*     */   private final int height;
/*     */   private int scroll;
/*     */   private int dragged;
/*     */   private boolean open;
/*     */   public boolean drag;
/*     */   private boolean scrollbar;
/*     */   private final List<Element> elements;
/*     */   private boolean visible;
/*     */   private float elementsHeight;
/*     */   private float fade;
/*     */   
/*     */   public Panel(String name, int x, int y, int width, int height, boolean open) {
/*  38 */     this.name = name;
/*  39 */     this.elements = new ArrayList<>();
/*  40 */     this.scrollbar = false;
/*  41 */     this.x = x;
/*  42 */     this.y = y;
/*  43 */     this.width = width;
/*  44 */     this.height = height;
/*  45 */     this.open = open;
/*  46 */     this.visible = true;
/*     */     
/*  48 */     setupItems();
/*     */   }
/*     */   
/*     */   public abstract void setupItems();
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float button) {
/*  54 */     if (!this.visible) {
/*     */       return;
/*     */     }
/*  57 */     int maxElements = ((Integer)((ClickGUI)Objects.requireNonNull((T)Retreat.moduleManager.getModule(ClickGUI.class))).maxElementsValue.get()).intValue();
/*     */ 
/*     */     
/*  60 */     if (this.drag) {
/*  61 */       int nx = this.x2 + mouseX;
/*  62 */       int ny = this.y2 + mouseY;
/*  63 */       if (nx > -1) {
/*  64 */         this.x = nx;
/*     */       }
/*  66 */       if (ny > -1) {
/*  67 */         this.y = ny;
/*     */       }
/*     */     } 
/*  70 */     this.elementsHeight = (getElementsHeight() - 1);
/*  71 */     boolean scrollbar = (this.elements.size() >= maxElements);
/*  72 */     if (this.scrollbar != scrollbar) {
/*  73 */       this.scrollbar = scrollbar;
/*     */     }
/*  75 */     Retreat.clickGui.style.drawPanel(mouseX, mouseY, this);
/*     */     
/*  77 */     int y = this.y + this.height - 2;
/*  78 */     int count = 0;
/*     */     
/*  80 */     for (Element element : this.elements) {
/*  81 */       if (++count > this.scroll && count < this.scroll + maxElements + 1 && this.scroll < this.elements.size()) {
/*  82 */         element.setLocation(this.x, y);
/*  83 */         element.setWidth(getWidth());
/*  84 */         if (y <= getY() + this.fade)
/*  85 */           element.drawScreen(mouseX, mouseY, button); 
/*  86 */         y += element.getHeight() + 1;
/*  87 */         element.setVisible(true); continue;
/*     */       } 
/*  89 */       element.setVisible(false);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
/*  94 */     if (!this.visible) {
/*     */       return;
/*     */     }
/*  97 */     if (mouseButton == 1 && isHovering(mouseX, mouseY)) {
/*  98 */       this.open = !this.open;
/*  99 */       mc.getSoundHandler().playSound("random.bow", 1.0F);
/*     */       
/*     */       return;
/*     */     } 
/* 103 */     for (Element element : this.elements) {
/* 104 */       if (element.getY() <= getY() + this.fade)
/* 105 */         element.mouseClicked(mouseX, mouseY, mouseButton); 
/*     */     } 
/*     */   }
/*     */   public void mouseReleased(int mouseX, int mouseY, int state) {
/* 109 */     if (!this.visible) {
/*     */       return;
/*     */     }
/* 112 */     this.drag = false;
/*     */     
/* 114 */     if (!this.open) {
/*     */       return;
/*     */     }
/* 117 */     for (Element element : this.elements)
/* 118 */       element.mouseReleased(mouseX, mouseY, state); 
/*     */   }
/*     */   
/*     */   public boolean handleScroll(int mouseX, int mouseY, int wheel) {
/* 122 */     int maxElements = ((Integer)((ClickGUI)Objects.requireNonNull((T)Retreat.moduleManager.getModule(ClickGUI.class))).maxElementsValue.get()).intValue();
/*     */     
/* 124 */     if (mouseX >= getX() && mouseX <= getX() + 100 && mouseY >= getY() && mouseY <= (getY() + 19) + this.elementsHeight) {
/* 125 */       if (wheel < 0 && this.scroll < this.elements.size() - maxElements) {
/* 126 */         this.scroll++;
/* 127 */         if (this.scroll < 0)
/* 128 */           this.scroll = 0; 
/* 129 */       } else if (wheel > 0) {
/* 130 */         this.scroll--;
/* 131 */         if (this.scroll < 0) {
/* 132 */           this.scroll = 0;
/*     */         }
/*     */       } 
/* 135 */       if (wheel < 0) {
/* 136 */         if (this.dragged < this.elements.size() - maxElements)
/* 137 */           this.dragged++; 
/* 138 */       } else if (wheel > 0 && this.dragged >= 1) {
/* 139 */         this.dragged--;
/*     */       } 
/*     */       
/* 142 */       return true;
/*     */     } 
/* 144 */     return false;
/*     */   }
/*     */   
/*     */   void updateFade(int delta) {
/* 148 */     if (this.open) {
/* 149 */       if (this.fade < this.elementsHeight) this.fade += 0.4F * delta; 
/* 150 */       if (this.fade > this.elementsHeight) this.fade = (int)this.elementsHeight; 
/*     */     } else {
/* 152 */       if (this.fade > 0.0F) this.fade -= 0.4F * delta; 
/* 153 */       if (this.fade < 0.0F) this.fade = 0.0F; 
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getName() {
/* 158 */     return this.name;
/*     */   }
/*     */   
/*     */   public int getX() {
/* 162 */     return this.x;
/*     */   }
/*     */   
/*     */   public int getY() {
/* 166 */     return this.y;
/*     */   }
/*     */   
/*     */   public void setX(int dragX) {
/* 170 */     this.x = dragX;
/*     */   }
/*     */   
/*     */   public void setY(int dragY) {
/* 174 */     this.y = dragY;
/*     */   }
/*     */   
/*     */   public int getWidth() {
/* 178 */     return this.width;
/*     */   }
/*     */   
/*     */   public int getHeight() {
/* 182 */     return this.height;
/*     */   }
/*     */   
/*     */   public boolean getScrollbar() {
/* 186 */     return this.scrollbar;
/*     */   }
/*     */   
/*     */   public void setOpen(boolean open) {
/* 190 */     this.open = open;
/*     */   }
/*     */   
/*     */   public boolean getOpen() {
/* 194 */     return this.open;
/*     */   }
/*     */   
/*     */   public void setVisible(boolean visible) {
/* 198 */     this.visible = visible;
/*     */   }
/*     */   
/*     */   public boolean isVisible() {
/* 202 */     return this.visible;
/*     */   }
/*     */   
/*     */   public List<Element> getElements() {
/* 206 */     return this.elements;
/*     */   }
/*     */   
/*     */   public int getFade() {
/* 210 */     return (int)this.fade;
/*     */   }
/*     */   
/*     */   public int getDragged() {
/* 214 */     return this.dragged;
/*     */   }
/*     */   
/*     */   private int getElementsHeight() {
/* 218 */     int height = 0;
/* 219 */     int count = 0;
/* 220 */     for (Element element : this.elements) {
/* 221 */       if (count >= ((Integer)((ClickGUI)Objects.requireNonNull((T)Retreat.moduleManager.getModule(ClickGUI.class))).maxElementsValue.get()).intValue())
/*     */         continue; 
/* 223 */       height += element.getHeight() + 1;
/* 224 */       count++;
/*     */     } 
/* 226 */     return height;
/*     */   }
/*     */   
/*     */   boolean isHovering(int mouseX, int mouseY) {
/* 230 */     float textWidth = mc.getFontRendererObj().getStringWidth(StringUtils.func_76338_a(this.name)) - 100.0F;
/* 231 */     return (mouseX >= this.x - textWidth / 2.0F - 19.0F && mouseX <= this.x - textWidth / 2.0F + mc.getFontRendererObj().getStringWidth(StringUtils.func_76338_a(this.name)) + 19.0F && mouseY >= this.y && mouseY <= this.y + this.height - (this.open ? 2 : 0));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\clickgui\Panel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */