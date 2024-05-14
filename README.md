Number Converter Program in Java

The Number Converter program facilitates the conversion between decimal and hexiacosadecimal representations. Here's an in-depth breakdown of its functionality:

1. Class Structure:
   - The `NumberConverter` class contains methods for converting between string and double representations of numbers.
   - It has two constructors: one for initializing the converter with a string input (hexiacosadecimal representation) and one for a double input (decimal representation).
   - Methods `convertToDouble()` and `convertToString()` handle the conversion logic.
   - `toString()` method overrides the default `toString()` method to display the converted representations.

2. Input Handling:
   - In the `main()` method, a `Scanner` object is used to capture user input from the console.
   - The program runs in a loop until the user decides to quit by entering 'q'.
   - Users can choose between converting from hexiacosadecimal to decimal ('h') or from decimal to hexiacosadecimal ('d').

3. Conversion Process:
   - When converting from hexiacosadecimal to decimal, the program validates the input and uses the `NumberConverter` constructor to initialize the conversion.
   - For decimal to hexiacosadecimal conversion, the program prompts the user to enter a valid decimal number. If the input is valid, it uses the `NumberConverter` constructor accordingly.
   - Conversion logic is implemented within the `NumberConverter` class using mathematical operations to handle base-26 encoding.

4. Output Display:
   - Upon successful conversion, the program displays the converted representation along with the original input.
   - Error messages are displayed for invalid inputs, guiding users to provide correct input formats.

5. Exit Condition:
   - Users can exit the program gracefully by entering 'q', which triggers a farewell message before terminating the program.
