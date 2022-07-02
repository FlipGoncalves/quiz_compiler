@SuppressWarnings("unchecked")
public class NumberVType extends VType {
    
    public NumberVType() {
        this("Number");
    }

    public NumberVType(String nameNumber) {
        super(nameNumber);
        super.setAdders(null);
        super.setRemovers(null);
        super.setGetters(null);
        super.setSetters(null);
        super.setMethods(null);
    }

    @Override
    public Method[] getMethods() {
        return new Method[] {new Method("toString", (Class<? extends VType>[]) new Class[0], new TextVType())};
    }

}
