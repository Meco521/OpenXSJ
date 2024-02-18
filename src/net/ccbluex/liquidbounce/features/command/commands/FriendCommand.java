/*     */ package net.ccbluex.liquidbounce.features.command.commands;
/*     */ import net.ccbluex.liquidbounce.file.configs.FriendsConfig;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\021\n\002\020\016\n\002\b\002\n\002\020 \n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\033\020\003\032\0020\0042\f\020\005\032\b\022\004\022\0020\0070\006H\026¢\006\002\020\bJ!\020\t\032\b\022\004\022\0020\0070\n2\f\020\005\032\b\022\004\022\0020\0070\006H\026¢\006\002\020\013¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/features/command/commands/FriendCommand;", "Lnet/ccbluex/liquidbounce/features/command/Command;", "()V", "execute", "", "args", "", "", "([Ljava/lang/String;)V", "tabComplete", "", "([Ljava/lang/String;)Ljava/util/List;", "XSJClient"})
/*     */ public final class FriendCommand extends Command {
/*     */   public FriendCommand() {
/*   7 */     super("friend", new String[] { "friends" });
/*     */   }
/*     */ 
/*     */   
/*     */   public void execute(@NotNull String[] args) {
/*  12 */     Intrinsics.checkParameterIsNotNull(args, "args"); if (args.length > 1) {
/*  13 */       FriendsConfig friendsConfig = (Retreat.INSTANCE.getFileManager()).friendsConfig;
/*     */ 
/*     */       
/*  16 */       if (StringsKt.equals(args[1], "add", true)) {
/*  17 */         if (args.length > 2) {
/*  18 */           String name = args[2];
/*     */           
/*  20 */           CharSequence charSequence = name; boolean bool = false; if ((charSequence.length() == 0)) {
/*  21 */             chat("The name is empty.");
/*     */             
/*     */             return;
/*     */           } 
/*  25 */           if ((args.length > 3) ? friendsConfig.addFriend(name, StringUtils.toCompleteString(args, 3)) : friendsConfig.addFriend(name)) {
/*  26 */             Retreat.INSTANCE.getFileManager().saveConfig((FileConfig)friendsConfig);
/*  27 */             chat("§a§l" + name + "§3 was added to your friend list.");
/*  28 */             playEdit();
/*     */           } else {
/*  30 */             chat("The name is already in the list.");
/*     */           }  return;
/*     */         } 
/*  33 */         chatSyntax("friend add <name> [alias]");
/*     */         
/*     */         return;
/*     */       } 
/*  37 */       if (StringsKt.equals(args[1], "remove", true)) {
/*  38 */         if (args.length > 2) {
/*  39 */           String name = args[2];
/*     */           
/*  41 */           if (friendsConfig.removeFriend(name)) {
/*  42 */             Retreat.INSTANCE.getFileManager().saveConfig((FileConfig)friendsConfig);
/*  43 */             chat("§a§l" + name + "§3 was removed from your friend list.");
/*  44 */             playEdit();
/*     */           } else {
/*  46 */             chat("This name is not in the list.");
/*     */           }  return;
/*     */         } 
/*  49 */         chatSyntax("friend remove <name>");
/*     */         
/*     */         return;
/*     */       } 
/*  53 */       if (StringsKt.equals(args[1], "clear", true)) {
/*  54 */         Intrinsics.checkExpressionValueIsNotNull(friendsConfig, "friendsConfig"); int friends = friendsConfig.getFriends().size();
/*  55 */         friendsConfig.clearFriends();
/*  56 */         Retreat.INSTANCE.getFileManager().saveConfig((FileConfig)friendsConfig);
/*  57 */         chat("Removed " + friends + " friend(s).");
/*     */         
/*     */         return;
/*     */       } 
/*  61 */       if (StringsKt.equals(args[1], "list", true)) {
/*  62 */         chat("Your Friends:");
/*     */         
/*  64 */         Intrinsics.checkExpressionValueIsNotNull(friendsConfig, "friendsConfig"); for (FriendsConfig.Friend friend : friendsConfig.getFriends()) {
/*  65 */           Intrinsics.checkExpressionValueIsNotNull(friend, "friend"); chat("§7> §a§l" + friend.getPlayerName() + " §c(§7§l" + friend.getAlias() + "§c)");
/*     */         } 
/*  67 */         chat("You have §c" + friendsConfig.getFriends().size() + "§3 friends.");
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/*  73 */     chatSyntax("friend <add/remove/list/clear>"); } @NotNull public List<String> tabComplete(@NotNull String[] args) { Iterable $this$filter$iv; String str; int $i$f$filter;
/*     */     Iterable iterable1;
/*     */     Collection<Object> destination$iv$iv;
/*     */     int $i$f$filterTo;
/*  77 */     Intrinsics.checkParameterIsNotNull(args, "args"); String[] arrayOfString = args; boolean bool = false; if ((arrayOfString.length == 0)) return CollectionsKt.emptyList();
/*     */     
/*  79 */     switch (args.length) { case 1:
/*  80 */         $this$filter$iv = CollectionsKt.listOf((Object[])new String[] { "add", "remove", "list", "clear" }); $i$f$filter = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 100 */         iterable1 = $this$filter$iv; destination$iv$iv = new ArrayList(); $i$f$filterTo = 0;
/* 101 */         for (Object element$iv$iv : iterable1) { String it = (String)element$iv$iv; int $i$a$-filter-FriendCommand$tabComplete$1 = 0; if (StringsKt.startsWith(it, args[0], true)) destination$iv$iv.add(element$iv$iv);  } case 2: str = args[0]; $i$f$filter = 0; if (str == null)
/*     */           throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case 96417: if (str.equals("add")) { if (MinecraftInstance.mc.getTheWorld() == null)
/* 103 */                 Intrinsics.throwNpe();  Iterable iterable2 = MinecraftInstance.mc.getTheWorld().getPlayerEntities(); int i = 0; Iterable iterable3 = iterable2; Collection collection = new ArrayList(); int j = 0;
/* 104 */               for (Object element$iv$iv : iterable3) { IEntityPlayer it = (IEntityPlayer)element$iv$iv; int $i$a$-filter-FriendCommand$tabComplete$2 = 0; it.getName(); }
/* 105 */                Iterable $this$map$iv = collection; int $i$f$map = 0;
/* 106 */               Iterable $this$filterTo$iv$iv = $this$map$iv; collection = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10)); int $i$f$mapTo = 0;
/* 107 */               for (Object item$iv$iv : $this$filterTo$iv$iv)
/* 108 */               { IEntityPlayer iEntityPlayer = (IEntityPlayer)item$iv$iv; Collection collection1 = collection; int $i$a$-map-FriendCommand$tabComplete$3 = 0; if (iEntityPlayer.getName() == null)
/* 109 */                   Intrinsics.throwNpe();  }  return (List<String>)collection; }  break;
/* 110 */           case -934610812: if (str.equals("remove")) { Intrinsics.checkExpressionValueIsNotNull((Retreat.INSTANCE.getFileManager()).friendsConfig, "Retreat.fileManager.friendsConfig"); Intrinsics.checkExpressionValueIsNotNull((Retreat.INSTANCE.getFileManager()).friendsConfig.getFriends(), "Retreat.fileManager.friendsConfig.friends"); Iterable $this$map$iv = (Retreat.INSTANCE.getFileManager()).friendsConfig.getFriends(); int $i$f$map = 0; Iterable $this$mapTo$iv$iv = $this$map$iv; Collection<String> collection1 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10)); int $i$f$mapTo = 0;
/* 111 */               for (Object item$iv$iv : $this$mapTo$iv$iv) {
/* 112 */                 FriendsConfig.Friend friend = (FriendsConfig.Friend)item$iv$iv; Collection<String> collection2 = collection1; int $i$a$-map-FriendCommand$tabComplete$4 = 0; Intrinsics.checkExpressionValueIsNotNull(friend, "it"); String str1 = friend.getPlayerName(); collection2.add(str1);
/* 113 */               }  Iterable iterable2 = collection1; int i = 0;
/* 114 */               $this$mapTo$iv$iv = iterable2; Collection<Object> collection = new ArrayList(); int j = 0;
/* 115 */               for (Object element$iv$iv : $this$mapTo$iv$iv) { String it = (String)element$iv$iv; int $i$a$-filter-FriendCommand$tabComplete$5 = 0; Intrinsics.checkExpressionValueIsNotNull(it, "it"); if (StringsKt.startsWith(it, args[1], true))
/* 116 */                   collection.add(element$iv$iv);  }  return (List)collection; }
/*     */             
/*     */             break; }
/*     */         
/*     */         return CollectionsKt.emptyList(); }
/*     */     
/*     */     return CollectionsKt.emptyList(); }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\command\commands\FriendCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */