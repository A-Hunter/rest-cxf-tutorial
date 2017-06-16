package cxf.rest.ws.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Ghazi Naceur on 16/06/2017.
 */
@XmlRootElement(name = "Book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book implements Serializable{

    private long id;

    private String title;

    private String author;

    public Book() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
