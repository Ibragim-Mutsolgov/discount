package vip.redcode.discount.core.service.serviceimpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vip.redcode.discount.core.model.Discount;
import vip.redcode.discount.core.repository.DiscountRepository;
import vip.redcode.discount.core.service.DiscountService;

import java.util.List;

@Service
@AllArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    private DiscountRepository repository;

    @Override
    public List<Discount> findAll() {
        return repository.findAll();
    }

    @Override
    public Discount findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Discount save(Discount discount) {
        return repository.save(discount);
    }

    @Override
    public Discount savePut(Long id, Discount discount) {
        return repository.findById(id)
                .map(discountSave -> {
                    discountSave.setId(discount.getId());
                    discountSave.setDiscount(discount.getDiscount());
                    return repository.save(discountSave);
                }).orElse(null);
    }

    @Override
    public Discount savePatch(Long id, Discount discount) {
        return repository.findById(id)
                .map(discountSave -> {
                    discountSave.setDiscount(discount.getDiscount());
                    return repository.save(discountSave);
                }).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
