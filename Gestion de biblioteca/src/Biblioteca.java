import java.util.*;

public class Biblioteca {
    private Map<String, Libro> libros; // Identificador del libro -> Libro
    Map<String, Usuario> usuarios; // Identificador del usuario -> Usuario
    private List<Prestamo> prestamos; // Lista de préstamos

    public Biblioteca() {
        this.libros = new HashMap<>();
        this.usuarios = new HashMap<>();
        this.prestamos = new LinkedList<>();
    }

    // Gestión de libros
    public void agregarLibro(Libro libro) {
        libros.put(libro.getTitulo(), libro);
    }

    public void eliminarLibro(String titulo) {
        libros.remove(titulo);
    }

    public Libro buscarLibro(String titulo) {
        return libros.get(titulo);
    }

    public Collection<Libro> listarLibros() {
        return libros.values();
    }

    // Gestión de usuarios
    public void registrarUsuario(Usuario usuario) {
        usuarios.put(usuario.getNumeroIdentificacion(), usuario);
    }

    public void actualizarUsuario(Usuario usuario) {
        usuarios.put(usuario.getNumeroIdentificacion(), usuario);
    }

    public Usuario buscarUsuario(String numeroIdentificacion) {
        return usuarios.get(numeroIdentificacion);
    }

    // Gestión de préstamos
    public void realizarPrestamo(Libro libro, Usuario usuario, Date fechaPrestamo, Date fechaDevolucion) {
        if (libros.containsKey(libro.getTitulo()) && usuarios.containsKey(usuario.getNumeroIdentificacion())) {
            prestamos.add(new Prestamo(libro, usuario, fechaPrestamo, fechaDevolucion));
        } else {
            System.out.println("Libro o usuario no encontrado.");
        }
    }

    public void devolverLibro(String titulo, String numeroIdentificacion) {
        prestamos.removeIf(prestamo -> prestamo.getLibro().getTitulo().equals(titulo) &&
                prestamo.getUsuario().getNumeroIdentificacion().equals(numeroIdentificacion));
    }

    public List<Prestamo> consultarPrestamosActivos() {
        return prestamos;
    }

    public void generarInformePrestamos() {
        for (Prestamo prestamo : prestamos) {
            System.out.println(prestamo);
        }
    }
}

