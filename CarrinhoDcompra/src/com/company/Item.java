package com.company;

import java.io.ObjectInputStream.GetField;

public class Item {
    private int numItem;
    private Produto produto;
    private int qtd;
    private Double precoTotalItem;

    public Item(int numItem, Produto produto, int qtd) {
        super();
        this.numItem = numItem;
        this.produto = produto;
        this.qtd = qtd;
    }

    public int getNumItem() {
        return numItem;
    }

    public void setNumItem(int numItem) {
        this.numItem = numItem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Double getPrecoTotalItem() {
        return precoTotalItem;
    }

    public void setPrecoTotalItem(Double precoTotalItem) {
        this.precoTotalItem = precoTotalItem;
    }
}

