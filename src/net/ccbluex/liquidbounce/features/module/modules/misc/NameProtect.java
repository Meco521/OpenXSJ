/*    */ package net.ccbluex.liquidbounce.features.module.modules.misc;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.event.TextEvent;
/*    */ import net.ccbluex.liquidbounce.file.configs.FriendsConfig;
/*    */ import net.ccbluex.liquidbounce.utils.misc.StringUtils;
/*    */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "NameProtect", description = "Changes playernames clientside.", category = ModuleCategory.MISC)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\b\032\0020\t2\006\020\n\032\0020\013H\007R\020\020\003\032\0020\0048\006X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\020\020\007\032\0020\0048\006X\004¢\006\002\n\000¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/misc/NameProtect;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "allPlayersValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "fakeNameValue", "Lnet/ccbluex/liquidbounce/value/TextValue;", "skinProtectValue", "onText", "", "event", "Lnet/ccbluex/liquidbounce/event/TextEvent;", "XSJClient"})
/*    */ public final class NameProtect extends Module {
/*    */   @JvmField
/*    */   @NotNull
/* 17 */   public final BoolValue allPlayersValue = new BoolValue("AllPlayers", false);
/*    */   @JvmField
/*    */   @NotNull
/* 20 */   public final BoolValue skinProtectValue = new BoolValue("SkinProtect", true);
/* 21 */   private final TextValue fakeNameValue = new TextValue("FakeName", "&aXSJ Sense&cUser");
/*    */   
/*    */   @EventTarget(ignoreCondition = true)
/*    */   public final void onText(@NotNull TextEvent event) {
/* 25 */     Intrinsics.checkParameterIsNotNull(event, "event"); IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */     
/* 27 */     if (thePlayer != null) { if (event.getText() == null) Intrinsics.throwNpe();  if (!StringsKt.contains$default(event.getText(), "§8[§9§lXSJ Client§8] §3", false, 2, null)) {
/*    */ 
/*    */         
/* 30 */         Intrinsics.checkExpressionValueIsNotNull((Retreat.INSTANCE.getFileManager()).friendsConfig, "Retreat.fileManager.friendsConfig"); for (FriendsConfig.Friend friend : (Retreat.INSTANCE.getFileManager()).friendsConfig.getFriends()) {
/* 31 */           Intrinsics.checkExpressionValueIsNotNull(friend, "friend"); Intrinsics.checkExpressionValueIsNotNull(friend.getAlias(), "friend.alias"); event.setText(StringUtils.replace(event.getText(), friend.getPlayerName(), ColorUtils.translateAlternateColorCodes(friend.getAlias()) + "§f"));
/*    */         } 
/* 33 */         if (!getState())
/*    */           return; 
/* 35 */         event.setText(StringUtils.replace(event.getText(), thePlayer.getName(), ColorUtils.translateAlternateColorCodes((String)this.fakeNameValue.get()) + "§f"));
/*    */         
/* 37 */         if (((Boolean)this.allPlayersValue.get()).booleanValue())
/* 38 */           for (INetworkPlayerInfo playerInfo : MinecraftInstance.mc.getNetHandler().getPlayerInfoMap())
/* 39 */             event.setText(StringUtils.replace(event.getText(), playerInfo.getGameProfile().getName(), "Protected User"));  
/*    */         return;
/*    */       }  }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\misc\NameProtect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */