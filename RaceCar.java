import java.util.Scanner;

/**
* RaceCar class should have the following attributes & methods
*
* Old Attributes:
*   color (String), maxSpeed (int), acceleration (int), tyreFriction (int), isEngineStarted (boolean), currentSpeed (int)
* New Attributes:
*     nitro (int)
*
* Old Methods:
*   startEngine, stopEngine, accelerate, applyBrakes, soundHorn
* 
* Override Methods:
*   soundHorn:
*       - Print "Peep Peep\nBeep Beep" if raceCar engine is on
*       - Print "Car has not started yet" if raceCar engine is off
*   accelerate:
*       - When car accelerates
*           if nitro points are available, the currentSpeed will increase by 20 within max limits
*           and the nitro will get reduced by 1
*           Note: When we accelerate, the currentSpeed should increase based on the nitro and 
*                  the acceleration value provided (currentSpeed = currentSpeed + nitroSpeed + acceleration)
*
* When a new RaceCar is created, the engine should be off by default and currentSpeed should be 0


* Implement the Car and RaceCar class appropriately
* Inherit the Car class into RaceCar class and override the methods which have extra features
*/

class Car {
    String color;
    int maxSpeed;
    int acceleration;
    int tyreFriction;
    int currentSpeed;
    boolean isEngineStarted;
    
    Car(String carColor, int carMaxSpeed, int carAcceleration, int carTyreFriction){
        color = carColor;
        maxSpeed = carMaxSpeed;
        acceleration = carAcceleration;
        tyreFriction = carTyreFriction;
        isEngineStarted = false;
        currentSpeed = 0;
    }
    
    void startEngine() {
       isEngineStarted = true;
    }
    
    void stopEngine() {
       isEngineStarted = false;
    }
    
    void accelerate() {
       if (!(isEngineStarted)) {
           System.out.println("Car has not started yet");
       } else {
           currentSpeed += acceleration;
           if (currentSpeed > maxSpeed) {
               currentSpeed = maxSpeed;
           }
       }
    }
    
    void soundHorn() {
       if (!(isEngineStarted)) {
           System.out.println("Beep Beep");
       } else {
           System.out.println("Car has not started yet");
       }
    }
    
    void applyBrakes() {
       currentSpeed -= tyreFriction;
       if (currentSpeed < 0) {
           currentSpeed = 0;
       }
    }
}

class RaceCar extends Car {    
    int nitro;
    
    RaceCar(String carColor, int carMaxSpeed, int carAcceleration, int carTyrefriction, int carNitro) {
        super(carColor, carMaxSpeed, carAcceleration, carTyrefriction);
        nitro = carNitro;
    }
    
    void accelerate(){
      if (nitro > 0 && isEngineStarted == true) {
          currentSpeed += 20;
          nitro -= 1;
          super.accelerate();
      }
    }
    
    void soundHorn() {
       if (isEngineStarted) {
           System.out.println("Peep Peep\nBeep Beep");
       } else {
           System.out.println("Car has not started yet");
       }
    }
}

class Base {
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        RaceCar raceCar = new RaceCar(input.next(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt());
        raceCar.startEngine();
        raceCar.accelerate(); // Calling the accelerate method when the isEngineStarted is True
        System.out.println(raceCar.currentSpeed); // 0 + (50 + 20) => 70
        System.out.println(raceCar.nitro); // 4 - 1 => 3
        raceCar.accelerate(); // 70 + (50 + 20) => 140
        System.out.println(raceCar.currentSpeed); // 140
        System.out.println(raceCar.nitro); // 3 - 1 => 2
        raceCar.accelerate(); // 140 + (50 + 20) => 210
        System.out.println(raceCar.currentSpeed); // 210
        System.out.println(raceCar.nitro); // 2 - 1 => 1
        raceCar.applyBrakes(); // 210 - 30 => 180
        System.out.println(raceCar.currentSpeed); // 180
        System.out.println(raceCar.nitro); // 1
        raceCar.accelerate(); // 180 + (50 + 20) => 250
        System.out.println(raceCar.currentSpeed); // 250
        System.out.println(raceCar.nitro); // 1 - 1 => 0
        raceCar.soundHorn();
    }
}