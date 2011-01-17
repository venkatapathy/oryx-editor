package org.oryxeditor.server.diagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * @author Philipp
 * Abstract Shape class represents an element of the canvas
 * stencilset independent
 */
public class Shape implements Stencil, Bounded{
	private String resourceId;
	private HashMap<String,String> properties;
	private StencilType stencil;
	private ArrayList<Shape> childShapes;
	private ArrayList<Shape> outgoings;
	private ArrayList<Point> dockers;
	private ArrayList<String> glossaryIds;
	private Bounds bounds;
	private Shape target;
	private Shape parent;
	private ArrayList<Shape> incoming;

	/**
	 * @return the parent
	 */
	public Shape getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(Shape parent) {
		this.parent = parent;
	}
	/**Constructs a new shape with id and stencil
	 * @param resourceId unique shape id, generated by the editor
	 * @param stencil StencilType with stencilId
	 */
	public Shape(String resourceId, StencilType stencil) {
		this.resourceId = resourceId;
		this.stencil = stencil;
	}
	/** set a new id for the shape
	 * @param resourceId
	 */
	public Shape(String resourceId) {
		this.resourceId = resourceId;
	}
	/* Overwritten hash code method, based on resourceId
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return resourceId.hashCode();
	}
	/* Overwritten equals method, based on resourceId
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shape other = (Shape) obj;
		if (resourceId == null) {
			if (other.resourceId != null)
				return false;
		} else if (!resourceId.equals(other.resourceId))
			return false;
		return true;
	}
	/* returns the StencilId of a shape
	 * @see org.oryxeditor.server.diagram.Stencil#getStencilId()
	 * @return String stencilId or null if stencil undefined
	 */
	public String getStencilId() {
		if(this.stencil!=null){
			return this.stencil.getId();
		}
		return null;
	}
	/** returns the unique shape id, generated by the editor
	 * @return the resourceId
	 */
	public String getResourceId() {
		return resourceId;
	}
	/** set unique shape id, usually generated by the editor
	 * @param resourceId the resourceId to set
	 */
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	/** Gives the value of the property with the given name
	 * @param name name of the property
	 * @return value of the property or null if no mapping available for the name
	 */
	public String getProperty(String name){
		return this.getProperties().get(name);
	}
	/** return a HashMap with all properties, name as key, value as value
	 * @return the properties
	 */
	public HashMap<String, String> getProperties() {
		if(this.properties==null)
			this.properties=new HashMap<String, String>();
		return properties;
	}
	/** set a new property hash map
	 * @param properties the properties to set
	 */
	public void setProperties(HashMap<String, String> properties) {
		this.properties = properties;
	}
	/** changes an existing property with the same name, or adds a new one
	 * @param key  property name with which the specified value is to be associated
	 * @param value value to be associated with the specified property name
	 * @return the previous value associated with property name, or null if there was no mapping for property name. (A null return can also indicate that the map previously associated null with key.)
	 */
	public String putProperty(String key, String value) {
		return this.getProperties().put(key, value);
	}
	/** Gives the Stencil object of the shape
	 * @return the stencil associated with the shape
	 */
	public StencilType getStencil() {
		return stencil;
	}
	/** Set a new Stencil Object for the shape
	 * @param stencil the stencil to set
	 */
	public void setStencil(StencilType stencil) {
		this.stencil = stencil;
	}
	/**
	 * @return the childShapes
	 */
	public ArrayList<Shape> getChildShapes() {
		if(this.childShapes==null){
			this.childShapes=new ArrayList<Shape>();
		}
		return this.childShapes;
	}
	/**
	 * @param childShapes the childShapes to set
	 */
	public void setChildShapes(ArrayList<Shape> childShapes) {
		this.childShapes = childShapes;
	}
	/* (non-Javadoc)
	 * @see org.oryxeditor.server.diagram.Shape#getOutgoings()
	 */
	@Deprecated
	public ArrayList<Shape> getOutgoing() {
		return this.getOutgoings();
	}
	/* (non-Javadoc)
	 * @see org.oryxeditor.server.diagram.Shape#setOutgoings()
	 */
	@Deprecated
	public void setOutgoing(ArrayList<Shape> outgoing) {
		this.setOutgoings(outgoing);
	}
	/** Give an array of outgoing shapes
	 * @return the outgoing shape objects of the shape
	 */
	public ArrayList<Shape> getOutgoings() {
		if(this.outgoings==null)
			this.outgoings=new ArrayList<Shape>();
		return outgoings;
	}
	/** Set a new array of outgoing shapes
	 * @param outgoings the outgoing shapes to set
	 */
	public void setOutgoings(ArrayList<Shape> outgoings) {
		this.outgoings = outgoings;
	}
	/** Adds a new shape to the outgoings
	 * @param outgoing shape to append
	 * @return true if add was successful
	 */
	public boolean addOutgoing(Shape out) {
		return this.getOutgoings().add(out);
	}
	/** Gives the point list of dockers for a shape, dockers usually appears on edges
	 * @return the dockers, a list of points
	 */
	public List<Point> getDockers() {
		if(this.dockers==null)
			this.dockers=new ArrayList<Point>();
		return dockers;
	}
	/** set a ArrayList with all attached dockers for a shape, dockers usually appears on edges
	 * A docker is a point on the canvas
	 * @param dockers the list of points to set
	 */
	public void setDockers(List<Point> dockers) {
		this.dockers = new ArrayList<Point>(dockers);
	}
	/** Gives the target of shape, which defined another associated shape
	 * @return the target shape
	 */
	public Shape getTarget() {
		return target;
	}
	/** Set a new target shape for a shape
	 * @param target the target shape to set
	 */
	public void setTarget(Shape target) {
		this.target = target;
	}
	/**Returns the bounds of a shape.
	 * Bounds defined the space a shape spans over the canvas
	 * @return the bounds object of a shape
	 */
	public Bounds getBounds() {
		return bounds;
	}
	/**Set a new bounds for a shape
	 * @param bounds the bounds to set
	 */
	public void setBounds(Bounds bounds) {
		this.bounds = bounds;
	}

	/* (non-Javadoc)
	 * @see org.oryxeditor.server.diagram.Bounded#getUpperLeft()
	 */
	public Point getUpperLeft() {
		if(this.bounds!=null)
			 return this.bounds.getUpperLeft();
		return null;
	}
	/* (non-Javadoc)
	 * @see org.oryxeditor.server.diagram.Bounded#getLowerRight()
	 */
	public Point getLowerRight() {
		if(this.bounds!=null)
			 return this.bounds.getLowerRight();
		return null;
	}
	
	/**
	 * @return the glossaryIds
	 */
	public ArrayList<String> getGlossaryIds() {
		if(this.glossaryIds==null)
			this.glossaryIds=new ArrayList<String>();
		return glossaryIds;
	}
	/**
	 * @param glossaryIds the glossaryIds to set
	 */
	public void setGlossaryIds(ArrayList<String> glossaryIds) {
		this.glossaryIds = glossaryIds;
	}
	public boolean addGlossaryIds(String id) {
		return this.getGlossaryIds().add(id);
	}
	
	public boolean addIncoming(Shape current) {
		return this.getIncomings().add(current);
		
	}
	public ArrayList<Shape> getIncomings() {
		if(this.incoming==null)
			this.incoming=new ArrayList<Shape>();
		return this.incoming;
	}
	public void setIncomings(ArrayList<Shape> cur){
		this.incoming=cur;
	}
	
	/* (non-Javadoc)
	 * @see org.oryxeditor.server.diagram.Bounded#height()
	 */
	public double getHeight() {
		return this.getLowerRight().getY() - this.getUpperLeft().getY();
	}
	
	/* (non-Javadoc)
	 * @see org.oryxeditor.server.diagram.Bounded#width()
	 */
	public double getWidth() {
		return this.getLowerRight().getX() - this.getUpperLeft().getX();
	}

}
