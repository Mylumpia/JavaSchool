package Final.Test;

import java.util.ArrayList;

public class Library {
    public ArrayList<Book> books;


    public Library(){
        books = new ArrayList<>();
    }

    
    public void addBook(Book bookz){
        books.add(bookz);
    }
    



    public void removeBook(Book title){
        books.remove(title);
    }


    /*public void removeBook(String title){
            Book toRemove = null;
            for (Book b : books){
                if (b.title == title){ 
                toRemove = b;
                break;
                
    }}
    if (toRemove != null){
        books.remove(toRemove);
        System.out.print("Book removed");
    }
    }*/


    public void displayBooks(){
        for (Book b: books){
            System.out.println(b.getBookInfo());
        }
    }
}


