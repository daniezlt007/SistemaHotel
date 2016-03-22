/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Daniel
 */
public class DadReserva {
    private int idreserva;
    private int idhabitacao;
    private int idcliente;
    private int idtrabalhador;
    private String tipo_reserva;
    private Date fecha_reserva;
    private Date entrada_reserva;
    private Date saida_reserva;
    private Double custo_apto;
    private String estado;

    //Contrutores
    public DadReserva() {
    }

    public DadReserva(int idreserva, int idhabitacao, int idcliente, int idtrabalhador, String tipo_reserva, Date fecha_reserva, Date entrada_reserva, Date saida_reserva, Double custo_apto, String estado) {
        this.idreserva = idreserva;
        this.idhabitacao = idhabitacao;
        this.idcliente = idcliente;
        this.idtrabalhador = idtrabalhador;
        this.tipo_reserva = tipo_reserva;
        this.fecha_reserva = fecha_reserva;
        this.entrada_reserva = entrada_reserva;
        this.saida_reserva = saida_reserva;
        this.custo_apto = custo_apto;
        this.estado = estado;
    } 

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public int getIdhabitacao() {
        return idhabitacao;
    }

    public void setIdhabitacao(int idhabitacao) {
        this.idhabitacao = idhabitacao;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdtrabalhador() {
        return idtrabalhador;
    }

    public void setIdtrabalhador(int idtrabalhador) {
        this.idtrabalhador = idtrabalhador;
    }

    public String getTipo_reserva() {
        return tipo_reserva;
    }

    public void setTipo_reserva(String tipo_reserva) {
        this.tipo_reserva = tipo_reserva;
    }

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public Date getEntrada_reserva() {
        return entrada_reserva;
    }

    public void setEntrada_reserva(Date entrada_reserva) {
        this.entrada_reserva = entrada_reserva;
    }

    public Date getSaida_reserva() {
        return saida_reserva;
    }

    public void setSaida_reserva(Date saida_reserva) {
        this.saida_reserva = saida_reserva;
    }

    public Double getCusto_apto() {
        return custo_apto;
    }

    public void setCusto_apto(Double custo_apto) {
        this.custo_apto = custo_apto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
 
}
