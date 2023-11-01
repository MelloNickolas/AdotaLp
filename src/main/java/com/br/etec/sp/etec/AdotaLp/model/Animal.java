package com.br.etec.sp.etec.AdotaLp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeanimal;
    private String sexo;
    private Integer idade;
    private String porte;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id.equals(animal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    //--------------------------------------------------------------------------------------------------------------


    @ManyToOne
    @JoinColumn(name = "idraca")
    private Raca raca;

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }


    //--------------------------------------------------------------------------------------------------------------

    @JsonIgnore
    @OneToMany(mappedBy = "situacaoanimal")
    private List<SituacaoAnimal> animalsituacao = new ArrayList<>();

    public List<SituacaoAnimal> getAnimalsituacao() {
        return animalsituacao;
    }

    public void setAnimalsituacao(List<SituacaoAnimal> animalsituacao) {
        this.animalsituacao = animalsituacao;
    }


    //--------------------------------------------------------------------------------------------------------------

    @JsonIgnore
    @OneToMany(mappedBy = "animal")
    private List<AdocaoDoacao> doacaoadocao = new ArrayList<>();

    public List<AdocaoDoacao> getDoacaoadocao() {
        return doacaoadocao;
    }

    public void setDoacaoadocao(List<AdocaoDoacao> doacaoadocao) {
        this.doacaoadocao = doacaoadocao;
    }

    //--------------------------------------------------------------------------------------------------------------

    @JsonIgnore
    @OneToMany(mappedBy = "fotosanimal")
    private List<FotosAnimal> fotosdoanimal = new ArrayList<>();

    public List<FotosAnimal> getFotosdoanimal() { return fotosdoanimal; }

    public void setFotosdoanimal(List<FotosAnimal> fotosdoanimal) { this.fotosdoanimal = fotosdoanimal; }

    //--------------------------------------------------------------------------------------------------------------

    @ManyToOne
    @JoinColumn(name = "idcidade")
    private Cidade cidadedoanimal;

    public Cidade getCidadedoanimal() {
        return cidadedoanimal;
    }

    public void setCidadedoanimal(Cidade cidadedoanimal) {
        this.cidadedoanimal = cidadedoanimal;
    }
}