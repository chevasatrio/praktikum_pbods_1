package main;

import hargatoken.hargatoken;
import hargapulsa.hargapulsa;

public class Main {
    public static void main(String[] args) {
        hargatoken objectToken = new hargatoken();
        objectToken.info();
        System.out.println();
        hargapulsa objectPulsa = new hargapulsa();
        objectPulsa.info();
    }
}