@SuppressWarnings("unchecked")
public class TextVType extends VType {
    
    private Method[] methods = {
        new Method("toNumber", (Class<? extends VType>[]) new Class[0], new NumberVType()) 
    };

    public TextVType() {
        super("Text");
        super.setAdders(null);
        super.setRemovers(null);
        super.setGetters(null);
        super.setSetters(null);
        super.setMethods(this.methods);
    }

}
