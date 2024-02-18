/*    */ package net.ccbluex.liquidbounce.features.module.modules.misc;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.Render2DEvent;
/*    */ import net.ccbluex.liquidbounce.file.FileConfig;
/*    */ import net.ccbluex.liquidbounce.file.configs.FriendsConfig;
/*    */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*    */ import org.lwjgl.input.Mouse;
/*    */ 
/*    */ @ModuleInfo(name = "MidClick", description = "Allows you to add a player as a friend by right clicking him.", category = ModuleCategory.MISC)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\022\020\005\032\0020\0062\b\020\007\032\004\030\0010\bH\007R\016\020\003\032\0020\004X\016¢\006\002\n\000¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/misc/MidClick;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "wasDown", "", "onRender", "", "event", "Lnet/ccbluex/liquidbounce/event/Render2DEvent;", "XSJClient"})
/*    */ public final class MidClick extends Module {
/*    */   @EventTarget
/*    */   public final void onRender(@Nullable Render2DEvent event) {
/* 19 */     if (MinecraftInstance.mc.getCurrentScreen() != null) {
/*    */       return;
/*    */     }
/* 22 */     if (!this.wasDown && Mouse.isButtonDown(2)) {
/* 23 */       if (MinecraftInstance.mc.getObjectMouseOver() == null) Intrinsics.throwNpe();  IEntity entity = MinecraftInstance.mc.getObjectMouseOver().getEntityHit();
/*    */       
/* 25 */       if (MinecraftInstance.classProvider.isEntityPlayer(entity)) {
/* 26 */         if (entity == null) Intrinsics.throwNpe();  String playerName = ColorUtils.stripColor(entity.getName());
/* 27 */         FriendsConfig friendsConfig = (Retreat.INSTANCE.getFileManager()).friendsConfig;
/*    */         
/* 29 */         if (!friendsConfig.isFriend(playerName)) {
/* 30 */           friendsConfig.addFriend(playerName);
/* 31 */           Retreat.INSTANCE.getFileManager().saveConfig((FileConfig)friendsConfig);
/* 32 */           ClientUtils.displayChatMessage("§a§l" + playerName + "§c was added to your friends.");
/*    */         } else {
/* 34 */           friendsConfig.removeFriend(playerName);
/* 35 */           Retreat.INSTANCE.getFileManager().saveConfig((FileConfig)friendsConfig);
/* 36 */           ClientUtils.displayChatMessage("§a§l" + playerName + "§c was removed from your friends.");
/*    */         } 
/*    */       } else {
/*    */         
/* 40 */         ClientUtils.displayChatMessage("§c§lError: §aYou need to select a player.");
/*    */       } 
/* 42 */     }  this.wasDown = Mouse.isButtonDown(2);
/*    */   }
/*    */   
/*    */   private boolean wasDown;
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\misc\MidClick.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */