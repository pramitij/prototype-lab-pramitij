[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=10538482&assignment_repo_type=AssignmentRepo)
# Welcome to the course CSYE6200 - Object Oriented Design
> Northeastern University, College of Engineering


## Professor: Daniel Peters

### Requirements
1. Eclipse or VS Code or IntelliJ.

Note: If you are using Eclipse, please have git CLI installed on your system or GitHub Desktop to commit the code in this repository

### SetUp Instructions
1. Please clone the repository on your local system
2. For Eclipse Import the project as Existing Maven Project, For IntelliJ you can directlty open it using 'Get from VCS'.
4. All code should be pushed to the main branch
3. Ensure the GitHub actions are successful post push

Submissions will have deadlines, failed GitHub Actions would result in point deductions.

### References
1. Cloning a Repository: <https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository>
2. Any GitHub Setup: Please refer to the Git & GitHub Fundamentals Repository shared to you by your respective TA and refer the README.md section

Please reach out to your respective TA if you need any help in regards with submission/ GitHub

Author:
- Aditya Mulik (mulik.a@northeastern.edu)
- Sai Akhil Vemula (vemula.v@northeastern.edu)

### Specifications of Assignment
LAB:

FOLLOW ALL INSTRUCTIONS:

Design a MyCloneable class to demonstrate object cloning in java, e.g. implement the Cloneable interface

/**
* Demonstrate the use of the Abstract Factory, Builder and Prototype design patterns as follows:
*
* get and use Item objects to sell UPPERCASE LETTERS
*
* sell all 26 upper case alphabetic letters (A-Z) with the following prices:
*     A for $ 1.99
*     B for $ 2.99
*  . . .
*     Y for $ 25.99
*     Z for $ 26.99
*
* 1. Develop MyCloneable class with Builder and the following inner classes:
* 2. Derive MyCloneableItem class from MyCloneable class
* 3. Develop MyCloneableAbstractFactory from SUPPLIED (below) MyCloneableAbstractFactoryAPI
* 4. Develop MyCloneableAbstractFactorySingleton
* 5. Load MyCloneableAbstractFactory with 26 MyCloneableItem prototypes which are cloned upon request
* 6. Demonstrate with console output showing use of 26 Letter Items with ID, Price and Name attributes.
*
* @author dpeters
*
*/

    /**
     * API for abstract factory of cloneable objects
     * 
     * @author dpeters
     *
     */
    public static abstract class MyCloneableAbstractFactoryAPI {
        /**
         * @param id            ID of prototype
         * @param prototype        one cloneable prototype object
         */
        public abstract void load(int id, MyCloneable prototype);
        /**
         * dynamically load list of prototypes
         * 
         * @param prototypeList        list of cloneable prototype objects
         */
        public abstract void load(HashMap<Integer, MyCloneable> prototypeList);
        /**
         * return clone of requested object
         * 
         * @param id            ID of requested object
         * @return                cloned object
         */
        public abstract MyCloneable getObject(int id);
    }