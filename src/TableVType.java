@SuppressWarnings("unchecked")
public class TableVType extends VType {

    private VType elemType;

    private Method[] methods = {
        new Method("size", new Class[0], new IntegerVType())
    };

    public TableVType() {
        super("Table");
        super.setAdders(null);
        super.setRemovers(null);
        super.setGetters(null);
        super.setSetters(null);
        super.setMethods(this.methods);
    }

    public VType getElemType() {
        return elemType;
    }

    public void setElemType(VType elemType) {
        this.elemType = elemType;
    }

    @Override
    public OtherMethod[] getAdders() {
        if (this.elemType != null)
            return new OtherMethod[] {
                new OtherMethod(null, new Class[] {this.elemType.getClass()}) 
            };
        else
            return null;
    }

    @Override
    public OtherMethod[] getRemovers() {
        if (this.elemType != null)
            return new OtherMethod[] {
                new OtherMethod(null, new Class[] {this.elemType.getClass()}) 
            };
        else
            return null;
    }

}
