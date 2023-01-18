package vip.redcode.discount.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vip.redcode.discount.core.model.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
