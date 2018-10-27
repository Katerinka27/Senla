package by.balitskaya.hotel.model;

public class Service {
    private Integer numberService;
    private Double price;//price услуги уникален
    private String information;

    public Service(){
    }

    public Service(double price,String information){
        this.price=price;
        this.information=information;
    }
    public Service(Integer numberService,double price,String information){
        this.price=price;
        this.information=information;
        this.numberService=numberService;
    }
    public Service(Integer numberService){
        this.numberService=numberService;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }






    public Integer getNumberService() {
        return numberService;
    }

    public void setNumberService(Integer numberService) {
        this.numberService = numberService;
    }
    @Override
    public String toString() {
        return "numberService:"+numberService+";price:"+price+";information:"+information;
    }
}
