/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Audience;
import model.DatabaseHandler;
import view.ArtistFrame;
import view.AudienceFrame;
import view.LoginFrame;
import view.RegisterFrame;

/**
 *
 * @author ASUS
 */
public class ControllerLogin implements ActionListener{
    private LoginFrame loginView;
    private DatabaseHandler db;
    
    public ControllerLogin(){
        loginView = new LoginFrame();
        loginView.addActionListener(this);
        loginView.setVisible(true);
        db = new DatabaseHandler();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object s = ae.getSource();
        
        if (s.equals(loginView.getBtn_login_audience())){
            String email = loginView.getTf_login_email();
            String password = loginView.getTf_login_pass();
            
            String validity = db.loginValidity("audience", email, password);
            if (validity == null){
               loginView.showMessageDialog("Username atau password salah");
            } else {
                loginView.dispose();
                new ControllerPlaylist(validity);
            }
            
        } else if (s.equals(loginView.getBtn_login_artist())){
            String email = loginView.getTf_login_email();
            String password = loginView.getTf_login_pass();
            
            String validity = db.loginValidity("artis", email, password);
            if (validity == null){
               loginView.showMessageDialog("Username atau password salah");
            } else {
                loginView.dispose();
                new ControllerAlbum(validity);
            }
            
        } else if (s.equals(loginView.getBtn_move_daftar())){
            loginView.setVisible(false);
        
            loginView.dispose();
            new ControllerRegister();

        }
    }
}
