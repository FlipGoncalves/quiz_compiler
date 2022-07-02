public enum Types{
    CString ("Text"),
    Cvoid ("None"),
    CList ("Table"),
    CBQuest("BQuest"),
    CInteger("Integer"),
    CDouble("Double"),
    Cint("Integer"),
    CQuiz("Quiz"),
    CQuestion("Question"),
    CType("Type"),
    CBoolean("Boolean"),
    CGroup("Group"),
    CArrayList("Table"),
    CDifficulty("Difficulty");
    private final String convertion;
    Types(String type){
    	this.convertion = type;
    }
    public String getValue(){
    	return convertion;
    }
}
