/* The code was made by Tamás Imets for an Arduino UNO project
   This code controls the BB-8 Droid from the Star Wars: The Force Awakens,
   and works with Bluetooth RC Car application, using a HC-06 seriaé bluetooth module
   See more details at instructables.com/member/Imetomi
   Friday,  December 25, 2015
 */

 // Reference "https://www.instructables.com/id/Autonomous-Autonavigation-Robot-Arduino/"


#include <Servo.h>
#include <SoftwareSerial.h>
#include <AFMotor.h>
int command = 0;  //incoming serial data


AF_DCMotor motor1(1, MOTOR12_64KHZ); //initialize motor1 that is connected to the M1 port, this motor moves forward and backward
AF_DCMotor motor2(2, MOTOR12_64KHZ); //motor2 is connected to M2 and this turns BB-8 left and right
AF_DCMotor motor3(3, MOTOR12_64KHZ);
AF_DCMotor motor4(4, MOTOR12_64KHZ);


// 0 is up, 1 is right, 2 is down, 3 is left
int robotDirection = 0;

//Starting points
int xcoordinate = 1;
int ycoordinate = 1;

void setup() {
  Serial.begin(9600); // set up Serial library at 9600 bps - this is the speed the serial interface will work all
  motor1.setSpeed(225); //set default speed
  motor2.setSpeed(225); //set default speed
  motor3.setSpeed(225); //set default speed
  motor4.setSpeed(225); //set default speed
}

//******************************//BFR=0  LFR-1  FRF-2  RFR-3
//int arrayA[12][12]=
//{
//  { 1,1,1,1,1,1,1,1,1,1,1,1 },
//  { 1,1,0,0,0,0,0,1,1,1,1,1 },
//  { 1,1,1,1,1,1,0,1,1,1,1,1 },
//  { 1,1,1,1,1,1,0,0,0,1,1,1 },
//  { 1,1,1,1,1,1,1,1,1,1,1,1 },
//  { 1,1,1,1,1,1,1,1,1,1,1,1 },
//  { 1,1,1,1,1,1,1,1,1,1,1,1 },
//  { 1,1,1,1,1,1,1,1,1,1,1,1 },
//  { 1,1,1,1,1,1,1,1,1,1,1,1 },
//  { 1,1,1,1,1,1,1,1,1,1,1,1 },
//  { 1,1,1,1,1,1,1,1,1,1,1,1 },
//  { 1,1,1,1,1,1,1,1,1,1,1,1 },
//};
//
//void loop() {
//
//  while (1==1){
//    if (isFrontOpen() == true) {
//      moveForward();
//      delay (1000);
//    }
//    else
//      if (isRightOpen() == true) {
//      turnRight();
//      delay (1000);
//    }
//    else
//      if (isLeftOpen() == true) {
//        turnLeft();
//        delay (1000);
//      } 
//      else {
//        moveBackward();
//        delay (1000);
//      }
//  }
//}
//
//
//// Checks if there is something right in front of it using Grids
//boolean isFrontOpen () {
//  int nextNumber = getFrontNumber();
//  if (nextNumber == 0){
//    return true;
//  }
//  else {
//    return false;
//  }
//}
//
//// Checks if there is something to the Right of it using Grids
//boolean isRightOpen(){
//  int nextNumber = getRightNumber();
//  if (nextNumber == 0){
//    return true;
//  }
//  else {
//    return false;
//  }
//}
//
//// Checks if there is something to the Left of it using Grids
//boolean isLeftOpen(){
//  int nextNumber = getLeftNumber();
//  if (nextNumber == 0){
//    return true;
//  }
//  else {
//    return false;
//  }
//}
//
//// Moves straight forward.
//void moveForward () {
//  motor1.run(FORWARD);
//  motor2.run(RELEASE);
//  motor3.run(FORWARD);
//  motor4.run(RELEASE);
//
//  Serial.println("Forward");
//  if (robotDirection == 0)
//    ycoordinate = ycoordinate - 1;
//  if (robotDirection == 1)
//    xcoordinate = xcoordinate + 1;
//  if (robotDirection == 2)
//    ycoordinate = ycoordinate + 1;
//  if (robotDirection == 3)
//    xcoordinate = xcoordinate - 1;
//}
//
//
//// Moves straight backward.
//void moveBackward() {
//  motor1.run(BACKWARD);
//  motor2.run(RELEASE);
//  motor3.run(BACKWARD);
//  motor4.run(RELEASE);
//
//  Serial.println("Backward");
//  if (robotDirection == 0)
//    robotDirection = 2;
//  else if (robotDirection == 1)
//    robotDirection = 3;
//  else if (robotDirection == 2)
//    robotDirection = 0;
//  else if (robotDirection == 3)
//    robotDirection = 1;
//}
//
//// Turns to the Right
//void turnRight () {
//  motor1.run(RELEASE);
//  motor2.run(FORWARD);
//  motor3.run(RELEASE);
//  motor4.run(FORWARD);
//  
//  Serial.println("Right");
//  if (robotDirection == 0)
//    robotDirection = 1;
//  else if (robotDirection == 1)
//    robotDirection = 2;
//  else if (robotDirection == 2)
//    robotDirection = 3;
//  else if (robotDirection == 3)
//    robotDirection = 0;
//}
//
//
//
//// Turns to the Left
//void turnLeft () {
//  motor1.run(RELEASE);
//  motor2.run(BACKWARD);
//  motor3.run(RELEASE);
//  motor4.run(BACKWARD);
//  
//  Serial.println("Left");
//  if (robotDirection == 0)
//    robotDirection = 3;
//  else if (robotDirection == 1)
//    robotDirection = 0;
//  else if (robotDirection == 2)
//    robotDirection = 1;
//  else if (robotDirection == 3)
//    robotDirection = 2;
//}
//
//
//// Gets the number on the Grid of the space right in front of it.
//int getFrontNumber() {
//  if (robotDirection == 0) {
//    return arrayA  [ycoordinate - 1][xcoordinate];
//  }
//  if (robotDirection == 1)  {
//    return arrayA  [ycoordinate][xcoordinate + 1];
//  }
//  if (robotDirection == 2) {
//    return arrayA [ycoordinate + 1][xcoordinate] ;
//  }
//  if (robotDirection == 3) {
//    return arrayA  [ycoordinate][xcoordinate - 1];
//  }
//}
//
//
//// Gets the number on the Grid of the space to the Right of it.
//int getRightNumber() {
//  if (robotDirection == 0) {
//    return arrayA [ycoordinate][xcoordinate + 1] ;
//  }
//  if (robotDirection == 1)  {
//    return arrayA  [ycoordinate + 1][xcoordinate];
//  }
//  if (robotDirection == 2) {
//    return arrayA  [ycoordinate][xcoordinate - 1];
//  }
//  if (robotDirection == 3) {
//    return arrayA  [ycoordinate - 1][xcoordinate];
//  }
//}
//
//
//// Gets the number on the Grid of the Space to the Left of it.
//int getLeftNumber() {
//  if (robotDirection == 0) {
//    return arrayA [ycoordinate][xcoordinate - 1] ;
//  }
//  if (robotDirection == 1)  {
//    return arrayA  [ycoordinate - 1][xcoordinate];
//  }
//  if (robotDirection == 2) {
//    return arrayA [ycoordinate][xcoordinate + 1] ;
//  }
//  if (robotDirection == 3) {
//    return arrayA  [ycoordinate + 1][xcoordinate];
//  }
//}
//

//******************************//

void loop() {
  if (Serial.available() > 0) { //if the Arduino detects incoming data
    // read the incoming byte:
    command = Serial.read();
  }
  switch (command) //set different cases of the "command" variable
  {
    case 'X': { //S, X
        motor1.run(RELEASE); // stopped
        motor2.run(RELEASE); // stopped
        motor3.run(RELEASE); // stopped
        motor4.run(RELEASE); // stopped
        command = '*';
      } break;

    case 'W': { //go forward F, W, u
        motor1.run(FORWARD);
        motor2.run(RELEASE);
        motor3.run(FORWARD);
        motor4.run(RELEASE);
      } break;

    case 'S': { //go backward B, S, d
        motor1.run(BACKWARD);
        motor2.run(RELEASE);
        motor3.run(BACKWARD);
        motor4.run(RELEASE);
      } break;

    case 'D': { //right R, E, r
        motor1.run(RELEASE);
        motor2.run(FORWARD);
        motor3.run(RELEASE);
        motor4.run(FORWARD);
      } break;

    case 'A': { //left L, Q, l
        motor1.run(RELEASE);
        motor2.run(BACKWARD);
        motor3.run(RELEASE);
        motor4.run(BACKWARD);
      } break;

    case 'Q': { //forward left G, A
        motor1.run(RELEASE);
        motor2.run(BACKWARD);
        motor3.run(FORWARD);
        motor4.run(RELEASE);
      } break;

    case 'E': { //forward right I, D
        motor1.run(FORWARD);
        motor2.run(FORWARD);
        motor3.run(RELEASE);
        motor4.run(RELEASE);
      } break;

    case 'Z': { //90 left H, Z
        motor1.run(FORWARD);
        motor2.run(BACKWARD);
        motor3.run(BACKWARD);
        motor4.run(FORWARD);
      } break;

    case 'C': { //90 right J, C
        motor1.run(BACKWARD);
        motor2.run(FORWARD);
        motor3.run(FORWARD);
        motor4.run(BACKWARD);
      } break;

    case 'U': { //set lower speed
        motor1.setSpeed(225);
        motor2.setSpeed(225);
        motor3.setSpeed(225);
        motor4.setSpeed(225);
      } break;

    case 'u': { //set max speed
        motor1.setSpeed(325);
        motor2.setSpeed(325);
        motor3.setSpeed(325);
        motor4.setSpeed(325);
      } break;

  }
}
