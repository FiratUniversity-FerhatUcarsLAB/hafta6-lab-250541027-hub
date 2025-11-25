/*
 * Ad Soyad: Emine Zehra Duyar
 * Ogrenci No: 250541027
 * Tarih: 24.11.2025
 * Aciklama: GOREV 1: Not Sistemi
 */

import java.util.Scanner ;

public class NotSistemi {
   //Ortalama Hesabı
    public static double calculateAverage(double vize, double finalExam ,double homework){
        return (vize*0.3)+(finalExam*0.4)+(homework*0.3);
    }
    //Geçti-Kaldı
        public static boolean isPassingGrade( double average){
            return average >=50.0 ;
        }
    //Harflendirme    
    public static String getLetterGrade(double average){
        if (average>= 90){
            return "A";
        } else if (average>=80){
            return "B";
        } else if (average >=70){
            return "C";
        }else if (average>=60){
            return "D";
        }else{
            return "F";
        
        }
    }  
    // Onur Listesi
    public static boolean isHonorList(double average, double vize,double finalExam, double homework){
      boolean isHighAverage = average> 85.0;
      boolean allGradesHigh = (vize >=70.0)&& (finalExam>=70.0)&&(homework>=70.0);
      return allGradesHigh && isHighAverage;
    }
    // Bütünleme Hakkı
    public static boolean hasRetakeRight( double average){
      return average >= 40.0 && average < 50.0;    
    }
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        System.out.print("Vize notunu giriniz: ");
        double vize = input.nextDouble();
        System.out.print("Final notunu giriniz: ");
        double finalExam = input.nextDouble();
        System.out.print("Odev notunu giriniz: ");
        double homework = input.nextDouble();

        //Ortalama Hesap
        double average = calculateAverage(vize, finalExam, homework);

        // Harf Notu
        String letterGrade = getLetterGrade(average);
        String passingStatus = isPassingGrade(average) ? "GECTI" : "KALDI" ;
        String honorStatus = isHonorList(average, vize, finalExam, homework) ? "EVET" : "HAYIR" ;
        String retakeStatus = hasRetakeRight(average)? "VAR": "YOK";
        //Çıktılar
        System.out.println("\n=== OGRENCI NOT RAPORU ==="); 
        System.out.printf("Vize Notu\t: %.1f\n", vize); 
        System.out.printf("Final Notu\t: %.1f\n", finalExam); 
        System.out.printf("Odev Notu\t: %.1f\n", homework);  
        
        System.out.println("-------------------------");
        System.out.printf("Ortalama\t: %.1f\n", average); 
        System.out.printf("Harf Notu\t: %s\n", letterGrade); 
        System.out.printf("Durum\t\t: %s\n", passingStatus);
        System.out.printf("Onur Listesi\t: %s\n", honorStatus); 
        System.out.printf("Butunleme\t: %s\n", retakeStatus); 
        
        input.close();
    }
    } 

