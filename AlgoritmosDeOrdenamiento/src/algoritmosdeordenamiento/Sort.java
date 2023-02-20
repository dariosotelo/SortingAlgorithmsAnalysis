/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosdeordenamiento;

import java.util.Arrays;

/**
 *
 * @author darios
 */
public class Sort<T extends Comparable<T>> {
    //At the beginning of every section, functions are declared to make the code cleaner.
    
    //Este código solo intercambia lugares.
    public void swap(T[] arre, int i, int j) {
        T copia = arre[i];
        arre[i]=arre[j];
        arre[j]=copia;
    }
    
    
/**************************************Selection sort******************************************************************/
    //It takes the minimum element from a list, it compares every element from the list and returns the minimum value
    //it has an index value because it is part of the recursive selection sort algorithm.
    public int[] getMinSS(T[] arre, int ind) {
        T aux = arre[ind];
        int res=0;
        int comp=0;
        for (int i=ind; i<arre.length; i++) {
            comp++;
            if (arre[i].compareTo(aux)<=0) {
                aux = arre[i];
                res=i;
            }
        }
        return new int[] {res, comp};
    }
        
    //This is the recursive algorithm for a selection sort.
    //The third argument is the number which will count all of the compare tasks that the algorithm makes.
    public int selectionSort(T[] arre, int indice, int comp) {
        if (arre.length==indice)
            return comp;
        else {
            int[] aux = getMinSS(arre, indice);
            swap(arre, indice, aux[0]);
            return selectionSort(arre, indice+1, comp+aux[1]);
        }
    }
    
    
/**************************************Insertion sort******************************************************************/

    //This code is used to sort a given value in its place.
    public int acomodaIS(T[] arre, int indice) {
        int comp=0;
        for (int i=indice; i>0; i--){
            comp++;
            if (arre[i].compareTo(arre[i-1])<0)
                swap(arre, i, i-1);
        }
        return comp;
    }
    
    
    //recursive insertion sort.
    public int insertionSort(T[] arre, int indice, int comp) {
        int auxComp=0;
        if (arre.length==indice)
            return comp;
        else {
            auxComp=acomodaIS(arre, indice);
            return insertionSort(arre, indice+1, auxComp+comp);
        }
    }
    
/**************************************Bubble sort******************************************************************/
    //Sorts a given element from using the bubble sort algorithm.
    public int acomodaBS(T[] arre, int indice1, int comp) {
        int auxComp=1;
        if (arre.length==indice1+1)
            return comp;
        else {
            comp=comp+auxComp;
            if (arre[indice1].compareTo(arre[indice1+1])<0)
                swap(arre, indice1, indice1+1);
            return acomodaBS(arre, indice1+1, comp);
        }
    }
    
    //Recursive bubble sort.
    public int bubbleSort(T[] arre, int indice, int comp) {
        if (arre.length==indice)
            return comp;
        else {
            comp=acomodaBS(arre, 0, comp);
            return bubbleSort(arre, indice+1, comp);
        }
    }
    
/**************************************Quick sort******************************************************************/
    //This function is necessary to make the quickSort, it does all the work to sort the values which are lower to the pivot
    //to the left and the higher numbers to the right.
    public int[] particion(T[] arre, int inicio, int salida, int cont) {
        int i = inicio - 1;
        for (int j = inicio; j<salida; j++) {
            cont++;
            if (arre[j].compareTo(arre[salida])<=0){
                i++;
                swap(arre, i, j);
            }
        }
        swap(arre, i+1, salida);
        return new int[] {i+1, cont};
    }
    
    //This is the recursive algorith.
    public int quickSort(T[] arre, int inicio, int salida, int cont) {
        if (inicio<salida) {
            int[] pivotecont = particion(arre, inicio, salida, cont);
            int pivote=pivotecont[0];
            cont=pivotecont[1];
            quickSort(arre, inicio, pivote - 1, cont);
            quickSort(arre, pivote + 1, salida, cont);
        }
        return cont;
    }
   
    
/**************************************Merge sort******************************************************************/
    //This is necessary to divide and merge the array.
    public int mezcla(T[] arre, int inicio, int mitad, int salida, int count) {
        T[] auxIzq = Arrays.copyOfRange(arre, inicio, mitad+1);
        T[] auxDer = Arrays.copyOfRange(arre, mitad+1, salida+1);
        int i=0;
        int j=0;
        int k=inicio;
        int countAux=1;
        while (i<auxIzq.length && j<auxDer.length) {
            count++;
            if (auxIzq[i].compareTo(auxDer[j])<=0){
                arre[k]=auxIzq[i];
                i++;
            } else {
                arre[k]=auxDer[j];
                j++;
            }
            k++;
        }
        while (i<auxIzq.length){
            arre[k]=auxIzq[i];
            i++;
            k++;
        }
        while (j<auxDer.length){
            arre[k]=auxDer[j];
            j++;
            k++;
        }
        return count;
    }

    public int mergeSort(T[] arre, int inicio, int salida, int count) {
        if (inicio<salida) {
            int mitad=(inicio+salida)/2;
            //This is where the code divides the array.
            mergeSort(arre, inicio, mitad, count);
            mergeSort(arre, mitad+1, salida, count);
            //This is the instruction to merge the array.
            count=mezcla(arre, inicio, mitad, salida, count);
        }
        return count;
    }
    
    
    
}
