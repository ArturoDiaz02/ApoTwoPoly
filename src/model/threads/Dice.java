package model.threads;

import java.io.IOException;

import javafx.application.Platform;
import model.objects.Board;
import ui.ApoTwoPolyGUI;

public class Dice extends Thread{

    private ApoTwoPolyGUI gui;

    public Dice(ApoTwoPolyGUI gui) {
        this.gui = gui;
    }

    @Override
    public void run() {
    
        try {

            Board axBoard = gui.initDice();

            Platform.runLater(new Thread(){
                @Override
                public void run() {
                    gui.setBoard(axBoard);
                }
    
            });

        } catch (IOException e1) {
            e1.printStackTrace();

        }

    }

}
