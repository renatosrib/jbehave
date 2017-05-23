package renatosrib

import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When
import renatosrib.entidades.Compra
import renatosrib.entidades.ItemDaCompra
import renatosrib.entidades.Produto

import static org.junit.Assert.assertEquals

class CompraDeProdutosSteps {
    Produto produto
    Compra compra

    @Given('é vendido $produto por $preco')
    public void defineProduto(String produto, String preco) {
        this.produto = new Produto(nome: produto, preco: new BigDecimal(preco));
    }

    @When('compro $quantidade')
    public void comproProduto(BigDecimal quantidade) {
        ItemDaCompra itemDaCompra = new ItemDaCompra(produto: produto, quantidade: quantidade);
        this.compra = new Compra();
        this.compra.adicionarItem(itemDaCompra);
    }

    @Then('o subtotal deve ser $subTotal reais')
    public void calculoSubtotal(BigDecimal subTotal) {
        assertEquals(compra.subTotal(), subTotal, 0);
    }

}
