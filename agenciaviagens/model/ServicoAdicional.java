package model;

public class ServicoAdicional {
    private String nome;
    private String descricao;
    private double preco;
    
    public ServicoAdicional(String nome, String descricao, double preco) {
        setNome(nome);
        setDescricao(descricao);
        setPreco(preco);
    }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
}