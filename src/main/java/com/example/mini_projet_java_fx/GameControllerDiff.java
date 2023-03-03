package com.example.mini_projet_java_fx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;


public class GameControllerDiff {
    ObservableList<Carte> listCartes = FXCollections.observableArrayList();

    @FXML
    Button carte1, carte2, carte3, carte4, carte5, carte6, carte7, carte8;

    @FXML
    Label labScore;

    @FXML
    Label timer;

    // Score si les deux cartes sont égales
    int score = 0;

    // seconde du timer
    int seconde = 60;

    // minutes du timer
    int minute = 0;


    // tableau de button
    Button[] tabBut = {new Button(), new Button()};


   @FXML
    public void initialize() {
       // création d'une liste pour y ajouter des cartes
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

       // timer pour afficher une boite de dialogue
       int nb = 60;
       Timeline tm = new Timeline(new KeyFrame(Duration.seconds(1), ae -> timerAlert()));
       tm.setCycleCount(60);
       nb--;
       tm.play();
       if (nb < 1)
           tm.stop();
   }

   private void timerAlert(){

       //Date dte = new Date(2023, 10, 6, 5, minute, seconde);
       //timer.textProperty().set(dte.format(DateTimeFormatter.ofPattern("mm:ss")));

       // affiche la boite de dialogue
       timer.setText("00:" + seconde);
       seconde--;
       if (seconde <= 1){
           Alert alertTimer = new Alert(Alert.AlertType.INFORMATION);
           alertTimer.setTitle("TEMPS ECOULE !");
           alertTimer.setContentText("Vous n'avez pas fini le jeu dans le temps impartie. Recommencez !");
           alertTimer.show();
           reset();
           System.out.println("TEMPS ECOULE !");

       }

   }

    @FXML
    public void onClickButton(ActionEvent evt){
        // ajoute la carte dans la liste
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
       labScore.setText("Score = " + score);
       seconde = 60;
       carte1.setVisible(true);
       carte2.setVisible(true);
       carte3.setVisible(true);
       carte4.setVisible(true);
       carte5.setVisible(true);
       carte6.setVisible(true);
       carte7.setVisible(true);
       carte8.setVisible(true);
    }

    private void reset(){
        if (!listCartes.isEmpty()){
            int taille = listCartes.size();
            for(int i = 0; i < taille; i++) {
                listCartes.remove(0);
            }
        }
        score = 0;
        seconde = 60;
        carte1.setVisible(true);
        carte2.setVisible(true);
        carte3.setVisible(true);
        carte4.setVisible(true);
        carte5.setVisible(true);
        carte6.setVisible(true);
        carte7.setVisible(true);
        carte8.setVisible(true);
    }
}