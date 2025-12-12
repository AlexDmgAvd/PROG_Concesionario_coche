import Controlador.ControladorConcesionario;
import Vista.VistaConcesionario;

/**
 * Clase principal que inicia la aplicación del concesionario.
 * Contiene el main que es el punto de entrada del programa.
 *
 * @author Alexandre Domínguez Avendaño
 */
public class Program {

    /**
     * Funcion principal que inicia la aplicación.
     * Crea la vista y el controlador, carga datos iniciales y ejecuta el programa.
     */
    public static void main(String[] args) {
        VistaConcesionario vista = new VistaConcesionario();
        ControladorConcesionario controlador = new ControladorConcesionario(vista);
        controlador.cargarDatosIniciales();
        controlador.run();
    }
}
