/*    */ package net.ccbluex.liquidbounce.utils.misc;@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000@\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\007\n\002\b\016\n\002\020\002\n\000\n\002\020\b\n\002\b\002\n\002\020\013\n\000\n\002\020\006\n\002\b\006\n\002\020\016\n\002\b\002\n\002\020\031\n\002\b\005\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\022\032\0020\0232\006\020\024\032\0020\025J\016\020\026\032\0020\0232\006\020\024\032\0020\025J\006\020\027\032\0020\030J\026\020\031\032\0020\0322\006\020\033\032\0020\0322\006\020\034\032\0020\032J\026\020\035\032\0020\0042\006\020\033\032\0020\0042\006\020\034\032\0020\004J\030\020\036\032\0020\0252\006\020\033\032\0020\0252\006\020\037\032\0020\025H\007J\026\020 \032\0020!2\006\020\"\032\0020\0252\006\020#\032\0020$J\026\020 \032\0020!2\006\020\"\032\0020\0252\006\020#\032\0020!J\016\020%\032\0020!2\006\020\"\032\0020\025J\020\020&\032\0020!2\006\020\"\032\0020\025H\007J\016\020'\032\0020\0232\006\020\024\032\0020\004J\016\020(\032\0020\0232\006\020\024\032\0020\004R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\032\020\t\032\0020\004X\016¢\006\016\n\000\032\004\b\n\020\006\"\004\b\013\020\bR\032\020\f\032\0020\004X\016¢\006\016\n\000\032\004\b\r\020\006\"\004\b\016\020\bR\032\020\017\032\0020\004X\016¢\006\016\n\000\032\004\b\020\020\006\"\004\b\021\020\b¨\006)"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/misc/RandomUtils;", "", "()V", "easinghealth", "", "getEasinghealth", "()F", "setEasinghealth", "(F)V", "easinghealth2", "getEasinghealth2", "setEasinghealth2", "tiph", "getTiph", "setTiph", "tiphrun", "getTiphrun", "setTiphrun", "animtips", "", "easing", "", "animtipsrun", "nextBoolean", "", "nextDouble", "", "startInclusive", "endInclusive", "nextFloat", "nextInt", "endExclusive", "random", "", "length", "chars", "", "randomNumber", "randomString", "updatebackground", "updatebackground2", "XSJClient"})
/*    */ public final class RandomUtils {
/*    */   private static float easinghealth;
/*    */   private static float easinghealth2;
/*    */   
/*    */   static {
/*  7 */     RandomUtils randomUtils = new RandomUtils();
/*    */   } private static float tiph; private static float tiphrun; public static final RandomUtils INSTANCE;
/*    */   @JvmStatic
/*    */   public static final int nextInt(int startInclusive, int endExclusive) {
/* 11 */     return (endExclusive - startInclusive <= 0) ? startInclusive : (startInclusive + (new Random()).nextInt(endExclusive - startInclusive));
/*    */   }
/*    */   
/*    */   public final double nextDouble(double startInclusive, double endInclusive) {
/* 15 */     return (startInclusive == endInclusive || endInclusive - startInclusive <= 0.0D) ? startInclusive : (startInclusive + (endInclusive - startInclusive) * Math.random());
/*    */   }
/*    */   
/*    */   public final float nextFloat(float startInclusive, float endInclusive) {
/* 19 */     return (startInclusive == endInclusive || endInclusive - startInclusive <= 0.0F) ? startInclusive : (float)(startInclusive + (endInclusive - startInclusive) * Math.random());
/*    */   }
/*    */   public final boolean nextBoolean() {
/* 22 */     return (new Random()).nextBoolean();
/*    */   }
/*    */   @NotNull
/*    */   public final String randomNumber(int length) {
/* 26 */     return random(length, "123456789");
/*    */   }
/*    */   @JvmStatic
/*    */   @NotNull
/*    */   public static final String randomString(int length) {
/* 31 */     return INSTANCE.random(length, "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
/*    */   }
/*    */   @NotNull
/*    */   public final String random(int length, @NotNull String chars) {
/* 35 */     Intrinsics.checkParameterIsNotNull(chars, "chars"); String str = chars; int i = length; RandomUtils randomUtils = this; boolean bool = false; Intrinsics.checkExpressionValueIsNotNull(str.toCharArray(), "(this as java.lang.String).toCharArray()"); char[] arrayOfChar = str.toCharArray(); return randomUtils.random(i, arrayOfChar);
/*    */   }
/* 37 */   public final float getEasinghealth() { return easinghealth; } public final void setEasinghealth(float <set-?>) { easinghealth = <set-?>; }
/* 38 */   public final float getEasinghealth2() { return easinghealth2; } public final void setEasinghealth2(float <set-?>) { easinghealth2 = <set-?>; }
/* 39 */   public final float getTiph() { return tiph; } public final void setTiph(float <set-?>) { tiph = <set-?>; }
/* 40 */   public final float getTiphrun() { return tiphrun; } public final void setTiphrun(float <set-?>) { tiphrun = <set-?>; } @NotNull
/*    */   public final String random(int length, @NotNull char[] chars) {
/* 42 */     Intrinsics.checkParameterIsNotNull(chars, "chars"); StringBuilder stringBuilder = new StringBuilder(); byte b; int i;
/* 43 */     for (b = 0, i = length; b < i; ) { stringBuilder.append(chars[(new Random()).nextInt(chars.length)]); b++; }
/* 44 */      Intrinsics.checkExpressionValueIsNotNull(stringBuilder.toString(), "stringBuilder.toString()"); return stringBuilder.toString();
/*    */   }
/*    */   public final void updatebackground(float easing) {
/* 47 */     float f1 = 2.0F, f2 = 6.5F, f4 = easing - easinghealth, f3 = easinghealth; boolean bool = false; float f5 = (float)Math.pow(f1, f2); easinghealth = f3 + f4 / f5 * RenderUtils.deltaTime;
/*    */   }
/*    */   public final void updatebackground2(float easing) {
/* 50 */     float f1 = 2.0F, f2 = 6.5F, f4 = easing - easinghealth2, f3 = easinghealth2; boolean bool = false; float f5 = (float)Math.pow(f1, f2); easinghealth2 = f3 + f4 / f5 * RenderUtils.deltaTime;
/*    */   }
/*    */   public final void animtips(int easing) {
/* 53 */     float f1 = 2.0F, f2 = 7.5F, f4 = easing - tiph, f3 = tiph; boolean bool = false; float f5 = (float)Math.pow(f1, f2); tiph = f3 + f4 / f5 * RenderUtils.deltaTime;
/*    */   }
/*    */   public final void animtipsrun(int easing) {
/* 56 */     float f1 = 2.0F, f2 = 7.5F, f4 = easing - tiphrun, f3 = tiphrun; boolean bool = false; float f5 = (float)Math.pow(f1, f2); tiphrun = f3 + f4 / f5 * RenderUtils.deltaTime;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\misc\RandomUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */