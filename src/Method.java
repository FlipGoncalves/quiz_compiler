import java.util.Arrays;

public class Method {

    private String name;
    private Class<? extends VType>[] parameters;
    private VType returnType;

    public Method(String name, Class<? extends VType>[] parameters) {
        this.name = name;
        this.parameters = parameters;
        this.returnType = null;
    }

    public Method(String name, Class<? extends VType>[] parameters, VType returnType) {
        this.name = name;
        this.parameters = parameters;
        this.returnType = returnType;
    }

    public String getName() {
        return name;
    }

    public Class<? extends VType>[] getParameters() {
        return parameters;
    }

    public VType getReturnType() {
        return returnType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + Arrays.hashCode(parameters);
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
        Method other = (Method) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (this.parameters.length != other.parameters.length)
            return false;
        for (int attrIdx = 0; attrIdx < this.parameters.length; attrIdx++)  {
            Class<?> thisParam = this.parameters[attrIdx];
            Class<?> otherParam = other.parameters[attrIdx];
            if (!thisParam.isInstance(otherParam) && !otherParam.isInstance(thisParam) && !thisParam.equals(otherParam))
                return false;
        }
        return true;
    }

    

}
