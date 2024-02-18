/*    */ package net.ccbluex.liquidbounce.features.module.modules.player;
/*    */ import java.util.Random;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*    */ import net.ccbluex.liquidbounce.event.AttackEvent;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.TextValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @ModuleInfo(name = "AutoL", category = ModuleCategory.PLAYER, description = "修复版")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000B\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\005\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\006\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\006\020\027\032\0020\bJ\020\020\030\032\0020\0312\006\020\032\032\0020\033H\007J\020\020\034\032\0020\0312\006\020\032\032\0020\035H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\032\020\007\032\0020\bX\016¢\006\016\n\000\032\004\b\t\020\n\"\004\b\013\020\fR\026\020\r\032\004\030\0010\0168VX\004¢\006\006\032\004\b\017\020\020R\034\020\021\032\004\030\0010\022X\016¢\006\016\n\000\032\004\b\023\020\024\"\004\b\025\020\026¨\006\036"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/player/AutoL;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "AutoLmsg", "Lnet/ccbluex/liquidbounce/value/TextValue;", "L", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "kill", "", "getKill", "()I", "setKill", "(I)V", "tag", "", "getTag", "()Ljava/lang/String;", "target", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "getTarget", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "setTarget", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)V", "kills", "onAttack", "", "event", "Lnet/ccbluex/liquidbounce/event/AttackEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class AutoL extends Module {
/* 16 */   private final BoolValue L = new BoolValue("L", true);
/* 17 */   private final TextValue AutoLmsg = new TextValue("AutoLmsg", "@[Retreat]"); @Nullable
/*    */   private IEntityLivingBase target; private int kill; @Nullable
/* 19 */   public final IEntityLivingBase getTarget() { return this.target; } public final void setTarget(@Nullable IEntityLivingBase <set-?>) { this.target = <set-?>; }
/* 20 */   public final int getKill() { return this.kill; } public final void setKill(int <set-?>) { this.kill = <set-?>; }
/*    */   
/*    */   @EventTarget
/*    */   public final void onAttack(@NotNull AttackEvent event) {
/* 24 */     Intrinsics.checkParameterIsNotNull(event, "event"); this.target = (IEntityLivingBase)event.getTargetEntity();
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 29 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (this.target == null) Intrinsics.throwNpe();  if (this.target.getHealth() <= 0.1D) {
/* 30 */       this.kill++;
/* 31 */       if (((Boolean)this.L.get()).booleanValue()) {
/* 32 */         Random r = new Random();
/* 33 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().sendChatMessage((String)this.AutoLmsg.get() + "我已经击杀了" + this.kill + "人 ");
/*    */       } 
/* 35 */       this.target = (IEntityLivingBase)null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public final int kills() {
/* 40 */     return this.kill;
/*    */   } @Nullable
/*    */   public String getTag() {
/* 43 */     return "Kill " + this.kill;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\player\AutoL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */