package edu.neu.csye7374;

import java.util.*;

/**
 * Demonstrate the use of the Abstract Factory, Builder and Prototype design patterns as follows:
 *
 * get and use Item objects to sell UPPERCASE LETTERS
 *
 * sell all 26 upper case alphabetic letters (A-Z) with the following prices:
 *     A for $ 1.99
 *     B for $ 2.99
 *  . . .
 *     Y for $ 25.99
 *     Z for $ 26.99
 *
 *
 * 1. Develop MyCloneableAbstractFactory from SUPPLIED
 * 2. Load MyCloneableAbstractFactory with 26 MyCloneableItem prototypes which are cloned upon request
 * 6. Demonstrate with console output showing use of 26 Letter Items with ID, Price and Name attributes.
 *
 * author dpeters
 *
 */


public class MyCloneable implements Cloneable{

    protected int id;
    protected char name;
    protected double price;

    //Builder pattern
    public MyCloneable(MyCloneable.Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(char name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static class Builder {

        private int id;
        private char name;
        private double price;


        public MyCloneable.Builder setId(int id) {
            this.id = id;
            return this;
        }

        public MyCloneable.Builder setName(char name) {
            this.name = name;
            return this;
        }

        public MyCloneable.Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public MyCloneable build() {
            return new MyCloneable(this);
        }

    }

    /**
     * API for abstract factory of cloneable objects
     *
     * @author dpeters
     *
     */
    public interface MyCloneableAbstractFactoryAPI {
        /**
         * @param id - ID of prototype
         * @param prototype - one cloneable prototype object
         */
        public void load(int id, MyCloneable prototype);
        /**
         * return clone of requested object
         *
         * @param id - ID of requested object
         * @return cloned object
         */
        public Object getObject(int id) throws CloneNotSupportedException;
    }

    public static class MyCloneableAbstractFactory implements MyCloneableAbstractFactoryAPI{

        private Map<Integer, MyCloneable> prototypes = new HashMap<>();


        @Override
        public void load(int id, MyCloneable prototype) {
            prototypes.put(id, prototype);
        }

        @Override
        public MyCloneable getObject(int id) throws CloneNotSupportedException {
            MyCloneable prototype = prototypes.get(id);
            if (prototype == null) {
                return null;
            }
            return prototype.clone();
        }
    }

    public class MyCloneableAbstractFactorySingleton {
        private static final MyCloneableAbstractFactory instance = new MyCloneableAbstractFactory();

        public static MyCloneableAbstractFactory getInstance() {
            return instance;
        }
    }

    public static void Run() throws CloneNotSupportedException {

        MyCloneableAbstractFactory factory = MyCloneableAbstractFactorySingleton.getInstance();
        char c = 'A';
        for(int i = 1; i<=26;i++){
            factory.load(i ,new MyCloneable.Builder().setId(i).setPrice(0.99+i).setName(c++).build());
        }

        MyCloneable itemVar;
        for(int i=1; i<=26; i++)
        {
            itemVar = factory.getObject(i);
            System.out.println(itemVar);
        }
    }

    @Override
    public MyCloneable clone() throws CloneNotSupportedException {
        return (MyCloneable) super.clone();
    }

    @Override
    public String toString(){
        return "Item Details:- ID:"+this.id+" Name: "+this.name+" Price: "+this.price+"\n";
    }
}
