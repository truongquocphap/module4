package bookstore_managerment.controller;

import bookstore_managerment.exception.BookMountException;
import bookstore_managerment.model.entity.Book;
import bookstore_managerment.model.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    @Autowired
    IBookService iBookService;
    @GetMapping("/book")
    public String listBook(Model model) {

        model.addAttribute("book", iBookService.findAll());
        return "book/list_book";
    }
    @GetMapping("view/{id}")
    public String viewBook(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("book", iBookService.findById(id));
        return "book/view_book";
    }
    @PostMapping("/rent_book")
    public String rent(@RequestParam("id") Integer id, Model model) throws BookMountException {
        Book book = iBookService.findById(id);
        if (book.getAmount() == 0) {
            throw new BookMountException();
        } else {
            book.setAmount(book.getAmount() - 1);
            iBookService.save(book);
            model.addAttribute("book", iBookService.findAll());
            return "book/list_book";
        }
    }
    @GetMapping("give_book")
    public String showGiveBook(Model model) {
        return "book/give_book";
    }

    @PostMapping("give_book")
    public String giveBook(@RequestParam("id") Integer id, Model model) {
        Book book = iBookService.findById(id);
        book.setAmount(book.getAmount() + 1);
        iBookService.save(book);
        model.addAttribute("book", iBookService.findAll());
        return "book/list_book";
    }
    @ExceptionHandler(BookMountException.class)
    public String showError() {
        return "book/error";
    }

}
