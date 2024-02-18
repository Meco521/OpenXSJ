/*     */ package net.ccbluex.liquidbounce.ui.client;
/*     */ import java.awt.Desktop;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URI;
/*     */ import java.net.URL;
/*     */ import java.nio.charset.Charset;
/*     */ import java.security.MessageDigest;
/*     */ import java.util.Base64;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.Charsets;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000@\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\002\n\002\b\003\n\002\020\b\n\002\b\031\n\002\020\007\n\000\n\002\020\016\n\002\b\007\n\002\020\006\n\002\b\002\030\000 32\0020\001:\0013B\005¢\006\002\020\002J\020\020\t\032\0020\n2\006\020\013\032\0020\004H\024J8\020\f\032\0020\n2\006\020\r\032\0020\0162\006\020\017\032\0020\0162\006\020\020\032\0020\0162\006\020\021\032\0020\0162\006\020\022\032\0020\0162\006\020\023\032\0020\016H\002J0\020\024\032\0020\n2\006\020\025\032\0020\0162\006\020\026\032\0020\0162\006\020\027\032\0020\0162\006\020\030\032\0020\0162\006\020\023\032\0020\016H\002J \020\031\032\0020\n2\006\020\032\032\0020\0162\006\020\033\032\0020\0162\006\020\023\032\0020\016H\002J\020\020\034\032\0020\n2\006\020\013\032\0020\004H\002J8\020\035\032\0020\n2\006\020\036\032\0020\0162\006\020\037\032\0020\0162\006\020 \032\0020\0162\006\020!\032\0020\0162\006\020\020\032\0020\0162\006\020\023\032\0020\016H\002J@\020\"\032\0020\n2\006\020\036\032\0020\0162\006\020\037\032\0020\0162\006\020 \032\0020\0162\006\020!\032\0020\0162\006\020\020\032\0020\0162\006\020#\032\0020\0162\006\020\023\032\0020\016H\002J \020$\032\0020\n2\006\020%\032\0020\0162\006\020&\032\0020\0162\006\020'\032\0020(H\026J\024\020)\032\004\030\0010*2\b\020+\032\004\030\0010*H\002J\b\020,\032\0020\nH\026J\016\020-\032\0020\n2\006\020.\032\0020*J\020\020/\032\0020\n2\006\0200\032\0020*H\002J\f\0201\032\00202*\0020\016H\002R\016\020\003\032\0020\004X.¢\006\002\n\000R\021\020\005\032\0020\006¢\006\b\n\000\032\004\b\007\020\b¨\0064"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/ButtonLogin;", "Lnet/minecraft/client/gui/GuiScreen;", "()V", "loginButton", "Lnet/minecraft/client/gui/GuiButton;", "logintime", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "getLogintime", "()Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "actionPerformed", "", "button", "drawArc", "cx", "", "cy", "radius", "startAngle", "endAngle", "color", "drawLine", "x1", "y1", "x2", "y2", "drawPixel", "x", "y", "drawRoundedButton", "drawRoundedRect", "left", "top", "right", "bottom", "drawRoundedRectOutline", "thickness", "drawScreen", "mouseX", "mouseY", "partialTicks", "", "encode", "", "inputData", "initGui", "openLink", "url", "showMessageDialog", "message", "toRadians", "", "Companion", "XSJClient"})
/*     */ public final class ButtonLogin extends GuiScreen {
/*     */   @NotNull
/*  24 */   private final MSTimer logintime = new MSTimer(); private GuiButton loginButton; public static final Companion Companion = new Companion(null); @NotNull public final MSTimer getLogintime() { return this.logintime; }
/*     */    public void func_73866_w_() {
/*  26 */     this.field_146292_n.clear();
/*     */     
/*  28 */     int centerX = this.field_146294_l / 2;
/*  29 */     int centerY = this.field_146295_m / 2;
/*     */     
/*  31 */     int buttonWidth = 162;
/*  32 */     int buttonHeight = this.field_146289_q.field_78288_b + 17;
/*     */ 
/*     */     
/*  35 */     this.loginButton = new GuiButton(0, centerX - buttonWidth / 2, centerY + 40, buttonWidth, buttonHeight, "Login");
/*  36 */     if (this.loginButton == null) Intrinsics.throwUninitializedPropertyAccessException("loginButton");  this.field_146292_n.add(this.loginButton);
/*     */   }
/*     */   
/*     */   public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
/*  40 */     super.func_73863_a(mouseX, mouseY, partialTicks);
/*  41 */     RenderUtils.drawImage(new ResourceLocation("tomk/splash2.png"), 0, 0, this.field_146294_l, this.field_146295_m);
/*     */ 
/*     */     
/*  44 */     if (this.loginButton == null) Intrinsics.throwUninitializedPropertyAccessException("loginButton");  drawRoundedButton(this.loginButton);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  49 */     if (this.loginButton == null) Intrinsics.throwUninitializedPropertyAccessException("loginButton"); 
/*  50 */     if (this.loginButton == null) Intrinsics.throwUninitializedPropertyAccessException("loginButton");  if (this.loginButton == null) Intrinsics.throwUninitializedPropertyAccessException("loginButton"); 
/*  51 */     if (this.loginButton == null) Intrinsics.throwUninitializedPropertyAccessException("loginButton");  if (this.loginButton == null) Intrinsics.throwUninitializedPropertyAccessException("loginButton");  func_73732_a(this.field_146289_q, this.loginButton.field_146126_j, this.loginButton.field_146128_h + this.loginButton.field_146120_f / 2, this.loginButton.field_146129_i + (this.loginButton.field_146121_g - 8) / 2, 
/*  52 */         16777215);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146284_a(@NotNull GuiButton button) {
/*  59 */     Intrinsics.checkParameterIsNotNull(button, "button"); if (this.loginButton == null) Intrinsics.throwUninitializedPropertyAccessException("loginButton");  if (button == this.loginButton) {
/*  60 */       String currenttoken = Companion.gettoken();
/*  61 */       if (Companion.getweb("https://gitcode.net/liufanzhubo/xsj-client-yes/-/raw/master/hwid") == null) Intrinsics.throwNpe();  String str1 = Companion.gettoken(), str2 = Companion.getweb("https://gitcode.net/liufanzhubo/xsj-client-yes/-/raw/master/hwid"); boolean bool = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");  String str3 = StringsKt.trim(str1).toString(); if (StringsKt.contains$default(str2, str3, false, 2, null)) {
/*  62 */         this.logintime.hasTimePassed(100L);
/*  63 */         this.field_146297_k.func_147108_a(new HuaHuoUI());
/*     */       } else {
/*  65 */         Intrinsics.checkExpressionValueIsNotNull(Toolkit.getDefaultToolkit(), "Toolkit.getDefaultToolkit()"); Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(currenttoken), null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final void showMessageDialog(String message)
/*     */   {
/*  74 */     SwingUtilities.invokeLater(new ButtonLogin$showMessageDialog$1(message)); } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "run"})
/*  75 */   static final class ButtonLogin$showMessageDialog$1 implements Runnable { public final void run() { String[] options = { "好的", "进入官方群" };
/*  76 */       int result = JOptionPane.showOptionDialog(
/*  77 */           null, 
/*  78 */           this.$message, 
/*  79 */           "！滚出去先验证再玩 ！", 
/*  80 */           -1, 
/*  81 */           1, 
/*  82 */           null, 
/*  83 */           (Object[])options, 
/*  84 */           options[0]);
/*     */ 
/*     */       
/*  87 */       if (result == 1)
/*     */       {
/*  89 */         ButtonLogin.this.openLink("https://qm.qq.com/cgi-bin/qm/qr?k=WhExVFvP1FCoNDnJQ992otA2KGjkb5Xk&jump_from=webapi&authKey=ZEDglAl/dCXmydgKiDucf0R78joI0qEPh8yWA38ox4iwH7wGvosa+XuQ9DA+EhWy");
/*     */       } }
/*     */ 
/*     */ 
/*     */     
/*     */     ButtonLogin$showMessageDialog$1(String param1String) {} }
/*     */ 
/*     */   
/*     */   public final void openLink(@NotNull String url) {
/*  98 */     Intrinsics.checkParameterIsNotNull(url, "url"); try {
/*  99 */       URI uri = new URI(url);
/* 100 */       if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
/* 101 */         Desktop.getDesktop().browse(uri);
/*     */       }
/* 103 */     } catch (Exception e) {
/* 104 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\002\b\004\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\006\020\003\032\0020\004J\006\020\005\032\0020\004J\020\020\006\032\004\030\0010\0042\006\020\007\032\0020\004¨\006\b"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/ButtonLogin$Companion;", "", "()V", "gethwid", "", "gettoken", "getweb", "urlString", "XSJClient"})
/*     */   public static final class Companion { private Companion() {}
/*     */     
/*     */     @Nullable
/*     */     public final String getweb(@NotNull String urlString) {
/* 113 */       Intrinsics.checkParameterIsNotNull(urlString, "urlString"); String content = (String)null;
/*     */       try {
/* 115 */         URL url = new URL(urlString);
/* 116 */         if (url.openConnection() == null) throw new TypeCastException("null cannot be cast to non-null type java.net.HttpURLConnection");  HttpURLConnection connection = (HttpURLConnection)url.openConnection();
/* 117 */         connection.setRequestMethod("GET");
/* 118 */         connection.setConnectTimeout(5000);
/* 119 */         connection.setReadTimeout(5000);
/*     */         
/* 121 */         int responseCode = connection.getResponseCode();
/* 122 */         if (responseCode == 200) {
/* 123 */           InputStream inputStream = connection.getInputStream();
/* 124 */           Intrinsics.checkExpressionValueIsNotNull(inputStream, "inputStream"); InputStream inputStream1 = inputStream; Charset charset = Charsets.UTF_8; boolean bool2 = false; InputStream inputStream2 = inputStream1; char c = Character.MIN_VALUE; null = new InputStreamReader(inputStream2, charset); c = ' '; boolean bool3 = false; BufferedReader bufferedReader = (null instanceof BufferedReader) ? (BufferedReader)null : new BufferedReader(null, c); boolean bool1 = false; Throwable throwable = (Throwable)null; try { BufferedReader it = bufferedReader; int $i$a$-use-ButtonLogin$Companion$getweb$1 = 0; String str = TextStreamsKt.readText(it); } catch (Throwable throwable1) { throwable = throwable1 = null; throw throwable1; } finally { CloseableKt.closeFinally(bufferedReader, throwable); }  content = str;
/* 125 */           inputStream.close();
/*     */         } 
/*     */         
/* 128 */         connection.disconnect();
/* 129 */       } catch (Exception e) {
/* 130 */         e.printStackTrace();
/*     */       } 
/* 132 */       return content;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @NotNull
/*     */     public final String gethwid() {
/* 139 */       StringBuilder s = new StringBuilder();
/* 140 */       String main = System.getenv("PROCESS_IDENTIFIER") + System.getenv("COMPUTERNAME");
/* 141 */       String str1 = main, str2 = "UTF-8"; boolean bool = false; Intrinsics.checkExpressionValueIsNotNull(Charset.forName(str2), "Charset.forName(charsetName)"); Charset charset = Charset.forName(str2); bool = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.getBytes(charset), "(this as java.lang.String).getBytes(charset)"); byte[] bytes = str1.getBytes(charset);
/* 142 */       MessageDigest messageDigest = MessageDigest.getInstance("SHA");
/* 143 */       byte[] sha = messageDigest.digest(bytes);
/* 144 */       int i = 0;
/* 145 */       int maxLength = 5;
/* 146 */       for (byte b : sha) {
/* 147 */         s.append(Integer.toHexString(b & 0xFF | 0x300), 0, 3);
/* 148 */         if (i != sha.length - 1 && i < maxLength - 1) {
/* 149 */           s.append("0");
/* 150 */         } else if (i >= maxLength - 1) {
/*     */           break;
/*     */         } 
/* 153 */         i++;
/*     */       } 
/* 155 */       Intrinsics.checkExpressionValueIsNotNull(s.toString(), "s.toString()"); return s.toString();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @NotNull
/*     */     public final String gettoken() {
/* 162 */       StringBuilder s = new StringBuilder();
/* 163 */       String main = System.getenv("COMPUTERNAME") + System.getenv("PROCESS_IDENTIFIER");
/* 164 */       String str1 = main, str2 = "UTF-8"; boolean bool = false; Intrinsics.checkExpressionValueIsNotNull(Charset.forName(str2), "Charset.forName(charsetName)"); Charset charset = Charset.forName(str2); bool = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.getBytes(charset), "(this as java.lang.String).getBytes(charset)"); byte[] bytes = str1.getBytes(charset);
/* 165 */       MessageDigest messageDigest = MessageDigest.getInstance("md5");
/* 166 */       byte[] md5 = messageDigest.digest(bytes);
/* 167 */       int i = 0;
/* 168 */       int maxLength = 7;
/*     */       
/* 170 */       for (byte b : md5) {
/* 171 */         s.append(Integer.toHexString(b & 0xFF | 0x300), 0, 3);
/* 172 */         if (i != md5.length - 1 && i < maxLength - 1) {
/* 173 */           s.append("");
/* 174 */         } else if (i >= maxLength - 1) {
/*     */           break;
/*     */         } 
/* 177 */         i++;
/*     */       } 
/*     */       
/* 180 */       Intrinsics.checkExpressionValueIsNotNull(s.toString(), "s.toString()"); return s.toString();
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final void drawRoundedButton(GuiButton button) {
/* 188 */     int cornerRadius = 5;
/*     */ 
/*     */     
/* 191 */     drawRoundedRect(
/* 192 */         button.field_146128_h, 
/* 193 */         button.field_146129_i, 
/* 194 */         button.field_146128_h + button.field_146120_f, 
/* 195 */         button.field_146129_i + button.field_146121_g, 
/* 196 */         cornerRadius, 
/* 197 */         (int)4281684079L);
/*     */ 
/*     */ 
/*     */     
/* 201 */     drawRoundedRectOutline(
/* 202 */         button.field_146128_h, 
/* 203 */         button.field_146129_i, 
/* 204 */         button.field_146128_h + button.field_146120_f, 
/* 205 */         button.field_146129_i + button.field_146121_g, 
/* 206 */         cornerRadius, 
/* 207 */         2, 
/* 208 */         (int)4294967295L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final void drawRoundedRect(int left, int top, int right, int bottom, int radius, int color) {
/* 216 */     func_73733_a(left + radius, top, right - radius, bottom, color, color);
/* 217 */     func_73733_a(left, top + radius, left + radius, bottom - radius, color, color);
/* 218 */     func_73733_a(right - radius, top + radius, right, bottom - radius, color, color);
/*     */     
/* 220 */     drawArc(left + radius, top + radius, radius, 0, 90, color);
/* 221 */     drawArc(right - radius, top + radius, radius, 270, 360, color);
/* 222 */     drawArc(right - radius, bottom - radius, radius, 180, 270, color);
/* 223 */     drawArc(left + radius, bottom - radius, radius, 90, 180, color);
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
/*     */   private final void drawRoundedRectOutline(int left, int top, int right, int bottom, int radius, int thickness, int color) {
/*     */     byte b;
/*     */     int i;
/* 238 */     for (b = 0, i = thickness; b < i; b++) {
/* 239 */       drawArc(left + radius - b, top + radius - b, radius, 135, 315, color);
/* 240 */       drawArc(right - radius - b, top + radius - b, radius, 45, 225, color);
/* 241 */       drawArc(right - radius - b, bottom - radius - b, radius, -45, 135, color);
/* 242 */       drawArc(left + radius - b, bottom - radius - b, radius, -135, 45, color);
/*     */       
/* 244 */       drawLine(left + radius - b, top + b, right - radius + b, top + b, color);
/* 245 */       drawLine(right - b, top + radius - radius + b, right - b, bottom - radius + radius - b, color);
/* 246 */       drawLine(right - radius + b, bottom - b, left + radius - b, bottom - b, color);
/* 247 */       drawLine(left + b, bottom - radius + radius - b, left + b, top + radius - radius + b, color);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final void drawArc(int cx, int cy, int radius, int startAngle, int endAngle, int color) {
/* 255 */     for (int i = startAngle, j = endAngle; i < j; i++) {
/* 256 */       double x = cx + radius * Math.cos(toRadians(i));
/* 257 */       double y = cy + radius * Math.sin(toRadians(i));
/* 258 */       drawPixel((int)x, (int)y, color);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final void drawLine(int x1, int y1, int x2, int y2, int color) {
/* 266 */     GuiScreen.func_73734_a(x1, y1, x2, y2, color);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final void drawPixel(int x, int y, int color) {
/* 273 */     GuiScreen.func_73734_a(x, y, x + 1, y + 1, color);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String encode(String inputData) {
/* 280 */     String str1 = inputData; boolean bool1 = false, bool3 = false; if ((str1 == null || str1.length() == 0)) {
/* 281 */       return null;
/*     */     }
/* 283 */     String str2 = inputData; Base64.Encoder encoder = Base64.getEncoder(); Charset charset = Charsets.UTF_8; boolean bool4 = false; if (str2 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str2.getBytes(charset), "(this as java.lang.String).getBytes(charset)"); byte[] arrayOfByte2 = str2.getBytes(charset), encodedBytes = encoder.encode(arrayOfByte2);
/* 284 */     Intrinsics.checkExpressionValueIsNotNull(encodedBytes, "encodedBytes"); byte[] arrayOfByte1 = encodedBytes; boolean bool2 = false; return new String(arrayOfByte1, Charsets.UTF_8);
/*     */   }
/*     */   private final double toRadians(int $this$toRadians) {
/* 287 */     return $this$toRadians * Math.PI / '´';
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\ButtonLogin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */