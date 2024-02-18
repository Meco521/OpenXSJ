/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.enums.BlockType;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.MovementUtils;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "Parkour2", category = ModuleCategory.MOVEMENT, description = "skid")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\006H\007¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/Parkour2;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class Parkour2
/*    */   extends Module {
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 23 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */ 
/*    */       
/* 26 */       if (MovementUtils.isMoving() && thePlayer.getOnGround() && !thePlayer.isSneaking() && !MinecraftInstance.mc.getGameSettings().getKeyBindSneak().isKeyDown() && !MinecraftInstance.mc.getGameSettings().getKeyBindJump().isKeyDown()) { if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  if (Intrinsics.areEqual(MinecraftInstance.mc.getTheWorld().getBlockState(new WBlockPos(thePlayer.getPosX(), thePlayer.getPosY() - 1.0D, thePlayer.getPosZ())).getBlock(), MinecraftInstance.classProvider.getBlockEnum(
/* 27 */               BlockType.AIR)))
/* 28 */           thePlayer.jump();  }
/*    */       
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\Parkour2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */