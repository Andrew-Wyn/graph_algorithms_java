package bfs;

import java.util.*;

/**
* Defines basic interface for a node of a graph
*
* @param <ENTITY>
*/
public interface GraphNodeIface<ENTITY, NODE extends GraphNodeIface> {

    /**
    * @return the id
    */
    public int getId();

    /**
    * @return the successors
    */
    public List<NODE> getSuccessors();

    public void setSuccessors(List<NODE> successors);

    /**
    * @return the value
    */
    public ENTITY getValue();

    /**
    * @param value the value to set
    */
    public void setValue(ENTITY value);


    public void setState(State state);

    public State getState();

    public void setD(int initTimer);

    public int getD();

    public void setPi(NODE pi);

    public NODE getPi();
}