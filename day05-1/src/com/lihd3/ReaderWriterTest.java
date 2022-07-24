package com.lihd3;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/8 19:47
 */
public class ReaderWriterTest {
    public static void main(String[] args) {
        Book b = new Book();
        new Thread(new Reader(b)).start();
        new Thread(new Writer(b)).start();
    }
}

class Book{
    private int books;
    public synchronized void writeBook(){
        notifyAll();
        if(books < 10){
            books++;
            System.out.println(Thread.currentThread().getName() + " 正在写第 " + books + " 本书");

        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void readBook(){
        notifyAll();
        if(books > 0){
            System.out.println(Thread.currentThread().getName() + " 正在读第 " + books + " 本书");
            books--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Reader implements Runnable{

    Book book;

    public Reader(Book book) {
        this.book = book;
    }

    @Override
    public void run() {
        while (true){
            book.readBook();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Writer implements Runnable{
    Book book;

    public Writer(Book book) {
        this.book = book;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            book.writeBook();
        }
    }
}