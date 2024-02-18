/*    */ package net.ccbluex.liquidbounce.features.command.commands;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\021\n\002\020\016\n\002\b\002\n\002\020 \n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\033\020\003\032\0020\0042\f\020\005\032\b\022\004\022\0020\0070\006H\026¢\006\002\020\bJ!\020\t\032\b\022\004\022\0020\0070\n2\f\020\005\032\b\022\004\022\0020\0070\006H\026¢\006\002\020\013¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/features/command/commands/RemoteViewCommand;", "Lnet/ccbluex/liquidbounce/features/command/Command;", "()V", "execute", "", "args", "", "", "([Ljava/lang/String;)V", "tabComplete", "", "([Ljava/lang/String;)Ljava/util/List;", "XSJClient"})
/*    */ public final class RemoteViewCommand extends Command {
/*    */   public RemoteViewCommand() {
/*  6 */     super("remoteview", new String[] { "rv" });
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(@NotNull String[] args) {
/* 11 */     Intrinsics.checkParameterIsNotNull(args, "args"); if (args.length < 2) {
/* 12 */       if ((Intrinsics.areEqual(MinecraftInstance.mc.getRenderViewEntity(), MinecraftInstance.mc.getThePlayer()) ^ true) != 0) {
/* 13 */         MinecraftInstance.mc.setRenderViewEntity((IEntity)MinecraftInstance.mc.getThePlayer());
/*    */         return;
/*    */       } 
/* 16 */       chatSyntax("remoteview <username>");
/*    */       
/*    */       return;
/*    */     } 
/* 20 */     String targetName = args[1];
/*    */     
/* 22 */     if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  for (IEntity entity : MinecraftInstance.mc.getTheWorld().getLoadedEntityList()) {
/* 23 */       if (Intrinsics.areEqual(targetName, entity.getName())) {
/* 24 */         MinecraftInstance.mc.setRenderViewEntity(entity);
/* 25 */         chat("Now viewing perspective of §8" + entity.getName() + "§3.");
/* 26 */         chat("Execute §8" + Retreat.INSTANCE.getCommandManager().getPrefix() + "remoteview §3again to go back to yours."); break;
/*    */       } 
/*    */     }  } @NotNull public List<String> tabComplete(@NotNull String[] args) { Iterable $this$filter$iv, $this$map$iv;
/*    */     int $i$f$filter, $i$f$map;
/*    */     Iterable iterable1, $this$filterTo$iv$iv;
/*    */     Collection destination$iv$iv;
/*    */     int $i$f$filterTo, $i$f$mapTo;
/* 33 */     Intrinsics.checkParameterIsNotNull(args, "args"); String[] arrayOfString = args; boolean bool = false; if ((arrayOfString.length == 0)) return CollectionsKt.emptyList();
/*    */     
/* 35 */     switch (args.length) { case 1:
/* 36 */         if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  $this$filter$iv = MinecraftInstance.mc.getTheWorld().getPlayerEntities();
/* 37 */         $i$f$filter = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 43 */         iterable1 = $this$filter$iv; destination$iv$iv = new ArrayList(); $i$f$filterTo = 0;
/* 44 */         for (Object element$iv$iv : iterable1) { IEntityPlayer it = (IEntityPlayer)element$iv$iv; int $i$a$-filter-RemoteViewCommand$tabComplete$1 = 0; }
/* 45 */          $this$map$iv = destination$iv$iv; $i$f$map = 0;
/* 46 */         $this$filterTo$iv$iv = $this$map$iv; destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10)); $i$f$mapTo = 0;
/* 47 */         for (Object item$iv$iv : $this$filterTo$iv$iv)
/* 48 */         { IEntityPlayer iEntityPlayer = (IEntityPlayer)item$iv$iv; Collection collection = destination$iv$iv; int $i$a$-map-RemoteViewCommand$tabComplete$2 = 0; if (iEntityPlayer.getName() == null)
/* 49 */             Intrinsics.throwNpe();  }  return (List<String>)destination$iv$iv; }
/*    */     
/*    */     return CollectionsKt.emptyList(); }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\command\commands\RemoteViewCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */