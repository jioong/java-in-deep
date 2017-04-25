package com.github.jioong.serialization;

import com.github.jioong.serialization.model.Person;

import java.io.*;

/**
 * Created by jioong on 17-4-24.
 */
public class ObjSerialization {

    public static void main(String[] args) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("out.dat"));
            Person p = new Person("happy", 18);
            out.writeObject(p);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("out.dat"));
            Person person = (Person)in.readObject();
            System.out.println(person.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
