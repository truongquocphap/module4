package bookstore_managerment.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class KindBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String kindBook;
    @OneToMany(mappedBy = "kindBook",cascade = CascadeType.ALL)
    private List<Book> bookList;

    public KindBook() {
    }

    public KindBook(String kindBook, List<Book> bookList) {
        this.kindBook = kindBook;
        this.bookList = bookList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKindBook() {
        return kindBook;
    }

    public void setKindBook(String kindBook) {
        this.kindBook = kindBook;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
