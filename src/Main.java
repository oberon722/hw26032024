
public class Main {
    public static void main(String[] args) {
        // Создание объектов поставщиков и товаров
        Supplier supplier1 = new Supplier("Supplier 1");
        Supplier supplier2 = new Supplier("Supplier 2");

        Product product1 = new Product("Product 1", "Category A");
        Product product2 = new Product("Product 2", "Category B");

        // Создание объекта склада и добавление товаров
        Warehouse<Product> warehouse = new Warehouse<>();
        warehouse.addProduct(product1, 10);
        warehouse.addProduct(product2, 5);

        // Вывод информации о наличии товаров на складе
        warehouse.displayInventory();

        // Удаление товаров
        warehouse.removeProduct(product1, 3);
        warehouse.removeProduct(product2, 2);

        // Вывод информации о наличии товаров на складе после удаления
        warehouse.displayInventory();
    }
}