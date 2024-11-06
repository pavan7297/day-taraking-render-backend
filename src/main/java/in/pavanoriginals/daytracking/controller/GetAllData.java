package in.pavanoriginals.daytracking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.pavanoriginals.daytracking.model.AddTask;
import in.pavanoriginals.daytracking.repo.AddTaskRepository;

@RestController
public class GetAllData {

	@Autowired
	private AddTaskRepository addTaskRepository;

	// Create a new task
	@PostMapping("/add")
	public AddTask createTask(@RequestBody AddTask addTask) {
		return addTaskRepository.save(addTask);
	}

	// Get all tasks
	@GetMapping("/all")
	public List<AddTask> getAllTasks() {
		return addTaskRepository.findAll();
	}

	// Get a task by ID
	@GetMapping("/{id}")
	public ResponseEntity<AddTask> getTaskById(@PathVariable Long id) {
		Optional<AddTask> task = addTaskRepository.findById(id);
		return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	// Update a task
	@PutMapping("/{id}")
	public ResponseEntity<AddTask> updateTask(@PathVariable Long id, @RequestBody AddTask taskDetails) {
		Optional<AddTask> optionalTask = addTaskRepository.findById(id);
		if (optionalTask.isPresent()) {
			AddTask task = optionalTask.get();
			task.setProjectName(taskDetails.getProjectName());
			task.setTaskTitle(taskDetails.getTaskTitle());
			task.setTaskDescription(taskDetails.getTaskDescription());
			task.setTaskAssign(taskDetails.getTaskAssign());
			task.setProjectClientName(taskDetails.getProjectClientName());
			return ResponseEntity.ok(addTaskRepository.save(task));
		}
		return ResponseEntity.notFound().build();
	}

	// Delete a task
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
		if (addTaskRepository.existsById(id)) {
			addTaskRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}
