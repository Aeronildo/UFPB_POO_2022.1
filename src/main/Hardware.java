package main;

import java.util.Objects;

public class Hardware {
    private String nome;
    private TipoDeHardware tipoDeHardware;
    private int quantidade;

    public Hardware(String nome, TipoDeHardware tipoDeHardware, int quantidade) {
        this.nome = nome;
        this.tipoDeHardware = tipoDeHardware;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public TipoDeHardware getTipoDeHardware() {
        return tipoDeHardware;
    }

    public void setTipoDeHardware(TipoDeHardware tipoDeHardware) {
        this.tipoDeHardware = tipoDeHardware;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hardware hardware = (Hardware) o;
        return Objects.equals(nome, hardware.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
