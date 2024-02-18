/*    */ package net.ccbluex.liquidbounce.features.module.modules.misc;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.misc.RandomUtils;
/*    */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*    */ import net.ccbluex.liquidbounce.utils.timer.TimeUtils;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import net.ccbluex.liquidbounce.value.TextValue;
/*    */ 
/*    */ 
/*    */ @ModuleInfo(name = "Spammer", description = "Spams the chat with a given message.", category = ModuleCategory.MISC)
/*    */ public class Spammer
/*    */   extends Module
/*    */ {
/* 21 */   private final IntegerValue maxDelayValue = new IntegerValue("MaxDelay", 1000, 0, 5000)
/*    */     {
/*    */       protected void onChanged(Integer oldValue, Integer newValue) {
/* 24 */         int minDelayValueObject = ((Integer)Spammer.this.minDelayValue.get()).intValue();
/*    */         
/* 26 */         if (minDelayValueObject > newValue.intValue())
/* 27 */           set(Integer.valueOf(minDelayValueObject)); 
/* 28 */         Spammer.this.delay = TimeUtils.randomDelay(((Integer)Spammer.this.minDelayValue.get()).intValue(), ((Integer)Spammer.this.maxDelayValue.get()).intValue());
/*    */       }
/*    */     };
/*    */   
/* 32 */   private final IntegerValue minDelayValue = new IntegerValue("MinDelay", 500, 0, 5000)
/*    */     {
/*    */       protected void onChanged(Integer oldValue, Integer newValue)
/*    */       {
/* 36 */         int maxDelayValueObject = ((Integer)Spammer.this.maxDelayValue.get()).intValue();
/*    */         
/* 38 */         if (maxDelayValueObject < newValue.intValue())
/* 39 */           set(Integer.valueOf(maxDelayValueObject)); 
/* 40 */         Spammer.this.delay = TimeUtils.randomDelay(((Integer)Spammer.this.minDelayValue.get()).intValue(), ((Integer)Spammer.this.maxDelayValue.get()).intValue());
/*    */       }
/*    */     };
/*    */   
/* 44 */   private final TextValue messageValue = new TextValue("Message", "XSJ Client On HYT | Retreat Client(.LOL) | Retreat on Top | 我正在使用 Retreat客户端 ");
/* 45 */   private final BoolValue customValue = new BoolValue("Custom", false);
/*    */   
/* 47 */   private final MSTimer msTimer = new MSTimer();
/* 48 */   private long delay = TimeUtils.randomDelay(((Integer)this.minDelayValue.get()).intValue(), ((Integer)this.maxDelayValue.get()).intValue());
/*    */   
/*    */   @EventTarget
/*    */   public void onUpdate(UpdateEvent event) {
/* 52 */     if (this.msTimer.hasTimePassed(this.delay)) {
/* 53 */       mc.getThePlayer().sendChatMessage(((Boolean)this.customValue.get()).booleanValue() ? replace((String)this.messageValue.get()) : ((String)this.messageValue.get() + " >" + RandomUtils.randomString(5 + (new Random()).nextInt(5)) + "<"));
/* 54 */       this.msTimer.reset();
/* 55 */       this.delay = TimeUtils.randomDelay(((Integer)this.minDelayValue.get()).intValue(), ((Integer)this.maxDelayValue.get()).intValue());
/*    */     } 
/*    */   }
/*    */   
/*    */   private String replace(String object) {
/* 60 */     Random r = new Random();
/*    */     
/* 62 */     while (object.contains("%f")) {
/* 63 */       object = object.substring(0, object.indexOf("%f")) + r.nextFloat() + object.substring(object.indexOf("%f") + "%f".length());
/*    */     }
/* 65 */     while (object.contains("%i")) {
/* 66 */       object = object.substring(0, object.indexOf("%i")) + r.nextInt(10000) + object.substring(object.indexOf("%i") + "%i".length());
/*    */     }
/* 68 */     while (object.contains("%s")) {
/* 69 */       object = object.substring(0, object.indexOf("%s")) + RandomUtils.randomString(r.nextInt(8) + 1) + object.substring(object.indexOf("%s") + "%s".length());
/*    */     }
/* 71 */     while (object.contains("%ss")) {
/* 72 */       object = object.substring(0, object.indexOf("%ss")) + RandomUtils.randomString(r.nextInt(4) + 1) + object.substring(object.indexOf("%ss") + "%ss".length());
/*    */     }
/* 74 */     while (object.contains("%ls"))
/* 75 */       object = object.substring(0, object.indexOf("%ls")) + RandomUtils.randomString(r.nextInt(15) + 1) + object.substring(object.indexOf("%ls") + "%ls".length()); 
/* 76 */     return object;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\misc\Spammer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */