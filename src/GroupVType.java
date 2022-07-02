public class GroupVType extends VType {
    
    private static Getter[] getters = {
        new Getter("Questions", new TableVType())
    };

    private static Setter[] setters = {
        new Setter("Questions", TableVType.class)
    };
    
    public GroupVType() {
        super("Group");
        super.setGetters(getters);
        super.setSetters(setters);
        super.setAdders(null);
        super.setRemovers(null);
        super.setMethods(null);
    }

}
