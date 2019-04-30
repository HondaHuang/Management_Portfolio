package com.hh.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "project")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	@Size(min=2,max=30)
	private String name;
	@Column
	@Size(min=2,max=30)
	private String type;
	@Column
	@Temporal(TemporalType.DATE)
	private Date start;
	@Column
	@Temporal(TemporalType.DATE)
	private Date end;
	@Column
	private int duration;
	@Column
	@Size(min=2,max=30)
	private String status;
	@Column
	@Size(min=2,max=30)
	private String methodology;
	@Column
	@Size(min=3,max=100)
	private String description;
	@Column
	@Size(min=2,max=30)
	private String tools;
	@Column
	@Size(min=2,max=30)
	private String pm;
	@Column
	@Size(min=2,max=30)
	private String dm;
	@Column
	@Size(min=2,max=30)
	private String client;
	@Column
	private double budget;
	@Column
	private double effort;
	@Column
	@ElementCollection(targetClass = Consultant.class)
	@OneToMany
	private List<Consultant> consultants;
	@Column
	@ElementCollection(targetClass = ClientPOC.class)
	@OneToMany
	private List<ClientPOC> clientPOCs;

	public Project() {
		// TODO Auto-generated constructor stub
	}

	public List<ClientPOC> getClientPOCs() {
		return clientPOCs;
	}

	public void setClientPOCs(List<ClientPOC> clientPOCs) {
		this.clientPOCs = clientPOCs;
	}

	public List<Consultant> getConsultants() {
		return consultants;
	}

	public void setConsultants(List<Consultant> consultants) {
		this.consultants = consultants;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMethodology() {
		return methodology;
	}

	public void setMethodology(String methodology) {
		this.methodology = methodology;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTools() {
		return tools;
	}

	public void setTools(String tools) {
		this.tools = tools;
	}

	public String getPm() {
		return pm;
	}

	public void setPm(String pm) {
		this.pm = pm;
	}

	public String getDm() {
		return dm;
	}

	public void setDm(String dm) {
		this.dm = dm;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public double getEffort() {
		return effort;
	}

	public void setEffort(double effort) {
		this.effort = effort;
	}

	public Project(String name, String type, Date start, Date end, int duration, String status, String methodology,
			String description, String tools, String pm, String dm, String client, double budget, double effort,
			List<Consultant> consultants, List<ClientPOC> clientPOCs) {
		super();
		this.name = name;
		this.type = type;
		this.start = start;
		this.end = end;
		this.duration = duration;
		this.status = status;
		this.methodology = methodology;
		this.description = description;
		this.tools = tools;
		this.pm = pm;
		this.dm = dm;
		this.client = client;
		this.budget = budget;
		this.effort = effort;
		this.consultants = consultants;
		this.clientPOCs = clientPOCs;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", type=" + type + ", start=" + start + ", end=" + end
				+ ", duration=" + duration + ", status=" + status + ", methodology=" + methodology + ", description="
				+ description + ", tools=" + tools + ", pm=" + pm + ", dm=" + dm + ", client=" + client + ", budget="
				+ budget + ", effort=" + effort + ", consultants=" + consultants + ", clientPOCs=" + clientPOCs + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(budget);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((clientPOCs == null) ? 0 : clientPOCs.hashCode());
		result = prime * result + ((consultants == null) ? 0 : consultants.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((dm == null) ? 0 : dm.hashCode());
		result = prime * result + duration;
		temp = Double.doubleToLongBits(effort);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((methodology == null) ? 0 : methodology.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pm == null) ? 0 : pm.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tools == null) ? 0 : tools.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (Double.doubleToLongBits(budget) != Double.doubleToLongBits(other.budget))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (clientPOCs == null) {
			if (other.clientPOCs != null)
				return false;
		} else if (!clientPOCs.equals(other.clientPOCs))
			return false;
		if (consultants == null) {
			if (other.consultants != null)
				return false;
		} else if (!consultants.equals(other.consultants))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (dm == null) {
			if (other.dm != null)
				return false;
		} else if (!dm.equals(other.dm))
			return false;
		if (duration != other.duration)
			return false;
		if (Double.doubleToLongBits(effort) != Double.doubleToLongBits(other.effort))
			return false;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (methodology == null) {
			if (other.methodology != null)
				return false;
		} else if (!methodology.equals(other.methodology))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pm == null) {
			if (other.pm != null)
				return false;
		} else if (!pm.equals(other.pm))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tools == null) {
			if (other.tools != null)
				return false;
		} else if (!tools.equals(other.tools))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
