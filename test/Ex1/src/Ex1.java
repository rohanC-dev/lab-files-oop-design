/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thirs
 */
public class Ex1 {
    public static void substituteMax(int[] a, int[] b) {
 	int maxOfA = a[0];
 	int index = 0;
 	for (int i = 0; i < a.length; i++) {
 		if(a[i] > maxOfA) {
 			maxOfA = a[i];
 			index = i;
                        // finds max in array and finds index of max
		}
 	}
 	int maxOfB = b[0];
 	for (int i = 0; i < b.length; i++) {
 		if(b[i] > maxOfB) {
 			maxOfB = b[i];
 		}
	}
 	a[index] = maxOfB;
        //System.out.println(maxOfA);
        //System.out.println(maxOfB);
    }
    
    public static void main(String[] args){
        int a[] = {2, 3, 4, 455, 6};
        int b[] = {4, 2, 49, 21, 4};
        substituteMax(a, b);
        for(int i = 0; i < b.length; i++){
            System.out.println(b[i]);
        }
        
    }
}
