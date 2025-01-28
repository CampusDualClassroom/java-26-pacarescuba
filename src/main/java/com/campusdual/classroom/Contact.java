package com.campusdual.classroom;

import java.text.Normalizer;

public class Contact implements ICallActions {

  public String name;
  public String surnames;
  public String phone;
  public String code;

  public Contact(String name, String surnames, String phone) {
    this.name = name;
    this.surnames = surnames;
    this.phone = phone;
    this.code = Normalizer.normalize(String.valueOf(name.trim().toLowerCase().charAt(0))
            + (surnames.trim().toLowerCase().charAt(0))
            + surnames.toLowerCase().trim().substring(1).replaceAll("^(\\s*.*?\\s)(.*)", "$2")
            .replaceAll(" ", ""), Normalizer.Form.NFKD).replaceAll("[^\\p{ASCII}]", "");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurnames() {
    return surnames;
  }

  public void setSurnames(String surname) {
    this.surnames = surname;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public void callMyNumber() {
    System.out.println("Estás llamando a " + getName() + " " + getSurnames() + " con teléfono: " + getPhone());
  }

  @Override
  public void callOtherNumber(String number) {
    System.out.println("Estás llamando a " + getName() + " " + getSurnames() + " con teléfono: " + number);
  }

  @Override
  public void showContactDetails() {
    System.out.println("Nombre y apellidos: " + getName() + " " + getSurnames() + "\nNickname: " + getCode()
            + "\nTeléfono: " + getPhone());
  }
}
