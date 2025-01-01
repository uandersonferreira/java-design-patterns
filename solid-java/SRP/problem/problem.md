```java
public class OrdemDeCompra {

    private List<Produto> produtos = new ArrayList<>();
    
    // Adicionar produto à lista de produtos
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }
    
    // Remover produto da lista de produtos
    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }
    
    // Calcular o total da ordem de compra
    public BigDecimal calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Produto produto : produtos) {
            total = total.add(produto.getPreco());
        }
        return total;
    }
    
    // Buscar ordens de compra do banco de dados
    public List<OrdemDeCompra> buscarOrdemDeCompra() {
        // Lógica para buscar ordens de compra no banco de dados
        return new ArrayList<>();
    }
    
    // Salvar ordem de compra no banco de dados
    public void salvarOrdemCompra() {
        // Lógica para salvar a ordem de compra no banco de dados
        System.out.println("Ordem de compra salva.");
    }
    
    // Enviar e-mail sobre a ordem de compra
    public void enviarEmail(String email) {
        // Lógica para enviar e-mail
        System.out.println("Enviando e-mail para " + email);
    }
    
    // Imprimir ordem de compra
    public void imprimirOrdemDeCompra() {
        // Lógica para imprimir a ordem de compra
        System.out.println("Imprimindo ordem de compra.");
    }
    
}
```

### Explicação

Neste exemplo, a classe `OrdemDeCompra` está centralizando várias responsabilidades, que vão além da simples representação da ordem de compra. Ela é responsável por:

1. **Manipular os produtos da ordem**: A classe adiciona e remove produtos da lista.
2. **Calcular o total da compra**: Ela calcula o valor total dos produtos.
3. **Buscar ordens de compra no banco de dados**: A classe busca ordens de compra (o que indica uma responsabilidade relacionada ao acesso ao banco de dados).
4. **Salvar ordens de compra no banco de dados**: Ela também lida com a persistência de dados.
5. **Enviar e-mails**: A classe envia notificações por e-mail.
6. **Imprimir a ordem de compra**: Ela também tem a responsabilidade de gerar uma versão física ou em PDF da ordem.

Essa estrutura violaria o SRP porque a classe tem múltiplas responsabilidades não relacionadas diretamente à lógica de negócio da ordem de compra. Isso torna o código mais difícil de manter, testar e modificar no futuro, já que qualquer mudança em uma dessas responsabilidades pode afetar o comportamento de outras partes da classe. Além disso, em um ambiente de equipe, outras pessoas podem ter dificuldades para entender e modificar uma classe tão sobrecarregada de responsabilidades.

