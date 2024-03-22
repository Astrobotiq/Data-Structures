public class HashTable {
    public int capacity;
    public int elementSize;
    MyInteger[] table;
    double loadFactor=elementSize / capacity;


    public HashTable(int capacity) {
        this.capacity = capacity;
        this.elementSize = 0;
        table = new MyInteger[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getElementSize() {
        return elementSize;
    }

    public void setElementSize(int elementSize) {
        this.elementSize = elementSize;
    }

    // Adding new value
    public void insert(int x){
        int index=hashFunction(x);

        if(table[index]==null){
            table[index]= new MyInteger(x);
            elementSize++;
        }
        else{
            MyInteger newMyInteger=new MyInteger(x);
            newMyInteger.next= table[index];
            table[index]=newMyInteger;
            elementSize++;
        }
        rehash();
    }

    // Searching a value in hash table
    public boolean contains(int x)
    {
        int index=hashFunction(x);
        if(table[index]!=null){
            if(table[index].value==x)
                return true;
            else{
                while(table[index].next!=null){
                    if(table[index].next.value==x)
                        return true;

                }
            }

        }
        return false; // Return TRUE if you find the value in hash table
    }

    // Printing all values
    public void printTable() {
        for(int i=0;i<= table.length;i++){
            System.out.print(table[i].value+" ");
            MyInteger start=table[i];
            while(start.next!=null){
                System.out.print(start.value+" ");
                start=start.next;


            }
        }

    }

    // Hash function
    private int hashFunction(int x)
    {int hashValue=x % capacity;
        return hashValue;
    }

    // Rehashing the hashtable
    private void rehash()
    {if(loadFactor>= 3){
        MyInteger [] tempTable=table;
        capacity*=2;
        table = new MyInteger[capacity];

        for(int i=0;i<=tempTable.length;i++){
            if(tempTable[i]==null){
                continue;
            }
            else {
                MyInteger temp;
                insert(tempTable[i].value);
                while (tempTable[i].next != null) {
                    temp=tempTable[i];
                    tempTable[i].next=tempTable[i].next.next;
                    insert(temp.value);
                }
            }
        }

    }
        // TODO: Implement rehashing when it is needed (load factor value is important!)
    }
}
