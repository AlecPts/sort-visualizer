package packTris;

import packData.MyData;

/**
 *
 * @author Effantin
 */
public abstract class AbstractTri {
    protected MyData myData;

    public AbstractTri(MyData myData) {
        this.myData = myData;
    }

    public abstract void next();
}
