package co.edu.jdc.sigepaisa.entity;




import jakarta.persistence.*;

    @Entity
    @Table(name = "usuario")
    public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "idusuario")
        private Integer idUsuario;

        @Column(name = "nombre", nullable = false, length = 50)
        private String nombre;

        @Column(name = "apellido", nullable = false, length = 50)
        private String apellido;

        @Column(name = "username", nullable = false, unique = true, length = 50)
        private String username;

        @Column(name = "contrasena", nullable = false, length = 255)
        private String contrasena;

        @Column(name = "telefono", length = 20)
        private String telefono;

        @Column(name = "correo", length = 100)
        private String correo;

        @Column(name = "estadousuario", nullable = false)
        private Boolean estadoUsuario = true;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "idrol", nullable = false)
        private Rol rol;

        public Usuario() {
        }

        public Integer getIdUsuario() {
            return idUsuario;
        }

        public void setIdUsuario(Integer idUsuario) {
            this.idUsuario = idUsuario;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getContrasena() {
            return contrasena;
        }

        public void setContrasena(String contrasena) {
            this.contrasena = contrasena;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public Boolean getEstadoUsuario() {
            return estadoUsuario;
        }

        public void setEstadoUsuario(Boolean estadoUsuario) {
            this.estadoUsuario = estadoUsuario;
        }

        public Rol getRol() {
            return rol;
        }

        public void setRol(Rol rol) {
            this.rol = rol;
        }
    }

