package vip.redcode.discount.core.service;

import vip.redcode.discount.core.model.Discount;

import java.util.List;

public interface DiscountService {

    List<Discount> findAll();

    Discount findById(Long id);

    Discount save(Discount discount);

    Discount savePut(Long id, Discount discount);

    Discount savePatch(Long id, Discount discount);

    void deleteById(Long id);
}
