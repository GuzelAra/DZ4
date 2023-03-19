import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    // Реализовать консольное приложение, которое: Принимает от пользователя строку вида text~num
    // 1. Нужно рассплитить строку по ~, сохранить text в связный список на позицию
    // num.
    // 2. Если введено print~num, выводит строку из позиции num в связном списке.
    // 3. Если введено exit, завершаем программу

    // Пример:
    // string~4
    // num~3
    // print~3
    // > num
    // print~4
    // > string
    // my_value~1
    // print~1
    // > my_value

    public static void main(String[] args) {
        System.out.println("Введите строку вида text-num: ");
        System.out.println("Для выхода введите: exit");
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String txt = sc.nextLine();
            try {
                if (txt.equals("exit")) {
                    break;
                }
                Integer.parseInt(txt.split("-")[1]);
                function(txt, list);
            } catch (Exception e) {
                System.out.println("Ошибка, проверьте вводимые данные!");
            }
        }
    }

    static void function(String text, ArrayList<String> list) {
        String[] newtxt = text.split("-");
        int num = Integer.parseInt(newtxt[1]);
        int localSize = num - list.size();
        while(list.size() <= localSize) {
            list.add(null);
        }
        if (newtxt[0].equals("print")) {
            System.out.println(list.get(num));
        } else {
            list.set(num, newtxt[0]);
        }
    }
}