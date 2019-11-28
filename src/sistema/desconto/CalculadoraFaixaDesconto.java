
package sistema.desconto;

/**
 *
 * @author ezequiel
 */
public abstract class CalculadoraFaixaDesconto {  
    private CalculadoraFaixaDesconto proximoDesconto;

    public CalculadoraFaixaDesconto(CalculadoraFaixaDesconto proximoDesconto) {
        this.proximoDesconto = proximoDesconto;
    }
    
    public double desconto(double valorTotal){
        double desconto = Calcular(valorTotal); 
        if(desconto == -1){
            return proximoDesconto.desconto(valorTotal);
        }
   return desconto; 
    }

    protected abstract double Calcular(double valorTotal);
      
}
