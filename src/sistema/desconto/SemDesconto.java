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
public class SemDesconto extends CalculadoraFaixaDesconto {

    public SemDesconto(CalculadoraFaixaDesconto proximoDesconto) {
        super(proximoDesconto);
    }

    @Override
    protected double Calcular(double valorTotal) {
        return 0;
    }
    
}
