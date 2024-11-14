package packData;

import java.util.Random;

public class MyData {
    private int[] tabData;
    private int nbData = 50;

    public MyData() {
        // Création d'un tableau de taile nbData
        tabData = new int[nbData];

        raz();
    }

    // Réinitialisation des données du tableau
    public void raz() {
        // Remplissage du tableau de valeurs aleatoires
        Random randNumber = new Random();

        for (int i = 0; i < nbData; i++) {
            tabData[i] = randNumber.nextInt(nbData);
            System.out.print(tabData[i]);
        }
    }

    // Récupération du tableau de données
    public int[] getData() {
        return tabData;
    }

    // Echange entre 2 éléments du tableau
    public void exchange(int elt1, int elt2) {
        int temp = tabData[elt1];
        tabData[elt1] = tabData[elt2];
        tabData[elt2] = temp;
    }

}
