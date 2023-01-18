package vip.redcode.discount.core.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vip.redcode.discount.core.model.Discount;
import vip.redcode.discount.core.service.DiscountService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/discount")
public class DiscountController {

    private DiscountService service;

    @GetMapping
    public ResponseEntity<List<Discount>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Discount> findById(@PathVariable(name = "id") Long id) {
        Discount discount = service.findById(id);
        if (discount != null) return ResponseEntity.ok().body(discount);
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Discount> save(Discount discount) {
        return ResponseEntity.ok().body(service.save(discount));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Discount> savePut(@PathVariable(name = "id") Long id, Discount discount) {
        Discount discountSave = service.savePut(id, discount);
        if (discountSave != null) return ResponseEntity.ok().body(discountSave);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Discount> savePatch(@PathVariable(name = "id") Long id, Discount discount) {
        Discount discountSave = service.savePatch(id, discount);
        if (discountSave != null) return ResponseEntity.ok().body(discountSave);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Discount> deleteById(@PathVariable(name = "id") Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
