/*     */ package net.ccbluex.liquidbounce.file.configs;
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.List;
/*     */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*     */ 
/*     */ public class FriendsConfig extends FileConfig {
/*  14 */   private final List<Friend> friends = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FriendsConfig(File file) {
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
/*  32 */     clearFriends();
/*     */     try {
/*  34 */       JsonElement jsonElement = (new JsonParser()).parse(new BufferedReader(new FileReader(getFile())));
/*     */       
/*  36 */       if (jsonElement instanceof com.google.gson.JsonNull) {
/*     */         return;
/*     */       }
/*  39 */       for (JsonElement friendElement : jsonElement.getAsJsonArray()) {
/*  40 */         JsonObject friendObject = friendElement.getAsJsonObject();
/*  41 */         addFriend(friendObject.get("playerName").getAsString(), friendObject.get("alias").getAsString());
/*     */       }
/*     */     
/*  44 */     } catch (JsonSyntaxException|IllegalStateException ex) {
/*     */       
/*  46 */       ClientUtils.getLogger().info("[FileManager] Try to load old Friends config...");
/*     */       
/*  48 */       BufferedReader bufferedReader = new BufferedReader(new FileReader(getFile()));
/*     */       
/*     */       String line;
/*  51 */       while ((line = bufferedReader.readLine()) != null) {
/*  52 */         if (!line.contains("{") && !line.contains("}")) {
/*  53 */           line = line.replace(" ", "").replace("\"", "").replace(",", "");
/*     */           
/*  55 */           if (line.contains(":")) {
/*  56 */             String[] data = line.split(":");
/*  57 */             addFriend(data[0], data[1]); continue;
/*     */           } 
/*  59 */           addFriend(line);
/*     */         } 
/*     */       } 
/*  62 */       bufferedReader.close();
/*  63 */       ClientUtils.getLogger().info("[FileManager] Loaded old Friends config...");
/*     */ 
/*     */       
/*  66 */       saveConfig();
/*  67 */       ClientUtils.getLogger().info("[FileManager] Saved Friends to new config...");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveConfig() throws IOException {
/*  78 */     JsonArray jsonArray = new JsonArray();
/*     */     
/*  80 */     for (Friend friend : getFriends()) {
/*  81 */       JsonObject friendObject = new JsonObject();
/*  82 */       friendObject.addProperty("playerName", friend.getPlayerName());
/*  83 */       friendObject.addProperty("alias", friend.getAlias());
/*  84 */       jsonArray.add((JsonElement)friendObject);
/*     */     } 
/*     */     
/*  87 */     PrintWriter printWriter = new PrintWriter(new FileWriter(getFile()));
/*  88 */     printWriter.println(FileManager.PRETTY_GSON.toJson((JsonElement)jsonArray));
/*  89 */     printWriter.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addFriend(String playerName) {
/*  99 */     return addFriend(playerName, playerName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addFriend(String playerName, String alias) {
/* 110 */     if (isFriend(playerName)) {
/* 111 */       return false;
/*     */     }
/* 113 */     this.friends.add(new Friend(playerName, alias));
/* 114 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeFriend(String playerName) {
/* 123 */     if (!isFriend(playerName)) {
/* 124 */       return false;
/*     */     }
/* 126 */     this.friends.removeIf(friend -> friend.getPlayerName().equals(playerName));
/* 127 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFriend(String playerName) {
/* 137 */     for (Friend friend : this.friends) {
/* 138 */       if (friend.getPlayerName().equals(playerName))
/* 139 */         return true; 
/* 140 */     }  return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearFriends() {
/* 147 */     this.friends.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Friend> getFriends() {
/* 156 */     return this.friends;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public class Friend
/*     */   {
/*     */     private final String playerName;
/*     */     
/*     */     private final String alias;
/*     */ 
/*     */     
/*     */     Friend(String playerName, String alias) {
/* 169 */       this.playerName = playerName;
/* 170 */       this.alias = alias;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getPlayerName() {
/* 177 */       return this.playerName;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getAlias() {
/* 184 */       return this.alias;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\file\configs\FriendsConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */