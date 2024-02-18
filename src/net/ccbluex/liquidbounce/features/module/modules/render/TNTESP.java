/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ import java.awt.Color;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.IClassProvider;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ 
/*    */ @ModuleInfo(name = "TNTESP", description = "Allows you to see ignited TNT blocks through walls.", category = ModuleCategory.RENDER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\006H\007¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/TNTESP;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "onRender3D", "", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "XSJClient"})
/*    */ public final class TNTESP extends Module {
/*    */   @EventTarget
/*    */   public final void onRender3D(@NotNull Render3DEvent event) {
/* 16 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  Collection collection1 = MinecraftInstance.mc.getTheWorld().getLoadedEntityList(); IClassProvider iClassProvider = MinecraftInstance.classProvider; int $i$f$filter = 0;
/*    */ 
/*    */     
/* 19 */     Collection collection2 = collection1; Collection<Object> destination$iv$iv = new ArrayList(); int $i$f$filterTo = 0;
/* 20 */     for (Iterator iterator2 = collection2.iterator(); iterator2.hasNext(); ) { Object element$iv$iv = iterator2.next(), p1 = element$iv$iv; int $i$a$-unknown-TNTESP$onRender3D$1 = 0; if (iClassProvider.isEntityTNTPrimed(p1))
/* 21 */         destination$iv$iv.add(element$iv$iv);  }  Iterable $this$forEach$iv = destination$iv$iv; int $i$f$forEach = 0;
/* 22 */     Iterator iterator1 = $this$forEach$iv.iterator(); if (iterator1.hasNext()) { Object element$iv = iterator1.next(); IEntity it = (IEntity)element$iv; int $i$a$-forEach-TNTESP$onRender3D$2 = 0;
/*    */       RenderUtils.drawEntityBox(it, Color.RED, false); }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\TNTESP.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */