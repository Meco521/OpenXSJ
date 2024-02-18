/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement;
/*    */ 
/*    */ import java.util.Map;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.TypeCastException;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.injection.backend.BlockImpl;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.block.BlockUtils;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.play.client.CPacketPlayerDigging;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "NoWeb", description = "bzd", category = ModuleCategory.MOVEMENT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\006H\007J\020\020\007\032\0020\0042\006\020\005\032\0020\bH\007¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/NoWeb;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "onRender3D", "", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class NoWeb
/*    */   extends Module {
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 31 */     Intrinsics.checkParameterIsNotNull(event, "event"); Map searchBlocks = BlockUtils.searchBlocks(4);
/*    */     
/* 33 */     Map map1 = searchBlocks; boolean bool = false; for (Map.Entry block : map1.entrySet()) {
/* 34 */       WBlockPos $this$unwrap$iv = (WBlockPos)block.getKey(); int $i$f$unwrap = 0; BlockPos blockpos = 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 73 */         new BlockPos($this$unwrap$iv.getX(), $this$unwrap$iv.getY(), $this$unwrap$iv.getZ()); IBlock iBlock = (IBlock)block.getValue(); int i = 0;
/* 74 */       if (iBlock == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.BlockImpl");  Block blocks = ((BlockImpl)iBlock).getWrapped();
/*    */       if (blocks instanceof net.minecraft.block.BlockWeb) {
/*    */         Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2");
/*    */         if (MinecraftInstance.mc2.func_147114_u() == null)
/*    */           Intrinsics.throwNpe(); 
/*    */         MinecraftInstance.mc2.func_147114_u().func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockpos, EnumFacing.DOWN));
/*    */         MinecraftInstance.mc2.field_71439_g.field_70134_J = false;
/*    */       } 
/*    */       if (blocks instanceof net.minecraft.block.BlockLiquid) {
/*    */         Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2");
/*    */         if (MinecraftInstance.mc2.func_147114_u() == null)
/*    */           Intrinsics.throwNpe(); 
/*    */         MinecraftInstance.mc2.func_147114_u().func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockpos, EnumFacing.DOWN));
/*    */         MinecraftInstance.mc2.field_71439_g.field_70171_ac = false;
/*    */       } 
/*    */     } 
/*    */     Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player");
/*    */     Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71474_y.field_74314_A, "mc2.gameSettings.keyBindJump");
/*    */     if (MinecraftInstance.mc2.field_71439_g.func_70617_f_() && MinecraftInstance.mc2.field_71474_y.field_74314_A.func_151470_d() && MinecraftInstance.mc2.field_71439_g.field_70181_x >= 0.0D)
/*    */       MinecraftInstance.mc2.field_71439_g.field_70181_x = 0.1786D; 
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onRender3D(@NotNull Render3DEvent event) {
/*    */     Intrinsics.checkParameterIsNotNull(event, "event");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\NoWeb.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */