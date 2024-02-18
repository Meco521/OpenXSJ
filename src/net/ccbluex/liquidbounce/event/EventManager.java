/*    */ package net.ccbluex.liquidbounce.event;
/*    */ 
/*    */ import java.lang.reflect.Method;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.function.Predicate;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.TypeCastException;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0002\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\020!\n\002\030\002\n\000\n\002\020\002\n\002\b\003\n\002\030\002\n\002\b\003\030\0002\0020\001B\005¢\006\002\020\002J\016\020\t\032\0020\n2\006\020\013\032\0020\006J\016\020\f\032\0020\n2\006\020\r\032\0020\016J\016\020\017\032\0020\n2\006\020\020\032\0020\016R(\020\003\032\034\022\f\022\n\022\006\b\001\022\0020\0060\005\022\n\022\b\022\004\022\0020\b0\0070\004X\004¢\006\002\n\000¨\006\021"}, d2 = {"Lnet/ccbluex/liquidbounce/event/EventManager;", "", "()V", "registry", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lnet/ccbluex/liquidbounce/event/Event;", "", "Lnet/ccbluex/liquidbounce/event/EventHook;", "callEvent", "", "event", "registerListener", "listener", "Lnet/ccbluex/liquidbounce/event/Listenable;", "unregisterListener", "listenable", "XSJClient"})
/*    */ public final class EventManager
/*    */ {
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\016\n\000\n\002\020\013\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lnet/ccbluex/liquidbounce/event/EventHook;", "test"})
/*    */   static final class EventManager$unregisterListener$1<T>
/*    */     implements Predicate<EventHook>
/*    */   {
/*    */     EventManager$unregisterListener$1(Listenable param1Listenable) {}
/*    */     
/*    */     public final boolean test(@NotNull EventHook it) {
/* 35 */       Intrinsics.checkParameterIsNotNull(it, "it"); return Intrinsics.areEqual(it.getEventClass(), this.$listenable); } } public final void unregisterListener(@NotNull Listenable listenable) { Intrinsics.checkParameterIsNotNull(listenable, "listenable"); Iterator<Map.Entry> iterator; HashMap<Class<? extends Event>, List<EventHook>> hashMap; boolean bool; for (hashMap = this.registry, bool = false, iterator = hashMap.entrySet().iterator(); iterator.hasNext(); ) { Map.Entry entry1 = iterator.next(), entry2 = entry1; boolean bool1 = false; Class<? extends Event> clazz = (Class)entry2.getKey(); entry2 = entry1; bool1 = false; List<EventHook> targets = (List)entry2.getValue(); targets.removeIf(new EventManager$unregisterListener$1(listenable));
/*    */       
/* 37 */       this.registry.put(clazz, targets); }
/*    */      }
/*    */   private final HashMap<Class<? extends Event>, List<EventHook>> registry = new HashMap<>(); public final void registerListener(@NotNull Listenable listener) { Intrinsics.checkParameterIsNotNull(listener, "listener"); for (Method method : listener.getClass().getDeclaredMethods()) {
/*    */       Intrinsics.checkExpressionValueIsNotNull(method, "method"); if (method.isAnnotationPresent((Class)EventTarget.class) && (method.getParameterTypes()).length == 1) {
/*    */         if (!method.isAccessible())
/*    */           method.setAccessible(true);  if (method.getParameterTypes()[0] == null)
/*    */           throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<out net.ccbluex.liquidbounce.event.Event>");  Class<?> eventClass = method.getParameterTypes()[0]; EventTarget eventTarget = method.<EventTarget>getAnnotation(EventTarget.class); Intrinsics.checkExpressionValueIsNotNull(this.registry.getOrDefault(eventClass, new ArrayList<>()), "registry.getOrDefault(eventClass, ArrayList())"); List<EventHook> invokableEventTargets = this.registry.getOrDefault(eventClass, new ArrayList<>()); Intrinsics.checkExpressionValueIsNotNull(eventTarget, "eventTarget");
/*    */         invokableEventTargets.add(new EventHook(listener, method, eventTarget));
/*    */         this.registry.put(eventClass, invokableEventTargets);
/*    */       } 
/* 47 */     }  } public final void callEvent(@NotNull Event event) { Intrinsics.checkParameterIsNotNull(event, "event"); if ((List)this.registry.get(event.getClass()) != null) { Intrinsics.checkExpressionValueIsNotNull(this.registry.get(event.getClass()), "registry[event.javaClass] ?: return"); List targets = this.registry.get(event.getClass());
/*    */       
/* 49 */       for (EventHook invokableEventTarget : targets) {
/*    */         try {
/* 51 */           if (!invokableEventTarget.getEventClass().handleEvents() && !invokableEventTarget.isIgnoreCondition()) {
/*    */             continue;
/*    */           }
/* 54 */           invokableEventTarget.getMethod().invoke(invokableEventTarget.getEventClass(), new Object[] { event });
/* 55 */         } catch (Throwable throwable) {
/* 56 */           throwable.printStackTrace();
/*    */         } 
/*    */       } 
/*    */       return; }
/*    */     
/*    */     (List)this.registry.get(event.getClass()); }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\event\EventManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */