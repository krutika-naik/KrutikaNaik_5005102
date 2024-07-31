import java.util.List;

public class QuickSort {
    public static void quickSortOrders(List<Order> orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSortOrders(orders, low, pi - 1);
            quickSortOrders(orders, pi + 1, high);
        }
    }

    private static int partition(List<Order> orders, int low, int high) {
        Order pivot = orders.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders.get(j).getTotalPrice() <= pivot.getTotalPrice()) {
                i++;
                Order temp = orders.get(i);
                orders.set(i, orders.get(j));
                orders.set(j, temp);
            }
        }
        Order temp = orders.get(i + 1);
        orders.set(i + 1, orders.get(high));
        orders.set(high, temp);
        return i + 1;
    }
}
