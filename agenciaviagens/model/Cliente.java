package model;

public abstract class Cliente {
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private String tipo;
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { 
        if(nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("Nome inválido");
        this.nome = nome; 
    }
    
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getTipo() { return tipo; }
    protected void setTipo(String tipo) { this.tipo = tipo; }
    
    public String getPassaporte() { throw new UnsupportedOperationException(); }
    public String getCPF() { throw new UnsupportedOperationException(); }
}