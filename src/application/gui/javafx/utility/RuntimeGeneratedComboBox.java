package application.gui.javafx.utility;

import application.entity.customer.Title;
import application.gui.javafx.annotation.CallableByRuntimeGeneratedControl;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class RuntimeGeneratedComboBox implements RuntimeGeneratedControl {

    @Override
    public void add(VBox pRoot, CallableByRuntimeGeneratedControl pAnnotation) {

        VBox mVBox = new VBox();
        ComboBox<Title> mComboBox = new ComboBox();
        Label mLabel = new Label();

        mVBox.setPadding(new Insets(10, 10,0,10));
        mLabel.setTextFill(Color.DARKGRAY);
        mLabel.setStyle("-fx-font-weight: bold");

        mComboBox.getItems().setAll(Title.values());
        mLabel.setText(pAnnotation.description());
        mVBox.getChildren().addAll(mComboBox, mLabel);

        pRoot.getChildren().add(mVBox);
    }
}
