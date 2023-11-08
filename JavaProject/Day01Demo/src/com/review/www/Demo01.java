package com.review.www;

public  class Demo01{
    public static void main(String[] args) {
        SingleInstance ins = SingleInstance.getInstance();
    }
}

class SingleInstance{
    private static SingleInstance instance;

    private SingleInstance(){
    }

    public static SingleInstance getInstance(){
        if(instance == null){
            instance = new SingleInstance();
        }
        return instance;
    }
}