package br.edu.ifpb.padroes.Decorator;

public class ExtraCheese extends DataPizzaExtraDecorator{

    public ExtraCheese(PizzaExtra pizza){
        super(pizza);
    }
    @Override
    public Float totalPrice(Float valor) {
        return valor *= 1.10f;
    }

    @Override
    public String name(String name) {
        return name += " (extra cheese)";
    }
}
