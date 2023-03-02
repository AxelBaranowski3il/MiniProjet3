package com.example.mini_projet_java_fx;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class GameController {
    ObservableList<Carte> listCartes = FXCollections.observableArrayList();

    @FXML
    Button carte1, carte2, carte3, carte4, carte5, carte6, carte7, carte8;

    @FXML
    Label labScore;

    // Score si les deux cartes sont égales
    int score = 0;

    // tableau de button
    Button[] tabBut = {new Button(), new Button()};


   @FXML
    public void initialize() {
       listCartes.addListener((ListChangeListener.Change<? extends Carte> change ) ->{
            while(change.next()){
                if (listCartes.size() == 2 && (listCartes.get(0).getId() == listCartes.get(1).getId())){
                    score++;
                    tabBut[0].setVisible(false);
                    tabBut[1].setVisible(false);
                }
                System.out.println("LISTE :");
                for(Carte carte : listCartes) {
                    System.out.println(carte.getId());
                }
                System.out.println("Score = " + score);
                labScore.setText("Score = " + score);

            }
       });
   }

    @FXML
    public void onClickButton(ActionEvent evt){
       if (listCartes.size() >= 2) {
           for (Carte carte : listCartes)
               listCartes.remove(0);
       }
        listCartes.add(new Carte((int)(Math.random()*4)+1));
        tabBut[listCartes.size()-1] = (Button)evt.getSource();
    }

    @FXML
    public void retryButton(ActionEvent evt){
       if (!listCartes.isEmpty()){
           int taille = listCartes.size();
           for(int i = 0; i < taille; i++) {
               listCartes.remove(0);
           }
       }
       score = 0;
    }
}