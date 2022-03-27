

public class Starter {

	public static void main(String[] args) {
		NeuronalNetwork nw = new NeuronalNetwork();
		nw.createInputNeurons(10);
		nw.addHiddenNeuron(10);
		nw.addOutputtNeurons(1);
		
		nw.setInputValues(123,12,12,12,3,5,43,2,99,21.0f);
		nw.setConnections(213,32,12,4,1234,5,345,6,123,412.32f);
		System.out.println(nw.getOutputNeurons().get(0).getOutputValue());
	}

}
