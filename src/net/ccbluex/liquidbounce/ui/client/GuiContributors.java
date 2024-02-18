/*     */ package net.ccbluex.liquidbounce.ui.client;
/*     */ import com.google.gson.JsonParser;
/*     */ import com.google.gson.annotations.SerializedName;
/*     */ import java.awt.Color;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.Unit;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiScreen;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.misc.HttpUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.CustomTexture;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000T\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020 \n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\002\n\002\020\007\n\002\b\004\n\002\020\f\n\002\b\t\030\0002\0020\001:\006\037 !\"#$B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\016\032\0020\0172\006\020\020\032\0020\021H\026J \020\022\032\0020\0172\006\020\023\032\0020\0242\006\020\025\032\0020\0242\006\020\026\032\0020\027H\026J\b\020\030\032\0020\017H\026J\b\020\031\032\0020\017H\026J\030\020\032\032\0020\0172\006\020\033\032\0020\0342\006\020\035\032\0020\024H\026J\b\020\036\032\0020\017H\002R\016\020\005\032\0020\006X\004¢\006\002\n\000R\030\020\007\032\f\022\b\022\0060\tR\0020\0000\bX\016¢\006\002\n\000R\016\020\n\032\0020\013X\016¢\006\002\n\000R\022\020\f\032\0060\rR\0020\000X.¢\006\002\n\000R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006%"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/GuiContributors;", "Lnet/ccbluex/liquidbounce/api/util/WrappedGuiScreen;", "prevGui", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;)V", "DECIMAL_FORMAT", "Ljava/text/DecimalFormat;", "credits", "", "Lnet/ccbluex/liquidbounce/ui/client/GuiContributors$Credit;", "failed", "", "list", "Lnet/ccbluex/liquidbounce/ui/client/GuiContributors$GuiList;", "actionPerformed", "", "button", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiButton;", "drawScreen", "mouseX", "", "mouseY", "partialTicks", "", "handleMouseInput", "initGui", "keyTyped", "typedChar", "", "keyCode", "loadCredits", "ContributorInformation", "Credit", "GitHubAuthor", "GitHubContributor", "GitHubWeek", "GuiList", "XSJClient"})
/*     */ public final class GuiContributors extends WrappedGuiScreen {
/*     */   private final DecimalFormat DECIMAL_FORMAT;
/*     */   private GuiList list;
/*     */   private List<Credit> credits;
/*     */   private boolean failed;
/*     */   private final IGuiScreen prevGui;
/*     */   
/*     */   public GuiContributors(@NotNull IGuiScreen prevGui) {
/*  30 */     this.prevGui = prevGui;
/*  31 */     if (NumberFormat.getInstance(Locale.US) == null) throw new TypeCastException("null cannot be cast to non-null type java.text.DecimalFormat");  this.DECIMAL_FORMAT = (DecimalFormat)NumberFormat.getInstance(Locale.US);
/*     */ 
/*     */     
/*  34 */     Intrinsics.checkExpressionValueIsNotNull(Collections.emptyList(), "Collections.emptyList()"); this.credits = Collections.emptyList();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class GuiContributors$initGui$1
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke()
/*     */     {
/*  46 */       GuiContributors.this.loadCredits(); } GuiContributors$initGui$1() { super(0); } } public void initGui() { this.list = new GuiList(getRepresentedScreen()); if (this.list == null) Intrinsics.throwUninitializedPropertyAccessException("list");  this.list.getRepresented().registerScrollButtons(7, 8); if (this.list == null) Intrinsics.throwUninitializedPropertyAccessException("list");  this.list.getRepresented().elementClicked(-1, false, 0, 0); getRepresentedScreen().getButtonList().add(MinecraftInstance.classProvider.createGuiButton(1, getRepresentedScreen().getWidth() / 2 - 100, getRepresentedScreen().getHeight() - 30, "Back")); this.failed = false; ThreadsKt.thread$default(false, false, null, null, 0, new GuiContributors$initGui$1(), 31, null); }
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/*  50 */     getRepresentedScreen().drawBackground(0);
/*     */     
/*  52 */     if (this.list == null) Intrinsics.throwUninitializedPropertyAccessException("list");  this.list.getRepresented().drawScreen(mouseX, mouseY, partialTicks);
/*     */     
/*  54 */     RenderUtils.drawRect(getRepresentedScreen().getWidth() / 4.0F, 40.0F, getRepresentedScreen().getWidth(), getRepresentedScreen().getHeight() - 40.0F, -2147483648);
/*     */     
/*  56 */     if (this.list == null) Intrinsics.throwUninitializedPropertyAccessException("list");  if (this.list.getSelectedSlot$XSJClient() != -1) {
/*  57 */       if (this.list == null) Intrinsics.throwUninitializedPropertyAccessException("list");  Credit credit = this.credits.get(this.list.getSelectedSlot$XSJClient());
/*     */       
/*  59 */       int y = 45;
/*  60 */       int x = getRepresentedScreen().getWidth() / 4 + 5;
/*  61 */       int infoOffset = 0;
/*     */       
/*  63 */       CustomTexture avatar = credit.getAvatar();
/*     */       
/*  65 */       int imageSize = getRepresentedScreen().getFontRendererObj().getFontHeight() * 4;
/*     */       
/*  67 */       if (avatar != null) {
/*  68 */         GL11.glPushAttrib(1048575);
/*     */         
/*  70 */         MinecraftInstance.classProvider.getGlStateManager().enableAlpha();
/*  71 */         MinecraftInstance.classProvider.getGlStateManager().enableBlend();
/*  72 */         MinecraftInstance.classProvider.getGlStateManager().tryBlendFuncSeparate(770, 771, 1, 0);
/*  73 */         MinecraftInstance.classProvider.getGlStateManager().enableTexture2D();
/*     */         
/*  75 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */         
/*  77 */         MinecraftInstance.classProvider.getGlStateManager().bindTexture(avatar.getTextureId());
/*     */ 
/*     */         
/*  80 */         GL11.glBegin(7);
/*     */         
/*  82 */         GL11.glTexCoord2f(0.0F, 0.0F);
/*  83 */         GL11.glVertex2i(x, y);
/*  84 */         GL11.glTexCoord2f(0.0F, 1.0F);
/*  85 */         GL11.glVertex2i(x, y + imageSize);
/*  86 */         GL11.glTexCoord2f(1.0F, 1.0F);
/*  87 */         GL11.glVertex2i(x + imageSize, y + imageSize);
/*  88 */         GL11.glTexCoord2f(1.0F, 0.0F);
/*  89 */         GL11.glVertex2i(x + imageSize, y);
/*     */         
/*  91 */         GL11.glEnd();
/*     */         
/*  93 */         MinecraftInstance.classProvider.getGlStateManager().bindTexture(0);
/*     */         
/*  95 */         MinecraftInstance.classProvider.getGlStateManager().disableBlend();
/*     */         
/*  97 */         infoOffset = imageSize;
/*     */         
/*  99 */         GL11.glPopAttrib();
/*     */       } 
/*     */       
/* 102 */       y += imageSize;
/*     */       
/* 104 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.font40.drawString("@" + credit.getName(), (x + infoOffset + 5), 48.0F, Color.WHITE.getRGB(), true);
/* 105 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.font40.drawString(credit.getCommits() + " commits §a" + this.DECIMAL_FORMAT.format(Integer.valueOf(credit.getAdditions())) + "++ §4" + this.DECIMAL_FORMAT.format(Integer.valueOf(credit.getDeletions())) + "--", (x + infoOffset + 5), (y - Fonts.font40.getFontHeight()), Color.WHITE.getRGB(), true);
/*     */       
/* 107 */       for (String s : credit.getContributions()) {
/* 108 */         y += Fonts.font40.getFontHeight() + 2;
/*     */         
/* 110 */         MinecraftInstance.classProvider.getGlStateManager().disableTexture2D();
/* 111 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 112 */         GL11.glBegin(1);
/*     */         
/* 114 */         GL11.glVertex2f(x, y + Fonts.font40.getFontHeight() / 2.0F - true);
/* 115 */         GL11.glVertex2f(x + 3.0F, y + Fonts.font40.getFontHeight() / 2.0F - true);
/*     */         
/* 117 */         GL11.glEnd();
/*     */         
/* 119 */         Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.font40.drawString(s, x + 5.0F, y, Color.WHITE.getRGB(), true);
/*     */       } 
/*     */     } 
/*     */     
/* 123 */     Fonts.font40.drawCenteredString("Contributors", getRepresentedScreen().getWidth() / 2.0F, 6.0F, 16777215);
/*     */     
/* 125 */     if (this.credits.isEmpty()) {
/* 126 */       if (this.failed) {
/* 127 */         double d = System.currentTimeMillis() * 0.003003003003003003D; boolean bool = false; int gb = (int)((Math.sin(d) + true) * 127.5D);
/* 128 */         Fonts.font40.drawCenteredString("Failed to load", getRepresentedScreen().getWidth() / 8.0F, getRepresentedScreen().getHeight() / 2.0F, (new Color(255, gb, gb)).getRGB());
/*     */       } else {
/* 130 */         Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.font40.drawCenteredString("Loading...", getRepresentedScreen().getWidth() / 8.0F, getRepresentedScreen().getHeight() / 2.0F, Color.WHITE.getRGB());
/* 131 */         RenderUtils.drawLoadingCircle((getRepresentedScreen().getWidth() / 8), (getRepresentedScreen().getHeight() / 2 - 40));
/*     */       } 
/*     */     }
/*     */     
/* 135 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */   
/*     */   public void actionPerformed(@NotNull IGuiButton button) {
/* 139 */     Intrinsics.checkParameterIsNotNull(button, "button"); if (button.getId() == 1) {
/* 140 */       MinecraftInstance.mc.displayGuiScreen(this.prevGui);
/*     */     }
/*     */   }
/*     */   
/*     */   public void keyTyped(char typedChar, int keyCode) {
/* 145 */     if (1 == keyCode) {
/* 146 */       MinecraftInstance.mc.displayGuiScreen(this.prevGui);
/*     */       
/*     */       return;
/*     */     } 
/* 150 */     super.keyTyped(typedChar, keyCode);
/*     */   }
/*     */   
/*     */   public void handleMouseInput() {
/* 154 */     super.handleMouseInput();
/* 155 */     if (this.list == null) Intrinsics.throwUninitializedPropertyAccessException("list");  this.list.getRepresented().handleMouseInput();
/*     */   } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\033\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\b\n\002\b\003*\001\000\b\n\030\0002\f\022\b\022\0060\002R\0020\0030\001J \020\004\032\0020\0052\n\020\006\032\0060\002R\0020\0032\n\020\007\032\0060\002R\0020\003H\026¨\006\b"}, d2 = {"net/ccbluex/liquidbounce/ui/client/GuiContributors$loadCredits$1", "Ljava/util/Comparator;", "Lnet/ccbluex/liquidbounce/ui/client/GuiContributors$Credit;", "Lnet/ccbluex/liquidbounce/ui/client/GuiContributors;", "compare", "", "o1", "o2", "XSJClient"}) public static final class GuiContributors$loadCredits$1 implements Comparator<Credit> {
/*     */     public int compare(@NotNull GuiContributors.Credit o1, @NotNull GuiContributors.Credit o2) { Intrinsics.checkParameterIsNotNull(o1, "o1"); Intrinsics.checkParameterIsNotNull(o2, "o2"); if (o1.isTeamMember() && o2.isTeamMember())
/*     */         return -Intrinsics.compare(o1.getCommits(), o2.getCommits());  if (o1.isTeamMember())
/*     */         return -1;  if (o2.isTeamMember())
/* 160 */         return 1;  return -Intrinsics.compare(o1.getAdditions(), o2.getAdditions()); } } private final void loadCredits() { try { Gson gson = new Gson();
/* 161 */       JsonParser jsonParser = new JsonParser();
/*     */       
/* 163 */       GitHubContributor[] gitHubContributors = (GitHubContributor[])gson.fromJson(HttpUtils.get("https://api.github.com/repos/CCBlueX/LiquidBounce/stats/contributors"), GitHubContributor[].class);
/* 164 */       Intrinsics.checkExpressionValueIsNotNull(jsonParser.parse(HttpUtils.get("https://raw.githubusercontent.com/CCBlueX/LiquidCloud/master/LiquidBounce/contributors.json")), "jsonParser.parse(HttpUti…unce/contributors.json\"))"); JsonObject additionalInformation = jsonParser.parse(HttpUtils.get("https://raw.githubusercontent.com/CCBlueX/LiquidCloud/master/LiquidBounce/contributors.json")).getAsJsonObject();
/*     */       
/* 166 */       ArrayList<Credit> credits = new ArrayList(gitHubContributors.length);
/*     */       
/* 168 */       for (GitHubContributor gitHubContributor : gitHubContributors) {
/* 169 */         ContributorInformation contributorInformation = (ContributorInformation)null;
/* 170 */         JsonElement jsonElement = additionalInformation.get(String.valueOf(gitHubContributor.getAuthor().getId()));
/*     */         
/* 172 */         if (jsonElement != null) {
/* 173 */           contributorInformation = (ContributorInformation)gson.fromJson(jsonElement, ContributorInformation.class);
/*     */         }
/*     */         
/* 176 */         int additions = 0;
/* 177 */         int deletions = 0;
/* 178 */         int commits = 0;
/*     */         
/* 180 */         for (GitHubWeek week : gitHubContributor.getWeeks()) {
/* 181 */           additions += week.getAdditions();
/* 182 */           deletions += week.getDeletions();
/* 183 */           commits += week.getCommits();
/*     */         } 
/*     */ 
/*     */         
/* 187 */         if (contributorInformation == null || contributorInformation.getContributions() == null) { contributorInformation.getContributions(); Intrinsics.checkExpressionValueIsNotNull(Collections.emptyList(), "Collections.emptyList()"); }  credits.add(new Credit(gitHubContributor.getAuthor().getName(), gitHubContributor.getAuthor().getAvatarUrl(), null, additions, deletions, commits, (contributorInformation != null) ? contributorInformation.getTeamMember() : false, (List)Collections.emptyList()));
/*     */       } 
/*     */       
/* 190 */       CollectionsKt.sortWith(credits, new GuiContributors$loadCredits$1());
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
/* 206 */       this.credits = credits;
/*     */       
/* 208 */       for (Credit credit : credits) {
/*     */         try {
/* 210 */           if (HttpUtils.requestStream$default(HttpUtils.INSTANCE, credit.getAvatarUrl() + "?s=" + (getRepresentedScreen().getFontRendererObj().getFontHeight() * 4), "GET", null, 4, null) != null) { InputStream inputStream = HttpUtils.requestStream$default(HttpUtils.INSTANCE, credit.getAvatarUrl() + "?s=" + (getRepresentedScreen().getFontRendererObj().getFontHeight() * 4), "GET", null, 4, null); boolean bool = false; Throwable throwable = (Throwable)null; try { InputStream it = inputStream; int $i$a$-use-GuiContributors$loadCredits$2 = 0;
/* 211 */               if (ImageIO.read(it) == null) Intrinsics.throwNpe();  credit.setAvatar(new CustomTexture(ImageIO.read(it)));
/* 212 */               Unit unit = Unit.INSTANCE; } catch (Throwable throwable1) { throwable = throwable1 = null; throw throwable1; } finally { CloseableKt.closeFinally(inputStream, throwable); }  continue; }  HttpUtils.requestStream$default(HttpUtils.INSTANCE, credit.getAvatarUrl() + "?s=" + (getRepresentedScreen().getFontRendererObj().getFontHeight() * 4), "GET", null, 4, null);
/* 213 */         } catch (Exception exception) {}
/*     */       }
/*     */        }
/*     */     
/* 217 */     catch (Exception e)
/* 218 */     { ClientUtils.getLogger().error("Failed to load credits.", e);
/* 219 */       this.failed = true; }
/*     */      } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\000\n\002\020\013\n\000\n\002\020 \n\002\b\b\b\004\030\0002\0020\001B#\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\f\020\006\032\b\022\004\022\0020\0030\007¢\006\002\020\bR\027\020\006\032\b\022\004\022\0020\0030\007¢\006\b\n\000\032\004\b\t\020\nR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\013\020\fR\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\r\020\016¨\006\017"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/GuiContributors$ContributorInformation;", "", "name", "", "teamMember", "", "contributions", "", "(Lnet/ccbluex/liquidbounce/ui/client/GuiContributors;Ljava/lang/String;ZLjava/util/List;)V", "getContributions", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getTeamMember", "()Z", "XSJClient"}) public final class ContributorInformation { @NotNull
/*     */     private final String name; private final boolean teamMember; @NotNull
/*     */     private final List<String> contributions; @NotNull
/* 223 */     public final String getName() { return this.name; } public final boolean getTeamMember() { return this.teamMember; } @NotNull public final List<String> getContributions() { return this.contributions; } public ContributorInformation(String name, @NotNull boolean teamMember, List<String> contributions) { this.name = name; this.teamMember = teamMember; this.contributions = contributions; } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\020\000\n\000\n\002\020\b\n\000\n\002\020 \n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\b\b\004\030\0002\0020\001B+\022\006\020\002\032\0020\003\022\020\020\004\032\f\022\b\022\0060\006R\0020\0070\005\022\n\020\b\032\0060\tR\0020\007¢\006\002\020\nR\025\020\b\032\0060\tR\0020\007¢\006\b\n\000\032\004\b\013\020\fR\026\020\002\032\0020\0038\006X\004¢\006\b\n\000\032\004\b\r\020\016R\033\020\004\032\f\022\b\022\0060\006R\0020\0070\005¢\006\b\n\000\032\004\b\017\020\020¨\006\021"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/GuiContributors$GitHubContributor;", "", "totalContributions", "", "weeks", "", "Lnet/ccbluex/liquidbounce/ui/client/GuiContributors$GitHubWeek;", "Lnet/ccbluex/liquidbounce/ui/client/GuiContributors;", "author", "Lnet/ccbluex/liquidbounce/ui/client/GuiContributors$GitHubAuthor;", "(Lnet/ccbluex/liquidbounce/ui/client/GuiContributors;ILjava/util/List;Lnet/ccbluex/liquidbounce/ui/client/GuiContributors$GitHubAuthor;)V", "getAuthor", "()Lnet/ccbluex/liquidbounce/ui/client/GuiContributors$GitHubAuthor;", "getTotalContributions", "()I", "getWeeks", "()Ljava/util/List;", "XSJClient"}) public final class GitHubContributor { @SerializedName("total") private final int totalContributions; @NotNull
/*     */     private final List<GuiContributors.GitHubWeek> weeks; @NotNull
/* 225 */     private final GuiContributors.GitHubAuthor author; public final int getTotalContributions() { return this.totalContributions; } @NotNull public final List<GuiContributors.GitHubWeek> getWeeks() { return this.weeks; } @NotNull public final GuiContributors.GitHubAuthor getAuthor() { return this.author; } public GitHubContributor(@NotNull int totalContributions, @NotNull List<GuiContributors.GitHubWeek> weeks, GuiContributors.GitHubAuthor author) { this.totalContributions = totalContributions; this.weeks = weeks; this.author = author; } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\020\000\n\000\n\002\020\t\n\000\n\002\020\b\n\002\b\n\b\004\030\0002\0020\001B%\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\005\022\006\020\007\032\0020\005¢\006\002\020\bR\026\020\004\032\0020\0058\006X\004¢\006\b\n\000\032\004\b\t\020\nR\026\020\007\032\0020\0058\006X\004¢\006\b\n\000\032\004\b\013\020\nR\026\020\006\032\0020\0058\006X\004¢\006\b\n\000\032\004\b\f\020\nR\026\020\002\032\0020\0038\006X\004¢\006\b\n\000\032\004\b\r\020\016¨\006\017"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/GuiContributors$GitHubWeek;", "", "timestamp", "", "additions", "", "deletions", "commits", "(Lnet/ccbluex/liquidbounce/ui/client/GuiContributors;JIII)V", "getAdditions", "()I", "getCommits", "getDeletions", "getTimestamp", "()J", "XSJClient"}) public final class GitHubWeek { @SerializedName("w") private final long timestamp; @SerializedName("a") private final int additions; @SerializedName("d") private final int deletions; @SerializedName("c")
/* 226 */     private final int commits; public final long getTimestamp() { return this.timestamp; } public final int getAdditions() { return this.additions; } public final int getDeletions() { return this.deletions; } public final int getCommits() { return this.commits; } public GitHubWeek(long timestamp, int additions, int deletions, int commits) { this.timestamp = timestamp; this.additions = additions; this.deletions = deletions; this.commits = commits; } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\000\n\002\020\b\n\002\b\b\b\004\030\0002\0020\001B\035\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\003¢\006\002\020\007R\026\020\006\032\0020\0038\006X\004¢\006\b\n\000\032\004\b\b\020\tR\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\n\020\013R\026\020\002\032\0020\0038\006X\004¢\006\b\n\000\032\004\b\f\020\t¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/GuiContributors$GitHubAuthor;", "", "name", "", "id", "", "avatarUrl", "(Lnet/ccbluex/liquidbounce/ui/client/GuiContributors;Ljava/lang/String;ILjava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "getId", "()I", "getName", "XSJClient"}) public final class GitHubAuthor { @SerializedName("login") @NotNull private final String name; private final int id; @SerializedName("avatar_url") @NotNull private final String avatarUrl; @NotNull
/* 227 */     public final String getName() { return this.name; } public final int getId() { return this.id; } @NotNull public final String getAvatarUrl() { return this.avatarUrl; } public GitHubAuthor(String name, @NotNull int id, String avatarUrl) { this.name = name; this.id = id; this.avatarUrl = avatarUrl; } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\000\n\002\020\b\n\002\b\003\n\002\020\013\n\000\n\002\020 \n\002\b\020\b\004\030\0002\0020\001BM\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003\022\b\020\005\032\004\030\0010\006\022\006\020\007\032\0020\b\022\006\020\t\032\0020\b\022\006\020\n\032\0020\b\022\006\020\013\032\0020\f\022\f\020\r\032\b\022\004\022\0020\0030\016¢\006\002\020\017R\021\020\007\032\0020\b¢\006\b\n\000\032\004\b\020\020\021R\034\020\005\032\004\030\0010\006X\016¢\006\016\n\000\032\004\b\022\020\023\"\004\b\024\020\025R\021\020\004\032\0020\003¢\006\b\n\000\032\004\b\026\020\027R\021\020\n\032\0020\b¢\006\b\n\000\032\004\b\030\020\021R\027\020\r\032\b\022\004\022\0020\0030\016¢\006\b\n\000\032\004\b\031\020\032R\021\020\t\032\0020\b¢\006\b\n\000\032\004\b\033\020\021R\021\020\013\032\0020\f¢\006\b\n\000\032\004\b\013\020\034R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\035\020\027¨\006\036"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/GuiContributors$Credit;", "", "name", "", "avatarUrl", "avatar", "Lnet/ccbluex/liquidbounce/utils/render/CustomTexture;", "additions", "", "deletions", "commits", "isTeamMember", "", "contributions", "", "(Lnet/ccbluex/liquidbounce/ui/client/GuiContributors;Ljava/lang/String;Ljava/lang/String;Lnet/ccbluex/liquidbounce/utils/render/CustomTexture;IIIZLjava/util/List;)V", "getAdditions", "()I", "getAvatar", "()Lnet/ccbluex/liquidbounce/utils/render/CustomTexture;", "setAvatar", "(Lnet/ccbluex/liquidbounce/utils/render/CustomTexture;)V", "getAvatarUrl", "()Ljava/lang/String;", "getCommits", "getContributions", "()Ljava/util/List;", "getDeletions", "()Z", "getName", "XSJClient"}) public final class Credit { @NotNull private final String name; @NotNull private final String avatarUrl; @Nullable private CustomTexture avatar; private final int additions; private final int deletions; private final int commits; private final boolean isTeamMember; @NotNull
/*     */     private final List<String> contributions; @NotNull
/* 229 */     public final String getName() { return this.name; } @NotNull public final String getAvatarUrl() { return this.avatarUrl; } @Nullable public final CustomTexture getAvatar() { return this.avatar; } public final void setAvatar(@Nullable CustomTexture <set-?>) { this.avatar = <set-?>; } public final int getAdditions() { return this.additions; } public final int getDeletions() { return this.deletions; } public final int getCommits() { return this.commits; } public final boolean isTeamMember() { return this.isTeamMember; } @NotNull public final List<String> getContributions() { return this.contributions; } public Credit(@NotNull String name, @Nullable String avatarUrl, CustomTexture avatar, int additions, int deletions, int commits, @NotNull boolean isTeamMember, List<String> contributions) { this.name = name; this.avatarUrl = avatarUrl; this.avatar = avatar; this.additions = additions; this.deletions = deletions; this.commits = commits; this.isTeamMember = isTeamMember; this.contributions = contributions; }
/*     */      } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000(\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\000\n\002\020\002\n\002\b\n\n\002\020\013\n\002\b\b\b\004\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\b\020\007\032\0020\bH\026J8\020\t\032\0020\b2\006\020\n\032\0020\0062\006\020\013\032\0020\0062\006\020\f\032\0020\0062\006\020\r\032\0020\0062\006\020\016\032\0020\0062\006\020\017\032\0020\006H\026J(\020\020\032\0020\b2\006\020\021\032\0020\0062\006\020\022\032\0020\0232\006\020\024\032\0020\0062\006\020\025\032\0020\006H\026J\r\020\026\032\0020\006H\000¢\006\002\b\027J\b\020\030\032\0020\006H\026J\020\020\031\032\0020\0232\006\020\032\032\0020\006H\026R\016\020\005\032\0020\006X\016¢\006\002\n\000¨\006\033"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/GuiContributors$GuiList;", "Lnet/ccbluex/liquidbounce/api/util/WrappedGuiSlot;", "gui", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;", "(Lnet/ccbluex/liquidbounce/ui/client/GuiContributors;Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;)V", "selectedSlot", "", "drawBackground", "", "drawSlot", "entryID", "p_180791_2_", "p_180791_3_", "p_180791_4_", "mouseXIn", "mouseYIn", "elementClicked", "index", "doubleClick", "", "var3", "var4", "getSelectedSlot", "getSelectedSlot$XSJClient", "getSize", "isSelected", "id", "XSJClient"})
/*     */   private final class GuiList extends WrappedGuiSlot { private int selectedSlot; public GuiList(IGuiScreen gui) {
/* 232 */       super(MinecraftInstance.mc, gui.getWidth() / 4, gui.getHeight(), 40, gui.getHeight() - 40, 15);
/*     */ 
/*     */       
/* 235 */       getRepresented().setListWidth(gui.getWidth() * 3 / 13);
/* 236 */       getRepresented().setEnableScissor(true);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isSelected(int id) {
/* 241 */       return (this.selectedSlot == id);
/*     */     } public int getSize() {
/* 243 */       return GuiContributors.this.credits.size();
/*     */     } public final int getSelectedSlot$XSJClient() {
/* 245 */       return (this.selectedSlot > GuiContributors.this.credits.size()) ? -1 : this.selectedSlot;
/*     */     }
/*     */     public void elementClicked(int index, boolean doubleClick, int var3, int var4) {
/* 248 */       this.selectedSlot = index;
/*     */     }
/*     */     
/*     */     public void drawSlot(int entryID, int p_180791_2_, int p_180791_3_, int p_180791_4_, int mouseXIn, int mouseYIn) {
/* 252 */       GuiContributors.Credit credit = GuiContributors.this.credits.get(entryID);
/*     */       
/* 254 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.font40.drawCenteredString(credit.getName(), getRepresented().getWidth() / 2.0F, p_180791_3_ + 2.0F, Color.WHITE.getRGB(), true);
/*     */     }
/*     */     
/*     */     public void drawBackground() {} }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\GuiContributors.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */