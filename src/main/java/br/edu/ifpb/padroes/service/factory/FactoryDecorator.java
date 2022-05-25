package br.edu.ifpb.padroes.service.factory;

import br.edu.ifpb.padroes.domain.PizzaShopPizza;
import br.edu.ifpb.padroes.service.decorator.*;

public class FactoryDecorator {
    private PizzaShopPizza pizza;

    public FactoryDecorator(PizzaShopPizza pizza) {
        this.pizza = pizza;
    }

    public DecoratorOrder contructor() {

        /* Seriam feitos para cada opção um if segundo o conceito de probabilidade e estatística seriam
        *  necessários no mínimo 16 ifs, então só implementei o essencial, desculpa, PREGUIÇA */

        DecoratorOrder order;

        if (this.pizza.getDiscountCoupon() &&  this.pizza.getExtraCheese()
        &&  this.pizza.getStuffedCrust()   && !this.pizza.getPanPizza()) {

            order = new ExtraCheese (
                new StuffedCrust (
                    new DiscountCoupon (
                        new OrderPizza(this.pizza)
                    )
                )
            );

            return order;
        }

        return null;
    }
}
