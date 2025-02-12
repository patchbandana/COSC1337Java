/* TVSet Class
   Anderson, Franceschi
*/
import java.text.NumberFormat;

public class TVSet
{
  public final NumberFormat money = NumberFormat.getCurrencyInstance( );
  private String brand;
  private double price;

  /**
  * Constructor:<BR>
  * Allows client to set beginning values for brand and price
  * This constructor takes two parameters<BR>
  * Calls mutator methods to validate new values
  * @param newBrand the brand of the TV set
  * @param newPrice the price of the TV set
  */
  public TVSet( String newBrand, double newPrice )
  {
    setBrand( newBrand );
    setPrice( newPrice );
  }

  /** getBrand method
  * @return the brand
  */
  public String getBrand( )
  {
    return brand;
  }

  /**
  * Mutator method:<BR>
  * Allows client to set value of brand
  * @param brand the new brand
  * @return a reference to this object
  */
  public TVSet setBrand( String brand )
  {
    this.brand = brand;
    return this;
  }

  /** getPrice method
  * @return the price
  */
  public double getPrice( )
  {
    return price;
  }

  /**
  * Mutator method:<BR>
  * Allows client to set value of price
  * Does not change the value if new value is less than 0<BR>
  * @param price the new price
  * @return a reference to this object
  */
  public TVSet setPrice( double price )
  {
    if ( price > 0 )
      this.price = price;
    return this;
  }

  /**
  * @return the brand and price of the TV set
  */
  public String toString( )
  {
    return( "brand: " + brand + "; price: " + money.format( price ) );
  }

  /**
  * equals method
  * Compares two TVSet objects for the same field values
  * @param o another TVSet object
  * @return a boolean, true if this object
  * has the same field values as the parameter tvs
  */
  public boolean equals( Object o )
  {
    if ( ! ( o instanceof TVSet ) )
       return false;
    else
    {
		TVSet tvs = (TVSet) o;
      return ( brand.equals( tvs.brand ) &&
            Math.abs( price - tvs.price ) < 0.0001 );
	}
  }
}