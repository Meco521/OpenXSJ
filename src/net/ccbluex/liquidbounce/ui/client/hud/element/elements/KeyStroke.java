/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IFontRenderer;
/*     */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.minecraft.client.settings.KeyBinding;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ import org.lwjgl.opengl.GL11;
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
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000X\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\005\n\002\030\002\n\002\020\t\n\002\030\002\n\002\b\005\n\002\020\016\n\002\b\005\n\002\020\013\n\002\b\006\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\007\n\002\b\003\n\002\030\002\n\002\b\004\030\0002\0020\001B-\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\005\022\006\020\007\032\0020\005\022\006\020\b\032\0020\005¢\006\002\020\tJ\006\020\035\032\0020\000J\016\020\035\032\0020\0002\006\020\036\032\0020\023JV\020\037\032\0020 2\006\020!\032\0020\0052\006\020\"\032\0020#2\006\020$\032\0020#2\006\020%\032\0020&2\006\020'\032\0020\0312\006\020(\032\0020\0052\006\020)\032\0020*2\006\020+\032\0020&2\006\020,\032\0020&2\006\020-\032\0020&R\036\020\n\032\022\022\004\022\0020\f0\013j\b\022\004\022\0020\f`\rX\004¢\006\002\n\000R\021\020\b\032\0020\005¢\006\b\n\000\032\004\b\016\020\017R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\020\020\021R\032\020\022\032\0020\023X\016¢\006\016\n\000\032\004\b\024\020\025\"\004\b\026\020\027R\016\020\030\032\0020\031X\016¢\006\002\n\000R\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\032\020\017R\021\020\006\032\0020\005¢\006\b\n\000\032\004\b\033\020\017R\021\020\007\032\0020\005¢\006\b\n\000\032\004\b\034\020\017¨\006."}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/KeyStroke;", "", "key", "Lnet/minecraft/client/settings/KeyBinding;", "posX", "", "posY", "width", "height", "(Lnet/minecraft/client/settings/KeyBinding;IIII)V", "animations", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getHeight", "()I", "getKey", "()Lnet/minecraft/client/settings/KeyBinding;", "keyName", "", "getKeyName", "()Ljava/lang/String;", "setKeyName", "(Ljava/lang/String;)V", "lastClick", "", "getPosX", "getPosY", "getWidth", "initKeyName", "name", "render", "", "speed", "bgColor", "Ljava/awt/Color;", "textColor", "highLightPct", "", "outline", "outlineBold", "font", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;", "renderX", "renderY", "scale", "XSJClient"})
/*     */ public final class KeyStroke
/*     */ {
/*     */   @NotNull
/*     */   private String keyName;
/*     */   private boolean lastClick;
/*     */   private final ArrayList<Long> animations;
/*     */   @NotNull
/*     */   private final KeyBinding key;
/*     */   private final int posX;
/*     */   private final int posY;
/*     */   private final int width;
/*     */   private final int height;
/*     */   
/*     */   @NotNull
/*     */   public final KeyBinding getKey() {
/*  80 */     return this.key; } public final int getPosX() { return this.posX; } public final int getPosY() { return this.posY; } public final int getWidth() { return this.width; } public final int getHeight() { return this.height; } public KeyStroke(@NotNull KeyBinding key, int posX, int posY, int width, int height) { this.key = key; this.posX = posX; this.posY = posY; this.width = width; this.height = height;
/*  81 */     this.keyName = "KEY";
/*     */ 
/*     */     
/*  84 */     this.animations = new ArrayList<>(); }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public final String getKeyName() {
/*     */     return this.keyName;
/*     */   }
/*     */   
/*     */   public final void setKeyName(@NotNull String <set-?>) {
/*     */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*     */     this.keyName = <set-?>;
/*     */   }
/*     */   
/*     */   public final void render(int speed, @NotNull Color bgColor, @NotNull Color textColor, float highLightPct, boolean outline, int outlineBold, @NotNull IFontRenderer font, float renderX, float renderY, float scale) {
/*  98 */     Intrinsics.checkParameterIsNotNull(bgColor, "bgColor"); Intrinsics.checkParameterIsNotNull(textColor, "textColor"); Intrinsics.checkParameterIsNotNull(font, "font"); GL11.glPushMatrix();
/*  99 */     GL11.glTranslatef(this.posX, this.posY, 0.0F);
/*     */     
/* 101 */     Color highLightColor = new Color(255 - (int)((255 - bgColor.getRed()) * highLightPct), 255 - (int)((255 - bgColor.getBlue()) * highLightPct), 255 - (int)((255 - bgColor.getGreen()) * highLightPct));
/*     */     
/* 103 */     float clickAlpha = 'ÿ' - (255 - bgColor.getAlpha()) * highLightPct;
/* 104 */     int centerX = this.width / 2;
/* 105 */     int centerY = this.height / 2;
/* 106 */     long nowTime = System.currentTimeMillis();
/*     */     
/* 108 */     Color rectColor = (this.lastClick && this.animations.isEmpty()) ? ColorUtils.INSTANCE.reAlpha(highLightColor, (int)clickAlpha) : bgColor;
/* 109 */     RenderUtils.drawRoundedRect(0.0F, 0.0F, this.width, this.height, 3.0F, rectColor.getRGB());
/*     */     
/* 111 */     ArrayList<Long> removeAble = new ArrayList();
/* 112 */     for (Long time : this.animations) {
/* 113 */       Intrinsics.checkExpressionValueIsNotNull(time, "time"); float pct = (float)(nowTime - time.longValue()) / speed;
/* 114 */       if (pct > true) {
/* 115 */         removeAble.add(time);
/*     */         continue;
/*     */       } 
/* 118 */       RenderUtils.drawLimitedCircle(0.0F, 0.0F, this.width, this.height, centerX, centerY, this.width * 0.7F * pct, new Color(255 - (int)((255 - highLightColor.getRed()) * pct), 255 - (int)((255 - highLightColor.getGreen()) * pct), 255 - (int)((255 - highLightColor.getBlue()) * pct), 255 - (int)(('ÿ' - clickAlpha) * pct)));
/*     */     } 
/* 120 */     for (Long time : removeAble) {
/* 121 */       this.animations.remove(time);
/*     */     }
/* 123 */     if (!this.lastClick && this.key.func_151470_d()) {
/* 124 */       this.animations.add(Long.valueOf(nowTime));
/*     */     }
/* 126 */     this.lastClick = this.key.func_151470_d();
/*     */     
/* 128 */     font.drawString(this.keyName, centerX - font.getStringWidth(this.keyName) / 2 + 1, centerY - font.getFontHeight() / 2 + 2, textColor.getRGB());
/* 129 */     if (outline) {
/* 130 */       RenderUtils.drawRect(0.0F, 0.0F, outlineBold, this.height, textColor.getRGB());
/* 131 */       RenderUtils.drawRect((this.width - outlineBold), 0.0F, this.width, this.height, textColor.getRGB());
/* 132 */       RenderUtils.drawRect(outlineBold, 0.0F, (this.width - outlineBold), outlineBold, textColor.getRGB());
/* 133 */       RenderUtils.drawRect(outlineBold, (this.height - outlineBold), (this.width - outlineBold), this.height, textColor.getRGB());
/*     */     } 
/*     */     
/* 136 */     GL11.glPopMatrix();
/*     */   }
/*     */   @NotNull
/*     */   public final KeyStroke initKeyName() {
/* 140 */     Intrinsics.checkExpressionValueIsNotNull(Keyboard.getKeyName(this.key.func_151463_i()), "Keyboard.getKeyName(key.keyCode)"); this.keyName = Keyboard.getKeyName(this.key.func_151463_i());
/* 141 */     return this;
/*     */   }
/*     */   @NotNull
/*     */   public final KeyStroke initKeyName(@NotNull String name) {
/* 145 */     Intrinsics.checkParameterIsNotNull(name, "name"); this.keyName = name;
/* 146 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\KeyStroke.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */