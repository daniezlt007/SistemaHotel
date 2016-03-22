
package model;

import java.sql.Date;

/**
 *
 * @author Daniel
 */
public class DadPagamento {
    private int idpagamento;
    private int idreserva;
    private String tipocomprovante;
    private String numcomprovante;
    private Double igv;
    private Double totalpagamento;
    private Date fecha_emissao;
    private Date fecha_pagamento;

    public DadPagamento() {
    }

    public DadPagamento(int idpagamento, int idreserva, String tipocomprovante, String numcomprovante, Double igv, Double totalpagamento, Date fecha_emissao, Date fecha_pagamento) {
        this.idpagamento = idpagamento;
        this.idreserva = idreserva;
        this.tipocomprovante = tipocomprovante;
        this.numcomprovante = numcomprovante;
        this.igv = igv;
        this.totalpagamento = totalpagamento;
        this.fecha_emissao = fecha_emissao;
        this.fecha_pagamento = fecha_pagamento;
    }

    public int getIdpagamento() {
        return idpagamento;
    }

    public void setIdpagamento(int idpagamento) {
        this.idpagamento = idpagamento;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public String getTipocomprovante() {
        return tipocomprovante;
    }

    public void setTipocomprovante(String tipocomprovante) {
        this.tipocomprovante = tipocomprovante;
    }

    public String getNumcomprovante() {
        return numcomprovante;
    }

    public void setNumcomprovante(String numcomprovante) {
        this.numcomprovante = numcomprovante;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public Double getTotalpagamento() {
        return totalpagamento;
    }

    public void setTotalpagamento(Double totalpagamento) {
        this.totalpagamento = totalpagamento;
    }

    public Date getFecha_emissao() {
        return fecha_emissao;
    }

    public void setFecha_emissao(Date fecha_emissao) {
        this.fecha_emissao = fecha_emissao;
    }

    public Date getFecha_pagamento() {
        return fecha_pagamento;
    }

    public void setFecha_pagamento(Date fecha_pagamento) {
        this.fecha_pagamento = fecha_pagamento;
    }
   
    
    
}


