package manipulation;

public interface Substitutable {
    /**
     * Substitute all occurrences of oldSymbol in the implementing object's content by newSymbol.
     * @param oldSymbol symbol to replace
     * @param newSymbol symbol to use as replacement
     */
    void substituteSymbol(char oldSymbol, char newSymbol);
}
