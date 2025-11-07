
/**<h4>Tarefa EBAC – Listas</h4>
 *
 * 
 *
 * @author Fabio Peretti Guimarães
 * @since novembro 2025
 */
public class Main {

 static int cooldown = 1;

 static{
  exercClass cadastro1 = new exercClass("João", 'M');
  exercClass cadastro2 = new exercClass("Fernanda", 'F');
  exercClass cadastro3 = new exercClass("Rafael", 'M');
  exercClass cadastro7 = new exercClass("Anna", 'F');
  exercClass cadastro5 = new exercClass("Pedro", 'M');
  exercClass cadastro6 = new exercClass("Carlos", 'M');
 }

 public static void main(String[] args) throws InterruptedException {

  System.out.println("\n----- Exercício Ebac – Módulo11 | Parte 01 -----");
  Thread.sleep(cooldown * 1000);

  listaParte01();

  System.out.println("\n----- Exercício Ebac – Módulo11 | Parte 02 -----");

  listaParte02();

 }


 public static void listaParte01() throws InterruptedException{
  System.out.println("\n#### IMPRESSÃO DE NOMES DA LISTA ####");
  System.out.println(exercParte01.getListaParte01());
  Thread.sleep(1000);
  System.out.println("\n--------------------------------\n");
  System.out.println("#### IMPRESSÃO DE NOMES DA LISTA ORDENADOS####");
  exercParte01.OrdemObjetos01();
  Thread.sleep(cooldown * 1000);
 }

 public static void listaParte02() throws InterruptedException{
  System.out.println("\n#### IMPRESSÃO DE LISTA COMPLETA ####");
  System.out.println(exercParte02.getListaParte02());
  Thread.sleep(cooldown * 1000);
  System.out.println("\n--------------------------------\n");
  System.out.println("#### IMPRESSÃO DE LISTA ORDENADA####");
  exercParte02.OrdemObjetos02();
  Thread.sleep(cooldown * 1000);
 }

}
