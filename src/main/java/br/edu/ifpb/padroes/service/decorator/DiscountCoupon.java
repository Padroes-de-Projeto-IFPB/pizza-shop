package br.edu.ifpb.padroes.service.decorator;

import br.edu.ifpb.padroes.domain.Pizza;

public class DiscountCoupon extends DecoratorOrder {
    public DiscountCoupon(Order order) {
        super(order);
    }

    @Override
    public Float updatePrice(Float price) {
        return super.updatePrice(addDiscount(price));
    }

    @Override
    public String updateName(String name) {
        return super.updateName(addName(name));
    }

    public Float addDiscount(Float price) {
        price *= 0.25f;
        return price;
    }

    public String addName(String name) {
        name += " (discount)";
        return name;
    }

}
