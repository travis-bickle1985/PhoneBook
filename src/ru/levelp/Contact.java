package ru.levelp;

/**
 * Created by coadmin on 26.06.2015.
 */
public class Contact {
    String name, number, email;
    public Contact(String name, String number, String email){
        this.name = name;
        this.number = number;
        this.email = email;
    }

    public void talk(int a) {//переменная a нужна для нумерации строк вывода, чтобы юзер выбирал
        //System.out.println("Вы ввели:");
        System.out.printf(a + ") %15s %15s %15s \n" ,name, number, email);
        //System.out.println("Спасибо");
    }

}
