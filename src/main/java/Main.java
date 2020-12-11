import com.google.gson.Gson;
import enums.BookDataSource;
import model.Book;
import service.LibraryAPI;

import java.util.List;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        final Logger LOGGER = Logger.getLogger(Main.class.getName());

        //Initializing the Library API with local datastore.
        LOGGER.info("Initializing LibraryAPI");
        LibraryAPI libraryAPI = new LibraryAPI(BookDataSource.LOCAL);

        //Create Book
        LOGGER.info("Creating Book");
        new Book(5, "Book 5", "Bon Joe");
        final Book bookCreated = libraryAPI.createBook(new Book(5, "Book 5", "Bon Joe"));

        //Get all Books
        LOGGER.info("Fetching All Books");
        final List<Book> allBooks = libraryAPI.getAllBooks();
        LOGGER.info(new Gson().toJson(allBooks));

        //Get Book by id
        LOGGER.info("Fetching Book by ID");
        final Book bookFetched = libraryAPI.getBookById(1);
        LOGGER.info(new Gson().toJson(bookFetched));

        //Update Book
        bookFetched.setAuthor("Updated Author");
        final Book updatedBook = libraryAPI.updateBook(bookFetched);
        LOGGER.info(new Gson().toJson(updatedBook));

        //Delete Book
        libraryAPI.deleteBook(1);
    }
}
