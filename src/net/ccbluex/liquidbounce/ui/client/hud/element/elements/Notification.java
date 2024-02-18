/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.math.BigDecimal;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.DefaultConstructorMarker;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.color.CustomColor;
/*     */ import net.ccbluex.liquidbounce.tomk.Client;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.render.EaseUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.RoundedUtil;
/*     */ import org.jetbrains.annotations.NotNull;
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
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000F\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\000\n\002\020\b\n\002\b\005\n\002\020\t\n\002\b\r\n\002\030\002\n\002\b\026\n\002\020\007\n\002\b\007\n\002\020\013\n\002\b\005\n\002\030\002\n\000\030\0002\0020\001B1\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003\022\006\020\005\032\0020\006\022\b\b\002\020\007\032\0020\b\022\b\b\002\020\t\032\0020\b¢\006\002\020\nJ.\020:\032\0020;2\006\020<\032\0020\b2\006\020=\032\002032\006\020>\032\002032\006\020?\032\002032\006\020@\032\0020AR\021\020\t\032\0020\b¢\006\b\n\000\032\004\b\013\020\fR\032\020\r\032\0020\016X\016¢\006\016\n\000\032\004\b\017\020\020\"\004\b\021\020\022R\032\020\023\032\0020\016X\016¢\006\016\n\000\032\004\b\024\020\020\"\004\b\025\020\022R\021\020\004\032\0020\003¢\006\b\n\000\032\004\b\026\020\027R\032\020\030\032\0020\016X\016¢\006\016\n\000\032\004\b\031\020\020\"\004\b\032\020\022R\032\020\033\032\0020\034X\016¢\006\016\n\000\032\004\b\035\020\036\"\004\b\037\020 R\024\020!\032\0020\bXD¢\006\b\n\000\032\004\b\"\020\fR\032\020#\032\0020\bX\016¢\006\016\n\000\032\004\b$\020\f\"\004\b%\020&R\032\020'\032\0020\bX\016¢\006\016\n\000\032\004\b(\020\f\"\004\b)\020&R\020\020*\032\004\030\0010\003X\016¢\006\002\n\000R\032\020+\032\0020\bX\016¢\006\016\n\000\032\004\b,\020\f\"\004\b-\020&R\021\020\007\032\0020\b¢\006\b\n\000\032\004\b.\020\fR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b/\020\027R\021\020\005\032\0020\006¢\006\b\n\000\032\004\b0\0201R\021\0202\032\00203¢\006\b\n\000\032\004\b4\0205R\032\0206\032\00203X\016¢\006\016\n\000\032\004\b7\0205\"\004\b8\0209¨\006B"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Notification;", "", "title", "", "content", "type", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/NotifyType;", "time", "", "animeTime", "(Ljava/lang/String;Ljava/lang/String;Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/NotifyType;II)V", "getAnimeTime", "()I", "animeXTime", "", "getAnimeXTime", "()J", "setAnimeXTime", "(J)V", "animeYTime", "getAnimeYTime", "setAnimeYTime", "getContent", "()Ljava/lang/String;", "displayTime", "getDisplayTime", "setDisplayTime", "fadeState", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/FadeState;", "getFadeState", "()Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/FadeState;", "setFadeState", "(Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/FadeState;)V", "height", "getHeight", "n2", "getN2", "setN2", "(I)V", "nowY", "getNowY", "setNowY", "s", "textLength", "getTextLength", "setTextLength", "getTime", "getTitle", "getType", "()Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/NotifyType;", "width", "", "getWidth", "()F", "x", "getX", "setX", "(F)V", "drawNotification", "", "index", "blurRadius", "y", "scale", "notifications", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Notifications;", "XSJClient"})
/*     */ public final class Notification
/*     */ {
/*     */   private String s;
/*     */   private int n2;
/*     */   private int textLength;
/*     */   private final float width;
/*     */   private final int height = 30;
/*     */   @NotNull
/*     */   private FadeState fadeState;
/*     */   private int nowY;
/*     */   private float x;
/*     */   private long displayTime;
/*     */   private long animeXTime;
/*     */   private long animeYTime;
/*     */   @NotNull
/*     */   private final String title;
/*     */   @NotNull
/*     */   private final String content;
/*     */   @NotNull
/*     */   private final NotifyType type;
/*     */   private final int time;
/*     */   private final int animeTime;
/*     */   
/*     */   @NotNull
/*     */   public final String getTitle() {
/*  59 */     return this.title; } @NotNull public final String getContent() { return this.content; } @NotNull public final NotifyType getType() { return this.type; } public final int getTime() { return this.time; } public final int getAnimeTime() { return this.animeTime; } public Notification(@NotNull String title, @NotNull String content, @NotNull NotifyType type, int time, int animeTime) { this.title = title; this.content = content; this.type = type; this.time = time; this.animeTime = animeTime;
/*     */     
/*  61 */     this.n2 = Fonts.posterama30.getStringWidth(this.content);
/*  62 */     this.textLength = Math.max(this.n2, 0);
/*  63 */     this.width = this.textLength + 80.0F;
/*  64 */     this.height = 30;
/*  65 */     this.fadeState = FadeState.IN;
/*  66 */     this.nowY = -this.height;
/*     */     
/*  68 */     this.displayTime = System.currentTimeMillis();
/*  69 */     this.animeXTime = System.currentTimeMillis();
/*  70 */     this.animeYTime = System.currentTimeMillis(); } public final int getN2() { return this.n2; } public final void setN2(int <set-?>) { this.n2 = <set-?>; } public final int getTextLength() { return this.textLength; } public final void setTextLength(int <set-?>) { this.textLength = <set-?>; } public final float getWidth() { return this.width; } public final int getHeight() { return this.height; } @NotNull public final FadeState getFadeState() { return this.fadeState; } public final void setFadeState(@NotNull FadeState <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.fadeState = <set-?>; } public final long getAnimeYTime() { return this.animeYTime; } public final int getNowY() { return this.nowY; } public final void setNowY(int <set-?>) { this.nowY = <set-?>; } public final float getX() { return this.x; } public final void setX(float <set-?>) { this.x = <set-?>; } public final long getDisplayTime() { return this.displayTime; } public final void setDisplayTime(long <set-?>) { this.displayTime = <set-?>; } public final long getAnimeXTime() { return this.animeXTime; } public final void setAnimeXTime(long <set-?>) { this.animeXTime = <set-?>; } public final void setAnimeYTime(long <set-?>) { this.animeYTime = <set-?>; }
/*     */ 
/*     */   
/*     */   public final boolean drawNotification(int index, float blurRadius, float y, float scale, @NotNull Notifications notifications) {
/*  74 */     Intrinsics.checkParameterIsNotNull(notifications, "notifications"); double renderX = notifications.getRenderX();
/*  75 */     double renderY = notifications.getRenderY();
/*  76 */     int realY = -(index + 1) * (this.height + 2);
/*     */     
/*  78 */     long nowTime = System.currentTimeMillis();
/*     */     
/*  80 */     double transY = this.nowY;
/*     */     
/*  82 */     if (this.nowY != realY) {
/*  83 */       double d = (nowTime - this.animeYTime) / this.animeTime;
/*  84 */       if (d > true) {
/*  85 */         this.nowY = realY;
/*  86 */         d = 1.0D;
/*     */       } else {
/*  88 */         d = EaseUtils.easeOutQuart(d);
/*     */       } 
/*  90 */       GL11.glTranslated(0.0D, (realY - this.nowY) * d, 0.0D);
/*     */     } else {
/*  92 */       this.animeYTime = nowTime;
/*     */     } 
/*     */     
/*  95 */     GL11.glTranslated(1.0D, this.nowY, 0.0D);
/*     */ 
/*     */     
/*  98 */     double pct = (nowTime - this.animeXTime) / this.animeTime;
/*  99 */     switch (Notification$WhenMappings.$EnumSwitchMapping$0[this.fadeState.ordinal()]) {
/*     */       case 1:
/* 101 */         if (pct > true) {
/* 102 */           this.fadeState = FadeState.STAY;
/* 103 */           this.animeXTime = nowTime;
/* 104 */           pct = 1.0D;
/*     */         } 
/* 106 */         pct = EaseUtils.easeOutQuart(pct);
/* 107 */         transY += (realY - this.nowY) * pct;
/*     */         break;
/*     */       
/*     */       case 2:
/* 111 */         pct = 1.0D;
/* 112 */         if (nowTime - this.animeXTime > this.time) {
/* 113 */           this.fadeState = FadeState.OUT;
/* 114 */           this.animeXTime = nowTime;
/*     */         } 
/*     */         break;
/*     */       
/*     */       case 3:
/* 119 */         if (pct > true) {
/* 120 */           this.fadeState = FadeState.END;
/* 121 */           this.animeXTime = nowTime;
/* 122 */           pct = 2.0D;
/*     */         } 
/* 124 */         pct = true - EaseUtils.INSTANCE.easeInQuart(pct);
/*     */         break;
/*     */       
/*     */       case 4:
/* 128 */         return true;
/*     */     } 
/*     */ 
/*     */     
/* 132 */     GL11.glTranslated(this.width - this.width * pct, 0.0D, 0.0D);
/* 133 */     GL11.glTranslatef(-this.width, 0.0F, 0.0F);
/*     */     
/* 135 */     if (this.type == NotifyType.SUCCESS) {
/* 136 */       this.s = "SUCCESS";
/* 137 */     } else if (this.type == NotifyType.ERROR) {
/* 138 */       this.s = "ERROR";
/* 139 */     } else if (this.type == NotifyType.WARNING) {
/* 140 */       this.s = "WARNING";
/* 141 */     } else if (this.type == NotifyType.INFO) {
/* 142 */       this.s = "INFO";
/*     */     } 
/* 144 */     if (Intrinsics.areEqual(this.s, "INFO")) {
/* 145 */       Client.drawOutline(20.0F, -3.0F, this.width - 7.0F, 13.0F, ((Number)CustomColor.ra.get()).floatValue(), ((Number)CustomColor.line.get()).floatValue(), ((Number)CustomColor.office.get()).floatValue());
/* 146 */       RoundedUtil.drawRound(14.0F, -2.0F, this.width - 15.0F, 28.0F, ((Number)CustomColor.ra.get()).floatValue(), new Color(0, 0, 0, 50));
/* 147 */       Fonts.no40.drawString("C", 23.0F, 5.0F, (new Color(255, 255, 255, 255)).getRGB());
/* 148 */       Fonts.posterama40.drawString(this.title, 48.0F, 3.0F, (new Color(255, 255, 255, 240)).getRGB());
/* 149 */       Fonts.posterama30.drawString(this.content + " (" + (new BigDecimal(((this.time - this.time * (float)(nowTime - this.displayTime) / (this.animeTime * 2.0F + this.time)) / 'Ϩ'))).setScale(1, 4).toString() + "s)", 48.0F, 16.0F, (new Color(255, 255, 255, 255)).getRGB());
/*     */     } 
/*     */     
/* 152 */     if (Intrinsics.areEqual(this.s, "WARNING")) {
/* 153 */       Client.drawOutline(20.0F, -3.0F, this.width - 7.0F, 13.0F, ((Number)CustomColor.ra.get()).floatValue(), ((Number)CustomColor.line.get()).floatValue(), ((Number)CustomColor.office.get()).floatValue());
/* 154 */       RoundedUtil.drawRound(14.0F, -2.0F, this.width - 15.0F, 28.0F, ((Number)CustomColor.ra.get()).floatValue(), new Color(0, 0, 0, 50));
/* 155 */       Fonts.no40.drawString("D", 23.0F, 5.0F, (new Color(255, 255, 255, 255)).getRGB());
/* 156 */       Fonts.posterama40.drawString(this.title, 48.0F, 3.0F, (new Color(255, 255, 255, 240)).getRGB());
/* 157 */       Fonts.posterama30.drawString(this.content + " (" + (new BigDecimal(((this.time - this.time * (float)(nowTime - this.displayTime) / (this.animeTime * 2.0F + this.time)) / 'Ϩ'))).setScale(1, 4).toString() + "s)", 48.0F, 16.0F, (new Color(255, 255, 255, 255)).getRGB());
/*     */     } 
/* 159 */     if (Intrinsics.areEqual(this.s, "SUCCESS")) {
/* 160 */       Client.drawOutline(20.0F, -3.0F, this.width - 7.0F, 13.0F, ((Number)CustomColor.ra.get()).floatValue(), ((Number)CustomColor.line.get()).floatValue(), ((Number)CustomColor.office.get()).floatValue());
/* 161 */       RoundedUtil.drawRound(14.0F, -2.0F, this.width - 15.0F, 28.0F, ((Number)CustomColor.ra.get()).floatValue(), new Color(0, 0, 0, 50));
/* 162 */       Fonts.no40.drawString("A", 23.0F, 5.0F, (new Color(255, 255, 255, 200)).getRGB());
/* 163 */       Fonts.posterama40.drawString(this.title, 48.0F, 3.0F, (new Color(255, 255, 255, 240)).getRGB());
/* 164 */       Fonts.posterama30.drawString(this.content + " (" + (new BigDecimal(((this.time - this.time * (float)(nowTime - this.displayTime) / (this.animeTime * 2.0F + this.time)) / 'Ϩ'))).setScale(1, 4).toString() + "s)", 48.0F, 16.0F, (new Color(255, 255, 255, 255)).getRGB());
/*     */     } 
/* 166 */     if (Intrinsics.areEqual(this.s, "ERROR")) {
/* 167 */       Client.drawOutline(20.0F, -3.0F, this.width - 7.0F, 13.0F, ((Number)CustomColor.ra.get()).floatValue(), ((Number)CustomColor.line.get()).floatValue(), ((Number)CustomColor.office.get()).floatValue());
/* 168 */       RoundedUtil.drawRound(14.0F, -2.0F, this.width - 15.0F, 28.0F, ((Number)CustomColor.ra.get()).floatValue(), new Color(0, 0, 0, 50));
/* 169 */       Fonts.no40.drawString("B", 23.0F, 5.0F, (new Color(255, 255, 255, 240)).getRGB());
/* 170 */       Fonts.posterama40.drawString(this.title, 48.0F, 3.0F, (new Color(255, 255, 255, 240)).getRGB());
/* 171 */       Fonts.posterama30.drawString(this.content + " (" + (new BigDecimal(((this.time - this.time * (float)(nowTime - this.displayTime) / (this.animeTime * 2.0F + this.time)) / 'Ϩ'))).setScale(1, 4).toString() + "s)", 48.0F, 16.0F, (new Color(255, 255, 255, 255)).getRGB());
/*     */     } 
/*     */     
/* 174 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\Notification.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */