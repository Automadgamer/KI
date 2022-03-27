

public class Sigmoid implements  ActivationFunktion{
//Sigmoid ist eine funktion
    public float activation(float value) {
        return (float)(1f / (1f +  Math.pow(Math.E, -value)));
    }
// derivative ist die ableitung von Sigmoid
    public float derivative(float value) {
        float sigmoid =  activation(value);
        return sigmoid*(1-sigmoid);
    }
}