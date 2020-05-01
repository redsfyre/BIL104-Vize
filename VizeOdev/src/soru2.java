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


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class soru2 {

	static int[][] colons;

	static boolean colonDogru(int[] numbers){
		
		if(control(numbers)){
			return false;
		}

		int individualNumber = 0, doubleNumber = 0;

		for(int i=0; i<numbers.length; i++){
			if(numbers[i] % 2 == 0){
				doubleNumber++;
			} else {
				individualNumber++;
			}
		}

		if(individualNumber != doubleNumber){
			return false;
		}

		int gap1 = 0, gap2 = 0, gap3 = 0, gap4 = 0, gap5 = 0;

		for(int i=0; i<numbers.length; i++){
            int number = numbers[i];
			
			if(number > 40 && number <= 49){
				gap5++;
			} else if(number > 30 && number <= 40){
				gap4++;
			} else if(number > 20 && number <= 30){
				gap3++;
			} else if(number > 10 && number <= 20){
				gap2++;
			} else if(number > 0 && number <= 10){
				gap1++;
			}
		}

		return (gap1 <= 2 && gap2 <= 2 && gap3 <= 2 && gap4 <= 2 && gap5 <= 2);
	}

    static Random rnd = new Random();

    static int[] createColon(){
        int[] colon = new int[6];
        for(int i = 0;i < colon.length;i++){
			colon[i] = findDifferent(colon);
		}
		Arrays.sort(colon);
		return colon;
	}

    static boolean control(int[] colon){
        for(int[] control : colons){
			if(control != null){
				for(int number : colon){
					if(!compare(control, number)){
						return true;
					}
				}
			}
		}
		return false;
	}

    static int findDifferent(int[] colon){
        int temp = rnd.nextInt(50);
        if(temp < 1 || !compare(colon, temp))
			return findDifferent(colon);
		return temp;
	}

    static boolean compare(int[] colon, int number){
        for(int i = 0;i < colon.length;i++){
            if(colon[i] == number){
                return false;
			}
		}
		return true;
	}

    static void colonYazdir(){
        int a=1;
        for(int i = 0;i < colons.length;i++){
            System.out.println("Kolon " + a + "Sayilari: ");
            a++;
            for(int j = 0;j < colons[i].length;j++){
                int number = colons[i][j];
                System.out.print(number);
                if(j < colons[i].length-1)
                    System.out.print("-");
                }
            
                System.out.println(" ");
                System.out.println(" ");
                        
            }
                
    }	
	
    public static void main(String[] args) {
        
        Scanner giris = new Scanner(System.in);
        int colon = 0;

        while(colon < 1 || colon > 8){
            System.out.print("Kolon sayisi: ");
            colon =giris.nextInt();
            if(colon < 1 || colon > 8){
                System.out.println("");
                System.out.println("Yanlis girdi!");
                System.out.println("Kolon sayisi 1 ile 8 arasinda olmalidir");
                System.out.println("");
                }
            }
		
            colons = new int[colon][];

            for(int i = 0;i < colon;){
                int[] newColon = createColon();
                if(colonDogru(newColon)){
                    colons[i] = newColon;
                    i++;
                }
            }


            colonYazdir();
        }
}


    



