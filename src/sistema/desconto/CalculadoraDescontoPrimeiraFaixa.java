/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.desconto;

/**
 *
 * @author ezequiel
 */
public class CalculadoraDescontoPrimeiraFaixa extends CalculadoraFaixaDesconto {

    public CalculadoraDescontoPrimeiraFaixa(CalculadoraFaixaDesconto proximoDesconto) {
        super(proximoDesconto);
    }

    @Override
    protected double Calcular(double valorTotal) {
        if(valorTotal > 300 && valorTotal <= 800){
            return valorTotal * 0.04;
        }
        return -1;
    }
    
    
}
