/*    */ package net.ccbluex.liquidbounce.api.minecraft.util;@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\006\n\002\b\004\n\002\020\007\n\000\n\002\020\b\n\002\b\004\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J!\020\003\032\0020\0042\006\020\005\032\0020\0042\006\020\006\032\0020\0042\006\020\007\032\0020\004H\bJ!\020\b\032\0020\t2\006\020\005\032\0020\t2\006\020\006\032\0020\t2\006\020\007\032\0020\tH\bJ\020\020\n\032\0020\0132\006\020\f\032\0020\004H\007J\020\020\r\032\0020\t2\006\020\016\032\0020\tH\007¨\006\017"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/util/WMathHelper;", "", "()V", "clamp_double", "", "num", "min", "max", "clamp_float", "", "floor_double", "", "value", "wrapAngleTo180_float", "angle", "XSJClient"})
/*    */ public final class WMathHelper {
/*    */   static {
/*  4 */     WMathHelper wMathHelper = new WMathHelper();
/*    */   }
/*    */   public static final WMathHelper INSTANCE;
/*    */   @JvmStatic
/*    */   public static final float wrapAngleTo180_float(float angle) {
/*  9 */     float value = angle % 360.0F;
/*    */     
/* 11 */     if (value >= 180.0F) {
/* 12 */       value -= 360.0F;
/*    */     }
/*    */     
/* 15 */     if (value < -180.0F) {
/* 16 */       value += 360.0F;
/*    */     }
/*    */     
/* 19 */     return value;
/*    */   }
/*    */   
/*    */   @JvmStatic
/*    */   public static final float clamp_float(float num, float min, float max) {
/* 24 */     int $i$f$clamp_float = 0; return (num < min) ? min : ((num > max) ? max : num);
/*    */   }
/*    */   
/*    */   @JvmStatic
/*    */   public static final double clamp_double(double num, double min, double max) {
/* 29 */     int $i$f$clamp_double = 0; return (num < min) ? min : ((num > max) ? max : num);
/*    */   }
/*    */   
/*    */   @JvmStatic
/*    */   public static final int floor_double(double value) {
/* 34 */     int i = (int)value;
/* 35 */     return (value < i) ? (i - 1) : i;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraf\\util\WMathHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */