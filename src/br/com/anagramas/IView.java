package br.com.anagramas;

import java.util.Collection;

public interface IView
{
    /**
     * Display an information message in this view.
     * By convention this should not require
     * user-interaction, i.e., no modal dialog.
     * @param s is the message displayed
     */
    public void showMessage(String s);
    
    /**
     * Display an error message in this view. For GUI views
     * this could pop up an error dialog.
     * @param s is the error message displayed
     */
    public void showError(String s);
    
    /**
     * Display all elements of the Collection
     * in some way. Typically the toString method
     * of each element could be displayed, but application
     * specific views can display as warranted.
     * @param elements is the collection to be displayed
     */
    public void update(Collection elements);
}
