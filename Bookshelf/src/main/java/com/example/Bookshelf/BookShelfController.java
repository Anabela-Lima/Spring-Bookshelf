package com.example.Bookshelf;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


// give class superpowers

@RestController

public class BookShelfController {

    // Create, Read, Update, delete = POST, GET, PUT, DELETE


    // Create a list of objects

    private List<Book> bookshelf;

    public BookShelfController(){

         bookshelf= new ArrayList<>();

        // add book objects to list to books

        bookshelf.add( new Book("The 5 am club", "Robin Sharma", 314));
        bookshelf.add( new Book("Sapiens", "Yuval Noah Harari", 443));
        bookshelf.add( new Book("Talking heads", "Alan Bennet", 272));
        bookshelf.add(new Book("Origin", "Dan Brown", 541));
        bookshelf.add(new Book("Our world", "David Attenborough", 272));
        bookshelf.add(new Book("A passage to India", "E.M Forster", 416));
        bookshelf.add(new Book( "The colour purple", "Alice Walker", 304 ));
        bookshelf.add(new Book( "American Dirt", "Jeanine Cummins",400 ));
        bookshelf.add(new Book("The Truth in my Lies", "Ivy Smoak", 344));
        bookshelf.add(new Book("How to talk to anyone", "Leil Lowndes", 300 ));
        bookshelf.add(new Book( "Twilight", "Stephenie Meyer", 498));



    }


    // create end point - from Dev perspective = methods

    @GetMapping("/book") // when client makes a http request with endpoint /book
    Book getBook(){     // our server returns  an object of type Book in JSON format
        return (new Book("Of Mice and Men", "John Steinbeck", 107));
    }


    @GetMapping("/books")  // when client makes a http request with endpoint /books

    List<Book> getBooks(){    // our server returns a list containing objects in JSON format
        return (bookshelf);
    }

// allowing client to create a book  and add it to the bookshelf, and see last book added
    @PostMapping("/books")
    Book post(@RequestBody  Book book  )  {

        // add a new book to Bookshelf

        bookshelf.add(book);

        // return last item in the bookshelf list
        return bookshelf.get(bookshelf.size()-1);
    }


    // removing a book from the bookshelf

    @DeleteMapping("/bookshelf/{id}")
    void delete(@PathVariable int id){

        // remove book from bookshelf

        bookshelf.remove(id);
    }




}
