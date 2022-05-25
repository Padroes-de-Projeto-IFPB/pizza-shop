package br.edu.ifpb.padroes.domain.decorator;

import br.edu.ifpb.padroes.domain.Pizza;

public class PizzaDecorator implements Pizza {
    private Pizza wrapee;

    PizzaDecorator(Pizza pizza){
        this.wrapee = pizza;
    }

    @Override
    public Float getPrice() {
        return wrapee.getPrice();
    }

    @Override
    public String getName() {
        return wrapee.getName();
    }
}
