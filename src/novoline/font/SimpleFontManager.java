/*    */ package novoline.font;
/*    */ 
/*    */ import java.awt.Font;
/*    */ import java.awt.FontFormatException;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.util.EnumMap;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.resources.IResource;
/*    */ import net.minecraft.client.resources.IResourceManager;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class SimpleFontManager
/*    */   implements FontManager
/*    */ {
/*    */   private static final String FONT_DIRECTORY = "tomk/font/";
/*    */   
/*    */   public static FontManager create() {
/* 26 */     return new SimpleFontManager();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 31 */   private final FontRegistry fonts = new FontRegistry();
/*    */ 
/*    */   
/*    */   public FontFamily fontFamily(FontType fontType) {
/* 35 */     return this.fonts.fontFamily(fontType);
/*    */   }
/*    */   
/*    */   private static final class FontRegistry extends EnumMap<FontType, FontFamily> {
/*    */     private FontRegistry() {
/* 40 */       super(FontType.class);
/*    */     }
/*    */     private FontFamily fontFamily(FontType fontType) {
/* 43 */       return computeIfAbsent(fontType, ignored -> {
/*    */             try {
/*    */               return SimpleFontFamily.create(fontType, readFontFromResources(fontType));
/* 46 */             } catch (IOException e) {
/*    */               throw SneakyThrowing.sneakyThrow(e);
/*    */             } 
/*    */           });
/*    */     }
/*    */     
/*    */     private static Font readFontFromResources(FontType fontType) throws IOException {
/*    */       IResource resource;
/* 54 */       IResourceManager resourceManager = Minecraft.func_71410_x().func_110442_L();
/* 55 */       ResourceLocation location = new ResourceLocation("tomk/font/" + fontType.fileName());
/*    */ 
/*    */       
/*    */       try {
/* 59 */         resource = resourceManager.func_110536_a(location);
/* 60 */       } catch (IOException e) {
/* 61 */         throw new IOException("Couldn't find resource: " + location, e);
/*    */       } 
/*    */       
/* 64 */       try (InputStream resourceInputStream = resource.func_110527_b()) {
/* 65 */         return readFont(resourceInputStream);
/*    */       } 
/*    */     }
/*    */ 
/*    */     
/*    */     private static Font readFont(InputStream resource) {
/*    */       Font font;
/*    */       try {
/* 73 */         font = Font.createFont(0, resource);
/* 74 */       } catch (FontFormatException e) {
/* 75 */         throw new RuntimeException("Resource does not contain the required font tables for the specified format", e);
/* 76 */       } catch (IOException e) {
/* 77 */         throw new RuntimeException("Couldn't completely read font resource", e);
/*    */       } 
/*    */       
/* 80 */       return font;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\novoline\font\SimpleFontManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */