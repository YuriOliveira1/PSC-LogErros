public class Price {

    private int[] exoticsPrice = {10, 44, 666}; 
    private int finalPrice = 0;

    public int buy(int option){
        if (option == 1) {
            finalPrice += exoticsPrice[0];
        } else if (option == 2) {
            finalPrice += exoticsPrice[1];
        } else if (option == 3) {
            finalPrice += exoticsPrice[2];
        }
        return finalPrice;
    }

    public int returnPrice(){
        return finalPrice;
    }
}
