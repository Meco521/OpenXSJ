/*    */ package net.ccbluex.liquidbounce.ui.client;
/*    */ import java.awt.Color;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import kotlin.Unit;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.text.StringsKt;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiButton;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiScreen;
/*    */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.misc.HttpUtils;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000B\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\020\016\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\002\n\002\020\007\n\002\b\003\n\002\020\f\n\002\b\003\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\b\032\0020\t2\006\020\n\032\0020\013H\026J \020\f\032\0020\t2\006\020\r\032\0020\0162\006\020\017\032\0020\0162\006\020\020\032\0020\021H\026J\b\020\022\032\0020\tH\026J\030\020\023\032\0020\t2\006\020\024\032\0020\0252\006\020\026\032\0020\016H\026J\b\020\027\032\0020\tH\002R\016\020\002\032\0020\003X\004¢\006\002\n\000R\032\020\005\032\016\022\004\022\0020\007\022\004\022\0020\0070\006X\004¢\006\002\n\000¨\006\030"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/GuiServerStatus;", "Lnet/ccbluex/liquidbounce/api/util/WrappedGuiScreen;", "prevGui", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;)V", "status", "Ljava/util/HashMap;", "", "actionPerformed", "", "button", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiButton;", "drawScreen", "mouseX", "", "mouseY", "partialTicks", "", "initGui", "keyTyped", "typedChar", "", "keyCode", "loadInformations", "XSJClient"})
/*    */ public final class GuiServerStatus extends WrappedGuiScreen {
/*    */   private final HashMap<String, String> status;
/*    */   
/*    */   public GuiServerStatus(@NotNull IGuiScreen prevGui) {
/* 21 */     this.prevGui = prevGui;
/* 22 */     this.status = new HashMap<>();
/*    */   }
/*    */   private final IGuiScreen prevGui;
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*    */   static final class GuiServerStatus$initGui$1 extends Lambda implements Function0<Unit> { public final void invoke() {
/* 27 */       GuiServerStatus.this.loadInformations(); } GuiServerStatus$initGui$1() { super(0); } } public void initGui() { getRepresentedScreen().getButtonList().add(MinecraftInstance.classProvider.createGuiButton(1, getRepresentedScreen().getWidth() / 2 - 100, getRepresentedScreen().getHeight() / 4 + 145, "Back")); ThreadsKt.thread$default(false, false, null, null, 0, new GuiServerStatus$initGui$1(), 31, null); }
/*    */ 
/*    */   
/*    */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 31 */     getRepresentedScreen().drawBackground(0);
/*    */     
/* 33 */     int i = getRepresentedScreen().getHeight() / 4 + 40;
/* 34 */     RenderUtils.drawRect(getRepresentedScreen().getWidth() / 2.0F - 115, i - 5.0F, getRepresentedScreen().getWidth() / 2.0F + 115, getRepresentedScreen().getHeight() / 4.0F + 43 + (this.status.keySet().isEmpty() ? 10 : (this.status.keySet().size() * Fonts.font40.getFontHeight())), -2147483648);
/*    */     
/* 36 */     if (this.status.isEmpty()) {
/* 37 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.font40.drawCenteredString("Loading...", getRepresentedScreen().getWidth() / 2.0F, getRepresentedScreen().getHeight() / 4.0F + 40, Color.WHITE.getRGB());
/*    */     } else {
/* 39 */       for (String server : this.status.keySet()) {
/* 40 */         String color = this.status.get(server);
/* 41 */         Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.font40.drawCenteredString("§c§l" + server + ": " + (StringsKt.equals(color, "red", true) ? "§c" : (StringsKt.equals(color, "yellow", true) ? "§e" : "§a")) + (StringsKt.equals(color, "red", true) ? "Offline" : (StringsKt.equals(color, "yellow", true) ? "Slow" : "Online")), getRepresentedScreen().getWidth() / 2.0F, i, Color.WHITE.getRGB());
/* 42 */         i += Fonts.font40.getFontHeight();
/*    */       } 
/*    */     } 
/*    */     
/* 46 */     Fonts.robotoBold180.drawCenteredString("Server Status", getRepresentedScreen().getWidth() / 2.0F, getRepresentedScreen().getHeight() / 8.0F + 5.0F, 4673984, true);
/*    */     
/* 48 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*    */   }
/*    */   
/*    */   private final void loadInformations() {
/* 52 */     this.status.clear();
/*    */     
/*    */     try {
/* 55 */       if ((new Gson()).fromJson(HttpUtils.get("https://status.mojang.com/check"), 
/* 56 */           List.class) == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, kotlin.String>>");  List linkedTreeMaps = (List)(new Gson()).fromJson(HttpUtils.get("https://status.mojang.com/check"), List.class);
/*    */       
/* 58 */       for (Map linkedTreeMap : linkedTreeMaps)
/* 59 */       { Map map1 = linkedTreeMap; boolean bool = false; for (Map.Entry entry : map1.entrySet())
/* 60 */           this.status.put((String)entry.getKey(), (String)entry.getValue());  } 
/* 61 */     } catch (IOException e) {
/* 62 */       this.status.put("status.mojang.com/check", "red");
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void actionPerformed(@NotNull IGuiButton button) {
/* 68 */     Intrinsics.checkParameterIsNotNull(button, "button"); if (button.getId() == 1) MinecraftInstance.mc.displayGuiScreen(this.prevGui); 
/*    */   }
/*    */   
/*    */   public void keyTyped(char typedChar, int keyCode) {
/* 72 */     if (1 == keyCode) {
/* 73 */       MinecraftInstance.mc.displayGuiScreen(this.prevGui);
/*    */       
/*    */       return;
/*    */     } 
/* 77 */     super.keyTyped(typedChar, keyCode);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\GuiServerStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */