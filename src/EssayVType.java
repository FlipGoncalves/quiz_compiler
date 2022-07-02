public class EssayVType extends TypeVType {
    
    private static Getter[] getters = {
        new Getter("answer", new TextVType())
    };

    private static Setter[] setters = {
        new Setter("answer", TextVType.class)
    };
    
    public EssayVType() {
        super("Essay");
        super.setGetters(getters);
        super.setSetters(setters);
    }

}
