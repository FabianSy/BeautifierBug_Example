import org.hybridlabs.source.beautifier.JavaImportBeautifierImpl;

import java.io.File;
import java.io.FileReader;


public class BeautifierBug{

    public static void main(String[] args) {
                
        File file;
        FileReader fr;
        String inputFile = "";
        try{
            file = new File("doc/TestDateColumn_vorBeautifier.txt");
            fr = new FileReader(file);
            
            int len = (int)file.length() ;
            char[] buffer = new char[len] ;       
            
            fr.read(buffer, 0, len);
            inputFile = new String(buffer);
        }
         catch (Exception e) {
            e.printStackTrace();
        }
          
        JavaImportBeautifierImpl javaImportBeautifier = new JavaImportBeautifierImpl();
        javaImportBeautifier.setFormat(true);   //set to false to avoid bug
        javaImportBeautifier.setOrganizeImports(true);        
        
        org.hybridlabs.source.beautifier.CharacterSequence seq = new org.hybridlabs.source.beautifier.CharacterSequence(inputFile);
        javaImportBeautifier.beautify(seq);
        
        System.out.println(seq);
        
    }

      
    
}
