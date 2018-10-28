package afinal.proyecto.cuatro.grupo.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import afinal.proyecto.cuatro.grupo.dao.DaoEdge;
import afinal.proyecto.cuatro.grupo.dao.DaoNode;
import afinal.proyecto.cuatro.grupo.entities.Edge;
import afinal.proyecto.cuatro.grupo.entities.Grafo;
import afinal.proyecto.cuatro.grupo.entities.Node;
import afinal.proyecto.cuatro.grupo.services.WayFindingService;

@Service
public class WayFindingServiceImpl implements WayFindingService {

    @Autowired
    private DaoEdge daoEdge;

    @Autowired
    private DaoNode daoNode;

    public Iterable<Node> findAllNodes() {
        return daoNode.findAll();
    }

    public Iterable<Edge> findAllEdges() {
        return daoEdge.findAll();
    }

    @Override
    public List<Node> getDestination(double pos_orig_x, double pos_orig_y, double pos_dest_x, double pos_dest_y) {

        Grafo g1 = new Grafo();

        Iterable<Edge> listaEdges = findAllEdges();

        Iterable<Node> listaNodes = findAllNodes();

        g1.setNodesGrafo(listaNodes);

        for (Edge edge : listaEdges) {
            edge.setOrigin(g1.getNodeByValue(edge.getOrigin_value()));
            edge.setTarget(g1.getNodeByValue(edge.getTarget_value()));
        }

        g1.setEdgesGrafo(listaEdges);

        for (Node elemNode : listaNodes) {

            String val = elemNode.getValue();

            List<Edge> nodeEdges = new ArrayList<>();
            for (Edge elemEdge : listaEdges) {

                if (elemEdge.getOrigin_value().equals(val)) {
                    nodeEdges.add(elemEdge);
                }
            }

            Edge[] edgesArr = new Edge[nodeEdges.size()];
            edgesArr = nodeEdges.toArray(edgesArr);
            elemNode.setAdjacencies(edgesArr);
        }

        AstarSearch(g1.getNodeByPosition(pos_orig_x, pos_orig_y), g1.getNodeByPosition(pos_dest_x, pos_dest_y));

        List<Node> path = printPath(g1.getNodeByPosition(pos_dest_x, pos_dest_y));

        return path;
    }

    public static List<Node> printPath(Node target) {

        List<Node> path = new ArrayList<>();

        for (Node node = target; node != null; node = node.getParent()) {
            path.add(node);
        }

        Collections.reverse(path);
        return path;
    }


    public static void AstarSearch(Node source, Node goal) {

        Set<Node> explored = new HashSet<>();

        // Override compare method
        PriorityQueue<Node> queue = new PriorityQueue<>(
                20,
                (i, j) -> {
                    if (i.getF_scores() > j.getF_scores()) {
                        return 1;
                    } else if (i.getF_scores() < j.getF_scores()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
        );

        // Cost from start
        source.setG_scores(0);

        queue.add(source);

        boolean found = false;

        while ((!queue.isEmpty()) && (!found)) {

            //the node in having the lowest f_score value
            Node current = queue.poll();

            explored.add(current);

            //goal found
            if (current.getValue().equals(goal.getValue())) {
                found = true;
            }

            //check every child of current node
            for (Edge e : current.getAdjacencies()) {
                Node child = e.getTarget();
                double cost = e.getCost();
                double temp_g_scores = current.getG_scores() + cost;
                double temp_f_scores = temp_g_scores + child.getH_scores();

                /*if child node has been evaluated and the newer f_score is higher, skip*/
                if ((explored.contains(child)) && (temp_f_scores >= child.getF_scores())) {
                }

                /*else if child node is not in queue or newer f_score is lower*/
                else if ((!queue.contains(child)) || (temp_f_scores < child.getF_scores())) {

                    child.setParent(current);
                    child.setG_scores(temp_g_scores);
                    child.setF_scores(temp_f_scores);

                    if (queue.contains(child)) {
                        queue.remove(child);
                    }
                    queue.add(child);
                }
            }
        }
    }
}