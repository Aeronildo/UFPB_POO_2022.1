package main;

import java.util.List;

public interface SistemaControleDeEstoque {
    boolean cadastraHardware(String nome, TipoDeHardware tipoDeHardware, int quantidade );
    Hardware pesquisaHardware(String nome) throws HardwareNaoExisteException;
    int contaQuantidadeEmEstoque(String nome);
    boolean existeHardware(String nome);
    List<Hardware> pesquisaHardwareDaCategoria(TipoDeHardware tipoDeHardware);

}
