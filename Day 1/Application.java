package com.demo;

public class Application{
    public static void main(String[] args) {
        CurrencyConverter curr = new CurrencyConverter();
        System.out.println(curr.inrToUsd(125.55));
    }
}