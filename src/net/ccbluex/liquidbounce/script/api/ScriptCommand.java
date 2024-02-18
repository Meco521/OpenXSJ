/*    */ package net.ccbluex.liquidbounce.script.api;
/*    */ import jdk.nashorn.api.scripting.JSObject;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\020\016\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\021\n\002\b\005\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\033\020\t\032\0020\n2\f\020\013\032\b\022\004\022\0020\0070\fH\026¢\006\002\020\rJ\026\020\016\032\0020\n2\006\020\017\032\0020\0072\006\020\020\032\0020\003R\016\020\002\032\0020\003X\004¢\006\002\n\000R*\020\005\032\036\022\004\022\0020\007\022\004\022\0020\0030\006j\016\022\004\022\0020\007\022\004\022\0020\003`\bX\004¢\006\002\n\000¨\006\021"}, d2 = {"Lnet/ccbluex/liquidbounce/script/api/ScriptCommand;", "Lnet/ccbluex/liquidbounce/features/command/Command;", "commandObject", "Ljdk/nashorn/api/scripting/JSObject;", "(Ljdk/nashorn/api/scripting/JSObject;)V", "events", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "execute", "", "args", "", "([Ljava/lang/String;)V", "on", "eventName", "handler", "XSJClient"})
/*    */ public final class ScriptCommand extends Command {
/*    */   public ScriptCommand(@NotNull JSObject commandObject) {
/*  9 */     super((String)commandObject.getMember("name"), 
/* 10 */         Arrays.<String>copyOf((String[])ScriptUtils.convert(commandObject.getMember("aliases"), String[].class), ((String[])ScriptUtils.convert(commandObject.getMember("aliases"), String[].class)).length));
/*    */     this.commandObject = commandObject;
/* 12 */     this.events = new HashMap<>();
/*    */   }
/*    */ 
/*    */   
/*    */   private final HashMap<String, JSObject> events;
/*    */   private final JSObject commandObject;
/*    */   
/*    */   public final void on(@NotNull String eventName, @NotNull JSObject handler) {
/* 20 */     Intrinsics.checkParameterIsNotNull(eventName, "eventName"); Intrinsics.checkParameterIsNotNull(handler, "handler"); this.events.put(eventName, handler);
/*    */   }
/*    */   
/*    */   public void execute(@NotNull String[] args) {
/* 24 */     Intrinsics.checkParameterIsNotNull(args, "args"); try {
/* 25 */       if ((JSObject)this.events.get("execute") != null) { ((JSObject)this.events.get("execute")).call(this.commandObject, new Object[] { args }); } else { (JSObject)this.events.get("execute"); } 
/* 26 */     } catch (Throwable throwable) {
/* 27 */       ClientUtils.getLogger().error("[ScriptAPI] Exception in command '" + getCommand() + "'!", throwable);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\script\api\ScriptCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */