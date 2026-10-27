package kr.ac.kopo.kim.bookmarket2.controller;

import kr.ac.kopo.kim.bookmarket2.domain.*;
import kr.ac.kopo.kim.bookmarket2.service.BookService;
import kr.ac.kopo.kim.bookmarket2.service.CartService;
import kr.ac.kopo.kim.bookmarket2.service.OrderProService;
import kr.ac.kopo.kim.bookmarket2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
        private OrderService orderService;

    @Autowired
        private CartService cartService;
    List<Book> listOfBooks;

    Order order;

    @Autowired
    private OrderProService orderProService;

    @Autowired
    private BookService bookService;

    @GetMapping("/{cartId}")
    public String requestCartList(@PathVariable(value = "cartId") String cartId, Model model){
        Cart cart = cartService.read(cartId);

        order = new Order();
        listOfBooks = new ArrayList<Book>();

        for(CartItem item : cart.getCartItems().values()){
            OrderItem orderItem = new OrderItem();
            Book book = item.getBook();

            listOfBooks.add(book);

            orderItem.setBookId(book.getBookId());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setTotalPrice(item.getTotalPrice());

            order.getOrderItems().put(book.getBookId(), orderItem);
        }
        order.setCustomer(new Customer());
        order.setShipping(new Shipping());
        order.setGrandTotal(cart.getGrandTotal());

        return "redirect:/order/orderCustomerInfo";
    }

}
