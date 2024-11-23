import java.util.LinkedList;
import java.util.Queue;

public class BufferExamenes {

        private Queue<String> colaExamenes;

        public BufferExamenes() {
            colaExamenes = new LinkedList<String>();
            //El primero que entra es el primero en salir.
        }

        //Metodo sincronizado para producir un nuevo examen
    public synchronized void fabricarNuevoExamen(String codigo) {
        colaExamenes.add(codigo);
        notify(); //Notificar a los hilos en espera
    }

    public synchronized String consumirExamen() {
        while (colaExamenes.isEmpty()) {
            //Si está vacía, el hilo entra en espera hasta que se fabrique un nuevo examen.
            try {
                wait(); //Esperar hasta que se fabrique un nuevo examen
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                //Restablece el estado de interrupción del hilo actual, de forma que el hilo pueda manejar la interrupción correctamente si es necesario.
            }
        }
        return colaExamenes.poll(); //Poll devuelve a null si está vacia. si se pusiera remove lanzaría una excepción
    }
}
