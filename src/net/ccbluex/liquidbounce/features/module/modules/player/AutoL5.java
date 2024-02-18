/*     */ package net.ccbluex.liquidbounce.features.module.modules.player;
/*     */ import java.util.Random;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.event.AttackEvent;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.MSTimer;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.autoL;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.ccbluex.liquidbounce.value.TextValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @ModuleInfo(name = "AutoL5", description = "AutoL5. ", category = ModuleCategory.PLAYER)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000h\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\021\n\002\020\016\n\002\b\006\n\002\030\002\n\002\b\004\n\002\020\b\n\002\b\b\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\0202\032\002032\006\0204\032\00205H\007J\022\0206\032\002032\b\0204\032\004\030\00107H\007R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\"\020\t\032\b\022\004\022\0020\0130\nX\016¢\006\020\n\002\020\020\032\004\b\f\020\r\"\004\b\016\020\017R\016\020\021\032\0020\022X\004¢\006\002\n\000R\"\020\023\032\b\022\004\022\0020\0130\nX\016¢\006\020\n\002\020\020\032\004\b\024\020\r\"\004\b\025\020\017R\032\020\026\032\0020\027X\016¢\006\016\n\000\032\004\b\030\020\031\"\004\b\032\020\033R\032\020\034\032\0020\027X\016¢\006\016\n\000\032\004\b\035\020\031\"\004\b\036\020\033R\021\020\037\032\0020 ¢\006\b\n\000\032\004\b!\020\"R\021\020#\032\0020$¢\006\b\n\000\032\004\b%\020&R\021\020'\032\0020(¢\006\b\n\000\032\004\b)\020*R\016\020+\032\0020,X\004¢\006\002\n\000R\024\020-\032\0020\0138VX\004¢\006\006\032\004\b.\020/R\020\0200\032\004\030\00101X\016¢\006\002\n\000¨\0068"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/player/AutoL5;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "R", "Ljava/util/Random;", "getR", "()Ljava/util/Random;", "setR", "(Ljava/util/Random;)V", "abuse", "", "", "getAbuse", "()[Ljava/lang/String;", "setAbuse", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "delay", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "englishabuse", "getEnglishabuse", "setEnglishabuse", "index", "", "getIndex", "()I", "setIndex", "(I)V", "kill", "getKill", "setKill", "lobbyValue", "Lnet/ccbluex/liquidbounce/value/TextValue;", "getLobbyValue", "()Lnet/ccbluex/liquidbounce/value/TextValue;", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "getModeValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "msTimer", "Lnet/ccbluex/liquidbounce/utils/MSTimer;", "getMsTimer", "()Lnet/ccbluex/liquidbounce/utils/MSTimer;", "prefix", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "tag", "getTag", "()Ljava/lang/String;", "target", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "onAttack", "", "event", "Lnet/ccbluex/liquidbounce/event/AttackEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class AutoL5 extends Module {
/*     */   @NotNull
/*  23 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "Chinese", "English", "zhuboMessage", "yurluMessage", "YuJiangJun", "Ikun", "L", "None", "Text" }, "None"); @NotNull public final ListValue getModeValue() { return this.modeValue; } @NotNull
/*  24 */   private final TextValue lobbyValue = new TextValue("Text", "XSJ Client 2023/Genuine edition"); @NotNull public final TextValue getLobbyValue() { return this.lobbyValue; }
/*  25 */    private final BoolValue prefix = new BoolValue("@", true);
/*  26 */   private final IntegerValue delay = new IntegerValue("Delay", 100, 0, 2000);
/*  27 */   private int index; public final int getIndex() { return this.index; } public final void setIndex(int <set-?>) { this.index = <set-?>; } @NotNull
/*  28 */   private Random R = new Random(); @NotNull public final Random getR() { return this.R; } public final void setR(@NotNull Random <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.R = <set-?>; } @NotNull
/*  29 */   private String[] abuse = new String[] { "XSJ Client 2023/Genuine edition" }; @NotNull public final String[] getAbuse() { return this.abuse; } public final void setAbuse(@NotNull String[] <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.abuse = <set-?>; } @NotNull
/*  30 */   private String[] englishabuse = new String[] { "You are loser" }; private IEntity target; private int kill; @NotNull public final String[] getEnglishabuse() { return this.englishabuse; } public final void setEnglishabuse(@NotNull String[] <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.englishabuse = <set-?>; }
/*     */   
/*  32 */   public final int getKill() { return this.kill; } public final void setKill(int <set-?>) { this.kill = <set-?>; } @NotNull
/*  33 */   private final MSTimer msTimer = new MSTimer(); @NotNull public final MSTimer getMsTimer() { return this.msTimer; }
/*     */    @EventTarget
/*     */   public final void onAttack(@NotNull AttackEvent event) {
/*  36 */     Intrinsics.checkParameterIsNotNull(event, "event"); this.target = event.getTargetEntity();
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@Nullable UpdateEvent event) {
/*  41 */     if (this.target != null) {
/*  42 */       if (this.target == null) Intrinsics.throwNpe();  if (this.target.isDead() && 
/*  43 */         this.msTimer.hasTimePassed(((Number)this.delay.get()).intValue())) {
/*  44 */         int i; this.index = (i = this.index) + 1;
/*  45 */         String str = (String)this.modeValue.get(); switch (str.hashCode())
/*     */         
/*     */         { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case 60895824:
/*  76 */             if (str.equals("English"))
/*  77 */             { this.kill++;
/*  78 */               if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().sendChatMessage((((Boolean)this.prefix.get()).booleanValue() ? "@" : "") + "  " + this.englishabuse[this.R.nextInt(
/*  79 */                       this.englishabuse.length)]);
/*     */ 
/*     */               
/*  82 */               this.target = (IEntity)null; }  break;case 454896168: if (str.equals("yurluMessage")) { if (this.index > autoL.yurluMessage.length)
/*     */                 this.index = 0;  if (MinecraftInstance.mc.getThePlayer() == null)
/*     */                 Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().sendChatMessage((((Boolean)this.prefix.get()).booleanValue() ? "@" : "") + " " + autoL.yurluMessage[this.index]); this.kill++; this.target = (IEntity)null; }  break;
/*     */           case -1883983667: if (str.equals("Chinese")) { if (MinecraftInstance.mc.getThePlayer() == null)
/*     */                 Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().sendChatMessage((((Boolean)this.prefix.get()).booleanValue() ? "@" : "") + ":" + this.abuse[this.R.nextInt(this.abuse.length)]); this.kill++; this.target = (IEntity)null; }  break;
/*     */           case 907717587: if (str.equals("zhuboMessage")) { if (this.index > autoL.zhuboMessage.length)
/*     */                 this.index = 0;  if (MinecraftInstance.mc.getThePlayer() == null)
/*     */                 Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().sendChatMessage((((Boolean)this.prefix.get()).booleanValue() ? "@" : "") + " " + autoL.zhuboMessage[this.index]); this.kill++; this.target = (IEntity)null; }  break;
/*     */           case 2281307: if (str.equals("Ikun")) { if (this.index > autoL.Ikun.length)
/*     */                 this.index = 0;  if (MinecraftInstance.mc.getThePlayer() == null)
/*     */                 Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().sendChatMessage((((Boolean)this.prefix.get()).booleanValue() ? "@" : "") + " " + autoL.Ikun[this.index]); this.kill++; this.target = (IEntity)null; }  break;
/*  93 */           case 2603341: if (str.equals("Text"))
/*  94 */             { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (this.target == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().sendChatMessage((((Boolean)this.prefix.get()).booleanValue() ? "@" : "") + (String)this.lobbyValue.get() + " [" + this.target.getName() + "]");
/*  95 */               this.kill++;
/*  96 */               this.target = (IEntity)null; }  break;case 370702756: if (str.equals("YuJiangJun")) { if (this.index > autoL.YuJiangJun.length) this.index = 0;  if (MinecraftInstance.mc.getThePlayer() == null)
/*     */                 Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().sendChatMessage((((Boolean)this.prefix.get()).booleanValue() ? "@" : "") + " " + autoL.YuJiangJun[this.index]); this.kill++; this.target = (IEntity)null; }  break;case 76: if (str.equals("L")) { if (MinecraftInstance.mc.getThePlayer() == null)
/*     */                 Intrinsics.throwNpe();  if (this.target == null)
/*  99 */                 Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().sendChatMessage((((Boolean)this.prefix.get()).booleanValue() ? "@" : "") + " L " + this.target.getName()); this.kill++; this.target = (IEntity)null; }  break;case 2433880: if (str.equals("None")) { this.kill++; this.target = (IEntity)null; }  break; }  this.msTimer.reset();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   @NotNull
/*     */   public String getTag() {
/* 105 */     return "Kills%" + this.kill;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\player\AutoL5.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */