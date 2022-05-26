package br.edu.ifpb.padroes.Decorator;

import br.edu.ifpb.padroes.domain.Pizza;

public class PanPizza extends DataPizzaExtraDecorator{
    public PanPizza(PizzaExtra pizza){
        super(pizza);
    }
    @Override
    public Float totalPrice(Float valor) {
        return super.totalPrice(valor *= 1.15f); // 15% increase

    }

    @Override
    public String name(String name) {
        return super.name(name += " (pan pizza)");
    }
}
