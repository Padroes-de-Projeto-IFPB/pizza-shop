package br.edu.ifpb.padroes.Decorator;

import br.edu.ifpb.padroes.domain.Pizza;

public class StuffedCrust implements PizzaExtra{

    @Override
    public Float totalPrice(Float valor) {

        return valor *= 1.20f;
    }

    @Override
    public String name(String name) {
        return name += " (stuffed crust)";
    }
}
