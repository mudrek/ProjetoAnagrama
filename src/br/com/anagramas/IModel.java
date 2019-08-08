package br.com.anagramas;

import java.util.*;
import java.io.Reader;

/**
 * The interface for typical models used in Compsci100.
 * The model is typically initialized to start a process,
 * e.g., a game or a simulation. The user then interacts
 * with the model via the model's process method which most
 * likely results in the model notifying all views that
 * a change in the model has occurred.
 * <P>
 * To set up a model/view typically the client/main code
 * looks like this:
 * 
   <PRE>
 
   IModel model = new ApplicationModel();
   IView  view = new GuiViewForApplication();
   model.addView(view);
 
   </PRE>
 * In this architecture the control is not part of the model,
 * but is typically part of the view (e.g., GUI control)
 * and other client code.
 * 
 * @author Owen Astrachan
 *
 */

public interface IModel
{
	/**
	 * Initialize the model using a scanner as the source
	 * of the model's initial data.
	 * @param s is the Scanner used to initialize
	 */
	public void initialize(Scanner s); 
	
	/**
	 * Add a view to the model, views are updated 
	 * based on application-specific basis.
	 * @param view is added to this model's views
	 * @see IView
	 */
    public void addView(IView view);
    
    /**
     * Remove a view from this model, it may be an error
     * to remove a view not previously added to the model.
     * @param view is removed from this model's views
     */
    public void removeView(IView view);
    
    /**
     * Process an Object in some model-specific way. Typically
     * the user might interact with the model, making a change
     * via the object. Views would be notified if the model
     * changes, for example.
     * @param o is the Object processed by this model
     */
    public void process(Object o);
    
    /**
     * Notify this model's views of the relevant model-state
     * passed to views in the collection
     * @param elements represents views to be displayed
     * @see IView
     */
    public void notifyViews(Collection elements);    
    
    /**
     * Send a message to each of this model's views.
     * @param s is the message sent to all views
     */
    public void messageViews(String s);
    
    /**
     * Send an error-message to this model's views.
     * @param s is the error message displayed in each view
     */
    public void showViewsError(String s);
}
