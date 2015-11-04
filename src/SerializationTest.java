import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.*;

public class SerializationTest {
    public static void main(String[] args) {
//        Collar c = new Collar(4);
//        Dog d = new Dog(c, "Sheru", 32);
//        FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//        try {
//            fos = new FileOutputStream(
//                    "/Users/siddharth.rk/project/flujo/DogState.txt");
//            oos = new ObjectOutputStream(fos);
//            oos.writeObject(d);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                oos.close();
//                fos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        // ***************************************************************************************************
//        // //
        Dog restore = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(
                    "/Users/siddharth.rk/project/flujo/DogState.txt");
            ois = new ObjectInputStream(fis);
            restore = (Dog) ois.readObject();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("after: dog name: "+ restore.name +" , collar=" + restore.getCollar());
        System.out.println("Animal material is:" + restore.getWeight());
    }
}

// Intentionally added parameterized constructor so that default constructor is not called.
class Animal{
    int weight = 42;
    public Animal() {}
    public Animal(int weight) {
        this.weight = weight;
        System.out.println("animal constructor");
    }
}


class Dog extends Animal implements Serializable {
    String name;
    transient Collar collar;
    String newText;

    public Dog() {}

    public Collar getCollar() {
        return collar;
    }

    public void setCollar(Collar collar) {
        this.collar = collar;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Dog(Collar collar, String name, int weight) {
        super(weight);
        System.out.println("Dog constructor");
        this.collar = collar;
        this.name = name;
    }

}
class Collar {
    int size;

    public Collar(int size) {
        System.out.println("Collar constructor");
        this.size = size;
    }
}