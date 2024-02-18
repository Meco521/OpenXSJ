/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.client;
/*    */ 
/*    */ import com.google.common.collect.Lists;
/*    */ import java.io.File;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.resources.ResourcePackRepository;
/*    */ import org.apache.commons.io.FileUtils;
/*    */ import org.apache.commons.io.comparator.LastModifiedFileComparator;
/*    */ import org.apache.commons.io.filefilter.TrueFileFilter;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Overwrite;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({ResourcePackRepository.class})
/*    */ public class MixinResourcePackRepository
/*    */ {
/*    */   @Shadow
/*    */   @Final
/*    */   private static Logger field_177320_c;
/*    */   @Shadow
/*    */   @Final
/*    */   private File field_148534_e;
/*    */   
/*    */   @Overwrite
/*    */   private void func_183028_i() {
/*    */     try {
/* 34 */       List<File> resourcePacksInFolder = Lists.newArrayList(FileUtils.listFiles(this.field_148534_e, TrueFileFilter.TRUE, null));
/* 35 */       resourcePacksInFolder.sort(LastModifiedFileComparator.LASTMODIFIED_REVERSE);
/* 36 */       int count = 0;
/*    */       
/* 38 */       for (File resourcePackFile : resourcePacksInFolder) {
/* 39 */         if (count++ >= 10) {
/* 40 */           field_177320_c.info("Deleting old server resource pack " + resourcePackFile.getName());
/* 41 */           FileUtils.deleteQuietly(resourcePackFile);
/*    */         } 
/*    */       } 
/* 44 */     } catch (Throwable e) {
/* 45 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\client\MixinResourcePackRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */