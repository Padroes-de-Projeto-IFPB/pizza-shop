package br.edu.ifpb.padroes.service.decorator;

public class DemandDecorator implements Demand {
    private Demand demand;

    public DemandDecorator(Demand demand) {
        this.demand = demand;
    }

    @Override
    public Float updatePrice(Float price) {
        return demand.updatePrice(price);
    }

    @Override
    public String updateName(String name) {
        return demand.updateName(name);
    }


}

