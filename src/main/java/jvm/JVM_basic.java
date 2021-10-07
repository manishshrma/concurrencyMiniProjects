package jvm;
import java.lang.reflect.*;
class Student {
    public String getName() {
        return null;
    }

    public int getRollno() {
        return 10;
    }

}

public class JVM_basic {
    public static void main(String[] args) throws ClassNotFoundException {
//        Class c = Class.forName("Student"); //  that's what internally happening
        //Above line: loaded the student.class file in the method area(JVM)
        //and JVM create a class Class object for the student.class file and store in the heap area

        Student st=new Student();
        Class c1=st.getClass(); // give class Class object.
        // first student.class load this student file in the method area and immediately
        // another object is create(In HEAP) which is  class Class object to repersent student.class
        //suppose now, i create again student object.
              Student st1=new Student();
              Class c2=st1.getClass();
        //It is to note
        //that no new class Class object will be created instead c1 and c2 both point to the same old
        //class Class object.

        System.out.println(c1.hashCode()); // c1 point to the same class Class obj
        System.out.println(c1.hashCode()); // c2 point to the same class Class obj
        System.out.println(c1==c2);// true



    }

}

