public class Principal {

    public static void main(String[] args) throws InterruptedException {

        //Aquí se crea una instancia de la clase BufferExamenes,
        // que actúa como  buffer entre los productos y examinados
        BufferExamenes generador = new BufferExamenes();

        //Se instancia un objeto de la clase ProductorExamenes y se le pasa como parámetro el buffer.
        new ProductorExamenes(generador);

        //Se crea un objeto de la clase Examinado, que representa a una persona que consume los exámenes.
        new Examinado("Rosa", generador);

        new ProductorExamenes(generador);

        new Examinado("Miguel", generador);

        new ProductorExamenes(generador);

        new Examinado("Carlos", generador);

    }

}
