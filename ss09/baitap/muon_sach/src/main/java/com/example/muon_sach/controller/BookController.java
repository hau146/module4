package com.example.muon_sach.controller;

import com.example.muon_sach.model.Book;
import com.example.muon_sach.model.BookCode;
import com.example.muon_sach.service.IBookCodeService;
import com.example.muon_sach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBookCodeService bookCodeService;

    @GetMapping("")
    public String showList(Model model) {
        List<Book> bookList = bookService.showList();
        model.addAttribute("bookList", bookList);
        return "list";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam(name = "id",
            defaultValue = "0",
            required = false) int id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "detail";
    }

    @PostMapping("/rent")
    public String rent(@ModelAttribute Book book,
                       RedirectAttributes redirectAttributes) {

        book.setQuantity(book.getQuantity() - 1);
        int randomCode = book.randomCodeBook();
        bookCodeService.saveRandomNumber(randomCode, book);
        bookService.save(book);
        redirectAttributes.addFlashAttribute("mess", "Thuê sách thành công, mã thuê của bạn là: " + randomCode);
        return "redirect:/";
    }

    @GetMapping("/showGiveBook")
    public String giveBook(Model model) {
        model.addAttribute("bookCode", new BookCode());
        return "give-book-back";
    }

    @PostMapping("/giveBook")
    public String create(@RequestParam int codeBook,
                         RedirectAttributes redirectAttributes) {
        List<BookCode> bookCodeList = bookCodeService.findAll();
        BookCode bookCode = null;
        int code = 0;
        for (int i = 0; i < bookCodeList.size(); i++) {
            if (codeBook == bookCodeList.get(i).getCodeBook()) {
                code = bookCodeList.get(i).getCodeBook();
                bookCode = bookCodeList.get(i);
                break;
            }
        }
        if (code == 0) {
            redirectAttributes.addFlashAttribute("mess", "Bạn chưa mượn sách nào có mã thuê này cả !");
            return "redirect:/showGiveBook";
        }
        Book book = bookCode.getBook();
        book.setQuantity(book.getQuantity() + 1);
        bookService.save(book);
        bookCodeService.deleteCodeBook(bookCode.getId());
        redirectAttributes.addFlashAttribute("mess", "Trả thành công");
        return "redirect:/";
    }
}
