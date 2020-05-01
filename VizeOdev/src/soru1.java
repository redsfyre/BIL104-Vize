/*
 * Copyright (C) 2020 Yasin İsa YILDIRIM
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.Scanner; //Scanner sınıfını import et
public class soru1 {


    public static void main(String[] args) {
        
        Scanner numberScanner = new Scanner(System.in); //Yeni bir Scanner nesnesi oluştur
        System.out.println("Lütfen pozitif bir doğal sayı giriniz!\n"); 
        
        int number = numberScanner.nextInt(); //square fonksiyonuna gidecek sayıyı gir
        System.out.println(square(number)); //Fonksiyondan dönen değeri konsola bas
    }

    
    static int square(int n) {
        
        if (n == 1)
            return 1;
        else if (n < 1) {
            System.out.println("Hesaplama yapılamıyor! Lütfen pozitif bir doğal sayı giriniz");
            return -1;
        }
        else {
            return square(n - 1) + n * n;
        }
        
   }
    
}

