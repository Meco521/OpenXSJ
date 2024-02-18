/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.client;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.movement.InventoryMove;
/*    */ import net.minecraft.client.settings.KeyBinding;
/*    */ import net.minecraftforge.client.settings.IKeyConflictContext;
/*    */ import net.minecraftforge.client.settings.KeyModifier;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Overwrite;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({KeyBinding.class})
/*    */ public abstract class MixinKeyBinding
/*    */ {
/*    */   @Shadow
/*    */   public boolean field_74513_e;
/*    */   
/*    */   @Overwrite
/*    */   public boolean func_151470_d() {
/* 25 */     InventoryMove inventoryMove = (InventoryMove)Retreat.moduleManager.get(InventoryMove.class);
/* 26 */     boolean InvMove = inventoryMove.getState() ? this.field_74513_e : ((this.field_74513_e && getKeyConflictContext().isActive() && getKeyModifier().isActive(getKeyConflictContext())));
/* 27 */     return InvMove;
/*    */   }
/*    */   
/*    */   @Shadow
/*    */   public abstract IKeyConflictContext getKeyConflictContext();
/*    */   
/*    */   @Shadow
/*    */   public abstract KeyModifier getKeyModifier();
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\client\MixinKeyBinding.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */