/* This is a stub for the Cafe class */
public class Cafe extends Building {
    boolean hasElevator;
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    /* Default constructor with name,address,nFloors,nCoffeeOunces,nSugarPackets,nCreams,nCups */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, boolean hasElevator) {
      // System.out.println("You have built a cafe: ☕");
      super(name, address, nFloors);
      this.nCoffeeOunces = nCoffeeOunces;
      this.nSugarPackets = nSugarPackets;
      this.nCreams = nCreams;
      this.nCups = nCups;
      this.hasElevator = hasElevator;
  
    }
    /**
     * overloaded constructor with the has elevator hard coded as false
     * @param name
     * @param address
     * @param nFloors
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
      // System.out.println("You have built a cafe: ☕");
      this(name, address, nFloors, nCoffeeOunces, nSugarPackets, nCreams, nCups, false);
  
    }
  
    /**
     *decrease the remaining inventory when the Cafe sells a cup of coffee
     * @param size the size of the coffee
     * @param nSugarPackets the number of sugar packets used
     * @param nCreams  the number of creams used
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
      if (nCoffeeOunces < 1) {
        this.restock(100, 0, 0, 0);
      }
      if (nSugarPackets < 1) {
        this.restock(size, 100, nCreams, nCups);
      }
      if (nCreams < 1) {
        this.restock(size, nSugarPackets, 100, nCups);
      }
      if (nCups < 1) {
        this.restock(size, nSugarPackets, nCreams, 100);
      }
      this.nCoffeeOunces -= size;
      this.nSugarPackets -= nSugarPackets;
      this.nCreams -= nCreams;
      this.nCups -= 1;
  
    }
    /* Overloaded sellCoffee method  with size */
    public void sellCoffee(int size) {
      this.sellCoffee(size, 1, 1); // Call method with hard-coded # nSugarPackets,#nCreams
    }
  
    public String toString() {
      return super.toString();
  
    }
  
    /**
     * method to restock when necessary
     * @param nCoffeeOunces the number of coffee Ounces
     * @param nSugarPackets the number of sugar packets
     * @param nCreams the number of creams
     * @param  nCups the number of cups
     */
  
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
      this.nCoffeeOunces += nCoffeeOunces;
      this.nSugarPackets += nSugarPackets;
      this.nCreams += nCreams;
      this.nCups += nCups;
    };
    /**
     * overriding  the show option method because a cafe has only one floor and we don't want the gotofloor method
     */
    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n");
    }
    /**
     * over riding the goToFloor method so it doesn't permit movement off the first floor
     * @param floorNum
     */
    public void goToFloor(int floorNum) {
      throw new RuntimeException("you can't use this method here use goup(),godown() methods");
    }
  
    public static void main(String[] args) {
      Cafe compass = new Cafe("compass", "100 Green Street Northampton, MA 01063", 4, 6, 7, 8, 9);
      compass.showOptions();
      compass.toString();
    }
  
  }