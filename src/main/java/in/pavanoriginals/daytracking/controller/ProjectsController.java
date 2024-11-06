package in.pavanoriginals.daytracking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.pavanoriginals.daytracking.model.projects;
import in.pavanoriginals.daytracking.repo.projectsRepo;
import in.pavanoriginals.daytracking.model.projects;

@RestController
@CrossOrigin
public class ProjectsController {

	@Autowired
	private projectsRepo projectsRepository;

	// Create a new task
	@PostMapping("/add")
	public projects createTask(@RequestBody projects projects) {
		return projectsRepository.save(projects);
	}

	// Get all tasks
	@GetMapping("/all")
	public List<projects> getAllTasks() {
		return projectsRepository.findAll();
	}

	// Get a task by ID
	@GetMapping("/{id}")
	public ResponseEntity<projects> getTaskById(@PathVariable Long id) {
		Optional<projects> task = projectsRepository.findById(id);
		return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	// Update a task
	@PutMapping("/{id}")
	public ResponseEntity<projects> updateTask(@PathVariable Long id, @RequestBody projects taskDetails) {
		Optional<projects> optionalTask = projectsRepository.findById(id);
		if (optionalTask.isPresent()) {
			projects task = optionalTask.get();
			task.setProjectName(taskDetails.getProjectName());
			task.setProjectStatus(taskDetails.getProjectStatus());
			return ResponseEntity.ok(projectsRepository.save(task));
		}
		return ResponseEntity.notFound().build();
	}

	// Delete a task
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
		if (projectsRepository.existsById(id)) {
			projectsRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}
