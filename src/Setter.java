public class Setter {
    
    private String name;
    private Class<? extends VType> parameter;

    public Setter(String name, Class<? extends VType> parameter) {
        this.name = name;
        this.parameter = parameter;
    }

    public String getName() {
        return name;
    }

    public Class<? extends VType> getParameter() {
        return parameter;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((parameter == null) ? 0 : parameter.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Setter other = (Setter) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equalsIgnoreCase(other.name)) {
            return false;
        }
        if (parameter == null) {
            if (other.parameter != null) {
                return false;
            }
        } else if (!parameter.equals(other.parameter) && !parameter.isInstance(other.parameter) && !other.parameter.isInstance(parameter)) {
            return false;
        }
            
        return true;
    }
    
}


