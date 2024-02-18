/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.settings.IKeyBinding;
/*    */ import net.ccbluex.liquidbounce.event.ClickWindowEvent;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "InventoryMove", description = "Allows you to walk while an inventory is opened.", category = ModuleCategory.MOVEMENT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000>\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\021\n\002\030\002\n\002\b\003\n\002\020\016\n\002\b\004\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\021\032\0020\0222\006\020\023\032\0020\024H\007J\b\020\025\032\0020\022H\026J\020\020\026\032\0020\0222\006\020\023\032\0020\027H\007J\006\020\030\032\0020\022R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\026\020\007\032\b\022\004\022\0020\t0\bX\004¢\006\004\n\002\020\nR\016\020\013\032\0020\004X\004¢\006\002\n\000R\026\020\f\032\004\030\0010\r8VX\004¢\006\006\032\004\b\016\020\017R\016\020\020\032\0020\004X\004¢\006\002\n\000¨\006\031"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/InventoryMove;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "aacAdditionProValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "getAacAdditionProValue", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "affectedBindings", "", "Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;", "[Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;", "noMoveClicksValue", "tag", "", "getTag", "()Ljava/lang/String;", "undetectable", "onClick", "", "event", "Lnet/ccbluex/liquidbounce/event/ClickWindowEvent;", "onDisable", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "tick", "XSJClient"})
/*    */ public final class InventoryMove extends Module {
/* 15 */   private final BoolValue undetectable = new BoolValue("Undetectable", false); @NotNull
/* 16 */   private final BoolValue aacAdditionProValue = new BoolValue("AACAdditionPro", false); @NotNull public final BoolValue getAacAdditionProValue() { return this.aacAdditionProValue; }
/* 17 */    private final BoolValue noMoveClicksValue = new BoolValue("NoMoveClicks", false);
/*    */   
/* 19 */   private final IKeyBinding[] affectedBindings = new IKeyBinding[] {
/* 20 */       MinecraftInstance.mc.getGameSettings().getKeyBindForward(), 
/* 21 */       MinecraftInstance.mc.getGameSettings().getKeyBindBack(), 
/* 22 */       MinecraftInstance.mc.getGameSettings().getKeyBindRight(), 
/* 23 */       MinecraftInstance.mc.getGameSettings().getKeyBindLeft(), 
/* 24 */       MinecraftInstance.mc.getGameSettings().getKeyBindJump(), 
/* 25 */       MinecraftInstance.mc.getGameSettings().getKeyBindSprint()
/*    */     };
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 30 */     Intrinsics.checkParameterIsNotNull(event, "event"); tick();
/*    */   }
/*    */   
/*    */   public final void tick() {
/* 34 */     if (!MinecraftInstance.classProvider.isGuiChat(MinecraftInstance.mc.getCurrentScreen()) && !MinecraftInstance.classProvider.isGuiIngameMenu(MinecraftInstance.mc.getCurrentScreen()) && (!((Boolean)this.undetectable.get()).booleanValue() || !MinecraftInstance.classProvider.isGuiContainer(MinecraftInstance.mc.getCurrentScreen()))) {
/* 35 */       for (IKeyBinding affectedBinding : this.affectedBindings) {
/* 36 */         affectedBinding.setPressed(MinecraftInstance.mc.getGameSettings().isKeyDown(affectedBinding));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onClick(@NotNull ClickWindowEvent event) {
/* 43 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (((Boolean)this.noMoveClicksValue.get()).booleanValue() && MovementUtils.isMoving())
/* 44 */       event.cancelEvent(); 
/*    */   }
/*    */   
/*    */   public void onDisable() {
/* 48 */     boolean isIngame = (MinecraftInstance.mc.getCurrentScreen() != null);
/*    */     
/* 50 */     for (IKeyBinding affectedBinding : this.affectedBindings) {
/* 51 */       if (!MinecraftInstance.mc.getGameSettings().isKeyDown(affectedBinding) || isIngame)
/* 52 */         affectedBinding.setPressed(false); 
/*    */     } 
/*    */   }
/*    */   @Nullable
/*    */   public String getTag() {
/* 57 */     return "Grim";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\InventoryMove.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */