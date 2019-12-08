/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import view.GuideFrame;
import view.WelcomeFrame;

/**
 *
 * @author ASUS
 */
public class ControllerIntro implements ActionListener{
    private WelcomeFrame welcomeView;
    private GuideFrame guideView;

    public ControllerIntro() {
        welcomeView = new WelcomeFrame();
        guideView = new GuideFrame();
        guideView.setVisible(true);
        try {
            final JProgressBar ps = guideView.getjProgressBar1();
            final Timer timer = new Timer(46, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    int value = ps.getValue() + 1;
                    ps.setValue(value);
                }

            });

            ps.addChangeListener(new ChangeListener() {

                @Override
                public void stateChanged(ChangeEvent e) {
                    if (ps.getValue() == 100) {
                        timer.stop();
                    }
                }
            });
            timer.start();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        guideView.setVisible(false);
        guideView.dispose();
        welcomeView.setVisible(true);
        welcomeView.setActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if (s.equals(welcomeView.getBtn_mulai())){
            welcomeView.dispose();
            new ControllerLogin();
        }
    
    }
    
    
    
    
}
