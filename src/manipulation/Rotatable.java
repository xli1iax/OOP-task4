package manipulation;

public interface Rotatable {

    /**
     * Rotate the content of the implementing object in the specified direction.
     * @param direction Direction to rotate the object's content towards.
     * @throws IllegalArgumentException if the direction is null.
     */
    void rotate(RotationDirection direction);
}
