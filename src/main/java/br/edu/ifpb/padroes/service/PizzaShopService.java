package br.edu.ifpb.padroes.service;

import br.edu.ifpb.padroes.Decorator.*;
import br.edu.ifpb.padroes.api.damenos.DamenosPizza;
import br.edu.ifpb.padroes.api.damenos.DamenosServiceImpl;
import br.edu.ifpb.padroes.api.damenos.proxy.DamenosService;
import br.edu.ifpb.padroes.api.damenos.proxy.DamenosServiceProxy;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotPizza;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotServiceImpl;
import br.edu.ifpb.padroes.api.pizzahot.proxy.PizzaHotService;
import br.edu.ifpb.padroes.domain.Pizza;
import br.edu.ifpb.padroes.domain.adapter.DamenosAdapter;
import br.edu.ifpb.padroes.domain.adapter.PizzahotAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PizzaShopService {

    private DamenosServiceProxy damenosService;
    private PizzaHotService pizzaHotService;

    public PizzaShopService() {
        // TODO - alterar criação de instância para chamar para o Proxy de Cache
        damenosService = new DamenosServiceProxy();
        pizzaHotService = new PizzaHotServiceImpl();
    }

    // TODO - implementar decorator para não precisar atributos da pizza como parâmetros no método
    public void orderPizza(Pizza pizza) {

        DataPizzaExtraDecorator newPizza = new DiscountCoupon(
                                            new ExtraCheese(
                                                    new PanPizza( new StuffedCrust())));

        Float totalPrice = newPizza.totalPrice(pizza.getPrice());
        String name = newPizza.name(pizza.getName());

        System.out.println(String.format("New order for = %s", name));
        System.out.println(String.format("Total price = %f", totalPrice));

    }

    // TODO - implementar adapter para unificar pizzas vindas das APIs Damenos e PizzaHot num único método getPizzas()
    // TODO - public List<Pizza> getPizzas() {}

    public List<Pizza> getPizzas() {
        List<Pizza> pizza = new ArrayList<>();
        pizza.addAll(pizzaHotService.getPizzas().stream().map(PizzahotAdapter::new).collect(Collectors.toList()));
        pizza.addAll(damenosService.getPizzas().stream().map(DamenosAdapter::new).collect(Collectors.toList()));
        return pizza;
    }

}
