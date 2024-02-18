/*     */ package net.ccbluex.liquidbounce.file.configs;
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.List;
/*     */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*     */ import net.ccbluex.liquidbounce.utils.login.MinecraftAccount;
/*     */ 
/*     */ public class AccountsConfig extends FileConfig {
/*  14 */   private final List<MinecraftAccount> accounts = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AccountsConfig(File file) {
/*  22 */     super(file);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadConfig() throws IOException {
/*  32 */     clearAccounts();
/*     */     try {
/*  34 */       JsonElement jsonElement = (new JsonParser()).parse(new BufferedReader(new FileReader(getFile())));
/*     */       
/*  36 */       if (jsonElement instanceof com.google.gson.JsonNull) {
/*     */         return;
/*     */       }
/*  39 */       for (JsonElement accountElement : jsonElement.getAsJsonArray()) {
/*  40 */         JsonObject accountObject = accountElement.getAsJsonObject();
/*  41 */         JsonElement name = accountObject.get("name");
/*  42 */         JsonElement password = accountObject.get("password");
/*  43 */         JsonElement inGameName = accountObject.get("inGameName");
/*     */         
/*  45 */         if (inGameName == null || inGameName.isJsonNull()) {
/*  46 */           addAccount(name.getAsString(), password.getAsString()); continue;
/*  47 */         }  if (inGameName.isJsonNull() && password.isJsonNull()) {
/*  48 */           addAccount(name.getAsString()); continue;
/*     */         } 
/*  50 */         addAccount(name.getAsString(), accountObject.get("password").getAsString(), accountObject.get("inGameName").getAsString());
/*     */       }
/*     */     
/*  53 */     } catch (JsonSyntaxException|IllegalStateException ex) {
/*     */       
/*  55 */       ClientUtils.getLogger().info("[FileManager] Try to load old Accounts config...");
/*  56 */       List<String> accountList = (List<String>)(new Gson()).fromJson(new BufferedReader(new FileReader(getFile())), List.class);
/*     */       
/*  58 */       if (accountList == null) {
/*     */         return;
/*     */       }
/*  61 */       this.accounts.clear();
/*     */       
/*  63 */       for (String account : accountList) {
/*  64 */         String[] information = account.split(":");
/*     */         
/*  66 */         if (information.length >= 3) {
/*  67 */           this.accounts.add(new MinecraftAccount(information[0], information[1], information[2])); continue;
/*  68 */         }  if (information.length == 2) {
/*  69 */           this.accounts.add(new MinecraftAccount(information[0], information[1])); continue;
/*     */         } 
/*  71 */         this.accounts.add(new MinecraftAccount(information[0]));
/*     */       } 
/*  73 */       ClientUtils.getLogger().info("[FileManager] Loaded old Accounts config...");
/*     */ 
/*     */       
/*  76 */       saveConfig();
/*  77 */       ClientUtils.getLogger().info("[FileManager] Saved Accounts to new config...");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveConfig() throws IOException {
/*  89 */     JsonArray jsonArray = new JsonArray();
/*     */     
/*  91 */     for (MinecraftAccount minecraftAccount : this.accounts) {
/*  92 */       JsonObject friendObject = new JsonObject();
/*  93 */       friendObject.addProperty("name", minecraftAccount.getName());
/*  94 */       friendObject.addProperty("password", minecraftAccount.getPassword());
/*  95 */       friendObject.addProperty("inGameName", minecraftAccount.getAccountName());
/*  96 */       jsonArray.add((JsonElement)friendObject);
/*     */     } 
/*     */     
/*  99 */     PrintWriter printWriter = new PrintWriter(new FileWriter(getFile()));
/* 100 */     printWriter.println(FileManager.PRETTY_GSON.toJson((JsonElement)jsonArray));
/* 101 */     printWriter.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addAccount(String name) {
/* 110 */     if (accountExists(name)) {
/*     */       return;
/*     */     }
/* 113 */     this.accounts.add(new MinecraftAccount(name));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addAccount(String name, String password) {
/* 123 */     if (accountExists(name)) {
/*     */       return;
/*     */     }
/* 126 */     this.accounts.add(new MinecraftAccount(name, password));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addAccount(String name, String password, String inGameName) {
/* 136 */     if (accountExists(name)) {
/*     */       return;
/*     */     }
/* 139 */     this.accounts.add(new MinecraftAccount(name, password, inGameName));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeAccount(int selectedSlot) {
/* 148 */     this.accounts.remove(selectedSlot);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeAccount(MinecraftAccount account) {
/* 158 */     this.accounts.remove(account);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean accountExists(String name) {
/* 168 */     for (MinecraftAccount minecraftAccount : this.accounts) {
/* 169 */       if (minecraftAccount.getName().equals(name))
/* 170 */         return true; 
/* 171 */     }  return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearAccounts() {
/* 178 */     this.accounts.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<MinecraftAccount> getAccounts() {
/* 187 */     return this.accounts;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\file\configs\AccountsConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */