package br.edu.ifpb.padroes.service.decorator;

public class PanPizza extends DemandDecorator {

    public PanPizza(Demand demand) {
        super(demand);
    }

    @Override
    public Float updatePrice(Float price) {
        return super.updatePrice(addPricePanPizza(price));
    }

    @Override
    public String updateName(String name) {
        return super.updateName(addNamePanPizza(name));
    }

    public Float addPricePanPizza(Float price) {
        price *= 1.15f;
        return price;
    }

    public String addNamePanPizza(String name) {
        name += "|pan pizza)";
        return name;
    }
}
