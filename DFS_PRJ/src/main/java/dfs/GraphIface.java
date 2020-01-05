package dfs;

import java.util.*;

/**
 * Defines basic interface for a generic graph
 *
 * @author Pavel Micka
 */
public interface GraphIface<ENTITY> {

    /**
     * Add an edge to a graph
     *
     * @param from source node
     * @param to target node
     */
    public void addEdge(int from, int to);

    /**
     * Get number of edges in the graph 
     *
     * @return number of edges in the graph
     */
    public int getEdgeCount();

    /**
     * Return vertex (node) with the given identifier
     *
     * @param id
     * @return
     */
    public GraphNodeIface getNode(int id);

    /**
     * Return total number of nodes (vertices)
     *
     * @return total number of nodes (vertices)
     */
    public int getVertexCount();

    /**
     * Remove the edge
     *
     * @param from source node
     * @param to target node
     */
    public void removeEdge(int from, int to);

}
