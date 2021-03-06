package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.Button;
import java.io.*;

public class Controller extends Component {

    public TextArea text;
    public String txt;
    public javafx.scene.control.Button cop;
    public javafx.scene.control.Button peg;
    public javafx.scene.control.Button eng;


    public void initialize (){
        cop.setGraphic(new ImageView("copy.png"));
        peg.setGraphic(new ImageView("paste.png"));
        eng.setGraphic(new ImageView("cut.png"));
        
    }
    public void sortit(ActionEvent actionEvent) {

        Platform.exit();
    }

    public void copiar(ActionEvent actionEvent) {

            text.copy();
    }

    public void tallar(ActionEvent actionEvent) {

            text.cut();
        }

    public void enganxar(ActionEvent actionEvent) {

            text.paste();
    }

    public void desfer(ActionEvent actionEvent) {

            text.undo();
    }

    public void sobre(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null, "Información sobre el editor, mejor preguntale a David Casas por el.", "Sobre el editor", JOptionPane.INFORMATION_MESSAGE);
    }

    public void arial(ActionEvent actionEvent) {

        text.setFont(new Font("Arial", 14));
    }

    public void serif(ActionEvent actionEvent) {

        text.setFont(new Font("Liberation Serif", 14));
    }

    public void cmr10(ActionEvent actionEvent) {

        text.setFont(new Font("cmr10", 14));
    }

    public void diez(ActionEvent actionEvent) {

    }

    public void doce(ActionEvent actionEvent) {

    }

    public void catorce(ActionEvent actionEvent) {

    }

    public void cop(ActionEvent actionEvent) {
        text.copy();
    }

    public void peg(ActionEvent actionEvent) {
        text.paste();

    }

    public void eng(ActionEvent actionEvent) {
        text.cut();
    }

    public void copy(ActionEvent actionEvent) {
        text.copy();
    }

    public void paste(ActionEvent actionEvent) {
        text.paste();
    }

    public void cut(ActionEvent actionEvent) {
        text.cut();
    }

    public void undo(ActionEvent actionEvent) {
        text.undo();
    }

    public String obrir(ActionEvent actionEvent) throws IOException {

        String aux="";
        String texto="";
        String title= "";

        try
        {

            JFileChooser file=new JFileChooser();
            file.showOpenDialog(this);

            File abre=file.getSelectedFile();

            title = abre.getName();
            Stage stage = (Stage)text.getScene().getWindow();
            stage.setTitle(title);

            if(abre!=null)
            {
                FileReader archivos=new FileReader(abre);
                BufferedReader lee=new BufferedReader(archivos);
                while((aux=lee.readLine())!=null)
                {
                    texto+= aux+ "\n";
                    text.setText(texto);

                }
                lee.close();
            }
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null,ex+" \nNo s'ha trobat l'arxiu", "Atenció!",JOptionPane.WARNING_MESSAGE);
        }
        return texto;
    }

    public void save(ActionEvent actionEvent) {

        try
        {
            String nombre="";
            JFileChooser file=new JFileChooser();
            file.showSaveDialog(this);
            File guarda =file.getSelectedFile();

            if(guarda !=null)
            {
                FileWriter  save=new FileWriter(guarda);
                save.write(text.getText());
                save.close();
            }

        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null,
                    "L'arxiu no s'ha guardat", "Atenció",JOptionPane.WARNING_MESSAGE);
        }
    }

}
