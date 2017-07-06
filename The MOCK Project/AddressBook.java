public class AddressBook    //public keyword means class is available to other classes in this program
{
    // These are the attributes (variables that each instance is given a set of), private meaning accesible only within the declared class itself
    private String address;
    private String name;
    private String surname;

    //This section is the constructor
    public AddressBook(String address, String name, String surname) 
    {        
        this.address = address;
        this.name = name;
        this.surname = surname;
    }

    //override the toString() method, if you don't have this when outputting you get a reference to the object
    // not the values of the object
    @Override   
    public String toString() 
    {
        return this.address + ", " + this.name + ", " +   this.surname;
    }

    //methods - getters and setters, also known as accessor methods
    public String getAddress() { return address;}

    public String getName() {return name;}

    public String getSurname() {return surname;}

    //this keyword highlights that the attribute is being assigned to rather than the parameter being assigned to itself
    public void setAddress(String address) {this.address = address;}

    public void setName(String name){this.name = name;}

    public void setSurname(String surname){this.surname = surname;}
}