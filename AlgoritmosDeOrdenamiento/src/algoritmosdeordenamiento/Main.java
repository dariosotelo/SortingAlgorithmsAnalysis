/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmosdeordenamiento;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author darios
 */
public class Main {

    /**
     * @param args the command line arguments
     */
   
    //This code is used to read the movie archive.
    //The movie archive is already sorted by alphabetical order.
    public static Movie[] readArray(int MAX) throws FileNotFoundException{
        File doc = new File("/Users/darios/Desktop/EDAEsp/ProyectoAlgoritmosdeOrdenamiento/movie_titles.txt");
        Scanner read = new Scanner(doc);
        int count=0;
        int movieN;
        String movie;
        String id;
        String year;
        String title;
        Movie[] movies = new Movie[MAX];
        while (read.hasNextLine() && count<MAX) {
            movie=read.nextLine();
            movieN=movie.indexOf(",");
            id=movie.substring(0, movieN);
            year=movie.substring(movieN+1, movieN+5);
            title=movie.substring(movieN+6);
            Movie mov = new Movie(Integer.parseInt(id), Integer.parseInt(year), title);
            if (mov!=null)
                movies[count]=mov;
            count++;
        }
        return movies;
    }
    
    public static void reverseArray(Movie[] arr) {
        Collections.reverse(Arrays.asList(arr));
    }
    
    public static void shuffleArray(Movie[] arr) {
        Collections.shuffle(Arrays.asList(arr));
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Sort sort = new Sort();

                
        //This section of the code is used to compare the time taken by the sorting algorithms.
        //This code is written to print the database.
        //System.out.println("Movies in the array: ");
        //for (Movie m:movies10k)
            //System.out.println(m);
        
        
        //This code is used to analyze the number of comparisons made by the algorithm as well as
        //the time taken to complete the task for 10,000 movies.
        Movie[] movies10k=new Movie[10000];
        movies10k=readArray(10000);
        long start = System.nanoTime();
        int comp=sort.mergeSort(movies10k, 0, 10000-1, 0);
        long finish = System.nanoTime();
        System.out.println("To complete 10,000 movies: ");
        System.out.println("It took "+(finish-start)+" nanoseconds to complete the sort");
        System.out.println("The sorting algorithm made "+comp+" comparisons");

        //the time taken to complete the task for 7,500 movies.
        Movie[] movies7500=new Movie[7500];
        movies7500=readArray(7500);
        start = System.nanoTime();
        comp=sort.mergeSort(movies7500, 0, 7499, 0);
        finish = System.nanoTime();
        System.out.println("To complete 7,500 movies: ");
        System.out.println("It took "+(finish-start)+" nanoseconds to complete the sort");
        System.out.println("The sorting algorithm made "+comp+" comparisons");
        
        //the time taken to complete the task for 5,000 movies.
        Movie[] movies5000=new Movie[5000];
        movies5000=readArray(5000);
        start = System.nanoTime();
        comp=sort.mergeSort(movies5000, 0, 4999, 0);
        finish = System.nanoTime();
        System.out.println("To complete 5,000 movies: ");
        System.out.println("It took "+(finish-start)+" nanoseconds to complete the sort");
        System.out.println("The sorting algorithm made "+comp+" comparisons");
        
        //the time taken to complete the task for 3,000 movies.
        Movie[] movies3000=new Movie[3000];
        movies3000=readArray(3000);
        start = System.nanoTime();
        comp=sort.mergeSort(movies3000, 0, 2999, 0);
        finish = System.nanoTime();
        System.out.println("To complete 3,000 movies: ");
        System.out.println("It took "+(finish-start)+" nanoseconds to complete the sort");
        System.out.println("The sorting algorithm made "+comp+" comparisons");
        
        //the time taken to complete the task for 2,500 movies.
        Movie[] movies2500=new Movie[2500];
        movies2500=readArray(2500);
        start = System.nanoTime();
        comp=sort.mergeSort(movies2500, 0, 2499, 0);
        finish = System.nanoTime();
        System.out.println("To complete 2,500 movies: ");
        System.out.println("It took "+(finish-start)+" nanoseconds to complete the sort");
        System.out.println("The sorting algorithm made "+comp+" comparisons");
        
        //The data analized for 1,000 movies.
        Movie[] movies1000=new Movie[1000];
        movies1000=readArray(1000);
        start = System.nanoTime();
        comp=sort.mergeSort(movies1000, 0, 999, 0);
        finish = System.nanoTime();
        System.out.println("To complete 1,000 movies: ");
        System.out.println("It took "+(finish-start)+" nanoseconds to complete the sort");
        System.out.println("The sorting algorithm made "+comp+" comparisons");
        
        //The data analized for 500 movies.
        Movie[] movies500=new Movie[500];
        movies500=readArray(500);
        start = System.nanoTime();
        comp=sort.mergeSort(movies500, 0, 499, 0);
        finish = System.nanoTime();
        System.out.println("To complete 500 movies: ");
        System.out.println("It took "+(finish-start)+" nanoseconds to complete the sort");
        System.out.println("The sorting algorithm made "+comp+" comparisons");
        
        //The data analized for 100 movies.
        Movie[] movies100=new Movie[100];
        movies100=readArray(100);
        start = System.nanoTime();
        comp=sort.mergeSort(movies100, 0, 99, 0);
        finish = System.nanoTime();
        System.out.println("To complete 100 movies: ");
        System.out.println("It took "+(finish-start)+" nanoseconds to complete the sort");
        System.out.println("The sorting algorithm made "+comp+" comparisons");
        
        
/***+++++++++++++++++++++++++++reversed array++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++**/
        //We repeat the whole process reading a reversed array to analize if the algorithms change.
        //the time taken to complete the task for 10,000 movies.
        movies10k=readArray(10000);
        reverseArray(movies10k);
        start = System.nanoTime();
        comp=sort.selectionSort(movies10k, 0, 0);
        finish = System.nanoTime();
        System.out.println("To complete 10,000 movies: ");
        System.out.println("It took "+(finish-start)+" nanoseconds to complete the sort");
        System.out.println("The sorting algorithm made "+comp+" comparisons");

        //the time taken to complete the task for 7,500 movies.
        movies7500=readArray(7500);
        reverseArray(movies7500);
        start = System.nanoTime();
        comp=sort.selectionSort(movies7500, 0, 0);
        finish = System.nanoTime();
        System.out.println("To complete 7,500 movies: ");
        System.out.println("It took "+(finish-start)+" nanoseconds to complete the sort");
        System.out.println("The sorting algorithm made "+comp+" comparisons");
        
        //the time taken to complete the task for 5,000 movies.
        movies5000=readArray(5000);
        reverseArray(movies5000);
        start = System.nanoTime();
        comp=sort.selectionSort(movies5000, 0, 0);
        finish = System.nanoTime();
        System.out.println("To complete 5,000 movies: ");
        System.out.println("It took "+(finish-start)+" nanoseconds to complete the sort");
        System.out.println("The sorting algorithm made "+comp+" comparisons");
        
        //the time taken to complete the task for 3,000 movies.
        movies3000=readArray(3000);
        reverseArray(movies3000);
        start = System.nanoTime();
        comp=sort.selectionSort(movies3000, 0, 0);
        finish = System.nanoTime();
        System.out.println("To complete 3,000 movies: ");
        System.out.println("It took "+(finish-start)+" nanoseconds to complete the sort");
        System.out.println("The sorting algorithm made "+comp+" comparisons");
        
        //the time taken to complete the task for 2,500 movies.
        movies2500=readArray(2500);
        reverseArray(movies2500);
        start = System.nanoTime();
        comp=sort.selectionSort(movies2500, 0, 0);
        finish = System.nanoTime();
        System.out.println("To complete 2,500 movies: ");
        System.out.println("It took "+(finish-start)+" nanoseconds to complete the sort");
        System.out.println("The sorting algorithm made "+comp+" comparisons");
        
        //The data analized for 1,000 movies.
        movies1000=readArray(1000);
        reverseArray(movies1000);
        start = System.nanoTime();
        comp=sort.selectionSort(movies1000, 0, 0);
        finish = System.nanoTime();
        System.out.println("To complete 1,000 movies: ");
        System.out.println("It took "+(finish-start)+" nanoseconds to complete the sort");
        System.out.println("The sorting algorithm made "+comp+" comparisons");
        
        //The data analized for 500 movies.
        movies500=readArray(500);
        reverseArray(movies500);
        start = System.nanoTime();
        comp=sort.selectionSort(movies500, 0, 0);
        finish = System.nanoTime();
        System.out.println("To complete 500 movies: ");
        System.out.println("It took "+(finish-start)+" nanoseconds to complete the sort");
        System.out.println("The sorting algorithm made "+comp+" comparisons");
        
        //The data analized for 100 movies.
        movies100=readArray(100);
        reverseArray(movies100);
        start = System.nanoTime();
        comp=sort.selectionSort(movies100, 0, 0);
        finish = System.nanoTime();
        System.out.println("To complete 100 movies: ");
        System.out.println("It took "+(finish-start)+" nanoseconds to complete the sort");
        System.out.println("The sorting algorithm made "+comp+" comparisons");
        
        
/***+++++++++++++++++++++++++++shuffled array++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++**/
        //We repeat the whole process reading a shuffled array to analize if the algorithms change.
        //the time taken to complete the task for 10,000 movies.
        movies10k=readArray(10000);
        shuffleArray(movies10k);
        start = System.nanoTime();
        comp=sort.mergeSort(movies10k, 0, 9999, 0);
        finish = System.nanoTime();
        System.out.println("To complete 10,000 movies: ");
        System.out.println("It took "+(finish-start)+" nanoseconds to complete the sort");
        System.out.println("The sorting algorithm made "+comp+" comparisons");

        //the time taken to complete the task for 7,500 movies.
        movies7500=readArray(7500);
        shuffleArray(movies7500);
        start = System.nanoTime();
        comp=sort.mergeSort(movies7500, 0, 7499, 0);
        finish = System.nanoTime();
        System.out.println("To complete 7,500 movies: ");
        System.out.println("It took "+(finish-start)+" nanoseconds to complete the sort");
        System.out.println("The sorting algorithm made "+comp+" comparisons");
        
        //the time taken to complete the task for 5,000 movies.
        movies5000=readArray(5000);
        shuffleArray(movies5000);
        start = System.nanoTime();
        comp=sort.mergeSort(movies5000, 0, 4999, 0);
        finish = System.nanoTime();
        System.out.println("To complete 5,000 movies: ");
        System.out.println("It took "+(finish-start)+" nanoseconds to complete the sort");
        System.out.println("The sorting algorithm made "+comp+" comparisons");
        
        //the time taken to complete the task for 3,000 movies.
        movies3000=readArray(3000);
        shuffleArray(movies3000);
        start = System.nanoTime();
        comp=sort.mergeSort(movies3000, 0, 2999, 0);
        finish = System.nanoTime();
        System.out.println("To complete 3,000 movies: ");
        System.out.println("It took "+(finish-start)+" nanoseconds to complete the sort");
        System.out.println("The sorting algorithm made "+comp+" comparisons");
        
        //the time taken to complete the task for 2,500 movies.
        movies2500=readArray(2500);
        shuffleArray(movies2500);
        start = System.nanoTime();
        comp=sort.mergeSort(movies2500, 0, 2499, 0);
        finish = System.nanoTime();
        System.out.println("To complete 2,500 movies: ");
        System.out.println("It took "+(finish-start)+" nanoseconds to complete the sort");
        System.out.println("The sorting algorithm made "+comp+" comparisons");
        
        //The data analized for 1,000 movies.
        movies1000=readArray(1000);
        shuffleArray(movies1000);
        start = System.nanoTime();
        comp=sort.mergeSort(movies1000, 0, 999, 0);
        finish = System.nanoTime();
        System.out.println("To complete 1,000 movies: ");
        System.out.println("It took "+(finish-start)+" nanoseconds to complete the sort");
        System.out.println("The sorting algorithm made "+comp+" comparisons");
        
        //The data analized for 500 movies.
        movies500=readArray(500);
        shuffleArray(movies500);
        start = System.nanoTime();
        comp=sort.mergeSort(movies500, 0, 499, 0);
        finish = System.nanoTime();
        System.out.println("To complete 500 movies: ");
        System.out.println("It took "+(finish-start)+" nanoseconds to complete the sort");
        System.out.println("The sorting algorithm made "+comp+" comparisons");
        
        //The data analized for 100 movies.
        movies100=readArray(100);
        shuffleArray(movies100);
        start = System.nanoTime();
        comp=sort.mergeSort(movies100, 0, 99, 0);
        finish = System.nanoTime();
        System.out.println("To complete 100 movies: ");
        System.out.println("It took "+(finish-start)+" nanoseconds to complete the sort");
        System.out.println("The sorting algorithm made "+comp+" comparisons");

        
        
    }
    
}
