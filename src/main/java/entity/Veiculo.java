package Atividade.ProjetoIndividual.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_veiculo")

public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "cliente_id",nullable = false)
    @NotNull(message = "O cliente é obrigatório")
    private Cliente cliente;

    @NotBlank(message = "A marca é obrigatório")
    private String marca;

    @NotBlank(message = "O modelo é obrigatório")
    private String modelo;

    @NotNull(message = "O ano é obrigatório")
    private Integer ano;

    @NotNull(message = "O valor é obrigatório")
    @DecimalMin("0.0 ")
    private BigDecimal valor;

    @NotBlank(message = "A placa é obrigatória")
    @Column(unique = true)
    private String placa;

    @NotNull(message = "O desconto é obrigatório")
    private Double maximoDesconto;

    private boolean vendido = false;
    private BigDecimal valorVenda;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Double getMaximoDesconto() {
        return maximoDesconto;
    }

    public void setMaximoDesconto(Double maximoDesconto) {
        this.maximoDesconto = maximoDesconto;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }
}

