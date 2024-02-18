/*     */ package net.ccbluex.liquidbounce.features.module.modules.misc;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.IEntityPlayer;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.network.INetworkPlayerInfo;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.play.server.ISPacketEntity;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.extensions.NetworkPlayerInfoKt;
/*     */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "AntiBot", description = "Prevents KillAura from attacking AntiCheat bots.", category = ModuleCategory.MISC)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000f\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020!\n\002\020\b\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\013\n\002\020%\n\002\b\003\n\002\030\002\n\002\b\007\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\020\013\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\bÇ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\b\020%\032\0020&H\002J\020\020'\032\0020(2\006\020)\032\0020*H\007J\020\020+\032\0020&2\006\020,\032\0020-H\007J\b\020.\032\0020&H\026J\020\020/\032\0020&2\006\0200\032\00201H\007J\022\0202\032\0020&2\b\0200\032\004\030\00103H\007R\024\020\003\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\b\032\0020\007X\004¢\006\002\n\000R\016\020\t\032\0020\nX\004¢\006\002\n\000R\016\020\013\032\0020\007X\004¢\006\002\n\000R\016\020\f\032\0020\007X\004¢\006\002\n\000R\016\020\r\032\0020\007X\004¢\006\002\n\000R\016\020\016\032\0020\007X\004¢\006\002\n\000R\016\020\017\032\0020\007X\004¢\006\002\n\000R\016\020\020\032\0020\007X\004¢\006\002\n\000R\024\020\021\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\016\020\022\032\0020\007X\004¢\006\002\n\000R\016\020\023\032\0020\007X\004¢\006\002\n\000R\024\020\024\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\032\020\025\032\016\022\004\022\0020\005\022\004\022\0020\0050\026X\004¢\006\002\n\000R\016\020\027\032\0020\007X\004¢\006\002\n\000R\024\020\030\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\016\020\031\032\0020\032X\004¢\006\002\n\000R\016\020\033\032\0020\007X\004¢\006\002\n\000R\016\020\034\032\0020\007X\004¢\006\002\n\000R\024\020\035\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\016\020\036\032\0020\007X\004¢\006\002\n\000R\024\020\037\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\016\020 \032\0020\007X\004¢\006\002\n\000R\016\020!\032\0020\"X\004¢\006\002\n\000R\016\020#\032\0020\007X\004¢\006\002\n\000R\016\020$\032\0020\007X\004¢\006\002\n\000¨\0064"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/misc/AntiBot;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "air", "", "", "airValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "allwaysInRadiusValue", "allwaysRadiusValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "armorValue", "colorValue", "derpValue", "duplicateInTabValue", "duplicateInWorldValue", "entityIDValue", "ground", "groundValue", "healthValue", "hitted", "invalidGround", "", "invalidGroundValue", "invisible", "livingTimeTicksValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "livingTimeValue", "needHitValue", "notAlwaysInRadius", "pingValue", "swing", "swingValue", "tabModeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "tabValue", "wasInvisibleValue", "clearAll", "", "isBot", "", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "onAttack", "e", "Lnet/ccbluex/liquidbounce/event/AttackEvent;", "onDisable", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onWorld", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "XSJClient"})
/*     */ public final class AntiBot extends Module {
/*     */   static {
/*  24 */     AntiBot antiBot = new AntiBot();
/*     */   }
/*  26 */   private static final BoolValue tabValue = new BoolValue("Tab", true);
/*  27 */   private static final ListValue tabModeValue = new ListValue("TabMode", new String[] { "Equals", "Contains" }, "Contains");
/*  28 */   private static final BoolValue entityIDValue = new BoolValue("EntityID", true);
/*  29 */   private static final BoolValue colorValue = new BoolValue("Color", false);
/*  30 */   private static final BoolValue livingTimeValue = new BoolValue("LivingTime", false);
/*  31 */   private static final IntegerValue livingTimeTicksValue = new IntegerValue("LivingTimeTicks", 40, 1, 200);
/*  32 */   private static final BoolValue groundValue = new BoolValue("Ground", true);
/*  33 */   private static final BoolValue airValue = new BoolValue("Air", false);
/*  34 */   private static final BoolValue invalidGroundValue = new BoolValue("InvalidGround", true);
/*  35 */   private static final BoolValue swingValue = new BoolValue("Swing", false);
/*  36 */   private static final BoolValue healthValue = new BoolValue("Health", false);
/*  37 */   private static final BoolValue derpValue = new BoolValue("Derp", true);
/*  38 */   private static final BoolValue wasInvisibleValue = new BoolValue("WasInvisible", false);
/*  39 */   private static final BoolValue armorValue = new BoolValue("Armor", false);
/*  40 */   private static final BoolValue pingValue = new BoolValue("Ping", false);
/*  41 */   private static final BoolValue needHitValue = new BoolValue("NeedHit", false);
/*  42 */   private static final BoolValue duplicateInWorldValue = new BoolValue("DuplicateInWorld", false);
/*  43 */   private static final BoolValue duplicateInTabValue = new BoolValue("DuplicateInTab", false);
/*  44 */   private static final BoolValue allwaysInRadiusValue = new BoolValue("AlwaysInRadius", false);
/*  45 */   private static final FloatValue allwaysRadiusValue = new FloatValue("AlwaysInRadiusBlocks", 20.0F, 5.0F, 30.0F);
/*     */   
/*  47 */   private static final List<Integer> ground = new ArrayList<>(); static { boolean bool = false; }
/*  48 */    private static final List<Integer> air = new ArrayList<>(); static { bool = false; }
/*  49 */    private static final Map<Integer, Integer> invalidGround = new LinkedHashMap<>(); static { bool = false; }
/*  50 */    private static final List<Integer> swing = new ArrayList<>(); static { bool = false; }
/*  51 */    private static final List<Integer> invisible = new ArrayList<>(); static { bool = false; }
/*  52 */    private static final List<Integer> hitted = new ArrayList<>(); static { bool = false; }
/*  53 */    private static final List<Integer> notAlwaysInRadius = new ArrayList<>(); public static final AntiBot INSTANCE; static { bool = false; }
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   public static final boolean isBot(@NotNull IEntityLivingBase entity) {
/*  58 */     Intrinsics.checkParameterIsNotNull(entity, "entity"); if (!MinecraftInstance.classProvider.isEntityPlayer(entity)) {
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     if (!INSTANCE.getState()) {
/*  63 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  67 */     if (((Boolean)colorValue.get()).booleanValue()) { if (entity.getDisplayName() == null) Intrinsics.throwNpe();  if (!StringsKt.contains$default(StringsKt.replace$default(entity.getDisplayName().getFormattedText(), "§r", "", false, 4, null), "§", false, 2, null))
/*  68 */         return true;  }
/*     */     
/*  70 */     if (((Boolean)livingTimeValue.get()).booleanValue() && entity.getTicksExisted() < ((Number)livingTimeTicksValue.get()).intValue()) {
/*  71 */       return true;
/*     */     }
/*  73 */     if (((Boolean)groundValue.get()).booleanValue() && !ground.contains(Integer.valueOf(entity.getEntityId()))) {
/*  74 */       return true;
/*     */     }
/*  76 */     if (((Boolean)airValue.get()).booleanValue() && !air.contains(Integer.valueOf(entity.getEntityId()))) {
/*  77 */       return true;
/*     */     }
/*  79 */     if (((Boolean)swingValue.get()).booleanValue() && !swing.contains(Integer.valueOf(entity.getEntityId()))) {
/*  80 */       return true;
/*     */     }
/*  82 */     if (((Boolean)healthValue.get()).booleanValue() && entity.getHealth() > 20.0F) {
/*  83 */       return true;
/*     */     }
/*  85 */     if (((Boolean)entityIDValue.get()).booleanValue() && (entity.getEntityId() >= 1000000000 || entity.getEntityId() <= -1)) {
/*  86 */       return true;
/*     */     }
/*  88 */     if (((Boolean)derpValue.get()).booleanValue() && (entity.getRotationPitch() > 90.0F || entity.getRotationPitch() < -90.0F)) {
/*  89 */       return true;
/*     */     }
/*  91 */     if (((Boolean)wasInvisibleValue.get()).booleanValue() && invisible.contains(Integer.valueOf(entity.getEntityId()))) {
/*  92 */       return true;
/*     */     }
/*  94 */     if (((Boolean)armorValue.get()).booleanValue()) {
/*  95 */       IEntityPlayer player = entity.asEntityPlayer();
/*     */       
/*  97 */       if (player.getInventory().getArmorInventory().get(0) == null && player.getInventory().getArmorInventory().get(1) == null && 
/*  98 */         player.getInventory().getArmorInventory().get(2) == null && player.getInventory().getArmorInventory().get(3) == null) {
/*  99 */         return true;
/*     */       }
/*     */     } 
/* 102 */     if (((Boolean)pingValue.get()).booleanValue())
/* 103 */       if (MinecraftInstance.mc.getNetHandler().getPlayerInfo(entity.asEntityPlayer().getUniqueID()) != null) { if (MinecraftInstance.mc.getNetHandler().getPlayerInfo(entity.asEntityPlayer().getUniqueID()).getResponseTime() == 0)
/* 104 */           return true;  }
/*     */       else
/*     */       { MinecraftInstance.mc.getNetHandler().getPlayerInfo(entity.asEntityPlayer().getUniqueID()); }
/* 107 */         if (((Boolean)needHitValue.get()).booleanValue() && !hitted.contains(Integer.valueOf(entity.getEntityId()))) {
/* 108 */       return true;
/*     */     }
/* 110 */     if (((Boolean)invalidGroundValue.get()).booleanValue() && ((Number)invalidGround.getOrDefault(Integer.valueOf(entity.getEntityId()), (V)Integer.valueOf(0))).intValue() >= 10) {
/* 111 */       return true;
/*     */     }
/* 113 */     if (((Boolean)tabValue.get()).booleanValue()) {
/* 114 */       boolean equals = StringsKt.equals((String)tabModeValue.get(), "Equals", true);
/* 115 */       if (entity.getDisplayName() == null) Intrinsics.throwNpe();  String targetName = ColorUtils.stripColor(entity.getDisplayName().getFormattedText());
/*     */       
/* 117 */       if (targetName != null) {
/* 118 */         for (INetworkPlayerInfo networkPlayerInfo : MinecraftInstance.mc.getNetHandler().getPlayerInfoMap()) {
/* 119 */           if (ColorUtils.stripColor(NetworkPlayerInfoKt.getFullName(networkPlayerInfo)) != null) { String networkName = ColorUtils.stripColor(NetworkPlayerInfoKt.getFullName(networkPlayerInfo));
/*     */             
/* 121 */             if (equals ? Intrinsics.areEqual(targetName, networkName) : StringsKt.contains$default(targetName, networkName, false, 2, null))
/* 122 */               return false;  continue; }
/*     */            ColorUtils.stripColor(NetworkPlayerInfoKt.getFullName(networkPlayerInfo));
/*     */         } 
/* 125 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 129 */     if (((Boolean)duplicateInWorldValue.get()).booleanValue())
/* 130 */     { if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  Iterable $this$filter$iv = MinecraftInstance.mc.getTheWorld().getLoadedEntityList(); int $i$f$filter = 0;
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
/* 218 */       Iterable iterable1 = $this$filter$iv; Collection<Object> destination$iv$iv = new ArrayList(); int $i$f$filterTo = 0;
/* 219 */       for (Object element$iv$iv : iterable1) { IEntity it = (IEntity)element$iv$iv; int $i$a$-filter-AntiBot$isBot$1 = 0; if ((MinecraftInstance.classProvider.isEntityPlayer(it) && Intrinsics.areEqual(it.asEntityPlayer().getDisplayNameString(), it.asEntityPlayer().getDisplayNameString())))
/* 220 */           destination$iv$iv.add(element$iv$iv);  }  $this$filter$iv = destination$iv$iv; $i$f$filter = 0; if ($this$filter$iv.size() > 1)
/* 221 */         return true;  }  if (((Boolean)duplicateInTabValue.get()).booleanValue()) { Iterable $this$filter$iv = MinecraftInstance.mc.getNetHandler().getPlayerInfoMap(); int $i$f$filter = 0; Iterable $this$filterTo$iv$iv = $this$filter$iv; Collection<Object> destination$iv$iv = new ArrayList(); int $i$f$filterTo = 0;
/* 222 */       for (Object element$iv$iv : $this$filterTo$iv$iv) { INetworkPlayerInfo it = (INetworkPlayerInfo)element$iv$iv; int $i$a$-filter-AntiBot$isBot$2 = 0; if (Intrinsics.areEqual(entity.getName(), ColorUtils.stripColor(NetworkPlayerInfoKt.getFullName(it))))
/* 223 */           destination$iv$iv.add(element$iv$iv);  }  $this$filter$iv = destination$iv$iv;
/*     */       $i$f$filter = 0;
/*     */       if ($this$filter$iv.size() > 1)
/*     */         return true;  }
/*     */     
/*     */     if (((Boolean)allwaysInRadiusValue.get()).booleanValue() && !notAlwaysInRadius.contains(Integer.valueOf(entity.getEntityId())))
/*     */       return true; 
/*     */     if (entity.getName() == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     CharSequence charSequence = entity.getName();
/*     */     boolean bool = false;
/*     */     if (!((charSequence.length() == 0) ? 1 : 0)) {
/*     */       if (MinecraftInstance.mc.getThePlayer() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       if (Intrinsics.areEqual(entity.getName(), MinecraftInstance.mc.getThePlayer().getName()));
/*     */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void onDisable() {
/*     */     clearAll();
/*     */     super.onDisable();
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/*     */     Intrinsics.checkParameterIsNotNull(event, "event");
/*     */     if (MinecraftInstance.mc.getThePlayer() == null || MinecraftInstance.mc.getTheWorld() == null)
/*     */       return; 
/*     */     IPacket packet = event.getPacket();
/*     */     if (MinecraftInstance.classProvider.isSPacketEntity(packet)) {
/*     */       ISPacketEntity packetEntity = packet.asSPacketEntity();
/*     */       if (MinecraftInstance.mc.getTheWorld() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       IEntity entity = packetEntity.getEntity((IWorld)MinecraftInstance.mc.getTheWorld());
/*     */       if (MinecraftInstance.classProvider.isEntityPlayer(entity) && entity != null) {
/*     */         if (packetEntity.getOnGround() && !ground.contains(Integer.valueOf(entity.getEntityId())))
/*     */           ground.add(Integer.valueOf(entity.getEntityId())); 
/*     */         if (!packetEntity.getOnGround() && !air.contains(Integer.valueOf(entity.getEntityId())))
/*     */           air.add(Integer.valueOf(entity.getEntityId())); 
/*     */         if (packetEntity.getOnGround()) {
/*     */           if (entity.getPrevPosY() != entity.getPosY())
/*     */             invalidGround.put(Integer.valueOf(entity.getEntityId()), Integer.valueOf(((Number)invalidGround.getOrDefault(Integer.valueOf(entity.getEntityId()), Integer.valueOf(0))).intValue() + 1)); 
/*     */         } else {
/*     */           int currentVL = ((Number)invalidGround.getOrDefault(Integer.valueOf(entity.getEntityId()), Integer.valueOf(0))).intValue() / 2;
/*     */           if (currentVL <= 0) {
/*     */             invalidGround.remove(Integer.valueOf(entity.getEntityId()));
/*     */           } else {
/*     */             invalidGround.put(Integer.valueOf(entity.getEntityId()), Integer.valueOf(currentVL));
/*     */           } 
/*     */         } 
/*     */         if (entity.isInvisible() && !invisible.contains(Integer.valueOf(entity.getEntityId())))
/*     */           invisible.add(Integer.valueOf(entity.getEntityId())); 
/*     */         if (!notAlwaysInRadius.contains(Integer.valueOf(entity.getEntityId()))) {
/*     */           if (MinecraftInstance.mc.getThePlayer() == null)
/*     */             Intrinsics.throwNpe(); 
/*     */           if (MinecraftInstance.mc.getThePlayer().getDistanceToEntity(entity) > ((Number)allwaysRadiusValue.get()).floatValue())
/*     */             notAlwaysInRadius.add(Integer.valueOf(entity.getEntityId())); 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     if (MinecraftInstance.classProvider.isSPacketAnimation(packet)) {
/*     */       ISPacketAnimation packetAnimation = packet.asSPacketAnimation();
/*     */       if (MinecraftInstance.mc.getTheWorld() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       IEntity entity = MinecraftInstance.mc.getTheWorld().getEntityByID(packetAnimation.getEntityID());
/*     */       if (entity != null && MinecraftInstance.classProvider.isEntityLivingBase(entity) && packetAnimation.getAnimationType() == 0 && !swing.contains(Integer.valueOf(entity.getEntityId())))
/*     */         swing.add(Integer.valueOf(entity.getEntityId())); 
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onAttack(@NotNull AttackEvent e) {
/*     */     Intrinsics.checkParameterIsNotNull(e, "e");
/*     */     IEntity entity = e.getTargetEntity();
/*     */     if (entity != null && MinecraftInstance.classProvider.isEntityLivingBase(entity) && !hitted.contains(Integer.valueOf(entity.getEntityId())))
/*     */       hitted.add(Integer.valueOf(entity.getEntityId())); 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onWorld(@Nullable WorldEvent event) {
/*     */     clearAll();
/*     */   }
/*     */   
/*     */   private final void clearAll() {
/*     */     hitted.clear();
/*     */     swing.clear();
/*     */     ground.clear();
/*     */     invalidGround.clear();
/*     */     invisible.clear();
/*     */     notAlwaysInRadius.clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\misc\AntiBot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */