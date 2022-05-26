package br.edu.ifpb.padroes.service.decorator;

public class StuffedCrust extends DemandDecorator {

    public StuffedCrust(Demand demand) {
        super(demand);
    }

    @Override
    public Float updatePrice(Float price) {
        return super.updatePrice(addPriceStuffedCrust(price));
    }

    @Override
    public String updateName(String name) {
        return super.updateName(addNameStuffedCrust(name));
    }

    public Float addPriceStuffedCrust(Float price) {
        price *= 1.20f;
        return price;
    }

    public String addNameStuffedCrust(String name) {
        name += "|stuffed crust";
        return name;
    }
}
