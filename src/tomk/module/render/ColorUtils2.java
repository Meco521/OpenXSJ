/*     */ package tomk.module.render;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.util.Random;
/*     */ import java.util.regex.Pattern;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.JvmField;
/*     */ import kotlin.jvm.JvmStatic;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.minecraft.util.ChatAllowedCharacters;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
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
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000F\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\025\n\000\n\002\020\t\n\000\n\002\020\b\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\002\b\003\n\002\020\007\n\002\b\"\n\002\020\006\n\002\b\f\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\n\032\0020\0132\006\020\f\032\0020\013H\007J\032\020\r\032\0020\0162\006\020\017\032\0020\0202\b\b\002\020\f\032\0020\013H\007J\030\020\021\032\0020\0162\006\020\022\032\0020\0162\006\020\023\032\0020\024H\007J \020\025\032\0020\0162\006\020\022\032\0020\0162\006\020\026\032\0020\0132\006\020\027\032\0020\013H\007J\026\020\030\032\0020\0132\006\020\031\032\0020\0132\006\020\032\032\0020\013J\"\020\033\032\0020\0162\006\020\034\032\0020\0242\006\020\035\032\0020\0242\b\b\002\020\f\032\0020\013H\007JL\020\036\032\0020\0162\006\020\026\032\0020\0132\b\b\002\020\037\032\0020\0242\b\b\002\020 \032\0020\0242\b\b\002\020!\032\0020\0132\b\b\002\020\"\032\0020\0132\b\b\002\020#\032\0020\0242\b\b\002\020$\032\0020\024H\007J\036\020%\032\0020\0162\006\020&\032\0020\0162\006\020'\032\0020\0162\006\020(\032\0020\024J \020)\032\0020\0132\006\020*\032\0020\0132\006\020+\032\0020\0242\006\020,\032\0020\024H\007J\b\020-\032\0020\016H\007J\020\020-\032\0020\0162\006\020\f\032\0020\024H\007J\020\020-\032\0020\0162\006\020\026\032\0020\013H\007J\030\020-\032\0020\0162\006\020\026\032\0020\0132\006\020\f\032\0020\024H\007J\030\020-\032\0020\0162\006\020\026\032\0020\0132\006\020\f\032\0020\013H\007J\020\020.\032\0020\0162\006\020\f\032\0020\013H\007J\016\020/\032\0020\0202\006\0200\032\0020\020J\030\0201\032\0020\0162\006\020\022\032\0020\0162\006\020\f\032\0020\024H\007J\030\0201\032\0020\0162\006\020\022\032\0020\0162\006\020\f\032\0020\013H\007J\020\0202\032\0020\0162\006\020\022\032\0020\016H\007J(\0203\032\0020\0162\006\0204\032\0020\0132\006\0205\032\0020\0242\006\0206\032\0020\0242\006\020\031\032\00207H\007J\"\0208\032\004\030\0010\0162\006\0204\032\0020\0132\006\0206\032\0020\0242\006\0205\032\0020\024H\007J(\0209\032\0020\0162\006\020:\032\0020\t2\006\020\027\032\0020\0132\006\020;\032\0020\0242\006\020<\032\0020\024H\007J\020\020=\032\0020\0202\006\020>\032\0020\020H\007J\020\020?\032\0020\0202\006\020@\032\0020\020H\007J\030\020A\032\0020\0162\006\020\032\032\0020\t2\006\020\f\032\0020\024H\007J\020\020B\032\0020\0132\006\020\f\032\0020\013H\007R\026\020\003\032\n \005*\004\030\0010\0040\004X\004¢\006\002\n\000R\020\020\006\032\0020\0078\006X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000¨\006C"}, d2 = {"Ltomk/module/render/ColorUtils2;", "", "()V", "COLOR_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "hexColors", "", "startTime", "", "black", "", "alpha", "colorCode", "Ljava/awt/Color;", "code", "", "darker", "color", "percentage", "", "fade", "index", "count", "getRainbow", "speed", "offset", "healthColor", "hp", "maxHP", "hslRainbow", "lowest", "bigest", "indexOffset", "timeSplit", "saturation", "brightness", "mixColors", "color1", "color2", "percent", "normalRainbow", "delay", "sat", "brg", "rainbow", "rainbowWithAlpha", "randomMagicText", "text", "reAlpha", "reverseColor", "skyRainbow", "var2", "bright", "st", "", "skyRainbow2", "slowlyRainbow", "time", "qd", "sq", "stripColor", "input", "translateAlternateColorCodes", "textToTranslate", "twoRainbow", "white", "XSJClient"})
/*     */ public final class ColorUtils2
/*     */ {
/*     */   private static final Pattern COLOR_PATTERN;
/*     */   private static final long startTime;
/*     */   @JvmField
/*     */   @NotNull
/*     */   public static final int[] hexColors;
/*     */   public static final ColorUtils2 INSTANCE;
/*     */   
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public static final String stripColor(@NotNull String input) {
/*  39 */     Intrinsics.checkParameterIsNotNull(input, "input"); Intrinsics.checkExpressionValueIsNotNull(COLOR_PATTERN.matcher(input).replaceAll(""), "COLOR_PATTERN.matcher(input).replaceAll(\"\")"); return COLOR_PATTERN.matcher(input).replaceAll("");
/*     */   }
/*     */   @NotNull
/*     */   public final Color mixColors(@NotNull Color color1, @NotNull Color color2, float percent) {
/*  43 */     Intrinsics.checkParameterIsNotNull(color1, "color1"); Intrinsics.checkParameterIsNotNull(color2, "color2"); return new Color(color1.getRed() + (int)((color2.getRed() - color1.getRed()) * percent), color1.getGreen() + (int)((color2.getGreen() - color1.getGreen()) * percent), color1.getBlue() + (int)((color2.getBlue() - color1.getBlue()) * percent), color1.getAlpha() + (int)((color2.getAlpha() - color1.getAlpha()) * percent));
/*     */   }
/*     */   public final int getRainbow(int speed, int offset) {
/*  46 */     float hue = (float)((System.currentTimeMillis() + offset) % speed);
/*  47 */     float f1 = speed; boolean bool1 = false, bool2 = false; float it = f1; int $i$a$-let-ColorUtils2$getRainbow$1 = 0; hue /= it; Intrinsics.checkExpressionValueIsNotNull(Color.getHSBColor(hue, 0.4F, 1.0F), "Color.getHSBColor(speed.…/= it; hue }, 0.4f, 1.0f)"); return Color.getHSBColor(hue, 0.4F, 1.0F).getRGB();
/*     */   }
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public static final String translateAlternateColorCodes(@NotNull String textToTranslate) {
/*  52 */     Intrinsics.checkParameterIsNotNull(textToTranslate, "textToTranslate"); String str = textToTranslate; int j = 0; Intrinsics.checkExpressionValueIsNotNull(str.toCharArray(), "(this as java.lang.String).toCharArray()"); char[] chars = str.toCharArray();
/*     */     
/*  54 */     for (byte b = 0; b < j; b++) {
/*  55 */       if (chars[b] == '&' && StringsKt.contains("0123456789AaBbCcDdEeFfKkLlMmNnOoRr", chars[b + 1], true)) {
/*  56 */         chars[b] = '§';
/*  57 */         chars[b + 1] = Character.toLowerCase(chars[b + 1]);
/*     */       } 
/*     */     } 
/*     */     
/*  61 */     int i = 0; return new String(chars);
/*     */   }
/*     */   @NotNull
/*     */   public final String randomMagicText(@NotNull String text) {
/*  65 */     Intrinsics.checkParameterIsNotNull(text, "text"); StringBuilder stringBuilder = new StringBuilder();
/*  66 */     String allowedCharacters = 
/*  67 */       "ÀÁÂÈÊËÍÓÔÕÚßãõğİıŒœŞşŴŵžȇ\000\000\000\000\000\000\000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\000ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐▀αβΓπΣσμτΦΘΩδ∞∅∈∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■\000";
/*     */     
/*  69 */     String str1 = text; boolean bool = false; Intrinsics.checkExpressionValueIsNotNull(str1.toCharArray(), "(this as java.lang.String).toCharArray()"); for (char c : str1.toCharArray()) {
/*  70 */       if (ChatAllowedCharacters.func_71566_a(c)) {
/*  71 */         int index = (new Random()).nextInt(allowedCharacters.length());
/*  72 */         String str = allowedCharacters; StringBuilder stringBuilder1 = stringBuilder; boolean bool1 = false; Intrinsics.checkExpressionValueIsNotNull(str.toCharArray(), "(this as java.lang.String).toCharArray()"); char[] arrayOfChar = str.toCharArray(); stringBuilder1.append(arrayOfChar[index]);
/*     */       } 
/*     */     } 
/*     */     
/*  76 */     Intrinsics.checkExpressionValueIsNotNull(stringBuilder.toString(), "stringBuilder.toString()"); return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   public static final int black(int alpha) {
/*  81 */     return (new Color(0, 0, 0, alpha)).getRGB();
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   public static final int white(int alpha) {
/*  86 */     return (new Color(255, 255, 255, alpha)).getRGB();
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   public static final int normalRainbow(int delay, float sat, float brg) {
/*  91 */     double d1 = (System.currentTimeMillis() + delay) / 20.0D; boolean bool = false; double rainbowState = Math.ceil(d1);
/*  92 */     rainbowState %= 360.0D;
/*  93 */     Intrinsics.checkExpressionValueIsNotNull(Color.getHSBColor((float)(rainbowState / 360.0F), sat, brg), "Color.getHSBColor((rainb….0f).toFloat(), sat, brg)"); return Color.getHSBColor((float)(rainbowState / 360.0F), sat, brg).getRGB();
/*     */   }
/*     */   @JvmStatic
/*     */   @Nullable
/*     */   public static final Color skyRainbow2(int var2, float st, float bright) {
/*  98 */     double d1 = (System.currentTimeMillis() + (var2 * 109)); boolean bool2 = false; double d2 = Math.ceil(d1), v1 = d2 / 5;
/*  99 */     d1 = 360.0D; boolean bool1 = false; bool2 = false; double it = d1; int $i$a$-also-ColorUtils2$skyRainbow2$1 = 0; v1 %= it; return Color.getHSBColor(
/* 100 */         ((float)(d1 / 360.0D) < 0.5D) ? -((float)(v1 / 360.0D)) : (float)(v1 / 360.0D), st, bright);
/*     */   }
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public static final Color colorCode(@NotNull String code, int alpha) {
/* 105 */     Intrinsics.checkParameterIsNotNull(code, "code"); String str = code; boolean bool = false; Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode())
/*     */     
/*     */     { 
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
/*     */       case 97:
/* 136 */         if (str.equals("a"))
/* 137 */           return new Color(85, 255, 85, alpha);  break;
/*     */       case 98:
/* 139 */         if (str.equals("b"))
/* 140 */           return new Color(85, 255, 255, alpha);  break;
/*     */       case 99:
/* 142 */         if (str.equals("c"))
/* 143 */           return new Color(255, 85, 85, alpha);  break;
/*     */       case 100:
/* 145 */         if (str.equals("d"))
/* 146 */           return new Color(255, 85, 255, alpha);  break;
/*     */       case 101:
/* 148 */         if (str.equals("e"))
/* 149 */           return new Color(255, 255, 85, alpha);  break;case 48: if (str.equals("0")) return new Color(0, 0, 0, alpha);  break;case 49: if (str.equals("1")) return new Color(0, 0, 170, alpha);  break;case 50: if (str.equals("2")) return new Color(0, 170, 0, alpha);  break;case 51: if (str.equals("3")) return new Color(0, 170, 170, alpha);  break;case 52: if (str.equals("4")) return new Color(170, 0, 0, alpha);  break;case 53: if (str.equals("5")) return new Color(170, 0, 170, alpha);  break;case 54: if (str.equals("6")) return new Color(255, 170, 0, alpha);  break;case 55: if (str.equals("7"))
/*     */           return new Color(170, 170, 170, alpha);  break;case 56: if (str.equals("8"))
/*     */           return new Color(85, 85, 85, alpha);  break;case 57: if (str.equals("9"))
/* 152 */           return new Color(85, 85, 255, alpha);  break; }  return new Color(255, 255, 255, alpha);
/*     */   }
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
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public static final Color hslRainbow(int index, float lowest, float bigest, int indexOffset, int timeSplit, float saturation, float brightness) {
/* 168 */     float f = ((int)(System.currentTimeMillis() - startTime) + index * indexOffset) / timeSplit % 2 - true; boolean bool = false; Intrinsics.checkExpressionValueIsNotNull(Color.getHSBColor(Math.abs(f) * (bigest - lowest) + lowest, 
/* 169 */           saturation, 
/* 170 */           brightness), "Color.getHSBColor(\n     …     brightness\n        )"); return Color.getHSBColor(Math.abs(f) * (bigest - lowest) + lowest, saturation, brightness);
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public static final Color rainbow() {
/* 176 */     return hslRainbow$default(1, 0.0F, 0.0F, 0, 0, 0.0F, 0.0F, 126, null);
/*     */   }
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public static final Color rainbow(int index) {
/* 181 */     return hslRainbow$default(index, 0.0F, 0.0F, 0, 0, 0.0F, 0.0F, 126, null);
/*     */   }
/*     */   @JvmStatic
/*     */   @NotNull
/* 185 */   public static final Color rainbow(float alpha) { return reAlpha(hslRainbow$default(1, 0.0F, 0.0F, 0, 0, 0.0F, 0.0F, 126, null), alpha); }
/*     */   @JvmStatic
/*     */   @NotNull
/* 188 */   public static final Color rainbowWithAlpha(int alpha) { return reAlpha(hslRainbow$default(1, 0.0F, 0.0F, 0, 0, 0.0F, 0.0F, 126, null), alpha); }
/*     */   @JvmStatic
/*     */   @NotNull
/* 191 */   public static final Color rainbow(int index, int alpha) { return reAlpha(hslRainbow$default(index, 0.0F, 0.0F, 0, 0, 0.0F, 0.0F, 126, null), alpha); } @JvmStatic
/*     */   @NotNull
/*     */   public static final Color rainbow(int index, float alpha) {
/* 194 */     return reAlpha(hslRainbow$default(index, 0.0F, 0.0F, 0, 0, 0.0F, 0.0F, 126, null), alpha);
/*     */   } @JvmStatic
/*     */   @NotNull
/*     */   public static final Color reAlpha(@NotNull Color color, int alpha) {
/* 198 */     Intrinsics.checkParameterIsNotNull(color, "color"); return new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
/*     */   }
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public static final Color reAlpha(@NotNull Color color, float alpha) {
/* 203 */     Intrinsics.checkParameterIsNotNull(color, "color"); return new Color(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, alpha);
/*     */   }
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public static final Color slowlyRainbow(long time, int count, float qd, float sq) {
/* 208 */     Color color = new Color(Color.HSBtoRGB(((float)time + count * -3000000.0F) / 2 / 1.0E9F, qd, sq));
/* 209 */     return new Color(color.getRed() / 255.0F * true, color.getGreen() / 255.0F * true, color.getBlue() / 255.0F * true, color.getAlpha() / 255.0F);
/*     */   }
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public static final Color twoRainbow(long offset, float alpha) {
/* 214 */     Color currentColor = new Color(Color.HSBtoRGB((float)(System.nanoTime() + offset) / 9.0E10F % true, 0.75F, 0.8F));
/* 215 */     return new Color(
/* 216 */         currentColor.getRed() / 255.0F * 1.0F, 
/* 217 */         currentColor.getGreen() / 255.0F * 1.0F, 
/* 218 */         currentColor.getBlue() / 255.0F * 1.0F, 
/* 219 */         alpha);
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public static final Color skyRainbow(int var2, float bright, float st, double speed) {
/* 225 */     double d1 = System.currentTimeMillis() / speed + (var2 * 109L); boolean bool2 = false; double d2 = Math.ceil(d1), v1 = d2 / 5;
/* 226 */     d1 = 360.0D; boolean bool1 = false; bool2 = false; double it = d1; int $i$a$-also-ColorUtils2$skyRainbow$1 = 0; v1 %= it; Intrinsics.checkExpressionValueIsNotNull(Color.getHSBColor((d1 / 360.0D < 0.5D) ? 
/* 227 */           -((float)(v1 / 360.0D)) : 
/*     */           
/* 229 */           (float)(v1 / 360.0D), 
/* 230 */           st, bright), "Color.getHSBColor(if ((3…()\n        }, st, bright)"); return Color.getHSBColor((d1 / 360.0D < 0.5D) ? -((float)(v1 / 360.0D)) : (float)(v1 / 360.0D), st, bright);
/*     */   }
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public static final Color fade(@NotNull Color color, int index, int count) {
/* 235 */     Intrinsics.checkParameterIsNotNull(color, "color"); float[] hsb = new float[3];
/* 236 */     Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), hsb);
/*     */     
/* 238 */     float f1 = ((float)(System.currentTimeMillis() % 2000L) / 1000.0F + index / count * 2.0F) % 2.0F - 1.0F; boolean bool = false; float brightness = Math.abs(f1);
/* 239 */     brightness = 0.5F + 0.5F * brightness;
/* 240 */     hsb[2] = brightness % 2.0F;
/* 241 */     return new Color(Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]));
/*     */   } @JvmStatic
/*     */   @NotNull
/*     */   public static final Color reverseColor(@NotNull Color color) {
/* 245 */     Intrinsics.checkParameterIsNotNull(color, "color"); return new Color(255 - color.getRed(), 255 - color.getGreen(), 255 - color.getBlue(), color.getAlpha());
/*     */   } @JvmStatic
/*     */   @NotNull
/*     */   public static final Color healthColor(float hp, float maxHP, int alpha) {
/* 249 */     int pct = (int)(hp / maxHP * 255.0F);
/* 250 */     int i = 255 - pct; char c = 'ÿ'; boolean bool1 = false; int j = Math.min(i, c); c = Character.MIN_VALUE; bool1 = false; j = Math.max(i, c); i = 255; j = j; c = Character.MIN_VALUE; int k = Math.min(pct, i); c = Character.MIN_VALUE; j = j; bool1 = false; k = Math.max(i, c); int m = alpha; boolean bool2 = false; int n = k, i1 = j; return new Color(i1, n, bool2, m);
/*     */   }
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public static final Color darker(@NotNull Color color, float percentage) {
/* 255 */     Intrinsics.checkParameterIsNotNull(color, "color"); return new Color(
/* 256 */         (int)(color.getRed() * percentage), 
/* 257 */         (int)(color.getGreen() * percentage), 
/* 258 */         (int)(color.getBlue() * percentage), 
/* 259 */         (int)(color.getAlpha() * percentage));
/*     */   }
/*     */   
/*     */   static {
/*     */     // Byte code:
/*     */     //   0: new tomk/module/render/ColorUtils2
/*     */     //   3: dup
/*     */     //   4: invokespecial <init> : ()V
/*     */     //   7: astore_0
/*     */     //   8: aload_0
/*     */     //   9: putstatic tomk/module/render/ColorUtils2.INSTANCE : Ltomk/module/render/ColorUtils2;
/*     */     //   12: ldc_w '(?i)§[0-9A-FK-OR]'
/*     */     //   15: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
/*     */     //   18: putstatic tomk/module/render/ColorUtils2.COLOR_PATTERN : Ljava/util/regex/Pattern;
/*     */     //   21: invokestatic currentTimeMillis : ()J
/*     */     //   24: putstatic tomk/module/render/ColorUtils2.startTime : J
/*     */     //   27: bipush #16
/*     */     //   29: newarray int
/*     */     //   31: putstatic tomk/module/render/ColorUtils2.hexColors : [I
/*     */     //   34: bipush #16
/*     */     //   36: istore_1
/*     */     //   37: iconst_0
/*     */     //   38: istore_2
/*     */     //   39: iconst_0
/*     */     //   40: istore_3
/*     */     //   41: iconst_0
/*     */     //   42: istore_3
/*     */     //   43: iload_1
/*     */     //   44: istore #4
/*     */     //   46: iload_3
/*     */     //   47: iload #4
/*     */     //   49: if_icmpge -> 166
/*     */     //   52: iload_3
/*     */     //   53: istore #5
/*     */     //   55: iconst_0
/*     */     //   56: istore #6
/*     */     //   58: iload #5
/*     */     //   60: iconst_3
/*     */     //   61: ishr
/*     */     //   62: iconst_1
/*     */     //   63: iand
/*     */     //   64: bipush #85
/*     */     //   66: imul
/*     */     //   67: istore #7
/*     */     //   69: iload #5
/*     */     //   71: iconst_2
/*     */     //   72: ishr
/*     */     //   73: iconst_1
/*     */     //   74: iand
/*     */     //   75: sipush #170
/*     */     //   78: imul
/*     */     //   79: iload #7
/*     */     //   81: iadd
/*     */     //   82: iload #5
/*     */     //   84: bipush #6
/*     */     //   86: if_icmpne -> 94
/*     */     //   89: bipush #85
/*     */     //   91: goto -> 95
/*     */     //   94: iconst_0
/*     */     //   95: iadd
/*     */     //   96: istore #8
/*     */     //   98: iload #5
/*     */     //   100: iconst_1
/*     */     //   101: ishr
/*     */     //   102: iconst_1
/*     */     //   103: iand
/*     */     //   104: sipush #170
/*     */     //   107: imul
/*     */     //   108: iload #7
/*     */     //   110: iadd
/*     */     //   111: istore #9
/*     */     //   113: iload #5
/*     */     //   115: iconst_1
/*     */     //   116: iand
/*     */     //   117: sipush #170
/*     */     //   120: imul
/*     */     //   121: iload #7
/*     */     //   123: iadd
/*     */     //   124: istore #10
/*     */     //   126: getstatic tomk/module/render/ColorUtils2.hexColors : [I
/*     */     //   129: iload #5
/*     */     //   131: iload #8
/*     */     //   133: sipush #255
/*     */     //   136: iand
/*     */     //   137: bipush #16
/*     */     //   139: ishl
/*     */     //   140: iload #9
/*     */     //   142: sipush #255
/*     */     //   145: iand
/*     */     //   146: bipush #8
/*     */     //   148: ishl
/*     */     //   149: ior
/*     */     //   150: iload #10
/*     */     //   152: sipush #255
/*     */     //   155: iand
/*     */     //   156: ior
/*     */     //   157: iastore
/*     */     //   158: nop
/*     */     //   159: nop
/*     */     //   160: iinc #3, 1
/*     */     //   163: goto -> 46
/*     */     //   166: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #17	-> 0
/*     */     //   #19	-> 12
/*     */     //   #20	-> 21
/*     */     //   #23	-> 27
/*     */     //   #26	-> 34
/*     */     //   #27	-> 58
/*     */     //   #29	-> 69
/*     */     //   #30	-> 98
/*     */     //   #31	-> 113
/*     */     //   #33	-> 126
/*     */     //   #34	-> 158
/*     */     //   #26	-> 160
/*     */     //   #35	-> 166
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   126	32	10	blue	I
/*     */     //   113	45	9	green	I
/*     */     //   98	60	8	red	I
/*     */     //   69	89	7	baseColor	I
/*     */     //   55	104	5	i	I
/*     */     //   58	101	6	$i$a$-repeat-ColorUtils2$1	I
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\module\render\ColorUtils2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */