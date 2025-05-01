package model;

public class ClienteNacional extends Cliente {
    private String cpf;
    
    public ClienteNacional(String nome, String telefone, String email, String cpf) {
        setNome(nome);
        setTelefone(telefone);
        setEmail(email);
        setTipo("nacional");
        setCPF(cpf);
    }
    
    @Override public String getCPF() { return cpf; }
    public void setCPF(String cpf) { 
        if(cpf == null || cpf.length() != 11) throw new IllegalArgumentException("CPF inválido");
        this.cpf = cpf; 
    }
}