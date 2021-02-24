/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.structures;

import java.util.Scanner;

/**
 *
 * @author Hemlata Ahire
 */
public class DataStructures {
Scanner s=new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    int subArraySum(int arr[], int n, int sum) 
    { 
        int curr_sum, i, j; 
  
        // Pick a starting point 
        for (i = 0; i < n; i++) { 
            curr_sum = arr[i]; 
  
            // try all subarrays starting with 'i' 
            for (j = i + 1; j <= n; j++) { 
                if (curr_sum == sum) { 
                    int p = j - 1; 
                    System.out.println( 
                        "Sum found between indexes " + i 
                        + " and " + p); 
                    return 1; 
                } 
                if (curr_sum > sum || j == n) 
                    break; 
                curr_sum = curr_sum + arr[j]; 
            } 
        } 
  
        System.out.println("No subarray found"); 
        return 0; 
    } 
    public static void main(String[] args) {
    DataStructures ds=new DataStructures();
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enetr size of array");
        int n = sc.nextInt();
        System.out.println("Enetr "+n+" element of array");
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int sum;
        System.out.println("Enter sum ");
        sum=sc.nextInt();
        ds.subArraySum(arr, n, sum); 
   }
    
    
}
