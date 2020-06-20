class Person<T>{  //泛型与类
    private T age;
    public void setAge(T age){
        this.age = age;
    }
    public T getAge(){
        return this.age;
    }
}
class Student<T> extends Person<T>{  //泛型与继承
 
}
class Teacher extends Person<String>{ //泛型与继承

}

interface Human<T>{  //泛型与接口
    public void setAge(T age);
    public T getAge();
}

class Worker<T extends Number> implements Human<T>{//泛型与接口+泛型上限
    private T age;
    public void setAge(T age){
        this.age = age;
    }
    public T getAge(){
        return this.age;
    }
}
class Singer implements Human<String>{//泛型与接口
    private String age;
    public void setAge(String age){
        this.age = age;
    }
    public String getAge(){
        return this.age;
    }
}


public class Generics{
    public static void main(String[] args){
        System.out.println("泛型基本用法:");
        Person<Integer> p1 = new Person<Integer>(); //泛型与对象
        p1.setAge(3);
        printInfo(p1);

        Person<String> p2 = new Person<String>();  //泛型与对象
        p2.setAge("3 years old");
        printInfo(p2);

        System.out.println("通配符基本用法:");
        Person<?> p3 = p1;  //通配符: 定义与赋值
        printInfo2(p1);
        printInfo2(p2);
        printInfo2(p3);
        
        System.out.println("泛型与继承的用法：");
        Student<Integer> s = new Student<Integer>();
        s.setAge(10);
        printInfo(s);

        Teacher t = new Teacher();
        t.setAge("30 years old");
        printInfo(t);
        printInfo(s);

        System.out.println("泛型与接口与泛型上下限的用法：");
        Worker<Integer> w = new Worker<Integer>();
        w.setAge(10);
        printInfo3(w);
        /*错误的用法：超出了"下限"*/
        //printInfo4(w);
        /*错误的用法：超出了"上限"*/
        //Worker<String> w1 = new Worker<String>();
        //w1.setAge(10);
        //printInfo3(w1);

        Singer x = new Singer();
        x.setAge("30 years old");
        printInfo3(x);
    }
    public static <T> void printInfo(Person<T> p){ //泛型与方法
        System.out.println(p.getAge());
    }
    public static void printInfo2(Person<?> p){ //通配符:作为形参
        System.out.println(p.getAge());
    }
    public static <T> void printInfo3(Human<T> p){ //泛型与方法（接口）
        System.out.println(p.getAge());
    }
    public static void printInfo4(Human<? super String> p){ //通配符:作为形参（接口）+泛型下限
        System.out.println(p.getAge());
    }
    
}
