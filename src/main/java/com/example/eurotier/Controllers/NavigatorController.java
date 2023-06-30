package com.example.eurotier.Controllers;

import com.example.eurotier.Flagger.Flagger;
import com.example.eurotier.Flagger.IFlagger;
import com.example.eurotier.TierList.TierList;
import com.example.eurotier.Tracker.hasTracker;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class NavigatorController implements hasTracker {

    private final IFlagger flagger = new Flagger();

    @FXML
    private ListView<TierList> tierListView;

    @FXML
    private ImageView imageView;

    @FXML
    private Label welcomeText;


//    private ListView<TierList> createListView() {
//        ListView<TierList> listView;
//
//        return listView;
//    }

    @FXML
    protected void onHelloButtonClick() {

        Image img = new Image(Objects.requireNonNull(getClass().getResourceAsStream(flagger.getValue("NLD"))));
        imageView.setImage(img);
        welcomeText.setText(flagger.getValue("NLD"));

    }
}