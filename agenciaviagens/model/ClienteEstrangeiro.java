package model;

public class ClienteEstrangeiro extends Cliente {
    private String passaporte;
    
    public ClienteEstrangeiro(String nome, String telefone, String email, String passaporte) {
        setNome(nome);
        setTelefone(telefone);
        setEmail(email);
        setTipo("estrangeiro");
        setPassaporte(passaporte);
    }
    
    @Override public String getPassaporte() { return passaporte; }
    public void setPassaporte(String passaporte) {
        if(passaporte == null || passaporte.isEmpty()) throw new IllegalArgumentException("Passaporte inválido");
        this.passaporte = passaporte;
    }
}