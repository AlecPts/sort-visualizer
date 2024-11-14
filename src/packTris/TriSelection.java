package packTris;

import packData.MyData;

/**
 * @author Effantin
 */
public class TriSelection extends AbstractTri {

    private MyData data;
    private int i = 0;

    public TriSelection(MyData data) {
        super(data);
        this.data = data;
     }

    @Override
    public void next() {
        int[] tabData = data.getData();
        int nbData = tabData.length;

        if (i < nbData - 1) {
            int minIndex = i;
            for (int j = i + 1; j < nbData; j++) {
                if (tabData[j] < tabData[minIndex]) {
                    minIndex = j;
                }
            }
            data.exchange(i, minIndex);
            i++;
        }

    }

}
