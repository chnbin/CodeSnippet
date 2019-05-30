class PhoneDirectory {
  boolean[] isAvailable;
  int capacity;

  /** Initialize your data structure here
      @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
  public PhoneDirectory(int maxNumbers) {
      isAvailable = new boolean[maxNumbers];
      capacity = maxNumbers;

      for (int i = 0; i < capacity; i++) {
          isAvailable[i] = true;
      }
  }
  
  /** Provide a number which is not assigned to anyone.
      @return - Return an available number. Return -1 if none is available. */
  public int get() {
      int number = -1;
      
      for (int i = 0; i < capacity; i++) {
          if (isAvailable[i]) {
              number = i;
              isAvailable[i] = false;
              break;
          }
      }
      return number;
  }
  
  /** Check if a number is available or not. */
  public boolean check(int number) {
      if (number >= capacity) { return false; }
      return isAvailable[number];
  }
  
  /** Recycle or release a number. */
  public void release(int number) {
      isAvailable[number] = true;
  }
}