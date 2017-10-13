/*
 * Author: Joshua Getega, jgetega@gmail.com
 * - These methods are my solutions to coding exercises in Ch. 18 of "Building Java Programs" by 
 * Stuart Reges and Marty Stepp
 * - Methods to be added to the HashIntSet Class at 
 * https://practiceit.cs.washington.edu/problems/bjp3/chapter18/HashIntSet.java
 * - Include in a HashIntSet Class to compile
 * 
*/ 


//Accepts another HashIntSet as a parameter
//Returns true if this set contains every element from the other set; false otherwise
public Boolean containsAll(HashIntSet s2) {
      int s2length = s2.elementData.length;
      for (int i = 0; i < s2length; i++) {
            Node current = s2.elementData[i];
            while (current != null) {
                  if (!(contains(current.data))) {
                        return false;
                    }
                  current = current.next;
              }
        }
      return true;
}

//Accepts another HashIntSet as a parameter
//Adds all elements from that set into the current set
public void addAll(HashIntSet s2) {
      int s2length = s2.elementData.length;
      for (int i = 0; i < s2length; i++) {
            Node current = s2.elementData[i];
            while (current != null) {
                  add(current.data);
                  current = current.next;
              }
        }
}

//Accepts another object as a parameter
//Returns true if the object is another HashIntSet that contains exactly the same elements
public boolean equals(Object o) {
      if (o instanceof HashIntSet) {
            HashIntSet s2 = (HashIntSet) o;
            if (this.size == s2.size) {
                  int s2length = s2.elementData.length;
                  for (int i = 0; i < s2length; i++) {
                        Node current = s2.elementData[i];
                        while (current != null) {
                              if (!(contains(current.data))) {
                                    return false;
                                }
                              current = current.next;
                          }
                    }
                  return true;
              } else {
                    return false;
                }
          }
      return false;
}

//Accepts another HashIntSet as a parameter
//Ensures that this set does not contain any of the elements from the other set
public void removeAll(HashIntSet s2) {
      int s2length = s2.elementData.length;
      for (int i = 0; i < s2length; i++) {
            Node current = s2.elementData[i];
            while (current != null) {
                  if (contains(current.data)) {
                        remove(current.data);
                    }
                  current = current.next;
              }
        }
}

//Accepts another HashIntSet as a parameter
//Removes all elements from this set that are not contained in the other set
public void retainAll(HashIntSet s2) {
      int thisLength = this.elementData.length;
      for (int i = 0; i < thisLength; i++) {
            Node current = this.elementData[i];
            while (current != null) {
                  if (!(s2.contains(current.data))) {
                        remove(current.data);
                    }
                  current = current.next;
              }
        }
}

//Returns the elements of this set as a filled array; order not important
public int[] toArray() {
      int[] setArray = new int[this.size];
      int arrayIndex = 0;
      int thisLength = this.elementData.length;
      for (int i = 0; i < thisLength; i++) {
            Node current = this.elementData[i];
            while (current != null) {
                  setArray[arrayIndex] = current.data;
                  arrayIndex++;
                  current = current.next;
              }
        }
      return setArray;
}

//Returns a string representation of the elements in this set
public String toString() {
      String setString = "[";
      int thisLength = this.elementData.length;
      boolean firstPrinted = false;
      for (int i = 0; i < thisLength; i++) {
            Node current = this.elementData[i];
            while (current != null && !firstPrinted) {
                  setString += current.data;
                  firstPrinted = true;
                  current = current.next;
              }
            while (current != null) {
                  setString = setString + ", " + current.data;
                  current = current.next;
              }
        }
      setString += "]";
      return setString;
}
