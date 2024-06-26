package com.mycompany.app.pdv.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tb_venda")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Cliente cliente;
    @OneToOne
    private Cliente vendedor;
    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ItemVenda> itemVenda;
    @Column(name = "vl_total")
    private double valorTotal;
    @Column(name = "vl_desconto")
    private double valorDesconto;
    @Column(name = "qt_itens")
    private int quantidadeItens;
    @Column(name = "metodo_pagamento")
    private String metodoPagamento;
    @Column(name = "cpf_nota")
    private String cpfNota;

    public Venda() {
    }

    public Venda(int id, Cliente cliente, Cliente vendedor, List<ItemVenda> itemVenda, double valorTotal, double valorDesconto, int quantidadeItens, String metodoPagamento, String cpfNota) {
        this.id = id;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.itemVenda = itemVenda;
        this.valorTotal = valorTotal;
        this.valorDesconto = valorDesconto;
        this.quantidadeItens = quantidadeItens;
        this.metodoPagamento = metodoPagamento;
        this.cpfNota = cpfNota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    public void setQuantidadeItens(int quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }

    public List<ItemVenda> getItemVenda() {
        return itemVenda;
    }

    public void setItemVenda(List<ItemVenda> itemVenda) {
        this.itemVenda = itemVenda;
    }

    public Cliente getVendedor() {
        return vendedor;
    }

    public void setVendedor(Cliente vendedor) {
        this.vendedor = vendedor;
    }

    public String getCpfNota() {
        return cpfNota;
    }

    public void setCpfNota(String cpfNota) {
        this.cpfNota = cpfNota;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
    
}
