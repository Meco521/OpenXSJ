/*    */ package novoline.module;
/*    */ import kotlin.TypeCastException;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import net.minecraft.network.play.server.SPacketChangeGameState;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "Ambience", category = ModuleCategory.WORLD, description = "IDK")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000>\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\t\n\002\b\005\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\021\032\0020\022H\026J\020\020\023\032\0020\0222\006\020\024\032\0020\025H\007J\020\020\026\032\0020\0222\006\020\024\032\0020\027H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\032\020\006\032\0020\007X\016¢\006\016\n\000\032\004\b\b\020\t\"\004\b\n\020\013R\016\020\f\032\0020\rX\004¢\006\002\n\000R\016\020\016\032\0020\rX\004¢\006\002\n\000R\016\020\017\032\0020\020X\004¢\006\002\n\000¨\006\030"}, d2 = {"Lnovoline/module/Ambience;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "changeWorldTimeSpeedValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "customWorldTimeValue", "i", "", "getI", "()J", "setI", "(J)V", "timeModeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "weatherModeValue", "weatherStrengthValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onDisable", "", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class Ambience extends Module {
/* 18 */   private final ListValue timeModeValue = new ListValue("TimeMode", new String[] { "None", "Normal", "Custom" }, "Normal");
/* 19 */   private final ListValue weatherModeValue = new ListValue("WeatherMode", new String[] { "None", "Sun", "Rain", "Thunder" }, "None");
/* 20 */   private final IntegerValue customWorldTimeValue = new IntegerValue("CustomTime", 1000, 0, 24000);
/* 21 */   private final IntegerValue changeWorldTimeSpeedValue = new IntegerValue("ChangeWorldTimeSpeed", 150, 10, 500);
/* 22 */   private final FloatValue weatherStrengthValue = new FloatValue("WeatherStrength", 1.0F, 0.0F, 1.0F);
/*    */   private long i;
/* 24 */   public final long getI() { return this.i; } public final void setI(long <set-?>) { this.i = <set-?>; }
/*    */   
/*    */   public void onDisable() {
/* 27 */     this.i = 0L;
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 32 */     Intrinsics.checkParameterIsNotNull(event, "event"); String str = (String)this.timeModeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case -1039745817:
/* 33 */         if (str.equals("normal"))
/* 34 */         { if (this.i < 24000L) {
/* 35 */             this.i += ((Number)this.changeWorldTimeSpeedValue.get()).longValue();
/*    */           } else {
/* 37 */             this.i = 0L;
/*    */           } 
/* 39 */           Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71441_e, "mc2.world"); MinecraftInstance.mc2.field_71441_e.func_72877_b(this.i); }  break;
/*    */       case -1349088399:
/* 41 */         if (str.equals("custom")) {
/* 42 */           Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71441_e, "mc2.world"); MinecraftInstance.mc2.field_71441_e.func_72877_b(((Number)this.customWorldTimeValue.get()).intValue());
/*    */         } 
/*    */         break; }
/*    */     
/* 46 */     str = (String)this.weatherModeValue.get(); bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) {
/*    */ 
/*    */ 
/*    */       
/*    */       case 3492756:
/* 51 */         if (str.equals("rain"))
/* 52 */         { MinecraftInstance.mc2.field_71441_e.func_72894_k(((Number)this.weatherStrengthValue.get()).floatValue());
/* 53 */           MinecraftInstance.mc2.field_71441_e.func_147442_i(0.0F); }  break;
/*    */       case -1334895388:
/* 55 */         if (str.equals("thunder")) {
/* 56 */           MinecraftInstance.mc2.field_71441_e.func_72894_k(((Number)this.weatherStrengthValue.get()).floatValue());
/* 57 */           MinecraftInstance.mc2.field_71441_e.func_147442_i(((Number)this.weatherStrengthValue.get()).floatValue());
/*    */         }  break;
/*    */       case 114252:
/*    */         if (str.equals("sun")) {
/*    */           MinecraftInstance.mc2.field_71441_e.func_72894_k(0.0F); MinecraftInstance.mc2.field_71441_e.func_147442_i(0.0F);
/*    */         } 
/*    */         break;
/* 64 */     }  } @EventTarget public final void onPacket(@NotNull PacketEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); IPacket packet = event.getPacket();
/*    */     
/* 66 */     if (!this.timeModeValue.equals("none") && packet instanceof net.minecraft.network.play.server.SPacketTimeUpdate) {
/* 67 */       event.cancelEvent();
/*    */     }
/*    */     
/* 70 */     if (!this.weatherModeValue.equals("none") && packet instanceof SPacketChangeGameState) {
/* 71 */       int i = ((SPacketChangeGameState)packet).func_149138_c(); if (7 > i) { 8; } else if (8 >= i)
/* 72 */       { event.cancelEvent(); }
/*    */     
/*    */     }  }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\novoline\module\Ambience.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */