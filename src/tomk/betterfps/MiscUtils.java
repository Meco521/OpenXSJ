/*    */ package tomk.betterfps;
/*    */ import java.net.URISyntaxException;
/*    */ import java.util.function.Consumer;
/*    */ import javax.swing.JFileChooser;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JOptionPane;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000*\n\002\030\002\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\016\n\002\b\004\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J'\020\003\032\002H\004\"\004\b\000\020\0042\006\020\005\032\002H\0042\f\020\006\032\b\022\004\022\002H\0040\007¢\006\002\020\bJ\b\020\t\032\004\030\0010\nJ\b\020\013\032\004\030\0010\nJ\016\020\f\032\0020\r2\006\020\016\032\0020\017J\026\020\f\032\0020\r2\006\020\020\032\0020\0172\006\020\016\032\0020\017J\016\020\021\032\0020\r2\006\020\022\032\0020\017¨\006\023"}, d2 = {"Ltomk/betterfps/MiscUtils;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "()V", "make", "T", "object", "consumer", "Ljava/util/function/Consumer;", "(Ljava/lang/Object;Ljava/util/function/Consumer;)Ljava/lang/Object;", "openFileChooser", "Ljava/io/File;", "saveFileChooser", "showErrorPopup", "", "message", "", "title", "showURL", "url", "XSJClient"})
/*    */ public final class MiscUtils extends MinecraftInstance {
/*    */   static {
/* 14 */     MiscUtils miscUtils = new MiscUtils();
/*    */   } public static final MiscUtils INSTANCE; public final void showErrorPopup(@NotNull String message) {
/* 16 */     Intrinsics.checkParameterIsNotNull(message, "message"); JOptionPane.showMessageDialog(null, message, "Alert", 0);
/*    */   }
/*    */   
/*    */   public final void showErrorPopup(@NotNull String title, @NotNull String message) {
/* 20 */     Intrinsics.checkParameterIsNotNull(title, "title"); Intrinsics.checkParameterIsNotNull(message, "message"); JOptionPane.showMessageDialog(null, message, title, 0);
/*    */   }
/*    */   
/*    */   public final void showURL(@NotNull String url) {
/* 24 */     Intrinsics.checkParameterIsNotNull(url, "url"); try {
/* 25 */       Desktop.getDesktop().browse(new URI(url));
/* 26 */     } catch (IOException e) {
/* 27 */       e.printStackTrace();
/* 28 */     } catch (URISyntaxException e) {
/* 29 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   @Nullable
/*    */   public final File openFileChooser() {
/* 34 */     if (MinecraftInstance.mc.isFullScreen()) MinecraftInstance.mc.toggleFullscreen(); 
/* 35 */     JFileChooser fileChooser = new JFileChooser();
/* 36 */     JFrame frame = new JFrame();
/* 37 */     fileChooser.setFileSelectionMode(0);
/* 38 */     frame.setVisible(true);
/* 39 */     frame.toFront();
/* 40 */     frame.setVisible(false);
/* 41 */     int action = fileChooser.showOpenDialog(frame);
/* 42 */     frame.dispose();
/* 43 */     return (action == 0) ? fileChooser.getSelectedFile() : null;
/*    */   }
/*    */   @Nullable
/*    */   public final File saveFileChooser() {
/* 47 */     if (MinecraftInstance.mc.isFullScreen()) MinecraftInstance.mc.toggleFullscreen(); 
/* 48 */     JFileChooser fileChooser = new JFileChooser();
/* 49 */     JFrame frame = new JFrame();
/* 50 */     fileChooser.setFileSelectionMode(0);
/* 51 */     frame.setVisible(true);
/* 52 */     frame.toFront();
/* 53 */     frame.setVisible(false);
/* 54 */     int action = fileChooser.showSaveDialog(frame);
/* 55 */     frame.dispose();
/* 56 */     return (action == 0) ? fileChooser.getSelectedFile() : null;
/*    */   }
/*    */   
/*    */   public final <T> T make(Object object, @NotNull Consumer<Object> consumer) {
/* 60 */     Intrinsics.checkParameterIsNotNull(consumer, "consumer"); consumer.accept(object);
/* 61 */     return (T)object;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\betterfps\MiscUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */