import java.util.ArrayList;

public class DataContainer<T> {

    private ArrayList<T> data = new ArrayList<T>(0);

    /**
     * gets the size of the ArrayList
     * @return
     */
    public int size(){
        return data.size();
    }

    /**
     * adds a new object
     * @param object
     */
    public void add(T object){
        data.add(object);
    }

    /**
     * gets an object from a specific position
     * @param id
     * @return
     */
    public T getObject(int id){
        return data.get(id);
    }

    /**
     * sets an object on a specific position
     * @param id
     * @param object
     */
    public void setObject(int id, T object){
        data.set(id, object);
    }

    /**
     * Deletes an object on a specific position
     * @param id
     */
    public void deleteObject(int id) {
        data.remove(id);
    }

    /**
     * Prints all objects of the ArrayList
     */
    public void printAll() {
        for (T t : data) {
            System.out.println(t);
        }
    }

}
