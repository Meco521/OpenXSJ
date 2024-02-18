/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement;
/*    */ import kotlin.TypeCastException;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.JumpEvent;
/*    */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.block.BlockUtils;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @ModuleInfo(name = "HighJump", category = ModuleCategory.MOVEMENT, description = "高跳")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000>\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\r\032\0020\0162\006\020\017\032\0020\020H\007J\022\020\021\032\0020\0162\b\020\017\032\004\030\0010\022H\007J\022\020\023\032\0020\0162\b\020\017\032\004\030\0010\024H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\024\020\t\032\0020\n8VX\004¢\006\006\032\004\b\013\020\f¨\006\025"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/HighJump;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "glassValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "heightValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "tag", "", "getTag", "()Ljava/lang/String;", "onJump", "", "event", "Lnet/ccbluex/liquidbounce/event/JumpEvent;", "onMove", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class HighJump extends Module {
/* 24 */   private final FloatValue heightValue = new FloatValue("Height", 2.0F, 1.1F, 5.0F);
/* 25 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "Vanilla", "Damage", "AACv3", "DAC", "Mineplex" }, "Vanilla");
/* 26 */   private final BoolValue glassValue = new BoolValue("OnlyGlassPane", false);
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@Nullable UpdateEvent event) {
/* 30 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */     
/* 32 */     if (((Boolean)this.glassValue.get()).booleanValue() && !MinecraftInstance.classProvider.isBlockPane(BlockUtils.getBlock(new WBlockPos(thePlayer.getPosX(), thePlayer.getPosY(), thePlayer.getPosZ())))) {
/*    */       return;
/*    */     }
/* 35 */     String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case -1339126929:
/* 36 */         if (str.equals("damage") && thePlayer.getHurtTime() > 0 && thePlayer.getOnGround()) thePlayer.setMotionY(thePlayer.getMotionY() + (0.42F * ((Number)this.heightValue.get()).floatValue()));  break;
/* 37 */       case 92570112: if (str.equals("aacv3") && !thePlayer.getOnGround()) thePlayer.setMotionY(thePlayer.getMotionY() + 0.059D);  break;
/*    */       case -1362669950:
/* 39 */         if (str.equals("mineplex") && !thePlayer.getOnGround()) MovementUtils.strafe(0.35F); 
/*    */         break;
/*    */       case 99206:
/*    */         if (str.equals("dac") && !thePlayer.getOnGround())
/*    */           thePlayer.setMotionY(thePlayer.getMotionY() + 0.049999D); 
/*    */         break; }
/* 45 */      } @EventTarget public final void onMove(@Nullable MoveEvent event) { if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 47 */       if (((Boolean)this.glassValue.get()).booleanValue() && !MinecraftInstance.classProvider.isBlockPane(BlockUtils.getBlock(new WBlockPos(thePlayer.getPosX(), thePlayer.getPosY(), thePlayer.getPosZ()))))
/*    */         return; 
/* 49 */       if (!thePlayer.getOnGround()) {
/* 50 */         String str1 = (String)this.modeValue.get(), str2 = "mineplex"; boolean bool = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()"); String str3 = str1.toLowerCase(); if (Intrinsics.areEqual(str2, str3))
/* 51 */           thePlayer.setMotionY(thePlayer.getMotionY() + ((thePlayer.getFallDistance() == 0.0F) ? 0.0499D : 0.05D)); 
/*    */       } 
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer(); }
/*    */   
/*    */   @EventTarget
/* 58 */   public final void onJump(@NotNull JumpEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 60 */       if (((Boolean)this.glassValue.get()).booleanValue() && !MinecraftInstance.classProvider.isBlockPane(BlockUtils.getBlock(new WBlockPos(thePlayer.getPosX(), thePlayer.getPosY(), thePlayer.getPosZ()))))
/*    */         return; 
/* 62 */       String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) {
/*    */         case -1362669950:
/* 64 */           if (str.equals("mineplex")) event.setMotion(0.47F);  break;
/*    */         case 233102203:
/*    */           if (str.equals("vanilla"))
/*    */             event.setMotion(event.getMotion() * ((Number)this.heightValue.get()).floatValue());  break;
/*    */       }  return; }
/* 69 */      MinecraftInstance.mc.getThePlayer(); } @NotNull public String getTag() { return (String)this.modeValue.get(); }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\HighJump.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */