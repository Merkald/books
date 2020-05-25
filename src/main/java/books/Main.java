package books;

import books.lib.Injector;
import books.model.Book;
import books.service.BookService;
import java.util.List;

public class Main {
    private static final Injector INJECTOR = Injector.getInstance("books");
    private static BookService bookService = (BookService) INJECTOR.getInstance(BookService.class);

    public static void main(String[] args) {
        Book book = new Book();
        book.setName("Book1");
        book = bookService.create(book);
        List<Book> list = bookService.getAll();
        Book book1 = bookService.getById(book.getId());
        System.out.println(list);
        System.out.println(book1);
        book.setName("Book2");
        bookService.update(book);
        System.out.println(bookService.getAll());
        System.out.println(bookService.getByField("name",book.getName()));
    }
}
