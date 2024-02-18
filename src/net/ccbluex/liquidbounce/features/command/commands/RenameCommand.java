/*    */ package net.ccbluex.liquidbounce.features.command.commands;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\021\n\002\020\016\n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\033\020\003\032\0020\0042\f\020\005\032\b\022\004\022\0020\0070\006H\026¢\006\002\020\b¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/features/command/commands/RenameCommand;", "Lnet/ccbluex/liquidbounce/features/command/Command;", "()V", "execute", "", "args", "", "", "([Ljava/lang/String;)V", "XSJClient"})
/*    */ public final class RenameCommand extends Command {
/*    */   public RenameCommand() {
/*  7 */     super("rename", new String[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(@NotNull String[] args) {
/* 12 */     Intrinsics.checkParameterIsNotNull(args, "args"); if (args.length > 1) {
/* 13 */       if (MinecraftInstance.mc.getPlayerController().isNotCreative()) {
/* 14 */         chat("§c§lError: §3You need to be in creative mode.");
/*    */         
/*    */         return;
/*    */       } 
/* 18 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IItemStack item = MinecraftInstance.mc.getThePlayer().getHeldItem();
/*    */       
/* 20 */       if (((item != null) ? item.getItem() : null) == null) {
/* 21 */         chat("§c§lError: §3You need to hold a item.");
/*    */         
/*    */         return;
/*    */       } 
/* 25 */       Intrinsics.checkExpressionValueIsNotNull(StringUtils.toCompleteString(args, 1), "StringUtils.toCompleteString(args, 1)"); item.setStackDisplayName(ColorUtils.translateAlternateColorCodes(StringUtils.toCompleteString(args, 1)));
/* 26 */       chat("§3Item renamed to '" + item.getDisplayName() + "§3'");
/*    */       
/*    */       return;
/*    */     } 
/* 30 */     chatSyntax("rename <name>");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\command\commands\RenameCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */