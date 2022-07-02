public class MatchingVType extends TypeVType {
    
    private static Getter[] getters = {
        new Getter("answer", new TableVType()),
        new Getter("opetions", new TableVType())
    };

    private static Setter[] setters = {
        new Setter("name", TextVType.class),
        new Setter("answer", TableVType.class)
    };
    
    public MatchingVType() {
        super("Matching");
        super.setSetters(setters);
        super.setGetters(getters);
    }
    
}
