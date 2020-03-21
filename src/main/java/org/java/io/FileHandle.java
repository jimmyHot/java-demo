package org.java.io;

import java.io.*;

public class FileHandle {

    public static void write() throws IOException {
        FileOutputStream fos = new FileOutputStream("/Users/jialimin/nashwork/temp.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        User user = new User();
        user.setAge(18);
        user.setName("sandy");
        oos.writeObject(user);

        oos.flush();
        oos.close();
    }

    public static void read() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("/Users/jialimin/nashwork/temp.txt");

        ObjectInputStream oin = new ObjectInputStream(fis);

        User user = (User) oin.readObject();

        System.out.println("name="+user.getName());
    }

    public static void main(String[] args) {
        try {
            write();
            //read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
