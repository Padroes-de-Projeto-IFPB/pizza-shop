package br.edu.ifpb.padroes.Decorator;

public class DataPizzaExtraDecorator implements PizzaExtra{
    private PizzaExtra wrappee;

    DataPizzaExtraDecorator(PizzaExtra pizza){
        this.wrappee = pizza;
    }

    @Override
    public Float totalPrice(Float valor) {
        return wrappee.totalPrice(valor);
    }

    @Override
    public String name(String name) {
        return wrappee.name(name);
    }
}
