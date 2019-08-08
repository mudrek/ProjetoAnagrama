package br.com.anagramas;

import java.util.*;
import java.io.Reader;

/**
 * This class implements methods from IModel that will be likely be the same in
 * all model implementations. Specifically, adding, removing, and notifying
 * views will likely be the same. Subclassing this class, rather than
 * implementing the IModel interface, is probably a good idea.
 * <P>
 * Subclasses must implement process and initialize from Scanner.
 * <P>
 * 
 * @author Owen Astrachan
 */
public abstract class AbstractModel implements IModel {
	private ArrayList<IView> myViews;

	public AbstractModel() {
		myViews = new ArrayList<IView>();
	}

	/**
	 * @param view
	 *            is added as one of this model's views
	 */
	public void addView(IView view) {
		myViews.add(view);
	}

	/**
	 * @param view
	 *            is removed from this model's views Removing a view that hasn't
	 *            been already added could cause a problem.
	 */
	public void removeView(IView view) {
		myViews.remove(view);
	}

	/**
	 * @param elements
	 *            is passed to all registered views.
	 */
	public void notifyViews(Collection elements) {
		for (IView view : myViews) {
			view.update(elements);
		}
	}

	/**
	 * Indicate an error, e.g., in an appropriate dialog, to all views.
	 * 
	 * @param s is displayed as an error to all views
	 */
	public void showViewsError(String s) {
		for (IView view : myViews) {
			view.showError(s);
		}
	}

	/**
	 * Display a message (e.g., in a dialog or in a text-field) to all views.
	 * 
	 * @param s is messaged to all views
	 */
	public void messageViews(String s) {
		for (IView view : myViews) {
			view.showMessage(s);
		}
	}
}
