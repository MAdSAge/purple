package practest;

class quesion_data {
	
	
	
	String question;
    String OptionA;
    String OptionB;
    String OptionC;
    String OptionD;
    String CorrOPT;
    String Explant;
    String images;
    
	quesion_data(String question, String optionA, String optionB, String optionC, String optionD, String corrOPT,
			String explant, String images) {
		super();
		this.question = question;
		OptionA = optionA;
		OptionB = optionB;
		OptionC = optionC;
		OptionD = optionD;
		CorrOPT = corrOPT;
		Explant = explant;
		this.images = images;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOptionA() {
		return OptionA;
	}

	public void setOptionA(String optionA) {
		OptionA = optionA;
	}

	public String getOptionB() {
		return OptionB;
	}

	public void setOptionB(String optionB) {
		OptionB = optionB;
	}

	public String getOptionC() {
		return OptionC;
	}

	public void setOptionC(String optionC) {
		OptionC = optionC;
	}

	public String getOptionD() {
		return OptionD;
	}

	public void setOptionD(String optionD) {
		OptionD = optionD;
	}

	public String getCorrOPT() {
		return CorrOPT;
	}

	public void setCorrOPT(String corrOPT) {
		CorrOPT = corrOPT;
	}

	public String getExplant() {
		return Explant;
	}

	public void setExplant(String explant) {
		Explant = explant;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
	
	
	
    
    
	
	
	

}
