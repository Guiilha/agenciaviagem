package model;

public class PacoteCultural extends PacoteViagem {
    public PacoteCultural(String nome, String destino, int duracao, double preco, String descricao) {
        setNome(nome);
        setDestino(destino);
        setDuracao(duracao);
        setPreco(preco);
        setDescricao(descricao);
        setTipo("cultural");
    }
}