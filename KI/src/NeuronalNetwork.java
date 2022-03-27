import java.util.ArrayList;





public class NeuronalNetwork {
    private ArrayList<InputNeuron> inputNeurons=new ArrayList<>();
    private ArrayList<ArrayList<WorkingNeuron>>hiddenNeurons=new ArrayList<>();
    private ArrayList<WorkingNeuron>outputNeurons=new ArrayList<>();
    
    public void createInputNeurons(int n){
        for(int i=0;i<n;i++){
            inputNeurons.add(new InputNeuron());
        }
    }
    
    public void addHiddenNeuron(int n){
        ArrayList<WorkingNeuron>hidden=new ArrayList<>();
        hiddenNeurons.add(hidden);
        for(int i=0;i<n;i++){
            hidden.add(new WorkingNeuron());
        }
    }
    
    public void addOutputtNeurons(int n){
        for(int i=0;i<n;i++){
            outputNeurons.add(new WorkingNeuron());
        }
    }
    
    public ArrayList<WorkingNeuron> getOutputNeurons() {
        return outputNeurons;
    }
    
    public ArrayList<ArrayList<WorkingNeuron>> getHiddenNeurons() {
        return hiddenNeurons;
    }

    public void setHiddenNeurons(ArrayList<ArrayList<WorkingNeuron>> hiddenNeurons) {
        this.hiddenNeurons = hiddenNeurons;
    }

    public void setInputNeurons(ArrayList<InputNeuron> inputNeurons) {
        this.inputNeurons = inputNeurons;
    }

    public void setOutputNeurons(ArrayList<WorkingNeuron> outputNeurons) {
        this.outputNeurons = outputNeurons;
    }
    
    public void setInputValues(float... v){
        if(v.length!=inputNeurons.size()){
            throw new IndexOutOfBoundsException();
        }
        for(int i=0;i<inputNeurons.size();i++){
            inputNeurons.get(i).setValue(v[i]);
        }
    }
    
    public void setConnections (float ...weights) {
    	
        for(WorkingNeuron hidden : hiddenNeurons.get(0)) {
            for(InputNeuron in : inputNeurons) {
                    hidden.addInputConnection(new Connection(in, (float) Math.random()*2f-1f));
               
                }
            
        }
        
    	int index = 0;
    	
    	for(WorkingNeuron hidden : hiddenNeurons.get(0)) {
            for(InputNeuron in : inputNeurons) {
                hidden.addInputConnection(new Connection(in, (float) Math.random()));
            }
        }

        for(int i=0;i<hiddenNeurons.size()-1;i++){
            for(int j=0;j<hiddenNeurons.get(i).size();j++){
                for(int k=0;k<hiddenNeurons.get(i+1).size();k++){
                    hiddenNeurons.get(i+1).get(k).addInputConnection(new Connection(hiddenNeurons.get(i).get(j),(float) Math.random()));
                }
            }
        }

        for(WorkingNeuron out : outputNeurons) {
            for(WorkingNeuron hidden : hiddenNeurons.get(hiddenNeurons.size()-1)) {
                out.addInputConnection(new Connection(hidden, (float) Math.random()));
            }
        }
    }

}
