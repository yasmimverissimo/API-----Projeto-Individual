package Atividade.ProjetoIndividual.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import java.util.UUID;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @NotBlank(message = "O telefone é obrigatório")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "O CPF é obrigatório")
    @CPF(message = "CPF inválido")
    @Column(nullable = false,unique = true)
    private String cpf;

    @NotBlank(message = "O email é obrigatório")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "O telefone é obrigatório")
    @Column(nullable = false)
    private String telefone;

    //Construtor Padrão
    public Cliente(){}
    //Construtor com Parâmetros
    public Cliente(String nome, String cpf, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id + ", " +
                "nome='" + nome + '\'' + ", " +
                "cpf='" + cpf + '\'' + ", " +
                "email='" + email + '\'' + ", " +
                "telefone='" + telefone + '\'' + '}';
    }
 }
