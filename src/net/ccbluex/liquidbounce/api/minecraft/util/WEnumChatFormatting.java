/*    */ package net.ccbluex.liquidbounce.api.minecraft.util;
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\020\020\n\000\n\002\020\016\n\000\n\002\020\f\n\000\n\002\020\b\n\002\b\002\n\002\020\013\n\002\b\"\b\001\030\0002\b\022\004\022\0020\0000\001B\037\b\022\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007¢\006\002\020\bB\037\b\022\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\t\032\0020\n¢\006\002\020\013B'\b\002\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\t\032\0020\n\022\006\020\006\032\0020\007¢\006\002\020\fJ\b\020\025\032\0020\003H\026R\021\020\006\032\0020\007¢\006\b\n\000\032\004\b\r\020\016R\021\020\t\032\0020\n¢\006\b\n\000\032\004\b\017\020\020R\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\021\020\022R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\023\020\024j\002\b\026j\002\b\027j\002\b\030j\002\b\031j\002\b\032j\002\b\033j\002\b\034j\002\b\035j\002\b\036j\002\b\037j\002\b j\002\b!j\002\b\"j\002\b#j\002\b$j\002\b%j\002\b&j\002\b'j\002\b(j\002\b)j\002\b*j\002\b+¨\006,"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/util/WEnumChatFormatting;", "", "formattingName", "", "formattingCodeIn", "", "colorIndex", "", "(Ljava/lang/String;ILjava/lang/String;CI)V", "fancyStylingIn", "", "(Ljava/lang/String;ILjava/lang/String;CZ)V", "(Ljava/lang/String;ILjava/lang/String;CZI)V", "getColorIndex", "()I", "getFancyStylingIn", "()Z", "getFormattingCodeIn", "()C", "getFormattingName", "()Ljava/lang/String;", "toString", "BLACK", "DARK_BLUE", "DARK_GREEN", "DARK_AQUA", "DARK_RED", "DARK_PURPLE", "GOLD", "GRAY", "DARK_GRAY", "BLUE", "GREEN", "AQUA", "RED", "LIGHT_PURPLE", "YELLOW", "WHITE", "OBFUSCATED", "BOLD", "STRIKETHROUGH", "UNDERLINE", "ITALIC", "RESET", "XSJClient"})
/*    */ public enum WEnumChatFormatting { @NotNull
/*  4 */   public final String getFormattingName() { return this.formattingName; } BLACK, DARK_BLUE, DARK_GREEN, DARK_AQUA, DARK_RED, DARK_PURPLE, GOLD, GRAY, DARK_GRAY, BLUE, GREEN, AQUA, RED, LIGHT_PURPLE, YELLOW, WHITE, OBFUSCATED, BOLD, STRIKETHROUGH, UNDERLINE, ITALIC, RESET; public final char getFormattingCodeIn() { return this.formattingCodeIn; } public final boolean getFancyStylingIn() { return this.fancyStylingIn; } public final int getColorIndex() { return this.colorIndex; } WEnumChatFormatting(String formattingName, char formattingCodeIn, boolean fancyStylingIn, int colorIndex) { this.formattingName = formattingName; this.formattingCodeIn = formattingCodeIn; this.fancyStylingIn = fancyStylingIn; this.colorIndex = colorIndex; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   private final String formattingName;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final char formattingCodeIn;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final boolean fancyStylingIn;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final int colorIndex;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public String toString() {
/* 34 */     return '§' + this.formattingCodeIn;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraf\\util\WEnumChatFormatting.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */