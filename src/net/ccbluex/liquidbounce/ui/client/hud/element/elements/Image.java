/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ 
/*     */ import com.google.gson.JsonElement;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.File;
/*     */ import java.util.Base64;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.misc.MiscUtils;
/*     */ import net.ccbluex.liquidbounce.value.TextValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ElementInfo(name = "Image")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0008\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\030\002\n\000\n\002\030\002\n\002\020\016\n\002\b\002\b\007\030\000 \0212\0020\001:\001\021B\005¢\006\002\020\002J\b\020\n\032\0020\013H\026J\b\020\f\032\0020\rH\026J\016\020\016\032\0020\0002\006\020\005\032\0020\017J\020\020\016\032\0020\0002\006\020\005\032\0020\020H\002R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\t\032\0020\004X\016¢\006\002\n\000¨\006\022"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Image;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "()V", "height", "", "image", "Lnet/ccbluex/liquidbounce/value/TextValue;", "resourceLocation", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;", "width", "createElement", "", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "setImage", "Ljava/io/File;", "", "Companion", "XSJClient"})
/*     */ public final class Image extends Element {
/*     */   private final TextValue image;
/*     */   private final IResourceLocation resourceLocation;
/*     */   private int width;
/*     */   private int height;
/*     */   public static final Companion Companion = new Companion(null);
/*     */   
/*  24 */   public Image() { super(0.0D, 0.0D, 0.0F, null, 15, null);
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
/*  42 */     this.image = new Image$image$1("Image", "");
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
/*  62 */     this.resourceLocation = MinecraftInstance.classProvider.createResourceLocation(RandomUtils.INSTANCE.randomNumber(128));
/*  63 */     this.width = 64;
/*  64 */     this.height = 64; } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\006\020\003\032\0020\004¨\006\005"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Image$Companion;", "", "()V", "default", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Image;", "XSJClient"}) public static final class Companion {
/*     */     private Companion() {} @NotNull public final Image default() { Image image = new Image();
/*     */       image.setX(0.0D);
/*     */       image.setY(0.0D);
/*     */       return image; } }
/*     */   @NotNull
/*  70 */   public Border drawElement() { RenderUtils.drawImage(this.resourceLocation, 0, 0, this.width / 2, this.height / 2);
/*     */     
/*  72 */     return new Border(0.0F, 0.0F, this.width / 2.0F, this.height / 2.0F); }
/*     */ 
/*     */   
/*     */   public boolean createElement() {
/*  76 */     if (MiscUtils.openFileChooser() != null) { File file = MiscUtils.openFileChooser();
/*     */       
/*  78 */       if (!file.exists()) {
/*  79 */         MiscUtils.showErrorPopup("Error", "The file does not exist.");
/*  80 */         return false;
/*     */       } 
/*     */       
/*  83 */       if (file.isDirectory()) {
/*  84 */         MiscUtils.showErrorPopup("Error", "The file is a directory.");
/*  85 */         return false;
/*     */       } 
/*     */       
/*  88 */       setImage(file);
/*  89 */       return true; }  MiscUtils.openFileChooser(); return false;
/*     */   }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000!\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\002*\001\000\b\n\030\0002\0020\001J\020\020\002\032\0020\0032\006\020\004\032\0020\005H\026J\030\020\006\032\0020\0032\006\020\007\032\0020\b2\006\020\t\032\0020\bH\024¨\006\n"}, d2 = {"net/ccbluex/liquidbounce/ui/client/hud/element/elements/Image$image$1", "Lnet/ccbluex/liquidbounce/value/TextValue;", "fromJson", "", "element", "Lcom/google/gson/JsonElement;", "onChanged", "oldValue", "", "newValue", "XSJClient"}) public static final class Image$image$1 extends TextValue {
/*     */     Image$image$1(String $super_call_param$1, String $super_call_param$2) { super($super_call_param$1, $super_call_param$2); }
/*     */     public void fromJson(@NotNull JsonElement element) { Intrinsics.checkParameterIsNotNull(element, "element"); super.fromJson(element); CharSequence charSequence = (CharSequence)get(); boolean bool = false; if ((charSequence.length() == 0)) return;  Image.this.setImage((String)get()); } protected void onChanged(@NotNull String oldValue, @NotNull String newValue) { Intrinsics.checkParameterIsNotNull(oldValue, "oldValue"); Intrinsics.checkParameterIsNotNull(newValue, "newValue"); CharSequence charSequence = (CharSequence)get(); boolean bool = false; if ((charSequence.length() == 0))
/*  94 */         return;  Image.this.setImage((String)get()); } } private final Image setImage(String image) { try { this.image.changeValue(image);
/*     */       
/*  96 */       ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.getDecoder().decode(image));
/*  97 */       BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
/*  98 */       byteArrayInputStream.close();
/*     */       
/* 100 */       Intrinsics.checkExpressionValueIsNotNull(bufferedImage, "bufferedImage"); this.width = bufferedImage.getWidth();
/* 101 */       this.height = bufferedImage.getHeight();
/*     */       
/* 103 */       MinecraftInstance.mc.getTextureManager().loadTexture(this.resourceLocation, (IAbstractTexture)MinecraftInstance.classProvider.createDynamicTexture(bufferedImage)); }
/* 104 */     catch (Exception e)
/* 105 */     { e.printStackTrace(); }
/*     */     
/* 107 */     return this; }
/*     */   
/*     */   @NotNull
/*     */   public final Image setImage(@NotNull File image) {
/* 111 */     Intrinsics.checkParameterIsNotNull(image, "image"); try {
/* 112 */       Intrinsics.checkExpressionValueIsNotNull(Base64.getEncoder().encodeToString(Files.readAllBytes(image.toPath())), "Base64.getEncoder().enco…AllBytes(image.toPath()))"); setImage(Base64.getEncoder().encodeToString(Files.readAllBytes(image.toPath())));
/* 113 */     } catch (Exception e) {
/* 114 */       e.printStackTrace();
/*     */     } 
/*     */     
/* 117 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\Image.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */