Типовые задачи на Java

Задача 1: Поиск суммы элементов списка

java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);

        int sum = 0;
        for (int num : list) {
            sum += num;
        }

        System.out.println("Сумма элементов: " + sum);
    }
}
Объяснение: Создаем ArrayList, добавляем элементы. С помощью цикла for-each накапливаем сумму элементов в переменной sum.

Задача 2: Удаление дубликатов из списка

java
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("a");
        list.add("c");
        list.add("b");

        LinkedHashSet<String> set = new LinkedHashSet<>(list);
        ArrayList<String> uniqueList = new ArrayList<>(set);

        System.out.println("Список без дубликатов: " + uniqueList);
    }
}
Объяснение: Используем LinkedHashSet для удаления дубликатов с сохранением порядка элементов. Преобразуем набор обратно в ArrayList.
