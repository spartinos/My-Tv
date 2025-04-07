package gui;

import api.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchResults extends JFrame {

    private ArrayList<Production> productions;
    private UserSystem userSystem;
    private AdminSystem adminSystem;
    private static JLabel success;
    private static JLabel totalReviews;
    private static JLabel totalAvgScore;
    private static JLabel title;
    private static JLabel descr;
    private static JLabel suitable;
    private static JLabel avgScore;
    private static JLabel firstScreen;
    private static JLabel dur;
    private static JLabel kind;
    private static JLabel cast;
    private static JButton closePageButton;
    private static JLabel empty;
    private static JPanel panel;
    private static JPanel panel2;
    private static JButton view;
    public SearchResults(UserSystem userSystem, ArrayList<Production> productions){
        this.userSystem = userSystem;
        this.productions = productions;
    }
    public SearchResults(AdminSystem adminSystem, ArrayList<Production> productions){
        this.adminSystem = adminSystem;
        this.productions = productions;
    }

    public void closeButton(){
        setVisible(false);
    }
    public void emptyLabel(){
        success.setText("No results");
    }
    public void makeResults(){
        //create JFrame
        setTitle("Search results page");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new GridLayout(2,1));

        //make panel1
        panel = new JPanel();
        TitledBorder border = BorderFactory.createTitledBorder("Productions");
        panel.setBorder(border);

        //make panel2
        panel2 = new JPanel();
        TitledBorder border2 = BorderFactory.createTitledBorder("Stats");
        panel2.setBorder(border2);

        int k=0;
        //make and add labels on panels
        if (userSystem==null){
            if(productions.size()!=0) {
                for (Production p : productions) {
                    if (p instanceof Show)
                        break;
                    Movie a = (Movie) p;
                    k++;
                    title = new JLabel("    " + a.getTitle());
                    descr = new JLabel("  " + a.getDescription());
                    if (a.getAppropriation()) suitable = new JLabel("Appropriate");
                    else suitable = new JLabel("Not Appropriate");
                    firstScreen = new JLabel("   "+a.getDateOfRelease());
                    kind = new JLabel(" "+a.getGenre());
                    dur = new JLabel("  "+ String.valueOf(a.getDuration()));
                    cast = new JLabel("  "+a.getCast());
                    avgScore = new JLabel("      Avg score: " + a.averageScore());
                    view=new JButton("view");

                    panel.add(title);
                    panel.add(descr);
                    panel.add(suitable);
                    panel.add(firstScreen);
                    panel.add(kind);
                    panel.add(dur);
                    panel.add(cast);
                    panel.add(avgScore);
                    panel.add(view);
                    view.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Reviews r = new Reviews(a, adminSystem);
                            r.makeR();
                        }
                    });
                }
            } if (productions.size()!=0) {
                for (Production p : productions) {
                    if (p instanceof Movie)
                        break;
                    Show a = (Show) p;
                    k++;
                    title = new JLabel("    " + a.getTitle());
                    descr = new JLabel("     " + a.getDescription());
                    if (a.getAppropriation()) suitable = new JLabel("Appropriate");
                    else suitable = new JLabel("Not Appropriate");
                    firstScreen = new JLabel("-");
                    dur = new JLabel(" - ");
                    kind = new JLabel("   "+a.getGenre());
                    cast = new JLabel("     " + a.getCast());
                    avgScore = new JLabel("       Avg score: " + a.averageScore());
                    view = new JButton("view");

                    panel.add(title);
                    panel.add(descr);
                    panel.add(suitable);
                    panel.add(firstScreen);
                    panel.add(kind);
                    panel.add(dur);
                    panel.add(cast);
                    panel.add(avgScore);
                    panel.add(view);
                    view.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Reviews r = new Reviews(a, adminSystem);
                            r.makeR();
                        }
                    });

                }
            }}

        if(adminSystem==null){
            if(productions.size()!=0) {
                for (Production p : productions) {
                    if (p instanceof Show)
                        break;
                    Movie a = (Movie) p;
                    k++;
                    title = new JLabel("    " + a.getTitle());
                    descr = new JLabel("  " + a.getDescription());
                    if (a.getAppropriation()) suitable = new JLabel("Appropriate");
                    else suitable = new JLabel("Not Appropriate");
                    firstScreen = new JLabel("   "+a.getDateOfRelease());
                    kind = new JLabel(" "+a.getGenre());
                    dur = new JLabel("  "+ String.valueOf(a.getDuration()));
                    cast = new JLabel("  "+a.getCast());
                    avgScore = new JLabel("      Avg score: " + a.averageScore());
                    view=new JButton("view");

                    panel.add(title);
                    panel.add(descr);
                    panel.add(suitable);
                    panel.add(firstScreen);
                    panel.add(kind);
                    panel.add(dur);
                    panel.add(cast);
                    panel.add(avgScore);
                    panel.add(view);
                    view.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Reviews r = new Reviews(a, userSystem);
                            r.makeR();
                        }
                    });
                }
            } if (productions.size()!=0) {
                for (Production p : productions) {
                    if (p instanceof Movie)
                        break;
                    Show a = (Show) p;
                    k++;
                    title = new JLabel("    " + a.getTitle());
                    descr = new JLabel("     " + a.getDescription());
                    if (a.getAppropriation()) suitable = new JLabel("Appropriate");
                    else suitable = new JLabel("Not Appropriate");
                    firstScreen = new JLabel("-");
                    dur = new JLabel(" - ");
                    kind = new JLabel("   "+a.getGenre());
                    cast = new JLabel("     " + a.getCast());
                    avgScore = new JLabel("       Avg score: " + a.averageScore());
                    view = new JButton("view");

                    panel.add(title);
                    panel.add(descr);
                    panel.add(suitable);
                    panel.add(firstScreen);
                    panel.add(kind);
                    panel.add(dur);
                    panel.add(cast);
                    panel.add(avgScore);
                    panel.add(view);
                    view.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Reviews r = new Reviews(a, userSystem);
                            r.makeR();
                        }
                    });

                }
            }}


        if(k==0){emptyLabel();}

        //make close button and add on panel2
        closePageButton=new JButton("back");
        panel2.add(closePageButton);
        //action listener for close button
        closePageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {closeButton();}
        });

        //set layout
        GridLayout layout = new GridLayout(k,10);
        panel.setLayout(layout);
        if(k>=2)panel2.setLayout(layout);
        else panel2.setLayout(new GridLayout(2,1));

        //add panels
        add(panel);
        add(panel2);

        pack();
        setVisible(true);
    }
}
