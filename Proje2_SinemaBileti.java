/*
 * Ad Soyad: Emine Zehra Duyar
 * Ogrenci No: 250541027
 * Tarih: 24.11.2025
 * Aciklama: GOREV 2: Sinema Bileti 
 */
import java.util.Scanner ;

public class SinemaBileti {
    
   
    public static boolean isWeekend(int gun) {
        // Hafta Sonu: 6 (Cmt) veya 7 (Paz)
        return gun == 6 || gun == 7;
    }
    
    
    public static boolean isMatinee(int saat) {
        // Matine: 12:00 öncesi 
        return saat < 12;
    }
    
   
    public static double calculateBasePrice(int gun, int saat) {
        double price = 0.0;
        
        if (isWeekend(gun)) {
            // HAFTA SONU 
            if (isMatinee(saat)) {
                price = 55.0; // Hafta sonu matine
            } else {
                price = 85.0; // Hafta sonu normal
            }
        } else {
            // HAFTA İÇİ
            if (isMatinee(saat)) {
                price = 45.0; // Hafta içi matine
            } else {
                price = 65.0; // Hafta içi normal
            }
        }
        return price;
    }
    
    public static double getFormatExtra(int filmTuru) {
        double extra = 0.0;
        
        switch (filmTuru) {
            case 2: // 3D 
                extra = 25.0;
                break;
            case 3: // IMAX 
                extra = 35.0;
                break;
            case 4: // 4DX 
                extra = 50.0;
                break;
            case 1: // 2D 
            default:
                extra = 0.0;
                break;
        }
        return extra;
    }
    
    public static double calculateDiscount(int yas, int meslek, int gun, double basePrice) {
        double maxDiscountRate = 0.0; // En yüksek indirim oranı
        
        if (yas >= 65) {
            maxDiscountRate = Math.max(maxDiscountRate, 0.30); 
        } else if (yas < 12) {
            maxDiscountRate = Math.max(maxDiscountRate, 0.25); 
        }
        
        
        switch (meslek) {
            case 1: 
               
                if (gun >= 1 && gun <= 4) { 
                    maxDiscountRate = Math.max(maxDiscountRate, 0.20);
               
                } else if (gun >= 5 && gun <= 7) { 
                    maxDiscountRate = Math.max(maxDiscountRate, 0.15);
                }
                break;
            case 2: 
                if (gun == 3) { 
                    maxDiscountRate = Math.max(maxDiscountRate, 0.35);
                }
                break;
        }
        
        double discountAmount = basePrice * maxDiscountRate;
        return discountAmount;
    }
    
    public static double calculateFinalPrice(double basePrice, double discountAmount, double extraCharge) {
        double finalPrice = basePrice - discountAmount + extraCharge;
        return finalPrice;
    }
    
    public static void generateTicketInfo(double basePrice, double discountAmount, double extraCharge, double finalPrice) {
        System.out.println("\n=== SINEMA BİLET RAPORU ===");
        System.out.printf("Temel Fiyat\t\t: %.2f TL\n", basePrice);
        System.out.printf("Uygulanan İndirim\t: -%.2f TL\n", discountAmount);
        System.out.printf("Format Ek Ücreti\t: +%.2f TL\n", extraCharge);
        System.out.println("---------------------------------");
        System.out.printf("ODENECEK TOPLAM\t\t: %.2f TL\n", finalPrice);
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
      
        System.out.print("Gun numarasi giriniz (1=Pzt, 7=Paz): ");
        int gun = input.nextInt(); 
        System.out.print("Saat giriniz (8-23): ");
        int saat = input.nextInt(); 
        System.out.print("Yasinizi giriniz: ");
        int yas = input.nextInt(); 
        System.out.print("Mesleğinizi giriniz (1=Ogr, 2=Ogrt, 3=Diger): ");
        int meslek = input.nextInt(); 
        
        System.out.print("Film türünü giriniz (1=2D, 2=3D, 3=IMAX, 4=4DX): ");
        int filmTuru = input.nextInt(); 

        // 1. Temel Fiyat
        double basePrice = calculateBasePrice(gun, saat); 

        // 2. İndirim Miktarı
        
        double discount = calculateDiscount(yas, meslek, gun, basePrice); 

        // 3. Ekstra Ücret
        double extra = getFormatExtra(filmTuru);

        // 4. Nihai Fiyat
        double finalPrice = calculateFinalPrice(basePrice, discount, extra);
        
        // 5. Rapor
        generateTicketInfo(basePrice, discount, extra, finalPrice);

        
        input.close(); 
    }
}

