package de.hpi.bpmn2xpdl;

import java.util.Arrays;

import org.json.JSONException;
import org.json.JSONObject;
import org.xmappr.Attribute;
import org.xmappr.RootElement;

@RootElement("Association")
public class XPDLAssociation extends XPDLThingConnectorGraphics {

	@Attribute("Direction")
	protected String direction;
	@Attribute("Source")
	protected String source;
	@Attribute("Target")
	protected String target;
	
	public static boolean handlesStencil(String stencil) {
		String[] types = {
			"Association_Undirected",
			"Association_Unidirectional",
			"Association_Bidirectional"};
		return Arrays.asList(types).contains(stencil);
	}
	
	public String getDirection() {
		return direction;
	}
	
	public String getSource() {
		return source;
	}
	
	public String getTarget() {
		return target;
	}
	
	public void readJSONdirection(JSONObject modelElement) {
		setDirection(modelElement.optString("direction"));
	}
	
	public void readJSONsource(JSONObject modelElement) {
		setSource(modelElement.optString("source"));	
	}
	
	public void readJSONtarget(JSONObject modelElement) throws JSONException {
		JSONObject target = modelElement.getJSONObject("target");
		setTarget(target.optString("resourceId"));
	}
	
	public void setDirection(String directionValue) {
		direction = directionValue;
	}
	
	public void setSource(String sourceValue) {
		source = sourceValue;
	}
	
	public void setTarget(String targetValue) {
		target = targetValue;
	}
}
