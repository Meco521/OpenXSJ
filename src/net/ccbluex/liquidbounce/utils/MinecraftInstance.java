/*    */ package net.ccbluex.liquidbounce.utils;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.IClassProvider;
/*    */ import net.ccbluex.liquidbounce.api.IExtractedFunctions;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.IMinecraft;
/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ public class MinecraftInstance {
/* 10 */   public static final IMinecraft mc = Retreat.wrapper.getMinecraft();
/* 11 */   protected static final Minecraft minecraft = Minecraft.func_71410_x();
/* 12 */   public static final IClassProvider classProvider = Retreat.INSTANCE.getWrapper().getClassProvider();
/* 13 */   protected static final IExtractedFunctions functions = Retreat.INSTANCE.getWrapper().getFunctions();
/*    */   
/* 15 */   public static final Minecraft mc2 = Minecraft.func_71410_x();
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\MinecraftInstance.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */