package StudentMangementSystem;

public class Student {
    

    private int id ;
    private String name ;
    private int age ;
    private String course ;
    private  float marks ;
    

    public  Student(int id , String name , int age , String course , float marks ){
        this.name = name ;
        this.age = age ;
        this.course = course;
        this.id = id ;
        this.marks =  marks;
    }
    public String getName(){
        return name ;
    }
    public String getCourse(){
        return course ;
    }
    public int getId(){
        return id ;
    }
    public int getAge(){
        return age ;
    }
    public float getMarks(){
        return marks ;
    }

    public void setName( String  name ){
        this.name = name ;
    }
    public void setCourse( String course){
        this.course = course ;
    }
    public void  setId(int id){
        this.id= id ;
    }
    public void  setAge(int age ){
        this.age = age  ;
    }
    public void  setMarks(float marks){
        this.marks= marks ;
    }

    public void displayStudent() {
        System.out.println("ID     : " + id);
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Course : " + course);
        System.out.println("Marks  : " + marks);
    }

}
