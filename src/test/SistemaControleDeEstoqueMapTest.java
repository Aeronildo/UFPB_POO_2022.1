package test;

import main.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SistemaControleDeEstoqueMapTest {

    SistemaControleDeEstoqueMap sistema = new SistemaControleDeEstoqueMap();

    @Test
    public void cadastraHardwareTest() {
        boolean cadastrouHardware = sistema.cadastraHardware("5700x", TipoDeHardware.PROCESSADOR, 1);
        assertTrue(cadastrouHardware);

    }

    @Test
    public void pesquisaHardwareTest(){
        SistemaControleDeEstoqueMap sistema = new SistemaControleDeEstoqueMap();

        sistema.cadastraHardware("5700x", TipoDeHardware.PROCESSADOR, 1);
        assertTrue(sistema.existeHardware("5700x"));
    }

    @Test
    public void contaQuantidadeEmEstoqueTest(){
        SistemaControleDeEstoqueMap sistema = new SistemaControleDeEstoqueMap();
        try {
            sistema.cadastraHardware("5700x", TipoDeHardware.PROCESSADOR, 20);
            assertTrue(sistema.pesquisaHardware("5700x").getQuantidade() == 20);
        }catch (HardwareNaoExisteException e) {
            fail("não deveria lançar exceção");
        }
    }

    @Test
    public void removerProdutoDeEstoque(){
        boolean cadastrouHardware = sistema.cadastraHardware("5700x", TipoDeHardware.PROCESSADOR, 1);
        assertTrue(cadastrouHardware);
        boolean removeuHardware = sistema.removerProdutoDeEstoque("5700x");
        assertTrue(removeuHardware);

    }

}
