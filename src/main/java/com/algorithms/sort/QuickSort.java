package com.algorithms.sort;

public class QuickSort {

    public static void main(String[] args) {

        int[] array = {10,8,100,3,5,2,1,10};
        quickSort(array, 0, array.length-1);

        for(int i=0; i< array.length; i++) {
            System.out.println(array[i]);
        }

    }

    public static void quickSort(int[] array, int low, int high) {

        if(low >= high) {
            return;
        }

        int mid = low + (high-low)/2;
        int pivot = array[mid];
        int i = low;
        int j = high;
        while(i <= j) {

            while(array[i] < pivot) {
                i++;
            }

            while(array[j] > pivot) {
                j--;
            }

            if(i<=j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }

            if(low < j) {
                quickSort(array, low, j);
            }

            if(high > i) {
                quickSort(array, i, high);
            }

        }

    }

    public static void quickSortRecursive(int[] array, int low, int high) {

        if(low > high) {
            return;
        }

        int partitionIndex = partition(array, low, high);
        quickSortRecursive(array, low, partitionIndex-1);
        quickSortRecursive(array, partitionIndex+1, high);

    }

    public static int partition(int[] array, int low, int high) {

        int pivot = array[high];
        int index = low-1;

        for(int i=low; i<high; i++) {

            if(array[i] <= pivot) {
                index++;
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }

        }

        int temp = array[index+1];
        array[index+1] = array[high];
        array[high] = temp;

        return index+1;
    }


}
