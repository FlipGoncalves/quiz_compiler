public abstract class VType {
    
	private final String name;

	private OtherMethod[] adders = null;
    private OtherMethod[] removers = null;
    private Getter[] getters = null;
    private Setter[] setters = null;
    private Method[] methods = null;

    public VType(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public boolean subtype(VType other) {
        assert other != null;
        return name.equals(other.name());
    }

    // TODO: java reflection?
    public static VType fromString(String name) {
    	switch (name) {
			case "Table": 			return new TableVType();
			case "Type": 			return new TypeVType();
			case "ShortAnswer": 	return new ShortAnswerVType();
			case "Quiz": 			return new QuizVType();
			case "Question": 		return new QuestionVType();
			case "NumericAnswer": 	return new NumericAnswerVType();
			case "Number": 			return new NumberVType();
			case "None": 			return new NoneVType();
			case "MultipleChoice": 	return new MultipleChoiceVType();
			case "Matching": 		return new MatchingVType();
			case "Integer": 		return new IntegerVType();
			case "Essay": 			return new EssayVType();
			case "Double": 			return new DoubleVType();
			case "BQuest": 			return new BQuestVType();
			case "Group": 		return new GroupVType();
		}

		return null;
	}

	protected void setAdders(OtherMethod[] adders) {
		this.adders = adders;
	}

	protected void setRemovers(OtherMethod[] removers) {
		this.removers = removers;
	}

	protected void setGetters(Getter[] getters) {
		this.getters = getters;
	}

	protected void setSetters(Setter[] setters) {
		this.setters = setters;
	}

	protected void setMethods(Method[] methods) {
		this.methods = methods;
	}

	public OtherMethod[] getAdders() {
		return adders;
	}

	public OtherMethod[] getRemovers() {
		return removers;
	}

	public Getter[] getGetters() {
		return getters;
	}

	public Setter[] getSetters() {
		return setters;
	}

	public Method[] getMethods() {
		return methods;
	}

	@Override
	public String toString() { return name(); }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VType other = (VType) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
