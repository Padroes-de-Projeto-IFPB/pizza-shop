package br.edu.ifpb.padroes.service.decorator;

public class Discount extends DemandDecorator {

    public Discount(Demand demand) {
        super(demand);
    }

    @Override
    public Float updatePrice(Float price) {
        return super.updatePrice(addPriceDiscount(price));
    }

    @Override
    public String updateName(String name) {
        return super.updateName(addNameDiscount(name));
    }

    public Float addPriceDiscount(Float price) {
        price *= 0.25f;
        return price;
    }

    public String addNameDiscount(String name) {
        name += "|discount";
        return name;
    }
}
