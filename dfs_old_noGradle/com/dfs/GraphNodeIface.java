package com.dfs;

import java.util.*;

/**
* Defines basic interface for a node of a graph
*
* @param <ENTITY>
*/
public interface GraphNodeIface<ENTITY> {

    /**
    * @return the id
    */
    public int getId();

    /**
    * @return the successors
    */
    public List<GraphNodeIface> getSuccessors();

    public void setSuccessors(List<GraphNodeIface> successors);

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

    public void setInitTimer(int initTimer);

    public int getInitTimer();

    public void setEndTimer(int endTimer);

    public int getEndTimer();
}