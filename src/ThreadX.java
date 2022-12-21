public class ThreadX extends java.lang.Thread {
    static int contador = 0;
    String cadena;



    public ThreadX(String cadena) {
        super();
        this.cadena = cadena;
    }

    public void run(){

        for (int i=0; i<10; i++){
            contador++;
            System.out.println(contador +" "+ cadena);

        }

    }


    public static void main(String[] args) throws InterruptedException {

        ThreadGroup grupo = new ThreadGroup("Group");


        ThreadX h1 = new ThreadX( "Si");
        ThreadX h2 = new ThreadX("No");

        Thread hil1 = new Thread(grupo, h1, "hil1");
        Thread hil2 = new Thread(grupo, h2,"hil2");

        h1.start();
        h1.join(); //así el join no vale porque aunque el output es más ordenado, no se trata de programacion concurrente.
        h2.start();
        h2.join();

    }

}
