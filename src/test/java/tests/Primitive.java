package tests;

public class Primitive {

        public static void main(String[] args) {

            System.out.println("Арифметические операции над int");
            int a = 15;
            int b = 5;
            System.out.println("a = " + a + ", b = " + b);
            System.out.println("a + b = " + (a + b));
            System.out.println("a - b = " + (a - b));
            System.out.println("a * b = " + (a * b));
            System.out.println("a / b = " + (a / b));
            System.out.println("a % b = " + (a % b));

            System.out.println("Арифметические операции над int и double ");
            int c = 10;
            double d = 3.5;
            System.out.println("c = " + c + ", d = " + d);
            System.out.println("c + d = " + (c + d));
            System.out.println("c - d = " + (c - d));
            System.out.println("c * d = " + (c * d));
            System.out.println("c / d = " + (c / d));

            System.out.println(" Логические операции ");
            int x = 20;
            int y = 25;
            System.out.println("x = " + x + ", y = " + y);
            System.out.println("x < y: " + (x < y));
            System.out.println("x > y: " + (x > y));
            System.out.println("x <= y: " + (x <= y));
            System.out.println("x >= y: " + (x >= y));
            System.out.println("x == y: " + (x == y));
            System.out.println("x != y: " + (x != y));

            System.out.println(" Диапазоны типов данных ");
            System.out.println("Тип float:");
            System.out.println("Минимальное значение: " + Float.MIN_VALUE);
            System.out.println("Максимальное значение: " + Float.MAX_VALUE);
            System.out.println("Тип double:");
            System.out.println("Минимальное значение: " + Double.MIN_VALUE);
            System.out.println("Максимальное значение: " + Double.MAX_VALUE);
            System.out.println();

            System.out.println("Переполнение ");

            int maxInt = Integer.MAX_VALUE;
            System.out.println("Максимальное значение int: " + maxInt);

            System.out.println("maxInt + 1 = " + (maxInt + 1)); // Происходит переполнение
        }
}
