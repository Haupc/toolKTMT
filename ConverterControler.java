import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.net.URL;
import java.util.ResourceBundle;

public class ConverterControler implements Initializable {
    private FXMLLoader loader = new FXMLLoader(getClass().getResource("NumberConverter.fxml"));
    @FXML
    private TextField UIInputText;
    @FXML
    private TextField UIOutputText;
    @FXML
    private TextField IInputText;
    @FXML
    private TextField IOutputText;
    @FXML
    private TextField RInputText;
    @FXML
    private TextField ROutputText;
    @FXML
    private TextField numOfBit;
    @FXML
    private TextField bitNguyen;
    @FXML
    private TextField bitThapPhan;
    @FXML
    private ChoiceBox<String> UIInputType;
    @FXML
    private ChoiceBox<String> UIOutputType;
    @FXML
    private ChoiceBox<String> IInputType;
    @FXML
    private ChoiceBox<String> IOutputType;
    @FXML
    private ChoiceBox<String> RInputType;
    @FXML
    private ChoiceBox<String> ROutputType;

    private unsignedIntConvert UIConverter = new unsignedIntConvert();
    private signBitIntConverter SBConverter = new signBitIntConverter();
    private OneComplementConverter oneComplementConverter = new OneComplementConverter();
    private TwoComplementConverter twoComplementConverter = new TwoComplementConverter();
    private FixedBitRealNumberConverter fixedBitRealNumberConverter = new FixedBitRealNumberConverter();

    public void processUnsignedInt(){
        switch (UIInputType.getValue()){
            case "BIN":
                switch (UIOutputType.getValue()){
                    case "DEC":
                        UIOutputText.setText(UIConverter.binToDec(UIInputText.getText()));
                        return;
                    case "OCT":
                        UIOutputText.setText(UIConverter.binToOctal(UIInputText.getText()));
                        return;
                    case "HEX":
                        UIOutputText.setText(UIConverter.binToHex(UIInputText.getText()));
                        return;
                    default:
                        return;
                }
            case "DEC":
                switch (UIOutputType.getValue()){
                    case "BIN":
                        UIOutputText.setText(UIConverter.decToBin(Long.parseLong(UIInputText.getText())));
                        return;
                    case "OCT":
                        UIOutputText.setText(UIConverter.decToOctal(Long.parseLong(UIInputText.getText())));
                        return;
                    case "HEX":
                        UIOutputText.setText(UIConverter.decToHex(Long.parseLong(UIInputText.getText())));
                        return;
                    default:
                        return;
                }
            case "OCT":
                switch (UIOutputType.getValue()){
                    case "BIN":
                        UIOutputText.setText(UIConverter.octalToBin(UIInputText.getText()));
                        return;
                    case "DEC":
                        UIOutputText.setText(UIConverter.octalToDec(UIInputText.getText()));
                        return;
                    case "HEX":
                        UIOutputText.setText(UIConverter.octalToHex(UIInputText.getText()));
                        return;
                    default:
                        return;
                }
            case "HEX":
                switch (UIOutputType.getValue()){
                    case "BIN":
                        UIOutputText.setText(UIConverter.hexToBin(UIInputText.getText()));
                        return;
                    case "DEC":
                        UIOutputText.setText(UIConverter.hexToDec(UIInputText.getText()));
                        return;
                    case "OCT":
                        UIOutputText.setText(UIConverter.hexToOctal(UIInputText.getText()));
                        return;
                    default:
                        return;
                }
            default:
                return;
        }
    }

    public void processInt(){
        if(IInputType.getValue().equals("BIN")){
            switch (IOutputType.getValue()){
                case "SIGN BIT":
                    IOutputText.setText(SBConverter.binToDec(IInputText.getText()));
                    return;
                case "BU 1":
                    IOutputText.setText(oneComplementConverter.binToDec(IInputText.getText()));
                    return;
                case "BU 2":
                    IOutputText.setText(twoComplementConverter.binToDec(IInputText.getText()));
                    return;
                default:
                    return;
            }
        } else {
            switch (IOutputType.getValue()){
                case "SIGN BIT":
                    System.out.println(IInputText.getText());
                    IOutputText.setText(SBConverter.decToBin(Integer.parseInt(IInputText.getText()), Integer.parseInt(numOfBit.getText())));
                    return;
                case "BU 1":
                    IOutputText.setText(oneComplementConverter.decToBin(Long.parseLong(IInputText.getText()), Integer.parseInt(numOfBit.getText())));
                    return;
                case "BU 2":
                    IOutputText.setText(twoComplementConverter.decToBin(Long.parseLong(IInputText.getText()), Integer.parseInt(numOfBit.getText())));
                    return;
                default:
                    return;
            }
        }
    }

    public void processRealNumber(){
        if(RInputType.getValue().equals("BIN")){
            if(ROutputType.getValue().equals("FIXED BIT")){
                RInputText.setText(fixedBitRealNumberConverter.binToDec(RInputText.getText(), Integer.parseInt(bitNguyen.getText()), Integer.parseInt(bitThapPhan.getText())));
            }
            else {
                ROutputText.setText(fixedBitRealNumberConverter.decToBin(Double.parseDouble(RInputText.getText()), Integer.parseInt(bitNguyen.getText()), Integer.parseInt(bitThapPhan.getText())));
            }
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UIInputType.setItems(FXCollections.observableArrayList("BIN", "DEC", "OCT", "HEX"));
        UIOutputType.setItems(FXCollections.observableArrayList("BIN", "DEC", "OCT", "HEX"));
        RInputType.setItems(FXCollections.observableArrayList("BIN", "DEC"));
        ROutputType.setItems(FXCollections.observableArrayList("FIXED BIT", "32BIT", "64BIT"));
        IInputType.setItems(FXCollections.observableArrayList("BIN", "DEC"));
        IOutputType.setItems(FXCollections.observableArrayList("SIGN BIT", "BU 1", "BU 2"));
        UIInputText.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ENTER)){
                    processUnsignedInt();
                }
            }
        });
        UIInputType.itemsProperty().addListener((observable, oldValue, newValue) -> processUnsignedInt());
        UIOutputType.itemsProperty().addListener((observable, oldValue, newValue) -> processUnsignedInt());

        IInputText.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ENTER)){
                    processInt();
                }
            }
        });
        IInputType.itemsProperty().addListener((observable, oldValue, newValue) -> processInt());
        IOutputType.itemsProperty().addListener((observable, oldValue, newValue) -> processInt());

        RInputText.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ENTER)){
                    processRealNumber();
                }
            }
        });
        RInputType.itemsProperty().addListener((observable, oldValue, newValue) -> processRealNumber());
        ROutputType.itemsProperty().addListener((observable, oldValue, newValue) -> processRealNumber());
    }

}
