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
public class DadHabitacao {

    private int idhabitacao;
    private String apto;
    private String andar;
    private String descricao;
    private String caracteristica;
    private Double preco_diaria;
    private String status;
    private String tipo_habitacao;

    public DadHabitacao(int idhabitacao, String andar, String apto, String descricao, String caracteristica, Double preco_diaria, String status, String tipo_habitacao) {
        this.idhabitacao = idhabitacao;
        this.apto = apto;
        this.andar = andar;
        this.descricao = descricao;
        this.caracteristica = caracteristica;
        this.preco_diaria = preco_diaria;
        this.status = status;
        this.tipo_habitacao = tipo_habitacao;
    }

    public DadHabitacao() {
    }

    public int getIdhabitacao() {
        return idhabitacao;
    }

    public void setIdhabitacao(int idhabitacao) {
        this.idhabitacao = idhabitacao;
    }

    public String getApto() {
        return apto;
    }

    public void setApto(String apto) {
        this.apto = apto;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public double getPreco_diaria() {
        return preco_diaria;
    }

    public void setPreco_diaria(Double preco_diaria) {
        this.preco_diaria = preco_diaria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo_habitacao() {
        return tipo_habitacao;
    }

    public void setTipo_habitacao(String tipo_habitacao) {
        this.tipo_habitacao = tipo_habitacao;
    }
}
