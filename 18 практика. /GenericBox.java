public class GenericBox<T, V, K>{
    private T content;
    private K con;
    private V tent;
    public GenericBox(T content, K con, V tent){
        this.content = content;
        this.con = con;
        this.tent = tent;
    }

    public T getContent(){
        return content;
    }

    public K getCon() {
        return con;
    }

    public V getTent() {
        return tent;
    }

    public void setContent(T content) {
        this.content = content;
    }
    public String toString() {
        return content + " (" + content.getClass() + ")";
    }
}
