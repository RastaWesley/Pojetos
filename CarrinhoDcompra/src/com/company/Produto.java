package com.company;

public class Produto {
    private int codigo;
    private String descricao;
    private Double precoUnit;


    public Produto(int codigo, String descricao, Double precoUnit) {
        super();
        this.codigo = codigo;
        this.descricao = descricao;
        this.precoUnit = precoUnit;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Double getPrecoUnit() {
        return precoUnit;
    }
    public void setPrecoUnit(Double precoUnit) {
        this.precoUnit = precoUnit;
    }


}