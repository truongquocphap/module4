package bookstore_managerment.model.entity;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameBook;
    private int amount;
    private String content;
    @ManyToOne
    @JoinColumn(name = "kind_book_id",referencedColumnName = "id")
    private KindBook kindBook;

    public Book() {
    }
    public Book(String nameBook, int amount, String content, KindBook kindBook) {
        this.nameBook = nameBook;
        this.amount = amount;
        this.content = content;
        this.kindBook = kindBook;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public KindBook getKindBook() {
        return kindBook;
    }

    public void setKindBook(KindBook kindBook) {
        this.kindBook = kindBook;
    }
}
