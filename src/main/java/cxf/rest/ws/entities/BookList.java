package cxf.rest.ws.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ghazi Naceur on 16/06/2017.
 */
@XmlRootElement(name = "BookList")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookList implements Serializable {

    private List<Book> books;

    public List<Book> getBooks() {
        if (books == null){
            books = new ArrayList<Book>();
        }
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
