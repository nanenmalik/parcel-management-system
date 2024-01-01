# parcel-management-system

case study repository

Group name    : 6

-----------------------------------------------------------------------------------------
Group Members : 1) Nur Nabila Radiah Binti Ahmad Ridzuan (2213554)
                2) Nur Amira Nabila Binti Mohd Ab Rahman (2220682)
                3) Nurul Nasreen Binti Abdul Malik (2217464)

------------------------------------------------------------------------------------------

The assigned tasks for each group member:-

### Main Class (Main):
1. main(String[] args) (Amira)
   - Presents a menu to the user and calls specific methods based on the user's choice.

2. menu1() (Amira)
   - Handles the collection of parcels.
   - Reads user input for username and collection code.
   - Searches for the parcel and removes it if found.

3. menu2() (Amira)
   - Handles the drop-off of parcels.
   - Reads user input for username, collection code, and sender details.
   - Stores the parcel if there is space.

4. printWelcomeMessage() (Amira)
   - Prints the welcome message and menu options.

5. readFile() (Nabila)
   - Reads the contents of the file and stores them in the parcel storage array.

6. writeFile() (Nabila)
   - Writes the contents of the parcel storage to the file.

7. resetArray() (Nabila)
   - Resets the parcel storage array.

### Parcel Class (Parcel): (Nasreen)
1. Parcel(String houseNumber, String code, String sender)
   - Creates a new parcel with the given username, code, and sender.

2. Parcel(String houseNumber, String code, LocalDate storedDate, LocalDate expiredDate, String sender)
   - Creates a new parcel with the given username, code, stored date, expired date, and sender.

3. Accessor Methods and Mutator Methods:(Nasreen)
   - Various methods to get and set the values of username, code, storedDate, expiredDate, and sender.

### ParcelStorage Class (ParcelStorage): Nabila
1. ParcelStorage()
   - Default constructor to initialize the parcel storage with null username and an empty list of parcels.

2. ParcelStorage(String username, List<Parcel> parcelList)
   - Creates a new parcel storage with the given username and list of parcels.

3. Accessor Methods and Mutator Methods:
   - Various methods to get and set the values of username and parcelList in the parcel storage.
  
### Make  UML class  diagram (Nasreen)

### Update README file (Nasreen)
 -----------------------------------------------------------------------------------------------------------------------------------------------------------    

 Brief Description of the case study

This code represents a parcel service centre application with basic functionality for storing and retrieving parcels. The program, initiated by the Main class, presents users with two options: collecting a parcel or dropping off a new one. It employs file operations to maintain parcel information persistently in the "parcel2.txt" file.

The Parcel class defines the attributes and behavior of individual parcels, including their username, collection code, dates, and sender details. Meanwhile, the ParcelStorage class manages storage units, associating each with a username and maintaining a list of stored parcels.

----------------------------------------------------------------------------------------------------------------------------------------------------------
UML Class Diagram

![Screenshot 2023-12-28 112805](https://github.com/nanenmalik/parcel-management-system/assets/147983899/f12ea0e6-2b61-4b4c-ad8b-363ff10e35ad)

---------------------------------------------------------------------------------------------------------------------------------------------------------------
REFERENCES
- Liang, D. (2020). Introduction to Java Programming and Data Structures. 12th Edition. Pearson Education, Inc.
