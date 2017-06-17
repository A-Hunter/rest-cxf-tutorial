package cxf.rest.ws.service;

import cxf.rest.ws.entities.Book;

import java.util.Collection;

/**
 * Created by Ghazi Naceur on 17/06/2017.
 */

public interface BookRestWS {


    public void create(Book book);

    public Book retrieve(long id);

    public void update(Book book);

    public void delete(long id);

    public Collection<Book> loadAll();
}
