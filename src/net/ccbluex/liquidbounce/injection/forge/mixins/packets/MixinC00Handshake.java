/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.packets;
/*    */ 
/*    */ import net.minecraft.network.EnumConnectionState;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.handshake.client.C00Handshake;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Overwrite;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ @Mixin({C00Handshake.class})
/*    */ public class MixinC00Handshake
/*    */ {
/*    */   @Shadow
/*    */   public int field_149599_c;
/*    */   @Shadow
/*    */   public String field_149598_b;
/*    */   @Shadow
/*    */   private int field_149600_a;
/*    */   @Shadow
/*    */   private EnumConnectionState field_149597_d;
/*    */   
/*    */   @Overwrite
/*    */   public void func_148840_b(PacketBuffer buf) {
/* 30 */     buf.func_150787_b(this.field_149600_a);
/* 31 */     buf.func_180714_a(this.field_149598_b + "\000FML\000");
/* 32 */     buf.writeShort(this.field_149599_c);
/* 33 */     buf.func_150787_b(this.field_149597_d.func_150759_c());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\packets\MixinC00Handshake.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */