package packTris;

import packData.MyData;

/**
 * @author Effantin
 */
public class TriBulle1 extends AbstractTri {

    private MyData data;

    public TriBulle1(MyData data) {
        super(data);
        this.data = data;
     }

    @Override
    public void next() {
        int[] tabData = data.getData();
        int nbData = tabData.length;

        // Comparaison des éléments adjacents
        for (int j = 0; j < nbData - 1; j++) {
            if (tabData[j] > tabData[j + 1]) {
                // Échange des éléments
                data.exchange(j, j + 1);
            }
        }

    }

}
