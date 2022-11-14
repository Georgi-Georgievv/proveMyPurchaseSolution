# ApproveMyPurchase

Johnny was asked to develop a small program and is asking you for help.
His company needs a tool for approving requests for purchases. For example, if someone asks for a new laptop, the request will be considered and if it is within a specific limit, it will be purchased for them.

Johnny wrote some code, but it's not finished and his deadline is approaching.

Your task is implementing all the functionalities and editing Johnny's code to follow the **SOLID** and **object-oriented** principles.

This table contains all manager limits in each category (amounts are INCLUSIVE);

|Type          |Manager|Director|Vice President|President|
|--------------|------|------|------|------|
| Consumables  | 300  | 500  | 700  | 1000 |
| Clerical     | 500  | 1000 | 1500 | 2000 |
| Gadgets      | 1000 | 1500 | 2000 | 3000 |
| Gaming       | 3000 | 3500 | 4500 | 5000 |
| PC           | 5000 | 6000 | 6500 | 8000 |

**NOTES ON SOLUTION**
* All the cases regarding check of the limits for different positions are covered with tests in ***test*** folder
* Design pattern used to implement this project is representation of ***Chain of Responsibility*** pattern
* Solution makes use of features from the latest versions of Java - ***records*** objects, new switch form and so on.
Using this features was not taken into consideration when tasks were reviewed.