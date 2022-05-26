package br.edu.ifpb.padroes.Decorator;

import br.edu.ifpb.padroes.domain.Pizza;

public interface PizzaExtra {
    Float totalPrice(Float valor);
    String name(String name);
}
