import java.util.ArrayList;




public class WorkingNeuron implements Neuron {
	   private ArrayList<Connection>inputConnections=new ArrayList<>();
	   private ActivationFunktion activationFunktion=new Sigmoid();
	   private float value=0;
	   private boolean isvalueset;

	    public float getOutputValue() {
	            float sum = 0;
	            for (Connection c : inputConnections) {
	                sum += c.getOutputValue();
	            }
	            value= activationFunktion.activation(sum);
	            isvalueset=true;
	        return value;
	    }
	    
	    public void addInputConnection(Connection ic){
	        inputConnections.add(ic);
	    }
}
