public class ShortAnswerVType extends TypeVType {

    private Getter[] getters = {
        new Getter("answer", new TextVType())
    };

    private Setter[] setters = {
        new Setter("answer", TextVType.class)
    };

    public ShortAnswerVType() {
        super("ShortAnswer");
        super.setSetters(this.setters);
    }

}
