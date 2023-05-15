package kr.inhatc.spring.cart.repository;

import kr.inhatc.spring.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {


}
