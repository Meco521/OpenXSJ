/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.IIChatComponent;
/*    */ import net.minecraft.client.entity.EntityPlayerSP;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000R\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\007\n\002\b\005\n\002\020\b\n\002\b\006\n\002\020\013\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\t\n\002\020\002\n\000\n\002\030\002\n\002\b\004\n\002\020\016\n\000\b\026\030\000*\b\b\000\020\001*\0020\0022\b\022\004\022\002H\0010\0032\0020\004B\r\022\006\020\005\032\0028\000¢\006\002\020\006J\020\020%\032\0020&2\006\020'\032\0020(H\026J\b\020)\032\0020&H\026J\b\020*\032\0020&H\026J\020\020+\032\0020&2\006\020,\032\0020-H\026R$\020\t\032\0020\b2\006\020\007\032\0020\b8V@VX\016¢\006\f\032\004\b\n\020\013\"\004\b\f\020\rR$\020\017\032\0020\0162\006\020\007\032\0020\0168V@VX\016¢\006\f\032\004\b\020\020\021\"\004\b\022\020\023R\024\020\024\032\0020\0258VX\004¢\006\006\032\004\b\024\020\026R\024\020\027\032\0020\0308VX\004¢\006\006\032\004\b\031\020\032R\024\020\033\032\0020\0348VX\004¢\006\006\032\004\b\035\020\036R$\020\037\032\0020\0252\006\020\007\032\0020\0258V@VX\016¢\006\f\032\004\b \020\026\"\004\b!\020\"R\024\020#\032\0020\0258VX\004¢\006\006\032\004\b$\020\026¨\006."}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/EntityPlayerSPImpl;", "T", "Lnet/minecraft/client/entity/EntityPlayerSP;", "Lnet/ccbluex/liquidbounce/injection/backend/AbstractClientPlayerImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;", "wrapped", "(Lnet/minecraft/client/entity/EntityPlayerSP;)V", "value", "", "horseJumpPower", "getHorseJumpPower", "()F", "setHorseJumpPower", "(F)V", "", "horseJumpPowerCounter", "getHorseJumpPowerCounter", "()I", "setHorseJumpPowerCounter", "(I)V", "isHandActive", "", "()Z", "movementInput", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovementInput;", "getMovementInput", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovementInput;", "sendQueue", "Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;", "getSendQueue", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;", "serverSprintState", "getServerSprintState", "setServerSprintState", "(Z)V", "sneaking", "getSneaking", "addChatMessage", "", "component", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;", "closeScreen", "respawnPlayer", "sendChatMessage", "msg", "", "XSJClient"})
/*    */ public class EntityPlayerSPImpl<T extends EntityPlayerSP> extends AbstractClientPlayerImpl<T> implements IEntityPlayerSP {
/*    */   public EntityPlayerSPImpl(@NotNull EntityPlayerSP wrapped) {
/* 10 */     super((T)wrapped);
/*    */   } public int getHorseJumpPowerCounter() {
/* 12 */     return ((EntityPlayerSP)getWrapped()).field_110320_a;
/*    */   } public void setHorseJumpPowerCounter(int value) {
/* 14 */     ((EntityPlayerSP)getWrapped()).field_110320_a = value;
/*    */   }
/*    */   public float getHorseJumpPower() {
/* 17 */     return ((EntityPlayerSP)getWrapped()).field_110321_bQ;
/*    */   } public void setHorseJumpPower(float value) {
/* 19 */     ((EntityPlayerSP)getWrapped()).field_110321_bQ = value;
/*    */   }
/*    */   
/* 22 */   public boolean isHandActive() { return ((EntityPlayerSP)getWrapped()).func_184587_cr(); }
/*    */   @NotNull
/* 24 */   public IINetHandlerPlayClient getSendQueue() { Intrinsics.checkExpressionValueIsNotNull(((EntityPlayerSP)getWrapped()).field_71174_a, "wrapped.connection"); NetHandlerPlayClient $this$wrap$iv = ((EntityPlayerSP)getWrapped()).field_71174_a; int $i$f$wrap = 0; return 
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
/* 46 */       new INetHandlerPlayClientImpl($this$wrap$iv); } @NotNull public IMovementInput getMovementInput() { Intrinsics.checkExpressionValueIsNotNull(((EntityPlayerSP)getWrapped()).field_71158_b, "wrapped.movementInput"); MovementInput $this$wrap$iv = ((EntityPlayerSP)getWrapped()).field_71158_b; int $i$f$wrap = 0;
/* 47 */     return new MovementInputImpl($this$wrap$iv); } public void addChatMessage(@NotNull IIChatComponent component) { Intrinsics.checkParameterIsNotNull(component, "component"); IIChatComponent iIChatComponent = component; EntityPlayerSP entityPlayerSP = (EntityPlayerSP)getWrapped(); int $i$f$unwrap = 0;
/* 48 */     ITextComponent iTextComponent = ((IChatComponentImpl)iIChatComponent).getWrapped(); entityPlayerSP.func_145747_a(iTextComponent); }
/*    */ 
/*    */   
/*    */   public boolean getSneaking() {
/*    */     return ((EntityPlayerSP)getWrapped()).func_70093_af();
/*    */   }
/*    */   
/*    */   public boolean getServerSprintState() {
/*    */     return ((EntityPlayerSP)getWrapped()).field_175171_bO;
/*    */   }
/*    */   
/*    */   public void setServerSprintState(boolean value) {
/*    */     ((EntityPlayerSP)getWrapped()).field_175171_bO = value;
/*    */   }
/*    */   
/*    */   public void sendChatMessage(@NotNull String msg) {
/*    */     Intrinsics.checkParameterIsNotNull(msg, "msg");
/*    */     ((EntityPlayerSP)getWrapped()).func_71165_d(msg);
/*    */   }
/*    */   
/*    */   public void respawnPlayer() {
/*    */     ((EntityPlayerSP)getWrapped()).func_71004_bE();
/*    */   }
/*    */   
/*    */   public void closeScreen() {
/*    */     ((EntityPlayerSP)getWrapped()).func_71053_j();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\EntityPlayerSPImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */