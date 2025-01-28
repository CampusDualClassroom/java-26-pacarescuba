package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {

  Map<String, Contact> contacts;

  public Phonebook() {
    this.contacts = new HashMap<>();
  }

  public static void buildMainMenu() {
    boolean isExit = false;
    boolean isValid = false;
    Phonebook phonebook = new Phonebook();
    do {
      System.out.println("\na) Añadir contacto al listín telefónico\nb) Mostrar contactos del listín telefónico" +
              "\nc) Seleccionar contacto\nd) Eliminar contacto\ne) Salir del menú\n");

      Contact contact;


      switch (Utils.string("Elige una opción -> ")) {
        case "a":
        case "A":
          contact = new Contact(Utils.string("Nombre del contacto -> "), Utils.string("Apellidos del contacto -> "),
                  Utils.string("Teléfono del contacto -> "));
          System.out.println(contact.getCode());
          System.out.println(contact.getName());
          System.out.println(contact.getSurnames());
          System.out.println(contact.getPhone());
          System.out.println(phonebook.getData().size());
          phonebook.addContact(contact);
          phonebook.showPhonebook();
          System.out.println(phonebook.getData().size());
          break;

        case "b":
        case "B":
          phonebook.showPhonebook();
          break;

        case "c":
        case "C":
          do {
            String c = Utils.string("Nickname del contacto -> ");
            if (phonebook.getData().containsKey(c)) {
              contact = phonebook.getData().get(c);

              System.out.println("\na) Llamar a otro número\nb) Llamarme a mí mismo\n");

              switch (Utils.character("Elige una opción -> ")) {
                case 'a':
                case 'A':
                  contact.callOtherNumber(Utils.string("Escribe el número al que llamas -> "));
                  break;

                case 'b':
                case 'B':
                  contact.callMyNumber();
                  break;

                default:
                  System.out.println("Introduzca un valor válido");
                  break;

              }
              isValid = true;
            } else {
              isValid = false;
              System.out.println("Contacto no encontrado");
            }
          } while (!isValid);
          break;

        case "d":
        case "D":

          do {
            String c = Utils.string("Nickname del contacto -> ");
            if (phonebook.getData().containsKey(c)) {
              phonebook.deleteContact(c);
              isValid = true;
            } else {
              isValid = false;
              System.out.println("Contacto no encontrado");
            }
          } while (!isValid);

          break;

        case "e":
        case "E":
          isExit = true;
          break;

        default:
          System.out.println("Introduzca un valor válido");
      }
    } while (!isExit);
  }

  public Map<String, Contact> getData() {
    return contacts;
  }

  public void addContact(Contact contact) {
    this.contacts.put(contact.getCode(), contact);
  }

  public void deleteContact(String name) {
    this.contacts.remove(name);
  }

  public void showPhonebook() {
    for (Contact contact : this.contacts.values()) {
      System.out.println("nickname: " + contact.getCode() + "\nNombre: " + contact.getName() + "\nApellidos: "
              + contact.getSurnames() + "\nTeléfono: " + contact.getPhone());
    }
  }
}
