/*     */ package net.ccbluex.liquidbounce.ui.Verify1;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.TrayIcon;
/*     */ import java.awt.datatransfer.Clipboard;
/*     */ import java.io.IOException;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.Base64;
/*     */ import javax.swing.JOptionPane;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IScaledResolution;
/*     */ import net.ccbluex.liquidbounce.api.util.WrappedGuiScreen;
/*     */ import net.ccbluex.liquidbounce.ui.Verify1.font.FontLoaders;
/*     */ import net.ccbluex.liquidbounce.ui.Verify1.utils.HWIDUtils;
/*     */ import net.ccbluex.liquidbounce.ui.Verify1.utils.SystemUtils;
/*     */ import net.ccbluex.liquidbounce.ui.Verify1.utils.WebUtils;
/*     */ import net.ccbluex.liquidbounce.ui.client.HuaHuoUI;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ import org.lwjgl.input.Mouse;
/*     */ import org.lwjgl.opengl.Display;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuiLogin
/*     */   extends WrappedGuiScreen
/*     */ {
/*  35 */   static final Base64.Encoder encoder = Base64.getEncoder();
/*  36 */   static final Base64.Decoder decoder = Base64.getDecoder();
/*  37 */   int alpha = 0;
/*     */   private boolean i = false;
/*     */   private boolean j = false;
/*  40 */   public String UserName = null;
/*  41 */   public String Password = null;
/*     */   public static GuiPasswordField password;
/*     */   public static GuiUserField username;
/*     */   public static boolean render = false;
/*     */   private float currentX;
/*     */   private float currentY;
/*     */   public boolean drag = false;
/*     */   public static boolean Passed = false;
/*     */   public static boolean UnDisCheck = false;
/*     */   String hwid;
/*     */   public static boolean isload = false;
/*  52 */   public static String HWID = null;
/*  53 */   public static int LOVEU = 1;
/*  54 */   public static String process = "[Waiting For Login...]";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GuiLogin() {
/*     */     try {
/*  61 */       this.hwid = HWIDUtils.getHWID();
/*  62 */     } catch (IOException|java.security.NoSuchAlgorithmException ioexception) {
/*  63 */       ioexception.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawScreen(int i, int j, float f) {
/*  69 */     Display.setTitle("XSJ | Not login");
/*  70 */     if (this.i && this.alpha < 255) {
/*  71 */       this.alpha += 5;
/*     */     }
/*     */     
/*  74 */     this; int h = classProvider.createScaledResolution(mc).getScaledHeight();
/*  75 */     this; int w = classProvider.createScaledResolution(mc).getScaledWidth();
/*     */     
/*  77 */     RenderUtils.drawGradientSideways(0.0D, 0.0D, w, h, (new Color(60, 96, 203)).getRGB(), (new Color(51, 201, 217)).getRGB());
/*  78 */     this.representedScreen.drawBackground(0);
/*  79 */     this; IScaledResolution sr = classProvider.createScaledResolution(mc);
/*  80 */     float xDiff = ((i - h / 2) - this.currentX) / sr.getScaleFactor();
/*  81 */     float yDiff = ((j - w / 2) - this.currentY) / sr.getScaleFactor();
/*     */     
/*  83 */     this.currentX += xDiff * 0.3F;
/*  84 */     this.currentY += yDiff * 0.3F;
/*  85 */     if (!Mouse.isButtonDown(0)) {
/*  86 */       this.drag = false;
/*     */     } else {
/*  88 */       this.drag = true;
/*     */     } 
/*  90 */     RenderUtils.drawGradientSideways((this.representedScreen.getWidth() / 2 + 30), (this.representedScreen.getHeight() / 2 + 47), (this.representedScreen.getWidth() / 2 + 155), (this.representedScreen.getHeight() / 2 + 70), (new Color(94, 212, 255)).getRGB(), (new Color(253, 222, 90)).getRGB());
/*     */     
/*  92 */     if (Mouse.isButtonDown(0) && i > this.representedScreen.getWidth() / 2 + 120 && i < this.representedScreen.getWidth() / 2 + 155 && j > this.representedScreen.getHeight() / 2 + 75 && j < this.representedScreen.getHeight() / 2 + 82) {
/*  93 */       Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
/*     */       
/*  95 */       GuiScreen.func_146275_d(this.hwid);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 101 */     RenderUtils.drawRect((this.representedScreen.getWidth() / 2 - 180), (this.representedScreen.getHeight() / 2 - 115), (this.representedScreen.getWidth() / 2 + 180), (this.representedScreen.getHeight() / 2 + 115), (new Color(89, 89, 89, 171)).getRGB());
/* 102 */     RenderUtils.drawShadow((this.representedScreen.getWidth() / 2 - 180), (this.representedScreen.getHeight() / 2 - 115), 360.0F, 230.0F);
/* 103 */     RenderUtils.drawmage(new ResourceLocation("pride/login.png"), this.representedScreen.getWidth() / 2 - 180, this.representedScreen.getHeight() / 2 - 115, 360, 230, 1.0F);
/* 104 */     RenderUtils.drawGradientSideways((this.representedScreen.getWidth() / 2 + 30), (this.representedScreen.getHeight() / 2 + 47), (this.representedScreen.getWidth() / 2 + 155), (this.representedScreen.getHeight() / 2 + 70), (new Color(0, 111, 255)).getRGB(), (new Color(255, 125, 198)).getRGB());
/* 105 */     RenderUtils.drawGradientSideways((this.representedScreen.getWidth() / 2 + 30), (this.representedScreen.getHeight() / 2 - 9), (this.representedScreen.getWidth() / 2 + 155), (this.representedScreen.getHeight() / 2 - 8), (new Color(0, 111, 255, 255)).getRGB(), (new Color(255, 125, 198)).getRGB());
/* 106 */     RenderUtils.drawGradientSideways((this.representedScreen.getWidth() / 2 + 30), (this.representedScreen.getHeight() / 2 + 30), (this.representedScreen.getWidth() / 2 + 155), (this.representedScreen.getHeight() / 2 + 31), (new Color(0, 111, 255, 255)).getRGB(), (new Color(255, 125, 198)).getRGB());
/*     */     
/* 108 */     if (!username.getText().isEmpty() && Mouse.isButtonDown(0) && this.drag && i > this.representedScreen.getWidth() / 2 + 30 && i < this.representedScreen.getWidth() / 2 + 155 && j > this.representedScreen.getHeight() / 2 + 47 && j < this.representedScreen.getHeight() / 2 + 70) {
/*     */       
/* 110 */       GuiScreen.func_146275_d(this.hwid);
/* 111 */       verify();
/* 112 */       Fonts.tenacitybold30.drawString("Login", (this.representedScreen.getWidth() / 2 + 10), (this.representedScreen.getHeight() / 2 - 75), -1);
/*     */     } 
/*     */     
/* 115 */     FontLoaders.xyz20.drawString("Login", (this.representedScreen.getWidth() / 2 + 80), (this.representedScreen.getHeight() / 2 + 55), -1);
/* 116 */     FontLoaders.xyz16.drawString("Click Login to get HWID", (this.representedScreen.getWidth() / 2 + 60), (this.representedScreen.getHeight() / 2 + 53 + 25), (new Color(200, 200, 200)).getRGB());
/*     */     
/* 118 */     FontLoaders.xyz16.drawString("Log in to your account so that we can", (this.representedScreen.getWidth() / 2 + 10), (this.representedScreen.getHeight() / 2 - 61), (new Color(217, 217, 217)).getRGB());
/* 119 */     FontLoaders.xyz16.drawString("check your identity.", (this.representedScreen.getWidth() / 2 + 10), (this.representedScreen.getHeight() / 2 - 53), (new Color(210, 210, 210)).getRGB());
/* 120 */     FontLoaders.xyz32.drawString("Login to client", (this.representedScreen.getWidth() / 2 - 165), (this.representedScreen.getHeight() / 2 - 105), -1);
/* 121 */     FontLoaders.xyz28.drawString("新年快乐！", (this.representedScreen.getWidth() / 2 - 150), (this.representedScreen.getHeight() / 2 + 40 + 20), (new Color(255, 255, 255, 255)).getRGB());
/* 122 */     FontLoaders.xyz16.drawString("XSJ", (this.representedScreen.getWidth() / 2 - 150), (this.representedScreen.getHeight() / 2 + 53 + 23), (new Color(211, 211, 211)).getRGB());
/* 123 */     username.drawTextBox2();
/* 124 */     FontLoaders.xyz16.drawString("Byfange", (this.representedScreen.getWidth() / 2 - 150), (this.representedScreen.getHeight() / 2 + 53 + 31), (new Color(213, 213, 213)).getRGB());
/* 125 */     password.drawTextBox2();
/* 126 */     if (password.getText().isEmpty() && !password.isFocused()) FontLoaders.xyz16.drawString("Your Password", (this.representedScreen.getWidth() / 2 + 35), (this.representedScreen.getHeight() / 2 + 20), (new Color(180, 180, 180)).getRGB());
/*     */     
/* 128 */     if (username.getText().isEmpty() && !username.isFocused()) {
/* 129 */       FontLoaders.xyz16.drawString("Your Username", (this.representedScreen.getWidth() / 2 + 35), (this.representedScreen.getHeight() / 2 - 19), (new Color(180, 180, 180)).getRGB());
/*     */     }
/*     */     
/* 132 */     super.drawScreen(i, j, f);
/*     */   }
/*     */   
/*     */   public void initGui() {
/* 136 */     FontRenderer fontrenderer = mc2.field_71466_p;
/* 137 */     super.initGui();
/* 138 */     render = true;
/* 139 */     username = new GuiUserField(fontrenderer, this.representedScreen.getWidth() / 2 + 30, this.representedScreen.getHeight() / 2 - 30, 125, 20);
/* 140 */     password = new GuiPasswordField(fontrenderer, this.representedScreen.getWidth() / 2 + 30, this.representedScreen.getHeight() / 2 + 10, 125, 20);
/*     */   }
/*     */   
/*     */   public void keyTyped(char c0, int i) {
/* 144 */     if (c0 == '\t') {
/* 145 */       if (!username.isFocused()) {
/* 146 */         username.setFocused(true);
/*     */       } else {
/* 148 */         username.setFocused(username.isFocused());
/* 149 */         password.setFocused(!username.isFocused());
/*     */       } 
/*     */     }
/*     */     
/* 153 */     if (c0 == '\033');
/*     */ 
/*     */ 
/*     */     
/* 157 */     username.textboxKeyTyped(c0, i);
/* 158 */     password.textboxKeyTyped(c0, i);
/*     */   }
/*     */   
/*     */   private void verify() {
/*     */     try {
/* 163 */       LOVEU *= 10;
/* 164 */       HWID = HWIDUtils.getHWID();
/*     */       
/* 166 */       GuiScreen.func_146275_d(this.hwid);
/* 167 */       if (!username.getText().isEmpty() && !HWID.isEmpty()) {
/* 168 */         LOVEU *= 10;
/* 169 */         this.UserName = username.getText();
/* 170 */         this.Password = password.getText();
/* 171 */         String throwable = "[" + this.UserName + "]" + HWIDUtils.getHWID() + ":" + this.Password;
/*     */         
/* 173 */         if (WebUtils.get("https://gitcode.net/liufanzhubo/xsj-client-yes/-/raw/master/hwid").contains(throwable)) {
/* 174 */           LOVEU *= 10;
/* 175 */           isload = true;
/*     */ 
/*     */           
/* 178 */           mc2.func_147108_a((GuiScreen)new HuaHuoUI());
/*     */ 
/*     */ 
/*     */           
/* 182 */           Display.setTitle("XSJ Client v2.3 New Year's Special Edition | User: " + this.UserName);
/*     */         } else {
/*     */           
/* 185 */           isload = false;
/* 186 */           GuiScreen.func_146275_d(this.hwid);
/* 187 */           SystemUtils.displayTray("ERROR", "If you have never registered or forgotten your password, please contact the administrator", TrayIcon.MessageType.ERROR);
/*     */         }
/*     */       
/*     */       }
/*     */     
/* 192 */     } catch (Throwable throwable) {
/*     */       try {
/* 194 */         LOVEU *= 10;
/* 195 */         HWID = HWIDUtils.getHWID();
/* 196 */         if (!username.getText().isEmpty() && !HWID.isEmpty()) {
/* 197 */           LOVEU *= 10;
/* 198 */           this.UserName = username.getText();
/* 199 */           this.Password = password.getText();
/*     */           
/* 201 */           GuiScreen.func_146275_d(this.hwid);
/* 202 */           String throwable1 = "[" + this.UserName + "]" + HWIDUtils.getHWID() + ":" + this.Password;
/*     */           
/* 204 */           if (WebUtils.get("https://gitcode.net/liufanzhubo/xsj-client-yes/-/raw/master/hwid").contains(throwable1)) {
/* 205 */             LOVEU *= 10;
/* 206 */             isload = true;
/*     */             
/* 208 */             mc2.func_147108_a((GuiScreen)new HuaHuoUI());
/*     */           } else {
/*     */             
/* 211 */             isload = false;
/*     */             
/* 213 */             SystemUtils.displayTray("ERROR", "If you have never registered or forgotten your password, please contact the administrator", TrayIcon.MessageType.ERROR);
/*     */           } 
/*     */         } 
/* 216 */       } catch (Throwable throwable1) {
/* 217 */         throwable1.printStackTrace();
/* 218 */         JOptionPane.showMessageDialog(null, "ERROR");
/*     */         
/* 220 */         GuiScreen.func_146275_d(this.hwid);
/* 221 */         this; mc.shutdown();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mouseClicked(int i, int j, int k) {
/*     */     try {
/* 233 */       super.mouseClicked(i, j, k);
/* 234 */     } catch (IOException ioexception) {
/* 235 */       ioexception.printStackTrace();
/*     */     } 
/*     */     
/* 238 */     username.mouseClicked(i, j, k);
/* 239 */     password.mouseClicked(i, j, k);
/*     */   }
/*     */   
/*     */   public void onGuiClosed() {
/* 243 */     Keyboard.enableRepeatEvents(false);
/*     */   }
/*     */   
/*     */   public void updateScreen() {
/* 247 */     username.updateCursorCounter();
/* 248 */     password.updateCursorCounter();
/*     */   }
/*     */   
/*     */   public static String decode(String encodedText) {
/* 252 */     String text = null;
/*     */     
/*     */     try {
/* 255 */       text = new String(decoder.decode(encodedText), "UTF-8");
/* 256 */     } catch (UnsupportedEncodingException unsupportedencodingexception) {
/* 257 */       unsupportedencodingexception.printStackTrace();
/*     */     } 
/*     */     
/* 260 */     return text;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\Verify1\GuiLogin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */