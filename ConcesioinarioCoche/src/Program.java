import Controlador.ControladorConcesionario;
import Vista.VistaConcesionario;

public class Program {

    public static void main(String[] args) {
        VistaConcesionario vista = new VistaConcesionario();
        ControladorConcesionario controlador = new ControladorConcesionario(vista);
        controlador.cargarDatosIniciales();
        controlador.run();
    }
}
