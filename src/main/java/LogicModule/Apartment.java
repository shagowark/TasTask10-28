package LogicModule;

public class Apartment {
    private String district;
    private int roomsNumber;
    private int area;
    private int kitchenArea;
    private int price;

    public Apartment(){
    }

    public Apartment(String district, int roomsNumber, int area,
                     int kitchenArea, int price){

        this.district = district;
        this.roomsNumber = roomsNumber;
        this.area = area;
        this.kitchenArea = kitchenArea;
        this.price = price;
    }

    public String getDistrict(){
        return district;
    }
    public int getRoomsNumber(){
        return roomsNumber;
    }
    public int getArea(){
        return area;
    }
    public int getKitchenArea(){
        return kitchenArea;
    }
    public int getPrice(){
        return price;
    }
    public void setDistrict(String district){
        this.district = district;
    }
    public void setRoomsNumber(int roomsNumber){
        this.roomsNumber = roomsNumber;
    }
    public void setArea(int area){
        this.area = area;
    }
    public void setKitchenArea(int kitchenArea){
        this.kitchenArea = kitchenArea;
    }
    public void setPrice(int price){
        this.price = price;
    }
}
