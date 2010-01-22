package de.hpi.bpmn2xpdl;

import org.json.JSONObject;
import org.xmappr.Attribute;
import org.xmappr.RootElement;

@RootElement("MultiInstance")
public class XPDLMultiInstance extends XMLConvertable {
	
	@Attribute("MI_Condition")
	protected String mi_condition;
	@Attribute("LoopCounter")
	protected String loopCounter;
	@Attribute("MI_Ordering")
	protected String mi_ordering;
	@Attribute("MI_FlowCondition")
	protected String mi_flowCondition;
	@Attribute("ComplexMI_FlowCondition")
	protected String complexMi_flowCondition;
	
	public String getMi_condition() {
		return mi_condition;
	}
	
	public String getLoopCounter() {
		return loopCounter;
	}
	
	public String getMi_ordering() {
		return mi_ordering;
	}
	
	public String getMi_flowCondition() {
		return mi_flowCondition;
	}
	
	public String getComplexMi_flowCondition() {
		return complexMi_flowCondition;
	}
	
	public void readJSONcomplex_micondition(JSONObject modelElement) {
		setComplexMi_flowCondition(modelElement.optString("complex_micondition"));
	}
	
	public void readJSONloopcounter(JSONObject modelElement) {
		setLoopCounter(modelElement.optString("loopcounter"));
	}
	
	public void readJSONmi_condition(JSONObject modelElement) {
		setMi_condition(modelElement.optString("mi_condition"));
	}
	
	public void readJSONmi_flowcondition(JSONObject modelElement) {
		setMi_flowCondition(modelElement.optString("mi_flowcondition"));
	}
	
	public void readJSONmi_ordering(JSONObject modelElement) {
		setMi_ordering(modelElement.optString("mi_ordering"));
	}
	
	public void setMi_condition(String miCondition) {
		mi_condition = miCondition;
	}
	
	public void setLoopCounter(String loopCounter) {
		this.loopCounter = loopCounter;
	}
	
	public void setMi_ordering(String miOrdering) {
		mi_ordering = miOrdering;
	}
	
	public void setMi_flowCondition(String miFlowCondition) {
		mi_flowCondition = miFlowCondition;
	}
	
	public void setComplexMi_flowCondition(String complexMiFlowCondition) {
		complexMi_flowCondition = complexMiFlowCondition;
	}
}
