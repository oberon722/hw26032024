# hw26032024
# Вопрос: Прокомментируй участки кода, которые рефакторим, какой принцип применяем и почему?

В коде несколько участков, которые можно улучшить. Рассмотрим их и прокомментируем:
# 1. Метод removeProduct в классе Warehouse:
```javascript
public void removeProduct(T product, int quantity) {
    int currentQuantity = inventory.getOrDefault(product, 0);
    if (currentQuantity >= quantity) {
        inventory.put(product, currentQuantity - quantity);
    } else {
        throw new IllegalArgumentException("Insufficient quantity of " + product + " to remove.");
    }
}
```
В этом методе у нас есть проверка наличия товара на складе перед его удалением.
Однако, вместо того, чтобы выбрасывать исключение, мы могли бы просто не выполнять
удаление, если товара недостаточно. Это более гибкий подход, поскольку позволяет
вызывающему коду принять решение о дальнейших действиях в зависимости от результата
операции удаления.

# 2. Метод displayInventory в классе Warehouse:
```javascript
public void displayInventory() {
    System.out.println("Inventory:");
    for (Map.Entry<T, Integer> entry : inventory.entrySet()) {
        System.out.println(entry.getKey() + " - Quantity: " + entry.getValue());
    }
}
```
Этот метод непосредственно выводит информацию о товарах на складе в консоль.
Однако было бы лучше передавать эту информацию вызывающему коду, чем непосредственно
выводить ее в консоль. Это сделает класс Warehouse более гибким и переиспользуемым,
так как информацию можно будет использовать в различных контекстах.

# 3. Поле inventory в классе Warehouse:
```javascript
private Map<T, Integer> inventory;
```
Хотя это поле не изменяется после его инициализации в конструкторе, было бы хорошо
объявить его как final. Это сделает код более чистым и понятным, а также поможет
предотвратить случайные изменения поля после его инициализации.

# Принципы, которые мы применяем:
·	Принцип единственной ответственности (Single Responsibility Principle - SRP):
Методы класса должны решать только одну задачу. Разделение метода removeProduct на два
отдельных метода: один для проверки наличия товара, а другой для его удаления,
соблюдает этот принцип, делая код более модульным и легко поддерживаемым.
·	Принцип открытости/закрытости (Open/Closed Principle - OCP): Класс должен быть
открыт для расширения, но закрыт для модификации.
Рефакторинг метода displayInventory так, чтобы он передавал информацию о товарах
вызывающему коду, а не выводил ее непосредственно в консоль, соблюдает этот принцип,
так как делает класс более гибким и переиспользуемым.
