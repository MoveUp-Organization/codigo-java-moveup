package br.com.fiap.model.dto;

import java.sql.Date;
import java.time.LocalDate;

public class Transporte extends Atividade{
    //atributos
    private int idTransporte;
    private LocalDate dataGeracao;
    private String status;
    private int quantidadePassagem;
    private int pontosUtilizados;


    //construtores
    public Transporte(){

    }

    public Transporte(int idTransporte,String descricao, String tipoTransporte, int pontosGerados, LocalDate dataGeracao, String status ,int quantidadePassagem, int pontosUtilizados, int pontosDisponiveis){
        super.setDescricao(descricao);
        super.setTipoTransporte(tipoTransporte);
        super.setPontosGerados(pontosGerados);
        super.setPontosDisponiveis(pontosDisponiveis);

        setIdTransporte(idTransporte);
        setDataGeracao(dataGeracao);
        setStatus(status);
        setQuantidadePassagem(quantidadePassagem);
        setPontosUtilizados(pontosUtilizados);

    }

    // métodos getters/setters


    public int getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    public LocalDate getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(LocalDate dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantidadePassagem() {
        return quantidadePassagem;
    }

    public void setQuantidadePassagem(int quantidadePassagem) {
        this.quantidadePassagem = quantidadePassagem;
    }

    public int getPontosUtilizados() {
        return pontosUtilizados;
    }

    public void setPontosUtilizados(int pontosUtilizados) {
        this.pontosUtilizados = pontosUtilizados;
    }
}
