/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosdeordenamiento;

/**
 *
 * @author darios
 */
public class Movie implements Comparable {
    private int id;
    private int year;
    private String title;
    
    public Movie() {
    }
    
    public Movie(int id, int year, String title) {
        this.id=id;
        this.year=year;
        this.title=title;
    }
    
    public int getID(){
        return id;
    }
    
    public int getYear(){
        return year;
    }
    
    public String getTitle(){
        return title;
    }

    @Override
    public int compareTo(Object o) {
        return this.id - ((Movie)o).id;
    }
    
    public String toString() {
        return "ID: "+id+", title: "+title+", release: "+year;
    }
    


    
    
}
