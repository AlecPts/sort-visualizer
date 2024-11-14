package packTris;

import packData.MyData;

/**
 * @author Effantin
 */
public class TriBulle2 extends AbstractTri {

    private MyData data;
    boolean swapped;

    public TriBulle2(MyData data) {
        super(data);
        this.data = data;
     }

    @Override
    public void next() {
        //if (!swapped) return;

        int[] tabData = data.getData();
        int nbData = tabData.length;
        swapped = false;

        // Comparaison des éléments adjacents
        for (int j = 0; j < nbData - 1; j++) {
            if (tabData[j] > tabData[j + 1]) {
                // Échange des éléments
                data.exchange(j, j + 1);

                swapped = true;
            }
        }

    }

}
