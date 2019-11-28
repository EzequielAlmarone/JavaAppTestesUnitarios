/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.desconto;

/**
 *
 * @author ezequiel
 * Calcula o valor de desconto de valor acima de R$ 800,00 e menor ou igual a R$ 1.000,00
 */
public class CalculadoraDescontoSegundaFaixa extends CalculadoraFaixaDesconto{

    public CalculadoraDescontoSegundaFaixa(CalculadoraFaixaDesconto proximoDesconto) {
        super(proximoDesconto);
    }

    @Override
    protected double Calcular(double valorTotal) {
        if(valorTotal > 800 && valorTotal <= 1000){
            return valorTotal * 0.06;
        }
        
        return -1;
    }
    
}
