package kr.ac.kopo.kim.bookmarket2.repository;

import kr.ac.kopo.kim.bookmarket2.domain.Cart;
public interface CartRepository {
    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);

}

