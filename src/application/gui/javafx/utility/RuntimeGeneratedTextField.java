package application.gui.javafx.utility;

import application.gui.javafx.annotation.CallableByRuntimeGeneratedControl;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class RuntimeGeneratedTextField implements RuntimeGeneratedControl {

    @Override
    public void add(VBox pRoot, CallableByRuntimeGeneratedControl pAnnotation) {

        VBox mVBox = new VBox();
        Label mLabel = new Label();
        TextField mTextField = new TextField();

        mVBox.setPadding(new Insets(10, 10,0,10));
        mLabel.setTextFill(Color.DARKGRAY);
        mLabel.setStyle("-fx-font-weight: bold");

        mTextField.setPromptText(pAnnotation.promptText());
        mLabel.setText(pAnnotation.description());
        mVBox.getChildren().addAll(mTextField, mLabel);

        mTextField.textProperty().addListener((obs, oldText, newText) -> {
            System.out.println("Text changed from "+oldText+" to "+newText);
            // ...
        });


        pRoot.getChildren().add(mVBox);

    }
}
