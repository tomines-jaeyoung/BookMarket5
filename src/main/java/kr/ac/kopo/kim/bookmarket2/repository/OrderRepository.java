package kr.ac.kopo.kim.bookmarket2.repository;



import kr.ac.kopo.kim.bookmarket2.domain.Order;

public interface OrderRepository {
    Long saveOrder(Order order);
}