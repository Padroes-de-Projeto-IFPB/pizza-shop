package br.edu.ifpb.padroes.api.damenos.proxy;

import br.edu.ifpb.padroes.api.damenos.DamenosPizza;
import br.edu.ifpb.padroes.api.damenos.DamenosServiceImpl;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotPizza;

import java.util.ArrayList;
import java.util.List;

// TODO - implementar proxy de cache para evitar leitura do json a cada chamada do método
public class DamenosServiceProxy implements DamenosService {
    private List<DamenosPizza> cache = new ArrayList<>();
    private DamenosService damenosService;
    public DamenosServiceProxy(){
        damenosService = new DamenosServiceImpl();
    }
    @Override
    public List<DamenosPizza> getPizzas() {
        if(cache.isEmpty()){
            cache = damenosService.getPizzas();
        }else{
            System.out.println("Retrieved list from cache.");
        }
        // TODO - implementar proxy
        return cache;
    }
}
