package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Consulta {
    private String data;
    private String descricao;
    private double valor;
    private boolean pago;
    private Medico medico;

    public static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Consulta(String data, String descricao, double valor, Medico medico) {
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
        this.pago = false;
        this.medico = medico;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void marcarComoPago() {
        this.pago = true;
    }

    public boolean estaPago() {
        return pago;
    }

    public Medico getMedico() {
        return medico;
    }

    @Override
    public String toString() {
        return "Data = " + LocalDate.parse(data, fmt) + "\nDescricao = " + descricao + "\nValor = " + valor + "\nMédico: " + medico.getNome();
    }
}
