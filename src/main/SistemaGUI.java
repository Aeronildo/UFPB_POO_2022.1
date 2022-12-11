package main;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.*;

public class SistemaGUI extends JFrame implements ActionListener {

    JButton botaoAdicionar = new JButton("Cadastrar Hardware");
    JButton botaoPesquisar = new JButton("Pesquisar Hardware");
    JButton botaoQuantidade = new JButton("Consultar quantidade em estoque");
    JButton botaoPegarLista = new JButton("Obter lista de peças por categoria");
    JButton botaoRemover = new JButton("Remover hardware");
    ImageIcon Image = new ImageIcon("./imgs/hw.png");
    JLabel label = new JLabel(Image);
    JLabel text = new JLabel("Sistema Controle de Estoque");
    Font font = new Font("times new roman", Font.BOLD, 22);

    public SistemaGUI() {

        add(label);

        //main window config
        setTitle("programa controle de estoque de peças");
        setSize(800, 600);
        setVisible(true);
        setResizable(false);
        setBackground(Color.yellow);
        setLocation(150,150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Buttons
        botaoAdicionar.setBounds(450, 50, 280, 50);
        add(botaoAdicionar);
        botaoAdicionar.addActionListener(this);
        botaoPesquisar.setBounds(450, 250, 280, 50);
        add(botaoPesquisar);
        botaoPesquisar.addActionListener(this);
        botaoQuantidade.setBounds(450, 350, 280, 50);
        add(botaoQuantidade);
        botaoQuantidade.addActionListener(this);
        botaoPegarLista.setBounds(450, 450, 280, 50);
        add(botaoPegarLista);
        botaoPegarLista.addActionListener(this);
        botaoRemover.setBounds(450, 150, 280, 50);
        add(botaoRemover);
        botaoRemover.addActionListener(this);

        //text configs
        text.setBounds(250, 5, 350, 20);
        text.setFont(font);
        add(text);
        add(label);


    }


    public static void main(String[] args) {
        new SistemaGUI();


    }

    SistemaControleDeEstoqueMap sistema = new SistemaControleDeEstoqueMap();

    @Override
    public void actionPerformed(ActionEvent e){

        if (e.getSource() == (botaoAdicionar)) {
            String nome = JOptionPane.showInputDialog("Digite O nome: ");
            int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de peças: "));
            String tipo = JOptionPane.showInputDialog("PROCESSADOR \n VGA \n MEMORIA \n Qual o tipo de hardware?: " );
            TipoDeHardware tipoDeHardware = null;
            if(tipo.equals("PROCESSADOR")){
                tipoDeHardware = TipoDeHardware.PROCESSADOR;
            } else if(tipo.equals("VGA")){
                tipoDeHardware = TipoDeHardware.VGA;
            } else if(tipo.equals("MEMORIA")){
                tipoDeHardware = TipoDeHardware.MEMORIA;
            }
            if(nome.equals("") || quantidade == 0 || tipo.equals("")){
                JOptionPane.showMessageDialog(null, "Inválido.");
            } else {
                sistema.cadastraHardware(nome, tipoDeHardware, quantidade);
            }

        }


        if (e.getSource() == (botaoPesquisar)) {
            String nome1 = JOptionPane.showInputDialog("Qual a peça a pesquisar?: ");
            try {
                Hardware x = sistema.pesquisaHardware(nome1);
                JOptionPane.showMessageDialog(null,"produto está cadastrado\n" + x.getQuantidade() + "peças no estoque");

            } catch (HardwareNaoExisteException c) {
                JOptionPane.showMessageDialog(null, "não cadastrado no sistema");
            }
        }


        if(e.getSource() == botaoQuantidade){
            String nome2 = JOptionPane.showInputDialog(null, "Digite o nome a pesquisar: ");
            int quantidade1 = sistema.contaQuantidadeEmEstoque(nome2);
            JOptionPane.showMessageDialog(null, quantidade1);
        }


        if(e.getSource() == botaoPegarLista){
            String tipo1 = JOptionPane.showInputDialog("Qual o tipo de hardware?:\n 1.PROCESSADOR\n" + "2.VGA\n" + "3.MEMORIA\n");

            TipoDeHardware tipoDeHardware = null;
            if(tipo1.equals("1")){
                tipoDeHardware = TipoDeHardware.PROCESSADOR;
            } else if(tipo1.equals("2")){
                tipoDeHardware = TipoDeHardware.VGA;
            } else if(tipo1.equals("3")){
                tipoDeHardware = TipoDeHardware.MEMORIA;
            }
            sistema.pesquisaHardwareDaCategoria(tipoDeHardware);

        }


        if(e.getSource() == botaoRemover){
            String nome3 = JOptionPane.showInputDialog(null, "Digite o que quer remover: ");
            sistema.removerProdutoDeEstoque(nome3);
        }


    }

}
