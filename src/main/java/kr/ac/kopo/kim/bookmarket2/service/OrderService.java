package kr.ac.kopo.kim.bookmarket2.service;

import kr.ac.kopo.kim.bookmarket2.domain.Order;

public interface OrderService {
    void confirmOrder(String bookId, long quantity);
    Long saveOrder(Order order);
}
