# Week 9 Coding Practice (Abstraction & Interfaces)

---

## Part A — Coding Problems

### Problem 1: Garden Plot Area Report
#### Task
A community garden rents out plots of three shapes: circular, rectangular, and triangular. Every plot has an owner, and every plot's area is calculated with a different formula. The garden office needs the area of each plot and the total area rented.
Adding a new plot shape later should not require changes to the code that prints the report.

#### Input
The first line contains N, the number of plots. Each of the next N lines contains the shape, the owner's name (one word), and the measurements:
- `CIRCLE Owner radius`
- `RECTANGLE Owner length width`
- `TRIANGLE Owner base height`

#### Output
For each plot, print `Owner (SHAPE): area`. Finally, print `Total Area: total`. All values are formatted to two decimal places.

#### Business Rules
- Circle area = $\pi \times \text{radius} \times \text{radius}$ (use `Math.PI`).
- Rectangle area = $\text{length} \times \text{width}$.
- Triangle area = $\frac{1}{2} \times \text{base} \times \text{height}$.

#### Sample Input
```
3
CIRCLE Asha 5
RECTANGLE Ravi 4 6
TRIANGLE Neha 10 3
```

#### Expected Output
```
Asha (CIRCLE): 78.54
Ravi (RECTANGLE): 24.00
Neha (TRIANGLE): 15.00
Total Area: 117.54
```

---

### Problem 2: Weekly Staff Pay
#### Task
A small company pays three kinds of staff every week: full-time staff receive a fixed weekly salary, hourly staff are paid by the hour with overtime, and interns receive a fixed stipend. Every staff member has a name, and the payroll screen must list each person's pay and the total.
A generic "staff member" with no pay rule must never be created.

#### Input
The first line contains N. Each of the next N lines is one of:
- `FULLTIME Name weeklySalary`
- `HOURLY Name hours rate`
- `INTERN Name stipend`

#### Output
For each person, print `Name: pay`. Finally, print `Total Payroll: total`, formatted to two decimal places.

#### Business Rules
- Full-time staff are paid their fixed weekly salary.
- Hourly staff are paid `rate` for the first 40 hours and `1.5 * rate` for every hour above 40.
- Interns are paid their fixed stipend.

#### Sample Input
```
3
FULLTIME Asha 12000
HOURLY Ravi 45 200
INTERN Neha 5000
```

#### Expected Output
```
Asha: 12000.00
Ravi: 9500.00
Neha: 5000.00
Total Payroll: 26500.00
```

---

### Problem 3: Library Late Fine Counter
#### Task
A library charges a fine when borrowed items are returned late. Books, DVDs, and magazines each follow a different fine rule. Every item has a title and a number of days late. The library needs the fine for each item and the total fines collected.

#### Input
The first line contains N. Each of the next N lines contains `TYPE Title daysLate`, where TYPE is `BOOK`, `DVD`, or `MAGAZINE` and Title is one word.

#### Output
For each item, print `Title: fine`. Finally, print `Total Fines: total`, formatted to two decimal places.

#### Business Rules
- Books: 2 per day late.
- DVDs: 5 per day late, up to a maximum of 50.
- Magazines: 1 per day late.

#### Sample Input
```
3
BOOK Algebra 4
DVD Inception 12
MAGAZINE Sports 3
```

#### Expected Output
```
Algebra: 8.00
Inception: 50.00
Sports: 3.00
Total Fines: 61.00
```

---

### Problem 4: Electricity Connection Billing
#### Task
The electricity board issues monthly bills to homes, shops, and factories. Every connection has a number of units used, but each connection type calculates its bill differently. The board needs each connection's bill and the total amount billed.

#### Input
The first line contains N. Each of the next N lines contains `TYPE units`, where TYPE is `HOME`, `SHOP`, or `FACTORY`.

#### Output
For each connection, print `TYPE: bill`. Finally, print `Total: total`, formatted to two decimal places.

#### Business Rules
- Home: 5 per unit for the first 100 units and 7 per unit after that.
- Shop: 8 per unit plus a fixed charge of 100.
- Factory: 6 per unit, with a minimum bill of 1000.

#### Sample Input
```
3
HOME 150
SHOP 90
FACTORY 120
```

#### Expected Output
```
HOME: 850.00
SHOP: 820.00
FACTORY: 1000.00
Total: 2670.00
```

---

### Problem 5: Travel Booking with a Common Fee
#### Task
A travel website sells bus, train, and flight tickets. The fare depends on the travel mode and the distance, but every booking — whatever the mode — also adds the same booking fee of 50. The fee must be written in one place only.
If the booking fee changes, only one line of code should need to change.

#### Input
The first line contains N. Each of the next N lines contains `MODE distanceKm`, where MODE is `BUS`, `TRAIN`, or `FLIGHT`.

#### Output
For each booking, print `MODE: total`, formatted to two decimal places.

#### Business Rules
- Bus fare: 2 per km.
- Train fare: 1.5 per km.
- Flight fare: 2500 plus 4 per km.
- Every booking adds a booking fee of 50 to the fare.

#### Sample Input
```
3
BUS 200
TRAIN 300
FLIGHT 500
```

#### Expected Output
```
BUS: 450.00
TRAIN: 500.00
FLIGHT: 4550.00
```

---

## Part B — Quiz Questions

**Q1. Which of the following best describes abstraction in object-oriented programming?**
- A. Showing all internal details of an object to the user
- B. Protecting data inside an object from unauthorized access
- **C. Hiding how an object performs its operations and showing only what it does**
- D. Allowing a class to inherit from multiple parent classes

**Q2. Which statement about an abstract class in Java is true?**
- A. It must contain at least one abstract method
- B. It can be instantiated if it has no abstract methods
- **C. It cannot be instantiated directly**
- D. It can extend multiple other classes

**Q3. If a concrete class extends an abstract class but fails to implement an inherited abstract method, what is the consequence?**
- A. Java automatically provides an empty implementation for the method
- **B. The class must be declared abstract, or the code will not compile**
- C. A runtime error will occur only when the unimplemented method is called
- D. The compiler will issue a warning but still allow compilation

**Q4. Which of the following modifiers is NOT allowed for an abstract method in Java?**
- A. protected
- B. public
- **C. private**
- D. default (package-private)

**Q5. Fields declared within a Java interface are implicitly:**
- A. private and static
- B. protected and final
- **C. public, static, and final**
- D. public and instance-specific

**Q6. How many interfaces can a single Java class implement?**
- A. Only one interface at a time
- B. At most two interfaces
- **C. Any number of interfaces**
- D. None, if the class already extends another class

**Q7. If a class implements an interface, what access modifier must it use for the implemented methods?**
- A. default (package-private)
- B. private
- C. protected
- **D. public**

**Q8. Why does Java allow a class to implement multiple interfaces but only extend a single class?**
- A. Implementing interfaces makes the code run faster
- B. Classes are unable to contain any methods
- **C. Interfaces carry no instance state, avoiding the 'diamond problem' ambiguity with conflicting data inheritance**
- D. Interfaces are compiled independently from classes

**Q9. What happens if a class implements two interfaces that both provide a default method with the same signature, and the class does not override this method?**
- A. The method from the first interface listed in the implements clause is used
- B. The method from the last interface listed in the implements clause is used
- C. A runtime exception occurs when the method is called
- **D. A compile-time error occurs until the class overrides the method**

**Q10. Which of the following is true regarding constructors in Java?**
- A. Concrete classes cannot have constructors
- **B. Abstract classes can have constructors that run when a subclass object is created**
- C. Interfaces must have at least one constructor
- D. Constructors in abstract classes are used to create objects of the abstract class directly

---

## Part C — Concept Questions

**Question 1: Explain abstraction in your own words. Provide a real-life example, different from those mentioned in the material, detailing what is shown to the user and what details are hidden.**
- **Answer**: Abstraction is the OOP principle of exposing only essential features and operations of an entity to the external world while concealing internal implementation mechanics and complexities. For example, consider an **ATM machine**: the user interacts with clean abstract interfaces such as "Withdraw Cash" or "Check Balance" by inserting a card and typing a PIN. The user is completely shielded from internal database queries, encrypted bank networking protocols, hardware cash-dispensing mechanisms, and ledger synchronization.

**Question 2: Describe the primary difference between abstraction and encapsulation. Explain how these two concepts work together within a single class to manage complexity and data protection.**
- **Answer**: 
  - **Abstraction** is design-level: it focuses on *what* an object does rather than *how* it does it (hiding implementation details using abstract classes and interfaces).
  - **Encapsulation** is implementation-level: it focuses on *data hiding and bundling* state and behavior together within a class (using `private` fields and controlled getters/setters).
  - They work together seamlessly: encapsulation shields internal state variables from direct outside tampering, while abstraction provides clean, high-level public methods for clients to interact with the object without knowing internal algorithms.

**Question 3: An abstract class cannot be instantiated, yet it can define a constructor. Explain why an abstract class might have a constructor and describe when this constructor is executed.**
- **Answer**: An abstract class can define a constructor to initialize its own instance fields and enforce baseline invariant setup common to all subclasses. Although clients cannot instantiate the abstract class directly via `new AbstractClass()`, its constructor is invoked during subclass instantiation through `super(...)` constructor chaining when a concrete subclass object is created.

**Question 4: Explain why an abstract method cannot be declared with the private, static, or final modifiers. Provide a reason for each of these restrictions.**
- **Answer**:
  - `private`: Abstract methods are meant to be overridden by subclasses. Private methods cannot be inherited or overridden by child classes.
  - `static`: Abstract methods rely on dynamic dispatch (runtime polymorphism) on instance objects, whereas static methods belong to the class itself and cannot be polymorphically overridden.
  - `final`: Final methods explicitly prevent method overriding, which directly contradicts the requirement that abstract methods must be overridden by concrete subclasses.

**Question 5: What is the 'diamond problem' in the context of inheritance? Explain how Java's design, allowing a class to implement multiple interfaces but extend only one class, addresses or avoids this problem.**
- **Answer**: The diamond problem occurs in multiple class inheritance when a class inherits from two parent classes that both inherit from a single grandparent class. If both parents override a method or maintain conflicting instance state (fields), the child class faces ambiguity about which parent's state and implementation to inherit. Java avoids state conflicts by allowing single class inheritance only. For multiple interface implementation, interfaces historically held no instance fields, preventing state conflicts. In modern Java with `default` methods, if a method conflict arises across interfaces, Java forces a compile-time error requiring the implementing class to explicitly override the conflicting method.
