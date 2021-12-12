package LogicModule;

public class AdvertFilter {
    private int minRoomsNumber;
    private int maxRoomsNumber;
    private int minArea;
    private int maxArea;
    private int minKitchenArea;
    private int maxKitchenArea;
    private int minPrice;
    private int maxPrice;



    public AdvertFilter(int minRoomsNumber, int maxRoomsNumber, int minArea, int maxArea,
                        int minKitchenArea, int maxKitchenArea, int minPrice, int maxPrice) {
        this.minRoomsNumber = minRoomsNumber;
        this.maxRoomsNumber = maxRoomsNumber;
        this.minArea = minArea;
        this.maxArea = maxArea;
        this.minKitchenArea = minKitchenArea;
        this.maxKitchenArea = maxKitchenArea;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;

    }

    public boolean filter(Apartment apart){
        return checkIfOk(apart.getRoomsNumber(), minRoomsNumber, maxRoomsNumber) &&
                checkIfOk(apart.getArea(), minArea, maxArea) &&
                checkIfOk(apart.getKitchenArea(), minKitchenArea, maxKitchenArea) &&
                checkIfOk(apart.getPrice(), minPrice, maxPrice);
    }

    public static boolean checkIfOk(int givenValue, int minValue, int maxValue){
        if (maxValue == -1){
            if (givenValue >= minValue){
                return true;
            }
        }
        return givenValue >= minValue && givenValue <= maxValue;
    }
}
