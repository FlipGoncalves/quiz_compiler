public class BQuestVType extends VType {
    
    private Getter[] getters = {
        new Getter("question", new QuestionVType()),
        new Getter("questions", new TableVType())
    };
    
    public BQuestVType() {
        super("BQuest");
        super.setGetters(this.getters);
        super.setAdders(null);
        super.setRemovers(null);
        super.setMethods(null);
    }
    
}
