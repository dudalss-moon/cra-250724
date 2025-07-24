package mission2;

import mission2.parts.Brake;
import mission2.parts.Engine;
import mission2.parts.Steering;

public class Car {
    private CarType carType;
    private Engine engine;
    private Brake brake;
    private Steering steering;


    public boolean isEngineBroken() {
        return engine == Engine.BROKEN;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setBrake(Brake brake) {
        this.brake = brake;
    }

    public void setSteering(Steering steering) {
        this.steering = steering;
    }

    public CarType getCarType() {
        return carType;
    }

    public Engine getEngine() {
        return engine;
    }

    public Brake getBrake() {
        return brake;
    }

    public Steering getSteering() {
        return steering;
    }
}
