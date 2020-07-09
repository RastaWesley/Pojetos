package com.company;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //Criação da Lista
    public static ArrayList<Item> itens = new ArrayList<Item>();
    public static Carrinho carrinho;

    public static void main(String[] args) throws IOException {
        //Lista com os produtos
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        Produto produto = new Produto(1, "Coca Cola", 5.50);
        produtos.add(produto);
        produto = new Produto(2, "Carne", 10.50);
        produtos.add(produto);
        produto = new Produto(3, "Cerveja Antartica", 7.50);
        produtos.add(produto);
        produto = new Produto(4, "Chocolate", 5.00);
        produtos.add(produto);
        produto = new Produto(5, "Leite", 3.00);
        produtos.add(produto);
        produto = new Produto(6, "Refrigerante mogi", 5.00);
        produtos.add(produto);
        produto = new Produto(7, "Banana", 2.50);
        produtos.add(produto);

        for (Produto p : produtos) {
            System.out.println(p.getCodigo() + " " + p.getDescricao() + ": " + p.getPrecoUnit());
        }
        //Scanner para o menu
        Scanner scanner = new Scanner(System.in);
        int opc = 0;
        do {

            System.out.println("\n============ MENU ============");
            System.out.println("1 - Escolher os Produtos");
            System.out.println("2 - Colocar no carrinho");
            System.out.println("3 - Finalizar compra");
            System.out.println("0 - Finalizar sessão");
            System.out.println("============================== ");

            opc = Integer.parseInt(scanner.nextLine());
            switch (opc) {
                case 1:
                    int codigoProduto = 0;
                    int codigoItem = 0;
                    do {
                        System.out.println("Digite o codigo do produto ou o 0 para terminar de comprar\n" +
                                "1-Coca Cola R$5.5 \n"+
                                "2-Carne R$10.50 \n"+
                                "3-Cerveja Antartica R$7.50 \n"+
                                "4-Chocolate R$5.00 \n"+
                                "5-Leite R$3.00 \n"+
                                "6-Refigerante Mogi R$5.00 \n"+
                                "7-Coca Cola R$2.50 ");
                        codigoProduto = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i <= produtos.size() - 1; i++) {
                            if (produtos.get(i).getCodigo() == codigoProduto) {
                                System.out.println("Digite a quantidade: ");
                                int qtd = Integer.parseInt(scanner.nextLine());

                                codigoItem = codigoItem + 1;
                                Item item = new Item(codigoItem, produtos.get(codigoProduto - 1), qtd);
                                adicionarProdutoAoItem(item);
                            }
                        }
                    } while (codigoProduto != 0);

                    break;
                case 2:
                    colocarItensNoCarrinho();
                    break;
                default:
                    finalizarCompra();
            }
        } while (opc != 0);

    }
    //Classe que adiciona o produto ao Item
    public static void adicionarProdutoAoItem(Item item) {
        itens.add(item);
        Double precoTotalItem = 0.0;
        precoTotalItem = item.getQtd() * item.getProduto().getPrecoUnit();
        item.setPrecoTotalItem(precoTotalItem);
        for (Item i : itens) {
            System.out.println(i.getNumItem() + " - " + i.getProduto().getDescricao() + " - " + " qtd: " + i.getQtd()
                    + " - total: " + i.getPrecoTotalItem());
        }
        System.out.println("==============================");
    }
    //Classe para adicionar os produtos ao carrinho
    public static void colocarItensNoCarrinho() {
        Scanner scanner = new Scanner(System.in);
        Double precoTotalCompra = 0.0;
        for (Item i : itens) {
            precoTotalCompra += i.getPrecoTotalItem();
        }
        System.out.println("Nome do cliente");
        String nomeCliente = scanner.nextLine();
        carrinho = new Carrinho(nomeCliente, precoTotalCompra, itens);
        System.out.println("Adicionado ao carrinho com sucesso");
    }
    //Classe de Finalização da compra
    public static void finalizarCompra() {
        System.out.println("Cliente: " + carrinho.getNomeCliente().toUpperCase());
        System.out.println("=========== PRODUTOS ===========\n");
        for (Item i : itens) {
            System.out.println(i.getNumItem() + " - " + i.getProduto().getDescricao() + " - " + " qtd: " + i.getQtd()
                    + " - total: " + i.getPrecoTotalItem()+ "\n");
        }
        System.out.println("=========== TOTAL =========== \n");
        System.out.println("Valor total da compra: " + carrinho.getPrecoTotal());
        //Adicionar todos os dados(Nome do Cliente e Produtos) ao arquivo Txt
        try {
            FileOutputStream os = new FileOutputStream(
                    "C:\\Saida Carrinho\\Compras.txt");

            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write("Cliente: " + carrinho.getNomeCliente().toUpperCase()+ "\n");
            bw.write("=========== PRODUTOS ==========="+"\n");
            for (Item i : itens) {
                bw.write(i.getNumItem() + " - " + i.getProduto().getDescricao() + " - " + " qtd: " + i.getQtd()
                        + " - total: " + i.getPrecoTotalItem()+"\n");
            }
            bw.write("=========== TOTAL ==========="+"\n");
            bw.write("Valor total da compra: " + carrinho.getPrecoTotal());
            bw.close();
        } catch (Exception e) {

        }
    }
}