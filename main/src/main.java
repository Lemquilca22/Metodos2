import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class main {
    public static String crearpersonaje() {
        Scanner sc = new Scanner(System.in);
        String nom="";
        nom = sc.nextLine();
        return nom;
    }
    public static String modificar(){
        Scanner sc = new Scanner(System.in);
        boolean trycat = true;
        String respuesta = "";
        while (trycat){
            try {
                respuesta = sc.next();
                if (!(respuesta.equalsIgnoreCase("si")||respuesta.equalsIgnoreCase("no"))){
                    throw new Exception("Error, ingresa si o no");
                }
                trycat=false;
            } catch (Exception e){
                System.out.println(e);
            }
        }
        return respuesta;
    }
    public static String enemigo(){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String nombre;
        String [] enemigos = {"Sagat","Akuma","M. Bison"};
        int numAleatorio = random.nextInt(3);//Numero
        nombre=enemigos[numAleatorio];
        return nombre;
    }
    public static int comprobarInt(){
        Scanner sc = new Scanner(System.in);
        int accion=0;
        boolean comprobar=true;
        while (comprobar) {
            try {
                accion = sc.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Error, los datos no son numericos, vuelve a intentarlo");
                sc.next();
            } catch (Exception e) {
                System.out.println(e);
            }
            comprobar=false;
        }
        return accion;
    }
    public static String ataquealeatorio(){
        Random random = new Random();
        String[] arrayataque = {"normal", "normal", "critico", "esquiva"};
        int ataqueAleatorio = random.nextInt(4);
        String attack = arrayataque[ataqueAleatorio];
        return attack;
    }
    static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        String nom;
        String respuesta;
        String nomenemigo;
        boolean juego = true;
        while (juego) {
            //STATS JUGADOR
            int vida = 100;
            int dañoBase = 15;
            //STATS ENEMIGO
            int vida2 = 100;
            int dañoBase2 = 15;

            System.out.println("Bienvenido a Street Fighers ");
            boolean crearPersonaje = true;
            while (crearPersonaje) {
                System.out.println("Ingresa el nombre de tu personaje");
                nom = crearpersonaje();
                System.out.println("Entonces eres " + nom + ", (si/no)?");
                respuesta = modificar();
                if (respuesta.equalsIgnoreCase("no")) {
                    crearPersonaje = true;
                } else if (respuesta.equalsIgnoreCase("si")) {
                    break;
                }
            }
            boolean escena = true;
            while (escena) {
                boolean combate = true;
                int accion;
                nomenemigo = enemigo();
                System.out.println("Mientras hacias tu recorrido por las calles de Japón te encontraste con " + nomenemigo + " quien te desafió a una pelea a muerte");
                System.out.println("A pelear!!");
                while (combate) {
                    String attack;
                    String attack2;
                    String attack3;
                    System.out.println("MENU");
                    System.out.println("1) Ataque 2) Defender 3)Estadisticas");
                    accion=comprobarInt();

                    switch (accion) {
                        case 1:
                            attack= ataquealeatorio();
                            attack2= ataquealeatorio();
                            if (attack.equalsIgnoreCase("normal")) {
                                System.out.println("Hiciste un ataque normal");
                                vida2 -=dañoBase;
                            } else if (attack.equalsIgnoreCase("critico")) {
                                System.out.println("Diste un golpe critico");
                                vida2 -= dañoBase2 * 2;
                            } else if (attack.equalsIgnoreCase("esquiva")) {
                                vida2 -= 0;
                                System.out.println("Tu rival esquivó tu ataque");
                            }

                            if (vida2 <= 0) {
                                System.out.println("YOU WIN");
                                escena=false;
                                combate = false;
                            }

                            if (attack2.equalsIgnoreCase("normal")) {
                                System.out.println("Recibiste un ataque normal");
                                vida -= dañoBase2;
                            } else if (attack2.equalsIgnoreCase("critico")) {
                                System.out.println("Te dieron un golpe critico");
                                vida -= dañoBase2 * 3;
                            } else if (attack2.equalsIgnoreCase("esquiva")) {
                                vida -= 0;
                                System.out.println("Esquivaste el golpe de tu rival");
                            }

                            if (vida<=0){
                                System.out.println("GAME OVER");
                                escena=false;
                                combate = false;
                            }
                            break;
                        case 2:

                            attack3 = ataquealeatorio();
                            if (attack3.equalsIgnoreCase("normal")) {
                                System.out.println("Bloqueaste un ataque normal");
                                vida -= dañoBase2/5;
                            } else if (attack3.equalsIgnoreCase("critico")) {
                                System.out.println("Te dieron un golpe critico, pero bloqueaste bien");
                                vida -= (dañoBase2*3)/5;
                            } else if (attack3.equalsIgnoreCase("esquiva")) {
                                vida -= 0;
                                System.out.println("Te cubriste, pero igual tu enemigo falló");
                            }
                            break;
                        case 3:
                            System.out.println("HP ACTUAL"+vida+"\nHP ENEMIGO"+vida2);
                            break;
                    }
                }
            }


        }


    }
}
