package manipulation;

public interface Normalizable {

    /**
     * Normalizes the implementing object's content.
     * For instance, if the implementing object is an image,
     * this method performs RGB normalization.
     */
    void normalize();
}
