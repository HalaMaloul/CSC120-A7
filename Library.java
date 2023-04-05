/* This is a stub for the Library class */

import java.util.Hashtable;
public class Library extends Building {
  private Hashtable < String, Boolean > collection;
  Boolean hasElevator;

  /**
   * defult constructor 
   * @param name
   * @param address
   * @param nFloors
   * @param hasElevator
   */
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    // System.out.println("You have built a library: 📖");
    super(name, address, nFloors);

    this.collection = new Hashtable < String, Boolean > ();
  }
  /**
   * overloaded constructor with the has elevator hard coded as true
   * @param name
   * @param address
   * @param nFloors
   */
  public Library(String name, String address, int nFloors) {
    this(name, address, nFloors, true);

  }

  /**
   * adding a title to the collection
   * @param title
   */
  public void addTitle(String title) {
    if (collection.containsKey(title)) {
      throw new RuntimeException(title + " already exists");
    } else {
      collection.put(title, true);
    }

  }

  /**
   * removing a title from the collection 
   * @param title
   
   */
  public String removeTitle(String title) {
    if (collection.containsKey(title)) {
      collection.remove(title);
    } else {
      throw new RuntimeException(title + " does not exists");
    }
    return title;
  }
  /**
   * checking out a book
   * @param title
   */
  public void checkOut(String title) {
    if (!collection.containsKey(title)) {

      throw new RuntimeException("sorry this book does not exist in the collection");
    }
    if (collection.get(title) == false) {

      throw new RuntimeException("sorry this book is already checked out");
    }
    collection.put(title, false);
  }
  /**
   * overloaded checkout method for checking out a book takes both the title and the persons name as arguments
   * @param title
   * @param name the name of who checked the book out
   */
  public void checkOut(String title, String name) {
    this.checkOut(title, name);
  }
  /**
   * returning a book
   * @param title
   */
  public void returnBook(String title) {
    if (!collection.containsKey(title)) {
      collection.put(title, true);
    }

  }

  public boolean containsTitle(String title) {
    return this.collection.containsKey(title);
  }

  public boolean isAvailable(String title) {
    return collection.get(title);

  }
  /**
   * priniting the collection
   */
  public void printCollection() {
    for (String title: this.collection.keySet()) {
      System.out.print(title);
      if (this.collection.get(title)) {
        System.out.println(":  Available");
      } else {
        System.out.println(": checked out");
      }
    }

  }

  public void showOptions() {
    super.showOptions();
    System.out.println("\n + checkout() \n + returnbook() \n + addtitle() \n + removetitle() \n");
  }
  /**
   * overriding to the getToFloor method to check if the building has an elevator first
   * @param floorNum
   */
  public void goToFloor(int floorNum) {
    if (this.hasElevator) {
      super.goToFloor(floorNum);
    } else {
      throw new RuntimeException("you can't use this method here use goup(),godown() methods");
    }
  }
  public static void main(String[] args) {
    Library Neilson = new Library("neilson", "smith college", 4);
    Neilson.addTitle("hala");
    // Neilson.addTitle("hala");
    Neilson.addTitle("maloul");
    Neilson.checkOut("maloul");
    Neilson.printCollection();
    Neilson.showOptions();

  }

}