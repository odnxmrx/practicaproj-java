//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    /* Al agregar la palabra 'static', indicamos que el método main es un método de clase
    y no de instancia, lo que permite que la máquina virtual de Java pueda ejecutar el
    programa sin necesidad de crear una instancia de la clase.
     */
    public static void main(String[] args) {
        System.out.print("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }
}