/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Artist;
import model.Audience;
import model.DatabaseHandler;
import view.AudienceFrame;
import view.LoginFrame;
import view.RegisterFrame;

/**
 *
 * @author ASUS
 */
public class ControllerRegister implements ActionListener{
 private RegisterFrame registerView;
    private DatabaseHandler db;
    
    public ControllerRegister(){
        registerView = new RegisterFrame();
        registerView.addActionListener(this);
        registerView.setVisible(true);
        db = new DatabaseHandler();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object s = ae.getSource();
        
        if (s.equals(registerView.getBtn_regis_artist())){
            String nama = registerView.getTf_regis_nama();
            String email = registerView.getTf_regis_email();
            String password = registerView.getTf_regis_pass();
         
            Artist a = new Artist(nama, email, password);
            db.addArtist(a);
            
            registerView.dispose();
            new ControllerLogin();

        } else if (s.equals(registerView.getBtn_regis_audience())){
            String nama = registerView.getTf_regis_nama();
            String email = registerView.getTf_regis_email();
            String password = registerView.getTf_regis_pass();
         
            Audience a = new Audience(nama, email, password);
            db.addAudience(a);
           
            registerView.dispose();
            new ControllerLogin();
            
        } else if (s.equals(registerView.getBtn_move_masuk())){
            registerView.setVisible(false);
            
            registerView.dispose();
            new ControllerLogin();

        }
    }
}
