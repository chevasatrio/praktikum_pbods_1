package com.mycompany.modul4_encapsulation;

/**
 * Class dalam package yang sama untuk test default (package-private) access.
 * Default members bisa diakses dalam package yang sama.
 */
public class SamePackageDemo {

    public void testAccess() {
        AccessModifierDemo demo = new AccessModifierDemo();

        // public - OK
        System.out.println("Public field: " + demo.publicField);
        demo.publicMethod();

        // private - TIDAK AKSES
        // System.out.println(demo.privateField);
        // demo.privateMethod();

        // protected - OK (package sama)
        System.out.println("Protected field: " + demo.protectedField);
        demo.protectedMethod();

        // default (package-private) - OK (package sama)
        System.out.println("Default field: " + demo.defaultField);
        demo.defaultMethod();
    }
}