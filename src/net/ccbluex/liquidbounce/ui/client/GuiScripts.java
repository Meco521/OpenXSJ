/*     */ package net.ccbluex.liquidbounce.ui.client;
/*     */ import java.awt.Color;
/*     */ import java.awt.Desktop;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipFile;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiButton;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiScreen;
/*     */ import net.ccbluex.liquidbounce.script.Script;
/*     */ import net.ccbluex.liquidbounce.ui.client.clickgui.ClickGui;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.misc.MiscUtils;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000>\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\002\n\002\020\007\n\002\b\004\n\002\020\f\n\002\b\003\030\0002\0020\001:\001\027B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\007\032\0020\b2\006\020\t\032\0020\nH\026J \020\013\032\0020\b2\006\020\f\032\0020\r2\006\020\016\032\0020\r2\006\020\017\032\0020\020H\026J\b\020\021\032\0020\bH\026J\b\020\022\032\0020\bH\026J\030\020\023\032\0020\b2\006\020\024\032\0020\0252\006\020\026\032\0020\rH\026R\022\020\005\032\0060\006R\0020\000X.¢\006\002\n\000R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\030"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/GuiScripts;", "Lnet/ccbluex/liquidbounce/api/util/WrappedGuiScreen;", "prevGui", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;)V", "list", "Lnet/ccbluex/liquidbounce/ui/client/GuiScripts$GuiList;", "actionPerformed", "", "button", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiButton;", "drawScreen", "mouseX", "", "mouseY", "partialTicks", "", "handleMouseInput", "initGui", "keyTyped", "typedChar", "", "keyCode", "GuiList", "XSJClient"})
/*     */ public final class GuiScripts extends WrappedGuiScreen {
/*     */   private GuiList list;
/*     */   
/*     */   public GuiScripts(@NotNull IGuiScreen prevGui) {
/*  27 */     this.prevGui = prevGui;
/*     */   }
/*     */   private final IGuiScreen prevGui;
/*     */   
/*     */   public void initGui() {
/*  32 */     this.list = new GuiList(getRepresentedScreen());
/*  33 */     if (this.list == null) Intrinsics.throwUninitializedPropertyAccessException("list");  this.list.getRepresented().registerScrollButtons(7, 8);
/*  34 */     if (this.list == null) Intrinsics.throwUninitializedPropertyAccessException("list");  this.list.elementClicked(-1, false, 0, 0);
/*     */     
/*  36 */     int j = 22;
/*  37 */     getRepresentedScreen().getButtonList().add(MinecraftInstance.classProvider.createGuiButton(0, getRepresentedScreen().getWidth() - 80, getRepresentedScreen().getHeight() - 65, 70, 20, "Back"));
/*  38 */     getRepresentedScreen().getButtonList().add(MinecraftInstance.classProvider.createGuiButton(1, getRepresentedScreen().getWidth() - 80, j + 24, 70, 20, "Import"));
/*  39 */     getRepresentedScreen().getButtonList().add(MinecraftInstance.classProvider.createGuiButton(2, getRepresentedScreen().getWidth() - 80, j + 48, 70, 20, "Delete"));
/*  40 */     getRepresentedScreen().getButtonList().add(MinecraftInstance.classProvider.createGuiButton(3, getRepresentedScreen().getWidth() - 80, j + 72, 70, 20, "Reload"));
/*  41 */     getRepresentedScreen().getButtonList().add(MinecraftInstance.classProvider.createGuiButton(4, getRepresentedScreen().getWidth() - 80, j + 96, 70, 20, "Folder"));
/*  42 */     getRepresentedScreen().getButtonList().add(MinecraftInstance.classProvider.createGuiButton(5, getRepresentedScreen().getWidth() - 80, j + 120, 70, 20, "Docs"));
/*  43 */     getRepresentedScreen().getButtonList().add(MinecraftInstance.classProvider.createGuiButton(6, getRepresentedScreen().getWidth() - 80, j + 144, 70, 20, "Find Scripts"));
/*     */   }
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/*  47 */     getRepresentedScreen().drawBackground(0);
/*     */     
/*  49 */     if (this.list == null) Intrinsics.throwUninitializedPropertyAccessException("list");  this.list.getRepresented().drawScreen(mouseX, mouseY, partialTicks);
/*     */     
/*  51 */     Fonts.font40.drawCenteredString("§9§lScripts", getRepresentedScreen().getWidth() / 2.0F, 28.0F, 16777215);
/*     */     
/*  53 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */   
/*     */   public void actionPerformed(@NotNull IGuiButton button) {
/*  57 */     Intrinsics.checkParameterIsNotNull(button, "button"); switch (button.getId()) { case 0:
/*  58 */         MinecraftInstance.mc.displayGuiScreen(this.prevGui); break;
/*     */       case 1:
/*  60 */         try { Iterator<File> iterator; if (MiscUtils.openFileChooser() != null) { File file = MiscUtils.openFileChooser();
/*  61 */             String fileName = file.getName();
/*     */             
/*  63 */             Intrinsics.checkExpressionValueIsNotNull(fileName, "fileName"); if (StringsKt.endsWith$default(fileName, ".js", false, 2, null)) {
/*  64 */               Retreat.INSTANCE.getScriptManager().importScript(file);
/*     */               
/*  66 */               Retreat.INSTANCE.setClickGui(new ClickGui());
/*  67 */               Retreat.INSTANCE.getFileManager().loadConfig((Retreat.INSTANCE.getFileManager()).clickGuiConfig); return;
/*     */             } 
/*  69 */             if (StringsKt.endsWith$default(fileName, ".zip", false, 2, null))
/*  70 */             { ZipFile zipFile = new ZipFile(file);
/*  71 */               Enumeration<? extends ZipEntry> entries = zipFile.entries();
/*  72 */               ArrayList<File> scriptFiles = new ArrayList();
/*     */               
/*  74 */               while (entries.hasMoreElements()) {
/*  75 */                 ZipEntry entry = entries.nextElement();
/*  76 */                 Intrinsics.checkExpressionValueIsNotNull(entry, "entry"); String entryName = entry.getName();
/*  77 */                 File entryFile = new File(Retreat.INSTANCE.getScriptManager().getScriptsFolder(), entryName);
/*     */                 
/*  79 */                 if (entry.isDirectory()) {
/*  80 */                   entryFile.mkdir();
/*     */                   
/*     */                   continue;
/*     */                 } 
/*  84 */                 InputStream fileStream = zipFile.getInputStream(entry);
/*  85 */                 FileOutputStream fileOutputStream = new FileOutputStream(entryFile);
/*     */                 
/*  87 */                 IOUtils.copy(fileStream, fileOutputStream);
/*  88 */                 fileOutputStream.close();
/*  89 */                 fileStream.close();
/*     */                 
/*  91 */                 Intrinsics.checkExpressionValueIsNotNull(entryName, "entryName"); if (!StringsKt.contains$default(entryName, "/", false, 2, null)) {
/*  92 */                   scriptFiles.add(entryFile);
/*     */                 }
/*     */               } 
/*  95 */               Iterable<File> $this$forEach$iv = scriptFiles; int $i$f$forEach = 0;
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
/* 183 */               iterator = $this$forEach$iv.iterator(); } else { MiscUtils.showErrorPopup("Wrong file extension.", "The file extension has to be .js or .zip"); break; }  } else { MiscUtils.openFileChooser(); return; }  if (iterator.hasNext()) { Object element$iv = iterator.next(); File scriptFile = (File)element$iv; int $i$a$-forEach-GuiScripts$actionPerformed$1 = 0;
/*     */             Retreat.INSTANCE.getScriptManager().loadScript(scriptFile); }
/*     */           
/*     */           Retreat.INSTANCE.setClickGui(new ClickGui());
/*     */           Retreat.INSTANCE.getFileManager().loadConfig((Retreat.INSTANCE.getFileManager()).clickGuiConfig);
/*     */           Retreat.INSTANCE.getFileManager().loadConfig((Retreat.INSTANCE.getFileManager()).hudConfig);
/*     */           return; }
/*     */         catch (Throwable t)
/*     */         { ClientUtils.getLogger().error("Something went wrong while importing a script.", t);
/*     */           MiscUtils.showErrorPopup(t.getClass().getName(), t.getMessage());
/*     */           break; }
/*     */       
/*     */       case 2:
/*     */         try {
/*     */           if (this.list == null)
/*     */             Intrinsics.throwUninitializedPropertyAccessException("list"); 
/*     */           if (this.list.getSelectedSlot$XSJClient() != -1) {
/*     */             if (this.list == null)
/*     */               Intrinsics.throwUninitializedPropertyAccessException("list"); 
/*     */             Script script = Retreat.INSTANCE.getScriptManager().getScripts().get(this.list.getSelectedSlot$XSJClient());
/*     */             Retreat.INSTANCE.getScriptManager().deleteScript(script);
/*     */             Retreat.INSTANCE.setClickGui(new ClickGui());
/*     */             Retreat.INSTANCE.getFileManager().loadConfig((Retreat.INSTANCE.getFileManager()).clickGuiConfig);
/*     */             Retreat.INSTANCE.getFileManager().loadConfig((Retreat.INSTANCE.getFileManager()).hudConfig);
/*     */           } 
/*     */         } catch (Throwable t) {
/*     */           ClientUtils.getLogger().error("Something went wrong while deleting a script.", t);
/*     */           MiscUtils.showErrorPopup(t.getClass().getName(), t.getMessage());
/*     */         } 
/*     */         break;
/*     */       case 3:
/*     */         try {
/*     */           Retreat.INSTANCE.getScriptManager().reloadScripts();
/*     */         } catch (Throwable t) {
/*     */           ClientUtils.getLogger().error("Something went wrong while reloading all scripts.", t);
/*     */           MiscUtils.showErrorPopup(t.getClass().getName(), t.getMessage());
/*     */         } 
/*     */         break;
/*     */       case 4:
/*     */         try {
/*     */           Desktop.getDesktop().open(Retreat.INSTANCE.getScriptManager().getScriptsFolder());
/*     */         } catch (Throwable t) {
/*     */           ClientUtils.getLogger().error("Something went wrong while trying to open your scripts folder.", t);
/*     */           MiscUtils.showErrorPopup(t.getClass().getName(), t.getMessage());
/*     */         } 
/*     */         break;
/*     */       case 5:
/*     */         try {
/*     */           Desktop.getDesktop().browse((new URL("https://liquidbounce.net/docs/ScriptAPI/Getting%20Started")).toURI());
/*     */         } catch (Exception exception) {}
/*     */         break;
/*     */       case 6:
/*     */         try {
/*     */           Desktop.getDesktop().browse((new URL("https://forum.ccbluex.net/viewforum.php?id=16")).toURI());
/*     */         } catch (Exception exception) {}
/*     */         break; }
/*     */   
/*     */   }
/*     */   
/*     */   public void keyTyped(char typedChar, int keyCode) {
/*     */     if (1 == keyCode) {
/*     */       MinecraftInstance.mc.displayGuiScreen(this.prevGui);
/*     */       return;
/*     */     } 
/*     */     super.keyTyped(typedChar, keyCode);
/*     */   }
/*     */   
/*     */   public void handleMouseInput() {
/*     */     super.handleMouseInput();
/*     */     if (this.list == null)
/*     */       Intrinsics.throwUninitializedPropertyAccessException("list"); 
/*     */     this.list.getRepresented().handleMouseInput();
/*     */   }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000(\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\000\n\002\020\002\n\002\b\t\n\002\020\013\n\002\b\006\b\004\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\b\020\007\032\0020\bH\026J8\020\t\032\0020\b2\006\020\n\032\0020\0062\006\020\013\032\0020\0062\006\020\f\032\0020\0062\006\020\r\032\0020\0062\006\020\016\032\0020\0062\006\020\017\032\0020\006H\026J(\020\020\032\0020\b2\006\020\n\032\0020\0062\006\020\021\032\0020\0222\006\020\023\032\0020\0062\006\020\r\032\0020\006H\026J\r\020\024\032\0020\006H\000¢\006\002\b\025J\b\020\026\032\0020\006H\026J\020\020\027\032\0020\0222\006\020\n\032\0020\006H\026R\016\020\005\032\0020\006X\016¢\006\002\n\000¨\006\030"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/GuiScripts$GuiList;", "Lnet/ccbluex/liquidbounce/api/util/WrappedGuiSlot;", "gui", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;", "(Lnet/ccbluex/liquidbounce/ui/client/GuiScripts;Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;)V", "selectedSlot", "", "drawBackground", "", "drawSlot", "id", "x", "y", "var4", "var5", "var6", "elementClicked", "doubleClick", "", "var3", "getSelectedSlot", "getSelectedSlot$XSJClient", "getSize", "isSelected", "XSJClient"})
/*     */   private final class GuiList extends WrappedGuiSlot {
/*     */     private int selectedSlot;
/*     */     
/*     */     public GuiList(IGuiScreen gui) {
/*     */       super(MinecraftInstance.mc, gui.getWidth(), gui.getHeight(), 40, gui.getHeight() - 40, 30);
/*     */     }
/*     */     
/*     */     public boolean isSelected(int id) {
/*     */       return (this.selectedSlot == id);
/*     */     }
/*     */     
/*     */     public final int getSelectedSlot$XSJClient() {
/*     */       return (this.selectedSlot > Retreat.INSTANCE.getScriptManager().getScripts().size()) ? -1 : this.selectedSlot;
/*     */     }
/*     */     
/*     */     public int getSize() {
/*     */       return Retreat.INSTANCE.getScriptManager().getScripts().size();
/*     */     }
/*     */     
/*     */     public void elementClicked(int id, boolean doubleClick, int var3, int var4) {
/*     */       this.selectedSlot = id;
/*     */     }
/*     */     
/*     */     public void drawSlot(int id, int x, int y, int var4, int var5, int var6) {
/*     */       Script script = Retreat.INSTANCE.getScriptManager().getScripts().get(id);
/*     */       Intrinsics.checkExpressionValueIsNotNull(Color.LIGHT_GRAY, "Color.LIGHT_GRAY");
/*     */       Fonts.font40.drawCenteredString("§9" + script.getScriptName() + " §7v" + script.getScriptVersion(), GuiScripts.this.getRepresentedScreen().getWidth() / 2.0F, y + 2.0F, Color.LIGHT_GRAY.getRGB());
/*     */       Intrinsics.checkExpressionValueIsNotNull(Color.LIGHT_GRAY, "Color.LIGHT_GRAY");
/*     */       Fonts.font40.drawCenteredString("by §c" + ArraysKt.joinToString$default((Object[])script.getScriptAuthors(), ", ", null, null, 0, null, null, 62, null), GuiScripts.this.getRepresentedScreen().getWidth() / 2.0F, y + 15.0F, Color.LIGHT_GRAY.getRGB());
/*     */     }
/*     */     
/*     */     public void drawBackground() {}
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\GuiScripts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */