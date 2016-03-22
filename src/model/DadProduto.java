/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Daniel
 */
public class DadProduto {
    
    private int idproduto;
    private String nome_produto;
    private String descricao;
    private String unidade_medida;
    private Double preco_venda;

    public DadProduto() {
    }

    public DadProduto(int idproduto, String nome_produto, String descricao, String unidade_medida, Double preco_venda) {
        this.idproduto = idproduto;
        this.nome_produto = nome_produto;
        this.descricao = descricao;
        this.unidade_medida = unidade_medida;
        this.preco_venda = preco_venda;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade_medida() {
        return unidade_medida;
    }

    public void setUnidade_medida(String unidade_medida) {
        this.unidade_medida = unidade_medida;
    }

    public Double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(Double preco_venda) {
        this.preco_venda = preco_venda;
    }
    
}
