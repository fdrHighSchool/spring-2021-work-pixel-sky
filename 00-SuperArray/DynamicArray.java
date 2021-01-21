/**
 * DynamicArray
 */
@SuppressWarnings("unchecked")
public class DynamicArray<T> {

    private T[] array;          // storing the values
    private int length = 0;     // the length that the user would see
    private int capacity;       // the actual capacity of the array

    // default constructor
    public DynamicArray() {
        this(10);           // pass default size 10 to the constructor
    }

    public DynamicArray(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException(String.format("Illegal Capacity: %d. Capacity cannot be less than 0.", capacity));
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity]; 
    }

    // grow the array by a certain size
    public void grow(int growSize) {
        if (growSize < 1) throw new IllegalArgumentException(String.format("Illegal grow size: %d. Grow size must be bigger than 0", growSize));
        this.capacity += growSize;  // increment the capacity
        T[] newArray = (T[]) new Object[this.capacity];     // cast Object array to T array
        for (int i = 0; i < this.length; i++) newArray[i] = this.array[i];  // copying over all the data from the old array to the new one
        this.array = newArray;  // set the array to the new array
    }
    
    // add data to the end of the array
    public void add(T value) {
        // if there are no room for the new data
        if (this.length + 1 > this.capacity) {
            if (this.capacity == 0) this.capacity = 1;  
            else this.capacity *= 2;
            
            T[] newArray = (T[]) new Object[this.capacity];     // cast Object array to T array
            
            for (int i = 0; i < this.length; i++) newArray[i] = this.array[i];  // copying all the data from old array to the new one
            this.array = newArray;  // set the array to the new array
        }
        
        this.array[this.length++] = value;  // add the value to the end then increment length
    }

    // insert data to a certain index
    public void add(int index, T value) {
        if (index < 0 || index > this.length - 1) throw new IndexOutOfBoundsException(String.format("Index %d out of bounds for length %d", index, this.length));
        
        if (this.capacity == 0) this.capacity = 1;
        else if (this.length + 1 > this.capacity) this.capacity *= 2;   // if there are no room for the new data, double the capacity
        
        T[] newArray = (T[]) new Object[this.capacity];     // cast Object array to T array

        int i = 0;
        // copying all the data but skip the index of the value to be added
        while (i < this.length) {
            // while i is less than the index
            if (i < index) newArray[i] = this.array[i++];   // newArray at index i equal to index i++(current index) of the old array, then i++
            else newArray[++i] = this.array[i - 1];         // newArray at index ++i(next index) equal to index i - 1(previous index or the index before ++i) of old array
        }
        this.array = newArray;  // set the array to the new array
        set(index, value);      // fill the skiped index
        this.length++;          // increment the lenght
    }

    // set the value at a specific index
    public void set(int index, T value) {
        this.array[index] = value;
    }
    
    // remove value at a specific index
    public T removeAt(int index) {
        if (index < 0 || index > this.length - 1) throw new IndexOutOfBoundsException(String.format("Index %d out of bounds for length %d", index, this.length));
        
        T data = this.array[index];

        // if not the last item
        if (!(index == this.length - 1)) {
            T[] newArray = (T[]) new Object[capacity];
            
            int i = 0;
            // copying all the data from old array to the new one, except the deleted one
            while (i < this.length - 1) {
                // while i is less than the index
                if (i < index) newArray[i] = this.array[i++];   // newArray at index i equal to index i++(current index) of the old array, then i+1
                else newArray[i] = this.array[++i];             // newArray at index i equal to index ++i(next index) of the old array 
            }
            
            this.array = newArray;  // set the array to the new array
        }
        
        this.length--;  // reduce the length
        return data;    // return the deleted data
    }
    
    // remove the first instance of the value
    public boolean remove(T value) {
        int index = indexOf(value);     // get the index of the value
        if (index == -1) return false;  // if the value does not exist in the array, return false
        removeAt(index);    // if the value do exist, pass the index to removeAt()
        return true;        // if nothing failed, return true
    }
    
    // return the index of the first value that matches
    public int indexOf(Object value) {
        for (int i = 0; i < this.length; i++) {
            if (value.equals(this.array[i])) return i;  // if found, return the index
        }
        return -1;  // -1 if not found
    }

    // get the value at the index
    public T get(int index) {
        return array[index];
    }
    
    // return the size of the array (length of the array)
    public int size() {
        return this.length;
    }

    // is the array empty
    public boolean isEmpty() {
        return size() == 0;
    }
    
    // return if the array contain the value
    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    // empty the array
    public void clear() {
        for (int i = 0; i < this.length; i++) array[i] = null;
        this.length = 0;
    }
    
    @Override
    public String toString() {
        if (this.length == 0) return "[]";      // if array is empty, then return []
        else {
            StringBuilder str = new StringBuilder().append("[");    // append open bracket
            for (int i = 0; i < this.length - 1; i++) str.append(this.array[i] + ", "); // append all the values + ", ", until the second last one
            return str.append(this.array[this.length - 1] + "]").toString();    // append the last value + closing bracket and return
        }
    }
}