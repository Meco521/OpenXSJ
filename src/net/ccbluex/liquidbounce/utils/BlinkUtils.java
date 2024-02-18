/*     */ package net.ccbluex.liquidbounce.utils;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ import java.util.LinkedList;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.ranges.IntRange;
/*     */ import kotlin.text.StringsKt;
/*     */ import me.utils.PacketUtils;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.INetHandlerPlayServer;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000@\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\002\n\002\020\013\n\002\b\027\n\002\020\030\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\005\n\002\020\016\n\000\n\002\020\002\n\002\b\024\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\022\020'\032\0020\0042\n\b\002\020(\032\004\030\0010)J&\020*\032\0020+2\n\b\002\020(\032\004\030\0010)2\b\b\002\020,\032\0020\0072\b\b\002\020-\032\0020\004J\022\020.\032\0020\0072\b\b\002\020(\032\0020)H\002J\022\020/\032\0020\0072\n\0200\032\006\022\002\b\0030\"J0\0201\032\0020+2\n\b\002\020(\032\004\030\0010)2\b\b\002\020,\032\0020\0072\b\b\002\020-\032\0020\0042\b\b\002\0202\032\0020\004J\006\0203\032\0020+Jt\0203\032\0020+2\b\b\002\0204\032\0020\0072\b\b\002\0205\032\0020\0072\b\b\002\0206\032\0020\0072\b\b\002\0207\032\0020\0072\b\b\002\0208\032\0020\0072\b\b\002\0209\032\0020\0072\b\b\002\020:\032\0020\0072\b\b\002\020;\032\0020\0072\b\b\002\020<\032\0020\0072\b\b\002\020=\032\0020\0072\b\b\002\020>\032\0020\007R\016\020\003\032\0020\004XT¢\006\002\n\000R\016\020\005\032\0020\004XT¢\006\002\n\000R\032\020\006\032\0020\007X\016¢\006\016\n\000\032\004\b\b\020\t\"\004\b\n\020\013R\032\020\f\032\0020\007X\016¢\006\016\n\000\032\004\b\r\020\t\"\004\b\016\020\013R\032\020\017\032\0020\007X\016¢\006\016\n\000\032\004\b\020\020\t\"\004\b\021\020\013R\032\020\022\032\0020\007X\016¢\006\016\n\000\032\004\b\023\020\t\"\004\b\024\020\013R\032\020\025\032\0020\007X\016¢\006\016\n\000\032\004\b\026\020\t\"\004\b\027\020\013R\032\020\030\032\0020\007X\016¢\006\016\n\000\032\004\b\031\020\t\"\004\b\032\020\013R\032\020\033\032\0020\007X\016¢\006\016\n\000\032\004\b\034\020\t\"\004\b\035\020\013R\016\020\036\032\0020\037X\016¢\006\002\n\000R\032\020 \032\016\022\n\022\b\022\004\022\0020#0\"0!X\004¢\006\002\n\000R\032\020$\032\0020\007X\016¢\006\016\n\000\032\004\b%\020\t\"\004\b&\020\013¨\006?"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/BlinkUtils;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "()V", "Invalid_Type", "", "MisMatch_Type", "abilitiesStat", "", "getAbilitiesStat", "()Z", "setAbilitiesStat", "(Z)V", "actionStat", "getActionStat", "setActionStat", "interactStat", "getInteractStat", "setInteractStat", "invStat", "getInvStat", "setInvStat", "keepAliveStat", "getKeepAliveStat", "setKeepAliveStat", "movingPacketStat", "getMovingPacketStat", "setMovingPacketStat", "otherPacket", "getOtherPacket", "setOtherPacket", "packetToggleStat", "", "playerBuffer", "Ljava/util/LinkedList;", "Lnet/minecraft/network/Packet;", "Lnet/minecraft/network/play/INetHandlerPlayServer;", "transactionStat", "getTransactionStat", "setTransactionStat", "bufferSize", "packetType", "", "clearPacket", "", "onlySelected", "amount", "isBlacklisted", "pushPacket", "packets", "releasePacket", "minBuff", "setBlinkState", "off", "release", "all", "packetMoving", "packetTransaction", "packetKeepAlive", "packetAction", "packetAbilities", "packetInventory", "packetInteract", "other", "XSJClient"})
/*     */ public final class BlinkUtils
/*     */   extends MinecraftInstance
/*     */ {
/*     */   static {
/*  22 */     BlinkUtils blinkUtils = new BlinkUtils();
/*  23 */   } public static final int Invalid_Type = -301; public static final int MisMatch_Type = -302; private static boolean movingPacketStat; private static boolean transactionStat; private static boolean keepAliveStat; private static final LinkedList<Packet<INetHandlerPlayServer>> playerBuffer = new LinkedList<>(); private static boolean actionStat; private static boolean abilitiesStat; private static boolean invStat; private static boolean interactStat; private static boolean otherPacket;
/*     */   
/*     */   public final boolean getMovingPacketStat() {
/*  26 */     return movingPacketStat; } public final void setMovingPacketStat(boolean <set-?>) { movingPacketStat = <set-?>; }
/*  27 */   public final boolean getTransactionStat() { return transactionStat; } public final void setTransactionStat(boolean <set-?>) { transactionStat = <set-?>; }
/*  28 */   public final boolean getKeepAliveStat() { return keepAliveStat; } public final void setKeepAliveStat(boolean <set-?>) { keepAliveStat = <set-?>; }
/*  29 */   public final boolean getActionStat() { return actionStat; } public final void setActionStat(boolean <set-?>) { actionStat = <set-?>; }
/*  30 */   public final boolean getAbilitiesStat() { return abilitiesStat; } public final void setAbilitiesStat(boolean <set-?>) { abilitiesStat = <set-?>; }
/*  31 */   public final boolean getInvStat() { return invStat; } public final void setInvStat(boolean <set-?>) { invStat = <set-?>; }
/*  32 */   public final boolean getInteractStat() { return interactStat; } public final void setInteractStat(boolean <set-?>) { interactStat = <set-?>; }
/*  33 */   public final boolean getOtherPacket() { return otherPacket; } public final void setOtherPacket(boolean <set-?>) { otherPacket = <set-?>; }
/*     */   
/*  35 */   private static boolean[] packetToggleStat = new boolean[] { false, false, false, false, false, false, false, false, false, false, 
/*     */       false, false, false, false, false, false, false, false, false, false, 
/*  37 */       false, false, false, false, false, false }; public static final BlinkUtils INSTANCE; static { setBlinkState$default(blinkUtils, 
/*  38 */         true, 
/*  39 */         true, false, false, false, false, false, false, false, false, false, 2044, null);
/*     */     
/*  41 */     clearPacket$default(blinkUtils, null, false, 0, 7, null); }
/*     */ 
/*     */   
/*     */   public final void releasePacket(@Nullable String packetType, boolean onlySelected, int amount, int minBuff) {
/*  45 */     int count = 0;
/*  46 */     String str = packetType; if (str == null) {
/*     */       
/*  48 */       count = -1;
/*  49 */       for (Packet<INetHandlerPlayServer> packets : playerBuffer) {
/*  50 */         Intrinsics.checkExpressionValueIsNotNull(packets.getClass().getSimpleName(), "packets.javaClass.simpleName"); boolean bool = true; int packetID = (new BigInteger(StringsKt.substring(packets.getClass().getSimpleName(), new IntRange(bool, 2)), 16)).intValue();
/*  51 */         if (packetToggleStat[packetID] || !onlySelected) {
/*  52 */           Intrinsics.checkExpressionValueIsNotNull(packets, "packets"); PacketUtils.sendPacketNoEvent(packets);
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       
/*  57 */       LinkedList<Packet> tempBuffer = new LinkedList();
/*  58 */       for (Packet<INetHandlerPlayServer> packets : playerBuffer) {
/*  59 */         String className = packets.getClass().getSimpleName();
/*  60 */         if (StringsKt.equals(className, packetType, true)) {
/*  61 */           tempBuffer.add(packets);
/*     */         }
/*     */       } 
/*  64 */       while (tempBuffer.size() > minBuff && (count < amount || amount <= 0)) {
/*  65 */         Intrinsics.checkExpressionValueIsNotNull(tempBuffer.pop(), "tempBuffer.pop()"); PacketUtils.sendPacketNoEvent(tempBuffer.pop());
/*  66 */         count++;
/*     */       } 
/*     */     } 
/*     */     
/*  70 */     clearPacket(packetType, onlySelected, count);
/*     */   }
/*     */   
/*     */   public final void clearPacket(@Nullable String packetType, boolean onlySelected, int amount) {
/*  74 */     String str = packetType; if (str == null) {
/*     */       
/*  76 */       LinkedList<Packet> tempBuffer = new LinkedList();
/*  77 */       for (Packet<INetHandlerPlayServer> packets : playerBuffer) {
/*  78 */         Intrinsics.checkExpressionValueIsNotNull(packets.getClass().getSimpleName(), "packets.javaClass.simpleName"); boolean bool = true; int packetID = (new BigInteger(StringsKt.substring(packets.getClass().getSimpleName(), new IntRange(bool, 2)), 16)).intValue();
/*  79 */         if (!packetToggleStat[packetID] && onlySelected) {
/*  80 */           tempBuffer.add(packets);
/*     */         }
/*     */       } 
/*  83 */       playerBuffer.clear();
/*  84 */       for (Packet<INetHandlerPlayServer> packets : tempBuffer) {
/*  85 */         playerBuffer.add(packets);
/*     */       }
/*     */     } else {
/*     */       
/*  89 */       int count = 0;
/*  90 */       LinkedList<Packet> tempBuffer = new LinkedList();
/*  91 */       for (Packet<INetHandlerPlayServer> packets : playerBuffer) {
/*  92 */         String className = packets.getClass().getSimpleName();
/*  93 */         if (!StringsKt.equals(className, packetType, true)) {
/*  94 */           tempBuffer.add(packets); continue;
/*     */         } 
/*  96 */         count++;
/*  97 */         if (count > amount) {
/*  98 */           tempBuffer.add(packets);
/*     */         }
/*     */       } 
/*     */       
/* 102 */       playerBuffer.clear();
/* 103 */       for (Packet<INetHandlerPlayServer> packets : tempBuffer) {
/* 104 */         playerBuffer.add(packets);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean pushPacket(@NotNull Packet<INetHandlerPlayServer> packets) {
/* 111 */     Intrinsics.checkParameterIsNotNull(packets, "packets"); Intrinsics.checkExpressionValueIsNotNull(packets.getClass().getSimpleName(), "packets.javaClass.simpleName"); boolean bool = true; int packetID = (new BigInteger(StringsKt.substring(packets.getClass().getSimpleName(), new IntRange(bool, 2)), 16)).intValue();
/* 112 */     Intrinsics.checkExpressionValueIsNotNull(packets.getClass().getSimpleName(), "packets.javaClass.simpleName"); if (packetToggleStat[packetID] && !isBlacklisted(packets.getClass().getSimpleName())) {
/* 113 */       playerBuffer.add(packets);
/* 114 */       return true;
/*     */     } 
/* 116 */     return false;
/*     */   }
/*     */   
/*     */   private final boolean isBlacklisted(String packetType) {
/* 120 */     String str = packetType; switch (str.hashCode()) { case 2128815408:
/* 121 */         if (str.equals("C01PacketEncryptionResponse")); break;case -255714108: if (str.equals("C00PacketLoginStart")); break;case -1423059366: if (str.equals("C00PacketServerQuery")); break;case 936222132: if (str.equals("C00Handshake")); break;case -579696962: if (str.equals("C01PacketPing")); break;case 1276952259: if (str.equals("C01PacketChatMessage"));
/*     */         break; }
/*     */     
/*     */     return false;
/*     */   }
/*     */   public final void setBlinkState() {
/* 127 */     setBlinkState$default(this, true, false, false, false, false, false, false, false, false, false, false, 2046, null);
/* 128 */     clearPacket$default(this, null, false, 0, 7, null);
/*     */   }
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
/*     */   public final void setBlinkState(boolean off, boolean release, boolean all, boolean packetMoving, boolean packetTransaction, boolean packetKeepAlive, boolean packetAction, boolean packetAbilities, boolean packetInventory, boolean packetInteract, boolean other) {
/* 144 */     if (release) {
/* 145 */       releasePacket$default(this, null, false, 0, 0, 15, null);
/*     */     }
/* 147 */     movingPacketStat = ((packetMoving && !off) || all);
/* 148 */     transactionStat = ((packetTransaction && !off) || all);
/* 149 */     keepAliveStat = ((packetKeepAlive && !off) || all);
/* 150 */     actionStat = ((packetAction && !off) || all);
/* 151 */     abilitiesStat = ((packetAbilities && !off) || all);
/* 152 */     invStat = ((packetInventory && !off) || all);
/* 153 */     interactStat = ((packetInteract && !off) || all);
/* 154 */     otherPacket = ((other && !off) || all);
/* 155 */     if (all) {
/* 156 */       byte b; int i; for (b = 0, i = packetToggleStat.length; b < i; b++) {
/* 157 */         packetToggleStat[b] = true;
/*     */       }
/*     */     } else {
/* 160 */       for (int i = 0, j = packetToggleStat.length; i < j; i++) {
/* 161 */         switch (i) { case 0:
/* 162 */             packetToggleStat[i] = keepAliveStat; break;
/* 163 */           case 1: case 17: case 18: case 20: case 21: case 23: case 24: case 25: packetToggleStat[i] = otherPacket; break;
/* 164 */           case 3: case 4: case 5: case 6: packetToggleStat[i] = movingPacketStat; break;
/* 165 */           case 15: packetToggleStat[i] = transactionStat; break;
/* 166 */           case 2: case 9: case 10: case 11: packetToggleStat[i] = actionStat; break;
/* 167 */           case 12: case 19: packetToggleStat[i] = abilitiesStat; break;
/* 168 */           case 13: case 14: case 16: case 22: packetToggleStat[i] = invStat; break;
/* 169 */           case 7: case 8: packetToggleStat[i] = interactStat;
/*     */             break; }
/*     */       
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public final int bufferSize(@Nullable String packetType) {
/* 176 */     String str = packetType;
/*     */ 
/*     */     
/* 179 */     int packetCount = 0;
/* 180 */     boolean flag = false;
/* 181 */     for (Packet<INetHandlerPlayServer> packets : playerBuffer) {
/* 182 */       String className = packets.getClass().getSimpleName();
/* 183 */       if (StringsKt.equals(className, packetType, true)) {
/* 184 */         flag = true;
/* 185 */         packetCount++;
/*     */       } 
/*     */     } 
/* 188 */     return (str == null) ? playerBuffer.size() : (flag ? packetCount : -302);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\BlinkUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */