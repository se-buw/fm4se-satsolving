![Points bar](../../blob/badges/.github/badges/points-bar.svg)


# Propositional Logic and SAT Solving

## Project Setup

[📼 see the project setup video]()

TODO: Create and describe github classroom setup

## Task 1
Using at least three atoms and two different operators in each formula-

**a.** Provide a formula $\varphi$, where $\models \varphi$  holds.
- https://play.formal-methods.net/?check=VAL&p=task-1a

**b.** Provide a formula $\varphi$, where $\models \varphi$  does not hold.
- https://play.formal-methods.net/?check=VAL&p=task-1b

Submit the translation to limboole and the answer it produces.
Submit the translations of the relevant checks in limboole syntax and the answers limboole produces in each case (4 checks).

## Task 2
Provide two folmulas $\varphi$- 

**a.** where $\varphi$ is semantically equivalent to $p \rightarrow (q \vee r) $.
- Check1: https://play.formal-methods.net/?check=VAL&p=task-2a-c1
- Check2: https://play.formal-methods.net/?check=VAL&p=task-2a-c2

**b.** where $\varphi$ is NOT semantically equivalent to $p \rightarrow (q \vee r) $.
- Check1: https://play.formal-methods.net/?check=VAL&p=task-2b-c1
- Check2: https://play.formal-methods.net/?check=VAL&p=task-2b-c2


Note: You may check each direction of the semantic entailment separately using limboole.

## Task 3
Check whether the conclusion(4) is a valid conclusion. 
> 1.	If Bob spends 5 hours playing video games or watching Netflix, then he cannot finish his formal method assignment.
> 2.	If Bob finishes his formal method assignment, then he can submit the final project.
> 3.	Bob submitted the final project.
> 4.	Therefore, Bob was playing video games for 5 hours.

**a.** Express the sentences in propositional logic.
- Sentence 1: https://play.formal-methods.net/?check=SAT&p=task-3a-s1
- Sentence 2: https://play.formal-methods.net/?check=SAT&p=task-3a-s2
- Sentence 3: https://play.formal-methods.net/?check=SAT&p=task-3a-s3
- Sentence 4: https://play.formal-methods.net/?check=SAT&p=task-3a-s4

**b.** Formulate the conclusion using semantic entailment.
- https://play.formal-methods.net/?check=SAT&p=task-3b

**c.** Transform it to validity, and check validity using limboole. 
- https://play.formal-methods.net/?check=SAT&p=task-3c

## Task 4

Consider the following permissions table for a role-based access control system.

| Role    | Course   | Assignment  | Server   |
|---------|----------|-------------|----------|
| Student | ✅      | ✅          | ❌      |
| Teacher | ✅      | ✅          | ❌      |
| Admin   | ✅      | ❌          | ✅      |


**a.** Follow the steps done in class to encode the above table and the constraints for checking them in limboole. Use these names:

Propositional atoms for roles: *isStudent*, *isTeacher*, *isAdmin*.

Propositional atoms for resources: *accessCourse*, *accessAssignment*, *accessServer*

- Rule 1: https://play.formal-methods.net/?check=SAT&p=task-4a-r1
- Rule 2: https://play.formal-methods.net/?check=SAT&p=task-4a-r2
- Rule 3: https://play.formal-methods.net/?check=SAT&p=task-4a-r3

**b.** Define two meaningful constraints for the above roles and resources in natural language and encode them in limboole.
- Constraint 1: https://play.formal-methods.net/?check=SAT&p=task-4b-c1
- Constraint 2: https://play.formal-methods.net/?check=SAT&p=task-4b-c2

**c.** From *a* and *b*  above, formulate the validity check.
- https://play.formal-methods.net/?check=SAT&p=task-4c



## Submission
[Submit all the permalinks in src/main/java/de/buw/fm4se/satsolving/task/Tasks.java](src/main/java/de/buw/fm4se/satsolving/task/Tasks.java)


## Feedback
TODO: Explain
#### Via GitHub Actions
![Action-Feedback](resource/action-feedback.gif)

#### Via GitHub Pull Request
![Action-Feedback](resource/pull-feedback.gif)

