import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Crear libros
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", "Editorial XYZ", 1967, 417);
        Libro libro2 = new Libro("1984", "George Orwell", "Editorial ABC", 1949, 328);

        // Agregar libros a la biblioteca
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        // Crear usuarios
        Usuario usuario1 = new Usuario("Juan", "Pérez", "juan.perez@example.com", "12345");
        Usuario usuario2 = new Usuario("Ana", "Gómez", "ana.gomez@example.com", "67890");

        // Registrar usuarios en la biblioteca
        biblioteca.registrarUsuario(usuario1);
        biblioteca.registrarUsuario(usuario2);

        // Realizar préstamos
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaPrestamo = sdf.parse("2024-07-30");
            Date fechaDevolucion = sdf.parse("2024-08-30");

            biblioteca.realizarPrestamo(libro1, usuario1, fechaPrestamo, fechaDevolucion);
            biblioteca.realizarPrestamo(libro2, usuario2, fechaPrestamo, fechaDevolucion);

            // Consultar y generar informes
            System.out.println("Libros en la biblioteca:");
            for (Libro libro : biblioteca.listarLibros()) {
                System.out.println(libro);
            }

            System.out.println("\nUsuarios registrados:");
            for (Usuario usuario : biblioteca.usuarios.values()) {
                System.out.println(usuario);
            }

            System.out.println("\nPréstamos activos:");
            biblioteca.generarInformePrestamos();

            // Devolver libro
            biblioteca.devolverLibro(libro1.getTitulo(), usuario1.getNumeroIdentificacion());

            System.out.println("\nPréstamos después de devolver el libro:");
            biblioteca.generarInformePrestamos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
