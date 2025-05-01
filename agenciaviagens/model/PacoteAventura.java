package model;

public class PacoteAventura extends PacoteViagem {
    public PacoteAventura(String nome, String destino, int duracao, double preco, String descricao) {
        setNome(nome);
        setDestino(destino);
        setDuracao(duracao);
        setPreco(preco);
        setDescricao(descricao);
        setTipo("aventura");
    }
}