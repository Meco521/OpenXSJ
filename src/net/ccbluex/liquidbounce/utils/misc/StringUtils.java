/*    */ package net.ccbluex.liquidbounce.utils.misc;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.HashMap;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public final class StringUtils
/*    */ {
/*    */   public static String breakString(String s) {
/* 15 */     StringBuilder sb = new StringBuilder();
/* 16 */     String[] sArray = s.split("");
/* 17 */     int index = 0;
/* 18 */     for (String s1 : sArray) {
/* 19 */       if (!s1.equals("")) {
/*    */         
/* 21 */         if (s1.equals(s1.toUpperCase()) && Character.isLetter(s1.toCharArray()[0]) && 
/* 22 */           index != 0) {
/* 23 */           sb.append(" ");
/*    */         }
/*    */ 
/*    */         
/* 27 */         sb.append(s1);
/* 28 */         index++;
/*    */       } 
/*    */     } 
/* 31 */     return sb.toString();
/*    */   }
/*    */   
/*    */   public static String toCompleteString(String[] args, int start) {
/* 35 */     if (args.length <= start) return "";
/*    */     
/* 37 */     return String.join(" ", Arrays.<CharSequence>copyOfRange((CharSequence[])args, start, args.length));
/*    */   }
/* 39 */   private static HashMap<String, String> stringCache = new HashMap<>();
/*    */   public static String fixString(String str) {
/* 41 */     if (stringCache.containsKey(str)) return stringCache.get(str);
/*    */     
/* 43 */     str = str.replaceAll("", "");
/*    */     
/* 45 */     StringBuilder sb = new StringBuilder();
/* 46 */     for (char c : str.toCharArray()) {
/* 47 */       if (c > '！' && c < '｠') {
/* 48 */         sb.append(Character.toChars(c - 65248));
/*    */       } else {
/* 50 */         sb.append(c);
/*    */       } 
/*    */     } 
/* 53 */     String result = sb.toString();
/* 54 */     stringCache.put(str, result);
/*    */     
/* 56 */     return result;
/*    */   }
/*    */   public static String replace(String string, String searchChars, String replaceChars) {
/* 59 */     if (string.isEmpty() || searchChars.isEmpty() || searchChars.equals(replaceChars)) {
/* 60 */       return string;
/*    */     }
/* 62 */     if (replaceChars == null) {
/* 63 */       replaceChars = "";
/*    */     }
/* 65 */     int stringLength = string.length();
/* 66 */     int searchCharsLength = searchChars.length();
/* 67 */     StringBuilder stringBuilder = new StringBuilder(string);
/*    */     
/* 69 */     for (int i = 0; i < stringLength; i++) {
/* 70 */       int start = stringBuilder.indexOf(searchChars, i);
/*    */       
/* 72 */       if (start == -1) {
/* 73 */         if (i == 0) {
/* 74 */           return string;
/*    */         }
/* 76 */         return stringBuilder.toString();
/*    */       } 
/*    */       
/* 79 */       stringBuilder.replace(start, start + searchCharsLength, replaceChars);
/*    */     } 
/*    */     
/* 82 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\misc\StringUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */