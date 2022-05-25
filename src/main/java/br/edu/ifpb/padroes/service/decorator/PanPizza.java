package br.edu.ifpb.padroes.service.decorator;

public class PanPizza extends DecoratorOrder {

    public PanPizza(Order order) {
        super(order);
    }

    @Override
    public Float updatePrice(Float price) {
        return super.updatePrice(addPanPizza(price));
    }

    @Override
    public String updateName(String name) {
        return super.updateName(addName(name));
    }

    public Float addPanPizza(Float price) {
        price *= 1.15f;
        return price;
    }

    public String addName(String name) {
        name += " (pan pizza)";
        return name;
    }
}
