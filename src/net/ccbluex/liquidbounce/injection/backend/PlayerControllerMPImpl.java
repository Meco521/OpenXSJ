/*     */ package net.ccbluex.liquidbounce.injection.backend;
/*     */ 
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IEnumFacing;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.multiplayer.PlayerControllerMP;
/*     */ import net.minecraft.client.multiplayer.WorldClient;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.EnumActionResult;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000v\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\006\n\002\020\007\n\002\b\007\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\006\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\000\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\002\n\002\b\003\n\002\030\002\n\002\030\002\n\002\b\b\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\030\020\036\032\0020\0312\006\020\037\032\0020 2\006\020!\032\0020\"H\026J\023\020#\032\0020\0312\b\020$\032\004\030\0010%H\002J\b\020&\032\0020\031H\026J\030\020'\032\0020\0312\006\020\037\032\0020 2\006\020!\032\0020\"H\026J:\020(\032\0020\0312\006\020)\032\0020*2\006\020+\032\0020,2\b\020-\032\004\030\0010.2\006\020/\032\0020 2\006\0200\032\0020\"2\006\0201\032\00202H\026J\020\0203\032\002042\006\0205\032\0020*H\026J \0206\032\0020\0312\006\0207\032\002082\006\020+\032\002092\006\020-\032\0020.H\026J\b\020:\032\00204H\026J0\020;\032\002042\006\020<\032\0020\0062\006\020=\032\0020\0062\006\020>\032\0020\0062\006\020?\032\0020\0062\006\020@\032\0020*H\026R$\020\007\032\0020\0062\006\020\005\032\0020\0068V@VX\016¢\006\f\032\004\b\b\020\t\"\004\b\n\020\013R\024\020\f\032\0020\r8VX\004¢\006\006\032\004\b\016\020\017R$\020\020\032\0020\r2\006\020\005\032\0020\r8V@VX\016¢\006\f\032\004\b\021\020\017\"\004\b\022\020\023R\024\020\024\032\0020\0258VX\004¢\006\006\032\004\b\026\020\027R\024\020\030\032\0020\0318VX\004¢\006\006\032\004\b\030\020\032R\024\020\033\032\0020\0318VX\004¢\006\006\032\004\b\033\020\032R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\034\020\035¨\006A"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/PlayerControllerMPImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;", "wrapped", "Lnet/minecraft/client/multiplayer/PlayerControllerMP;", "(Lnet/minecraft/client/multiplayer/PlayerControllerMP;)V", "value", "", "blockHitDelay", "getBlockHitDelay", "()I", "setBlockHitDelay", "(I)V", "blockReachDistance", "", "getBlockReachDistance", "()F", "curBlockDamageMP", "getCurBlockDamageMP", "setCurBlockDamageMP", "(F)V", "currentGameType", "Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorldSettings$WGameType;", "getCurrentGameType", "()Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorldSettings$WGameType;", "isInCreativeMode", "", "()Z", "isNotCreative", "getWrapped", "()Lnet/minecraft/client/multiplayer/PlayerControllerMP;", "clickBlock", "blockPos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "enumFacing", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;", "equals", "other", "", "extendedReach", "onPlayerDestroyBlock", "onPlayerRightClick", "playerSP", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;", "wWorld", "Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;", "wItemStack", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "wPosition", "wSideOpposite", "wHitVec", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;", "onStoppedUsingItem", "", "thePlayer", "sendUseItem", "wPlayer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;", "Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorld;", "updateController", "windowClick", "windowId", "slot", "mouseButton", "mode", "player", "XSJClient"})
/*     */ public final class PlayerControllerMPImpl implements IPlayerControllerMP {
/*     */   @NotNull
/*     */   private final PlayerControllerMP wrapped;
/*     */   
/*     */   @NotNull
/*  26 */   public final PlayerControllerMP getWrapped() { return this.wrapped; } public PlayerControllerMPImpl(@NotNull PlayerControllerMP wrapped) { this.wrapped = wrapped; }
/*     */    public boolean isNotCreative() {
/*  28 */     return this.wrapped.func_78762_g();
/*     */   }
/*  30 */   public float getBlockReachDistance() { return this.wrapped.func_78757_d(); }
/*     */   @NotNull
/*  32 */   public IWorldSettings.WGameType getCurrentGameType() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_178889_l(), "wrapped.currentGameType"); GameType $this$wrap$iv = this.wrapped.func_178889_l(); int $i$f$wrap = 0;
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
/*     */ 
/*     */ 
/*     */     
/* 112 */     switch (BackendExtentionsKt.WhenMappings.$EnumSwitchMapping$6[$this$wrap$iv.ordinal()]) { case 1: 
/*     */       case 2: 
/*     */       case 3: 
/*     */       case 4: 
/*     */       case 5:
/* 117 */        }  throw new NoWhenBranchMatchedException(); }
/*     */   public boolean isInCreativeMode() { return this.wrapped.func_78758_h(); }
/*     */   public float getCurBlockDamageMP() { return this.wrapped.field_78770_f; }
/*     */   public void setCurBlockDamageMP(float value) { this.wrapped.field_78770_f = value; }
/*     */   public int getBlockHitDelay() { return this.wrapped.field_78781_i; }
/*     */   public void setBlockHitDelay(int value) { this.wrapped.field_78781_i = value; }
/*     */   public void windowClick(int windowId, int slot, int mouseButton, int mode, @NotNull IEntityPlayerSP player) { // Byte code:
/*     */     //   0: aload #5
/*     */     //   2: ldc 'player'
/*     */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   7: aload_0
/*     */     //   8: getfield wrapped : Lnet/minecraft/client/multiplayer/PlayerControllerMP;
/*     */     //   11: iload_1
/*     */     //   12: iload_2
/*     */     //   13: iload_3
/*     */     //   14: iload #4
/*     */     //   16: istore #6
/*     */     //   18: istore #11
/*     */     //   20: istore #10
/*     */     //   22: istore #9
/*     */     //   24: astore #8
/*     */     //   26: iconst_0
/*     */     //   27: istore #7
/*     */     //   29: iload #6
/*     */     //   31: tableswitch default -> 114, 0 -> 72, 1 -> 78, 2 -> 84, 3 -> 90, 4 -> 96, 5 -> 102, 6 -> 108
/*     */     //   72: getstatic net/minecraft/inventory/ClickType.PICKUP : Lnet/minecraft/inventory/ClickType;
/*     */     //   75: goto -> 145
/*     */     //   78: getstatic net/minecraft/inventory/ClickType.QUICK_MOVE : Lnet/minecraft/inventory/ClickType;
/*     */     //   81: goto -> 145
/*     */     //   84: getstatic net/minecraft/inventory/ClickType.SWAP : Lnet/minecraft/inventory/ClickType;
/*     */     //   87: goto -> 145
/*     */     //   90: getstatic net/minecraft/inventory/ClickType.CLONE : Lnet/minecraft/inventory/ClickType;
/*     */     //   93: goto -> 145
/*     */     //   96: getstatic net/minecraft/inventory/ClickType.THROW : Lnet/minecraft/inventory/ClickType;
/*     */     //   99: goto -> 145
/*     */     //   102: getstatic net/minecraft/inventory/ClickType.QUICK_CRAFT : Lnet/minecraft/inventory/ClickType;
/*     */     //   105: goto -> 145
/*     */     //   108: getstatic net/minecraft/inventory/ClickType.PICKUP_ALL : Lnet/minecraft/inventory/ClickType;
/*     */     //   111: goto -> 145
/*     */     //   114: new java/lang/IllegalArgumentException
/*     */     //   117: dup
/*     */     //   118: new java/lang/StringBuilder
/*     */     //   121: dup
/*     */     //   122: invokespecial <init> : ()V
/*     */     //   125: ldc 'Invalid mode '
/*     */     //   127: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   130: iload #6
/*     */     //   132: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   135: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   138: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   141: checkcast java/lang/Throwable
/*     */     //   144: athrow
/*     */     //   145: astore #12
/*     */     //   147: aload #8
/*     */     //   149: iload #9
/*     */     //   151: iload #10
/*     */     //   153: iload #11
/*     */     //   155: aload #12
/*     */     //   157: aload #5
/*     */     //   159: astore #6
/*     */     //   161: astore #12
/*     */     //   163: istore #11
/*     */     //   165: istore #10
/*     */     //   167: istore #9
/*     */     //   169: astore #8
/*     */     //   171: iconst_0
/*     */     //   172: istore #7
/*     */     //   174: aload #6
/*     */     //   176: checkcast net/ccbluex/liquidbounce/injection/backend/EntityPlayerSPImpl
/*     */     //   179: invokevirtual getWrapped : ()Lnet/minecraft/entity/Entity;
/*     */     //   182: checkcast net/minecraft/client/entity/EntityPlayerSP
/*     */     //   185: astore #13
/*     */     //   187: aload #8
/*     */     //   189: iload #9
/*     */     //   191: iload #10
/*     */     //   193: iload #11
/*     */     //   195: aload #12
/*     */     //   197: aload #13
/*     */     //   199: checkcast net/minecraft/entity/player/EntityPlayer
/*     */     //   202: invokevirtual func_187098_a : (IIILnet/minecraft/inventory/ClickType;Lnet/minecraft/entity/player/EntityPlayer;)Lnet/minecraft/item/ItemStack;
/*     */     //   205: pop
/*     */     //   206: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #47	-> 7
/*     */     //   #118	-> 29
/*     */     //   #119	-> 72
/*     */     //   #120	-> 78
/*     */     //   #121	-> 84
/*     */     //   #122	-> 90
/*     */     //   #123	-> 96
/*     */     //   #124	-> 102
/*     */     //   #125	-> 108
/*     */     //   #126	-> 114
/*     */     //   #47	-> 157
/*     */     //   #127	-> 174
/*     */     //   #47	-> 202
/*     */     //   #48	-> 206
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   26	119	6	$this$toClickType$iv	I
/*     */     //   29	116	7	$i$f$toClickType	I
/*     */     //   171	14	6	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   174	11	7	$i$f$unwrap	I
/*     */     //   0	207	0	this	Lnet/ccbluex/liquidbounce/injection/backend/PlayerControllerMPImpl;
/*     */     //   0	207	1	windowId	I
/*     */     //   0	207	2	slot	I
/*     */     //   0	207	3	mouseButton	I
/*     */     //   0	207	4	mode	I
/*     */     //   0	207	5	player	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP; }
/*     */   public void updateController() { this.wrapped.func_78765_e(); } public boolean sendUseItem(@NotNull IEntityPlayer wPlayer, @NotNull IWorld wWorld, @NotNull IItemStack wItemStack) { Intrinsics.checkParameterIsNotNull(wPlayer, "wPlayer"); Intrinsics.checkParameterIsNotNull(wWorld, "wWorld");
/*     */     Intrinsics.checkParameterIsNotNull(wItemStack, "wItemStack");
/*     */     IEntityPlayer $this$unwrap$iv = wPlayer;
/*     */     int $i$f$unwrap = 0;
/* 128 */     EntityPlayer player = ((EntityPlayerImpl<EntityPlayer>)$this$unwrap$iv).getWrapped(); IWorld iWorld = wWorld; int j = 0;
/* 129 */     World world = ((WorldImpl<World>)iWorld).getWrapped(); IItemStack iItemStack = wItemStack; int k = 0;
/* 130 */     ItemStack itemStack = ((ItemStackImpl)iItemStack).getWrapped(); if (this.wrapped.func_178889_l() == GameType.SPECTATOR) return false;  this.wrapped.func_78750_j(); Intrinsics.checkExpressionValueIsNotNull(Minecraft.func_71410_x(), "Minecraft.getMinecraft()"); if (Minecraft.func_71410_x().func_147114_u() == null) Intrinsics.throwNpe();  Minecraft.func_71410_x().func_147114_u().func_147297_a((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND)); if (player.func_184811_cZ().func_185141_a(itemStack.func_77973_b())) return false;  EnumActionResult cancelResult = ForgeHooks.onItemRightClick(player, EnumHand.MAIN_HAND); if (cancelResult != null) return (cancelResult == EnumActionResult.SUCCESS);  int i = itemStack.func_190916_E(); ActionResult result = itemStack.func_77957_a(world, player, EnumHand.MAIN_HAND); Intrinsics.checkExpressionValueIsNotNull(result, "result"); ItemStack resultStack = (ItemStack)result.func_188398_b(); player.func_184611_a(EnumHand.MAIN_HAND, resultStack); Intrinsics.checkExpressionValueIsNotNull(resultStack, "resultStack"); if (((Intrinsics.areEqual(resultStack, itemStack) ^ true) != 0 || resultStack.func_190916_E() != i) && resultStack.func_190926_b())
/* 131 */       ForgeEventFactory.onPlayerDestroyItem(player, itemStack, EnumHand.MAIN_HAND);  return (result.func_188397_a() == EnumActionResult.SUCCESS); } public boolean onPlayerRightClick(@NotNull IEntityPlayerSP playerSP, @NotNull IWorldClient wWorld, @Nullable IItemStack wItemStack, @NotNull WBlockPos wPosition, @NotNull IEnumFacing wSideOpposite, @NotNull WVec3 wHitVec) { Intrinsics.checkParameterIsNotNull(playerSP, "playerSP"); Intrinsics.checkParameterIsNotNull(wWorld, "wWorld"); Intrinsics.checkParameterIsNotNull(wPosition, "wPosition"); Intrinsics.checkParameterIsNotNull(wSideOpposite, "wSideOpposite"); Intrinsics.checkParameterIsNotNull(wHitVec, "wHitVec"); IEntityPlayerSP iEntityPlayerSP = playerSP; PlayerControllerMP playerControllerMP = this.wrapped; int $i$f$unwrap = 0; EntityPlayerSP entityPlayerSP = ((EntityPlayerSPImpl<EntityPlayerSP>)iEntityPlayerSP).getWrapped(); IWorldClient iWorldClient = wWorld; entityPlayerSP = entityPlayerSP; playerControllerMP = playerControllerMP; $i$f$unwrap = 0;
/* 132 */     WorldClient worldClient = ((WorldClientImpl)iWorldClient).getWrapped(); WBlockPos wBlockPos = wPosition; worldClient = worldClient; entityPlayerSP = entityPlayerSP; playerControllerMP = playerControllerMP; $i$f$unwrap = 0;
/* 133 */     BlockPos blockPos = new BlockPos(wBlockPos.getX(), wBlockPos.getY(), wBlockPos.getZ()); IEnumFacing iEnumFacing = wSideOpposite; blockPos = blockPos; worldClient = worldClient; entityPlayerSP = entityPlayerSP; playerControllerMP = playerControllerMP; $i$f$unwrap = 0;
/* 134 */     EnumFacing enumFacing = ((EnumFacingImpl)iEnumFacing).getWrapped(); WVec3 wVec3 = wHitVec; enumFacing = enumFacing; blockPos = blockPos; worldClient = worldClient; entityPlayerSP = entityPlayerSP; playerControllerMP = playerControllerMP; $i$f$unwrap = 0;
/* 135 */     Vec3d vec3d = new Vec3d(wVec3.getXCoord(), wVec3.getYCoord(), wVec3.getZCoord()); return (playerControllerMP.func_187099_a(entityPlayerSP, worldClient, blockPos, enumFacing, vec3d, EnumHand.MAIN_HAND) == EnumActionResult.SUCCESS); } public void onStoppedUsingItem(@NotNull IEntityPlayerSP thePlayer) { Intrinsics.checkParameterIsNotNull(thePlayer, "thePlayer"); IEntityPlayerSP iEntityPlayerSP = thePlayer; PlayerControllerMP playerControllerMP = this.wrapped; int $i$f$unwrap = 0;
/* 136 */     EntityPlayerSP entityPlayerSP = ((EntityPlayerSPImpl<EntityPlayerSP>)iEntityPlayerSP).getWrapped(); playerControllerMP.func_78766_c((EntityPlayer)entityPlayerSP); } public boolean clickBlock(@NotNull WBlockPos blockPos, @NotNull IEnumFacing enumFacing) { Intrinsics.checkParameterIsNotNull(blockPos, "blockPos"); Intrinsics.checkParameterIsNotNull(enumFacing, "enumFacing"); WBlockPos wBlockPos = blockPos; PlayerControllerMP playerControllerMP = this.wrapped; int $i$f$unwrap = 0;
/* 137 */     BlockPos blockPos1 = new BlockPos(wBlockPos.getX(), wBlockPos.getY(), wBlockPos.getZ()); IEnumFacing iEnumFacing = enumFacing; blockPos1 = blockPos1; playerControllerMP = playerControllerMP; $i$f$unwrap = 0;
/* 138 */     EnumFacing enumFacing1 = ((EnumFacingImpl)iEnumFacing).getWrapped(); return playerControllerMP.func_180511_b(blockPos1, enumFacing1); } public boolean onPlayerDestroyBlock(@NotNull WBlockPos blockPos, @NotNull IEnumFacing enumFacing) { Intrinsics.checkParameterIsNotNull(blockPos, "blockPos"); Intrinsics.checkParameterIsNotNull(enumFacing, "enumFacing"); WBlockPos wBlockPos = blockPos; PlayerControllerMP playerControllerMP = this.wrapped; int $i$f$unwrap = 0;
/* 139 */     BlockPos blockPos1 = new BlockPos(wBlockPos.getX(), wBlockPos.getY(), wBlockPos.getZ()); return playerControllerMP.func_187103_a(blockPos1); }
/*     */ 
/*     */   
/*     */   public boolean extendedReach() {
/*     */     return this.wrapped.func_78749_i();
/*     */   }
/*     */   
/*     */   public boolean equals(@Nullable Object other) {
/*     */     return (other instanceof PlayerControllerMPImpl && Intrinsics.areEqual(((PlayerControllerMPImpl)other).wrapped, this.wrapped));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\PlayerControllerMPImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */