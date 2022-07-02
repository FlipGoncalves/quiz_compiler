public class TypeVType extends VType {
    
    private Getter[] getters = {
        new Getter("name", new TextVType()),
        new Getter("rightAnswer", new TextVType()),
        new Getter("options", new TableVType())     
    };

    private Setter[] setters = {
        new Setter("name", TextVType.class),
        new Setter("rightAnswer", TextVType.class),
        new Setter("options", TableVType.class)
    };

    public TypeVType(String type) {
        super(type);
        super.setAdders(null);
        super.setRemovers(null);
        super.setGetters(this.getters);
        super.setSetters(this.setters);
        super.setMethods(null);
    }

    public TypeVType(){
    	this("Type");
    }

}
