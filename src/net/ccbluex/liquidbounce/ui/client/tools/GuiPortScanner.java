/*     */ package net.ccbluex.liquidbounce.ui.client.tools;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.Socket;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.swing.JOptionPane;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiButton;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiScreen;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiTextField;
/*     */ import net.ccbluex.liquidbounce.api.util.WrappedGuiScreen;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.TabUtils;
/*     */ import net.ccbluex.liquidbounce.utils.misc.MiscUtils;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ 
/*     */ public class GuiPortScanner
/*     */   extends WrappedGuiScreen
/*     */ {
/*     */   private final IGuiScreen prevGui;
/*  25 */   private final List<Integer> ports = new ArrayList<>();
/*     */   private IGuiTextField hostField;
/*     */   private IGuiTextField minPortField;
/*     */   private IGuiTextField maxPortField;
/*     */   private IGuiTextField threadsField;
/*     */   private IGuiButton buttonToggle;
/*     */   private boolean running;
/*  32 */   private String status = "§7Waiting...";
/*     */   private String host;
/*     */   private int currentPort;
/*     */   private int maxPort;
/*     */   private int minPort;
/*     */   private int checkedPort;
/*     */   
/*     */   public GuiPortScanner(IGuiScreen prevGui) {
/*  40 */     this.prevGui = prevGui;
/*     */   }
/*     */ 
/*     */   
/*     */   public void initGui() {
/*  45 */     Keyboard.enableRepeatEvents(true);
/*     */     
/*  47 */     this.hostField = classProvider.createGuiTextField(0, Fonts.roboto40, this.representedScreen.getWidth() / 2 - 100, 60, 200, 20);
/*  48 */     this.hostField.setFocused(true);
/*  49 */     this.hostField.setMaxStringLength(2147483647);
/*  50 */     this.hostField.setText("localhost");
/*     */     
/*  52 */     this.minPortField = classProvider.createGuiTextField(1, Fonts.roboto40, this.representedScreen.getHeight() / 2 - 100, 90, 90, 20);
/*  53 */     this.minPortField.setMaxStringLength(5);
/*  54 */     this.minPortField.setText(String.valueOf(1));
/*     */     
/*  56 */     this.maxPortField = classProvider.createGuiTextField(2, Fonts.roboto40, this.representedScreen.getWidth() / 2 + 10, 90, 90, 20);
/*  57 */     this.maxPortField.setMaxStringLength(5);
/*  58 */     this.maxPortField.setText(String.valueOf(65535));
/*     */     
/*  60 */     this.threadsField = classProvider.createGuiTextField(3, Fonts.roboto40, this.representedScreen.getWidth() / 2 - 100, 120, 200, 20);
/*  61 */     this.threadsField.setMaxStringLength(2147483647);
/*  62 */     this.threadsField.setText(String.valueOf(500));
/*     */     
/*  64 */     this.representedScreen.getButtonList().add(this.buttonToggle = classProvider.createGuiButton(1, this.representedScreen.getWidth() / 2 - 100, this.representedScreen.getHeight() / 4 + 95, this.running ? "Stop" : "Start"));
/*  65 */     this.representedScreen.getButtonList().add(classProvider.createGuiButton(0, this.representedScreen.getWidth() / 2 - 100, this.representedScreen.getHeight() / 4 + 120, "Back"));
/*  66 */     this.representedScreen.getButtonList().add(classProvider.createGuiButton(2, this.representedScreen.getWidth() / 2 - 100, this.representedScreen.getHeight() / 4 + 155, "Export"));
/*     */     
/*  68 */     super.initGui();
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/*  73 */     this.representedScreen.drawBackground(0);
/*     */     
/*  75 */     Fonts.roboto40.drawCenteredString("Port Scanner", this.representedScreen.getWidth() / 2.0F, 34.0F, 16777215);
/*  76 */     Fonts.roboto35.drawCenteredString(this.running ? ("§7" + this.checkedPort + " §8/ §7" + this.maxPort) : ((this.status == null) ? "" : this.status), this.representedScreen.getWidth() / 2.0F, this.representedScreen.getHeight() / 4.0F + 80.0F, 16777215);
/*     */     
/*  78 */     this.buttonToggle.setDisplayString(this.running ? "Stop" : "Start");
/*     */     
/*  80 */     this.hostField.drawTextBox();
/*  81 */     this.minPortField.drawTextBox();
/*  82 */     this.maxPortField.drawTextBox();
/*  83 */     this.threadsField.drawTextBox();
/*     */     
/*  85 */     Fonts.roboto40.drawString("§c§lPorts:", 2, 2, Color.WHITE.hashCode());
/*     */     
/*  87 */     synchronized (this.ports) {
/*  88 */       int i = 12;
/*     */       
/*  90 */       for (Integer integer : this.ports) {
/*  91 */         Fonts.roboto35.drawString(String.valueOf(integer), 2, i, Color.WHITE.hashCode());
/*  92 */         i += Fonts.roboto35.getFontHeight();
/*     */       } 
/*     */     } 
/*     */     
/*  96 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */   
/*     */   public void actionPerformed(IGuiButton button) throws IOException {
/*     */     File selectedFile;
/* 101 */     switch (button.getId()) {
/*     */       case 0:
/* 103 */         mc.displayGuiScreen(this.prevGui);
/*     */         break;
/*     */       case 1:
/* 106 */         if (this.running) {
/* 107 */           this.running = false;
/*     */         } else {
/* 109 */           int threads; this.host = this.hostField.getText();
/*     */           
/* 111 */           if (this.host.isEmpty()) {
/* 112 */             this.status = "§cInvalid host";
/*     */             
/*     */             return;
/*     */           } 
/*     */           try {
/* 117 */             this.minPort = Integer.parseInt(this.minPortField.getText());
/* 118 */           } catch (NumberFormatException e) {
/* 119 */             this.status = "§cInvalid min port";
/*     */             
/*     */             return;
/*     */           } 
/*     */           try {
/* 124 */             this.maxPort = Integer.parseInt(this.maxPortField.getText());
/* 125 */           } catch (NumberFormatException e) {
/* 126 */             this.status = "§cInvalid max port";
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*     */           try {
/* 132 */             threads = Integer.parseInt(this.threadsField.getText());
/* 133 */           } catch (NumberFormatException e) {
/* 134 */             this.status = "§cInvalid threads";
/*     */             
/*     */             return;
/*     */           } 
/* 138 */           this.ports.clear();
/*     */           
/* 140 */           this.currentPort = this.minPort - 1;
/* 141 */           this.checkedPort = this.minPort;
/*     */           
/* 143 */           for (int i = 0; i < threads; i++) {
/* 144 */             (new Thread(() -> {
/*     */                   try {
/*     */                     while (this.running && this.currentPort < this.maxPort) {
/*     */                       int port = ++this.currentPort;
/*     */                       
/*     */                       try {
/*     */                         Socket socket = new Socket();
/*     */                         
/*     */                         socket.connect(new InetSocketAddress(this.host, port), 500);
/*     */                         
/*     */                         socket.close();
/*     */                         synchronized (this.ports) {
/*     */                           if (!this.ports.contains(Integer.valueOf(port))) {
/*     */                             this.ports.add(Integer.valueOf(port));
/*     */                           }
/*     */                         } 
/* 160 */                       } catch (Exception exception) {}
/*     */                       
/*     */                       if (this.checkedPort < port) {
/*     */                         this.checkedPort = port;
/*     */                       }
/*     */                     } 
/*     */                     
/*     */                     this.running = false;
/*     */                     this.buttonToggle.setDisplayString("Start");
/* 169 */                   } catch (Exception e) {
/*     */                     this.status = "§a§l" + e.getClass().getSimpleName() + ": §c" + e.getMessage();
/*     */                   } 
/* 172 */                 })).start();
/*     */           } 
/*     */           
/* 175 */           this.running = true;
/*     */         } 
/*     */         
/* 178 */         this.buttonToggle.setDisplayString(this.running ? "Stop" : "Start");
/*     */         break;
/*     */       case 2:
/* 181 */         selectedFile = MiscUtils.saveFileChooser();
/*     */         
/* 183 */         if (selectedFile == null || selectedFile.isDirectory()) {
/*     */           return;
/*     */         }
/*     */         try {
/* 187 */           if (!selectedFile.exists()) {
/* 188 */             selectedFile.createNewFile();
/*     */           }
/* 190 */           FileWriter fileWriter = new FileWriter(selectedFile);
/*     */           
/* 192 */           fileWriter.write("Portscan\r\n");
/* 193 */           fileWriter.write("Host: " + this.host + "\r\n\r\n");
/*     */           
/* 195 */           fileWriter.write("Ports (" + this.minPort + " - " + this.maxPort + "):\r\n");
/*     */           
/* 197 */           for (Integer integer : this.ports)
/* 198 */             fileWriter.write(integer + "\r\n"); 
/* 199 */           fileWriter.flush();
/* 200 */           fileWriter.close();
/* 201 */           JOptionPane.showMessageDialog(null, "Exported successfully!", "Port Scanner", 1);
/* 202 */         } catch (Exception e) {
/* 203 */           e.printStackTrace();
/* 204 */           MiscUtils.showErrorPopup("Error", "Exception class: " + e.getClass().getName() + "\nMessage: " + e.getMessage());
/*     */         } 
/*     */         break;
/*     */     } 
/* 208 */     super.actionPerformed(button);
/*     */   }
/*     */ 
/*     */   
/*     */   public void keyTyped(char typedChar, int keyCode) throws IOException {
/* 213 */     if (1 == keyCode) {
/* 214 */       mc.displayGuiScreen(this.prevGui);
/*     */       
/*     */       return;
/*     */     } 
/* 218 */     if (15 == keyCode) {
/* 219 */       TabUtils.tab(new IGuiTextField[] { this.hostField, this.minPortField, this.maxPortField });
/*     */     }
/* 221 */     if (this.running) {
/*     */       return;
/*     */     }
/* 224 */     if (this.hostField.isFocused()) {
/* 225 */       this.hostField.textboxKeyTyped(typedChar, keyCode);
/*     */     }
/* 227 */     if (this.minPortField.isFocused() && !Character.isLetter(typedChar)) {
/* 228 */       this.minPortField.textboxKeyTyped(typedChar, keyCode);
/*     */     }
/* 230 */     if (this.maxPortField.isFocused() && !Character.isLetter(typedChar)) {
/* 231 */       this.maxPortField.textboxKeyTyped(typedChar, keyCode);
/*     */     }
/* 233 */     if (this.threadsField.isFocused() && !Character.isLetter(typedChar))
/* 234 */       this.threadsField.textboxKeyTyped(typedChar, keyCode); 
/* 235 */     super.keyTyped(typedChar, keyCode);
/*     */   }
/*     */ 
/*     */   
/*     */   public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
/* 240 */     this.hostField.mouseClicked(mouseX, mouseY, mouseButton);
/* 241 */     this.minPortField.mouseClicked(mouseX, mouseY, mouseButton);
/* 242 */     this.maxPortField.mouseClicked(mouseX, mouseY, mouseButton);
/* 243 */     this.threadsField.mouseClicked(mouseX, mouseY, mouseButton);
/* 244 */     super.mouseClicked(mouseX, mouseY, mouseButton);
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateScreen() {
/* 249 */     this.hostField.updateCursorCounter();
/* 250 */     this.minPortField.updateCursorCounter();
/* 251 */     this.maxPortField.updateCursorCounter();
/* 252 */     this.threadsField.updateCursorCounter();
/* 253 */     super.updateScreen();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuiClosed() {
/* 258 */     Keyboard.enableRepeatEvents(false);
/* 259 */     this.running = false;
/* 260 */     super.onGuiClosed();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\tools\GuiPortScanner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */