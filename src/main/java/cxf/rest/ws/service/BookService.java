package cxf.rest.ws.service;

import cxf.rest.ws.entities.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Ghazi Naceur on 16/06/2017.
 */
//@Path("bs")
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class BookService {

    static List<Book> books = new ArrayList<>();

    static {
        books = initialize();
    }

    static List<Book> initialize() {
        List<Book> books = new CopyOnWriteArrayList<>();
        books.add(new Book((long) 1, "ref1", "author1"));
        books.add(new Book((long) 2, "ref2", "author2"));
        books.add(new Book((long) 3, "ref3", "author3"));
        return books;
    }

    @POST
    @Path("add")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Book book) {
        books.add(book);
        books.forEach(ref -> System.out.println(ref.getId() + " - " + ref.getTitle() + "-" + ref.getAuthor()));
    }

    @PUT
    @Path("update")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void update(Book book) {
//          int index = books.indexOf(reference);
//        references.set(index, reference);
        delete(book.getId());
        create(book);
        books.forEach(ref -> System.out.println(ref.getId() + " - " + ref.getTitle() + "-" + ref.getAuthor()));
    }


    @GET
    @Path("retrieve/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Book retrieve(@PathParam("id") long id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    @DELETE
    @Path("delete/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void delete(@PathParam("id") long id) {
        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
            }
        }
    }

    @GET
    @Path("retrieveAll")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Book> loadAll() {
        books.forEach(ref -> System.out.println(ref.getId() + " - " + ref.getTitle() + "-" + ref.getAuthor()));
        return books;
    }
}
