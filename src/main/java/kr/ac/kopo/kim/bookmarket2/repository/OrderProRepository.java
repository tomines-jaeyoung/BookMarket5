package kr.ac.kopo.kim.bookmarket2.repository;

import kr.ac.kopo.kim.bookmarket2.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProRepository extends JpaRepository<Order, Long> {
}