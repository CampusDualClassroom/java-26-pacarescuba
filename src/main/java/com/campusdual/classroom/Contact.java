package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.text.Normalizer;
import java.util.List;

public class Contact implements ICallActions {

  public String name;
  public String surnames;
  public String phone;
  public String code;
  public List<String> secondaryPhones;

  public Contact(String name, String surnames, String phone) {
    this.name = name;
    this.surnames = surnames;
    this.phone = phone;
    this.code = calculateCode();
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurnames() {
    return this.surnames;
  }

  public void setSurnames(String surname) {
    this.surnames = surname;
  }

  public String getPhone() {
    return this.phone;
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

  private String calculateCode() {
    return Normalizer.normalize(String.valueOf(this.name.trim().toLowerCase().charAt(0))
            + (this.surnames.trim().toLowerCase().charAt(0))
            + this.surnames.toLowerCase().trim().substring(1).replaceAll("^(\\s*.*?\\s)(.*)", "$2")
            .replaceAll(" ", ""), Normalizer.Form.NFKD).replaceAll("[^\\p{ASCII}]", "");
  }

  @Override
  public void callMyNumber() {
    System.out.println("Te estás llamando a tí mismo");
  }

  @Override
  public void callOtherNumber(String number) {
    System.out.println("Estás llamando a " + getName() + " " + getSurnames() + " con teléfono: " + number);
  }

  @Override
  public void showContactDetails() {
    System.out.println("Nombre y apellidos: " + getName() + " " + getSurnames() + "\nNickname: " + getCode()
            + "\nTeléfono: " + getPhone() + "\n");
  }

  public void contactOptions() {
    System.out.println("\na) Llamar a otro número\nb) Llamarme a mí mismo\nc) Mostrar detalles\n");

    switch (Utils.string("Elige una opción -> ")) {
      case "a":
      case "A":
        callOtherNumber(Utils.string("Escribe el número al que llamas -> "));
        break;

      case "b":
      case "B":
        callMyNumber();
        break;

      case "c":
      case "C":
        showContactDetails();
        break;

      default:
        System.out.println("Introduzca un valor válido");
        break;

    }
  }
}
