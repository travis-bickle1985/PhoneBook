package ru.levelp;

import java.util.Scanner;

/**
 * Created by coadmin on 26.06.2015.
 */
public class Main {
    public static void main(String[] args) {
        Contact[] book = new Contact[20];
        int exit = 0;//это для пятого пункта меню (выход), далее будет цикл с постусловием

        do {
            int size = 0;//это кол-во введенных контактов для второго пункта (удаление) и для вывода всего списка
            System.out.println("\nМеню");
            System.out.println("1. Добавить контакт \n2. Удалить контакт \n3. Вывести все контакты \n" +
                    "4. Изменить контакт \n5. Выход");
            System.out.println("Введите номер желаемого действия:\n");
            Scanner scan = new Scanner(System.in);
            int answer = scan.nextInt();

            switch (answer) {
                case 1:
                    int repeat;
                    do {
                        System.out.println("Выбрано добавление: \n");
                        System.out.println("Введите имя:");
                        String aname = scan.next(); //непонятно почему я не могу использовать переменную name
                        System.out.println("Введите номер:");
                        String anumber = scan.next();
                        System.out.println("Введите мыло:");
                        String aemail = scan.next();
                        book[size] = new Contact(aname, anumber, aemail);
                        book[size].talk(size); //методу talk нужен аргумент для нумерпции строк вывода контактов
                        size++;
                        System.out.println("Добавить еще контакт? \t1. Да 0. Нет");
                        repeat = scan.nextInt();
                    } while (repeat == 1);
                    break;
                case 2:
                    System.out.println("Выбрано удаление");
                    if(book[0] == null){
                        System.out.println("Список пуст");
                    } else{
                        System.out.println("Вывод списка контактов:");
                        for (int i = 0; i < size; i++) {
                            book[i].talk(i);
                        }
                        System.out.println("Введите номер удаляемого контакта");
                        int delNum = scan.nextInt();
                        for (int i = delNum; i < size; i++) {
                            book[i] = book[i + 1];
                        }
                        size -= 1;
                        System.out.println("Вывод списка контактов после удаления:");
                        for (int i = 0; i < size; i++) {
                            book[i].talk(i);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Выбран вывод списка контактов:");
                    if(book[0] == null){
                        System.out.println("Список пуст");
                    } else{
                        for (int i = 0; i < size; i++) {
                            book[i].talk(i);
                        }
                    }
                    break;
                case 4:
                    if(book[0] == null){
                        System.out.println("Список пуст");
                    } else{
                        System.out.println("Выбрано изменение контакта.");
                        System.out.println("Вывод списка контактов:");
                        for (int i = 0; i < size; i++) {
                            book[i].talk(i);
                        }
                        System.out.println("Введите номер изменяемого контакта");
                        int chNum = scan.nextInt();
                        System.out.println("Выбрано изменение следующего контакта:");
                        book[chNum].talk(chNum);
                        int exitChange = 0;
                        do {
                            System.out.println("Введите номер поля для изменения\n1. Имя\n2. Номер\n3. Мыло");
                            int fieldNum = scan.nextInt();
                            switch(fieldNum){
                                case 1:
                                    System.out.println("Текущее имя: " + book[chNum].name);
                                    System.out.println("Введите новое имя:");
                                    book[chNum].name = scan.next();
                                    break;
                                case 2:
                                    System.out.println("Текущий номер: " + book[chNum].number);
                                    System.out.println("Введите новый номер:");
                                    book[chNum].number = scan.next();
                                    break;
                                case 3:
                                    System.out.println("Текущее мыло: " + book[chNum].email);
                                    System.out.println("Введите новое мыло:");
                                    book[chNum].email = scan.next();
                                    break;
                            }
                            System.out.println("Изменить другое поле этого контакта? 1 - Да, 0 - Нет.");
                            exitChange = scan.nextInt();
                        } while (exitChange == 1);

                        System.out.println("Вывод списка контактов после изменения:");
                        for (int i = 0; i < size; i++) {
                            book[i].talk(i);
                        }
                    }
                    break;
                case 5:
                    exit = 1;
                    break;
                default:
                    System.out.println("Неверное значение");
                    break;
            }
        } while (exit == 0);
        /* пробовал вынести добавление контактов и тд отдельными методами, но запарился c областями видимости
            private static void addContact() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите имя");
            String name = scan.next();
            System.out.println("Введите номер");
            String number = scan.next();
            System.out.println("Введите мыло");
            String email = scan.next();
            int size = 0;
            book[int size] = new Contact(name, phone, email);
            size++;
        }*/
    }


}
