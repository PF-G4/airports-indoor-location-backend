package afinal.proyecto.cuatro.grupo.services.impl;

import org.springframework.stereotype.Service;

import afinal.proyecto.cuatro.grupo.services.WayFindingService;
import afinal.proyecto.cuatro.grupo.services.util.ServiceUtil;
import afinal.proyecto.cuatro.grupo.entities.Edge;
import afinal.proyecto.cuatro.grupo.entities.Node;
import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

@Service
public class WayFindingServiceImpl extends ServiceUtil implements WayFindingService {
	
	@Override
	public void getDestination(String idBeacon,String destino) {
		 //initialize the graph base on the Romania map
        Node n1 = new Node("Arad",1);
        Node n2 = new Node("Zerind",1);
        Node n3 = new Node("Oradea",1);
        Node n4 = new Node("Sibiu",1);
        Node n5 = new Node("Fagaras",1);
        Node n6 = new Node("Rimnicu Vilcea",1);
        Node n7 = new Node("Pitesti",1);
        Node n8 = new Node("Timisoara",1);
        Node n9 = new Node("Lugoj",1);
        Node n10 = new Node("Mehadia",1);
        Node n11 = new Node("Drobeta",1);
        Node n12 = new Node("Craiova",1);
        Node n13 = new Node("Bucharest",1);
                Node n14 = new Node("Giurgiu",1);

        //initialize the edges
        //Path: [Arad, Sibiu, Rimnicu Vilcea, Pitesti, Bucharest]
        //Path: [Arad, Sibiu, Fagaras, Bucharest]
        //Arad
        n1.setAdjacencies((new Edge[]{
                new Edge(n2,1),
                new Edge(n3,3)
        		}));
       
        
         //Zerind
        n2.setAdjacencies((new Edge[]{
                new Edge(n1,1),
                new Edge(n4,1),
                new Edge(n5,3)
        }));
         

         //Oradea
        n3.setAdjacencies(new Edge[]{
                new Edge(n1,3),
                new Edge(n6,1)
        });
         
         //Sibiu
        n4.setAdjacencies(new Edge[]{
                new Edge(n2,1),
                new Edge(n6,1)
        });
         

         //Fagaras
        n5.setAdjacencies(new Edge[]{
                new Edge(n2,3),

                //178
                new Edge(n9,1)
        });
         
         //Rimnicu Vilcea
        n6.setAdjacencies(new Edge[]{
                new Edge(n3,1),
                new Edge(n4,1),
                new Edge(n7,1)
        });
         
         //Pitesti
        n7.setAdjacencies(new Edge[]{
                new Edge(n6,1),
                new Edge(n8,1)
        });
         
         //Timisoara
        n8.setAdjacencies(new Edge[]{
                new Edge(n7,1),
                new Edge(n9,1),
                new Edge(n10,1)
        });
         
         //Lugoj
        n9.setAdjacencies(new Edge[]{
                new Edge(n8,1),
                new Edge(n5,1)
        });

         //Mehadia
        n10.setAdjacencies(new Edge[]{
                new Edge(n12,1),
                new Edge(n11,1),
                new Edge(n8,1)
        });
         
         //Drobeta
        n11.setAdjacencies(new Edge[]{
                new Edge(n10,1),
                new Edge(n13,1)
        });

         //Craiova
        n12.setAdjacencies(new Edge[]{
                new Edge(n10,1),
                new Edge(n13,1)
        });

        //Bucharest
        n13.setAdjacencies(new Edge[]{
                new Edge(n11,1),
                new Edge(n12,1),
                new Edge(n14,1)
        });
         
         //Giurgiu
        n14.setAdjacencies(new Edge[]{
                new Edge(n13,1)
        });

        AstarSearch(n1,n13);

        List<Node> path = printPath(n13);

                System.out.println("Path: " + path);

	}
	
	public static List<Node> printPath(Node target){
        List<Node> path = new ArrayList<Node>();

	for(Node node = target; node!=null; node = node.getParent()){
	    path.add(node);
	}
	
	Collections.reverse(path);
	
	return path;
}
	
	public static void AstarSearch(Node source, Node goal){

        Set<Node> explored = new HashSet<Node>();

        PriorityQueue<Node> queue = new PriorityQueue<Node>(20, 
                new Comparator<Node>(){
                         //override compare method
         public int compare(Node i, Node j){
            if(i.getF_scores() > j.getF_scores()){
                return 1;
            }

            else if (i.getF_scores() < j.getF_scores()){
                return -1;
            }

            else{
                return 0;
            }
         }

                }
                );

        //cost from start
        source.setG_scores(0);

        queue.add(source);

        boolean found = false;

        while((!queue.isEmpty())&&(!found)){

                //the node in having the lowest f_score value
                Node current = queue.poll();

                explored.add(current);

                //goal found
                if(current.getValue().equals(goal.getValue())){
                        found = true;
                }

                //check every child of current node
                for(Edge e : current.getAdjacencies()){
                        Node child = e.getTarget();
                        double cost = e.getCost();
                        double temp_g_scores = current.getG_scores() + cost;
                        double temp_f_scores = temp_g_scores + child.getH_scores();


                        /*if child node has been evaluated and 
                        the newer f_score is higher, skip*/
                        
                        if((explored.contains(child)) && 
                                (temp_f_scores >= child.getF_scores())){
                                continue;
                        }

                        /*else if child node is not in queue or 
                        newer f_score is lower*/
                        
                        else if((!queue.contains(child)) || 
                                (temp_f_scores < child.getF_scores())){

                                child.setParent(current);
                                child.setG_scores(temp_g_scores);
                                child.setF_scores(temp_f_scores);

                                if(queue.contains(child)){
                                        queue.remove(child);
                                }

                                queue.add(child);

                        }

                }

        }

}

}

	
