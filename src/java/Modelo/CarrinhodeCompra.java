/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author PC
 */
public class CarrinhodeCompra {

    private Integer id;
    private List<ItemdeCompra> itens;
    private double total;

    public void addNovoItem(ItemdeCompra item) {
        if (this.itens == null) {
            this.itens = new ArrayList<ItemdeCompra>();
        }
        this.itens.add(item);
    }

    public void removerItem(ItemdeCompra itemRemove) {
        for (Iterator i = itens.iterator(); i.hasNext();) {
            ItemdeCompra item = (ItemdeCompra) i.next();

            if (item.getProduto().getId() == itemRemove.getProduto().getId()) {
                i.remove();
            }
        }
    }

    public double calculaTotal() {
        double vtotal = 0;
        for (ItemdeCompra item : this.itens) {
            vtotal += item.getTotal();
        }
        this.total = vtotal;
        return total;
    }

    public Integer getID() {
        return id;
    }
    
    public List<ItemdeCompra> getItens(){
        return itens;
    }
    
    public double getTotal(){
        return total;
    }

}
