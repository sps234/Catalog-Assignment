## Description

This project implements a simplified version of Shamir's Secret Sharing algorithm using Java. The goal is to find the constant term \( c \) of an unknown polynomial given its roots in a specific format. The input is provided in JSON format, and the program decodes the roots to compute the constant term of the polynomial.

## Requirements

- Java Development Kit (JDK) version 8 or higher
- [json-20240303.jar](https://mvnrepository.com/artifact/org.json/json) (place this in the `lib` directory)

## Directory Structure
![Screenshot (379)](https://github.com/user-attachments/assets/351666e6-9861-4642-b5c2-b3b466be241b)


## Setup

1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Ensure that the `json-20240303.jar` file is placed inside the `lib` directory.

## Compiling and Running the Program

To compile and run the `Solution.java` file, open your terminal and navigate to the project directory. Use the following commands:


### Compile

```sh
javac -cp ".;lib/json-20240303.jar" Solution.java
```

### Run

```sh
java -cp ".;lib/json-20240303.jar" Solution
```

Example Input
```sh
{
    "keys": {
        "n": 4,
        "k": 3
    },
    "1": {
        "base": "10",
        "value": "4"
    },
    "2": {
        "base": "2",
        "value": "111"
    },
    "3": {
        "base": "10",
        "value": "12"
    },
    "4": {
        "base": "4",
        "value": "213"
    }
}
```

Output
The program will output the constant term c of the polynomial based on the decoded roots provided in the input.

