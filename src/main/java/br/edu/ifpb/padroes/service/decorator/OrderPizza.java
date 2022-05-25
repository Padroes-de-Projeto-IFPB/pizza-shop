package br.edu.ifpb.padroes.service.decorator;

import br.edu.ifpb.padroes.domain.Pizza;

public class OrderPizza implements Order {
    private Pizza pizza;

    public OrderPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public Float updatePrice(Float price) {
        return price;
    }

    @Override
    public String updateName(String name) {
        return name;
    }
}
