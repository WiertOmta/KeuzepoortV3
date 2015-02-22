import java.util.*;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

public class QuestionHandler {

	private ArrayList<String> questionList;
	private  int currentQuestion;

	public QuestionHandler() {
		questionList = new ArrayList<String>();
		readCSV("questions.csv");
		currentQuestion = 0;
	}

	private void readCSV(String fileName) {
		try {
		FileInputStream fis = new FileInputStream(fileName);	
		BufferedReader br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
    	String line;
       	
         	while((line = br.readLine()) != null) {
              	questionList.add(line);
           	}
      	}
      	catch(IOException e) {
          	System.out.println("IOException");
      	}
	}

	public String getNextQuestion() {
		String s = questionList.get(currentQuestion);
		currentQuestion++;
		if(currentQuestion >= questionList.size()) {
			currentQuestion = 0;
		}
		return s;
	}
}