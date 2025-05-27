package Biblioteca;

public class Usuario {
    private long id;
    private String nombreUsuario;
    private String email;

    public Usuario(long id, String nombreUsuario, String email) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
    }

    public long getId() { return id; }
    public String getNombreUsuario() { return nombreUsuario; }
    public String getEmail() { return email; }

    public void setId(long id) { this.id = id; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
