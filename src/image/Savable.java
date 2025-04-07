package image;

public interface Savable {

    /**
     * Save the content of the implementing object to a file.
     * @param path Path to save the object's content to.
     * @throws IllegalArgumentException if the path is null or otherwise invalid.
     */
    void save(String path);
}
