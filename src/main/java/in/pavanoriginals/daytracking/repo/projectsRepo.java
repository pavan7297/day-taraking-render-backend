package in.pavanoriginals.daytracking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pavanoriginals.daytracking.model.AddTask;
import in.pavanoriginals.daytracking.model.projects;

public interface projectsRepo extends JpaRepository<projects, Long> {

}
