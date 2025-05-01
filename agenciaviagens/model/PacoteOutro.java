package model;

public class PacoteOutro extends PacoteViagem {
    public PacoteOutro(String nome, String destino, int duracao, double preco, String descricao, String tipo) {
        setNome(nome);
        setDestino(destino);
        setDuracao(duracao);
        setPreco(preco);
        setDescricao(descricao);
        setTipo(tipo);
    }
}