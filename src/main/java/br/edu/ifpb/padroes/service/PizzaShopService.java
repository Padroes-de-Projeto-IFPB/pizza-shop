package br.edu.ifpb.padroes.service;

import br.edu.ifpb.padroes.domain.Pizza;
import br.edu.ifpb.padroes.api.damenos.DamenosPizza;
import br.edu.ifpb.padroes.api.damenos.proxy.DamenosService;
import br.edu.ifpb.padroes.api.damenos.proxy.DamenosServiceProxy;
import br.edu.ifpb.padroes.domain.adapter.DamenosAdapter;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotPizza;
import br.edu.ifpb.padroes.api.pizzahot.proxy.PizzaHotService;
import br.edu.ifpb.padroes.api.pizzahot.proxy.PizzaHotServiceProxy;
import br.edu.ifpb.padroes.domain.adapter.PizzahotAdapter;
import br.edu.ifpb.padroes.service.decorator.*;

import java.util.ArrayList;
import java.util.List;

public class PizzaShopService {

    private DamenosService damenosService;
    private PizzaHotService pizzaHotService;

    public PizzaShopService() {
        // TODO - alterar criação de instância para chamar para o Proxy de Cache
        damenosService = new DamenosServiceProxy();
        pizzaHotService = new PizzaHotServiceProxy();
    }

    // TODO - implementar decorator para não precisar atributos da pizza como parâmetros no método
    public void orderPizza(Pizza pizza) {

        DemandDecorator demand;

        demand =
                new ExtraCheese(
                    new StuffedCrust(
                        new Discount(
                            new DemandStandard(pizza)
                    )
                )
            );

        Float totalPrice = demand.updatePrice(pizza.getPrice());
        String name = demand.updateName(pizza.getName());

//

        System.out.println(String.format("New order for = %s", name));
        System.out.println(String.format("Total price = %f", totalPrice));

    }

    // TODO - implementar adapter para unificar pizzas vindas das APIs Damenos e PizzaHot num único método getPizzas()
    //      - public List<Pizza> getPizzas() {}
    public List<Pizza> getPizzas() {
        List<Pizza> listaPizza = new ArrayList<>();

        DamenosAdapter damenosPizza;
        PizzahotAdapter pizzahotPizza;

        for (DamenosPizza pizza : this.getPizzasDamenos()) {
            damenosPizza = new DamenosAdapter(pizza);
            listaPizza.add(damenosPizza);
        }

        for (PizzaHotPizza pizza : this.getPizzasPizzaHot()) {
            pizzahotPizza = new PizzahotAdapter(pizza);
            listaPizza.add(pizzahotPizza);
        }

        return listaPizza;
    }

    public List<DamenosPizza> getPizzasDamenos() {
        return damenosService.getPizzas();
    }

    public List<PizzaHotPizza> getPizzasPizzaHot() {
        return pizzaHotService.getPizzas();
    }

}
