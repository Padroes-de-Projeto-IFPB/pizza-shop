package br.edu.ifpb.padroes.service.decorator;

public class DecoratorOrder implements Order {
    private Order  wrappee;

    public DecoratorOrder(Order order) {
        this.wrappee    = order;
    }

    @Override
    public Float updatePrice(Float price) {
        return wrappee.updatePrice(price);
    }

    @Override
    public String updateName(String name) {
        return wrappee.updateName(name);
    }
}
