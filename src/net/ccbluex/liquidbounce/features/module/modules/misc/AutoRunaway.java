/*    */ package net.ccbluex.liquidbounce.features.module.modules.misc;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketEntityAction;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura2;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura3;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.ModuleUtils;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.TextValue;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "AutoRunaway", description = "操你妈打不过直接自动/hub顺便帮你关掉杀戮", category = ModuleCategory.MISC)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000@\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\b\n\002\020\013\n\002\b\005\n\002\030\002\n\002\b\005\n\002\020\002\n\000\n\002\020\b\n\002\b\003\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\030\020\036\032\0020\0372\006\020 \032\0020!2\006\020\"\032\0020\023H\002J\020\020#\032\0020\0372\006\020$\032\0020%H\007R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\032\020\t\032\0020\nX\016¢\006\016\n\000\032\004\b\013\020\f\"\004\b\r\020\016R\032\020\017\032\0020\004X\016¢\006\016\n\000\032\004\b\020\020\006\"\004\b\021\020\bR\032\020\022\032\0020\023X\016¢\006\016\n\000\032\004\b\024\020\025\"\004\b\026\020\027R\032\020\030\032\0020\031X\016¢\006\016\n\000\032\004\b\032\020\033\"\004\b\034\020\035¨\006&"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/misc/AutoRunaway;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "autoDisable", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "getAutoDisable", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "setAutoDisable", "(Lnet/ccbluex/liquidbounce/value/BoolValue;)V", "health", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "getHealth", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "setHealth", "(Lnet/ccbluex/liquidbounce/value/FloatValue;)V", "keepArmor", "getKeepArmor", "setKeepArmor", "lmao", "", "getLmao", "()Z", "setLmao", "(Z)V", "text", "Lnet/ccbluex/liquidbounce/value/TextValue;", "getText", "()Lnet/ccbluex/liquidbounce/value/TextValue;", "setText", "(Lnet/ccbluex/liquidbounce/value/TextValue;)V", "autoArmor", "", "item", "", "isArmorSlot", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class AutoRunaway extends Module {
/*    */   @NotNull
/* 28 */   private FloatValue health = new FloatValue("Health", 5.0F, 0.0F, 20.0F); @NotNull public final FloatValue getHealth() { return this.health; } public final void setHealth(@NotNull FloatValue <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.health = <set-?>; } @NotNull
/* 29 */   private TextValue text = new TextValue("Text", "/hub"); @NotNull public final TextValue getText() { return this.text; } public final void setText(@NotNull TextValue <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.text = <set-?>; } @NotNull
/* 30 */   private BoolValue autoDisable = new BoolValue("AutoDisable", true); @NotNull public final BoolValue getAutoDisable() { return this.autoDisable; } public final void setAutoDisable(@NotNull BoolValue <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.autoDisable = <set-?>; } private boolean lmao; @NotNull
/* 31 */   private BoolValue keepArmor = new BoolValue("KeepArmor", true); @NotNull public final BoolValue getKeepArmor() { return this.keepArmor; } public final void setKeepArmor(@NotNull BoolValue <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.keepArmor = <set-?>; }
/*    */   
/* 33 */   public final boolean getLmao() { return this.lmao; } public final void setLmao(boolean <set-?>) { this.lmao = <set-?>; }
/*    */   
/*    */   private final void autoArmor(int item, boolean isArmorSlot) {
/* 36 */     if (item != -1) {
/* 37 */       boolean openInventory = !(MinecraftInstance.mc.getCurrentScreen() instanceof net.minecraft.client.gui.inventory.GuiInventory);
/* 38 */       if (openInventory) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), 
/* 39 */               ICPacketEntityAction.WAction.OPEN_INVENTORY)); }
/*    */       
/* 41 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getPlayerController().windowClick(MinecraftInstance.mc.getThePlayer().getInventoryContainer().getWindowId(), isArmorSlot ? item : ((item < 9) ? (item + 36) : item), 0, 1, MinecraftInstance.mc.getThePlayer());
/*    */       
/* 43 */       if (openInventory) MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketCloseWindow()); 
/*    */     } 
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 49 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHealth() < ((Number)this.health.get()).floatValue()) {
/* 50 */         if (((Boolean)this.keepArmor.get()).booleanValue()) {
/* 51 */           for (byte b1 = 0, b2 = 3; b1 <= b2; b1++) {
/* 52 */             int armorSlot = 3 - b1;
/* 53 */             autoArmor(8 - armorSlot, true);
/*    */           } 
/*    */         }
/*    */         
/* 57 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHealth() <= ((Number)this.health.get()).floatValue() && !this.lmao) {
/* 58 */           (access$getMinecraft$p$s1046033730()).field_71439_g.func_71165_d((String)this.text.get());
/* 59 */           this.lmao = true;
/*    */         } 
/*    */         
/* 62 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHealth() <= ((Number)this.health.get()).floatValue() && ((Boolean)this.autoDisable.get()).booleanValue()) {
/* 63 */           ModuleUtils.disableModules(new Class[] { KillAura.class, KillAura2.class, KillAura3.class });
/*    */         }
/*    */         
/* 66 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHealth() >= ((Number)this.health.get()).floatValue())
/* 67 */           this.lmao = false; 
/*    */       }  }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\misc\AutoRunaway.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */