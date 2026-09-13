package Assignment_3;
class ElectricityBill{
    String customerName;
    double unitsCounsumed, billAmount ;

    ElectricityBill(String name , double units){
            
        customerName = name ;
        unitsCounsumed = units ;


    }
    void calculateBillAmount(){
        if(unitsCounsumed <= 100)
                billAmount = unitsCounsumed*5;
        else if (unitsCounsumed <= 300)
            billAmount = 100*5+(unitsCounsumed-100)*7;
        else 
            billAmount = 100 * 5 + 200*7 + (unitsCounsumed - 300 )*10;



            }

    
        

}
public class Q4 {
    public static void main(String[] args) {
        ElectricityBill b = new ElectricityBill("Rahul", 350);
        b.calculateBillAmount();

        System.out.println("Coutomer: "+b.customerName);
        System.out.println("Units "+ b.unitsCounsumed);;
        System.out.println("Bills "+ b.billAmount);
    }
    
}
