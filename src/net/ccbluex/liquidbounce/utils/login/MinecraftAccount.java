/*    */ package net.ccbluex.liquidbounce.utils.login;
/*    */ 
/*    */ public final class MinecraftAccount
/*    */ {
/*    */   private final String username;
/*    */   private String password;
/*    */   private String inGameName;
/*    */   
/*    */   public MinecraftAccount(String username) {
/* 10 */     this.username = username;
/*    */   }
/*    */   
/*    */   public MinecraftAccount(String name, String password) {
/* 14 */     this.username = name;
/* 15 */     this.password = password;
/*    */   }
/*    */   
/*    */   public MinecraftAccount(String name, String password, String inGameName) {
/* 19 */     this.username = name;
/* 20 */     this.password = password;
/* 21 */     this.inGameName = inGameName;
/*    */   }
/*    */   
/*    */   public boolean isCracked() {
/* 25 */     return (this.password == null || this.password.isEmpty());
/*    */   }
/*    */   
/*    */   public String getName() {
/* 29 */     return this.username;
/*    */   }
/*    */   
/*    */   public String getPassword() {
/* 33 */     return this.password;
/*    */   }
/*    */   
/*    */   public String getAccountName() {
/* 37 */     return this.inGameName;
/*    */   }
/*    */   
/*    */   public void setAccountName(String accountName) {
/* 41 */     this.inGameName = accountName;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\login\MinecraftAccount.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */