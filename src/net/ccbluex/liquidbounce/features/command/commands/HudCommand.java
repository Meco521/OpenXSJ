/*    */ package net.ccbluex.liquidbounce.features.command.commands;
/*    */ import java.io.File;
/*    */ import java.io.PrintWriter;
/*    */ import java.util.ArrayList;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import org.apache.commons.io.FileUtils;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\021\n\002\020\016\n\002\b\002\n\002\020 \n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\033\020\003\032\0020\0042\f\020\005\032\b\022\004\022\0020\0070\006H\026¢\006\002\020\bJ!\020\t\032\b\022\004\022\0020\0070\n2\f\020\005\032\b\022\004\022\0020\0070\006H\026¢\006\002\020\013¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/features/command/commands/HudCommand;", "Lnet/ccbluex/liquidbounce/features/command/Command;", "()V", "execute", "", "args", "", "", "([Ljava/lang/String;)V", "tabComplete", "", "([Ljava/lang/String;)Ljava/util/List;", "XSJClient"})
/*    */ public final class HudCommand extends Command {
/*    */   public HudCommand() {
/* 13 */     super("hudconfig", new String[0]);
/*    */   } public void execute(@NotNull String[] args) {
/* 15 */     Intrinsics.checkParameterIsNotNull(args, "args"); if (args.length >= 2)
/* 16 */     { String command = args[1];
/* 17 */       if ((Retreat.INSTANCE.getFileManager()).hudsDir == null) Intrinsics.throwNpe();  File dir = (Retreat.INSTANCE.getFileManager()).hudsDir;
/*    */       
/* 19 */       String str1 = command; switch (str1.hashCode())
/*    */       
/*    */       { 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/*    */         case 3327206:
/* 45 */           if (str1.equals("load")) {
/* 46 */             if (args.length == 3) {
/*    */               
/* 48 */               if ((new File((Retreat.INSTANCE.getFileManager()).configsDir, args[2])).exists()) {
/*    */                 
/* 50 */                 Retreat.INSTANCE.getHud().clearElements();
/* 51 */                 Intrinsics.checkExpressionValueIsNotNull(FileUtils.readFileToString(new File((Retreat.INSTANCE.getFileManager()).hudsDir, args[2])), "FileUtils.readFileToStri…anager.hudsDir, args[2]))"); Retreat.INSTANCE.setHud((new Config(FileUtils.readFileToString(new File((Retreat.INSTANCE.getFileManager()).hudsDir, args[2])))).toHUD());
/*    */                 
/* 53 */                 chat("Loaded hud: " + args[2]); break;
/*    */               } 
/* 55 */               chat("Hud " + args[2] + " not found.");
/*    */               
/*    */               break;
/*    */             } 
/* 59 */             chatSyntax("hudconfig < list / save <name> / load <name> / delete <name> >");
/*    */           } 
/*    */           break;
/*    */         case 3522941:
/* 63 */           if (str1.equals("save"))
/* 64 */           { if (args.length == 3) {
/* 65 */               PrintWriter printWriter = new PrintWriter(new FileWriter(new File((Retreat.INSTANCE.getFileManager()).hudsDir, args[2])));
/* 66 */               printWriter.println((new Config(Retreat.INSTANCE.getHud())).toJson());
/* 67 */               printWriter.close();
/* 68 */               chat("Saved hud " + args[2]); break;
/*    */             } 
/* 70 */             chatSyntax("hudconfig < list / save <name> / load <name> / delete <name> >"); }  break;
/*    */         case 3322014:
/*    */           if (str1.equals("list")) { chat("Huds :"); for (File listFile : dir.listFiles()) { Intrinsics.checkExpressionValueIsNotNull(listFile, "listFile"); Intrinsics.checkExpressionValueIsNotNull(listFile.getName(), "listFile.name"); chat(listFile.getName()); }  }  break;
/*    */         case -1335458389:
/*    */           if (str1.equals("delete")) { if (args.length == 3) { if ((new File((Retreat.INSTANCE.getFileManager()).configsDir, args[2])).exists()) { try { FileUtils.forceDelete(new File((Retreat.INSTANCE.getFileManager()).hudsDir, args[2])); chat("Deleted hud: " + args[2]); } catch (Exception e) { chat("Failed to delete hud: " + args[2]); }  break; }  chat("Hud " + args[2] + " not found."); break; }  chatSyntax("hudconfig < list / save <name> / load <name> / delete <name> >"); }  break; }  }
/* 75 */     else { chatSyntax("hudconfig < list / save <name> / load <name> / delete <name> >"); }
/*    */   
/*    */   } @NotNull
/*    */   public List<String> tabComplete(@NotNull String[] args) {
/*    */     ArrayList<String> array;
/* 80 */     Intrinsics.checkParameterIsNotNull(args, "args"); String[] arrayOfString = args; boolean bool = false; if ((arrayOfString.length == 0)) return CollectionsKt.emptyList();
/*    */     
/* 82 */     switch (args.length) { case 1:
/*    */       
/*    */       case 2:
/* 85 */         array = new ArrayList();
/* 86 */         if ((Retreat.INSTANCE.getFileManager()).hudsDir == null) Intrinsics.throwNpe();  for (File listFile : (Retreat.INSTANCE.getFileManager()).hudsDir.listFiles()) {
/* 87 */           Intrinsics.checkExpressionValueIsNotNull(listFile, "listFile"); array.add(listFile.getName());
/*    */         }  }
/*    */ 
/*    */ 
/*    */     
/* 92 */     return CollectionsKt.emptyList();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\command\commands\HudCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */