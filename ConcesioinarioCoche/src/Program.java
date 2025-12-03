import Controlador.ControladorConcesionario;
import Vista.VistaSimple;

public class Program {

    static void main(String[] args) {
        VistaSimple vista = new VistaSimple();
        ControladorConcesionario controlador = new ControladorConcesionario(vista);
        controlador.run();


    }
}
