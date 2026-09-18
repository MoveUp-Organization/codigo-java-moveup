package br.com.fiap.model.dto;

import java.time.LocalDate;

public class Voucher {
    private int idVoucher;
    private int quantidadePassagem;
    private LocalDate dataGeracao;
    private String status;
    private int pontosUtilizados;

    //contrutores
    public Voucher(){

    }

    public Voucher(int idVoucher, int quantidadePassagem, LocalDate dataGeracao, String status, int pontosUtilizados){
        setIdVoucher(idVoucher);
        setQuantidadePassagem(quantidadePassagem);
        setDataGeracao(dataGeracao);
        setStatus(status);
        setPontosUtilizados(pontosUtilizados);
    }

    //getters/setters


    public int getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(int idVoucher) {
        this.idVoucher = idVoucher;
    }

    public int getQuantidadePassagem() {
        return quantidadePassagem;
    }

    public void setQuantidadePassagem(int quantidadePassagem) {
        this.quantidadePassagem = quantidadePassagem;
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

    public int getPontosUtilizados() {
        return pontosUtilizados;
    }

    public void setPontosUtilizados(int pontosUtilizados) {
        this.pontosUtilizados = pontosUtilizados;
    }
}
