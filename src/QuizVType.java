@SuppressWarnings("unchecked")
public class QuizVType extends VType {
    
    private OtherMethod[] adders = {
        new OtherMethod("Question", new Class[] {QuestionVType.class, NumberVType.class}),
        new OtherMethod("Questions", new Class[] {TableVType.class, NumberVType.class}),
        new OtherMethod("Question", new Class[] {QuestionVType.class}),
        new OtherMethod("Group", new Class[] {TableVType.class})
    };
    
    private OtherMethod[] removers = {
        new OtherMethod("Question", new Class[] {QuestionVType.class}),
        new OtherMethod("Question", new Class[] {QuestionVType.class, NumberVType.class}),
        new OtherMethod("Questions", new Class[] {TableVType.class, NumberVType.class}),
        new OtherMethod("Question", new Class[] {NumberVType.class})
    };
    
    private Getter[] getters = {
        new Getter("name", new TextVType()),
        new Getter("groups", new TableVType())
    };

    private Setter[] setters = {
        new Setter("name", TextVType.class),
        new Setter("groups", TableVType.class)
    };
    
    private Method[] methods = {
        new Method("start", new Class[0], new NoneVType())
    };
    
    public QuizVType() {
        super("Quiz");
        super.setAdders(this.adders);
        super.setRemovers(this.removers);
        super.setGetters(this.getters);
        super.setSetters(this.setters);
        super.setMethods(this.methods);
    }
}
