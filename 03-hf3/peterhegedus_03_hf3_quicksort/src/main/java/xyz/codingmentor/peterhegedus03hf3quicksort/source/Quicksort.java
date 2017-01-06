package xyz.codingmentor.peterhegedus03hf3quicksort.source;

/**
 *
 * @author Péter
 */
public class Quicksort{
    
private Quicksort(){
    
}

private static void switchElements(int[] elements,int firstElementIdx, int secondElementIdx){
    int tmp = elements[firstElementIdx];
    elements[firstElementIdx]=elements[secondElementIdx];
    elements[secondElementIdx]=tmp;
}
    
private static int partition(int[] elements, int minIdx, int maxIdx){
    int pivotIdx=(minIdx + maxIdx) / 2;
    int pivot = elements[pivotIdx];
    int min=minIdx;
    int max=maxIdx;

    while(min <= max){
        while(elements[min]<pivot)
            min++;
        while(elements[max]>pivot)
            max--;
        if(min<=max){
            switchElements(elements,min,max);
            min++;
            max--;
        }
    }
    return min;
}
    
public static void quickSort(int[] elements, int minIdx, int maxIdx) {
        int pivotIdx = partition(elements, minIdx,maxIdx);
        if(minIdx<pivotIdx-1){
            quickSort(elements, minIdx, pivotIdx-1);
        }
        
        if(maxIdx>pivotIdx){
            quickSort(elements, pivotIdx, maxIdx);
        }

    }
}

