/*    */ package net.ccbluex.liquidbounce.features.module.modules.world;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.TypeCastException;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.text.StringsKt;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @ModuleInfo(name = "Ambience", description = "Change your world time and weather client-side.", category = ModuleCategory.WORLD)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000B\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\002\b\003\n\002\030\002\n\000\n\002\020\t\n\002\b\004\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\022\032\0020\023H\026J\020\020\024\032\0020\0232\006\020\025\032\0020\026H\007J\020\020\027\032\0020\0232\006\020\025\032\0020\030H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\026\020\007\032\004\030\0010\b8VX\004¢\006\006\032\004\b\t\020\nR\016\020\013\032\0020\fX\004¢\006\002\n\000R\016\020\r\032\0020\016X\016¢\006\002\n\000R\016\020\017\032\0020\fX\004¢\006\002\n\000R\016\020\020\032\0020\fX\004¢\006\002\n\000R\016\020\021\032\0020\004X\004¢\006\002\n\000¨\006\031"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/world/Ambience;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "cycleSpeedValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "rainStrengthValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "tag", "", "getTag", "()Ljava/lang/String;", "tagValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "timeCycle", "", "timeModeValue", "weatherModeValue", "worldTimeValue", "onEnable", "", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class Ambience extends Module {
/* 24 */   private final ListValue timeModeValue = new ListValue("Time", new String[] { "Static", "Cycle" }, "Static");
/* 25 */   private final IntegerValue cycleSpeedValue = new IntegerValue("CycleSpeed", 1, -24, 24);
/* 26 */   private final IntegerValue worldTimeValue = new IntegerValue("Time", 12000, 0, 24000);
/* 27 */   private final ListValue weatherModeValue = new ListValue("Weather", new String[] { "Clear", "Rain", "NoModification" }, "Clear");
/* 28 */   private final FloatValue rainStrengthValue = new FloatValue("RainStrength", 0.1F, 0.01F, 1.0F);
/* 29 */   private final ListValue tagValue = new ListValue("Tag", new String[] { "TimeOnly", "Simplified", "Detailed", "None" }, "TimeOnly");
/*    */   
/*    */   private long timeCycle;
/*    */   
/*    */   public void onEnable() {
/* 34 */     this.timeCycle = 0L;
/*    */   }
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/* 40 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.classProvider.isSPacketTimeUpdate(event.getPacket()))
/* 41 */       event.cancelEvent(); 
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 46 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (StringsKt.equals((String)this.timeModeValue.get(), "static", true)) {
/* 47 */       Intrinsics.checkExpressionValueIsNotNull((Minecraft.func_71410_x()).field_71441_e, "Minecraft.getMinecraft().world"); (Minecraft.func_71410_x()).field_71441_e.func_72877_b(((Number)this.worldTimeValue.get()).intValue());
/*    */     } else {
/* 49 */       Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71441_e, "mc2.world"); MinecraftInstance.mc2.field_71441_e.func_72877_b(this.timeCycle);
/* 50 */       this.timeCycle += (((Number)this.cycleSpeedValue.get()).intValue() * 10);
/*    */       
/* 52 */       if (this.timeCycle > 24000L) this.timeCycle = 0L; 
/* 53 */       if (this.timeCycle < 0L) this.timeCycle = 24000L;
/*    */     
/*    */     } 
/* 56 */     if (!StringsKt.equals((String)this.weatherModeValue.get(), "nomodification", true))
/* 57 */       MinecraftInstance.mc2.field_71441_e.func_72894_k(StringsKt.equals((String)this.weatherModeValue.get(), "clear", true) ? 0.0F : ((Number)this.rainStrengthValue.get()).floatValue()); 
/*    */   }
/*    */   @Nullable
/*    */   public String getTag() {
/* 61 */     String str = (String)this.tagValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case -2076556295:
/* 62 */         if (str.equals("timeonly")) return StringsKt.equals((String)this.timeModeValue.get(), "static", true) ? String.valueOf(((Number)this.worldTimeValue.get()).intValue()) : String.valueOf(this.timeCycle);  break;
/* 63 */       case -1427350696: if (str.equals("simplified")); break;
/* 64 */       case 1044731056: if (str.equals("detailed")); break; }
/* 65 */      return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\world\Ambience.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */