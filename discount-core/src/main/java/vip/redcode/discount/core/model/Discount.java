package vip.redcode.discount.core.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "discounts")
public class Discount {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "discounts")
    private String discount;
}
