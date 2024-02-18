/*     */ package net.ccbluex.liquidbounce.utils;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.network.play.INetHandlerPlayServer;
/*     */ import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ 
/*     */ public class C08PacketPlayerBlockPlacement extends CPacketPlayerTryUseItem implements Packet<INetHandlerPlayServer> {
/*  15 */   private static final BlockPos field_179726_a = new BlockPos(-1, -1, -1);
/*     */   
/*     */   private BlockPos position;
/*     */   private WBlockPos position2;
/*     */   private int placedBlockDirection;
/*     */   private EnumHand stack;
/*     */   private ItemStack stack2;
/*     */   public float facingX;
/*     */   public float facingY;
/*     */   public float facingZ;
/*     */   
/*     */   public C08PacketPlayerBlockPlacement() {}
/*     */   
/*     */   public C08PacketPlayerBlockPlacement(EnumHand p_i45930_1_) {
/*  29 */     this(field_179726_a, 255, p_i45930_1_, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public C08PacketPlayerBlockPlacement(BlockPos p_i45931_1_, int p_i45931_2_, ItemStack p_i45931_3_, float p_i45931_4_, float p_i45931_5_, float p_i45931_6_) {
/*  33 */     this.position = p_i45931_1_;
/*  34 */     this.placedBlockDirection = p_i45931_2_;
/*  35 */     this.stack2 = (p_i45931_3_ != null) ? p_i45931_3_.func_77946_l() : null;
/*  36 */     this.facingX = p_i45931_4_;
/*  37 */     this.facingY = p_i45931_5_;
/*  38 */     this.facingZ = p_i45931_6_;
/*     */   }
/*     */   
/*     */   public C08PacketPlayerBlockPlacement(WBlockPos p_i45931_1_, int p_i45931_2_, EnumHand p_i46858_3_, float p_i45931_4_, float p_i45931_5_, float p_i45931_6_) {
/*  42 */     this.position2 = p_i45931_1_;
/*  43 */     this.placedBlockDirection = p_i45931_2_;
/*  44 */     this.stack = p_i46858_3_;
/*  45 */     this.facingX = p_i45931_4_;
/*  46 */     this.facingY = p_i45931_5_;
/*  47 */     this.facingZ = p_i45931_6_;
/*     */   }
/*     */   
/*     */   public C08PacketPlayerBlockPlacement(BlockPos p_i45931_1_, int p_i45931_2_, EnumHand p_i46858_3_, float p_i45931_4_, float p_i45931_5_, float p_i45931_6_) {
/*  51 */     this.position = p_i45931_1_;
/*  52 */     this.placedBlockDirection = p_i45931_2_;
/*  53 */     this.stack = p_i46858_3_;
/*  54 */     this.facingX = p_i45931_4_;
/*  55 */     this.facingY = p_i45931_5_;
/*  56 */     this.facingZ = p_i45931_6_;
/*     */   }
/*     */   
/*     */   public void func_148837_a(PacketBuffer p_readPacketData_1_) throws IOException {
/*  60 */     this.position = p_readPacketData_1_.func_179259_c();
/*  61 */     this.placedBlockDirection = p_readPacketData_1_.readUnsignedByte();
/*  62 */     this.stack = (EnumHand)p_readPacketData_1_.func_179257_a(EnumHand.class);
/*  63 */     this.facingX = p_readPacketData_1_.readUnsignedByte() / 16.0F;
/*  64 */     this.facingY = p_readPacketData_1_.readUnsignedByte() / 16.0F;
/*  65 */     this.facingZ = p_readPacketData_1_.readUnsignedByte() / 16.0F;
/*     */   }
/*     */   
/*     */   public void func_148840_b(PacketBuffer p_writePacketData_1_) throws IOException {
/*  69 */     p_writePacketData_1_.func_179255_a(this.position);
/*  70 */     p_writePacketData_1_.writeByte(this.placedBlockDirection);
/*  71 */     p_writePacketData_1_.func_179249_a((Enum)this.stack);
/*  72 */     p_writePacketData_1_.writeByte((int)(this.facingX * 16.0F));
/*  73 */     p_writePacketData_1_.writeByte((int)(this.facingY * 16.0F));
/*  74 */     p_writePacketData_1_.writeByte((int)(this.facingZ * 16.0F));
/*     */   }
/*     */   
/*     */   public void func_148833_a(INetHandlerPlayServer p_processPacket_1_) {
/*  78 */     p_processPacket_1_.func_147346_a(this);
/*     */   }
/*     */   
/*     */   public BlockPos getPosition() {
/*  82 */     return this.position;
/*     */   }
/*     */   
/*     */   public int getPlacedBlockDirection() {
/*  86 */     return this.placedBlockDirection;
/*     */   }
/*     */   
/*     */   public EnumHand getStack() {
/*  90 */     return this.stack;
/*     */   }
/*     */   
/*     */   public float getPlacedBlockOffsetX() {
/*  94 */     return this.facingX;
/*     */   }
/*     */   
/*     */   public float getPlacedBlockOffsetY() {
/*  98 */     return this.facingY;
/*     */   }
/*     */   
/*     */   public float getPlacedBlockOffsetZ() {
/* 102 */     return this.facingZ;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\C08PacketPlayerBlockPlacement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */