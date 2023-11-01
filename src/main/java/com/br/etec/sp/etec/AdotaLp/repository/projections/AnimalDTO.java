package com.br.etec.sp.etec.AdotaLp.repository.projections;

public class AnimalDTO {

    private Integer id;
    private String nomeanimal;
    private String sexo;
    private Integer idade;
    private String porte;
    //FK's
    private String descricao;
    private String nomecidade;

    public AnimalDTO(Integer id, String nomeanimal, String sexo, Integer idade, String porte, String descricao, String nomecidade) {
        this.id = id;
        this.nomeanimal = nomeanimal;
        this.sexo = sexo;
        this.idade = idade;
        this.porte = porte;
        this.descricao = descricao;
        this.nomecidade = nomecidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeanimal() {
        return nomeanimal;
    }

    public void setNomeanimal(String nomeanimal) {
        this.nomeanimal = nomeanimal;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomecidade() {
        return nomecidade;
    }

    public void setNomecidade(String nomecidade) {
        this.nomecidade = nomecidade;
    }
}
