# CoffeeAndTacos
An exercise in geolocation, csv parsing, and logging for Java

## Kata Overview

Here's what you'll need to do for this Kata:

1. Clone this repo to your machine, then create a branch to accomplish your work (`git checkout -b your-branch-name`)
2. Complete all the `TODO`s, while adding appropriate log statements along the way. You can find more details below in the Kata Details section:
    2. Implement the Parse Method
    3. Use the GeoCoordinate class to calculate distance between two points
3. Reduce the logging verbosity and rerun

## Kata Details

Here's some more details for completing the steps above.

### TacoParser

Updating the `Parse` method in your `TacoParser`

This method is used to parse a single row from your CSV file as a string and return an Trackable:

```Java
public Trackable Parse(string line) {

    // Take your line and research a way to seperate the line by each comma, to extract the long and lat values.
    
    // If your array.Length is less than 3, something went wrong

    // grab the latitude from your array at index 0
    // grab the longitude from your array at index 1
    // grab the name from your array at index 2

    // Your going to need to parse your string as a `double`

    // You'll need an instance of the Trackable class
    // With the name and point set correctly

    // Then, return the instance of your Trackable class
}
```

### CoffeeAndTacos

You now have your `Parse` method working properly. Now, let's get into our CoffeeAndTacos file in our `main` static method.

```Java
public static void main(String[] args)
{
    List<Trackable> locations = new ArrayList<>();
        
        var parser = new TacoParser();
        Scanner scanner;      
        try {
            scanner = new Scanner(new File(PATH));
            while (scanner.hasNextLine()) {
            locations.add(parser.Parse(scanner.nextLine()));
            }           
        } catch (Exception e) {
            logger.logSevere("Cannot find file path", e);
        }

    // Here's where you start

    // Create two `Trackable` variables with initial values of `null`. These will be used to store your two taco bells that are the furthest from each other.
    // Create a `double` variable to store the distance

    // Do a loop for your locations to grab each location as the origin (perhaps: `locA`)
    // Create a new corA GeoCoordinate with your locA's lat and long

    // Now, do another loop on the locations with the scope of your first loop, so you can grab the "destination" location (perhaps: `locB`)
    // Create a new GeoCoordinate with your locB's lat and long
    // Now, compare the two using `.getDistanceTo()`, which returns a double
    // If the distance is greater than the currently saved distance, update the distance and the two `TTrackable` variables you set above

    // Once you've looped through everything, you've found the two Taco Bells furthest away from each other.
}
```
