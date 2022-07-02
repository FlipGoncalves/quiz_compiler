public class QuestionVType extends VType {
    
    private Getter[] getters = {
        new Getter("type", new TypeVType()),
        new Getter("content", new TextVType()),
        new Getter("theme", new TextVType()),
        new Getter("difficulty", new NumberVType())
    };

    private Setter[] setters = {
        new Setter("type", TypeVType.class),
        new Setter("content", TextVType.class),
        new Setter("theme", TextVType.class),
        new Setter("difficulty", IntegerVType.class)
    };
    
    private VType questionType;

    public QuestionVType() {
        super("Question");
        super.setAdders(null);
        super.setRemovers(null);
        super.setGetters(this.getters);
        super.setSetters(this.setters);
        super.setMethods(null);
        this.questionType = null;
    }

    public QuestionVType(VType questionType) {
        super("Question");
        super.setAdders(null);
        super.setRemovers(null);
        super.setGetters(this.getters);
        super.setSetters(this.setters);
        super.setMethods(null);
        this.questionType = questionType;
    }

    public VType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(VType questionType) {
        this.questionType = questionType;
    }
    
}
