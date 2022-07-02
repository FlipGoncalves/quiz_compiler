public class NumericAnswerVType extends TypeVType {
    
    private Getter[] getters = {
        new Getter("answer", new NumberVType())
    };
    
    public NumericAnswerVType() {
        super("NumericAnswer");
        super.setGetters(getters);
    }
}
