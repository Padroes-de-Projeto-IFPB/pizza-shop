package br.edu.ifpb.padroes.service;

import br.edu.ifpb.padroes.api.damenos.DamenosPizza;
import br.edu.ifpb.padroes.api.damenos.proxy.DamenosService;
import br.edu.ifpb.padroes.api.damenos.proxy.DamenosServiceProxy;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotPizza;
import br.edu.ifpb.padroes.api.pizzahot.proxy.PizzaHotService;
import br.edu.ifpb.padroes.api.pizzahot.proxy.PizzaHotServiceProxy;
import br.edu.ifpb.padroes.domain.Pizza;
import br.edu.ifpb.padroes.domain.PizzaShopPizza;
import br.edu.ifpb.padroes.domain.adapter.DamenosAdapter;
import br.edu.ifpb.padroes.domain.adapter.PizzahotAdapter;
import br.edu.ifpb.padroes.service.decorator.*;
import br.edu.ifpb.padroes.service.factory.FactoryDecorator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PizzaShopService {

    private DamenosService  damenosService;
    private PizzaHotService pizzaHotService;

    public PizzaShopService() {
        // TODO - alterar criação de instância para chamar para o Proxy de Cache
        damenosService  = new DamenosServiceProxy();
        pizzaHotService = new PizzaHotServiceProxy();
    }

    // TODO - implementar decorator para não precisar atributos da pizza como parâmetros no método
    public void orderPizza(Pizza pizza) {

        PizzaShopPizza pizzaOrder = (PizzaShopPizza) pizza;
        FactoryDecorator factory  = new FactoryDecorator(pizzaOrder);

        DecoratorOrder order = factory.contructor();

        Float totalPrice = order.updatePrice(pizzaOrder.getPrice());
        String name      = order.updateName(pizzaOrder.getName());

        System.out.println(String.format("New order for = %s", name));
        System.out.println(String.format("Total price = %.2f", totalPrice));

    }

    // TODO - implementar adapter para unificar pizzas vindas das APIs Damenos e PizzaHot num único método getPizzas()
    // TODO - public List<Pizza> getPizzas() {}

    public List<DamenosPizza>  getPizzasDamenos() {
        return damenosService.getPizzas();
    }

    public List<Pizza>         getPizzas() {
        List<Pizza>     pizzas  = new ArrayList<>();

        pizzas.addAll(this.getPizzasPizzaHot().stream().map(PizzahotAdapter::new).collect(Collectors.toList()));
        pizzas.addAll(this.getPizzasDamenos().stream().map(DamenosAdapter::new).collect(Collectors.toList()));

        return pizzas;
    }

    public List<PizzaHotPizza> getPizzasPizzaHot() {
        return pizzaHotService.getPizzas();
    }

}
