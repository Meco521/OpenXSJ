/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.text.StringsKt;
/*    */ import net.ccbluex.liquidbounce.api.enums.BlockType;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.block.material.IMaterial;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.block.BlockUtils;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @ModuleInfo(name = "IceSpeed", category = ModuleCategory.MOVEMENT, description = "冰上加速")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000 \n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\002\n\002\b\003\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\005\032\0020\006H\026J\b\020\007\032\0020\006H\026J\022\020\b\032\0020\0062\b\020\t\032\004\030\0010\nH\007R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\013"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/IceSpeed;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "onDisable", "", "onEnable", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class IceSpeed extends Module {
/* 22 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "NCP", "AAC", "Spartan" }, "NCP");
/*    */   public void onEnable() {
/* 24 */     if (StringsKt.equals((String)this.modeValue.get(), "NCP", true)) {
/* 25 */       MinecraftInstance.classProvider.getBlockEnum(BlockType.ICE).setSlipperiness(0.39F);
/* 26 */       MinecraftInstance.classProvider.getBlockEnum(BlockType.ICE_PACKED).setSlipperiness(0.39F);
/*    */     } 
/* 28 */     super.onEnable();
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@Nullable UpdateEvent event) {
/* 33 */     String mode = (String)this.modeValue.get();
/* 34 */     if (StringsKt.equals(mode, "NCP", true)) {
/* 35 */       MinecraftInstance.classProvider.getBlockEnum(BlockType.ICE).setSlipperiness(0.39F);
/* 36 */       MinecraftInstance.classProvider.getBlockEnum(BlockType.ICE_PACKED).setSlipperiness(0.39F);
/*    */     } else {
/* 38 */       MinecraftInstance.classProvider.getBlockEnum(BlockType.ICE).setSlipperiness(0.98F);
/* 39 */       MinecraftInstance.classProvider.getBlockEnum(BlockType.ICE_PACKED).setSlipperiness(0.98F);
/*    */     } 
/*    */     
/* 42 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 44 */       if (thePlayer.getOnGround() && !thePlayer.isOnLadder() && !thePlayer.isSneaking() && thePlayer.getSprinting() && thePlayer.getMovementInput().getMoveForward() > 0.0D) {
/* 45 */         if (StringsKt.equals(mode, "AAC", true)) {
/* 46 */           IMaterial iMaterial1 = BlockUtils.getMaterial(thePlayer.getPosition().down()); boolean bool1 = false, bool2 = false; IMaterial it = iMaterial1; int $i$a$-let-IceSpeed$onUpdate$1 = 0;
/* 47 */           if (Intrinsics.areEqual(it, MinecraftInstance.classProvider.getBlockEnum(BlockType.ICE)) || Intrinsics.areEqual(it, MinecraftInstance.classProvider.getBlockEnum(BlockType.ICE_PACKED))) {
/* 48 */             thePlayer.setMotionX(thePlayer.getMotionX() * 1.342D);
/* 49 */             thePlayer.setMotionZ(thePlayer.getMotionZ() * 1.342D);
/* 50 */             MinecraftInstance.classProvider.getBlockEnum(BlockType.ICE).setSlipperiness(0.6F);
/* 51 */             MinecraftInstance.classProvider.getBlockEnum(BlockType.ICE_PACKED).setSlipperiness(0.6F);
/*    */           } 
/*    */         } 
/*    */         
/* 55 */         if (StringsKt.equals(mode, "Spartan", true)) {
/* 56 */           IMaterial iMaterial1 = BlockUtils.getMaterial(thePlayer.getPosition().down()); boolean bool1 = false, bool2 = false; IMaterial it = iMaterial1; int $i$a$-let-IceSpeed$onUpdate$2 = 0;
/* 57 */           if (Intrinsics.areEqual(it, MinecraftInstance.classProvider.getBlockEnum(BlockType.ICE)) || Intrinsics.areEqual(it, MinecraftInstance.classProvider.getBlockEnum(BlockType.ICE_PACKED))) {
/* 58 */             IBlock upBlock = BlockUtils.getBlock(new WBlockPos(thePlayer.getPosX(), thePlayer.getPosY() + 2.0D, thePlayer.getPosZ()));
/*    */             
/* 60 */             if (!MinecraftInstance.classProvider.isBlockAir(upBlock)) {
/* 61 */               thePlayer.setMotionX(thePlayer.getMotionX() * 1.342D);
/* 62 */               thePlayer.setMotionZ(thePlayer.getMotionZ() * 1.342D);
/*    */             } else {
/* 64 */               thePlayer.setMotionX(thePlayer.getMotionX() * 1.18D);
/* 65 */               thePlayer.setMotionZ(thePlayer.getMotionZ() * 1.18D);
/*    */             } 
/*    */             
/* 68 */             MinecraftInstance.classProvider.getBlockEnum(BlockType.ICE).setSlipperiness(0.6F);
/* 69 */             MinecraftInstance.classProvider.getBlockEnum(BlockType.ICE_PACKED).setSlipperiness(0.6F);
/*    */           } 
/*    */         } 
/*    */       } 
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer();
/*    */   } public void onDisable() {
/* 77 */     MinecraftInstance.classProvider.getBlockEnum(BlockType.ICE).setSlipperiness(0.98F);
/* 78 */     MinecraftInstance.classProvider.getBlockEnum(BlockType.ICE_PACKED).setSlipperiness(0.98F);
/* 79 */     super.onDisable();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\IceSpeed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */