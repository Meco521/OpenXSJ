/*     */ package tomk.CFont;
/*     */ 
/*     */ import java.awt.Font;
/*     */ import java.io.File;
/*     */ import java.io.InputStream;
/*     */ import java.nio.file.Files;
/*     */ import java.util.ArrayList;
/*     */ import net.ccbluex.liquidbounce.Retreat;
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
/*     */ public class FontLoaders
/*     */ {
/*     */   public static CFontRenderer Sans12;
/*     */   public static CFontRenderer Sans14;
/*     */   public static CFontRenderer Sans16;
/*     */   public static CFontRenderer Sans18;
/*     */   public static CFontRenderer Sans20;
/*     */   public static CFontRenderer PoppinsSemiBold16;
/*     */   public static CFontRenderer PoppinsSemiBold18;
/*     */   public static CFontRenderer PoppinsSemiBold20;
/*     */   public static CFontRenderer SFREGULAR12;
/*     */   public static CFontRenderer SFREGULAR14;
/*     */   public static CFontRenderer SFREGULAR16;
/*     */   public static CFontRenderer SFREGULAR18;
/*     */   public static CFontRenderer productsans16;
/*     */   public static CFontRenderer productsans18;
/*     */   public static CFontRenderer BoldFont12;
/*     */   public static CFontRenderer BoldFont8;
/*     */   public static CFontRenderer poppins14;
/*     */   public static CFontRenderer poppins15;
/*     */   public static CFontRenderer poppins16;
/*     */   public static CFontRenderer poppins18;
/*     */   public static CFontRenderer BoldFont14;
/*     */   public static CFontRenderer BoldFont16;
/*     */   public static CFontRenderer BoldFont10;
/*     */   public static CFontRenderer BoldFont18;
/*     */   public static CFontRenderer BoldFont20;
/*     */   public static CFontRenderer BoldFont30;
/*     */   public static CFontRenderer SFREGULAR25;
/*     */   public static CFontRenderer Sans25;
/*     */   public static CFontRenderer Sans35;
/*     */   public static CFontRenderer font40;
/*     */   public static CFontRenderer ETB20;
/*     */   public static CFontRenderer NovIcon20;
/*     */   public static CFontRenderer FluxIcon14;
/*     */   public static CFontRenderer FluxIcon16;
/*     */   public static CFontRenderer FluxIcon18;
/*     */   public static CFontRenderer FluxIcon20;
/*     */   public static CFontRenderer FluxIcon30;
/*     */   public static CFontRenderer FluxIcon40;
/*     */   public static CFontRenderer FluxIcon50;
/*     */   public static CFontRenderer Icon16;
/*     */   public static CFontRenderer JelloTitle20;
/*     */   public static CFontRenderer JelloTitle18;
/*     */   public static CFontRenderer JelloList16;
/*     */   public static CFontRenderer JelloList40;
/*     */   public static CFontRenderer NOTIFICATIONS20;
/*     */   public static CFontRenderer NOTIFICATIONS18;
/*     */   public static CFontRenderer NOTIFICATIONS16;
/*     */   public static CFontRenderer NOTIFICATIONS30;
/*     */   public static CFontRenderer siyuan20;
/*     */   public static CFontRenderer siyuan18;
/*     */   public static CFontRenderer siyuan16;
/*     */   public static CFontRenderer siyuan30;
/*     */   public static CFontRenderer tenacitybold14;
/*     */   public static CFontRenderer tenacitybold16;
/*     */   public static CFontRenderer tenacitybold18;
/*     */   public static CFontRenderer tenacitybold20;
/*     */   public static CFontRenderer tenacitybold22;
/*     */   public static CFontRenderer tenacity14;
/*     */   public static CFontRenderer tenacity16;
/*     */   public static CFontRenderer tenacity18;
/*     */   public static CFontRenderer tenacity20;
/*     */   public static CFontRenderer tenacity22;
/*     */   public static CFontRenderer verdana20;
/*     */   public static CFontRenderer verdana18;
/*     */   public static CFontRenderer verdana14;
/*     */   public static CFontRenderer verdana16;
/*     */   public static CFontRenderer verdana30;
/*     */   public static CFontRenderer verdanab20;
/*     */   public static CFontRenderer verdanab18;
/*     */   public static CFontRenderer verdanab14;
/*     */   public static CFontRenderer verdanab16;
/*     */   public static CFontRenderer verdanab17;
/*     */   public static CFontRenderer verdanab30;
/*     */   public static CFontRenderer sf_ui_display_regular12;
/*     */   public static CFontRenderer sf_ui_display_regular14;
/*     */   public static CFontRenderer sf_ui_display_regular16;
/*     */   public static CFontRenderer sf_ui_display_regular18;
/*     */   public static CFontRenderer sf_ui_display_regular20;
/*     */   public static CFontRenderer sf_ui_display_regular35;
/*     */   public static CFontRenderer C16;
/*     */   public static CFontRenderer C18;
/*     */   public static CFontRenderer C24;
/*     */   public static CFontRenderer sf_ui_display_regular22;
/*     */   public static CFontRenderer sf_ui_display_regular25;
/*     */   public static CFontRenderer sf_ui_display_regular28;
/*     */   public static CFontRenderer Chinese18;
/*     */   public static CFontRenderer Chinese35;
/*     */   public static CFontRenderer JelloMedium_28;
/*     */   public static CFontRenderer JelloMedium_22;
/*     */   public static CFontRenderer JelloLight_24;
/*     */   public static CFontRenderer JelloLight_30;
/*     */   public static CFontRenderer Tenatiy_24;
/*     */   public static CFontRenderer posterama18;
/*     */   public static CFontRenderer posterama35;
/*     */   public static CFontRenderer JelloM20;
/*     */   public static CFontRenderer JelloM15;
/*     */   
/*     */   public static CFontRenderer getFontRender(int size) {
/* 127 */     return fonts.get(size - 10);
/*     */   }
/*     */   private static Font getFont(String fontName, int size) {
/*     */     try {
/* 131 */       InputStream inputStream = Files.newInputStream((new File(Retreat.fileManager.fontsDir, fontName + ".ttf")).toPath(), new java.nio.file.OpenOption[0]);
/* 132 */       Font awtClientFont = Font.createFont(0, inputStream);
/* 133 */       awtClientFont = awtClientFont.deriveFont(0, size);
/* 134 */       inputStream.close();
/* 135 */       return awtClientFont;
/* 136 */     } catch (Exception e) {
/* 137 */       e.printStackTrace();
/*     */       
/* 139 */       return new Font("default", 0, size);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 145 */   public static CFontRenderer xyz16 = new CFontRenderer(getFont("Arial.ttf", 16), true, true);
/* 146 */   public static CFontRenderer xyz18 = new CFontRenderer(getFont("Arial.ttf", 18), true, true);
/* 147 */   public static CFontRenderer xyz20 = new CFontRenderer(getFont("Arial.ttf", 20), true, true);
/* 148 */   public static CFontRenderer xyz28 = new CFontRenderer(getFont("Arial.ttf", 28), true, true);
/* 149 */   public static CFontRenderer xyz26 = new CFontRenderer(getFont("Arial.ttf", 26), true, true); static {
/* 150 */     Sans12 = new CFontRenderer(getFont("GoogleSans", 12), true, true);
/* 151 */     Sans14 = new CFontRenderer(getFont("GoogleSans", 14), true, true);
/* 152 */     Sans16 = new CFontRenderer(getFont("GoogleSans", 16), true, true);
/* 153 */     Sans18 = new CFontRenderer(getFont("GoogleSans", 18), true, true);
/* 154 */     Sans20 = new CFontRenderer(getFont("GoogleSans", 20), true, true);
/* 155 */     Chinese18 = new CFontRenderer(getFont("Chinese", 18), true, true);
/* 156 */     Chinese35 = new CFontRenderer(getFont("Chinese", 35), true, true);
/* 157 */     PoppinsSemiBold16 = new CFontRenderer(getFont("PoppinsSemiBold", 16), true, true);
/* 158 */     PoppinsSemiBold18 = new CFontRenderer(getFont("PoppinsSemiBold", 18), true, true);
/* 159 */     PoppinsSemiBold20 = new CFontRenderer(getFont("PoppinsSemiBold", 20), true, true);
/* 160 */     SFREGULAR12 = new CFontRenderer(getFont("SFREGULAR", 12), true, true);
/* 161 */     SFREGULAR14 = new CFontRenderer(getFont("SFREGULAR", 14), true, true);
/* 162 */     SFREGULAR16 = new CFontRenderer(getFont("SFREGULAR", 16), true, true);
/* 163 */     SFREGULAR18 = new CFontRenderer(getFont("SFREGULAR", 18), true, true);
/* 164 */     productsans16 = new CFontRenderer(getFont("productsans", 16), true, true);
/* 165 */     productsans18 = new CFontRenderer(getFont("productsans", 18), true, true);
/* 166 */     BoldFont12 = new CFontRenderer(getFont("BoldFont", 14), true, true);
/* 167 */     BoldFont8 = new CFontRenderer(getFont("BoldFont", 8), true, true);
/* 168 */     poppins14 = new CFontRenderer(getFont("PoppinsRegular", 14), true, true);
/* 169 */     poppins15 = new CFontRenderer(getFont("PoppinsRegular", 15), true, true);
/* 170 */     poppins16 = new CFontRenderer(getFont("PoppinsRegular", 16), true, true);
/* 171 */     poppins18 = new CFontRenderer(getFont("PoppinsRegular", 18), true, true);
/* 172 */     BoldFont14 = new CFontRenderer(getFont("BoldFont", 14), true, true);
/* 173 */     BoldFont16 = new CFontRenderer(getFont("BoldFont", 16), true, true);
/* 174 */     BoldFont10 = new CFontRenderer(getFont("BoldFont", 10), true, true);
/* 175 */     BoldFont18 = new CFontRenderer(getFont("BoldFont", 18), true, true);
/* 176 */     BoldFont20 = new CFontRenderer(getFont("BoldFont", 20), true, true);
/* 177 */     BoldFont30 = new CFontRenderer(getFont("BoldFont", 30), true, true);
/* 178 */     SFREGULAR25 = new CFontRenderer(getFont("SFREGULAR", 25), true, true);
/* 179 */     Sans25 = new CFontRenderer(getFont("GoogleSans", 25), true, true);
/* 180 */     Sans35 = new CFontRenderer(getFont("GoogleSans", 35), true, true);
/* 181 */     JelloMedium_28 = new CFontRenderer(getFont("jellomedium", 28), true, true);
/* 182 */     JelloMedium_22 = new CFontRenderer(getFont("jellomedium", 22), true, true);
/* 183 */     JelloLight_24 = new CFontRenderer(getFont("jellolight", 24), true, true);
/* 184 */     JelloLight_30 = new CFontRenderer(getFont("jellolight", 30), true, true);
/* 185 */     Tenatiy_24 = new CFontRenderer(getFont("tenacitybold", 24), true, true);
/* 186 */     posterama18 = new CFontRenderer(getFont("posterama", 18), true, true);
/* 187 */     posterama35 = new CFontRenderer(getFont("posterama", 35), true, true);
/* 188 */     ETB20 = new CFontRenderer(getFont("ETB", 20), true, true);
/* 189 */     NovIcon20 = new CFontRenderer(getFont("NovIcon", 20), true, true);
/* 190 */     FluxIcon14 = new CFontRenderer(getFont("fluxicon", 16), true, true);
/* 191 */     FluxIcon16 = new CFontRenderer(getFont("fluxicon", 16), true, true);
/* 192 */     FluxIcon18 = new CFontRenderer(getFont("fluxicon", 18), true, true);
/* 193 */     FluxIcon20 = new CFontRenderer(getFont("fluxicon", 25), true, true);
/* 194 */     FluxIcon30 = new CFontRenderer(getFont("fluxicon", 41), true, true);
/* 195 */     FluxIcon40 = new CFontRenderer(getFont("fluxicon", 40), true, true);
/* 196 */     FluxIcon50 = new CFontRenderer(getFont("fluxicon", 50), true, true);
/* 197 */     Icon16 = new CFontRenderer(getFont("icon", 16), true, true);
/* 198 */     JelloTitle20 = new CFontRenderer(getFont("jellolight", 20), true, true);
/* 199 */     JelloTitle18 = new CFontRenderer(getFont("jellolight", 18), true, true);
/* 200 */     JelloList16 = new CFontRenderer(getFont("jelloregular", 16), true, true);
/* 201 */     JelloList40 = new CFontRenderer(getFont("jelloregular", 21), true, true);
/* 202 */     font40 = new CFontRenderer(getFont("regular", 21), true, true);
/* 203 */     C16 = new CFontRenderer(getFont("misans", 16), true, true);
/* 204 */     C18 = new CFontRenderer(getFont("misans", 18), true, true);
/* 205 */     C24 = new CFontRenderer(getFont("misans", 24), true, true);
/* 206 */     NOTIFICATIONS20 = new CFontRenderer(getFont("NOTIFICATIONS", 20), true, true);
/* 207 */     NOTIFICATIONS18 = new CFontRenderer(getFont("NOTIFICATIONS", 18), true, true);
/* 208 */     NOTIFICATIONS16 = new CFontRenderer(getFont("NOTIFICATIONS", 16), true, true);
/* 209 */     NOTIFICATIONS30 = new CFontRenderer(getFont("NOTIFICATIONS", 30), true, true);
/* 210 */     siyuan20 = new CFontRenderer(getFont("siyuan", 20), true, true);
/* 211 */     siyuan18 = new CFontRenderer(getFont("siyuan", 18), true, true);
/* 212 */     siyuan16 = new CFontRenderer(getFont("siyuan", 16), true, true);
/* 213 */     siyuan30 = new CFontRenderer(getFont("siyuan", 30), true, true);
/* 214 */     tenacitybold14 = new CFontRenderer(getFont("tenacitybold", 14), true, true);
/* 215 */     tenacitybold16 = new CFontRenderer(getFont("tenacitybold", 16), true, true);
/* 216 */     tenacitybold18 = new CFontRenderer(getFont("tenacitybold", 18), true, true);
/* 217 */     tenacitybold20 = new CFontRenderer(getFont("tenacitybold", 20), true, true);
/* 218 */     tenacitybold22 = new CFontRenderer(getFont("tenacitybold", 22), true, true);
/* 219 */     tenacity14 = new CFontRenderer(getFont("tenacity", 14), true, true);
/* 220 */     tenacity16 = new CFontRenderer(getFont("tenacity", 16), true, true);
/* 221 */     tenacity18 = new CFontRenderer(getFont("tenacity", 18), true, true);
/* 222 */     tenacity20 = new CFontRenderer(getFont("tenacity", 20), true, true);
/* 223 */     tenacity22 = new CFontRenderer(getFont("tenacity", 22), true, true);
/* 224 */     verdana20 = new CFontRenderer(getFont("verdana", 20), true, true);
/* 225 */     verdana18 = new CFontRenderer(getFont("verdana", 18), true, true);
/* 226 */     verdana14 = new CFontRenderer(getFont("verdana", 14), true, true);
/* 227 */     verdana16 = new CFontRenderer(getFont("verdana", 15), true, true);
/* 228 */     verdana30 = new CFontRenderer(getFont("verdana", 30), true, true);
/* 229 */     verdanab20 = new CFontRenderer(getFont("verdanab", 20), true, true);
/* 230 */     verdanab18 = new CFontRenderer(getFont("verdanab", 18), true, true);
/* 231 */     verdanab14 = new CFontRenderer(getFont("verdanab", 14), true, true);
/* 232 */     verdanab16 = new CFontRenderer(getFont("verdanab", 16), true, true);
/* 233 */     verdanab17 = new CFontRenderer(getFont("verdanab", 17), true, true);
/* 234 */     verdanab30 = new CFontRenderer(getFont("verdanab", 30), true, true);
/* 235 */     sf_ui_display_regular12 = new CFontRenderer(getFont("sf_ui_display_regular", 12), true, true);
/* 236 */     sf_ui_display_regular14 = new CFontRenderer(getFont("sf_ui_display_regular", 16), true, true);
/* 237 */     sf_ui_display_regular16 = new CFontRenderer(getFont("sf_ui_display_regular", 16), true, true);
/* 238 */     sf_ui_display_regular18 = new CFontRenderer(getFont("sf_ui_display_regular", 18), true, true);
/* 239 */     sf_ui_display_regular20 = new CFontRenderer(getFont("sf_ui_display_regular", 21), true, true);
/* 240 */     sf_ui_display_regular22 = new CFontRenderer(getFont("sf_ui_display_regular", 22), true, true);
/* 241 */     sf_ui_display_regular25 = new CFontRenderer(getFont("sf_ui_display_regular", 25), true, true);
/* 242 */     sf_ui_display_regular28 = new CFontRenderer(getFont("sf_ui_display_regular", 28), true, true);
/* 243 */     sf_ui_display_regular35 = new CFontRenderer(getFont("sf_ui_display_regular", 35), true, true);
/* 244 */     JelloM20 = new CFontRenderer(getFont("jellom", 20), true, true);
/* 245 */     JelloM15 = new CFontRenderer(getFont("jellom", 15), true, true);
/*     */     
/* 247 */     fonts = new ArrayList<>();
/*     */   }
/*     */   
/*     */   public static ArrayList<CFontRenderer> fonts;
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\CFont\FontLoaders.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */