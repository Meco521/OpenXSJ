/*     */ package net.ccbluex.liquidbounce.features.module.modules.retreat;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.entity.effect.EntityLightningBolt;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ @ModuleInfo(name = "AttackParticle", category = ModuleCategory.RETREAT, description = "更多击打特效")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\022\020\t\032\0020\n2\b\020\013\032\004\030\0010\fH\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\026\020\005\032\n \007*\004\030\0010\0060\006X\004¢\006\002\n\000R\016\020\b\032\0020\004X\004¢\006\002\n\000¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/retreat/AttackParticle;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "oldMc", "Lnet/minecraft/client/Minecraft;", "kotlin.jvm.PlatformType", "particlesMode", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class AttackParticle extends Module {
/*  17 */   private final ListValue modeValue = new ListValue("RenderMode", new String[] { "Kill", "Keep" }, "Kill");
/*  18 */   private final Minecraft oldMc = Minecraft.func_71410_x();
/*     */   
/*  20 */   private final ListValue particlesMode = new ListValue(
/*  21 */       "Mode", 
/*  22 */       new String[] { 
/*  23 */         "lightning", 
/*  24 */         "heart", 
/*  25 */         "barrier", 
/*  26 */         "lava", 
/*  27 */         "smoke", 
/*  28 */         "mobappearance", 
/*  29 */         "slime", 
/*  30 */         "flame", 
/*  31 */         "explode", 
/*  32 */         "hugeexplode", 
/*  33 */         "largeexplode", 
/*  34 */         "largesmoke"
/*     */       },
/*  36 */       "lightning");
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@Nullable UpdateEvent event) {
/*  41 */     EnumParticleTypes em = EnumParticleTypes.HEART;
/*  42 */     String str = (String)this.particlesMode.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode())
/*     */     
/*     */     { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 1316266852:
/*  59 */         if (str.equals("mobappearance")) {
/*  60 */           em = EnumParticleTypes.MOB_APPEARANCE;
/*     */         }
/*     */         break;
/*     */ 
/*     */       
/*     */       case 3314400:
/*     */         if (str.equals("lava")) {
/*     */           em = EnumParticleTypes.LAVA;
/*     */         }
/*     */         break;
/*     */ 
/*     */       
/*     */       case -333143113:
/*     */         if (str.equals("barrier")) {
/*     */           em = EnumParticleTypes.BARRIER;
/*     */         }
/*     */         break;
/*     */       
/*     */       case -945474234:
/*  79 */         if (str.equals("largeexplode"))
/*  80 */           em = EnumParticleTypes.EXPLOSION_LARGE;  break;case -1309148959: if (str.equals("explode"))
/*     */           em = EnumParticleTypes.EXPLOSION_NORMAL;  break;case 2058541844: if (str.equals("largesmoke"))
/*     */           em = EnumParticleTypes.SMOKE_LARGE;  break;
/*  83 */       case 2010163158: if (str.equals("hugeexplode"))
/*  84 */           em = EnumParticleTypes.EXPLOSION_HUGE;  break;case 109562223: if (str.equals("smoke"))
/*     */           em = EnumParticleTypes.SMOKE_NORMAL;  break;case 97513267: if (str.equals("flame"))
/*     */           em = EnumParticleTypes.FLAME;  break;case 99151942: if (str.equals("heart"))
/*     */           em = EnumParticleTypes.HEART;  break;case 109526728: if (str.equals("slime"))
/*  88 */           em = EnumParticleTypes.SLIME;  break; }  if (Intrinsics.areEqual(this.modeValue.get(), "Kill")) {
/*  89 */       if (Retreat.INSTANCE.getModuleManager().getModule(KillAura.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura");  IEntityLivingBase target = ((KillAura)Retreat.INSTANCE.getModuleManager().getModule(KillAura.class)).getTarget();
/*  90 */       if (target != null && 
/*  91 */         target.getHealth() < 0.1D) {
/*  92 */         if (StringsKt.equals((String)this.particlesMode.get(), "lightning", true)) {
/*  93 */           EntityLightningBolt ent = new EntityLightningBolt(
/*  94 */               (World)this.oldMc.field_71441_e, 
/*  95 */               target.getPosX(), 
/*  96 */               target.getPosY(), 
/*  97 */               target.getPosZ(), 
/*  98 */               true);
/*     */           
/* 100 */           this.oldMc.field_71441_e.func_73027_a(-1, (Entity)ent);
/* 101 */           MinecraftInstance.mc.getSoundHandler().playSound("entity.lightning.impact", 1.0F);
/* 102 */           MinecraftInstance.mc.getSoundHandler().playSound("entity.lightning.thunder", 1.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         }
/*     */         else {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 141 */           (new int[1])[0] = 1; this.oldMc.field_71438_f.func_180442_a(em.func_179348_c(), false, target.getPosX(), target.getPosY(), target.getPosZ(), 1.0D, 1.0D, 1.0D, new int[] { (new int[1]).length });
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 148 */     if (Intrinsics.areEqual(this.modeValue.get(), "Keep")) {
/* 149 */       if (Retreat.INSTANCE.getModuleManager().getModule(KillAura.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura");  IEntityLivingBase target = ((KillAura)Retreat.INSTANCE.getModuleManager().getModule(KillAura.class)).getTarget();
/* 150 */       if (target != null)
/* 151 */         if (StringsKt.equals((String)this.particlesMode.get(), "lightning", true)) {
/* 152 */           EntityLightningBolt ent = new EntityLightningBolt(
/* 153 */               (World)this.oldMc.field_71441_e, 
/* 154 */               target.getPosX(), 
/* 155 */               target.getPosY(), 
/* 156 */               target.getPosZ(), 
/* 157 */               true);
/*     */           
/* 159 */           this.oldMc.field_71441_e.func_73027_a(-1, (Entity)ent);
/* 160 */           MinecraftInstance.mc.getSoundHandler().playSound("entity.lightning.impact", 1.0F);
/* 161 */           MinecraftInstance.mc.getSoundHandler().playSound("entity.lightning.thunder", 1.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         }
/*     */         else {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 172 */           (new int[1])[0] = 1; this.oldMc.field_71438_f.func_180442_a(em.func_179348_c(), false, target.getPosX(), target.getPosY(), target.getPosZ(), 1.0D, 1.0D, 1.0D, new int[] { (new int[1]).length });
/*     */         }  
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\retreat\AttackParticle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */