package main;

import java.util.Scanner;

public class MergeSort {

	private static void printArray(int[] array ) {
		
		for (int i: array) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
	}
	
	private static int[] mergeSort(int[] array) {
		
		if(array.length <= 1) {
			return array;
		}
		
		int midpoint = array.length / 2;
		int[] left = new int[midpoint];
		int[] right;
		
		if(array.length % 2 == 0) {
			right = new int[midpoint];
		}
		else {
			right = new int[midpoint + 1];
		}
		
		for (int i = 0; i < midpoint; i++) {
			left[i] = array[i];
		}
		for (int j = 0; j < right.length; j++) {
			right[j] = array[midpoint + j];
		}
		
		int[] result = new int[array.length];
		
		left = mergeSort(left);
		right = mergeSort(right);
		
		result = merge(left, right);
		
		return result;
		
	}
	
	private static int[] merge(int[] left, int[] right) {
		
		int[] result = new int[left.length + right.length];
		
		int leftPointer, rightPointer, resultPointer;
		leftPointer = rightPointer = resultPointer = 0;
		
		while(leftPointer < left.length || rightPointer < right.length) {
			if(leftPointer < left.length && rightPointer < right.length) {
				if(left[leftPointer] < right[rightPointer]) {
					result[resultPointer++] = left[leftPointer++];
				}
				else {
					result[resultPointer++] = right[rightPointer++];
				}
			}
			else if(leftPointer < left.length) {
				result[resultPointer++] = left[leftPointer++];
			}
			else if(rightPointer < right.length) {
				result[resultPointer++] = right[rightPointer++];
			}
		}
		
		return result;
		
	}
	
	public static void main(String args[]) {
				
		/* Scanner scanner = new Scanner(System.in);
		System.out.print("Min & Max Array Length: ");
		String input = scanner.nextLine();
		String[] inputs = input.split(" ");
		int min = Integer.parseInt(inputs[0]);
		int max = Integer.parseInt(inputs[1]);
		
		int[] array = new int[max];
		for (int i = min; i < max; i++) {
			array[i] = i + 1;
		} */
		
		int[] array = {3, 2, 1};
		System.out.println("Initial Array: ");
		printArray(array);
		
		array = mergeSort(array);
		System.out.println("Sorted Array: ");
		printArray(array);
		
	}
	
}
