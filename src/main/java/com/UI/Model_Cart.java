/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UI;



/**
 *
 * @author PC
 */
public class Model_Cart {

    String values;

    String title;

    public Model_Cart(String values, String title) {

        this.values = values;

        this.title = title;
    }

    public Model_Cart() {
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
