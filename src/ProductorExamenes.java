import java.time.LocalDateTime;

public class ProductorExamenes implements Runnable{

    private BufferExamenes buffer;

    //Contador estático que asegura que cada exámen tenga un número único
    private static int numeroExamen = 0;

    //Cada productor crea y administra un hilo que ejecuta la lógica de producción del examen.
    private Thread hilo;

    //Recibe el buffer donde se depositarán los exámenes.
    public ProductorExamenes(BufferExamenes buffer) {
    this.buffer = buffer;
    numeroExamen++; //Incrementa en uno los exámenes
    this.hilo = new Thread(this,"E" + numeroExamen); //Asigna un número único al examen.
    hilo.start(); //Lo ejecuta con el run
    }

    @Override
    //Esto lo que hace es crear un nuevo examen en la fecha de ahora.
    public void run() {
        int year = LocalDateTime.now().getYear();
        String codigo = this.hilo.getName() + "-" + year;
        buffer.fabricarNuevoExamen(codigo); //Llama al método fabricarNuevoExamen del buffer pasandole el código.
        System.out.println("Producido examen " + codigo);
    }
}
