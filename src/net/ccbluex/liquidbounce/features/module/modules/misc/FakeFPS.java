/*    */ package net.ccbluex.liquidbounce.features.module.modules.misc;
/*    */ import kotlin.Metadata;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ @ModuleInfo(name = "FakeFPS", description = "无敌增强fps by:凡哥 lovely苗贺涵", category = ModuleCategory.MISC)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\032\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\000\n\002\030\002\n\002\b\004\b\007\030\0002\0020\001B\005¢\006\002\020\002J\006\020\t\032\0020\004R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\006X\004¢\006\002\n\000R\016\020\b\032\0020\004X\016¢\006\002\n\000¨\006\n"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/misc/FakeFPS;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "fps", "", "maxFps", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "minFps", "minecraftFPS", "getFakeFPS", "XSJClient"})
/*    */ public final class FakeFPS extends Module {
/* 12 */   private final IntegerValue maxFps = new FakeFPS$maxFps$1("MaxFPS", 1000, 30, 100000); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/misc/FakeFPS$maxFps$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class FakeFPS$maxFps$1 extends IntegerValue { FakeFPS$maxFps$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*    */      protected void onChanged(int oldValue, int newValue) {
/* 14 */       if (((Number)FakeFPS.this.minFps.get()).intValue() > newValue) set(FakeFPS.this.minFps.get()); 
/*    */     } }
/*    */   
/*    */   private int minecraftFPS;
/* 18 */   private final IntegerValue minFps = new FakeFPS$minFps$1("MinFPS", 900, 30, 3000); private int fps; @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/misc/FakeFPS$minFps$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class FakeFPS$minFps$1 extends IntegerValue { FakeFPS$minFps$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*    */      protected void onChanged(int oldValue, int newValue) {
/* 20 */       if (((Number)FakeFPS.this.maxFps.get()).intValue() < newValue) set(FakeFPS.this.maxFps.get());
/*    */     
/*    */     } }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final int getFakeFPS() {
/* 28 */     if (this.minecraftFPS != Minecraft.func_175610_ah()) {
/* 29 */       this.fps = RandomUtils.nextInt(((Number)this.minFps.get()).intValue(), ((Number)this.maxFps.get()).intValue());
/* 30 */       this.minecraftFPS = Minecraft.func_175610_ah();
/*    */     } 
/* 32 */     return this.fps;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\misc\FakeFPS.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */