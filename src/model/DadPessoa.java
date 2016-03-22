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
public class DadPessoa {
    
    private int idpessoa;
    private String nome;
    private String cpf;
    private String rg;
    private String endereco;
    private String fone_res_com;
    private String fone_cel;
    private String email;

    public DadPessoa() {
    }

    public DadPessoa(int idpessoa, String nome, String cpf, String rg, String endereco, String fone_res_com, String fone_cel, String email) {
        this.idpessoa = idpessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.fone_res_com = fone_res_com;
        this.fone_cel = fone_cel;
        this.email = email;
    }

    public int getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(int idpessoa) {
        this.idpessoa = idpessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFone_res_com() {
        return fone_res_com;
    }

    public void setFone_res_com(String fone_res_com) {
        this.fone_res_com = fone_res_com;
    }

    public String getFone_cel() {
        return fone_cel;
    }

    public void setFone_cel(String fone_cel) {
        this.fone_cel = fone_cel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
