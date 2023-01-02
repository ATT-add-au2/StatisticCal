/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication_shenyuan;

import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;

import javax.imageio.ImageIO;


/**
 * @author kezhang
 */
public class IOOperation {

    private static List<Double> inputData;

    public static void SaveToFile(Pane pane, File file) throws IOException {

        if (file != null) {
            try {
                WritableImage writableImage = new WritableImage((int) pane.getWidth(), (int) pane.getHeight());
                pane.snapshot(null, writableImage);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                ImageIO.write(renderedImage, "png", file);
            } catch (IOException s) {
                System.out.println("Error: failed to save");
            }
        }
    }

    /*
    Open test data list
    param: File file
    */
    public static void openFile(File file) {
        String fileName = file.getName();
        //check the exist of file
        if (file != null) {
            try {
                //use bufferedreader to read the file line by line
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                ArrayList<Double> listoflines = new ArrayList<>();
                String line = null;
                //check the empty of file
                while ((line = reader.readLine()) != null) {
                    listoflines.add(Double.valueOf(line));
                }
                //multipy every elements by 10E5
                for (int q = 0; q < listoflines.size(); q++) {
                    listoflines.set(q, listoflines.get(q) * 10E5);
                }
                //sort the list 
                Collections.sort(listoflines);
                //assign the inputData
                inputData = listoflines;
            } catch (IOException ex) {
                System.out.println("Error reading file \n");
            }
        }
    }

    public static List<Double> getInputData() {
        return inputData;
    }


}
