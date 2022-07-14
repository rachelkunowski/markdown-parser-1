//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.net.SocketPermission;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) throws InterruptedException {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        int openBracket=0,openParen=0,closeBracket=0,closeParen=0;
        ArrayList<String> check = new ArrayList<>();
        do {
            check = new ArrayList<>();
            if (markdown.indexOf("[", currentIndex)!=-1){
                openBracket = markdown.indexOf("[", currentIndex);
            }
            else{
                break;
            }
            if (markdown.indexOf("]", openBracket)!=-1){
                closeBracket = markdown.indexOf("]", openBracket);
            }
            else{
                break;
            }
            if(markdown.indexOf("]", openBracket)!=-1){
                closeBracket = markdown.indexOf("]", openBracket);
            }
            else{
                break;
            }
            if(markdown.indexOf("(", closeBracket)!=-1){
                openParen = markdown.indexOf("(", closeBracket);
            }
            else{
                break;
            }
            if(markdown.indexOf(")", openParen)!=-1){
                closeParen = markdown.indexOf(")", openParen);
            }
            else{
                break;
            }

            for (int i=0; i<toReturn.size();i++){
                check.add(toReturn.get(i));
            }
            if(openParen-closeBracket<2&&closeParen>openParen){
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }
            currentIndex = closeParen+1 ;
        }
        while(currentIndex < markdown.length()&& !(toReturn.equals(check)));
  

        return toReturn;
    }


    public static void main(String[] args) throws IOException ,InterruptedException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
        System.out.println(links);
    }
}