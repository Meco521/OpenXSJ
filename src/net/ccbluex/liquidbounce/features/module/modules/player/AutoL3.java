/*     */ package net.ccbluex.liquidbounce.features.module.modules.player;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.event.AttackEvent;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.TextValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @ModuleInfo(name = "AutoL3", description = "自动骂人", category = ModuleCategory.PLAYER)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000t\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020!\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\013\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020\b\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\017\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\006\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020*\032\0020\023H\002J\020\020+\032\0020,2\006\020-\032\0020.H\007J\020\020/\032\0020,2\006\020-\032\00200H\007J\020\0201\032\0020,2\006\020-\032\00202H\007J\020\0203\032\0020,2\006\020-\032\00204H\007J\020\0205\032\0020,2\006\0206\032\0020\023H\002J\020\0207\032\0020,2\006\0206\032\0020\023H\002J\b\0208\032\0020,H\002J\006\0209\032\0020,R\024\020\003\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\n\032\0020\013X\004¢\006\002\n\000R\016\020\f\032\0020\007X\004¢\006\002\n\000R\016\020\r\032\0020\007X\004¢\006\002\n\000R\016\020\016\032\0020\017X\016¢\006\002\n\000R\016\020\020\032\0020\021X\004¢\006\002\n\000R\024\020\022\032\b\022\004\022\0020\0230\004X\016¢\006\002\n\000R\016\020\024\032\0020\025X\016¢\006\002\n\000R\016\020\026\032\0020\tX\004¢\006\002\n\000R\016\020\027\032\0020\030X\004¢\006\002\n\000R\016\020\031\032\0020\tX\004¢\006\002\n\000R\016\020\032\032\0020\007X\004¢\006\002\n\000R\016\020\033\032\0020\034X\004¢\006\002\n\000R\016\020\035\032\0020\034X\004¢\006\002\n\000R\024\020\036\032\0020\0238VX\004¢\006\006\032\004\b\037\020 R\034\020!\032\004\030\0010\005X\016¢\006\016\n\000\032\004\b\"\020#\"\004\b$\020%R\016\020&\032\0020\025X\016¢\006\002\n\000R\016\020'\032\0020\023X\016¢\006\002\n\000R\016\020(\032\0020\034X\004¢\006\002\n\000R\016\020)\032\0020\007X\004¢\006\002\n\000¨\006:"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/player/AutoL3;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "attackedEntityList", "", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "chatTotalKill", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "delay", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "delayValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "enableHYTAtall", "enablement", "inCombat", "", "insultFile", "Ljava/io/File;", "insultWords", "", "kill", "", "lastAttackTimer", "mode", "Lnet/ccbluex/liquidbounce/value/ListValue;", "ms", "showNotification", "suffixTextAfterRecord", "Lnet/ccbluex/liquidbounce/value/TextValue;", "suffixTextBeforeRecord", "tag", "getTag", "()Ljava/lang/String;", "target", "getTarget", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "setTarget", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V", "tempkill", "text", "textValue", "waterMark", "getRandomOne", "onAttack", "", "event", "Lnet/ccbluex/liquidbounce/event/AttackEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "onWorld", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "playerChat", "name", "playerDeathEvent", "replaceFilterWords", "resetAttackedList", "XSJClient"})
/*     */ public final class AutoL3 extends Module {
/*  22 */   private final BoolValue enablement = new BoolValue("EnableAutoL", true);
/*  23 */   private final IntegerValue delayValue = new IntegerValue("ChatDelay", 3000, 2400, 6000);
/*  24 */   private final ListValue mode = new ListValue("Mode", new String[] { "WithWords", "RawWord", "Clear", "Custom", "HeyGuy" }, "Clear");
/*  25 */   private final BoolValue waterMark = new BoolValue("WaterMark", true);
/*  26 */   private final BoolValue enableHYTAtall = new BoolValue("Prefix@", true);
/*  27 */   private final TextValue textValue = new TextValue("Text", "ExampleChat");
/*  28 */   private final BoolValue chatTotalKill = new BoolValue("ChatTotalKill", false);
/*  29 */   private final TextValue suffixTextBeforeRecord = new TextValue("TextBeforeKillRecord", "我已经击杀了");
/*  30 */   private final TextValue suffixTextAfterRecord = new TextValue("TextAfterKillRecord", "人!");
/*  31 */   private final BoolValue showNotification = new BoolValue("ShowNotificationsOnKill", false);
/*     */ 
/*     */   
/*  34 */   private final MSTimer lastAttackTimer = new MSTimer(); @Nullable private IEntity target; private int kill; private int tempkill; @Nullable
/*  35 */   public final IEntity getTarget() { return this.target; } public final void setTarget(@Nullable IEntity <set-?>) { this.target = <set-?>; }
/*     */ 
/*     */   
/*  38 */   private String text = ""; private boolean inCombat; private final List<IEntity> attackedEntityList; private final File insultFile; private List<String> insultWords; private final MSTimer ms; private final MSTimer delay;
/*     */   public AutoL3() {
/*  40 */     AutoL3 autoL3 = this; boolean bool = false; ArrayList<IEntity> arrayList = new ArrayList();
/*  41 */     this.insultFile = new File((Retreat.INSTANCE.getFileManager()).dir, "filter.json");
/*  42 */     autoL3 = this; bool = false; autoL3.insultWords = (List)(arrayList = new ArrayList<>());
/*  43 */     this.ms = new MSTimer();
/*  44 */     this.delay = new MSTimer();
/*     */   }
/*     */   @EventTarget
/*     */   public final void onAttack(@NotNull AttackEvent event) {
/*  48 */     Intrinsics.checkParameterIsNotNull(event, "event"); IEntity target = event.getTargetEntity();
/*     */     
/*  50 */     if (target instanceof IEntity && EntityUtils.isSelected(target, true)) {
/*  51 */       this.target = target;
/*  52 */       if (!this.attackedEntityList.contains(target)) {
/*  53 */         this.attackedEntityList.add(target);
/*     */       }
/*     */     } 
/*  56 */     this.lastAttackTimer.reset();
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/*  61 */     Intrinsics.checkParameterIsNotNull(event, "event"); Iterable<IEntity> $this$filter$iv = this.attackedEntityList; int $i$f$filter = 0;
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
/*     */ 
/*     */ 
/*     */     
/* 173 */     Iterable<IEntity> iterable1 = $this$filter$iv; Collection<Object> destination$iv$iv = new ArrayList(); int $i$f$filterTo = 0;
/* 174 */     for (IEntity element$iv$iv : iterable1) { IEntity it = element$iv$iv; int $i$a$-filter-AutoL3$onUpdate$1 = 0; if (it.isDead())
/* 175 */         destination$iv$iv.add(element$iv$iv);  }  Iterable $this$forEach$iv = destination$iv$iv; int $i$f$forEach = 0;
/* 176 */     Iterator iterator = $this$forEach$iv.iterator(); if (iterator.hasNext()) { Object element$iv = iterator.next(); IEntity it = (IEntity)element$iv; int $i$a$-forEach-AutoL3$onUpdate$2 = 0;
/*     */       if (it.getName() == null)
/*     */         Intrinsics.throwNpe();  }
/*     */     
/*     */     this.inCombat = false;
/*     */     if (!this.lastAttackTimer.hasTimePassed(1000L)) {
/*     */       this.inCombat = true;
/*     */       return;
/*     */     } 
/*     */     if (this.target != null) {
/*     */       if (MinecraftInstance.mc.getThePlayer() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       if (this.target == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       if (MinecraftInstance.mc.getThePlayer().getDistanceToEntity(this.target) <= 7 && this.inCombat) {
/*     */         if (this.target == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         if (this.target.isDead()) {
/*     */           this.target = (IEntity)null;
/*     */           return;
/*     */         } 
/*     */         this.inCombat = true;
/*     */         return;
/*     */       } 
/*     */     } else {
/*     */       return;
/*     */     } 
/*     */     this.target = (IEntity)null;
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/*     */     Intrinsics.checkParameterIsNotNull(event, "event");
/*     */     IPacket packet = event.getPacket();
/*     */     Intrinsics.checkExpressionValueIsNotNull(((SPacketChat)packet).func_148915_c(), "packet.chatComponent");
/*     */     String chat = ((SPacketChat)packet).func_148915_c().func_150260_c();
/*     */     Intrinsics.checkExpressionValueIsNotNull(chat, "chat");
/*     */     if (packet instanceof SPacketChat && StringsKt.contains$default(chat, "起床战争", false, 2, null) && StringsKt.contains$default(chat, ">>", false, 2, null) && StringsKt.contains$default(chat, "游戏开始", false, 2, null))
/*     */       this.attackedEntityList.clear(); 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onWorld(@NotNull WorldEvent event) {
/*     */     Intrinsics.checkParameterIsNotNull(event, "event");
/*     */     this.inCombat = false;
/*     */     this.target = (IEntity)null;
/*     */     this.attackedEntityList.clear();
/*     */   }
/*     */   
/*     */   private final void playerDeathEvent(String name) {
/*     */     int i;
/*     */     this.kill = (i = this.kill) + 1;
/*     */     Recorder.INSTANCE.setKillCounts((i = Recorder.INSTANCE.getKillCounts()) + 1);
/*     */     this.tempkill = (i = this.tempkill) + 1;
/*     */     if (this.delay.hasTimePassed(((Number)this.delayValue.get()).intValue())) {
/*     */       playerChat(name);
/*     */       this.delay.reset();
/*     */     } 
/*     */   }
/*     */   
/*     */   private final void playerChat(String name) {
/*     */     if (((Boolean)this.enablement.get()).booleanValue()) {
/*     */       String str = (String)this.mode.get();
/*     */       boolean bool = false;
/*     */       if (str == null)
/*     */         throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */       Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()");
/*     */       str = str.toLowerCase();
/*     */       switch (str.hashCode()) {
/*     */         case -1220552529:
/*     */           if (str.equals("heyguy")) {
/*     */             int a = (int)(Math.random() * 12);
/*     */             switch (a) {
/*     */               case 1:
/*     */                 this.text = "Ｌ " + name + " | 嗨，我是风动，这是我的neibu神器，3000收neibu是我的秘密武器，花钱一分钟，赚钱两个月，不要告诉别人哦";
/*     */                 break;
/*     */               case 2:
/*     */                 this.text = "Ｌ " + name + " | 嗨，我是Pro，这是我的neibu神器，200整30个conf是我的秘密武器，花钱一分钟，赚钱两年半，不要告诉别人哦";
/*     */                 break;
/*     */               case 3:
/*     */                 this.text = "Ｌ " + name + " | 嗨，我是瓦瓦，这是我的pride+神器，grimvel是我的秘密武器，vel一分钟，死号两小时，不要告诉瓦瓦哦";
/*     */                 break;
/*     */               case 4:
/*     */                 this.text = "Ｌ " + name + " | 嗨，我是_RyF,这是我的彩色字节，彩色字节是我的秘密武器，出击一分钟，殴打两小时，不要告诉瓦瓦哦";
/*     */                 break;
/*     */               case 5:
/*     */                 this.text = "Ｌ " + name + " | 嗨，我是小手冰凉,这是我的CoolSense，CoolSense是我的秘密武器，出击一分钟，殴打两小时，不要告诉小手哦";
/*     */                 break;
/*     */               case 6:
/*     */                 this.text = "Ｌ " + name + " | 嗨，我是风动，这是我的抽烟神器，3000买下锐刻114514代是我的秘密武器，花钱一秒钟，抽烟一辈子，不要告诉丁真哦";
/*     */                 break;
/*     */               case 7:
/*     */                 this.text = "Ｌ " + name + " | 嗨，我是狼牙，这是我的狼牙神器，一定是狼牙干的是我的秘密武器，花钱一秒钟，抽烟一辈子，不要告诉xiatian哦";
/*     */                 break;
/*     */               case 8:
/*     */                 this.text = "Ｌ " + name + " | 嗨，我是原批，这是我的启动神器，你说的对，但是原神启动是我的秘密武器，启动十分钟，充电五小时，不要告诉别人哦";
/*     */                 break;
/*     */               case 9:
/*     */                 this.text = "Ｌ " + name + " | 嗨，我是SLA，这是我的开户神器，开假户是我的秘密武器，假户十分钟，高兴一个月，不要告诉李瓦琦哦";
/*     */                 break;
/*     */               case 10:
/*     */                 this.text = "Ｌ " + name + " | 嗨，我是小职，这是我的cookies神器，3000+cookies是我的秘密武器，获取一秒钟，游戏一小时，不要告诉别人哦";
/*     */                 break;
/*     */               case 11:
/*     */                 this.text = "Ｌ " + name + " | 嗨，我是回想，这是我的fix神器，fix各种端是我的秘密武器，fix一小时，高兴一个月，不要告诉别人哦";
/*     */                 break;
/*     */               case 12:
/*     */                 this.text = "Ｌ " + name + " | 嗨，我是刘梦(执剑)，这是我的圈钱神器，圈钱造谣自大是我的秘密武器，圈钱一秒钟，高兴一个月，不要告诉别人哦";
/*     */                 break;
/*     */             } 
/*     */           } 
/*     */           break;
/*     */         case 525613953:
/*     */           if (str.equals("rawwords"))
/*     */             this.text = getRandomOne(); 
/*     */           break;
/*     */         case 934737315:
/*     */           if (str.equals("withwords"))
/*     */             this.text = "Ｌ " + name + " | " + getRandomOne(); 
/*     */           break;
/*     */         case -1349088399:
/*     */           if (str.equals("custom")) {
/*     */             this.text = (String)this.textValue.get();
/*     */             this.text = StringsKt.replace$default(this.text, "%name%", name, false, 4, null);
/*     */             this.text += ' ';
/*     */           } 
/*     */           break;
/*     */         case 94746189:
/*     */           if (str.equals("clear"))
/*     */             this.text = "Ｌ " + name; 
/*     */           break;
/*     */       } 
/*     */       replaceFilterWords();
/*     */       if (((Boolean)this.chatTotalKill.get()).booleanValue())
/*     */         this.text += " | " + (String)this.suffixTextBeforeRecord.get() + this.kill + (String)this.suffixTextAfterRecord.get(); 
/*     */       if (((Boolean)this.waterMark.get()).booleanValue())
/*     */         this.text = "[XSJ Client] " + this.text; 
/*     */       if (((Boolean)this.enableHYTAtall.get()).booleanValue())
/*     */         this.text = "@a" + this.text; 
/*     */       if (MinecraftInstance.mc.getThePlayer() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       MinecraftInstance.mc.getThePlayer().sendChatMessage(this.text);
/*     */     } 
/*     */   }
/*     */   
/*     */   private final String getRandomOne() {
/*     */     return this.insultWords.get(RandomUtils.nextInt(0, this.insultWords.size() - 1));
/*     */   }
/*     */   
/*     */   public final void resetAttackedList() {
/*     */     this.attackedEntityList.clear();
/*     */   }
/*     */   
/*     */   private final void replaceFilterWords() {
/*     */     this.text = StringsKt.replace$default(this.text, "%L%", "Ｌ", false, 4, null);
/*     */     this.text = StringsKt.replace$default(this.text, "%l%", "Ｌ", false, 4, null);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getTag() {
/*     */     return "Kills " + this.kill;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\player\AutoL3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */