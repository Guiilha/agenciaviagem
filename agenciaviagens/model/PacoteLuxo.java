package model;

public class PacoteLuxo extends PacoteViagem {
    public PacoteLuxo(String nome, String destino, int duracao, double preco, String descricao) {
        setNome(nome);
        setDestino(destino);
        setDuracao(duracao);
        setPreco(preco);
        setDescricao(descricao);
        setTipo("luxo");
    }
}