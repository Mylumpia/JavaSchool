package Final.Test;

import java.util.ArrayList;

public class Book {
    String title;
    String author;
    int pages;
    public ArrayList<Book> books;

    public Book (String title, String author, int pages){
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public Book (String title){
        this.title = title;
    }

    public String getBookInfo(){
        return "Title: " + title + ", Author: " + author + ", Page: " + pages; 
    }
    

}
