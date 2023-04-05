import java.util.ArrayList;

/* This is a stub for the House class */

public class House extends Building {
  private ArrayList < String > residents;
  private boolean hasDiningRoom;
  boolean hasElevator;

  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  public int nResidents() {
    return this.residents.size();

  }

  /**
   defult constructor with name, adress,nfloors,hasDiningRoom,hasElevator
  */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    // System.out.println("You have built a house: 🏠");
    super(name, address, nFloors);
    this.residents = new ArrayList < String > ();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;

  }
  /** 
   * checks if a person is a resident
   * @param person 

   */
  public boolean isResident(String person) {
    return this.residents.contains(person);

  }

  /**
   * updates the Arraylist when someone moves in
   * @param name
   */
  public void moveIn(String name) {
    if (isResident(name)) {
      throw new RuntimeException(name + "is already a resident");
    } else {
      residents.add(name);
    }
  }
  /**
   * overloaded method that takes name and iD and updates the Arraylist when someone moves in 
   * @param name
   * @param iD  the student iD number
   */
  public void moveIn(String name, int iD) {
    this.moveIn(name);
  }
  /**
   * updates the Arraylist when someone moves out
   * @param name
   */
  public String moveOut(String name) {
    if (isResident(name)) {

      residents.remove(name);
      return name;

    } else {
      throw new RuntimeException(name + "is not a resident");
    }
  }

  /**
   * overloaded moveout method with name and idicates that the room was emptied (hard coded true)
   * @param name
   * @param emptiedroomyet  
   * 
   */
  public String moveOut(String name, boolean emptiedRoomYet) {
    return this.moveOut(name, true);
  }

  public String toString() {
    String describtion = super.toString();
    describtion += "There are currently" + this.residents.size() + "residents in this house";
    describtion += "this house";
    if (this.hasDiningRoom) {
      describtion += "has";
    } else {
      describtion += "does not have";

    }
    describtion += "a dining room";

    return describtion;

  }
  public void showOptions() {
    super.showOptions();
    System.out.println("\n + movein() \n + moveout() \n + goToFloor(n)");
  }
  /** 
   * overriding the go to floor method to check if the house has an elevator first
   * @param floornum 
   */
  public void goToFloor(int floorNum) {
    if (this.hasElevator) {
      super.goToFloor(floorNum);
    } else {
      throw new RuntimeException("you can't use this method here use goup(),godown() methods");
    }
  }

  public static void main(String[] args) {
    House wilson = new House("wilson", "hkhk", 4, true, false);
    System.out.println(wilson);

    wilson.moveIn("Hala");
    System.out.println(wilson);
    wilson.showOptions();

  }

}