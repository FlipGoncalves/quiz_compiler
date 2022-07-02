public class MultipleChoiceVType extends TypeVType {
    
    private static Getter[] getters = {
        new Getter("answer", new NumberVType()),
        new Getter("options", new TableVType())
    };

    private static Setter[] setters = {
        new Setter("name", TextVType.class),
        new Setter("answer", IntegerVType.class)
    };
    
    public MultipleChoiceVType() {
        super("MultipleChoice");
        super.setSetters(setters);
        super.setGetters(getters);
    }

}
