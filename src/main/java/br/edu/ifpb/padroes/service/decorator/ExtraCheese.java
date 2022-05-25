package br.edu.ifpb.padroes.service.decorator;

public class ExtraCheese extends DecoratorOrder {

    public ExtraCheese(Order order) {
        super(order);
    }

    @Override
    public Float updatePrice(Float price) {
        return super.updatePrice(addExtraCheese(price));
    }

    @Override
    public String updateName(String name) {
        return super.updateName(addName(name));
    }

    public Float addExtraCheese(Float price) {
        price *= 1.10f;
        return price;
    }

    public String addName(String name) {
        name += " (extra cheese)";
        return name;
    }
}
