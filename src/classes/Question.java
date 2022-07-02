package classes;

public class Question{

	private Type questionType;
	private String content;	//Enunciado
	private String theme;
	private Difficulty difficulty;

	public Question() {
		this(null, "", "", Difficulty.EASY); //Predefined
	}

	public Question(Type questionType, String content, String theme, int difficulty) {
		this(questionType, content, theme, Difficulty.fromNum(difficulty));
	}

	public Question(Type questionType, String content, String theme, Difficulty difficulty) {
		this.questionType = questionType; 
		this.content = content;
		this.theme = theme;
		this.difficulty = difficulty;
	}

	public Type getType() {
		return questionType;
	}

	public void setType(Type questionType) {
		this.questionType = questionType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Integer getDifficulty() {
		return difficulty.getDiff();
	}

	public void setDifficulty(int diff) {
		this.difficulty = Difficulty.fromNum(diff);
	}

	public String getRightAnswer() {
		return questionType.getRightAnswer();
	}

	public boolean validateAnswer(String input) {
		return questionType.validateAnswer(input);
	}

	public boolean isValidQuestion() {
		if (questionType == null || content.isEmpty() || theme.isEmpty())
			return false;
		if (getRightAnswer().isEmpty() || getRightAnswer() == null)
			return false;

		return true;
	}

	@Override
	public String toString() {
		return content + "\n" + questionType;
	}
}
