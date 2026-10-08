package com.mycompany.modul4_encapsulation;

/**
 * Demonstrasi Access Modifier: public, private, protected, default (package-private).
 * File ini menunjukkan perbedaan aksesibilitas antar modifier.
 */
public class AccessModifierDemo {

    // public - akses dari mana saja
    public String publicField = "Public Field";

    // private - hanya akses dalam class ini
    private String privateField = "Private Field";

    // protected - akses dalam package yang sama DAN subclass (meski package berbeda)
    protected String protectedField = "Protected Field";

    // default (package-private) - akses dalam package yang sama saja
    String defaultField = "Default (Package-Private) Field";

    // Public method - bisa dipanggil dari mana saja
    public void publicMethod() {
        System.out.println("Public method dipanggil");
        privateMethod(); // Bisa akses private method dalam class yang sama
    }

    // Private method - hanya dalam class ini
    private void privateMethod() {
        System.out.println("Private method dipanggil (hanya dalam class ini)");
    }

    // Protected method - package sama + subclass
    protected void protectedMethod() {
        System.out.println("Protected method dipanggil");
    }

    // Default method - package yang sama saja
    void defaultMethod() {
        System.out.println("Default method dipanggil (package yang sama)");
    }

    // Getter untuk private field (enkapsulasi)
    public String getPrivateField() {
        return privateField;
    }

    // Setter untuk private field dengan validasi
    public void setPrivateField(String value) {
        if (value != null && !value.isEmpty()) {
            this.privateField = value;
        }
    }
}