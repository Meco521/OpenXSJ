/*     */ package net.ccbluex.liquidbounce.file;
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.GsonBuilder;
/*     */ import java.io.File;
/*     */ import java.lang.reflect.Field;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.file.configs.AccountsConfig;
/*     */ import net.ccbluex.liquidbounce.file.configs.FriendsConfig;
/*     */ import net.ccbluex.liquidbounce.file.configs.HudConfig;
/*     */ import net.ccbluex.liquidbounce.file.configs.ValuesConfig;
/*     */ import net.ccbluex.liquidbounce.file.configs.XRayConfig;
/*     */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class FileManager extends MinecraftInstance {
/*  19 */   public final File dir = new File(mc.getDataDir(), "XSJ Client-1.12");
/*  20 */   public final File configsDir = new File(this.dir, "configs");
/*     */   
/*  22 */   public final File capeDir = new File(this.dir, "capes");
/*     */   
/*  24 */   public final File fontsDir = new File(this.dir, "fonts");
/*     */   
/*  26 */   public final File soundsDir = new File(this.dir, "sounds");
/*     */   
/*  28 */   public final File hudsDir = new File(this.dir, "huds");
/*  29 */   public final FileConfig valuesConfig = (FileConfig)new ValuesConfig(new File(this.dir, "values.json"));
/*  30 */   public final FileConfig clickGuiConfig = (FileConfig)new ClickGuiConfig(new File(this.dir, "clickgui.json"));
/*  31 */   public final AccountsConfig accountsConfig = new AccountsConfig(new File(this.dir, "accounts.json"));
/*  32 */   public final FriendsConfig friendsConfig = new FriendsConfig(new File(this.dir, "friends.json"));
/*  33 */   public final FileConfig xrayConfig = (FileConfig)new XRayConfig(new File(this.dir, "xray-blocks.json"));
/*  34 */   public final FileConfig hudConfig = (FileConfig)new HudConfig(new File(this.dir, "hud.json"));
/*     */   
/*  36 */   public final File backgroundFile = new File(this.dir, "userbackground.png");
/*     */   
/*     */   public boolean firstStart = false;
/*     */   
/*  40 */   public static final Gson PRETTY_GSON = (new GsonBuilder()).setPrettyPrinting().create();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileManager() {
/*  49 */     setupFolder();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setupFolder() {
/*  56 */     if (!this.dir.exists()) {
/*  57 */       this.dir.mkdir();
/*  58 */       this.firstStart = true;
/*     */     } 
/*     */     
/*  61 */     if (!this.configsDir.exists()) {
/*  62 */       this.configsDir.mkdir();
/*     */     }
/*  64 */     if (!this.hudsDir.exists()) {
/*  65 */       this.hudsDir.mkdir();
/*     */     }
/*  67 */     if (!this.capeDir.exists()) {
/*  68 */       this.capeDir.mkdir();
/*     */     }
/*  70 */     if (!this.fontsDir.exists()) {
/*  71 */       this.fontsDir.mkdir();
/*     */     }
/*  73 */     if (!this.soundsDir.exists()) {
/*  74 */       this.soundsDir.mkdir();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadConfigs(FileConfig... configs) {
/*  83 */     for (FileConfig fileConfig : configs) {
/*  84 */       loadConfig(fileConfig);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadConfig(FileConfig config) {
/*  93 */     if (!config.hasConfig()) {
/*  94 */       ClientUtils.getLogger().info("[FileManager] Skipped loading config: " + config.getFile().getName() + ".");
/*     */       
/*  96 */       saveConfig(config, true);
/*     */       
/*     */       return;
/*     */     } 
/*     */     try {
/* 101 */       config.loadConfig();
/* 102 */       ClientUtils.getLogger().info("[FileManager] load config: " + config.getFile().getName() + ".");
/* 103 */     } catch (Throwable t) {
/* 104 */       ClientUtils.getLogger().error("[FileManager] Failed to load config file: " + config.getFile().getName() + ".", t);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveAllConfigs() {
/* 112 */     for (Field field : getClass().getDeclaredFields()) {
/* 113 */       if (field.getType() == FileConfig.class) {
/*     */         try {
/* 115 */           if (!field.isAccessible()) {
/* 116 */             field.setAccessible(true);
/*     */           }
/* 118 */           FileConfig fileConfig = (FileConfig)field.get(this);
/* 119 */           saveConfig(fileConfig);
/* 120 */         } catch (IllegalAccessException e) {
/* 121 */           ClientUtils.getLogger().error("[FileManager] Failed to save config file of field " + field
/* 122 */               .getName() + ".", e);
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveConfigs(FileConfig... configs) {
/* 134 */     for (FileConfig fileConfig : configs) {
/* 135 */       saveConfig(fileConfig);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveConfig(FileConfig config) {
/* 144 */     saveConfig(config, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void saveConfig(FileConfig config, boolean ignoreStarting) {
/* 154 */     if (!ignoreStarting && Retreat.INSTANCE.isStarting()) {
/*     */       return;
/*     */     }
/*     */     try {
/* 158 */       if (!config.hasConfig()) {
/* 159 */         config.createConfig();
/*     */       }
/* 161 */       config.saveConfig();
/* 162 */       ClientUtils.getLogger().info("[FileManager] save config : " + config.getFile().getName() + ".");
/* 163 */     } catch (Throwable t) {
/* 164 */       ClientUtils.getLogger().error("[FileManager] Failed to save config file: " + config
/* 165 */           .getFile().getName() + ".", t);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\file\FileManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */