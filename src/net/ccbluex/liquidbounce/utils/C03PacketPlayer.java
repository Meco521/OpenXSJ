/*     */ package net.ccbluex.liquidbounce.utils;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.network.play.INetHandlerPlayServer;
/*     */ import net.minecraft.network.play.client.CPacketPlayer;
/*     */ 
/*     */ 
/*     */ public class C03PacketPlayer
/*     */   extends CPacketPlayer
/*     */   implements Packet<INetHandlerPlayServer>
/*     */ {
/*     */   public double field_149479_a;
/*     */   public double field_149477_b;
/*     */   public double field_149478_c;
/*     */   public float field_149476_e;
/*     */   public float field_149473_f;
/*     */   public boolean field_149474_g;
/*     */   public boolean field_149480_h;
/*     */   protected boolean field_149481_i;
/*     */   
/*     */   public C03PacketPlayer() {}
/*     */   
/*     */   public C03PacketPlayer(boolean isOnGround) {
/*  27 */     this.field_149474_g = isOnGround;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148833_a(INetHandlerPlayServer handler) {
/*  32 */     handler.func_147347_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148837_a(PacketBuffer buf) throws IOException {
/*  37 */     this.field_149474_g = (buf.readUnsignedByte() != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148840_b(PacketBuffer buf) throws IOException {
/*  42 */     buf.writeByte(this.field_149474_g ? 1 : 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public double getPositionX() {
/*  47 */     return this.field_149479_a;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getPositionY() {
/*  52 */     return this.field_149477_b;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getPositionZ() {
/*  57 */     return this.field_149478_c;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getYaw() {
/*  62 */     return this.field_149476_e;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPitch() {
/*  67 */     return this.field_149473_f;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149465_i() {
/*  72 */     return this.field_149474_g;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isMoving() {
/*  77 */     return this.field_149480_h;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getRotating() {
/*  82 */     return this.field_149481_i;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMoving(boolean isMoving) {
/*  87 */     this.field_149480_h = isMoving;
/*     */   }
/*     */   
/*     */   public static class C04PacketPlayerPosition
/*     */     extends C03PacketPlayer
/*     */   {
/*     */     public C04PacketPlayerPosition() {
/*  94 */       this.field_149480_h = true;
/*     */     }
/*     */ 
/*     */     
/*     */     public C04PacketPlayerPosition(double posX, double posY, double posZ, boolean isOnGround) {
/*  99 */       this.field_149479_a = posX;
/* 100 */       this.field_149477_b = posY;
/* 101 */       this.field_149478_c = posZ;
/* 102 */       this.field_149474_g = isOnGround;
/* 103 */       this.field_149480_h = true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_148837_a(PacketBuffer buf) throws IOException {
/* 108 */       this.field_149479_a = buf.readDouble();
/* 109 */       this.field_149477_b = buf.readDouble();
/* 110 */       this.field_149478_c = buf.readDouble();
/* 111 */       super.func_148837_a(buf);
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_148840_b(PacketBuffer buf) throws IOException {
/* 116 */       buf.writeDouble(this.field_149479_a);
/* 117 */       buf.writeDouble(this.field_149477_b);
/* 118 */       buf.writeDouble(this.field_149478_c);
/* 119 */       super.func_148840_b(buf);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class C05PacketPlayerLook
/*     */     extends C03PacketPlayer
/*     */   {
/*     */     public C05PacketPlayerLook() {
/* 127 */       this.field_149481_i = true;
/*     */     }
/*     */ 
/*     */     
/*     */     public C05PacketPlayerLook(float playerYaw, float playerPitch, boolean isOnGround) {
/* 132 */       this.field_149476_e = playerYaw;
/* 133 */       this.field_149473_f = playerPitch;
/* 134 */       this.field_149474_g = isOnGround;
/* 135 */       this.field_149481_i = true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_148837_a(PacketBuffer buf) throws IOException {
/* 140 */       this.field_149476_e = buf.readFloat();
/* 141 */       this.field_149473_f = buf.readFloat();
/* 142 */       super.func_148837_a(buf);
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_148840_b(PacketBuffer buf) throws IOException {
/* 147 */       buf.writeFloat(this.field_149476_e);
/* 148 */       buf.writeFloat(this.field_149473_f);
/* 149 */       super.func_148840_b(buf);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class C06PacketPlayerPosLook
/*     */     extends C03PacketPlayer
/*     */   {
/*     */     public C06PacketPlayerPosLook() {
/* 157 */       this.field_149480_h = true;
/* 158 */       this.field_149481_i = true;
/*     */     }
/*     */ 
/*     */     
/*     */     public C06PacketPlayerPosLook(double playerX, double playerY, double playerZ, float playerYaw, float playerPitch, boolean playerIsOnGround) {
/* 163 */       this.field_149479_a = playerX;
/* 164 */       this.field_149477_b = playerY;
/* 165 */       this.field_149478_c = playerZ;
/* 166 */       this.field_149476_e = playerYaw;
/* 167 */       this.field_149473_f = playerPitch;
/* 168 */       this.field_149474_g = playerIsOnGround;
/* 169 */       this.field_149481_i = true;
/* 170 */       this.field_149480_h = true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_148837_a(PacketBuffer buf) throws IOException {
/* 175 */       this.field_149479_a = buf.readDouble();
/* 176 */       this.field_149477_b = buf.readDouble();
/* 177 */       this.field_149478_c = buf.readDouble();
/* 178 */       this.field_149476_e = buf.readFloat();
/* 179 */       this.field_149473_f = buf.readFloat();
/* 180 */       super.func_148837_a(buf);
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_148840_b(PacketBuffer buf) throws IOException {
/* 185 */       buf.writeDouble(this.field_149479_a);
/* 186 */       buf.writeDouble(this.field_149477_b);
/* 187 */       buf.writeDouble(this.field_149478_c);
/* 188 */       buf.writeFloat(this.field_149476_e);
/* 189 */       buf.writeFloat(this.field_149473_f);
/* 190 */       super.func_148840_b(buf);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\C03PacketPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */