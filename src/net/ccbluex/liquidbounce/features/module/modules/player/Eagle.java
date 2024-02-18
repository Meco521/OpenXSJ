/*    */ package net.ccbluex.liquidbounce.features.module.modules.player;
/*    */ 
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.enums.BlockType;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ 
/*    */ @ModuleInfo(name = "Eagle", description = "Makes you eagle (aka. FastBridge).", category = ModuleCategory.PLAYER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\032\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\003\032\0020\004H\026J\020\020\005\032\0020\0042\006\020\006\032\0020\007H\007¨\006\b"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/player/Eagle;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "onDisable", "", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class Eagle extends Module {
/*    */   @EventTarget
/* 16 */   public final void onUpdate(@NotNull UpdateEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 18 */       if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getGameSettings().getKeyBindSneak().setPressed(Intrinsics.areEqual(MinecraftInstance.mc.getTheWorld().getBlockState(new WBlockPos(thePlayer.getPosX(), thePlayer.getPosY() - 1.0D, thePlayer.getPosZ())).getBlock(), MinecraftInstance.classProvider.getBlockEnum(BlockType.AIR)));
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer(); } public void onDisable() {
/* 22 */     if (MinecraftInstance.mc.getThePlayer() == null) {
/*    */       return;
/*    */     }
/* 25 */     if (!MinecraftInstance.mc.getGameSettings().isKeyDown(MinecraftInstance.mc.getGameSettings().getKeyBindSneak()))
/* 26 */       MinecraftInstance.mc.getGameSettings().getKeyBindSneak().setPressed(false); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\player\Eagle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */