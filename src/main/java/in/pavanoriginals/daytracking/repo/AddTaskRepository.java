package in.pavanoriginals.daytracking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pavanoriginals.daytracking.model.AddTask;

public interface AddTaskRepository extends JpaRepository<AddTask, Long> {

}