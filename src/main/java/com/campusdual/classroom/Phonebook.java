package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {

  Map<String, Contact> contacts;

  public Phonebook() {
    this.contacts = new HashMap<>();
  }

  public void buildMainMenu() {
    boolean isExitPressed = false;
    do {
      System.out.println("\na) Añadir contacto al listín telefónico\nb) Mostrar contactos del listín telefónico" +
              "\nc) Seleccionar contacto\nd) Eliminar contacto\nexit) Salir del programa\n");


      switch (Utils.string("Elige una opción -> ")) {
        case "a":
        case "A":
          addContact(createContact());
          break;

        case "b":
        case "B":
          showPhonebook();
          break;

        case "c":
        case "C":
          Contact contact = getSingleContact(Utils.string("Código del contacto ->"));
          if (contact == null) {
            System.err.println("Contacto no encontrado");
          } else {
            contact.contactOptions();
          }
          break;

        case "d":
        case "D":
          String c = Utils.string("Nickname del contacto -> ");
          deleteContact(c);
          break;

        case "exit":
        case "Exit":
          isExitPressed = true;
          break;

        default:
          System.out.println("Introduzca un valor válido");
      }
      Utils.string("Presiona INTRO para continuar");
    } while (!isExitPressed);
  }

  public Map<String, Contact> getData() {
    return this.contacts;
  }

  private Contact createContact() {
    return new Contact(Utils.string("Nombre del contacto -> "), Utils.string("Apellidos del contacto -> "),
            Utils.string("Teléfono del contacto -> "));
  }

  private Contact getSingleContact(String contactCode) {
    return this.contacts.get(contactCode);
  }

  public void addContact(Contact contact) {
    this.contacts.put(contact.getCode(), contact);
  }

  public void deleteContact(String name) {
    this.contacts.remove(name);
  }

  public void showPhonebook() {
    if (contacts.isEmpty()) {
      System.out.println("El listín telefónico no tiene ningún contacto");
    } else {
      for (Contact contact : this.contacts.values()) {
        System.out.println("nickname: " + contact.getCode() + "\nNombre: " + contact.getName() + "\nApellidos: "
                + contact.getSurnames() + "\nTeléfono: " + contact.getPhone());
      }
    }
  }
}
