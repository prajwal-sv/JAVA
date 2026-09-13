package Assignment_3;
class Counter {
    int count ;
    static int totalObject  ;

    Counter(int count){
        this.count = count;
        totalObject++;

    }
    void display(){
        System.out.println("total object count : "+totalObject+"count is "+count);
    }
}
public class Q4 {

    public static void main(String[] args) {
        Counter c1 = new Counter(1);
        Counter c2 = new Counter(2);
        Counter c3 = new Counter(3);

        c1.display();
        c2.display();
        c3.display();
    }
    
}
