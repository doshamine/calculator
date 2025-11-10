public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1,1);
        // ошибка: деление на ноль (b = 0)
        // Возможные решения:
        // 1. Проверить значение делителя
        //    до выполнения операции и
        //    вывести сообщение в случае b = 0
        if (b != 0) {
            int c = calc.divide.apply(a, b);
            calc.println.accept(c);
        } else {
            System.err.println("Был передан нулевой делитель");
        }
        // 2. Обработать исключение с помощью
        //    конструкции try/except
        try {
            int c = calc.divide.apply(a, b);
            calc.println.accept(c);
        } catch (ArithmeticException e) {
            System.err.println("Ошибка при делении: " + e.getMessage());
        }
    }
}