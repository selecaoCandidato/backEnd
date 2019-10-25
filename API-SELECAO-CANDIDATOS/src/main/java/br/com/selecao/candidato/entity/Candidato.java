package br.com.selecao.candidato.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Candidato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCandidato")
    private Long id;

    @Column
    private String nome;

    @Column
    private String idade;

    @Column
    private Boolean sexo;

    @Column
    private String telefone;

    @Column
    private String Empresa;

    @Column
    private String observacao;

    @OneToMany(mappedBy = "conhecimento")
    private Set<Conhecimento> conhecimentos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public Boolean getSexo() {
        return sexo;
    }

    public void setSexo(Boolean sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String empresa) {
        Empresa = empresa;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Set<Conhecimento> getConhecimentos() {
        return conhecimentos;
    }

    public void setConhecimentos(Set<Conhecimento> conhecimentos) {
        this.conhecimentos = conhecimentos;
    }

    

}
