public class Set {
    private int[] array;
    private int counter;

    public Set() {
        this.array = new int[10];
        this.counter = 0;
    }

    public Set(int size) {
        this.array = new int[size];
        this.counter = 0;
    }

    public Set(int[] numbers) {
        this.array = new int[numbers.length];
        this.counter = 0;
        for (int number : numbers) {
            if (!contains(number)) {
                this.array[counter] = number;
                this.counter++;
            }
        }
    }

    public boolean add(int value) {
        if (!contains(value)) {
            if (counter == array.length) {
                int[] temp = new int[array.length * 2];
                for (int i = 0; i < array.length; i++) {
                    temp[i] = array[i];
                }
                array = temp;
            }
            array[counter] = value;
            counter++;
            return true;
        }
        return false;
    }

    public boolean remove(int value) {
        for (int i = 0; i < counter; i++) {
            if (array[i] == value) {
                for (int j = i; j < counter - 1; j++) {
                    array[j] = array[j + 1];
                }
                counter--;
                return true;
            }
        }
        return false;
    }

    public boolean contains(int value) {
        for (int i = 0; i < counter; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    public Set(Set other) {
        this.counter = other.counter;
        this.array = new int[other.array.length];
        for (int i = 0; i < other.counter; i++) {
            this.array[i] = other.array[i];
        }
    }

    public boolean equals(Set other){
        if(this.counter != other.counter){
            return false;
        }
        for(int i=0;i<this.counter;i++){
            if(this.contains(this.array[i])){
                return false;
            }
        }
        return true;
    }

    public Set union(Set other){
        Set resolt = new Set();

        for(int i=0;i<this.counter;i++){
            resolt.add(this.array[i]);
        }
        for(int i=0;i<other.counter;i++){
            resolt.add(other.array[i]);
        }
        return resolt;
    }

    public Set intersect(Set other) {
        Set full = new Set();
        for (int i = 0; i < this.counter; i++) {
            if (other.contains(this.array[i])) {
                full.add(this.array[i]);
            }
        }
        return full;
    }

    public boolean subSet(Set other){
        if(this.counter>other.counter){
            for(int i=0;i<this.counter;i++){
                if(other.contains(this.array[i])){
                    return false;
                }
            }
        }
        return true;
    }

    public int[] toArray(){
        int[]arrays = new int [this.counter];
        for(int i=0;i<this.counter;i++){
            arrays[i] = this.array[i];
        }
        return arrays;
    }

    public Set subTract(Set other){
        Set sub = new Set();
        for(int i=0;i<this.counter;i++){
            if(this.contains(this.array[i])){
                sub.add(this.array[i]);
            }
        }
        return sub;
    }
}