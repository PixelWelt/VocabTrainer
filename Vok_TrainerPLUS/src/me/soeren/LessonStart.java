package me.soeren;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class LessonStart {
    int score = 0;
    int wrongVocab = 0;
    JFrame trainer = new JFrame();
    JButton submit = new JButton("bestätigen");
    JLabel vocab = new JLabel();
    JTextField vocabInput = new JTextField("Platzhalter");
    JLabel scoreField = new JLabel(String.valueOf(score));
    JButton endtraining = new JButton("Training beenden");
    Random vocabGen = new Random();
    int nextVocab = 0;

    //endscreen
    JFrame summaryScreen = new JFrame("Zusammenfassung");
    JButton restart = new JButton("Neustarten");
    JLabel wrongStuff = new JLabel("Fehler: " + wrongVocab);
    JLabel rightStuff = new JLabel("Richtig: " + score);


    @SuppressWarnings("rawtypes")
	LessonStart(List VocabListLocal){
        JFrame m = new JFrame("VokabelTrainer v. 1.0.0 BETA"); //menu
        JButton exit = new JButton("verlassen");
        JButton start = new JButton("Start");
        JButton vokShow = new JButton("Vokabeln einsehen");
        m.setLayout(new FlowLayout());

        m.add(start);
        m.add(vokShow);
        m.add(exit);






        m.pack();
        m.setVisible(true);
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        vokShow.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                JFrame vokTable = new JFrame();
                JTable vocab = new JTable();
            }


        });
        start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                m.dispose();

                trainer.setVisible(true);
                generateVocab(VocabListLocal);
            }

        });


    }
    @SuppressWarnings("rawtypes")
	private void generateVocab(List vocabListLocal) {
        int listSize = vocabListLocal.size();
        trainer.setLayout(new FlowLayout());
        //trainer.add(submit);
        trainer.add(scoreField);
        trainer.add(vocab);
        trainer.add(vocabInput);
        trainer.add(endtraining);

        trainer.setSize(600, 400);

        System.out.println(listSize);

        System.out.println(nextVocab);

        vocab.setText((String) vocabListForeign.get(nextVocab));

        vocabInput.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("test");
                System.out.println(vocabListLocal.get(nextVocab));
                System.out.println(vocabInput.getText());

                if(vocabInput.getText().contains((CharSequence) vocabListLocal.get(nextVocab)) ) {
                    System.out.println("richtig!");
                    System.out.println(nextVocab + "richtig");
                    score ++;
                }else{
                    System.out.println("falsch");
                    System.out.println(vocabListLocal.get(nextVocab));
                    JDialog wrong = new JDialog();
                    JLabel wrongtxt = new JLabel("leider Falsch");
                    JButton next = new JButton("weiter");
                    wrong.setLayout(new GridBagLayout());
                    wrong.add(next);
                    wrong.add(wrongtxt);
                    wrong.setSize(200, 100);
                    wrong.setVisible(true);
                    System.out.println(nextVocab + "falsch");
                    wrongVocab ++;
                    next.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            wrong.dispose();


                        }
                    });

                }
                nextVocab = vocabGen.nextInt(listSize);
                System.out.println(nextVocab);
                vocab.setText((String) vocabListForeign.get(nextVocab));
                vocabInput.setText("Platzhalter");
                scoreField.setText(String.valueOf(score));
                //generateVocab(vocabListLocal, vocabListForeign);
            }

        });
        endtraining.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            summaryScreen.setLayout(new GridLayout());
            summaryScreen.add(rightStuff);
            summaryScreen.add(wrongStuff);
            
            }
        });
    }
}
