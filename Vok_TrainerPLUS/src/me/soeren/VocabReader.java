package me.soeren;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

public class VocabReader {
    List<String> VocabListLocal = new ArrayList<>();
    List<String> VocabListForeign = new ArrayList<>();
    String VocabFile = null;

    private void readFile() {
        boolean ao = false; //already opened
        BufferedReader ConfigReader = null;
        FileWriter configCreator = null;

        if(ao) {
            try {
                ConfigReader = new BufferedReader(new FileReader("config.conf"));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                VocabFile =	ConfigReader.readLine();
            } catch (IOException e) {

                e.printStackTrace();
            }


        }else{
            JFileChooser ChooseVocabFile = new JFileChooser();
            int ChooserReturn = ChooseVocabFile.showDialog(null, "wähle deine Vokabelliste aus");
            if(ChooserReturn == ChooseVocabFile.APPROVE_OPTION) {
                VocabFile = ChooseVocabFile.getSelectedFile().getAbsolutePath();

                System.out.println(VocabFile);
                try {
                    configCreator = new FileWriter("config.conf");
                    configCreator.write(VocabFile);

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                readData(VocabFile);
            }else {
                System.out.println("Vorgang abgebrochen");
            }

        }
    }

    private void readData(String vocabFile) {

        BufferedReader vocabReader = null;
        try {
            vocabReader = new BufferedReader(new FileReader(vocabFile));
        } catch (FileNotFoundException e0) {
            // TODO Auto-generated catch block
            e0.printStackTrace();
        }
        String thisLine;
        try {
            while ((thisLine = vocabReader.readLine()) != null) { // while loop begins here

                System.out.println(thisLine);
                String[] platzhalter = thisLine.split(";");
                if(platzhalter[0].contains("Substantiv")) {
                	if(platzhalter[0]!=null) {
	                    this.VocabListLocal.add(platzhalter[0]);
	                }else {
	                    System.out.println("ERROR!");
	                }
	
	                if(platzhalter[1]!=null) {
	                    this.VocabListForeign.add(platzhalter[1]);
	                }else {
	                    System.out.println("ERROR!");
	                }
	                
	
	                if(platzhalter[2]!=null) {
	                    this.VocabListForeign.add(platzhalter[2]);
	                }else {
	                    System.out.println("ERROR!");
	                }
                }else if(platzhalter[0].contains("Verb")) {
                	
                }else {
                	
                }
	                

            }
            new LessonStart(VocabListLocal, VocabListForeign);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // end while
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        final VocabReader myClass = new VocabReader();
        myClass.readFile();
    }
}




