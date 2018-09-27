package application.gui.javafx.gui.customeredit;

import application.entity.customer.Customer;
import application.gui.javafx.annotation.CallableByRuntimeGeneratedControl;
import application.gui.javafx.gui.UserInterfaceJavaFX;
import application.gui.javafx.utility.RuntimeGeneratedControl;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Arrays;

public class UserInterfaceJavaFXCustomerEdit extends UserInterfaceJavaFX {

    @FXML
    private Button btn_ok;
    @FXML
    private VBox vbox_body;




    public UserInterfaceJavaFXCustomerEdit(Customer pCustomer) throws Exception {

        super();

        for (Method mMethod : Arrays.asList((Customer.class.getDeclaredMethods()))) {

            CallableByRuntimeGeneratedControl mAnnotation = mMethod.getAnnotation(CallableByRuntimeGeneratedControl.class);

            if (mAnnotation != null) {

                String mClassName = MessageFormat.format("{0}.{1}", RuntimeGeneratedControl.class.getPackage().getName(), mAnnotation.controlType());
                RuntimeGeneratedControl mygg = (RuntimeGeneratedControl) Class.forName(mClassName).getDeclaredConstructor().newInstance();


                mygg.add(vbox_body, mAnnotation);


            }
        }

    }


    @Override
    public void showUserInterface() {

        this.stage = new Stage();
        this.scene = new Scene(this.root);

        this.stage.setTitle("Customer edit");
        this.stage.setScene(this.scene);
        this.stage.setResizable(true);

        this.stage.show();
    }

    @Override
    public void updateUserInterface() {

    }

    @Override
    public void closeUserInterface() {

    }


    @FXML
    void OnAction_ok(ActionEvent event) {

    }
}
