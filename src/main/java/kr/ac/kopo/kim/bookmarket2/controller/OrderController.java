package kr.ac.kopo.kim.bookmarket2.controller;

import jakarta.validation.Valid;
import kr.ac.kopo.kim.bookmarket2.domain.*;
import kr.ac.kopo.kim.bookmarket2.service.BookService;
import kr.ac.kopo.kim.bookmarket2.service.CartService;
import kr.ac.kopo.kim.bookmarket2.service.OrderProService;
import kr.ac.kopo.kim.bookmarket2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    // 1. 고객 정보 입력 폼 화면 보여주기 (GET)
    @GetMapping("/orderCustomerInfo")
    public String requestCustomerInfoForm(Model model){
        model.addAttribute("customer", order.getCustomer());
        return "orderCustomerInfo";
    }

    // 2. 입력된 고객 정보 제출받기 (POST)
    @PostMapping("/orderCustomerInfo")
    public String requestCustomerInfo(Customer customer){
        order.setCustomer(customer);
        return "redirect:/order/orderShippingInfo";
    }

    // 3. 배송 정보 입력 폼 화면 보여주기 (GET)
    @GetMapping("/orderShippingInfo")
    public String requestShippingInfoForm(Model model){
        model.addAttribute("shipping", order.getShipping());
        return "orderShippingInfo";
    }

    // 4. 배송 정보 제출받기 (POST)
    @PostMapping("/orderShippingInfo")
    public String requestShippingInfo(@Valid @ModelAttribute Shipping shipping, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors())
            return "orderShippingInfo";
        order.setShipping(shipping);

        model.addAttribute("order", order);
        return "redirect:/order/orderConfirmation";
    }

    // 5. 주문 확인 영수증 화면 보여주기 (GET)
    @GetMapping("/orderConfirmation")
    public String requestConfirmation(Model model){
        model.addAttribute("BookList", listOfBooks);
        model.addAttribute("order", order);
        return "orderConfirmation";
    }

    // 6. 주문 취소 처리 메서드 (canceled 로 통일 완료)
    @GetMapping("/orderCanceled")
    public String requestPermissionCanceled() {
        order = new Order(); // 주문 정보 초기화
        return "orderCanceled"; // templates/orderCanceled.html 파일 호출
    }
}