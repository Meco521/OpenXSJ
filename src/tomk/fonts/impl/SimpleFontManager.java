/*    */ package tomk.fonts.impl;
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
/*    */ import tomk.fonts.api.FontFamily;
/*    */ import tomk.fonts.api.FontManager;
/*    */ import tomk.fonts.api.FontType;
/*    */ import tomk.fonts.util.SneakyThrowing;
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
/* 28 */     return new SimpleFontManager();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 33 */   private final FontRegistry fonts = new FontRegistry();
/*    */ 
/*    */   
/*    */   public FontFamily fontFamily(FontType fontType) {
/* 37 */     return this.fonts.fontFamily(fontType);
/*    */   }
/*    */   
/*    */   private static final class FontRegistry extends EnumMap<FontType, FontFamily> {
/*    */     private FontRegistry() {
/* 42 */       super(FontType.class);
/*    */     }
/*    */     private FontFamily fontFamily(FontType fontType) {
/* 45 */       return computeIfAbsent(fontType, ignored -> {
/*    */             try {
/*    */               return SimpleFontFamily.create(fontType, readFontFromResources(fontType));
/* 48 */             } catch (IOException e) {
/*    */               throw SneakyThrowing.sneakyThrow(e);
/*    */             } 
/*    */           });
/*    */     }
/*    */     
/*    */     private static Font readFontFromResources(FontType fontType) throws IOException {
/*    */       IResource resource;
/* 56 */       IResourceManager resourceManager = Minecraft.func_71410_x().func_110442_L();
/* 57 */       ResourceLocation location = new ResourceLocation("tomk/font/" + fontType.fileName());
/*    */ 
/*    */       
/*    */       try {
/* 61 */         resource = resourceManager.func_110536_a(location);
/* 62 */       } catch (IOException e) {
/* 63 */         throw new IOException("Couldn't find resource: " + location, e);
/*    */       } 
/*    */       
/* 66 */       try (InputStream resourceInputStream = resource.func_110527_b()) {
/* 67 */         return readFont(resourceInputStream);
/*    */       } 
/*    */     }
/*    */ 
/*    */     
/*    */     private static Font readFont(InputStream resource) {
/*    */       Font font;
/*    */       try {
/* 75 */         font = Font.createFont(0, resource);
/* 76 */       } catch (FontFormatException e) {
/* 77 */         throw new RuntimeException("Resource does not contain the required font tables for the specified format", e);
/* 78 */       } catch (IOException e) {
/* 79 */         throw new RuntimeException("Couldn't completely read font resource", e);
/*    */       } 
/*    */       
/* 82 */       return font;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\fonts\impl\SimpleFontManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */