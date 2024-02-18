/*    */ package net.ccbluex.liquidbounce.ui.client.hud;
/*    */ 
/*    */ import com.google.gson.Gson;
/*    */ import com.google.gson.GsonBuilder;
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.Element;
/*    */ import net.ccbluex.liquidbounce.value.Value;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\030\0002\0020\001B\017\b\026\022\006\020\002\032\0020\003¢\006\002\020\004B\017\b\026\022\006\020\005\032\0020\006¢\006\002\020\007J\006\020\n\032\0020\006J\006\020\013\032\0020\003R\016\020\b\032\0020\tX\016¢\006\002\n\000¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/Config;", "", "config", "", "(Ljava/lang/String;)V", "hud", "Lnet/ccbluex/liquidbounce/ui/client/hud/HUD;", "(Lnet/ccbluex/liquidbounce/ui/client/hud/HUD;)V", "jsonArray", "Lcom/google/gson/JsonArray;", "toHUD", "toJson", "XSJClient"})
/*    */ public final class Config {
/* 16 */   private JsonArray jsonArray = new JsonArray();
/*    */   
/*    */   public Config(@NotNull String config) {
/* 19 */     Intrinsics.checkExpressionValueIsNotNull((new Gson()).fromJson(config, JsonArray.class), "Gson().fromJson(config, JsonArray::class.java)"); this.jsonArray = (JsonArray)(new Gson()).fromJson(config, JsonArray.class);
/*    */   }
/*    */   
/*    */   public Config(@NotNull HUD hud) {
/* 23 */     for (Element element : hud.getElements()) {
/* 24 */       JsonObject elementObject = new JsonObject();
/* 25 */       elementObject.addProperty("Type", element.getName());
/* 26 */       elementObject.addProperty("X", Double.valueOf(element.getX()));
/* 27 */       elementObject.addProperty("Y", Double.valueOf(element.getY()));
/* 28 */       elementObject.addProperty("Scale", Float.valueOf(element.getScale()));
/* 29 */       elementObject.addProperty("HorizontalFacing", element.getSide().getHorizontal().getSideName());
/* 30 */       elementObject.addProperty("VerticalFacing", element.getSide().getVertical().getSideName());
/*    */       
/* 32 */       for (Value value : element.getValues()) {
/* 33 */         elementObject.add(value.getName(), value.toJson());
/*    */       }
/* 35 */       this.jsonArray.add((JsonElement)elementObject);
/*    */     } 
/*    */   } @NotNull
/*    */   public final String toJson() {
/* 39 */     Intrinsics.checkExpressionValueIsNotNull((new GsonBuilder()).setPrettyPrinting().create().toJson((JsonElement)this.jsonArray), "GsonBuilder().setPrettyP…reate().toJson(jsonArray)"); return (new GsonBuilder()).setPrettyPrinting().create().toJson((JsonElement)this.jsonArray);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final HUD toHUD() {
/*    */     // Byte code:
/*    */     //   0: new net/ccbluex/liquidbounce/ui/client/hud/HUD
/*    */     //   3: dup
/*    */     //   4: invokespecial <init> : ()V
/*    */     //   7: astore_1
/*    */     //   8: nop
/*    */     //   9: aload_0
/*    */     //   10: getfield jsonArray : Lcom/google/gson/JsonArray;
/*    */     //   13: invokevirtual iterator : ()Ljava/util/Iterator;
/*    */     //   16: astore_3
/*    */     //   17: aload_3
/*    */     //   18: invokeinterface hasNext : ()Z
/*    */     //   23: ifeq -> 536
/*    */     //   26: aload_3
/*    */     //   27: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   32: checkcast com/google/gson/JsonElement
/*    */     //   35: astore_2
/*    */     //   36: nop
/*    */     //   37: aload_2
/*    */     //   38: instanceof com/google/gson/JsonObject
/*    */     //   41: ifne -> 47
/*    */     //   44: goto -> 533
/*    */     //   47: aload_2
/*    */     //   48: checkcast com/google/gson/JsonObject
/*    */     //   51: ldc 'Type'
/*    */     //   53: invokevirtual has : (Ljava/lang/String;)Z
/*    */     //   56: ifne -> 62
/*    */     //   59: goto -> 533
/*    */     //   62: aload_2
/*    */     //   63: checkcast com/google/gson/JsonObject
/*    */     //   66: ldc 'Type'
/*    */     //   68: invokevirtual get : (Ljava/lang/String;)Lcom/google/gson/JsonElement;
/*    */     //   71: dup
/*    */     //   72: ldc 'jsonObject["Type"]'
/*    */     //   74: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   77: invokevirtual getAsString : ()Ljava/lang/String;
/*    */     //   80: astore #4
/*    */     //   82: getstatic net/ccbluex/liquidbounce/ui/client/hud/HUD.Companion : Lnet/ccbluex/liquidbounce/ui/client/hud/HUD$Companion;
/*    */     //   85: invokevirtual getElements : ()[Ljava/lang/Class;
/*    */     //   88: astore #7
/*    */     //   90: aload #7
/*    */     //   92: arraylength
/*    */     //   93: istore #8
/*    */     //   95: iconst_0
/*    */     //   96: istore #6
/*    */     //   98: iload #6
/*    */     //   100: iload #8
/*    */     //   102: if_icmpge -> 533
/*    */     //   105: aload #7
/*    */     //   107: iload #6
/*    */     //   109: aaload
/*    */     //   110: astore #5
/*    */     //   112: aload #5
/*    */     //   114: ldc net/ccbluex/liquidbounce/ui/client/hud/element/ElementInfo
/*    */     //   116: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
/*    */     //   119: checkcast net/ccbluex/liquidbounce/ui/client/hud/element/ElementInfo
/*    */     //   122: invokeinterface name : ()Ljava/lang/String;
/*    */     //   127: astore #9
/*    */     //   129: aload #9
/*    */     //   131: aload #4
/*    */     //   133: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*    */     //   136: ifeq -> 510
/*    */     //   139: aload #5
/*    */     //   141: invokevirtual newInstance : ()Ljava/lang/Object;
/*    */     //   144: checkcast net/ccbluex/liquidbounce/ui/client/hud/element/Element
/*    */     //   147: astore #10
/*    */     //   149: aload #10
/*    */     //   151: aload_2
/*    */     //   152: checkcast com/google/gson/JsonObject
/*    */     //   155: ldc 'X'
/*    */     //   157: invokevirtual get : (Ljava/lang/String;)Lcom/google/gson/JsonElement;
/*    */     //   160: dup
/*    */     //   161: ldc 'jsonObject["X"]'
/*    */     //   163: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   166: invokevirtual getAsInt : ()I
/*    */     //   169: i2d
/*    */     //   170: invokevirtual setX : (D)V
/*    */     //   173: aload #10
/*    */     //   175: aload_2
/*    */     //   176: checkcast com/google/gson/JsonObject
/*    */     //   179: ldc 'Y'
/*    */     //   181: invokevirtual get : (Ljava/lang/String;)Lcom/google/gson/JsonElement;
/*    */     //   184: dup
/*    */     //   185: ldc 'jsonObject["Y"]'
/*    */     //   187: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   190: invokevirtual getAsInt : ()I
/*    */     //   193: i2d
/*    */     //   194: invokevirtual setY : (D)V
/*    */     //   197: aload #10
/*    */     //   199: aload_2
/*    */     //   200: checkcast com/google/gson/JsonObject
/*    */     //   203: ldc 'Scale'
/*    */     //   205: invokevirtual get : (Ljava/lang/String;)Lcom/google/gson/JsonElement;
/*    */     //   208: dup
/*    */     //   209: ldc 'jsonObject["Scale"]'
/*    */     //   211: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   214: invokevirtual getAsFloat : ()F
/*    */     //   217: invokevirtual setScale : (F)V
/*    */     //   220: aload #10
/*    */     //   222: new net/ccbluex/liquidbounce/ui/client/hud/element/Side
/*    */     //   225: dup
/*    */     //   226: getstatic net/ccbluex/liquidbounce/ui/client/hud/element/Side$Horizontal.Companion : Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Horizontal$Companion;
/*    */     //   229: aload_2
/*    */     //   230: checkcast com/google/gson/JsonObject
/*    */     //   233: ldc 'HorizontalFacing'
/*    */     //   235: invokevirtual get : (Ljava/lang/String;)Lcom/google/gson/JsonElement;
/*    */     //   238: dup
/*    */     //   239: ldc 'jsonObject["HorizontalFacing"]'
/*    */     //   241: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   244: invokevirtual getAsString : ()Ljava/lang/String;
/*    */     //   247: dup
/*    */     //   248: ldc 'jsonObject["HorizontalFacing"].asString'
/*    */     //   250: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   253: invokevirtual getByName : (Ljava/lang/String;)Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Horizontal;
/*    */     //   256: dup
/*    */     //   257: ifnonnull -> 263
/*    */     //   260: invokestatic throwNpe : ()V
/*    */     //   263: getstatic net/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical.Companion : Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical$Companion;
/*    */     //   266: aload_2
/*    */     //   267: checkcast com/google/gson/JsonObject
/*    */     //   270: ldc 'VerticalFacing'
/*    */     //   272: invokevirtual get : (Ljava/lang/String;)Lcom/google/gson/JsonElement;
/*    */     //   275: dup
/*    */     //   276: ldc 'jsonObject["VerticalFacing"]'
/*    */     //   278: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   281: invokevirtual getAsString : ()Ljava/lang/String;
/*    */     //   284: dup
/*    */     //   285: ldc 'jsonObject["VerticalFacing"].asString'
/*    */     //   287: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   290: invokevirtual getByName : (Ljava/lang/String;)Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;
/*    */     //   293: dup
/*    */     //   294: ifnonnull -> 300
/*    */     //   297: invokestatic throwNpe : ()V
/*    */     //   300: invokespecial <init> : (Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Horizontal;Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;)V
/*    */     //   303: invokevirtual setSide : (Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;)V
/*    */     //   306: aload #10
/*    */     //   308: invokevirtual getValues : ()Ljava/util/List;
/*    */     //   311: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   316: astore #12
/*    */     //   318: aload #12
/*    */     //   320: invokeinterface hasNext : ()Z
/*    */     //   325: ifeq -> 381
/*    */     //   328: aload #12
/*    */     //   330: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   335: checkcast net/ccbluex/liquidbounce/value/Value
/*    */     //   338: astore #11
/*    */     //   340: aload_2
/*    */     //   341: checkcast com/google/gson/JsonObject
/*    */     //   344: aload #11
/*    */     //   346: invokevirtual getName : ()Ljava/lang/String;
/*    */     //   349: invokevirtual has : (Ljava/lang/String;)Z
/*    */     //   352: ifeq -> 378
/*    */     //   355: aload #11
/*    */     //   357: aload_2
/*    */     //   358: checkcast com/google/gson/JsonObject
/*    */     //   361: aload #11
/*    */     //   363: invokevirtual getName : ()Ljava/lang/String;
/*    */     //   366: invokevirtual get : (Ljava/lang/String;)Lcom/google/gson/JsonElement;
/*    */     //   369: dup
/*    */     //   370: ldc 'jsonObject[value.name]'
/*    */     //   372: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   375: invokevirtual fromJson : (Lcom/google/gson/JsonElement;)V
/*    */     //   378: goto -> 318
/*    */     //   381: aload_2
/*    */     //   382: checkcast com/google/gson/JsonObject
/*    */     //   385: ldc 'font'
/*    */     //   387: invokevirtual has : (Ljava/lang/String;)Z
/*    */     //   390: ifeq -> 494
/*    */     //   393: aload #10
/*    */     //   395: invokevirtual getValues : ()Ljava/util/List;
/*    */     //   398: checkcast java/lang/Iterable
/*    */     //   401: astore #11
/*    */     //   403: iconst_0
/*    */     //   404: istore #12
/*    */     //   406: aload #11
/*    */     //   408: astore #13
/*    */     //   410: iconst_0
/*    */     //   411: istore #14
/*    */     //   413: aload #13
/*    */     //   415: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   420: astore #15
/*    */     //   422: aload #15
/*    */     //   424: invokeinterface hasNext : ()Z
/*    */     //   429: ifeq -> 464
/*    */     //   432: aload #15
/*    */     //   434: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   439: astore #16
/*    */     //   441: aload #16
/*    */     //   443: checkcast net/ccbluex/liquidbounce/value/Value
/*    */     //   446: astore #17
/*    */     //   448: iconst_0
/*    */     //   449: istore #18
/*    */     //   451: aload #17
/*    */     //   453: instanceof net/ccbluex/liquidbounce/value/FontValue
/*    */     //   456: ifeq -> 422
/*    */     //   459: aload #16
/*    */     //   461: goto -> 465
/*    */     //   464: aconst_null
/*    */     //   465: checkcast net/ccbluex/liquidbounce/value/Value
/*    */     //   468: dup
/*    */     //   469: ifnull -> 493
/*    */     //   472: aload_2
/*    */     //   473: checkcast com/google/gson/JsonObject
/*    */     //   476: ldc 'font'
/*    */     //   478: invokevirtual get : (Ljava/lang/String;)Lcom/google/gson/JsonElement;
/*    */     //   481: dup
/*    */     //   482: ldc 'jsonObject["font"]'
/*    */     //   484: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   487: invokevirtual fromJson : (Lcom/google/gson/JsonElement;)V
/*    */     //   490: goto -> 494
/*    */     //   493: pop
/*    */     //   494: aload_1
/*    */     //   495: aload #10
/*    */     //   497: dup
/*    */     //   498: ldc 'element'
/*    */     //   500: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   503: invokevirtual addElement : (Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;)Lnet/ccbluex/liquidbounce/ui/client/hud/HUD;
/*    */     //   506: pop
/*    */     //   507: goto -> 533
/*    */     //   510: iinc #6, 1
/*    */     //   513: goto -> 98
/*    */     //   516: astore #4
/*    */     //   518: invokestatic getLogger : ()Lorg/apache/logging/log4j/Logger;
/*    */     //   521: ldc 'Error while loading custom hud element from config.'
/*    */     //   523: aload #4
/*    */     //   525: checkcast java/lang/Throwable
/*    */     //   528: invokeinterface error : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*    */     //   533: goto -> 17
/*    */     //   536: getstatic net/ccbluex/liquidbounce/ui/client/hud/HUD.Companion : Lnet/ccbluex/liquidbounce/ui/client/hud/HUD$Companion;
/*    */     //   539: invokevirtual getElements : ()[Ljava/lang/Class;
/*    */     //   542: astore #4
/*    */     //   544: aload #4
/*    */     //   546: arraylength
/*    */     //   547: istore #5
/*    */     //   549: iconst_0
/*    */     //   550: istore_3
/*    */     //   551: iload_3
/*    */     //   552: iload #5
/*    */     //   554: if_icmpge -> 722
/*    */     //   557: aload #4
/*    */     //   559: iload_3
/*    */     //   560: aaload
/*    */     //   561: astore_2
/*    */     //   562: aload_2
/*    */     //   563: ldc net/ccbluex/liquidbounce/ui/client/hud/element/ElementInfo
/*    */     //   565: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
/*    */     //   568: checkcast net/ccbluex/liquidbounce/ui/client/hud/element/ElementInfo
/*    */     //   571: invokeinterface force : ()Z
/*    */     //   576: ifeq -> 693
/*    */     //   579: aload_1
/*    */     //   580: invokevirtual getElements : ()Ljava/util/List;
/*    */     //   583: checkcast java/lang/Iterable
/*    */     //   586: astore #6
/*    */     //   588: iconst_0
/*    */     //   589: istore #7
/*    */     //   591: aload #6
/*    */     //   593: instanceof java/util/Collection
/*    */     //   596: ifeq -> 616
/*    */     //   599: aload #6
/*    */     //   601: checkcast java/util/Collection
/*    */     //   604: invokeinterface isEmpty : ()Z
/*    */     //   609: ifeq -> 616
/*    */     //   612: iconst_1
/*    */     //   613: goto -> 671
/*    */     //   616: aload #6
/*    */     //   618: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   623: astore #8
/*    */     //   625: aload #8
/*    */     //   627: invokeinterface hasNext : ()Z
/*    */     //   632: ifeq -> 670
/*    */     //   635: aload #8
/*    */     //   637: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   642: astore #9
/*    */     //   644: aload #9
/*    */     //   646: checkcast net/ccbluex/liquidbounce/ui/client/hud/element/Element
/*    */     //   649: astore #10
/*    */     //   651: iconst_0
/*    */     //   652: istore #11
/*    */     //   654: aload #10
/*    */     //   656: invokevirtual getClass : ()Ljava/lang/Class;
/*    */     //   659: aload_2
/*    */     //   660: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*    */     //   663: ifeq -> 625
/*    */     //   666: iconst_0
/*    */     //   667: goto -> 671
/*    */     //   670: iconst_1
/*    */     //   671: ifeq -> 693
/*    */     //   674: aload_1
/*    */     //   675: aload_2
/*    */     //   676: invokevirtual newInstance : ()Ljava/lang/Object;
/*    */     //   679: dup
/*    */     //   680: ldc_w 'elementClass.newInstance()'
/*    */     //   683: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   686: checkcast net/ccbluex/liquidbounce/ui/client/hud/element/Element
/*    */     //   689: invokevirtual addElement : (Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;)Lnet/ccbluex/liquidbounce/ui/client/hud/HUD;
/*    */     //   692: pop
/*    */     //   693: iinc #3, 1
/*    */     //   696: goto -> 551
/*    */     //   699: astore_2
/*    */     //   700: invokestatic getLogger : ()Lorg/apache/logging/log4j/Logger;
/*    */     //   703: ldc_w 'Error while loading custom hud config.'
/*    */     //   706: aload_2
/*    */     //   707: checkcast java/lang/Throwable
/*    */     //   710: invokeinterface error : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*    */     //   715: getstatic net/ccbluex/liquidbounce/ui/client/hud/HUD.Companion : Lnet/ccbluex/liquidbounce/ui/client/hud/HUD$Companion;
/*    */     //   718: invokevirtual createDefault : ()Lnet/ccbluex/liquidbounce/ui/client/hud/HUD;
/*    */     //   721: areturn
/*    */     //   722: aload_1
/*    */     //   723: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #42	-> 0
/*    */     //   #44	-> 8
/*    */     //   #45	-> 9
/*    */     //   #46	-> 36
/*    */     //   #47	-> 37
/*    */     //   #48	-> 44
/*    */     //   #50	-> 47
/*    */     //   #51	-> 59
/*    */     //   #53	-> 62
/*    */     //   #55	-> 82
/*    */     //   #56	-> 112
/*    */     //   #58	-> 129
/*    */     //   #59	-> 139
/*    */     //   #61	-> 149
/*    */     //   #62	-> 173
/*    */     //   #63	-> 197
/*    */     //   #64	-> 220
/*    */     //   #65	-> 226
/*    */     //   #66	-> 263
/*    */     //   #64	-> 300
/*    */     //   #69	-> 306
/*    */     //   #70	-> 340
/*    */     //   #71	-> 355
/*    */     //   #69	-> 378
/*    */     //   #75	-> 381
/*    */     //   #76	-> 393
/*    */     //   #76	-> 451
/*    */     //   #76	-> 456
/*    */     //   #76	-> 472
/*    */     //   #78	-> 494
/*    */     //   #79	-> 507
/*    */     //   #55	-> 510
/*    */     //   #82	-> 516
/*    */     //   #83	-> 518
/*    */     //   #84	-> 533
/*    */     //   #45	-> 533
/*    */     //   #88	-> 536
/*    */     //   #89	-> 562
/*    */     //   #90	-> 562
/*    */     //   #89	-> 562
/*    */     //   #90	-> 579
/*    */     //   #102	-> 591
/*    */     //   #103	-> 616
/*    */     //   #90	-> 654
/*    */     //   #104	-> 670
/*    */     //   #91	-> 674
/*    */     //   #88	-> 693
/*    */     //   #94	-> 699
/*    */     //   #95	-> 700
/*    */     //   #96	-> 715
/*    */     //   #97	-> 722
/*    */     //   #99	-> 722
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   340	38	11	value	Lnet/ccbluex/liquidbounce/value/Value;
/*    */     //   448	8	17	it	Lnet/ccbluex/liquidbounce/value/Value;
/*    */     //   451	5	18	$i$a$-find-Config$toHUD$1	I
/*    */     //   149	361	10	element	Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;
/*    */     //   129	381	9	classType	Ljava/lang/String;
/*    */     //   112	401	5	elementClass	Ljava/lang/Class;
/*    */     //   82	434	4	type	Ljava/lang/String;
/*    */     //   518	15	4	e	Ljava/lang/Exception;
/*    */     //   36	497	2	jsonObject	Lcom/google/gson/JsonElement;
/*    */     //   651	12	10	it	Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;
/*    */     //   654	9	11	$i$a$-none-Config$toHUD$2	I
/*    */     //   644	26	9	element$iv	Ljava/lang/Object;
/*    */     //   588	83	6	$this$none$iv	Ljava/lang/Iterable;
/*    */     //   591	80	7	$i$f$none	I
/*    */     //   562	134	2	elementClass	Ljava/lang/Class;
/*    */     //   700	22	2	e	Ljava/lang/Exception;
/*    */     //   8	716	1	hud	Lnet/ccbluex/liquidbounce/ui/client/hud/HUD;
/*    */     //   0	724	0	this	Lnet/ccbluex/liquidbounce/ui/client/hud/Config;
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   8	699	699	java/lang/Exception
/*    */     //   36	516	516	java/lang/Exception
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\Config.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */