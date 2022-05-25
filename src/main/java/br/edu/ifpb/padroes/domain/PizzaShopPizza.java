package br.edu.ifpb.padroes.domain;

public class PizzaShopPizza implements Pizza {

    private String  name;
    private Float   price;
    private Boolean discountCoupon;
    private Boolean extraCheese;
    private Boolean panPizza;
    private Boolean stuffedCrust;

    public PizzaShopPizza(String name, Float price) {
        this.name           = name;
        this.price          = price;
    }

    public PizzaShopPizza(String name, Float price, boolean discountCoupon, boolean extraCheese, boolean panPizza,
                          boolean stuffedCrust) {
        this.name           = name;
        this.price          = price;
        this.discountCoupon = discountCoupon;
        this.extraCheese    = extraCheese;
        this.panPizza       = panPizza;
        this.stuffedCrust   = stuffedCrust;
    }

    @Override
    public Float getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getDiscountCoupon() {
        return discountCoupon;
    }

    public void setDiscountCoupon(Boolean discountCoupon) {
        this.discountCoupon = discountCoupon;
    }

    public Boolean getExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(Boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public Boolean getPanPizza() {
        return panPizza;
    }

    public void setPanPizza(Boolean panPizza) {
        this.panPizza = panPizza;
    }

    public Boolean getStuffedCrust() {
        return stuffedCrust;
    }

    public void setStuffedCrust(Boolean stuffedCrust) {
        this.stuffedCrust = stuffedCrust;
    }

}
