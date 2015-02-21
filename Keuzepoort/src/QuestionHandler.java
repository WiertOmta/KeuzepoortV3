import java.util.*;

public class QuestionHandler {

	private ArrayList<String> questionList;
	private  int currentQuestion;

	public QuestionHandler() {
		questionList = new ArrayList<String>();
		readCSV("questions.csv");
		currentQuestion = 0;
	}

	private void readCSV(String fileName) {
		FileInputStream fis = new FileInputStream(fileName);	
		BufferedReader br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
    	String line;
       	try {
         	while((line = br.readLine()) != null) {
              	questionList.add(line);
           	}
      	}
      	catch(IOException e) {
          	System.out.println("IOException");
      	}
        catch(FileNotFoundException e)
        {
            System.out.println("File not found!");
        }
	}

	public String getNextQuestion() {
		String s = questionList[currentQuestion];
		currentQuestion++;
		return s;
	}
}