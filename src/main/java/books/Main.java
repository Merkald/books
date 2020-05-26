package books;

import books.lib.Injector;
import books.model.Author;
import books.model.Book;
import books.model.Genre;
import books.service.AuthorService;
import books.service.BookService;
import books.service.GenreService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    private static final Injector INJECTOR = Injector.getInstance("books");
    private static BookService bookService = (BookService) INJECTOR
            .getInstance(BookService.class);
    private static AuthorService authorService = (AuthorService) INJECTOR
            .getInstance(AuthorService.class);
    private static GenreService genreService = (GenreService) INJECTOR
            .getInstance(GenreService.class);

    public static void main(String[] args) {
        Author author = new Author();
        Genre genre = new Genre();
        author.setAge(55);
        author.setName("Name");
        genre.setName("Horror");
        Book book = new Book();
        book.setName("Book1");
        Set<Author> authorSet = new HashSet<>();
        authorSet.add(author);
        book.setAuthor(authorSet);
        book.setGenre(genre);
        authorService.create(author);
        genreService.create(genre);
        book = bookService.create(book);
        List<Book> list = bookService.getAll();
        Book book1 = bookService.getById(book.getId());
        System.out.println(list);
        System.out.println(book1);
        book.setName("Book2");
        bookService.update(book);
        System.out.println(bookService.getAll());
        System.out.println(bookService.getByField("name", book.getName()));
        bookService.delete(book);
    }
}
