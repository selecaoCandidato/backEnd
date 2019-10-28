package br.com.selecao.candidato.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

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
    private char sexo;

    @Column
    private String telefone;

    /**
     * Embora as classes Candidato e Conhecimento estejam devidamente mapeadas com seu relacionamento OneToMany,
     * os elementos do tipo Conhecimento não estão sendo persistidos corretamente, o valor da chave-estrangeira não
     * está sendo setado, fazendo com que a referência ao objeto candidado seja perdida. Por esse motivo e devido
     * ao prazo, vou tratar de modo um pouco mais braçal esses objetos.
     */
    //@JsonProperty("IdEmpresa")
    //@ManyToOne(fetch = FetchType.EAGER)
    private Empresa Empresa;

    @Column
    private String observacao;

    @OneToMany(mappedBy = "candidato", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private List<Conhecimento> conhecimentos;

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

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Empresa getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(Empresa empresa) {
        Empresa = empresa;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<Conhecimento> getConhecimentos() {
        return conhecimentos;
    }

    public void setConhecimentos(List<Conhecimento> conhecimentos) {
        this.conhecimentos = conhecimentos;
    }

    

}
