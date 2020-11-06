package controller;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;

public class WebViewController {
    @FXML
    private WebView webView;

    public void initialize(){
        WebEngine engine = webView.getEngine();
        engine.load("http://facebook.com");
    }
}
