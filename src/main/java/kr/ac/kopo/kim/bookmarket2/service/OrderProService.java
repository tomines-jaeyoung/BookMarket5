package kr.ac.kopo.kim.bookmarket2.service;

import kr.ac.kopo.kim.bookmarket2.domain.Order;
import kr.ac.kopo.kim.bookmarket2.repository.OrderProRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class OrderProService {
    @Autowired
    private OrderProRepository orderProRepository;

    public void save(Order order) {
        orderProRepository.save(order);
    }

    public Order get(Long id) {
        return orderProRepository.findById(id).get();
    }

    public void delete(Long id) {
        orderProRepository.deleteById(id);

    }

    public void deleteAll() {
        orderProRepository.deleteAll();
    }

    public Page<Order> listAll(int pageNum, String sorfField, String sortDir) {
        return null;
    }
}
