package br.edu.ifpb.padroes.service.decorator;

import br.edu.ifpb.padroes.domain.Pizza;

public class DemandStandard implements Demand {
    private Pizza pizza;

    public DemandStandard(Pizza pizza) {
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
