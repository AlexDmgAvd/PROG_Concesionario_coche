import Controlador.ControladorConcesionario;
import Controlador.IControlador;
import Vista.IVista;
import Vista.VistaSimple;

public class Program {

    public static void main(String[] args) {
        VistaSimple vista = new VistaSimple();
        ControladorConcesionario controlador = new ControladorConcesionario(vista);
        controlador.run();
    }
}
