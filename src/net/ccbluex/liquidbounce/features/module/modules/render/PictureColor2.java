/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "PictureColorTwo", description = "全局颜色2", category = ModuleCategory.RENDER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0000\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\t\n\002\020\b\n\002\b\035\n\002\030\002\n\002\b\005\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\0201\032\002022\006\0203\032\00204H\007R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\021\020\007\032\0020\004¢\006\b\n\000\032\004\b\b\020\006R\021\020\t\032\0020\004¢\006\b\n\000\032\004\b\n\020\006R\021\020\013\032\0020\004¢\006\b\n\000\032\004\b\f\020\006R\032\020\r\032\0020\016X\016¢\006\016\n\000\032\004\b\017\020\020\"\004\b\021\020\022R\032\020\023\032\0020\016X\016¢\006\016\n\000\032\004\b\024\020\020\"\004\b\025\020\022R\032\020\026\032\0020\016X\016¢\006\016\n\000\032\004\b\027\020\020\"\004\b\030\020\022R\032\020\031\032\0020\016X\016¢\006\016\n\000\032\004\b\032\020\020\"\004\b\033\020\022R\032\020\034\032\0020\016X\016¢\006\016\n\000\032\004\b\035\020\020\"\004\b\036\020\022R\032\020\037\032\0020\016X\016¢\006\016\n\000\032\004\b \020\020\"\004\b!\020\022R\032\020\"\032\0020\016X\016¢\006\016\n\000\032\004\b#\020\020\"\004\b$\020\022R\032\020%\032\0020\016X\016¢\006\016\n\000\032\004\b&\020\020\"\004\b'\020\022R\032\020(\032\0020\016X\016¢\006\016\n\000\032\004\b)\020\020\"\004\b*\020\022R\032\020+\032\0020,X\016¢\006\016\n\000\032\004\b-\020.\"\004\b/\0200¨\0065"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/PictureColor2;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "colorBlueValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "getColorBlueValue", "()Lnet/ccbluex/liquidbounce/value/IntegerValue;", "colorGreenValue", "getColorGreenValue", "colorRedValue", "getColorRedValue", "coloralpha", "getColoralpha", "h", "", "getH", "()I", "setH", "(I)V", "h1", "getH1", "setH1", "h2", "getH2", "setH2", "m", "getM", "setM", "m1", "getM1", "setM1", "m2", "getM2", "setM2", "s", "getS", "setS", "s1", "getS1", "setS1", "s2", "getS2", "setS2", "timer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "getTimer", "()Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "setTimer", "(Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;)V", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class PictureColor2 extends Module {
/*    */   @NotNull
/* 14 */   private final IntegerValue colorRedValue = new IntegerValue("R", 255, 0, 255); @NotNull public final IntegerValue getColorRedValue() { return this.colorRedValue; } @NotNull
/* 15 */   private final IntegerValue colorGreenValue = new IntegerValue("G", 133, 0, 255); @NotNull public final IntegerValue getColorGreenValue() { return this.colorGreenValue; } @NotNull
/* 16 */   private final IntegerValue colorBlueValue = new IntegerValue("B", 255, 0, 255); @NotNull public final IntegerValue getColorBlueValue() { return this.colorBlueValue; } @NotNull
/* 17 */   private final IntegerValue coloralpha = new IntegerValue("alpha", 255, 0, 255); private int s; private int m; private int h; private int s1; @NotNull public final IntegerValue getColoralpha() { return this.coloralpha; } private int m1; private int h1; private int s2; private int m2; private int h2; public final int getS() {
/* 18 */     return this.s; } public final void setS(int <set-?>) { this.s = <set-?>; }
/* 19 */   public final int getM() { return this.m; } public final void setM(int <set-?>) { this.m = <set-?>; }
/* 20 */   public final int getH() { return this.h; } public final void setH(int <set-?>) { this.h = <set-?>; }
/* 21 */   public final int getS1() { return this.s1; } public final void setS1(int <set-?>) { this.s1 = <set-?>; }
/* 22 */   public final int getM1() { return this.m1; } public final void setM1(int <set-?>) { this.m1 = <set-?>; }
/* 23 */   public final int getH1() { return this.h1; } public final void setH1(int <set-?>) { this.h1 = <set-?>; }
/* 24 */   public final int getS2() { return this.s2; } public final void setS2(int <set-?>) { this.s2 = <set-?>; }
/* 25 */   public final int getM2() { return this.m2; } public final void setM2(int <set-?>) { this.m2 = <set-?>; }
/* 26 */   public final int getH2() { return this.h2; } public final void setH2(int <set-?>) { this.h2 = <set-?>; } @NotNull
/* 27 */   private MSTimer timer = new MSTimer(); @NotNull public final MSTimer getTimer() { return this.timer; } public final void setTimer(@NotNull MSTimer <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.timer = <set-?>; }
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 31 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (this.s == 60) {
/* 32 */       this.s = 0; int j;
/* 33 */       this.m = (j = this.m) + 1;
/*    */     } 
/* 35 */     if (this.m == 60) {
/* 36 */       this.m = 0; int j;
/* 37 */       this.h = (j = this.h) + 1;
/*    */     } 
/* 39 */     if (this.h == 60) {
/* 40 */       this.h = 0;
/*    */     }
/*    */     
/* 43 */     if (this.s1 == 10) {
/* 44 */       int j; this.s2 = (j = this.s2) + 1;
/* 45 */       this.s1 = 0;
/*    */     } 
/* 47 */     if (this.s2 == 6) {
/* 48 */       int j; this.m1 = (j = this.m1) + 1;
/* 49 */       this.s2 = 0;
/*    */     } 
/* 51 */     if (this.m1 == 10) {
/* 52 */       this.m1 = 0; int j;
/* 53 */       this.m2 = (j = this.m2) + 1;
/*    */     } 
/* 55 */     if (this.m2 == 6) {
/* 56 */       int j; this.h1 = (j = this.h1) + 1;
/* 57 */       this.m2 = 0;
/*    */     } 
/* 59 */     if (this.h1 == 10) {
/* 60 */       this.h1 = 0;
/*    */     }
/* 62 */     if (!this.timer.hasTimePassed(1000L))
/*    */       return; 
/*    */     int i;
/* 65 */     this.s = (i = this.s) + 1;
/* 66 */     this.s1 = (i = this.s1) + 1;
/*    */     
/* 68 */     this.timer.reset();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\PictureColor2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */