
public class Cowrie {
	AdjGraph adj = new AdjGraph(true);
	int edges = 0; //the number of roads on the graph
	int farms = 0; //the number of farms on the graph
	
	int mini = 0; //this will change to the smallest number which will then be multiplied by -1 to give the answer
	
	int[][] weights = new int[farms][farms]; //holds the information about the weights between vertices, if not edge between then infinity
	
	//initializes the farms and roads
	void createFarmsAndRoads(int farms, int roads){
		this.farms = farms;
		this.edges = roads;
		this.weights = new int[farms][farms];
		
		
		for(int i = 0; i< farms; i++){
			adj.addVertex("" + i); //converts the int into a string to store as the name of the vertex for each farm
		}
	}
	
	//adds roads(edges) to the cow path as a negative distance
	void addRoad(int farmA, int farmB, int distance, String direction){
		adj.setEdge(farmA, farmB, distance);
		weights[farmA-1][farmB-1] = -distance;
	}
	
	//finds all the shortest paths between vertices
	void findAllShortestPaths(){
		for (int i = 0; i< farms; i++){
			for (int j = 0; j< farms; j++){
				if(i==j){
					weights[i][j] = 0;
					}
				else if(adj.adjList.get(i).contains(j)){
					weights[i][j] = weights[i][j];
				}
				else{
					weights[i][j] = 99;
				}
			}
		}
			for (int k=0; k< farms; k++){
				for (int i=0; i< farms; i++){
					for (int j=0; j< farms; j++){
						if (weights[i][j] > weights[i][k] + weights[k][j]){
							weights[i][j] = weights[i][k] + weights[k][j];
						}
					}
				}
			}
		}
	
	//finds the smallest numbers among the shortest paths among vertices
	void findMin(){
		for(int i = 0; i< farms; i++){
			for (int j = 0; j<farms; j++){
				this.mini = Math.min(mini, weights[i][j]);
			}
		}
	}
	
	//function used to display the weights array
	void displayWeights(){
		for (int i = 0; i<farms; i++){
			System.out.println("");
			for (int a = 0; a<farms; a++){
				System.out.print(weights[i][a] + " ");
			}
		}
		System.out.println("");
	}

	
	public static void main(String[] args){
		Cowrie cow = new Cowrie();
		cow.createFarmsAndRoads(7,6);
		cow.addRoad(1, 6, 13, "E");
		cow.addRoad(6, 3, 9, "E");
		cow.addRoad(3, 5, 7, "S");
		cow.addRoad(4, 1, 3, "N");
		cow.addRoad(2, 4, 20, "W");
		cow.addRoad(4, 7, 2, "S");
		
		cow.findAllShortestPaths();
		
		cow.findMin();
		
		System.out.println(cow.mini * -1);
	}
}
