package LogicModule;

import java.util.Dictionary;

public class AdvertFilter {
    private int minRoomsNumber = -1;
    private int maxRoomsNumber = -1;
    private int minArea = -1;
    private int maxArea = -1;
    private int minKitchenArea = -1;
    private int maxKitchenArea = -1;
    private int minPrice = -1;
    private int maxPrice = -1;


    public AdvertFilter(){}

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

    public void setFilterArgsFromCmd(Dictionary<String, String> argsDict){
        if (argsDict.get("-r") != null){
            this.minRoomsNumber = Integer.parseInt(argsDict.get("-r"));
        }
        if (argsDict.get("-R") != null){
            this.maxRoomsNumber = Integer.parseInt(argsDict.get("-R"));
        }
        if (argsDict.get("-a") != null){
            this.minArea = Integer.parseInt(argsDict.get("-a"));
        }
        if (argsDict.get("-A") != null){
            this.maxArea = Integer.parseInt(argsDict.get("-A"));
        }
        if (argsDict.get("-k") != null){
            this.minKitchenArea = Integer.parseInt(argsDict.get("-k"));
        }
        if (argsDict.get("-K") != null){
            this.maxKitchenArea = Integer.parseInt(argsDict.get("-K"));
        }
        if (argsDict.get("-p") != null){
            this.minPrice = Integer.parseInt(argsDict.get("-p"));
        }
        if (argsDict.get("-P") != null){
            this.maxPrice = Integer.parseInt(argsDict.get("-P"));
        }

    }

    public void setMinRoomsNumber(int minRoomsNumber){
        this.minRoomsNumber = minRoomsNumber;
    }
    public int getMinRoomsNumber(){
        return minRoomsNumber;
    }
    public void setMaxRoomsNumber(int maxRoomsNumber){
        this.maxRoomsNumber = maxRoomsNumber;
    }
    public int getMaxRoomsNumber(){
        return maxRoomsNumber;
    }
    public void setMinArea(int minArea){
        this.minArea = minArea;
    }
    public int getMinArea(){
        return minArea;
    }
    public void setMaxArea(int maxArea){
        this.maxArea = maxArea;
    }
    public int getMaxArea(){
        return maxArea;
    }
    public void setMinKitchenArea(int minKitchenArea){
        this.minKitchenArea = minKitchenArea;
    }
    public int getMinKitchenArea(){
        return minKitchenArea;
    }
    public void setMaxKitchenArea(int maxKitchenArea){
        this.maxKitchenArea = maxKitchenArea;
    }
    public int getMaxKitchenArea(){
        return maxKitchenArea;
    }
    public void setMinPrice(int minPrice){
        this.minPrice = minPrice;
    }
    public int getMinPrice(){
        return minPrice;
    }
    public void setMaxPrice(int maxPrice){
        this.maxPrice = maxPrice;
    }
    public int getMaxPrice(){
        return maxPrice;
    }
}
