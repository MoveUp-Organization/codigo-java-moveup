package br.com.fiap.model.dto;

import java.sql.Date;
import java.time.LocalDate;

public class  Missao extends Atividade {
    private int idMisssao;
    private LocalDate dataAtividade;

    //construtores
    public Missao() {

    }

    public Missao(int idMisssao, String descricao, String tipoTransporte, int pontosGerados, int pontosDisponiveis, LocalDate dataAtividade) {
       super.setDescricao(descricao);
       super.setTipoTransporte(tipoTransporte);
       super.setPontosGerados(pontosGerados);
       super.setPontosDisponiveis(pontosDisponiveis);

       setIdMisssao(idMisssao);
       setDataAtividade(dataAtividade);
    }

    // métodos getters/setters

    public LocalDate getDataAtividade() {
        return dataAtividade;
    }

    public void setDataAtividade(LocalDate dataAtividade) {
        this.dataAtividade = dataAtividade;
    }

    public int getIdMisssao() {
        return idMisssao;
    }

    public void setIdMisssao(int idMisssao) {
        this.idMisssao = idMisssao;
    }
}