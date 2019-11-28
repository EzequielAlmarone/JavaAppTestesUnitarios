
package sistema;
import java.util.ArrayList;
import java.util.List;
import sistema.desconto.CalculadoraFaixaDesconto;

/**
 *
 * @author ezequiel
 */
public class Pedido {
    private CalculadoraFaixaDesconto calculadoraFaixaDesconto;
    private List<ItemPedido> carrinho = new ArrayList<>();

    public Pedido(CalculadoraFaixaDesconto calculadoraFaixaDesconto) {
        this.calculadoraFaixaDesconto = calculadoraFaixaDesconto;
    }
    
    /**
     * 
     * @param descricao
     * @param valor
     * @param quantidade 
     */
    
   public void adicionaItem(ItemPedido item) {
       this.carrinho.add(item);
    }
   
   public ResumoPedido resumo(){
   
        double valorTotal = carrinho.stream().mapToDouble(i -> i.getValor() * i.getQuantidade()).sum(); // intereitor
        
        double desconto = calculadoraFaixaDesconto.desconto(valorTotal);
        
      
       return new ResumoPedido(valorTotal, desconto);
   }  
}
