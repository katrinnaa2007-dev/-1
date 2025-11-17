Типовые задачи на C++

Задача 1: Поиск максимального элемента в массиве

c++
#include <iostream>
using namespace std;

int main() {
    int arr[] = {5, 12, 3, 9, 7};
    int n = sizeof(arr) / sizeof(arr[0]);
    int max_val = arr[0];

    for (int i = 1; i < n; i++) {
        if (arr[i] > max_val) {
            max_val = arr[i];
        }
    }

    cout << "Максимальный элемент: " << max_val << endl;
    return 0;
}
Объяснение: Инициализируем переменную max_val первым элементом массива. Последовательно сравниваем все элементы с текущим максимумом, обновляя его при необходимости.

Задача 2: Реверс массива

c++
#include <iostream>
using namespace std;

int main() {
    int arr[] = {1, 2, 3, 4, 5};
    int n = sizeof(arr) / sizeof(arr[0]);

    for (int i = 0; i < n / 2; i++) {
        swap(arr[i], arr[n - i - 1]);
    }

    cout << "Реверс массива: ";
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    return 0;
}
Объяснение: Используем цикл до середины массива, меняя местами элементы симметрично относительно центра с помощью функции swap().
