package renatosrib

import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When
import org.jbehave.core.model.ExamplesTable
import renatosrib.entidades.Compra
import renatosrib.entidades.ItemDaCompra
import renatosrib.entidades.Produto

import static org.junit.Assert.assertEquals

class CompraDeProdutosListaSteps {
    Compra compra = new Compra()

    @Given('os seguintes produtos são comprados: $table')
    public void recebeProdutos(ExamplesTable table) {
        this.compra = adicionaTodosOsProdutoACompra(table)
    }

    @Then('o subtotal deve ser $subTotal reais')
    public void calculoSubtotal(BigDecimal subTotal) {
        assertEquals(compra.subTotal(), subTotal, 0);
    }

    private static Compra adicionaTodosOsProdutoACompra(ExamplesTable table) {
        Compra compra = new Compra()
        for(Map<String, String> map: table.getRows()) {
            Produto produto = new Produto(nome: map.get("Produto"), preco: new BigDecimal(map.get("Preco")))
            ItemDaCompra item = new ItemDaCompra(produto: produto, quantidade:  new BigDecimal(map.get("Quantidade")))
            compra.adicionarItem(item)
        }
        return compra
    }

}
