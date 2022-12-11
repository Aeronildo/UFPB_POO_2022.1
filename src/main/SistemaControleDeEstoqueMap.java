package main;

import java.util.*;

public class SistemaControleDeEstoqueMap implements SistemaControleDeEstoque{

    private Map<String, Hardware> hardware;

    public SistemaControleDeEstoqueMap() {

        this.hardware = new HashMap<>();
    }
    
    public boolean cadastraHardware(String nome, TipoDeHardware tipoDeHardware, int quantidade) {
        if (this.hardware.containsKey(nome)){
            return false;
        }else{
            Hardware hardware = new Hardware(nome, tipoDeHardware, quantidade);
            this.hardware.put(nome, hardware);
        }
        return true;

    }

    public Hardware pesquisaHardware(String nome) throws HardwareNaoExisteException {
        Hardware hardware = this.hardware.get(nome);
        if (hardware == null) {
            throw new HardwareNaoExisteException("Não existe hardware com o nome "+nome);
        } else {
            return hardware;
        }


    }


    public int contaQuantidadeEmEstoque(String nome) {
        int cont = 0;
        for (Hardware p: this.hardware.values()){
            if (p.getNome().equals(nome)){
                cont++;
            }
        }
        return cont;

    }


    public boolean existeHardware(String nome) {
        if (this.hardware.containsKey(nome)){
            return true;
        }else{
            return false;
        }

    }


    public List<Hardware> pesquisaHardwareDaCategoria(TipoDeHardware tipoDeHardware) {
        List<Hardware> productCategory = new ArrayList<Hardware>();

        for (Hardware h : this.hardware.values()) {
            if (h.getTipoDeHardware().equals(tipoDeHardware)) {
                productCategory.add(h);
            }
        }
        return productCategory;
    }

    public boolean removerProdutoDeEstoque(String nome) {
        if (this.hardware.containsKey(nome)) {
            this.hardware.remove(nome, hardware);
            return true;
        } else {
            return false;
        }
    }

}
