import java.util.Arrays;

public class OtherMethod {
    
    private String name;
    private Class<? super VType>[] parameters;
    
    public OtherMethod(String name, Class<? super VType>[] parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    public String getName() {
        return this.name;
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
        OtherMethod other = (OtherMethod) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equalsIgnoreCase(other.name))
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
