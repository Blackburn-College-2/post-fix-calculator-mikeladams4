package postfixcalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author adams
 */
public class PostfixcalculatorController implements Initializable {

    @FXML
    private Label lblIntro;

    @FXML
    private Button btnCalculate;

    @FXML
    private Label lblAnswer;

    @FXML
    private TextField tfExpression;

    @FXML
    private Text txtAnswer;

    @FXML
    private Label lblOps;

    @FXML
    void clicked(ActionEvent event) {
        Solver solver = new Solver(tfExpression.getText());
        txtAnswer.setText(solver.solve(solver.createList()));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
