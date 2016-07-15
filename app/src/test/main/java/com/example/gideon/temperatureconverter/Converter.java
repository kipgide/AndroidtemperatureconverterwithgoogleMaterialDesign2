package com.example.gideon.temperatureconverter;
/**
 * Created by gideon on 08/07/16.
 */
public class Converter {
    public static double fahrenheit(double f) {

        return (32 + f) * 9/5;
    }

    public  static  double celcius(double c) {

        return (c - 32) * 5/9;
    }
}