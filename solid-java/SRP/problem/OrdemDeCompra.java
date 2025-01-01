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
