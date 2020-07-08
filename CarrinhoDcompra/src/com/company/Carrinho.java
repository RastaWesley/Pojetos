package com.company;

import java.time.LocalDate;
import java.util.ArrayList;


public class Carrinho {
    private LocalDate dataCompra;
    private String  nomeCliente;
    private Double precoTotal;
    ArrayList<Item> itens = new ArrayList<Item>();

    public Carrinho(String nomeCliente, Double precoTotal, ArrayList<Item> itens) {
        super();
        this.dataCompra = LocalDate.now();
        this.nomeCliente = nomeCliente;
        this.precoTotal = precoTotal;
        this.itens = itens;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal += precoTotal;
    }

    public String getItens() {
        return ("Nome: " + getNomeCliente()
                + "\nData da compra: " + getDataCompra()

                + "\nValor total da compra: " + getPrecoTotal());
    }

    public void setItens(Item item) {
        this.itens.add(item);
    }


}