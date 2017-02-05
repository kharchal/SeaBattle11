package ua.com.hav.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Base {

        private Map<Integer, Pet> pets = new HashMap<Integer, Pet>();

    {
        add(new Pet("Kesha", 1));
        add(new Pet("Stepa", 3));
        add(new Pet("Gera", 5));
        add(new Pet("Layka", 4));
    }
        private int key;

        public void add(Pet pet) {
            if (!pets.containsValue(pet)) {
                pet.setId(key);
                pets.put(key++, pet);
            }
            System.out.println("pets = " + pets);
        }

        public Pet get(int key) {
            System.out.println("pets = " + pets);
            return pets.get(key);
        }

        public void remove(int id) {
            pets.put(id, null);
            pets.remove(id);
            System.out.println("pets = " + pets);
        }

        public void edit(Pet pet) {
            pets.put(pet.getId(), pet);
            System.out.println("pets = " + pets);
        }

        public List<Pet> asList() {
            return new ArrayList<Pet>(pets.values());
        }


}
