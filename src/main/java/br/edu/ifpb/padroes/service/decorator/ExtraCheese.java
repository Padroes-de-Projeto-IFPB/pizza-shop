package br.edu.ifpb.padroes.service.decorator;

public class ExtraCheese extends DemandDecorator {

    public ExtraCheese(Demand demand) {
        super(demand);
    }

    @Override
    public Float updatePrice(Float price) {
        return super.updatePrice(addPriceExtraCheese(price));
    }

    @Override
    public String updateName(String name) {
        return super.updateName(addNameExtraCheese(name));
    }

    public Float addPriceExtraCheese(Float price) {
        price *= 1.10f;
        return price;
    }

    public String addNameExtraCheese(String name) {
        name += "|extra cheese";
        return name;
    }
}
