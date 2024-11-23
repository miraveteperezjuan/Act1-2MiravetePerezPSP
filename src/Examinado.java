import java.util.Random;

public class Examinado implements Runnable {

    private BufferExamenes buffer;
    private Thread hilo;

    //Crea un hilo, asociándolo con la instancia actual (this) que implementa Runnable.
    public Examinado(String alumno, BufferExamenes generador){
        this.hilo = new Thread(this,alumno);
        //Le da al hilo el nombre del alumno (alumno), que se usa como identificador en los mensajes de salida.
        this.buffer = generador;
        hilo.start(); //Inicia el hilo, lo que activa el método run().
    }

    public synchronized void run(){
        //El consumidor llama al método consumirExamen del buffer para obtener el código de un examen.
        String codigoExamen = this.buffer.consumirExamen();

        //Si es distinto a nullo genera un examen random con las respuestas del array.
        if(codigoExamen != null){
            Random random = new Random();
            String[] resupuestas = {"A", "B", "C", "D", "-"};

            //10 respuestas de examen
            for (int i = 1; i <= 10; i++) {
                //El random genera un numero aleatorio entre la longitud y el numero de respuesta.
                String respuesta = resupuestas[random.nextInt(resupuestas.length)];
                    System.out.println(codigoExamen + "," + this.hilo.getName() + "; Pregunta" + i + ";" + respuesta);
            }// Al finalizar el ciclo, imprime todo el resultado en un solo mensaje


        }else{
            System.out.println("No hay más exámenes"); //Si no hay más examenes nos lo señala
        }



    }

}
