
package sistema.desconto;

/**
 *
 * @author ezequiel
 * Calcula o desconto para valores acima de R$ 1.000,00
 */
public class CalculadoraDescontoTerceiraFaixa extends CalculadoraFaixaDesconto {

    public CalculadoraDescontoTerceiraFaixa(CalculadoraFaixaDesconto proximoDesconto) {
        super(proximoDesconto);
    }

    @Override
    protected double Calcular(double valorTotal) {
        if(valorTotal > 1000){
            return valorTotal * 0.08;
        }
        
        return -1;
                
    }
    
}
