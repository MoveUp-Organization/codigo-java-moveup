package br.com.fiap.model.dto;

public class Atividade {
    private String descricao;
    private String tipoTransporte;
    private int pontosGerados;
    private int pontosDisponiveis;

    public Atividade() {
    }

    public Atividade(String descricao, String tipoTransporte, int pontosGerados, int pontosDisponiveis) {
        this.descricao = descricao;
        this.tipoTransporte = tipoTransporte;
        this.pontosGerados = pontosGerados;
        this.pontosDisponiveis = pontosDisponiveis;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public int getPontosGerados() {
        return pontosGerados;
    }

    public void setPontosGerados(int pontosGerados) {
        this.pontosGerados = pontosGerados;
    }

    public int getPontosDisponiveis() {
        return pontosDisponiveis;
    }

    public void setPontosDisponiveis(int pontosDisponiveis) {
        this.pontosDisponiveis = pontosDisponiveis;
    }
}







