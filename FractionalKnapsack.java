import java.util.*;

class Item {
    int weight, profit;

    Item(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
    }
}

public class FractionalKnapsack {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight and profit of item " + (i + 1) + ": ");
            int w = sc.nextInt();
            int p = sc.nextInt();

            items[i] = new Item(w, p);
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        // Sort items according to profit/weight ratio
        Arrays.sort(items, (a, b) ->
            Double.compare(
                (double) b.profit / b.weight,
                (double) a.profit / a.weight
            )
        );

        double totalProfit = 0;

        for (int i = 0; i < n; i++) {

            if (capacity == 0)
                break;

            if (items[i].weight <= capacity) {

                totalProfit += items[i].profit;
                capacity -= items[i].weight;

            } else {

                totalProfit += (double) items[i].profit
                        * capacity / items[i].weight;

                capacity = 0;
            }
        }

        System.out.println("Maximum Profit = " + totalProfit);

        sc.close();
    }
}