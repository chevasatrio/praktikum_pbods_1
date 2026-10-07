package com.mycompany.modul4_subpackage;

import com.mycompany.modul4_encapsulation.AccessModifierDemo;

/**
 * Subclass di package berbeda untuk demonstrasi protected access modifier.
 * Protected members bisa diakses oleh subclass meski di package berbeda.
 */
public class SubclassDemo extends AccessModifierDemo {

    public void testAccess() {
        // public - OK
        System.out.println("Public field: " + publicField);

        // private - TIDAK AKSES (compile error)
        // System.out.println(privateField);

        // protected - OK (karena subclass)
        System.out.println("Protected field: " + protectedField);
        protectedMethod();

        // default - TIDAK AKSES (package berbeda)
        // System.out.println(defaultField);
        // defaultMethod();

        // Getter/setter untuk private field - OK
        System.out.println("Private field via getter: " + getPrivateField());
        setPrivateField("Diubah dari subclass");
        System.out.println("Setelah diubah: " + getPrivateField());
    }
}