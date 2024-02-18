/*     */ package net.ccbluex.liquidbounce.features.module.modules.retreat;
/*     */ 
/*     */ import java.util.LinkedList;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.injection.backend.PacketImpl;
/*     */ import net.ccbluex.liquidbounce.script.api.global.Chat;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.INetHandlerPlayClient;
/*     */ import org.jetbrains.annotations.NotNull;
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
/*     */ @ModuleInfo(name = "PacketDisabler", description = "取消游戏发包", category = ModuleCategory.RETREAT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000>\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\033\n\002\030\002\n\002\030\002\n\002\030\002\n\002\bF\n\002\020\016\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020l\032\0020m2\006\020n\032\0020oH\007J\020\020p\032\0020m2\006\020n\032\0020qH\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\004X\004¢\006\002\n\000R\016\020\007\032\0020\004X\004¢\006\002\n\000R\016\020\b\032\0020\004X\004¢\006\002\n\000R\016\020\t\032\0020\004X\004¢\006\002\n\000R\016\020\n\032\0020\004X\004¢\006\002\n\000R\016\020\013\032\0020\004X\004¢\006\002\n\000R\016\020\f\032\0020\004X\004¢\006\002\n\000R\016\020\r\032\0020\004X\004¢\006\002\n\000R\016\020\016\032\0020\004X\004¢\006\002\n\000R\016\020\017\032\0020\004X\004¢\006\002\n\000R\016\020\020\032\0020\004X\004¢\006\002\n\000R\016\020\021\032\0020\004X\004¢\006\002\n\000R\016\020\022\032\0020\004X\004¢\006\002\n\000R\016\020\023\032\0020\004X\004¢\006\002\n\000R\016\020\024\032\0020\004X\004¢\006\002\n\000R\016\020\025\032\0020\004X\004¢\006\002\n\000R\016\020\026\032\0020\004X\004¢\006\002\n\000R\016\020\027\032\0020\004X\004¢\006\002\n\000R\016\020\030\032\0020\004X\004¢\006\002\n\000R\016\020\031\032\0020\004X\004¢\006\002\n\000R\016\020\032\032\0020\004X\004¢\006\002\n\000R\016\020\033\032\0020\004X\004¢\006\002\n\000R\016\020\034\032\0020\004X\004¢\006\002\n\000R\016\020\035\032\0020\004X\004¢\006\002\n\000R\016\020\036\032\0020\004X\004¢\006\002\n\000R\032\020\037\032\016\022\n\022\b\022\004\022\0020\"0!0 X\004¢\006\002\n\000R\016\020#\032\0020\004X\004¢\006\002\n\000R\016\020$\032\0020\004X\004¢\006\002\n\000R\016\020%\032\0020\004X\004¢\006\002\n\000R\016\020&\032\0020\004X\004¢\006\002\n\000R\016\020'\032\0020\004X\004¢\006\002\n\000R\016\020(\032\0020\004X\004¢\006\002\n\000R\016\020)\032\0020\004X\004¢\006\002\n\000R\016\020*\032\0020\004X\004¢\006\002\n\000R\016\020+\032\0020\004X\004¢\006\002\n\000R\016\020,\032\0020\004X\004¢\006\002\n\000R\016\020-\032\0020\004X\004¢\006\002\n\000R\016\020.\032\0020\004X\004¢\006\002\n\000R\016\020/\032\0020\004X\004¢\006\002\n\000R\016\0200\032\0020\004X\004¢\006\002\n\000R\016\0201\032\0020\004X\004¢\006\002\n\000R\016\0202\032\0020\004X\004¢\006\002\n\000R\016\0203\032\0020\004X\004¢\006\002\n\000R\016\0204\032\0020\004X\004¢\006\002\n\000R\016\0205\032\0020\004X\004¢\006\002\n\000R\016\0206\032\0020\004X\004¢\006\002\n\000R\016\0207\032\0020\004X\004¢\006\002\n\000R\016\0208\032\0020\004X\004¢\006\002\n\000R\016\0209\032\0020\004X\004¢\006\002\n\000R\016\020:\032\0020\004X\004¢\006\002\n\000R\016\020;\032\0020\004X\004¢\006\002\n\000R\016\020<\032\0020\004X\004¢\006\002\n\000R\016\020=\032\0020\004X\004¢\006\002\n\000R\016\020>\032\0020\004X\004¢\006\002\n\000R\016\020?\032\0020\004X\004¢\006\002\n\000R\016\020@\032\0020\004X\004¢\006\002\n\000R\016\020A\032\0020\004X\004¢\006\002\n\000R\016\020B\032\0020\004X\004¢\006\002\n\000R\016\020C\032\0020\004X\004¢\006\002\n\000R\016\020D\032\0020\004X\004¢\006\002\n\000R\016\020E\032\0020\004X\004¢\006\002\n\000R\016\020F\032\0020\004X\004¢\006\002\n\000R\016\020G\032\0020\004X\004¢\006\002\n\000R\016\020H\032\0020\004X\004¢\006\002\n\000R\016\020I\032\0020\004X\004¢\006\002\n\000R\016\020J\032\0020\004X\004¢\006\002\n\000R\016\020K\032\0020\004X\004¢\006\002\n\000R\016\020L\032\0020\004X\004¢\006\002\n\000R\016\020M\032\0020\004X\004¢\006\002\n\000R\016\020N\032\0020\004X\004¢\006\002\n\000R\016\020O\032\0020\004X\004¢\006\002\n\000R\016\020P\032\0020\004X\004¢\006\002\n\000R\016\020Q\032\0020\004X\004¢\006\002\n\000R\016\020R\032\0020\004X\004¢\006\002\n\000R\016\020S\032\0020\004X\004¢\006\002\n\000R\016\020T\032\0020\004X\004¢\006\002\n\000R\016\020U\032\0020\004X\004¢\006\002\n\000R\016\020V\032\0020\004X\004¢\006\002\n\000R\016\020W\032\0020\004X\004¢\006\002\n\000R\016\020X\032\0020\004X\004¢\006\002\n\000R\016\020Y\032\0020\004X\004¢\006\002\n\000R\016\020Z\032\0020\004X\004¢\006\002\n\000R\016\020[\032\0020\004X\004¢\006\002\n\000R\016\020\\\032\0020\004X\004¢\006\002\n\000R\016\020]\032\0020\004X\004¢\006\002\n\000R\016\020^\032\0020\004X\004¢\006\002\n\000R\016\020_\032\0020\004X\004¢\006\002\n\000R\016\020`\032\0020\004X\004¢\006\002\n\000R\016\020a\032\0020\004X\004¢\006\002\n\000R\016\020b\032\0020\004X\004¢\006\002\n\000R\016\020c\032\0020\004X\004¢\006\002\n\000R\016\020d\032\0020\004X\004¢\006\002\n\000R\016\020e\032\0020\004X\004¢\006\002\n\000R\016\020f\032\0020\004X\004¢\006\002\n\000R\016\020g\032\0020\004X\004¢\006\002\n\000R\024\020h\032\0020i8VX\004¢\006\006\032\004\bj\020k¨\006r"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/retreat/PacketDisabler;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "allClientPacket", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "allServerPacket", "c01", "c02", "c03", "c04", "c05", "c06", "c07", "c08", "c09", "c0A", "c0B", "c0C", "c0D", "c0F", "c10", "c11", "c12", "c13", "c14", "c15", "c16", "c17", "c18", "c19", "deBug", "inBus", "Ljava/util/LinkedList;", "Lnet/minecraft/network/Packet;", "Lnet/minecraft/network/play/INetHandlerPlayClient;", "noMove", "s01", "s02", "s03", "s04", "s05", "s06", "s07", "s08", "s09", "s0A", "s0B", "s0C", "s0D", "s0E", "s0F", "s10", "s11", "s12", "s13", "s14", "s15", "s16", "s17", "s18", "s19", "s1B", "s1C", "s1D", "s1E", "s1F", "s20", "s21", "s22", "s23", "s24", "s25", "s27", "s28", "s29", "s2A", "s2B", "s2C", "s2D", "s2E", "s2F", "s30", "s31", "s32", "s34", "s35", "s36", "s37", "s38", "s39", "s3A", "s3B", "s3C", "s3E", "s3F", "s40", "s41", "s42", "s43", "s44", "s45", "s47", "s48", "serverPacketMoveFix", "tag", "", "getTag", "()Ljava/lang/String;", "onMove", "", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "XSJClient"})
/*     */ public final class PacketDisabler
/*     */   extends Module
/*     */ {
/*  57 */   private final BoolValue deBug = new BoolValue("DeBug", false);
/*  58 */   private final BoolValue noMove = new BoolValue("NoMove", false);
/*     */   
/*  60 */   private final BoolValue allClientPacket = new BoolValue("AllClientPacket", false);
/*  61 */   private final BoolValue allServerPacket = new BoolValue("AllServerPacket", false);
/*     */   
/*  63 */   private final BoolValue serverPacketMoveFix = new BoolValue("ServerPacketMoveFix", false);
/*     */   
/*  65 */   private final BoolValue c01 = new BoolValue("C01", false);
/*  66 */   private final BoolValue c02 = new BoolValue("C02", false);
/*  67 */   private final BoolValue c03 = new BoolValue("C03", false);
/*  68 */   private final BoolValue c04 = new BoolValue("C04", false);
/*  69 */   private final BoolValue c05 = new BoolValue("C05", false);
/*  70 */   private final BoolValue c06 = new BoolValue("C06", false);
/*  71 */   private final BoolValue c07 = new BoolValue("C07", false);
/*  72 */   private final BoolValue c08 = new BoolValue("C08", false);
/*  73 */   private final BoolValue c09 = new BoolValue("C09", false);
/*  74 */   private final BoolValue c0A = new BoolValue("C0A", false);
/*  75 */   private final BoolValue c0F = new BoolValue("C0F", false);
/*  76 */   private final BoolValue c0B = new BoolValue("C0B", false);
/*  77 */   private final BoolValue c0C = new BoolValue("C0C", false);
/*  78 */   private final BoolValue c0D = new BoolValue("C0D", false);
/*  79 */   private final BoolValue c10 = new BoolValue("C10", false);
/*  80 */   private final BoolValue c11 = new BoolValue("C11", false);
/*  81 */   private final BoolValue c12 = new BoolValue("C12", false);
/*  82 */   private final BoolValue c13 = new BoolValue("C13", false);
/*  83 */   private final BoolValue c14 = new BoolValue("C14", false);
/*  84 */   private final BoolValue c15 = new BoolValue("C15", false);
/*  85 */   private final BoolValue c16 = new BoolValue("C16", false);
/*  86 */   private final BoolValue c17 = new BoolValue("C17", false);
/*  87 */   private final BoolValue c18 = new BoolValue("C18", false);
/*  88 */   private final BoolValue c19 = new BoolValue("C19", false);
/*     */   
/*  90 */   private final BoolValue s01 = new BoolValue("S01", false);
/*  91 */   private final BoolValue s02 = new BoolValue("S02", false);
/*  92 */   private final BoolValue s03 = new BoolValue("S03", false);
/*  93 */   private final BoolValue s04 = new BoolValue("S04", false);
/*  94 */   private final BoolValue s05 = new BoolValue("S05", false);
/*  95 */   private final BoolValue s06 = new BoolValue("S06", false);
/*  96 */   private final BoolValue s07 = new BoolValue("S07", false);
/*  97 */   private final BoolValue s08 = new BoolValue("S08", false);
/*  98 */   private final BoolValue s09 = new BoolValue("S09", false);
/*  99 */   private final BoolValue s0A = new BoolValue("S0A", false);
/* 100 */   private final BoolValue s0B = new BoolValue("S0B", false);
/* 101 */   private final BoolValue s0C = new BoolValue("S0C", false);
/* 102 */   private final BoolValue s0D = new BoolValue("S0D", false);
/* 103 */   private final BoolValue s0E = new BoolValue("S0E", false);
/* 104 */   private final BoolValue s0F = new BoolValue("S0F", false);
/* 105 */   private final BoolValue s10 = new BoolValue("S10", false);
/* 106 */   private final BoolValue s11 = new BoolValue("S11", false);
/* 107 */   private final BoolValue s12 = new BoolValue("S12", false);
/* 108 */   private final BoolValue s13 = new BoolValue("S13", false);
/* 109 */   private final BoolValue s14 = new BoolValue("S14", false);
/* 110 */   private final BoolValue s15 = new BoolValue("S15", false);
/* 111 */   private final BoolValue s16 = new BoolValue("S16", false);
/* 112 */   private final BoolValue s17 = new BoolValue("S17", false);
/* 113 */   private final BoolValue s18 = new BoolValue("S18", false);
/* 114 */   private final BoolValue s19 = new BoolValue("S19", false);
/* 115 */   private final BoolValue s1B = new BoolValue("S1B", false);
/* 116 */   private final BoolValue s1C = new BoolValue("S1C", false);
/* 117 */   private final BoolValue s1D = new BoolValue("S1D", false);
/* 118 */   private final BoolValue s1E = new BoolValue("S1E", false);
/* 119 */   private final BoolValue s1F = new BoolValue("S1F", false);
/* 120 */   private final BoolValue s20 = new BoolValue("S20", false);
/* 121 */   private final BoolValue s21 = new BoolValue("S21", false);
/* 122 */   private final BoolValue s22 = new BoolValue("S22", false);
/* 123 */   private final BoolValue s23 = new BoolValue("S23", false);
/* 124 */   private final BoolValue s24 = new BoolValue("S24", false);
/* 125 */   private final BoolValue s25 = new BoolValue("S25", false);
/* 126 */   private final BoolValue s27 = new BoolValue("S27", false);
/* 127 */   private final BoolValue s28 = new BoolValue("S28", false);
/* 128 */   private final BoolValue s29 = new BoolValue("S29", false);
/* 129 */   private final BoolValue s2A = new BoolValue("S2A", false);
/* 130 */   private final BoolValue s2B = new BoolValue("S2B", false);
/* 131 */   private final BoolValue s2C = new BoolValue("S2C", false);
/* 132 */   private final BoolValue s2D = new BoolValue("S2D", false);
/* 133 */   private final BoolValue s2E = new BoolValue("S2E", false);
/* 134 */   private final BoolValue s2F = new BoolValue("S2F", false);
/* 135 */   private final BoolValue s30 = new BoolValue("S30", false);
/* 136 */   private final BoolValue s31 = new BoolValue("S31", false);
/* 137 */   private final BoolValue s32 = new BoolValue("S32", false);
/* 138 */   private final BoolValue s34 = new BoolValue("S34", false);
/* 139 */   private final BoolValue s35 = new BoolValue("S35", false);
/* 140 */   private final BoolValue s36 = new BoolValue("S36", false);
/* 141 */   private final BoolValue s37 = new BoolValue("S37", false);
/* 142 */   private final BoolValue s38 = new BoolValue("S38", false);
/* 143 */   private final BoolValue s39 = new BoolValue("S39", false);
/* 144 */   private final BoolValue s3A = new BoolValue("S3A", false);
/* 145 */   private final BoolValue s3B = new BoolValue("S3B", false);
/* 146 */   private final BoolValue s3C = new BoolValue("S3C", false);
/* 147 */   private final BoolValue s3E = new BoolValue("S3E", false);
/* 148 */   private final BoolValue s3F = new BoolValue("S3E", false);
/* 149 */   private final BoolValue s40 = new BoolValue("S40", false);
/* 150 */   private final BoolValue s41 = new BoolValue("S41", false);
/* 151 */   private final BoolValue s42 = new BoolValue("S42", false);
/* 152 */   private final BoolValue s43 = new BoolValue("S43", false);
/* 153 */   private final BoolValue s44 = new BoolValue("S44", false);
/* 154 */   private final BoolValue s45 = new BoolValue("S45", false);
/* 155 */   private final BoolValue s47 = new BoolValue("S47", false);
/* 156 */   private final BoolValue s48 = new BoolValue("S48", false);
/*     */   
/* 158 */   private final LinkedList<Packet<INetHandlerPlayClient>> inBus = new LinkedList<>();
/*     */   
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/* 162 */     Intrinsics.checkParameterIsNotNull(event, "event"); IPacket $this$unwrap$iv = event.getPacket(); int $i$f$unwrap = 0;
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
/* 651 */     if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.PacketImpl<*>");  Packet<INetHandlerPlayClient> packet = ((PacketImpl)$this$unwrap$iv).getWrapped();
/*     */     Intrinsics.checkExpressionValueIsNotNull(packet.getClass().getSimpleName(), "packet::class.java.simpleName");
/*     */     if (((Boolean)this.allClientPacket.get()).booleanValue() && StringsKt.startsWith(packet.getClass().getSimpleName(), "C", true)) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 AllClientPacket"); 
/*     */     } 
/*     */     Intrinsics.checkExpressionValueIsNotNull(packet.getClass().getSimpleName(), "packet::class.java.simpleName");
/*     */     if (((Boolean)this.allServerPacket.get()).booleanValue() && StringsKt.startsWith(packet.getClass().getSimpleName(), "S", true)) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 AllServerPacket"); 
/*     */       if (((Boolean)this.serverPacketMoveFix.get()).booleanValue()) {
/*     */         if (packet == null)
/*     */           throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.Packet<net.minecraft.network.play.INetHandlerPlayClient>"); 
/*     */         this.inBus.add(packet);
/*     */       } 
/*     */     } 
/*     */     if (((Boolean)this.c01.get()).booleanValue() && packet instanceof net.minecraft.network.play.client.CPacketChatMessage) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 CPacketChatMessage"); 
/*     */     } 
/*     */     if (((Boolean)this.c02.get()).booleanValue() && packet instanceof net.minecraft.network.play.client.CPacketUseEntity) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 CPacketUseEntity"); 
/*     */     } 
/*     */     if (((Boolean)this.c03.get()).booleanValue() && packet instanceof net.minecraft.network.play.client.CPacketPlayer) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 CPacketPlayer"); 
/*     */     } 
/*     */     if (((Boolean)this.c04.get()).booleanValue() && packet instanceof net.minecraft.network.play.client.CPacketPlayer.Position) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 CPacketPlayer.Position"); 
/*     */     } 
/*     */     if (((Boolean)this.c05.get()).booleanValue() && packet instanceof net.minecraft.network.play.client.CPacketPlayer.Rotation) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 CPacketPlayer.Rotation"); 
/*     */     } 
/*     */     if (((Boolean)this.c06.get()).booleanValue() && packet instanceof net.minecraft.network.play.client.CPacketPlayer.PositionRotation) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 CPacketPlayer.PositionRotation"); 
/*     */     } 
/*     */     if (((Boolean)this.c07.get()).booleanValue() && packet instanceof net.minecraft.network.play.client.CPacketPlayerDigging) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 CPacketPlayerDigging"); 
/*     */     } 
/*     */     if (((Boolean)this.c08.get()).booleanValue() && packet instanceof net.minecraft.network.play.client.CPacketPlayerTryUseItem) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 CPacketPlayerTryUseItem"); 
/*     */     } 
/*     */     if (((Boolean)this.c09.get()).booleanValue() && packet instanceof net.minecraft.network.play.client.CPacketHeldItemChange) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 CPacketHeldItemChange"); 
/*     */     } 
/*     */     if (((Boolean)this.c0A.get()).booleanValue() && packet instanceof net.minecraft.network.play.client.CPacketAnimation) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 CPacketAnimation"); 
/*     */     } 
/*     */     if (((Boolean)this.c0B.get()).booleanValue() && packet instanceof net.minecraft.network.play.client.CPacketEntityAction) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 CPacketEntityAction"); 
/*     */     } 
/*     */     if (((Boolean)this.c0C.get()).booleanValue() && packet instanceof net.minecraft.network.play.client.CPacketInput) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 CPacketInput"); 
/*     */     } 
/*     */     if (((Boolean)this.c0D.get()).booleanValue() && packet instanceof net.minecraft.network.play.client.CPacketCloseWindow) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 CPacketCloseWindow"); 
/*     */     } 
/*     */     if (((Boolean)this.c0F.get()).booleanValue() && packet instanceof net.minecraft.network.play.client.CPacketConfirmTransaction) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 CPacketConfirmTransaction"); 
/*     */     } 
/*     */     if (((Boolean)this.c10.get()).booleanValue() && packet instanceof net.minecraft.network.play.client.CPacketCreativeInventoryAction) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 CPacketCreativeInventoryAction"); 
/*     */     } 
/*     */     if (((Boolean)this.c11.get()).booleanValue() && packet instanceof net.minecraft.network.play.client.CPacketEnchantItem) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 CPacketEnchantItem"); 
/*     */     } 
/*     */     if (((Boolean)this.c12.get()).booleanValue() && packet instanceof net.minecraft.network.play.client.CPacketUpdateSign) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 CPacketUpdateSign"); 
/*     */     } 
/*     */     if (((Boolean)this.c13.get()).booleanValue() && packet instanceof net.minecraft.network.play.client.CPacketPlayerAbilities) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 CPacketPlayerAbilities"); 
/*     */     } 
/*     */     if (((Boolean)this.c14.get()).booleanValue() && packet instanceof net.minecraft.network.play.client.CPacketTabComplete) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 CPacketTabComplete"); 
/*     */     } 
/*     */     if (((Boolean)this.c15.get()).booleanValue() && packet instanceof net.minecraft.network.play.client.CPacketClientSettings) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 CPacketClientSettings"); 
/*     */     } 
/*     */     if (((Boolean)this.c16.get()).booleanValue() && packet instanceof net.minecraft.network.play.client.CPacketClientStatus) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 CPacketClientStatus"); 
/*     */     } 
/*     */     if (((Boolean)this.c17.get()).booleanValue() && packet instanceof net.minecraft.network.play.client.CPacketCustomPayload) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 CPacketCustomPayload"); 
/*     */     } 
/*     */     if (((Boolean)this.c18.get()).booleanValue() && packet instanceof net.minecraft.network.play.client.CPacketSpectate) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 CPacketSpectate"); 
/*     */     } 
/*     */     if (((Boolean)this.c19.get()).booleanValue() && packet instanceof net.minecraft.network.play.client.CPacketResourcePackStatus) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 CPacketResourcePackStatus"); 
/*     */     } 
/*     */     if (((Boolean)this.s01.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketJoinGame) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketJoinGame"); 
/*     */     } 
/*     */     if (((Boolean)this.s02.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketChat) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketChat"); 
/*     */       if (((Boolean)this.serverPacketMoveFix.get()).booleanValue())
/*     */         this.inBus.add(packet); 
/*     */     } 
/*     */     if (((Boolean)this.s03.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketTimeUpdate) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketTimeUpdate"); 
/*     */     } 
/*     */     if (((Boolean)this.s04.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketEntityEquipment) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketEntityEquipment"); 
/*     */     } 
/*     */     if (((Boolean)this.s05.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketSpawnPosition) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketSpawnPosition"); 
/*     */     } 
/*     */     if (((Boolean)this.s06.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketUpdateHealth) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketUpdateHealth"); 
/*     */     } 
/*     */     if (((Boolean)this.s07.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketRespawn) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketRespawn"); 
/*     */     } 
/*     */     if (((Boolean)this.s08.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketPlayerPosLook) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketPlayerPosLook"); 
/*     */     } 
/*     */     if (((Boolean)this.s09.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketHeldItemChange) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketHeldItemChange"); 
/*     */     } 
/*     */     if (((Boolean)this.s0A.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketUseBed) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketUseBed"); 
/*     */     } 
/*     */     if (((Boolean)this.s0B.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketAnimation) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketAnimation"); 
/*     */     } 
/*     */     if (((Boolean)this.s0C.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketSpawnPlayer) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketSpawnPlayer"); 
/*     */     } 
/*     */     if (((Boolean)this.s0D.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketCollectItem) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketCollectItem"); 
/*     */     } 
/*     */     if (((Boolean)this.s0E.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketSpawnObject) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketSpawnObject"); 
/*     */     } 
/*     */     if (((Boolean)this.s0F.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketSpawnMob) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketSpawnMob"); 
/*     */     } 
/*     */     if (((Boolean)this.s10.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketSpawnPainting) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketSpawnPainting"); 
/*     */     } 
/*     */     if (((Boolean)this.s11.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketSpawnExperienceOrb) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketSpawnExperienceOrb"); 
/*     */     } 
/*     */     if (((Boolean)this.s12.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketEntityVelocity) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketEntityVelocity"); 
/*     */     } 
/*     */     if (((Boolean)this.s13.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketDestroyEntities) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketDestroyEntities"); 
/*     */     } 
/*     */     if (((Boolean)this.s14.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketEntity) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketEntity"); 
/*     */       if (((Boolean)this.serverPacketMoveFix.get()).booleanValue())
/*     */         this.inBus.add(packet); 
/*     */     } 
/*     */     if (((Boolean)this.s15.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketEntity.S15PacketEntityRelMove) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketEntity.S15PacketEntityRelMove"); 
/*     */       if (((Boolean)this.serverPacketMoveFix.get()).booleanValue())
/*     */         this.inBus.add(packet); 
/*     */     } 
/*     */     if (((Boolean)this.s16.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketEntity.S16PacketEntityLook) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketEntity.S16PacketEntityLook"); 
/*     */       if (((Boolean)this.serverPacketMoveFix.get()).booleanValue())
/*     */         this.inBus.add(packet); 
/*     */     } 
/*     */     if (((Boolean)this.s17.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketEntity.S17PacketEntityLookMove) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketEntity.S17PacketEntityLookMove"); 
/*     */       if (((Boolean)this.serverPacketMoveFix.get()).booleanValue())
/*     */         this.inBus.add(packet); 
/*     */     } 
/*     */     if (((Boolean)this.s18.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketEntityTeleport) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketEntityTeleport"); 
/*     */     } 
/*     */     if (((Boolean)this.s19.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketEntityHeadLook) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketEntityHeadLook"); 
/*     */     } 
/*     */     if (((Boolean)this.s1B.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketEntityAttach) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketEntityAttach"); 
/*     */     } 
/*     */     if (((Boolean)this.s1C.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketEntityMetadata) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketEntityMetadata"); 
/*     */     } 
/*     */     if (((Boolean)this.s1D.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketEntityEffect) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketEntityEffect"); 
/*     */     } 
/*     */     if (((Boolean)this.s1E.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketRemoveEntityEffect) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketRemoveEntityEffect"); 
/*     */     } 
/*     */     if (((Boolean)this.s1F.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketSetExperience) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketSetExperience"); 
/*     */     } 
/*     */     if (((Boolean)this.s20.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketEntityProperties) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketEntityProperties"); 
/*     */     } 
/*     */     if (((Boolean)this.s21.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketChunkData) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketChunkData"); 
/*     */     } 
/*     */     if (((Boolean)this.s22.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketMultiBlockChange) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketMultiBlockChange"); 
/*     */     } 
/*     */     if (((Boolean)this.s23.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketBlockChange) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketBlockChange"); 
/*     */     } 
/*     */     if (((Boolean)this.s24.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketBlockAction) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketBlockAction"); 
/*     */     } 
/*     */     if (((Boolean)this.s25.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketBlockBreakAnim) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketBlockBreakAnim"); 
/*     */     } 
/*     */     if (((Boolean)this.s27.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketExplosion) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketExplosion"); 
/*     */     } 
/*     */     if (((Boolean)this.s28.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketEffect) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketEffect"); 
/*     */     } 
/*     */     if (((Boolean)this.s29.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketSoundEffect) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketSoundEffect"); 
/*     */     } 
/*     */     if (((Boolean)this.s2A.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketParticles) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketParticles"); 
/*     */     } 
/*     */     if (((Boolean)this.s2B.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketChangeGameState) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketChangeGameState"); 
/*     */     } 
/*     */     if (((Boolean)this.s2C.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketSpawnGlobalEntity) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketSpawnGlobalEntity"); 
/*     */     } 
/*     */     if (((Boolean)this.s2D.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketOpenWindow) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketOpenWindow"); 
/*     */     } 
/*     */     if (((Boolean)this.s2E.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketCloseWindow) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketCloseWindow"); 
/*     */     } 
/*     */     if (((Boolean)this.s2F.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketSetSlot) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketSetSlot"); 
/*     */     } 
/*     */     if (((Boolean)this.s30.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketWindowItems) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketWindowItems"); 
/*     */     } 
/*     */     if (((Boolean)this.s31.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketWindowProperty) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketWindowProperty"); 
/*     */     } 
/*     */     if (((Boolean)this.s32.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketConfirmTransaction) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketConfirmTransaction"); 
/*     */     } 
/*     */     if (((Boolean)this.s34.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketMaps) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketMaps"); 
/*     */     } 
/*     */     if (((Boolean)this.s35.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketUpdateTileEntity) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketUpdateTileEntity"); 
/*     */     } 
/*     */     if (((Boolean)this.s36.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketSignEditorOpen) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketSignEditorOpen"); 
/*     */     } 
/*     */     if (((Boolean)this.s37.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketStatistics) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketStatistics"); 
/*     */     } 
/*     */     if (((Boolean)this.s38.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketPlayerListItem) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketPlayerListItem"); 
/*     */     } 
/*     */     if (((Boolean)this.s39.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketPlayerAbilities) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketPlayerAbilities"); 
/*     */     } 
/*     */     if (((Boolean)this.s3A.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketTabComplete) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketTabComplete"); 
/*     */     } 
/*     */     if (((Boolean)this.s3B.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketScoreboardObjective) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketScoreboardObjective"); 
/*     */     } 
/*     */     if (((Boolean)this.s3C.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketUpdateScore) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketUpdateScore"); 
/*     */     } 
/*     */     if (((Boolean)this.s3E.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketTeams) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketTeams"); 
/*     */     } 
/*     */     if (((Boolean)this.s3F.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketCustomPayload) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketCustomPayload"); 
/*     */     } 
/*     */     if (((Boolean)this.s40.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketDisconnect) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketDisconnect"); 
/*     */     } 
/*     */     if (((Boolean)this.s41.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketServerDifficulty) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketServerDifficulty"); 
/*     */     } 
/*     */     if (((Boolean)this.s42.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketCombatEvent) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketCombatEvent"); 
/*     */     } 
/*     */     if (((Boolean)this.s43.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketCamera) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketCamera"); 
/*     */     } 
/*     */     if (((Boolean)this.s44.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketWorldBorder) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketWorldBorder"); 
/*     */     } 
/*     */     if (((Boolean)this.s45.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketTitle) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketTitle"); 
/*     */     } 
/*     */     if (((Boolean)this.s47.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketPlayerListHeaderFooter) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketPlayerListHeaderFooter"); 
/*     */     } 
/*     */     if (((Boolean)this.s48.get()).booleanValue() && packet instanceof net.minecraft.network.play.server.SPacketResourcePackSend) {
/*     */       event.cancelEvent();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 SPacketResourcePackSend"); 
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onMove(@NotNull MoveEvent event) {
/*     */     Intrinsics.checkParameterIsNotNull(event, "event");
/*     */     if (((Boolean)this.noMove.get()).booleanValue()) {
/*     */       event.zero();
/*     */       if (((Boolean)this.deBug.get()).booleanValue())
/*     */         Chat.print("取消 Move"); 
/*     */     } 
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getTag() {
/*     */     return "PacketDisabler By Xinkong";
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\retreat\PacketDisabler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */