package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.text.MessageFormat;
import java.util.ArrayList;

/**
 * This class represent a view.
 * 
 * @author andrea
 */
public abstract class View {

	// Observer list...
	private ArrayList<ViewObserver> observers = new ArrayList<>();

	// JavaFX "Stage" class; it is a container for any JavaFX program.
	private Stage stage;
	// JavaFX "Scene" class; it is a container for all content in a scene.
	private Scene scene;

	// Window title.
	private String windowTitle = "Window";
	// The base class for all nodes that have children in the scene graph.
	private Parent root;
	// Resizable window.
	private boolean isWindowResizable = true;

	/**
	 * This method is used to initalize a specific view.
	 */
	protected abstract void initializationView();

	/**
	 * Constructs a newly allocated {@code View} object.
	 */
	public View() throws Exception {

		// Get location of FXML file...
		String resourceName = MessageFormat.format("{0}.fxml", this.getClass().getSimpleName());
		// Ger a JavaFX "FXMLLoader" object; it is used to loading FXML files at
		// runtime...
		FXMLLoader loader = new FXMLLoader(getClass().getResource(resourceName));
		// Set view controller...
		loader.setController(this);
		// Loads an object hierarchy from a FXML document...
		this.root = loader.load();
	}

	/**
	 * This method is used to show a window.
	 *
	 * @throws Exception
	 */
	public void show() throws Exception {

		// Get a JavaFX "Stage" and "Scene" object...
		if (this.stage == null)
			this.stage = new Stage();
		if (this.scene == null)
			this.scene = new Scene(this.root);

		// Stage configuration...
		this.stage.setTitle(windowTitle);
		this.stage.setScene(this.scene);
		this.stage.setResizable(isWindowResizable);

		// Initialization...
		initializationView();
		// Show stage...
		this.stage.show();
	}

	/**
	 * This method is used to close a view.
	 */
	public void close() {
		stage.close();
	}

	/**
	 * This method is used to register a new observer.
	 * 
	 * @param arg0
	 *            - Represents an {@link ViewObserver} object.
	 */
	public void addObserver(ViewObserver arg0) {
		this.observers.add(arg0);
	}

	/**
	 * This method is used to remove an existing observer.
	 * 
	 * @param arg0
	 *            - Represents an {@link ViewObserver} object.
	 */
	public void removeObserver(ViewObserver arg0) {
		this.observers.remove(arg0);
	}

	/**
	 * This method is used to notify all observers
	 */
	public void notifyToObservers() {
		for (ViewObserver object : this.observers) {
			object.updateView();
		}
	}

	/**********************************************************************
	 * /* Getter and setter... /
	 **********************************************************************/

	/**
	 * @return the stage
	 */
	public Stage getStage() {
		return stage;
	}

	/**
	 * @param stage
	 *            the stage to set
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}

	/**
	 * @return the scene
	 */
	public Scene getScene() {
		return scene;
	}

	/**
	 * @param scene
	 *            the scene to set
	 */
	public void setScene(Scene scene) {
		this.scene = scene;
	}

	/**
	 * @return the windowTitle
	 */
	public String getWindowTitle() {
		return windowTitle;
	}

	/**
	 * @param windowTitle
	 *            the windowTitle to set
	 */
	public void setWindowTitle(String windowTitle) {
		this.windowTitle = windowTitle;
	}

	/**
	 * @return the root
	 */
	public Parent getRoot() {
		return root;
	}

	/**
	 * @param root
	 *            the root to set
	 */
	public void setRoot(Parent root) {
		this.root = root;
	}

	/**
	 * @return the isWindowResizable
	 */
	public boolean isWindowResizable() {
		return isWindowResizable;
	}

	/**
	 * @param isWindowResizable
	 *            the isWindowResizable to set
	 */
	public void setWindowResizable(boolean isWindowResizable) {
		this.isWindowResizable = isWindowResizable;
	}
}
