package in.pavanoriginals.daytracking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "add_task")
@Data
public class AddTask {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "project_name")
	private String projectName;

	@Column(name = "task_title")
	private String taskTitle;

	@Column(name = "task_description")
	private String taskDescription;

	@Column(name = "task_assign")
	private String taskAssign;

	@Column(name = "project_client_name")
	private String projectClientName;

}
