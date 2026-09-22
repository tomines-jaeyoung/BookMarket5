package kr.ac.kopo.kim.bookmarket2.service;

import kr.ac.kopo.kim.bookmarket2.domain.Cart;

public interface CartService {
    Cart create(Cart cart);

    Cart read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);

}
