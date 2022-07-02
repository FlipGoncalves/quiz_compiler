public abstract class Symbol {
    protected final String id;
    protected VType type;
    protected boolean init = false;

    protected int size;
    protected VType elementsType;
    
    public Symbol(String id, VType type, boolean init) {
        assert id != null;
        assert type != null;

        this.id = id;
        this.type = type;
        this.init = init;

        // Variable for tables
        this.size = 0;  
        this.elementsType = new NoneVType();
        
    }

    public void setInit(boolean init) {
        this.init = init;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setElementsType(VType type) {
        this.elementsType = type;
    }

    public void setType(VType type) {
        this.type = type;
    }

    public String id() {
        return id;
    }

    public VType type() {
        return type;
    }

    public int size() {
        return size;
    }
    
    public VType elementsType() {
        return elementsType;
    }

    public boolean init() {
        return init;
    }
}

// public abstract class Symbol<T> {
//     protected final String name;
//     protected final VType type;
//     protected T value;
    
//     public Symbol(String name, VType type) {
//         assert name != null;
//         assert type != null;

//         this.name = name;
//         this.type = type;
//     }

//     public void setValue(T value) {
//         assert value != null;

//         this.value = value;
//     }

//     public String name(){
//         return name;
//     }

//     public VType type(){
//         return type;
//     }

//     public T value(){
//         return value;
//     }
// }

