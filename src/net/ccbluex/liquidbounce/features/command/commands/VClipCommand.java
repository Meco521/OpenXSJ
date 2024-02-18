/*    */ package net.ccbluex.liquidbounce.features.command.commands;
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\021\n\002\020\016\n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\033\020\003\032\0020\0042\f\020\005\032\b\022\004\022\0020\0070\006H\026¢\006\002\020\b¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/features/command/commands/VClipCommand;", "Lnet/ccbluex/liquidbounce/features/command/Command;", "()V", "execute", "", "args", "", "", "([Ljava/lang/String;)V", "XSJClient"})
/*    */ public final class VClipCommand extends Command {
/*    */   public VClipCommand() {
/*  5 */     super("vclip", new String[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(@NotNull String[] args) {
/* 10 */     Intrinsics.checkParameterIsNotNull(args, "args"); if (args.length > 1) {
/*    */       try {
/* 12 */         String str = args[1]; boolean bool = false; double y = Double.parseDouble(str);
/* 13 */         if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */           
/* 15 */           if (thePlayer.isRiding()) { if (thePlayer.getRidingEntity() == null) Intrinsics.throwNpe();  } else {  }  IEntity entity = (IEntity)thePlayer;
/*    */           
/* 17 */           entity.setPosition(entity.getPosX(), entity.getPosY() + y, entity.getPosZ());
/* 18 */           chat("You were teleported."); return; }  MinecraftInstance.mc.getThePlayer(); return;
/* 19 */       } catch (NumberFormatException ex) {
/* 20 */         chatSyntaxError();
/*    */       } 
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 26 */     chatSyntax("vclip <value>");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\command\commands\VClipCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */