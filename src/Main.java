import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class LucasNumber {
    private int index;
    private int value;

    // Конструктор
    public LucasNumber(int index, int value) {
        this.index = index;
        this.value = value;
    }

    // Методи доступу
    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }

    // Метод для перевірки, чи можна подати число як w^2 + 1
    public boolean formulaCheck() {
        int w = (int) Math.sqrt(this.value - 1);
        return w * w + 1 == this.value;
    }

    public String toString() {
        return "Число Люка " + index + ": " + value;
    }
}

public class Main {
    public static List<LucasNumber> generateLucasNumbers(int n) {
        List<LucasNumber> lucasNumbers = new ArrayList<>();
        int num1 = 2;
        int num2 = 1;

        lucasNumbers.add(new LucasNumber(0, num1));
        if (n > 1) {
            lucasNumbers.add(new LucasNumber(1, num2));
        }

        // Генерація чисел Люка
        for (int i = 2; i < n; i++) {
            int current = num1 + num2;
            lucasNumbers.add(new LucasNumber(i, current));
            num1 = num2;
            num2 = current;
        }

        return lucasNumbers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість чисел Люка: ");
        int n = scanner.nextInt();

        List<LucasNumber> lucasNumbers = generateLucasNumbers(n);
        System.out.println("Перші " + n + " чисел Люка:");
        for (LucasNumber ln : lucasNumbers) {
            System.out.println(ln);
        }

        // Перевірка
        System.out.println("\nЧисла Люка, які можна подати у вигляді w^2 + 1:");
        for (LucasNumber ln : lucasNumbers) {
            if (ln.formulaCheck()) {
                System.out.println(ln + " можна подати як w^2 + 1.");
            }
        }
    }
}