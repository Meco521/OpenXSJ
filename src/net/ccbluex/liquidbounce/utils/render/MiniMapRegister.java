/*     */ package net.ccbluex.liquidbounce.utils.render;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.world.IChunk;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000F\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\003\n\002\020\002\n\002\b\007\bÆ\002\030\0002\0020\001:\002\032\033B\007\b\002¢\006\002\020\002J\030\020\017\032\004\030\0010\0062\006\020\020\032\0020\0212\006\020\022\032\0020\021J\006\020\023\032\0020\021J\006\020\024\032\0020\025J\026\020\026\032\0020\0252\006\020\020\032\0020\0212\006\020\022\032\0020\021J\016\020\027\032\0020\0252\006\020\030\032\0020\016J\006\020\031\032\0020\025R*\020\003\032\036\022\004\022\0020\005\022\004\022\0020\0060\004j\016\022\004\022\0020\005\022\004\022\0020\006`\007X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\036\020\n\032\022\022\004\022\0020\0050\013j\b\022\004\022\0020\005`\fX\004¢\006\002\n\000R\036\020\r\032\022\022\004\022\0020\0160\013j\b\022\004\022\0020\016`\fX\004¢\006\002\n\000¨\006\034"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/render/MiniMapRegister;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "()V", "chunkTextureMap", "Ljava/util/HashMap;", "Lnet/ccbluex/liquidbounce/utils/render/MiniMapRegister$ChunkLocation;", "Lnet/ccbluex/liquidbounce/utils/render/MiniMapRegister$MiniMapTexture;", "Lkotlin/collections/HashMap;", "deleteAllChunks", "Ljava/util/concurrent/atomic/AtomicBoolean;", "queuedChunkDeletions", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "queuedChunkUpdates", "Lnet/ccbluex/liquidbounce/api/minecraft/world/IChunk;", "getChunkTextureAt", "x", "", "z", "getLoadedChunkCount", "unloadAllChunks", "", "unloadChunk", "updateChunk", "chunk", "updateChunks", "ChunkLocation", "MiniMapTexture", "XSJClient"})
/*     */ public final class MiniMapRegister extends MinecraftInstance {
/*     */   static {
/*  10 */     MiniMapRegister miniMapRegister = new MiniMapRegister();
/*  11 */   } private static final HashMap<ChunkLocation, MiniMapTexture> chunkTextureMap = new HashMap<>();
/*  12 */   private static final HashSet<IChunk> queuedChunkUpdates = new HashSet<>(256);
/*  13 */   private static final HashSet<ChunkLocation> queuedChunkDeletions = new HashSet<>(256);
/*  14 */   private static final AtomicBoolean deleteAllChunks = new AtomicBoolean(false); public static final MiniMapRegister INSTANCE;
/*     */   
/*     */   public final void updateChunk(@NotNull IChunk chunk) {
/*  17 */     Intrinsics.checkParameterIsNotNull(chunk, "chunk"); HashSet<IChunk> hashSet = queuedChunkUpdates; boolean bool = false; synchronized (false) { int $i$a$-synchronized-MiniMapRegister$updateChunk$1 = 0; null = 
/*  18 */         queuedChunkUpdates.add(chunk);
/*     */       /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/HashSet<ObjectType{net/ccbluex/liquidbounce/api/minecraft/world/IChunk}>}, name=null} */ }
/*     */   
/*     */   } @Nullable
/*     */   public final MiniMapTexture getChunkTextureAt(int x, int z) {
/*  23 */     return chunkTextureMap.get(new ChunkLocation(x, z));
/*     */   }
/*     */   
/*     */   public final void updateChunks() {
/*  27 */     HashSet<IChunk> hashSet = queuedChunkUpdates; boolean bool = false; synchronized (false) { Iterable<ChunkLocation> $this$forEach$iv; int $i$a$-synchronized-MiniMapRegister$updateChunks$1 = 0;
/*  28 */       if (deleteAllChunks.get())
/*  29 */       { HashSet<ChunkLocation> hashSet2 = queuedChunkDeletions; boolean bool2 = false; synchronized (false) { int $i$a$-synchronized-MiniMapRegister$updateChunks$1$1 = 0;
/*  30 */           queuedChunkDeletions.clear();
/*  31 */           Unit unit = Unit.INSTANCE; /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/HashSet<InnerObjectType{ObjectType{net/ccbluex/liquidbounce/utils/render/MiniMapRegister}.Lnet/ccbluex/liquidbounce/utils/render/MiniMapRegister$ChunkLocation;}>}, name=null} */ }
/*  32 */          queuedChunkUpdates.clear();
/*     */         
/*  34 */         Map<ChunkLocation, MiniMapTexture> map1 = chunkTextureMap; int $i$f$forEach = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 107 */         Map<ChunkLocation, MiniMapTexture> map2 = map1; boolean bool3 = false; Iterator iterator1 = map2.entrySet().iterator(); }
/*     */       else { HashSet<ChunkLocation> hashSet2 = queuedChunkDeletions; boolean bool2 = false; synchronized (false) {
/* 109 */           int $i$a$-synchronized-MiniMapRegister$updateChunks$1$3 = 0; $this$forEach$iv = queuedChunkDeletions; int i = 0; Iterator<ChunkLocation> iterator2 = $this$forEach$iv.iterator(); if (iterator2.hasNext()) { Object element$iv = iterator2.next(); ChunkLocation it = (ChunkLocation)element$iv; int $i$a$-forEach-MiniMapRegister$updateChunks$1$3$1 = 0; if ((MiniMapTexture)chunkTextureMap.remove(it) != null) { ((MiniMapTexture)chunkTextureMap.remove(it)).delete$XSJClient(); } else { (MiniMapTexture)chunkTextureMap.remove(it); }  }
/*     */            queuedChunkDeletions.clear(); Unit unit = Unit.INSTANCE; /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/HashSet<InnerObjectType{ObjectType{net/ccbluex/liquidbounce/utils/render/MiniMapRegister}.Lnet/ccbluex/liquidbounce/utils/render/MiniMapRegister$ChunkLocation;}>}, name=null} */
/* 111 */         }  Iterable<IChunk> iterable = queuedChunkUpdates; int $i$f$forEach = 0; Iterator<IChunk> iterator1 = iterable.iterator(); }  if ($this$forEach$iv.hasNext()) { Map.Entry element$iv = (Map.Entry)$this$forEach$iv.next(), entry1 = element$iv; int $i$a$-forEach-MiniMapRegister$updateChunks$1$2 = 0; ((MiniMapTexture)entry1.getValue()).delete$XSJClient(); }  chunkTextureMap.clear(); deleteAllChunks.set(false); HashSet<IChunk> hashSet1 = queuedChunkUpdates; boolean bool1 = false; Iterator<IChunk> iterator = hashSet1.iterator(); }
/*     */   
/*     */   }
/*     */   
/*     */   public final int getLoadedChunkCount() {
/*     */     return chunkTextureMap.size();
/*     */   }
/*     */   
/*     */   public final void unloadChunk(int x, int z) {
/*     */     HashSet<ChunkLocation> hashSet = queuedChunkDeletions;
/*     */     boolean bool = false;
/*     */     synchronized (false) {
/*     */       int $i$a$-synchronized-MiniMapRegister$unloadChunk$1 = 0;
/*     */       null = queuedChunkDeletions.add(new ChunkLocation(x, z));
/*     */       /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/HashSet<InnerObjectType{ObjectType{net/ccbluex/liquidbounce/utils/render/MiniMapRegister}.Lnet/ccbluex/liquidbounce/utils/render/MiniMapRegister$ChunkLocation;}>}, name=null} */
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void unloadAllChunks() {
/*     */     deleteAllChunks.set(true);
/*     */   }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000*\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\013\n\002\b\005\n\002\030\002\n\002\b\003\n\002\020\002\n\002\b\004\n\002\030\002\n\000\030\0002\0020\001B\005¢\006\002\020\002J\r\020\r\032\0020\016H\000¢\006\002\b\017J\b\020\020\032\0020\016H\004J\016\020\021\032\0020\0162\006\020\022\032\0020\023R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\021\020\t\032\0020\n¢\006\b\n\000\032\004\b\013\020\f¨\006\024"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/render/MiniMapRegister$MiniMapTexture;", "", "()V", "deleted", "", "getDeleted", "()Z", "setDeleted", "(Z)V", "texture", "Lnet/minecraft/client/renderer/texture/DynamicTexture;", "getTexture", "()Lnet/minecraft/client/renderer/texture/DynamicTexture;", "delete", "", "delete$XSJClient", "finalize", "updateChunkData", "chunk", "Lnet/ccbluex/liquidbounce/api/minecraft/world/IChunk;", "XSJClient"})
/*     */   public static final class MiniMapTexture {
/*     */     @NotNull
/*     */     private final DynamicTexture texture = new DynamicTexture(16, 16);
/*     */     private boolean deleted;
/*     */     
/*     */     @NotNull
/*     */     public final DynamicTexture getTexture() {
/*     */       return this.texture;
/*     */     }
/*     */     
/*     */     public final boolean getDeleted() {
/*     */       return this.deleted;
/*     */     }
/*     */     
/*     */     public final void setDeleted(boolean <set-?>) {
/*     */       this.deleted = <set-?>;
/*     */     }
/*     */     
/*     */     public final void updateChunkData(@NotNull IChunk chunk) {
/*     */       Intrinsics.checkParameterIsNotNull(chunk, "chunk");
/*     */       int[] rgbValues = this.texture.func_110565_c();
/*     */       for (byte b1 = 0, b2 = 15; b1 <= b2; b1++) {
/*     */         for (byte b3 = 0, b4 = 15; b3 <= b4; b3++) {
/*     */           WBlockPos bp = new WBlockPos(b1, chunk.getHeightValue(b1, b3) - 1, b3);
/*     */           IIBlockState blockState = chunk.getBlockState(bp);
/*     */           if (MinecraftInstance.mc.getTheWorld() == null)
/*     */             Intrinsics.throwNpe(); 
/*     */           rgbValues[rgbValues.length - b3 * 16 + b1 + 1] = blockState.getBlock().getMapColor(blockState, MinecraftInstance.mc.getTheWorld(), bp) | 0xFF000000;
/*     */         } 
/*     */       } 
/*     */       this.texture.func_110564_a();
/*     */     }
/*     */     
/*     */     public final void delete$XSJClient() {
/*     */       if (!this.deleted) {
/*     */         this.texture.func_147631_c();
/*     */         this.deleted = true;
/*     */       } 
/*     */     }
/*     */     
/*     */     protected final void finalize() {
/*     */       if (!this.deleted)
/*     */         this.texture.func_147631_c(); 
/*     */     }
/*     */   }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000 \n\002\030\002\n\002\020\000\n\000\n\002\020\b\n\002\b\t\n\002\020\013\n\002\b\003\n\002\020\016\n\000\b\b\030\0002\0020\001B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003¢\006\002\020\005J\t\020\t\032\0020\003HÆ\003J\t\020\n\032\0020\003HÆ\003J\035\020\013\032\0020\0002\b\b\002\020\002\032\0020\0032\b\b\002\020\004\032\0020\003HÆ\001J\023\020\f\032\0020\r2\b\020\016\032\004\030\0010\001HÖ\003J\t\020\017\032\0020\003HÖ\001J\t\020\020\032\0020\021HÖ\001R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\006\020\007R\021\020\004\032\0020\003¢\006\b\n\000\032\004\b\b\020\007¨\006\022"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/render/MiniMapRegister$ChunkLocation;", "", "x", "", "z", "(II)V", "getX", "()I", "getZ", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "XSJClient"})
/*     */   public static final class ChunkLocation {
/*     */     private final int x;
/*     */     private final int z;
/*     */     
/*     */     public final int getX() {
/*     */       return this.x;
/*     */     }
/*     */     
/*     */     public final int getZ() {
/*     */       return this.z;
/*     */     }
/*     */     
/*     */     public ChunkLocation(int x, int z) {
/*     */       this.x = x;
/*     */       this.z = z;
/*     */     }
/*     */     
/*     */     public final int component1() {
/*     */       return this.x;
/*     */     }
/*     */     
/*     */     public final int component2() {
/*     */       return this.z;
/*     */     }
/*     */     
/*     */     @NotNull
/*     */     public final ChunkLocation copy(int x, int z) {
/*     */       return new ChunkLocation(x, z);
/*     */     }
/*     */     
/*     */     @NotNull
/*     */     public String toString() {
/*     */       return "ChunkLocation(x=" + this.x + ", z=" + this.z + ")";
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return Integer.hashCode(this.x) * 31 + Integer.hashCode(this.z);
/*     */     }
/*     */     
/*     */     public boolean equals(@Nullable Object param1Object) {
/*     */       if (this != param1Object) {
/*     */         if (param1Object instanceof ChunkLocation) {
/*     */           ChunkLocation chunkLocation = (ChunkLocation)param1Object;
/*     */           if (this.x == chunkLocation.x && this.z == chunkLocation.z)
/*     */             return true; 
/*     */         } 
/*     */       } else {
/*     */         return true;
/*     */       } 
/*     */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\MiniMapRegister.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */