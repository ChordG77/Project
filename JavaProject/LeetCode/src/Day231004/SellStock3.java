package Day231004;

public class SellStock3 {

    private static final int[] price = {1,2,4,2,5,7,2,4,9,0};

    public static void main(String[] args) {
        System.out.println(maxProfit(price));
    }

    public static int maxProfit(int[] prices) {
        int buy1 = -prices[0];
        int buy2 = -prices[0];
        int sell1 = 0;
        int sell2 = 0;
        for(int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }

        return sell2;
    }
}
