import java.util.HashMap;
import java.util.Map;

public class Warehouse<T> {
    private final Map<T, Integer> inventory; // делаем поле inventory final

    public Warehouse() {
        this.inventory = new HashMap<>();
    }

    public void addProduct(T product, int quantity) {
        inventory.put(product, inventory.getOrDefault(product, 0) + quantity);
    }

    public void removeProduct(T product, int quantity) {
        int currentQuantity = inventory.getOrDefault(product, 0);
        if (currentQuantity >= quantity) {
            inventory.put(product, currentQuantity - quantity);
        } else {
            throw new IllegalArgumentException("Insufficient quantity of " + product + " to remove.");
        }
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (Map.Entry<T, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " - Quantity: " + entry.getValue());
        }
    }
}