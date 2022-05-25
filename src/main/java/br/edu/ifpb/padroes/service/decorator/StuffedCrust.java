package br.edu.ifpb.padroes.service.decorator;

public class StuffedCrust extends DecoratorOrder {

    public StuffedCrust(Order order) {
        super(order);
    }

    @Override
    public Float updatePrice(Float price) {
        return super.updatePrice(addStuffedCrust(price));
    }

    @Override
    public String updateName(String name) {
        return super.updateName(addName(name));
    }

    public Float addStuffedCrust(Float price) {
        price *= 1.20f;
        return price;
    }

    public String addName(String name) {
        name += " (stuffed crust)";
        return name;
    }
}
