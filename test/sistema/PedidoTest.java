/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sistema.desconto.CalculadoraDescontoPrimeiraFaixa;
import sistema.desconto.CalculadoraDescontoSegundaFaixa;
import sistema.desconto.CalculadoraDescontoTerceiraFaixa;
import sistema.desconto.CalculadoraFaixaDesconto;
import sistema.desconto.SemDesconto;


/**
 *
 * @author ezequiel
 */
public class PedidoTest {
    
    //Baby Steps
    private Pedido pedido;
    
    @Before
    public void setup(){
        CalculadoraFaixaDesconto calculadoraFaixaDesconto = new CalculadoraDescontoTerceiraFaixa(
        new CalculadoraDescontoSegundaFaixa(new CalculadoraDescontoPrimeiraFaixa(new SemDesconto(null))));
        pedido = new Pedido(calculadoraFaixaDesconto);
    }

    @Test
    public void testeAdicionaUmITem(){
        pedido.adicionaItem(new ItemPedido("Camisa", 45.0, 20));
    }
    @Test
    public void calcularValorTotalPedidoVazio(){
        ResumoPedido resumoPedido = pedido.resumo();
        Assert.assertEquals(0.0, resumoPedido.getValorTotal(), 0.0001);
   }
    
    private void assertResumoPedido(double valorTotal, double desconto){
        ResumoPedido resumoPedido = pedido.resumo();
        Assert.assertEquals(valorTotal, resumoPedido.getValorTotal(), 0.0001);
        Assert.assertEquals(desconto, resumoPedido.getDesconto(), 0.0001);        
    }
    
    @Test
    public void calcularValorTotalComDescontoPedidoVazio(){
        assertResumoPedido(0.0, 0.0);
    }
    
    @Test
    public void calcularUmItemSemDesconto(){
        pedido.adicionaItem(new ItemPedido("Camiseta", 40.0, 4));
        assertResumoPedido(160, 0.0);
    }
    @Test
    public void calcularDoisItemSemDesconto(){
        pedido.adicionaItem(new ItemPedido("Camiseta", 40.0, 4));
        pedido.adicionaItem(new ItemPedido("Bermuda Jeans", 40.0, 1));
        assertResumoPedido(200, 0.0);
    }
    
    @Test
    public void aplicarQuatroDesconto(){
        pedido.adicionaItem(new ItemPedido("Camiseta", 40.0, 4));
        pedido.adicionaItem(new ItemPedido("Bermuda Jeans", 40.0, 4));
        assertResumoPedido(320, 12.8);
    } 
    @Test
    public void aplicarSeisDesconto(){
        pedido.adicionaItem(new ItemPedido("Camiseta", 100.0, 4));
        pedido.adicionaItem(new ItemPedido("Bermuda Jeans", 100.0, 5));
        assertResumoPedido(900, 54.0);
    }
    @Test
    public void aplicarOitoDesconto(){
        pedido.adicionaItem(new ItemPedido("Camiseta", 200.0, 4));
        pedido.adicionaItem(new ItemPedido("Bermuda Jeans", 100.0, 5));
        assertResumoPedido(1300, 104);
    }
    
    
}
