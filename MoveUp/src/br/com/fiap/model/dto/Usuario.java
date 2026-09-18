package br.com.fiap.model.dto;

public class Usuario {
    //atributos
    private int idUsuario;
    private String nomeUsuario;
    private String cpf;
    private String email;
    private String telefone;
    private String senha;
    private String cidade;
    private String bairro;
    private String rua;
    private String numeroResidencia;
    private int pontosDisponiveis;
    private int pontosUtilizados;
    private int quantidadePassagem;

    //contrutores
    public Usuario() {

    }

    public Usuario(int idUsuario, String nomeUsuario, String cpf, String email, String telefone, String senha, String cidade, String bairro, String rua, String numeroResidencia, int pontosDisponiveis, int pontosUtilizados, int quantidadePassagem) {
        setIdUsuario(idUsuario);
        setNomeUsuario(nomeUsuario);
        setCpf(cpf);
        setEmail(email);
        setTelefone(telefone);
        setSenha(senha);
        setCidade(cidade);
        setBairro(bairro);
        setRua(rua);
        setNumeroResidencia(numeroResidencia);
        setPontosDisponiveis(pontosDisponiveis);
        setPontosUtilizados(pontosUtilizados);
        setQuantidadePassagem(quantidadePassagem);
    }

    //métodos getters/setters

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumeroResidencia() {
        return numeroResidencia;
    }

    public void setNumeroResidencia(String numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
    }

    public int getPontosDisponiveis() {
        return pontosDisponiveis;
    }

    public void setPontosDisponiveis(int pontosDisponiveis) {
        this.pontosDisponiveis = pontosDisponiveis;
    }

    public int getPontosUtilizados() {
        return pontosUtilizados;
    }

    public void setPontosUtilizados(int pontosUtilizados) {
        this.pontosUtilizados = pontosUtilizados;
    }

    public int getQuantidadePassagem() {
        return quantidadePassagem;
    }

    public void setQuantidadePassagem(int quantidadePassagem) {
        this.quantidadePassagem = quantidadePassagem;
    }
}